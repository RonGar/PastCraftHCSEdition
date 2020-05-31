/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.GameRegistry
 *  ieta
 *  jhvs
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.TypeFile;
import cpw.mods.fml.common.registry.GameRegistry;
import java.util.ArrayList;
import java.util.List;

public class InfoType {
    public static List<InfoType> infoTypes = new ArrayList<InfoType>();
    public String contentPack;
    public jhvs item;
    public int colour = 16777215;
    public int itemID;
    public String iconPath;
    public Object[] recipe;
    public String[] recipeLine;
    public int recipeOutput = 1;
    public boolean shapeless;
    public String smeltableFrom = null;
    public String name;
    public String shortName;
    public String texture;
    public String modelString;
    public String description;
    public float modelScale = 1.0f;

    public InfoType(TypeFile typeFile) {
        this.contentPack = typeFile.name;
        infoTypes.add(this);
    }

    protected void read(TypeFile typeFile) {
        String string;
        while ((string = typeFile.readLine()) != null) {
            String[] arrstring;
            if (string.startsWith("//") || (arrstring = string.split(" ")).length < 2) continue;
            this.read(arrstring, typeFile);
        }
    }

    protected void read(String[] arrstring, TypeFile typeFile) {
        try {
            int n;
            if (arrstring[0].toLowerCase().equals("model")) {
                this.modelString = arrstring[1];
            }
            if (arrstring[0].toLowerCase().equals("modelscale")) {
                this.modelScale = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Name")) {
                this.name = arrstring[1];
                for (n = 0; n < arrstring.length - 2; ++n) {
                    this.name = this.name + " " + arrstring[n + 2];
                }
            }
            if (arrstring[0].equals("Description")) {
                this.description = arrstring[1];
                for (n = 0; n < arrstring.length - 2; ++n) {
                    this.description = this.description + " " + arrstring[n + 2];
                }
            }
            if (arrstring[0].equals("ShortName")) {
                this.shortName = arrstring[1];
            }
            if (arrstring[0].equals("Colour") || arrstring[0].equals("Color")) {
                this.colour = (Integer.parseInt(arrstring[1]) << 16) + (Integer.parseInt(arrstring[2]) << 8) + Integer.parseInt(arrstring[3]);
            }
            if (arrstring[0].equals("ItemID")) {
                this.itemID = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("Icon")) {
                this.iconPath = arrstring[1];
            }
            if (arrstring[0].equals("RecipeOutput")) {
                this.recipeOutput = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("Recipe")) {
                this.recipe = new Object[arrstring.length + 2];
                for (n = 0; n < 3; ++n) {
                    String string = typeFile.readLine();
                    if (string == null) continue;
                    if (string == null || string.startsWith("//")) {
                        --n;
                        continue;
                    }
                    this.recipe[n] = string;
                }
                this.recipeLine = arrstring;
                this.shapeless = false;
            }
            if (arrstring[0].equals("ShapelessRecipe")) {
                this.recipeLine = arrstring;
                this.shapeless = true;
            }
            if (arrstring[0].equals("SmeltableFrom")) {
                this.smeltableFrom = arrstring[1];
            }
        }
        catch (Exception exception) {
            FlansMod.log("Reading file failed : " + this.shortName);
            exception.printStackTrace();
        }
    }

    public void addRecipe() {
        this.addRecipe(this.getItem());
    }

