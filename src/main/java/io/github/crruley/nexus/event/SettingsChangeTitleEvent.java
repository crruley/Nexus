package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;

public class SettingsChangeTitleEvent extends Event {

    private final String title;

    public SettingsChangeTitleEvent(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}