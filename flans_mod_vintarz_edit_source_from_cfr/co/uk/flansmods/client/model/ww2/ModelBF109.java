/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.client.model.ww2;

import co.uk.flansmods.client.model.ModelPlane;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelBF109
extends ModelPlane {
    public ModelBF109() {
        this.bodyModel = new ModelRendererTurbo[4];
        this.bodyModel[0] = new ModelRendererTurbo(this, 0, 104, 256, 128);
        this.bodyModel[1] = new ModelRendererTurbo(this, 60, 76, 256, 128);
        this.bodyModel[2] = new ModelRendererTurbo(this, 60, 76, 256, 128);
        this.bodyModel[3] = new ModelRendererTurbo(this, 0, 76, 256, 128);
        this.bodyModel[0].addBox(-3.0f, 5.0f, -10.0f, 20, 2, 20);
        this.bodyModel[1].addBox(-3.0f, -11.0f, -10.0f, 20, 16, 2);
        this.bodyModel[2].addBox(-17.0f, -16.0f, -10.0f, 20, 16, 2);
        this.bodyModel[2].field_78796_g = 3.1415927f;
        this.bodyModel[2].setPosition(0.0f, 5.0f, 0.0f);
        this.bodyModel[3].addTrapezoid(-3.0f, -19.0f, -10.0f, 20, 8, 20, 0.0f, -3.0f, 4);
        this.bodyWheelModel = new ModelRendererTurbo[4];
        this.bodyWheelModel[0] = new ModelRendererTurbo(this, 116, 48, 256, 128);
        this.bodyWheelModel[1] = new ModelRendererTurbo(this, 116, 48, 256, 128);
        this.bodyWheelModel[2] = new ModelRendererTurbo(this, 200, 12, 256, 128);
        this.bodyWheelModel[3] = new ModelRendererTurbo(this, 200, 12, 256, 128);
        this.bodyWheelModel[0].func_78790_a(-6.0f, 14.0f, 4.0f, 6, 6, 4, 0.0f);
        this.bodyWheelModel[1].func_78790_a(-6.0f, 14.0f, -8.0f, 6, 6, 4, 0.0f);
        this.bodyWheelModel[2].func_78790_a(-4.0f, 6.0f, 5.0f, 2, 8, 2, 0.0f);
        this.bodyWheelModel[3].func_78790_a(-4.0f, 6.0f, -7.0f, 2, 8, 2, 0.0f);
        this.noseModel = new ModelRendererTurbo[2];
        this.noseModel[0] = new ModelRendererTurbo(this, 0, 38, 256, 128);
        this.noseModel[0].addTrapezoid(-51.0f, -16.0f, -10.0f, 48, 18, 20, 0.0f, -3.0f, 3);
        this.noseModel[0].setPosition(0.0f, 5.0f, 0.0f);
        this.noseModel[1] = new ModelRendererTurbo(this, 172, 12, 256, 128);
        this.noseModel[1].func_78790_a(0.0f, -2.0f, 0.0f, 4, 4, 4, 0.0f);
        this.noseModel[1].setPosition(-55.0f, -2.0f, -2.0f);
        this.bayModel = new ModelRendererTurbo[1];
        this.bayModel[0] = new ModelRendererTurbo(this, 0, 0, 256, 128);
        this.bayModel[0].addTrapezoid(17.0f, -16.0f, -10.0f, 76, 18, 20, 0.0f, -3.0f, 2);
        this.bayModel[0].setPosition(0.0f, 5.0f, 0.0f);
        this.tailWheelModel = new ModelRendererTurbo[2];
        this.tailWheelModel[0] = new ModelRendererTurbo(this, 116, 48, 256, 128);
        this.tailWheelModel[1] = new ModelRendererTurbo(this, 200, 12, 256, 128);
        this.tailWheelModel[0].func_78790_a(79.0f, 6.0f, -2.0f, 6, 6, 4, 0.0f);
        this.tailWheelModel[1].func_78790_a(81.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f);
        this.rightWingModel = new ModelRendererTurbo[2];
        this.rightWingModel[0] = new ModelRendererTurbo(this, 58, 48, 256, 128);
        this.rightWingModel[1] = new ModelRendererTurbo(this, 172, 0, 256, 128);
        this.rightWingModel[0].func_78790_a(-25.0f, 3.0f, 0.0f, 32, 2, 78, 0.0f);
        this.rightWingModel[1].addTrapezoid(-25.0f, 3.0f, 78.0f, 32, 2, 10, 0.0f, -1.0f, 1);
        this.leftWingModel = new ModelRendererTurbo[2];
        this.leftWingModel[0] = new ModelRendererTurbo(this, 58, 48, 256, 128);
        this.leftWingModel[1] = new ModelRendererTurbo(this, 172, 0, 256, 128);
        this.leftWingModel[0].addBox(-32.0f, -2.0f, -78.0f, 32, 2, 78);
        this.leftWingModel[0].field_78796_g = 3.1415927f;
        this.leftWingModel[0].setPosition(-25.0f, 5.0f, -78.0f);
        this.leftWingModel[1].addTrapezoid(-32.0f, 3.0f, -88.0f, 32, 2, 10, 0.0f, -1.0f, 1);
        this.leftWingModel[1].field_78796_g = 3.1415927f;
        this.leftWingModel[1].setPosition(-25.0f, 0.0f, -166.0f);
        this.propellerModels = new ModelRendererTurbo[1][3];
        this.propellerModels[0][0] = new ModelRendererTurbo(this, 192, 12, 256, 128);
        this.propellerModels[0][1] = new ModelRendererTurbo(this, 192, 12, 256, 128);
        this.propellerModels[0][2] = new ModelRendererTurbo(this, 192, 12, 256, 128);
        this.propellerModels[0][0].func_78790_a(-0.0f, -12.0f, -1.0f, 2, 11, 2, 0.0f);
        this.propellerModels[0][1].func_78790_a(-0.0f, -12.0f, -1.0f, 2, 11, 2, 0.0f);
        this.propellerModels[0][2].func_78790_a(-0.0f, -12.0f, -1.0f, 2, 11, 2, 0.0f);
        this.propellerModels[0][0].func_78793_a(-54.0f, -2.0f, 0.0f);
        this.propellerModels[0][1].func_78793_a(-54.0f, -2.0f, 0.0f);
        this.propellerModels[0][2].func_78793_a(-54.0f, -2.0f, 0.0f);
        this.yawFlapModel = new ModelRendererTurbo[1];
        this.yawFlapModel[0] = new ModelRendererTurbo(this, 220, 12, 256, 128);
        this.yawFlapModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 16, 20, 2, 0.0f);
        this.yawFlapModel[0].setPosition(76.0f, -22.0f, -1.0f);
        this.pitchFlapLeftModel = new ModelRendererTurbo[1];
        this.pitchFlapLeftModel[0] = new ModelRendererTurbo(this, 220, 12, 256, 128);
        this.pitchFlapLeftModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 16, 22, 2, 0.0f);
        this.pitchFlapLeftModel[0].field_78795_f = 1.570796f;
        this.pitchFlapLeftModel[0].setPosition(76.0f, 1.0f, -22.0f);
        this.pitchFlapRightModel = new ModelRendererTurbo[1];
        this.pitchFlapRightModel[0] = new ModelRendererTurbo(this, 220, 12, 256, 128);
        this.pitchFlapRightModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 16, 22, 2, 0.0f);
        this.pitchFlapRightModel[0].field_78795_f = 1.570796f;
        this.pitchFlapRightModel[0].setPosition(76.0f, 1.0f, 0.0f);
        this.flipAll();
    }
}

