/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  hsus
 *  net.minecraft.entity.Entity
 */
package co.uk.flansmods.client.debug;

import co.uk.flansmods.common.vector.Vector3f;
import net.minecraft.entity.Entity;

public class EntityDebugVector
extends Entity {
    public Vector3f vector;
    public int life;
    public float red = 1.0f;
    public float green = 1.0f;
    public float blue = 1.0f;

    public EntityDebugVector(cuqu cuqu2, Vector3f vector3f, Vector3f vector3f2, int n, float f, float f2, float f3) {
        super(cuqu2);
        this.func_70107_b((double)vector3f.x, (double)vector3f.y, (double)vector3f.z);
        this.vector = vector3f2;
        this.life = n;
        this.red = f;
        this.green = f2;
        this.blue = f3;
    }

    public EntityDebugVector(cuqu cuqu2, Vector3f vector3f, Vector3f vector3f2, int n) {
        super(cuqu2);
        this.func_70107_b((double)vector3f.x, (double)vector3f.y, (double)vector3f.z);
        this.vector = vector3f2;
        this.life = n;
    }

    public void func_70071_h_() {
        --this.life;
        if (this.life <= 0) {
            this.func_70106_y();
        }
    }

    protected void func_70088_a() {
    }

    protected void func_70037_a(hsus hsus2) {
    }

    protected void func_70014_b(hsus hsus2) {
    }
}

