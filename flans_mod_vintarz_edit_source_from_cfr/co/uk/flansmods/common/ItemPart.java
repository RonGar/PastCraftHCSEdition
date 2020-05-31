/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ieta
 *  jhvs
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.roij
 *  qlze
 *  tekj
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.PartType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.roij;

public class ItemPart
extends jhvs {
    public PartType type;

    public ItemPart(int n, PartType partType) {
        super(n);
        this.type = partType;
        this.func_77625_d(this.type.stackSize);
        if (this.type.category == 9) {
            this.func_77656_e(this.type.fuel);
            this.func_77627_a(true);
        }
        this.type.item = this;
        this.func_77637_a((tekj)FlansMod.tabFlanParts);
    }

    public void func_77624_a(ieta ieta2, EntityPlayer entityPlayer, List list, boolean bl) {
        if (this.type.category == 9) {
            list.add("Fuel Stored: " + (this.type.fuel - ieta2._j()) + " / " + this.type.fuel);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public int func_82790_a(ieta ieta2, int n) {
        return this.type.colour;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(qlze qlze2) {
        this.field_77791_bV = qlze2._a("FlansMod:" + this.type.iconPath);
    }
}

