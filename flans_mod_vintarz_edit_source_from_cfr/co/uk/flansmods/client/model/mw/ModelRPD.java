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

public class ModelRPD
extends ModelGun {
    public ModelRPD() {
        this.gunModel = new ModelRendererTurbo[8];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(-1.0f, 3.0f, -1.0f, 8, 2, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 20, 0, 64, 16);
        this.gunModel[1].addShapeBox(7.0f, 3.0f, -1.0f, 2, 2, 2, 0.0f, 0.0f, 0.2f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2f, 0.0f, 0.0f, 0.2f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2f, 0.0f);
        this.gunModel[2] = new ModelRendererTurbo(this, 28, 0, 64, 16);
        this.gunModel[2].addShapeBox(9.0f, 3.0f, -1.0f, 2, 2, 2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2f, 0.0f, 0.0f, 0.2f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2f, 0.0f, 0.0f, 0.2f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.gunModel[3] = new ModelRendererTurbo(this, 0, 4, 64, 16);
        this.gunModel[3].addBox(11.0f, 4.1f, -0.4f, 8.0f, 0.8f, 0.8f);
        this.gunModel[4] = new ModelRendererTurbo(this, 18, 4, 64, 16);
        this.gunModel[4].addBox(11.0f, 3.1f, -0.4f, 3.0f, 0.8f, 0.8f);
        this.gunModel[5] = new ModelRendererTurbo(this, 36, 0, 64, 16);
        this.gunModel[5].addBox(12.5f, 3.0f, -0.5f, 1, 2, 1);
        this.gunModel[6] = new ModelRendererTurbo(this, 40, 0, 64, 16);
        this.gunModel[6].addBox(17.5f, 4.0f, -0.5f, 1, 2, 1);
        this.gunModel[7] = new ModelRendererTurbo(this, 0, 6, 64, 16);
        this.gunModel[7].addBox(-1.0f, -4.0f, -0.75f, 2.0f, 5.0f, 1.5f);
        this.gunModel[7].func_78793_a(1.0f, 3.0f, 0.0f);
        this.gunModel[7].field_78808_h = -0.5f;
        this.ammoModel = new ModelRendererTurbo[3];
        this.ammoModel[0] = new ModelRendererTurbo(this, 8, 6, 64, 16);
        this.ammoModel[0].addBox(4.0f, -1.0f, -1.0f, 2, 5, 2);
        this.ammoModel[1] = new ModelRendererTurbo(this, 24, 6, 64, 16);
        this.ammoModel[1].addShapeBox(4.0f, -1.0f, -3.0f, 2, 5, 2, 0.0f, 0.0f, -1.5f, -0.5f, 0.0f, -1.5f, -0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.5f, -0.5f, 0.0f, -1.5f, -0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.ammoModel[2] = new ModelRendererTurbo(this, 16, 6, 64, 16);
        this.ammoModel[2].addShapeBox(4.0f, -1.0f, 1.0f, 2, 5, 2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.5f, -0.5f, 0.0f, -1.5f, -0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.5f, -0.5f, 0.0f, -1.5f, -0.5f);
        this.stockAttachPoint = new Vector3f(-0.0625f, 0.25f, 0.0f);
        this.defaultStockModel = new ModelRendererTurbo[3];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 32, 4, 64, 16);
        this.defaultStockModel[0].addShapeBox(-2.0f, 3.0f, -1.0f, 1, 2, 2, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f);
        this.defaultStockModel[1] = new ModelRendererTurbo(this, 42, 12, 64, 16);
        this.defaultStockModel[1].addShapeBox(-5.0f, 2.0f, -1.0f, 3, 2, 2, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.defaultStockModel[2] = new ModelRendererTurbo(this, 32, 8, 64, 16);
        this.defaultStockModel[2].addBox(-8.0f, 1.0f, -1.0f, 3, 3, 2);
        this.barrelAttachPoint = new Vector3f(0.734375f, 0.21875f, 0.0f);
        this.scopeAttachPoint = new Vector3f(0.125f, 0.3125f, 0.0f);
        this.gripAttachPoint = new Vector3f(0.46875f, 0.125f, 0.0f);
        this.gunSlideDistance = 0.25f;
        this.animationType = EnumAnimationType.BOTTOM_CLIP;
        this.tiltGunTime = 0.1f;
        this.unloadClipTime = 0.2f;
        this.loadClipTime = 0.2f;
        this.untiltGunTime = 0.5f;
    }
}

