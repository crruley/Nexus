package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;

public class SettingsChangeTargetUPSEvent extends Event {

    private final int targetUPS;

    public SettingsChangeTargetUPSEvent(int targetUPS) {
        this.targetUPS = targetUPS;
    }

    public int getTargetUPS() {
        return targetUPS;
    }
}