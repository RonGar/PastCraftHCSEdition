/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.common.PartType;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.vector.Vector3f;

public class Propeller {
    public PartType itemType;
    public int ID;
    public int x;
    public int y;
    public int z;
    public EnumDriveablePart planePart;

    public Propeller(int n, int n2, int n3, int n4, EnumDriveablePart enumDriveablePart, PartType partType) {
        this.ID = n;
        this.x = n2;
        this.y = n3;
        this.z = n4;
        this.planePart = enumDriveablePart;
        this.itemType = partType;
    }

    public Vector3f getPosition() {
        return new Vector3f((float)this.x / 16.0f, (float)this.y / 16.0f, (float)this.z / 16.0f);
    }
}

