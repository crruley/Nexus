package io.github.crruley.nexus.scene;

import io.github.crruley.nexus.graphics.Mesh;

public class Entity {

    private Mesh mesh;
    private Transform transform;

    public Entity(Mesh mesh, Transform transform) {
        this.mesh = mesh;
        this.transform = transform;
    }

    public Mesh getModel() {
        return mesh;
    }

    public Transform getTransform() {
        return transform;
    }

    public void setMesh(Mesh mesh) {
        this.mesh = mesh;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public void update() {
        transform.update();
    }

    public void delete() {
        mesh.delete();
    }

}