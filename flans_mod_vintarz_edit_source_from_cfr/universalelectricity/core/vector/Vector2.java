/*
 * Decompiled with CFR 0.145.
 */
package universalelectricity.core.vector;

public class Vector2
implements Cloneable {
    public double x;
    public double y;

    public Vector2() {
        this(0.0, 0.0);
    }

    public Vector2(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public int intX() {
        return (int)Math.floor(this.x);
    }

    public int intY() {
        return (int)Math.floor(this.y);
    }

    public Vector2 clone() {
        return new Vector2(this.x, this.y);
    }

    public static double distance(Vector2 vector2, Vector2 vector22) {
        double d = vector2.x - vector22.x;
        double d2 = vector2.y - vector22.y;
        return Math.sqrt(d * d + d2 * d2);
    }

    public static double slope(Vector2 vector2, Vector2 vector22) {
        double d = vector2.x - vector22.x;
        double d2 = vector2.y - vector22.y;
        return d2 / d;
    }

    public double distanceTo(Vector2 vector2) {
        double d = this.x - vector2.x;
        double d2 = this.y - vector2.y;
        return Math.sqrt(d * d + d2 * d2);
    }

    public Vector2 add(Vector2 vector2) {
        this.x += vector2.x;
        this.y += vector2.y;
        return this;
    }

    public Vector2 add(double d) {
        this.x += d;
        this.y += d;
        return this;
    }

    public Vector2 invert() {
        this.multiply(-1.0);
        return this;
    }

    public Vector2 multiply(double d) {
        this.x *= d;
        this.y *= d;
        return this;
    }

    public Vector2 round() {
        return new Vector2(Math.round(this.x), Math.round(this.y));
    }

    public Vector2 ceil() {
        return new Vector2(Math.ceil(this.x), Math.ceil(this.y));
    }

    public Vector2 floor() {
        return new Vector2(Math.floor(this.x), Math.floor(this.y));
    }

    public int hashCode() {
        return ("X:" + this.x + "Y:" + this.y).hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof Vector2) {
            Vector2 vector2 = (Vector2)object;
            return this.x == vector2.x && this.y == vector2.y;
        }
        return false;
    }

    public String toString() {
        return "Vector2 [" + this.x + "," + this.y + "]";
    }
}

