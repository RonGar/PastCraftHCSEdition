/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cccu
 *  ccfp
 *  com.google.common.io.ByteArrayDataInput
 *  com.google.common.io.ByteArrayDataOutput
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.common.registry.IEntityAdditionalSpawnData
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  hcsmod.cunches.IVehicle
 *  hsus
 *  ieta
 *  kjsv
 *  maaq
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.eidl
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.pico
 *  net.minecraft.util.rojd
 *  net.minecraft.util.samw
 *  zxiv
 *  zxsm
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.api.IControllable;
import co.uk.flansmods.api.IExplodeable;
import co.uk.flansmods.client.FlansModClient;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.PartType;
import co.uk.flansmods.common.RotatedAxes;
import co.uk.flansmods.common.driveables.CollisionBox;
import co.uk.flansmods.common.driveables.CollisionPoint;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.DriveablePosition;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.EntityWheel;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.driveables.Seat;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.network.PacketDriveableDamage;
import co.uk.flansmods.common.network.PacketDriveableKeyHeld;
import co.uk.flansmods.common.vector.Vector;
import co.uk.flansmods.common.vector.Vector3f;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.cunches.IVehicle;
import icbm.api.RadarRegistry;
import icbm.api.sentry.IAATarget;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.eidl;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.pico;
import net.minecraft.util.rojd;
import net.minecraft.util.samw;

