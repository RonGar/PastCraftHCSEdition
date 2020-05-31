/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  dfsc
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.model.PositionTextureVertex
 *  net.minecraft.client.model.TexturedQuad
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.samw
 *  org.lwjgl.opengl.GL11
 *  zfwe
 *  zwqa
 */
package co.uk.flansmods.client.tmt;

import co.uk.flansmods.client.tmt.Bone;
import co.uk.flansmods.client.tmt.Coord2D;
import co.uk.flansmods.client.tmt.ModelPool;
import co.uk.flansmods.client.tmt.ModelPoolEntry;
import co.uk.flansmods.client.tmt.PositionTextureVertex;
import co.uk.flansmods.client.tmt.PositionTransformVertex;
import co.uk.flansmods.client.tmt.Shape2D;
import co.uk.flansmods.client.tmt.Shape3D;
import co.uk.flansmods.client.tmt.TextureGroup;
import co.uk.flansmods.client.tmt.TexturedPolygon;
import co.uk.flansmods.client.tmt.TmtTessellator;
import co.uk.flansmods.client.tmt.TransformGroup;
import co.uk.flansmods.client.tmt.TransformGroupBone;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwbg;
import net.minecraft.util.samw;
import org.lwjgl.opengl.GL11;

public class ModelRendererTurbo
extends ModelRenderer {
    private PositionTextureVertex[] vertices = new PositionTextureVertex[0];
    private TexturedPolygon[] faces = new TexturedPolygon[0];
    private int textureOffsetX;
    private int textureOffsetY;
    private boolean compiled = false;
    private int displayList = 0;
    private int[] displayListArray;
    private Map<String, TransformGroup> transformGroup = new HashMap<String, TransformGroup>();
    private Map<String, TextureGroup> textureGroup;
    private TransformGroup currentGroup;
    private TextureGroup currentTextureGroup;
    public boolean field_78809_i = false;
    public boolean flip = false;
    public boolean field_78806_j = true;
    public boolean field_1402_i = false;
    public boolean forcedRecompile = false;
    public boolean useLegacyCompiler = true;
    public List field_78804_l;
    public List field_78805_m;
    public final String field_78802_n;
    private String defaultTexture;
    public static final int MR_FRONT = 0;
    public static final int MR_BACK = 1;
    public static final int MR_LEFT = 2;
    public static final int MR_RIGHT = 3;
    public static final int MR_TOP = 4;
    public static final int MR_BOTTOM = 5;
    private static final float pi = 3.1415927f;

    public ModelRendererTurbo(ModelBase modelBase, String string) {
        super(modelBase, string);
        this.transformGroup.put("0", new TransformGroupBone(new Bone(0.0f, 0.0f, 0.0f, 0.0f), 1.0));
        this.textureGroup = new HashMap<String, TextureGroup>();
        this.textureGroup.put("0", new TextureGroup());
        this.currentTextureGroup = this.textureGroup.get("0");
        this.field_78802_n = string;
        this.defaultTexture = "";
    }

    public ModelRendererTurbo(ModelBase modelBase) {
        this(modelBase, null);
    }

    public ModelRendererTurbo(ModelBase modelBase, int n, int n2) {
        this(modelBase, n, n2, 64, 32);
    }

    public ModelRendererTurbo(ModelBase modelBase, int n, int n2, int n3, int n4) {
        this(modelBase);
        this.textureOffsetX = n;
        this.textureOffsetY = n2;
        this.field_78801_a = n3;
        this.field_78799_b = n4;
    }

    public void addPolygon(PositionTextureVertex[] arrpositionTextureVertex) {
        this.copyTo(arrpositionTextureVertex, new TexturedPolygon[]{new TexturedPolygon(arrpositionTextureVertex)});
    }

    public void addPolygon(PositionTextureVertex[] arrpositionTextureVertex, int[][] arrn) {
        try {
            for (int i = 0; i < arrpositionTextureVertex.length; ++i) {
                arrpositionTextureVertex[i] = arrpositionTextureVertex[i].setTexturePosition((float)arrn[i][0] / this.field_78801_a, (float)arrn[i][1] / this.field_78799_b);
            }
        }
        finally {
            this.addPolygon(arrpositionTextureVertex);
        }
    }

    public void addPolygon(PositionTextureVertex[] arrpositionTextureVertex, int n, int n2, int n3, int n4) {
        this.copyTo(arrpositionTextureVertex, new TexturedPolygon[]{this.addPolygonReturn(arrpositionTextureVertex, n, n2, n3, n4)});
    }

    private TexturedPolygon addPolygonReturn(PositionTextureVertex[] arrpositionTextureVertex, int n, int n2, int n3, int n4, float f, float f2, float f3, float f4) {
        if (arrpositionTextureVertex.length < 3) {
            return null;
        }
        float f5 = 1.0f / (this.field_78801_a * 10.0f);
        float f6 = 1.0f / (this.field_78799_b * 10.0f);
        if (arrpositionTextureVertex.length < 4) {
            float f7;
            float f8;
            float f9 = -1.0f;
            float f10 = -1.0f;
            float f11 = 0.0f;
            float f12 = 0.0f;
            for (int i = 0; i < arrpositionTextureVertex.length; ++i) {
                f8 = arrpositionTextureVertex[i].field_78241_b;
                f7 = arrpositionTextureVertex[i].field_78242_c;
                f11 = Math.max(f11, f8);
                f9 = f9 < -1.0f ? f8 : Math.min(f9, f8);
                f12 = Math.max(f12, f7);
                f10 = f10 < -1.0f ? f7 : Math.min(f10, f7);
            }
            float f13 = (float)n / this.field_78801_a + f5;
            f8 = (float)n2 / this.field_78799_b + f6;
            f7 = (float)(n3 - n) / this.field_78801_a - f5 * 2.0f;
            float f14 = (float)(n4 - n2) / this.field_78799_b - f6 * 2.0f;
            float f15 = f11 - f9;
            float f16 = f12 - f10;
            for (int i = 0; i < arrpositionTextureVertex.length; ++i) {
                float f17 = arrpositionTextureVertex[i].field_78241_b;
                float f18 = arrpositionTextureVertex[i].field_78242_c;
                f17 = (f17 - f9) / f15;
                f18 = (f18 - f10) / f16;
                arrpositionTextureVertex[i] = arrpositionTextureVertex[i].setTexturePosition(f13 + f17 * f7, f8 + f18 * f14);
            }
        } else {
            arrpositionTextureVertex[0] = arrpositionTextureVertex[0].setTexturePosition(((float)n3 / this.field_78801_a - f5) * f, ((float)n2 / this.field_78799_b + f6) * f, f);
            arrpositionTextureVertex[1] = arrpositionTextureVertex[1].setTexturePosition(((float)n / this.field_78801_a + f5) * f2, ((float)n2 / this.field_78799_b + f6) * f2, f2);
            arrpositionTextureVertex[2] = arrpositionTextureVertex[2].setTexturePosition(((float)n / this.field_78801_a + f5) * f3, ((float)n4 / this.field_78799_b - f6) * f3, f3);
            arrpositionTextureVertex[3] = arrpositionTextureVertex[3].setTexturePosition(((float)n3 / this.field_78801_a - f5) * f4, ((float)n4 / this.field_78799_b - f6) * f4, f4);
        }
        return new TexturedPolygon(arrpositionTextureVertex);
    }

    private TexturedPolygon addPolygonReturn(PositionTextureVertex[] arrpositionTextureVertex, int n, int n2, int n3, int n4) {
        if (arrpositionTextureVertex.length < 3) {
            return null;
        }
        float f = 1.0f / (this.field_78801_a * 10.0f);
        float f2 = 1.0f / (this.field_78799_b * 10.0f);
        if (arrpositionTextureVertex.length < 4) {
            float f3;
            float f4;
            float f5 = -1.0f;
            float f6 = -1.0f;
            float f7 = 0.0f;
            float f8 = 0.0f;
            for (int i = 0; i < arrpositionTextureVertex.length; ++i) {
                f4 = arrpositionTextureVertex[i].field_78241_b;
                f3 = arrpositionTextureVertex[i].field_78242_c;
                f7 = Math.max(f7, f4);
                f5 = f5 < -1.0f ? f4 : Math.min(f5, f4);
                f8 = Math.max(f8, f3);
                f6 = f6 < -1.0f ? f3 : Math.min(f6, f3);
            }
            float f9 = (float)n / this.field_78801_a + f;
            f4 = (float)n2 / this.field_78799_b + f2;
            f3 = (float)(n3 - n) / this.field_78801_a - f * 2.0f;
            float f10 = (float)(n4 - n2) / this.field_78799_b - f2 * 2.0f;
            float f11 = f7 - f5;
            float f12 = f8 - f6;
            for (int i = 0; i < arrpositionTextureVertex.length; ++i) {
                float f13 = arrpositionTextureVertex[i].field_78241_b;
                float f14 = arrpositionTextureVertex[i].field_78242_c;
                f13 = (f13 - f5) / f11;
                f14 = (f14 - f6) / f12;
                arrpositionTextureVertex[i] = arrpositionTextureVertex[i].setTexturePosition(f9 + f13 * f3, f4 + f14 * f10);
            }
        } else {
            arrpositionTextureVertex[0] = arrpositionTextureVertex[0].setTexturePosition((float)n3 / this.field_78801_a - f, (float)n2 / this.field_78799_b + f2);
            arrpositionTextureVertex[1] = arrpositionTextureVertex[1].setTexturePosition((float)n / this.field_78801_a + f, (float)n2 / this.field_78799_b + f2);
            arrpositionTextureVertex[2] = arrpositionTextureVertex[2].setTexturePosition((float)n / this.field_78801_a + f, (float)n4 / this.field_78799_b - f2);
            arrpositionTextureVertex[3] = arrpositionTextureVertex[3].setTexturePosition((float)n3 / this.field_78801_a - f, (float)n4 / this.field_78799_b - f2);
        }
        return new TexturedPolygon(arrpositionTextureVertex);
    }

    public void addRectShape(float[] arrf, float[] arrf2, float[] arrf3, float[] arrf4, float[] arrf5, float[] arrf6, float[] arrf7, float[] arrf8, int n, int n2, int n3) {
        float[] arrf9 = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        this.addRectShape(arrf, arrf2, arrf3, arrf4, arrf5, arrf6, arrf7, arrf8, n, n2, n3, arrf9);
    }

    public void addRectShape(float[] arrf, float[] arrf2, float[] arrf3, float[] arrf4, float[] arrf5, float[] arrf6, float[] arrf7, float[] arrf8, int n, int n2, int n3, float[] arrf9) {
        PositionTextureVertex[] arrpositionTextureVertex = new PositionTextureVertex[8];
        TexturedPolygon[] arrtexturedPolygon = new TexturedPolygon[6];
        PositionTextureVertex positionTextureVertex = new PositionTextureVertex(arrf[0], arrf[1], arrf[2], 0.0f, 0.0f);
        PositionTextureVertex positionTextureVertex2 = new PositionTextureVertex(arrf2[0], arrf2[1], arrf2[2], 0.0f, 8.0f);
        PositionTextureVertex positionTextureVertex3 = new PositionTextureVertex(arrf3[0], arrf3[1], arrf3[2], 8.0f, 8.0f);
        PositionTextureVertex positionTextureVertex4 = new PositionTextureVertex(arrf4[0], arrf4[1], arrf4[2], 8.0f, 0.0f);
        PositionTextureVertex positionTextureVertex5 = new PositionTextureVertex(arrf5[0], arrf5[1], arrf5[2], 0.0f, 0.0f);
        PositionTextureVertex positionTextureVertex6 = new PositionTextureVertex(arrf6[0], arrf6[1], arrf6[2], 0.0f, 8.0f);
        PositionTextureVertex positionTextureVertex7 = new PositionTextureVertex(arrf7[0], arrf7[1], arrf7[2], 8.0f, 8.0f);
        PositionTextureVertex positionTextureVertex8 = new PositionTextureVertex(arrf8[0], arrf8[1], arrf8[2], 8.0f, 0.0f);
        arrpositionTextureVertex[0] = positionTextureVertex;
        arrpositionTextureVertex[1] = positionTextureVertex2;
        arrpositionTextureVertex[2] = positionTextureVertex3;
        arrpositionTextureVertex[3] = positionTextureVertex4;
        arrpositionTextureVertex[4] = positionTextureVertex5;
        arrpositionTextureVertex[5] = positionTextureVertex6;
        arrpositionTextureVertex[6] = positionTextureVertex7;
        arrpositionTextureVertex[7] = positionTextureVertex8;
        arrtexturedPolygon[0] = this.addPolygonReturn(new PositionTextureVertex[]{positionTextureVertex6, positionTextureVertex2, positionTextureVertex3, positionTextureVertex7}, this.textureOffsetX + n3 + n, this.textureOffsetY + n3, this.textureOffsetX + n3 + n + n3, this.textureOffsetY + n3 + n2, 1.0f, arrf9[7], arrf9[10] * arrf9[7], arrf9[10]);
        arrtexturedPolygon[1] = this.addPolygonReturn(new PositionTextureVertex[]{positionTextureVertex, positionTextureVertex5, positionTextureVertex8, positionTextureVertex4}, this.textureOffsetX + 0, this.textureOffsetY + n3, this.textureOffsetX + n3, this.textureOffsetY + n3 + n2, arrf9[9] * arrf9[6], arrf9[9], 1.0f, arrf9[6]);
        arrtexturedPolygon[2] = this.addPolygonReturn(new PositionTextureVertex[]{positionTextureVertex6, positionTextureVertex5, positionTextureVertex, positionTextureVertex2}, this.textureOffsetX + n3, this.textureOffsetY + 0, this.textureOffsetX + n3 + n, this.textureOffsetY + n3, 1.0f, arrf9[8], arrf9[1] * arrf9[8], arrf9[1]);
        arrtexturedPolygon[3] = this.addPolygonReturn(new PositionTextureVertex[]{positionTextureVertex3, positionTextureVertex4, positionTextureVertex8, positionTextureVertex7}, this.textureOffsetX + n3 + n, this.textureOffsetY + 0, this.textureOffsetX + n3 + n + n, this.textureOffsetY + n3, arrf9[3], arrf9[3] * arrf9[11], arrf9[11], 1.0f);
        arrtexturedPolygon[4] = this.addPolygonReturn(new PositionTextureVertex[]{positionTextureVertex2, positionTextureVertex, positionTextureVertex4, positionTextureVertex3}, this.textureOffsetX + n3, this.textureOffsetY + n3, this.textureOffsetX + n3 + n, this.textureOffsetY + n3 + n2, arrf9[0], arrf9[0] * arrf9[4], arrf9[4], 1.0f);
        arrtexturedPolygon[5] = this.addPolygonReturn(new PositionTextureVertex[]{positionTextureVertex5, positionTextureVertex6, positionTextureVertex7, positionTextureVertex8}, this.textureOffsetX + n3 + n + n3, this.textureOffsetY + n3, this.textureOffsetX + n3 + n + n3 + n, this.textureOffsetY + n3 + n2, arrf9[2] * arrf9[5], arrf9[2], 1.0f, arrf9[5]);
        if (this.field_78809_i ^ this.flip) {
            for (int i = 0; i < 6; ++i) {
                arrtexturedPolygon[i].flipFace();
            }
        }
        this.copyTo(arrpositionTextureVertex, arrtexturedPolygon);
    }

    public ModelRendererTurbo addBox(float f, float f2, float f3, int n, int n2, int n3) {
        this.func_78790_a(f, f2, f3, n, n2, n3, 0.0f);
        return this;
    }

    public void func_78790_a(float f, float f2, float f3, int n, int n2, int n3, float f4) {
        this.addBox(f, f2, f3, n, n2, n3, f4, 1.0f);
    }

    public void addBox(float f, float f2, float f3, int n, int n2, int n3, float f4, float f5) {
        float f6 = (float)n * f5;
        float f7 = (float)n2 * f5;
        float f8 = (float)n3 * f5;
        float f9 = f + f6;
        float f10 = f2 + f7;
        float f11 = f3 + f8;
        float f12 = f4 + f6 - (float)n;
        float f13 = f4 + f7 - (float)n2;
        float f14 = f4 + f8 - (float)n3;
        f -= f12;
        f2 -= f13;
        f3 -= f14;
        f9 += f4;
        f10 += f4;
        f11 += f4;
        if (this.field_78809_i) {
            float f15 = f9;
            f9 = f;
            f = f15;
        }
        float[] arrf = new float[]{f, f2, f3};
        float[] arrf2 = new float[]{f9, f2, f3};
        float[] arrf3 = new float[]{f9, f10, f3};
        float[] arrf4 = new float[]{f, f10, f3};
        float[] arrf5 = new float[]{f, f2, f11};
        float[] arrf6 = new float[]{f9, f2, f11};
        float[] arrf7 = new float[]{f9, f10, f11};
        float[] arrf8 = new float[]{f, f10, f11};
        this.addRectShape(arrf, arrf2, arrf3, arrf4, arrf5, arrf6, arrf7, arrf8, n, n2, n3);
    }

    public void addTrapezoid(float f, float f2, float f3, int n, int n2, int n3, float f4, float f5, int n4) {
        int n5;
        float f6 = f + (float)n;
        float f7 = f2 + (float)n2;
        float f8 = f3 + (float)n3;
        f -= f4;
        f2 -= f4;
        f3 -= f4;
        f6 += f4;
        f7 += f4;
        f8 += f4;
        int n6 = n5 = this.field_78809_i ? -1 : 1;
        if (this.field_78809_i) {
            float f9 = f6;
            f6 = f;
            f = f9;
        }
        float[] arrf = new float[]{f, f2, f3};
        float[] arrf2 = new float[]{f6, f2, f3};
        float[] arrf3 = new float[]{f6, f7, f3};
        float[] arrf4 = new float[]{f, f7, f3};
        float[] arrf5 = new float[]{f, f2, f8};
        float[] arrf6 = new float[]{f6, f2, f8};
        float[] arrf7 = new float[]{f6, f7, f8};
        float[] arrf8 = new float[]{f, f7, f8};
        switch (n4) {
            case 3: {
                float[] arrf9 = arrf;
                arrf9[1] = arrf9[1] - f5;
                float[] arrf10 = arrf;
                arrf10[2] = arrf10[2] - f5;
                float[] arrf11 = arrf4;
                arrf11[1] = arrf11[1] + f5;
                float[] arrf12 = arrf4;
                arrf12[2] = arrf12[2] - f5;
                float[] arrf13 = arrf5;
                arrf13[1] = arrf13[1] - f5;
                float[] arrf14 = arrf5;
                arrf14[2] = arrf14[2] + f5;
                float[] arrf15 = arrf8;
                arrf15[1] = arrf15[1] + f5;
                float[] arrf16 = arrf8;
                arrf16[2] = arrf16[2] + f5;
                break;
            }
            case 2: {
                float[] arrf17 = arrf2;
                arrf17[1] = arrf17[1] - f5;
                float[] arrf18 = arrf2;
                arrf18[2] = arrf18[2] - f5;
                float[] arrf19 = arrf3;
                arrf19[1] = arrf19[1] + f5;
                float[] arrf20 = arrf3;
                arrf20[2] = arrf20[2] - f5;
                float[] arrf21 = arrf6;
                arrf21[1] = arrf21[1] - f5;
                float[] arrf22 = arrf6;
                arrf22[2] = arrf22[2] + f5;
                float[] arrf23 = arrf7;
                arrf23[1] = arrf23[1] + f5;
                float[] arrf24 = arrf7;
                arrf24[2] = arrf24[2] + f5;
                break;
            }
            case 0: {
                float[] arrf25 = arrf;
                arrf25[0] = arrf25[0] - (float)n5 * f5;
                float[] arrf26 = arrf;
                arrf26[1] = arrf26[1] - f5;
                float[] arrf27 = arrf2;
                arrf27[0] = arrf27[0] + (float)n5 * f5;
                float[] arrf28 = arrf2;
                arrf28[1] = arrf28[1] - f5;
                float[] arrf29 = arrf3;
                arrf29[0] = arrf29[0] + (float)n5 * f5;
                float[] arrf30 = arrf3;
                arrf30[1] = arrf30[1] + f5;
                float[] arrf31 = arrf4;
                arrf31[0] = arrf31[0] - (float)n5 * f5;
                float[] arrf32 = arrf4;
                arrf32[1] = arrf32[1] + f5;
                break;
            }
            case 1: {
                float[] arrf33 = arrf5;
                arrf33[0] = arrf33[0] - (float)n5 * f5;
                float[] arrf34 = arrf5;
                arrf34[1] = arrf34[1] - f5;
                float[] arrf35 = arrf6;
                arrf35[0] = arrf35[0] + (float)n5 * f5;
                float[] arrf36 = arrf6;
                arrf36[1] = arrf36[1] - f5;
                float[] arrf37 = arrf7;
                arrf37[0] = arrf37[0] + (float)n5 * f5;
                float[] arrf38 = arrf7;
                arrf38[1] = arrf38[1] + f5;
                float[] arrf39 = arrf8;
                arrf39[0] = arrf39[0] - (float)n5 * f5;
                float[] arrf40 = arrf8;
                arrf40[1] = arrf40[1] + f5;
                break;
            }
            case 4: {
                float[] arrf41 = arrf;
                arrf41[0] = arrf41[0] - (float)n5 * f5;
                float[] arrf42 = arrf;
                arrf42[2] = arrf42[2] - f5;
                float[] arrf43 = arrf2;
                arrf43[0] = arrf43[0] + (float)n5 * f5;
                float[] arrf44 = arrf2;
                arrf44[2] = arrf44[2] - f5;
                float[] arrf45 = arrf5;
                arrf45[0] = arrf45[0] - (float)n5 * f5;
                float[] arrf46 = arrf5;
                arrf46[2] = arrf46[2] + f5;
                float[] arrf47 = arrf6;
                arrf47[0] = arrf47[0] + (float)n5 * f5;
                float[] arrf48 = arrf6;
                arrf48[2] = arrf48[2] + f5;
                break;
            }
            case 5: {
                float[] arrf49 = arrf3;
                arrf49[0] = arrf49[0] + (float)n5 * f5;
                float[] arrf50 = arrf3;
                arrf50[2] = arrf50[2] - f5;
                float[] arrf51 = arrf4;
                arrf51[0] = arrf51[0] - (float)n5 * f5;
                float[] arrf52 = arrf4;
                arrf52[2] = arrf52[2] - f5;
                float[] arrf53 = arrf7;
                arrf53[0] = arrf53[0] + (float)n5 * f5;
                float[] arrf54 = arrf7;
                arrf54[2] = arrf54[2] + f5;
                float[] arrf55 = arrf8;
                arrf55[0] = arrf55[0] - (float)n5 * f5;
                float[] arrf56 = arrf8;
                arrf56[2] = arrf56[2] + f5;
            }
        }
        float[] arrf57 = new float[]{Math.abs((arrf[0] - arrf2[0]) / (arrf4[0] - arrf3[0])), Math.abs((arrf[0] - arrf2[0]) / (arrf5[0] - arrf6[0])), Math.abs((arrf5[0] - arrf6[0]) / (arrf8[0] - arrf7[0])), Math.abs((arrf4[0] - arrf3[0]) / (arrf8[0] - arrf7[0])), Math.abs((arrf[1] - arrf4[1]) / (arrf2[1] - arrf3[1])), Math.abs((arrf5[1] - arrf8[1]) / (arrf6[1] - arrf7[1])), Math.abs((arrf[1] - arrf4[1]) / (arrf5[1] - arrf8[1])), Math.abs((arrf2[1] - arrf3[1]) / (arrf6[1] - arrf7[1])), Math.abs((arrf[2] - arrf5[2]) / (arrf2[2] - arrf6[2])), Math.abs((arrf[2] - arrf5[2]) / (arrf4[2] - arrf8[2])), Math.abs((arrf2[2] - arrf6[2]) / (arrf3[2] - arrf7[2])), Math.abs((arrf4[2] - arrf8[2]) / (arrf3[2] - arrf7[2]))};
        this.addRectShape(arrf, arrf2, arrf3, arrf4, arrf5, arrf6, arrf7, arrf8, n, n2, n3);
    }

    public void addFlexBox(float f, float f2, float f3, int n, int n2, int n3, float f4, float f5, float f6, float f7, float f8, int n4) {
        int n5;
        float f9 = f + (float)n;
        float f10 = f2 + (float)n2;
        float f11 = f3 + (float)n3;
        f -= f4;
        f2 -= f4;
        f3 -= f4;
        f9 += f4;
        f10 += f4;
        f11 += f4;
        int n6 = n5 = this.field_78809_i ? -1 : 1;
        if (this.field_78809_i) {
            float f12 = f9;
            f9 = f;
            f = f12;
        }
        float[] arrf = new float[]{f, f2, f3};
        float[] arrf2 = new float[]{f9, f2, f3};
        float[] arrf3 = new float[]{f9, f10, f3};
        float[] arrf4 = new float[]{f, f10, f3};
        float[] arrf5 = new float[]{f, f2, f11};
        float[] arrf6 = new float[]{f9, f2, f11};
        float[] arrf7 = new float[]{f9, f10, f11};
        float[] arrf8 = new float[]{f, f10, f11};
        switch (n4) {
            case 3: {
                float[] arrf9 = arrf;
                arrf9[1] = arrf9[1] - f5;
                float[] arrf10 = arrf;
                arrf10[2] = arrf10[2] - f7;
                float[] arrf11 = arrf4;
                arrf11[1] = arrf11[1] + f6;
                float[] arrf12 = arrf4;
                arrf12[2] = arrf12[2] - f7;
                float[] arrf13 = arrf5;
                arrf13[1] = arrf13[1] - f5;
                float[] arrf14 = arrf5;
                arrf14[2] = arrf14[2] + f8;
                float[] arrf15 = arrf8;
                arrf15[1] = arrf15[1] + f6;
                float[] arrf16 = arrf8;
                arrf16[2] = arrf16[2] + f8;
                break;
            }
            case 2: {
                float[] arrf17 = arrf2;
                arrf17[1] = arrf17[1] - f5;
                float[] arrf18 = arrf2;
                arrf18[2] = arrf18[2] - f7;
                float[] arrf19 = arrf3;
                arrf19[1] = arrf19[1] + f6;
                float[] arrf20 = arrf3;
                arrf20[2] = arrf20[2] - f7;
                float[] arrf21 = arrf6;
                arrf21[1] = arrf21[1] - f5;
                float[] arrf22 = arrf6;
                arrf22[2] = arrf22[2] + f8;
                float[] arrf23 = arrf7;
                arrf23[1] = arrf23[1] + f6;
                float[] arrf24 = arrf7;
                arrf24[2] = arrf24[2] + f8;
                break;
            }
            case 0: {
                float[] arrf25 = arrf;
                arrf25[0] = arrf25[0] - (float)n5 * f8;
                float[] arrf26 = arrf;
                arrf26[1] = arrf26[1] - f5;
                float[] arrf27 = arrf2;
                arrf27[0] = arrf27[0] + (float)n5 * f7;
                float[] arrf28 = arrf2;
                arrf28[1] = arrf28[1] - f5;
                float[] arrf29 = arrf3;
                arrf29[0] = arrf29[0] + (float)n5 * f7;
                float[] arrf30 = arrf3;
                arrf30[1] = arrf30[1] + f6;
                float[] arrf31 = arrf4;
                arrf31[0] = arrf31[0] - (float)n5 * f8;
                float[] arrf32 = arrf4;
                arrf32[1] = arrf32[1] + f6;
                break;
            }
            case 1: {
                float[] arrf33 = arrf5;
                arrf33[0] = arrf33[0] - (float)n5 * f8;
                float[] arrf34 = arrf5;
                arrf34[1] = arrf34[1] - f5;
                float[] arrf35 = arrf6;
                arrf35[0] = arrf35[0] + (float)n5 * f7;
                float[] arrf36 = arrf6;
                arrf36[1] = arrf36[1] - f5;
                float[] arrf37 = arrf7;
                arrf37[0] = arrf37[0] + (float)n5 * f7;
                float[] arrf38 = arrf7;
                arrf38[1] = arrf38[1] + f6;
                float[] arrf39 = arrf8;
                arrf39[0] = arrf39[0] - (float)n5 * f8;
                float[] arrf40 = arrf8;
                arrf40[1] = arrf40[1] + f6;
                break;
            }
            case 4: {
                float[] arrf41 = arrf;
                arrf41[0] = arrf41[0] - (float)n5 * f5;
                float[] arrf42 = arrf;
                arrf42[2] = arrf42[2] - f7;
                float[] arrf43 = arrf2;
                arrf43[0] = arrf43[0] + (float)n5 * f6;
                float[] arrf44 = arrf2;
                arrf44[2] = arrf44[2] - f7;
                float[] arrf45 = arrf5;
                arrf45[0] = arrf45[0] - (float)n5 * f5;
                float[] arrf46 = arrf5;
                arrf46[2] = arrf46[2] + f8;
                float[] arrf47 = arrf6;
                arrf47[0] = arrf47[0] + (float)n5 * f6;
                float[] arrf48 = arrf6;
                arrf48[2] = arrf48[2] + f8;
                break;
            }
            case 5: {
                float[] arrf49 = arrf3;
                arrf49[0] = arrf49[0] + (float)n5 * f6;
                float[] arrf50 = arrf3;
                arrf50[2] = arrf50[2] - f7;
                float[] arrf51 = arrf4;
                arrf51[0] = arrf51[0] - (float)n5 * f5;
                float[] arrf52 = arrf4;
                arrf52[2] = arrf52[2] - f7;
                float[] arrf53 = arrf7;
                arrf53[0] = arrf53[0] + (float)n5 * f6;
                float[] arrf54 = arrf7;
                arrf54[2] = arrf54[2] + f8;
                float[] arrf55 = arrf8;
                arrf55[0] = arrf55[0] - (float)n5 * f5;
                float[] arrf56 = arrf8;
                arrf56[2] = arrf56[2] + f8;
            }
        }
        float[] arrf57 = new float[]{Math.abs((arrf[0] - arrf2[0]) / (arrf4[0] - arrf3[0])), Math.abs((arrf[0] - arrf2[0]) / (arrf5[0] - arrf6[0])), Math.abs((arrf5[0] - arrf6[0]) / (arrf8[0] - arrf7[0])), Math.abs((arrf4[0] - arrf3[0]) / (arrf8[0] - arrf7[0])), Math.abs((arrf[1] - arrf4[1]) / (arrf2[1] - arrf3[1])), Math.abs((arrf5[1] - arrf8[1]) / (arrf6[1] - arrf7[1])), Math.abs((arrf[1] - arrf4[1]) / (arrf5[1] - arrf8[1])), Math.abs((arrf2[1] - arrf3[1]) / (arrf6[1] - arrf7[1])), Math.abs((arrf[2] - arrf5[2]) / (arrf2[2] - arrf6[2])), Math.abs((arrf[2] - arrf5[2]) / (arrf4[2] - arrf8[2])), Math.abs((arrf2[2] - arrf6[2]) / (arrf3[2] - arrf7[2])), Math.abs((arrf4[2] - arrf8[2]) / (arrf3[2] - arrf7[2]))};
        this.addRectShape(arrf, arrf2, arrf3, arrf4, arrf5, arrf6, arrf7, arrf8, n, n2, n3);
    }

    public void addFlexTrapezoid(float f, float f2, float f3, int n, int n2, int n3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int n4) {
        int n5;
        float f11 = f + (float)n;
        float f12 = f2 + (float)n2;
        float f13 = f3 + (float)n3;
        f -= f4;
        f2 -= f4;
        f3 -= f4;
        f11 += f4;
        f12 += f4;
        f13 += f4;
        int n6 = n5 = this.field_78809_i ? -1 : 1;
        if (this.field_78809_i) {
            float f14 = f11;
            f11 = f;
            f = f14;
        }
        float[] arrf = new float[]{f, f2, f3};
        float[] arrf2 = new float[]{f11, f2, f3};
        float[] arrf3 = new float[]{f11, f12, f3};
        float[] arrf4 = new float[]{f, f12, f3};
        float[] arrf5 = new float[]{f, f2, f13};
        float[] arrf6 = new float[]{f11, f2, f13};
        float[] arrf7 = new float[]{f11, f12, f13};
        float[] arrf8 = new float[]{f, f12, f13};
        switch (n4) {
            case 3: {
                float[] arrf9 = arrf;
                arrf9[2] = arrf9[2] - f9;
                float[] arrf10 = arrf2;
                arrf10[2] = arrf10[2] - f9;
                float[] arrf11 = arrf5;
                arrf11[2] = arrf11[2] + f10;
                float[] arrf12 = arrf6;
                arrf12[2] = arrf12[2] + f10;
                float[] arrf13 = arrf;
                arrf13[1] = arrf13[1] - f5;
                float[] arrf14 = arrf;
                arrf14[2] = arrf14[2] - f7;
                float[] arrf15 = arrf4;
                arrf15[1] = arrf15[1] + f6;
                float[] arrf16 = arrf4;
                arrf16[2] = arrf16[2] - f7;
                float[] arrf17 = arrf5;
                arrf17[1] = arrf17[1] - f5;
                float[] arrf18 = arrf5;
                arrf18[2] = arrf18[2] + f8;
                float[] arrf19 = arrf8;
                arrf19[1] = arrf19[1] + f6;
                float[] arrf20 = arrf8;
                arrf20[2] = arrf20[2] + f8;
                break;
            }
            case 2: {
                float[] arrf21 = arrf;
                arrf21[2] = arrf21[2] - f9;
                float[] arrf22 = arrf2;
                arrf22[2] = arrf22[2] - f9;
                float[] arrf23 = arrf5;
                arrf23[2] = arrf23[2] + f10;
                float[] arrf24 = arrf6;
                arrf24[2] = arrf24[2] + f10;
                float[] arrf25 = arrf2;
                arrf25[1] = arrf25[1] - f5;
                float[] arrf26 = arrf2;
                arrf26[2] = arrf26[2] - f7;
                float[] arrf27 = arrf3;
                arrf27[1] = arrf27[1] + f6;
                float[] arrf28 = arrf3;
                arrf28[2] = arrf28[2] - f7;
                float[] arrf29 = arrf6;
                arrf29[1] = arrf29[1] - f5;
                float[] arrf30 = arrf6;
                arrf30[2] = arrf30[2] + f8;
                float[] arrf31 = arrf7;
                arrf31[1] = arrf31[1] + f6;
                float[] arrf32 = arrf7;
                arrf32[2] = arrf32[2] + f8;
                break;
            }
            case 0: {
                float[] arrf33 = arrf2;
                arrf33[1] = arrf33[1] - f9;
                float[] arrf34 = arrf6;
                arrf34[1] = arrf34[1] - f9;
                float[] arrf35 = arrf3;
                arrf35[1] = arrf35[1] + f10;
                float[] arrf36 = arrf7;
                arrf36[1] = arrf36[1] + f10;
                float[] arrf37 = arrf;
                arrf37[0] = arrf37[0] - (float)n5 * f8;
                float[] arrf38 = arrf;
                arrf38[1] = arrf38[1] - f5;
                float[] arrf39 = arrf2;
                arrf39[0] = arrf39[0] + (float)n5 * f7;
                float[] arrf40 = arrf2;
                arrf40[1] = arrf40[1] - f5;
                float[] arrf41 = arrf3;
                arrf41[0] = arrf41[0] + (float)n5 * f7;
                float[] arrf42 = arrf3;
                arrf42[1] = arrf42[1] + f6;
                float[] arrf43 = arrf4;
                arrf43[0] = arrf43[0] - (float)n5 * f8;
                float[] arrf44 = arrf4;
                arrf44[1] = arrf44[1] + f6;
                break;
            }
            case 1: {
                float[] arrf45 = arrf2;
                arrf45[1] = arrf45[1] - f9;
                float[] arrf46 = arrf6;
                arrf46[1] = arrf46[1] - f9;
                float[] arrf47 = arrf3;
                arrf47[1] = arrf47[1] + f10;
                float[] arrf48 = arrf7;
                arrf48[1] = arrf48[1] + f10;
                float[] arrf49 = arrf5;
                arrf49[0] = arrf49[0] - (float)n5 * f8;
                float[] arrf50 = arrf5;
                arrf50[1] = arrf50[1] - f5;
                float[] arrf51 = arrf6;
                arrf51[0] = arrf51[0] + (float)n5 * f7;
                float[] arrf52 = arrf6;
                arrf52[1] = arrf52[1] - f5;
                float[] arrf53 = arrf7;
                arrf53[0] = arrf53[0] + (float)n5 * f7;
                float[] arrf54 = arrf7;
                arrf54[1] = arrf54[1] + f6;
                float[] arrf55 = arrf8;
                arrf55[0] = arrf55[0] - (float)n5 * f8;
                float[] arrf56 = arrf8;
                arrf56[1] = arrf56[1] + f6;
                break;
            }
            case 4: {
                float[] arrf57 = arrf2;
                arrf57[2] = arrf57[2] - f9;
                float[] arrf58 = arrf3;
                arrf58[2] = arrf58[2] - f9;
                float[] arrf59 = arrf6;
                arrf59[2] = arrf59[2] + f10;
                float[] arrf60 = arrf7;
                arrf60[2] = arrf60[2] + f10;
                float[] arrf61 = arrf;
                arrf61[0] = arrf61[0] - (float)n5 * f5;
                float[] arrf62 = arrf;
                arrf62[2] = arrf62[2] - f7;
                float[] arrf63 = arrf2;
                arrf63[0] = arrf63[0] + (float)n5 * f6;
                float[] arrf64 = arrf2;
                arrf64[2] = arrf64[2] - f7;
                float[] arrf65 = arrf5;
                arrf65[0] = arrf65[0] - (float)n5 * f5;
                float[] arrf66 = arrf5;
                arrf66[2] = arrf66[2] + f8;
                float[] arrf67 = arrf6;
                arrf67[0] = arrf67[0] + (float)n5 * f6;
                float[] arrf68 = arrf6;
                arrf68[2] = arrf68[2] + f8;
                break;
            }
            case 5: {
                float[] arrf69 = arrf2;
                arrf69[2] = arrf69[2] - f9;
                float[] arrf70 = arrf3;
                arrf70[2] = arrf70[2] - f9;
                float[] arrf71 = arrf6;
                arrf71[2] = arrf71[2] + f10;
                float[] arrf72 = arrf7;
                arrf72[2] = arrf72[2] + f10;
                float[] arrf73 = arrf3;
                arrf73[0] = arrf73[0] + (float)n5 * f6;
                float[] arrf74 = arrf3;
                arrf74[2] = arrf74[2] - f7;
                float[] arrf75 = arrf4;
                arrf75[0] = arrf75[0] - (float)n5 * f5;
                float[] arrf76 = arrf4;
                arrf76[2] = arrf76[2] - f7;
                float[] arrf77 = arrf7;
                arrf77[0] = arrf77[0] + (float)n5 * f6;
                float[] arrf78 = arrf7;
                arrf78[2] = arrf78[2] + f8;
                float[] arrf79 = arrf8;
                arrf79[0] = arrf79[0] - (float)n5 * f5;
                float[] arrf80 = arrf8;
                arrf80[2] = arrf80[2] + f8;
            }
        }
        float[] arrf81 = new float[]{Math.abs((arrf[0] - arrf2[0]) / (arrf4[0] - arrf3[0])), Math.abs((arrf[0] - arrf2[0]) / (arrf5[0] - arrf6[0])), Math.abs((arrf5[0] - arrf6[0]) / (arrf8[0] - arrf7[0])), Math.abs((arrf4[0] - arrf3[0]) / (arrf8[0] - arrf7[0])), Math.abs((arrf[1] - arrf4[1]) / (arrf2[1] - arrf3[1])), Math.abs((arrf5[1] - arrf8[1]) / (arrf6[1] - arrf7[1])), Math.abs((arrf[1] - arrf4[1]) / (arrf5[1] - arrf8[1])), Math.abs((arrf2[1] - arrf3[1]) / (arrf6[1] - arrf7[1])), Math.abs((arrf[2] - arrf5[2]) / (arrf2[2] - arrf6[2])), Math.abs((arrf[2] - arrf5[2]) / (arrf4[2] - arrf8[2])), Math.abs((arrf2[2] - arrf6[2]) / (arrf3[2] - arrf7[2])), Math.abs((arrf4[2] - arrf8[2]) / (arrf3[2] - arrf7[2]))};
        this.addRectShape(arrf, arrf2, arrf3, arrf4, arrf5, arrf6, arrf7, arrf8, n, n2, n3);
    }

    public void addBox(float f, float f2, float f3, float f4, float f5, float f6) {
        int n = dwbg._f((float)f4);
        int n2 = dwbg._f((float)f5);
        int n3 = dwbg._f((float)f6);
        this.addShapeBox(f, f2, f3, n, n2, n3, 0.0f, 0.0f, 0.0f, 0.0f, f4 -= (float)n, 0.0f, 0.0f, f4, 0.0f, f6 -= (float)n3, 0.0f, 0.0f, f6, 0.0f, f5 -= (float)n2, 0.0f, f4, f5, 0.0f, f4, f5, f6, 0.0f, f5, f6);
    }

    public void addShapeBox(float f, float f2, float f3, int n, int n2, int n3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25, float f26, float f27, float f28) {
        float f29 = f + (float)n;
        float f30 = f2 + (float)n2;
        float f31 = f3 + (float)n3;
        f -= f4;
        f2 -= f4;
        f3 -= f4;
        f29 += f4;
        f30 += f4;
        f31 += f4;
        if (this.field_78809_i) {
            float f32 = f29;
            f29 = f;
            f = f32;
        }
        float[] arrf = new float[]{f - f5, f2 - f6, f3 - f7};
        float[] arrf2 = new float[]{f29 + f8, f2 - f9, f3 - f10};
        float[] arrf3 = new float[]{f29 + f20, f30 + f21, f3 - f22};
        float[] arrf4 = new float[]{f - f17, f30 + f18, f3 - f19};
        float[] arrf5 = new float[]{f - f14, f2 - f15, f31 + f16};
        float[] arrf6 = new float[]{f29 + f11, f2 - f12, f31 + f13};
        float[] arrf7 = new float[]{f29 + f23, f30 + f24, f31 + f25};
        float[] arrf8 = new float[]{f - f26, f30 + f27, f31 + f28};
        float[] arrf9 = new float[]{Math.abs((arrf[0] - arrf2[0]) / (arrf4[0] - arrf3[0])), Math.abs((arrf[0] - arrf2[0]) / (arrf5[0] - arrf6[0])), Math.abs((arrf5[0] - arrf6[0]) / (arrf8[0] - arrf7[0])), Math.abs((arrf4[0] - arrf3[0]) / (arrf8[0] - arrf7[0])), Math.abs((arrf[1] - arrf4[1]) / (arrf2[1] - arrf3[1])), Math.abs((arrf5[1] - arrf8[1]) / (arrf6[1] - arrf7[1])), Math.abs((arrf[1] - arrf4[1]) / (arrf5[1] - arrf8[1])), Math.abs((arrf2[1] - arrf3[1]) / (arrf6[1] - arrf7[1])), Math.abs((arrf[2] - arrf5[2]) / (arrf2[2] - arrf6[2])), Math.abs((arrf[2] - arrf5[2]) / (arrf4[2] - arrf8[2])), Math.abs((arrf2[2] - arrf6[2]) / (arrf3[2] - arrf7[2])), Math.abs((arrf4[2] - arrf8[2]) / (arrf3[2] - arrf7[2]))};
        this.addRectShape(arrf, arrf2, arrf3, arrf4, arrf5, arrf6, arrf7, arrf8, n, n2, n3);
    }

    public void addShape3D(float f, float f2, float f3, Coord2D[] arrcoord2D, float f4, int n, int n2, int n3, int n4, int n5) {
        this.addShape3D(f, f2, f3, arrcoord2D, f4, n, n2, n3, n4, n5, null);
    }

    public void addShape3D(float f, float f2, float f3, Coord2D[] arrcoord2D, float f4, int n, int n2, int n3, int n4, int n5, float[] arrf) {
        this.addShape3D(f, f2, f3, new Shape2D(arrcoord2D), f4, n, n2, n3, n4, n5, arrf);
    }

    public void addShape3D(float f, float f2, float f3, ArrayList<Coord2D> arrayList, float f4, int n, int n2, int n3, int n4, int n5) {
        this.addShape3D(f, f2, f3, arrayList, f4, n, n2, n3, n4, n5, null);
    }

    public void addShape3D(float f, float f2, float f3, ArrayList<Coord2D> arrayList, float f4, int n, int n2, int n3, int n4, int n5, float[] arrf) {
        this.addShape3D(f, f2, f3, new Shape2D(arrayList), f4, n, n2, n3, n4, n5, arrf);
    }

    public void addShape3D(float f, float f2, float f3, Shape2D shape2D, float f4, int n, int n2, int n3, int n4, int n5) {
        this.addShape3D(f, f2, f3, shape2D, f4, n, n2, n3, n4, n5, null);
    }

    public void addShape3D(float f, float f2, float f3, Shape2D shape2D, float f4, int n, int n2, int n3, int n4, int n5, float[] arrf) {
        float f5 = 0.0f;
        float f6 = 0.0f;
        switch (n5) {
            case 2: {
                f6 = 1.5707964f;
                break;
            }
            case 3: {
                f6 = -1.5707964f;
                break;
            }
            case 4: {
                f5 = 1.5707964f;
                break;
            }
            case 5: {
                f5 = -1.5707964f;
                break;
            }
            case 0: {
                f6 = 3.1415927f;
            }
        }
        this.addShape3D(f, f2, f3, shape2D, f4, n, n2, n3, n4, f5, f6, 0.0f, arrf);
    }

    public void addShape3D(float f, float f2, float f3, Shape2D shape2D, float f4, int n, int n2, int n3, int n4, float f5, float f6, float f7) {
        this.addShape3D(f, f2, f3, shape2D, f4, n, n2, n3, n4, f5, f6, f7, null);
    }

    public void addShape3D(float f, float f2, float f3, Shape2D shape2D, float f4, int n, int n2, int n3, int n4, float f5, float f6, float f7, float[] arrf) {
        Shape3D shape3D = shape2D.extrude(f, f2, f3, f5, f6, f7, f4, this.textureOffsetX, this.textureOffsetY, this.field_78801_a, this.field_78799_b, n, n2, n3, n4, arrf);
        if (this.flip) {
            for (int i = 0; i < shape3D.faces.length; ++i) {
                shape3D.faces[i].flipFace();
            }
        }
        this.copyTo((PositionTextureVertex[])shape3D.vertices, shape3D.faces);
    }

    public void addPixel(float f, float f2, float f3, float f4, float f5, float f6) {
        this.addPixel(f, f2, f3, new float[]{f4, f5, f6}, this.textureOffsetX, this.textureOffsetY);
    }

    public void addPixel(float f, float f2, float f3, float[] arrf, int n, int n2) {
        PositionTextureVertex[] arrpositionTextureVertex = new PositionTextureVertex[8];
        TexturedPolygon[] arrtexturedPolygon = new TexturedPolygon[6];
        float f4 = f + arrf[0];
        float f5 = f2 + arrf[1];
        float f6 = f3 + arrf[2];
        float[] arrf2 = new float[]{f, f2, f3};
        float[] arrf3 = new float[]{f4, f2, f3};
        float[] arrf4 = new float[]{f4, f5, f3};
        float[] arrf5 = new float[]{f, f5, f3};
        float[] arrf6 = new float[]{f, f2, f6};
        float[] arrf7 = new float[]{f4, f2, f6};
        float[] arrf8 = new float[]{f4, f5, f6};
        float[] arrf9 = new float[]{f, f5, f6};
        PositionTextureVertex positionTextureVertex = new PositionTextureVertex(arrf2[0], arrf2[1], arrf2[2], 0.0f, 0.0f);
        PositionTextureVertex positionTextureVertex2 = new PositionTextureVertex(arrf3[0], arrf3[1], arrf3[2], 0.0f, 8.0f);
        PositionTextureVertex positionTextureVertex3 = new PositionTextureVertex(arrf4[0], arrf4[1], arrf4[2], 8.0f, 8.0f);
        PositionTextureVertex positionTextureVertex4 = new PositionTextureVertex(arrf5[0], arrf5[1], arrf5[2], 8.0f, 0.0f);
        PositionTextureVertex positionTextureVertex5 = new PositionTextureVertex(arrf6[0], arrf6[1], arrf6[2], 0.0f, 0.0f);
        PositionTextureVertex positionTextureVertex6 = new PositionTextureVertex(arrf7[0], arrf7[1], arrf7[2], 0.0f, 8.0f);
        PositionTextureVertex positionTextureVertex7 = new PositionTextureVertex(arrf8[0], arrf8[1], arrf8[2], 8.0f, 8.0f);
        PositionTextureVertex positionTextureVertex8 = new PositionTextureVertex(arrf9[0], arrf9[1], arrf9[2], 8.0f, 0.0f);
        arrpositionTextureVertex[0] = positionTextureVertex;
        arrpositionTextureVertex[1] = positionTextureVertex2;
        arrpositionTextureVertex[2] = positionTextureVertex3;
        arrpositionTextureVertex[3] = positionTextureVertex4;
        arrpositionTextureVertex[4] = positionTextureVertex5;
        arrpositionTextureVertex[5] = positionTextureVertex6;
        arrpositionTextureVertex[6] = positionTextureVertex7;
        arrpositionTextureVertex[7] = positionTextureVertex8;
        arrtexturedPolygon[0] = this.addPolygonReturn(new PositionTextureVertex[]{positionTextureVertex6, positionTextureVertex2, positionTextureVertex3, positionTextureVertex7}, n, n2, n + 1, n2 + 1);
        arrtexturedPolygon[1] = this.addPolygonReturn(new PositionTextureVertex[]{positionTextureVertex, positionTextureVertex5, positionTextureVertex8, positionTextureVertex4}, n, n2, n + 1, n2 + 1);
        arrtexturedPolygon[2] = this.addPolygonReturn(new PositionTextureVertex[]{positionTextureVertex6, positionTextureVertex5, positionTextureVertex, positionTextureVertex2}, n, n2, n + 1, n2 + 1);
        arrtexturedPolygon[3] = this.addPolygonReturn(new PositionTextureVertex[]{positionTextureVertex3, positionTextureVertex4, positionTextureVertex8, positionTextureVertex7}, n, n2, n + 1, n2 + 1);
        arrtexturedPolygon[4] = this.addPolygonReturn(new PositionTextureVertex[]{positionTextureVertex2, positionTextureVertex, positionTextureVertex4, positionTextureVertex3}, n, n2, n + 1, n2 + 1);
        arrtexturedPolygon[5] = this.addPolygonReturn(new PositionTextureVertex[]{positionTextureVertex5, positionTextureVertex6, positionTextureVertex7, positionTextureVertex8}, n, n2, n + 1, n2 + 1);
        this.copyTo(arrpositionTextureVertex, arrtexturedPolygon);
    }

    public void addSprite(float f, float f2, float f3, int n, int n2, float f4) {
        this.addSprite(f, f2, f3, n, n2, 1, false, false, false, false, false, f4);
    }

    public void addSprite(float f, float f2, float f3, int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, float f4) {
        this.addSprite(f, f2, f3, n, n2, 1, bl, bl2, bl3, bl4, bl5, f4);
    }

    public void addSprite(float f, float f2, float f3, int n, int n2, int n3, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, float f4) {
        this.addSprite(f, f2, f3, n, n2, n3, 1.0f, bl, bl2, bl3, bl4, bl5, f4);
    }

    public void addSprite(float f, float f2, float f3, int n, int n2, int n3, float f4, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, float f5) {
        Object[] arrobject = new String[n2];
        char[] arrc = new char[n];
        Arrays.fill(arrc, '1');
        Arrays.fill(arrobject, new String(arrc));
        this.addSprite(f, f2, f3, (String[])arrobject, n3, f4, bl, bl2, bl3, bl4, bl5, f5);
    }

    public void addSprite(float f, float f2, float f3, String[] arrstring, int n, float f4, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, float f5) {
        int n2;
        int n3;
        int n4;
        int n5 = arrstring[0].length();
        int n6 = arrstring.length;
        float f6 = f - f5;
        float f7 = f2 - f5;
        float f8 = f3 - f5;
        float f9 = 1.0f + f5 / ((float)n5 * f4);
        float f10 = 1.0f + f5 / ((float)n6 * f4);
        if (!bl) {
            if (!bl2) {
                if (!bl3) {
                    n2 = 0;
                    n4 = 1;
                    n3 = 2;
                } else {
                    n2 = 1;
                    n4 = 0;
                    n3 = 2;
                }
            } else if (!bl3) {
                n2 = 2;
                n4 = 1;
                n3 = 0;
            } else {
                n2 = 2;
                n4 = 0;
                n3 = 1;
            }
        } else if (!bl2) {
            if (!bl3) {
                n2 = 0;
                n4 = 2;
                n3 = 1;
            } else {
                n2 = 1;
                n4 = 2;
                n3 = 0;
            }
        } else if (!bl3) {
            n2 = 2;
            n4 = 0;
            n3 = 1;
        } else {
            n2 = 2;
            n4 = 1;
            n3 = 0;
        }
        int n7 = this.textureOffsetX + (bl4 ? n5 * 1 - 1 : 0);
        int n8 = this.textureOffsetY + (bl5 ? n6 * 1 - 1 : 0);
        int n9 = bl4 ? -1 : 1;
        int n10 = bl5 ? -1 : 1;
        float f11 = this.getPixelSize(f9, f10, (float)n * f4 + f5 * 2.0f, 0, 1, n2, 1, 1);
        float f12 = this.getPixelSize(f9, f10, (float)n * f4 + f5 * 2.0f, 0, 1, n4, 1, 1);
        float f13 = this.getPixelSize(f9, f10, (float)n * f4 + f5 * 2.0f, 0, 1, n3, 1, 1);
        for (int i = 0; i < n5; ++i) {
            for (int j = 0; j < n6; ++j) {
                if (arrstring[j].charAt(i) != '1') continue;
                this.addPixel(f6 + this.getPixelSize(f9, f10, 0.0f, n2, n4, 0, i, j), f7 + this.getPixelSize(f9, f10, 0.0f, n2, n4, 1, i, j), f8 + this.getPixelSize(f9, f10, 0.0f, n2, n4, 2, i, j), new float[]{f11, f12, f13}, n7 + n9 * i, n8 + n10 * j);
            }
        }
    }

    private float getPixelSize(float f, float f2, float f3, int n, int n2, int n3, int n4, int n5) {
        return n == n3 ? f * (float)n4 : (n2 == n3 ? f2 * (float)n5 : f3);
    }

    public void addSphere(float f, float f2, float f3, float f4, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        PositionTextureVertex[] arrpositionTextureVertex;
        if (n < 3) {
            n = 3;
        }
        PositionTextureVertex[] arrpositionTextureVertex2 = new PositionTextureVertex[n * (++n2 - 1) + 2];
        TexturedPolygon[] arrtexturedPolygon = new TexturedPolygon[n * n2];
        arrpositionTextureVertex2[0] = new PositionTextureVertex(f, f2 - f4, f3, 0.0f, 0.0f);
        arrpositionTextureVertex2[arrpositionTextureVertex2.length - 1] = new PositionTextureVertex(f, f2 + f4, f3, 0.0f, 0.0f);
        float f5 = 1.0f / (this.field_78801_a * 10.0f);
        float f6 = 1.0f / (this.field_78799_b * 10.0f);
        float f7 = (float)n3 / this.field_78801_a - 2.0f * f5;
        float f8 = (float)n4 / this.field_78799_b - 2.0f * f6;
        float f9 = f7 / (float)n;
        float f10 = f8 / (float)n2;
        float f11 = (float)this.textureOffsetX / this.field_78801_a;
        float f12 = (float)this.textureOffsetY / this.field_78799_b;
        int n7 = 0;
        for (n5 = 1; n5 < n2; ++n5) {
            for (int i = 0; i < n; ++i) {
                n6 = (int)dwbg._b((float)(-1.5707964f + 3.1415927f / (float)n2 * (float)n5));
                float f13 = dwbg._a((float)(-1.5707964f + 3.1415927f / (float)n2 * (float)n5));
                float f14 = dwbg._a((float)(3.1415927f / (float)n * (float)i * 2.0f + 3.1415927f)) * n6;
                float f15 = -dwbg._b((float)(3.1415927f / (float)n * (float)i * 2.0f + 3.1415927f)) * n6;
                int n8 = 1 + i + n * (n5 - 1);
                arrpositionTextureVertex2[n8] = new PositionTextureVertex(f + f14 * f4, f2 + f13 * f4, f3 + f15 * f4, 0.0f, 0.0f);
                if (i <= 0) continue;
                PositionTextureVertex[] arrpositionTextureVertex3 = n5 == 1 ? new PositionTextureVertex[]{arrpositionTextureVertex2[n8].setTexturePosition(f11 + f9 * (float)i, f12 + f10 * (float)n5), arrpositionTextureVertex2[n8 - 1].setTexturePosition(f11 + f9 * (float)(i - 1), f12 + f10 * (float)n5), arrpositionTextureVertex2[0].setTexturePosition(f11 + f9 * (float)(i - 1), f12), arrpositionTextureVertex2[0].setTexturePosition(f11 + f9 + f9 * (float)i, f12)} : new PositionTextureVertex[]{arrpositionTextureVertex2[n8].setTexturePosition(f11 + f9 * (float)i, f12 + f10 * (float)n5), arrpositionTextureVertex2[n8 - 1].setTexturePosition(f11 + f9 * (float)(i - 1), f12 + f10 * (float)n5), arrpositionTextureVertex2[n8 - 1 - n].setTexturePosition(f11 + f9 * (float)(i - 1), f12 + f10 * (float)(n5 - 1)), arrpositionTextureVertex2[n8 - n].setTexturePosition(f11 + f9 * (float)i, f12 + f10 * (float)(n5 - 1))};
                arrtexturedPolygon[n7] = new TexturedPolygon(arrpositionTextureVertex3);
                ++n7;
            }
            arrpositionTextureVertex = n5 == 1 ? new PositionTextureVertex[]{arrpositionTextureVertex2[1].setTexturePosition(f11 + f9 * (float)n, f12 + f10 * (float)n5), arrpositionTextureVertex2[n].setTexturePosition(f11 + f9 * (float)(n - 1), f12 + f10 * (float)n5), arrpositionTextureVertex2[0].setTexturePosition(f11 + f9 * (float)(n - 1), f12), arrpositionTextureVertex2[0].setTexturePosition(f11 + f9 * (float)n, f12)} : new PositionTextureVertex[]{arrpositionTextureVertex2[1 + n * (n5 - 1)].setTexturePosition(f11 + f7, f12 + f10 * (float)n5), arrpositionTextureVertex2[n * (n5 - 1) + n].setTexturePosition(f11 + f7 - f9, f12 + f10 * (float)n5), arrpositionTextureVertex2[n * (n5 - 1)].setTexturePosition(f11 + f7 - f9, f12 + f10 * (float)(n5 - 1)), arrpositionTextureVertex2[1 + n * (n5 - 1) - n].setTexturePosition(f11 + f7, f12 + f10 * (float)(n5 - 1))};
            arrtexturedPolygon[n7] = new TexturedPolygon(arrpositionTextureVertex);
            ++n7;
        }
        for (n5 = 0; n5 < n; ++n5) {
            arrpositionTextureVertex = new PositionTextureVertex[3];
            n6 = arrpositionTextureVertex2.length - (n + 1);
            arrpositionTextureVertex[0] = arrpositionTextureVertex2[arrpositionTextureVertex2.length - 1].setTexturePosition(f11 + f9 * ((float)n5 + 0.5f), f12 + f8);
            arrpositionTextureVertex[1] = arrpositionTextureVertex2[n6 + n5].setTexturePosition(f11 + f9 * (float)n5, f12 + f8 - f10);
            arrpositionTextureVertex[2] = arrpositionTextureVertex2[n6 + (n5 + 1) % n].setTexturePosition(f11 + f9 * (float)(n5 + 1), f12 + f8 - f10);
            arrtexturedPolygon[n7] = new TexturedPolygon(arrpositionTextureVertex);
            ++n7;
        }
        this.copyTo(arrpositionTextureVertex2, arrtexturedPolygon);
    }

    public void addCone(float f, float f2, float f3, float f4, float f5, int n) {
        this.addCone(f, f2, f3, f4, f5, n, 1.0f);
    }

    public void addCone(float f, float f2, float f3, float f4, float f5, int n, float f6) {
        this.addCone(f, f2, f3, f4, f5, n, f6, 4);
    }

    public void addCone(float f, float f2, float f3, float f4, float f5, int n, float f6, int n2) {
        this.addCone(f, f2, f3, f4, f5, n, f6, n2, (int)Math.floor(f4 * 2.0f), (int)Math.floor(f4 * 2.0f));
    }

    public void addCone(float f, float f2, float f3, float f4, float f5, int n, float f6, int n2, int n3, int n4) {
        this.addCylinder(f, f2, f3, f4, f5, n, f6, 0.0f, n2, n3, n4, 1);
    }

    public void addCylinder(float f, float f2, float f3, float f4, float f5, int n) {
        this.addCylinder(f, f2, f3, f4, f5, n, 1.0f, 1.0f);
    }

    public void addCylinder(float f, float f2, float f3, float f4, float f5, int n, float f6, float f7) {
        this.addCylinder(f, f2, f3, f4, f5, n, f6, f7, 4);
    }

    public void addCylinder(float f, float f2, float f3, float f4, float f5, int n, float f6, float f7, int n2) {
        this.addCylinder(f, f2, f3, f4, f5, n, f6, f7, n2, (int)Math.floor(f4 * 2.0f), (int)Math.floor(f4 * 2.0f), (int)Math.floor(f5));
    }

    public void addCylinder(float f, float f2, float f3, float f4, float f5, int n, float f6, float f7, int n2, int n3, int n4, int n5) {
        float f8;
        float f9;
        boolean bl;
        float f10;
        float f11;
        float f12;
        boolean bl2 = n2 == 4 || n2 == 5;
        boolean bl3 = n2 == 3 || n2 == 2;
        boolean bl4 = n2 == 0 || n2 == 1;
        boolean bl5 = n2 == 2 || n2 == 5 || n2 == 1;
        boolean bl6 = f6 == 0.0f;
        boolean bl7 = bl = f7 == 0.0f;
        if (bl6 && bl) {
            f6 = 1.0f;
            bl6 = false;
        }
        PositionTextureVertex[] arrpositionTextureVertex = new PositionTextureVertex[n * (bl6 || bl ? 1 : 2) + 2];
        TexturedPolygon[] arrtexturedPolygon = new TexturedPolygon[n * (bl6 || bl ? 2 : 3)];
        float f13 = bl3 ? f5 : 0.0f;
        float f14 = bl2 ? f5 : 0.0f;
        float f15 = bl4 ? f5 : 0.0f;
        float f16 = bl5 ? f + f13 : f;
        float f17 = bl5 ? f2 + f14 : f2;
        float f18 = bl5 ? f3 + f15 : f3;
        float f19 = !bl5 ? f + f13 : f;
        float f20 = !bl5 ? f2 + f14 : f2;
        float f21 = !bl5 ? f3 + f15 : f3;
        arrpositionTextureVertex[0] = new PositionTextureVertex(f16, f17, f18, 0.0f, 0.0f);
        arrpositionTextureVertex[arrpositionTextureVertex.length - 1] = new PositionTextureVertex(f19, f20, f21, 0.0f, 0.0f);
        float f22 = f16;
        float f23 = f17;
        float f24 = f18;
        float f25 = bl6 ? f7 : f6;
        for (int i = 0; i < (bl6 || bl ? 1 : 2); ++i) {
            for (int j = 0; j < n; ++j) {
                f8 = (float)(this.field_78809_i ^ bl5 ? -1 : 1) * dwbg._a((float)(3.1415927f / (float)n * (float)j * 2.0f + 3.1415927f)) * f4 * f25;
                f12 = -dwbg._b((float)(3.1415927f / (float)n * (float)j * 2.0f + 3.1415927f)) * f4 * f25;
                f9 = f22 + (!bl3 ? f8 : 0.0f);
                f10 = f23 + (!bl2 ? f12 : 0.0f);
                f11 = f24 + (bl3 ? f8 : (bl2 ? f12 : 0.0f));
                arrpositionTextureVertex[1 + j + i * n] = new PositionTextureVertex(f9, f10, f11, 0.0f, 0.0f);
            }
            f22 = f19;
            f23 = f20;
            f24 = f21;
            f25 = f7;
        }
        float f26 = 1.0f / this.field_78801_a;
        float f27 = 1.0f / this.field_78799_b;
        f8 = f26 / 20.0f;
        f12 = f27 / 20.0f;
        f9 = (float)n3 * f26;
        f10 = (float)n4 * f27;
        f11 = (f9 * 2.0f - f8 * 2.0f) / (float)n;
        float f28 = (float)n5 * f27 - f8 * 2.0f;
        float f29 = (float)this.textureOffsetX * f26;
        float f30 = (float)this.textureOffsetY * f27;
        for (int i = 0; i < n; ++i) {
            int n6 = (i + 1) % n;
            float f31 = dwbg._a((float)(3.1415927f / (float)n * (float)i * 2.0f + (!bl2 ? 0.0f : 3.1415927f))) * (0.5f * f9 - 2.0f * f8);
            float f32 = dwbg._b((float)(3.1415927f / (float)n * (float)i * 2.0f + (!bl2 ? 0.0f : 3.1415927f))) * (0.5f * f10 - 2.0f * f12);
            float f33 = dwbg._a((float)(3.1415927f / (float)n * (float)n6 * 2.0f + (!bl2 ? 0.0f : 3.1415927f))) * (0.5f * f9 - 2.0f * f8);
            float f34 = dwbg._b((float)(3.1415927f / (float)n * (float)n6 * 2.0f + (!bl2 ? 0.0f : 3.1415927f))) * (0.5f * f10 - 2.0f * f12);
            PositionTextureVertex[] arrpositionTextureVertex2 = new PositionTextureVertex[]{arrpositionTextureVertex[0].setTexturePosition(f29 + 0.5f * f9, f30 + 0.5f * f10), arrpositionTextureVertex[1 + n6].setTexturePosition(f29 + 0.5f * f9 + f33, f30 + 0.5f * f10 + f34), arrpositionTextureVertex[1 + i].setTexturePosition(f29 + 0.5f * f9 + f31, f30 + 0.5f * f10 + f32)};
            arrtexturedPolygon[i] = new TexturedPolygon(arrpositionTextureVertex2);
            if (this.field_78809_i ^ this.flip) {
                arrtexturedPolygon[i].flipFace();
            }
            if (!bl6 && !bl) {
                arrpositionTextureVertex2 = new PositionTextureVertex[]{arrpositionTextureVertex[1 + i].setTexturePosition(f29 + f8 + f11 * (float)i, f30 + f12 + f10), arrpositionTextureVertex[1 + n6].setTexturePosition(f29 + f8 + f11 * (float)(i + 1), f30 + f12 + f10), arrpositionTextureVertex[1 + n + n6].setTexturePosition(f29 + f8 + f11 * (float)(i + 1), f30 + f12 + f10 + f28), arrpositionTextureVertex[1 + n + i].setTexturePosition(f29 + f8 + f11 * (float)i, f30 + f12 + f10 + f28)};
                arrtexturedPolygon[i + n] = new TexturedPolygon(arrpositionTextureVertex2);
                if (this.field_78809_i ^ this.flip) {
                    arrtexturedPolygon[i + n].flipFace();
                }
            }
            arrpositionTextureVertex2 = new PositionTextureVertex[]{arrpositionTextureVertex[arrpositionTextureVertex.length - 1].setTexturePosition(f29 + 1.5f * f9, f30 + 0.5f * f10), arrpositionTextureVertex[arrpositionTextureVertex.length - 2 - i].setTexturePosition(f29 + 1.5f * f9 + f33, f30 + 0.5f * f10 + f34), arrpositionTextureVertex[arrpositionTextureVertex.length - (1 + n) + (n - i) % n].setTexturePosition(f29 + 1.5f * f9 + f31, f30 + 0.5f * f10 + f32)};
            arrtexturedPolygon[arrtexturedPolygon.length - n + i] = new TexturedPolygon(arrpositionTextureVertex2);
            if (!(this.field_78809_i ^ this.flip)) continue;
            arrtexturedPolygon[arrtexturedPolygon.length - n + i].flipFace();
        }
        this.copyTo(arrpositionTextureVertex, arrtexturedPolygon);
    }

    public void addObj(String string) {
        this.addModel(string, ModelPool.OBJ);
    }

    public void addModel(String string, Class class_) {
        ModelPoolEntry modelPoolEntry = ModelPool.addFile(string, class_, this.transformGroup, this.textureGroup);
        if (modelPoolEntry == null) {
            return;
        }
        PositionTextureVertex[] arrpositionTextureVertex = Arrays.copyOf(modelPoolEntry.vertices, modelPoolEntry.vertices.length);
        TexturedPolygon[] arrtexturedPolygon = Arrays.copyOf(modelPoolEntry.faces, modelPoolEntry.faces.length);
        if (this.flip) {
            for (int i = 0; i < this.faces.length; ++i) {
                this.faces[i].flipFace();
            }
        }
        this.copyTo(arrpositionTextureVertex, arrtexturedPolygon, false);
    }

    public ModelRendererTurbo setTextureOffset(int n, int n2) {
        this.textureOffsetX = n;
        this.textureOffsetY = n2;
        return this;
    }

    public void setPosition(float f, float f2, float f3) {
        this.field_78800_c = f;
        this.field_78797_d = f2;
        this.field_78798_e = f3;
    }

    public void doMirror(boolean bl, boolean bl2, boolean bl3) {
        for (int i = 0; i < this.faces.length; ++i) {
            PositionTextureVertex[] arrpositionTextureVertex = this.faces[i].vertexPositions;
            for (int j = 0; j < arrpositionTextureVertex.length; ++j) {
                arrpositionTextureVertex[j].field_78243_a._c *= (double)(bl ? -1 : 1);
                arrpositionTextureVertex[j].field_78243_a._d *= (double)(bl2 ? -1 : 1);
                arrpositionTextureVertex[j].field_78243_a._e *= (double)(bl3 ? -1 : 1);
            }
            if (!(bl ^ bl2 ^ bl3)) continue;
            this.faces[i].flipFace();
        }
    }

    public void setMirrored(boolean bl) {
        this.field_78809_i = bl;
    }

    public void setFlipped(boolean bl) {
        this.flip = bl;
    }

    public void clear() {
        this.vertices = new PositionTextureVertex[0];
        this.faces = new TexturedPolygon[0];
        this.transformGroup.clear();
        this.transformGroup.put("0", new TransformGroupBone(new Bone(0.0f, 0.0f, 0.0f, 0.0f), 1.0));
        this.currentGroup = this.transformGroup.get("0");
    }

    public void copyTo(PositionTextureVertex[] arrpositionTextureVertex, TexturedPolygon[] arrtexturedPolygon) {
        this.copyTo(arrpositionTextureVertex, arrtexturedPolygon, true);
    }

    public void copyTo(PositionTextureVertex[] arrpositionTextureVertex, TexturedPolygon[] arrtexturedPolygon, boolean bl) {
        int n;
        this.vertices = Arrays.copyOf(this.vertices, this.vertices.length + arrpositionTextureVertex.length);
        this.faces = Arrays.copyOf(this.faces, this.faces.length + arrtexturedPolygon.length);
        for (n = 0; n < arrpositionTextureVertex.length; ++n) {
            this.vertices[this.vertices.length - arrpositionTextureVertex.length + n] = arrpositionTextureVertex[n];
            if (!bl || !(arrpositionTextureVertex[n] instanceof PositionTransformVertex)) continue;
            ((PositionTransformVertex)arrpositionTextureVertex[n]).addGroup(this.currentGroup);
        }
        for (n = 0; n < arrtexturedPolygon.length; ++n) {
            this.faces[this.faces.length - arrtexturedPolygon.length + n] = arrtexturedPolygon[n];
            if (!bl) continue;
            this.currentTextureGroup.addPoly(arrtexturedPolygon[n]);
        }
    }

    public void copyTo(PositionTextureVertex[] arrpositionTextureVertex, TexturedQuad[] arrtexturedQuad) {
        TexturedPolygon[] arrtexturedPolygon = new TexturedPolygon[arrtexturedQuad.length];
        for (int i = 0; i < arrtexturedQuad.length; ++i) {
            arrtexturedPolygon[i] = new TexturedPolygon((PositionTextureVertex[])arrtexturedQuad[i].field_78239_a);
        }
        this.copyTo(arrpositionTextureVertex, arrtexturedPolygon);
    }

    public void setGroup(String string) {
        this.setGroup(string, new Bone(0.0f, 0.0f, 0.0f, 0.0f), 1.0);
    }

    public void setGroup(String string, Bone bone, double d) {
        if (!this.transformGroup.containsKey(string)) {
            this.transformGroup.put(string, new TransformGroupBone(bone, d));
        }
        this.currentGroup = this.transformGroup.get(string);
    }

    public TransformGroup getGroup() {
        return this.currentGroup;
    }

    public TransformGroup getGroup(String string) {
        if (!this.transformGroup.containsKey(string)) {
            return null;
        }
        return this.transformGroup.get(string);
    }

    public void setTextureGroup(String string) {
        if (!this.textureGroup.containsKey(string)) {
            this.textureGroup.put(string, new TextureGroup());
        }
        this.currentTextureGroup = this.textureGroup.get(string);
    }

    public TextureGroup getTextureGroup() {
        return this.currentTextureGroup;
    }

    public TextureGroup getTextureGroup(String string) {
        if (!this.textureGroup.containsKey(string)) {
            return null;
        }
        return this.textureGroup.get(string);
    }

    public void setGroupTexture(String string) {
        this.currentTextureGroup.texture = string;
    }

    public void setDefaultTexture(String string) {
        this.defaultTexture = string;
    }

    public void func_78785_a(float f) {
        if (this.field_1402_i) {
            return;
        }
        if (!this.field_78806_j) {
            return;
        }
        if (!this.compiled || this.forcedRecompile) {
            this.compileDisplayList(f);
        }
        if (this.field_78795_f != 0.0f || this.field_78796_g != 0.0f || this.field_78808_h != 0.0f) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)(this.field_78800_c * f), (float)(this.field_78797_d * f), (float)(this.field_78798_e * f));
            if (this.field_78796_g != 0.0f) {
                GL11.glRotatef((float)(this.field_78796_g * 57.29578f), (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (this.field_78808_h != 0.0f) {
                GL11.glRotatef((float)(this.field_78808_h * 57.29578f), (float)0.0f, (float)0.0f, (float)1.0f);
            }
            if (this.field_78795_f != 0.0f) {
                GL11.glRotatef((float)(this.field_78795_f * 57.29578f), (float)1.0f, (float)0.0f, (float)0.0f);
            }
            this.callDisplayList();
            if (this.field_78805_m != null) {
                for (int i = 0; i < this.field_78805_m.size(); ++i) {
                    ((ModelRenderer)this.field_78805_m.get(i)).func_78785_a(f);
                }
            }
            GL11.glPopMatrix();
        } else if (this.field_78800_c != 0.0f || this.field_78797_d != 0.0f || this.field_78798_e != 0.0f) {
            GL11.glTranslatef((float)(this.field_78800_c * f), (float)(this.field_78797_d * f), (float)(this.field_78798_e * f));
            this.callDisplayList();
            if (this.field_78805_m != null) {
                for (int i = 0; i < this.field_78805_m.size(); ++i) {
                    ((ModelRenderer)this.field_78805_m.get(i)).func_78785_a(f);
                }
            }
            GL11.glTranslatef((float)(-this.field_78800_c * f), (float)(-this.field_78797_d * f), (float)(-this.field_78798_e * f));
        } else {
            this.callDisplayList();
            if (this.field_78805_m != null) {
                for (int i = 0; i < this.field_78805_m.size(); ++i) {
                    ((ModelRenderer)this.field_78805_m.get(i)).func_78785_a(f);
                }
            }
        }
    }

    public void renderNoDL(float f) {
        if (this.field_1402_i) {
            return;
        }
        if (!this.field_78806_j) {
            return;
        }
        if (this.field_78795_f != 0.0f || this.field_78796_g != 0.0f || this.field_78808_h != 0.0f) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)(this.field_78800_c * f), (float)(this.field_78797_d * f), (float)(this.field_78798_e * f));
            if (this.field_78796_g != 0.0f) {
                GL11.glRotatef((float)(this.field_78796_g * 57.29578f), (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (this.field_78808_h != 0.0f) {
                GL11.glRotatef((float)(this.field_78808_h * 57.29578f), (float)0.0f, (float)0.0f, (float)1.0f);
            }
            if (this.field_78795_f != 0.0f) {
                GL11.glRotatef((float)(this.field_78795_f * 57.29578f), (float)1.0f, (float)0.0f, (float)0.0f);
            }
            this.actuallyRenderNoDL(f);
            GL11.glPopMatrix();
        } else if (this.field_78800_c != 0.0f || this.field_78797_d != 0.0f || this.field_78798_e != 0.0f) {
            GL11.glTranslatef((float)(this.field_78800_c * f), (float)(this.field_78797_d * f), (float)(this.field_78798_e * f));
            this.actuallyRenderNoDL(f);
            GL11.glTranslatef((float)(-this.field_78800_c * f), (float)(-this.field_78797_d * f), (float)(-this.field_78798_e * f));
        } else {
            this.actuallyRenderNoDL(f);
        }
    }

    public void func_78791_b(float f) {
        if (this.field_1402_i) {
            return;
        }
        if (!this.field_78806_j) {
            return;
        }
        if (!this.compiled) {
            this.compileDisplayList(f);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(this.field_78800_c * f), (float)(this.field_78797_d * f), (float)(this.field_78798_e * f));
        if (this.field_78796_g != 0.0f) {
            GL11.glRotatef((float)(this.field_78796_g * 57.29578f), (float)0.0f, (float)1.0f, (float)0.0f);
        }
        if (this.field_78795_f != 0.0f) {
            GL11.glRotatef((float)(this.field_78795_f * 57.29578f), (float)1.0f, (float)0.0f, (float)0.0f);
        }
        if (this.field_78808_h != 0.0f) {
            GL11.glRotatef((float)(this.field_78808_h * 57.29578f), (float)0.0f, (float)0.0f, (float)1.0f);
        }
        this.callDisplayList();
        GL11.glPopMatrix();
    }

    public void func_78794_c(float f) {
        if (this.field_1402_i) {
            return;
        }
        if (!this.field_78806_j) {
            return;
        }
        if (!this.compiled || this.forcedRecompile) {
            this.compileDisplayList(f);
        }
        if (this.field_78795_f != 0.0f || this.field_78796_g != 0.0f || this.field_78808_h != 0.0f) {
            GL11.glTranslatef((float)(this.field_78800_c * f), (float)(this.field_78797_d * f), (float)(this.field_78798_e * f));
            if (this.field_78808_h != 0.0f) {
                GL11.glRotatef((float)(this.field_78808_h * 57.29578f), (float)0.0f, (float)0.0f, (float)1.0f);
            }
            if (this.field_78796_g != 0.0f) {
                GL11.glRotatef((float)(this.field_78796_g * 57.29578f), (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (this.field_78795_f != 0.0f) {
                GL11.glRotatef((float)(this.field_78795_f * 57.29578f), (float)1.0f, (float)0.0f, (float)0.0f);
            }
        } else if (this.field_78800_c != 0.0f || this.field_78797_d != 0.0f || this.field_78798_e != 0.0f) {
            GL11.glTranslatef((float)(this.field_78800_c * f), (float)(this.field_78797_d * f), (float)(this.field_78798_e * f));
        }
    }

    private void callDisplayList() {
        if (this.useLegacyCompiler) {
            GL11.glCallList((int)this.displayList);
        } else {
            zfwe zfwe2 = dfsc._b._g;
            Collection<TextureGroup> collection = this.textureGroup.values();
            Iterator<TextureGroup> iterator = collection.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                TextureGroup textureGroup = iterator.next();
                textureGroup.loadTexture();
                GL11.glCallList((int)this.displayListArray[n]);
                if (!this.defaultTexture.equals("")) {
                    zfwe2._a(new ResourceLocation("", this.defaultTexture));
                }
                ++n;
            }
        }
    }

    private void compileDisplayList(float f) {
        if (this.useLegacyCompiler) {
            this.compileLegacyDisplayList(f);
        } else {
            Collection<TextureGroup> collection = this.textureGroup.values();
            Iterator<TextureGroup> iterator = collection.iterator();
            this.displayListArray = new int[this.textureGroup.size()];
            int n = 0;
            while (iterator.hasNext()) {
                this.displayListArray[n] = zwqa._a((int)1);
                GL11.glNewList((int)this.displayListArray[n], (int)4864);
                TmtTessellator tmtTessellator = TmtTessellator.instance;
                TextureGroup textureGroup = iterator.next();
                for (int i = 0; i < textureGroup.poly.size(); ++i) {
                    textureGroup.poly.get(i).draw(tmtTessellator, f);
                }
                GL11.glEndList();
                ++n;
            }
        }
        this.compiled = true;
    }

    private void actuallyRenderNoDL(float f) {
        if (this.useLegacyCompiler) {
            TmtTessellator tmtTessellator = TmtTessellator.instance;
            for (int i = 0; i < this.faces.length; ++i) {
                this.faces[i].draw(tmtTessellator, f);
            }
        } else {
            Collection<TextureGroup> collection = this.textureGroup.values();
            Iterator<TextureGroup> iterator = collection.iterator();
            while (iterator.hasNext()) {
                TmtTessellator tmtTessellator = TmtTessellator.instance;
                TextureGroup textureGroup = iterator.next();
                for (int i = 0; i < textureGroup.poly.size(); ++i) {
                    textureGroup.poly.get(i).draw(tmtTessellator, f);
                }
            }
        }
    }

    private void compileLegacyDisplayList(float f) {
        this.displayList = zwqa._a((int)1);
        GL11.glNewList((int)this.displayList, (int)4864);
        TmtTessellator tmtTessellator = TmtTessellator.instance;
        for (int i = 0; i < this.faces.length; ++i) {
            this.faces[i].draw(tmtTessellator, f);
        }
        GL11.glEndList();
    }

    public /* synthetic */ ModelRenderer func_78789_a(float f, float f2, float f3, int n, int n2, int n3) {
        return this.addBox(f, f2, f3, n, n2, n3);
    }

    public /* synthetic */ ModelRenderer func_78784_a(int n, int n2) {
        return this.setTextureOffset(n, n2);
    }
}

