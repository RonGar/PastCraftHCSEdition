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

public class ModelAK74
extends ModelGun {
    public ModelAK74() {
        this.gunModel = new ModelRendererTurbo[7];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 64, 16);
        this.gunModel[0].addBox(-1.0f, 3.0f, -1.0f, 9, 1, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 0, 3, 64, 16);
        this.gunModel[1].addShapeBox(-1.0f, 4.0f, -1.0f, 12, 1, 2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 6, 64, 16);
        this.gunModel[2].addShapeBox(8.0f, 3.0f, -1.0f, 3, 1, 2, 0.0f, 0.0f, 0.25f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.25f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.gunModel[3] = new ModelRendererTurbo(this, 10, 6, 64, 16);
        this.gunModel[3].addBox(-1.0f, 2.0f, -1.0f, 2, 1, 2);
        this.gunModel[4] = new ModelRendererTurbo(this, 28, 0, 64, 16);
        this.gunModel[4].addBox(-0.75f, -3.0f, -0.75f, 1.5f, 4.0f, 1.5f);
        this.gunModel[4].func_78793_a(-0.2f, 2.0f, 0.0f);
        this.gunModel[4].field_78808_h = -0.5f;
        this.gunModel[5] = new ModelRendererTurbo(this, 0, 13, 64, 16);
        this.gunModel[5].addBox(11.0f, 3.75f, -0.25f, 0.5f, 2.0f, 0.5f);
        this.gunModel[6] = new ModelRendererTurbo(this, 4, 14, 64, 16);
        this.gunModel[6].addBox(11.0f, 3.25f, -0.25f, 3.0f, 0.5f, 0.5f);
        this.ammoModel = new ModelRendererTurbo[2];
        this.ammoModel[0] = new ModelRendererTurbo(this, 12, 12, 64, 16);
        this.ammoModel[0].addShapeBox(4.0f, 1.0f, -1.0f, 2, 2, 2, 0.0f, -0.5f, 0.5f, 0.0f, 0.5f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f, -0.5f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.ammoModel[1] = new ModelRendererTurbo(this, 20, 12, 64, 16);
        this.ammoModel[1].addShapeBox(4.0f, -1.0f, -1.0f, 2, 2, 2, 0.0f, -2.0f, 0.0f, 0.0f, 1.25f, -1.25f, 0.0f, 1.25f, -1.25f, 0.0f, -2.0f, 0.0f, 0.0f, -0.5f, -0.5f, 0.0f, 0.5f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f, -0.5f, -0.5f, 0.0f);
        this.stockAttachPoint = new Vector3f(0.1875f, 0.3125f, 0.0f);
        this.defaultStockModel = new ModelRendererTurbo[4];
        this.defaultStockModel[0] = new ModelRendererTurbo(this, 12, 10, 64, 16);
        this.defaultStockModel[0].addBox(-2.0f, 3.0f, -0.5f, 1, 1, 1);
        this.defaultStockModel[1] = new ModelRendererTurbo(this, 16, 10, 64, 16);
        this.defaultStockModel[1].addShapeBox(-7.0f, 1.0f, -0.5f, 5, 1, 1, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -2.0f, 0.0f, 0.0f, -2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.5f, 0.0f, 0.0f, 1.5f, 0.0f, 0.0f, -0.5f, 0.0f);
        this.defaultStockModel[2] = new ModelRendererTurbo(this, 18, 8, 64, 16);
        this.defaultStockModel[2].addBox(-7.0f, 3.5f, -0.5f, 5.0f, 0.5f, 1.0f);
        this.defaultStockModel[3] = new ModelRendererTurbo(this, 28, 12, 64, 16);
        this.defaultStockModel[3].addBox(-8.0f, 1.0f, -0.5f, 1, 3, 1);
        this.barrelAttachPoint = new Vector3f(0.734375f, 0.21875f, 0.0f);
        this.defaultBarrelModel = new ModelRendererTurbo[1];
        this.defaultBarrelModel[0] = new ModelRendererTurbo(this, 32, 14, 64, 16);
        this.defaultBarrelModel[0].addBox(11.5f, 3.0f, -0.5f, 2, 1, 1);
        this.scopeAttachPoint = new Vector3f(0.1875f, 0.3125f, 0.0f);
        this.defaultScopeModel = new ModelRendererTurbo[1];
        this.defaultScopeModel[0] = new ModelRendererTurbo(this, 38, 14, 64, 16);
        this.defaultScopeModel[0].addBox(4.0f, 5.0f, -0.5f, 1, 1, 1);
        this.gunSlideDistance = 0.25f;
        this.animationType = EnumAnimationType.BOTTOM_CLIP;
    }
}

