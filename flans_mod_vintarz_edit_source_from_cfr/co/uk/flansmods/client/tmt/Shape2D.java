/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.client.tmt;

import co.uk.flansmods.client.tmt.Coord2D;
import co.uk.flansmods.client.tmt.PositionTextureVertex;
import co.uk.flansmods.client.tmt.PositionTransformVertex;
import co.uk.flansmods.client.tmt.Shape3D;
import co.uk.flansmods.client.tmt.TexturedPolygon;
import java.util.ArrayList;
import net.minecraft.util.dwbg;
import net.minecraft.util.samw;

public class Shape2D {
    public ArrayList<Coord2D> coords;

    public Shape2D() {
        this.coords = new ArrayList();
    }

    public Shape2D(Coord2D[] arrcoord2D) {
        this.coords = new ArrayList();
        for (int i = 0; i < arrcoord2D.length; ++i) {
            this.coords.add(arrcoord2D[i]);
        }
    }

    public Shape2D(ArrayList<Coord2D> arrayList) {
        this.coords = arrayList;
    }

    public Coord2D[] getCoordArray() {
        return (Coord2D[])this.coords.toArray();
    }

    public Shape3D extrude(float f, float f2, float f3, float f4, float f5, float f6, float f7, int n, int n2, float f8, float f9, int n3, int n4, int n5, int n6, float[] arrf) {
        Coord2D coord2D;
        float f10;
        float f11;
        PositionTransformVertex[] arrpositionTransformVertex = new PositionTransformVertex[this.coords.size() * 2];
        PositionTextureVertex[] arrpositionTextureVertex = new PositionTransformVertex[this.coords.size()];
        PositionTextureVertex[] arrpositionTextureVertex2 = new PositionTransformVertex[this.coords.size()];
        TexturedPolygon[] arrtexturedPolygon = new TexturedPolygon[this.coords.size() + 2];
        samw samw2 = samw._a((double)0.0, (double)0.0, (double)f7);
        this.setVectorRotations(samw2, f4, f5, f6);
        if (arrf != null && arrf.length < this.coords.size()) {
            arrf = null;
        }
        float f12 = 0.0f;
        for (int i = 0; i < this.coords.size(); ++i) {
            Coord2D coord2D2 = this.coords.get(i);
            coord2D = this.coords.get((i + 1) % this.coords.size());
            float f13 = (float)(coord2D2.uCoord + n) / f8;
            f10 = (float)(n3 * 2 - coord2D2.uCoord + n) / f8;
            f11 = (float)(coord2D2.vCoord + n2) / f9;
            samw samw3 = samw._a((double)coord2D2.xCoord, (double)coord2D2.yCoord, (double)0.0);
            this.setVectorRotations(samw3, f4, f5, f6);
            arrpositionTransformVertex[i] = new PositionTransformVertex(f + (float)samw3._c, f2 + (float)samw3._d, f3 + (float)samw3._e, f13, f11);
            arrpositionTransformVertex[i + this.coords.size()] = new PositionTransformVertex(f + (float)samw3._c - (float)samw2._c, f2 + (float)samw3._d - (float)samw2._d, f3 + (float)samw3._e - (float)samw2._e, f10, f11);
            arrpositionTextureVertex[i] = new PositionTransformVertex(arrpositionTransformVertex[i]);
            arrpositionTextureVertex2[this.coords.size() - i - 1] = new PositionTransformVertex(arrpositionTransformVertex[i + this.coords.size()]);
            if (arrf != null) {
                f12 += arrf[i];
                continue;
            }
            f12 = (float)((double)f12 + Math.sqrt(Math.pow(coord2D2.xCoord - coord2D.xCoord, 2.0) + Math.pow(coord2D2.yCoord - coord2D.yCoord, 2.0)));
        }
        arrtexturedPolygon[this.coords.size()] = new TexturedPolygon(arrpositionTextureVertex);
        arrtexturedPolygon[this.coords.size() + 1] = new TexturedPolygon(arrpositionTextureVertex2);
        float f14 = f12;
        for (int i = 0; i < this.coords.size(); ++i) {
            coord2D = this.coords.get(i);
            Coord2D coord2D3 = this.coords.get((i + 1) % this.coords.size());
            f10 = (float)Math.sqrt(Math.pow(coord2D.xCoord - coord2D3.xCoord, 2.0) + Math.pow(coord2D.yCoord - coord2D3.yCoord, 2.0));
            if (arrf != null) {
                f10 = arrf[arrf.length - i - 1];
            }
            f11 = f14 / f12;
            float f15 = (f14 - f10) / f12;
            float f16 = (f15 * (float)n5 + (float)n) / f8;
            float f17 = (f11 * (float)n5 + (float)n) / f8;
            float f18 = ((float)n2 + (float)n4) / f9;
            float f19 = ((float)n2 + (float)n4 + (float)n6) / f9;
            PositionTextureVertex[] arrpositionTextureVertex3 = new PositionTransformVertex[]{new PositionTransformVertex(arrpositionTransformVertex[i], f17, f18), new PositionTransformVertex(arrpositionTransformVertex[this.coords.size() + i], f17, f19), new PositionTransformVertex(arrpositionTransformVertex[this.coords.size() + (i + 1) % this.coords.size()], f16, f19), new PositionTransformVertex(arrpositionTransformVertex[(i + 1) % this.coords.size()], f16, f18)};
            arrtexturedPolygon[i] = new TexturedPolygon(arrpositionTextureVertex3);
            f14 -= f10;
        }
        return new Shape3D(arrpositionTransformVertex, arrtexturedPolygon);
    }

    protected void setVectorRotations(samw samw2, float f, float f2, float f3) {
        float f4 = dwbg._b((float)f);
        float f5 = dwbg._a((float)f);
        float f6 = dwbg._b((float)f2);
        float f7 = dwbg._a((float)f2);
        float f8 = dwbg._b((float)f3);
        float f9 = dwbg._a((float)f3);
        double d = samw2._c;
        double d2 = samw2._d;
        double d3 = samw2._e;
        double d4 = (double)f4 * d2 - (double)f5 * d3;
        double d5 = (double)f4 * d3 + (double)f5 * d2;
        double d6 = (double)f6 * d5 - (double)f7 * d;
        double d7 = (double)f6 * d + (double)f7 * d5;
        double d8 = (double)f8 * d7 - (double)f9 * d4;
        double d9 = (double)f8 * d4 + (double)f9 * d7;
        d = d8;
        d2 = d9;
        d3 = d6;
        samw2._c = d;
        samw2._d = d2;
        samw2._e = d3;
    }
}

