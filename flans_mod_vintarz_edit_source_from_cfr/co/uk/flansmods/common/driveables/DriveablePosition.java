/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.vector.Vector3f;

public class DriveablePosition {
    public Vector3f position;
    public float originaZ;
    public EnumDriveablePart part;

    public DriveablePosition(Vector3f vector3f, EnumDriveablePart enumDriveablePart) {
        this.position = vector3f;
        this.part = enumDriveablePart;
    }

    public DriveablePosition(String[] arrstring) {
        this(new Vector3f(Float.parseFloat(arrstring[1]) / 16.0f, Float.parseFloat(arrstring[2]) / 16.0f, Float.parseFloat(arrstring[3]) / 16.0f), EnumDriveablePart.getPart(arrstring[4]));
    }
}

