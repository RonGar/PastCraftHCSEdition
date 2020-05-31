/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ccfp
 *  co.uk.flansmods.vintarz.
 *  co.uk.flansmods.vintarz.$.TiProebal
 *  com.google.common.io.ByteArrayDataInput
 *  com.google.common.io.ByteArrayDataOutput
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.common.network.Player
 *  cpw.mods.fml.common.registry.IEntityAdditionalSpawnData
 *  cpw.mods.fml.relauncher.Side
 *  cupi
 *  cuqu
 *  decomod.decoblock.DecoBlock
 *  extendedDmgSrc.ExtendedDamageSource
 *  extendedDmgSrc.ExtendedDamageSource$BodyPart
 *  hcsmod.HCS
 *  hcsmod.entity.EntityCrawler
 *  hcsmod.entity.EntityPalatka
 *  hcsmod.entity.EntityZombieDayZ
 *  hcsmod.entity.EntityZombieHead
 *  hsus
 *  ieta
 *  kjsv
 *  maaq
 *  mquq
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityMinecart
 *  net.minecraft.entity.kjuq
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.util.dfat
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.pico
 *  net.minecraft.util.pzgw
 *  net.minecraft.util.rojd
 *  net.minecraft.util.samw
 *  net.minecraft.util.zwaq
 *  scko
 *  srmr
 *  srni
 *  zfad
 *  zgmv
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.api.IControllable;
import co.uk.flansmods.client.FlansModClient;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.DamageMultiplier;
import co.uk.flansmods.common.guns.EntityDamageSourceGun;
import co.uk.flansmods.common.guns.EntityMG;
import co.uk.flansmods.common.guns.FlansModExplosion;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.network.PacketBullet;
import co.uk.flansmods.common.network.PacketFlak;
import co.uk.flansmods.common.network.PacketHit;
import co.uk.flansmods.common.teams.Gametype;
import co.uk.flansmods.common.teams.TeamsManager;
import co.uk.flansmods.common.vector.Vector;
import co.uk.flansmods.common.vector.Vector3f;
import co.uk.flansmods.vintarz.;
import co.uk.flansmods.vintarz.PlayerRayTraceResult;
import co.uk.flansmods.vintarz.Util;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import decomod.decoblock.DecoBlock;
import extendedDmgSrc.ExtendedDamageSource;
import hcsmod.HCS;
import hcsmod.entity.EntityCrawler;
import hcsmod.entity.EntityPalatka;
import hcsmod.entity.EntityZombieDayZ;
import hcsmod.entity.EntityZombieHead;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.kjuq;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.eidl;
import net.minecraft.util.dfat;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.pico;
import net.minecraft.util.pzgw;
import net.minecraft.util.rojd;
import net.minecraft.util.samw;
import net.minecraft.util.zwaq;

