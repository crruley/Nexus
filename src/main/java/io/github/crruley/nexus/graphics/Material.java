package io.github.crruley.nexus.graphics;

import io.github.crruley.nexus.math.Vector4;

/**
 * Represents the visual properties of a surface used for rendering.
 *
 * @author Christopher Ruley
 */
public class Material {

    private String name;
    private Vector4 ambientColor;
    private Vector4 diffuseColor;
    private Vector4 specularColor;
    private float shininess;

    // This is optional and may be null.
    private Texture texture;

    /**
     * Constructs a {@code Material}.
     */
    public Material() {
        name = "Default";
        ambientColor = new Vector4();
        diffuseColor = new Vector4();
        specularColor = new Vector4();
        shininess = 0.0F;
    }

    /**
     * Constructs a {@code Material}.
     *
     * @param name          the name.
     * @param ambientColor  the color that is reflected under ambient lighting.
     * @param diffuseColor  the color of the surface under diffuse lighting.
     * @param specularColor the color of the specular highlight on the surface.
     */
    public Material(String name, Vector4 ambientColor, Vector4 diffuseColor, Vector4 specularColor, float shininess) {
        this.name = name;
        this.ambientColor = ambientColor;
        this.diffuseColor = diffuseColor;
        this.specularColor = specularColor;
        this.shininess = shininess;
    }

    /**
     * Gets the name.
     *
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the color that is reflected under ambient lighting.
     *
     * @return the ambient color.
     */
    public Vector4 getAmbientColor() {
        return ambientColor;
    }

    /**
     * Gets the color of the surface under diffuse lighting.
     *
     * @return the diffuse color.
     */
    public Vector4 getDiffuseColor() {
        return diffuseColor;
    }

    /**
     * Gets the color of the specular highlight on the surface.
     *
     * @return the specular color.
     */
    public Vector4 getSpecularColor() {
        return specularColor;
    }

    /**
     * Gets the scattering / radius of the specular highlight.
     *
     * @return the shininess.
     */
    public float getShininess() {
        return shininess;
    }

    /**
     * Gets the (optional) {@link Texture}. This value may be null.
     *
     * @return the (optional) {@link Texture}.
     */
    public Texture getTexture() {
        return texture;
    }

    /**
     * Sets the name.
     *
     * @param name the name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the color that is reflected under ambient lighting.
     *
     * @param ambientColor the ambient color.
     */
    public void setAmbientColor(Vector4 ambientColor) {
        this.ambientColor = ambientColor;
    }

    /**
     * Sets the color of the surface under diffuse lighting.
     *
     * @param diffuseColor the diffuse color.
     */
    public void setDiffuseColor(Vector4 diffuseColor) {
        this.diffuseColor = diffuseColor;
    }

    /**
     * Sets the color of the specular highlight on the surface.
     *
     * @param specularColor the specular color.
     */
    public void setSpecularColor(Vector4 specularColor) {
        this.specularColor = specularColor;
    }

    /**
     * Sets the scattering / radius of the specular highlight.
     *
     * @param shininess the shininess.
     */
    public void setShininess(float shininess) {
        this.shininess = shininess;
    }

    /**
     * Sets the (optional) {@link Texture}. This value may be null.
     *
     * @param texture the (optional) {@link Texture}.
     */
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

}