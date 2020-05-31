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
import co.uk.flansmods.client.model.ModelVehicle;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.RotatedAxes;
import co.uk.flansmods.common.driveables.CollisionBox;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.EntityVehicle;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.driveables.PilotGun;
import co.uk.flansmods.common.driveables.VehicleType;
import co.uk.flansmods.common.vector.Vector3f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.rojd;
import org.lwjgl.opengl.GL11;

public class RenderVehicle
extends uyfg {
    public RenderVehicle() {
        this.field_76989_e = 0.5f;
    }

    public void render(EntityVehicle entityVehicle, double d, double d2, double d3, float f, float f2) {
        float f5;
        float f4;
        float f3;
        this.func_110777_b((Entity)entityVehicle);
        VehicleType vehicleType = entityVehicle.getVehicleType();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
        for (f4 = entityVehicle.axes.getYaw() - entityVehicle.field_70126_B; f4 > 180.0f; f4 -= 360.0f) {
        }
        while (f4 <= -180.0f) {
            f4 += 360.0f;
        }
        for (f5 = entityVehicle.axes.getPitch() - entityVehicle.field_70127_C; f5 > 180.0f; f5 -= 360.0f) {
        }
        while (f5 <= -180.0f) {
            f5 += 360.0f;
        }
        for (f3 = entityVehicle.axes.getRoll() - entityVehicle.prevRotationRoll; f3 > 180.0f; f3 -= 360.0f) {
        }
        while (f3 <= -180.0f) {
            f3 += 360.0f;
        }
        GL11.glRotatef((float)(180.0f - entityVehicle.field_70126_B - f4 * f2), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(entityVehicle.field_70127_C + f5 * f2), (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glRotatef((float)(entityVehicle.prevRotationRoll + f3 * f2), (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        float f6 = vehicleType.modelScale;
        GL11.glPushMatrix();
        GL11.glScalef((float)f6, (float)f6, (float)f6);
        ModelVehicle modelVehicle = (ModelVehicle)vehicleType.model;
        if (modelVehicle != null) {
            modelVehicle.render(entityVehicle, f2);
        }
        GL11.glPushMatrix();
        if (vehicleType.barrelPosition != null && entityVehicle.isPartIntact(EnumDriveablePart.turret) && entityVehicle.seats != null && entityVehicle.seats[0] != null) {
            float f7 = entityVehicle.seats[0].prevLooking.getYaw() + (entityVehicle.seats[0].looking.getYaw() - entityVehicle.seats[0].prevLooking.getYaw()) * f2;
            GL11.glTranslatef((float)vehicleType.barrelPosition.x, (float)vehicleType.barrelPosition.y, (float)vehicleType.barrelPosition.z);
            GL11.glRotatef((float)(-f7), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glTranslatef((float)(-vehicleType.barrelPosition.x), (float)(-vehicleType.barrelPosition.y), (float)(-vehicleType.barrelPosition.z));
            if (modelVehicle != null) {
                modelVehicle.renderTurret(0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f, entityVehicle);
            }
            if (FlansMod.DEBUG) {
                GL11.glColor4f((float)0.0f, (float)0.0f, (float)1.0f, (float)0.3f);
                for (PilotGun pilotGun : vehicleType.guns) {
                    if (pilotGun.driveablePart != EnumDriveablePart.turret) continue;
                    RenderVehicle.func_76980_a((rojd)rojd.func_72330_a((double)(pilotGun.position.x - 0.25f), (double)(pilotGun.position.y - 0.25f), (double)(pilotGun.position.z - 0.25f), (double)(pilotGun.position.x + 0.25f), (double)(pilotGun.position.y + 0.25f), (double)(pilotGun.position.z + 0.25f)));
                }
            }
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
        if (FlansMod.DEBUG) {
            GL11.glDisable((int)3553);
            GL11.glEnable((int)3042);
            GL11.glDisable((int)2929);
            GL11.glColor4f((float)1.0f, (float)0.0f, (float)0.0f, (float)0.3f);
            GL11.glScalef((float)1.0f, (float)1.0f, (float)1.0f);
            for (DriveablePart driveablePart : entityVehicle.getDriveableData().parts.values()) {
                if (driveablePart.box == null) continue;
                RenderVehicle.func_76980_a((rojd)rojd.func_72330_a((double)((float)driveablePart.box.x / 16.0f), (double)((float)driveablePart.box.y / 16.0f), (double)((float)driveablePart.box.z / 16.0f), (double)((float)(driveablePart.box.x + driveablePart.box.w) / 16.0f), (double)((float)(driveablePart.box.y + driveablePart.box.h) / 16.0f), (double)((float)(driveablePart.box.z + driveablePart.box.d) / 16.0f)));
            }
            GL11.glColor4f((float)0.0f, (float)1.0f, (float)0.0f, (float)0.3f);
            if (vehicleType.barrelPosition != null) {
                RenderVehicle.func_76980_a((rojd)rojd.func_72330_a((double)(vehicleType.barrelPosition.x - 0.25f), (double)(vehicleType.barrelPosition.y - 0.25f), (double)(vehicleType.barrelPosition.z - 0.25f), (double)(vehicleType.barrelPosition.x + 0.25f), (double)(vehicleType.barrelPosition.y + 0.25f), (double)(vehicleType.barrelPosition.z + 0.25f)));
            }
            GL11.glColor4f((float)0.0f, (float)0.0f, (float)1.0f, (float)0.3f);
            for (PilotGun pilotGun : vehicleType.guns) {
                if (pilotGun.driveablePart == EnumDriveablePart.turret) continue;
                RenderVehicle.func_76980_a((rojd)rojd.func_72330_a((double)(pilotGun.position.x - 0.25f), (double)(pilotGun.position.y - 0.25f), (double)(pilotGun.position.z - 0.25f), (double)(pilotGun.position.x + 0.25f), (double)(pilotGun.position.y + 0.25f), (double)(pilotGun.position.z + 0.25f)));
            }
            GL11.glColor4f((float)0.0f, (float)0.0f, (float)0.0f, (float)0.3f);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2929);
            GL11.glDisable((int)3042);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.render((EntityVehicle)entity, d, d2, d3, f, f2);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return FlansModResourceHandler.getTexture(((EntityVehicle)entity).getVehicleType());
    }
}

