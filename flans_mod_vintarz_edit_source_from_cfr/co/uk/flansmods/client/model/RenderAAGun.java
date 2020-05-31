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

import co.uk.flansmods.client.FlansModResourceHandler;
import co.uk.flansmods.client.model.ModelAAGun;
import co.uk.flansmods.common.guns.AAGunType;
import co.uk.flansmods.common.guns.EntityAAGun;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderAAGun
extends uyfg {
    public RenderAAGun() {
        this.field_76989_e = 0.5f;
    }

    public void render(EntityAAGun entityAAGun, double d, double d2, double d3, float f, float f2) {
        this.func_110777_b((Entity)entityAAGun);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
        GL11.glScalef((float)1.0f, (float)1.0f, (float)1.0f);
        ModelAAGun modelAAGun = entityAAGun.type.model;
        modelAAGun.renderBase(0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f, entityAAGun);
        GL11.glRotatef((float)(180.0f - entityAAGun.gunYaw), (float)0.0f, (float)1.0f, (float)0.0f);
        modelAAGun.renderGun(0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f, entityAAGun);
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.render((EntityAAGun)entity, d, d2, d3, f, f2);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return FlansModResourceHandler.getTexture(((EntityAAGun)entity).type);
    }
}

