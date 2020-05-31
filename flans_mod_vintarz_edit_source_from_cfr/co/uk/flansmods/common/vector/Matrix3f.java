/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.common.vector;

import net.minecraft.util.dwbg;
import net.minecraft.util.samw;

public class Matrix3f {
    float[][] matrix = new float[3][3];

    public Matrix3f(float[][] arrf) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.matrix[i][j] = arrf[i][j];
            }
        }
    }

    public Matrix3f(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.matrix[0][0] = f;
        this.matrix[0][1] = f2;
        this.matrix[0][2] = f3;
        this.matrix[1][0] = f4;
        this.matrix[1][1] = f5;
        this.matrix[1][2] = f6;
        this.matrix[2][0] = f7;
        this.matrix[2][1] = f8;
        this.matrix[2][2] = f9;
    }

    public Matrix3f mult(Matrix3f matrix3f) {
        return Matrix3f.multMatrix(this, matrix3f);
    }

    public samw mult(samw samw2) {
        return Matrix3f.multVec(this, samw2);
    }

    public static Matrix3f getMatrixRotX(float f) {
        float f2 = dwbg._a((float)f);
        float f3 = dwbg._b((float)f);
        return new Matrix3f(new float[][]{{1.0f, 0.0f, 0.0f}, {0.0f, f3, -f2}, {0.0f, f2, f3}});
    }

    public static Matrix3f getMatrixRotY(float f) {
        float f2 = dwbg._a((float)f);
        float f3 = dwbg._b((float)f);
        return new Matrix3f(new float[][]{{f3, 0.0f, f2}, {0.0f, 1.0f, 0.0f}, {-f2, 0.0f, f3}});
    }

    public static Matrix3f getMatrixRotZ(float f) {
        float f2 = dwbg._a((float)f);
        float f3 = dwbg._b((float)f);
        return new Matrix3f(new float[][]{{f3, -f2, 0.0f}, {f2, f3, 0.0f}, {0.0f, 0.0f, 1.0f}});
    }

    public static samw multVec(Matrix3f matrix3f, samw samw2) {
        float[] arrf = new float[3];
        for (int i = 0; i < 3; ++i) {
            float[] arrf2 = new float[]{matrix3f.matrix[i][0], matrix3f.matrix[i][1], matrix3f.matrix[i][2]};
            float[] arrf3 = new float[]{(float)samw2._c, (float)samw2._d, (float)samw2._e};
            for (int j = 0; j < 3; ++j) {
                float[] arrf4 = arrf;
                int n = i;
                arrf4[n] = arrf4[n] + arrf2[j] * arrf3[j];
            }
        }
        return samw._a((double)arrf[0], (double)arrf[1], (double)arrf[2]);
    }

    public static Matrix3f multMatrix(Matrix3f matrix3f, Matrix3f matrix3f2) {
        Matrix3f matrix3f3 = new Matrix3f(new float[3][3]);
        for (int i = 0; i < 3; ++i) {
            float[] arrf = new float[]{matrix3f.matrix[i][0], matrix3f.matrix[i][1], matrix3f.matrix[i][2]};
            for (int j = 0; j < 3; ++j) {
                float[] arrf2 = new float[]{matrix3f2.matrix[0][j], matrix3f2.matrix[1][j], matrix3f2.matrix[2][j]};
                for (int k = 0; k < 3; ++k) {
                    float[] arrf3 = matrix3f3.matrix[i];
                    int n = j;
                    arrf3[n] = arrf3[n] + arrf[k] * arrf2[k];
                }
            }
        }
        return matrix3f3;
    }
}

