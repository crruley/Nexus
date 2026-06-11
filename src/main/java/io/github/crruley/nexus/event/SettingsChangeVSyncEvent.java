package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;

public class SettingsChangeVSyncEvent extends Event {

    private final boolean vSync;

    public SettingsChangeVSyncEvent(boolean vSync) {
        this.vSync = vSync;
    }

    public boolean getVSync() {
        return vSync;
    }

}