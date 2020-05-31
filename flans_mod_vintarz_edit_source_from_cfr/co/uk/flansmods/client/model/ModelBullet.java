/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  org.lwjgl.opengl.GL11
 */
package co.uk.flansmods.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelBullet
extends ModelBase {
    public ModelRenderer bulletModel = new ModelRenderer((ModelBase)this, 0, 0);

    public ModelBullet() {
        this.bulletModel.func_78789_a(-0.5f, -1.5f, -0.5f, 1, 3, 1);
    }

    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        this.bulletModel.func_78785_a(f6);
    }
}

