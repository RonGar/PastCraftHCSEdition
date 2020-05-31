/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.client.tmt;

public class Coord2D {
    public double xCoord;
    public double yCoord;
    public int uCoord;
    public int vCoord;

    public Coord2D(double d, double d2) {
        this.xCoord = d;
        this.yCoord = d2;
        this.uCoord = (int)Math.floor(d);
        this.vCoord = (int)Math.floor(d2);
    }

    public Coord2D(double d, double d2, int n, int n2) {
        this(d, d2);
        this.uCoord = n;
        this.vCoord = n2;
    }
}

