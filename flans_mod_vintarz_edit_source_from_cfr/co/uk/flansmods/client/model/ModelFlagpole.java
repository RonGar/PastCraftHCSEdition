/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.common.teams.EntityFlag;
import co.uk.flansmods.common.teams.EntityFlagpole;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelFlagpole
extends ModelBase {
    public ModelRenderer[] poleModel = new ModelRenderer[3];
    public ModelRenderer[] flagModel;

    public ModelFlagpole() {
        this.poleModel[0] = new ModelRenderer((ModelBase)this, 0, 16);
        this.poleModel[1] = new ModelRenderer((ModelBase)this, 0, 16);
        this.poleModel[2] = new ModelRenderer((ModelBase)this, 0, 20);
        this.poleModel[0].func_78790_a(-48.0f, -1.0f, -1.0f, 24, 2, 2, 0.0f);
        this.poleModel[1].func_78790_a(-24.0f, -1.0f, -1.0f, 24, 2, 2, 0.0f);
        this.poleModel[2].func_78790_a(-2.0f, -2.0f, -2.0f, 4, 2, 4, 0.0f);
        this.poleModel[0].field_78808_h = 1.5707964f;
        this.poleModel[1].field_78808_h = 1.5707964f;
        this.flagModel = new ModelRenderer[1];
        this.flagModel[0] = new ModelRenderer((ModelBase)this, 0, 0);
        this.flagModel[0].func_78790_a(-8.0f, -16.0f, 0.0f, 16, 16, 0, 0.0f);
        this.flagModel[0].func_78793_a(8.0f, 0.0f, 0.0f);
    }

    public void renderPole(float f, float f2, float f3, float f4, float f5, float f6, EntityFlagpole entityFlagpole) {
        for (ModelRenderer modelRenderer : this.poleModel) {
            modelRenderer.func_78785_a(f6);
        }
    }

    public void renderFlag(float f, float f2, float f3, float f4, float f5, float f6, EntityFlag entityFlag) {
        for (ModelRenderer modelRenderer : this.flagModel) {
            modelRenderer.func_78785_a(f6);
        }
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
    }
}

