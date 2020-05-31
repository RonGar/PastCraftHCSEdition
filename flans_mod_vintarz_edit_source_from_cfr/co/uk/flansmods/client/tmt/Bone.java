/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.client.tmt;

import co.uk.flansmods.client.tmt.Angle3D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.dwbg;
import net.minecraft.util.samw;

public class Bone {
    protected Angle3D neutralAngles;
    public Angle3D relativeAngles;
    protected Angle3D absoluteAngles;
    private samw positionVector;
    private float length;
    private Bone parentNode;
    protected ArrayList<Bone> childNodes;
    private ArrayList<ModelRenderer> models;
    private Map<ModelRenderer, Angle3D> modelBaseRot;
    private float offsetX;
    private float offsetY;
    private float offsetZ;

    public Bone(float f, float f2, float f3, float f4) {
        this.neutralAngles = new Angle3D(f, f2, f3);
        this.relativeAngles = new Angle3D(0.0f, 0.0f, 0.0f);
        this.absoluteAngles = new Angle3D(0.0f, 0.0f, 0.0f);
        this.positionVector = samw._a((double)0.0, (double)0.0, (double)0.0);
        this.length = f4;
        this.childNodes = new ArrayList();
        this.models = new ArrayList();
        this.modelBaseRot = new HashMap<ModelRenderer, Angle3D>();
        this.parentNode = null;
        this.offsetX = 0.0f;
        this.offsetY = 0.0f;
        this.offsetZ = 0.0f;
        this.positionVector = samw._a((double)0.0, (double)0.0, (double)0.0);
    }

    public Bone(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this(f4, f5, f6, f7);
        this.positionVector = this.setOffset(f, f2, f3);
    }

    public Bone(float f, float f2, float f3, float f4, Bone bone) {
        this(f, f2, f3, f4);
        this.attachBone(bone);
    }

    public void detachBone() {
        this.parentNode.childNodes.remove(this);
        this.parentNode = null;
    }

    public void attachBone(Bone bone) {
        if (this.parentNode != null) {
            this.detachBone();
        }
        this.parentNode = bone;
        bone.addChildBone(this);
        this.offsetX = bone.offsetX;
        this.offsetY = bone.offsetY;
        this.offsetZ = bone.offsetZ;
        this.resetOffset();
    }

    public samw setOffset(float f, float f2, float f3) {
        if (this.parentNode != null) {
            samw samw2 = this.parentNode.setOffset(f, f2, f3);
            this.offsetX = (float)samw2._c;
            this.offsetY = (float)samw2._d;
            this.offsetZ = (float)samw2._e;
            return samw2;
        }
        this.offsetX = f;
        this.offsetY = f2;
        this.offsetZ = f3;
        this.resetOffset(true);
        return samw._a((double)f, (double)f2, (double)f3);
    }

    public void resetOffset() {
        this.resetOffset(false);
    }

    public void resetOffset(boolean bl) {
        if (this.parentNode != null) {
            this.positionVector = samw._a((double)0.0, (double)0.0, (double)this.parentNode.length);
            this.parentNode.setVectorRotations(this.positionVector);
            this.positionVector._c += this.parentNode.positionVector._c;
            this.positionVector._d += this.parentNode.positionVector._d;
            this.positionVector._e += this.parentNode.positionVector._e;
        }
        if (bl && !this.childNodes.isEmpty()) {
            for (int i = 0; i < this.childNodes.size(); ++i) {
                this.childNodes.get(i).resetOffset(bl);
            }
        }
    }

    public void setNeutralRotation(float f, float f2, float f3) {
        this.neutralAngles.angleX = f;
        this.neutralAngles.angleY = f2;
        this.neutralAngles.angleZ = f3;
    }

    public Bone getRootParent() {
        if (this.parentNode == null) {
            return this;
        }
        return this.parentNode.getRootParent();
    }

    public void addModel(ModelRenderer modelRenderer) {
        this.addModel(modelRenderer, false);
    }

    public void addModel(ModelRenderer modelRenderer, boolean bl) {
        this.addModel(modelRenderer, 0.0f, 0.0f, 0.0f, bl);
    }

    public void addModel(ModelRenderer modelRenderer, boolean bl, boolean bl2) {
        this.addModel(modelRenderer, 0.0f, 0.0f, 0.0f, bl, bl2);
    }

    public void addModel(ModelRenderer modelRenderer, float f, float f2, float f3) {
        this.addModel(modelRenderer, f, f2, f3, false);
    }

    public void addModel(ModelRenderer modelRenderer, float f, float f2, float f3, boolean bl) {
        this.addModel(modelRenderer, f, f2, f3, bl, false);
    }

