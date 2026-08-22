package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;
import io.github.crruley.nexus.core.Window;

/**
 * Notifies subscribers when a {@link Window} is closed.
 *
 * @author Christopher Ruley
 */
public class WindowCloseEvent extends Event {

    private final Window window;

    /**
     * Constructs a {@code WindowCloseEvent}.
     *
     * @param window the {@link Window} this {@code WindowCloseEvent} is derived from.
     */
    public WindowCloseEvent(Window window) {
        this.window = window;
    }

    /**
     * Gets the {@link Window} this {@code WindowCloseEvent} is derived from.
     *
     * @return the {@code Window} this {@code WindowCloseEvent} is derived from.
     */
    public Window getWindow() {
        return window;
    }

}