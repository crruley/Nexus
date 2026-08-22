package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;
import io.github.crruley.nexus.core.Window;

/**
 * Notifies subscribers when a {@link Window} is maximized or restored.
 *
 * @author Christopher Ruley
 */
public class WindowMaximizeEvent extends Event {

    private final Window window;
    private final boolean maximized;

    /**
     * Constructs a {@code WindowMaximizeEvent}.
     *
     * @param window    the {@link Window} this {@code WindowMaximizeEvent} is derived from.
     * @param maximized whether the {@code Window} was maximized or restored.
     */
    public WindowMaximizeEvent(Window window, boolean maximized) {
        this.window = window;
        this.maximized = maximized;
    }

    /**
     * Gets the {@link Window} this {@code WindowMaximizeEvent} is derived from.
     *
     * @return the {@code Window} this {@code WindowMaximizeEvent} is derived from.
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Whether the {@link Window} was maximized or restored.
     *
     * @return whether the {@code Window} was maximized or restored.
     */
    public boolean isMaximized() {
        return maximized;
    }

}