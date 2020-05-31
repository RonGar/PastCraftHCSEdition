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

public class ModelP90
extends ModelGun {
    public ModelP90() {
        this.gunModel = new ModelRendererTurbo[8];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(-2.0f, 1.0f, -1.0f, 12, 2, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 4, 64, 16);
        this.gunModel[1].addBox(-8.0f, -1.0f, -1.0f, 6, 5, 2);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 11, 64, 16);
        this.gunModel[2].addBox(-2.0f, -2.0f, -1.0f, 3, 3, 2);
        this.gunModel[3] = new ModelRendererTurbo(this, 10, 13, 64, 16);
        this.gunModel[3].addBox(1.0f, -2.0f, -1.0f, 8, 1, 2);
        this.gunModel[4] = new ModelRendererTurbo(this, 14, 9, 64, 16);
        this.gunModel[4].addBox(5.0f, -1.0f, -1.0f, 1, 2, 2);
        this.gunModel[5] = new ModelRendererTurbo(this, 18, 7, 64, 16);
        this.gunModel[5].addBox(8.0f, -1.0f, -1.0f, 1, 2, 2);
        this.gunModel[6] = new ModelRendererTurbo(this, 16, 4, 64, 16);
        this.gunModel[6].addBox(9.0f, 0.0f, -1.0f, 1, 1, 2);
        this.gunModel[7] = new ModelRendererTurbo(this, 25, 1, 64, 16);
        this.gunModel[7].addBox(4.9f, 2.0f, -1.5f, 5, 3, 3);
        this.scopeAttachPoint = new Vector3f(0.46875f, 0.3125f, 0.0f);
        this.defaultBarrelModel = new ModelRendererTurbo[1];
        this.defaultBarrelModel[0] = new ModelRendererTurbo(this, 21, 11, 64, 16);
        this.defaultBarrelModel[0].addBox(10.0f, 1.5f, -0.5f, 1, 1, 1);
        this.barrelAttachPoint = new Vector3f(0.625f, 0.125f, 0.0f);
        this.ammoModel = new ModelRendererTurbo[1];
        this.ammoModel[0] = new ModelRendererTurbo(this, 28, 13, 64, 16);
        this.ammoModel[0].addBox(-2.0f, 3.0f, -1.0f, 11, 1, 2);
        this.gunSlideDistance = 0.5f;
        this.animationType = EnumAnimationType.P90;
    }
}

