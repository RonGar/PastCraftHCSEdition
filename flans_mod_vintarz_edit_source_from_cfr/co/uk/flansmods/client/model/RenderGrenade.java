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
import co.uk.flansmods.common.RotatedAxes;
import co.uk.flansmods.common.guns.EntityGrenade;
import co.uk.flansmods.common.guns.GrenadeType;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGrenade
extends uyfg {
    public RenderGrenade() {
        this.field_76989_e = 0.5f;
    }

    public void render(EntityGrenade entityGrenade, double d, double d2, double d3, float f, float f2) {
        this.func_110777_b((Entity)entityGrenade);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
        if (entityGrenade.stuck) {
            GL11.glRotatef((float)(180.0f - entityGrenade.axes.getYaw()), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)entityGrenade.axes.getPitch(), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)entityGrenade.axes.getRoll(), (float)1.0f, (float)0.0f, (float)0.0f);
        } else {
            float f3;
            float f4;
            float f5;
            for (f5 = entityGrenade.axes.getYaw() - entityGrenade.field_70126_B; f5 > 180.0f; f5 -= 360.0f) {
            }
            while (f5 <= -180.0f) {
                f5 += 360.0f;
            }
            for (f4 = entityGrenade.axes.getPitch() - entityGrenade.field_70127_C; f4 > 180.0f; f4 -= 360.0f) {
            }
            while (f4 <= -180.0f) {
                f4 += 360.0f;
            }
            for (f3 = entityGrenade.axes.getRoll() - entityGrenade.prevRotationRoll; f3 > 180.0f; f3 -= 360.0f) {
            }
            while (f3 <= -180.0f) {
                f3 += 360.0f;
            }
            GL11.glRotatef((float)(180.0f - entityGrenade.field_70126_B - f5 * f2), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(entityGrenade.field_70127_C + f4 * f2), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)(entityGrenade.prevRotationRoll + f3 * f2), (float)1.0f, (float)0.0f, (float)0.0f);
        }
        ModelBase modelBase = entityGrenade.type.model;
        modelBase.func_78088_a((Entity)entityGrenade, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.render((EntityGrenade)entity, d, d2, d3, f, f2);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return FlansModResourceHandler.getTexture(((EntityGrenade)entity).type);
    }
}

