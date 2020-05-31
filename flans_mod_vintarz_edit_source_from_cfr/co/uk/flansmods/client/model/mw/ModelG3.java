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

public class ModelG3
extends ModelGun {
    public ModelG3() {
        this.gunModel = new ModelRendererTurbo[8];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(-1.0f, 3.0f, -1.0f, 8, 2, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 4, 64, 16);
        this.gunModel[1].addBox(0.0f, 2.0f, -1.0f, 6, 1, 2);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 7, 64, 16);
        this.gunModel[2].addBox(7.0f, 3.0f, -1.0f, 8.0f, 1.5f, 2.0f);
        this.gunModel[3] = new ModelRendererTurbo(this, 0, 11, 64, 16);
        this.gunModel[3].addBox(7.0f, 4.5f, -0.5f, 8.0f, 0.5f, 1.0f);
        this.gunModel[4] = new ModelRendererTurbo(this, 0, 13, 64, 16);
        this.gunModel[4].addBox(15.0f, 3.375f, -0.375f, 2.0f, 0.75f, 0.75f);
        this.gunModel[5] = new ModelRendererTurbo(this, 6, 13, 64, 16);
        this.gunModel[5].addBox(17.0f, 3.25f, -0.5f, 1, 1, 1);
        this.gunModel[6] = new ModelRendererTurbo(this, 20, 0, 64, 16);
        this.gunModel[6].addBox(-0.75f, -3.0f, -0.75f, 1.5f, 4.0f, 1.5f);
        this.gunModel[6].func_78793_a(1.0f, 2.0f, 0.0f);
        this.gunModel[6].field_78808_h = -0.5f;
        this.gunModel[7] = new ModelRendererTurbo(this, 16, 5, 64, 16);
        this.gunModel[7].addBox(14.0f, 5.0f, -0.5f, 1, 1, 1);
        this.scopeAttachPoint = new Vector3f(0.25f, 0.3125f, 0.0f);
        this.defaultStockModel = new ModelRendererTurbo[3];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 10, 13, 64, 16);
        this.defaultStockModel[0].addBox(-8.0f, 2.0f, -0.5f, 1, 2, 1);
        this.defaultStockModel[1] = new ModelRendererTurbo(this, 20, 6, 64, 16);
        this.defaultStockModel[1].addShapeBox(-7.0f, 2.0f, -0.5f, 5, 2, 1, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.defaultStockModel[2] = new ModelRendererTurbo(this, 20, 9, 64, 16);
        this.defaultStockModel[2].addShapeBox(-2.0f, 3.0f, -1.0f, 1, 2, 2, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, -1.0f, -0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, -0.5f);
        this.stockAttachPoint = new Vector3f(-0.25f, 0.21875f, 0.0f);
        this.barrelAttachPoint = new Vector3f(1.125f, 0.234375f, 0.0f);
        this.gripAttachPoint = new Vector3f(0.625f, 0.1875f, 0.0f);
        this.ammoModel = new ModelRendererTurbo[1];
        this.ammoModel[0] = new ModelRendererTurbo(this, 26, 9, 64, 16);
        this.ammoModel[0].addBox(3.5f, -1.0f, -0.75f, 2.0f, 4.0f, 1.5f);
        this.gunSlideDistance = 0.5f;
        this.animationType = EnumAnimationType.BOTTOM_CLIP;
    }
}

