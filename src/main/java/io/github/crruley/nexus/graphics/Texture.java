package io.github.crruley.nexus.graphics;

import java.awt.image.BufferedImage;

import static io.github.crruley.nexus.utility.Documents.*;
import static io.github.crruley.nexus.utility.Memory.*;
import static org.lwjgl.opengl.GL11.*;

/**
 * Represents a two-dimensional texture used for rendering.
 * <p>
 * A {@code Texture} loads image data from a file and stores it as an OpenGL texture.
 *
 * @author Christopher Ruley
 */
public class Texture {

    private final int width;
    private final int height;
    private final int handle;

    /**
     * Construxts a {@code Texture} from the image at the specified path.
     *
     * @param path the path of the image file.
     */
    public Texture(String path) {
        BufferedImage bufferedImage = readImage(path);

        width = bufferedImage.getWidth();
        height = bufferedImage.getHeight();

        int length = width * height;
        int[] pixels = new int[length];

        bufferedImage.getRGB(0, 0, width, height, pixels, 0, width);

        int[] rearrangedPixels = new int[length];

        for (int i = 0; i < length; i++) {
            int a = (pixels[i] & 0xff000000) >> 24;
            int r = (pixels[i] & 0xff0000) >> 16;
            int g = (pixels[i] & 0xff00) >> 8;
            int b = (pixels[i] & 0xff);

            rearrangedPixels[i] = a << 24 | b << 16 | g << 8 | r;
        }

        handle = glGenTextures();

        bind();
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE,
            store(rearrangedPixels));
        unbind();
    }

    /**
     * Gets the width, in pixels.
     *
     * @return the width, in pixels.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height, in pixels.
     *
     * @return the height, in pixels.
     */
    public int getHeight() {
        return height;
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
     * Binds this {@code Texture}.
     */
    public void bind() {
        glBindTexture(GL_TEXTURE_2D, handle);
    }

    /**
     * Unbinds this {@code Texture}.
     */
    public void unbind() {
        glBindTexture(GL_TEXTURE_2D, 0);
    }

    /**
     * Deletes this {@code Texture}.
     */
    public void delete() {
        glDeleteTextures(handle);
    }

}