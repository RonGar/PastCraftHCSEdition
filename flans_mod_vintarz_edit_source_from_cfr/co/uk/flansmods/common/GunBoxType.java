/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ccfp
 *  cpw.mods.fml.common.registry.GameRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ieta
 *  jhvs
 *  kjsv
 *  net.minecraft.util.roij
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.BlockGunBox;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.TypeFile;
import co.uk.flansmods.common.guns.BulletType;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.roij;

public class GunBoxType
extends InfoType {
    public int blockID;
    public ccfp material = ccfp._f;
    public String topTexturePath;
    public String sideTexturePath;
    public String bottomTexturePath;
    @SideOnly(value=Side.CLIENT)
    public roij top;
    @SideOnly(value=Side.CLIENT)
    public roij side;
    @SideOnly(value=Side.CLIENT)
    public roij bottom;
    public int gunBoxID;
    public int numGuns;
    public int nextGun = -1;
    public InfoType[] guns;
    public BulletType[] bullets;
    public BulletType[] altBullets;
    public List[] gunParts;
    public List[] bulletParts;
    public List[] altBulletParts;
    private static int lastIconIndex = 2;
    public static HashMap gunBoxMap = new HashMap();
    public static ArrayList shortNameList = new ArrayList();
    public static int nextDefaultID;

    public GunBoxType(TypeFile typeFile) {
        super(typeFile);
        for (String string : typeFile.lines) {
            String[] arrstring;
            if (string == null) break;
            if (string.startsWith("//") || (arrstring = string.split(" ")).length < 2 || !arrstring[0].equals("NumGuns")) continue;
            this.numGuns = Integer.parseInt(arrstring[1]);
            this.guns = new InfoType[this.numGuns];
            this.bullets = new BulletType[this.numGuns];
            this.altBullets = new BulletType[this.numGuns];
            this.gunParts = new List[this.numGuns];
            this.bulletParts = new List[this.numGuns];
            this.altBulletParts = new List[this.numGuns];
            for (int i = 0; i < this.numGuns; ++i) {
                this.gunParts[i] = new ArrayList();
                this.bulletParts[i] = new ArrayList();
                this.altBulletParts[i] = new ArrayList();
            }
        }
    }

    @Override
    protected void read(TypeFile typeFile) {
        super.read(typeFile);
        if (this.gunBoxID == 0) {
            this.gunBoxID = nextDefaultID++;
        }
        gunBoxMap.put(this.shortName, this);
        shortNameList.add(this.shortName);
    }

    @Override
    protected void read(String[] arrstring, TypeFile typeFile) {
        super.read(arrstring, typeFile);
        try {
            int n;
            if (arrstring[0].equals("Material")) {
                this.material = GunBoxType.getMaterial(arrstring[1]);
            }
            if (arrstring[0].equals("TopTexture")) {
                this.topTexturePath = arrstring[1];
            }
            if (arrstring[0].equals("BottomTexture")) {
                this.bottomTexturePath = arrstring[1];
            }
            if (arrstring[0].equals("SideTexture")) {
                this.sideTexturePath = arrstring[1];
            }
            if (arrstring[0].equals("GunBoxID") || arrstring[0].equals("BlockID")) {
                this.gunBoxID = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("AddGun")) {
                ++this.nextGun;
                if (this.gunParts[this.nextGun] == null) {
                    FlansMod.log("NumGuns was not found or was incorrect");
                }
                this.guns[this.nextGun] = InfoType.getType(arrstring[1]);
                for (n = 0; n < (arrstring.length - 2) / 2; ++n) {
                    if (arrstring[n * 2 + 3].contains(".")) {
                        this.gunParts[this.nextGun].add(GunBoxType.getRecipeElement(arrstring[n * 2 + 3].split("\\.")[0], Integer.parseInt(arrstring[n * 2 + 2]), Integer.valueOf(arrstring[n * 2 + 3].split("\\.")[1])));
                        continue;
                    }
                    this.gunParts[this.nextGun].add(GunBoxType.getRecipeElement(arrstring[n * 2 + 3], Integer.parseInt(arrstring[n * 2 + 2]), 0));
                }
            }
            if (arrstring[0].equals("AddAmmo")) {
                if (this.bulletParts[this.nextGun] == null) {
                    FlansMod.log("NumGuns was not found or was incorrect");
                }
                this.bullets[this.nextGun] = BulletType.getBullet(arrstring[1]);
                for (n = 0; n < (arrstring.length - 2) / 2; ++n) {
                    if (arrstring[n * 2 + 3].contains(".")) {
                        this.bulletParts[this.nextGun].add(GunBoxType.getRecipeElement(arrstring[n * 2 + 3].split("\\.")[0], Integer.parseInt(arrstring[n * 2 + 2]), Integer.valueOf(arrstring[n * 2 + 3].split("\\.")[1])));
                        continue;
                    }
                    this.bulletParts[this.nextGun].add(GunBoxType.getRecipeElement(arrstring[n * 2 + 3], Integer.parseInt(arrstring[n * 2 + 2]), 0));
                }
            }
            if (arrstring[0].equals("AddAltAmmo") || arrstring[0].equals("AddAlternateAmmo")) {
                if (this.altBulletParts[this.nextGun] == null) {
                    FlansMod.log("NumGuns was not found or was incorrect");
                }
                this.altBullets[this.nextGun] = BulletType.getBullet(arrstring[1]);
                for (n = 0; n < (arrstring.length - 2) / 2; ++n) {
                    if (arrstring[n * 2 + 3].contains(".")) {
                        this.altBulletParts[this.nextGun].add(GunBoxType.getRecipeElement(arrstring[n * 2 + 3].split("\\.")[0], Integer.parseInt(arrstring[n * 2 + 2]), Integer.valueOf(arrstring[n * 2 + 3].split("\\.")[1])));
                        continue;
                    }
                    this.altBulletParts[this.nextGun].add(GunBoxType.getRecipeElement(arrstring[n * 2 + 3], Integer.parseInt(arrstring[n * 2 + 2]), 0));
                }
            }
        }
        catch (Exception exception) {
            System.out.println("Reading gun box file failed : " + this.shortName);
            exception.printStackTrace();
        }
    }

    public static GunBoxType getBox(String string) {
        return (GunBoxType)gunBoxMap.get(string);
    }

    public static GunBoxType getBox(int n) {
        GunBoxType gunBoxType;
        Iterator iterator = gunBoxMap.values().iterator();
        do {
            if (!iterator.hasNext()) {
                return null;
            }
            gunBoxType = (GunBoxType)iterator.next();
        } while (gunBoxType.gunBoxID != n);
        return gunBoxType;
    }

    public static ccfp getMaterial(String string) {
        return string.equals("wood") ? ccfp._d : (!string.equals("rock") && !string.equals("stone") ? (string.equals("iron") ? ccfp._f : (string.equals("cloth") ? ccfp._n : ccfp._f)) : ccfp._e);
    }

    public static ieta getRecipeElement(String string, int n, int n2) {
        ieta ieta2 = GunBoxType.getRecipeElement(string, n2);
        if (ieta2 == null) {
            return ieta2;
        }
        ieta2._b = n;
        return ieta2;
    }

    @Override
    public void addRecipe(jhvs jhvs2) {
        if (this.smeltableFrom != null) {
            GameRegistry.addSmelting((int)GunBoxType.getRecipeElement((String)this.smeltableFrom, (int)0)._d, (ieta)new ieta(this.item), (float)0.0f);
        }
        if (this.recipeLine != null) {
            try {
                if (!this.shapeless) {
                    Object[] arrobject;
                    int n;
                    int n2;
                    Object[] arrobject2;
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
                        arrobject = new Object[this.recipe.length - 1];
                        arrobject[0] = this.recipe[1];
                        arrobject[1] = this.recipe[2];
                        this.recipe = arrobject;
                        --n3;
                        if (this.recipe[0].equals(" ") || this.recipe[0].equals("  ") || this.recipe[0].equals("   ")) {
                            arrobject2 = new Object[this.recipe.length - 1];
                            arrobject2[0] = this.recipe[1];
                            this.recipe = arrobject2;
                            --n3;
                        }
                    }
                    if (this.recipe[n3 - 1].equals(" ") || this.recipe[n3 - 1].equals("  ") || this.recipe[n3 - 1].equals("   ")) {
                        arrobject = new Object[this.recipe.length - 1];
                        arrobject[0] = this.recipe[0];
                        arrobject[1] = this.recipe[1];
                        this.recipe = arrobject;
                        if (this.recipe[--n3 - 1].equals(" ") || this.recipe[n3 - 1].equals("  ") || this.recipe[n3 - 1].equals("   ")) {
                            arrobject2 = new Object[this.recipe.length - 1];
                            arrobject2[0] = this.recipe[0];
                            this.recipe = arrobject2;
                            --n3;
                        }
                    }
                    for (n = 0; n < (this.recipeLine.length - 1) / 2; ++n) {
                        this.recipe[n * 2 + n3] = Character.valueOf(this.recipeLine[n * 2 + 1].charAt(0));
                        this.recipe[n * 2 + n3 + 1] = this.recipeLine[n * 2 + 2].contains(".") ? GunBoxType.getRecipeElement(this.recipeLine[n * 2 + 2].split("\\.")[0], Integer.valueOf(this.recipeLine[n * 2 + 2].split("\\.")[1])) : GunBoxType.getRecipeElement(this.recipeLine[n * 2 + 2], 0);
                    }
                    if (FlansMod.gunBoxBlock != null) {
                        GameRegistry.addRecipe((ieta)new ieta((kjsv)FlansMod.gunBoxBlock, this.recipeOutput, this.gunBoxID), (Object[])this.recipe);
                    }
                } else {
                    this.recipe = new Object[this.recipeLine.length - 1];
                    for (int i = 0; i < this.recipeLine.length - 1; ++i) {
                        this.recipe[i] = this.recipeLine[i + 1].contains(".") ? GunBoxType.getRecipeElement(this.recipeLine[i + 1].split("\\.")[0], Integer.valueOf(this.recipeLine[i + 1].split("\\.")[1])) : GunBoxType.getRecipeElement(this.recipeLine[i + 1], 0);
                    }
                    GameRegistry.addShapelessRecipe((ieta)new ieta((kjsv)FlansMod.gunBoxBlock, this.recipeOutput, this.gunBoxID), (Object[])this.recipe);
                }
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add recipe for : " + this.shortName);
                exception.printStackTrace();
            }
        }
    }
}

