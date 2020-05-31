// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.entity;

import net.minecraft.util.rojd;
import net.minecraft.util.dwbg;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.hrmy;

public class ZombieAttackAi extends hrmy
{
    private static final int JUMP_DELAY = 10;
    private final EntityZombieDayZ zombie;
    private int attackTick;
    private double speedTowardsTarget;
    private int pathFindingTimeout;
    private int jump_time;
    public boolean walkToPoint;
    public double lastPathX;
    public double lastPathY;
    public double lastPathZ;
    
    ZombieAttackAi(final EntityZombieDayZ zombie, final double speedTowardsTarget) {
        this.walkToPoint = false;
        this.zombie = zombie;
        this.speedTowardsTarget = speedTowardsTarget;
        this.func_75248_a(3);
    }
    
    public boolean func_75250_a() {
        if (this.zombie.func_70638_az() != null) {
            return true;
        }
        if (this.walkToPoint) {
            final double n = this.zombie.moveX - this.zombie.field_70165_t;
            final double a = this.zombie.moveY - this.zombie.field_70163_u;
            final double n2 = this.zombie.moveZ - this.zombie.field_70161_v;
            return Math.abs(a) > 2.0 || n * n + n2 * n2 > 1.0;
        }
        return false;
    }
    
    public void func_75249_e() {
        this.pathFindingTimeout = 10 + this.zombie.func_70681_au().nextInt(10);
    }
    
    public boolean func_75253_b() {
        if (this.pathFindingTimeout > 0) {
            --this.pathFindingTimeout;
        }
        if (this.walkToPoint) {
            final double n = this.zombie.moveX - this.zombie.field_70165_t;
            final double a = this.zombie.moveY - this.zombie.field_70163_u;
            final double n2 = this.zombie.moveZ - this.zombie.field_70161_v;
            if ((Math.abs(a) < 2.0 && n * n + n2 * n2 < 1.0) || n * n + a * a + n2 * n2 > 9216.0) {
                this.walkToPoint = false;
            }
        }
        return this.walkToPoint || this.zombie.func_70638_az() != null;
    }
    
    public void func_75251_c() {
        this.zombie.func_70661_as()._h();
        this.zombie.field_70701_bs = 0.0f;
        this.zombie.field_70702_br = 0.0f;
        this.walkToPoint = false;
    }
    
