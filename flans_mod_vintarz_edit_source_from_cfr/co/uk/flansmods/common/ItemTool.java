/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  hcsmod.client.HcsClient
 *  hcsmod.server.HcsServer
 *  ieta
 *  jhvs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.pzgw
 *  net.minecraft.util.roij
 *  net.minecraft.util.rojd
 *  net.minecraft.util.samw
 *  qlze
 *  tekj
 */
package co.uk.flansmods.common;

import co.uk.flansmods.client.debug.EntityDebugVector;
import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.EntityParachute;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.ToolType;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.guns.EntityGrenade;
import co.uk.flansmods.common.vector.Vector3f;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.client.HcsClient;
import hcsmod.server.HcsServer;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidl;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.pzgw;
import net.minecraft.util.roij;
import net.minecraft.util.rojd;
import net.minecraft.util.samw;

public class ItemTool
extends jhvs {
    public ToolType type;

    public ItemTool(int n, ToolType toolType) {
        super(n);
        this.field_77777_bU = 1;
        this.type = toolType;
        this.type.item = this;
        this.func_77656_e(this.type.toolLife);
        this.func_77637_a((tekj)(this.type.remote ? FlansMod.tabFlanGuns : FlansMod.tabFlanParts));
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
    public void func_94581_a(qlze qlze2) {
        this.field_77791_bV = qlze2._a("FlansMod:" + this.type.iconPath);
    }

    public ieta func_77659_a(ieta ieta2, cuqu cuqu2, EntityPlayer entityPlayer) {
        Object object;
        DriveablePart driveablePart;
        Object object2;
        if (this.type.parachute) {
            if (entityPlayer.field_70143_R > 2.0f) {
                if (!cuqu2.field_72995_K) {
                    EntityParachute entityParachute = new EntityParachute(cuqu2, this.type, entityPlayer);
                    cuqu2.func_72838_d((Entity)entityParachute);
                    entityPlayer.func_70078_a((Entity)entityParachute);
                }
                if (!entityPlayer.field_71075_bZ._d && this.type.toolLife > 0) {
                    ieta2._b(ieta2._j() + 1);
                }
                if (this.type.toolLife > 0 && this.type.destroyOnEmpty && ieta2._j() == ieta2._k()) {
                    --ieta2._b;
                }
            }
            return ieta2;
        }
        if (this.type.remote && !cuqu2.field_72995_K) {
            FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData(entityPlayer, Side.SERVER);
            boolean bl = true;
            for (int i = 0; i < flansModPlayerData.remoteExplosives.size(); ++i) {
                EntityGrenade entityGrenade = flansModPlayerData.remoteExplosives.get(i);
                entityGrenade.detonate();
                if (entityGrenade.detonated) continue;
                bl = false;
            }
            if (bl) {
                flansModPlayerData.remoteExplosives.clear();
            }
            if (!entityPlayer.field_71075_bZ._d && this.type.toolLife > 0) {
                ieta2._b(ieta2._j() + 1);
            }
            if (this.type.toolLife > 0 && this.type.destroyOnEmpty && ieta2._j() == ieta2._k()) {
                --ieta2._b;
            }
            return ieta2;
        }
        float f = dwbg._b((float)(-entityPlayer.field_70177_z * 0.01745329f));
        float f2 = dwbg._a((float)(-entityPlayer.field_70177_z * 0.01745329f));
        float f3 = -dwbg._b((float)(entityPlayer.field_70125_A * 0.01745329f));
        float f4 = dwbg._a((float)(entityPlayer.field_70125_A * 0.01745329f));
        samw samw2 = samw._a((double)entityPlayer.field_70165_t, (double)(entityPlayer.field_70163_u + 1.62 - (double)entityPlayer.field_70129_M), (double)entityPlayer.field_70161_v);
        samw samw3 = samw2._c((double)(f2 * f3) * -5.0, (double)f4 * -5.0, (double)(f * f3) * -5.0);
        if (cuqu2.field_72995_K && FlansMod.DEBUG) {
            cuqu2.func_72838_d((Entity)new EntityDebugVector(cuqu2, new Vector3f(samw2), new Vector3f(samw2._a(samw3)), 100));
        }
        if (this.type.healDriveables) {
            EntityDriveable entityDriveable;
            for (int i = 0; i < cuqu2.field_72996_f.size(); ++i) {
                object = cuqu2.field_72996_f.get(i);
                if (!(object instanceof EntityDriveable) || (driveablePart = (entityDriveable = (EntityDriveable)object).raytraceParts(new Vector3f(samw2), Vector3f.sub(new Vector3f(samw3), new Vector3f(samw2), null))) == null || driveablePart.maxHealth <= 0 || driveablePart.health >= driveablePart.maxHealth || this.type.toolLife != 0 && ieta2._j() >= ieta2._k()) continue;
                driveablePart.health += this.type.healAmount;
                System.out.println(driveablePart);
                if (driveablePart.health > driveablePart.maxHealth) {
                    driveablePart.health = driveablePart.maxHealth;
                }
                if (!entityPlayer.field_71075_bZ._d && this.type.toolLife > 0) {
                    ieta2._b(ieta2._j() + 1);
                }
                if (this.type.toolLife > 0 && this.type.destroyOnEmpty && ieta2._j() == ieta2._k()) {
                    --ieta2._b;
                }
                return ieta2;
            }
            object2 = entityPlayer.func_70040_Z();
            object = cuqu2.func_82732_R()._a(entityPlayer.field_70165_t + object2._c, entityPlayer.field_70163_u + (double)entityPlayer.func_70047_e() + object2._d, entityPlayer.field_70161_v + object2._e);
            entityDriveable = cuqu2.func_82732_R()._a(entityPlayer.field_70165_t, entityPlayer.field_70163_u + (double)entityPlayer.func_70047_e(), entityPlayer.field_70161_v);
            driveablePart = cuqu2.func_72831_a(object, (samw)entityDriveable, false, true);
            object = cuqu2.func_82732_R()._a(entityPlayer.field_70165_t, entityPlayer.field_70163_u + (double)entityPlayer.func_70047_e(), entityPlayer.field_70161_v);
            cuqu2.func_82732_R()._a(entityPlayer.field_70165_t + ((samw)object)._c, entityPlayer.field_70163_u + (double)entityPlayer.func_70047_e() + ((samw)object)._d, entityPlayer.field_70161_v + ((samw)object)._e);
            if (driveablePart != null) {
                cuqu2.func_82732_R()._a(driveablePart._f._c, driveablePart._f._d, driveablePart._f._e);
            }
            List list = cuqu2.func_72839_b((Entity)entityPlayer, entityPlayer.field_70121_D.func_72321_a(object2._c, object2._d, object2._e));
            for (int i = 0; i < list.size(); ++i) {
                list.get(i);
            }
        }
        if (cuqu2.field_72995_K && this.type.healPlayers) {
            HcsClient.flansHealCooldown();
        }
        if (!cuqu2.field_72995_K && this.type.healPlayers) {
            if (!HcsServer.healCooldown((EntityPlayer)entityPlayer)) {
                return ieta2;
            }
            object2 = entityPlayer;
            object = cuqu2.func_72872_a(EntityLivingBase.class, rojd.func_72330_a((double)Math.min(samw2._c, samw3._c), (double)Math.min(samw2._d, samw3._d), (double)Math.min(samw2._e, samw3._e), (double)Math.max(samw2._c, samw3._c), (double)Math.max(samw2._d, samw3._d), (double)Math.max(samw2._e, samw3._e)));
            for (int i = 0; i < object.size(); ++i) {
                idqh idqh2;
                if (!(object.get(i) instanceof EntityLivingBase) || (driveablePart = (EntityLivingBase)object.get(i)) == entityPlayer || (idqh2 = ((EntityLivingBase)driveablePart).field_70121_D.func_72327_a(samw2, samw3)) == null) continue;
                object2 = driveablePart;
            }
            if (object2 != null) {
                if (ieta2._j() >= ieta2._k() && this.type.toolLife > 0) {
                    return ieta2;
                }
                ((EntityLivingBase)object2).func_70691_i((float)this.type.healAmount);
                if (!entityPlayer.field_71075_bZ._d && this.type.toolLife > 0) {
                    ieta2._b(ieta2._j() + 1);
                }
                if (this.type.toolLife > 0 && this.type.destroyOnEmpty && ieta2._j() >= ieta2._k()) {
                    --ieta2._b;
                }
            }
        }
        return ieta2;
    }

    public String toString() {
        return this.type == null ? this.field_77779_bT + "" : this.type.name;
    }
}

