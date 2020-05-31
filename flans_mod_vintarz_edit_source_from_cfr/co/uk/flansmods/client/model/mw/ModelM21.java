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

public class ModelM21
extends ModelGun {
    public ModelM21() {
        this.gunModel = new ModelRendererTurbo[3];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(2.0f, 3.5f, -0.5f, 16, 1, 1);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 2, 64, 16);
        this.gunModel[1].addBox(-1.0f, 2.0f, -1.0f, 8, 3, 2);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 7, 64, 16);
        this.gunModel[2].addBox(7.0f, 3.0f, -1.0f, 6, 2, 2);
        this.defaultScopeModel = new ModelRendererTurbo[6];
        this.defaultScopeModel[0] = new ModelRendererTurbo(this, 0, 11, 64, 16);
        this.defaultScopeModel[0].addBox(-1.0f, 6.0f, -1.0f, 2, 2, 2);
        this.defaultScopeModel[1] = new ModelRendererTurbo(this, 34, 0, 64, 16);
        this.defaultScopeModel[1].addBox(1.0f, 6.5f, -0.5f, 4, 1, 1);
        this.defaultScopeModel[2] = new ModelRendererTurbo(this, 8, 11, 64, 16);
        this.defaultScopeModel[2].addBox(5.0f, 6.0f, -1.0f, 2, 2, 2);
        this.defaultScopeModel[3] = new ModelRendererTurbo(this, 6, 11, 64, 16);
        this.defaultScopeModel[3].addBox(1.5f, 5.5f, -0.5f, 1, 1, 1);
        this.defaultScopeModel[4] = new ModelRendererTurbo(this, 6, 11, 64, 16);
        this.defaultScopeModel[4].addBox(3.5f, 5.5f, -0.5f, 1, 1, 1);
        this.defaultScopeModel[5] = new ModelRendererTurbo(this, 14, 11, 64, 16);
        this.defaultScopeModel[5].addBox(0.0f, 4.5f, -0.5f, 6, 1, 1);
        this.scopeAttachPoint = new Vector3f(0.1875f, 0.3125f, 0.0f);
        this.barrelAttachPoint = new Vector3f(1.125f, 0.25f, 0.0f);
        this.defaultStockModel = new ModelRendererTurbo[2];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 20, 2, 64, 16);
        this.defaultStockModel[0].addBox(-2.0f, 2.0f, -1.0f, 1, 2, 2);
        this.defaultStockModel[1] = new ModelRendererTurbo(this, 19, 6, 64, 16);
        this.defaultStockModel[1].addBox(-8.0f, 1.0f, -1.0f, 6, 3, 2);
        this.stockAttachPoint = new Vector3f(-0.0625f, 0.1875f, 0.0f);
        this.ammoModel = new ModelRendererTurbo[1];
        this.ammoModel[0] = new ModelRendererTurbo(this, 35, 8, 64, 16);
        this.ammoModel[0].addBox(3.0f, -4.0f, -1.0f, 3, 6, 2);
        this.gunSlideDistance = 0.5f;
        this.animationType = EnumAnimationType.BOTTOM_CLIP;
    }
}

