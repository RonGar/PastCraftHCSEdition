/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.vector.Vector3f;

public class CollisionPoint {
    public int posX;
    public int posY;
    public int posZ;
    public float strength;
    public EnumDriveablePart part;

    public CollisionPoint(int n, int n2, int n3, String string, float f) {
        this.posX = n;
        this.posY = n2;
        this.posZ = n3;
        this.part = EnumDriveablePart.getPart(string);
        this.strength = f;
    }

    public Vector3f getLocalVector() {
        return new Vector3f((float)this.posX / 16.0f, (float)this.posY / 16.0f, (float)this.posZ / 16.0f);
    }
}

