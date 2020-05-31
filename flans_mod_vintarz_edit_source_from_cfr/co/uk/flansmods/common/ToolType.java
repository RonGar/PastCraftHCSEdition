/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.GameRegistry
 *  cpw.mods.fml.common.uxsf
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ieta
 *  jhvs
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.TypeFile;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.uxsf;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.model.ModelBase;

public class ToolType
extends InfoType {
    public static ArrayList tools = new ArrayList();
    @SideOnly(value=Side.CLIENT)
    public ModelBase model;
    public boolean healPlayers = false;
    public boolean healDriveables = false;
    public int healAmount = 0;
    public int toolLife = 0;
    public boolean destroyOnEmpty = true;
    public ArrayList rechargeRecipe = new ArrayList();
    public int EUPerCharge = 0;
    public boolean parachute = false;
    public boolean remote = false;

    public ToolType(TypeFile typeFile) {
        super(typeFile);
        tools.add(this);
    }

    @Override
    protected void read(String[] arrstring, TypeFile typeFile) {
        super.read(arrstring, typeFile);
        try {
            if (uxsf.instance().getSide().isClient() && arrstring[0].equals("Model")) {
                this.model = FlansMod.proxy.loadModel(arrstring[1], this.shortName, ModelBase.class);
            }
            if (arrstring[0].equals("Texture")) {
                this.texture = arrstring[1];
            }
            if (arrstring[0].equals("Parachute")) {
                this.parachute = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("ExplosiveRemote")) {
                this.remote = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("Heal") || arrstring[0].equals("HealPlayers")) {
                this.healPlayers = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("Repair") || arrstring[0].equals("RepairVehicles")) {
                this.healDriveables = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("HealAmount") || arrstring[0].equals("RepairAmount")) {
                this.healAmount = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("ToolLife") || arrstring[0].equals("ToolUses")) {
                this.toolLife = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("EUPerCharge")) {
                this.EUPerCharge = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("RechargeRecipe")) {
                for (int i = 0; i < (arrstring.length - 1) / 2; ++i) {
                    int n = Integer.parseInt(arrstring[2 * i + 1]);
                    boolean bl = arrstring[2 * i + 2].contains(".");
                    String string = bl ? arrstring[2 * i + 2].split("\\.")[0] : arrstring[2 * i + 2];
                    int n2 = bl ? Integer.parseInt(arrstring[2 * i + 2].split("\\.")[1]) : 0;
                    this.rechargeRecipe.add(ToolType.getRecipeElement(string, n, n2));
                }
            }
            if (arrstring[0].equals("DestroyOnEmpty")) {
                this.destroyOnEmpty = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
        }
        catch (Exception exception) {
            FlansMod.log("Reading file failed : " + this.shortName);
            exception.printStackTrace();
        }
    }

    @Override
    public void addRecipe(jhvs jhvs2) {
        super.addRecipe(jhvs2);
        if (this.rechargeRecipe.size() >= 1) {
            this.rechargeRecipe.add(new ieta(jhvs2, 1, this.toolLife));
            GameRegistry.addShapelessRecipe((ieta)new ieta(jhvs2, 1, 0), (Object[])this.rechargeRecipe.toArray());
        }
    }

    public static ToolType getType(String string) {
        ToolType toolType;
        Iterator iterator = tools.iterator();
        do {
            if (!iterator.hasNext()) {
                return null;
            }
            toolType = (ToolType)iterator.next();
        } while (!toolType.shortName.equals(string));
        return toolType;
    }
}

