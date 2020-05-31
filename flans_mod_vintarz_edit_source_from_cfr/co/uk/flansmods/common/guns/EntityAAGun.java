/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.io.ByteArrayDataInput
 *  com.google.common.io.ByteArrayDataOutput
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.common.registry.IEntityAdditionalSpawnData
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  hsus
 *  ieta
 *  jhvs
 *  maaq
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.idqh
 *  net.minecraft.util.pico
 *  net.minecraft.util.rojd
 *  net.minecraft.util.samw
 *  net.minecraft.util.zwaq
 *  org.lwjgl.input.Mouse
 *  rojd
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.guns.AAGunType;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.guns.ItemBullet;
import co.uk.flansmods.common.network.PacketMGFire;
import co.uk.flansmods.common.network.PacketPlaySound;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidl;
import net.minecraft.util.idqh;
import net.minecraft.util.pico;
import net.minecraft.util.samw;
import net.minecraft.util.zwaq;
import org.lwjgl.input.Mouse;

public class EntityAAGun
extends Entity
implements IEntityAdditionalSpawnData {
    private int field_9394_d;
    private double field_9393_e;
    private double field_9392_f;
    private double field_9391_g;
    private double field_9390_h;
    private double field_9389_i;
    private double field_9388_j;
    private double field_9387_k;
    private double field_9386_l;
    private int health;
    private int shootDelay;
    public float gunYaw;
    public float gunPitch;
    public float[] barrelRecoil;
    public AAGunType type;
    public Entity towedByEntity;
    public ieta[] ammo;
    public int reloadTimer;
    public int currentBarrel;
    public boolean mouseHeld;
    public boolean wasShooting;
    public int ticksSinceUsed = 0;

    public EntityAAGun(cuqu cuqu2) {
        super(cuqu2);
        this.field_70156_m = true;
        this.func_70105_a(2.0f, 2.0f);
        this.field_70129_M = 0.0f;
        this.gunYaw = 0.0f;
        this.gunPitch = 0.0f;
        this.shootDelay = 0;
    }

    public EntityAAGun(cuqu cuqu2, AAGunType aAGunType, double d, double d2, double d3) {
        this(cuqu2);
        this.type = aAGunType;
        this.initType();
        this.func_70107_b(d, d2, d3);
    }

    public void func_70107_b(double d, double d2, double d3) {
        this.field_70165_t = d;
        this.field_70163_u = d2;
        this.field_70161_v = d3;
        float f = this.field_70130_N / 2.0f;
        float f2 = this.field_70131_O;
        this.field_70121_D.func_72324_b(d - (double)f, d2 - (double)this.field_70129_M + (double)this.field_70139_V, d3 - (double)f, d + (double)f, d2 - (double)this.field_70129_M + (double)this.field_70139_V + (double)f2, d3 + (double)f);
    }

    public void initType() {
        this.health = this.type.health;
        this.barrelRecoil = new float[this.type.numBarrels];
        this.ammo = new ieta[this.type.numBarrels];
    }

    protected void func_70088_a() {
    }

    public void func_70100_b_(EntityPlayer entityPlayer) {
    }

    public void func_70108_f(Entity entity) {
    }

    public net.minecraft.util.rojd func_70114_g(Entity entity) {
        return entity.field_70121_D;
    }

    public net.minecraft.util.rojd func_70046_E() {
        return this.field_70121_D;
    }

    public boolean func_70104_M() {
        return false;
    }

    public double func_70042_X() {
        return 0.0;
    }

    public void setMouseHeld(boolean bl) {
        this.mouseHeld = bl;
    }

    public boolean func_70097_a(pico pico2, float f) {
        if (pico2.field_76373_n.equals("player")) {
            Entity entity = ((zwaq)pico2).func_76346_g();
            if (entity != this.field_70153_n) {
                if (this.field_70153_n != null) {
                    return this.field_70153_n.func_70097_a(pico2, f);
                }
                if (FlansMod.canBreakGuns) {
                    this.func_70106_y();
                }
            }
        } else {
            this.func_70018_K();
            this.health = (int)((float)this.health - f);
            if (!this.field_70170_p.field_72995_K && this.health <= 0) {
                this.func_70106_y();
            }
        }
        return true;
    }

    public samw rotate(double d, double d2, double d3) {
        double d4 = Math.cos(180.0f - this.gunYaw * 3.1415927f / 180.0f);
        double d5 = Math.sin(180.0f - this.gunYaw * 3.1415927f / 180.0f);
        double d6 = Math.cos(this.gunPitch * 3.1415927f / 180.0f);
        double d7 = Math.sin(this.gunPitch * 3.1415927f / 180.0f);
        double d8 = d * d4 + (d2 * d7 + d3 * d6) * d5;
        double d9 = d2 * d6 - d3 * d7;
        double d10 = -d * d5 + (d2 * d7 + d3 * d6) * d4;
        return samw._a((double)d8, (double)d9, (double)d10);
    }

    public boolean func_70067_L() {
        return !this.field_70128_L;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        ++this.ticksSinceUsed;
        if (FlansMod.aaLife > 0 && this.ticksSinceUsed > FlansMod.aaLife * 20) {
            this.func_70106_y();
        }
        if (this.field_70153_n != null) {
            this.ticksSinceUsed = 0;
            this.gunYaw = this.field_70153_n.field_70177_z - 90.0f;
            this.gunPitch = this.field_70153_n.field_70125_A;
        }
        if (this.gunPitch > this.type.bottomViewLimit) {
            this.gunPitch = this.type.bottomViewLimit;
        }
        if (this.gunPitch < -this.type.topViewLimit) {
            this.gunPitch = -this.type.topViewLimit;
        }
        int n = 0;
        while (n < this.type.numBarrels) {
            float[] arrf = this.barrelRecoil;
            int n2 = n++;
            arrf[n2] = arrf[n2] * 0.9f;
        }
        if (this.shootDelay > 0) {
            --this.shootDelay;
        }
        this.field_70159_w *= 0.5;
        this.field_70179_y *= 0.5;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        if (this.field_70170_p.field_72995_K && this.field_70153_n != null && this.field_70153_n == rojd.instance().getClient()._r) {
            this.checkForShooting();
        }
        if (this.field_70170_p.field_72995_K) {
            if (this.field_9394_d > 0) {
                double d;
                double d2 = this.field_70165_t + (this.field_9393_e - this.field_70165_t) / (double)this.field_9394_d;
                double d3 = this.field_70163_u + (this.field_9392_f - this.field_70163_u) / (double)this.field_9394_d;
                double d4 = this.field_70161_v + (this.field_9391_g - this.field_70161_v) / (double)this.field_9394_d;
                for (d = this.field_9390_h - (double)this.field_70177_z; d < -180.0; d += 360.0) {
                }
                while (d >= 180.0) {
                    d -= 360.0;
                }
                this.field_70177_z = (float)((double)this.field_70177_z + d / (double)this.field_9394_d);
                this.field_70125_A = (float)((double)this.field_70125_A + (this.field_9389_i - (double)this.field_70125_A) / (double)this.field_9394_d);
                --this.field_9394_d;
                this.func_70107_b(d2, d3, d4);
                this.func_70101_b(this.field_70177_z, this.field_70125_A);
            }
        } else {
            int n3;
            if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
                this.field_70153_n = null;
            }
            if (this.reloadTimer > 0) {
                --this.reloadTimer;
            } else {
                for (n = 0; n < this.type.numBarrels; ++n) {
                    if (this.ammo[n] != null && this.ammo[n]._j() == this.ammo[n]._k()) {
                        this.ammo[n] = null;
                    }
                    if (this.ammo[n] != null || this.field_70153_n == null || !(this.field_70153_n instanceof EntityPlayer) || (n3 = this.findAmmo((EntityPlayer)this.field_70153_n)) < 0) continue;
                    this.ammo[n] = ((EntityPlayer)this.field_70153_n).field_71071_by.func_70301_a(n3);
                    if (!((EntityPlayer)this.field_70153_n).field_71075_bZ._d) {
                        ((EntityPlayer)this.field_70153_n).field_71071_by.func_70298_a(n3, 1);
                    }
                    this.reloadTimer = this.type.reloadTime;
                    PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0, this.field_71093_bK, this.type.reloadSound, true);
                }
            }
            if (!this.field_70170_p.field_72995_K && this.mouseHeld && this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.reloadTimer <= 0 && this.shootDelay <= 0) {
                EntityPlayer entityPlayer = (EntityPlayer)this.field_70153_n;
                for (n3 = 0; n3 < this.type.numBarrels; ++n3) {
                    if (this.shootDelay > 0 || this.ammo[n3] == null || this.type.fireAlternately && (!this.type.fireAlternately || this.currentBarrel != n3)) continue;
                    BulletType.getBullet(this.ammo[n3]._d);
                    if (!((EntityPlayer)this.field_70153_n).field_71075_bZ._d) {
                        this.ammo[n3]._a(1, (EntityLivingBase)entityPlayer);
                    }
                    this.shootDelay = this.type.shootDelay;
                    this.barrelRecoil[n3] = this.type.recoil;
                    ((ItemBullet)this.ammo[n3]._a()).getEntity(this.field_70170_p, this.rotate((double)this.type.barrelX[this.currentBarrel] / 16.0 - (double)this.type.barrelZ[this.currentBarrel] / 16.0, (double)this.type.barrelY[this.currentBarrel] / 16.0, (double)this.type.barrelX[this.currentBarrel] / 16.0 + (double)this.type.barrelZ[this.currentBarrel] / 16.0)._c(this.field_70165_t, this.field_70163_u, this.field_70161_v), this.gunYaw + 90.0f, this.gunPitch, (EntityLivingBase)entityPlayer, (float)this.type.accuracy, (float)this.type.damage, this.ammo[n3]._j(), (InfoType)this.type);
                    PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0, this.field_71093_bK, this.type.shootSound, true);
                }
                this.currentBarrel = (this.currentBarrel + 1) % this.type.numBarrels;
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    private void checkForShooting() {
        if (Mouse.isButtonDown((int)0) && !this.wasShooting && !FlansMod.proxy.isScreenOpen()) {
            PacketDispatcher.sendPacketToServer((maaq)PacketMGFire.buildMGFirePacket(true));
            this.wasShooting = true;
        } else if (!Mouse.isButtonDown((int)0) && this.wasShooting) {
            PacketDispatcher.sendPacketToServer((maaq)PacketMGFire.buildMGFirePacket(false));
            this.wasShooting = false;
        }
    }

    public void func_70106_y() {
        super.func_70106_y();
        if (!this.field_70170_p.field_72995_K) {
            this.func_70025_b(this.type.getItem().field_77779_bT, 1);
            for (ieta ieta2 : this.ammo) {
                if (ieta2 == null) continue;
                this.func_70099_a(ieta2, 0.5f);
            }
        }
    }

    public void func_70043_V() {
        if (this.field_70153_n != null) {
            double d = (double)this.type.gunnerX / 16.0;
            double d2 = (double)this.type.gunnerY / 16.0;
            double d3 = (double)this.type.gunnerZ / 16.0;
            double d4 = Math.cos((double)(-this.gunYaw) / 180.0 * 3.141592653589793);
            double d5 = Math.sin((double)(-this.gunYaw) / 180.0 * 3.141592653589793);
            Math.cos((double)this.gunPitch / 180.0 * 3.141592653589793);
            Math.sin((double)this.gunPitch / 180.0 * 3.141592653589793);
            double d6 = d * d4 + d3 * d5;
            double d7 = -d * d5 + d3 * d4;
            this.field_70153_n.func_70107_b(this.field_70165_t + d6, this.field_70163_u + d2, this.field_70161_v + d7);
        }
    }

    protected void func_70014_b(hsus hsus2) {
        hsus2._a("Type", this.type.shortName);
        hsus2._a("Health", this.health);
        hsus2._a("RotationYaw", this.field_70177_z);
        hsus2._a("RotationPitch", this.field_70125_A);
        for (int i = 0; i < this.type.numBarrels; ++i) {
            if (this.ammo[i] == null) continue;
            hsus2._a("Ammo " + i, this.ammo[i]._b(new hsus()));
        }
    }

    protected void func_70037_a(hsus hsus2) {
        this.type = AAGunType.getAAGun(hsus2._j("Type"));
        this.initType();
        this.health = hsus2._f("Health");
        this.field_70177_z = hsus2._h("RotationYaw");
        this.field_70125_A = hsus2._h("RotationPitch");
        for (int i = 0; i < this.type.numBarrels; ++i) {
            this.ammo[i] = ieta._a((hsus)hsus2._m("Ammo " + i));
        }
    }

    public float func_70053_R() {
        return 0.0f;
    }

    public boolean func_130002_c(EntityPlayer entityPlayer) {
        return false;
    }

    public int findAmmo(EntityPlayer entityPlayer) {
        for (int i = 0; i < entityPlayer.field_71071_by.func_70302_i_(); ++i) {
            ieta ieta2 = entityPlayer.field_71071_by.func_70301_a(i);
            if (!this.type.isAmmo(ieta2)) continue;
            return i;
        }
        return -1;
    }

    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeUTF(this.type.shortName);
    }

    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        try {
            this.type = AAGunType.getAAGun(byteArrayDataInput.readUTF());
            this.initType();
        }
        catch (Exception exception) {
            FlansMod.log("Failed to retreive AA gun type from server.");
            super.func_70106_y();
            exception.printStackTrace();
        }
    }

    public boolean canRiderInteract() {
        return false;
    }

    public ieta getPickedResult(idqh idqh2) {
        ieta ieta2 = new ieta(this.type.itemID, 1, 0);
        return ieta2;
    }
}

