/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.entity.Entity
 */
package co.uk.flansmods.client.model.yeolde;

import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelRock
extends ModelBase {
    public ModelRendererTurbo rockModel = new ModelRendererTurbo(this, 0, 0, 8, 8);

    public ModelRock() {
        this.rockModel.addBox(-1.0f, -1.0f, -1.0f, 2, 2, 2);
    }

    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.rockModel.func_78785_a(f6);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
    }
}

