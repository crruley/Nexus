package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;

public class SettingsChangeHeightEvent extends Event {

    private final int height;

    public SettingsChangeHeightEvent(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

}