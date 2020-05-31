/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.client.tmt;

import co.uk.flansmods.client.tmt.Bone;
import co.uk.flansmods.client.tmt.PositionTransformVertex;
import co.uk.flansmods.client.tmt.TextureGroup;
import co.uk.flansmods.client.tmt.TexturedPolygon;
import co.uk.flansmods.client.tmt.TransformGroup;
import co.uk.flansmods.client.tmt.TransformGroupBone;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class ModelPoolEntry {
    public String name;
    public PositionTransformVertex[] vertices;
    public TexturedPolygon[] faces;
    public Map<String, TransformGroupBone> groups;
    public Map<String, TextureGroup> textures;
    protected TransformGroupBone group;
    protected TextureGroup texture;
    protected String[] fileExtensions;

    public File checkValidPath(String string) {
        File file = null;
        for (int i = 0; !(i >= this.fileExtensions.length || file != null && file.exists()); ++i) {
            String string2 = string;
            if (!string.endsWith("." + this.fileExtensions[i])) {
                string2 = string2 + "." + this.fileExtensions[i];
            }
            file = new File(string2);
        }
        if (file == null || !file.exists()) {
            return null;
        }
        return file;
    }

    public abstract void getModel(File var1);

    protected void setGroup(String string) {
        this.setGroup(string, new Bone(0.0f, 0.0f, 0.0f, 0.0f), 1.0);
    }

    protected void setGroup(String string, Bone bone, double d) {
        if (this.groups.size() == 0 || !this.groups.containsKey(string)) {
            this.groups.put(string, new TransformGroupBone(bone, d));
        }
        this.group = this.groups.get(string);
    }

    protected void setTextureGroup(String string) {
        if (this.textures.size() == 0 || !this.textures.containsKey(string)) {
            this.textures.put(string, new TextureGroup());
        }
        this.texture = this.textures.get(string);
    }

    protected void applyGroups(Map<String, TransformGroup> map, Map<String, TextureGroup> map2) {
        int n;
        String string;
        String string2;
        Set<String> set = this.groups.keySet();
        Set<String> set2 = this.textures.keySet();
        Iterator<String> iterator = set.iterator();
        Iterator<E> iterator2 = set2.iterator();
        while (iterator.hasNext()) {
            n = 0;
            string2 = iterator.next();
            string = this.name + "_" + 0 + ":" + string2;
            while (map.size() > 0 && map.containsKey(string)) {
                string = this.name + "_" + ++n + ":" + string2;
            }
            map.put(string, this.groups.get(string2));
        }
        while (iterator2.hasNext()) {
            n = 0;
            string2 = (String)iterator2.next();
            string = this.name + "_" + 0 + ":" + string2;
            while (map.size() > 0 && map2.containsKey(string)) {
                string = this.name + "_" + ++n + ":" + string2;
            }
            map2.put(string, this.textures.get(string2));
        }
    }
}

