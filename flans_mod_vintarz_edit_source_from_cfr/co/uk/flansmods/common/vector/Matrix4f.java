/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.vector;

import co.uk.flansmods.common.vector.Matrix;
import co.uk.flansmods.common.vector.Vector2f;
import co.uk.flansmods.common.vector.Vector3f;
import co.uk.flansmods.common.vector.Vector4f;
import java.io.Serializable;
import java.nio.FloatBuffer;

public class Matrix4f
extends Matrix
implements Serializable {
    private static final long serialVersionUID = 1L;
    public float m00;
    public float m01;
    public float m02;
    public float m03;
    public float m10;
    public float m11;
    public float m12;
    public float m13;
    public float m20;
    public float m21;
    public float m22;
    public float m23;
    public float m30;
    public float m31;
    public float m32;
    public float m33;

    public Matrix4f() {
        this.setIdentity();
    }

    public Matrix4f(Matrix4f matrix4f) {
        this.load(matrix4f);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.m00).append(' ').append(this.m10).append(' ').append(this.m20).append(' ').append(this.m30).append('\n');
        stringBuilder.append(this.m01).append(' ').append(this.m11).append(' ').append(this.m21).append(' ').append(this.m31).append('\n');
        stringBuilder.append(this.m02).append(' ').append(this.m12).append(' ').append(this.m22).append(' ').append(this.m32).append('\n');
        stringBuilder.append(this.m03).append(' ').append(this.m13).append(' ').append(this.m23).append(' ').append(this.m33).append('\n');
        return stringBuilder.toString();
    }

    @Override
    public Matrix setIdentity() {
        return Matrix4f.setIdentity(this);
    }

    public static Matrix4f setIdentity(Matrix4f matrix4f) {
        matrix4f.m00 = 1.0f;
        matrix4f.m01 = 0.0f;
        matrix4f.m02 = 0.0f;
        matrix4f.m03 = 0.0f;
        matrix4f.m10 = 0.0f;
        matrix4f.m11 = 1.0f;
        matrix4f.m12 = 0.0f;
        matrix4f.m13 = 0.0f;
        matrix4f.m20 = 0.0f;
        matrix4f.m21 = 0.0f;
        matrix4f.m22 = 1.0f;
        matrix4f.m23 = 0.0f;
        matrix4f.m30 = 0.0f;
        matrix4f.m31 = 0.0f;
        matrix4f.m32 = 0.0f;
        matrix4f.m33 = 1.0f;
        return matrix4f;
    }

    @Override
    public Matrix setZero() {
        return Matrix4f.setZero(this);
    }

    public static Matrix4f setZero(Matrix4f matrix4f) {
        matrix4f.m00 = 0.0f;
        matrix4f.m01 = 0.0f;
        matrix4f.m02 = 0.0f;
        matrix4f.m03 = 0.0f;
        matrix4f.m10 = 0.0f;
        matrix4f.m11 = 0.0f;
        matrix4f.m12 = 0.0f;
        matrix4f.m13 = 0.0f;
        matrix4f.m20 = 0.0f;
        matrix4f.m21 = 0.0f;
        matrix4f.m22 = 0.0f;
        matrix4f.m23 = 0.0f;
        matrix4f.m30 = 0.0f;
        matrix4f.m31 = 0.0f;
        matrix4f.m32 = 0.0f;
        matrix4f.m33 = 0.0f;
        return matrix4f;
    }

    public Matrix4f load(Matrix4f matrix4f) {
        return Matrix4f.load(matrix4f, this);
    }

    public static Matrix4f load(Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (matrix4f2 == null) {
            matrix4f2 = new Matrix4f();
        }
        matrix4f2.m00 = matrix4f.m00;
        matrix4f2.m01 = matrix4f.m01;
        matrix4f2.m02 = matrix4f.m02;
        matrix4f2.m03 = matrix4f.m03;
        matrix4f2.m10 = matrix4f.m10;
        matrix4f2.m11 = matrix4f.m11;
        matrix4f2.m12 = matrix4f.m12;
        matrix4f2.m13 = matrix4f.m13;
        matrix4f2.m20 = matrix4f.m20;
        matrix4f2.m21 = matrix4f.m21;
        matrix4f2.m22 = matrix4f.m22;
        matrix4f2.m23 = matrix4f.m23;
        matrix4f2.m30 = matrix4f.m30;
        matrix4f2.m31 = matrix4f.m31;
        matrix4f2.m32 = matrix4f.m32;
        matrix4f2.m33 = matrix4f.m33;
        return matrix4f2;
    }

    @Override
    public Matrix load(FloatBuffer floatBuffer) {
        this.m00 = floatBuffer.get();
        this.m01 = floatBuffer.get();
        this.m02 = floatBuffer.get();
        this.m03 = floatBuffer.get();
        this.m10 = floatBuffer.get();
        this.m11 = floatBuffer.get();
        this.m12 = floatBuffer.get();
        this.m13 = floatBuffer.get();
        this.m20 = floatBuffer.get();
        this.m21 = floatBuffer.get();
        this.m22 = floatBuffer.get();
        this.m23 = floatBuffer.get();
        this.m30 = floatBuffer.get();
        this.m31 = floatBuffer.get();
        this.m32 = floatBuffer.get();
        this.m33 = floatBuffer.get();
        return this;
    }

    @Override
    public Matrix loadTranspose(FloatBuffer floatBuffer) {
        this.m00 = floatBuffer.get();
        this.m10 = floatBuffer.get();
        this.m20 = floatBuffer.get();
        this.m30 = floatBuffer.get();
        this.m01 = floatBuffer.get();
        this.m11 = floatBuffer.get();
        this.m21 = floatBuffer.get();
        this.m31 = floatBuffer.get();
        this.m02 = floatBuffer.get();
        this.m12 = floatBuffer.get();
        this.m22 = floatBuffer.get();
        this.m32 = floatBuffer.get();
        this.m03 = floatBuffer.get();
        this.m13 = floatBuffer.get();
        this.m23 = floatBuffer.get();
        this.m33 = floatBuffer.get();
        return this;
    }

    @Override
    public Matrix store(FloatBuffer floatBuffer) {
        floatBuffer.put(this.m00);
        floatBuffer.put(this.m01);
        floatBuffer.put(this.m02);
        floatBuffer.put(this.m03);
        floatBuffer.put(this.m10);
        floatBuffer.put(this.m11);
        floatBuffer.put(this.m12);
        floatBuffer.put(this.m13);
        floatBuffer.put(this.m20);
        floatBuffer.put(this.m21);
        floatBuffer.put(this.m22);
        floatBuffer.put(this.m23);
        floatBuffer.put(this.m30);
        floatBuffer.put(this.m31);
        floatBuffer.put(this.m32);
        floatBuffer.put(this.m33);
        return this;
    }

    @Override
    public Matrix storeTranspose(FloatBuffer floatBuffer) {
        floatBuffer.put(this.m00);
        floatBuffer.put(this.m10);
        floatBuffer.put(this.m20);
        floatBuffer.put(this.m30);
        floatBuffer.put(this.m01);
        floatBuffer.put(this.m11);
        floatBuffer.put(this.m21);
        floatBuffer.put(this.m31);
        floatBuffer.put(this.m02);
        floatBuffer.put(this.m12);
        floatBuffer.put(this.m22);
        floatBuffer.put(this.m32);
        floatBuffer.put(this.m03);
        floatBuffer.put(this.m13);
        floatBuffer.put(this.m23);
        floatBuffer.put(this.m33);
        return this;
    }

    public Matrix store3f(FloatBuffer floatBuffer) {
        floatBuffer.put(this.m00);
        floatBuffer.put(this.m01);
        floatBuffer.put(this.m02);
        floatBuffer.put(this.m10);
        floatBuffer.put(this.m11);
        floatBuffer.put(this.m12);
        floatBuffer.put(this.m20);
        floatBuffer.put(this.m21);
        floatBuffer.put(this.m22);
        return this;
    }

    public static Matrix4f add(Matrix4f matrix4f, Matrix4f matrix4f2, Matrix4f matrix4f3) {
        if (matrix4f3 == null) {
            matrix4f3 = new Matrix4f();
        }
        matrix4f3.m00 = matrix4f.m00 + matrix4f2.m00;
        matrix4f3.m01 = matrix4f.m01 + matrix4f2.m01;
        matrix4f3.m02 = matrix4f.m02 + matrix4f2.m02;
        matrix4f3.m03 = matrix4f.m03 + matrix4f2.m03;
        matrix4f3.m10 = matrix4f.m10 + matrix4f2.m10;
        matrix4f3.m11 = matrix4f.m11 + matrix4f2.m11;
        matrix4f3.m12 = matrix4f.m12 + matrix4f2.m12;
        matrix4f3.m13 = matrix4f.m13 + matrix4f2.m13;
        matrix4f3.m20 = matrix4f.m20 + matrix4f2.m20;
        matrix4f3.m21 = matrix4f.m21 + matrix4f2.m21;
        matrix4f3.m22 = matrix4f.m22 + matrix4f2.m22;
        matrix4f3.m23 = matrix4f.m23 + matrix4f2.m23;
        matrix4f3.m30 = matrix4f.m30 + matrix4f2.m30;
        matrix4f3.m31 = matrix4f.m31 + matrix4f2.m31;
        matrix4f3.m32 = matrix4f.m32 + matrix4f2.m32;
        matrix4f3.m33 = matrix4f.m33 + matrix4f2.m33;
        return matrix4f3;
    }

    public static Matrix4f sub(Matrix4f matrix4f, Matrix4f matrix4f2, Matrix4f matrix4f3) {
        if (matrix4f3 == null) {
            matrix4f3 = new Matrix4f();
        }
        matrix4f3.m00 = matrix4f.m00 - matrix4f2.m00;
        matrix4f3.m01 = matrix4f.m01 - matrix4f2.m01;
        matrix4f3.m02 = matrix4f.m02 - matrix4f2.m02;
        matrix4f3.m03 = matrix4f.m03 - matrix4f2.m03;
        matrix4f3.m10 = matrix4f.m10 - matrix4f2.m10;
        matrix4f3.m11 = matrix4f.m11 - matrix4f2.m11;
        matrix4f3.m12 = matrix4f.m12 - matrix4f2.m12;
        matrix4f3.m13 = matrix4f.m13 - matrix4f2.m13;
        matrix4f3.m20 = matrix4f.m20 - matrix4f2.m20;
        matrix4f3.m21 = matrix4f.m21 - matrix4f2.m21;
        matrix4f3.m22 = matrix4f.m22 - matrix4f2.m22;
        matrix4f3.m23 = matrix4f.m23 - matrix4f2.m23;
        matrix4f3.m30 = matrix4f.m30 - matrix4f2.m30;
        matrix4f3.m31 = matrix4f.m31 - matrix4f2.m31;
        matrix4f3.m32 = matrix4f.m32 - matrix4f2.m32;
        matrix4f3.m33 = matrix4f.m33 - matrix4f2.m33;
        return matrix4f3;
    }

    public static Matrix4f mul(Matrix4f matrix4f, Matrix4f matrix4f2, Matrix4f matrix4f3) {
        if (matrix4f3 == null) {
            matrix4f3 = new Matrix4f();
        }
        float f = matrix4f.m00 * matrix4f2.m00 + matrix4f.m10 * matrix4f2.m01 + matrix4f.m20 * matrix4f2.m02 + matrix4f.m30 * matrix4f2.m03;
        float f2 = matrix4f.m01 * matrix4f2.m00 + matrix4f.m11 * matrix4f2.m01 + matrix4f.m21 * matrix4f2.m02 + matrix4f.m31 * matrix4f2.m03;
        float f3 = matrix4f.m02 * matrix4f2.m00 + matrix4f.m12 * matrix4f2.m01 + matrix4f.m22 * matrix4f2.m02 + matrix4f.m32 * matrix4f2.m03;
        float f4 = matrix4f.m03 * matrix4f2.m00 + matrix4f.m13 * matrix4f2.m01 + matrix4f.m23 * matrix4f2.m02 + matrix4f.m33 * matrix4f2.m03;
        float f5 = matrix4f.m00 * matrix4f2.m10 + matrix4f.m10 * matrix4f2.m11 + matrix4f.m20 * matrix4f2.m12 + matrix4f.m30 * matrix4f2.m13;
        float f6 = matrix4f.m01 * matrix4f2.m10 + matrix4f.m11 * matrix4f2.m11 + matrix4f.m21 * matrix4f2.m12 + matrix4f.m31 * matrix4f2.m13;
        float f7 = matrix4f.m02 * matrix4f2.m10 + matrix4f.m12 * matrix4f2.m11 + matrix4f.m22 * matrix4f2.m12 + matrix4f.m32 * matrix4f2.m13;
        float f8 = matrix4f.m03 * matrix4f2.m10 + matrix4f.m13 * matrix4f2.m11 + matrix4f.m23 * matrix4f2.m12 + matrix4f.m33 * matrix4f2.m13;
        float f9 = matrix4f.m00 * matrix4f2.m20 + matrix4f.m10 * matrix4f2.m21 + matrix4f.m20 * matrix4f2.m22 + matrix4f.m30 * matrix4f2.m23;
        float f10 = matrix4f.m01 * matrix4f2.m20 + matrix4f.m11 * matrix4f2.m21 + matrix4f.m21 * matrix4f2.m22 + matrix4f.m31 * matrix4f2.m23;
        float f11 = matrix4f.m02 * matrix4f2.m20 + matrix4f.m12 * matrix4f2.m21 + matrix4f.m22 * matrix4f2.m22 + matrix4f.m32 * matrix4f2.m23;
        float f12 = matrix4f.m03 * matrix4f2.m20 + matrix4f.m13 * matrix4f2.m21 + matrix4f.m23 * matrix4f2.m22 + matrix4f.m33 * matrix4f2.m23;
        float f13 = matrix4f.m00 * matrix4f2.m30 + matrix4f.m10 * matrix4f2.m31 + matrix4f.m20 * matrix4f2.m32 + matrix4f.m30 * matrix4f2.m33;
        float f14 = matrix4f.m01 * matrix4f2.m30 + matrix4f.m11 * matrix4f2.m31 + matrix4f.m21 * matrix4f2.m32 + matrix4f.m31 * matrix4f2.m33;
        float f15 = matrix4f.m02 * matrix4f2.m30 + matrix4f.m12 * matrix4f2.m31 + matrix4f.m22 * matrix4f2.m32 + matrix4f.m32 * matrix4f2.m33;
        float f16 = matrix4f.m03 * matrix4f2.m30 + matrix4f.m13 * matrix4f2.m31 + matrix4f.m23 * matrix4f2.m32 + matrix4f.m33 * matrix4f2.m33;
        matrix4f3.m00 = f;
        matrix4f3.m01 = f2;
        matrix4f3.m02 = f3;
        matrix4f3.m03 = f4;
        matrix4f3.m10 = f5;
        matrix4f3.m11 = f6;
        matrix4f3.m12 = f7;
        matrix4f3.m13 = f8;
        matrix4f3.m20 = f9;
        matrix4f3.m21 = f10;
        matrix4f3.m22 = f11;
        matrix4f3.m23 = f12;
        matrix4f3.m30 = f13;
        matrix4f3.m31 = f14;
        matrix4f3.m32 = f15;
        matrix4f3.m33 = f16;
        return matrix4f3;
    }

    public static Vector4f transform(Matrix4f matrix4f, Vector4f vector4f, Vector4f vector4f2) {
        if (vector4f2 == null) {
            vector4f2 = new Vector4f();
        }
        float f = matrix4f.m00 * vector4f.x + matrix4f.m10 * vector4f.y + matrix4f.m20 * vector4f.z + matrix4f.m30 * vector4f.w;
        float f2 = matrix4f.m01 * vector4f.x + matrix4f.m11 * vector4f.y + matrix4f.m21 * vector4f.z + matrix4f.m31 * vector4f.w;
        float f3 = matrix4f.m02 * vector4f.x + matrix4f.m12 * vector4f.y + matrix4f.m22 * vector4f.z + matrix4f.m32 * vector4f.w;
        float f4 = matrix4f.m03 * vector4f.x + matrix4f.m13 * vector4f.y + matrix4f.m23 * vector4f.z + matrix4f.m33 * vector4f.w;
        vector4f2.x = f;
        vector4f2.y = f2;
        vector4f2.z = f3;
        vector4f2.w = f4;
        return vector4f2;
    }

    @Override
    public Matrix transpose() {
        return this.transpose(this);
    }

    public Matrix4f translate(Vector2f vector2f) {
        return this.translate(vector2f, this);
    }

    public Matrix4f translate(Vector3f vector3f) {
        return this.translate(vector3f, this);
    }

    public Matrix4f scale(Vector3f vector3f) {
        return Matrix4f.scale(vector3f, this, this);
    }

    public static Matrix4f scale(Vector3f vector3f, Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (matrix4f2 == null) {
            matrix4f2 = new Matrix4f();
        }
        matrix4f2.m00 = matrix4f.m00 * vector3f.x;
        matrix4f2.m01 = matrix4f.m01 * vector3f.x;
        matrix4f2.m02 = matrix4f.m02 * vector3f.x;
        matrix4f2.m03 = matrix4f.m03 * vector3f.x;
        matrix4f2.m10 = matrix4f.m10 * vector3f.y;
        matrix4f2.m11 = matrix4f.m11 * vector3f.y;
        matrix4f2.m12 = matrix4f.m12 * vector3f.y;
        matrix4f2.m13 = matrix4f.m13 * vector3f.y;
        matrix4f2.m20 = matrix4f.m20 * vector3f.z;
        matrix4f2.m21 = matrix4f.m21 * vector3f.z;
        matrix4f2.m22 = matrix4f.m22 * vector3f.z;
        matrix4f2.m23 = matrix4f.m23 * vector3f.z;
        return matrix4f2;
    }

    public Matrix4f rotate(float f, Vector3f vector3f) {
        return this.rotate(f, vector3f, this);
    }

    public Matrix4f rotate(float f, Vector3f vector3f, Matrix4f matrix4f) {
        return Matrix4f.rotate(f, vector3f, this, matrix4f);
    }

    public static Matrix4f rotate(float f, Vector3f vector3f, Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (matrix4f2 == null) {
            matrix4f2 = new Matrix4f();
        }
        float f2 = (float)Math.cos(f);
        float f3 = (float)Math.sin(f);
        float f4 = 1.0f - f2;
        float f5 = vector3f.x * vector3f.y;
        float f6 = vector3f.y * vector3f.z;
        float f7 = vector3f.x * vector3f.z;
        float f8 = vector3f.x * f3;
        float f9 = vector3f.y * f3;
        float f10 = vector3f.z * f3;
        float f11 = vector3f.x * vector3f.x * f4 + f2;
        float f12 = f5 * f4 + f10;
        float f13 = f7 * f4 - f9;
        float f14 = f5 * f4 - f10;
        float f15 = vector3f.y * vector3f.y * f4 + f2;
        float f16 = f6 * f4 + f8;
        float f17 = f7 * f4 + f9;
        float f18 = f6 * f4 - f8;
        float f19 = vector3f.z * vector3f.z * f4 + f2;
        float f20 = matrix4f.m00 * f11 + matrix4f.m10 * f12 + matrix4f.m20 * f13;
        float f21 = matrix4f.m01 * f11 + matrix4f.m11 * f12 + matrix4f.m21 * f13;
        float f22 = matrix4f.m02 * f11 + matrix4f.m12 * f12 + matrix4f.m22 * f13;
        float f23 = matrix4f.m03 * f11 + matrix4f.m13 * f12 + matrix4f.m23 * f13;
        float f24 = matrix4f.m00 * f14 + matrix4f.m10 * f15 + matrix4f.m20 * f16;
        float f25 = matrix4f.m01 * f14 + matrix4f.m11 * f15 + matrix4f.m21 * f16;
        float f26 = matrix4f.m02 * f14 + matrix4f.m12 * f15 + matrix4f.m22 * f16;
        float f27 = matrix4f.m03 * f14 + matrix4f.m13 * f15 + matrix4f.m23 * f16;
        matrix4f2.m20 = matrix4f.m00 * f17 + matrix4f.m10 * f18 + matrix4f.m20 * f19;
        matrix4f2.m21 = matrix4f.m01 * f17 + matrix4f.m11 * f18 + matrix4f.m21 * f19;
        matrix4f2.m22 = matrix4f.m02 * f17 + matrix4f.m12 * f18 + matrix4f.m22 * f19;
        matrix4f2.m23 = matrix4f.m03 * f17 + matrix4f.m13 * f18 + matrix4f.m23 * f19;
        matrix4f2.m00 = f20;
        matrix4f2.m01 = f21;
        matrix4f2.m02 = f22;
        matrix4f2.m03 = f23;
        matrix4f2.m10 = f24;
        matrix4f2.m11 = f25;
        matrix4f2.m12 = f26;
        matrix4f2.m13 = f27;
        return matrix4f2;
    }

    public Matrix4f translate(Vector3f vector3f, Matrix4f matrix4f) {
        return Matrix4f.translate(vector3f, this, matrix4f);
    }

    public static Matrix4f translate(Vector3f vector3f, Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (matrix4f2 == null) {
            matrix4f2 = new Matrix4f();
        }
        matrix4f2.m30 += matrix4f.m00 * vector3f.x + matrix4f.m10 * vector3f.y + matrix4f.m20 * vector3f.z;
        matrix4f2.m31 += matrix4f.m01 * vector3f.x + matrix4f.m11 * vector3f.y + matrix4f.m21 * vector3f.z;
        matrix4f2.m32 += matrix4f.m02 * vector3f.x + matrix4f.m12 * vector3f.y + matrix4f.m22 * vector3f.z;
        matrix4f2.m33 += matrix4f.m03 * vector3f.x + matrix4f.m13 * vector3f.y + matrix4f.m23 * vector3f.z;
        return matrix4f2;
    }

    public Matrix4f translate(Vector2f vector2f, Matrix4f matrix4f) {
        return Matrix4f.translate(vector2f, this, matrix4f);
    }

    public static Matrix4f translate(Vector2f vector2f, Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (matrix4f2 == null) {
            matrix4f2 = new Matrix4f();
        }
        matrix4f2.m30 += matrix4f.m00 * vector2f.x + matrix4f.m10 * vector2f.y;
        matrix4f2.m31 += matrix4f.m01 * vector2f.x + matrix4f.m11 * vector2f.y;
        matrix4f2.m32 += matrix4f.m02 * vector2f.x + matrix4f.m12 * vector2f.y;
        matrix4f2.m33 += matrix4f.m03 * vector2f.x + matrix4f.m13 * vector2f.y;
        return matrix4f2;
    }

    public Matrix4f transpose(Matrix4f matrix4f) {
        return Matrix4f.transpose(this, matrix4f);
    }

    public static Matrix4f transpose(Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (matrix4f2 == null) {
            matrix4f2 = new Matrix4f();
        }
        float f = matrix4f.m00;
        float f2 = matrix4f.m10;
        float f3 = matrix4f.m20;
        float f4 = matrix4f.m30;
        float f5 = matrix4f.m01;
        float f6 = matrix4f.m11;
        float f7 = matrix4f.m21;
        float f8 = matrix4f.m31;
        float f9 = matrix4f.m02;
        float f10 = matrix4f.m12;
        float f11 = matrix4f.m22;
        float f12 = matrix4f.m32;
        float f13 = matrix4f.m03;
        float f14 = matrix4f.m13;
        float f15 = matrix4f.m23;
        float f16 = matrix4f.m33;
        matrix4f2.m00 = f;
        matrix4f2.m01 = f2;
        matrix4f2.m02 = f3;
        matrix4f2.m03 = f4;
        matrix4f2.m10 = f5;
        matrix4f2.m11 = f6;
        matrix4f2.m12 = f7;
        matrix4f2.m13 = f8;
        matrix4f2.m20 = f9;
        matrix4f2.m21 = f10;
        matrix4f2.m22 = f11;
        matrix4f2.m23 = f12;
        matrix4f2.m30 = f13;
        matrix4f2.m31 = f14;
        matrix4f2.m32 = f15;
        matrix4f2.m33 = f16;
        return matrix4f2;
    }

    @Override
    public float determinant() {
        float f = this.m00 * (this.m11 * this.m22 * this.m33 + this.m12 * this.m23 * this.m31 + this.m13 * this.m21 * this.m32 - this.m13 * this.m22 * this.m31 - this.m11 * this.m23 * this.m32 - this.m12 * this.m21 * this.m33);
        f -= this.m01 * (this.m10 * this.m22 * this.m33 + this.m12 * this.m23 * this.m30 + this.m13 * this.m20 * this.m32 - this.m13 * this.m22 * this.m30 - this.m10 * this.m23 * this.m32 - this.m12 * this.m20 * this.m33);
        f += this.m02 * (this.m10 * this.m21 * this.m33 + this.m11 * this.m23 * this.m30 + this.m13 * this.m20 * this.m31 - this.m13 * this.m21 * this.m30 - this.m10 * this.m23 * this.m31 - this.m11 * this.m20 * this.m33);
        return f -= this.m03 * (this.m10 * this.m21 * this.m32 + this.m11 * this.m22 * this.m30 + this.m12 * this.m20 * this.m31 - this.m12 * this.m21 * this.m30 - this.m10 * this.m22 * this.m31 - this.m11 * this.m20 * this.m32);
    }

    private static float determinant3x3(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return f * (f5 * f9 - f6 * f8) + f2 * (f6 * f7 - f4 * f9) + f3 * (f4 * f8 - f5 * f7);
    }

    @Override
    public Matrix invert() {
        return Matrix4f.invert(this, this);
    }

    public static Matrix4f invert(Matrix4f matrix4f, Matrix4f matrix4f2) {
        float f = matrix4f.determinant();
        if (f != 0.0f) {
            if (matrix4f2 == null) {
                matrix4f2 = new Matrix4f();
            }
            float f2 = 1.0f / f;
            float f3 = Matrix4f.determinant3x3(matrix4f.m11, matrix4f.m12, matrix4f.m13, matrix4f.m21, matrix4f.m22, matrix4f.m23, matrix4f.m31, matrix4f.m32, matrix4f.m33);
            float f4 = -Matrix4f.determinant3x3(matrix4f.m10, matrix4f.m12, matrix4f.m13, matrix4f.m20, matrix4f.m22, matrix4f.m23, matrix4f.m30, matrix4f.m32, matrix4f.m33);
            float f5 = Matrix4f.determinant3x3(matrix4f.m10, matrix4f.m11, matrix4f.m13, matrix4f.m20, matrix4f.m21, matrix4f.m23, matrix4f.m30, matrix4f.m31, matrix4f.m33);
            float f6 = -Matrix4f.determinant3x3(matrix4f.m10, matrix4f.m11, matrix4f.m12, matrix4f.m20, matrix4f.m21, matrix4f.m22, matrix4f.m30, matrix4f.m31, matrix4f.m32);
            float f7 = -Matrix4f.determinant3x3(matrix4f.m01, matrix4f.m02, matrix4f.m03, matrix4f.m21, matrix4f.m22, matrix4f.m23, matrix4f.m31, matrix4f.m32, matrix4f.m33);
            float f8 = Matrix4f.determinant3x3(matrix4f.m00, matrix4f.m02, matrix4f.m03, matrix4f.m20, matrix4f.m22, matrix4f.m23, matrix4f.m30, matrix4f.m32, matrix4f.m33);
            float f9 = -Matrix4f.determinant3x3(matrix4f.m00, matrix4f.m01, matrix4f.m03, matrix4f.m20, matrix4f.m21, matrix4f.m23, matrix4f.m30, matrix4f.m31, matrix4f.m33);
            float f10 = Matrix4f.determinant3x3(matrix4f.m00, matrix4f.m01, matrix4f.m02, matrix4f.m20, matrix4f.m21, matrix4f.m22, matrix4f.m30, matrix4f.m31, matrix4f.m32);
            float f11 = Matrix4f.determinant3x3(matrix4f.m01, matrix4f.m02, matrix4f.m03, matrix4f.m11, matrix4f.m12, matrix4f.m13, matrix4f.m31, matrix4f.m32, matrix4f.m33);
            float f12 = -Matrix4f.determinant3x3(matrix4f.m00, matrix4f.m02, matrix4f.m03, matrix4f.m10, matrix4f.m12, matrix4f.m13, matrix4f.m30, matrix4f.m32, matrix4f.m33);
            float f13 = Matrix4f.determinant3x3(matrix4f.m00, matrix4f.m01, matrix4f.m03, matrix4f.m10, matrix4f.m11, matrix4f.m13, matrix4f.m30, matrix4f.m31, matrix4f.m33);
            float f14 = -Matrix4f.determinant3x3(matrix4f.m00, matrix4f.m01, matrix4f.m02, matrix4f.m10, matrix4f.m11, matrix4f.m12, matrix4f.m30, matrix4f.m31, matrix4f.m32);
            float f15 = -Matrix4f.determinant3x3(matrix4f.m01, matrix4f.m02, matrix4f.m03, matrix4f.m11, matrix4f.m12, matrix4f.m13, matrix4f.m21, matrix4f.m22, matrix4f.m23);
            float f16 = Matrix4f.determinant3x3(matrix4f.m00, matrix4f.m02, matrix4f.m03, matrix4f.m10, matrix4f.m12, matrix4f.m13, matrix4f.m20, matrix4f.m22, matrix4f.m23);
            float f17 = -Matrix4f.determinant3x3(matrix4f.m00, matrix4f.m01, matrix4f.m03, matrix4f.m10, matrix4f.m11, matrix4f.m13, matrix4f.m20, matrix4f.m21, matrix4f.m23);
            float f18 = Matrix4f.determinant3x3(matrix4f.m00, matrix4f.m01, matrix4f.m02, matrix4f.m10, matrix4f.m11, matrix4f.m12, matrix4f.m20, matrix4f.m21, matrix4f.m22);
            matrix4f2.m00 = f3 * f2;
            matrix4f2.m11 = f8 * f2;
            matrix4f2.m22 = f13 * f2;
            matrix4f2.m33 = f18 * f2;
            matrix4f2.m01 = f7 * f2;
            matrix4f2.m10 = f4 * f2;
            matrix4f2.m20 = f5 * f2;
            matrix4f2.m02 = f11 * f2;
            matrix4f2.m12 = f12 * f2;
            matrix4f2.m21 = f9 * f2;
            matrix4f2.m03 = f15 * f2;
            matrix4f2.m30 = f6 * f2;
            matrix4f2.m13 = f16 * f2;
            matrix4f2.m31 = f10 * f2;
            matrix4f2.m32 = f14 * f2;
            matrix4f2.m23 = f17 * f2;
            return matrix4f2;
        }
        return null;
    }

    @Override
    public Matrix negate() {
        return this.negate(this);
    }

    public Matrix4f negate(Matrix4f matrix4f) {
        return Matrix4f.negate(this, matrix4f);
    }

    public static Matrix4f negate(Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (matrix4f2 == null) {
            matrix4f2 = new Matrix4f();
        }
        matrix4f2.m00 = -matrix4f.m00;
        matrix4f2.m01 = -matrix4f.m01;
        matrix4f2.m02 = -matrix4f.m02;
        matrix4f2.m03 = -matrix4f.m03;
        matrix4f2.m10 = -matrix4f.m10;
        matrix4f2.m11 = -matrix4f.m11;
        matrix4f2.m12 = -matrix4f.m12;
        matrix4f2.m13 = -matrix4f.m13;
        matrix4f2.m20 = -matrix4f.m20;
        matrix4f2.m21 = -matrix4f.m21;
        matrix4f2.m22 = -matrix4f.m22;
        matrix4f2.m23 = -matrix4f.m23;
        matrix4f2.m30 = -matrix4f.m30;
        matrix4f2.m31 = -matrix4f.m31;
        matrix4f2.m32 = -matrix4f.m32;
        matrix4f2.m33 = -matrix4f.m33;
        return matrix4f2;
    }
}

