/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.common.vector.Vector3f;

public class CollisionSurface {
    public Vector3f localisedOrigin;
    public Vector3f u;
    public Vector3f v;

    public CollisionSurface(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        this.localisedOrigin = vector3f;
        this.u = vector3f2;
        this.v = vector3f3;
    }
}

