/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.entity.Entity
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelBomb
extends ModelBase {
    public ModelRendererTurbo[] bombModel = new ModelRendererTurbo[4];

    public ModelBomb() {
        this.bombModel[0] = new ModelRendererTurbo(this, 104, 0, 128, 64);
        this.bombModel[1] = new ModelRendererTurbo(this, 104, 0, 128, 64);
        this.bombModel[2] = new ModelRendererTurbo(this, 56, 8, 128, 64);
        this.bombModel[3] = new ModelRendererTurbo(this, 56, 8, 128, 64);
        this.bombModel[0].addTrapezoid(-2.0f, 0.0f, -2.0f, 4, 1, 4, 0.0f, 1.0f, 4);
        this.bombModel[1].func_78790_a(-2.0f, 1.0f, -2.0f, 4, 6, 4, 0.0f);
        this.bombModel[2].addTrapezoid(-2.0f, 7.0f, -2.0f, 4, 1, 4, 0.0f, 1.0f, 5);
        this.bombModel[3].func_78790_a(-2.0f, 8.0f, -2.0f, 4, 2, 4, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        for (int i = 0; i < 4; ++i) {
            this.bombModel[i].func_78785_a(f6);
        }
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
    }
}

