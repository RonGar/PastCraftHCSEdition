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
import co.uk.flansmods.client.model.ModelMG;
import co.uk.flansmods.common.guns.EntityMG;
import co.uk.flansmods.common.guns.GunType;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderMG
extends uyfg {
    public RenderMG() {
        this.field_76989_e = 0.5f;
    }

    public void render(EntityMG entityMG, double d, double d2, double d3, float f, float f2) {
        this.func_110777_b((Entity)entityMG);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
        GL11.glRotatef((float)(180.0f - (float)entityMG.direction * 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        ModelMG modelMG = entityMG.type.deployableModel;
        if (modelMG != null) {
            modelMG.renderBipod(0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f, entityMG);
            GL11.glRotatef((float)(-(entityMG.field_70126_B + (entityMG.field_70177_z - entityMG.field_70126_B) * f2)), (float)0.0f, (float)1.0f, (float)0.0f);
            modelMG.renderGun(0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f, f2, entityMG);
            GL11.glPopMatrix();
        }
    }

    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.render((EntityMG)entity, d, d2, d3, f, f2);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return FlansModResourceHandler.getDeployableTexture(((EntityMG)entity).type);
    }
}

