/*
 * Decompiled with CFR 0.145.
 */
package universalelectricity.prefab.vector;

import universalelectricity.core.vector.Vector2;

public class Region2 {
    public Vector2 min;
    public Vector2 max;

    public Region2() {
        this(new Vector2(), new Vector2());
    }

    public Region2(Vector2 vector2, Vector2 vector22) {
        this.min = vector2;
        this.max = vector22;
    }

    public boolean isIn(Vector2 vector2) {
        return vector2.x > this.min.x && vector2.x < this.max.x && vector2.y > this.min.y && vector2.y < this.max.y;
    }

    public boolean isIn(Region2 region2) {
        return region2.max.x > this.min.x && region2.min.x < this.max.x ? region2.max.y > this.min.y && region2.min.y < this.max.y : false;
    }
}

