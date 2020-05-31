/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.client.tmt;

import co.uk.flansmods.client.tmt.PositionTransformVertex;
import net.minecraft.util.samw;

public abstract class TransformGroup {
    public abstract double getWeight();

    public abstract samw doTransformation(PositionTransformVertex var1);
}

