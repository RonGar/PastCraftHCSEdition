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

public class ModelJeep
extends ModelVehicle {
    public ModelJeep() {
        this.bodyModel = new ModelRendererTurbo[11];
        this.bodyModel[0] = new ModelRendererTurbo(this, 0, 0, 128, 128);
        this.bodyModel[1] = new ModelRendererTurbo(this, 0, 94, 128, 128);
        this.bodyModel[2] = new ModelRendererTurbo(this, 0, 40, 128, 128);
        this.bodyModel[3] = new ModelRendererTurbo(this, 0, 40, 128, 128);
        this.bodyModel[4] = new ModelRendererTurbo(this, 60, 12, 128, 128);
        this.bodyModel[5] = new ModelRendererTurbo(this, 0, 43, 128, 128);
        this.bodyModel[6] = new ModelRendererTurbo(this, 60, 0, 128, 128);
        this.bodyModel[7] = new ModelRendererTurbo(this, 60, 0, 128, 128);
        this.bodyModel[8] = new ModelRendererTurbo(this, 32, 49, 128, 128);
        this.bodyModel[9] = new ModelRendererTurbo(this, 90, 28, 128, 128);
        this.bodyModel[10] = new ModelRendererTurbo(this, 66, 49, 128, 128);
        this.bodyModel[0].func_78790_a(8.0f, -10.0f, -14.0f, 16, 12, 28, 0.0f);
        this.bodyModel[1].func_78790_a(-24.0f, 0.0f, -16.0f, 32, 2, 32, 0.0f);
        this.bodyModel[2].func_78790_a(8.0f, -4.0f, -16.0f, 16, 1, 2, 0.0f);
        this.bodyModel[3].func_78790_a(8.0f, -4.0f, 14.0f, 16, 1, 2, 0.0f);
        this.bodyModel[4].func_78790_a(-6.0f, -8.0f, -14.0f, 1, 8, 28, 0.0f);
        this.bodyModel[5].func_78790_a(-24.0f, -10.0f, -14.0f, 4, 10, 28, 0.0f);
        this.bodyModel[6].func_78790_a(-24.0f, -10.0f, -16.0f, 32, 10, 2, 0.0f);
        this.bodyModel[7].func_78790_a(-24.0f, -10.0f, -16.0f, 32, 10, 2, 0.0f);
        this.bodyModel[7].doMirror(false, false, true);
        this.bodyModel[8].func_78790_a(8.0f, -18.0f, -16.0f, 1, 8, 32, 0.0f);
        this.bodyModel[9].func_78790_a(-4.0f, -4.0f, -1.0f, 8, 8, 2, 0.0f);
        this.bodyModel[9].field_78796_g = 1.5707964f;
        this.bodyModel[9].func_78793_a(-25.0f, -6.0f, 0.0f);
        this.bodyModel[10].func_78790_a(-6.0f, -22.0f, -0.5f, 1, 14, 1, 0.0f);
        this.leftBackWheelModel = new ModelRendererTurbo[1];
        this.leftBackWheelModel[0] = new ModelRendererTurbo(this, 90, 22, 128, 128);
        this.leftBackWheelModel[0].func_78790_a(-20.0f, 2.0f, -15.0f, 8, 4, 2, 0.0f);
        this.rightBackWheelModel = new ModelRendererTurbo[1];
        this.rightBackWheelModel[0] = new ModelRendererTurbo(this, 90, 22, 128, 128);
        this.rightBackWheelModel[0].func_78790_a(-20.0f, 2.0f, 13.0f, 8, 4, 2, 0.0f);
        this.leftFrontWheelModel = new ModelRendererTurbo[1];
        this.leftFrontWheelModel[0] = new ModelRendererTurbo(this, 90, 28, 128, 128);
        this.leftFrontWheelModel[0].func_78790_a(-4.0f, -4.0f, -1.0f, 8, 8, 2, 0.0f);
        this.leftFrontWheelModel[0].func_78793_a(16.0f, 2.0f, 15.0f);
        this.rightFrontWheelModel = new ModelRendererTurbo[1];
        this.rightFrontWheelModel[0] = new ModelRendererTurbo(this, 90, 28, 128, 128);
        this.rightFrontWheelModel[0].func_78790_a(-4.0f, -4.0f, -1.0f, 8, 8, 2, 0.0f);
        this.rightFrontWheelModel[0].func_78793_a(16.0f, 2.0f, -15.0f);
        ModelRendererTurbo[][] arrmodelRendererTurbo = new ModelRendererTurbo[][]{new ModelRendererTurbo[0], new ModelRendererTurbo[4], null};
        arrmodelRendererTurbo[1][0] = new ModelRendererTurbo(this, 66, 73, 128, 128);
        arrmodelRendererTurbo[1][1] = new ModelRendererTurbo(this, 66, 79, 128, 128);
        arrmodelRendererTurbo[1][2] = new ModelRendererTurbo(this, 80, 68, 128, 128);
        arrmodelRendererTurbo[1][3] = new ModelRendererTurbo(this, 66, 64, 128, 128);
        arrmodelRendererTurbo[1][0].addBox(-8.0f, -1.5f, -1.5f, 12, 3, 3);
        arrmodelRendererTurbo[1][1].addBox(4.0f, -0.5f, -0.5f, 10, 1, 1);
        arrmodelRendererTurbo[1][2].addBox(-10.0f, 0.0f, -1.0f, 2, 3, 2);
        arrmodelRendererTurbo[1][3].addBox(0.0f, -1.0f, -6.0f, 2, 4, 5);
        for (ModelRendererTurbo modelRendererTurbo : arrmodelRendererTurbo[1]) {
            modelRendererTurbo.func_78793_a(-6.0f, -18.0f, 0.0f);
        }
        arrmodelRendererTurbo[2] = new ModelRendererTurbo[0];
        this.registerGunModel("Browning", arrmodelRendererTurbo);
        this.flipAll();
        this.translateAll(0, -4, 0);
    }
}

