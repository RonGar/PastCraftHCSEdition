/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package co.uk.flansmods.client.model.nerf;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDisc
extends ModelBase {
    public ModelRenderer bulletModel = new ModelRenderer((ModelBase)this, 0, 0);

    public ModelDisc() {
        this.bulletModel.func_78789_a(-1.0f, -1.0f, -0.5f, 2, 2, 1);
    }

    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.bulletModel.func_78785_a(f6);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
    }
}

