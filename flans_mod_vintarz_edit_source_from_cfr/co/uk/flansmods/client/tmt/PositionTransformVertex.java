/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.client.tmt;

import co.uk.flansmods.client.tmt.PositionTextureVertex;
import co.uk.flansmods.client.tmt.TransformGroup;
import java.util.ArrayList;
import net.minecraft.util.samw;

public class PositionTransformVertex
extends PositionTextureVertex {
    public samw neutralVector;
    public ArrayList<TransformGroup> transformGroups = new ArrayList();

    public PositionTransformVertex(float f, float f2, float f3, float f4, float f5) {
        this(samw._a((double)f, (double)f2, (double)f3), f4, f5);
    }

    public PositionTransformVertex(PositionTextureVertex positionTextureVertex, float f, float f2) {
        super(positionTextureVertex, f, f2);
        this.neutralVector = positionTextureVertex instanceof PositionTransformVertex ? ((PositionTransformVertex)positionTextureVertex).neutralVector : samw._a((double)positionTextureVertex.field_78243_a._c, (double)positionTextureVertex.field_78243_a._d, (double)positionTextureVertex.field_78243_a._e);
    }

    public PositionTransformVertex(PositionTextureVertex positionTextureVertex) {
        this(positionTextureVertex, positionTextureVertex.field_78241_b, positionTextureVertex.field_78242_c);
    }

    public PositionTransformVertex(samw samw2, float f, float f2) {
        super(samw2, f, f2);
        this.neutralVector = samw._a((double)samw2._c, (double)samw2._d, (double)samw2._e);
    }

    public void setTransformation() {
        int n;
        if (this.transformGroups.size() == 0) {
            this.field_78243_a._c = this.neutralVector._c;
            this.field_78243_a._d = this.neutralVector._d;
            this.field_78243_a._e = this.neutralVector._e;
            return;
        }
        double d = 0.0;
        for (n = 0; n < this.transformGroups.size(); ++n) {
            d += this.transformGroups.get(n).getWeight();
        }
        this.field_78243_a._c = 0.0;
        this.field_78243_a._d = 0.0;
        this.field_78243_a._e = 0.0;
        for (n = 0; n < this.transformGroups.size(); ++n) {
            TransformGroup transformGroup = this.transformGroups.get(n);
            double d2 = transformGroup.getWeight() / d;
            samw samw2 = transformGroup.doTransformation(this);
            this.field_78243_a._c += d2 * samw2._c;
            this.field_78243_a._d += d2 * samw2._d;
            this.field_78243_a._e += d2 * samw2._e;
        }
    }

    public void addGroup(TransformGroup transformGroup) {
        this.transformGroups.add(transformGroup);
    }

    public void removeGroup(TransformGroup transformGroup) {
        this.transformGroups.remove(transformGroup);
    }
}

