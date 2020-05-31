/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.client.tmt;

public class Angle3D {
    public float angleX;
    public float angleY;
    public float angleZ;

    public Angle3D(float f, float f2, float f3) {
        this.angleX = f;
        this.angleY = f2;
        this.angleZ = f3;
    }

    public void addAngles(float f, float f2, float f3) {
        this.angleX += f;
        this.angleY += f2;
        this.angleZ += f3;
    }

    public void addAngles(Angle3D angle3D) {
        this.angleX += angle3D.angleX;
        this.angleY += angle3D.angleY;
        this.angleZ += angle3D.angleZ;
    }

    public void multiplyAngles(float f, float f2, float f3) {
        this.angleX *= f;
        this.angleY *= f2;
        this.angleZ *= f3;
    }

    public void multiplyAngles(Angle3D angle3D) {
        this.angleX *= angle3D.angleX;
        this.angleY *= angle3D.angleY;
        this.angleZ *= angle3D.angleZ;
    }

    public static Angle3D getCenter(Angle3D angle3D, Angle3D angle3D2) {
        Angle3D angle3D3 = new Angle3D(0.0f, 0.0f, 0.0f);
        angle3D3.addAngles(angle3D);
        angle3D3.addAngles(angle3D2);
        angle3D3.multiplyAngles(0.5f, 0.5f, 0.5f);
        return angle3D3;
    }

    public Angle3D copy() {
        return new Angle3D(this.angleX, this.angleY, this.angleZ);
    }
}

