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

public class ModelAK47
extends ModelGun {
    public ModelAK47() {
        this.gunModel = new ModelRendererTurbo[4];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(-4.0f, 2.0f, -1.0f, 12, 3, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 5, 64, 16);
        this.gunModel[1].addBox(-0.0f, -2.0f, -1.0f, 2, 4, 2);
        this.gunModel[2] = new ModelRendererTurbo(this, 8, 5, 64, 16);
        this.gunModel[2].addBox(6.9f, 4.2f, -0.5f, 1, 1, 1);
        this.gunModel[3] = new ModelRendererTurbo(this, 0, 12, 64, 16);
        this.gunModel[3].addBox(8.0f, 2.25f, -1.0f, 6, 2, 2);
        this.scopeAttachPoint = new Vector3f(0.25f, 0.3125f, 0.0f);
        this.defaultStockModel = new ModelRendererTurbo[2];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 8, 7, 64, 16);
        this.defaultStockModel[0].addBox(-7.0f, 1.0f, -1.0f, 3, 3, 2);
        this.defaultStockModel[1] = new ModelRendererTurbo(this, 18, 7, 64, 16);
        this.defaultStockModel[1].addBox(-10.0f, 0.0f, -1.0f, 3, 3, 2);
        this.stockAttachPoint = new Vector3f(-0.25f, 0.21875f, 0.0f);
        this.defaultBarrelModel = new ModelRendererTurbo[2];
        this.defaultBarrelModel[0] = new ModelRendererTurbo(this, 30, 14, 64, 16);
        this.defaultBarrelModel[0].addBox(14.0f, 2.5f, -0.5f, 3, 1, 1);
        this.defaultBarrelModel[1] = new ModelRendererTurbo(this, 16, 12, 64, 16);
        this.defaultBarrelModel[1].addBox(17.0f, 2.5f, -0.5f, 1, 2, 1);
        this.barrelAttachPoint = new Vector3f(0.875f, 0.203125f, 0.0f);
        this.ammoModel = new ModelRendererTurbo[3];
        this.ammoModel[0] = new ModelRendererTurbo(this, 28, 0, 64, 16);
        this.ammoModel[0].addBox(4.0f, -2.0f, -1.0f, 3, 4, 2);
        this.ammoModel[1] = new ModelRendererTurbo(this, 20, 12, 64, 16);
        this.ammoModel[1].addBox(5.0f, -4.0f, -1.0f, 3, 2, 2);
        this.ammoModel[2] = new ModelRendererTurbo(this, 28, 7, 64, 16);
        this.ammoModel[2].addBox(6.0f, -5.0f, -1.0f, 2, 1, 2);
        this.gunSlideDistance = 0.5f;
        this.animationType = EnumAnimationType.BOTTOM_CLIP;
    }
}

