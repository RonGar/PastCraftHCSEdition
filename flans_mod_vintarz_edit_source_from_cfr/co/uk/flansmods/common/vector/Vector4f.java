/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.vector;

import co.uk.flansmods.common.vector.ReadableVector4f;
import co.uk.flansmods.common.vector.Vector;
import co.uk.flansmods.common.vector.WritableVector4f;
import java.io.Serializable;
import java.nio.FloatBuffer;

public class Vector4f
extends Vector
implements ReadableVector4f,
WritableVector4f,
Serializable {
    private static final long serialVersionUID = 1L;
    public float x;
    public float y;
    public float z;
    public float w;

    public Vector4f() {
    }

    public Vector4f(ReadableVector4f readableVector4f) {
        this.set(readableVector4f);
    }

    public Vector4f(float f, float f2, float f3, float f4) {
        this.set(f, f2, f3, f4);
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

    @Override
    public void set(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.w = f4;
    }

    public Vector4f set(ReadableVector4f readableVector4f) {
        this.x = readableVector4f.getX();
        this.y = readableVector4f.getY();
        this.z = readableVector4f.getZ();
        this.w = readableVector4f.getW();
        return this;
    }

    @Override
    public float lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
    }

    public Vector4f translate(float f, float f2, float f3, float f4) {
        this.x += f;
        this.y += f2;
        this.z += f3;
        this.w += f4;
        return this;
    }

    public static Vector4f add(Vector4f vector4f, Vector4f vector4f2, Vector4f vector4f3) {
        if (vector4f3 == null) {
            return new Vector4f(vector4f.x + vector4f2.x, vector4f.y + vector4f2.y, vector4f.z + vector4f2.z, vector4f.w + vector4f2.w);
        }
        vector4f3.set(vector4f.x + vector4f2.x, vector4f.y + vector4f2.y, vector4f.z + vector4f2.z, vector4f.w + vector4f2.w);
        return vector4f3;
    }

    public static Vector4f sub(Vector4f vector4f, Vector4f vector4f2, Vector4f vector4f3) {
        if (vector4f3 == null) {
            return new Vector4f(vector4f.x - vector4f2.x, vector4f.y - vector4f2.y, vector4f.z - vector4f2.z, vector4f.w - vector4f2.w);
        }
        vector4f3.set(vector4f.x - vector4f2.x, vector4f.y - vector4f2.y, vector4f.z - vector4f2.z, vector4f.w - vector4f2.w);
        return vector4f3;
    }

    @Override
    public Vector negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
        return this;
    }

    public Vector4f negate(Vector4f vector4f) {
        if (vector4f == null) {
            vector4f = new Vector4f();
        }
        vector4f.x = -this.x;
        vector4f.y = -this.y;
        vector4f.z = -this.z;
        vector4f.w = -this.w;
        return vector4f;
    }

    public Vector4f normalise(Vector4f vector4f) {
        float f = this.length();
        if (vector4f == null) {
            vector4f = new Vector4f(this.x / f, this.y / f, this.z / f, this.w / f);
        } else {
            vector4f.set(this.x / f, this.y / f, this.z / f, this.w / f);
        }
        return vector4f;
    }

    public static float dot(Vector4f vector4f, Vector4f vector4f2) {
        return vector4f.x * vector4f2.x + vector4f.y * vector4f2.y + vector4f.z * vector4f2.z + vector4f.w * vector4f2.w;
    }

    public static float angle(Vector4f vector4f, Vector4f vector4f2) {
        float f = Vector4f.dot(vector4f, vector4f2) / (vector4f.length() * vector4f2.length());
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
        this.w = floatBuffer.get();
        return this;
    }

    @Override
    public Vector scale(float f) {
        this.x *= f;
        this.y *= f;
        this.z *= f;
        this.w *= f;
        return this;
    }

    @Override
    public Vector store(FloatBuffer floatBuffer) {
        floatBuffer.put(this.x);
        floatBuffer.put(this.y);
        floatBuffer.put(this.z);
        floatBuffer.put(this.w);
        return this;
    }

    public String toString() {
        return "Vector4f: " + this.x + " " + this.y + " " + this.z + " " + this.w;
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

    @Override
    public void setW(float f) {
        this.w = f;
    }

    @Override
    public float getW() {
        return this.w;
    }
}

