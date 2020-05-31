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

public class ModelRPG
extends ModelGun {
    public ModelRPG() {
        this.gunModel = new ModelRendererTurbo[5];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(-14.0f, 2.5f, -1.0f, 22, 2, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 4, 64, 16);
        this.gunModel[1].addBox(-15.0f, 2.0f, -1.5f, 1, 3, 3);
        this.gunModel[2] = new ModelRendererTurbo(this, 8, 4, 64, 16);
        this.gunModel[2].addBox(-5.0f, 2.0f, -1.5f, 8, 3, 3);
        this.gunModel[3] = new ModelRendererTurbo(this, 0, 13, 64, 16);
        this.gunModel[3].addBox(0.0f, 0.0f, -0.5f, 1, 2, 1);
        this.gunModel[4] = new ModelRendererTurbo(this, 4, 11, 64, 16);
        this.gunModel[4].addBox(4.0f, -1.0f, -0.5f, 1, 4, 1);
        this.scopeAttachPoint = new Vector3f(0.09375f, 0.3125f, 0.0f);
        this.barrelAttachPoint = new Vector3f(1.125f, 0.25f, 0.0f);
        this.stockAttachPoint = new Vector3f(-0.0625f, 0.0625f, 0.0f);
        this.ammoModel = new ModelRendererTurbo[4];
        this.ammoModel[0] = new ModelRendererTurbo(this, 14, 12, 64, 16);
        this.ammoModel[0].addBox(-1.5f, 0.0f, -1.5f, 3, 1, 3);
        this.ammoModel[1] = new ModelRendererTurbo(this, 26, 9, 64, 16);
        this.ammoModel[1].addTrapezoid(-2.0f, 1.0f, -2.0f, 4, 3, 4, 0.0f, -1.0f, 4);
        this.ammoModel[2] = new ModelRendererTurbo(this, 38, 6, 64, 16);
        this.ammoModel[2].addTrapezoid(-2.0f, 4.0f, -2.0f, 4, 3, 4, 0.0f, -1.0f, 5);
        this.ammoModel[3] = new ModelRendererTurbo(this, 38, 5, 64, 16);
        this.ammoModel[3].addBox(-0.5f, -4.0f, -0.5f, 1, 4, 1);
        for (int i = 0; i < 4; ++i) {
            this.ammoModel[i].func_78793_a(8.0f, 3.5f, 0.0f);
            this.ammoModel[i].field_78808_h = -1.5707964f;
        }
        this.gunSlideDistance = 0.5f;
        this.animationType = EnumAnimationType.END_LOADED;
        this.tiltGunTime = 0.4f;
        this.unloadClipTime = 0.1f;
        this.loadClipTime = 0.1f;
        this.untiltGunTime = 0.4f;
    }
}

