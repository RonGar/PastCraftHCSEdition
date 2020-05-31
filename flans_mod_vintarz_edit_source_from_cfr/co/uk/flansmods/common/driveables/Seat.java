/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.guns.GunType;

public class Seat {
    public int x;
    public int y;
    public int z;
    public int id;
    public float minYaw = -360.0f;
    public float maxYaw = 360.0f;
    public float minPitch = -89.0f;
    public float maxPitch = 89.0f;
    public GunType gunType;
    public String gunName;
    public EnumDriveablePart part;
    public int gunnerID;

    public Seat(String[] arrstring) {
        this.id = Integer.parseInt(arrstring[1]);
        this.x = Integer.parseInt(arrstring[2]);
        this.y = Integer.parseInt(arrstring[3]);
        this.z = Integer.parseInt(arrstring[4]);
        this.part = EnumDriveablePart.getPart(arrstring[5]);
        if (arrstring.length > 6) {
            this.minYaw = Float.parseFloat(arrstring[6]);
            this.maxYaw = Float.parseFloat(arrstring[7]);
            this.minPitch = Float.parseFloat(arrstring[8]);
            this.maxPitch = Float.parseFloat(arrstring[9]);
            if (arrstring.length > 10) {
                this.gunType = GunType.getGun(arrstring[10]);
                this.gunName = arrstring[11];
            }
        }
    }

    public Seat(int n, int n2, int n3) {
        this.id = 0;
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.part = EnumDriveablePart.core;
    }

    public Seat(int n, int n2, int n3, float f, float f2, float f3, float f4) {
        this.id = 0;
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.part = EnumDriveablePart.core;
        this.minYaw = f;
        this.maxYaw = f2;
        this.minPitch = f3;
        this.maxPitch = f4;
    }
}

