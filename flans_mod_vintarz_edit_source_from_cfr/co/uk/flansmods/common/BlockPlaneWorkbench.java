/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ccfp
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  ieta
 *  kjsv
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.roij
 *  qlze
 *  tekj
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.FlansMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.roij;

public class BlockPlaneWorkbench
extends kjsv {
    private roij side;
    private roij[] top;

    public BlockPlaneWorkbench(int n, int n2, int n3) {
        super(n, ccfp._f);
        this.func_71848_c(3.0f);
        this.func_71894_b(6.0f);
        this.func_71849_a((tekj)FlansMod.tabFlanDriveables);
    }

    public void func_71879_a(int n, tekj tekj2, List list) {
        list.add(new ieta(n, 1, 0));
        list.add(new ieta(n, 1, 1));
        list.add(new ieta(n, 1, 2));
    }

    public roij func_71858_a(int n, int n2) {
        return n == 1 ? this.top[n2] : this.side;
    }

    public boolean func_71903_a(cuqu cuqu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        switch (cuqu2.func_72805_g(n, n2, n3)) {
            case 0: {
                if (!cuqu2.field_72995_K) break;
                entityPlayer.openGui((Object)FlansMod.instance, 0, cuqu2, n, n2, n3);
                break;
            }
            case 1: {
                if (cuqu2.field_72995_K) break;
                entityPlayer.openGui((Object)FlansMod.instance, 2, cuqu2, n, n2, n3);
            }
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(qlze qlze2) {
        this.top = new roij[3];
        this.top[0] = qlze2._a("FlansMod:planeCraftingTableSmall");
        this.top[1] = qlze2._a("FlansMod:planeCraftingTableLarge");
        this.top[2] = qlze2._a("FlansMod:vehicleCraftingTable");
        this.side = qlze2._a("FlansMod:planeCraftingTableSide");
    }

    public int func_71899_b(int n) {
        return n;
    }
}

