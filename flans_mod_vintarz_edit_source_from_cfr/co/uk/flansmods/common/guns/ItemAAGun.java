/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  ieta
 *  jhvs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.util.dfat
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.roij
 *  net.minecraft.util.samw
 *  net.minecraftforge.common.tuor
 *  qlze
 *  tekj
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.guns.AAGunType;
import co.uk.flansmods.common.guns.EntityAAGun;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidl;
import net.minecraft.util.dfat;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.roij;
import net.minecraft.util.samw;
import net.minecraftforge.common.tuor;

public class ItemAAGun
extends jhvs {
    public static final ArrayList names = new ArrayList();
    @SideOnly(value=Side.CLIENT)
    private ArrayList icons;
    public AAGunType type;

    public ItemAAGun(int n, AAGunType aAGunType) {
        super(n);
        this.field_77777_bU = 1;
        this.type = aAGunType;
        this.type.item = this;
        this.func_77637_a((tekj)FlansMod.tabFlanGuns);
    }

    public ieta func_77659_a(ieta ieta2, cuqu cuqu2, EntityPlayer entityPlayer) {
        samw samw2;
        float f = dwbg._b((float)(-entityPlayer.field_70177_z * 0.01745329f - 3.141593f));
        float f2 = dwbg._a((float)(-entityPlayer.field_70177_z * 0.01745329f - 3.141593f));
        float f3 = -dwbg._b((float)(-entityPlayer.field_70125_A * 0.01745329f));
        float f4 = dwbg._a((float)(-entityPlayer.field_70125_A * 0.01745329f));
        samw samw3 = samw._a((double)entityPlayer.field_70165_t, (double)(entityPlayer.field_70163_u + 1.62 - (double)entityPlayer.field_70129_M), (double)entityPlayer.field_70161_v);
        idqh idqh2 = cuqu2.func_72901_a(samw3, samw2 = samw3._c((double)(f2 * f3) * 5.0, (double)f4 * 5.0, (double)(f * f3) * 5.0), true);
        if (idqh2 == null) {
            return ieta2;
        }
        if (idqh2._a == dfat._a) {
            int n = idqh2._b;
            int n2 = idqh2._c;
            int n3 = idqh2._d;
            if (!cuqu2.field_72995_K && cuqu2.isBlockSolidOnSide(n, n2, n3, tuor.UP)) {
                cuqu2.func_72838_d((Entity)new EntityAAGun(cuqu2, this.type, (double)n + 0.5, (double)n2 + 1.0, (double)n3 + 0.5));
            }
            if (!entityPlayer.field_71075_bZ._d) {
                --ieta2._b;
            }
        }
        return ieta2;
    }

    public Entity spawnAAGun(cuqu cuqu2, double d, double d2, double d3, ieta ieta2) {
        EntityAAGun entityAAGun = new EntityAAGun(cuqu2, this.type, d, d2, d3);
        if (!cuqu2.field_72995_K) {
            cuqu2.func_72838_d((Entity)entityAAGun);
        }
        return entityAAGun;
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

