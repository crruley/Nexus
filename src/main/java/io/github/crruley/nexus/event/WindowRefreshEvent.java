package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;
import io.github.crruley.nexus.core.Window;

/**
 * Notifies subscribers when a {@link Window} refreshes.
 *
 * @author Christopher Ruley
 */
public class WindowRefreshEvent extends Event {

    private final Window window;

    /**
     * Constructs a {@code WindowRefreshEvent}.
     *
     * @param window the {@link Window} this {@code WindowRefreshEvent} is derived from.
     */
    public WindowRefreshEvent(Window window) {
        this.window = window;
    }

    /**
     * Gets the {@link Window} this {@code WindowRefreshEvent} is derived from.
     *
     * @return the {@code Window} this {@code WindowRefreshEvent} is derived from.
     */
    public Window getWindow() {
        return window;
    }

}