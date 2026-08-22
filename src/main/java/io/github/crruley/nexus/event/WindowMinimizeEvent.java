package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;
import io.github.crruley.nexus.core.Window;

/**
 * Notifies subscribers when a {@link Window} is minimized or restored.
 *
 * @author Christopher Ruley
 */
public class WindowMinimizeEvent extends Event {

    private final Window window;
    private final boolean minimized;

    /**
     * Constructs a {@code WindowMinimizeEvent}.
     *
     * @param window    the {@link Window} this {@code WindowMinimizeEvent} is derived from.
     * @param minimized whether the {@code Window} was minimized or restored.
     */
    public WindowMinimizeEvent(Window window, boolean minimized) {
        this.window = window;
        this.minimized = minimized;
    }

    /**
     * Gets the {@link Window} this {@code WindowMinimizeEvent} is derived from.
     *
     * @return the {@code Window} this {@code WindowMinimizeEvent} is derived from.
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Whether the {@link Window} was minimized or restored.
     *
     * @return whether the {@code Window} was minimized or restored.
     */
    public boolean isMinimized() {
        return minimized;
    }

}