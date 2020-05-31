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

public class ModelG36
extends ModelGun {
    public ModelG36() {
        this.gunModel = new ModelRendererTurbo[7];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(-1.0f, 2.0f, -1.0f, 15, 2, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 4, 64, 16);
        this.gunModel[1].addBox(1.0f, 4.0f, -1.0f, 5.0f, 0.5f, 2.0f);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 7, 64, 16);
        this.gunModel[2].addBox(2.0f, 4.5f, -1.0f, 9.0f, 0.5f, 2.0f);
        this.gunModel[3] = new ModelRendererTurbo(this, 14, 4, 64, 16);
        this.gunModel[3].addBox(10.0f, 4.0f, -1.0f, 2.0f, 0.5f, 2.0f);
        this.gunModel[4] = new ModelRendererTurbo(this, 32, 0, 64, 16);
        this.gunModel[4].addBox(14.0f, 2.5f, -0.5f, 1, 1, 1);
        this.gunModel[5] = new ModelRendererTurbo(this, 22, 4, 64, 16);
        this.gunModel[5].addBox(1.0f, 1.0f, -1.0f, 6, 1, 2);
        this.gunModel[6] = new ModelRendererTurbo(this, 0, 10, 64, 16);
        this.gunModel[6].addBox(-0.5f, -2.0f, -0.5f, 1, 3, 1);
        this.gunModel[6].func_78793_a(2.0f, 1.0f, 0.0f);
        this.gunModel[6].field_78808_h = -0.5f;
        this.scopeAttachPoint = new Vector3f(0.25f, 0.3125f, 0.0f);
        this.defaultStockModel = new ModelRendererTurbo[5];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 4, 10, 64, 16);
        this.defaultStockModel[0].addBox(-7.0f, 1.0f, -0.5f, 1, 3, 1);
        this.defaultStockModel[1] = new ModelRendererTurbo(this, 0, 14, 64, 16);
        this.defaultStockModel[1].addBox(-6.0f, 1.5f, -0.5f, 2.0f, 0.5f, 1.0f);
        this.defaultStockModel[2] = new ModelRendererTurbo(this, 6, 14, 64, 16);
        this.defaultStockModel[2].addBox(-4.0f, 2.0f, -0.5f, 3.0f, 0.5f, 1.0f);
        this.defaultStockModel[3] = new ModelRendererTurbo(this, 14, 14, 64, 16);
        this.defaultStockModel[3].addBox(-6.0f, 3.5f, -0.5f, 5.0f, 0.5f, 1.0f);
        this.defaultStockModel[4] = new ModelRendererTurbo(this, 26, 14, 64, 16);
        this.defaultStockModel[4].addBox(-3.0f, 2.5f, -0.5f, 1, 1, 1);
        this.stockAttachPoint = new Vector3f(-0.25f, 0.21875f, 0.0f);
        this.barrelAttachPoint = new Vector3f(0.9375f, 0.1875f, 0.0f);
        this.defaultGripModel = new ModelRendererTurbo[2];
        this.defaultGripModel[0] = new ModelRendererTurbo(this, 8, 10, 64, 16);
        this.defaultGripModel[0].addBox(11.0f, 1.0f, -1.0f, 2, 1, 2);
        this.defaultGripModel[1] = new ModelRendererTurbo(this, 16, 10, 64, 16);
        this.defaultGripModel[1].addBox(11.5f, -1.0f, -0.5f, 1, 2, 1);
        this.gripAttachPoint = new Vector3f(0.625f, 0.1875f, 0.0f);
        this.ammoModel = new ModelRendererTurbo[1];
        this.ammoModel[0] = new ModelRendererTurbo(this, 22, 7, 64, 16);
        this.ammoModel[0].addBox(-1.0f, -4.0f, -0.5f, 2, 5, 1);
        this.ammoModel[0].func_78793_a(6.0f, 1.0f, 0.0f);
        this.ammoModel[0].field_78808_h = 0.25f;
        this.gunSlideDistance = 0.5f;
        this.animationType = EnumAnimationType.BOTTOM_CLIP;
    }
}

