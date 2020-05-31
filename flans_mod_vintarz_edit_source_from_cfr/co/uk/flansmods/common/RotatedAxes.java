/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.vector.Matrix4f;
import co.uk.flansmods.common.vector.Vector3f;

public class RotatedAxes {
    public float rotationYaw;
    public float rotationPitch;
    public float rotationRoll;
    public Matrix4f rotationMatrix;

    public RotatedAxes() {
        this.rotationMatrix = new Matrix4f();
    }

    public RotatedAxes(Matrix4f matrix4f) {
        this.rotationMatrix = matrix4f;
        this.convertMatrixToAngles();
    }

    public RotatedAxes(float f, float f2, float f3) {
        this.setAngles(f, f2, f3);
    }

    public RotatedAxes clone() {
        RotatedAxes rotatedAxes = new RotatedAxes();
        rotatedAxes.rotationMatrix.load(this.getMatrix());
        rotatedAxes.convertMatrixToAngles();
        return rotatedAxes;
    }

    public void setAngles(float f, float f2, float f3) {
        this.rotationYaw = f;
        this.rotationPitch = f2;
        this.rotationRoll = f3;
        this.convertAnglesToMatrix();
    }

    public float getYaw() {
        return this.rotationYaw;
    }

    public float getPitch() {
        return this.rotationPitch;
    }

    public float getRoll() {
        return this.rotationRoll;
    }

    public Vector3f getXAxis() {
        return new Vector3f(this.rotationMatrix.m00, this.rotationMatrix.m10, this.rotationMatrix.m20);
    }

    public Vector3f getYAxis() {
        return new Vector3f(this.rotationMatrix.m01, this.rotationMatrix.m11, this.rotationMatrix.m21);
    }

    public Vector3f getZAxis() {
        return new Vector3f(-this.rotationMatrix.m02, -this.rotationMatrix.m12, -this.rotationMatrix.m22);
    }

    public Matrix4f getMatrix() {
        return this.rotationMatrix;
    }

    public void rotateLocalYaw(float f) {
        this.rotationMatrix.rotate(f * 3.1415927f / 180.0f, this.getYAxis().normalise(null));
        this.convertMatrixToAngles();
    }

    public void rotateLocalPitch(float f) {
        this.rotationMatrix.rotate(f * 3.1415927f / 180.0f, this.getZAxis().normalise(null));
        this.convertMatrixToAngles();
    }

    public void rotateLocalRoll(float f) {
        this.rotationMatrix.rotate(f * 3.1415927f / 180.0f, this.getXAxis().normalise(null));
        this.convertMatrixToAngles();
    }

    public void rotateGlobalYaw(float f) {
        this.rotationMatrix.rotate(f * 3.1415927f / 180.0f, new Vector3f(0.0f, 1.0f, 0.0f));
        this.convertMatrixToAngles();
    }

    public void rotateGlobalPitch(float f) {
        this.rotationMatrix.rotate(f * 3.1415927f / 180.0f, new Vector3f(0.0f, 0.0f, 1.0f));
        this.convertMatrixToAngles();
    }

    public void rotateGlobalRoll(float f) {
        this.rotationMatrix.rotate(f * 3.1415927f / 180.0f, new Vector3f(1.0f, 0.0f, 0.0f));
        this.convertMatrixToAngles();
    }

    public void rotateLocal(float f, Vector3f vector3f) {
        this.rotationMatrix.rotate(f * 3.1415927f / 180.0f, this.findLocalVectorGlobally(vector3f));
        this.convertMatrixToAngles();
    }

    public void rotateGlobal(float f, Vector3f vector3f) {
        this.rotationMatrix.rotate(f * 3.1415927f / 180.0f, vector3f);
        this.convertMatrixToAngles();
    }

    public Vector3f findGlobalVectorLocally(Vector3f vector3f) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.m00 = vector3f.x;
        matrix4f.m10 = vector3f.y;
        matrix4f.m20 = vector3f.z;
        matrix4f.rotate(-this.rotationYaw * 3.1415927f / 180.0f, new Vector3f(0.0f, 1.0f, 0.0f));
        matrix4f.rotate(-this.rotationPitch * 3.1415927f / 180.0f, new Vector3f(0.0f, 0.0f, 1.0f));
        matrix4f.rotate(-this.rotationRoll * 3.1415927f / 180.0f, new Vector3f(1.0f, 0.0f, 0.0f));
        return new Vector3f(matrix4f.m00, matrix4f.m10, matrix4f.m20);
    }

    public Vector3f findLocalVectorGlobally(Vector3f vector3f) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.m00 = vector3f.x;
        matrix4f.m10 = vector3f.y;
        matrix4f.m20 = vector3f.z;
        matrix4f.rotate(this.rotationRoll * 3.1415927f / 180.0f, new Vector3f(1.0f, 0.0f, 0.0f));
        matrix4f.rotate(this.rotationPitch * 3.1415927f / 180.0f, new Vector3f(0.0f, 0.0f, 1.0f));
        matrix4f.rotate(this.rotationYaw * 3.1415927f / 180.0f, new Vector3f(0.0f, 1.0f, 0.0f));
        return new Vector3f(matrix4f.m00, matrix4f.m10, matrix4f.m20);
    }

    private void convertAnglesToMatrix() {
        this.rotationMatrix = new Matrix4f();
        this.rotationMatrix.rotate(this.rotationRoll * 3.1415927f / 180.0f, new Vector3f(1.0f, 0.0f, 0.0f));
        this.rotationMatrix.rotate(this.rotationPitch * 3.1415927f / 180.0f, new Vector3f(0.0f, 0.0f, 1.0f));
        this.rotationMatrix.rotate(this.rotationYaw * 3.1415927f / 180.0f, new Vector3f(0.0f, 1.0f, 0.0f));
        this.convertMatrixToAngles();
    }

    private void convertMatrixToAngles() {
        this.rotationYaw = (float)Math.atan2(this.rotationMatrix.m20, this.rotationMatrix.m00) * 180.0f / 3.1415927f;
        this.rotationPitch = (float)Math.atan2(-this.rotationMatrix.m10, Math.sqrt(this.rotationMatrix.m12 * this.rotationMatrix.m12 + this.rotationMatrix.m11 * this.rotationMatrix.m11)) * 180.0f / 3.1415927f;
        this.rotationRoll = (float)Math.atan2(this.rotationMatrix.m12, this.rotationMatrix.m11) * 180.0f / 3.1415927f;
    }

    public RotatedAxes findLocalAxesGlobally(RotatedAxes rotatedAxes) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.load(rotatedAxes.getMatrix());
        matrix4f.rotate(this.rotationRoll * 3.1415927f / 180.0f, new Vector3f(1.0f, 0.0f, 0.0f));
        matrix4f.rotate(this.rotationPitch * 3.1415927f / 180.0f, new Vector3f(0.0f, 0.0f, 1.0f));
        matrix4f.rotate(this.rotationYaw * 3.1415927f / 180.0f, new Vector3f(0.0f, 1.0f, 0.0f));
        return new RotatedAxes(matrix4f);
    }
}

