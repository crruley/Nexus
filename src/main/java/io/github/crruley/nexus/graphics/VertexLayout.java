package io.github.crruley.nexus.graphics;

/**
 * Defines the layout of vertex data stored in a {@link VertexBuffer}.
 * <p>
 * A {@code VertexLayout} consists of one or more {@link VertexElement} instances that describe the attributes of each
 * vertex.
 *
 * @author Christopher Ruley
 */
public class VertexLayout {

    private final VertexElement[] vertexElements;
    private int stride;

    /**
     * Constructs a {@code VertexLayout}.
     * <p>
     * The offset of each {@link VertexElement} and the stride of the layout are calculated according to the size of
     * each element.
     *
     * @param vertexElements the {@code VertexElement} array.
     */
    public VertexLayout(VertexElement... vertexElements) {
        this.vertexElements = vertexElements;

        int offset = 0;

        for (var vertexElement : vertexElements) {
            vertexElement.offset = offset;

            int size = vertexElement.getShaderDataType().getSize();

            offset += size;
            stride += size;
        }
    }

    /**
     * Gets the {@code VertexElement} array.
     *
     * @return the {@code VertexElement} array.
     */
    public VertexElement[] getVertexElements() {
        return vertexElements;
    }

    /**
     * Gets the stride (in bytes), or the total of each {@code VertexElement}'s size.
     *
     * @return the stride (in bytes).
     */
    public int getStride() {
        return stride;
    }

}