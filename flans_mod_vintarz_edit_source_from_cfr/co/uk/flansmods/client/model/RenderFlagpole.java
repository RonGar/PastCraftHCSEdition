/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  uyfg
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.model.ModelFlagpole;
import co.uk.flansmods.common.teams.EntityFlagpole;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderFlagpole
extends uyfg {
    private static final ResourceLocation texture = new ResourceLocation("flansmod", "teamsMod/Flagpole.png");
    public ModelFlagpole modelFlagpole = new ModelFlagpole();

    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.func_110777_b(entity);
        EntityFlagpole entityFlagpole = (EntityFlagpole)entity;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
        GL11.glRotatef((float)f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glScalef((float)-1.0f, (float)-1.0f, (float)1.0f);
        GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
        this.modelFlagpole.renderPole(0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f, entityFlagpole);
        GL11.glPopMatrix();
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return texture;
    }
}

