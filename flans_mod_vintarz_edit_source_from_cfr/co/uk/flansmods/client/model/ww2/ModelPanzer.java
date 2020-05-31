/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.client.model.ww2;

import co.uk.flansmods.client.model.ModelVehicle;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelPanzer
extends ModelVehicle {
    public ModelPanzer() {
        this.bodyModel = new ModelRendererTurbo[4];
        this.bodyModel[0] = new ModelRendererTurbo(this, 0, 0, 256, 256);
        this.bodyModel[1] = new ModelRendererTurbo(this, 0, 68, 256, 256);
        this.bodyModel[2] = new ModelRendererTurbo(this, 0, 184, 256, 256);
        this.bodyModel[3] = new ModelRendererTurbo(this, 0, 184, 256, 256);
        this.bodyModel[0].func_78790_a(-40.0f, -20.0f, -24.0f, 80, 20, 48, 0.0f);
        this.bodyModel[1].addTrapezoid(-40.0f, -32.0f, -24.0f, 72, 12, 48, 0.0f, -2.0f, 4);
        this.bodyModel[2].func_78790_a(-36.0f, -32.0f, -26.0f, 72, 20, 2, 0.0f);
        this.bodyModel[3].func_78790_a(-36.0f, -32.0f, -26.0f, 72, 20, 2, 0.0f);
        this.bodyModel[3].field_78796_g = 3.1415927f;
        this.turretModel = new ModelRendererTurbo[2];
        this.turretModel[0] = new ModelRendererTurbo(this, 0, 132, 256, 256);
        this.turretModel[1] = new ModelRendererTurbo(this, 128, 132, 256, 256);
        this.turretModel[0].addTrapezoid(-16.0f, -6.0f, -16.0f, 32, 12, 32, 0.0f, -2.0f, 4);
        this.turretModel[1].flip = true;
        this.turretModel[1].addTrapezoid(-15.5f, -6.0f, -15.5f, 31, 9, 31, 0.0f, -1.5f, 4);
        this.turretModel[0].func_78793_a(0.0f, -38.0f, 0.0f);
        this.turretModel[1].func_78793_a(0.0f, -38.0f, 0.0f);
        this.barrelModel = new ModelRendererTurbo[1];
        this.barrelModel[0] = new ModelRendererTurbo(this, 0, 176, 256, 256);
        this.barrelModel[0].func_78790_a(-2.0f, -2.0f, -2.0f, 60, 4, 4, 0.0f);
        this.barrelModel[0].func_78793_a(15.0f, -38.0f, 0.0f);
        ModelRendererTurbo[][] arrmodelRendererTurbo = new ModelRendererTurbo[][]{new ModelRendererTurbo[0], new ModelRendererTurbo[4], null};
        arrmodelRendererTurbo[1][0] = new ModelRendererTurbo(this, 0, 28, 256, 256);
        arrmodelRendererTurbo[1][1] = new ModelRendererTurbo(this, 0, 23, 256, 256);
        arrmodelRendererTurbo[1][2] = new ModelRendererTurbo(this, 8, 26, 256, 256);
        arrmodelRendererTurbo[1][3] = new ModelRendererTurbo(this, 18, 19, 256, 256);
        arrmodelRendererTurbo[1][0].addBox(0.0f, 3.0f, -1.0f, 16, 2, 2);
        arrmodelRendererTurbo[1][1].addBox(4.0f, 5.0f, -1.0f, 2, 3, 2);
        arrmodelRendererTurbo[1][2].addBox(16.0f, 3.5f, -0.5f, 4, 1, 1);
        arrmodelRendererTurbo[1][3].addBox(8.0f, 3.0f, -6.0f, 2, 4, 5);
        for (ModelRendererTurbo modelRendererTurbo : arrmodelRendererTurbo[1]) {
            modelRendererTurbo.func_78793_a(0.0f, -52.0f, 0.0f);
        }
        arrmodelRendererTurbo[2] = new ModelRendererTurbo[0];
        this.registerGunModel("MG42", arrmodelRendererTurbo);
        this.flipAll();
        this.translateAll(0, -8, 0);
    }
}

