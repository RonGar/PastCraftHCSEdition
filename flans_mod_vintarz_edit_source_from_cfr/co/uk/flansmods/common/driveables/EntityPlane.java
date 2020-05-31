/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.common.uxsf
 *  cpw.mods.fml.relauncher.Side
 *  cuqu
 *  hsus
 *  ieta
 *  jhvs
 *  maaq
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.pico
 *  net.minecraft.util.samw
 *  net.minecraft.util.zwaq
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansHooks;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.ItemPart;
import co.uk.flansmods.common.ItemTool;
import co.uk.flansmods.common.PartType;
import co.uk.flansmods.common.RotatedAxes;
import co.uk.flansmods.common.ToolType;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.driveables.PilotGun;
import co.uk.flansmods.common.driveables.PlaneType;
import co.uk.flansmods.common.driveables.Propeller;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemBullet;
import co.uk.flansmods.common.network.PacketPlaySound;
import co.uk.flansmods.common.network.PacketVehicleControl;
import co.uk.flansmods.common.network.PacketVehicleKey;
import co.uk.flansmods.common.vector.Vector;
import co.uk.flansmods.common.vector.Vector3f;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.uxsf;
import cpw.mods.fml.relauncher.Side;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidl;
import net.minecraft.util.dwbg;
import net.minecraft.util.pico;
import net.minecraft.util.samw;
import net.minecraft.util.zwaq;

