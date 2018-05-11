/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.vulkan;

import javax.annotation.*;

import java.nio.*;

import org.lwjgl.*;
import org.lwjgl.system.*;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.MemoryStack.*;

/**
 * Structure indicating which instances are bound.
 * 
 * <h5>Description</h5>
 * 
 * <p>These device indices apply to all buffer and image memory binds included in the batch that points to this structure. The semaphore waits and signals for the batch are executed only by the physical device specified by the {@code resourceDeviceIndex}.</p>
 * 
 * <p>If this structure is not present, {@code resourceDeviceIndex} and {@code memoryDeviceIndex} are assumed to be zero.</p>
 * 
 * <h5>Valid Usage</h5>
 * 
 * <ul>
 * <li>{@code resourceDeviceIndex} and {@code memoryDeviceIndex} <b>must</b> both be valid device indices.</li>
 * <li>Each memory allocation bound in this batch <b>must</b> have allocated an instance for {@code memoryDeviceIndex}.</li>
 * </ul>
 * 
 * <h5>Valid Usage (Implicit)</h5>
 * 
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_DEVICE_GROUP_BIND_SPARSE_INFO STRUCTURE_TYPE_DEVICE_GROUP_BIND_SPARSE_INFO}</li>
 * </ul>
 * 
 * <h3>Member documentation</h3>
 * 
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code resourceDeviceIndex} &ndash; a device index indicating which instance of the resource is bound.</li>
 * <li>{@code memoryDeviceIndex} &ndash; a device index indicating which instance of the memory the resource instance is bound to.</li>
 * </ul>
 * 
 * <h3>Layout</h3>
 * 
 * <code><pre>
 * struct VkDeviceGroupBindSparseInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     uint32_t resourceDeviceIndex;
 *     uint32_t memoryDeviceIndex;
 * }</pre></code>
 */
