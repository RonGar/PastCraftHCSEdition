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

public class ModelR700
extends ModelGun {
    public ModelR700() {
        this.gunModel = new ModelRendererTurbo[2];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(1.0f, 1.5f, -0.5f, 16, 1, 1);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 2, 64, 16);
        this.gunModel[1].addBox(-1.0f, 0.0f, -1.0f, 13, 2, 2);
        this.defaultScopeModel = new ModelRendererTurbo[5];
        this.defaultScopeModel[0] = new ModelRendererTurbo(this, 0, 9, 64, 16);
        this.defaultScopeModel[0].addBox(-1.0f, 4.0f, -1.0f, 2, 2, 2);
        this.defaultScopeModel[1] = new ModelRendererTurbo(this, 0, 13, 64, 16);
        this.defaultScopeModel[1].addBox(1.0f, 4.5f, -0.5f, 3, 1, 1);
        this.defaultScopeModel[2] = new ModelRendererTurbo(this, 8, 9, 64, 16);
        this.defaultScopeModel[2].addBox(4.0f, 4.0f, -1.0f, 3, 2, 2);
        this.defaultScopeModel[3] = new ModelRendererTurbo(this, 8, 13, 64, 16);
        this.defaultScopeModel[3].addBox(1.0f, 2.5f, -0.5f, 1, 2, 1);
        this.defaultScopeModel[4] = new ModelRendererTurbo(this, 12, 13, 64, 16);
        this.defaultScopeModel[4].addBox(3.0f, 2.5f, -0.5f, 1, 2, 1);
        this.scopeAttachPoint = new Vector3f(0.1875f, 0.3125f, 0.0f);
        this.barrelAttachPoint = new Vector3f(1.0625f, 0.28125f, 0.0f);
        this.defaultStockModel = new ModelRendererTurbo[2];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 16, 6, 64, 16);
        this.defaultStockModel[0].addBox(-2.0f, -0.5f, -1.0f, 1, 2, 2);
        this.defaultStockModel[1] = new ModelRendererTurbo(this, 18, 10, 64, 16);
        this.defaultStockModel[1].addBox(-8.0f, -1.0f, -1.0f, 6, 3, 2);
        this.stockAttachPoint = new Vector3f(-0.0625f, 0.0625f, 0.0f);
        this.ammoModel = new ModelRendererTurbo[1];
        this.ammoModel[0] = new ModelRendererTurbo(this, 26, 6, 64, 16);
        this.ammoModel[0].addBox(1.0f, 0.5f, -0.5f, 3, 1, 1);
        this.translateAll(0.0f, 2.5f, 0.0f);
        this.gunSlideDistance = 0.5f;
        this.animationType = EnumAnimationType.RIFLE;
        this.numBulletsInReloadAnimation = 4.0f;
        this.tiltGunTime = 0.279f;
        this.unloadClipTime = 0.0f;
        this.loadClipTime = 0.558f;
        this.untiltGunTime = 0.163f;
    }
}

