/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.client.model.yeolde;

import co.uk.flansmods.client.model.ModelPlane;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelBiplane
extends ModelPlane {
    public ModelBiplane() {
        this.propellerModels = new ModelRendererTurbo[1][3];
        this.propellerModels[0][0] = new ModelRendererTurbo(this, 56, 8, 128, 64);
        this.propellerModels[0][1] = new ModelRendererTurbo(this, 56, 8, 128, 64);
        this.propellerModels[0][2] = new ModelRendererTurbo(this, 56, 8, 128, 64);
        this.propellerModels[0][0].func_78790_a(-1.0f, 2.0f, -1.0f, 2, 5, 2, 0.0f);
        this.propellerModels[0][1].func_78790_a(-1.0f, 2.0f, -1.0f, 2, 5, 2, 0.0f);
        this.propellerModels[0][2].func_78790_a(-1.0f, 2.0f, -1.0f, 2, 5, 2, 0.0f);
        this.propellerModels[0][0].func_78793_a(-14.0f, 0.0f, 0.0f);
        this.propellerModels[0][1].func_78793_a(-14.0f, 0.0f, 0.0f);
        this.propellerModels[0][2].func_78793_a(-14.0f, 0.0f, 0.0f);
        this.yawFlapModel = new ModelRendererTurbo[1];
        this.yawFlapModel[0] = new ModelRendererTurbo(this, 104, 0, 128, 64);
        this.yawFlapModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 10, 10, 2, 0.0f);
        this.yawFlapModel[0].setPosition(40.0f, -12.0f, -1.0f);
        this.pitchFlapLeftModel = new ModelRendererTurbo[1];
        this.pitchFlapLeftModel[0] = new ModelRendererTurbo(this, 104, 0, 128, 64);
        this.pitchFlapLeftModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 10, 15, 2, 0.0f);
        this.pitchFlapLeftModel[0].field_78795_f = 1.5707964f;
        this.pitchFlapLeftModel[0].setPosition(40.0f, 3.0f, -15.0f);
        this.pitchFlapRightModel = new ModelRendererTurbo[1];
        this.pitchFlapRightModel[0] = new ModelRendererTurbo(this, 104, 0, 128, 64);
        this.pitchFlapRightModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 10, 15, 2, 0.0f);
        this.pitchFlapRightModel[0].field_78795_f = 1.5707964f;
        this.pitchFlapRightModel[0].setPosition(40.0f, 3.0f, 0.0f);
        this.bodyWheelModel = new ModelRendererTurbo[4];
        this.bodyWheelModel[0] = new ModelRendererTurbo(this, 0, 32, 128, 64);
        this.bodyWheelModel[1] = new ModelRendererTurbo(this, 0, 32, 128, 64);
        this.bodyWheelModel[2] = new ModelRendererTurbo(this, 56, 15, 128, 64);
        this.bodyWheelModel[3] = new ModelRendererTurbo(this, 56, 15, 128, 64);
        this.bodyWheelModel[0].func_78790_a(-4.0f, 11.0f, 5.0f, 4, 4, 2, 0.0f);
        this.bodyWheelModel[1].func_78790_a(-4.0f, 11.0f, -7.0f, 4, 4, 2, 0.0f);
        this.bodyWheelModel[2].func_78790_a(-3.0f, 6.0f, 5.0f, 2, 5, 2, 0.0f);
        this.bodyWheelModel[3].func_78790_a(-3.0f, 6.0f, -7.0f, 2, 5, 2, 0.0f);
        this.bodyModel = new ModelRendererTurbo[6];
        this.bodyModel[0] = new ModelRendererTurbo(this, 0, 8, 128, 64);
        this.bodyModel[1] = new ModelRendererTurbo(this, 0, 0, 128, 64);
        this.bodyModel[2] = new ModelRendererTurbo(this, 0, 0, 128, 64);
        this.bodyModel[3] = new ModelRendererTurbo(this, 0, 0, 128, 64);
        this.bodyModel[4] = new ModelRendererTurbo(this, 0, 0, 128, 64);
        this.bodyModel[5] = new ModelRendererTurbo(this, 44, 0, 128, 64);
        this.bodyModel[0].func_78790_a(-12.0f, -8.0f, -3.0f, 24, 16, 4, 0.0f);
        this.bodyModel[0].setPosition(0.0f, 4.0f, 0.0f);
        this.bodyModel[1].func_78790_a(-10.0f, -7.0f, -1.0f, 20, 6, 2, 0.0f);
        this.bodyModel[1].setPosition(-11.0f, 4.0f, 0.0f);
        this.bodyModel[2].func_78790_a(-10.0f, -7.0f, -1.0f, 20, 6, 2, 0.0f);
        this.bodyModel[2].setPosition(11.0f, 4.0f, 0.0f);
        this.bodyModel[3].func_78790_a(-10.0f, -7.0f, -1.0f, 20, 6, 2, 0.0f);
        this.bodyModel[3].setPosition(0.0f, 4.0f, -9.0f);
        this.bodyModel[4].func_78790_a(-10.0f, -7.0f, -1.0f, 20, 6, 2, 0.0f);
        this.bodyModel[4].setPosition(0.0f, 4.0f, 9.0f);
        this.bodyModel[5].func_78790_a(0.0f, 0.0f, 0.0f, 4, 4, 4, 0.0f);
        this.bodyModel[5].setPosition(-15.0f, -2.0f, -2.0f);
        this.bodyModel[0].field_78795_f = 1.5707964f;
        this.bodyModel[1].field_78796_g = 4.712389f;
        this.bodyModel[2].field_78796_g = 1.5707964f;
        this.bodyModel[3].field_78796_g = 3.1415927f;
        this.rightWingModel = new ModelRendererTurbo[5];
        this.rightWingModel[0] = new ModelRendererTurbo(this, 64, 0, 128, 64);
        this.rightWingModel[1] = new ModelRendererTurbo(this, 56, 15, 128, 64);
        this.rightWingModel[2] = new ModelRendererTurbo(this, 56, 15, 128, 64);
        this.rightWingModel[3] = new ModelRendererTurbo(this, 56, 15, 128, 64);
        this.rightWingModel[4] = new ModelRendererTurbo(this, 56, 15, 128, 64);
        this.rightWingModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 18, 41, 2, 0.0f);
        this.rightWingModel[0].field_78795_f = -1.5707964f;
        this.rightWingModel[0].setPosition(-9.0f, 0.0f, -9.0f);
        this.rightWingModel[1].func_78790_a(-7.0f, -18.0f, -40.0f, 2, 18, 2, 0.0f);
        this.rightWingModel[2].func_78790_a(5.0f, -18.0f, -40.0f, 2, 18, 2, 0.0f);
        this.rightWingModel[3].func_78790_a(-7.0f, -18.0f, -16.0f, 2, 18, 2, 0.0f);
        this.rightWingModel[4].func_78790_a(5.0f, -18.0f, -16.0f, 2, 18, 2, 0.0f);
        this.leftWingModel = new ModelRendererTurbo[5];
        this.leftWingModel[0] = new ModelRendererTurbo(this, 64, 0, 128, 64);
        this.leftWingModel[1] = new ModelRendererTurbo(this, 56, 15, 128, 64);
        this.leftWingModel[2] = new ModelRendererTurbo(this, 56, 15, 128, 64);
        this.leftWingModel[3] = new ModelRendererTurbo(this, 56, 15, 128, 64);
        this.leftWingModel[4] = new ModelRendererTurbo(this, 56, 15, 128, 64);
        this.leftWingModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 18, 41, 2, 0.0f);
        this.leftWingModel[0].field_78795_f = -1.5707964f;
        this.leftWingModel[0].setPosition(-9.0f, 0.0f, 50.0f);
        this.leftWingModel[1].func_78790_a(-7.0f, -18.0f, 38.0f, 2, 18, 2, 0.0f);
        this.leftWingModel[2].func_78790_a(5.0f, -18.0f, 38.0f, 2, 18, 2, 0.0f);
        this.leftWingModel[3].func_78790_a(-7.0f, -18.0f, 14.0f, 2, 18, 2, 0.0f);
        this.leftWingModel[4].func_78790_a(5.0f, -18.0f, 14.0f, 2, 18, 2, 0.0f);
        this.topWingModel = new ModelRendererTurbo[3];
        this.topWingModel[0] = new ModelRendererTurbo(this, 64, 0, 128, 64);
        this.topWingModel[1] = new ModelRendererTurbo(this, 64, 0, 128, 64);
        this.topWingModel[2] = new ModelRendererTurbo(this, 64, 0, 128, 64);
        this.topWingModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 18, 18, 2, 0.0f);
        this.topWingModel[0].field_78795_f = -1.5707964f;
        this.topWingModel[0].setPosition(-9.0f, -20.0f, 9.0f);
        this.topWingModel[1].func_78790_a(0.0f, 0.0f, 0.0f, 18, 41, 2, 0.0f);
        this.topWingModel[1].field_78795_f = -1.5707964f;
        this.topWingModel[1].setPosition(-9.0f, -20.0f, 50.0f);
        this.topWingModel[2].func_78790_a(0.0f, 0.0f, 0.0f, 18, 41, 2, 0.0f);
        this.topWingModel[2].field_78795_f = -1.5707964f;
        this.topWingModel[2].setPosition(-9.0f, -20.0f, -9.0f);
        this.tailModel = new ModelRendererTurbo[1];
        this.tailModel[0] = new ModelRendererTurbo(this, 0, 43, 128, 64);
        this.tailModel[0].func_78790_a(11.0f, -2.0f, -5.0f, 40, 8, 10, 0.0f);
        this.tailWheelModel = new ModelRendererTurbo[1];
        this.tailWheelModel[0] = new ModelRendererTurbo(this, 0, 32, 128, 64);
        this.tailWheelModel[0].func_78790_a(44.0f, 6.0f, -1.0f, 4, 4, 2, 0.0f);
        this.flipAll();
    }
}

