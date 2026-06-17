package io.github.crruley.nexus.scene;

public class Camera {

    private Transform transform;

    public Camera() {
        transform = new Transform();
    }

    public Camera(Transform transform) {
        this.transform = transform;
    }

   public Transform getTransform() {
        return transform;
   }

   public void setTransform(Transform transform) {
        this.transform = transform;
   }

   public void update() {
        transform.update();
   }

}