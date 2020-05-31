/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.common.vector;

import co.uk.flansmods.common.vector.Vector;
import java.nio.FloatBuffer;
import net.minecraft.util.samw;

public class Vector3i
extends Vector {
    private static final long serialVersionUID = 1L;
    public int x;
    public int y;
    public int z;

    public Vector3i() {
    }

    public Vector3i(int n, int n2, int n3) {
        this.set(n, n2, n3);
    }

    public Vector3i(samw samw2) {
        this((int)samw2._c, (int)samw2._d, (int)samw2._e);
    }

    public Vector3i(double d, double d2, double d3) {
        this((int)d, (int)d2, (int)d3);
    }

    public Vector3i(Vector3i vector3i) {
        this(vector3i.x, vector3i.y, vector3i.z);
    }

    public samw toVec3() {
        return samw._a((double)this.x, (double)this.y, (double)this.z);
    }

    public void set(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    @Override
    public float lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public Vector3i translate(int n, int n2, int n3) {
        this.x += n;
        this.y += n2;
        this.z += n3;
        return this;
    }

    public static Vector3i add(Vector3i vector3i, Vector3i vector3i2, Vector3i vector3i3) {
        if (vector3i3 == null) {
            return new Vector3i(vector3i.x + vector3i2.x, vector3i.y + vector3i2.y, vector3i.z + vector3i2.z);
        }
        vector3i3.set(vector3i.x + vector3i2.x, vector3i.y + vector3i2.y, vector3i.z + vector3i2.z);
        return vector3i3;
    }

    public static Vector3i sub(Vector3i vector3i, Vector3i vector3i2, Vector3i vector3i3) {
        if (vector3i3 == null) {
            return new Vector3i(vector3i.x - vector3i2.x, vector3i.y - vector3i2.y, vector3i.z - vector3i2.z);
        }
        vector3i3.set(vector3i.x - vector3i2.x, vector3i.y - vector3i2.y, vector3i.z - vector3i2.z);
        return vector3i3;
    }

    public static Vector3i cross(Vector3i vector3i, Vector3i vector3i2, Vector3i vector3i3) {
        if (vector3i3 == null) {
            vector3i3 = new Vector3i();
        }
        vector3i3.set(vector3i.y * vector3i2.z - vector3i.z * vector3i2.y, vector3i2.x * vector3i.z - vector3i2.z * vector3i.x, vector3i.x * vector3i2.y - vector3i.y * vector3i2.x);
        return vector3i3;
    }

    @Override
    public Vector negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public Vector3i negate(Vector3i vector3i) {
        if (vector3i == null) {
            vector3i = new Vector3i();
        }
        vector3i.x = -this.x;
        vector3i.y = -this.y;
        vector3i.z = -this.z;
        return vector3i;
    }

    public Vector3i normalise(Vector3i vector3i) {
        float f = this.length();
        if (vector3i == null) {
            vector3i = new Vector3i((float)this.x / f, (float)this.y / f, (float)this.z / f);
        } else {
            vector3i.set((int)((float)this.x / f), (int)((float)this.y / f), (int)((float)this.z / f));
        }
        return vector3i;
    }

    public static float dot(Vector3i vector3i, Vector3i vector3i2) {
        return vector3i.x * vector3i2.x + vector3i.y * vector3i2.y + vector3i.z * vector3i2.z;
    }

    public static float angle(Vector3i vector3i, Vector3i vector3i2) {
        float f = Vector3i.dot(vector3i, vector3i2) / (vector3i.length() * vector3i2.length());
        if (f < -1.0f) {
            f = -1.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        return (float)Math.acos(f);
    }

    @Override
    public Vector load(FloatBuffer floatBuffer) {
        this.x = (int)floatBuffer.get();
        this.y = (int)floatBuffer.get();
        this.z = (int)floatBuffer.get();
        return this;
    }

    @Override
    public Vector scale(float f) {
        this.x = (int)((float)this.x * f);
        this.y = (int)((float)this.y * f);
        this.z = (int)((float)this.z * f);
        return this;
    }

    @Override
    public Vector store(FloatBuffer floatBuffer) {
        floatBuffer.put(this.x);
        floatBuffer.put(this.y);
        floatBuffer.put(this.z);
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("Vector3i[");
        stringBuilder.append(this.x);
        stringBuilder.append(", ");
        stringBuilder.append(this.y);
        stringBuilder.append(", ");
        stringBuilder.append(this.z);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public final void setX(int n) {
        this.x = n;
    }

    public final void setY(int n) {
        this.y = n;
    }

    public void setZ(int n) {
        this.z = n;
    }

    public int getZ() {
        return this.z;
    }
}

