/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  dxen
 *  ieta
 *  jhvs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.entity.srlj
 *  net.minecraft.util.roij
 *  qlze
 *  sbmc
 *  tekj
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.guns.EntityGrenade;
import co.uk.flansmods.common.guns.GrenadeType;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidl;
import net.minecraft.entity.srlj;
import net.minecraft.util.roij;

public class ItemGrenade
extends jhvs {
    public GrenadeType type;

    public ItemGrenade(int n, GrenadeType grenadeType) {
        super(n);
        this.type = grenadeType;
        this.field_77777_bU = this.type.maxStackSize;
        this.type.item = this;
        this.func_77637_a((tekj)FlansMod.tabFlanGuns);
    }

    public float getDamageVsEntity(Entity entity, ieta ieta2) {
        return this.type.meleeDamage;
    }

    public Multimap func_111205_h() {
        Multimap multimap = super.func_111205_h();
        multimap.put((Object)srlj._e._a(), (Object)new dxen(jhvs.field_111210_e, "Weapon modifier", (double)this.type.meleeDamage, 0));
        return multimap;
    }

    public boolean func_77662_d() {
        return true;
    }

    public boolean onEntitySwing(EntityLivingBase entityLivingBase, ieta ieta2) {
        return this.type.meleeDamage == 0;
    }

    public ieta func_77659_a(ieta ieta2, cuqu cuqu2, EntityPlayer entityPlayer) {
        FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData(entityPlayer, cuqu2.field_72995_K ? Side.CLIENT : Side.SERVER);
        if (flansModPlayerData.shootTime <= 0) {
            flansModPlayerData.shootTime = this.type.throwDelay;
            EntityGrenade entityGrenade = new EntityGrenade(cuqu2, this.type, (EntityLivingBase)entityPlayer);
            if (!cuqu2.field_72995_K) {
                cuqu2.func_72838_d((Entity)entityGrenade);
            }
            if (this.type.remote) {
                flansModPlayerData.remoteExplosives.add(entityGrenade);
            }
            if (!entityPlayer.field_71075_bZ._d) {
                --ieta2._b;
            }
            if (this.type.dropItemOnThrow != null) {
                String string = this.type.dropItemOnDetonate;
                int n = 0;
                if (string.contains(".")) {
                    n = Integer.parseInt(string.split("\\.")[1]);
                    string = string.split("\\.")[0];
                }
                ieta ieta3 = InfoType.getRecipeElement(string, n);
                cuqu2.func_72838_d((Entity)new EntityItem(cuqu2, entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, ieta3));
            }
        }
        return ieta2;
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

