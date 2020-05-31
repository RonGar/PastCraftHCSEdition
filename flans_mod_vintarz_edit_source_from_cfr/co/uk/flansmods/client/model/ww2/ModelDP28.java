/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.client.model.ww2;

import co.uk.flansmods.client.model.ModelMG;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelDP28
extends ModelMG {
    public ModelDP28() {
        this.bipodModel = new ModelRendererTurbo[2];
        this.bipodModel[0] = new ModelRendererTurbo(this, 0, 0);
        this.bipodModel[0].addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.bipodModel[0].field_78808_h = 0.7853982f;
        this.bipodModel[0].func_78793_a(5.66f, 0.0f, 0.0f);
        this.bipodModel[1] = new ModelRendererTurbo(this, 0, 0);
        this.bipodModel[1].addBox(-1.0f, 0.0f, 0.0f, 1, 8, 1);
        this.bipodModel[1].field_78808_h = -0.7853982f;
        this.bipodModel[1].func_78793_a(-5.66f, 0.0f, 0.0f);
        this.gunModel = new ModelRendererTurbo[3];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0);
        this.gunModel[0].addBox(-1.0f, -1.0f, -2.0f, 2, 2, 16);
        this.gunModel[0].func_78793_a(0.0f, 6.0f, 0.0f);
        this.gunModel[1] = new ModelRendererTurbo(this, 4, 0);
        this.gunModel[1].addBox(-1.0f, -2.0f, 14.0f, 2, 3, 2);
        this.gunModel[1].func_78793_a(0.0f, 6.0f, 0.0f);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 18);
        this.gunModel[2].addBox(-0.5f, -0.5f, -8.0f, 1, 1, 6);
        this.gunModel[2].func_78793_a(0.0f, 6.0f, 0.0f);
        this.ammoModel = new ModelRendererTurbo[1];
        this.ammoModel[0] = new ModelRendererTurbo(this, 20, 0);
        this.ammoModel[0].addBox(-3.0f, 1.0f, 1.0f, 6, 1, 6);
        this.ammoModel[0].func_78793_a(0.0f, 6.0f, 0.0f);
    }
}

