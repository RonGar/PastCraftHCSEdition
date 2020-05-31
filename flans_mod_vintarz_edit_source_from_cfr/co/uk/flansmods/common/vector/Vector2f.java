/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.vector;

import co.uk.flansmods.common.vector.ReadableVector2f;
import co.uk.flansmods.common.vector.Vector;
import co.uk.flansmods.common.vector.WritableVector2f;
import java.io.Serializable;
import java.nio.FloatBuffer;

public class Vector2f
extends Vector
implements ReadableVector2f,
WritableVector2f,
Serializable {
    private static final long serialVersionUID = 1L;
    public float x;
    public float y;

    public Vector2f() {
    }

    public Vector2f(ReadableVector2f readableVector2f) {
        this.set(readableVector2f);
    }

    public Vector2f(float f, float f2) {
        this.set(f, f2);
    }

    @Override
    public void set(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public Vector2f set(ReadableVector2f readableVector2f) {
        this.x = readableVector2f.getX();
        this.y = readableVector2f.getY();
        return this;
    }

    @Override
    public float lengthSquared() {
        return this.x * this.x + this.y * this.y;
    }

    public Vector2f translate(float f, float f2) {
        this.x += f;
        this.y += f2;
        return this;
    }

    @Override
    public Vector negate() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }

    public Vector2f negate(Vector2f vector2f) {
        if (vector2f == null) {
            vector2f = new Vector2f();
        }
        vector2f.x = -this.x;
        vector2f.y = -this.y;
        return vector2f;
    }

    public Vector2f normalise(Vector2f vector2f) {
        float f = this.length();
        if (vector2f == null) {
            vector2f = new Vector2f(this.x / f, this.y / f);
        } else {
            vector2f.set(this.x / f, this.y / f);
        }
        return vector2f;
    }

    public static float dot(Vector2f vector2f, Vector2f vector2f2) {
        return vector2f.x * vector2f2.x + vector2f.y * vector2f2.y;
    }

    public static float angle(Vector2f vector2f, Vector2f vector2f2) {
        float f = Vector2f.dot(vector2f, vector2f2) / (vector2f.length() * vector2f2.length());
        if (f < -1.0f) {
            f = -1.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        return (float)Math.acos(f);
    }

    public static Vector2f add(Vector2f vector2f, Vector2f vector2f2, Vector2f vector2f3) {
        if (vector2f3 == null) {
            return new Vector2f(vector2f.x + vector2f2.x, vector2f.y + vector2f2.y);
        }
        vector2f3.set(vector2f.x + vector2f2.x, vector2f.y + vector2f2.y);
        return vector2f3;
    }

    public static Vector2f sub(Vector2f vector2f, Vector2f vector2f2, Vector2f vector2f3) {
        if (vector2f3 == null) {
            return new Vector2f(vector2f.x - vector2f2.x, vector2f.y - vector2f2.y);
        }
        vector2f3.set(vector2f.x - vector2f2.x, vector2f.y - vector2f2.y);
        return vector2f3;
    }

    @Override
    public Vector store(FloatBuffer floatBuffer) {
        floatBuffer.put(this.x);
        floatBuffer.put(this.y);
        return this;
    }

    @Override
    public Vector load(FloatBuffer floatBuffer) {
        this.x = floatBuffer.get();
        this.y = floatBuffer.get();
        return this;
    }

    @Override
    public Vector scale(float f) {
        this.x *= f;
        this.y *= f;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("Vector2f[");
        stringBuilder.append(this.x);
        stringBuilder.append(", ");
        stringBuilder.append(this.y);
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
}

