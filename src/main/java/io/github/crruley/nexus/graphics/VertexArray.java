package io.github.crruley.nexus.graphics;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

/**
 * Represents the configuration of vertex data used for rendering.
 * <p>
 * A {@code VertexArray} associates one or more {@link VertexBuffer} instances and optionally an {@link IndexBuffer}.
 *
 * @author Christopher Ruley
 */
public class VertexArray {

    private final VertexBuffer[] vertexBuffers;
    private final int handle;
    private IndexBuffer indexBuffer;

    /**
     * Constructs a {@code VertexArray} and associates the provided {@link VertexBuffer} instances.
     *
     * @param vertexBuffers the {@code VertexBuffer} instances.
     */
    public VertexArray(VertexBuffer... vertexBuffers) {
        this.vertexBuffers = vertexBuffers;
        handle = glGenVertexArrays();

        bind();

        int index = 0;

        for (var vertexBuffer : vertexBuffers) {
            VertexLayout vertexLayout = vertexBuffer.getVertexLayout();
            VertexElement[] vertexElements = vertexLayout.getVertexElements();

            vertexBuffer.bind();

            for (var vertexElement : vertexElements) {
                ShaderDataType shaderDataType = vertexElement.getShaderDataType();

                glEnableVertexAttribArray(index);
                glVertexAttribPointer(index, shaderDataType.getComponentCount(), shaderDataType.getOpenGLType(),
                    vertexElement.isNormalized(), vertexLayout.getStride(), vertexElement.getOffset());

                index++;
            }
        }

        unbind();
    }

    /**
     * Gets the {@code VertexBuffer} array.
     *
     * @return the {@code VertexBuffer} array.
     */
    public VertexBuffer[] getVertexBuffers() {
        return vertexBuffers;
    }

    /**
     * Gets the unique identification.
     *
     * @return the unique identification.
     */
    public long getHandle() {
        return handle;
    }

    /**
     * Gets the (optional) {@link IndexBuffer}. This value can be null
     *
     * @return the {@link IndexBuffer} if present or null if not.
     */
    public IndexBuffer getIndexBuffer() {
        return indexBuffer;
    }

    /**
     * Sets the {@code IndexBuffer}.
     *
     * @param indexBuffer the {@code IndexBuffer}.
     */
    public void setIndexBuffer(IndexBuffer indexBuffer) {
        this.indexBuffer = indexBuffer;

        bind();
        indexBuffer.bind();
        unbind();
    }

    /**
     * Binds this {@code VertexArray}.
     */
    public void bind() {
        glBindVertexArray(handle);
    }

    /**
     * Unbinds this {@code VertexArray}.
     */
    public void unbind() {
        glBindVertexArray(0);
    }

    /**
     * Deletes this {@code VertexArray} and the associated {@link VertexBuffer} instances (and {@link IndexBuffer},
     * if used).
     */
    public void delete() {
        glDeleteVertexArrays(handle);

        for (var vertexBuffer : vertexBuffers) {
            vertexBuffer.delete();
        }

        if (indexBuffer != null) {
            indexBuffer.delete();
        }
    }

}