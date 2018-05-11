/*
 * Copyright (c) 2014-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package org.lwjgl.util.yoga;

import org.lwjgl.system.*;
import org.testng.annotations.*;

import java.lang.ref.*;
import java.util.*;
import java.util.concurrent.atomic.*;

import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.util.yoga.Yoga.*;
import static org.lwjgl.util.yoga.YogaNode.*;
import static org.testng.Assert.*;

public class YogaNodeTest {

    @Test
    public void testInit() {
        int refCount = YGNodeGetInstanceCount();
        new YogaNode();
        assertEquals(refCount + 1, YGNodeGetInstanceCount());
    }

    @Test
    public void testBaseline() {
        YogaNode root = new YogaNode();
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWidth(100);
        root.setHeight(100);

        YogaNode child1 = new YogaNode();
        child1.setWidth(40);
        child1.setHeight(40);
        root.addChildAt(child1, 0);

        YogaNode child2 = new YogaNode();
        child2.setWidth(40);
        child2.setHeight(40);
        YGNodeSetBaselineFunc(child2.node, (node, width, height) -> 0);
        root.addChildAt(child2, 1);

        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0, (int)child1.getLayoutY());
        assertEquals(40, (int)child2.getLayoutY());

        Objects.requireNonNull(YGNodeGetBaselineFunc(child2.node)).free();
    }

    private static YGMeasureFunc getTestMeasureFunc(float testWidth, float testHeight) {
        return YGMeasureFunc.create((node, width, widthMode, height, heightMode) -> {
            try (MemoryStack stack = stackPush()) {
                return YGMeasureFunc.toLong(
                    YGSize.mallocStack(stack)
                        .width(testWidth)
                        .height(testHeight)
                );
            }
        });
    }

    @Test
    public void testMeasure() {
        YogaNode node = new YogaNode();

        try (YGMeasureFunc measureFunc = getTestMeasureFunc(200, 100)) {
            YGNodeSetMeasureFunc(node.node, measureFunc);
            node.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);
            assertEquals(200, (int)node.getLayoutWidth());
            assertEquals(100, (int)node.getLayoutHeight());
        }
    }

    @Test
    public void testMeasureFloat() {
        YogaNode node = new YogaNode();

        try (YGMeasureFunc measureFunc = getTestMeasureFunc(200.5f, 100.5f)) {
            YGNodeSetMeasureFunc(node.node, measureFunc);
            node.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);
            assertEquals(201.0f, node.getLayoutWidth(), 0.01f);
            assertEquals(101.0f, node.getLayoutHeight(), 0.01f);
        }
    }

    @Test
    public void testMeasureFloatMin() {
        YogaNode node = new YogaNode();
        try (YGMeasureFunc measureFunc = getTestMeasureFunc(Float.MIN_VALUE, Float.MIN_VALUE)) {
            YGNodeSetMeasureFunc(node.node, measureFunc);
            node.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);
            assertEquals(Float.MIN_VALUE, node.getLayoutWidth(), 0.01f);
            assertEquals(Float.MIN_VALUE, node.getLayoutHeight(), 0.01f);
        }
    }

    @Test
    public void testMeasureFloatMax() {
        YogaNode node      = new YogaNode();
        float    bigNumber = (float)10E5;
        try (YGMeasureFunc measureFunc = getTestMeasureFunc(bigNumber, bigNumber)) {
            YGNodeSetMeasureFunc(node.node, measureFunc);
            node.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);
            assertEquals(bigNumber, node.getLayoutWidth(), 0.01f);
            assertEquals(bigNumber, node.getLayoutHeight(), 0.01f);
        }
    }

    @Test
    public void testCopyStyle() {
        try (MemoryStack stack = stackPush()) {
            YGValue v = YGValue.mallocStack(stack);

            YogaNode node0 = new YogaNode();
            assertTrue(YogaConstants.isUndefined(node0.getMaxHeight(v)));

            YogaNode node1 = new YogaNode();
            node1.setMaxHeight(100);

            node0.copyStyle(node1);
            assertEquals(100, (int)node0.getMaxHeight(v).value());
        }
    }

    @Test
    public void testLayoutMargin() {
        YogaNode node = new YogaNode();
        node.setWidth(100);
        node.setHeight(100);
        node.setMargin(YogaEdge.START, 1);
        node.setMargin(YogaEdge.END, 2);
        node.setMargin(YogaEdge.TOP, 3);
        node.setMargin(YogaEdge.BOTTOM, 4);
        node.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(1, (int)node.getLayoutMargin(YogaEdge.LEFT));
        assertEquals(2, (int)node.getLayoutMargin(YogaEdge.RIGHT));
        assertEquals(3, (int)node.getLayoutMargin(YogaEdge.TOP));
        assertEquals(4, (int)node.getLayoutMargin(YogaEdge.BOTTOM));
    }

    @Test
    public void testLayoutPadding() {
        YogaNode node = new YogaNode();
        node.setWidth(100);
        node.setHeight(100);
        node.setPadding(YogaEdge.START, 1);
        node.setPadding(YogaEdge.END, 2);
        node.setPadding(YogaEdge.TOP, 3);
        node.setPadding(YogaEdge.BOTTOM, 4);
        node.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(1, (int)node.getLayoutPadding(YogaEdge.LEFT));
        assertEquals(2, (int)node.getLayoutPadding(YogaEdge.RIGHT));
        assertEquals(3, (int)node.getLayoutPadding(YogaEdge.TOP));
        assertEquals(4, (int)node.getLayoutPadding(YogaEdge.BOTTOM));
    }

    @Test
    public void testLayoutBorder() {
        YogaNode node = new YogaNode();
        node.setWidth(100);
        node.setHeight(100);
        node.setBorder(YogaEdge.START, 1);
        node.setBorder(YogaEdge.END, 2);
        node.setBorder(YogaEdge.TOP, 3);
        node.setBorder(YogaEdge.BOTTOM, 4);
        node.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(1, (int)node.getLayoutBorder(YogaEdge.LEFT));
        assertEquals(2, (int)node.getLayoutBorder(YogaEdge.RIGHT));
        assertEquals(3, (int)node.getLayoutBorder(YogaEdge.TOP));
        assertEquals(4, (int)node.getLayoutBorder(YogaEdge.BOTTOM));
    }

    @Test
    public void testUseWebDefaults() {
        YogaConfig config = new YogaConfig();
        config.setUseWebDefaults(true);
        YogaNode node = new YogaNode(config);
        assertEquals(YogaFlexDirection.ROW.value, node.getFlexDirection());
    }

    @Test
    public void testPercentPaddingOnRoot() {
        YogaNode node = new YogaNode();
        node.setPaddingPercent(YogaEdge.ALL, 10);
        node.calculateLayout(50, 50);

        assertEquals(5, (int)node.getLayoutPadding(YogaEdge.LEFT));
        assertEquals(5, (int)node.getLayoutPadding(YogaEdge.RIGHT));
        assertEquals(5, (int)node.getLayoutPadding(YogaEdge.TOP));
        assertEquals(5, (int)node.getLayoutPadding(YogaEdge.BOTTOM));
    }

    @Test
    public void testDefaultEdgeValues() {
        YogaNode node = new YogaNode();

        try (MemoryStack stack = stackPush()) {
            YGValue v = YGValue.mallocStack(stack);

            for (YogaEdge edge : YogaEdge.values()) {
                assertEquals(YogaUnit.UNDEFINED, node.getMargin(edge, v).unit());
                assertEquals(YogaUnit.UNDEFINED, node.getPadding(edge, v).unit());
                assertEquals(YogaUnit.UNDEFINED, node.getPosition(edge, v).unit());
                assertTrue(YogaConstants.isUndefined(node.getBorder(edge)));
            }
        }
    }

    @Test
    public void testCloneNode() throws Exception {
        YogaConfig config     = new YogaConfig();
        YogaNode   root       = new YogaNode(config);
        YogaNode   child      = new YogaNode(config);
        YogaNode   grandChild = new YogaNode(config);
        root.addChildAt(child, 0);
        child.addChildAt(grandChild, 0);
        child.setFlexDirection(YogaFlexDirection.ROW);

        YogaNode clonedChild = child.clone();

        assertNotSame(clonedChild, child);

        assertEquals(YogaFlexDirection.ROW.value, child.getFlexDirection());
        assertEquals(child.getFlexDirection(), clonedChild.getFlexDirection());

        // Verify the cloning is shallow on the List of children
        assertEquals(1, child.getChildCount());
        assertEquals(child.getChildCount(), clonedChild.getChildCount());
        assertEquals(child.getChildAt(0), clonedChild.getChildAt(0));

        child.removeChildAt(0);
        assertEquals(0, child.getChildCount());
        assertEquals(1, clonedChild.getChildCount());
    }

    @Test
    public void testCloneWithNewChildren() throws Exception {
        YogaConfig config     = new YogaConfig();
        YogaNode   root       = new YogaNode(config);
        YogaNode   child      = new YogaNode(config);
        YogaNode   grandChild = new YogaNode(config);
        root.addChildAt(child, 0);
        child.addChildAt(grandChild, 0);
        child.setFlexDirection(YogaFlexDirection.ROW);

        YogaNode clonedChild = child.cloneWithNewChildren();

        assertNotSame(clonedChild, child);
        assertEquals(YogaFlexDirection.ROW.value, clonedChild.getFlexDirection());
        assertEquals(child.getFlexDirection(), clonedChild.getFlexDirection());
        assertEquals(0, clonedChild.getChildCount());
        assertEquals(1, child.getChildCount());
    }

    @Test
    public void testAddSharedChildCloneWithNewChildren() throws Exception {
        YogaConfig config     = new YogaConfig();
        YogaNode   root       = new YogaNode(config);
        YogaNode   child      = new YogaNode(config);
        YogaNode   grandChild = new YogaNode(config);
        root.addChildAt(child, 0);
        child.addChildAt(grandChild, 0);
        child.setFlexDirection(YogaFlexDirection.ROW);

        YogaNode clonedChild = child.cloneWithNewChildren();

        assertNotSame(clonedChild, child);
        assertEquals(YogaFlexDirection.ROW.value, clonedChild.getFlexDirection());
        assertEquals(child.getFlexDirection(), clonedChild.getFlexDirection());
        assertEquals(0, clonedChild.getChildCount());
        assertEquals(1, child.getChildCount());

        clonedChild.addSharedChildAt(grandChild, 0);
        assertEquals(1, clonedChild.getChildCount());
        assertNull(grandChild.getOwner());
    }

    @Test
    public void testCloneNodeListener() throws Exception {
        AtomicBoolean onNodeClonedExecuted = new AtomicBoolean(false);
        YogaConfig    config               = new YogaConfig();
        config.setOnCloneNode((oldNode, owner, childIndex) -> {
            onNodeClonedExecuted.set(true);
            return YGNodeClone(oldNode);
        });
        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setHeight(100f);
        YogaNode child0 = new YogaNode(config);
        root.addChildAt(child0, 0);
        child0.setWidth(50f);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        // Force a clone to happen.
        YogaNode root2 = root.clone();
        root2.setWidth(200f);
        root2.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertTrue(onNodeClonedExecuted.get());
        assertEquals(1, root2.getChildCount());
        YogaNode clonedNode = root2.getChildAt(0);
        assertNotSame(child0, clonedNode);
        try (MemoryStack stack = stackPush()) {
            YGValue v = YGValue.mallocStack(stack);

            assertEquals(child0.getWidth(v).value(), clonedNode.getWidth(v).value());
            assertEquals(50f, clonedNode.getWidth(v).value(), 0.01f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOnNodeClonedLeak() throws Exception {
        YogaConfig config = new YogaConfig();
        config.setOnCloneNode((oldNode, owner, childIndex) -> YGNodeClone(oldNode));
        config.setOnCloneNode(null);
        WeakReference<Object> ref = new WeakReference<>(config);
        // noinspection UnusedAssignment
        config = null;
        // try and free for the next 5 seconds, usually it works after the
        // first GC attempt.
        for (int i = 0; i < 50; i++) {
            System.gc();
            if (ref.get() == null) {
                // free successfully
                return;
            }
            Thread.sleep(100);
        }
        fail("YogaConfig leaked");
    }

    @Test
    public void testFlagShouldDiffLayoutWithoutLegacyStretchBehaviour() throws Exception {
        YogaConfig config = new YogaConfig();
        config.setShouldDiffLayoutWithoutLegacyStretchBehaviour(true);
        config.setUseLegacyStretchBehaviour(true);
        YogaNode root = new YogaNode(config);
        root.setWidth(500);
        root.setHeight(500);
        YogaNode root_child0 = new YogaNode(config);
        root_child0.setAlignItems(YogaAlign.FLEX_START);
        root.addChildAt(root_child0, 0);
        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setFlexGrow(1);
        root_child0_child0.setFlexShrink(1);
        root_child0.addChildAt(root_child0_child0, 0);
        YogaNode root_child0_child0_child0 = new YogaNode(config);
        root_child0_child0_child0.setFlexGrow(1);
        root_child0_child0_child0.setFlexShrink(1);
        root_child0_child0.addChildAt(root_child0_child0_child0, 0);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);
        assertFalse(root.getDoesLegacyStretchFlagAffectsLayout());
    }
}
