package io.github.crruley.nexus.scene;

import io.github.crruley.nexus.model.Model;

public class Entity {

    private Model model;
    private Transform transform;

    public Entity(Model model, Transform transform) {
        this.model = model;
        this.transform = transform;
    }

    public Model getModel() {
        return model;
    }

    public Transform getTransform() {
        return transform;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void update() {
        transform.update();
    }

    public void delete() {
        model.delete();
    }

}