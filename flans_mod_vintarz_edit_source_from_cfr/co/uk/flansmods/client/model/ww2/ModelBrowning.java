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

public class ModelBrowning
extends ModelMG {
    public ModelBrowning() {
        this.bipodModel = new ModelRendererTurbo[3];
        this.bipodModel[0] = new ModelRendererTurbo(this, 0, 0);
        this.bipodModel[0].addBox(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.bipodModel[0].field_78808_h = 0.9853982f;
        this.bipodModel[0].field_78795_f = -0.7853982f;
        this.bipodModel[0].func_78793_a(5.66f, 0.0f, 8.0f);
        this.bipodModel[1] = new ModelRendererTurbo(this, 0, 0);
        this.bipodModel[1].addBox(-1.0f, 0.0f, 0.0f, 1, 10, 1);
        this.bipodModel[1].field_78808_h = -0.9853982f;
        this.bipodModel[1].field_78795_f = -0.7853982f;
        this.bipodModel[1].func_78793_a(-5.66f, 0.0f, 8.0f);
        this.bipodModel[2] = new ModelRendererTurbo(this, 0, 0);
        this.bipodModel[2].addBox(-1.0f, 0.0f, 0.0f, 1, 10, 1);
        this.bipodModel[2].field_78795_f = 1.0471976f;
        this.bipodModel[2].func_78793_a(0.0f, 0.0f, -8.0f);
        this.gunModel = new ModelRendererTurbo[3];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0);
        this.gunModel[0].addBox(-1.5f, -1.5f, -4.0f, 3, 3, 12);
        this.gunModel[0].func_78793_a(0.0f, 6.0f, 0.0f);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 15);
        this.gunModel[1].addBox(-0.5f, -0.5f, -12.0f, 1, 1, 10);
        this.gunModel[1].func_78793_a(0.0f, 6.0f, 0.0f);
        this.gunModel[2] = new ModelRendererTurbo(this, 4, 0);
        this.gunModel[2].addBox(-1.0f, -3.0f, 8.0f, 2, 3, 2);
        this.gunModel[2].func_78793_a(0.0f, 6.0f, 0.0f);
        this.ammoModel = new ModelRendererTurbo[1];
        this.ammoModel[0] = new ModelRendererTurbo(this, 18, 0);
        this.ammoModel[0].addBox(-6.0f, -3.0f, -2.0f, 5, 4, 2);
        this.ammoModel[0].func_78793_a(0.0f, 6.0f, 0.0f);
    }
}

