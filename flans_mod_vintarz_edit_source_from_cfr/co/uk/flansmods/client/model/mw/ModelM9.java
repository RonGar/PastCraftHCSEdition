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

public class ModelM9
extends ModelGun {
    public ModelM9() {
        this.gunModel = new ModelRendererTurbo[3];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 32, 16);
        this.gunModel[0].addBox(-1.0f, -2.0f, -1.0f, 3, 4, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 6, 32, 16);
        this.gunModel[1].addBox(-1.0f, 2.0f, -1.0f, 8, 1, 2);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 9, 32, 16);
        this.gunModel[2].addBox(-0.5f, 3.5f, -0.5f, 8, 1, 1);
        this.slideModel = new ModelRendererTurbo[3];
        this.slideModel[0] = new ModelRendererTurbo(this, 0, 12, 32, 16);
        this.slideModel[0].addBox(-1.0f, 3.0f, -1.0f, 8, 2, 2);
        this.slideModel[1] = new ModelRendererTurbo(this, 10, 2, 32, 16);
        this.slideModel[1].addBox(5.95f, 4.5f, -0.5f, 1, 1, 1);
        this.slideModel[2] = new ModelRendererTurbo(this, 8, 0, 32, 16);
        this.slideModel[2].addBox(-0.8f, 4.5f, -0.5f, 1, 1, 1);
        this.ammoModel = new ModelRendererTurbo[1];
        this.ammoModel[0] = new ModelRendererTurbo(this, 14, 0, 32, 16);
        this.ammoModel[0].addBox(-0.5f, -1.8f, -0.5f, 2, 4, 1);
        this.barrelAttachPoint = new Vector3f(0.46875f, 0.25f, 0.0f);
        this.scopeAttachPoint = new Vector3f(0.1875f, 0.3125f, 0.0f);
        this.scopeIsOnSlide = true;
        this.gunSlideDistance = 0.25f;
        this.animationType = EnumAnimationType.PISTOL_CLIP;
    }
}

