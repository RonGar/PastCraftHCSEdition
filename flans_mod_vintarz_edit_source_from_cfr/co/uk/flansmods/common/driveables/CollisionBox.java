/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.vector.Vector3f;

public class CollisionBox {
    public int x;
    public int y;
    public int z;
    public int w;
    public int h;
    public int d;
    public int health;
    public EnumDriveablePart part;

    public CollisionBox(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.health = n;
        this.x = n2;
        this.y = n3;
        this.z = n4;
        this.w = n5;
        this.h = n6;
        this.d = n7;
    }

    public Vector3f getCentre() {
        return new Vector3f((float)this.x / 16.0f + (float)this.w / 32.0f, (float)this.y / 16.0f + (float)this.h / 32.0f, (float)this.z / 16.0f + (float)this.d / 32.0f);
    }
}

