/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ieta
 *  jhvo
 *  jhvs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.pico
 *  net.minecraft.util.roij
 *  net.minecraftforge.common.owbd
 *  net.minecraftforge.common.owbd$uxsf
 *  qlze
 *  qmjs
 *  tekj
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.teams.ArmourType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.pico;
import net.minecraft.util.roij;
import net.minecraftforge.common.owbd;

public class ItemTeamArmour
extends qmjs
implements owbd {
    public ArmourType type;

    public ItemTeamArmour(ArmourType armourType) {
        super(armourType.itemID - 256, jhvo._a, 0, armourType.type);
        this.type = armourType;
        this.func_77637_a((tekj)FlansMod.tabFlanTeams);
    }

    public ItemTeamArmour(int n, jhvo jhvo2, int n2, int n3) {
        super(n, jhvo2, n2, n3);
    }

    public owbd.uxsf getProperties(EntityLivingBase entityLivingBase, ieta ieta2, pico pico2, double d, int n) {
        return new owbd.uxsf(1, this.type.defence, Integer.MAX_VALUE);
    }

    public int getArmorDisplay(EntityPlayer entityPlayer, ieta ieta2, int n) {
        return (int)(this.type.defence * 20.0);
    }

    public void damageArmor(EntityLivingBase entityLivingBase, ieta ieta2, pico pico2, int n, int n2) {
    }

    public String getArmorTexture(ieta ieta2, Entity entity, int n, int n2) {
        return "flansmod:armor/" + this.type.armourTextureName + "_" + (this.type.type == 2 ? "2" : "1") + ".png";
    }

    public void func_77624_a(ieta ieta2, EntityPlayer entityPlayer, List list, boolean bl) {
        if (this.type.description != null) {
            for (String string : this.type.description.split("_")) {
                list.add(string);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public int func_82790_a(ieta ieta2, int n) {
        return this.type.colour;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_77623_v() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(qlze qlze2) {
        this.field_77791_bV = qlze2._a("FlansMod:" + this.type.iconPath);
    }
}

