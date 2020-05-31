/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.entity.Entity
 */
package co.uk.flansmods.client.model.mw;

import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelClaymore
extends ModelBase {
    public ModelRendererTurbo[] claymoreModel = new ModelRendererTurbo[2];

    public ModelClaymore() {
        this.claymoreModel[0] = new ModelRendererTurbo(this, 0, 0, 32, 16);
        this.claymoreModel[0].addBox(-1.0f, 2.0f, -4.0f, 2, 4, 8);
        this.claymoreModel[1] = new ModelRendererTurbo(this, 12, 4, 32, 16);
        this.claymoreModel[1].addBox(0.0f, -2.0f, -4.0f, 0, 4, 8);
    }

    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        for (ModelRendererTurbo modelRendererTurbo : this.claymoreModel) {
            modelRendererTurbo.func_78785_a(f6);
        }
    }
}

