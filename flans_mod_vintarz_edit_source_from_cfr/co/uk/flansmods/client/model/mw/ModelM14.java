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

public class ModelM14
extends ModelGun {
    public ModelM14() {
        this.gunModel = new ModelRendererTurbo[10];
        this.gunModel[0] = new ModelRendererTurbo(this, 12, 0, 64, 32);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 6, 64, 32);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 9, 64, 32);
        this.gunModel[3] = new ModelRendererTurbo(this, 0, 14, 64, 32);
        this.gunModel[4] = new ModelRendererTurbo(this, 0, 16, 64, 32);
        this.gunModel[5] = new ModelRendererTurbo(this, 0, 18, 64, 32);
        this.gunModel[6] = new ModelRendererTurbo(this, 0, 0, 64, 32);
        this.gunModel[8] = new ModelRendererTurbo(this, 6, 16, 64, 32);
        this.gunModel[9] = new ModelRendererTurbo(this, 20, 24, 64, 32);
        this.gunModel[7] = new ModelRendererTurbo(this, 22, 21, 64, 32);
        this.gunModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 1, 3, 2, 0.0f);
        this.gunModel[0].func_78793_a(0.0f, -7.0f, -1.0f);
        this.gunModel[1].func_78790_a(0.0f, 0.0f, 0.0f, 3, 1, 2, 0.0f);
        this.gunModel[1].func_78793_a(0.0f, -4.0f, -1.0f);
        this.gunModel[2].func_78790_a(0.0f, 0.0f, 0.0f, 14, 3, 2, 0.0f);
        this.gunModel[2].func_78793_a(7.0f, -3.0f, -1.0f);
        this.gunModel[3].func_78790_a(0.0f, 0.0f, 0.0f, 5, 1, 1, 0.0f);
        this.gunModel[3].func_78793_a(20.0f, -1.5f, -0.5f);
        this.gunModel[4].func_78790_a(0.0f, 0.0f, 0.0f, 2, 1, 1, 0.0f);
        this.gunModel[4].func_78793_a(21.0f, -2.8f, -0.5f);
        this.gunModel[5].func_78790_a(0.0f, 0.0f, 0.0f, 9, 2, 2, 0.0f);
        this.gunModel[5].func_78793_a(-2.0f, -3.0f, -1.0f);
        this.gunModel[6].func_78790_a(0.0f, 0.0f, 0.0f, 4, 1, 2, 0.0f);
        this.gunModel[6].func_78793_a(-2.0f, -1.0f, -1.0f);
        this.gunModel[8].func_78790_a(0.0f, 0.0f, 0.0f, 1, 1, 1, 0.0f);
        this.gunModel[8].func_78793_a(18.5f, 0.0f, -0.5f);
        this.gunModel[9].func_78790_a(0.0f, 0.0f, 0.0f, 6, 2, 1, 0.0f);
        this.gunModel[9].func_78793_a(9.0f, -3.2f, 0.2f);
        this.gunModel[7].func_78790_a(0.0f, 0.0f, 0.0f, 6, 2, 1, 0.0f);
        this.gunModel[7].func_78793_a(9.0f, -3.2f, -1.2f);
        this.scopeAttachPoint = new Vector3f(0.0f, 0.390625f, 0.0f);
        this.defaultScopeModel = new ModelRendererTurbo[1];
        this.defaultScopeModel[0] = new ModelRendererTurbo(this, 0, 30, 64, 32);
        this.defaultScopeModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 3, 1, 1, 0.0f);
        this.defaultScopeModel[0].func_78793_a(-1.5f, 0.0f, -0.5f);
        this.defaultStockModel = new ModelRendererTurbo[2];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 8, 28, 64, 32);
        this.defaultStockModel[1] = new ModelRendererTurbo(this, 20, 27, 64, 32);
        this.defaultStockModel[0].addShapeBox(0.0f, 0.0f, 0.0f, 4, 2, 2, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f);
        this.defaultStockModel[0].func_78793_a(-6.0f, -3.0f, -1.0f);
        this.defaultStockModel[1].addShapeBox(0.0f, 0.0f, 0.0f, 5, 3, 2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.defaultStockModel[1].func_78793_a(-11.0f, -5.0f, -1.0f);
        this.stockAttachPoint = new Vector3f(0.0625f, 0.25f, 0.0f);
        this.barrelAttachPoint = new Vector3f(1.5625f, 0.328125f, 0.0f);
        this.gripAttachPoint = new Vector3f(0.625f, 0.1875f, 0.0f);
        this.slideModel = new ModelRendererTurbo[1];
        this.slideModel[0] = new ModelRendererTurbo(this, 0, 22, 64, 32);
        this.slideModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 5, 1, 1, 0.0f);
        this.slideModel[0].func_78793_a(2.0f, -1.1f, -0.5f);
        this.ammoModel = new ModelRendererTurbo[1];
        this.ammoModel[0] = new ModelRendererTurbo(this, 0, 24, 64, 32);
        this.ammoModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 3, 5, 1, 0.0f);
        this.ammoModel[0].func_78793_a(5.0f, -7.0f, -0.5f);
        this.ammoModel[0].field_78808_h = 0.06981317f;
        this.gunSlideDistance = 0.2f;
        this.animationType = EnumAnimationType.BOTTOM_CLIP;
        this.translateAll(0.0f, 6.25f, 0.0f);
    }
}