public class VkDeviceGroupBindSparseInfo extends Struct implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        STYPE,
        PNEXT,
        RESOURCEDEVICEINDEX,
        MEMORYDEVICEINDEX;

    static {
        Layout layout = __struct(
            __member(4),
            __member(POINTER_SIZE),
            __member(4),
            __member(4)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        STYPE = layout.offsetof(0);
        PNEXT = layout.offsetof(1);
        RESOURCEDEVICEINDEX = layout.offsetof(2);
        MEMORYDEVICEINDEX = layout.offsetof(3);
    }

    VkDeviceGroupBindSparseInfo(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    /**
     * Creates a {@link VkDeviceGroupBindSparseInfo} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public VkDeviceGroupBindSparseInfo(ByteBuffer container) {
        this(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** Returns the value of the {@code sType} field. */
    @NativeType("VkStructureType")
    public int sType() { return nsType(address()); }
    /** Returns the value of the {@code pNext} field. */
    @NativeType("void const *")
    public long pNext() { return npNext(address()); }
    /** Returns the value of the {@code resourceDeviceIndex} field. */
    @NativeType("uint32_t")
    public int resourceDeviceIndex() { return nresourceDeviceIndex(address()); }
    /** Returns the value of the {@code memoryDeviceIndex} field. */
    @NativeType("uint32_t")
    public int memoryDeviceIndex() { return nmemoryDeviceIndex(address()); }

    /** Sets the specified value to the {@code sType} field. */
    public VkDeviceGroupBindSparseInfo sType(@NativeType("VkStructureType") int value) { nsType(address(), value); return this; }
    /** Sets the specified value to the {@code pNext} field. */
    public VkDeviceGroupBindSparseInfo pNext(@NativeType("void const *") long value) { npNext(address(), value); return this; }
    /** Sets the specified value to the {@code resourceDeviceIndex} field. */
    public VkDeviceGroupBindSparseInfo resourceDeviceIndex(@NativeType("uint32_t") int value) { nresourceDeviceIndex(address(), value); return this; }
    /** Sets the specified value to the {@code memoryDeviceIndex} field. */
    public VkDeviceGroupBindSparseInfo memoryDeviceIndex(@NativeType("uint32_t") int value) { nmemoryDeviceIndex(address(), value); return this; }

    /** Initializes this struct with the specified values. */
    public VkDeviceGroupBindSparseInfo set(
        int sType,
        long pNext,
        int resourceDeviceIndex,
        int memoryDeviceIndex
    ) {
        sType(sType);
        pNext(pNext);
        resourceDeviceIndex(resourceDeviceIndex);
        memoryDeviceIndex(memoryDeviceIndex);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public VkDeviceGroupBindSparseInfo set(VkDeviceGroupBindSparseInfo src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@link VkDeviceGroupBindSparseInfo} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static VkDeviceGroupBindSparseInfo malloc() {
        return create(nmemAllocChecked(SIZEOF));
    }

    /** Returns a new {@link VkDeviceGroupBindSparseInfo} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static VkDeviceGroupBindSparseInfo calloc() {
        return create(nmemCallocChecked(1, SIZEOF));
    }

    /** Returns a new {@link VkDeviceGroupBindSparseInfo} instance allocated with {@link BufferUtils}. */
    public static VkDeviceGroupBindSparseInfo create() {
        return new VkDeviceGroupBindSparseInfo(BufferUtils.createByteBuffer(SIZEOF));
    }

    /** Returns a new {@link VkDeviceGroupBindSparseInfo} instance for the specified memory address. */
    public static VkDeviceGroupBindSparseInfo create(long address) {
        return new VkDeviceGroupBindSparseInfo(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static VkDeviceGroupBindSparseInfo createSafe(long address) {
        return address == NULL ? null : create(address);
    }

    /**
     * Returns a new {@link VkDeviceGroupBindSparseInfo.Buffer} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static VkDeviceGroupBindSparseInfo.Buffer malloc(int capacity) {
        return create(__malloc(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkDeviceGroupBindSparseInfo.Buffer} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static VkDeviceGroupBindSparseInfo.Buffer calloc(int capacity) {
        return create(nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkDeviceGroupBindSparseInfo.Buffer} instance allocated with {@link BufferUtils}.
     *
     * @param capacity the buffer capacity
     */
    public static VkDeviceGroupBindSparseInfo.Buffer create(int capacity) {
        return new Buffer(__create(capacity, SIZEOF));
    }

    /**
     * Create a {@link VkDeviceGroupBindSparseInfo.Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static VkDeviceGroupBindSparseInfo.Buffer create(long address, int capacity) {
        return new Buffer(address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static VkDeviceGroupBindSparseInfo.Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : create(address, capacity);
    }

    // -----------------------------------

    /** Returns a new {@link VkDeviceGroupBindSparseInfo} instance allocated on the thread-local {@link MemoryStack}. */
    public static VkDeviceGroupBindSparseInfo mallocStack() {
        return mallocStack(stackGet());
    }

    /** Returns a new {@link VkDeviceGroupBindSparseInfo} instance allocated on the thread-local {@link MemoryStack} and initializes all its bits to zero. */
    public static VkDeviceGroupBindSparseInfo callocStack() {
        return callocStack(stackGet());
    }

    /**
     * Returns a new {@link VkDeviceGroupBindSparseInfo} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static VkDeviceGroupBindSparseInfo mallocStack(MemoryStack stack) {
        return create(stack.nmalloc(ALIGNOF, SIZEOF));
    }

    /**
     * Returns a new {@link VkDeviceGroupBindSparseInfo} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static VkDeviceGroupBindSparseInfo callocStack(MemoryStack stack) {
        return create(stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    /**
     * Returns a new {@link VkDeviceGroupBindSparseInfo.Buffer} instance allocated on the thread-local {@link MemoryStack}.
     *
     * @param capacity the buffer capacity
     */
    public static VkDeviceGroupBindSparseInfo.Buffer mallocStack(int capacity) {
        return mallocStack(capacity, stackGet());
    }

    /**
     * Returns a new {@link VkDeviceGroupBindSparseInfo.Buffer} instance allocated on the thread-local {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param capacity the buffer capacity
     */
    public static VkDeviceGroupBindSparseInfo.Buffer callocStack(int capacity) {
        return callocStack(capacity, stackGet());
    }

    /**
     * Returns a new {@link VkDeviceGroupBindSparseInfo.Buffer} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static VkDeviceGroupBindSparseInfo.Buffer mallocStack(int capacity, MemoryStack stack) {
        return create(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkDeviceGroupBindSparseInfo.Buffer} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static VkDeviceGroupBindSparseInfo.Buffer callocStack(int capacity, MemoryStack stack) {
        return create(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #sType}. */
    public static int nsType(long struct) { return memGetInt(struct + VkDeviceGroupBindSparseInfo.STYPE); }
    /** Unsafe version of {@link #pNext}. */
    public static long npNext(long struct) { return memGetAddress(struct + VkDeviceGroupBindSparseInfo.PNEXT); }
    /** Unsafe version of {@link #resourceDeviceIndex}. */
    public static int nresourceDeviceIndex(long struct) { return memGetInt(struct + VkDeviceGroupBindSparseInfo.RESOURCEDEVICEINDEX); }
    /** Unsafe version of {@link #memoryDeviceIndex}. */
    public static int nmemoryDeviceIndex(long struct) { return memGetInt(struct + VkDeviceGroupBindSparseInfo.MEMORYDEVICEINDEX); }

    /** Unsafe version of {@link #sType(int) sType}. */
    public static void nsType(long struct, int value) { memPutInt(struct + VkDeviceGroupBindSparseInfo.STYPE, value); }
    /** Unsafe version of {@link #pNext(long) pNext}. */
    public static void npNext(long struct, long value) { memPutAddress(struct + VkDeviceGroupBindSparseInfo.PNEXT, value); }
    /** Unsafe version of {@link #resourceDeviceIndex(int) resourceDeviceIndex}. */
    public static void nresourceDeviceIndex(long struct, int value) { memPutInt(struct + VkDeviceGroupBindSparseInfo.RESOURCEDEVICEINDEX, value); }
    /** Unsafe version of {@link #memoryDeviceIndex(int) memoryDeviceIndex}. */
    public static void nmemoryDeviceIndex(long struct, int value) { memPutInt(struct + VkDeviceGroupBindSparseInfo.MEMORYDEVICEINDEX, value); }

    // -----------------------------------

    /** An array of {@link VkDeviceGroupBindSparseInfo} structs. */
    public static class Buffer extends StructBuffer<VkDeviceGroupBindSparseInfo, Buffer> implements NativeResource {

        /**
         * Creates a new {@link VkDeviceGroupBindSparseInfo.Buffer} instance backed by the specified container.
         *
         * Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link VkDeviceGroupBindSparseInfo#SIZEOF}, and its mark will be undefined.
         *
         * <p>The created buffer instance holds a strong reference to the container object.</p>
         */
        public Buffer(ByteBuffer container) {
            super(container, container.remaining() / SIZEOF);
        }

        public Buffer(long address, int cap) {
            super(address, null, -1, 0, cap, cap);
        }

        Buffer(long address, @Nullable ByteBuffer container, int mark, int pos, int lim, int cap) {
            super(address, container, mark, pos, lim, cap);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected Buffer newBufferInstance(long address, @Nullable ByteBuffer container, int mark, int pos, int lim, int cap) {
            return new Buffer(address, container, mark, pos, lim, cap);
        }

        @Override
        protected VkDeviceGroupBindSparseInfo newInstance(long address) {
            return new VkDeviceGroupBindSparseInfo(address, container);
        }

        @Override
        public int sizeof() {
            return SIZEOF;
        }

        /** Returns the value of the {@code sType} field. */
        @NativeType("VkStructureType")
        public int sType() { return VkDeviceGroupBindSparseInfo.nsType(address()); }
        /** Returns the value of the {@code pNext} field. */
        @NativeType("void const *")
        public long pNext() { return VkDeviceGroupBindSparseInfo.npNext(address()); }
        /** Returns the value of the {@code resourceDeviceIndex} field. */
        @NativeType("uint32_t")
        public int resourceDeviceIndex() { return VkDeviceGroupBindSparseInfo.nresourceDeviceIndex(address()); }
        /** Returns the value of the {@code memoryDeviceIndex} field. */
        @NativeType("uint32_t")
        public int memoryDeviceIndex() { return VkDeviceGroupBindSparseInfo.nmemoryDeviceIndex(address()); }

        /** Sets the specified value to the {@code sType} field. */
        public VkDeviceGroupBindSparseInfo.Buffer sType(@NativeType("VkStructureType") int value) { VkDeviceGroupBindSparseInfo.nsType(address(), value); return this; }
        /** Sets the specified value to the {@code pNext} field. */
        public VkDeviceGroupBindSparseInfo.Buffer pNext(@NativeType("void const *") long value) { VkDeviceGroupBindSparseInfo.npNext(address(), value); return this; }
        /** Sets the specified value to the {@code resourceDeviceIndex} field. */
        public VkDeviceGroupBindSparseInfo.Buffer resourceDeviceIndex(@NativeType("uint32_t") int value) { VkDeviceGroupBindSparseInfo.nresourceDeviceIndex(address(), value); return this; }
        /** Sets the specified value to the {@code memoryDeviceIndex} field. */
        public VkDeviceGroupBindSparseInfo.Buffer memoryDeviceIndex(@NativeType("uint32_t") int value) { VkDeviceGroupBindSparseInfo.nmemoryDeviceIndex(address(), value); return this; }

    }

}