/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.client.model.ww2;

import co.uk.flansmods.client.model.ModelAAGun;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelFlakvierling
extends ModelAAGun {
    public ModelFlakvierling() {
        this.baseModel = new ModelRendererTurbo[4];
        this.baseModel[0] = new ModelRendererTurbo(this, 0, 0, 128, 64);
        this.baseModel[1] = new ModelRendererTurbo(this, 0, 18, 128, 64);
        this.baseModel[2] = new ModelRendererTurbo(this, 0, 18, 128, 64);
        this.baseModel[3] = new ModelRendererTurbo(this, 0, 18, 128, 64);
        this.baseModel[0].func_78790_a(-12.0f, -4.0f, -8.0f, 24, 2, 16, 0.0f);
        this.baseModel[1].func_78790_a(-20.0f, -4.0f, -4.0f, 8, 4, 8, 0.0f);
        this.baseModel[2].func_78790_a(4.0f, -4.0f, 8.0f, 8, 4, 8, 0.0f);
        this.baseModel[3].func_78790_a(4.0f, -4.0f, -16.0f, 8, 4, 8, 0.0f);
        this.seatModel = new ModelRendererTurbo[5];
        this.seatModel[0] = new ModelRendererTurbo(this, 0, 30, 128, 64);
        this.seatModel[1] = new ModelRendererTurbo(this, 96, 0, 128, 64);
        this.seatModel[2] = new ModelRendererTurbo(this, 96, 0, 128, 64);
        this.seatModel[3] = new ModelRendererTurbo(this, 0, 48, 128, 64);
        this.seatModel[4] = new ModelRendererTurbo(this, 0, 48, 128, 64);
        this.seatModel[0].func_78790_a(-8.0f, -6.0f, -8.0f, 16, 2, 16, 0.0f);
        this.seatModel[1].func_78790_a(6.0f, -26.0f, -20.0f, 2, 20, 14, 0.0f);
        this.seatModel[2].func_78790_a(6.0f, -26.0f, 6.0f, 2, 20, 14, 0.0f);
        this.seatModel[3].func_78790_a(-12.0f, -10.0f, 4.0f, 12, 1, 12, 0.0f);
        this.seatModel[4].func_78790_a(-8.0f, -9.0f, 5.0f, 2, 3, 2, 0.0f);
        this.gunModel = new ModelRendererTurbo[1];
        this.gunModel[0] = new ModelRendererTurbo(this, 48, 18, 128, 64);
        this.gunModel[0].func_78790_a(0.0f, 0.0f, 0.0f, 12, 12, 12, 0.0f);
        this.barrelModel = new ModelRendererTurbo[4][1];
        this.barrelModel[0][0] = new ModelRendererTurbo(this, 64, 0, 128, 64);
        this.barrelModel[1][0] = new ModelRendererTurbo(this, 64, 0, 128, 64);
        this.barrelModel[2][0] = new ModelRendererTurbo(this, 64, 0, 128, 64);
        this.barrelModel[3][0] = new ModelRendererTurbo(this, 64, 0, 128, 64);
        this.barrelModel[0][0].func_78790_a(12.0f, 1.0f, 1.0f, 20, 2, 2, 0.0f);
        this.barrelModel[1][0].func_78790_a(12.0f, 9.0f, 1.0f, 20, 2, 2, 0.0f);
        this.barrelModel[2][0].func_78790_a(12.0f, 1.0f, 9.0f, 20, 2, 2, 0.0f);
        this.barrelModel[3][0].func_78790_a(12.0f, 9.0f, 9.0f, 20, 2, 2, 0.0f);
        this.ammoModel = new ModelRendererTurbo[0][0];
        this.barrelX = 0;
        this.barrelY = 16;
        this.barrelZ = 6;
        this.flipAll();
    }
}

