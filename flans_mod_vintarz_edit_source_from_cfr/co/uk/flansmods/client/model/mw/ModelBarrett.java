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

public class ModelBarrett
extends ModelGun {
    public ModelBarrett() {
        this.gunModel = new ModelRendererTurbo[3];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(-4.0f, 2.0f, -1.0f, 16, 2, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 26, 4, 64, 16);
        this.gunModel[1].addBox(12.0f, 2.5f, -0.5f, 8, 1, 1);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 4, 64, 16);
        this.gunModel[2].addBox(-1.0f, -2.0f, -1.0f, 3, 4, 2);
        this.slideModel = new ModelRendererTurbo[2];
        this.slideModel[0] = new ModelRendererTurbo(this, 34, 6, 64, 16);
        this.slideModel[0].addTrapezoid(3.0f, 2.5f, 0.5f, 1, 1, 2, 0.0f, -0.5f, 0);
        this.slideModel[0].doMirror(false, false, true);
        this.slideModel[1] = new ModelRendererTurbo(this, 34, 6, 64, 16);
        this.slideModel[1].addTrapezoid(3.0f, 2.5f, 0.5f, 1, 1, 2, 0.0f, -0.5f, 0);
        this.defaultScopeModel = new ModelRendererTurbo[3];
        this.defaultScopeModel[0] = new ModelRendererTurbo(this, 0, 10, 64, 16);
        this.defaultScopeModel[0].addTrapezoid(-1.0f, 4.25f, -1.0f, 4, 2, 2, 0.0f, -0.5f, 2);
        this.defaultScopeModel[1] = new ModelRendererTurbo(this, 12, 10, 64, 16);
        this.defaultScopeModel[1].addTrapezoid(3.0f, 4.25f, -1.0f, 4, 2, 2, 0.0f, -0.5f, 3);
        this.defaultScopeModel[2] = new ModelRendererTurbo(this, 10, 7, 64, 16);
        this.defaultScopeModel[2].addBox(1.5f, 3.5f, -0.5f, 3, 2, 1);
        this.scopeAttachPoint = new Vector3f(0.1875f, 0.3125f, 0.0f);
        this.defaultBarrelModel = new ModelRendererTurbo[1];
        this.defaultBarrelModel[0] = new ModelRendererTurbo(this, 18, 4, 64, 16);
        this.defaultBarrelModel[0].addBox(18.5f, 2.0f, -1.0f, 2, 2, 2);
        this.barrelAttachPoint = new Vector3f(1.25f, 0.25f, 0.0f);
        this.defaultStockModel = new ModelRendererTurbo[1];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 36, 9, 64, 16);
        this.defaultStockModel[0].addBox(-8.0f, 0.0f, -1.0f, 4, 3, 2);
        this.stockAttachPoint = new Vector3f(-0.25f, 0.0625f, 0.0f);
        this.ammoModel = new ModelRendererTurbo[1];
        this.ammoModel[0] = new ModelRendererTurbo(this, 24, 8, 64, 16);
        this.ammoModel[0].addBox(2.5f, -3.0f, -1.0f, 4, 5, 2);
        this.translateAll(0.0f, 1.0f, 0.0f);
        this.gunSlideDistance = 0.5f;
        this.animationType = EnumAnimationType.BOTTOM_CLIP;
    }
}