public class EntityBullet
extends Entity
implements IEntityAdditionalSpawnData {
    public static final float SPREAD_MODIFIER = 0.5f;
    public static final Random bulletRng = new Random();
    public static boolean FOOL;
    public static float HITBOX_EXTEND;
    public Entity owner;
    public BulletType type;
    public InfoType firedFrom;
    public float damage;
    public boolean shotgun = false;
    private double distance = 150.0;
    private float speed;
    public int ping;
    public int skipX;
    public int skipY = -1;
    public int skipZ;
    public float slowdown;
    private final Random deflectionRng = new Random();

    public static float getDamageModifierForBlock(kjsv kjsv2) {
        if (kjsv2 == kjsv.field_72003_bq) {
            return 0.9f;
        }
        if (kjsv2 == kjsv.field_72031_aZ || kjsv2 == kjsv.field_72002_bp || kjsv2 == kjsv.field_72098_bB) {
            return 0.9f;
        }
        if (kjsv2 == kjsv.field_72054_aE || kjsv2.getClass() == zfad.class || kjsv2 instanceof srmr) {
            return 0.75f;
        }
        if (kjsv2 instanceof DecoBlock) {
            return 0.5f;
        }
        return 0.0f;
    }

    public EntityBullet(cuqu cuqu2) {
        super(cuqu2);
        this.func_70105_a(0.1f, 0.1f);
    }

    private EntityBullet(cuqu cuqu2, EntityLivingBase entityLivingBase, float f, BulletType bulletType, InfoType infoType) {
        this(cuqu2);
        this.field_70145_X = true;
        this.owner = entityLivingBase;
        this.type = bulletType;
        this.firedFrom = infoType;
        this.damage = f;
    }

    public EntityBullet(EntityPlayer entityPlayer, int n, FlansModPlayerData flansModPlayerData, float f, float f2, BulletType bulletType, float f3, boolean bl, float f4, InfoType infoType, long l) {
        this(entityPlayer.field_70170_p, (EntityLivingBase)entityPlayer, f2, bulletType, infoType);
        this.speed = f3;
        this.slowdown = f4;
        this.field_70129_M = 0.0f;
        f *= 0.5f;
        this.shotgun = bl;
        this.ping = n;
        double d = entityPlayer.func_70047_e();
        if (this.field_70170_p.field_72995_K) {
            d = 0.0;
        }
        this.field_70165_t = entityPlayer.field_70165_t;
        this.field_70161_v = entityPlayer.field_70161_v;
        this.field_70163_u = entityPlayer.field_70163_u;
        this.field_70177_z = entityPlayer.field_70177_z;
        this.field_70125_A = entityPlayer.field_70125_A + 90.0f;
        this.field_70163_u += 0.12 * -Math.sin(this.field_70125_A / 180.0f * 3.141593f);
        this.field_70177_z = entityPlayer.field_70177_z;
        double d2 = Math.cos(this.field_70125_A / 180.0f * 3.141593f);
        this.field_70165_t += d2 * 0.12 * -Math.sin(this.field_70177_z / 180.0f * 3.141593f);
        this.field_70161_v += d2 * 0.12 * Math.cos(this.field_70177_z / 180.0f * 3.141593f);
        if (!flansModPlayerData.isAiming) {
            this.field_70177_z = entityPlayer.field_70177_z + 90.0f;
            this.field_70165_t += 0.15 * -Math.sin(this.field_70177_z / 180.0f * 3.141593f);
            this.field_70161_v += 0.15 * Math.cos(this.field_70177_z / 180.0f * 3.141593f);
        }
        this.field_70177_z = entityPlayer.field_70177_z;
        this.field_70125_A = entityPlayer.field_70125_A;
        this.func_70012_b(this.field_70165_t, this.field_70163_u + d, this.field_70161_v, this.field_70177_z, this.field_70125_A);
        double d3 = (bulletRng.nextDouble() - 0.5) * 2.0;
        d3 *= Math.abs(d3);
        this.field_70125_A = (float)((double)this.field_70125_A + d3 * (double)f);
        d3 = Math.sqrt(1.0 - d3 * d3);
        double d4 = (bulletRng.nextDouble() - 0.5) * 2.0;
        d4 *= Math.abs(d4);
        d4 = d4 * d3 * (double)f / 180.0 * 3.141592653589793;
        this.field_70159_w = -Math.sin(this.field_70177_z / 180.0f * 3.141593f) * Math.cos(this.field_70125_A / 180.0f * 3.141593f);
        this.field_70179_y = Math.cos(this.field_70177_z / 180.0f * 3.141593f) * Math.cos(this.field_70125_A / 180.0f * 3.141593f);
        this.field_70181_x = -Math.sin(this.field_70125_A / 180.0f * 3.141593f);
        this.field_70159_w -= Math.sin((this.field_70177_z + 90.0f) / 180.0f * 3.141593f) * Math.tan(d4);
        this.field_70179_y += Math.cos((this.field_70177_z + 90.0f) / 180.0f * 3.141593f) * Math.tan(d4);
        d2 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
        this.field_70159_w /= d2;
        this.field_70181_x /= d2;
        this.field_70179_y /= d2;
        this.field_70159_w *= (double)f3;
        this.field_70181_x *= (double)f3;
        this.field_70179_y *= (double)f3;
        float f5 = (float)Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / 3.1415927410125732);
        this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f5) * 180.0 / 3.1415927410125732);
        this.deflectionRng.setSeed(l);
        this.doAttack();
    }

    public EntityBullet(cuqu cuqu2, samw samw2, float f, float f2, EntityLivingBase entityLivingBase, float f3, float f4, BulletType bulletType, InfoType infoType) {
        this(cuqu2, samw2, f, f2, entityLivingBase, f3, f4, bulletType, 7.0f, infoType);
        this.doAttack();
    }

    public EntityBullet(cuqu cuqu2, samw samw2, float f, float f2, EntityLivingBase entityLivingBase, float f3, float f4, BulletType bulletType, float f5, InfoType infoType) {
        this(cuqu2, entityLivingBase, f4, bulletType, infoType);
        this.damage = f4;
        this.func_70012_b(samw2._c, samw2._d, samw2._e, f, f2);
        this.field_70165_t -= Math.cos(this.field_70177_z / 180.0f * 3.141593f) * 0.0;
        this.field_70163_u -= 0.0;
        this.field_70161_v -= Math.sin(this.field_70177_z / 180.0f * 3.141593f) * 0.0;
        this.field_70159_w = -Math.sin(this.field_70177_z / 180.0f * 3.141593f) * Math.cos(this.field_70125_A / 180.0f * 3.141593f);
        this.field_70179_y = Math.cos(this.field_70177_z / 180.0f * 3.141593f) * Math.cos(this.field_70125_A / 180.0f * 3.141593f);
        this.field_70181_x = -Math.sin(this.field_70125_A / 180.0f * 3.141593f);
        this.setArrowHeading(this.field_70159_w, this.field_70181_x, this.field_70179_y, f3, f5);
    }

    public EntityBullet(cuqu cuqu2, Vector3f vector3f, Vector3f vector3f2, EntityLivingBase entityLivingBase, float f, float f2, BulletType bulletType, float f3, InfoType infoType) {
        this(cuqu2, entityLivingBase, f2, bulletType, infoType);
        this.damage = f2;
        this.func_70107_b((double)vector3f.x, (double)vector3f.y, (double)vector3f.z);
        this.field_70159_w = vector3f2.x;
        this.field_70181_x = vector3f2.y;
        this.field_70179_y = vector3f2.z;
        this.setArrowHeading(this.field_70159_w, this.field_70181_x, this.field_70179_y, f, f3);
        this.doAttack();
    }

    public EntityBullet(cuqu cuqu2, samw samw2, float f, float f2, double d, double d2, double d3, EntityLivingBase entityLivingBase, float f3, BulletType bulletType, InfoType infoType) {
        this(cuqu2);
        this.shotgun = false;
        this.type = bulletType;
        this.firedFrom = infoType;
        this.owner = entityLivingBase;
        this.damage = f3;
        this.func_70012_b(samw2._c, samw2._d, samw2._e, f, f2);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70159_w = d;
        this.field_70181_x = d2;
        this.field_70179_y = d3;
        this.doAttack();
    }

    private void doAttack() {
        if (HCS.doAttack((EntityBullet)this)) {
            if (this.type.explosion > 0) {
                if (!this.field_70170_p.field_72995_K) {
                    this.field_70170_p.func_72838_d((Entity)this);
                }
            } else {
                this.func_70071_h_();
                if (this.field_70128_L) {
                    return;
                }
                if (!this.field_70170_p.field_72995_K) {
                    this.field_70170_p.func_72838_d((Entity)this);
                } else {
                    FlansModClient.clientBullets.add(this);
                }
            }
        }
    }

    protected void func_70088_a() {
    }

    public void setArrowHeading(double d, double d2, double d3, float f, float f2) {
        float f3 = (float)Math.sqrt(d * d + d2 * d2 + d3 * d3);
        d /= (double)f3;
        d2 /= (double)f3;
        d3 /= (double)f3;
        f3 = (float)Math.sqrt((d += this.field_70146_Z.nextGaussian() * 0.005 * (double)f) * d + (d2 += this.field_70146_Z.nextGaussian() * 0.005 * (double)f) * d2 + (d3 += this.field_70146_Z.nextGaussian() * 0.005 * (double)f) * d3);
        d /= (double)f3;
        d2 /= (double)f3;
        d3 /= (double)f3;
        this.field_70159_w = d *= (double)f2;
        this.field_70181_x = d2 *= (double)f2;
        this.field_70179_y = d3 *= (double)f2;
        float f4 = (float)Math.sqrt(d * d + d3 * d3);
        this.field_70126_B = this.field_70177_z = (float)(Math.atan2(d, d3) * 180.0 / 3.1415927410125732);
        this.field_70127_C = this.field_70125_A = (float)(Math.atan2(d2, f4) * 180.0 / 3.1415927410125732);
    }

    public void func_70016_h(double d, double d2, double d3) {
        this.field_70159_w = d;
        this.field_70181_x = d2;
        this.field_70179_y = d3;
        if (this.field_70127_C == 0.0f && this.field_70126_B == 0.0f) {
            float f = (float)Math.sqrt(d * d + d3 * d3);
            this.field_70126_B = this.field_70177_z = (float)(Math.atan2(d, d3) * 180.0 / 3.1415927410125732);
            this.field_70127_C = this.field_70125_A = (float)(Math.atan2(d2, f) * 180.0 / 3.1415927410125732);
            this.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
        }
    }

    public void func_70071_h_() {
        if (this.field_70173_aa > 0 && this.firedFrom instanceof GunType) {
            double d = this.field_70170_p.func_72803_f(dwbg._c((double)this.field_70165_t), dwbg._c((double)this.field_70163_u), dwbg._c((double)this.field_70161_v)) == ccfp._h ? 0.800000011920929 : Math.min(1.0 - (double)this.slowdown * 0.01, 1.0);
            this.field_70181_x = FOOL ? (this.field_70181_x += (double)this.type.fallSpeed * 0.3) : (this.field_70181_x -= (double)this.type.fallSpeed * 0.2);
            this.field_70159_w *= d;
            this.field_70181_x *= d;
            this.field_70179_y *= d;
        }
        try {
            block65 : {
                block64 : {
                    double d;
                    double d2;
                    double d3;
                    double d4;
                    double d5;
                    block61 : {
                        block63 : {
                            block62 : {
                                Object object;
                                double d6;
                                int n;
                                Object object2;
                                Object object3;
                                boolean bl;
                                double d7;
                                Object object4;
                                float f = 1.0f;
                                boolean bl2 = false;
                                d5 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
                                float f2 = this.speed == 0.0f ? 1.0f : (float)Math.min(d5 / (double)this.speed, 1.0);
                                samw samw2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                                samw samw3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
                                Object object5 = this.rayTraceBlocks(samw2, samw3);
                                samw2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                                samw3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
                                if (object5 != null) {
                                    kjsv kjsv2 = (kjsv)object5._h;
                                    f = EntityBullet.getDamageModifierForBlock(kjsv2);
                                    samw3 = object5._f;
                                    if (f != 1.0f) {
                                        boolean bl3 = bl2 = kjsv2 != kjsv.field_72003_bq;
                                        if (!this.field_70170_p.field_72995_K) {
                                            PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)64.0, (int)this.field_70170_p.func_72912_H()._j(), (maaq)PacketBullet.buildPacket(samw3._c, samw3._d, samw3._e, this.field_70169_q, this.field_70167_r, this.field_70166_s, object5, this.owner, this.damage, false));
                                        }
                                    }
                                }
                                double d8 = samw2._d(samw3);
                                List list = this.field_70170_p.func_94576_a((Entity)this, rojd.func_72330_a((double)(Math.min(samw2._c, samw3._c) - 0.1), (double)(Math.min(samw2._d, samw3._d) - 0.1), (double)(Math.min(samw2._e, samw3._e) - 0.1), (double)(Math.max(samw2._c, samw3._c) + 0.1), (double)(Math.max(samw2._d, samw3._d) + 0.1), (double)(Math.max(samw2._e, samw3._e) + 0.1)), new mquq(){

                                    public boolean func_82704_a(Entity entity) {
                                        return entity.func_70089_S() && entity.func_70067_L() && !(entity instanceof EntityPalatka) && !(entity instanceof IControllable) && !(entity instanceof EntityPlayer) && !(entity instanceof EntityMinecart);
                                    }
                                });
                                for (Entity entity : list) {
                                    object3 = entity.field_70121_D.func_72327_a(samw2, samw3);
                                    if (object3 == null || !((d = samw2._d(object3._f)) < d8)) continue;
                                    object5 = object3;
                                    object5._g = entity;
                                    object5._a = dfat._b;
                                    d8 = d;
                                }
                                if (object5 != null) {
                                    samw3 = object5._f;
                                }
                                try {
                                    object4 = .TiProebal.rayTracePlayers((EntityPlayerMP)((EntityPlayerMP)this.owner), (long)this.ping, (samw)samw2, (samw)samw3);
                                }
                                catch (Throwable throwable) {
                                    for (Object object6 : this.field_70170_p.field_72996_f) {
                                        if (object6 == this.owner || !(object6 instanceof EntityPlayer) || !(object = (EntityPlayer)object6).func_70089_S() || (object2 = object.field_70121_D.func_72314_b((double)HITBOX_EXTEND, (double)HITBOX_EXTEND, (double)HITBOX_EXTEND).func_72327_a(samw2, samw3)) == null || !((d6 = samw2._d(((idqh)object2)._f)) < d8)) continue;
                                        object5 = object2;
                                        object5._g = object;
                                        object5._a = dfat._b;
                                        d8 = d6;
                                    }
                                    object4 = null;
                                }
                                if (object4 != null) {
                                    object5 = ((PlayerRayTraceResult)object4).hit;
                                }
                                if (object5 != null) {
                                    samw3 = object5._f;
                                }
                                for (int i = 0; i < this.field_70170_p.field_72996_f.size(); ++i) {
                                    Object object6;
                                    object3 = this.field_70170_p.field_72996_f.get(i);
                                    if (!(object3 instanceof EntityDriveable) || !(object6 = (EntityDriveable)object3).func_70089_S() || ((EntityDriveable)object6).isPartOfThis(this.owner) || !((double)this.func_70032_d((Entity)object6) <= Math.sqrt(this.func_70092_e(samw3._c, samw3._d, samw3._e)))) continue;
                                    object2 = new Vector3f((float)this.field_70159_w, (float)this.field_70181_x, (float)this.field_70179_y);
                                    d6 = ((Vector)object2).length();
                                    ((Vector)object2).normalise();
                                    Vector3f vector3f = new Vector3f((float)this.field_70165_t, (float)this.field_70163_u, (float)this.field_70161_v);
                                    n = 0;
                                    while ((double)n < d6) {
                                        if (!(vector3f.x > -147.0f && this.field_70165_t < 163.0 && this.field_70161_v > -156.0 && this.field_70161_v < 153.0 && this.field_70163_u > 10.0)) {
                                            object = ((EntityDriveable)object6).attackFromBullet(this, vector3f, (Vector3f)object2);
                                            if (object != null) {
                                                this.field_70169_q = this.field_70165_t;
                                                this.field_70167_r = this.field_70163_u;
                                                this.field_70166_s = this.field_70161_v;
                                                this.field_70165_t = vector3f.x;
                                                this.field_70163_u = vector3f.y;
                                                this.field_70161_v = vector3f.z;
                                                if (!this.field_70170_p.field_72995_K) {
                                                    if (this.field_70173_aa == 0 && this.owner instanceof EntityPlayer) {
                                                        zgmv._H().__af()._a((EntityPlayer)this.owner, this.field_70165_t, this.field_70163_u, this.field_70161_v, 64.0, this.field_70170_p.func_72912_H()._j(), PacketBullet.buildPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70169_q, this.field_70167_r, this.field_70166_s, object5, this.owner, this.damage, false));
                                                    }
                                                    if (this.owner instanceof Player) {
                                                        PacketDispatcher.sendPacketToPlayer((maaq)PacketHit.buildPacket(false), (Player)((Player)this.owner));
                                                    }
                                                }
                                                this.func_70106_y();
                                                return;
                                            }
                                            vector3f.translate(((Vector3f)object2).x, ((Vector3f)object2).y, ((Vector3f)object2).z);
                                        }
                                        ++n;
                                    }
                                }
                                if (!this.field_70170_p.field_72995_K && object5 != null && object5._g instanceof EntityPlayer) {
                                    EntityPlayer entityPlayer = (EntityPlayer)object5._g;
                                    if (entityPlayer.field_71075_bZ._a || this.owner instanceof EntityPlayer && !((EntityPlayer)this.owner).func_96122_a(entityPlayer)) {
                                        object5 = null;
                                    }
                                }
                                d2 = this.field_70165_t;
                                d = this.field_70163_u;
                                d4 = this.field_70161_v;
                                this.field_70165_t = samw3._c;
                                this.field_70163_u = samw3._d;
                                this.field_70161_v = samw3._e;
                                if (object5 != null && object5._g != null) {
                                    this.field_70169_q = d2;
                                    this.field_70167_r = d;
                                    this.field_70166_s = d4;
                                    if (!this.field_70170_p.field_72995_K) {
                                        Object object7;
                                        ExtendedDamageSource.BodyPart bodyPart;
                                        DamageMultiplier damageMultiplier;
                                        Entity entity = object5._g;
                                        boolean bl4 = false;
                                        n = 0;
                                        if (object4 != null && entity instanceof EntityPlayerMP) {
                                            object7 = (EntityPlayerMP)entity;
                                            try {
                                                bodyPart = .TiProebal.getHitBodyPart((PlayerRayTraceResult)object4, (Entity)object7);
                                                bl4 = bodyPart == ExtendedDamageSource.BodyPart.HEAD;
                                                damageMultiplier = .TiProebal.getBulletDamage((EntityPlayer)object7, (EntityBullet)this, (PlayerRayTraceResult)object4, (ExtendedDamageSource.BodyPart)bodyPart);
                                                if (damageMultiplier != null) {
                                                    f2 *= damageMultiplier.value;
                                                }
                                            }
                                            catch (Throwable throwable) {}
                                        } else if (entity instanceof EntityZombieHead || entity instanceof EntityCrawler) {
                                            n = 1;
                                            if (HCS.isHardcoreServer()) {
                                                this.damage *= 2.5f;
                                            }
                                        } else {
                                            object7 = kjuq._b((Entity)entity);
                                            if (object7 != null && ((String)object7).startsWith("mcheli.MCH.E.")) {
                                                this.damage /= 2.0f;
                                            }
                                        }
                                        float f3 = this.damage * this.type.damageVsLiving;
                                        bodyPart = this.owner == null ? pico.field_76377_j : this.getBulletDamage(bl4);
                                        .TiProebal.resetDamage();
                                        if (f3 == 0.0f && entity instanceof EntityPlayerMP && TeamsManager.getInstance().currentGametype != null) {
                                            TeamsManager.getInstance().currentGametype.playerAttacked((EntityPlayerMP)entity, (pico)bodyPart);
                                        }
                                        if (entity.func_70097_a((pico)bodyPart, f3 * f2) && entity instanceof EntityLivingBase) {
                                            ++((EntityLivingBase)entity).field_70720_be;
                                            ((EntityLivingBase)entity).field_70172_ad = 0;
                                            if (this.owner instanceof Player) {
                                                PacketDispatcher.sendPacketToPlayer((maaq)PacketHit.buildPacket(false), (Player)((Player)this.owner));
                                            }
                                            if (n != 0 || entity instanceof EntityZombieDayZ) {
                                                damageMultiplier = (EntityZombieDayZ)entity;
                                                ((EntityZombieDayZ)damageMultiplier).stop = 8;
                                                ((EntityZombieDayZ)damageMultiplier).slowdown = 30;
                                            }
                                        }
                                        int n2 = Math.max(1, (int)(this.damage / 2.0f));
                                        PacketDispatcher.sendPacketToAllAround((double)samw3._c, (double)samw3._d, (double)samw3._e, (double)128.0, (int)this.field_70170_p.func_72912_H()._j(), (maaq)PacketFlak.buildFlakPacket(samw3._c, samw3._d, samw3._e, n2, "tilecrack_35_14", this.field_70159_w / 512.0, this.field_70181_x / 512.0, this.field_70179_y / 512.0));
                                        if (this.field_70173_aa == 0) {
                                            PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)64.0, (int)this.field_70170_p.func_72912_H()._j(), (maaq)PacketBullet.buildPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, d2, d, d4, object5, this.owner, this.damage, false));
                                        }
                                    }
                                    this.func_70106_y();
                                    return;
                                }
                                if (object5 == null || object5._a != dfat._a) break block61;
                                this.field_70169_q = d2;
                                this.field_70167_r = d;
                                this.field_70166_s = d4;
                                boolean bl5 = bl = f == 0.0f;
                                if (this.field_70170_p.field_72995_K) {
                                    Util.clientBulletEffects(object5, this, false);
                                } else if (this.field_70173_aa == 0) {
                                    PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)64.0, (int)this.field_70170_p.func_72912_H()._j(), (maaq)PacketBullet.buildPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, d2, d, d4, object5, this.owner, this.damage, bl));
                                }
                                if (bl) {
                                    this.func_70106_y();
                                    return;
                                }
                                this.field_70159_w *= (double)f;
                                this.field_70181_x *= (double)f;
                                this.field_70179_y *= (double)f;
                                if (bl2) {
                                    this.field_70159_w += (this.deflectionRng.nextDouble() - 0.5) * (0.1 + d5 / 30.0);
                                    this.field_70181_x += (this.deflectionRng.nextDouble() - 0.5) * (0.1 + d5 / 30.0);
                                    this.field_70179_y += (this.deflectionRng.nextDouble() - 0.5) * (0.1 + d5 / 30.0);
                                }
                                if (this.field_70163_u > 256.0 || this.field_70163_u < 0.0 || this.speed < 0.5f) break block62;
                                this.distance -= (double)this.speed;
                                if (!(d7 < 0.0)) break block63;
                            }
                            this.func_70106_y();
                            return;
                        }
                        if (this.field_70170_p.field_72995_K) {
                            Util.clientBulletUpdate(this);
                        } else if (this.field_70173_aa == 0) {
                            zgmv._H().__af()._a((EntityPlayer)this.owner, this.field_70165_t, this.field_70163_u, this.field_70161_v, 32.0, this.field_70170_p.func_72912_H()._j(), PacketBullet.buildPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70169_q, this.field_70167_r, this.field_70166_s, null, this.owner, this.damage, true));
                        }
                        return;
                    }
                    this.field_70165_t = d2;
                    this.field_70163_u = d;
                    this.field_70161_v = d4;
                    this.skipY = -1;
                    this.field_70169_q = this.field_70165_t;
                    this.field_70167_r = this.field_70163_u;
                    this.field_70166_s = this.field_70161_v;
                    this.field_70165_t += this.field_70159_w;
                    this.field_70163_u += this.field_70181_x;
                    this.field_70161_v += this.field_70179_y;
                    this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    if (this.field_70163_u > 256.0 || this.field_70163_u < 0.0 || d5 < 0.5) break block64;
                    this.distance -= d5;
                    if (!(d3 < 0.0)) break block65;
                }
                this.func_70106_y();
                return;
            }
            if (!this.field_70170_p.field_72995_K) {
                float f = (float)Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
                this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / 3.1415927410125732);
                this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0 / 3.1415927410125732);
            }
        }
        catch (Exception exception) {
            this.func_70106_y();
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            Util.clientBulletUpdate(this);
        } else if (this.field_70173_aa == 0) {
            zgmv._H().__af()._a((EntityPlayer)this.owner, this.field_70165_t, this.field_70163_u, this.field_70161_v, 32.0, this.field_70170_p.func_72912_H()._j(), PacketBullet.buildPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70169_q, this.field_70167_r, this.field_70166_s, null, this.owner, this.damage, true));
        }
    }

    private idqh rayTraceBlocks(samw samw2, samw samw3) {
        if (!(Double.isNaN(samw2._c) || Double.isNaN(samw2._d) || Double.isNaN(samw2._e))) {
            if (!(Double.isNaN(samw3._c) || Double.isNaN(samw3._d) || Double.isNaN(samw3._e))) {
                int n;
                int n2;
                int n3 = dwbg._c((double)samw3._c);
                int n4 = dwbg._c((double)samw3._d);
                int n5 = dwbg._c((double)samw3._e);
                int n6 = dwbg._c((double)samw2._c);
                int n7 = dwbg._c((double)samw2._d);
                int n8 = dwbg._c((double)samw2._e);
                if (this.skipY != n7 && this.skipX != n6 && this.skipZ != n8) {
                    n = this.field_70170_p.func_72798_a(n6, n7, n8);
                    n2 = this.field_70170_p.func_72805_g(n6, n7, n8);
                    kjsv kjsv2 = kjsv.field_71973_m[n];
                    if (kjsv2 != null) {
                        idqh idqh2;
                        ccfp ccfp2 = kjsv2.field_72018_cp;
                        if (kjsv2.func_71935_l() && (ccfp2._a() || ccfp2 != ccfp._j && ccfp2 != ccfp._F && ccfp2 != ccfp._k && ccfp2 != ccfp._l && ccfp2 != ccfp._q) && (kjsv2.func_71872_e(this.field_70170_p, n6, n7, n8) != null || kjsv2.func_71913_a(n2, true)) && (idqh2 = kjsv2.func_71878_a(this.field_70170_p, n6, n7, n8, samw2, samw3)) != null) {
                            idqh2._h = kjsv2;
                            this.skipX = n6;
                            this.skipY = n7;
                            this.skipZ = n8;
                            return idqh2;
                        }
                    }
                }
                n = 200;
                while (n-- >= 0) {
                    idqh idqh3;
                    int n9;
                    if (Double.isNaN(samw2._c) || Double.isNaN(samw2._d) || Double.isNaN(samw2._e)) {
                        return null;
                    }
                    if (n6 == n3 && n7 == n4 && n8 == n5) {
                        return null;
                    }
                    n2 = 1;
                    boolean bl = true;
                    boolean bl2 = true;
                    double d = 999.0;
                    double d2 = 999.0;
                    double d3 = 999.0;
                    if (n3 > n6) {
                        d = (double)n6 + 1.0;
                    } else if (n3 < n6) {
                        d = (double)n6 + 0.0;
                    } else {
                        n2 = 0;
                    }
                    if (n4 > n7) {
                        d2 = (double)n7 + 1.0;
                    } else if (n4 < n7) {
                        d2 = (double)n7 + 0.0;
                    } else {
                        bl = false;
                    }
                    if (n5 > n8) {
                        d3 = (double)n8 + 1.0;
                    } else if (n5 < n8) {
                        d3 = (double)n8 + 0.0;
                    } else {
                        bl2 = false;
                    }
                    double d4 = 999.0;
                    double d5 = 999.0;
                    double d6 = 999.0;
                    double d7 = samw3._c - samw2._c;
                    double d8 = samw3._d - samw2._d;
                    double d9 = samw3._e - samw2._e;
                    if (n2 != 0) {
                        d4 = (d - samw2._c) / d7;
                    }
                    if (bl) {
                        d5 = (d2 - samw2._d) / d8;
                    }
                    if (bl2) {
                        d6 = (d3 - samw2._e) / d9;
                    }
                    if (d4 < d5 && d4 < d6) {
                        n9 = n3 > n6 ? 4 : 5;
                        samw2._c = d;
                        samw2._d += d8 * d4;
                        samw2._e += d9 * d4;
                    } else if (d5 < d6) {
                        n9 = n4 > n7 ? 0 : 1;
                        samw2._c += d7 * d5;
                        samw2._d = d2;
                        samw2._e += d9 * d5;
                    } else {
                        n9 = n5 > n8 ? 2 : 3;
                        samw2._c += d7 * d6;
                        samw2._d += d8 * d6;
                        samw2._e = d3;
                    }
                    samw samw4 = this.field_70170_p.func_82732_R()._a(samw2._c, samw2._d, samw2._e);
                    samw4._c = dwbg._c((double)samw2._c);
                    n6 = (int)samw4._c;
                    if (n9 == 5) {
                        --n6;
                        samw4._c += 1.0;
                    }
                    samw4._d = dwbg._c((double)samw2._d);
                    n7 = (int)samw4._d;
                    if (n9 == 1) {
                        --n7;
                        samw4._d += 1.0;
                    }
                    samw4._e = dwbg._c((double)samw2._e);
                    n8 = (int)samw4._e;
                    if (n9 == 3) {
                        --n8;
                        samw4._e += 1.0;
                    }
                    if (n7 == this.skipY && n6 == this.skipX && n8 == this.skipZ) continue;
                    int n10 = this.field_70170_p.func_72798_a(n6, n7, n8);
                    int n11 = this.field_70170_p.func_72805_g(n6, n7, n8);
                    kjsv kjsv3 = kjsv.field_71973_m[n10];
                    if (kjsv3 == null) continue;
                    ccfp ccfp3 = kjsv3.field_72018_cp;
                    if (!kjsv3.func_71935_l() || !ccfp3._a() && (ccfp3 == ccfp._j || ccfp3 == ccfp._F || ccfp3 == ccfp._k || ccfp3 == ccfp._l || ccfp3 == ccfp._q) || kjsv3.func_71872_e(this.field_70170_p, n6, n7, n8) == null && !kjsv3.func_71913_a(n11, true) || (idqh3 = kjsv3.func_71878_a(this.field_70170_p, n6, n7, n8, samw2, samw3)) == null) continue;
                    idqh3._h = kjsv3;
                    this.skipX = n6;
                    this.skipY = n7;
                    this.skipZ = n8;
                    return idqh3;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private pico getBulletDamage(boolean bl) {
        return this.owner instanceof EntityPlayer ? new EntityDamageSourceGun(this.type.shortName, (EntityPlayer)this.owner, this.firedFrom, bl).func_76349_b() : new zwaq(this.type.shortName, this.owner).func_76349_b();
    }

    private boolean isPartOfOwner(Entity entity) {
        if (this.owner == null) {
            return false;
        }
        if (entity != this.owner && entity != this.owner.field_70153_n && entity != this.owner.field_70154_o) {
            if (this.owner instanceof EntityPlayer) {
                if (FlansModPlayerHandler.getPlayerData((EntityPlayer)this.owner, this.field_70170_p.field_72995_K ? Side.CLIENT : Side.SERVER) == null) {
                    return false;
                }
                EntityMG entityMG = FlansModPlayerHandler.getPlayerData((EntityPlayer)((EntityPlayer)this.owner), (Side)(this.field_70170_p.field_72995_K != false ? Side.CLIENT : Side.SERVER)).mountingGun;
                if (entityMG != null && entityMG == entity) {
                    return true;
                }
            }
            return !(this.owner.field_70154_o instanceof EntitySeat) ? false : ((EntitySeat)this.owner.field_70154_o).driveable == null || ((EntitySeat)this.owner.field_70154_o).driveable.isPartOfThis(entity);
        }
        return true;
    }

    public void func_70106_y() {
        if (!this.field_70128_L) {
            super.func_70106_y();
            if (this.field_70170_p.field_72995_K) {
                Util.clientBulletUpdate(this);
            }
            try {
                if (!this.field_70170_p.field_72995_K) {
                    int n;
                    if (this.type.explosion > 0) {
                        if (this.owner instanceof EntityPlayer) {
                            new co.uk.flansmods.common.guns.FlansModExplosion(this.field_70170_p, this, (EntityPlayer)this.owner, this.firedFrom, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.explosion);
                        } else {
                            new co.uk.flansmods.common.guns.FlansModExplosion(this.field_70170_p, this, null, this.firedFrom, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.explosion);
                        }
                    }
                    if (this.type.fire > 0) {
                        for (int i = (int)this.field_70165_t - this.type.fire; i < (int)this.field_70165_t + this.type.fire; ++i) {
                            for (n = (int)this.field_70161_v - this.type.fire; n < (int)this.field_70161_v + this.type.fire; ++n) {
                                for (int j = (int)this.field_70163_u - 1; j < (int)this.field_70163_u + 1; ++j) {
                                    if (this.field_70170_p.func_72803_f(i, j, n) != ccfp._a) continue;
                                    this.field_70170_p.func_72832_d(i, j, n, kjsv.field_72067_ar.field_71990_ca, 0, 3);
                                }
                            }
                        }
                    }
                    if (this.type.flak > 0) {
                        PacketDispatcher.sendPacketToAllAround((double)this.field_70165_t, (double)this.field_70163_u, (double)this.field_70161_v, (double)128.0, (int)this.field_71093_bK, (maaq)PacketFlak.buildFlakPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.flak, this.type.flakParticles));
                    }
                    if (this.type.dropItemOnHit != null) {
                        String string = this.type.dropItemOnHit;
                        n = 0;
                        if (string.contains(".")) {
                            n = Integer.parseInt(string.split("\\.")[1]);
                            string = string.split("\\.")[0];
                        }
                        ieta ieta2 = InfoType.getRecipeElement(string, n);
                        this.func_70099_a(ieta2, 1.0f);
                    }
                }
            }
            catch (Exception exception) {}
        }
    }

    public boolean func_70039_c(hsus hsus2) {
        return false;
    }

    protected void func_70037_a(hsus hsus2) {
    }

    protected void func_70014_b(hsus hsus2) {
    }

    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeDouble(this.field_70159_w);
        byteArrayDataOutput.writeDouble(this.field_70181_x);
        byteArrayDataOutput.writeDouble(this.field_70179_y);
        byteArrayDataOutput.writeUTF(this.type.shortName);
        byteArrayDataOutput.writeByte((int)(this.slowdown * 255.0f));
        if (this.owner == null) {
            byteArrayDataOutput.writeInt(-1);
        } else {
            byteArrayDataOutput.writeInt(this.owner.field_70157_k);
        }
        if (this.firedFrom instanceof GunType) {
            byteArrayDataOutput.writeUTF(this.firedFrom.shortName);
        }
    }

    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        try {
            this.field_70159_w = byteArrayDataInput.readDouble();
            this.field_70181_x = byteArrayDataInput.readDouble();
            this.field_70179_y = byteArrayDataInput.readDouble();
            this.type = BulletType.getBullet(byteArrayDataInput.readUTF());
            this.slowdown = (float)byteArrayDataInput.readUnsignedByte() / 255.0f;
            this.owner = this.field_70170_p.func_73045_a(byteArrayDataInput.readInt());
        }
        catch (Exception exception) {
            FlansMod.log("Failed to read bullet owner from server.");
            super.func_70106_y();
            exception.printStackTrace();
        }
        try {
            this.firedFrom = GunType.getGun(byteArrayDataInput.readUTF());
        }
        catch (Throwable throwable) {}
    }

    static {
        HITBOX_EXTEND = 0.2f;
    }

}

