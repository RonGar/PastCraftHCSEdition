/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.vector;

import co.uk.flansmods.common.vector.Vector;
import java.nio.FloatBuffer;

public interface ReadableVector {
    public float length();

    public float lengthSquared();

    public Vector store(FloatBuffer var1);
}

