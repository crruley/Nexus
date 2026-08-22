package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;
import io.github.crruley.nexus.core.Window;

/**
 * Notifies subscribers when a {@link Window} gains or loses focus.
 *
 * @author Christopher Ruley
 */
public class WindowFocusEvent extends Event {

    private final Window window;
    private final boolean focused;

    /**
     * Constructs a {@code WindowFocusEvent}.
     *
     * @param window  the {@link Window} this {@code WindowFocusEvent} is derived from.
     * @param focused whether the {@code Window} has gained or lost focus.
     */
    public WindowFocusEvent(Window window, boolean focused) {
        this.window = window;
        this.focused = focused;
    }

    /**
     * Gets the {@link Window} this {@code WindowFocusEvent} is derived from.
     *
     * @return the {@code Window} this {@code WindowFocusEvent} is derived from.
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Gets whether the {@code Window} has gained or lost focus.
     *
     * @return whether the {@code Window} has gained or lost focus.
     */
    public boolean isFocused() {
        return focused;
    }

}