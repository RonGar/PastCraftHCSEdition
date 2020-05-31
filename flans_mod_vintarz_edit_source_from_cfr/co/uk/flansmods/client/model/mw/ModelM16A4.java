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

public class ModelM16A4
extends ModelGun {
    public ModelM16A4() {
        this.gunModel = new ModelRendererTurbo[6];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(1.0f, 2.0f, -1.0f, 5, 3, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 14, 0, 64, 16);
        this.gunModel[1].addBox(0.0f, -1.0f, -1.0f, 1, 3, 2);
        this.gunModel[2] = new ModelRendererTurbo(this, 20, 0, 64, 16);
        this.gunModel[2].addBox(1.0f, 1.0f, -1.0f, 1, 1, 2);
        this.gunModel[3] = new ModelRendererTurbo(this, 0, 5, 64, 16);
        this.gunModel[3].addBox(6.5f, 3.0f, -1.0f, 7, 2, 2);
        this.gunModel[4] = new ModelRendererTurbo(this, 12, 0, 64, 16);
        this.gunModel[4].addBox(14.0f, 4.5f, -0.5f, 1, 1, 1);
        this.gunModel[5] = new ModelRendererTurbo(this, 0, 9, 64, 16);
        this.gunModel[5].addBox(6.0f, 3.5f, -0.5f, 12, 1, 1);
        this.scopeAttachPoint = new Vector3f(0.21875f, 0.3125f, 0.0f);
        this.defaultStockModel = new ModelRendererTurbo[3];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 20, 3, 64, 16);
        this.defaultStockModel[0].addBox(-8.0f, 1.0f, -1.0f, 3, 4, 2);
        this.defaultStockModel[1] = new ModelRendererTurbo(this, 0, 11, 64, 16);
        this.defaultStockModel[1].addBox(-5.0f, 2.0f, -1.0f, 3, 3, 2);
        this.defaultStockModel[2] = new ModelRendererTurbo(this, 10, 11, 64, 16);
        this.defaultStockModel[2].addBox(-2.0f, 3.0f, -1.0f, 3, 2, 2);
        this.stockAttachPoint = new Vector3f(0.0625f, 0.25f, 0.0f);
        this.barrelAttachPoint = new Vector3f(1.125f, 0.25f, 0.0f);
        this.gripAttachPoint = new Vector3f(0.625f, 0.1875f, 0.0f);
        this.ammoModel = new ModelRendererTurbo[2];
        this.ammoModel[0] = new ModelRendererTurbo(this, 20, 11, 64, 16);
        this.ammoModel[0].addBox(3.0f, 0.0f, -1.0f, 3, 2, 2);
        this.ammoModel[1] = new ModelRendererTurbo(this, 30, 11, 64, 16);
        this.ammoModel[1].addBox(4.0f, -2.0f, -1.0f, 3, 2, 2);
        this.gunSlideDistance = 0.5f;
        this.animationType = EnumAnimationType.BOTTOM_CLIP;
    }
}

