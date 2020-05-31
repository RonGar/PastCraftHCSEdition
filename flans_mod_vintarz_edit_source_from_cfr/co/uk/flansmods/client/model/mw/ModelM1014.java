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

public class ModelM1014
extends ModelGun {
    public ModelM1014() {
        this.gunModel = new ModelRendererTurbo[6];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(-1.0f, 3.0f, -1.0f, 7, 2, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 4, 64, 16);
        this.gunModel[1].addBox(6.0f, 3.0f, -0.5f, 12, 2, 1);
        this.gunModel[2] = new ModelRendererTurbo(this, 16, 0, 64, 16);
        this.gunModel[2].addBox(15.0f, 5.0f, -0.5f, 1, 1, 1);
        this.gunModel[3] = new ModelRendererTurbo(this, 0, 7, 64, 16);
        this.gunModel[3].addBox(-1.0f, 0.0f, -1.0f, 2, 3, 2);
        this.gunModel[4] = new ModelRendererTurbo(this, 18, 0, 64, 16);
        this.gunModel[4].addBox(1.0f, 2.0f, -1.0f, 1, 1, 2);
        this.gunModel[5] = new ModelRendererTurbo(this, 28, 0, 64, 16);
        this.gunModel[5].addBox(1.0f, 2.5f, -2.0f, 4, 3, 1);
        this.pumpModel = new ModelRendererTurbo[1];
        this.pumpModel[0] = new ModelRendererTurbo(this, 8, 7, 64, 16);
        this.pumpModel[0].addBox(10.0f, 2.8f, -1.0f, 4, 1, 2);
        this.scopeAttachPoint = new Vector3f(0.1875f, 0.3125f, 0.0f);
        this.defaultStockModel = new ModelRendererTurbo[3];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 8, 10, 64, 16);
        this.defaultStockModel[0].addBox(-8.0f, 0.0f, -1.0f, 3, 3, 2);
        this.defaultStockModel[1] = new ModelRendererTurbo(this, 0, 12, 64, 16);
        this.defaultStockModel[1].addBox(-5.0f, 1.0f, -1.0f, 2, 2, 2);
        this.defaultStockModel[2] = new ModelRendererTurbo(this, 18, 12, 64, 16);
        this.defaultStockModel[2].addBox(-3.0f, 2.0f, -1.0f, 2, 2, 2);
        this.stockAttachPoint = new Vector3f(0.0625f, 0.25f, 0.0f);
        this.barrelAttachPoint = new Vector3f(1.125f, 0.25f, 0.0f);
        this.gripAttachPoint = new Vector3f(0.625f, 0.1875f, 0.0f);
        this.ammoModel = new ModelRendererTurbo[1];
        this.ammoModel[0] = new ModelRendererTurbo(this, 22, 0, 64, 16);
        this.ammoModel[0].addBox(4.0f, 3.5f, -0.5f, 2, 1, 1);
        this.gunSlideDistance = 0.5f;
        this.animationType = EnumAnimationType.SHOTGUN;
        this.pumpDelayAfterReload = 65;
        this.pumpDelay = 6;
        this.pumpTime = 9;
        this.numBulletsInReloadAnimation = 4.0f;
        this.tiltGunTime = 0.204f;
        this.unloadClipTime = 0.0f;
        this.loadClipTime = 0.625f;
        this.untiltGunTime = 0.171f;
    }
}

