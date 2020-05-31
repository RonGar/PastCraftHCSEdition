/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  dfsc
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.rojd
 *  org.lwjgl.opengl.GL11
 *  uyfg
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.driveables.EntityWheel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.rojd;
import org.lwjgl.opengl.GL11;

public class RenderNull
extends uyfg {
    private static final ResourceLocation texture = new ResourceLocation("Flan", "null.png");
    protected ModelBase model;

    public RenderNull() {
        this.field_76989_e = 0.5f;
    }

    public void func_157_a(Entity entity, double d, double d2, double d3, float f, float f2) {
    }

    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        if (FlansMod.DEBUG && entity instanceof EntityWheel) {
            GL11.glPushMatrix();
            GL11.glTranslated((double)(-dfsc._d), (double)(-dfsc._e), (double)(-dfsc._f));
            GL11.glDisable((int)3553);
            GL11.glEnable((int)3042);
            GL11.glDisable((int)2929);
            GL11.glColor4f((float)0.0f, (float)0.0f, (float)1.0f, (float)0.3f);
            RenderNull.func_76980_a((rojd)entity.field_70121_D);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2929);
            GL11.glDisable((int)3042);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return texture;
    }
}

