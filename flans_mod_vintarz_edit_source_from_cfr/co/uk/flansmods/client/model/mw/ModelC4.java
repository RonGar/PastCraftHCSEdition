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

public class ModelC4
extends ModelBase {
    public ModelRendererTurbo[] c4Model = new ModelRendererTurbo[2];

    public ModelC4() {
        this.c4Model[0] = new ModelRendererTurbo(this, 0, 0, 32, 8);
        this.c4Model[0].addBox(-2.0f, 0.0f, -3.0f, 4, 2, 6);
        this.c4Model[1] = new ModelRendererTurbo(this, 20, 0, 32, 8);
        this.c4Model[1].addBox(-1.0f, 1.5f, -2.0f, 2, 1, 4);
    }

    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        for (ModelRendererTurbo modelRendererTurbo : this.c4Model) {
            modelRendererTurbo.func_78785_a(f6);
        }
    }
}

