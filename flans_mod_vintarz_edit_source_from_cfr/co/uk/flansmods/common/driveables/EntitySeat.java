/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  brcy
 *  com.google.common.io.ByteArrayDataInput
 *  com.google.common.io.ByteArrayDataOutput
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.common.registry.IEntityAdditionalSpawnData
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cupi
 *  cuqu
 *  hcsmod.HCS
 *  hcsmod.server.SPacketHandler
 *  hsus
 *  ieta
 *  jhvs
 *  maaq
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.pico
 *  net.minecraft.util.pzgw
 *  net.minecraft.util.rojd
 *  net.minecraft.util.samw
 *  rppd
 *  uyla
 *  xrdl
 *  zgmv
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.api.IControllable;
import co.uk.flansmods.client.FlansModClient;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.ItemTool;
import co.uk.flansmods.common.RotatedAxes;
import co.uk.flansmods.common.ToolType;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.Seat;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemBullet;
import co.uk.flansmods.common.network.PacketSeatUpdates;
import co.uk.flansmods.common.network.PacketVehicleKey;
import co.uk.flansmods.common.vector.Vector3f;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.HCS;
import hcsmod.server.SPacketHandler;
import java.util.List;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.eidl;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.pico;
import net.minecraft.util.pzgw;
import net.minecraft.util.rojd;
import net.minecraft.util.samw;

