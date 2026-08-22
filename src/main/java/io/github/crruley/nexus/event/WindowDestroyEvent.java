package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;
import io.github.crruley.nexus.core.Window;

/**
 * Notifies subscribers when a {@link Window} is destroyed.
 *
 * @author Christopher Ruley
 */
public class WindowDestroyEvent extends Event {

    private final Window window;

    /**
     * Constructs a {@code WindowDestroyEvent}.
     *
     * @param window the {@link Window} this {@code WindowDestroyEvent} is derived from.
     */
    public WindowDestroyEvent(Window window) {
        this.window = window;
    }

    /**
     * Gets the {@link Window} this {@code WindowDestroyEvent} is derived from.
     *
     * @return the {@code Window} this {@code WindowDestroyEvent} is derived from.
     */
    public Window getWindow() {
        return window;
    }

}