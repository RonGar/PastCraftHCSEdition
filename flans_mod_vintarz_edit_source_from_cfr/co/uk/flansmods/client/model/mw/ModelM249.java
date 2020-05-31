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

public class ModelM249
extends ModelGun {
    public ModelM249() {
        this.gunModel = new ModelRendererTurbo[15];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 32);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 9, 64, 32);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 14, 64, 32);
        this.gunModel[3] = new ModelRendererTurbo(this, 0, 17, 64, 32);
        this.gunModel[8] = new ModelRendererTurbo(this, 4, 27, 64, 32);
        this.gunModel[9] = new ModelRendererTurbo(this, 4, 25, 64, 32);
        this.gunModel[10] = new ModelRendererTurbo(this, 4, 23, 64, 32);
        this.gunModel[11] = new ModelRendererTurbo(this, 12, 24, 64, 32);
        this.gunModel[12] = new ModelRendererTurbo(this, 0, 7, 64, 32);
        this.gunModel[13] = new ModelRendererTurbo(this, 6, 6, 64, 32);
        this.gunModel[14] = new ModelRendererTurbo(this, 12, 22, 64, 32);
        this.gunModel[4] = new ModelRendererTurbo(this, 22, 18, 64, 32);
        this.gunModel[5] = new ModelRendererTurbo(this, 10, 7, 64, 32);
        this.gunModel[6] = new ModelRendererTurbo(this, 20, 14, 64, 32);
        this.gunModel[7] = new ModelRendererTurbo(this, 20, 16, 64, 32);
        this.gunModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 12, 1, 1, 0.0f);
        this.gunModel[0].func_78793_a(6.0f, 3.8f, -0.5f);
        this.gunModel[1].func_78790_a(0.0f, 0.0f, 0.0f, 8, 2, 2, 0.0f);
        this.gunModel[1].func_78793_a(6.0f, 3.0f, -1.0f);
        this.gunModel[2].func_78790_a(0.0f, 0.0f, 0.0f, 9, 1, 1, 0.0f);
        this.gunModel[2].func_78793_a(6.0f, 2.5f, -0.5f);
        this.gunModel[3].func_78790_a(0.0f, 0.0f, 0.0f, 9, 1, 1, 0.0f);
        this.gunModel[3].func_78793_a(4.9f, 4.2f, -0.5f);
        this.gunModel[8].func_78790_a(0.0f, 0.0f, 0.0f, 3, 1, 1, 0.0f);
        this.gunModel[8].func_78793_a(9.2f, 4.3f, -0.2f);
        this.gunModel[9].func_78790_a(0.0f, 0.0f, 0.0f, 3, 1, 1, 0.0f);
        this.gunModel[9].func_78793_a(9.2f, 4.3f, -0.8f);
        this.gunModel[10].func_78790_a(0.0f, 0.0f, 0.0f, 2, 1, 1, 0.0f);
        this.gunModel[10].func_78793_a(9.7f, 4.4f, -0.5f);
        this.gunModel[11].func_78790_a(0.0f, 0.0f, 0.0f, 3, 3, 2, 0.0f);
        this.gunModel[11].func_78793_a(3.0f, 2.5f, -1.0f);
        this.gunModel[12].func_78790_a(0.0f, 0.0f, 0.0f, 2, 1, 1, 0.0f);
        this.gunModel[12].func_78793_a(3.5f, 2.2f, -0.5f);
        this.gunModel[13].func_78790_a(0.0f, 0.0f, 0.0f, 1, 2, 1, 0.0f);
        this.gunModel[13].func_78793_a(3.5f, 0.2f, -0.5f);
        this.gunModel[14].func_78790_a(0.0f, 0.0f, 0.0f, 3, 1, 1, 0.0f);
        this.gunModel[14].func_78793_a(5.8f, 3.5f, -1.1f);
        this.gunModel[4].func_78790_a(0.0f, 0.0f, -1.0f, 2, 2, 1, 0.0f);
        this.gunModel[4].func_78793_a(6.8f, 2.9f, 1.2f);
        this.gunModel[5].func_78790_a(0.0f, -0.6666667f, 0.0f, 3, 1, 1, 0.0f);
        this.gunModel[5].func_78793_a(5.0f, 5.0f, -0.9f);
        this.gunModel[6].func_78790_a(0.0f, -0.6666667f, 0.0f, 3, 1, 1, 0.0f);
        this.gunModel[6].func_78793_a(5.0f, 5.0f, -0.1f);
        this.gunModel[7].func_78790_a(0.0f, -0.6666667f, 0.0f, 3, 1, 1, 0.0f);
        this.gunModel[7].func_78793_a(5.1f, 5.1f, -0.5f);
        this.scopeAttachPoint = new Vector3f(0.125f, 0.2083125f, 0.0f);
        this.defaultStockModel = new ModelRendererTurbo[4];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 20, 11, 64, 32);
        this.defaultStockModel[1] = new ModelRendererTurbo(this, 24, 11, 64, 32);
        this.defaultStockModel[2] = new ModelRendererTurbo(this, 0, 5, 64, 32);
        this.defaultStockModel[3] = new ModelRendererTurbo(this, 20, 7, 64, 32);
        this.defaultStockModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 1, 2, 1, 0.0f);
        this.defaultStockModel[0].func_78793_a(2.0f, 3.3f, -0.8f);
        this.defaultStockModel[1].func_78790_a(0.0f, 0.0f, 0.0f, 1, 2, 1, 0.0f);
        this.defaultStockModel[1].func_78793_a(2.0f, 3.3f, -0.2f);
        this.defaultStockModel[2].func_78790_a(0.0f, 0.0f, 0.0f, 2, 1, 1, 0.0f);
        this.defaultStockModel[2].func_78793_a(1.0f, 4.4f, -0.5f);
        this.defaultStockModel[3].func_78790_a(0.0f, 0.0f, 0.0f, 1, 3, 1, 0.0f);
        this.defaultStockModel[3].func_78793_a(0.0f, 2.4f, -0.5f);
        this.stockAttachPoint = new Vector3f(0.0625f, 0.25f, 0.0f);
        this.barrelAttachPoint = new Vector3f(1.125f, 0.25f, 0.0f);
        this.gripAttachPoint = new Vector3f(0.5f, 0.03125f, 0.0f);
        this.defaultGripModel = new ModelRendererTurbo[4];
        this.defaultGripModel[0] = new ModelRendererTurbo(this, 0, 20, 64, 32);
        this.defaultGripModel[1] = new ModelRendererTurbo(this, 0, 24, 64, 32);
        this.defaultGripModel[2] = new ModelRendererTurbo(this, 0, 29, 64, 32);
        this.defaultGripModel[3] = new ModelRendererTurbo(this, 4, 29, 64, 32);
        this.defaultGripModel[0].func_78790_a(0.0f, -1.0f, 0.0f, 4, 1, 2, 0.0f);
        this.defaultGripModel[0].func_78793_a(8.5f, 3.0f, -1.0f);
        this.defaultGripModel[1].func_78790_a(0.0f, -3.0f, 0.0f, 1, 3, 1, 0.0f);
        this.defaultGripModel[1].func_78793_a(10.5f, 2.5f, -0.5f);
        this.defaultGripModel[1].field_78808_h = -0.3141593f;
        this.defaultGripModel[2].func_78790_a(0.0f, -1.0f, 0.0f, 1, 1, 1, 0.0f);
        this.defaultGripModel[2].func_78793_a(10.4f, 3.4f, 0.1f);
        this.defaultGripModel[3].func_78790_a(0.0f, -1.0f, 0.0f, 1, 1, 1, 0.0f);
        this.defaultGripModel[3].func_78793_a(10.4f, 3.4f, -1.1f);
        this.slideModel = new ModelRendererTurbo[2];
        this.slideModel[0] = new ModelRendererTurbo(this, 18, 20, 64, 32);
        this.slideModel[1] = new ModelRendererTurbo(this, 22, 21, 64, 32);
        this.slideModel[0].func_78790_a(0.0f, 0.0f, -1.0f, 1, 1, 1, 0.0f);
        this.slideModel[0].func_78793_a(10.8f, 3.5f, 1.2f);
        this.slideModel[1].func_78790_a(0.0f, 0.0f, -1.0f, 4, 1, 1, 0.0f);
        this.slideModel[1].func_78793_a(7.8f, 3.5f, 1.1f);
        this.ammoModel = new ModelRendererTurbo[2];
        this.ammoModel[0] = new ModelRendererTurbo(this, 22, 23, 64, 32);
        this.ammoModel[1] = new ModelRendererTurbo(this, 12, 19, 64, 32);
        this.ammoModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 3, 3, 3, 0.0f);
        this.ammoModel[0].func_78793_a(5.8f, 0.0f, -2.4f);
        this.ammoModel[1].func_78790_a(0.0f, 2.5f, -1.5f, 2, 2, 1, 0.0f);
        this.ammoModel[1].func_78793_a(6.266667f, 0.0f, -2.5f);
        this.ammoModel[1].field_78795_f = 0.6806784f;
        this.ammoModel[1].field_78796_g = 0.01745329f;
        this.translateAll(-3.0f, -2.2f, 0.0f);
        this.gunSlideDistance = 0.5f;
        this.animationType = EnumAnimationType.BOTTOM_CLIP;
        this.tiltGunTime = 0.1f;
        this.unloadClipTime = 0.2f;
        this.loadClipTime = 0.2f;
        this.untiltGunTime = 0.5f;
    }
}