public class EntitySeat
extends Entity
implements IControllable,
IEntityAdditionalSpawnData {
    @SideOnly(value=Side.CLIENT)
    public boolean foundDriveable;
    private int driveableID;
    private int seatID;
    public EntityDriveable driveable;
    @SideOnly(value=Side.CLIENT)
    public float playerRoll;
    public Seat seatInfo;
    public boolean driver;
    public RotatedAxes looking;
    public RotatedAxes prevLooking;
    public int gunDelay;
    public int soundDelay;
    private double playerPosX;
    private double playerPosY;
    private double playerPosZ;
    private float playerYaw;
    private float playerPitch;
    private double prevPlayerPosX;
    private double prevPlayerPosY;
    private double prevPlayerPosZ;
    private float prevPlayerYaw;
    private float prevPlayerPitch;

    public EntitySeat(cuqu cuqu2) {
        super(cuqu2);
        this.func_70105_a(1.0f, 1.0f);
        this.prevLooking = new RotatedAxes();
        this.looking = new RotatedAxes();
    }

    public EntitySeat(cuqu cuqu2, EntityDriveable entityDriveable, int n) {
        this(cuqu2);
        this.driveable = entityDriveable;
        this.driveableID = entityDriveable.field_70157_k;
        this.seatInfo = this.driveable.getDriveableType().seats[n];
        this.driver = n == 0;
        this.func_70107_b(entityDriveable.field_70165_t, entityDriveable.field_70163_u, entityDriveable.field_70161_v);
        this.playerPosX = this.prevPlayerPosX = this.field_70165_t;
        this.playerPosY = this.prevPlayerPosY = this.field_70163_u;
        this.playerPosZ = this.prevPlayerPosZ = this.field_70161_v;
        this.looking.setAngles((this.seatInfo.minYaw + this.seatInfo.maxYaw) / 2.0f, 0.0f, 0.0f);
    }

    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
    }

    public void func_70071_h_() {
        if (this.driveable != null && this.driveable.field_70128_L) {
            this.func_70106_y();
            return;
        }
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K && !this.foundDriveable) {
            this.driveable = (EntityDriveable)this.field_70170_p.func_73045_a(this.driveableID);
            if (this.driveable == null) {
                return;
            }
            this.foundDriveable = true;
            this.driveable.seats[this.seatID] = this;
            this.seatInfo = this.driveable.getDriveableType().seats[this.seatID];
            this.looking.setAngles((this.seatInfo.minYaw + this.seatInfo.maxYaw) / 2.0f, 0.0f, 0.0f);
            this.prevPlayerPosX = this.field_70165_t = this.driveable.field_70165_t;
            this.playerPosX = this.field_70165_t;
            this.prevPlayerPosY = this.field_70163_u = this.driveable.field_70163_u;
            this.playerPosY = this.field_70163_u;
            this.prevPlayerPosZ = this.field_70161_v = this.driveable.field_70161_v;
            this.playerPosZ = this.field_70161_v;
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        }
        if (this.gunDelay > 0) {
            --this.gunDelay;
        }
        if (this.soundDelay > 0) {
            --this.soundDelay;
        }
        if (this.field_70170_p.field_72995_K) {
            if (this.driver && this.field_70153_n == tuor._E()._r && FlansModClient.controlModeMouse && this.driveable.hasMouseControlMode()) {
                this.looking = new RotatedAxes();
            }
            this.driveable.axes.findLocalAxesGlobally(this.looking).getXAxis();
            this.driveable.axes.findLocalAxesGlobally(this.looking).getYAxis();
            this.driveable.axes.findLocalAxesGlobally(this.looking).getZAxis();
            this.driveable.axes.findLocalVectorGlobally(new Vector3f(0.0f, this.field_70153_n == null ? 0.0f : (float)this.field_70153_n.func_70033_W(), 0.0f));
        }
        this.prevLooking = this.looking.clone();
    }

    public void updatePosition() {
        if (!this.field_70170_p.field_72995_K || this.foundDriveable) {
            Object object;
            float f = this.driveable.axes.rotationRoll;
            this.driveable.axes.rotationRoll *= 0.2f;
            this.prevPlayerPosX = this.playerPosX;
            this.prevPlayerPosY = this.playerPosY;
            this.prevPlayerPosZ = this.playerPosZ;
            this.prevPlayerYaw = this.playerYaw;
            this.prevPlayerPitch = this.playerPitch;
            Vector3f vector3f = new Vector3f((float)this.seatInfo.x / 16.0f, (float)this.seatInfo.y / 16.0f, (float)this.seatInfo.z / 16.0f);
            if (this.driver) {
                object = new RotatedAxes(this.looking.getYaw(), 0.0f, 0.0f);
                Vector3f vector3f2 = ((RotatedAxes)object).findLocalVectorGlobally(this.driveable.getDriveableType().rotatedDriverOffset);
                Vector3f.add(vector3f, new Vector3f(vector3f2.x, 0.0f, vector3f2.z), vector3f);
            }
            object = this.driveable.axes.findLocalVectorGlobally(vector3f);
            this.func_70107_b(this.driveable.field_70165_t + (double)((Vector3f)object).x, this.driveable.field_70163_u + (double)((Vector3f)object).y, this.driveable.field_70161_v + (double)((Vector3f)object).z);
            if (this.field_70153_n != null) {
                this.driveable.getDriveableType();
                samw samw2 = this.driveable.rotate(0.0, this.field_70153_n.func_70033_W(), 0.0).toVec3();
                this.playerPosX = this.field_70165_t + samw2._c;
                this.playerPosY = this.field_70163_u + samw2._d;
                this.playerPosZ = this.field_70161_v + samw2._e;
                this.field_70153_n.field_70142_S = this.field_70153_n.field_70169_q = this.prevPlayerPosX;
                this.field_70153_n.field_70137_T = this.field_70153_n.field_70167_r = this.prevPlayerPosY;
                this.field_70153_n.field_70136_U = this.field_70153_n.field_70166_s = this.prevPlayerPosZ;
                this.field_70153_n.func_70107_b(this.playerPosX, this.playerPosY, this.playerPosZ);
                float f2 = this.driveable.axes.rotationPitch;
                this.driveable.axes.rotationPitch *= 0.5f;
                RotatedAxes rotatedAxes = this.driveable.axes.findLocalAxesGlobally(this.looking);
                this.driveable.axes.rotationPitch = f2;
                this.playerYaw = -90.0f + rotatedAxes.getYaw();
                this.playerPitch = rotatedAxes.getPitch();
                double d = this.playerYaw - this.prevPlayerYaw;
                if (d > 180.0) {
                    this.prevPlayerYaw += 360.0f;
                }
                if (d < -180.0) {
                    this.prevPlayerYaw -= 360.0f;
                }
                if (this.field_70153_n instanceof EntityPlayer) {
                    this.field_70153_n.field_70126_B = this.prevPlayerYaw;
                    this.field_70153_n.field_70127_C = this.prevPlayerPitch;
                    this.field_70153_n.field_70177_z = this.playerYaw;
                    this.field_70153_n.field_70125_A = this.playerPitch;
                }
                if (this.field_70170_p.field_72995_K) {
                    this.playerRoll = -rotatedAxes.getRoll();
                }
            }
            this.driveable.axes.rotationRoll = f;
        }
    }

    public void func_70043_V() {
        if (this.field_70153_n instanceof EntityPlayer) {
            this.field_70153_n.field_70177_z = this.playerYaw;
            this.field_70153_n.field_70125_A = this.playerPitch;
            this.field_70153_n.field_70126_B = this.prevPlayerYaw;
            this.field_70153_n.field_70127_C = this.prevPlayerPitch;
        }
        this.field_70153_n.field_70142_S = this.field_70153_n.field_70169_q = this.prevPlayerPosX;
        this.field_70153_n.field_70137_T = this.field_70153_n.field_70167_r = this.prevPlayerPosY;
        this.field_70153_n.field_70136_U = this.field_70153_n.field_70166_s = this.prevPlayerPosZ;
    }

    public boolean func_70067_L() {
        return !this.field_70128_L;
    }

    protected void func_70088_a() {
    }

    public float func_70053_R() {
        return 4.0f;
    }

    protected void func_70037_a(hsus hsus2) {
    }

    protected void func_70014_b(hsus hsus2) {
    }

    public boolean func_70039_c(hsus hsus2) {
        return false;
    }

    public boolean func_98035_c(hsus hsus2) {
        return false;
    }

    @Override
    public void onMouseMoved(int n, int n2) {
        if (this.foundDriveable) {
            this.prevLooking = this.looking.clone();
            if (this.driver) {
                this.driveable.onMouseMoved(n, n2);
            }
            if (!(this.driver && FlansModClient.controlModeMouse && this.driveable.hasMouseControlMode())) {
                float f = this.looking.getPitch() - (float)n2 / 4.0f * tuor._E()._K._j;
                if (f > -this.seatInfo.minPitch) {
                    f = -this.seatInfo.minPitch;
                }
                if (f < -this.seatInfo.maxPitch) {
                    f = -this.seatInfo.maxPitch;
                }
                float f2 = this.looking.getYaw() + (float)n / 4.0f * tuor._E()._K._j;
                float f3 = f2 - 360.0f;
                if (f2 < 0.0f) {
                    f3 = f2 + 360.0f;
                }
                if ((f2 < this.seatInfo.minYaw || f2 > this.seatInfo.maxYaw) && (f3 < this.seatInfo.minYaw || f3 > this.seatInfo.maxYaw)) {
                    float f4;
                    float f5 = Math.min(Math.abs(f2 - this.seatInfo.minYaw), Math.abs(f2 - this.seatInfo.maxYaw));
                    if (f5 <= (f4 = Math.min(Math.abs(f3 - this.seatInfo.minYaw), Math.abs(f3 - this.seatInfo.maxYaw)))) {
                        if (f2 > this.seatInfo.maxYaw) {
                            f2 = this.seatInfo.maxYaw;
                        }
                        if (f2 < this.seatInfo.minYaw) {
                            f2 = this.seatInfo.minYaw;
                        }
                    } else {
                        if (f3 > this.seatInfo.maxYaw) {
                            f3 = this.seatInfo.maxYaw;
                        }
                        if (f3 < this.seatInfo.minYaw) {
                            f3 = this.seatInfo.minYaw;
                        }
                        f2 = f2 < 0.0f ? f3 - 360.0f : f3 + 360.0f;
                    }
                }
                this.looking.setAngles(f2, f, 0.0f);
                PacketDispatcher.sendPacketToServer((maaq)PacketSeatUpdates.buildUpdatePacket(this));
            }
        }
    }

    @Override
    public void updateKeyHeldState(int n, boolean bl) {
        if ((!this.field_70170_p.field_72995_K || this.foundDriveable) && this.driver) {
            this.driveable.updateKeyHeldState(n, bl);
        }
    }

    @Override
    public boolean pressKey(int n, EntityPlayer entityPlayer) {
        if (this.field_70170_p.field_72995_K && !this.foundDriveable) {
            return false;
        }
        if (this.driver && (this.field_70170_p.field_72995_K || n != 6)) {
            return this.driveable.pressKey(n, entityPlayer);
        }
        if (n == 6) {
            if (this.field_70170_p.field_72995_K) {
                PacketDispatcher.sendPacketToServer((maaq)PacketVehicleKey.buildKeyPacket(n));
            } else if (entityPlayer instanceof EntityPlayerMP) {
                samw samw2;
                EntityPlayerMP entityPlayerMP = (EntityPlayerMP)entityPlayer;
                entityPlayerMP.field_70169_q = entityPlayerMP.field_70165_t;
                entityPlayerMP.field_70167_r = entityPlayerMP.field_70163_u;
                entityPlayerMP.field_70166_s = entityPlayerMP.field_70161_v;
                double d = this.field_70165_t;
                double d2 = (float)dwbg._c((double)this.driveable.field_70163_u) - entityPlayerMP.field_70131_O / 2.0f;
                double d3 = this.field_70161_v;
                double d4 = this.driveable.axes.getYaw() % 360.0f;
                if (d4 < 0.0) {
                    d4 += 360.0;
                }
                d4 = Math.toRadians(d4);
                d += Math.sin(d4) * 1.132;
                d3 = this.seatInfo.z < 0 ? (d3 -= Math.cos(d4) * 1.132) : (d3 += Math.cos(d4) * 1.132);
                boolean bl = true;
                for (int i = 0; i <= 2; ++i) {
                    entityPlayerMP.func_70107_b(d, d2 + (double)i, d3);
                    if (!this.field_70170_p.func_72945_a((Entity)entityPlayerMP, entityPlayerMP.field_70121_D).isEmpty()) continue;
                    bl = false;
                    break;
                }
                if (bl) {
                    entityPlayerMP.func_70107_b(entityPlayerMP.field_70169_q, entityPlayerMP.field_70167_r, entityPlayerMP.field_70166_s);
                    SPacketHandler.sendHint((EntityPlayer)entityPlayerMP, (String)"carexit", (String)"\u00a7c\u0422\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u0432\u044b\u0439\u0442\u0438 \u0438\u0437 \u043c\u0430\u0448\u0438\u043d\u044b.\n\u00a7c\u041e\u0442\u044a\u0435\u0434\u044c \u043e\u0442 \u043f\u0440\u0435\u043f\u044f\u0442\u0441\u0442\u0432\u0438\u044f.", (int)255);
                    return false;
                }
                samw samw3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, (this.field_70121_D.field_72338_b + this.field_70121_D.field_72337_e) / 2.0, this.field_70161_v);
                idqh idqh2 = this.field_70170_p.func_72831_a(samw3, samw2 = this.field_70170_p.func_82732_R()._a(d, (entityPlayerMP.field_70121_D.field_72338_b + entityPlayerMP.field_70121_D.field_72337_e) / 2.0, d3), false, true);
                if (idqh2 != null) {
                    SPacketHandler.sendHint((EntityPlayer)entityPlayerMP, (String)"carexit", (String)"\u00a7c\u0422\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u0432\u044b\u0439\u0442\u0438 \u0438\u0437 \u043c\u0430\u0448\u0438\u043d\u044b.\n\u00a7c\u041e\u0442\u044a\u0435\u0434\u044c \u043e\u0442 \u043f\u0440\u0435\u043f\u044f\u0442\u0441\u0442\u0432\u0438\u044f.", (int)255);
                    return false;
                }
                if (entityPlayerMP.field_70154_o != null) {
                    entityPlayerMP.field_70154_o.field_70153_n = null;
                }
                entityPlayerMP.field_70154_o = null;
                entityPlayerMP.field_71135_a._b((maaq)new xrdl(0, (Entity)entityPlayerMP, null));
                entityPlayerMP.func_70634_a(entityPlayerMP.field_70165_t, entityPlayerMP.field_70163_u, entityPlayerMP.field_70161_v);
                SPacketHandler.sendHint((EntityPlayer)entityPlayerMP, (String)"carexit", (String)"", (int)0);
            }
            return true;
        }
        if (n == 9) {
            if (this.field_70170_p.field_72995_K) {
                PacketDispatcher.sendPacketToServer((maaq)PacketVehicleKey.buildKeyPacket(n));
            } else if (this.gunDelay <= 0 && FlansMod.bulletsEnabled) {
                BulletType bulletType;
                GunType gunType = this.seatInfo.gunType;
                ieta ieta2 = this.driveable.getDriveableData().ammo[this.seatInfo.gunnerID];
                if (gunType != null && ieta2 != null && ieta2._a() instanceof ItemBullet && gunType.isAmmo(bulletType = ((ItemBullet)ieta2._a()).type)) {
                    this.driveable.axes.findLocalAxesGlobally(this.looking);
                    Vector3f vector3f = this.driveable.axes.findLocalVectorGlobally(this.looking.getXAxis());
                    Vector3f vector3f2 = this.driveable.axes.findLocalVectorGlobally(new Vector3f(0.0f, (float)entityPlayer.func_70042_X(), 0.0f));
                    ((ItemBullet)ieta2._a()).getEntity(this.field_70170_p, Vector3f.add(vector3f2, new Vector3f((float)this.field_70165_t, (float)this.field_70163_u, (float)this.field_70161_v), null), vector3f, (EntityLivingBase)this.field_70153_n, gunType.bulletSpread, gunType.damage, 8.0f, ieta2._j(), (InfoType)this.driveable.getDriveableType());
                    int n2 = ieta2._j();
                    ieta2._b(n2 + 1);
                    if (n2 + 1 == ieta2._k()) {
                        ieta2._b(0);
                        if (--ieta2._b <= 0) {
                            this.driveable.getDriveableData().ammo[this.seatInfo.gunnerID] = null;
                        }
                        if (!((EntityPlayer)this.field_70153_n).field_71075_bZ._d) {
                            this.driveable.getDriveableData().func_70298_a(3 + this.seatID, 1);
                        }
                    }
                    this.gunDelay = gunType.shootDelay;
                }
            }
        }
        return false;
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
        if (ieta2 != null && ieta2._a() instanceof rppd) {
            if (this.field_70153_n != null && this.field_70153_n instanceof EntityLiving && !(this.field_70153_n instanceof EntityPlayer)) {
                EntityLiving entityLiving = (EntityLiving)this.field_70153_n;
                this.field_70153_n.func_70078_a(null);
                entityLiving.func_110162_b((Entity)entityPlayer, true);
                return true;
            }
            List list = this.field_70170_p.func_72872_a(EntityLiving.class, rojd.func_72330_a((double)(this.field_70165_t - 10.0), (double)(this.field_70163_u - 10.0), (double)(this.field_70161_v - 10.0), (double)(this.field_70165_t + 10.0), (double)(this.field_70163_u + 10.0), (double)(this.field_70161_v + 10.0)));
            for (Object e : list) {
                EntityLiving entityLiving = (EntityLiving)e;
                if (!entityLiving.func_110167_bD() || entityLiving.func_110166_bE() != entityPlayer) continue;
                entityLiving.func_70078_a((Entity)this);
                this.looking.setAngles(-entityLiving.field_70177_z, entityLiving.field_70125_A, 0.0f);
                entityLiving.func_110160_i(true, !entityPlayer.field_71075_bZ._d);
            }
            return true;
        }
        if (this.field_70153_n == null) {
            String string = this.driveable.locked();
            if (string != null && !entityPlayer.field_71075_bZ._d) {
                if (HCS.isHardcoreServer() && !HCS.isEntityInSafezone((Entity)this.driveable)) {
                    SPacketHandler.sendHint((EntityPlayer)entityPlayer, (String)"vechun", (String)"\u00a7c\u0425\u0430\u0440\u0434\u043a\u043e\u0440 \u0441\u0435\u0440\u0432\u0435\u0440: \u041c\u0430\u0448\u0438\u043d\u0430 \u0432\u043d\u0435 \u0441\u0435\u0439\u0444\u0437\u043e\u043d\u044b, \u0443\u0441\u043f\u0435\u0448\u043d\u043e \u0443\u0433\u043d\u0430\u043d\u043d\u0430.", (int)40);
                    this.driveable.lock(null);
                } else if (zgmv._H().__af()._h(string) == null) {
                    SPacketHandler.sendHint((EntityPlayer)entityPlayer, (String)"vechun", (String)("\u00a7c\u0412\u043b\u0430\u0434\u0435\u043b\u0435\u0446 " + string + " \u043d\u0435 \u0432 \u0438\u0433\u0440\u0435, \u043c\u0430\u0448\u0438\u043d\u0430 \u043e\u0442\u043a\u0440\u044b\u0442\u0430."), (int)40);
                    this.driveable.lock(null);
                } else if (!entityPlayer.field_71092_bJ.equals(string)) {
                    if (HCS.isHardcoreServer()) {
                        SPacketHandler.sendHint((EntityPlayer)entityPlayer, (String)"vechlc", (String)("\u00a7c\u041c\u0430\u0448\u0438\u043d\u0430 \u0437\u0430\u043f\u0435\u0440\u0442\u0430 \u043d\u0430 \u0441\u0435\u0439\u0444\u0437\u043e\u043d\u0435, \u043f\u043e\u043a\u0430 \u0432\u043b\u0430\u0434\u0435\u043b\u0435\u0446 " + string + " \u043e\u043d\u043b\u0430\u0439\u043d."), (int)40);
                    } else {
                        SPacketHandler.sendHint((EntityPlayer)entityPlayer, (String)"vechlc", (String)("\u00a7c\u041c\u0430\u0448\u0438\u043d\u0430 \u0437\u0430\u043f\u0435\u0440\u0442\u0430, \u043f\u043e\u043a\u0430 \u0432\u043b\u0430\u0434\u0435\u043b\u0435\u0446 " + string + " \u043e\u043d\u043b\u0430\u0439\u043d."), (int)40);
                    }
                    return false;
                }
            }
            entityPlayer.func_70078_a((Entity)this);
            return true;
        }
        return false;
    }

    @Override
    public Entity getControllingEntity() {
        return this.field_70153_n;
    }

    @Override
    public boolean isDead() {
        return this.field_70128_L;
    }

    public void func_70106_y() {
        super.func_70106_y();
    }

    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeInt(this.driveableID);
        byteArrayDataOutput.writeInt(this.seatInfo.id);
    }

    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        this.driveableID = byteArrayDataInput.readInt();
        this.driveable = (EntityDriveable)this.field_70170_p.func_73045_a(this.driveableID);
        this.seatID = byteArrayDataInput.readInt();
        boolean bl = this.driver = this.seatID == 0;
        if (this.driveable != null) {
            this.seatInfo = this.driveable.getDriveableType().seats[this.seatID];
            this.looking.setAngles((this.seatInfo.minYaw + this.seatInfo.maxYaw) / 2.0f, 0.0f, 0.0f);
            this.prevPlayerPosX = this.field_70165_t = this.driveable.field_70165_t;
            this.playerPosX = this.field_70165_t;
            this.prevPlayerPosY = this.field_70163_u = this.driveable.field_70163_u;
            this.playerPosY = this.field_70163_u;
            this.prevPlayerPosZ = this.field_70161_v = this.driveable.field_70161_v;
            this.playerPosZ = this.field_70161_v;
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        }
    }

    public ieta getPickedResult(idqh idqh2) {
        return this.field_70170_p.field_72995_K && !this.foundDriveable ? null : this.driveable.getPickedResult(idqh2);
    }

    @Override
    public float getPlayerRoll() {
        return this.playerRoll;
    }

    @Override
    public float getCameraDistance() {
        return this.foundDriveable && this.seatID == 0 ? this.driveable.getDriveableType().cameraDistance : 5.0f;
    }

    public boolean func_70097_a(pico pico2, float f) {
        return this.field_70170_p.field_72995_K && !this.foundDriveable ? false : this.driveable.func_70097_a(pico2, f);
    }
}

