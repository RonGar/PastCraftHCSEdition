/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.client.model.ww2;

import co.uk.flansmods.client.model.ModelPlane;
import co.uk.flansmods.client.tmt.Coord2D;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import co.uk.flansmods.client.tmt.Shape2D;
import net.minecraft.client.model.ModelBase;

public class ModelLancaster
extends ModelPlane {
    private int textureX = 512;
    private int textureY = 512;

    public ModelLancaster() {
        ModelRendererTurbo[] arrmodelRendererTurbo;
        Object object;
        Object object2;
        Object object3;
        int n;
        ModelRendererTurbo[] arrmodelRendererTurbo2;
        int n2;
        this.bodyModel = new ModelRendererTurbo[25];
        this.bodyModel[0] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
        this.bodyModel[0].addTrapezoid(-160.0f, -80.0f, -16.0f, 16, 32, 32, 0.0f, -4.0f, 3);
        this.bodyModel[18] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
        this.bodyModel[18].flip = true;
        this.bodyModel[18].addTrapezoid(-160.0f, -80.0f, -16.0f, 16, 32, 32, 0.0f, -4.0f, 3);
        this.bodyModel[1] = new ModelRendererTurbo(this, 64, 0, this.textureX, this.textureY);
        this.bodyModel[1].func_78790_a(-144.0f, -80.0f, -15.0f, 16, 1, 30, 0.0f);
        this.bodyModel[2] = new ModelRendererTurbo(this, 127, 1, this.textureX, this.textureY);
        this.bodyModel[2].func_78790_a(-144.0f, -49.0f, -15.0f, 112, 1, 30, 0.0f);
        this.bodyModel[3] = new ModelRendererTurbo(this, 64, 32, this.textureX, this.textureY);
        this.bodyModel[3].addTrapezoid(-128.0f, -96.0f, -16.0f, 64, 16, 32, 0.0f, -8.0f, 4);
        this.bodyModel[16] = new ModelRendererTurbo(this, 64, 32, this.textureX, this.textureY);
        this.bodyModel[16].flip = true;
        this.bodyModel[16].addTrapezoid(-128.0f, -96.0f, -16.0f, 64, 16, 32, 0.0f, -8.0f, 4);
        this.bodyModel[4] = new ModelRendererTurbo(this, 0, 80, this.textureX, this.textureY);
        this.bodyModel[4].func_78790_a(-144.0f, -80.0f, -16.0f, 112, 32, 1, 0.0f);
        this.bodyModel[5] = new ModelRendererTurbo(this, 0, 80, this.textureX, this.textureY);
        this.bodyModel[5].func_78790_a(-144.0f, -80.0f, -16.0f, 112, 32, 1, 0.0f);
        this.bodyModel[5].func_78793_a(-176.0f, 0.0f, 0.0f);
        this.bodyModel[5].field_78796_g = 3.1415927f;
        this.bodyModel[19] = new ModelRendererTurbo(this, 0, 445, this.textureX, this.textureY);
        this.bodyModel[19].func_78790_a(-8.0f, 16.0f, -8.0f, 16, 2, 16, 0.0f);
        this.bodyModel[19].func_78793_a(-116.0f, -88.0f, 0.0f);
        this.bodyModel[19].field_78796_g = 3.1415927f;
        this.bodyModel[20] = new ModelRendererTurbo(this, 0, 463, this.textureX, this.textureY);
        this.bodyModel[20].func_78790_a(-8.0f, 0.0f, -8.0f, 2, 16, 16, 0.0f);
        this.bodyModel[20].func_78793_a(-116.0f, -88.0f, 0.0f);
        this.bodyModel[20].field_78796_g = 3.1415927f;
        this.bodyModel[21] = new ModelRendererTurbo(this, 0, 445, this.textureX, this.textureY);
        this.bodyModel[21].func_78790_a(-8.0f, 16.0f, -8.0f, 16, 2, 16, 0.0f);
        this.bodyModel[21].func_78793_a(-90.0f, -76.0f, 0.0f);
        this.bodyModel[21].field_78796_g = 3.1415927f;
        this.bodyModel[22] = new ModelRendererTurbo(this, 0, 463, this.textureX, this.textureY);
        this.bodyModel[22].func_78790_a(-8.0f, 0.0f, -8.0f, 2, 16, 16, 0.0f);
        this.bodyModel[22].func_78793_a(-90.0f, -76.0f, 0.0f);
        this.bodyModel[22].field_78796_g = 3.1415927f;
        this.bodyModel[23] = new ModelRendererTurbo(this, 0, 445, this.textureX, this.textureY);
        this.bodyModel[23].func_78790_a(-8.0f, 16.0f, -8.0f, 16, 2, 16, 0.0f);
        this.bodyModel[23].func_78793_a(-68.0f, -76.0f, 0.0f);
        this.bodyModel[23].field_78796_g = 3.1415927f;
        this.bodyModel[24] = new ModelRendererTurbo(this, 0, 463, this.textureX, this.textureY);
        this.bodyModel[24].func_78790_a(-8.0f, 0.0f, -8.0f, 2, 16, 16, 0.0f);
        this.bodyModel[24].func_78793_a(-68.0f, -76.0f, 0.0f);
        this.bodyModel[24].field_78796_g = 3.1415927f;
        this.bodyModel[6] = new ModelRendererTurbo(this, 226, 80, this.textureX, this.textureY);
        this.bodyModel[6].func_78790_a(-71.0f, -96.0f, -15.0f, 103, 1, 30, 0.0f);
        this.bodyModel[7] = new ModelRendererTurbo(this, 432, 24, this.textureX, this.textureY);
        this.bodyModel[7].func_78790_a(-72.0f, -96.0f, -16.0f, 1, 16, 32, 0.0f);
        this.bodyModel[8] = new ModelRendererTurbo(this, 0, 245, this.textureX, this.textureY);
        this.bodyModel[8].func_78790_a(0.0f, 0.0f, -16.0f, 199, 16, 1, 0.0f);
        this.bodyModel[8].func_78793_a(-71.0f, -96.0f, 0.0f);
        this.bodyModel[9] = new ModelRendererTurbo(this, 0, 245, this.textureX, this.textureY);
        this.bodyModel[9].func_78790_a(0.0f, 0.0f, -16.0f, 199, 16, 1, 0.0f);
        this.bodyModel[9].func_78793_a(-71.0f, -96.0f, 0.0f);
        this.bodyModel[9].doMirror(false, false, true);
        this.bodyModel[10] = new ModelRendererTurbo(this, 38, 262, this.textureX, this.textureY);
        this.bodyModel[10].func_78790_a(0.0f, 0.0f, -16.0f, 160, 16, 1, 0.0f);
        this.bodyModel[10].func_78793_a(-32.0f, -80.0f, 0.0f);
        this.bodyModel[11] = new ModelRendererTurbo(this, 38, 262, this.textureX, this.textureY);
        this.bodyModel[11].func_78790_a(0.0f, 0.0f, -16.0f, 160, 16, 1, 0.0f);
        this.bodyModel[11].func_78793_a(-32.0f, -80.0f, 0.0f);
        this.bodyModel[11].doMirror(false, false, true);
        this.bodyModel[12] = new ModelRendererTurbo(this, 144, 279, this.textureX, this.textureY);
        this.bodyModel[12].addTrapezoid(32.0f, -112.0f, -16.0f, 32, 16, 32, 0.0f, -8.0f, 4);
        this.bodyModel[17] = new ModelRendererTurbo(this, 144, 279, this.textureX, this.textureY);
        this.bodyModel[17].flip = true;
        this.bodyModel[17].addTrapezoid(32.0f, -112.0f, -16.0f, 32, 16, 32, 0.0f, -8.0f, 4);
        ModelRendererTurbo[][] arrmodelRendererTurbo3 = new ModelRendererTurbo[][]{new ModelRendererTurbo[4], null, null};
        arrmodelRendererTurbo3[0][0] = new ModelRendererTurbo(this, 0, 445, this.textureX, this.textureY);
        arrmodelRendererTurbo3[0][0].func_78790_a(-8.0f, 16.0f, -8.0f, 16, 2, 16, 0.0f);
        arrmodelRendererTurbo3[0][1] = new ModelRendererTurbo(this, 0, 463, this.textureX, this.textureY);
        arrmodelRendererTurbo3[0][1].func_78790_a(-8.0f, 0.0f, -8.0f, 2, 16, 16, 0.0f);
        arrmodelRendererTurbo3[0][2] = new ModelRendererTurbo(this, 40, 381, this.textureX, this.textureY);
        arrmodelRendererTurbo3[0][2].func_78790_a(8.0f, -6.0f, -7.0f, 2, 24, 2, 0.0f);
        arrmodelRendererTurbo3[0][3] = new ModelRendererTurbo(this, 40, 381, this.textureX, this.textureY);
        arrmodelRendererTurbo3[0][3].func_78790_a(8.0f, -6.0f, 5.0f, 2, 24, 2, 0.0f);
        arrmodelRendererTurbo3[1] = new ModelRendererTurbo[3];
        arrmodelRendererTurbo3[1][0] = new ModelRendererTurbo(this, 40, 411, this.textureX, this.textureY);
        arrmodelRendererTurbo3[1][0].func_78790_a(8.0f, -1.0f, 3.0f, 24, 2, 2, 0.0f);
        arrmodelRendererTurbo3[1][1] = new ModelRendererTurbo(this, 40, 411, this.textureX, this.textureY);
        arrmodelRendererTurbo3[1][1].func_78790_a(8.0f, -1.0f, -5.0f, 24, 2, 2, 0.0f);
        arrmodelRendererTurbo3[1][2] = new ModelRendererTurbo(this, 40, 415, this.textureX, this.textureY);
        arrmodelRendererTurbo3[1][2].func_78790_a(8.0f, -1.0f, -3.0f, 2, 2, 6, 0.0f);
        arrmodelRendererTurbo3[2] = new ModelRendererTurbo[0];
        ModelRendererTurbo[][] arrmodelRendererTurbo4 = arrmodelRendererTurbo3;
        for (int i = 0; i < 3; ++i) {
            object3 = arrmodelRendererTurbo = arrmodelRendererTurbo4[i];
            n = arrmodelRendererTurbo.length;
            for (n2 = 0; n2 < n; ++n2) {
                object2 = object3[n2];
                object2.func_78793_a(48.0f, -104.0f, 0.0f);
            }
        }
        this.registerGunModel("Dorsal", arrmodelRendererTurbo3);
        arrmodelRendererTurbo4 = new ModelRendererTurbo[][]{new ModelRendererTurbo[4], null, null};
        arrmodelRendererTurbo4[0][0] = new ModelRendererTurbo(this, 0, 445, this.textureX, this.textureY);
        arrmodelRendererTurbo4[0][0].func_78790_a(-8.0f, 16.0f, -8.0f, 16, 2, 16, 0.0f);
        arrmodelRendererTurbo4[0][1] = new ModelRendererTurbo(this, 0, 463, this.textureX, this.textureY);
        arrmodelRendererTurbo4[0][1].func_78790_a(-8.0f, 0.0f, -8.0f, 2, 16, 16, 0.0f);
        arrmodelRendererTurbo4[0][2] = new ModelRendererTurbo(this, 40, 381, this.textureX, this.textureY);
        arrmodelRendererTurbo4[0][2].func_78790_a(8.0f, -6.0f, -7.0f, 2, 24, 2, 0.0f);
        arrmodelRendererTurbo4[0][3] = new ModelRendererTurbo(this, 40, 381, this.textureX, this.textureY);
        arrmodelRendererTurbo4[0][3].func_78790_a(8.0f, -6.0f, 5.0f, 2, 24, 2, 0.0f);
        arrmodelRendererTurbo4[1] = new ModelRendererTurbo[3];
        arrmodelRendererTurbo4[1][0] = new ModelRendererTurbo(this, 40, 411, this.textureX, this.textureY);
        arrmodelRendererTurbo4[1][0].func_78790_a(8.0f, -1.0f, 3.0f, 24, 2, 2, 0.0f);
        arrmodelRendererTurbo4[1][1] = new ModelRendererTurbo(this, 40, 411, this.textureX, this.textureY);
        arrmodelRendererTurbo4[1][1].func_78790_a(8.0f, -1.0f, -5.0f, 24, 2, 2, 0.0f);
        arrmodelRendererTurbo4[1][2] = new ModelRendererTurbo(this, 40, 415, this.textureX, this.textureY);
        arrmodelRendererTurbo4[1][2].func_78790_a(8.0f, -1.0f, -3.0f, 2, 2, 6, 0.0f);
        arrmodelRendererTurbo4[2] = new ModelRendererTurbo[0];
        arrmodelRendererTurbo = arrmodelRendererTurbo4;
        for (n = 0; n < 3; ++n) {
            object = object3 = arrmodelRendererTurbo[n];
            n2 = ((ModelRendererTurbo[])object3).length;
            for (object2 = (Object)false; object2 < n2; ++object2) {
                arrmodelRendererTurbo2 = object[object2];
                arrmodelRendererTurbo2.func_78793_a(-148.0f, -70.0f, 0.0f);
            }
        }
        this.registerGunModel("Nose", arrmodelRendererTurbo4);
        arrmodelRendererTurbo = new ModelRendererTurbo[][]{new ModelRendererTurbo[4], null, null};
        arrmodelRendererTurbo[0][0] = new ModelRendererTurbo(this, 0, 445, this.textureX, this.textureY);
        arrmodelRendererTurbo[0][0].func_78790_a(-8.0f, 16.0f, -8.0f, 16, 2, 16, 0.0f);
        arrmodelRendererTurbo[0][1] = new ModelRendererTurbo(this, 0, 463, this.textureX, this.textureY);
        arrmodelRendererTurbo[0][1].func_78790_a(-8.0f, 0.0f, -8.0f, 2, 16, 16, 0.0f);
        arrmodelRendererTurbo[0][2] = new ModelRendererTurbo(this, 40, 381, this.textureX, this.textureY);
        arrmodelRendererTurbo[0][2].func_78790_a(8.0f, -6.0f, -7.0f, 2, 24, 2, 0.0f);
        arrmodelRendererTurbo[0][3] = new ModelRendererTurbo(this, 40, 381, this.textureX, this.textureY);
        arrmodelRendererTurbo[0][3].func_78790_a(8.0f, -6.0f, 5.0f, 2, 24, 2, 0.0f);
        arrmodelRendererTurbo[1] = new ModelRendererTurbo[3];
        arrmodelRendererTurbo[1][0] = new ModelRendererTurbo(this, 40, 411, this.textureX, this.textureY);
        arrmodelRendererTurbo[1][0].func_78790_a(8.0f, -1.0f, 3.0f, 24, 2, 2, 0.0f);
        arrmodelRendererTurbo[1][1] = new ModelRendererTurbo(this, 40, 411, this.textureX, this.textureY);
        arrmodelRendererTurbo[1][1].func_78790_a(8.0f, -1.0f, -5.0f, 24, 2, 2, 0.0f);
        arrmodelRendererTurbo[1][2] = new ModelRendererTurbo(this, 40, 415, this.textureX, this.textureY);
        arrmodelRendererTurbo[1][2].func_78790_a(8.0f, -1.0f, -3.0f, 2, 2, 6, 0.0f);
        arrmodelRendererTurbo[2] = new ModelRendererTurbo[0];
        arrmodelRendererTurbo2 = arrmodelRendererTurbo;
        for (int i = 0; i < 3; ++i) {
            Object object4 = object = arrmodelRendererTurbo2[i];
            object2 = ((ModelRendererTurbo[])object).length;
            for (int j = 0; j < object2; ++j) {
                ModelRendererTurbo modelRendererTurbo = object4[j];
                modelRendererTurbo.func_78793_a(128.0f, -88.0f, 0.0f);
            }
        }
        this.registerGunModel("Tail", (ModelRendererTurbo[][])arrmodelRendererTurbo);
        this.bodyModel[13] = new ModelRendererTurbo(this, 52, 362, this.textureX, this.textureY);
        this.bodyModel[13].addShape3D(128.0f, -65.0f, -15.0f, new Shape2D(new Coord2D[]{new Coord2D(0.0, 0.0, 0, 0), new Coord2D(160.0, 16.0, 160, 0), new Coord2D(160.0, 17.0, 160, 1), new Coord2D(0.0, 1.0, 0, 1)}), 30.0f, 160, 1, 322, 30, 0, new float[]{1.0f, 160.0f, 1.0f, 160.0f});
        this.bodyModel[13].field_78795_f = 3.1415927f;
        this.bodyModel[14] = new ModelRendererTurbo(this, 52, 345, this.textureX, this.textureY);
        this.bodyModel[14].addShape3D(128.0f, -64.0f, -16.0f, new Shape2D(new Coord2D[]{new Coord2D(0.0, 0.0, 0, 0), new Coord2D(160.0, 0.0, 160, 0), new Coord2D(160.0, 16.0, 160, 16)}), 1.0f, 160, 16, 336, 1, 0, new float[]{160.0f, 16.0f, 160.0f});
        this.bodyModel[14].field_78795_f = 3.1415927f;
        this.bodyModel[15] = new ModelRendererTurbo(this, 52, 394, this.textureX, this.textureY);
        this.bodyModel[15].addShape3D(128.0f, -64.0f, 15.0f, new Shape2D(new Coord2D[]{new Coord2D(0.0, 0.0, 0, 0), new Coord2D(160.0, 0.0, 160, 0), new Coord2D(160.0, 16.0, 160, 16)}), 1.0f, 160, 16, 336, 1, 0, new float[]{160.0f, 16.0f, 160.0f});
        this.bodyModel[15].field_78795_f = 3.1415927f;
        this.tailModel = new ModelRendererTurbo[7];
        this.tailModel[0] = new ModelRendererTurbo(this, 0, 279, this.textureX, this.textureY);
        this.tailModel[0].func_78790_a(96.0f, 16.0f, -82.0f, 16, 64, 2, 0.0f);
        this.tailModel[0].field_78795_f = -1.5707964f;
        this.tailModel[1] = new ModelRendererTurbo(this, 0, 279, this.textureX, this.textureY);
        this.tailModel[1].func_78790_a(96.0f, 16.0f, -82.0f, 16, 64, 2, 0.0f);
        this.tailModel[1].doMirror(false, true, false);
        this.tailModel[1].field_78795_f = -1.5707964f;
        this.tailModel[2] = new ModelRendererTurbo(this, 72, 279, this.textureX, this.textureY);
        this.tailModel[2].func_78790_a(96.0f, -128.0f, 80.0f, 16, 64, 2, 0.0f);
        this.tailModel[3] = new ModelRendererTurbo(this, 72, 279, this.textureX, this.textureY);
        this.tailModel[3].func_78790_a(96.0f, -128.0f, -82.0f, 16, 64, 2, 0.0f);
        this.tailModel[4] = new ModelRendererTurbo(this, 240, 279, this.textureX, this.textureY);
        this.tailModel[4].func_78790_a(64.0f, -96.0f, -15.0f, 64, 1, 30, 0.0f);
        this.tailModel[5] = new ModelRendererTurbo(this, 304, 111, this.textureX, this.textureY);
        this.tailModel[5].addTrapezoid(128.0f, -96.0f, -16.0f, 16, 32, 32, 0.0f, -6.0f, 2);
        this.tailModel[6] = new ModelRendererTurbo(this, 304, 111, this.textureX, this.textureY);
        this.tailModel[6].flip = true;
        this.tailModel[6].addTrapezoid(128.0f, -96.0f, -16.0f, 16, 32, 32, 0.0f, -6.0f, 2);
        this.tailWheelModel = new ModelRendererTurbo[2];
        this.tailWheelModel[0] = new ModelRendererTurbo(this, 36, 463, this.textureX, this.textureY);
        this.tailWheelModel[0].addBox(98.0f, -63.0f, -3.0f, 4, 16, 6);
        this.tailWheelModel[1] = new ModelRendererTurbo(this, 84, 447, this.textureX, this.textureY);
        this.tailWheelModel[1].addBox(94.0f, -53.0f, -2.0f, 12, 12, 4);
        this.leftWingModel = new ModelRendererTurbo[6];
        this.leftWingModel[0] = new ModelRendererTurbo(this, 0, 113, this.textureX, this.textureY);
        this.leftWingModel[0].func_78790_a(-64.0f, 16.0f, -82.0f, 64, 96, 4, 0.0f);
        this.leftWingModel[0].field_78795_f = -1.5707964f;
        this.leftWingModel[1] = new ModelRendererTurbo(this, 136, 113, this.textureX, this.textureY);
        this.leftWingModel[1].addTrapezoid(-64.0f, 112.0f, -82.0f, 80, 128, 4, 0.0f, -2.0f, 5);
        this.leftWingModel[1].field_78795_f = -1.5707964f;
        this.leftWingModel[2] = new ModelRendererTurbo(this, 256, 32, this.textureX, this.textureY);
        this.leftWingModel[2].addTrapezoid(-112.0f, -80.0f, -64.0f, 64, 24, 24, 0.0f, -2.0f, 5);
        this.leftWingModel[3] = new ModelRendererTurbo(this, 256, 32, this.textureX, this.textureY);
        this.leftWingModel[3].addTrapezoid(-96.0f, -80.0f, -128.0f, 64, 24, 24, 0.0f, -2.0f, 5);
        this.leftWingModel[4] = new ModelRendererTurbo(this, 408, 24, this.textureX, this.textureY);
        this.leftWingModel[4].func_78790_a(-115.0f, -76.0f, -60.0f, 6, 16, 16, 0.0f);
        this.leftWingModel[5] = new ModelRendererTurbo(this, 408, 24, this.textureX, this.textureY);
        this.leftWingModel[5].func_78790_a(-99.0f, -76.0f, -124.0f, 6, 16, 16, 0.0f);
        this.leftWingWheelModel = new ModelRendererTurbo[2];
        this.leftWingWheelModel[0] = new ModelRendererTurbo(this, 48, 415, this.textureX, this.textureY);
        this.leftWingWheelModel[0].addBox(-82.0f, -56.0f, -58.0f, 4, 24, 12);
        this.leftWingWheelModel[1] = new ModelRendererTurbo(this, 80, 415, this.textureX, this.textureY);
        this.leftWingWheelModel[1].addBox(-92.0f, -44.0f, -56.0f, 24, 24, 8);
        this.rightWingModel = new ModelRendererTurbo[6];
        this.rightWingModel[0] = new ModelRendererTurbo(this, 0, 113, this.textureX, this.textureY);
        this.rightWingModel[0].func_78790_a(-64.0f, 16.0f, -82.0f, 64, 96, 4, 0.0f);
        this.rightWingModel[0].doMirror(false, true, false);
        this.rightWingModel[0].field_78795_f = -1.5707964f;
        this.rightWingModel[1] = new ModelRendererTurbo(this, 136, 113, this.textureX, this.textureY);
        this.rightWingModel[1].addTrapezoid(-64.0f, 112.0f, -82.0f, 80, 128, 4, 0.0f, -2.0f, 5);
        this.rightWingModel[1].doMirror(false, true, false);
        this.rightWingModel[1].field_78795_f = -1.5707964f;
        this.rightWingModel[2] = new ModelRendererTurbo(this, 256, 32, this.textureX, this.textureY);
        this.rightWingModel[2].addTrapezoid(-112.0f, -80.0f, 40.0f, 64, 24, 24, 0.0f, -2.0f, 5);
        this.rightWingModel[3] = new ModelRendererTurbo(this, 256, 32, this.textureX, this.textureY);
        this.rightWingModel[3].addTrapezoid(-96.0f, -80.0f, 104.0f, 64, 24, 24, 0.0f, -2.0f, 5);
        this.rightWingModel[4] = new ModelRendererTurbo(this, 408, 24, this.textureX, this.textureY);
        this.rightWingModel[4].func_78790_a(-115.0f, -76.0f, 44.0f, 6, 16, 16, 0.0f);
        this.rightWingModel[5] = new ModelRendererTurbo(this, 408, 24, this.textureX, this.textureY);
        this.rightWingModel[5].func_78790_a(-99.0f, -76.0f, 108.0f, 6, 16, 16, 0.0f);
        this.rightWingWheelModel = new ModelRendererTurbo[2];
        this.rightWingWheelModel[0] = new ModelRendererTurbo(this, 48, 415, this.textureX, this.textureY);
        this.rightWingWheelModel[0].addBox(-82.0f, -56.0f, 46.0f, 4, 24, 12);
        this.rightWingWheelModel[1] = new ModelRendererTurbo(this, 80, 415, this.textureX, this.textureY);
        this.rightWingWheelModel[1].addBox(-92.0f, -44.0f, 48.0f, 24, 24, 8);
        this.propellerModels = new ModelRendererTurbo[4][3];
        this.propellerModels[1] = this.makeProp(-114, -68, 52);
        this.propellerModels[0] = this.makeProp(-114, -68, -52);
        this.propellerModels[3] = this.makeProp(-98, -68, 116);
        this.propellerModels[2] = this.makeProp(-98, -68, -116);
        this.yawFlapModel = new ModelRendererTurbo[2];
        this.yawFlapModel[0] = new ModelRendererTurbo(this, 108, 279, this.textureX, this.textureY);
        this.yawFlapModel[0].func_78790_a(0.0f, -48.0f, -1.0f, 16, 64, 2, 0.0f);
        this.yawFlapModel[0].setPosition(112.0f, -80.0f, 81.0f);
        this.yawFlapModel[1] = new ModelRendererTurbo(this, 108, 279, this.textureX, this.textureY);
        this.yawFlapModel[1].func_78790_a(0.0f, -48.0f, -1.0f, 16, 64, 2, 0.0f);
        this.yawFlapModel[1].setPosition(112.0f, -80.0f, -81.0f);
        this.pitchFlapLeftWingModel = new ModelRendererTurbo[1];
        this.pitchFlapLeftWingModel[0] = new ModelRendererTurbo(this, 0, 345, this.textureX, this.textureY);
        this.pitchFlapLeftWingModel[0].func_78790_a(0.0f, -48.0f, -2.0f, 16, 96, 4, 0.0f);
        this.pitchFlapLeftWingModel[0].field_78795_f = 1.570796f;
        this.pitchFlapLeftWingModel[0].setPosition(0.0f, -80.0f, -64.0f);
        this.pitchFlapLeftModel = new ModelRendererTurbo[1];
        this.pitchFlapLeftModel[0] = new ModelRendererTurbo(this, 36, 279, this.textureX, this.textureY);
        this.pitchFlapLeftModel[0].func_78790_a(0.0f, -32.0f, -1.0f, 16, 64, 2, 0.0f);
        this.pitchFlapLeftModel[0].field_78795_f = 1.570796f;
        this.pitchFlapLeftModel[0].setPosition(112.0f, -81.0f, 48.0f);
        this.pitchFlapRightWingModel = new ModelRendererTurbo[1];
        this.pitchFlapRightWingModel[0] = new ModelRendererTurbo(this, 0, 345, this.textureX, this.textureY);
        this.pitchFlapRightWingModel[0].func_78790_a(0.0f, -48.0f, -2.0f, 16, 96, 4, 0.0f);
        this.pitchFlapRightWingModel[0].doMirror(false, true, false);
        this.pitchFlapRightWingModel[0].field_78795_f = 1.570796f;
        this.pitchFlapRightWingModel[0].setPosition(0.0f, -80.0f, 64.0f);
        this.pitchFlapRightModel = new ModelRendererTurbo[1];
        this.pitchFlapRightModel[0] = new ModelRendererTurbo(this, 36, 279, this.textureX, this.textureY);
        this.pitchFlapRightModel[0].func_78790_a(0.0f, -32.0f, -1.0f, 16, 64, 2, 0.0f);
        this.pitchFlapRightModel[0].field_78795_f = 1.570796f;
        this.pitchFlapRightModel[0].setPosition(112.0f, -81.0f, -48.0f);
        this.translateAll(0, 52, 0);
        this.flipAll();
    }

    private ModelRendererTurbo[] makeProp(int n, int n2, int n3) {
        ModelRendererTurbo[] arrmodelRendererTurbo = new ModelRendererTurbo[]{new ModelRendererTurbo(this, 40, 345, this.textureX, this.textureY), new ModelRendererTurbo(this, 40, 345, this.textureX, this.textureY), new ModelRendererTurbo(this, 40, 345, this.textureX, this.textureY)};
        arrmodelRendererTurbo[0].func_78790_a(-0.0f, -32.0f, -2.0f, 2, 32, 4, 0.0f);
        arrmodelRendererTurbo[0].func_78793_a((float)n, (float)n2, (float)n3);
        arrmodelRendererTurbo[1].func_78790_a(-0.0f, -32.0f, -2.0f, 2, 32, 4, 0.0f);
        arrmodelRendererTurbo[1].func_78793_a((float)n, (float)n2, (float)n3);
        arrmodelRendererTurbo[2].func_78790_a(-0.0f, -32.0f, -2.0f, 2, 32, 4, 0.0f);
        arrmodelRendererTurbo[2].func_78793_a((float)n, (float)n2, (float)n3);
        return arrmodelRendererTurbo;
    }
}

