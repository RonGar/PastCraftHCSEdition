/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.PositionTextureVertex
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.client.tmt;

import net.minecraft.util.samw;

public class PositionTextureVertex
extends net.minecraft.client.model.PositionTextureVertex {
    public float texturePositionW = 1.0f;

    public PositionTextureVertex(float f, float f2, float f3, float f4, float f5) {
        this(f, f2, f3, f4, f5, 1.0f);
    }

    public PositionTextureVertex(float f, float f2, float f3, float f4, float f5, float f6) {
        this(samw._a((double)f, (double)f2, (double)f3), f4, f5);
    }

    public PositionTextureVertex setTexturePosition(float f, float f2) {
        return new PositionTextureVertex(this, f, f2, 1.0f);
    }

    public PositionTextureVertex setTexturePosition(float f, float f2, float f3) {
        return new PositionTextureVertex(this, f, f2, f3);
    }

    public PositionTextureVertex(PositionTextureVertex positionTextureVertex, float f, float f2) {
        this(positionTextureVertex, f, f2, 1.0f);
    }

    public PositionTextureVertex(PositionTextureVertex positionTextureVertex, float f, float f2, float f3) {
        super((net.minecraft.client.model.PositionTextureVertex)positionTextureVertex, f, f2);
        this.texturePositionW = f3;
    }

    public PositionTextureVertex(samw samw2, float f, float f2) {
        this(samw2, f, f2, 1.0f);
    }

    public PositionTextureVertex(samw samw2, float f, float f2, float f3) {
        super(samw2, f, f2);
        this.texturePositionW = f3;
    }

    public /* synthetic */ net.minecraft.client.model.PositionTextureVertex func_78240_a(float f, float f2) {
        return this.setTexturePosition(f, f2);
    }
}

