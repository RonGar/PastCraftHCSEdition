/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ccfp
 *  cpw.mods.fml.common.uxsf
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  dxti
 *  ieta
 *  jhvs
 *  kjsv
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.roij
 *  ogpr
 *  qlze
 *  samw
 *  tekj
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.GunBoxType;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.TileEntityGunBox;
import co.uk.flansmods.common.guns.BulletType;
import cpw.mods.fml.common.uxsf;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;
import net.minecraft.util.roij;

public class BlockGunBox
extends samw {
    public BlockGunBox(int n) {
        super(n, ccfp._d);
        this.func_71848_c(2.0f);
        this.func_71894_b(4.0f);
        this.func_71849_a((tekj)FlansMod.tabFlanGuns);
    }

    public void buyGun(int n, rojd rojd2, GunBoxType gunBoxType) {
        if (uxsf.instance().getEffectiveSide().isClient()) {
            FlansMod.proxy.buyGun(gunBoxType, n);
        }
        if (n <= gunBoxType.numGuns && gunBoxType.guns[n] != null) {
            int n2;
            ieta ieta2;
            int n3;
            boolean bl = true;
            for (ieta ieta3 : gunBoxType.gunParts[n]) {
                n2 = 0;
                for (n3 = 0; n3 < rojd2.func_70302_i_(); ++n3) {
                    ieta2 = rojd2.func_70301_a(n3);
                    if (ieta2 == null || ieta2._d != ieta3._d || ieta2._j() != ieta3._j()) continue;
                    n2 += ieta2._b;
                }
                if (n2 >= ieta3._b) continue;
                bl = false;
            }
            if (bl) {
                for (ieta ieta3 : gunBoxType.gunParts[n]) {
                    n2 = ieta3._b;
                    for (n3 = 0; n3 < rojd2.func_70302_i_(); ++n3) {
                        ieta2 = rojd2.func_70301_a(n3);
                        if (n2 <= 0 || ieta2 == null || ieta2._d != ieta3._d || ieta2._j() != ieta3._j()) continue;
                        n2 -= rojd2.func_70298_a((int)n3, (int)n2)._b;
                    }
                }
                rojd2._c(new ieta(gunBoxType.guns[n].getItem()));
            }
        }
    }

    public void buyAmmo(int n, rojd rojd2, GunBoxType gunBoxType) {
        if (uxsf.instance().getEffectiveSide().isClient()) {
            FlansMod.proxy.buyAmmo(gunBoxType, n, 1);
        }
        if (n <= gunBoxType.numGuns && gunBoxType.bulletParts[n] != null) {
            int n2;
            ieta ieta2;
            int n3;
            boolean bl = true;
            for (ieta ieta3 : gunBoxType.bulletParts[n]) {
                n2 = 0;
                for (n3 = 0; n3 < rojd2.func_70302_i_(); ++n3) {
                    ieta2 = rojd2.func_70301_a(n3);
                    if (ieta2 == null || ieta2._d != ieta3._d || ieta2._j() != ieta3._j()) continue;
                    n2 += ieta2._b;
                }
                if (n2 >= ieta3._b) continue;
                bl = false;
            }
            if (bl) {
                for (ieta ieta3 : gunBoxType.bulletParts[n]) {
                    n2 = ieta3._b;
                    for (n3 = 0; n3 < rojd2.func_70302_i_(); ++n3) {
                        ieta2 = rojd2.func_70301_a(n3);
                        if (n2 <= 0 || ieta2 == null || ieta2._d != ieta3._d || ieta2._j() != ieta3._j()) continue;
                        n2 -= rojd2.func_70298_a((int)n3, (int)n2)._b;
                    }
                }
                rojd2._c(new ieta(gunBoxType.bullets[n].getItem()));
            }
        }
    }

    public void buyAltAmmo(int n, rojd rojd2, GunBoxType gunBoxType) {
        if (uxsf.instance().getEffectiveSide().isClient()) {
            FlansMod.proxy.buyAmmo(gunBoxType, n, 2);
        }
        if (n <= gunBoxType.numGuns && gunBoxType.altBulletParts[n] != null) {
            int n2;
            ieta ieta2;
            int n3;
            boolean bl = true;
            for (ieta ieta3 : gunBoxType.altBulletParts[n]) {
                n2 = 0;
                for (n3 = 0; n3 < rojd2.func_70302_i_(); ++n3) {
                    ieta2 = rojd2.func_70301_a(n3);
                    if (ieta2 == null || ieta2._d != ieta3._d || ieta2._j() != ieta3._j()) continue;
                    n2 += ieta2._b;
                }
                if (n2 >= ieta3._b) continue;
                bl = false;
            }
            if (bl) {
                for (ieta ieta3 : gunBoxType.altBulletParts[n]) {
                    n2 = ieta3._b;
                    for (n3 = 0; n3 < rojd2.func_70302_i_(); ++n3) {
                        ieta2 = rojd2.func_70301_a(n3);
                        if (n2 <= 0 || ieta2 == null || ieta2._d != ieta3._d || ieta2._j() != ieta3._j()) continue;
                        n2 -= rojd2.func_70298_a((int)n3, (int)n2)._b;
                    }
                }
                rojd2._c(new ieta(gunBoxType.altBullets[n].getItem()));
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public roij func_71895_b(dxti dxti2, int n, int n2, int n3, int n4) {
        TileEntityGunBox tileEntityGunBox = (TileEntityGunBox)dxti2.func_72796_p(n, n2, n3);
        GunBoxType gunBoxType = tileEntityGunBox.getType();
        return gunBoxType == null ? null : (n4 == 1 ? gunBoxType.top : (n4 == 0 ? gunBoxType.bottom : gunBoxType.side));
    }

    @SideOnly(value=Side.CLIENT)
    public roij func_71858_a(int n, int n2) {
        GunBoxType gunBoxType = GunBoxType.getBox(n2);
        return gunBoxType == null ? null : (n == 1 ? gunBoxType.top : (n == 0 ? gunBoxType.bottom : gunBoxType.side));
    }

    public boolean func_71903_a(cuqu cuqu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        TileEntityGunBox tileEntityGunBox = (TileEntityGunBox)cuqu2.func_72796_p(n, n2, n3);
        if (tileEntityGunBox != null) {
            if (entityPlayer.func_70093_af()) {
                return false;
            }
            entityPlayer.openGui((Object)FlansMod.instance, 5, cuqu2, n, n2, n3);
        }
        return true;
    }

    public void addCreativeItems(ArrayList arrayList) {
        arrayList.add(new ieta((kjsv)this));
    }

    public kjsv purchaseItem(int n, int n2, rojd rojd2, GunBoxType gunBoxType) {
        switch (n) {
            case 0: {
                this.buyGun(n2, rojd2, gunBoxType);
                break;
            }
            case 1: {
                this.buyAmmo(n2, rojd2, gunBoxType);
                break;
            }
            case 2: {
                this.buyAltAmmo(n2, rojd2, gunBoxType);
            }
        }
        return this;
    }

    public ogpr func_72274_a(cuqu cuqu2) {
        return new TileEntityGunBox();
    }

    public ArrayList getBlockDropped(cuqu cuqu2, int n, int n2, int n3, int n4, int n5) {
        ArrayList<ieta> arrayList = new ArrayList<ieta>();
        TileEntityGunBox tileEntityGunBox = (TileEntityGunBox)cuqu2.func_72796_p(n, n2, n3);
        if (tileEntityGunBox != null && tileEntityGunBox.getType() != null) {
            arrayList.add(new ieta(this.field_71990_ca, 1, tileEntityGunBox.getType().gunBoxID));
        }
        return arrayList;
    }

    public void func_71852_a(cuqu cuqu2, int n, int n2, int n3, int n4, int n5) {
        TileEntityGunBox tileEntityGunBox = (TileEntityGunBox)cuqu2.func_72796_p(n, n2, n3);
        if (tileEntityGunBox != null && tileEntityGunBox.getType() != null) {
            cuqu2.func_72838_d((Entity)new EntityItem(cuqu2, (double)((float)n + 0.5f), (double)((float)n2 + 0.5f), (double)((float)n3 + 0.5f), new ieta(this.field_71990_ca, 1, tileEntityGunBox.getType().gunBoxID)));
        }
        super.func_71852_a(cuqu2, n, n2, n3, n4, n5);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(qlze qlze2) {
        for (GunBoxType gunBoxType : GunBoxType.gunBoxMap.values()) {
            gunBoxType.top = qlze2._a("FlansMod:" + gunBoxType.topTexturePath);
            gunBoxType.side = qlze2._a("FlansMod:" + gunBoxType.sideTexturePath);
            gunBoxType.bottom = qlze2._a("FlansMod:" + gunBoxType.bottomTexturePath);
        }
    }
}

