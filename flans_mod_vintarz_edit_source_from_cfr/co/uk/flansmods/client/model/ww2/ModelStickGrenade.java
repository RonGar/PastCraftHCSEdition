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

public class ModelStickGrenade
extends ModelBase {
    public ModelRendererTurbo headModel;
    public ModelRendererTurbo stickModel = new ModelRendererTurbo(this, 0, 0, 16, 8);

    public ModelStickGrenade() {
        this.stickModel.addBox(-0.5f, -0.5f, -3.0f, 1, 1, 4);
        this.headModel = new ModelRendererTurbo(this, 8, 0, 16, 8);
        this.headModel.addBox(-1.0f, -1.0f, 1.0f, 2, 2, 2);
        this.stickModel.field_78795_f = -1.5707964f;
        this.headModel.field_78795_f = -1.5707964f;
    }

    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.headModel.func_78785_a(f6);
        this.stickModel.func_78785_a(f6);
    }
}

