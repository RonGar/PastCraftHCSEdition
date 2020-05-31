/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.vector;

import co.uk.flansmods.common.vector.ReadableVector;
import java.io.Serializable;
import java.nio.FloatBuffer;

public abstract class Vector
implements ReadableVector,
Serializable {
    @Override
    public final float length() {
        return (float)Math.sqrt(this.lengthSquared());
    }

    @Override
    public abstract float lengthSquared();

    public abstract Vector load(FloatBuffer var1);

    public abstract Vector negate();

    public final Vector normalise() {
        float f = this.length();
        if (f != 0.0f) {
            float f2 = 1.0f / f;
            return this.scale(f2);
        }
        throw new IllegalStateException("Zero length vector");
    }

    @Override
    public abstract Vector store(FloatBuffer var1);

    public abstract Vector scale(float var1);
}

