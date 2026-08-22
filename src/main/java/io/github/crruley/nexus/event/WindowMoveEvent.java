package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;
import io.github.crruley.nexus.core.Window;

/**
 * Notifies subscribers when a {@link Window} moves.
 *
 * @author Christopher Ruley
 */
public class WindowMoveEvent extends Event {

    private final Window window;
    private final int previousX;
    private final int previousY;

    /**
     * Constructs a {@code WindowMoveEvent}.
     *
     * @param window    the {@link Window} this {@code WindowMoveEvent} is derived from.
     * @param previousX the x position before moving.
     * @param previousY the y position before moving.
     */
    public WindowMoveEvent(Window window, int previousX, int previousY) {
        this.window = window;
        this.previousX = previousX;
        this.previousY = previousY;
    }

    /**
     * Gets the {@link Window} this {@code WindowMoveEvent} is derived from.
     *
     * @return the {@code Window} this {@code WindowMoveEvent} is derived from.
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Gets the x position of the {@code Window} before moving.
     *
     * @return the previous x position.
     */
    public int getPreviousX() {
        return previousX;
    }

    /**
     * Gets the y position of the {@code Window} before moving.
     *
     * @return the previous y position.
     */
    public int getPreviousY() {
        return previousY;
    }

}