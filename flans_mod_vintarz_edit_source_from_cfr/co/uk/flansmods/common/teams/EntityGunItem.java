/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.GameRegistry
 *  cuqu
 *  ieta
 *  jhvs
 *  kjsv
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.eidl
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.pico
 *  net.minecraft.util.rojd
 *  net.minecraftforge.common.bpzx
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.eidl
 *  pkeo
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemBullet;
import co.uk.flansmods.common.guns.ItemGun;
import cpw.mods.fml.common.registry.GameRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.eidl;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;
import net.minecraft.util.dwbg;
import net.minecraft.util.pico;
import net.minecraftforge.common.bpzx;
import net.minecraftforge.event.Event;

public class EntityGunItem
extends EntityItem {
    public List<ieta> ammoStacks;

    public EntityGunItem(cuqu cuqu2) {
        super(cuqu2);
    }

    public EntityGunItem(EntityItem entityItem) {
        super(entityItem.field_70170_p, entityItem.field_70165_t, entityItem.field_70163_u, entityItem.field_70161_v, entityItem.func_92059_d()._l());
        this.func_70105_a(1.0f, 1.0f);
        this.ammoStacks = new ArrayList<ieta>();
    }

    public EntityGunItem(cuqu cuqu2, double d, double d2, double d3, ieta ieta2, List<ieta> list) {
        super(cuqu2, d, d2, d3, ieta2);
        this.func_70105_a(1.0f, 1.0f);
        this.ammoStacks = new ArrayList<ieta>();
        for (ieta ieta3 : list) {
            if (ieta3 == null || ieta3._a() == null || !(ieta3._a() instanceof ItemBullet)) continue;
            this.ammoStacks.add(ieta3);
        }
    }

    public EntityGunItem(cuqu cuqu2, double d, double d2, double d3) {
        super(cuqu2, d, d2, d3);
    }

    public boolean func_70067_L() {
        return true;
    }

    protected boolean func_70041_e_() {
        return true;
    }

    public net.minecraft.util.rojd func_70046_E() {
        return null;
    }

    public boolean func_70075_an() {
        return true;
    }

    public void func_70071_h_() {
        this.func_70030_z();
        if (this.func_92059_d() == null || this.func_92059_d()._a() == null || !(this.func_92059_d()._a() instanceof ItemGun)) {
            this.func_70106_y();
        }
        if (!this.field_70170_p.field_72995_K && this.ammoStacks == null) {
            this.func_70106_y();
        }
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.field_70181_x -= 0.03999999910593033;
        this.func_70048_i(this.field_70165_t, (this.field_70121_D.field_72338_b + this.field_70121_D.field_72337_e) / 2.0, this.field_70161_v);
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        float f = 0.98f;
        if (this.field_70122_E) {
            f = 0.58800006f;
            int n = this.field_70170_p.func_72798_a(dwbg._c((double)this.field_70165_t), dwbg._c((double)this.field_70121_D.field_72338_b) - 1, dwbg._c((double)this.field_70161_v));
            if (n > 0) {
                f = kjsv.field_71973_m[n].field_72016_cq * 0.98f;
            }
        }
        this.field_70159_w *= (double)f;
        this.field_70181_x *= 0.9800000190734863;
        this.field_70179_y *= (double)f;
        if (this.field_70122_E) {
            this.field_70181_x *= -0.5;
        }
        ++this.field_70292_b;
        ieta ieta2 = this.func_70096_w()._f(10);
        if (!this.field_70170_p.field_72995_K && this.field_70292_b >= this.lifespan) {
            if (ieta2 != null) {
                pkeo pkeo2 = new pkeo((EntityItem)this, ieta2._a() == null ? 6000 : ieta2._a().getEntityLifespan(ieta2, this.field_70170_p));
                if (bpzx.EVENT_BUS.post((Event)pkeo2)) {
                    this.lifespan += pkeo2.extraLife;
                } else {
                    this.func_70106_y();
                }
            } else {
                this.func_70106_y();
            }
        }
        if (ieta2 != null && ieta2._b <= 0) {
            this.func_70106_y();
        }
    }

    public boolean func_70097_a(pico pico2, float f) {
        return false;
    }

    public void func_70100_b_(EntityPlayer entityPlayer) {
        if (!this.field_70170_p.field_72995_K && this.ammoStacks != null && this.ammoStacks.size() > 0) {
            for (int i = 0; i < entityPlayer.field_71071_by.func_70302_i_(); ++i) {
                ieta ieta2 = entityPlayer.field_71071_by.func_70301_a(i);
                if (ieta2 == null || ieta2._a() == null || !(ieta2._a() instanceof ItemGun)) continue;
                GunType gunType = ((ItemGun)ieta2._a()).type;
                for (int j = this.ammoStacks.size() - 1; j >= 0; --j) {
                    ieta ieta3 = this.ammoStacks.get(j);
                    if (!gunType.isAmmo(((ItemBullet)ieta3._a()).type) || !entityPlayer.field_71071_by._c(ieta3)) continue;
                    GameRegistry.onPickupNotification((EntityPlayer)entityPlayer, (EntityItem)this);
                    this.func_85030_a("random.pop", 0.2f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                    this.ammoStacks.remove(j);
                }
                if (this.ammoStacks.size() != 0) continue;
                this.func_70106_y();
            }
        }
    }

    public boolean func_130002_c(EntityPlayer entityPlayer) {
        if (this.field_70170_p.field_72995_K) {
            return true;
        }
        ieta ieta2 = entityPlayer.func_71045_bC();
        if (ieta2 != null && ieta2._a() instanceof ItemGun) {
            GunType gunType = ((ItemGun)ieta2._a()).type;
            ArrayList<ieta> arrayList = new ArrayList<ieta>();
            for (int i = 0; i < entityPlayer.field_71071_by.func_70302_i_(); ++i) {
                BulletType bulletType;
                ieta ieta3 = entityPlayer.field_71071_by.func_70301_a(i);
                if (ieta3 == null || !(ieta3._a() instanceof ItemBullet) || !gunType.isAmmo(bulletType = ((ItemBullet)ieta3._a()).type)) continue;
                arrayList.add(ieta3._l());
                entityPlayer.field_71071_by.func_70299_a(i, null);
            }
            EntityGunItem entityGunItem = new EntityGunItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, ieta2._l(), arrayList);
            this.field_70170_p.func_72838_d((Entity)entityGunItem);
            entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, this.func_92059_d());
            for (ieta ieta3 : this.ammoStacks) {
                entityPlayer.field_71071_by._c(ieta3);
            }
            this.func_70106_y();
            FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayer).shootClickDelay = 10;
            return true;
        }
        return false;
    }
}

