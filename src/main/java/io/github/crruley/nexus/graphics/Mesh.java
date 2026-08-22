package io.github.crruley.nexus.graphics;

/**
 * Represents a complete set of renderable geometry.
 * <p>
 * A {@code Mesh} owns the {@link VertexArray} which contains the vertex and index data and is divided into one or more
 * {@link SubMesh} instances that define independently drawable regions of geometry.
 *
 * @author Christopher Ruley
 */
public class Mesh {

    private final VertexArray vertexArray;
    private final SubMesh[] subMeshes;

    /**
     * Constructs a {@code Mesh}.
     *
     * @param vertexArray the {@link VertexArray}.
     * @param subMeshes   the array of {@link SubMesh} instances.
     */
    public Mesh(VertexArray vertexArray, SubMesh[] subMeshes) {
        this.vertexArray = vertexArray;
        this.subMeshes = subMeshes;
    }

    public VertexArray getVertexArray() {
        return vertexArray;
    }

    public SubMesh[] getSubMeshes() {
        return subMeshes;
    }

    /**
     * Binds this {@code Mesh}.
     */
    public void bind() {
        vertexArray.bind();
    }

    /**
     * Unbinds this {@code Mesh}.
     */
    public void unbind() {
        vertexArray.unbind();
    }

    /**
     * Deletes this {@code Mesh} by releasing its resources.
     */
    public void delete() {
        vertexArray.delete();
    }

}