/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.vector.Vector3f;

public class PilotGun {
    public Vector3f position;
    public EnumDriveablePart driveablePart;
    public GunType type;
    public int gunID;

    public PilotGun(String[] arrstring) {
        this.position = new Vector3f(Float.parseFloat(arrstring[1]) / 16.0f, Float.parseFloat(arrstring[2]) / 16.0f, Float.parseFloat(arrstring[3]) / 16.0f);
        this.driveablePart = EnumDriveablePart.getPart(arrstring[4]);
        this.type = GunType.getGun(arrstring[5]);
    }
}

