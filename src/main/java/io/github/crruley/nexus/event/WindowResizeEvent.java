package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;
import io.github.crruley.nexus.core.Window;

/**
 * Notifies subscribers when a {@link Window} resizes.
 *
 * @author Christopher Ruley
 */
public class WindowResizeEvent extends Event {

    private final Window window;
    private final int previousWidth;
    private final int previousHeight;

    /**
     * Constructs a {@code WindowResizeEvent}.
     *
     * @param window         the {@link Window} this {@code WindowResizeEvent} is derived from.
     * @param previousWidth  the width before resizing.
     * @param previousHeight the height before resizing.
     */
    public WindowResizeEvent(Window window, int previousWidth, int previousHeight) {
        this.window = window;
        this.previousWidth = previousWidth;
        this.previousHeight = previousHeight;
    }

    /**
     * Gets the {@link Window} this {@code WindowResizeEvent} is derived from.
     *
     * @return the {@code Window} this {@code WindowResizeEvent} is derived from.
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Gets the width (in pixels) of the {@code Window} before resizing.
     *
     * @return the previous width (in pixels).
     */
    public int getPreviousWidth() {
        return previousWidth;
    }

    /**
     * Gets the height (in pixels) of the {@code Window} before resizing.
     *
     * @return the previous height (in pixels).
     */
    public int getPreviousHeight() {
        return previousHeight;
    }

}