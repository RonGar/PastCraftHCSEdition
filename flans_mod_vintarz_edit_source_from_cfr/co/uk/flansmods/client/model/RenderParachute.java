/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  uyfg
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.FlansModResourceHandler;
import co.uk.flansmods.common.EntityParachute;
import co.uk.flansmods.common.ToolType;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderParachute
extends uyfg {
    public RenderParachute() {
        this.field_76989_e = 0.5f;
    }

    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.func_110777_b(entity);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
        GL11.glRotatef((float)(-f), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-entity.field_70127_C - (entity.field_70125_A - entity.field_70127_C) * f2), (float)1.0f, (float)0.0f, (float)0.0f);
        ModelBase modelBase = ((EntityParachute)entity).type.model;
        modelBase.func_78088_a(entity, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return FlansModResourceHandler.getTexture(((EntityParachute)entity).type);
    }
}

