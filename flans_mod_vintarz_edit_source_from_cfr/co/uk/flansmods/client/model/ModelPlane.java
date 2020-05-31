/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.model.ModelDriveable;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import co.uk.flansmods.common.RotatedAxes;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntityPlane;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.driveables.PlaneType;
import co.uk.flansmods.common.driveables.Propeller;
import co.uk.flansmods.common.driveables.Seat;
import java.util.ArrayList;
import java.util.HashMap;

public class ModelPlane
extends ModelDriveable {
    public ModelRendererTurbo[] noseModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] leftWingModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] rightWingModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] topWingModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] bayModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] tailModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[][] propellerModels = new ModelRendererTurbo[0][0];
    public ModelRendererTurbo[] yawFlapModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] pitchFlapLeftModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] pitchFlapRightModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] pitchFlapLeftWingModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] pitchFlapRightWingModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] bodyWheelModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] tailWheelModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] leftWingWheelModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] rightWingWheelModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] tailDoorOpenModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] tailDoorCloseModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] rightWingPos1Model = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] rightWingPos2Model = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] leftWingPos1Model = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] leftWingPos2Model = new ModelRendererTurbo[0];

    @Override
    public void render(EntityDriveable entityDriveable, float f) {
        this.render(0.0625f, (EntityPlane)entityDriveable, f);
    }

    @Override
    public void render(DriveableType driveableType) {
        super.render(driveableType);
        this.renderPart(this.noseModel);
        this.renderPart(this.leftWingModel);
        this.renderPart(this.rightWingModel);
        this.renderPart(this.topWingModel);
        this.renderPart(this.bayModel);
        this.renderPart(this.tailModel);
        for (ModelRendererTurbo[] arrmodelRendererTurbo : this.propellerModels) {
            for (int i = 0; i < arrmodelRendererTurbo.length; ++i) {
                arrmodelRendererTurbo[i].field_78795_f = (float)i * 2.0f * 3.1415927f / (float)arrmodelRendererTurbo.length;
                arrmodelRendererTurbo[i].func_78785_a(0.0625f);
            }
        }
        this.renderPart(this.yawFlapModel);
        this.renderPart(this.pitchFlapLeftModel);
        this.renderPart(this.pitchFlapRightModel);
        this.renderPart(this.pitchFlapLeftWingModel);
        this.renderPart(this.pitchFlapRightWingModel);
        this.renderPart(this.bodyWheelModel);
        this.renderPart(this.tailWheelModel);
        this.renderPart(this.leftWingWheelModel);
        this.renderPart(this.rightWingWheelModel);
        this.renderPart(this.tailDoorCloseModel);
        this.renderPart(this.rightWingPos1Model);
        this.renderPart(this.leftWingPos1Model);
    }

    public void render(float f, EntityPlane entityPlane, float f2) {
        reference var6_622;
        float f3 = entityPlane.propAngle;
        for (reference var6_622 : entityPlane.getPlaneType().propellers) {
            if (!entityPlane.isPartIntact(var6_622.planePart)) continue;
            int n = this.propellerModels[var6_622.ID].length;
            for (int i = 0; i < n; ++i) {
                this.propellerModels[var6_622.ID][i].field_78795_f = f3 + (float)i * 2.0f * 3.1415927f / (float)n;
                this.propellerModels[var6_622.ID][i].func_78785_a(f);
            }
        }
        if (entityPlane.isPartIntact(EnumDriveablePart.nose)) {
            for (int i = 0; i < this.noseModel.length; ++i) {
                this.noseModel[i].func_78785_a(f);
            }
        }
        if (entityPlane.isPartIntact(EnumDriveablePart.bay)) {
            for (var6_622 = (reference)false; var6_622 < this.bayModel.length; ++var6_622) {
                this.bayModel[var6_622].func_78785_a(f);
            }
        }
        if (entityPlane.isPartIntact(EnumDriveablePart.tail)) {
            for (var6_622 = (reference)false; var6_622 < this.tailModel.length; ++var6_622) {
                this.tailModel[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.tailDoorOpenModel.length; ++var6_622) {
                if (!entityPlane.varDoor) continue;
                this.tailDoorOpenModel[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.tailDoorCloseModel.length; ++var6_622) {
                if (entityPlane.varDoor) continue;
                this.tailDoorCloseModel[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.yawFlapModel.length; ++var6_622) {
                this.yawFlapModel[var6_622].field_78796_g = entityPlane.flapsYaw * 3.1415927f / 180.0f;
                this.yawFlapModel[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.pitchFlapLeftModel.length; ++var6_622) {
                this.pitchFlapLeftModel[var6_622].field_78808_h = entityPlane.flapsPitchLeft * 3.1415927f / 180.0f;
                this.pitchFlapLeftModel[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.pitchFlapRightModel.length; ++var6_622) {
                this.pitchFlapRightModel[var6_622].field_78808_h = entityPlane.flapsPitchRight * 3.1415927f / 180.0f;
                this.pitchFlapRightModel[var6_622].func_78785_a(f);
            }
        }
        if (entityPlane.isPartIntact(EnumDriveablePart.tailWheel)) {
            for (var6_622 = (reference)false; var6_622 < this.tailWheelModel.length; ++var6_622) {
                if (!entityPlane.varGear) continue;
                this.tailWheelModel[var6_622].func_78785_a(f);
            }
        }
        if (entityPlane.isPartIntact(EnumDriveablePart.leftWing)) {
            for (var6_622 = (reference)false; var6_622 < this.leftWingModel.length; ++var6_622) {
                this.leftWingModel[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.leftWingPos1Model.length; ++var6_622) {
                if (!entityPlane.varWing) continue;
                this.leftWingPos1Model[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.leftWingPos2Model.length; ++var6_622) {
                if (entityPlane.varWing) continue;
                this.leftWingPos2Model[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.pitchFlapLeftWingModel.length; ++var6_622) {
                this.pitchFlapLeftWingModel[var6_622].field_78808_h = entityPlane.flapsPitchLeft * 3.1415927f / 180.0f;
                this.pitchFlapLeftWingModel[var6_622].func_78785_a(f);
            }
        }
        if (entityPlane.isPartIntact(EnumDriveablePart.rightWing)) {
            for (var6_622 = (reference)false; var6_622 < this.rightWingModel.length; ++var6_622) {
                this.rightWingModel[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.rightWingPos1Model.length; ++var6_622) {
                if (!entityPlane.varWing) continue;
                this.rightWingPos1Model[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.rightWingPos2Model.length; ++var6_622) {
                if (entityPlane.varWing) continue;
                this.rightWingPos2Model[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.pitchFlapRightWingModel.length; ++var6_622) {
                this.pitchFlapRightWingModel[var6_622].field_78808_h = entityPlane.flapsPitchRight * 3.1415927f / 180.0f;
                this.pitchFlapRightWingModel[var6_622].func_78785_a(f);
            }
        }
        if (entityPlane.isPartIntact(EnumDriveablePart.leftWingWheel)) {
            for (var6_622 = (reference)false; var6_622 < this.leftWingWheelModel.length; ++var6_622) {
                if (!entityPlane.varGear) continue;
                this.leftWingWheelModel[var6_622].func_78785_a(f);
            }
        }
        if (entityPlane.isPartIntact(EnumDriveablePart.rightWingWheel)) {
            for (var6_622 = (reference)false; var6_622 < this.rightWingWheelModel.length; ++var6_622) {
                if (!entityPlane.varGear) continue;
                this.rightWingWheelModel[var6_622].func_78785_a(f);
            }
        }
        if (entityPlane.isPartIntact(EnumDriveablePart.core)) {
            for (var6_622 = (reference)false; var6_622 < this.bodyModel.length; ++var6_622) {
                this.bodyModel[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.bodyDoorOpenModel.length; ++var6_622) {
                if (!entityPlane.varDoor) continue;
                this.bodyDoorOpenModel[var6_622].func_78785_a(f);
            }
            for (var6_622 = (reference)false; var6_622 < this.bodyDoorCloseModel.length; ++var6_622) {
                if (entityPlane.varDoor) continue;
                this.bodyDoorCloseModel[var6_622].func_78785_a(f);
            }
        }
        if (entityPlane.isPartIntact(EnumDriveablePart.coreWheel)) {
            for (var6_622 = (reference)false; var6_622 < this.bodyWheelModel.length; ++var6_622) {
                if (!entityPlane.varGear) continue;
                this.bodyWheelModel[var6_622].func_78785_a(f);
            }
        }
        if (entityPlane.isPartIntact(EnumDriveablePart.topWing)) {
            for (var6_622 = (reference)false; var6_622 < this.topWingModel.length; ++var6_622) {
                this.topWingModel[var6_622].func_78785_a(f);
            }
        }
        for (EntitySeat entitySeat : entityPlane.seats) {
            if (entitySeat == null || entitySeat.seatInfo == null || entitySeat.seatInfo.gunName == null || this.gunModels.get(entitySeat.seatInfo.gunName) == null || !entityPlane.isPartIntact(entitySeat.seatInfo.part)) continue;
            float f4 = entitySeat.prevLooking.getYaw() + (entitySeat.looking.getYaw() - entitySeat.prevLooking.getYaw()) * f2;
            float f5 = entitySeat.prevLooking.getPitch() + (entitySeat.looking.getPitch() - entitySeat.prevLooking.getPitch()) * f2;
            ModelRendererTurbo[][] arrmodelRendererTurbo = (ModelRendererTurbo[][])this.gunModels.get(entitySeat.seatInfo.gunName);
            for (ModelRendererTurbo modelRendererTurbo : arrmodelRendererTurbo[0]) {
                modelRendererTurbo.field_78796_g = (180.0f - f4) * 3.1415927f / 180.0f;
                modelRendererTurbo.func_78785_a(f);
            }
            for (ModelRendererTurbo modelRendererTurbo : arrmodelRendererTurbo[1]) {
                modelRendererTurbo.field_78796_g = (180.0f - f4) * 3.1415927f / 180.0f;
                modelRendererTurbo.field_78808_h = -f5 * 3.1415927f / 180.0f;
                modelRendererTurbo.func_78785_a(f);
            }
            for (ModelRendererTurbo modelRendererTurbo : arrmodelRendererTurbo[2]) {
                modelRendererTurbo.field_78796_g = (180.0f - f4) * 3.1415927f / 180.0f;
                modelRendererTurbo.field_78808_h = -f5 * 3.1415927f / 180.0f;
                modelRendererTurbo.func_78785_a(f);
            }
        }
    }

    @Override
    public void flipAll() {
        super.flipAll();
        this.flip(this.noseModel);
        this.flip(this.leftWingModel);
        this.flip(this.rightWingModel);
        this.flip(this.topWingModel);
        this.flip(this.bayModel);
        this.flip(this.tailModel);
        this.flip(this.yawFlapModel);
        this.flip(this.pitchFlapLeftModel);
        this.flip(this.pitchFlapRightModel);
        this.flip(this.pitchFlapLeftWingModel);
        this.flip(this.pitchFlapRightWingModel);
        this.flip(this.bodyWheelModel);
        this.flip(this.tailWheelModel);
        this.flip(this.leftWingWheelModel);
        this.flip(this.rightWingWheelModel);
        this.flip(this.tailDoorOpenModel);
        this.flip(this.tailDoorCloseModel);
        this.flip(this.rightWingPos1Model);
        this.flip(this.rightWingPos2Model);
        this.flip(this.leftWingPos1Model);
        this.flip(this.leftWingPos2Model);
        for (ModelRendererTurbo[] arrmodelRendererTurbo : this.propellerModels) {
            this.flip(arrmodelRendererTurbo);
        }
    }

    @Override
    public void translateAll(float f, float f2, float f3) {
        super.translateAll(f, f2, f3);
        this.translate(this.noseModel, f, f2, f3);
        this.translate(this.leftWingModel, f, f2, f3);
        this.translate(this.rightWingModel, f, f2, f3);
        this.translate(this.topWingModel, f, f2, f3);
        this.translate(this.bayModel, f, f2, f3);
        this.translate(this.tailModel, f, f2, f3);
        this.translate(this.yawFlapModel, f, f2, f3);
        this.translate(this.pitchFlapLeftModel, f, f2, f3);
        this.translate(this.pitchFlapRightModel, f, f2, f3);
        this.translate(this.pitchFlapLeftWingModel, f, f2, f3);
        this.translate(this.pitchFlapRightWingModel, f, f2, f3);
        this.translate(this.bodyWheelModel, f, f2, f3);
        this.translate(this.tailWheelModel, f, f2, f3);
        this.translate(this.leftWingWheelModel, f, f2, f3);
        this.translate(this.rightWingWheelModel, f, f2, f3);
        this.translate(this.tailDoorOpenModel, f, f2, f3);
        this.translate(this.tailDoorCloseModel, f, f2, f3);
        this.translate(this.rightWingPos1Model, f, f2, f3);
        this.translate(this.rightWingPos2Model, f, f2, f3);
        this.translate(this.leftWingPos1Model, f, f2, f3);
        this.translate(this.leftWingPos2Model, f, f2, f3);
        for (ModelRendererTurbo[] arrmodelRendererTurbo : this.propellerModels) {
            this.translate(arrmodelRendererTurbo, f, f2, f3);
        }
    }
}

