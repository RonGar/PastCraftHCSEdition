/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.client.tmt;

import co.uk.flansmods.client.tmt.PositionTransformVertex;
import co.uk.flansmods.client.tmt.TexturedPolygon;

public class Shape3D {
    public PositionTransformVertex[] vertices;
    public TexturedPolygon[] faces;

    public Shape3D(PositionTransformVertex[] arrpositionTransformVertex, TexturedPolygon[] arrtexturedPolygon) {
        this.vertices = arrpositionTransformVertex;
        this.faces = arrtexturedPolygon;
    }
}