    public void addModel(ModelRenderer modelRenderer, float f, float f2, float f3, boolean bl, boolean bl2) {
        if (bl) {
            f += this.neutralAngles.angleX + (bl2 ? 1.5707964f : 0.0f);
            f2 += this.neutralAngles.angleY;
            f3 += this.neutralAngles.angleZ;
        }
        this.models.add(modelRenderer);
        this.modelBaseRot.put(modelRenderer, new Angle3D(f, f2, f3));
    }

    public void removeModel(ModelRenderer modelRenderer) {
        this.models.remove((Object)modelRenderer);
        this.modelBaseRot.remove((Object)modelRenderer);
    }

    public Angle3D getAbsoluteAngle() {
        return new Angle3D(this.absoluteAngles.angleX, this.absoluteAngles.angleY, this.absoluteAngles.angleZ);
    }

    public samw getPosition() {
        return samw._a((double)this.positionVector._c, (double)this.positionVector._d, (double)this.positionVector._e);
    }

    protected void addChildBone(Bone bone) {
        this.childNodes.add(bone);
    }

    public void prepareDraw() {
        if (this.parentNode != null) {
            this.parentNode.prepareDraw();
        } else {
            this.setAbsoluteRotations();
            this.setVectors();
        }
    }

    public void setRotations(float f, float f2, float f3) {
        this.relativeAngles.angleX = f;
        this.relativeAngles.angleY = f2;
        this.relativeAngles.angleZ = f3;
    }

    protected void setAbsoluteRotations() {
        this.absoluteAngles.angleX = this.relativeAngles.angleX;
        this.absoluteAngles.angleY = this.relativeAngles.angleY;
        this.absoluteAngles.angleZ = this.relativeAngles.angleZ;
        for (int i = 0; i < this.childNodes.size(); ++i) {
            this.childNodes.get(i).setAbsoluteRotations(this.absoluteAngles.angleX, this.absoluteAngles.angleY, this.absoluteAngles.angleZ);
        }
    }

    protected void setAbsoluteRotations(float f, float f2, float f3) {
        this.absoluteAngles.angleX = this.relativeAngles.angleX + f;
        this.absoluteAngles.angleY = this.relativeAngles.angleY + f2;
        this.absoluteAngles.angleZ = this.relativeAngles.angleZ + f3;
        for (int i = 0; i < this.childNodes.size(); ++i) {
            this.childNodes.get(i).setAbsoluteRotations(this.absoluteAngles.angleX, this.absoluteAngles.angleY, this.absoluteAngles.angleZ);
        }
    }

    protected void setVectorRotations(samw samw2) {
        float f = this.neutralAngles.angleX + this.absoluteAngles.angleX;
        float f2 = this.neutralAngles.angleY + this.absoluteAngles.angleY;
        float f3 = this.neutralAngles.angleZ + this.absoluteAngles.angleZ;
        this.setVectorRotations(samw2, f, f2, f3);
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

    protected void addVector(samw samw2, samw samw3) {
        samw2._c += samw3._c;
        samw2._d += samw3._d;
        samw2._e += samw3._e;
    }

    protected void setVectors() {
        samw samw2 = samw._a((double)0.0, (double)0.0, (double)this.length);
        this.positionVector = samw._a((double)this.offsetX, (double)this.offsetY, (double)this.offsetZ);
        this.addVector(samw2, this.positionVector);
        this.setVectorRotations(samw2);
        for (int i = 0; i < this.childNodes.size(); ++i) {
            this.childNodes.get(i).setVectors(samw2);
        }
    }

    protected void setVectors(samw samw2) {
        this.positionVector = samw2;
        samw samw3 = samw._a((double)0.0, (double)0.0, (double)this.length);
        this.setVectorRotations(samw3);
        this.addVector(samw3, samw2);
        for (int i = 0; i < this.childNodes.size(); ++i) {
            this.childNodes.get(i).setVectors(samw3);
        }
    }

    public void setAnglesToModels() {
        int n;
        for (n = 0; n < this.models.size(); ++n) {
            ModelRenderer modelRenderer = this.models.get(n);
            Angle3D angle3D = this.modelBaseRot.get((Object)modelRenderer);
            modelRenderer.field_78795_f = angle3D.angleX + this.absoluteAngles.angleX;
            modelRenderer.field_78796_g = angle3D.angleY + this.absoluteAngles.angleY;
            modelRenderer.field_78808_h = angle3D.angleZ + this.absoluteAngles.angleZ;
            modelRenderer.field_78800_c = (float)this.positionVector._c;
            modelRenderer.field_78797_d = (float)this.positionVector._d;
            modelRenderer.field_78798_e = (float)this.positionVector._e;
        }
        for (n = 0; n < this.childNodes.size(); ++n) {
            this.childNodes.get(n).setAnglesToModels();
        }
    }
}

