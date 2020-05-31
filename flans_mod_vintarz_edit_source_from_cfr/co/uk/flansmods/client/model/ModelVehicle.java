/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.model.ModelDriveable;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import co.uk.flansmods.common.RotatedAxes;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.EntityVehicle;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.driveables.Seat;
import co.uk.flansmods.common.driveables.VehicleType;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL11;

public class ModelVehicle
extends ModelDriveable {
    private static final Map displayLists = new HashMap();
    public ModelRendererTurbo[] turretModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] barrelModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] frontWheelModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] backWheelModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] leftFrontWheelModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] rightFrontWheelModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] leftBackWheelModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] rightBackWheelModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] rightTrackModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] leftTrackModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] rightTrackWheelModels = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] leftTrackWheelModels = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] bodyDoorOpenModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] bodyDoorCloseModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] trailerModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] steeringWheelModel = new ModelRendererTurbo[0];

    @Override
    public void render(EntityDriveable entityDriveable, float f) {
        this.render(0.0625f, (EntityVehicle)entityDriveable, f);
    }

    @Override
    public void render(DriveableType driveableType) {
        super.render(driveableType);
        this.renderPart(this.leftBackWheelModel);
        this.renderPart(this.rightBackWheelModel);
        this.renderPart(this.leftFrontWheelModel);
        this.renderPart(this.rightFrontWheelModel);
        this.renderPart(this.rightTrackModel);
        this.renderPart(this.leftTrackModel);
        this.renderPart(this.rightTrackWheelModels);
        this.renderPart(this.leftTrackWheelModels);
        this.renderPart(this.bodyDoorCloseModel);
        this.renderPart(this.trailerModel);
        this.renderPart(this.turretModel);
        this.renderPart(this.barrelModel);
        this.renderPart(this.steeringWheelModel);
    }

    public void render(float f, EntityVehicle entityVehicle, float f2) {
        int n;
        boolean bl = entityVehicle.getVehicleType().rotateWheels;
        if (entityVehicle.isPartIntact(EnumDriveablePart.core)) {
            EntitySeat[] arrentitySeat = (EntitySeat[])displayLists.get(entityVehicle.driveableType);
            if (arrentitySeat != null) {
                GL11.glCallList((int)arrentitySeat.intValue());
            } else {
                int n2 = GL11.glGenLists((int)1);
                GL11.glNewList((int)n2, (int)4865);
                for (n = 0; n < this.bodyModel.length; ++n) {
                    this.bodyModel[n].renderNoDL(f);
                }
                for (n = 0; n < this.bodyDoorOpenModel.length; ++n) {
                    if (!entityVehicle.varDoor) continue;
                    this.bodyDoorOpenModel[n].renderNoDL(f);
                }
                for (n = 0; n < this.bodyDoorCloseModel.length; ++n) {
                    if (entityVehicle.varDoor) continue;
                    this.bodyDoorCloseModel[n].renderNoDL(f);
                }
                GL11.glEndList();
                displayLists.put(entityVehicle.driveableType, n2);
            }
            for (n = 0; n < this.steeringWheelModel.length; ++n) {
                this.steeringWheelModel[n].field_78795_f = entityVehicle.wheelsYaw * 3.1415927f / 180.0f * 3.0f;
                this.steeringWheelModel[n].func_78785_a(f);
            }
        }
        if (entityVehicle.isPartIntact(EnumDriveablePart.backLeftWheel)) {
            for (n = 0; n < this.leftBackWheelModel.length; ++n) {
                this.leftBackWheelModel[n].field_78808_h = bl ? -entityVehicle.wheelsAngle : 0.0f;
                this.leftBackWheelModel[n].func_78785_a(f);
            }
        }
        if (entityVehicle.isPartIntact(EnumDriveablePart.backRightWheel)) {
            for (n = 0; n < this.rightBackWheelModel.length; ++n) {
                this.rightBackWheelModel[n].field_78808_h = bl ? -entityVehicle.wheelsAngle : 0.0f;
                this.rightBackWheelModel[n].func_78785_a(f);
            }
        }
        if (entityVehicle.isPartIntact(EnumDriveablePart.frontLeftWheel)) {
            for (n = 0; n < this.leftFrontWheelModel.length; ++n) {
                this.leftFrontWheelModel[n].field_78808_h = bl ? -entityVehicle.wheelsAngle : 0.0f;
                this.leftFrontWheelModel[n].field_78796_g = -entityVehicle.wheelsYaw * 3.1415927f / 180.0f * 3.0f;
                this.leftFrontWheelModel[n].func_78785_a(f);
            }
        }
        if (entityVehicle.isPartIntact(EnumDriveablePart.frontRightWheel)) {
            for (n = 0; n < this.rightFrontWheelModel.length; ++n) {
                this.rightFrontWheelModel[n].field_78808_h = bl ? -entityVehicle.wheelsAngle : 0.0f;
                this.rightFrontWheelModel[n].field_78796_g = -entityVehicle.wheelsYaw * 3.1415927f / 180.0f * 3.0f;
                this.rightFrontWheelModel[n].func_78785_a(f);
            }
        }
        if (entityVehicle.isPartIntact(EnumDriveablePart.frontWheel)) {
            for (n = 0; n < this.frontWheelModel.length; ++n) {
                this.frontWheelModel[n].field_78808_h = bl ? -entityVehicle.wheelsAngle : 0.0f;
                this.frontWheelModel[n].field_78796_g = -entityVehicle.wheelsYaw * 3.1415927f / 180.0f * 3.0f;
                this.frontWheelModel[n].func_78785_a(f);
            }
        }
        if (entityVehicle.isPartIntact(EnumDriveablePart.backWheel)) {
            for (n = 0; n < this.backWheelModel.length; ++n) {
                this.backWheelModel[n].field_78808_h = bl ? -entityVehicle.wheelsAngle : 0.0f;
                this.backWheelModel[n].func_78785_a(f);
            }
        }
        for (EntitySeat entitySeat : entityVehicle.seats) {
            if (entitySeat == null || entitySeat.seatInfo == null || entitySeat.seatInfo.gunName == null || this.gunModels.get(entitySeat.seatInfo.gunName) == null || !entityVehicle.isPartIntact(entitySeat.seatInfo.part)) continue;
            float f3 = entitySeat.prevLooking.getYaw() + (entitySeat.looking.getYaw() - entitySeat.prevLooking.getYaw()) * f2;
            float f4 = entitySeat.prevLooking.getPitch() + (entitySeat.looking.getPitch() - entitySeat.prevLooking.getPitch()) * f2;
            ModelRendererTurbo[][] arrmodelRendererTurbo = (ModelRendererTurbo[][])this.gunModels.get(entitySeat.seatInfo.gunName);
            for (ModelRendererTurbo modelRendererTurbo : arrmodelRendererTurbo[0]) {
                modelRendererTurbo.field_78796_g = -f3 * 3.1415927f / 180.0f;
                modelRendererTurbo.func_78785_a(f);
            }
            for (ModelRendererTurbo modelRendererTurbo : arrmodelRendererTurbo[1]) {
                modelRendererTurbo.field_78796_g = -f3 * 3.1415927f / 180.0f;
                modelRendererTurbo.field_78808_h = -f4 * 3.1415927f / 180.0f;
                modelRendererTurbo.func_78785_a(f);
            }
            for (ModelRendererTurbo modelRendererTurbo : arrmodelRendererTurbo[2]) {
                modelRendererTurbo.field_78796_g = -f3 * 3.1415927f / 180.0f;
                modelRendererTurbo.field_78808_h = -f4 * 3.1415927f / 180.0f;
                modelRendererTurbo.func_78785_a(f);
            }
        }
    }

    public void renderTurret(float f, float f2, float f3, float f4, float f5, float f6, EntityVehicle entityVehicle) {
        int n;
        entityVehicle.seats[0].looking.getYaw();
        float f7 = entityVehicle.seats[0].looking.getPitch();
        for (n = 0; n < this.turretModel.length; ++n) {
            this.turretModel[n].func_78785_a(f6);
        }
        for (n = 0; n < this.barrelModel.length; ++n) {
            this.barrelModel[n].field_78808_h = -f7 * 3.1415927f / 180.0f;
            this.barrelModel[n].func_78785_a(f6);
        }
    }

    @Override
    public void flipAll() {
        super.flipAll();
        this.flip(this.bodyDoorOpenModel);
        this.flip(this.bodyDoorCloseModel);
        this.flip(this.turretModel);
        this.flip(this.barrelModel);
        this.flip(this.leftFrontWheelModel);
        this.flip(this.rightFrontWheelModel);
        this.flip(this.leftBackWheelModel);
        this.flip(this.rightBackWheelModel);
        this.flip(this.rightTrackModel);
        this.flip(this.leftTrackModel);
        this.flip(this.rightTrackWheelModels);
        this.flip(this.leftTrackWheelModels);
        this.flip(this.trailerModel);
        this.flip(this.steeringWheelModel);
        this.flip(this.frontWheelModel);
        this.flip(this.backWheelModel);
    }

    @Override
    public void translateAll(float f, float f2, float f3) {
        super.translateAll(f, f2, f3);
        this.translate(this.bodyDoorOpenModel, f, f2, f3);
        this.translate(this.bodyDoorCloseModel, f, f2, f3);
        this.translate(this.turretModel, f, f2, f3);
        this.translate(this.barrelModel, f, f2, f3);
        this.translate(this.leftFrontWheelModel, f, f2, f3);
        this.translate(this.rightFrontWheelModel, f, f2, f3);
        this.translate(this.leftBackWheelModel, f, f2, f3);
        this.translate(this.rightBackWheelModel, f, f2, f3);
        this.translate(this.rightTrackModel, f, f2, f3);
        this.translate(this.leftTrackModel, f, f2, f3);
        this.translate(this.rightTrackWheelModels, f, f2, f3);
        this.translate(this.leftTrackWheelModels, f, f2, f3);
        this.translate(this.trailerModel, f, f2, f3);
        this.translate(this.steeringWheelModel, f, f2, f3);
        this.translate(this.frontWheelModel, f, f2, f3);
        this.translate(this.backWheelModel, f, f2, f3);
    }
}

