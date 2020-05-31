/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  org.lwjgl.opengl.GL11
 *  uheb
 */
package co.uk.flansmods.client.model.yeolde;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelArrow
extends ModelBase {
    public ModelRenderer bulletModel = new ModelRenderer((ModelBase)this, 0, 0);

    public ModelArrow() {
        this.bulletModel.func_78789_a(-0.5f, -1.0f, -0.5f, 1, 2, 1);
    }

    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        uheb uheb2 = uheb.field_78398_a;
        GL11.glEnable((int)32826);
        GL11.glRotatef((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glRotatef((float)45.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glScalef((float)0.05625f, (float)0.05625f, (float)0.05625f);
        GL11.glTranslatef((float)-4.0f, (float)0.0f, (float)0.0f);
        GL11.glNormal3f((float)0.05625f, (float)0.0f, (float)0.0f);
        uheb2.func_78382_b();
        uheb2.func_78374_a(-7.0, -2.0, -2.0, 0.0, 0.15625);
        uheb2.func_78374_a(-7.0, -2.0, 2.0, 0.15625, 0.15625);
        uheb2.func_78374_a(-7.0, 2.0, 2.0, 0.15625, 0.3125);
        uheb2.func_78374_a(-7.0, 2.0, -2.0, 0.0, 0.3125);
        uheb2.func_78381_a();
        GL11.glNormal3f((float)-0.05625f, (float)0.0f, (float)0.0f);
        uheb2.func_78382_b();
        uheb2.func_78374_a(-7.0, 2.0, -2.0, 0.0, 0.15625);
        uheb2.func_78374_a(-7.0, 2.0, 2.0, 0.15625, 0.15625);
        uheb2.func_78374_a(-7.0, -2.0, 2.0, 0.15625, 0.3125);
        uheb2.func_78374_a(-7.0, -2.0, -2.0, 0.0, 0.3125);
        uheb2.func_78381_a();
        for (int i = 0; i < 4; ++i) {
            GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glNormal3f((float)0.0f, (float)0.0f, (float)0.05625f);
            uheb2.func_78382_b();
            uheb2.func_78374_a(-8.0, -2.0, 0.0, 0.0, 0.0);
            uheb2.func_78374_a(8.0, -2.0, 0.0, 0.5, 0.0);
            uheb2.func_78374_a(8.0, 2.0, 0.0, 0.5, 0.15625);
            uheb2.func_78374_a(-8.0, 2.0, 0.0, 0.0, 0.15625);
            uheb2.func_78381_a();
        }
        GL11.glDisable((int)32826);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
    }
}

