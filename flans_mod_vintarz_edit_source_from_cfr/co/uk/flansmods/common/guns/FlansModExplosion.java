/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  briw
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cuqu
 *  decomod.decoblock.DecoBlock
 *  kjsv
 *  maaq
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.pico
 *  net.minecraft.util.pzgw
 *  net.minecraft.util.rojd
 *  net.minecraft.util.samw
 *  scko
 *  zxsm
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.client.FlansModClient;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.guns.EntityDamageSourceGun;
import co.uk.flansmods.common.guns.EntityGrenade;
import cpw.mods.fml.common.network.PacketDispatcher;
import decomod.decoblock.DecoBlock;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.pico;
import net.minecraft.util.pzgw;
import net.minecraft.util.rojd;
import net.minecraft.util.samw;

public class FlansModExplosion
extends zxsm {
    private cuqu field_77287_j;
    public InfoType type;
    public EntityPlayer player;
    public EntityGrenade e;

    public static boolean penetrable(kjsv kjsv2, boolean bl) {
        return kjsv2 == kjsv.field_71946_M || kjsv2 == kjsv.field_72003_bq || kjsv2 == kjsv.field_94347_ck || bl && (kjsv2 == kjsv.field_72031_aZ || kjsv2 == kjsv.field_72002_bp || kjsv2 == kjsv.field_72098_bB || kjsv2 == kjsv.field_72054_aE || kjsv2 instanceof DecoBlock);
    }

    public FlansModExplosion(cuqu cuqu2, Entity entity, EntityPlayer entityPlayer, InfoType infoType, double d, double d2, double d3, float f) {
        super(cuqu2, (Entity)(entityPlayer != null && FlansModPlayerHandler.serverSideData.containsKey(entityPlayer.field_71092_bJ) ? entityPlayer : entity), d, d2, d3, f);
        if (entity instanceof EntityGrenade) {
            this.e = (EntityGrenade)entity;
        }
        this.field_77287_j = cuqu2;
        this.type = infoType;
        this.player = entityPlayer;
        this.field_77286_a = false;
        this.field_82755_b = false;
        this.func_77278_a();
        this.func_77279_a(true);
        PacketDispatcher.sendPacketToAllAround((double)d, (double)d2, (double)d3, (double)128.0, (int)cuqu2.func_72912_H()._j(), (maaq)new briw(d, d2, d3, f * 2.0f, new ArrayList(), null));
    }

    public void func_77278_a() {
        if (this.field_77287_j.field_72995_K) {
            return;
        }
        int n = dwbg._c((double)(this.field_77284_b - (double)this.field_77280_f - 2.0));
        int n2 = dwbg._c((double)(this.field_77284_b + (double)this.field_77280_f + 2.0));
        int n3 = dwbg._c((double)(this.field_77285_c - (double)this.field_77280_f - 2.0));
        int n4 = dwbg._c((double)(this.field_77285_c + (double)this.field_77280_f + 2.0));
        int n5 = dwbg._c((double)(this.field_77282_d - (double)this.field_77280_f - 2.0));
        int n6 = dwbg._c((double)(this.field_77282_d + (double)this.field_77280_f + 2.0));
        List list = this.field_77287_j.func_72839_b((Entity)this.e, rojd.func_72332_a()._a((double)n, (double)n3, (double)n5, (double)n2, (double)n4, (double)n6));
        for (int i = 0; i < list.size(); ++i) {
            Entity entity = (Entity)list.get(i);
            double d = (entity.field_70130_N + entity.field_70131_O) / 2.0f;
            double d2 = entity.func_70011_f(this.field_77284_b, this.field_77285_c, this.field_77282_d) / ((double)(this.field_77280_f * 1.5f) * d);
            if (d2 > 1.0) continue;
            float f = (float)(1.0 - d2);
            Object object = this.player == null ? pico.func_94539_a((zxsm)this) : new EntityDamageSourceGun(this.type.shortName, entity, this.player, this.type);
            float f2 = f * this.field_77280_f * 6.0f;
            if (entity.field_70130_N < 1.0f && (double)entity.field_70131_O > 1.5) {
                if (this.isBehindCover(entity.field_70165_t, entity.field_70121_D.field_72338_b + 1.5, entity.field_70161_v)) {
                    if (this.isBehindCover(entity.field_70165_t, entity.field_70121_D.field_72338_b + 0.5, entity.field_70161_v)) continue;
                    f2 /= 2.0f;
                }
            } else if (this.isBehindCover(entity.field_70165_t, (entity.field_70121_D.field_72338_b + entity.field_70121_D.field_72337_e) / 2.0, entity.field_70161_v)) continue;
            if (entity instanceof EntityDriveable) {
                entity.func_70097_a(object, this.field_77280_f * 65.0f);
                continue;
            }
            entity.func_70097_a(object, Math.max(f2, 0.0f));
        }
    }

    public void func_77279_a(boolean bl) {
        this.field_77287_j.func_72908_a(this.field_77284_b, this.field_77285_c, this.field_77282_d, "random.explode", 4.0f, (1.0f + (this.field_77287_j.field_73012_v.nextFloat() - this.field_77287_j.field_73012_v.nextFloat()) * 0.2f) * 0.7f);
    }

    public EntityLivingBase func_94613_c() {
        return this.field_77283_e == null ? null : (this.field_77283_e instanceof EntityTNTPrimed ? ((EntityTNTPrimed)this.field_77283_e).func_94083_c() : (this.field_77283_e instanceof EntityLivingBase ? (EntityLivingBase)this.field_77283_e : null));
    }

    public boolean isBehindCover(double d, double d2, double d3) {
        samw samw2;
        samw samw3 = this.field_77287_j.func_82732_R()._a(this.field_77284_b, this.field_77285_c, this.field_77282_d);
        return FlansModExplosion.rayTraceBlocks(this.field_77287_j, samw3, samw2 = this.field_77287_j.func_82732_R()._a(d, d2, d3), null) != null;
    }

    public static idqh rayTraceBlocks(cuqu cuqu2, samw samw2, samw samw3, Object object) {
        boolean bl;
        boolean bl2 = bl = samw2._e(samw3) > 0.25;
        if (!(Double.isNaN(samw2._c) || Double.isNaN(samw2._d) || Double.isNaN(samw2._e))) {
            if (!(Double.isNaN(samw3._c) || Double.isNaN(samw3._d) || Double.isNaN(samw3._e))) {
                idqh idqh2;
                int n = dwbg._c((double)samw3._c);
                int n2 = dwbg._c((double)samw3._d);
                int n3 = dwbg._c((double)samw3._e);
                int n4 = dwbg._c((double)samw2._c);
                int n5 = dwbg._c((double)samw2._d);
                int n6 = dwbg._c((double)samw2._e);
                int n7 = cuqu2.func_72798_a(n4, n5, n6);
                int n8 = cuqu2.func_72805_g(n4, n5, n6);
                kjsv kjsv2 = kjsv.field_71973_m[n7];
                if (kjsv2 != null && kjsv2.func_71872_e(cuqu2, n4, n5, n6) != null && n7 > 0 && kjsv2.func_71913_a(n8, false) && (idqh2 = kjsv2.func_71878_a(cuqu2, n4, n5, n6, samw2, samw3)) != null) {
                    if (FlansModExplosion.penetrable(kjsv2, object == null) && (object == null || bl)) {
                        if (cuqu2.field_72995_K && object != null && bl) {
                            FlansModClient.penetrationEffects(kjsv2, idqh2, object);
                        }
                    } else {
                        return idqh2;
                    }
                }
                n7 = 200;
                while (n7-- >= 0) {
                    int n9;
                    idqh idqh3;
                    if (Double.isNaN(samw2._c) || Double.isNaN(samw2._d) || Double.isNaN(samw2._e)) {
                        return null;
                    }
                    if (n4 == n && n5 == n2 && n6 == n3) {
                        return null;
                    }
                    boolean bl3 = true;
                    boolean bl4 = true;
                    boolean bl5 = true;
                    double d = 999.0;
                    double d2 = 999.0;
                    double d3 = 999.0;
                    if (n > n4) {
                        d = (double)n4 + 1.0;
                    } else if (n < n4) {
                        d = (double)n4 + 0.0;
                    } else {
                        bl3 = false;
                    }
                    if (n2 > n5) {
                        d2 = (double)n5 + 1.0;
                    } else if (n2 < n5) {
                        d2 = (double)n5 + 0.0;
                    } else {
                        bl4 = false;
                    }
                    if (n3 > n6) {
                        d3 = (double)n6 + 1.0;
                    } else if (n3 < n6) {
                        d3 = (double)n6 + 0.0;
                    } else {
                        bl5 = false;
                    }
                    double d4 = 999.0;
                    double d5 = 999.0;
                    double d6 = 999.0;
                    double d7 = samw3._c - samw2._c;
                    double d8 = samw3._d - samw2._d;
                    double d9 = samw3._e - samw2._e;
                    if (bl3) {
                        d4 = (d - samw2._c) / d7;
                    }
                    if (bl4) {
                        d5 = (d2 - samw2._d) / d8;
                    }
                    if (bl5) {
                        d6 = (d3 - samw2._e) / d9;
                    }
                    if (d4 < d5 && d4 < d6) {
                        n9 = n > n4 ? 4 : 5;
                        samw2._c = d;
                        samw2._d += d8 * d4;
                        samw2._e += d9 * d4;
                    } else if (d5 < d6) {
                        n9 = n2 > n5 ? 0 : 1;
                        samw2._c += d7 * d5;
                        samw2._d = d2;
                        samw2._e += d9 * d5;
                    } else {
                        n9 = n3 > n6 ? 2 : 3;
                        samw2._c += d7 * d6;
                        samw2._d += d8 * d6;
                        samw2._e = d3;
                    }
                    samw samw4 = cuqu2.func_82732_R()._a(samw2._c, samw2._d, samw2._e);
                    samw4._c = dwbg._c((double)samw2._c);
                    n4 = (int)samw4._c;
                    if (n9 == 5) {
                        --n4;
                        samw4._c += 1.0;
                    }
                    samw4._d = dwbg._c((double)samw2._d);
                    n5 = (int)samw4._d;
                    if (n9 == 1) {
                        --n5;
                        samw4._d += 1.0;
                    }
                    samw4._e = dwbg._c((double)samw2._e);
                    n6 = (int)samw4._e;
                    if (n9 == 3) {
                        --n6;
                        samw4._e += 1.0;
                    }
                    int n10 = cuqu2.func_72798_a(n4, n5, n6);
                    int n11 = cuqu2.func_72805_g(n4, n5, n6);
                    kjsv kjsv3 = kjsv.field_71973_m[n10];
                    if (kjsv3 == null || kjsv3.func_71872_e(cuqu2, n4, n5, n6) == null || n10 <= 0 || !kjsv3.func_71913_a(n11, false) || (idqh3 = kjsv3.func_71878_a(cuqu2, n4, n5, n6, samw2, samw3)) == null) continue;
                    if (FlansModExplosion.penetrable(kjsv3, object == null) && (object == null || bl)) {
                        if (!cuqu2.field_72995_K || object == null || !bl) continue;
                        FlansModClient.penetrationEffects(kjsv3, idqh3, object);
                        continue;
                    }
                    return idqh3;
                }
                return null;
            }
            return null;
        }
        return null;
    }
}

