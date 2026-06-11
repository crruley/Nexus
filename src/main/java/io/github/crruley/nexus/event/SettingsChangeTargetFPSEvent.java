package io.github.crruley.nexus.event;

import io.github.crruley.signal.core.Event;

public class SettingsChangeTargetFPSEvent extends Event {

    private final int targetFPS;

    public SettingsChangeTargetFPSEvent(int targetFPS) {
        this.targetFPS = targetFPS;
    }

    public int getTargetFPS() {
        return targetFPS;
    }

}