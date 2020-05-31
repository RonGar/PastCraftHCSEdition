/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.common.vector;

import co.uk.flansmods.common.vector.ReadableVector3f;
import co.uk.flansmods.common.vector.Vector;
import co.uk.flansmods.common.vector.WritableVector3f;
import java.io.Serializable;
import java.nio.FloatBuffer;
import net.minecraft.util.samw;

public class Vector3f
extends Vector
implements ReadableVector3f,
WritableVector3f,
Serializable {
    private static final long serialVersionUID = 1L;
    public float x;
    public float y;
    public float z;

    public Vector3f() {
    }

    public Vector3f(ReadableVector3f readableVector3f) {
        this.set(readableVector3f);
    }

    public Vector3f(float f, float f2, float f3) {
        this.set(f, f2, f3);
    }

    public Vector3f(samw samw2) {
        this((float)samw2._c, (float)samw2._d, (float)samw2._e);
    }

    public Vector3f(double d, double d2, double d3) {
        this((float)d, (float)d2, (float)d3);
    }

    public samw toVec3() {
        return samw._a((double)this.x, (double)this.y, (double)this.z);
    }

    @Override
    public void set(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    @Override
    public void set(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public Vector3f set(ReadableVector3f readableVector3f) {
        this.x = readableVector3f.getX();
        this.y = readableVector3f.getY();
        this.z = readableVector3f.getZ();
        return this;
    }

    @Override
    public float lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public Vector3f translate(float f, float f2, float f3) {
        this.x += f;
        this.y += f2;
        this.z += f3;
        return this;
    }

    public static Vector3f add(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        if (vector3f3 == null) {
            return new Vector3f(vector3f.x + vector3f2.x, vector3f.y + vector3f2.y, vector3f.z + vector3f2.z);
        }
        vector3f3.set(vector3f.x + vector3f2.x, vector3f.y + vector3f2.y, vector3f.z + vector3f2.z);
        return vector3f3;
    }

    public static Vector3f sub(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        if (vector3f3 == null) {
            return new Vector3f(vector3f.x - vector3f2.x, vector3f.y - vector3f2.y, vector3f.z - vector3f2.z);
        }
        vector3f3.set(vector3f.x - vector3f2.x, vector3f.y - vector3f2.y, vector3f.z - vector3f2.z);
        return vector3f3;
    }

    public static Vector3f cross(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        if (vector3f3 == null) {
            vector3f3 = new Vector3f();
        }
        vector3f3.set(vector3f.y * vector3f2.z - vector3f.z * vector3f2.y, vector3f2.x * vector3f.z - vector3f2.z * vector3f.x, vector3f.x * vector3f2.y - vector3f.y * vector3f2.x);
        return vector3f3;
    }

    @Override
    public Vector negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public Vector3f negate(Vector3f vector3f) {
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        vector3f.x = -this.x;
        vector3f.y = -this.y;
        vector3f.z = -this.z;
        return vector3f;
    }

    public Vector3f normalise(Vector3f vector3f) {
        float f = this.length();
        if (vector3f == null) {
            vector3f = new Vector3f(this.x / f, this.y / f, this.z / f);
        } else {
            vector3f.set(this.x / f, this.y / f, this.z / f);
        }
        return vector3f;
    }

    public static float dot(Vector3f vector3f, Vector3f vector3f2) {
        return vector3f.x * vector3f2.x + vector3f.y * vector3f2.y + vector3f.z * vector3f2.z;
    }

    public static float angle(Vector3f vector3f, Vector3f vector3f2) {
        float f = Vector3f.dot(vector3f, vector3f2) / (vector3f.length() * vector3f2.length());
        if (f < -1.0f) {
            f = -1.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        return (float)Math.acos(f);
    }

    @Override
    public Vector load(FloatBuffer floatBuffer) {
        this.x = floatBuffer.get();
        this.y = floatBuffer.get();
        this.z = floatBuffer.get();
        return this;
    }

    @Override
    public Vector scale(float f) {
        this.x *= f;
        this.y *= f;
        this.z *= f;
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
        stringBuilder.append("Vector3f[");
        stringBuilder.append(this.x);
        stringBuilder.append(", ");
        stringBuilder.append(this.y);
        stringBuilder.append(", ");
        stringBuilder.append(this.z);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override
    public final float getX() {
        return this.x;
    }

    @Override
    public final float getY() {
        return this.y;
    }

    @Override
    public final void setX(float f) {
        this.x = f;
    }

    @Override
    public final void setY(float f) {
        this.y = f;
    }

    @Override
    public void setZ(float f) {
        this.z = f;
    }

    @Override
    public float getZ() {
        return this.z;
    }
}

