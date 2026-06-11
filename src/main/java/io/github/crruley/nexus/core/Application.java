package io.github.crruley.nexus.core;

import io.github.crruley.nexus.event.SettingsChangeHeightEvent;
import io.github.crruley.nexus.event.SettingsChangeTitleEvent;
import io.github.crruley.nexus.event.SettingsChangeVSyncEvent;
import io.github.crruley.nexus.event.SettingsChangeWidthEvent;
import io.github.crruley.nexus.event.WindowCloseEvent;
import io.github.crruley.nexus.event.WindowMinimizeEvent;
import io.github.crruley.nexus.event.WindowResizeEvent;
import io.github.crruley.signal.core.Bus;
import io.github.crruley.signal.core.Subscribe;

import static io.github.crruley.nexus.utility.Time.getCurrentTimeSeconds;
import static io.github.crruley.nexus.utility.Time.sync;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glViewport;

/**
 * @author Christopher Ruley
 */
public abstract class Application {

    /**
     * The main {@code Bus} for the {@code Application}.
     */
    protected final Bus bus;

    /**
     * The {@code Settings} for the {@code Application}.
     */
    protected final Settings settings;

    /**
     * The main {@code Window} for the {@code Application}.
     */
    protected final Window window;

    /**
     * Whether the {@code Application} is running.
     */
    private boolean running;

    /**
     * Whether the {@code Application} is minimized.
     */
    private boolean minimized;

    /**
     * The updates-per-second.
     */
    private int ups;

    /**
     * The frames-per-second.
     */
    private int fps;

    /**
     * Constructs an {@code Application}.
     */
    protected Application() {
        bus = new Bus();
        settings = new Settings(bus);
        window = new Window(bus, settings.getTitle(), settings.getWidth(), settings.getHeight());
    }

    public final Settings getSettings() {
        return settings;
    }

    public final Bus getBus() {
        return bus;
    }

    public final Window getWindow() {
        return window;
    }

    public final boolean isRunning() {
        return running;
    }

    public final boolean isMinimized() {
        return minimized;
    }

    public final int getUPS() {
        return ups;
    }

    public final int getFPS() {
        return fps;
    }

    /**
     * The user-implemented method for the creation stage.
     */
    protected abstract void onCreate();

    /**
     * The user-implemented method for the updating stage.
     */
    protected abstract void onUpdate();

    /**
     * The user-implemented method for the rendering stage.
     *
     * @param interpolation the value used for rendering according to updates.
     */
    protected abstract void onRender(double interpolation);

    /**
     * The user-implemented method for the destruction stage.
     */
    protected abstract void onDestroy();

    /**
     * Starts the {@code Application}.
     */
    public final void start() {
        if (running) {
            return;
        }

        running = true;

        run();
    }

    /**
     * Stops the {@code Application}.
     */
    public final void stop() {
        running = false;
    }

    /**
     * Runs the {@code Application}.
     */
    private void run() {
        try {
            bus.register(this);

            if (!glfwInit()) {
                throw new IllegalStateException("Failed to initialize GLFW!");
            }

            window.create();

            if (!window.isCreated()) {
                throw new IllegalStateException("Failed to create the window!");
            }

            window.setContextCurrent(true);
            onCreate();

            if (!window.isVisible()) {
                window.setVisible(true);
            }

            final double maxFrameTime = 0.25D;
            double previousTime = getCurrentTimeSeconds();
            double accumulator = 0.0D;
            double counter = 0.0D;
            int upsCounter = 0;
            int fpsCounter = 0;

            while (running) {
                glfwPollEvents();

                double updateInterval = 1.0D / settings.getTargetUPS();
                double currentTime = getCurrentTimeSeconds();
                double elapsedTime = currentTime - previousTime;

                if (elapsedTime > maxFrameTime) {
                    elapsedTime = maxFrameTime;
                }

                previousTime = currentTime;
                accumulator += elapsedTime;
                counter += elapsedTime;

                while (accumulator >= updateInterval) {
                    onUpdate();

                    upsCounter++;
                    accumulator -= updateInterval;
                }

                if (counter >= 1.0) {
                    ups = upsCounter;
                    fps = fpsCounter;
                    upsCounter = 0;
                    fpsCounter = 0;
                    counter = 0;
                }
                if (!minimized) {
                    onRender(accumulator / updateInterval);
                    window.swapBuffers();

                    fpsCounter++;
                }

                if (!settings.getVSync()) {
                    sync(settings.getTargetFPS());
                }
            }
        } finally {
            onDestroy();
            window.destroy();
            glfwTerminate();
            bus.unregister(this);
        }
    }

    /**
     * Listens for a {@code SettingsChangeTitleEvent} and updates the {@code Window}.
     *
     * @param event the event listed for.
     */
    @Subscribe
    private void onEvent(SettingsChangeTitleEvent event) {
        window.setTitle(event.getTitle());
    }

    /**
     * Listens for a {@code SettingsChangeWidthEvent} and updates the {@code Window}.
     *
     * @param event the event listed for.
     */
    @Subscribe
    private void onEvent(SettingsChangeWidthEvent event) {
        window.setWidth(event.getWidth());
    }

    /**
     * Listens for a {@code SettingsChangeHeightEvent} and updates the {@code Window}.
     *
     * @param event the event listed for.
     */
    @Subscribe
    private void onEvent(SettingsChangeHeightEvent event) {
        window.setHeight(event.getHeight());
    }

    /**
     * Listens for a {@code SettingsChangeVSyncEvent} and updates the {@code Application} vertical synchronization
     * state.
     *
     * @param event the event listed for.
     */
    @Subscribe
    private void onEvent(SettingsChangeVSyncEvent event) {
        glfwSwapInterval(event.getVSync() ? 1 : 0);
    }

    /**
     * Listens for a {@code WindowResizeEvent} and updates the {@code Application} resized state.
     *
     * @param event the event listed for.
     */
    @Subscribe
    private void onEvent(WindowResizeEvent event) {
        glViewport(0, 0, window.getWidth(), window.getHeight());
    }

    /**
     * Listens for a {@code WindowMinimizeEvent} and updates the {@code Application} minimized state.
     *
     * @param event the event listed for.
     */
    @Subscribe
    private void onEvent(WindowMinimizeEvent event) {
        minimized = event.isMinimized();
    }

    /**
     * Listens for a {@code WindowCloseEvent} and updates the {@code Application} running state.
     *
     * @param event the event listed for.
     */
    @Subscribe
    private void onEvent(WindowCloseEvent event) {
        running = false;
    }

}