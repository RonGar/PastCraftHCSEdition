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
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.idqh
 *  net.minecraft.util.pico
 *  net.minecraft.util.samw
 *  net.minecraft.util.zwaq
 *  org.lwjgl.input.Mouse
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.guns.EnumFireMode;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemBullet;
import co.uk.flansmods.common.network.PacketMGFire;
import co.uk.flansmods.common.network.PacketPlaySound;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidl;
import net.minecraft.entity.player.rojd;
import net.minecraft.util.idqh;
import net.minecraft.util.pico;
import net.minecraft.util.samw;
import net.minecraft.util.zwaq;
import org.lwjgl.input.Mouse;

public class EntityMG
extends Entity
implements IEntityAdditionalSpawnData {
    public int blockX;
    public int blockY;
    public int blockZ;
    public int direction;
    public GunType type;
    public ieta ammo;
    public int reloadTimer;
    public int soundDelay;
    public int shootDelay;
    public static List mgs = new ArrayList();
    public EntityPlayer gunner;
    public boolean isShooting;
    public boolean wasShooting = false;
    public int ticksSinceUsed = 0;

    public EntityMG(cuqu cuqu2) {
        super(cuqu2);
        this.func_70105_a(1.0f, 1.0f);
        this.field_70158_ak = true;
    }

    public EntityMG(cuqu cuqu2, int n, int n2, int n3, int n4, GunType gunType) {
        super(cuqu2);
        this.func_70105_a(1.0f, 1.0f);
        this.blockX = n;
        this.blockY = n2;
        this.blockZ = n3;
        this.field_70169_q = (double)n + 0.5;
        this.field_70167_r = n2;
        this.field_70166_s = (double)n3 + 0.5;
        this.func_70107_b((double)n + 0.5, (double)n2, (double)n3 + 0.5);
        this.direction = n4;
        this.field_70177_z = 0.0f;
        this.field_70125_A = -60.0f;
        this.type = gunType;
        this.field_70158_ak = true;
        mgs.add(this);
    }

    public boolean func_70067_L() {
        return !this.field_70128_L;
    }

    public void func_70071_h_() {
        this.func_70106_y();
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

    public void mouseHeld(boolean bl) {
        this.isShooting = bl;
    }

    public boolean func_70097_a(pico pico2, float f) {
        if (pico2.field_76373_n.equals("player")) {
            Entity entity = ((zwaq)pico2).func_76346_g();
            if (entity == this.gunner) {
                if (this.type.mode == EnumFireMode.FULLAUTO) {
                    return true;
                }
                if (this.ammo == null || this.reloadTimer > 0 || this.shootDelay > 0) {
                    return true;
                }
                BulletType.getBullet(this.ammo._d);
                if (this.gunner != null && !this.gunner.field_71075_bZ._d) {
                    this.ammo._a(1, (EntityLivingBase)((EntityLiving)entity));
                }
                this.shootDelay = this.type.shootDelay;
                if (!this.field_70170_p.field_72995_K) {
                    ((ItemBullet)this.ammo._a()).getEntity(this.field_70170_p, samw._a((double)((double)this.blockX + 0.5), (double)((float)this.blockY + this.type.pivotHeight), (double)((double)this.blockZ + 0.5)), (float)this.direction * 90.0f + this.field_70177_z, this.field_70125_A, (EntityLivingBase)this.gunner, this.type.bulletSpread, this.type.damage, this.ammo._j(), (InfoType)this.type);
                }
                if (this.soundDelay <= 0) {
                    if (this.type.distortSound) {
                        this.field_70146_Z.nextFloat();
                    }
                    PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)50.0, (int)this.field_71093_bK, (maaq)PacketPlaySound.buildSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.shootSound, this.type.distortSound));
                    this.soundDelay = this.type.shootSoundLength;
                }
            } else {
                if (this.gunner != null) {
                    return this.gunner.func_70097_a(pico2, f);
                }
                if (FlansMod.canBreakGuns) {
                    this.func_70106_y();
                }
            }
        }
        return true;
    }

    public boolean func_130002_c(EntityPlayer entityPlayer) {
        return false;
    }

    public void mountGun(EntityPlayer entityPlayer, boolean bl) {
        if (entityPlayer != null) {
            Side side;
            Side side2 = side = this.field_70170_p.field_72995_K ? Side.CLIENT : Side.SERVER;
            if (bl) {
                this.gunner = entityPlayer;
                FlansModPlayerHandler.getPlayerData((EntityPlayer)this.gunner, (Side)side).mountingGun = this;
            } else {
                FlansModPlayerHandler.getPlayerData((EntityPlayer)this.gunner, (Side)side).mountingGun = null;
                this.gunner = null;
            }
        }
    }

    public int findAmmo(EntityPlayer entityPlayer) {
        for (int i = 0; i < entityPlayer.field_71071_by.func_70302_i_(); ++i) {
            ieta ieta2 = entityPlayer.field_71071_by.func_70301_a(i);
            if (!this.type.isAmmo(ieta2)) continue;
            return i;
        }
        return -1;
    }

    public void func_70106_y() {
        if (this.gunner != null && FlansModPlayerHandler.getPlayerData(this.gunner) != null) {
            FlansModPlayerHandler.getPlayerData((EntityPlayer)this.gunner).mountingGun = null;
        }
        super.func_70106_y();
    }

    protected void func_70014_b(hsus hsus2) {
        hsus2._a("Type", this.type.shortName);
        if (this.ammo != null) {
            hsus2._a("AmmoID", (short)this.ammo._d);
            hsus2._a("AmmoDamage", (short)this.ammo._j());
        }
        hsus2._a("BlockX", this.blockX);
        hsus2._a("BlockY", this.blockY);
        hsus2._a("BlockZ", this.blockZ);
        hsus2._a("Dir", (byte)this.direction);
    }

    protected void func_70037_a(hsus hsus2) {
        this.type = GunType.getGun(hsus2._j("Type"));
        this.blockX = hsus2._f("BlockX");
        this.blockY = hsus2._f("BlockY");
        this.blockZ = hsus2._f("BlockZ");
        this.direction = hsus2._d("Dir");
        short s = hsus2._e("AmmoID");
        short s2 = hsus2._e("AmmoDamage");
        if (s > 0) {
            this.ammo = new ieta((int)s, 1, (int)s2);
        }
    }

    protected void func_70088_a() {
    }

    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeUTF(this.type.shortName);
        byteArrayDataOutput.writeInt(this.direction);
        byteArrayDataOutput.writeInt(this.blockX);
        byteArrayDataOutput.writeInt(this.blockY);
        byteArrayDataOutput.writeInt(this.blockZ);
        if (this.ammo != null) {
            byteArrayDataOutput.writeBoolean(true);
            byteArrayDataOutput.writeInt(this.ammo._d);
            byteArrayDataOutput.writeInt(this.ammo._j());
        } else {
            byteArrayDataOutput.writeBoolean(false);
        }
    }

    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        try {
            this.type = GunType.getGun(byteArrayDataInput.readUTF());
            this.direction = byteArrayDataInput.readInt();
            this.blockX = byteArrayDataInput.readInt();
            this.blockY = byteArrayDataInput.readInt();
            this.blockZ = byteArrayDataInput.readInt();
            if (byteArrayDataInput.readBoolean()) {
                this.ammo = new ieta(byteArrayDataInput.readInt(), 1, byteArrayDataInput.readInt());
            }
        }
        catch (Exception exception) {
            FlansMod.log("Failed to retreive gun type from server.");
            super.func_70106_y();
            exception.printStackTrace();
        }
    }

    public ieta getPickedResult(idqh idqh2) {
        ieta ieta2 = new ieta(this.type.itemID, 1, 0);
        return ieta2;
    }
}

