/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cuqu
 *  hcsmod.HCS
 *  hrvk
 *  hsus
 *  ieta
 *  ifck
 *  jhvs
 *  maaq
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.pico
 *  net.minecraft.util.samw
 *  rojd
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.api.IExplodeable;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansHooks;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.ItemPart;
import co.uk.flansmods.common.PartType;
import co.uk.flansmods.common.RotatedAxes;
import co.uk.flansmods.common.driveables.CollisionBox;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.DriveablePosition;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.EntityWheel;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.driveables.PilotGun;
import co.uk.flansmods.common.driveables.VehicleType;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemBullet;
import co.uk.flansmods.common.network.PacketDriveableDamage;
import co.uk.flansmods.common.network.PacketPlaySound;
import co.uk.flansmods.common.network.PacketVehicleControl;
import co.uk.flansmods.common.network.PacketVehicleKey;
import co.uk.flansmods.common.vector.Vector;
import co.uk.flansmods.common.vector.Vector3f;
import cpw.mods.fml.common.network.PacketDispatcher;
import hcsmod.HCS;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidl;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.pico;
import net.minecraft.util.samw;

public class EntityVehicle
extends EntityDriveable
implements IExplodeable {
    public int shellDelay;
    public int gunDelay;
    public int soundPosition;
    public float wheelsYaw;
    private int ticksSinceUsed = 0;
    public boolean varDoor;
    public float wheelsAngle;
    public int toggleTimer = 0;
    public boolean wasthrootlepress;
    public boolean engineInitialized = false;
    public int engineStarted = 0;
    public float yaw = 0.0f;
    public float pitch = 0.0f;
    public float roll = 0.0f;

    public EntityVehicle(cuqu cuqu2) {
        super(cuqu2);
    }

    public EntityVehicle(cuqu cuqu2, double d, double d2, double d3, VehicleType vehicleType, DriveableData driveableData) {
        super(cuqu2, vehicleType, driveableData);
        this.field_70138_W = 1.5f;
        this.func_70107_b(d, d2, d3);
        this.initType(vehicleType, false);
    }

    public EntityVehicle(cuqu cuqu2, double d, double d2, double d3, EntityPlayer entityPlayer, VehicleType vehicleType, DriveableData driveableData) {
        this(cuqu2, d, d2, d3, vehicleType, driveableData);
        this.rotateYaw(entityPlayer.field_70177_z + 90.0f);
    }

    @Override
    protected void func_70014_b(hsus hsus2) {
        super.func_70014_b(hsus2);
        hsus2._a("VarDoor", this.varDoor);
    }

    @Override
    protected void func_70037_a(hsus hsus2) {
        super.func_70037_a(hsus2);
        this.varDoor = hsus2._o("VarDoor");
    }

    @Override
    public void writeUpdateData(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeBoolean(this.varDoor);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public void readUpdateData(DataInputStream dataInputStream) {
        if (!this.engineInitialized && this.throttle > 0.0f) {
            this.engineStarted = 1337;
        }
        this.engineInitialized = true;
        try {
            this.varDoor = dataInputStream.readBoolean();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public void onMouseMoved(int n, int n2) {
    }

    @Override
    public void setPositionRotationAndMotion(double d, double d2, double d3, float f, float f2, float f3, double d4, double d5, double d6, float f4, float f5, float f6, float f7, float f8) {
        super.setPositionRotationAndMotion(d, d2, d3, f, f2, f3, d4, d5, d6, f4, f5, f6, f7, f8);
        this.wheelsYaw = f8;
    }

    public boolean func_130002_c(EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public boolean pressKey(int n, EntityPlayer entityPlayer) {
        VehicleType vehicleType = this.getVehicleType();
        if (this.field_70170_p.field_72995_K && (n == 6 || n == 8 || n == 9)) {
            PacketDispatcher.sendPacketToServer((maaq)PacketVehicleKey.buildKeyPacket(n));
            return true;
        }
        switch (n) {
            case 0: {
                if (this.throttle < 0.0f) {
                    this.throttle = 0.0f;
                }
                this.throttle += 0.02f;
                this.wasthrootlepress = true;
                if (this.throttle > 1.0f) {
                    this.throttle = 1.0f;
                }
                return true;
            }
            case 1: {
                this.wasthrootlepress = true;
                if (this.throttle > 0.0f && this.throttle <= 0.4f) {
                    this.throttle = 0.0f;
                }
                this.throttle -= this.throttle < 0.0f ? 0.1f : 0.02f;
                if (this.throttle < -1.0f) {
                    this.throttle = -1.0f;
                }
                if (this.throttle < 0.0f && vehicleType.maxNegativeThrottle == 0.0f) {
                    this.throttle = 0.0f;
                }
                return true;
            }
            case 2: {
                this.wheelsYaw -= 1.0f;
                return true;
            }
            case 3: {
                this.wheelsYaw += 1.0f;
                return true;
            }
            case 4: {
                float f;
                this.throttle *= 0.75f;
                if (Math.abs(f) < 0.1f) {
                    this.throttle = 0.0f;
                }
                return true;
            }
            case 5: {
                return true;
            }
            case 6: {
                this.seats[0].field_70153_n.func_70078_a(null);
                return true;
            }
            case 7: {
                if (this.field_70170_p.field_72995_K) {
                    FlansMod.proxy.openDriveableMenu((EntityPlayer)this.seats[0].field_70153_n, this.field_70170_p, this);
                }
                return true;
            }
            case 8: {
                if (!this.field_70170_p.field_72995_K && this.gunDelay <= 0 && FlansMod.bulletsEnabled) {
                    for (PilotGun pilotGun : this.getDriveableType().guns) {
                        BulletType bulletType;
                        GunType gunType = pilotGun.type;
                        ieta ieta2 = this.driveableData.ammo[this.getDriveableType().numPassengerGunners + pilotGun.gunID];
                        if (gunType == null || ieta2 == null || !(ieta2._a() instanceof ItemBullet) || !gunType.isAmmo(bulletType = ((ItemBullet)ieta2._a()).type)) continue;
                        Vector3f vector3f = pilotGun.position;
                        Vector3f vector3f2 = this.axes.getXAxis();
                        if (pilotGun.driveablePart == EnumDriveablePart.turret) {
                            vector3f = this.seats[0].looking.findLocalVectorGlobally(vector3f);
                            vector3f2 = this.axes.findLocalVectorGlobally(this.seats[0].looking.getXAxis());
                        }
                        Vector3f vector3f3 = this.rotate(vector3f);
                        ((ItemBullet)ieta2._a()).getEntity(this.field_70170_p, Vector3f.add(vector3f3, new Vector3f((float)this.field_70165_t, (float)this.field_70163_u, (float)this.field_70161_v), null), vector3f2, (EntityLivingBase)((EntityLiving)this.field_70153_n), gunType.bulletSpread / 2.0f, gunType.damage, 2.0f, ieta2._j(), (InfoType)vehicleType);
                        PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)50.0, (int)this.field_71093_bK, (maaq)PacketPlaySound.buildSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, vehicleType.shootMainSound, false));
                        int n2 = ieta2._j();
                        ieta2._b(n2 + 1);
                        if (n2 + 1 == ieta2._k()) {
                            ieta2._b(0);
                            if (!((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ._d) {
                                --ieta2._b;
                                if (ieta2._b <= 0) {
                                    ieta2 = null;
                                }
                                this.driveableData.func_70299_a(this.getDriveableType().numPassengerGunners + pilotGun.gunID, ieta2);
                            }
                        }
                        this.gunDelay = vehicleType.vehicleShootDelay;
                    }
                    return true;
                }
                return false;
            }
            case 9: {
                if (!this.field_70170_p.field_72995_K && this.shellDelay <= 0 && FlansMod.bombsEnabled) {
                    int n3 = -1;
                    for (int i = this.driveableData.getBombInventoryStart(); i < this.driveableData.getBombInventoryStart() + vehicleType.numBombSlots; ++i) {
                        ieta ieta3 = this.driveableData.func_70301_a(i);
                        if (ieta3 == null || !(ieta3._a() instanceof ItemBullet) || !((ItemBullet)ieta3._a()).type.isShell) continue;
                        n3 = i;
                    }
                    if (n3 != -1) {
                        ((ItemBullet)this.driveableData.func_70301_a(n3)._a()).getEntity(this.field_70170_p, Vector3f.add(new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v), this.rotate(vehicleType.barrelPosition), null), this.rotate(this.seats[0].looking.getXAxis()), (EntityLivingBase)this.seats[0].field_70153_n, 0.0f, 1.0f, 3.0f, this.driveableData.func_70301_a(n3)._j(), (InfoType)vehicleType);
                        if (vehicleType.shootSecondarySound != null) {
                            PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)50.0, (int)this.field_71093_bK, (maaq)PacketPlaySound.buildSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, vehicleType.shootSecondarySound, false));
                        }
                        if (!((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ._d) {
                            this.driveableData.func_70298_a(n3, 1);
                        }
                        this.shellDelay = vehicleType.vehicleShellDelay;
                    }
                    return true;
                }
                return false;
            }
            case 10: {
                return true;
            }
            case 11: {
                return true;
            }
            case 12: {
                return true;
            }
            case 13: {
                return true;
            }
            case 14: {
                if (this.toggleTimer <= 0) {
                    boolean bl = this.varDoor = !this.varDoor;
                    if (vehicleType.hasDoor) {
                        entityPlayer.func_71035_c("Doors " + (this.varDoor ? "open" : "closed"));
                    }
                    this.toggleTimer = 10;
                    PacketDispatcher.sendPacketToServer((maaq)PacketVehicleControl.buildUpdatePacket(this));
                }
                return true;
            }
            case 15: {
                return true;
            }
            case 16: {
                this.applyTorque(new Vector3f(this.axes.getRoll() / 10.0f, 0.0f, 0.0f));
                return true;
            }
        }
        return false;
    }

    @Override
    public Vector3f getLookVector(DriveablePosition driveablePosition) {
        return this.rotate(this.seats[0].looking.getXAxis());
    }

    private Vector3f findGround(Vector3f vector3f) {
        samw samw2;
        samw samw3 = samw._a((double)((double)vector3f.x + this.field_70165_t), (double)(this.field_70163_u + 1.0), (double)((double)vector3f.z + this.field_70161_v));
        idqh idqh2 = this.field_70170_p.func_72831_a(samw3, samw2 = samw._a((double)((double)vector3f.x + this.field_70165_t), (double)(this.field_70163_u - 3.0), (double)((double)vector3f.z + this.field_70161_v)), false, true);
        if (idqh2 != null) {
            vector3f.x = (float)idqh2._f._c;
            vector3f.y = (float)idqh2._f._d;
            vector3f.z = (float)idqh2._f._e;
        } else {
            vector3f.y = (float)this.field_70163_u;
        }
        return vector3f;
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        try {
            super.func_70071_h_();
            if (!this.wasthrootlepress) {
                if (this.throttle > 0.4f) {
                    this.throttle -= 0.02f;
                }
                if (this.throttle < 0.0f) {
                    this.throttle = 0.0f;
                }
            }
            this.wasthrootlepress = false;
            VehicleType vehicleType = this.getVehicleType();
            DriveableData driveableData = this.getDriveableData();
            if (vehicleType == null) {
                FlansMod.log("Vehicle type null. Not ticking vehicle");
            } else {
                Object object;
                float f;
                boolean bl = this.field_70170_p.field_72995_K && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)this.seats[0].field_70153_n);
                ++this.ticksSinceUsed;
                if (!this.field_70170_p.field_72995_K && this.seats[0].field_70153_n != null) {
                    this.ticksSinceUsed = 0;
                }
                if (!this.field_70170_p.field_72995_K && FlansMod.vehicleLife > 0 && this.ticksSinceUsed > FlansMod.vehicleLife * 20) {
                    this.func_70106_y();
                }
                if (this.shellDelay > 0) {
                    --this.shellDelay;
                }
                if (this.gunDelay > 0) {
                    --this.gunDelay;
                }
                if (this.toggleTimer > 0) {
                    --this.toggleTimer;
                }
                if (this.soundPosition > 0) {
                    --this.soundPosition;
                }
                if (this.hasEnoughFuel()) {
                    this.wheelsAngle += this.throttle / 2.0f;
                }
                this.wheelsYaw *= 0.9f;
                if (this.wheelsYaw > 20.0f) {
                    this.wheelsYaw = 20.0f;
                }
                if (this.wheelsYaw < -20.0f) {
                    this.wheelsYaw = -20.0f;
                }
                if (this.field_70170_p.field_72995_K && !bl && this.serverPositionTransitionTicker > 0) {
                    double d = this.bZ;
                    double d2 = this.field_70163_u + (this.ca - this.field_70163_u) / (double)this.serverPositionTransitionTicker;
                    double d3 = this.cb;
                    double d4 = dwbg._f((double)(this.serverYaw - (double)this.axes.getYaw()));
                    double d5 = dwbg._f((double)(this.serverPitch - (double)this.axes.getPitch()));
                    double d6 = dwbg._f((double)(this.serverRoll - (double)this.axes.getRoll()));
                    this.field_70177_z = (float)((double)this.axes.getYaw() + d4 / (double)this.serverPositionTransitionTicker);
                    this.field_70125_A = (float)((double)this.axes.getPitch() + d5 / (double)this.serverPositionTransitionTicker);
                    f = (float)((double)this.axes.getRoll() + d6 / (double)this.serverPositionTransitionTicker);
                    --this.serverPositionTransitionTicker;
                    this.func_70107_b(d, d2, d3);
                    this.setRotation(this.field_70177_z, this.field_70125_A, f);
                }
                if (this.field_70170_p.field_72995_K && this.field_70170_p.func_72938_d(dwbg._c((double)this.field_70165_t), dwbg._c((double)this.field_70161_v)) instanceof ifck) {
                    this.field_70165_t = this.field_70169_q;
                    this.field_70163_u = this.field_70167_r;
                    this.field_70161_v = this.field_70166_s;
                    this.func_70107_b(this.field_70169_q, this.field_70167_r, this.field_70166_s);
                } else {
                    object = new Vector3f();
                    this.updateWheels(vehicleType, driveableData, (Vector3f)object);
                    if (this.throttle >= 0.4f) {
                        int n = -1;
                        for (EntityWheel entityWheel : this.wheels) {
                            if (entityWheel == null || !entityWheel.field_70123_F || !entityWheel.field_70122_E || ++n != 2 && n != 3) continue;
                            this.throttle = 0.4f;
                            break;
                        }
                    }
                    this.func_70091_d((double)((Vector3f)object).x, (double)((Vector3f)object).y, (double)((Vector3f)object).z);
                    if (this.wheels[0] != null && this.wheels[1] != null && this.wheels[2] != null && this.wheels[3] != null) {
                        Vector3f vector3f = new Vector3f((this.wheels[2].field_70165_t + this.wheels[3].field_70165_t) / 2.0, (this.wheels[2].field_70163_u + this.wheels[3].field_70163_u) / 2.0, (this.wheels[2].field_70161_v + this.wheels[3].field_70161_v) / 2.0);
                        Vector3f n = new Vector3f((this.wheels[0].field_70165_t + this.wheels[1].field_70165_t) / 2.0, (this.wheels[0].field_70163_u + this.wheels[1].field_70163_u) / 2.0, (this.wheels[0].field_70161_v + this.wheels[1].field_70161_v) / 2.0);
                        DriveablePosition driveablePosition = vehicleType.wheelPositions[3];
                        Vector3f vector3f2 = this.axes.findLocalVectorGlobally(new Vector3f(driveablePosition.position.x, driveablePosition.position.y, driveablePosition.originaZ));
                        driveablePosition = vehicleType.wheelPositions[2];
                        Vector3f vector3f3 = this.axes.findLocalVectorGlobally(new Vector3f(driveablePosition.position.x, driveablePosition.position.y, driveablePosition.originaZ));
                        driveablePosition = vehicleType.wheelPositions[0];
                        Vector3f vector3f4 = this.axes.findLocalVectorGlobally(new Vector3f(driveablePosition.position.x, driveablePosition.position.y, driveablePosition.originaZ));
                        driveablePosition = vehicleType.wheelPositions[1];
                        Vector3f vector3f5 = this.axes.findLocalVectorGlobally(new Vector3f(driveablePosition.position.x, driveablePosition.position.y, driveablePosition.originaZ));
                        vector3f2 = this.findGround(vector3f2);
                        Vector3f vector3f6 = this.findGround(vector3f3);
                        vector3f4 = this.findGround(vector3f4);
                        vector3f5 = this.findGround(vector3f5);
                        Vector3f vector3f7 = new Vector3f((vector3f2.x + vector3f4.x) / 2.0f, (vector3f2.y + vector3f4.y) / 2.0f, (vector3f2.z + vector3f4.z) / 2.0f);
                        Vector3f vector3f8 = new Vector3f((vector3f6.x + vector3f5.x) / 2.0f, (vector3f6.y + vector3f5.y) / 2.0f, (vector3f6.z + vector3f5.z) / 2.0f);
                        float f2 = vector3f.x - n.x;
                        float f3 = vector3f.y - n.y;
                        f = vector3f.z - n.z;
                        float f4 = vector3f7.x - vector3f8.x;
                        float f5 = vector3f7.y - vector3f8.y;
                        float f6 = vector3f7.z - vector3f8.z;
                        float f7 = (float)Math.sqrt(f2 * f2 + f * f);
                        float f8 = (float)Math.sqrt(f4 * f4 + f6 * f6);
                        float f9 = (float)Math.atan2(f, f2);
                        float f10 = -((float)Math.atan2(f3, f7));
                        float f11 = (float)Math.atan2(f5, f8) * 0.5f;
                        this.yaw = f9;
                        this.pitch = this.Lerp(this.pitch, f10, 0.2f);
                        this.roll = this.Lerp(this.roll, -f11, 0.15f);
                        float f12 = 0.1f * this.throttle * (this.throttle > 0.0f ? vehicleType.maxThrottle : vehicleType.maxNegativeThrottle) * driveableData.engine.engineSpeed;
                        float f13 = 0.1f * (this.wheelsYaw > 0.0f ? vehicleType.turnLeftModifier : vehicleType.turnRightModifier);
                        float f14 = this.wheelsYaw * f13 * f12;
                        this.throttle = this.throttle >= 0.0f ? (this.throttle -= Math.abs(0.3f * this.throttle * f14)) : (this.throttle += Math.abs(0.3f * this.throttle * f14));
                        this.yaw = this.axes.getYaw() / 180.0f * 3.14159f + f14;
                        this.axes.setAngles(this.yaw * 180.0f / 3.14159f, this.pitch * 180.0f / 3.14159f, this.roll * 180.0f / 3.14159f);
                    }
                }
                object = this.getDriveableData();
                float f15 = Math.max(1.0f, (float)object.parts.get((Object)EnumDriveablePart.core).maxHealth / 400.0f);
                ((DriveableData)object).fuelInTank -= Math.abs(driveableData.engine.fuelConsumption * this.throttle * 2.0f * f15);
                if (((DriveableData)object).fuel != null && object.fuel._b <= 0) {
                    ((DriveableData)object).fuel = null;
                }
                boolean bl2 = this.fuelling = ((DriveableData)object).fuel != null && ((DriveableData)object).fuelInTank < (float)vehicleType.fuelTankSize && object.fuel._b > 0 && ((DriveableData)object).fuel._a() instanceof ItemPart && ((ItemPart)object.fuel._a()).type.category == 9;
                if (this.fuelling) {
                    int n = ((DriveableData)object).fuel._j();
                    ((DriveableData)object).fuel._b(n + 1);
                    ((DriveableData)object).fuelInTank += 100.0f;
                    if (n >= ((DriveableData)object).fuel._k()) {
                        ((DriveableData)object).fuel._b(0);
                        --object.fuel._b;
                        if (object.fuel._b <= 0) {
                            ((DriveableData)object).fuel = null;
                        }
                    }
                }
                if (FlansMod.hooks.BuildCraftLoaded && !this.fuelling && ((DriveableData)object).fuel != null && object.fuel._b > 0) {
                    if (((DriveableData)object).fuel._b(FlansMod.hooks.BuildCraftOilBucket) && ((DriveableData)object).fuelInTank + 500.0f <= (float)vehicleType.fuelTankSize) {
                        ((DriveableData)object).fuelInTank += 5000.0f;
                        ((DriveableData)object).fuel = new ieta(jhvs.field_77788_aw);
                    } else if (((DriveableData)object).fuel._b(FlansMod.hooks.BuildCraftFuelBucket) && ((DriveableData)object).fuelInTank + 1000.0f <= (float)vehicleType.fuelTankSize) {
                        ((DriveableData)object).fuelInTank += 10000.0f;
                        ((DriveableData)object).fuel = new ieta(jhvs.field_77788_aw);
                    }
                }
                if (this.field_70170_p.field_72995_K && this.engineInitialized) {
                    boolean bl3 = this.throttle != 0.0f && this.hasEnoughFuel();
                    float f16 = Math.abs(this.throttle);
                    if (bl3 && this.engineStarted == 0) {
                        rojd.instance().getClient()._L._a("flansmod:" + vehicleType.startSound, (float)this.field_70165_t, (float)this.field_70163_u, (float)this.field_70161_v, 4.0f, 1.0f);
                    }
                    this.engineStarted = bl3 ? ++this.engineStarted : 0;
                    if (this.engineStarted > 10 && this.soundPosition == 0) {
                        float f17 = 0.8f + f16 * 0.6666666f;
                        rojd.instance().getClient()._L._a("flansmod:" + vehicleType.engineSound, (float)this.field_70165_t, (float)this.field_70163_u, (float)this.field_70161_v, 2.0f + f16 * 2.0f, 1.0f * f17);
                        this.soundPosition = (int)(19.0f / f17);
                    }
                }
                for (EntitySeat entitySeat : this.seats) {
                    if (entitySeat == null) continue;
                    entitySeat.updatePosition();
                }
                if (bl) {
                    PacketDispatcher.sendPacketToServer((maaq)PacketVehicleControl.buildUpdatePacket(this));
                    this.bZ = this.field_70165_t;
                    this.ca = this.field_70163_u;
                    this.cb = this.field_70161_v;
                    this.serverYaw = this.axes.getYaw();
                }
                if (!this.field_70170_p.field_72995_K) {
                    PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)128.0, (int)this.field_71093_bK, (maaq)PacketVehicleControl.buildUpdatePacket(this));
                }
            }
            if (Float.isNaN(this.throttle)) {
                throw new IllegalStateException("Vehicle thrOttle is NAN");
            }
            if (Float.isNaN(this.axes.rotationYaw)) {
                throw new IllegalStateException("Vehicle axes.yaw is NAN");
            }
            if (Float.isNaN(this.axes.rotationPitch)) {
                throw new IllegalStateException("Vehicle axes.pitch is NAN");
            }
            if (Float.isNaN(this.axes.rotationRoll)) {
                throw new IllegalStateException("Vehicle axes.roll is NAN");
            }
        }
        catch (Throwable throwable) {
            System.err.println("VEHICLE ONUPDATE FATAL ERROR");
            throwable.printStackTrace();
            this.func_70106_y();
        }
    }

    private void updateWheels(VehicleType vehicleType, DriveableData driveableData, Vector3f vector3f) {
        int n = -1;
        for (EntityWheel entityWheel : this.wheels) {
            boolean bl;
            ++n;
            if (entityWheel == null) continue;
            EntityWheel entityWheel2 = null;
            if (n % 2 != 0) {
                entityWheel2 = this.wheels[n - 1];
            }
            this.field_70122_E = true;
            entityWheel.field_70122_E = true;
            entityWheel.field_70177_z = this.axes.getYaw();
            if (!(vehicleType.tank || entityWheel.ID != 2 && entityWheel.ID != 3)) {
                entityWheel.field_70177_z += this.wheelsYaw;
            }
            entityWheel.field_70159_w *= 0.8999999761581421;
            entityWheel.field_70181_x *= 0.8999999761581421;
            entityWheel.field_70179_y *= 0.8999999761581421;
            entityWheel.field_70181_x -= 0.6100000143051147;
            boolean bl2 = this.seats != null && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ._d;
            boolean bl3 = bl = n == 2 || n == 3;
            if (bl2 || driveableData.fuelInTank > driveableData.engine.fuelConsumption * this.throttle) {
                float f = this.throttle;
                if (!bl && (double)f <= 0.5) {
                    f = 0.0f;
                }
                float f2 = 0.1f * f * (f > 0.0f ? vehicleType.maxThrottle : vehicleType.maxNegativeThrottle) * driveableData.engine.engineSpeed;
                entityWheel.field_70159_w += Math.cos(entityWheel.field_70177_z * 3.1415927f / 180.0f) * (double)f2;
                entityWheel.field_70179_y += Math.sin(entityWheel.field_70177_z * 3.1415927f / 180.0f) * (double)f2;
                if (entityWheel.ID == 2 || entityWheel.ID == 3) {
                    f2 = 0.01f * (this.wheelsYaw > 0.0f ? vehicleType.turnLeftModifier : vehicleType.turnRightModifier) * (float)(f > 0.0f ? 1 : -1);
                    entityWheel.field_70159_w -= entityWheel.getSpeedXZ() * Math.sin(entityWheel.field_70177_z * 3.1415927f / 180.0f) * (double)f2 * (double)this.wheelsYaw;
                    entityWheel.field_70179_y += entityWheel.getSpeedXZ() * Math.cos(entityWheel.field_70177_z * 3.1415927f / 180.0f) * (double)f2 * (double)this.wheelsYaw;
                } else {
                    entityWheel.field_70159_w *= 0.8999999761581421;
                    entityWheel.field_70179_y *= 0.8999999761581421;
                }
            }
            if (entityWheel2 != null) {
                entityWheel.func_70107_b(entityWheel2.field_70165_t, entityWheel2.field_70163_u, entityWheel2.field_70161_v);
                entityWheel.field_70177_z = entityWheel2.field_70177_z;
                entityWheel.field_70122_E = entityWheel2.field_70122_E;
                entityWheel.field_70123_F = entityWheel2.field_70123_F;
            } else if (Math.abs(entityWheel.field_70159_w) > 3.0 || Math.abs(entityWheel.field_70181_x) > 10.0 || Math.abs(entityWheel.field_70179_y) > 3.0) {
                entityWheel.func_70107_b(entityWheel.field_70165_t + entityWheel.field_70159_w, entityWheel.field_70163_u + entityWheel.field_70181_x, entityWheel.field_70161_v + entityWheel.field_70179_y);
            } else {
                entityWheel.func_70091_d(entityWheel.field_70159_w, entityWheel.field_70181_x, entityWheel.field_70179_y);
            }
            Vector3f vector3f2 = this.axes.findLocalVectorGlobally(this.getVehicleType().wheelPositions[entityWheel.ID].position);
            Vector3f vector3f3 = new Vector3f(entityWheel.field_70165_t - this.field_70165_t, entityWheel.field_70163_u - this.field_70163_u, entityWheel.field_70161_v - this.field_70161_v);
            Vector3f vector3f4 = (Vector3f)Vector3f.sub(vector3f2, vector3f3, null).scale(this.getVehicleType().wheelSpringStrength);
            if (!(vector3f4.length() > 0.001f)) continue;
            if (entityWheel2 == null) {
                if (Math.abs(vector3f4.x) > 16.0f || Math.abs(vector3f4.y) > 16.0f || Math.abs(vector3f4.z) > 16.0f) {
                    entityWheel.func_70107_b(entityWheel.field_70165_t + (double)vector3f4.x, entityWheel.field_70163_u + (double)vector3f4.y, entityWheel.field_70161_v + (double)vector3f4.z);
                } else {
                    boolean bl4 = entityWheel.field_70122_E;
                    boolean bl5 = entityWheel.field_70123_F;
                    entityWheel.func_70091_d(vector3f4.x, vector3f4.y, vector3f4.z);
                    entityWheel.field_70122_E = bl4;
                    entityWheel.field_70123_F = bl5;
                }
                vector3f4.scale(0.5f);
            }
            Vector3f.sub(vector3f, vector3f4, vector3f);
        }
    }

    private void applyThrust(DriveablePart driveablePart, float f) {
        if ((driveablePart.maxHealth <= 0 || driveablePart.health > 0) && driveablePart.box != null) {
            boolean bl;
            DriveableData driveableData = this.getDriveableData();
            boolean bl2 = bl = this.seats != null && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ._d;
            if (bl || driveableData.fuelInTank > Math.abs(driveableData.engine.fuelConsumption * this.throttle)) {
                Vector3f vector3f = driveablePart.box.getCentre();
                Vector3f vector3f2 = this.axes.findLocalVectorGlobally(vector3f);
                Vector3f vector3f3 = this.axes.getXAxis();
                this.applyForce(vector3f2, (Vector3f)new Vector3f(vector3f3.x, 0.0f, vector3f3.z).scale(f));
                if (!bl) {
                    driveableData.fuelInTank -= Math.abs(driveableData.engine.fuelConsumption * this.throttle);
                }
            }
        }
    }

    @Override
    public boolean landVehicle() {
        return true;
    }

    @Override
    public boolean func_70097_a(pico pico2, float f) {
        if (f > 0.0f && !this.field_70170_p.field_72995_K && !this.field_70128_L && !"fall".equals(pico2.field_76373_n)) {
            if (!HCS.isEntityInSafezone((Entity)this)) {
                this.getDriveableData().parts.get((Object)EnumDriveablePart.core).health -= dwbg._d((float)f);
                PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)100.0, (int)this.field_71093_bK, (maaq)PacketDriveableDamage.buildUpdatePacket(this));
            }
            return true;
        }
        return true;
    }

    public VehicleType getVehicleType() {
        return VehicleType.getVehicle(this.driveableType);
    }

    @Override
    public float getPlayerRoll() {
        return this.axes.getRoll();
    }

    @Override
    protected void dropItemsOnPartDeath(Vector3f vector3f, DriveablePart driveablePart) {
    }

    @Override
    public String getBombInventoryName() {
        return "Shells";
    }

    @Override
    public boolean hasMouseControlMode() {
        return false;
    }

    public float Lerp(float f, float f2, float f3) {
        float f4 = f + f3 * (f2 - f);
        return f4;
    }
}

