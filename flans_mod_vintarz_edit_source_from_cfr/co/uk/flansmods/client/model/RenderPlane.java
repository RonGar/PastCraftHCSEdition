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
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.FlansModResourceHandler;
import co.uk.flansmods.client.model.ModelDriveable;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.driveables.CollisionBox;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntityPlane;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.driveables.PilotGun;
import co.uk.flansmods.common.driveables.PlaneType;
import co.uk.flansmods.common.driveables.Propeller;
import co.uk.flansmods.common.vector.Vector3f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.rojd;
import org.lwjgl.opengl.GL11;

public class RenderPlane
extends uyfg {
    public RenderPlane() {
        this.field_76989_e = 0.5f;
    }

    public void render(EntityPlane entityPlane, double d, double d2, double d3, float f, float f2) {
        float f5;
        float f4;
        float f3;
        this.func_110777_b((Entity)entityPlane);
        PlaneType planeType = entityPlane.getPlaneType();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
        for (f4 = entityPlane.axes.getYaw() - entityPlane.field_70126_B; f4 > 180.0f; f4 -= 360.0f) {
        }
        while (f4 <= -180.0f) {
            f4 += 360.0f;
        }
        for (f5 = entityPlane.axes.getPitch() - entityPlane.field_70127_C; f5 > 180.0f; f5 -= 360.0f) {
        }
        while (f5 <= -180.0f) {
            f5 += 360.0f;
        }
        for (f3 = entityPlane.axes.getRoll() - entityPlane.prevRotationRoll; f3 > 180.0f; f3 -= 360.0f) {
        }
        while (f3 <= -180.0f) {
            f3 += 360.0f;
        }
        GL11.glRotatef((float)(180.0f - entityPlane.field_70126_B - f4 * f2), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(entityPlane.field_70127_C + f5 * f2), (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glRotatef((float)(entityPlane.prevRotationRoll + f3 * f2), (float)1.0f, (float)0.0f, (float)0.0f);
        float f6 = planeType.modelScale;
        GL11.glScalef((float)f6, (float)f6, (float)f6);
        ModelDriveable modelDriveable = planeType.model;
        if (modelDriveable != null) {
            modelDriveable.render(entityPlane, f2);
        }
        if (FlansMod.DEBUG) {
            GL11.glDisable((int)3553);
            GL11.glEnable((int)3042);
            GL11.glDisable((int)2929);
            GL11.glColor4f((float)1.0f, (float)0.0f, (float)0.0f, (float)0.3f);
            GL11.glScalef((float)-1.0f, (float)1.0f, (float)-1.0f);
            for (DriveablePart object : entityPlane.getDriveableData().parts.values()) {
                if (object.box == null) continue;
                RenderPlane.func_76980_a((rojd)rojd.func_72330_a((double)((float)object.box.x / 16.0f), (double)((float)object.box.y / 16.0f), (double)((float)object.box.z / 16.0f), (double)((float)(object.box.x + object.box.w) / 16.0f), (double)((float)(object.box.y + object.box.h) / 16.0f), (double)((float)(object.box.z + object.box.d) / 16.0f)));
            }
            GL11.glColor4f((float)0.0f, (float)1.0f, (float)0.0f, (float)0.3f);
            for (Propeller propeller : planeType.propellers) {
                RenderPlane.func_76980_a((rojd)rojd.func_72330_a((double)((float)propeller.x / 16.0f - 0.25f), (double)((float)propeller.y / 16.0f - 0.25f), (double)((float)propeller.z / 16.0f - 0.25f), (double)((float)propeller.x / 16.0f + 0.25f), (double)((float)propeller.y / 16.0f + 0.25f), (double)((float)propeller.z / 16.0f + 0.25f)));
            }
            GL11.glColor4f((float)0.0f, (float)0.0f, (float)1.0f, (float)0.3f);
            for (PilotGun pilotGun : planeType.guns) {
                RenderPlane.func_76980_a((rojd)rojd.func_72330_a((double)(pilotGun.position.x - 0.25f), (double)(pilotGun.position.y - 0.25f), (double)(pilotGun.position.z - 0.25f), (double)(pilotGun.position.x + 0.25f), (double)(pilotGun.position.y + 0.25f), (double)(pilotGun.position.z + 0.25f)));
            }
            GL11.glColor4f((float)0.0f, (float)0.0f, (float)0.0f, (float)0.3f);
            if (planeType.bombPosition != null) {
                RenderPlane.func_76980_a((rojd)rojd.func_72330_a((double)(planeType.bombPosition.x - 0.25f), (double)(planeType.bombPosition.y - 0.25f), (double)(planeType.bombPosition.z - 0.25f), (double)(planeType.bombPosition.x + 0.25f), (double)(planeType.bombPosition.y + 0.25f), (double)(planeType.bombPosition.z + 0.25f)));
            }
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2929);
            GL11.glDisable((int)3042);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.render((EntityPlane)entity, d, d2, d3, f, f2);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return FlansModResourceHandler.getTexture(((EntityPlane)entity).getPlaneType());
    }
}

