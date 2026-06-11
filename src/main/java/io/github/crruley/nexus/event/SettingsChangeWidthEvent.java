package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;

public class SettingsChangeWidthEvent extends Event {

    private final int width;

    public SettingsChangeWidthEvent(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

}