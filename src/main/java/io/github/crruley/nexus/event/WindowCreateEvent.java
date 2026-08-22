package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;
import io.github.crruley.nexus.core.Window;

/**
 * Notifies subscribers when a {@link Window} is created.
 *
 * @author Christopher Ruley
 */
public class WindowCreateEvent extends Event {

    private final Window window;

    /**
     * Constructs a {@code WindowCreateEvent}.
     *
     * @param window the {@link Window} this {@code WindowCreateEvent} is derived from.
     */
    public WindowCreateEvent(Window window) {
        this.window = window;
    }

    /**
     * Gets the {@link Window} this {@code WindowCreateEvent} is derived from.
     *
     * @return the {@code Window} this {@code WindowCreateEvent} is derived from.
     */
    public Window getWindow() {
        return window;
    }

}