public class EntityPlane
extends EntityDriveable {
    public float flapsYaw;
    public float flapsPitchLeft;
    public float flapsPitchRight;
    public int soundPosition;
    public float propAngle;
    public int bombDelay;
    public int gunDelay;
    public int ticksSinceUsed = 0;
    public boolean varGear = true;
    public boolean varDoor = false;
    public boolean varWing = false;
    public int toggleTimer = 0;

    public EntityPlane(cuqu cuqu2) {
        super(cuqu2);
    }

    public EntityPlane(cuqu cuqu2, double d, double d2, double d3, PlaneType planeType, DriveableData driveableData) {
        super(cuqu2, planeType, driveableData);
        this.func_70107_b(d, d2, d3);
        this.initType(planeType, false);
    }

    public EntityPlane(cuqu cuqu2, double d, double d2, double d3, EntityPlayer entityPlayer, PlaneType planeType, DriveableData driveableData) {
        this(cuqu2, d, d2, d3, planeType, driveableData);
        this.rotateYaw(entityPlayer.field_70177_z + 90.0f);
        this.rotatePitch(planeType.restingPitch);
    }

    @Override
    protected void func_70014_b(hsus hsus2) {
        super.func_70014_b(hsus2);
        hsus2._a("VarGear", this.varGear);
        hsus2._a("VarDoor", this.varDoor);
        hsus2._a("VarWing", this.varWing);
    }

    @Override
    protected void func_70037_a(hsus hsus2) {
        super.func_70037_a(hsus2);
        this.varGear = hsus2._o("VarGear");
        this.varDoor = hsus2._o("VarDoor");
        this.varWing = hsus2._o("VarWing");
    }

    @Override
    public void writeUpdateData(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeBoolean(this.varGear);
            dataOutputStream.writeBoolean(this.varDoor);
            dataOutputStream.writeBoolean(this.varWing);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public void readUpdateData(DataInputStream dataInputStream) {
        try {
            this.varGear = dataInputStream.readBoolean();
            this.varDoor = dataInputStream.readBoolean();
            this.varWing = dataInputStream.readBoolean();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public void onMouseMoved(int n, int n2) {
        if (uxsf.instance().getSide().isClient() && FlansMod.proxy.mouseControlEnabled()) {
            this.flapsPitchLeft -= 0.02f * (float)n2;
            this.flapsPitchRight -= 0.02f * (float)n2;
            this.flapsPitchLeft -= 0.02f * (float)n;
            this.flapsPitchRight += 0.02f * (float)n;
        }
    }

    public boolean func_130002_c(EntityPlayer entityPlayer) {
        if (this.field_70128_L) {
            return false;
        }
        if (this.field_70170_p.field_72995_K) {
            return false;
        }
        ieta ieta2 = entityPlayer.func_71045_bC();
        if (ieta2 != null && ieta2._a() instanceof ItemTool && ((ItemTool)ieta2._a()).type.healDriveables) {
            return true;
        }
        PlaneType planeType = this.getPlaneType();
        for (int i = 0; i <= planeType.numPassengers; ++i) {
            if (!this.seats[i].func_130002_c(entityPlayer)) continue;
            if (i == 0) {
                this.bombDelay = planeType.planeBombDelay;
                FlansMod.proxy.doTutorialStuff(entityPlayer, this);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean pressKey(int n, EntityPlayer entityPlayer) {
        PlaneType planeType = this.getPlaneType();
        if (this.field_70170_p.field_72995_K && (n == 6 || n == 8 || n == 9)) {
            PacketDispatcher.sendPacketToServer((maaq)PacketVehicleKey.buildKeyPacket(n));
            return true;
        }
        switch (n) {
            case 0: {
                this.throttle += 0.01f;
                if (this.throttle > 1.0f) {
                    this.throttle = 1.0f;
                }
                return true;
            }
            case 1: {
                this.throttle -= 0.01f;
                if (this.throttle < -1.0f) {
                    this.throttle = -1.0f;
                }
                if (this.throttle < 0.0f && planeType.maxNegativeThrottle == 0.0f) {
                    this.throttle = 0.0f;
                }
                return true;
            }
            case 2: {
                this.flapsYaw -= 1.0f;
                return true;
            }
            case 3: {
                this.flapsYaw += 1.0f;
                return true;
            }
            case 4: {
                this.flapsPitchLeft += 1.0f;
                this.flapsPitchRight += 1.0f;
                return true;
            }
            case 5: {
                this.flapsPitchLeft -= 1.0f;
                this.flapsPitchRight -= 1.0f;
                return true;
            }
            case 6: {
                this.seats[0].field_70153_n.func_70078_a(null);
                return true;
            }
            case 7: {
                if (this.field_70170_p.field_72995_K && (planeType.invInflight || Math.abs(this.throttle) < 0.1f && this.field_70122_E)) {
                    FlansMod.proxy.openDriveableMenu((EntityPlayer)this.seats[0].field_70153_n, this.field_70170_p, this);
                }
                return true;
            }
            case 8: {
                if (!this.field_70170_p.field_72995_K && this.bombDelay <= 0 && FlansMod.bombsEnabled) {
                    int n2 = -1;
                    for (int i = this.driveableData.getBombInventoryStart(); i < this.driveableData.getBombInventoryStart() + planeType.numBombSlots; ++i) {
                        ieta ieta2 = this.driveableData.func_70301_a(i);
                        if (ieta2 == null || !(ieta2._a() instanceof ItemBullet) || !((ItemBullet)ieta2._a()).type.isBomb) continue;
                        n2 = i;
                    }
                    if (n2 != -1) {
                        samw samw2 = this.rotate(planeType.bombPosition).toVec3();
                        ((ItemBullet)this.driveableData.func_70301_a(n2)._a()).getEntity(this.field_70170_p, samw2._c(this.field_70165_t, this.field_70163_u, this.field_70161_v), this.axes.getYaw(), this.axes.getPitch(), this.field_70159_w, this.field_70181_x, this.field_70179_y, (EntityLivingBase)((EntityLiving)this.field_70153_n), 1.0f, this.driveableData.func_70301_a(n2)._j(), planeType);
                        if (planeType.shootSecondarySound != null) {
                            PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)50.0, (int)this.field_71093_bK, (maaq)PacketPlaySound.buildSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, planeType.shootSecondarySound, false));
                        }
                        if (!((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ._d) {
                            this.driveableData.func_70298_a(n2, 1);
                        }
                        this.bombDelay = planeType.planeBombDelay;
                    }
                    return true;
                }
                return false;
            }
            case 9: {
                if (!this.field_70170_p.field_72995_K && this.gunDelay <= 0 && FlansMod.bulletsEnabled) {
                    for (PilotGun pilotGun : this.getDriveableType().guns) {
                        BulletType bulletType;
                        GunType gunType = pilotGun.type;
                        ieta ieta3 = this.driveableData.ammo[this.getDriveableType().numPassengerGunners + pilotGun.gunID];
                        if (gunType == null || ieta3 == null || !(ieta3._a() instanceof ItemBullet) || !gunType.isAmmo(bulletType = ((ItemBullet)ieta3._a()).type)) continue;
                        Vector3f vector3f = this.rotate(pilotGun.position);
                        ((ItemBullet)ieta3._a()).getEntity(this.field_70170_p, Vector3f.add(vector3f, new Vector3f((float)this.field_70165_t, (float)this.field_70163_u, (float)this.field_70161_v), null), this.axes.getXAxis(), (EntityLivingBase)this.seats[0].field_70153_n, gunType.bulletSpread / 2.0f, gunType.damage, 2.0f, ieta3._j(), (InfoType)planeType);
                        PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)50.0, (int)this.field_71093_bK, (maaq)PacketPlaySound.buildSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, planeType.shootMainSound, false));
                        int n3 = ieta3._j();
                        ieta3._b(n3 + 1);
                        if (n3 + 1 == ieta3._k()) {
                            ieta3._b(0);
                            if (!((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ._d) {
                                --ieta3._b;
                                if (ieta3._b <= 0) {
                                    ieta3 = null;
                                }
                                this.driveableData.func_70299_a(this.getDriveableType().numPassengerGunners + pilotGun.gunID, ieta3);
                            }
                        }
                        this.gunDelay = planeType.planeShootDelay;
                    }
                    return true;
                }
                return false;
            }
            case 10: {
                FlansMod.proxy.changeControlMode((EntityPlayer)this.seats[0].field_70153_n);
                return true;
            }
            case 11: {
                this.flapsPitchLeft += 1.0f;
                this.flapsPitchRight -= 1.0f;
                return true;
            }
            case 12: {
                this.flapsPitchLeft -= 1.0f;
                this.flapsPitchRight += 1.0f;
                return true;
            }
            case 13: {
                if (this.toggleTimer <= 0) {
                    this.varGear = !this.varGear;
                    entityPlayer.func_71035_c("Landing gear " + (this.varGear ? "down" : "up"));
                    this.toggleTimer = 10;
                    PacketDispatcher.sendPacketToServer((maaq)PacketVehicleControl.buildUpdatePacket(this));
                }
                return true;
            }
            case 14: {
                if (this.toggleTimer <= 0) {
                    boolean bl = this.varDoor = !this.varDoor;
                    if (planeType.hasDoor) {
                        entityPlayer.func_71035_c("Doors " + (this.varDoor ? "open" : "closed"));
                    }
                    this.toggleTimer = 10;
                    PacketDispatcher.sendPacketToServer((maaq)PacketVehicleControl.buildUpdatePacket(this));
                }
                return true;
            }
            case 15: {
                if (this.toggleTimer <= 0) {
                    boolean bl = this.varWing = !this.varWing;
                    if (planeType.hasWing) {
                        entityPlayer.func_71035_c("Toggling wings");
                    }
                    this.toggleTimer = 10;
                    PacketDispatcher.sendPacketToServer((maaq)PacketVehicleControl.buildUpdatePacket(this));
                }
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
    public void func_70071_h_() {
        super.func_70071_h_();
        PlaneType planeType = this.getPlaneType();
        DriveableData driveableData = this.getDriveableData();
        if (planeType == null) {
            FlansMod.log("Plane type null. Not ticking plane");
        } else {
            float f;
            boolean bl = this.field_70170_p.field_72995_K && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)this.seats[0].field_70153_n);
            ++this.ticksSinceUsed;
            if (!this.field_70170_p.field_72995_K && this.seats[0].field_70153_n != null) {
                this.ticksSinceUsed = 0;
            }
            if (!this.field_70170_p.field_72995_K && FlansMod.planeLife > 0 && this.ticksSinceUsed > FlansMod.planeLife * 20) {
                this.func_70106_y();
            }
            if (this.bombDelay > 0) {
                --this.bombDelay;
            }
            if (this.gunDelay > 0) {
                --this.gunDelay;
            }
            if (this.toggleTimer > 0) {
                --this.toggleTimer;
            }
            if (this.hasEnoughFuel()) {
                this.propAngle += this.throttle / 7.0f;
            }
            this.flapsYaw *= 0.9f;
            this.flapsPitchLeft *= 0.9f;
            this.flapsPitchRight *= 0.9f;
            if (this.flapsYaw > 20.0f) {
                this.flapsYaw = 20.0f;
            }
            if (this.flapsYaw < -20.0f) {
                this.flapsYaw = -20.0f;
            }
            if (this.flapsPitchRight > 20.0f) {
                this.flapsPitchRight = 20.0f;
            }
            if (this.flapsPitchRight < -20.0f) {
                this.flapsPitchRight = -20.0f;
            }
            if (this.flapsPitchLeft > 20.0f) {
                this.flapsPitchLeft = 20.0f;
            }
            if (this.flapsPitchLeft < -20.0f) {
                this.flapsPitchLeft = -20.0f;
            }
            if (this.field_70170_p.field_72995_K && !bl && this.serverPositionTransitionTicker > 0) {
                double d = this.field_70165_t + (this.bZ - this.field_70165_t) / (double)this.serverPositionTransitionTicker;
                double d2 = this.field_70163_u + (this.ca - this.field_70163_u) / (double)this.serverPositionTransitionTicker;
                double d3 = this.field_70161_v + (this.cb - this.field_70161_v) / (double)this.serverPositionTransitionTicker;
                double d4 = dwbg._f((double)(this.serverYaw - (double)this.axes.getYaw()));
                double d5 = dwbg._f((double)(this.serverPitch - (double)this.axes.getPitch()));
                double d6 = dwbg._f((double)(this.serverRoll - (double)this.axes.getRoll()));
                this.field_70177_z = (float)((double)this.axes.getYaw() + d4 / (double)this.serverPositionTransitionTicker);
                this.field_70125_A = (float)((double)this.axes.getPitch() + d5 / (double)this.serverPositionTransitionTicker);
                float f2 = (float)((double)this.axes.getRoll() + d6 / (double)this.serverPositionTransitionTicker);
                --this.serverPositionTransitionTicker;
                this.func_70107_b(d, d2, d3);
                this.setRotation(this.field_70177_z, this.field_70125_A, f2);
            }
            float f3 = 0.5f * planeType.mass / (float)Math.max(1.0, 5.0 * Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y));
            float f4 = this.flapsYaw * (this.flapsYaw > 0.0f ? planeType.turnLeftModifier : planeType.turnRightModifier) * f3;
            float f5 = (this.flapsPitchLeft + this.flapsPitchRight) / 2.0f;
            float f6 = f5 * (f5 > 0.0f ? planeType.lookUpModifier : planeType.lookDownModifier) * f3;
            float f7 = (this.flapsPitchRight - this.flapsPitchLeft) / 2.0f;
            float f8 = f7 * (f7 > 0.0f ? planeType.rollLeftModifier : planeType.rollRightModifier) * f3;
            this.applyTorque(this.axes.findLocalVectorGlobally(new Vector3f(-f8, f4, -f6)));
            f6 = 12.0f * planeType.drag * planeType.mass * 0.49050003f / (planeType.lift * 2.0f * planeType.maxThrottle * (float)planeType.propellers.size());
            for (Propeller object2 : planeType.propellers) {
                boolean bl2;
                if (this.getDriveableData().parts.get((Object)object2.planePart).dead) continue;
                boolean bl3 = bl2 = this.seats != null && this.seats[0] != null && this.seats[0].field_70153_n instanceof EntityPlayer && ((EntityPlayer)this.seats[0].field_70153_n).field_71075_bZ._d;
                if (!bl2 && !(driveableData.fuelInTank > driveableData.engine.fuelConsumption * this.throttle)) continue;
                f = 2.0f * this.throttle * (this.throttle > 0.0f ? planeType.maxThrottle : planeType.maxNegativeThrottle) * driveableData.engine.engineSpeed;
                this.applyForce(this.axes.findLocalVectorGlobally(object2.getPosition()), (Vector3f)this.axes.getXAxis().scale(f));
                if (bl2) continue;
                driveableData.fuelInTank -= driveableData.engine.fuelConsumption * this.throttle;
            }
            Vector3f vector3f = new Vector3f((float)this.field_70159_w, (float)this.field_70181_x, (float)this.field_70179_y);
            if (vector3f.lengthSquared() > 1.0E-7f) {
                f8 = 10.0f * planeType.drag * vector3f.lengthSquared();
                this.applyForce(new Vector3f(), (Vector3f)vector3f.normalise().negate().scale(f8));
            }
            Vector3f vector3f2 = new Vector3f((float)this.field_70159_w, (float)this.field_70181_x, (float)this.field_70179_y);
            f8 = Vector3f.dot(vector3f2, this.axes.getXAxis());
            float f2 = Vector3f.dot(vector3f2, this.axes.getZAxis());
            f = f8 * f8 + f2 * f2;
            if (vector3f2.lengthSquared() > 1.0E-7f) {
                float f9 = f6 * planeType.lift * f;
                this.applyForce(new Vector3f(), (Vector3f)this.axes.getYAxis().scale(f9));
            }
            f7 = planeType.mass * 0.49050003f;
            this.applyForce(new Vector3f(), new Vector3f(0.0f, -f7, 0.0f));
            this.angularVelocity.scale(0.95f);
            if (driveableData.fuel != null && driveableData.fuel._b <= 0) {
                driveableData.fuel = null;
            }
            boolean bl4 = this.fuelling = driveableData.fuel != null && driveableData.fuelInTank < (float)planeType.fuelTankSize && driveableData.fuel._b > 0 && driveableData.fuel._a() instanceof ItemPart && ((ItemPart)driveableData.fuel._a()).type.category == 9;
            if (this.fuelling) {
                int n = driveableData.fuel._j();
                driveableData.fuel._b(n + 1);
                driveableData.fuelInTank += 100.0f;
                if (n >= driveableData.fuel._k()) {
                    driveableData.fuel._b(0);
                    --driveableData.fuel._b;
                    if (driveableData.fuel._b <= 0) {
                        driveableData.fuel = null;
                    }
                }
            }
            if (FlansMod.hooks.BuildCraftLoaded && !this.fuelling && driveableData.fuel != null && driveableData.fuel._b > 0) {
                if (driveableData.fuel._b(FlansMod.hooks.BuildCraftOilBucket) && driveableData.fuelInTank + 500.0f <= (float)planeType.fuelTankSize) {
                    driveableData.fuelInTank += 5000.0f;
                    driveableData.fuel = new ieta(jhvs.field_77788_aw);
                } else if (driveableData.fuel._b(FlansMod.hooks.BuildCraftFuelBucket) && driveableData.fuelInTank + 1000.0f <= (float)planeType.fuelTankSize) {
                    driveableData.fuelInTank += 10000.0f;
                    driveableData.fuel = new ieta(jhvs.field_77788_aw);
                }
            }
            if (this.throttle > 0.01f && this.throttle < 0.2f && this.soundPosition == 0 && this.hasEnoughFuel()) {
                PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0, this.field_71093_bK, planeType.startSound, false);
                this.soundPosition = planeType.startSoundLength;
            }
            if (this.throttle > 0.2f && this.soundPosition == 0 && this.hasEnoughFuel()) {
                PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0, this.field_71093_bK, planeType.engineSound, false);
                this.soundPosition = planeType.engineSoundLength;
            }
            if (this.soundPosition > 0) {
                --this.soundPosition;
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
            if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 5 == 0) {
                PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)128.0, (int)this.field_71093_bK, (maaq)PacketVehicleControl.buildUpdatePacket(this));
            }
        }
    }

    @Override
    public boolean gearDown() {
        return this.varGear;
    }

    public boolean attackEntityFrom(pico pico2, float f, boolean bl) {
        if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
            PlaneType planeType = PlaneType.getPlane(this.driveableType);
            if (pico2.field_76373_n.equals("player") && ((zwaq)pico2).func_76346_g().field_70122_E && (this.seats[0] == null || this.seats[0].field_70153_n == null)) {
                ieta ieta2 = new ieta(planeType.itemID, 1, 0);
                ieta2._e = new hsus();
                this.driveableData.writeToNBT(ieta2._e);
                this.func_70099_a(ieta2, 0.5f);
                this.func_70106_y();
            }
            return true;
        }
        return true;
    }

    @Override
    public boolean canHitPart(EnumDriveablePart enumDriveablePart) {
        return this.varGear || enumDriveablePart != EnumDriveablePart.coreWheel && enumDriveablePart != EnumDriveablePart.leftWingWheel && enumDriveablePart != EnumDriveablePart.rightWingWheel && enumDriveablePart != EnumDriveablePart.tailWheel;
    }

    @Override
    public boolean func_70097_a(pico pico2, float f) {
        return this.attackEntityFrom(pico2, f, true);
    }

    public PlaneType getPlaneType() {
        return PlaneType.getPlane(this.driveableType);
    }

    @Override
    protected void dropItemsOnPartDeath(Vector3f vector3f, DriveablePart driveablePart) {
    }

    @Override
    public String getBombInventoryName() {
        return "Bombs";
    }

    @Override
    public boolean hasMouseControlMode() {
        return true;
    }
}

