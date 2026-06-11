package io.github.crruley.nexus.core;

import io.github.crruley.nexus.event.*;
import io.github.crruley.signal.core.Bus;

import static io.github.crruley.signal.core.Priority.*;

public class Settings {

    private final Bus bus;

    private String title;

    private int width;

    private int height;

    private int targetUPS;

    private int targetFPS;

    private boolean vSync;

    public Settings(Bus bus) {
        this.bus = bus;
        title = "";
        width = 960;
        height = 540;
        targetUPS = 60;
        targetFPS = 120;
        vSync = false;
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getTargetUPS() {
        return targetUPS;
    }

    public int getTargetFPS() {
        return targetFPS;
    }

    public boolean getVSync() {
        return vSync;
    }

    public void setTitle(String title) {
        bus.publish(new SettingsChangeTitleEvent(this.title = title), HIGH);
    }

    public void setWidth(int width) {
        bus.publish(new SettingsChangeWidthEvent(this.width = width), HIGH);
    }

    public void setHeight(int height) {
        bus.publish(new SettingsChangeHeightEvent(this.height = height), HIGH);
    }

    public void setTargetUPS(int targetUPS) {
        bus.publish(new SettingsChangeTargetUPSEvent(this.targetUPS = targetUPS), HIGH);
    }

    public void setTargetFPS(int targetFPS) {
        bus.publish(new SettingsChangeTargetFPSEvent(this.targetFPS = targetFPS), HIGH);
    }

    public void setVSync(boolean vSync) {
        bus.publish(new SettingsChangeVSyncEvent(this.vSync = vSync), HIGH);
    }
}