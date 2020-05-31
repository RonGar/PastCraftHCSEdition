/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ccfp
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  ieta
 *  jhvs
 *  kjsv
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.dfat
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.roij
 *  net.minecraft.util.samw
 *  qlze
 *  tekj
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.teams.EntityFlagpole;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dfat;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.roij;
import net.minecraft.util.samw;

public class ItemFlagpole
extends jhvs {
    public ItemFlagpole(int n) {
        super(n);
        this.func_77637_a((tekj)FlansMod.tabFlanTeams);
    }

    public ieta func_77659_a(ieta ieta2, cuqu cuqu2, EntityPlayer entityPlayer) {
        float f;
        float f2;
        float f3;
        float f4 = entityPlayer.field_70127_C + (entityPlayer.field_70125_A - entityPlayer.field_70127_C) * 1.0f;
        float f5 = entityPlayer.field_70126_B + (entityPlayer.field_70177_z - entityPlayer.field_70126_B) * 1.0f;
        double d = entityPlayer.field_70169_q + (entityPlayer.field_70165_t - entityPlayer.field_70169_q) * 1.0;
        double d2 = entityPlayer.field_70167_r + (entityPlayer.field_70163_u - entityPlayer.field_70167_r) * 1.0 + 1.62 - (double)entityPlayer.field_70129_M;
        double d3 = entityPlayer.field_70166_s + (entityPlayer.field_70161_v - entityPlayer.field_70166_s) * 1.0;
        samw samw2 = samw._a((double)d, (double)d2, (double)d3);
        float f6 = dwbg._b((float)(-f5 * 0.01745329f - 3.141593f));
        float f7 = dwbg._a((float)(-f5 * 0.01745329f - 3.141593f));
        float f8 = f7 * (f3 = -dwbg._b((float)(-f4 * 0.01745329f)));
        samw samw3 = samw2._c((double)f8 * 5.0, (double)(f = dwbg._a((float)(-f4 * 0.01745329f))) * 5.0, (double)(f2 = f6 * f3) * 5.0);
        idqh idqh2 = cuqu2.func_72901_a(samw2, samw3, true);
        if (idqh2 == null) {
            return ieta2;
        }
        if (idqh2._a == dfat._a) {
            int n = idqh2._b;
            int n2 = idqh2._c;
            int n3 = idqh2._d;
            if (!cuqu2.field_72995_K) {
                if (cuqu2.func_72798_a(n, n2, n3) == kjsv.field_72037_aS.field_71990_ca) {
                    --n2;
                }
                if (this.isSolid(cuqu2, n, n2, n3)) {
                    cuqu2.func_72838_d((Entity)new EntityFlagpole(cuqu2, n, n2 + 1, n3));
                }
            }
        }
        return ieta2;
    }

    private boolean isSolid(cuqu cuqu2, int n, int n2, int n3) {
        int n4 = cuqu2.func_72798_a(n, n2, n3);
        if (n4 == 0) {
            return false;
        }
        return kjsv.field_71973_m[n4].field_72018_cp._b() && kjsv.field_71973_m[n4].func_71926_d();
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(qlze qlze2) {
        this.field_77791_bV = qlze2._a("FlansMod:flagpole");
    }
}

