package io.github.crruley.nexus.graphics;

/**
 * Represents an independently drawable region of a {@link Mesh}.
 * <p>
 * A {@code SubMesh} defines the range of vertex data, index data (if applicable), and the {@link Material} used when
 * rendering that region. It does not own the underlying geometry.
 *
 * @author Christopher Ruley
 */
public class SubMesh {

    /**
     * The name.
     */
    private final String name;

    /**
     * The {@link Material}.
     */
    private final Material material;

    /**
     * The total number of vertices.
     */
    private final int vertexCount;

    /**
     * The total number of indices.
     */
    private final int indexCount;

    /**
     * The starting position of the indices.
     */
    private final int indexOffset;

    /**
     * Constructs a {@code SubMesh}.
     *
     * @param name        the name.
     * @param material    the {@link Material}.
     * @param vertexCount the total number of vertices.
     * @param indexCount  the total number of indices.
     * @param indexOffset the starting position of the indices.
     */
    public SubMesh(String name, Material material, int vertexCount, int indexCount, int indexOffset) {
        this.name = name;
        this.material = material;
        this.vertexCount = vertexCount;
        this.indexCount = indexCount;
        this.indexOffset = indexOffset;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getIndexCount() {
        return indexCount;
    }

    public int getIndexOffset() {
        return indexOffset;
    }

}