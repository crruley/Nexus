package io.github.crruley.nexus.scene;

import io.github.crruley.nexus.math.Vector3;

public class Transform {

    private Vector3 position;
    private Vector3 rotation;
    private Vector3 scale;
    private Vector3 previousPosition;
    private Vector3 previousRotation;

    public Transform() {
        setZero();
    }

    public Transform(Vector3 position, Vector3 rotation, Vector3 scale) {
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
        previousPosition = new Vector3();
        previousRotation = new Vector3();

        update();
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getRotation() {
        return rotation;
    }

    public Vector3 getScale() {
        return scale;
    }

    public Vector3 getPreviousPosition() {
        return previousPosition;
    }

    public Vector3 getPreviousRotation() {
        return previousRotation;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public void setRotation(Vector3 rotation) {
        this.rotation = rotation;
    }

    public void setScale(Vector3 scale) {
        this.scale = scale;
    }

    public void setZero() {
        position = position == null ? new Vector3() : position.setZero();
        rotation = rotation == null ? new Vector3() : rotation.setZero();

        if (scale == null) {
            scale = new Vector3(1.0F, 1.0F, 1.0F);
        } else {
            scale.x = 1.0F;
            scale.y = 1.0F;
            scale.z = 1.0F;
        }

        previousPosition = previousPosition == null ? new Vector3() : previousPosition.setZero();
        previousRotation = previousRotation == null ? new Vector3() : previousRotation.setZero();
    }

    public void update() {
       previousPosition.setCopy(position);
       previousRotation.setCopy(rotation);
    }

}