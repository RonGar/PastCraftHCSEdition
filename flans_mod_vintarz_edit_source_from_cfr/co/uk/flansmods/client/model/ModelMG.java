/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ieta
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import co.uk.flansmods.common.guns.EntityMG;
import net.minecraft.client.model.ModelBase;

public class ModelMG
extends ModelBase {
    public ModelRendererTurbo[] bipodModel;
    public ModelRendererTurbo[] gunModel;
    public ModelRendererTurbo[] ammoModel;

    public void renderBipod(float f, float f2, float f3, float f4, float f5, float f6, EntityMG entityMG) {
        for (ModelRendererTurbo modelRendererTurbo : this.bipodModel) {
            modelRendererTurbo.func_78785_a(f6);
        }
    }

    public void renderGun(float f, float f2, float f3, float f4, float f5, float f6, float f7, EntityMG entityMG) {
        for (ModelRendererTurbo modelRendererTurbo : this.gunModel) {
            modelRendererTurbo.field_78795_f = -(entityMG.field_70127_C + (entityMG.field_70125_A - entityMG.field_70127_C) * f7) / 180.0f * 3.1415927f;
            modelRendererTurbo.func_78785_a(f6);
        }
        if (entityMG.reloadTimer <= 0 && entityMG.ammo != null) {
            for (ModelRendererTurbo modelRendererTurbo : this.ammoModel) {
                modelRendererTurbo.field_78795_f = -(entityMG.field_70127_C + (entityMG.field_70125_A - entityMG.field_70127_C) * f7) / 180.0f * 3.1415927f;
                modelRendererTurbo.func_78785_a(f6);
            }
        }
    }

    public void flipAll() {
        int n;
        for (n = 0; n < this.bipodModel.length; ++n) {
            this.bipodModel[n].doMirror(false, true, true);
            this.bipodModel[n].func_78793_a(this.bipodModel[n].field_78800_c, -this.bipodModel[n].field_78797_d, -this.bipodModel[n].field_78798_e);
        }
        for (n = 0; n < this.gunModel.length; ++n) {
            this.gunModel[n].doMirror(false, true, true);
            this.gunModel[n].func_78793_a(this.gunModel[n].field_78800_c, -this.gunModel[n].field_78797_d, -this.gunModel[n].field_78798_e);
        }
        for (n = 0; n < this.ammoModel.length; ++n) {
            this.ammoModel[n].doMirror(false, true, true);
            this.ammoModel[n].func_78793_a(this.ammoModel[n].field_78800_c, -this.ammoModel[n].field_78797_d, -this.ammoModel[n].field_78798_e);
        }
    }
}

