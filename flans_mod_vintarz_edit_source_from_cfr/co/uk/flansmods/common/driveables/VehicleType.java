/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.client.model.ModelDriveable;
import co.uk.flansmods.client.model.ModelVehicle;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.TypeFile;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.vector.Vector3f;
import java.util.ArrayList;

public class VehicleType
extends DriveableType {
    public float turnLeftModifier = 1.0f;
    public float turnRightModifier = 1.0f;
    public boolean squashMobs = false;
    public Vector3f barrelPosition;
    public float wheelRadius = 1.0f;
    public boolean fourWheelDrive = false;
    public boolean rotateWheels = false;
    public boolean tank = false;
    public int vehicleShootDelay;
    public int vehicleShellDelay;
    public boolean hasDoor = false;
    public static ArrayList<VehicleType> types = new ArrayList();

    public VehicleType(TypeFile typeFile) {
        super(typeFile);
        types.add(this);
    }

    @Override
    protected void read(String[] arrstring, TypeFile typeFile) {
        super.read(arrstring, typeFile);
        try {
            if (arrstring[0].equals("TurnLeftSpeed")) {
                this.turnLeftModifier = 1.0f;
            }
            if (arrstring[0].equals("TurnRightSpeed")) {
                this.turnRightModifier = 1.0f;
            }
            if (arrstring[0].equals("SquashMobs")) {
                this.squashMobs = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("WheelRadius")) {
                this.wheelRadius = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("FourWheelDrive")) {
                this.fourWheelDrive = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("Tank") || arrstring[0].equals("TankMode")) {
                this.tank = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("HasDoor")) {
                this.hasDoor = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("RotateWheels")) {
                this.rotateWheels = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("BarrelPosition")) {
                this.barrelPosition = new Vector3f((float)Integer.parseInt(arrstring[1]) / 16.0f, (float)Integer.parseInt(arrstring[2]) / 16.0f, (float)Integer.parseInt(arrstring[3]) / 16.0f);
            }
            if (arrstring[0].equals("ShootDelay")) {
                this.vehicleShootDelay = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("ShellDelay")) {
                this.vehicleShellDelay = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("ShootSound")) {
                this.shootMainSound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "driveables", arrstring[1]);
            }
            if (arrstring[0].equals("ShellSound")) {
                this.shootSecondarySound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "driveables", arrstring[1]);
            }
        }
        catch (Exception exception) {}
    }

    public static VehicleType getVehicle(String string) {
        for (VehicleType vehicleType : types) {
            if (!vehicleType.shortName.equals(string)) continue;
            return vehicleType;
        }
        return null;
    }

    @Override
    public void reloadModel() {
        this.model = FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelVehicle.class);
    }
}

