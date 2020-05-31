/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.client.tmt;

import co.uk.flansmods.client.tmt.ModelPoolEntry;
import co.uk.flansmods.client.tmt.PositionTextureVertex;
import co.uk.flansmods.client.tmt.PositionTransformVertex;
import co.uk.flansmods.client.tmt.TextureGroup;
import co.uk.flansmods.client.tmt.TexturedPolygon;
import co.uk.flansmods.client.tmt.TransformGroup;
import co.uk.flansmods.client.tmt.TransformGroupBone;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import net.minecraft.util.dwbg;
import net.minecraft.util.samw;

public class ModelPoolObjEntry
extends ModelPoolEntry {
    public ModelPoolObjEntry() {
        this.fileExtensions = new String[]{"obj"};
    }

    @Override
    public void getModel(File file) {
        try {
            int n;
            String string;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            ArrayList<PositionTransformVertex> arrayList = new ArrayList<PositionTransformVertex>();
            ArrayList<float[]> arrayList2 = new ArrayList<float[]>();
            ArrayList<float[]> arrayList3 = new ArrayList<float[]>();
            ArrayList<Object> arrayList4 = new ArrayList<Object>();
            while ((string = bufferedReader.readLine()) != null) {
                Object object;
                Object object2;
                int n2;
                Object[] arrobject;
                if (string.indexOf("#") > -1) {
                    string = string.substring(0, string.indexOf("#"));
                }
                if ((string = string.trim()).equals("")) continue;
                if (string.startsWith("g ")) {
                    this.setTextureGroup(string.substring(string.indexOf(" ") + 1).trim());
                    continue;
                }
                if (string.startsWith("v ")) {
                    string = string.substring(string.indexOf(" ") + 1).trim();
                    object2 = new float[3];
                    for (int i = 0; i < 3; ++i) {
                        n2 = string.indexOf(" ");
                        object2[i] = n2 > -1 ? Float.parseFloat(string.substring(0, n2)) : Float.parseFloat(string.substring(0));
                        string = string.substring(string.indexOf(" ") + 1).trim();
                    }
                    float f = object2[2];
                    object2[2] = -object2[1];
                    object2[1] = f;
                    arrayList.add(new PositionTransformVertex(object2[0], object2[1], object2[2], 0.0f, 0.0f));
                    continue;
                }
                if (string.startsWith("vt ")) {
                    string = string.substring(string.indexOf(" ") + 1).trim();
                    object2 = new float[2];
                    for (int i = 0; i < 2; ++i) {
                        n2 = string.indexOf(" ");
                        object2[i] = n2 > -1 ? Float.parseFloat(string.substring(0, n2)) : Float.parseFloat(string.substring(0));
                        string = string.substring(string.indexOf(" ") + 1).trim();
                    }
                    arrayList2.add(new float[]{object2[0], 1.0f - object2[1]});
                    continue;
                }
                if (string.startsWith("vn ")) {
                    string = string.substring(string.indexOf(" ") + 1).trim();
                    object2 = new float[3];
                    for (int i = 0; i < 3; ++i) {
                        n2 = string.indexOf(" ");
                        object2[i] = n2 > -1 ? Float.parseFloat(string.substring(0, n2)) : Float.parseFloat(string.substring(0));
                        string = string.substring(string.indexOf(" ") + 1).trim();
                    }
                    float f = object2[2];
                    object2[2] = object2[1];
                    object2[1] = f;
                    arrayList3.add(new float[]{object2[0], object2[1], object2[2]});
                    continue;
                }
                if (!string.startsWith("f ")) continue;
                string = string.substring(string.indexOf(" ") + 1).trim();
                object2 = new ArrayList();
                n2 = 0;
                float[] arrf = new float[]{0.0f, 0.0f, 0.0f};
                ArrayList<samw> arrayList5 = new ArrayList<samw>();
                do {
                    int n3;
                    int n4 = string.indexOf(" ");
                    String string2 = string;
                    if (n4 > -1) {
                        string2 = string.substring(0, n4);
                    }
                    if (string2.indexOf("/") > -1) {
                        int n5;
                        String[] arrstring = string2.split("/");
                        n3 = Integer.parseInt(arrstring[0]) - 1;
                        if (arrstring[1].equals("")) {
                            arrstring[1] = arrstring[0];
                        }
                        int n6 = Integer.parseInt(arrstring[1]) - 1;
                        arrobject = arrayList2.size() > n6 ? (float[])arrayList2.get(n6) : new float[]{0.0f, 0.0f};
                        if (arrstring.length == 3) {
                            if (arrstring[2].equals("")) {
                                arrstring[2] = arrstring[0];
                            }
                            n5 = Integer.parseInt(arrstring[2]) - 1;
                        } else {
                            n5 = Integer.parseInt(arrstring[0]) - 1;
                        }
                        object = arrayList3.size() > n5 ? (float[])arrayList3.get(n5) : new float[]{0.0f, 0.0f, 0.0f};
                    } else {
                        n3 = Integer.parseInt(string2) - 1;
                        arrobject = arrayList2.size() > n3 ? (float[])arrayList2.get(n3) : new float[]{0.0f, 0.0f};
                        object = arrayList3.size() > n3 ? (float[])arrayList3.get(n3) : new float[]{0.0f, 0.0f, 0.0f};
                    }
                    arrayList5.add(samw._a((double)object[0], (double)object[1], (double)object[2]));
                    float[] arrf2 = arrf;
                    arrf2[0] = arrf2[0] + object[0];
                    float[] arrf3 = arrf;
                    arrf3[1] = arrf3[1] + object[1];
                    float[] arrf4 = arrf;
                    arrf4[2] = arrf4[2] + object[2];
                    if (n3 < arrayList.size()) {
                        ((ArrayList)object2).add(((PositionTransformVertex)((Object)arrayList.get(n3))).setTexturePosition(arrobject[0], arrobject[1]));
                        if (arrayList.get(n3) instanceof PositionTransformVertex) {
                            ((PositionTransformVertex)((Object)arrayList.get(n3))).addGroup(this.group);
                        }
                    }
                    if (n4 > -1) {
                        string = string.substring(string.indexOf(" ") + 1).trim();
                        continue;
                    }
                    ++n2;
                } while (n2 < 1);
                float f = dwbg._a((double)(arrf[0] * arrf[0] + arrf[1] * arrf[1] + arrf[2] * arrf[2]));
                float[] arrf5 = arrf;
                arrf5[0] = arrf5[0] / f;
                float[] arrf6 = arrf;
                arrf6[1] = arrf6[1] / f;
                float[] arrf7 = arrf;
                arrf7[2] = arrf7[2] / f;
                arrobject = new PositionTextureVertex[((ArrayList)object2).size()];
                for (int i = 0; i < ((ArrayList)object2).size(); ++i) {
                    arrobject[i] = (float)((PositionTextureVertex)((Object)((ArrayList)object2).get(i)));
                }
                object = new TexturedPolygon((PositionTextureVertex[])arrobject);
                ((TexturedPolygon)object).setNormals(arrf[0], arrf[1], arrf[2]);
                ((TexturedPolygon)object).setNormals(arrayList5);
                arrayList4.add(object);
                this.texture.addPoly((TexturedPolygon)object);
            }
            this.vertices = new PositionTransformVertex[arrayList.size()];
            for (n = 0; n < arrayList.size(); ++n) {
                this.vertices[n] = (PositionTransformVertex)((Object)arrayList.get(n));
            }
            this.faces = new TexturedPolygon[arrayList4.size()];
            for (n = 0; n < arrayList4.size(); ++n) {
                this.faces[n] = (TexturedPolygon)arrayList4.get(n);
            }
            bufferedReader.close();
        }
        catch (Throwable throwable) {}
    }
}

