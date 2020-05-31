/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.Loader
 */
package co.uk.flansmods.client.tmt;

import co.uk.flansmods.client.tmt.ModelPoolEntry;
import co.uk.flansmods.client.tmt.ModelPoolObjEntry;
import co.uk.flansmods.client.tmt.TextureGroup;
import co.uk.flansmods.client.tmt.TransformGroup;
import co.uk.flansmods.client.tmt.TransformGroupBone;
import cpw.mods.fml.common.Loader;
import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class ModelPool {
    private static Map<String, ModelPoolEntry> modelMap = new HashMap<String, ModelPoolEntry>();
    private static String[] resourceDir = new String[]{"/resources/models/", "/resources/mod/models/"};
    public static final Class OBJ = ModelPoolObjEntry.class;

    public static ModelPoolEntry addFile(String string, Class class_, Map<String, TransformGroup> map, Map<String, TextureGroup> map2) {
        ModelPoolEntry modelPoolEntry;
        if (modelMap.containsKey(string)) {
            ModelPoolEntry modelPoolEntry2 = modelMap.get(string);
            modelPoolEntry2.applyGroups(map, map2);
            return modelPoolEntry2;
        }
        try {
            modelPoolEntry = (ModelPoolEntry)class_.newInstance();
        }
        catch (Exception exception) {
            System.out.println("A new " + ((Object)null).getClass().getName() + " could not be initialized.");
            System.out.println(exception.getMessage());
            return null;
        }
        File file = null;
        for (int i = 0; !(i >= resourceDir.length || file != null && file.exists()); ++i) {
            String string2 = new File(Loader.instance().getConfigDir().getParent(), resourceDir[i]).getAbsolutePath();
            if (!string2.endsWith("/") || !string2.endsWith("\\")) {
                string2 = string2 + "/";
            }
            file = modelPoolEntry.checkValidPath(string2 + string);
        }
        if (file == null || !file.exists()) {
            System.out.println("The model with the name " + string + " does not exist.");
            return null;
        }
        modelPoolEntry.groups = new HashMap<String, TransformGroupBone>();
        modelPoolEntry.textures = new HashMap<String, TextureGroup>();
        modelPoolEntry.name = string;
        modelPoolEntry.setGroup("0");
        modelPoolEntry.setTextureGroup("0");
        modelPoolEntry.getModel(file);
        modelPoolEntry.applyGroups(map, map2);
        modelMap.put(string, modelPoolEntry);
        return modelPoolEntry;
    }
}

