/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.rojd
 *  org.lwjgl.opengl.GL11
 *  uyfg
 */
package co.uk.flansmods.client.debug;

import co.uk.flansmods.client.debug.EntityDebugAABB;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.rojd;
import org.lwjgl.opengl.GL11;

public class RenderDebugAABB
extends uyfg {
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        if (FlansMod.DEBUG) {
            EntityDebugAABB entityDebugAABB = (EntityDebugAABB)entity;
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2929);
            GL11.glEnable((int)3042);
            GL11.glColor4f((float)entityDebugAABB.red, (float)entityDebugAABB.green, (float)entityDebugAABB.blue, (float)0.9f);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
            RenderDebugAABB.func_76980_a((rojd)rojd.func_72330_a((double)0.0, (double)0.0, (double)0.0, (double)entityDebugAABB.vector.x, (double)entityDebugAABB.vector.y, (double)entityDebugAABB.vector.z));
            GL11.glPopMatrix();
            GL11.glDisable((int)3042);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2929);
        }
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return null;
    }
}