    public void addRecipe(jhvs jhvs2) {
        if (this.smeltableFrom != null) {
            GameRegistry.addSmelting((int)InfoType.getRecipeElement((String)this.smeltableFrom, (int)0)._d, (ieta)new ieta(this.item), (float)0.0f);
        }
        if (this.recipeLine == null) {
            return;
        }
        try {
            if (!this.shapeless) {
                int n;
                int n2;
                Object[] arrobject;
                int n3 = 3;
                if (((String)this.recipe[0]).charAt(0) == ' ' && ((String)this.recipe[1]).charAt(0) == ' ' && ((String)this.recipe[2]).charAt(0) == ' ') {
                    for (n2 = 0; n2 < 3; ++n2) {
                        this.recipe[n2] = ((String)this.recipe[n2]).substring(1);
                    }
                    if (((String)this.recipe[0]).charAt(0) == ' ' && ((String)this.recipe[1]).charAt(0) == ' ' && ((String)this.recipe[2]).charAt(0) == ' ') {
                        for (n2 = 0; n2 < 3; ++n2) {
                            this.recipe[n2] = ((String)this.recipe[n2]).substring(1);
                        }
                    }
                }
                if (((String)this.recipe[0]).charAt(n2 = ((String)this.recipe[0]).length() - 1) == ' ' && ((String)this.recipe[1]).charAt(n2) == ' ' && ((String)this.recipe[2]).charAt(n2) == ' ') {
                    for (n = 0; n < 3; ++n) {
                        this.recipe[n] = ((String)this.recipe[n]).substring(0, n2);
                    }
                    if (((String)this.recipe[0]).charAt(--n2) == ' ' && ((String)this.recipe[1]).charAt(n2) == ' ' && ((String)this.recipe[2]).charAt(n2) == ' ') {
                        for (n = 0; n < 3; ++n) {
                            this.recipe[n] = ((String)this.recipe[n]).substring(0, 0);
                        }
                    }
                }
                if (this.recipe[0].equals(" ") || this.recipe[0].equals("  ") || this.recipe[0].equals("   ")) {
                    Object[] arrobject2 = new Object[this.recipe.length - 1];
                    arrobject2[0] = this.recipe[1];
                    arrobject2[1] = this.recipe[2];
                    this.recipe = arrobject2;
                    --n3;
                    if (this.recipe[0].equals(" ") || this.recipe[0].equals("  ") || this.recipe[0].equals("   ")) {
                        arrobject = new Object[this.recipe.length - 1];
                        arrobject[0] = this.recipe[1];
                        this.recipe = arrobject;
                        --n3;
                    }
                }
                if (this.recipe[n3 - 1].equals(" ") || this.recipe[n3 - 1].equals("  ") || this.recipe[n3 - 1].equals("   ")) {
                    Object[] arrobject3 = new Object[this.recipe.length - 1];
                    arrobject3[0] = this.recipe[0];
                    arrobject3[1] = this.recipe[1];
                    this.recipe = arrobject3;
                    if (this.recipe[--n3 - 1].equals(" ") || this.recipe[n3 - 1].equals("  ") || this.recipe[n3 - 1].equals("   ")) {
                        arrobject = new Object[this.recipe.length - 1];
                        arrobject[0] = this.recipe[0];
                        this.recipe = arrobject;
                        --n3;
                    }
                }
                for (n = 0; n < (this.recipeLine.length - 1) / 2; ++n) {
                    this.recipe[n * 2 + n3] = Character.valueOf(this.recipeLine[n * 2 + 1].charAt(0));
                    this.recipe[n * 2 + n3 + 1] = this.recipeLine[n * 2 + 2].contains(".") ? InfoType.getRecipeElement(this.recipeLine[n * 2 + 2].split("\\.")[0], Integer.valueOf(this.recipeLine[n * 2 + 2].split("\\.")[1])) : InfoType.getRecipeElement(this.recipeLine[n * 2 + 2], 0);
                }
                GameRegistry.addRecipe((ieta)new ieta(this.item, this.recipeOutput), (Object[])this.recipe);
            } else {
                this.recipe = new Object[this.recipeLine.length - 1];
                for (int i = 0; i < this.recipeLine.length - 1; ++i) {
                    this.recipe[i] = this.recipeLine[i + 1].contains(".") ? InfoType.getRecipeElement(this.recipeLine[i + 1].split("\\.")[0], Integer.valueOf(this.recipeLine[i + 1].split("\\.")[1])) : InfoType.getRecipeElement(this.recipeLine[i + 1], 0);
                }
                GameRegistry.addShapelessRecipe((ieta)new ieta(this.item, this.recipeOutput), (Object[])this.recipe);
            }
        }
        catch (Exception exception) {
            FlansMod.log("Failed to add recipe for : " + this.shortName);
            exception.printStackTrace();
        }
    }

    public jhvs getItem() {
        return this.item;
    }

    public static ieta getRecipeElement(String string, int n) {
        return InfoType.getRecipeElement(string, 1, n);
    }

    public static ieta getRecipeElement(String string, int n, int n2) {
        if (string.equals("doorIron")) {
            return new ieta(jhvs.field_77766_aB, n);
        }
        if (string.equals("doorWood")) {
            return new ieta(jhvs.field_77790_av, n);
        }
        if (string.equals("clayItem")) {
            return new ieta(jhvs.field_77757_aI, n);
        }
        for (int i = jhvs.field_77698_e.length - 1; i >= 0; --i) {
            jhvs object = jhvs.field_77698_e[i];
            if (object == null || object.func_77658_a() == null || !object.func_77658_a().equals("item." + string) && !object.func_77658_a().equals("tile." + string)) continue;
            return new ieta(object, n, n2);
        }
        for (InfoType infoType : infoTypes) {
            if (!infoType.shortName.equals(string)) continue;
            return new ieta(infoType.item, n, n2);
        }
        if (string.equals("gunpowder")) {
            return new ieta(jhvs.field_77677_M, n);
        }
        if (string.equals("iron")) {
            return new ieta(jhvs.field_77703_o, n);
        }
        FlansMod.log("Could not find " + string + " when adding recipe");
        return null;
    }

    public void reloadModel() {
    }

    public static InfoType getType(String string) {
        for (InfoType infoType : infoTypes) {
            if (!infoType.shortName.equals(string)) continue;
            return infoType;
        }
        return null;
    }
}

