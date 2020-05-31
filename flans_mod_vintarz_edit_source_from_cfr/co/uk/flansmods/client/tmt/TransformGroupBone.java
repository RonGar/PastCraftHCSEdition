/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.client.tmt;

import co.uk.flansmods.client.tmt.Angle3D;
import co.uk.flansmods.client.tmt.Bone;
import co.uk.flansmods.client.tmt.PositionTransformVertex;
import co.uk.flansmods.client.tmt.TransformGroup;
import net.minecraft.util.dwbg;
import net.minecraft.util.samw;

public class TransformGroupBone
extends TransformGroup {
    protected Angle3D baseAngles;
    protected samw baseVector;
    protected Bone attachedBone;
    protected double weight;

    public TransformGroupBone(Bone bone, double d) {
        this.baseVector = bone.getPosition();
        this.baseAngles = bone.getAbsoluteAngle();
        this.attachedBone = bone;
        this.weight = d;
    }

    public Angle3D getBaseAngles() {
        return this.baseAngles.copy();
    }

    public Angle3D getTransformAngle() {
        Angle3D angle3D = this.attachedBone.getAbsoluteAngle().copy();
        angle3D.angleX -= this.baseAngles.angleX;
        angle3D.angleY -= this.baseAngles.angleY;
        angle3D.angleZ -= this.baseAngles.angleZ;
        return angle3D;
    }

    public samw getBaseVector() {
        return samw._a((double)this.baseVector._c, (double)this.baseVector._d, (double)this.baseVector._e);
    }

    public samw getTransformVector() {
        return this.baseVector._a(this.attachedBone.getPosition());
    }

    public samw getCurrentVector() {
        return this.attachedBone.getPosition();
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    public void attachBone(Bone bone) {
        this.baseVector = bone.getPosition();
        this.baseAngles = bone.getAbsoluteAngle();
        this.attachedBone = bone;
    }

    @Override
    public samw doTransformation(PositionTransformVertex positionTransformVertex) {
        samw samw2 = samw._a((double)positionTransformVertex.neutralVector._c, (double)positionTransformVertex.neutralVector._d, (double)positionTransformVertex.neutralVector._e);
        samw2 = this.getBaseVector()._a(samw2);
        Angle3D angle3D = this.getTransformAngle();
        this.setVectorRotations(samw2, angle3D.angleX, angle3D.angleY, angle3D.angleZ);
        return samw2;
    }

    protected void setVectorRotations(samw samw2, float f, float f2, float f3) {
        float f4 = dwbg._b((float)f);
        float f5 = dwbg._a((float)f);
        float f6 = dwbg._b((float)f2);
        float f7 = dwbg._a((float)f2);
        float f8 = dwbg._b((float)f3);
        float f9 = dwbg._a((float)f3);
        double d = samw2._c;
        double d2 = samw2._d;
        double d3 = samw2._e;
        double d4 = (double)f4 * d2 - (double)f5 * d3;
        double d5 = (double)f4 * d3 + (double)f5 * d2;
        double d6 = (double)f6 * d5 - (double)f7 * d;
        double d7 = (double)f6 * d + (double)f7 * d5;
        double d8 = (double)f8 * d7 - (double)f9 * d4;
        double d9 = (double)f8 * d4 + (double)f9 * d7;
        d = d8;
        d2 = d9;
        d3 = d6;
        samw2._c = d;
        samw2._d = d2;
        samw2._e = d3;
    }
}

