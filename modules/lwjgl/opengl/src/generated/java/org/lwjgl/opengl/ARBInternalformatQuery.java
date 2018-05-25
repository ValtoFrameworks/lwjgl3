/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.opengl;

import java.nio.*;

import org.lwjgl.system.*;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.JNI.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * Native bindings to the <a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_internalformat_query.txt">ARB_internalformat_query</a> extension.
 * 
 * <p>OpenGL 4.1 has a number of queries to indicate the maximum number of samples available for different formats. These give a coarse-grained query
 * mechanism e.g. an implementation can expose different sample counts for integer and floating-point formats, but not for different floating-point
 * formats. There is also no convenient way for the user to determine the granularity of sample counts available, only the maximum.</p>
 * 
 * <p>This extension adds a query mechanism that allows the user to determine which sample counts are available for a specific internal format.</p>
 * 
 * <p>Requires {@link GL30 OpenGL 3.0} or {@link ARBFramebufferObject ARB_framebuffer_object}. Promoted to core in {@link GL42 OpenGL 4.2}.</p>
 */
public class ARBInternalformatQuery {

    /** Accepted by the {@code pname} parameter of GetInternalformativ. */
    public static final int GL_NUM_SAMPLE_COUNTS = 0x9380;

    static { GL.initialize(); }

    protected ARBInternalformatQuery() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return checkFunctions(
            caps.glGetInternalformativ
        );
    }

    // --- [ glGetInternalformativ ] ---

    /**
     * Unsafe version of: {@link #glGetInternalformativ GetInternalformativ}
     *
     * @param bufSize the maximum number of values that may be written to params by the function
     */
    public static void nglGetInternalformativ(int target, int internalformat, int pname, int bufSize, long params) {
        GL42.nglGetInternalformativ(target, internalformat, pname, bufSize, params);
    }

    /**
     * Retrieves information about implementation-dependent support for internal formats.
     *
     * @param target         the usage of the internal format. One of:<br><table><tr><td>{@link GL11#GL_TEXTURE_1D TEXTURE_1D}</td><td>{@link GL11#GL_TEXTURE_2D TEXTURE_2D}</td><td>{@link GL30#GL_TEXTURE_1D_ARRAY TEXTURE_1D_ARRAY}</td><td>{@link GL31#GL_TEXTURE_RECTANGLE TEXTURE_RECTANGLE}</td><td>{@link GL13#GL_TEXTURE_CUBE_MAP TEXTURE_CUBE_MAP}</td></tr><tr><td>{@link GL12#GL_TEXTURE_3D TEXTURE_3D}</td><td>{@link GL30#GL_TEXTURE_2D_ARRAY TEXTURE_2D_ARRAY}</td><td>{@link GL40#GL_TEXTURE_CUBE_MAP_ARRAY TEXTURE_CUBE_MAP_ARRAY}</td><td>{@link GL30#GL_RENDERBUFFER RENDERBUFFER}</td><td>{@link GL31#GL_TEXTURE_BUFFER TEXTURE_BUFFER}</td></tr><tr><td>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE TEXTURE_2D_MULTISAMPLE}</td><td>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE_ARRAY TEXTURE_2D_MULTISAMPLE_ARRAY}</td></tr></table>
     * @param internalformat the internal format about which to retrieve information
     * @param pname          the type of information to query
     * @param params         a variable into which to write the retrieved information
     */
    public static void glGetInternalformativ(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
        nglGetInternalformativ(target, internalformat, pname, params.remaining(), memAddress(params));
    }

    /**
     * Retrieves information about implementation-dependent support for internal formats.
     *
     * @param target         the usage of the internal format. One of:<br><table><tr><td>{@link GL11#GL_TEXTURE_1D TEXTURE_1D}</td><td>{@link GL11#GL_TEXTURE_2D TEXTURE_2D}</td><td>{@link GL30#GL_TEXTURE_1D_ARRAY TEXTURE_1D_ARRAY}</td><td>{@link GL31#GL_TEXTURE_RECTANGLE TEXTURE_RECTANGLE}</td><td>{@link GL13#GL_TEXTURE_CUBE_MAP TEXTURE_CUBE_MAP}</td></tr><tr><td>{@link GL12#GL_TEXTURE_3D TEXTURE_3D}</td><td>{@link GL30#GL_TEXTURE_2D_ARRAY TEXTURE_2D_ARRAY}</td><td>{@link GL40#GL_TEXTURE_CUBE_MAP_ARRAY TEXTURE_CUBE_MAP_ARRAY}</td><td>{@link GL30#GL_RENDERBUFFER RENDERBUFFER}</td><td>{@link GL31#GL_TEXTURE_BUFFER TEXTURE_BUFFER}</td></tr><tr><td>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE TEXTURE_2D_MULTISAMPLE}</td><td>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE_ARRAY TEXTURE_2D_MULTISAMPLE_ARRAY}</td></tr></table>
     * @param internalformat the internal format about which to retrieve information
     * @param pname          the type of information to query
     */
    @NativeType("void")
    public static int glGetInternalformati(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int pname) {
        MemoryStack stack = stackGet(); int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            nglGetInternalformativ(target, internalformat, pname, 1, memAddress(params));
            return params.get(0);
        } finally {
            stack.setPointer(stackPointer);
        }
    }

    /** Array version of: {@link #glGetInternalformativ GetInternalformativ} */
    public static void glGetInternalformativ(@NativeType("GLenum") int target, @NativeType("GLenum") int internalformat, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetInternalformativ;
        if (CHECKS) {
            check(__functionAddress);
        }
        callPV(__functionAddress, target, internalformat, pname, params.length, params);
    }

}