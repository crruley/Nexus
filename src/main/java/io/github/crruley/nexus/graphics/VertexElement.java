package io.github.crruley.nexus.graphics;

/**
 * Represents an attribute for a vertex, such as a position, normal, or texture coordinate.
 *
 * @author Christopher Ruley
 */
public class VertexElement {

    private final String name;
    private final ShaderDataType shaderDataType;
    private final boolean normalized;

    // This is calculated later.
    int offset;

    /**
     * Constructs an {@code VertexElement}.
     *
     * @param name           the name.
     * @param shaderDataType the {@link ShaderDataType}.
     * @param normalized     whether data should be normalized or converted directly as fixed-point values.
     */
    public VertexElement(String name, ShaderDataType shaderDataType, boolean normalized) {
        this.name = name;
        this.shaderDataType = shaderDataType;
        this.normalized = normalized;
    }

    /**
     * The name.
     */
    public String getName() {
        return name;
    }

    /**
     * The {@link ShaderDataType}.
     */
    public ShaderDataType getShaderDataType() {
        return shaderDataType;
    }

    /**
     * Gets whether this should be normalized or converted directly as fixed-point values. If true, values are mapped to
     * the range [-1, 1] (for signed values) or [0, 1] (for unsigned values) when accessed and converted to floating
     * points.
     *
     * @return whether data should be normalized or converted directly as fixed-point values.
     */
    public boolean isNormalized() {
        return normalized;
    }

    /**
     * Gets the offset (in bytes), or displacement. This value is calculated during the creation of the
     * {@link VertexLayout}.
     *
     * @return the offset (in bytes).
     */
    public int getOffset() {
        return offset;
    }

}