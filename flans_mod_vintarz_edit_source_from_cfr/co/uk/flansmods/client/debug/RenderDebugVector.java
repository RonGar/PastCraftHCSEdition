/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  uyfg
 */
package co.uk.flansmods.client.debug;

import co.uk.flansmods.client.debug.EntityDebugVector;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderDebugVector
extends uyfg {
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        if (FlansMod.DEBUG) {
            EntityDebugVector entityDebugVector = (EntityDebugVector)entity;
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2929);
            GL11.glColor3f((float)entityDebugVector.red, (float)entityDebugVector.green, (float)entityDebugVector.blue);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
            GL11.glLineWidth((float)5.0f);
            GL11.glBegin((int)3);
            GL11.glVertex3f((float)0.0f, (float)0.0f, (float)0.0f);
            GL11.glVertex3f((float)entityDebugVector.vector.x, (float)entityDebugVector.vector.y, (float)entityDebugVector.vector.z);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2929);
        }
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return null;
    }
}

