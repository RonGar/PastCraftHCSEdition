/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.client.tmt;

import co.uk.flansmods.client.tmt.PositionTextureVertex;
import co.uk.flansmods.client.tmt.PositionTransformVertex;
import co.uk.flansmods.client.tmt.TmtTessellator;
import java.util.ArrayList;
import net.minecraft.util.samw;

public class TexturedPolygon {
    public PositionTextureVertex[] vertexPositions;
    public int nVertices;
    private boolean invertNormal = false;
    private float[] normals;
    private ArrayList<samw> iNormals;

    public TexturedPolygon(PositionTextureVertex[] arrpositionTextureVertex) {
        this.vertexPositions = arrpositionTextureVertex;
        this.nVertices = arrpositionTextureVertex.length;
        this.iNormals = new ArrayList();
        this.normals = new float[0];
    }

    public TexturedPolygon(PositionTextureVertex[] arrpositionTextureVertex, int n, int n2, int n3, int n4, float f, float f2) {
        this(arrpositionTextureVertex);
        float f3 = 0.0f / f;
        float f4 = 0.0f / f2;
        arrpositionTextureVertex[0] = arrpositionTextureVertex[0].setTexturePosition((float)n3 / f - f3, (float)n2 / f2 + f4);
        arrpositionTextureVertex[1] = arrpositionTextureVertex[1].setTexturePosition((float)n / f + f3, (float)n2 / f2 + f4);
        arrpositionTextureVertex[2] = arrpositionTextureVertex[2].setTexturePosition((float)n / f + f3, (float)n4 / f2 - f4);
        arrpositionTextureVertex[3] = arrpositionTextureVertex[3].setTexturePosition((float)n3 / f - f3, (float)n4 / f2 - f4);
    }

    public void setInvertNormal(boolean bl) {
        this.invertNormal = bl;
    }

    public void setNormals(float f, float f2, float f3) {
        this.normals = new float[]{f, f2, f3};
    }

    public void flipFace() {
        PositionTextureVertex[] arrpositionTextureVertex = new PositionTextureVertex[this.vertexPositions.length];
        for (int i = 0; i < this.vertexPositions.length; ++i) {
            arrpositionTextureVertex[i] = this.vertexPositions[this.vertexPositions.length - i - 1];
        }
        this.vertexPositions = arrpositionTextureVertex;
    }

    public void setNormals(ArrayList<samw> arrayList) {
        this.iNormals = arrayList;
    }

    public void draw(TmtTessellator tmtTessellator, float f) {
        PositionTextureVertex positionTextureVertex;
        if (this.nVertices == 3) {
            tmtTessellator.func_78371_b(4);
        } else if (this.nVertices == 4) {
            tmtTessellator.func_78382_b();
        } else {
            tmtTessellator.func_78371_b(9);
        }
        if (this.iNormals.size() == 0) {
            if (this.normals.length == 3) {
                if (this.invertNormal) {
                    tmtTessellator.func_78375_b(-this.normals[0], -this.normals[1], -this.normals[2]);
                } else {
                    tmtTessellator.func_78375_b(this.normals[0], this.normals[1], this.normals[2]);
                }
            } else if (this.vertexPositions.length >= 3) {
                samw samw2 = this.vertexPositions[1].field_78243_a._a(this.vertexPositions[0].field_78243_a);
                positionTextureVertex = this.vertexPositions[1].field_78243_a._a(this.vertexPositions[2].field_78243_a);
                samw samw3 = positionTextureVertex._c(samw2)._a();
                if (this.invertNormal) {
                    tmtTessellator.func_78375_b(-((float)samw3._c), -((float)samw3._d), -((float)samw3._e));
                } else {
                    tmtTessellator.func_78375_b((float)samw3._c, (float)samw3._d, (float)samw3._e);
                }
            } else {
                return;
            }
        }
        for (int i = 0; i < this.nVertices; ++i) {
            positionTextureVertex = this.vertexPositions[i];
            if (positionTextureVertex instanceof PositionTransformVertex) {
                ((PositionTransformVertex)positionTextureVertex).setTransformation();
            }
            if (i < this.iNormals.size()) {
                if (this.invertNormal) {
                    tmtTessellator.func_78375_b(-((float)this.iNormals.get((int)i)._c), -((float)this.iNormals.get((int)i)._d), -((float)this.iNormals.get((int)i)._e));
                } else {
                    tmtTessellator.func_78375_b((float)this.iNormals.get((int)i)._c, (float)this.iNormals.get((int)i)._d, (float)this.iNormals.get((int)i)._e);
                }
            }
            tmtTessellator.addVertexWithUVW((float)positionTextureVertex.field_78243_a._c * f, (float)positionTextureVertex.field_78243_a._d * f, (float)positionTextureVertex.field_78243_a._e * f, positionTextureVertex.field_78241_b, positionTextureVertex.field_78242_c, positionTextureVertex.texturePositionW);
        }
        tmtTessellator.func_78381_a();
    }
}

