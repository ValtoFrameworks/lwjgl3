/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.opengl;

/**
 * Native bindings to the <a target="_blank" href="https://www.khronos.org/registry/OpenGL/extensions/EXT/EXT_framebuffer_sRGB.txt">EXT_framebuffer_sRGB</a> extension.
 * 
 * <p>Conventionally, OpenGL assumes framebuffer color components are stored in a linear color space. In particular, framebuffer blending is a linear
 * operation.</p>
 * 
 * <p>The sRGB color space is based on typical (non-linear) monitor characteristics expected in a dimly lit office. It has been standardized by the
 * International Electrotechnical Commission (IEC) as IEC 61966-2-1. The sRGB color space roughly corresponds to 2.2 gamma correction.</p>
 * 
 * <p>This extension adds a framebuffer capability for sRGB framebuffer update and blending. When blending is disabled but the new sRGB updated mode is
 * enabled (assume the framebuffer supports the capability), high-precision linear color component values for red, green, and blue generated by fragment
 * coloring are encoded for sRGB prior to being written into the framebuffer. When blending is enabled along with the new sRGB update mode, red, green, and
 * blue framebuffer color components are treated as sRGB values that are converted to linear color values, blended with the high-precision color values
 * generated by fragment coloring, and then the blend result is encoded for sRGB just prior to being written into the framebuffer.</p>
 * 
 * <p>The primary motivation for this extension is that it allows OpenGL applications to render into a framebuffer that is scanned to a monitor configured to
 * assume framebuffer color values are sRGB encoded. This assumption is roughly true of most PC monitors with default gamma correction. This allows
 * applications to achieve faithful color reproduction for OpenGL rendering without adjusting the monitor's gamma correction.</p>
 * 
 * <p>Promoted to core in {@link GL30 OpenGL 3.0}.</p>
 */
public final class EXTFramebufferSRGB {

    /**
     * Accepted by the {@code cap} parameter of Enable, Disable, and IsEnabled, and by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv, and
     * GetDoublev.
     */
    public static final int GL_FRAMEBUFFER_SRGB_EXT = 0x8DB9;

    /** Accepted by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv, and GetDoublev. */
    public static final int GL_FRAMEBUFFER_SRGB_CAPABLE_EXT = 0x8DBA;

    private EXTFramebufferSRGB() {}

}