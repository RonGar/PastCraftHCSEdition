/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.entity.Entity
 */
package co.uk.flansmods.client.model.ww2;

import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelMine
extends ModelBase {
    public ModelRendererTurbo[] mineModel = new ModelRendererTurbo[3];
    public ModelRendererTurbo buttonModel;

    public ModelMine() {
        this.mineModel[0] = new ModelRendererTurbo(this, 0, 0, 32, 8);
        this.mineModel[0].addBox(-2.0f, 0.0f, -3.0f, 4, 2, 6);
        this.mineModel[1] = new ModelRendererTurbo(this, 14, 0, 32, 8);
        this.mineModel[1].addBox(-3.0f, 0.0f, -2.0f, 1, 2, 4);
        this.mineModel[2] = new ModelRendererTurbo(this, 14, 0, 32, 8);
        this.mineModel[2].addBox(-3.0f, 0.0f, -2.0f, 1, 2, 4);
        this.mineModel[2].field_78796_g = 3.1415927f;
        this.buttonModel = new ModelRendererTurbo(this, 0, 0, 32, 8);
        this.buttonModel.addBox(-0.5f, 1.5f, -0.5f, 1, 1, 1);
    }

    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        for (ModelRendererTurbo modelRendererTurbo : this.mineModel) {
            modelRendererTurbo.func_78785_a(f6);
        }
        this.buttonModel.func_78785_a(f6);
    }
}