    public void func_75246_d() {
        final EntityLivingBase func_70638_az = this.zombie.func_70638_az();
        if (func_70638_az != null) {
            this.walkToPoint = true;
            this.zombie.moveX = func_70638_az.field_70165_t;
            this.zombie.moveY = func_70638_az.field_70163_u;
            this.zombie.moveZ = func_70638_az.field_70161_v;
            this.attackTick = Math.max(this.attackTick - 1, 0);
            if (this.checkEntityAABB((Entity)func_70638_az, 0.25, 1.0)) {
                if (this.attackTick <= 0) {
                    this.attackTick = 20;
                    this.zombie.func_71038_i();
                    this.zombie.func_70652_k((Entity)func_70638_az);
                }
                this.zombie.func_70661_as()._h();
                this.zombie.field_70701_bs = 0.0f;
                this.zombie.field_70702_br = 0.0f;
                return;
            }
        }
        final double n = this.zombie.moveX - this.zombie.field_70165_t;
        final double a = this.zombie.moveY - this.zombie.field_70163_u;
        final double n2 = this.zombie.moveZ - this.zombie.field_70161_v;
        if (Math.abs(a) <= 2.0 && n * n + n2 * n2 <= 1.0) {
            this.zombie.func_70661_as()._h();
            this.zombie.field_70701_bs = 0.0f;
            this.zombie.field_70702_br = 0.0f;
            return;
        }
        boolean b = this.zombie.func_70661_as()._d() == null && !this.canSeeWalkSpot();
        this.zombie.func_70671_ap()._a(this.zombie.moveX, this.zombie.moveY + this.zombie.func_70047_e(), this.zombie.moveZ, 180.0f, 180.0f);
        if (this.zombie.func_70661_as()._d() != null) {
            final ssxd c = this.zombie.func_70661_as()._d()._c();
            if (c != null) {
                final double n3 = this.zombie.moveX - c._a;
                final double n4 = this.zombie.moveY - c._b;
                final double n5 = this.zombie.moveZ - c._c;
                if (n3 * n3 + n4 * n4 + n5 * n5 < 4.0) {
                    b = false;
                }
                else {
                    this.zombie.func_70661_as()._h();
                }
            }
        }
        if (b) {
            this.zombie.func_70624_b((EntityLivingBase)null);
        }
        if (b && this.pathFindingTimeout <= 0 && this.zombie.field_70122_E) {
            this.pathFindingTimeout = 20 + this.zombie.func_70681_au().nextInt(10);
            if (this.zombie.func_70092_e(this.lastPathX, this.lastPathY, this.lastPathZ) < 4.0) {
                this.walkToPoint = false;
                this.lastPathY = -1.0;
                return;
            }
            this.lastPathX = this.zombie.field_70165_t;
            this.lastPathY = this.zombie.field_70163_u;
            this.lastPathZ = this.zombie.field_70161_v;
            final mrgm a2 = this.zombie.func_70661_as()._a(this.zombie.moveX, this.zombie.moveY, this.zombie.moveZ);
            if (a2 != null) {
                final ssxd c2 = a2._c();
                if (c2 != null) {
                    final double n6 = this.zombie.moveX - c2._a;
                    final double n7 = this.zombie.moveY - c2._b;
                    final double n8 = this.zombie.moveZ - c2._c;
                    if (n6 * n6 + n7 * n7 + n8 * n8 < 4.0) {
                        this.zombie.func_70661_as()._a(a2, this.speedTowardsTarget);
                        this.lastPathY = -1.0;
                        return;
                    }
                }
            }
        }
        boolean b2 = false;
        if (this.zombie.func_70661_as()._d() == null) {
            int n9 = 0;
            float n10 = 0.91f;
            if (this.zombie.field_70122_E) {
                n10 = 0.54600006f;
                final int func_72798_a = this.zombie.field_70170_p.func_72798_a(dwbg._c(this.zombie.field_70165_t), dwbg._c(this.zombie.field_70121_D.field_72338_b) - 1, dwbg._c(this.zombie.field_70161_v));
                if (func_72798_a > 0) {
                    n10 = kjsv.field_71973_m[func_72798_a].field_72016_cq * 0.91f;
                }
            }
            final float n11 = 0.16277136f / (n10 * n10 * n10);
            float field_70747_aH;
            if (this.zombie.field_70122_E) {
                field_70747_aH = this.zombie.func_70689_ay() * n11;
            }
            else {
                field_70747_aH = this.zombie.field_70747_aH;
            }
            if (this.zombie.field_70702_br != 0.0f) {
                this.zombie.field_70701_bs = Math.abs(this.zombie.field_70702_br);
                this.zombie.field_70702_br = 0.0f;
            }
            final float field_70702_br = this.zombie.field_70702_br;
            final float field_70701_bs = this.zombie.field_70701_bs;
            final float n12 = field_70702_br * field_70702_br + field_70701_bs * field_70701_bs;
            boolean b3 = false;
            if (n12 >= 1.0E-4f) {
                float c3 = dwbg._c(n12);
                if (c3 < 1.0f) {
                    c3 = 1.0f;
                }
                final float n13 = field_70747_aH / c3;
                final float n14 = field_70702_br * (n13 * 6.0f);
                final float n15 = field_70701_bs * (n13 * 6.0f);
                final float a3 = dwbg._a(this.zombie.field_70177_z * 3.1415927f / 180.0f);
                final float b4 = dwbg._b(this.zombie.field_70177_z * 3.1415927f / 180.0f);
                final double n16 = n14 * b4 - n15 * a3;
                final double n17 = n15 * b4 + n14 * a3;
                final rojd func_72329_c = this.zombie.field_70121_D.func_72329_c();
                b3 = (!this.zombie.field_70170_p.func_72840_a(func_72329_c.func_72317_d(n16, 0.0, n17)).isEmpty() && !this.zombie.field_70170_p.func_72840_a(func_72329_c.func_72317_d(0.0, 0.5, 0.0)).isEmpty());
                n9 = ((b3 && this.zombie.field_70170_p.func_72840_a(func_72329_c.func_72317_d(0.0, 0.5, 0.0)).isEmpty()) ? 1 : 0);
            }
            this.zombie.func_70605_aq()._a(this.zombie.moveX, this.zombie.moveY, this.zombie.moveZ, 1.0);
            if (n9 != 0) {
                if (this.zombie.field_70122_E && this.jump_time == 0) {
                    this.zombie.func_70683_ar()._a();
                    this.jump_time = 10;
                    b2 = true;
                }
            }
            else if (b3) {
                this.zombie.field_70702_br = ((this.zombie.field_70173_aa / 50 % 2 == 0) ? (-this.zombie.field_70701_bs) : this.zombie.field_70701_bs);
                this.zombie.field_70701_bs = 0.0f;
            }
        }
        if (!b2 && this.zombie.field_70122_E && this.jump_time > 0) {
            --this.jump_time;
        }
    }
    
    private boolean checkEntityAABB(final Entity entity, final double n, final double n2) {
        return rojd.func_72332_a()._a(this.zombie.field_70121_D.field_72340_a - n, this.zombie.field_70121_D.field_72338_b, this.zombie.field_70121_D.field_72339_c - n, this.zombie.field_70121_D.field_72336_d + n, this.zombie.field_70121_D.field_72337_e + n2, this.zombie.field_70121_D.field_72334_f + n).func_72326_a(entity.field_70121_D);
    }
    
    private boolean canSeeWalkSpot() {
        return this.zombie.field_70170_p.func_72831_a(this.zombie.field_70170_p.func_82732_R()._a(this.zombie.moveX, this.zombie.moveY + this.zombie.func_70047_e(), this.zombie.moveZ), this.zombie.field_70170_p.func_82732_R()._a(this.zombie.field_70165_t, this.zombie.field_70163_u + this.zombie.func_70047_e(), this.zombie.field_70161_v), false, true) == null;
    }
}
