/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.client.model.mw;

import co.uk.flansmods.client.model.EnumAnimationType;
import co.uk.flansmods.client.model.ModelGun;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import co.uk.flansmods.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelSkorpion
extends ModelGun {
    public ModelSkorpion() {
        this.gunModel = new ModelRendererTurbo[5];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 32, 16);
        this.gunModel[0].addBox(-1.0f, 3.0f, -1.0f, 8, 2, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 4, 32, 16);
        this.gunModel[1].addShapeBox(-1.0f, 2.0f, -1.0f, 7, 1, 2, 0.0f, 0.0f, 0.0f, 0.0f, -4.0f, 0.0f, 0.0f, -4.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 8, 32, 16);
        this.gunModel[2].addBox(-1.0f, -1.0f, -1.0f, 2, 3, 2);
        this.gunModel[3] = new ModelRendererTurbo(this, 0, 14, 32, 16);
        this.gunModel[3].addBox(7.0f, 3.25f, -0.5f, 1, 1, 1);
        this.gunModel[4] = new ModelRendererTurbo(this, 4, 14, 32, 16);
        this.gunModel[4].addBox(8.0f, 3.5f, -0.25f, 2.0f, 0.5f, 0.5f);
        this.ammoModel = new ModelRendererTurbo[1];
        this.ammoModel[0] = new ModelRendererTurbo(this, 8, 8, 32, 16);
        this.ammoModel[0].addBox(-1.0f, -3.0f, -0.75f, 2.0f, 4.0f, 1.5f);
        this.ammoModel[0].func_78793_a(4.0f, 2.0f, 0.0f);
        this.ammoModel[0].field_78808_h = 0.5f;
        this.barrelAttachPoint = new Vector3f(0.5f, 0.234375f, 0.0f);
        this.scopeAttachPoint = new Vector3f(0.1875f, 0.3125f, 0.0f);
        this.gunSlideDistance = 0.25f;
        this.animationType = EnumAnimationType.BOTTOM_CLIP;
    }
}

