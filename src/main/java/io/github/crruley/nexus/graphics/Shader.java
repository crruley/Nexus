package io.github.crruley.nexus.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

/**
 * A {@code Shader} is a user-defined program designed to run on some stage of a graphics processor.
 *
 * @author Christopher Ruley
 */
public class Shader {

    /**
     * The {@code PipelineStage}.
     */
    private ShaderPipelineStage shaderPipelineStage;

    /**
     * The source code.
     */
    private String sourceCode;

    /**
     * The unique identification.
     */
    private int handle;

    /**
     * Constructs a {@code Shader}.
     *
     * @param shaderPipelineStage the {@code PipelineStage}.
     * @param sourceCode    the source code.
     */
    public Shader(ShaderPipelineStage shaderPipelineStage, String sourceCode) {
        this.shaderPipelineStage = shaderPipelineStage;
        this.sourceCode = sourceCode;
        handle = glCreateShader(shaderPipelineStage.getOpenGLType());

        glShaderSource(handle, sourceCode);
        glCompileShader(handle);

        if (glGetShaderi(handle, GL_COMPILE_STATUS) == GL_FALSE) {
            String errorMessage = glGetShaderInfoLog(handle);

            glDeleteShader(handle);

            throw new RuntimeException(errorMessage);
        }
    }

    /**
     * Gets the {@code PipelineStage}.
     */
    public ShaderPipelineStage getPipelineStage() {
        return shaderPipelineStage;
    }

    /**
     * Gets the source code.
     */
    public String getSourceCode() {
        return sourceCode;
    }

    /**
     * Gets the unique identification.
     *
     * @return the unique identification.
     */
    public int getHandle() {
        return handle;
    }

    /**
     * Deletes this {@code Shader}.
     */
    public void delete() {
        glDeleteShader(handle);
    }

}