public abstract class EntityDriveable
extends Entity
implements IControllable,
IExplodeable,
IEntityAdditionalSpawnData,
IVehicle,
IAATarget {
    public static ArrayList<EntityDriveable> vehiclesInClient = new ArrayList<E>();
    public static final boolean syncFromServer = true;
    public long placed = 0L;
    public int serverPositionTransitionTicker;
    public double bZ;
    public double ca;
    public double cb;
    public double serverYaw;
    public double serverPitch;
    public double serverRoll;
    public DriveableData driveableData;
    public String driveableType;
    public float throttle;
    public EntityWheel[] wheels;
    public boolean fuelling;
    public float prevRotationRoll;
    public Vector3f angularVelocity = new Vector3f(0.0f, 0.0f, 0.0f);
    public boolean leftMouseHeld = false;
    public boolean rightMouseHeld = false;
    public RotatedAxes prevAxes = new RotatedAxes();
    public RotatedAxes axes = new RotatedAxes();
    public EntitySeat[] seats;
    private boolean isAddedToClientList;

    public EntityDriveable(cuqu cuqu2) {
        super(cuqu2);
        this.field_70156_m = true;
        this.func_70105_a(1.0f, 1.0f);
        this.field_70129_M = 0.375f;
        this.field_70155_l = 128.0;
    }

    public EntityDriveable(cuqu cuqu2, DriveableType driveableType, DriveableData driveableData) {
        this(cuqu2);
        this.driveableType = driveableType.shortName;
        this.driveableData = driveableData;
    }

    protected void initType(DriveableType driveableType, boolean bl) {
        int n;
        this.seats = new EntitySeat[driveableType.numPassengers + 1];
        for (n = 0; n < driveableType.numPassengers + 1; ++n) {
            if (bl) continue;
            this.seats[n] = new EntitySeat(this.field_70170_p, this, n);
            this.field_70170_p.func_72838_d((Entity)this.seats[n]);
        }
        this.wheels = new EntityWheel[driveableType.wheelPositions.length];
        for (n = 0; n < this.wheels.length; ++n) {
            if (bl) continue;
            this.wheels[n] = new EntityWheel(this.field_70170_p, this, n);
            this.field_70170_p.func_72838_d((Entity)this.wheels[n]);
        }
        this.field_70138_W = driveableType.wheelStepHeight;
        this.field_70129_M = driveableType.yOffset;
        if (driveableType.onRadar) {
            RadarRegistry.register(this);
        }
    }

    protected void func_70088_a() {
        this.field_70180_af._a(13, (Object)"");
    }

    public String locked() {
        String string = this.field_70180_af._e(13);
        return string.isEmpty() ? null : string;
    }

    public void lock(String string) {
        this.field_70180_af._b(13, (Object)(string == null ? "" : string));
    }

    protected void func_70014_b(hsus hsus2) {
        this.driveableData.writeToNBT(hsus2);
        hsus2._a("Type", this.driveableType);
        hsus2._a("RotationYaw", this.axes.getYaw());
        hsus2._a("RotationPitch", this.axes.getPitch());
        hsus2._a("RotationRoll", this.axes.getRoll());
        hsus2._a("placed", this.placed);
        String string = this.locked();
        if (string != null) {
            hsus2._a("Locked", string);
        }
    }

    protected void func_70037_a(hsus hsus2) {
        this.driveableType = hsus2._j("Type");
        this.driveableData = new DriveableData(hsus2);
        this.initType(DriveableType.getDriveable(this.driveableType), false);
        this.placed = hsus2._g("placed");
        this.field_70126_B = hsus2._h("RotationYaw");
        this.field_70127_C = hsus2._h("RotationPitch");
        this.prevRotationRoll = hsus2._h("RotationRoll");
        this.axes = new RotatedAxes(this.field_70126_B, this.field_70127_C, this.prevRotationRoll);
        if (hsus2._c("Locked")) {
            this.lock(hsus2._j("Locked"));
        } else {
            this.lock(null);
        }
    }

    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        try {
            byteArrayDataOutput.writeUTF(this.driveableType);
            hsus hsus2 = new hsus();
            this.driveableData.writeToNBT(hsus2, false);
            zxiv._a((zxiv)hsus2, (DataOutput)byteArrayDataOutput);
            byteArrayDataOutput.writeFloat(this.axes.getYaw());
            byteArrayDataOutput.writeFloat(this.axes.getPitch());
            byteArrayDataOutput.writeFloat(this.axes.getRoll());
            byteArrayDataOutput.writeLong(this.placed);
            for (EnumDriveablePart enumDriveablePart : EnumDriveablePart.values()) {
                DriveablePart driveablePart = this.getDriveableData().parts.get((Object)enumDriveablePart);
                byteArrayDataOutput.writeShort((int)((short)driveablePart.health));
                byteArrayDataOutput.writeBoolean(driveablePart.onFire);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        try {
            this.driveableType = byteArrayDataInput.readUTF();
            this.driveableData = new DriveableData((hsus)zxiv._a((DataInput)byteArrayDataInput));
            this.initType(this.getDriveableType(), true);
            this.axes.setAngles(byteArrayDataInput.readFloat(), byteArrayDataInput.readFloat(), byteArrayDataInput.readFloat());
            this.field_70126_B = this.axes.getYaw();
            this.field_70127_C = this.axes.getPitch();
            this.prevRotationRoll = this.axes.getRoll();
            this.placed = byteArrayDataInput.readLong();
            for (EnumDriveablePart enumDriveablePart : EnumDriveablePart.values()) {
                DriveablePart driveablePart = this.getDriveableData().parts.get((Object)enumDriveablePart);
                driveablePart.health = byteArrayDataInput.readShort();
                driveablePart.onFire = byteArrayDataInput.readBoolean();
            }
        }
        catch (Exception exception) {
            FlansMod.log("Failed to retreive plane type from server.");
            super.func_70106_y();
            exception.printStackTrace();
        }
    }

    public abstract void writeUpdateData(DataOutputStream var1);

    public abstract void readUpdateData(DataInputStream var1);

    @Override
    public abstract void onMouseMoved(int var1, int var2);

    protected boolean canSit(int n) {
        return this.getDriveableType().numPassengers >= n && this.seats[n].field_70153_n == null;
    }

    protected boolean func_70041_e_() {
        return false;
    }

    public rojd func_70114_g(Entity entity) {
        return null;
    }

    public rojd func_70046_E() {
        return this.field_70121_D;
    }

    public boolean func_70104_M() {
        return false;
    }

    public double func_70042_X() {
        return -0.3;
    }

    public boolean func_70097_a(pico pico2, float f) {
        if (this.field_70170_p.field_72995_K || this.field_70128_L) {
            return true;
        }
        return true;
    }

    public void func_70106_y() {
        if (this.field_70170_p.field_72995_K) {
            if (!this.field_70128_L) {
                vehiclesInClient.remove(this);
            }
        } else if (!this.field_70128_L && this.field_70173_aa > 1) {
            this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)this.getDriveableData().parts.get((Object)EnumDriveablePart.core).maxHealth / 80.0f, false);
        }
        super.func_70106_y();
        RadarRegistry.unregister(this);
        for (EntitySeat entitySeat : this.seats) {
            if (entitySeat == null) continue;
            entitySeat.func_70106_y();
        }
        for (Entity entity : this.wheels) {
            if (entity == null) continue;
            entity.func_70106_y();
        }
    }

    public void func_70100_b_(EntityPlayer entityPlayer) {
    }

    public boolean func_70067_L() {
        return !this.field_70128_L;
    }

    public void func_70108_f(Entity entity) {
        if (!this.isPartOfThis(entity)) {
            super.func_70108_f(entity);
        }
    }

    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
        if (this.field_70173_aa > 1) {
            return;
        }
        if (!(this.field_70153_n instanceof EntityPlayer) || !FlansMod.proxy.isThePlayer((EntityPlayer)this.field_70153_n)) {
            this.serverPositionTransitionTicker = 3;
            this.bZ = d;
            this.ca = d2;
            this.cb = d3;
            this.serverYaw = f;
            this.serverPitch = f2;
        }
    }

    public void setPositionRotationAndMotion(double d, double d2, double d3, float f, float f2, float f3, double d4, double d5, double d6, float f4, float f5, float f6, float f7, float f8) {
        if (this.field_70170_p.field_72995_K) {
            this.bZ = d;
            this.ca = d2;
            this.cb = d3;
            this.serverYaw = f;
            this.serverPitch = f2;
            this.serverRoll = f3;
            this.serverPositionTransitionTicker = 2;
        } else {
            this.func_70107_b(d, d2, d3);
            this.field_70126_B = f;
            this.field_70127_C = f2;
            this.prevRotationRoll = f3;
            this.setRotation(f, f2, f3);
        }
        this.field_70159_w = d4;
        this.field_70181_x = d5;
        this.field_70179_y = d6;
        this.angularVelocity = new Vector3f(f4, f5, f6);
        this.throttle = f7;
    }

    public void func_70016_h(double d, double d2, double d3) {
        this.field_70159_w = d;
        this.field_70181_x = d2;
        this.field_70179_y = d3;
    }

    @Override
    public abstract boolean pressKey(int var1, EntityPlayer var2);

    @Override
    public void updateKeyHeldState(int n, boolean bl) {
        if (this.field_70170_p.field_72995_K) {
            PacketDispatcher.sendPacketToServer((maaq)PacketDriveableKeyHeld.buildKeyPacket(n, bl));
        }
        switch (n) {
            case 9: {
                this.leftMouseHeld = bl;
                break;
            }
            case 8: {
                this.rightMouseHeld = bl;
            }
        }
    }

    public Vector3f getLookVector(DriveablePosition driveablePosition) {
        return this.axes.getXAxis();
    }

    public void func_70071_h_() {
        boolean bl;
        super.func_70071_h_();
        if ((double)this.throttle > 0.5) {
            this.placed = System.currentTimeMillis();
        }
        if (this.field_70170_p.field_72995_K && !this.isAddedToClientList) {
            vehiclesInClient.add(this);
        }
        if (!this.field_70170_p.field_72995_K && this.placed == 0L) {
            this.placed = System.currentTimeMillis();
        }
        if (!this.field_70170_p.field_72995_K && this.placed < System.currentTimeMillis() - 86400000L) {
            this.func_70106_y();
            return;
        }
        DriveableType driveableType = this.getDriveableType();
        if (!this.field_70170_p.field_72995_K) {
            int n;
            for (n = 0; n < this.getDriveableType().numPassengers + 1; ++n) {
                if (this.seats[n] != null && this.seats[n].field_70175_ag) continue;
                this.seats[n] = new EntitySeat(this.field_70170_p, this, n);
                this.field_70170_p.func_72838_d((Entity)this.seats[n]);
            }
            for (n = 0; n < driveableType.wheelPositions.length; ++n) {
                if (this.wheels[n] != null && this.wheels[n].field_70175_ag) continue;
                this.wheels[n] = new EntityWheel(this.field_70170_p, this, n);
                this.field_70170_p.func_72838_d((Entity)this.wheels[n]);
            }
            if (this.field_70171_ac) {
                --this.getDriveableData().parts.get((Object)EnumDriveablePart.core).health;
            }
        }
        for (DriveablePart driveablePart : this.getDriveableData().parts.values()) {
            Vector3f vector3f;
            if (driveablePart.box == null) continue;
            driveablePart.update(this);
            if (this.field_70170_p.field_72995_K) {
                if (driveablePart.onFire) {
                    vector3f = this.axes.findLocalVectorGlobally(new Vector3f((float)driveablePart.box.x / 16.0f + this.field_70146_Z.nextFloat() * (float)driveablePart.box.w / 16.0f, (float)driveablePart.box.y / 16.0f + this.field_70146_Z.nextFloat() * (float)driveablePart.box.h / 16.0f, (float)driveablePart.box.z / 16.0f + this.field_70146_Z.nextFloat() * (float)driveablePart.box.d / 16.0f));
                    this.field_70170_p.func_72869_a("flame", this.field_70165_t + (double)vector3f.x, this.field_70163_u + (double)vector3f.y, this.field_70161_v + (double)vector3f.z, 0.0, 0.0, 0.0);
                }
                if (driveablePart.health > 0 && driveablePart.health < driveablePart.maxHealth / 4) {
                    vector3f = this.axes.findLocalVectorGlobally(new Vector3f((float)driveablePart.box.x / 16.0f + this.field_70146_Z.nextFloat() * (float)driveablePart.box.w / 16.0f, (float)driveablePart.box.y / 16.0f + this.field_70146_Z.nextFloat() * (float)driveablePart.box.h / 16.0f, (float)driveablePart.box.z / 16.0f + this.field_70146_Z.nextFloat() * (float)driveablePart.box.d / 16.0f));
                    this.field_70170_p.func_72869_a(driveablePart.health < driveablePart.maxHealth / 8 ? "flame" : "flame", this.field_70165_t + (double)vector3f.x, this.field_70163_u + (double)vector3f.y, this.field_70161_v + (double)vector3f.z, 0.0, 0.0, 0.0);
                }
                if (driveablePart.type == EnumDriveablePart.backRightWheel && this.seats != null && this.seats[0] != null && this.seats[0].field_70153_n != null) {
                    vector3f = this.axes.findLocalVectorGlobally(new Vector3f((double)((float)driveablePart.box.x / 16.0f + this.field_70146_Z.nextFloat() * (float)driveablePart.box.w / 16.0f) - 0.85, 0.0, (double)((float)driveablePart.box.z / 40.0f + this.field_70146_Z.nextFloat() * (float)driveablePart.box.d / 40.0f)));
                    int n = 1 + (int)(Math.abs(this.throttle) * 4.0f);
                    float f = this.axes.getYaw() / 180.0f * 3.1415927f;
                    for (int i = 0; i < n; ++i) {
                        float f2 = (float)i / (float)n;
                        double d = this.field_70165_t - this.field_70169_q;
                        double d2 = this.field_70161_v - this.field_70166_s;
                        this.field_70170_p.func_72869_a("smoke", this.field_70169_q + d * (double)f2 + (double)vector3f.x, this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)f2 + (double)vector3f.y, this.field_70166_s + d2 * (double)f2 + (double)vector3f.z, (double)(-dwbg._b((float)f)) * 0.1 + d * 0.75, -0.05, (double)(-dwbg._a((float)f)) * 0.1 + d2 * 0.75);
                    }
                }
            }
            if (driveablePart.onFire) {
                if (this.field_70170_p.func_72896_J() && this.field_70146_Z.nextInt(40) == 0) {
                    driveablePart.onFire = false;
                }
                vector3f = this.axes.findLocalVectorGlobally(new Vector3f((float)driveablePart.box.x / 16.0f + (float)driveablePart.box.w / 32.0f, (float)driveablePart.box.y / 16.0f + (float)driveablePart.box.h / 32.0f, (float)driveablePart.box.z / 16.0f + (float)driveablePart.box.d / 32.0f));
                if (this.field_70170_p.func_72803_f(dwbg._c((double)(this.field_70165_t + (double)vector3f.x)), dwbg._c((double)(this.field_70163_u + (double)vector3f.y)), dwbg._c((double)(this.field_70161_v + (double)vector3f.z))) != ccfp._h) continue;
                driveablePart.onFire = false;
                continue;
            }
            vector3f = this.axes.findLocalVectorGlobally(new Vector3f((float)driveablePart.box.x / 16.0f + (float)driveablePart.box.w / 32.0f, (float)driveablePart.box.y / 16.0f + (float)driveablePart.box.h / 32.0f, (float)driveablePart.box.z / 16.0f + (float)driveablePart.box.d / 32.0f));
            if (this.field_70170_p.func_72803_f(dwbg._c((double)(this.field_70165_t + (double)vector3f.x)), dwbg._c((double)(this.field_70163_u + (double)vector3f.y)), dwbg._c((double)(this.field_70161_v + (double)vector3f.z))) != ccfp._i) continue;
            driveablePart.onFire = true;
        }
        for (DriveablePart driveablePart : this.getDriveableData().parts.values()) {
            if (driveablePart == null || driveablePart.health >= 0) continue;
            driveablePart.health = 0;
        }
        for (DriveablePart driveablePart : this.getDriveableData().parts.values()) {
            if (!driveablePart.dead) continue;
            this.throttle = 0.0f;
        }
        this.checkParts();
        this.field_70126_B = this.axes.getYaw();
        this.field_70127_C = this.axes.getPitch();
        this.prevRotationRoll = this.axes.getRoll();
        this.prevAxes = this.axes.clone();
        boolean bl2 = bl = this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ._d || this.driveableData.fuelInTank > 0.0f;
        if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
            this.field_70153_n = null;
        }
        if (this.field_70153_n != null && this.field_70128_L) {
            this.field_70153_n.func_70078_a(null);
        }
        if (this.field_70153_n != null) {
            this.field_70153_n.field_70143_R = 0.0f;
        }
        if (this.seats[0] != null && this.seats[0].field_70153_n == null || !bl) {
            this.throttle *= 0.98f;
            this.leftMouseHeld = false;
            this.rightMouseHeld = false;
        }
    }

    protected void func_70069_a(float f) {
        if (f <= 0.0f) {
            return;
        }
        super.func_70069_a(f);
        int n = dwbg._f((float)(f - 3.0f));
        if (n > 0) {
            if (n > 4) {
                this.func_85030_a("damage.fallbig", 1.0f, 1.0f);
            } else {
                this.func_85030_a("damage.fallsmall", 1.0f, 1.0f);
            }
            this.func_70097_a(pico.field_76379_h, n);
            int n2 = this.field_70170_p.func_72798_a(dwbg._c((double)this.field_70165_t), dwbg._c((double)(this.field_70163_u - 0.20000000298023224 - (double)this.field_70129_M)), dwbg._c((double)this.field_70161_v));
            if (n2 > 0) {
                cccu cccu2 = kjsv.field_71973_m[n2].field_72020_cn;
                this.func_85030_a(cccu2._d(), cccu2._a() * 0.5f, cccu2._b() * 0.75f);
            }
        }
    }

    public Vector3f rotate(Vector3f vector3f) {
        return this.axes.findLocalVectorGlobally(vector3f);
    }

    public Vector3f rotate(samw samw2) {
        return this.rotate(samw2._c, samw2._d, samw2._e);
    }

    public Vector3f rotate(double d, double d2, double d3) {
        return this.rotate(new Vector3f((float)d, (float)d2, (float)d3));
    }

    public void rotateYaw(float f) {
        if (Math.abs(f) < 0.01f) {
            return;
        }
        this.axes.rotateLocalYaw(f);
        this.updatePrevAngles();
    }

    public void rotatePitch(float f) {
        if (Math.abs(f) < 0.01f) {
            return;
        }
        this.axes.rotateLocalPitch(f);
        this.updatePrevAngles();
    }

    public void rotateRoll(float f) {
        if (Math.abs(f) < 0.01f) {
            return;
        }
        this.axes.rotateLocalRoll(f);
        this.updatePrevAngles();
    }

    public void updatePrevAngles() {
        double d;
        double d2;
        double d3 = this.axes.getYaw() - this.field_70126_B;
        if (d3 > 180.0) {
            this.field_70126_B += 360.0f;
        }
        if (d3 < -180.0) {
            this.field_70126_B -= 360.0f;
        }
        if ((d = (double)(this.axes.getPitch() - this.field_70127_C)) > 180.0) {
            this.field_70127_C += 360.0f;
        }
        if (d < -180.0) {
            this.field_70127_C -= 360.0f;
        }
        if ((d2 = (double)(this.axes.getRoll() - this.prevRotationRoll)) > 180.0) {
            this.prevRotationRoll += 360.0f;
        }
        if (d2 < -180.0) {
            this.prevRotationRoll -= 360.0f;
        }
    }

    public void setRotation(float f, float f2, float f3) {
        this.axes.setAngles(f, f2, f3);
    }

    public boolean isPartOfThis(Entity entity) {
        for (EntitySeat entitySeat : this.seats) {
            if (entitySeat == null) continue;
            if (entity == entitySeat) {
                return true;
            }
            if (entitySeat.field_70153_n != entity) continue;
            return true;
        }
        return entity == this;
    }

    public float func_70053_R() {
        return 0.0f;
    }

    public DriveableType getDriveableType() {
        return DriveableType.getDriveable(this.driveableType);
    }

    public DriveableData getDriveableData() {
        return this.driveableData;
    }

    @Override
    public boolean isDead() {
        return this.field_70128_L;
    }

    @Override
    public Entity getControllingEntity() {
        return this.seats[0].getControllingEntity();
    }

    public ieta getPickedResult(idqh idqh2) {
        ieta ieta2 = new ieta(this.getDriveableType().itemID, 1, 0);
        ieta2._e = new hsus();
        this.driveableData.writeToNBT(ieta2._e);
        return ieta2;
    }

    public boolean hasFuel() {
        if (this.seats == null || this.seats[0] == null || this.seats[0].field_70153_n == null) {
            return false;
        }
        if (this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ._d) {
            return true;
        }
        return this.driveableData.fuelInTank > 0.0f;
    }

    public boolean hasEnoughFuel() {
        if (this.seats == null || this.seats[0] == null || this.seats[0].field_70153_n == null) {
            return false;
        }
        if (this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ._d) {
            return true;
        }
        return this.driveableData.fuelInTank > this.driveableData.engine.fuelConsumption * this.throttle;
    }

    public double getSpeedXYZ() {
        return Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
    }

    public double getSpeedXZ() {
        return Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
    }

    public double getKineticEnergy() {
        return 0.5 * (double)this.getDriveableType().mass * this.getSpeedXYZ();
    }

    public void CheckCollisonsTSAD() {
        ArrayList<E> arrayList;
        int n;
        kjsv kjsv2;
        int n2;
        Vector3f vector3f;
        int n3;
        int n4;
        DriveableType driveableType = this.getDriveableType();
        for (CollisionPoint collisionPoint : driveableType.points) {
            if (!this.isPartIntact(collisionPoint.part) || EnumDriveablePart.isWheel(collisionPoint.part) && !this.gearDown()) continue;
            vector3f = this.axes.findLocalVectorGlobally(collisionPoint.getLocalVector());
            n3 = dwbg._c((double)(this.field_70165_t + (double)vector3f.x));
            n4 = this.field_70170_p.func_72798_a(n3, n = dwbg._c((double)(this.field_70163_u + (double)vector3f.y)), n2 = dwbg._c((double)(this.field_70161_v + (double)vector3f.z)));
            if (n4 <= 0) continue;
            kjsv2 = kjsv.field_71973_m[n4];
            arrayList = new ArrayList<E>();
            kjsv2.func_71871_a(this.field_70170_p, n3, n, n2, rojd.func_72330_a((double)(this.field_70165_t + (double)vector3f.x), (double)(this.field_70163_u + (double)vector3f.y), (double)(this.field_70161_v + (double)vector3f.z), (double)(this.field_70165_t + (double)vector3f.x), (double)(this.field_70163_u + (double)vector3f.y), (double)(this.field_70161_v + (double)vector3f.z)), arrayList, (Entity)this);
        }
        for (CollisionPoint collisionPoint : driveableType.points) {
            if (!this.isPartIntact(collisionPoint.part) || EnumDriveablePart.isWheel(collisionPoint.part) && !this.gearDown()) continue;
            vector3f = this.axes.findLocalVectorGlobally(collisionPoint.getLocalVector());
            n3 = dwbg._c((double)(this.field_70165_t + (double)vector3f.x));
            n4 = this.field_70170_p.func_72798_a(n3, n = dwbg._c((double)(this.field_70163_u + (double)vector3f.y)), n2 = dwbg._c((double)(this.field_70161_v + (double)vector3f.z)));
            if (n4 <= 0) continue;
            kjsv2 = kjsv.field_71973_m[n4];
            arrayList = new ArrayList<E>();
            kjsv2.func_71871_a(this.field_70170_p, n3, n, n2, rojd.func_72330_a((double)(this.field_70165_t + (double)vector3f.x), (double)(this.field_70163_u + (double)vector3f.y), (double)(this.field_70161_v + (double)vector3f.z), (double)(this.field_70165_t + (double)vector3f.x), (double)(this.field_70163_u + (double)vector3f.y), (double)(this.field_70161_v + (double)vector3f.z)), arrayList, (Entity)this);
            if (arrayList.size() <= 0) continue;
            rojd rojd2 = (rojd)arrayList.get(0);
            double d = Math.abs(this.field_70165_t + (double)vector3f.x - rojd2.field_72340_a);
            double d2 = Math.abs(this.field_70165_t + (double)vector3f.x - rojd2.field_72336_d);
            double d3 = Math.abs(this.field_70163_u + (double)vector3f.y - rojd2.field_72338_b);
            double d4 = Math.abs(this.field_70163_u + (double)vector3f.y - rojd2.field_72337_e);
            double d5 = Math.abs(this.field_70161_v + (double)vector3f.z - rojd2.field_72339_c);
            double d6 = Math.abs(this.field_70161_v + (double)vector3f.z - rojd2.field_72334_f);
            Math.min(d3, d4);
            if (collisionPoint.part.getShortName().endsWith("Wheel")) continue;
            double d7 = 0.0;
            double d8 = Math.min(Math.min(d, d2), Math.min(d5, d6));
            if (Math.abs(d - d8) < 9.999999747378752E-6 && !this.field_70170_p.func_72804_r(n3 - 1, n, n2)) {
                d7 = 0.0 + (double)(this.throttle * 10.0f);
            } else if (Math.abs(d2 - d8) < 9.999999747378752E-6 && !this.field_70170_p.func_72804_r(n3 + 1, n, n2)) {
                d7 = 0.0 + (double)(this.throttle * 10.0f);
            } else if (Math.abs(d5 - d8) < 9.999999747378752E-6 && !this.field_70170_p.func_72804_r(n3, n, n2 - 1)) {
                d7 = 0.0 + (double)(this.throttle * 10.0f);
            } else if (Math.abs(d6 - d8) < 9.999999747378752E-6 && !this.field_70170_p.func_72804_r(n3, n, n2 + 1)) {
                d7 = 0.0 + (double)(this.throttle * 10.0f);
            }
            if (this.field_70170_p.field_72995_K || !(d7 > 5.0)) continue;
            this.getDriveableData().parts.get((Object)EnumDriveablePart.frontLeftWheel).health -= Math.abs(this.field_70146_Z.nextInt((int)d7));
            this.getDriveableData().parts.get((Object)EnumDriveablePart.frontRightWheel).health -= Math.abs(this.field_70146_Z.nextInt((int)d7));
            this.getDriveableData().parts.get((Object)EnumDriveablePart.core).health -= Math.abs(this.field_70146_Z.nextInt((int)(d7 * 0.5)));
            PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)100.0, (int)this.field_71093_bK, (maaq)PacketDriveableDamage.buildUpdatePacket(this));
        }
        this.checkParts();
    }

    public void applyForce(Vector3f vector3f, Vector3f vector3f2) {
        this.applyTranslationalForce(vector3f, vector3f2);
        this.applyRotationalForce(vector3f, vector3f2);
    }

    public void applyRotationalForce(Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3 = Vector3f.cross((Vector3f)vector3f2.scale(1.0f), vector3f, null);
        this.applyTorque(vector3f3);
    }

    public void applyTorque(Vector3f vector3f) {
        this.landVehicle();
        if ((double)Math.abs(this.throttle) > 0.025) {
            Vector3f.add(this.angularVelocity, (Vector3f)vector3f.scale((this.throttle > 0.0f ? 0.1f : -0.1f) + this.throttle * 0.5f), this.angularVelocity);
        }
    }

    public void applyTranslationalForce(Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3 = (Vector3f)vector3f2.scale(1.0f / this.getDriveableType().mass);
        this.field_70159_w += (double)(vector3f3.x * 0.05f);
        this.field_70181_x += (double)(vector3f3.y * 0.05f);
        this.field_70179_y += (double)(vector3f3.z * 0.05f);
    }

    public boolean landVehicle() {
        return false;
    }

    public boolean gearDown() {
        return true;
    }

    public boolean onGround() {
        return this.field_70122_E;
    }

    public boolean attackPoint(CollisionPoint collisionPoint, pico pico2, float f) {
        return false;
    }

    public String attackFromBullet(EntityBullet entityBullet, Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3 = Vector3f.sub(vector3f, new Vector3f((float)this.field_70165_t, (float)this.field_70163_u, (float)this.field_70161_v), null);
        Vector3f vector3f4 = this.axes.findGlobalVectorLocally(vector3f3);
        Vector3f vector3f5 = this.axes.findGlobalVectorLocally(vector3f2);
        for (DriveablePart driveablePart : this.getDriveableData().parts.values()) {
            if (driveablePart.type == EnumDriveablePart.leftTrack || driveablePart.type == EnumDriveablePart.rightTrack || !driveablePart.rayTrace(this, entityBullet, vector3f4, vector3f5)) continue;
            if (this.field_70170_p.field_72995_K) {
                return driveablePart.type.getShortName();
            }
            this.checkParts();
            PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)100.0, (int)this.field_71093_bK, (maaq)PacketDriveableDamage.buildUpdatePacket(this));
            return driveablePart.type.getShortName();
        }
        return null;
    }

    public DriveablePart raytraceParts(Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3 = Vector3f.sub(vector3f, new Vector3f((float)this.field_70165_t, (float)this.field_70163_u, (float)this.field_70161_v), null);
        this.axes.findGlobalVectorLocally(vector3f3);
        this.axes.findGlobalVectorLocally(vector3f2);
        Iterator<DriveablePart> iterator = this.getDriveableData().parts.values().iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        return null;
    }

    public boolean canHitPart(EnumDriveablePart enumDriveablePart) {
        return true;
    }

    public void checkParts() {
        for (DriveablePart driveablePart : this.getDriveableData().parts.values()) {
            if (driveablePart == null || driveablePart.dead || driveablePart.health > 0 || driveablePart.maxHealth <= 0 || driveablePart.type == EnumDriveablePart.leftTrack || driveablePart.type == EnumDriveablePart.rightTrack) continue;
            this.killPart(driveablePart);
        }
        if (this.getDriveableData().parts.get((Object)EnumDriveablePart.core).dead) {
            this.func_70106_y();
        }
    }

    private void killPart(DriveablePart driveablePart) {
        if (driveablePart.dead) {
            return;
        }
        driveablePart.health = 0;
        driveablePart.dead = true;
        for (EnumDriveablePart enumDriveablePart : driveablePart.type.getChildren()) {
            this.killPart(this.getDriveableData().parts.get((Object)((Object)enumDriveablePart)));
        }
    }

    protected abstract void dropItemsOnPartDeath(Vector3f var1, DriveablePart var2);

    @Override
    public float getPlayerRoll() {
        return this.axes.getRoll();
    }

    @Override
    public void explode() {
    }

    @Override
    public float getCameraDistance() {
        return this.getDriveableType().cameraDistance;
    }

    public boolean isPartIntact(EnumDriveablePart enumDriveablePart) {
        return this.getDriveableData().parts.get((Object)enumDriveablePart).maxHealth == 0 || this.getDriveableData().parts.get((Object)enumDriveablePart).health > 0;
    }

    public abstract boolean hasMouseControlMode();

    public abstract String getBombInventoryName();

    public boolean rotateWithTurret(Seat seat) {
        return seat.part == EnumDriveablePart.turret;
    }

    public String func_70023_ak() {
        return this.getDriveableType().name;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean showInventory(int n) {
        return n == 0 ? !FlansModClient.controlModeMouse : true;
    }

    @Override
    public void destroyCraft() {
    }

    @Override
    public int doDamage(int n) {
        int n2;
        DriveableType driveableType = this.getDriveableType();
        n *= 5;
        n = (int)((float)n / driveableType.mass);
        DriveablePart driveablePart = this.getDriveableData().parts.get((Object)((Object)EnumDriveablePart.core));
        if (this.field_70170_p.field_72995_K) {
            return driveablePart.health;
        }
        DriveablePart driveablePart2 = null;
        DriveablePart[] arrdriveablePart = this.getDriveableData().parts.values().toArray(new DriveablePart[0]);
        while (driveablePart2 == null) {
            n2 = this.field_70170_p.field_73012_v.nextInt(this.getDriveableData().parts.size());
            driveablePart2 = arrdriveablePart[n2];
            if (!driveablePart2.dead) continue;
            driveablePart2 = null;
        }
        n2 = n / 8;
        driveablePart.health -= n2;
        driveablePart2.health -= n - n2;
        this.checkParts();
        PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)100.0, (int)this.field_71093_bK, (maaq)PacketDriveableDamage.buildUpdatePacket(this));
        return driveablePart.health;
    }

    @Override
    public boolean canBeTargeted(Object object) {
        DriveableType driveableType = this.getDriveableType();
        if (driveableType.onRadar && FlansMod.isICBMSentryLoaded) {
            try {
                Class<?> class_ = Class.forName("icbm.sentry.turret.TileEntityTurret");
                Class<?> class_2 = Class.forName("icbm.sentry.terminal.TileEntityTerminal");
                if (class_.isInstance(object)) {
                    Method method = class_.getMethod("getPlatform", new Class[0]);
                    Method method2 = class_2.getMethod("canUserAccess", String.class);
                    Object object2 = method.invoke(object, new Object[0]);
                    boolean bl = true;
                    for (int i = 0; i < this.seats.length; ++i) {
                        if (this.seats[i].field_70153_n == null || !(this.seats[i].field_70153_n instanceof EntityPlayerMP)) continue;
                        bl = false;
                        Boolean bl2 = (Boolean)method2.invoke(object2, ((EntityPlayerMP)this.seats[i].field_70153_n).field_71092_bJ);
                        if (!bl2.booleanValue()) continue;
                        return false;
                    }
                    if (bl) {
                        return false;
                    }
                }
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (NoSuchMethodException noSuchMethodException) {
                noSuchMethodException.printStackTrace();
            }
            catch (SecurityException securityException) {
                securityException.printStackTrace();
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
            }
            catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public String vehName() {
        return this.driveableType;
    }

    public void setDriver(EntityPlayer entityPlayer) {
        entityPlayer.func_70078_a((Entity)this.seats[0]);
    }

    public boolean hasDriver() {
        if (this.seats == null) {
            return false;
        }
        for (EntitySeat entitySeat : this.seats) {
            if (entitySeat == null || entitySeat.field_70153_n == null) continue;
            return true;
        }
        return false;
    }

    public Entity entity() {
        return this;
    }
}

