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

public class ModelMP5
extends ModelGun {
    public ModelMP5() {
        this.gunModel = new ModelRendererTurbo[6];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(-1.0f, 4.0f, -0.75f, 12.0f, 1.0f, 1.5f);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 3, 64, 16);
        this.gunModel[1].addBox(-1.0f, 3.0f, -1.0f, 12, 1, 2);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 6, 64, 16);
        this.gunModel[2].addBox(-1.0f, 2.0f, -1.0f, 6, 1, 2);
        this.gunModel[3] = new ModelRendererTurbo(this, 26, 0, 64, 16);
        this.gunModel[3].addBox(11.0f, 3.0f, -0.5f, 1, 1, 1);
        this.gunModel[5] = new ModelRendererTurbo(this, 26, 0, 64, 16);
        this.gunModel[5].addBox(10.0f, 5.0f, -0.5f, 1, 1, 1);
        this.gunModel[4] = new ModelRendererTurbo(this, 0, 9, 64, 16);
        this.gunModel[4].addBox(-0.75f, -3.0f, -0.75f, 1.5f, 4.0f, 1.5f);
        this.gunModel[4].func_78793_a(1.0f, 2.0f, 0.0f);
        this.gunModel[4].field_78808_h = -0.5f;
        this.ammoModel = new ModelRendererTurbo[2];
        this.ammoModel[0] = new ModelRendererTurbo(this, 8, 9, 64, 16);
        this.ammoModel[0].addShapeBox(3.5f, 0.0f, -0.5f, 1, 3, 1, 0.0f, -1.0f, 0.0f, 0.0f, 0.8f, -0.2f, 0.0f, 0.8f, -0.2f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.ammoModel[1] = new ModelRendererTurbo(this, 12, 9, 64, 16);
        this.ammoModel[1].addShapeBox(3.5f, -3.0f, -0.5f, 1, 3, 1, 0.0f, -2.5f, -1.0f, 0.0f, 2.0f, -1.5f, 0.0f, 2.0f, -1.5f, 0.0f, -2.5f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.8f, 0.2f, 0.0f, 0.8f, 0.2f, 0.0f, -1.0f, 0.0f, 0.0f);
        this.stockAttachPoint = new Vector3f(-0.0625f, 0.21875f, 0.0f);
        this.defaultStockModel = new ModelRendererTurbo[2];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 16, 6, 64, 16);
        this.defaultStockModel[0].addBox(-7.0f, 3.0f, -0.5f, 6, 1, 1);
        this.defaultStockModel[1] = new ModelRendererTurbo(this, 16, 8, 64, 16);
        this.defaultStockModel[1].addBox(-8.0f, 1.0f, -0.5f, 1, 3, 1);
        this.barrelAttachPoint = new Vector3f(0.75f, 0.21875f, 0.0f);
        this.scopeAttachPoint = new Vector3f(0.125f, 0.3125f, 0.0f);
        this.gunSlideDistance = 0.25f;
        this.animationType = EnumAnimationType.PISTOL_CLIP;
    }
}

