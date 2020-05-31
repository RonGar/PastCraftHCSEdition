// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.entity;

import java.util.List;
import net.minecraft.entity.zway;
import java.util.Iterator;
import hcsmod.player.ExtendedPlayer;
import net.minecraft.util.dwbg;
import hcsmod.effects.EnactEffect;
import hcsmod.effects.Effect;
import net.minecraftforge.common.zwaq;
import net.minecraft.entity.item.EntityItem;
import hcsmod.HCS;
import net.minecraft.entity.EntityLivingBase;
import vintarz.core.VCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.pico;
import net.minecraft.entity.Entity;
import net.minecraft.entity.srlj;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.pzgw;
import net.minecraft.entity.ai.hrmy;
import net.minecraft.entity.monster.EntityMob;

public class EntityZombieDayZ extends EntityMob
{
    static final int[] detect_distances_f;
    static final int[] detect_distances_b;
    static final int[] loot_from_zombie;
    public static RandomDropCallback randomDropCallback;
    private boolean firstUpdate;
    public int texture;
    public final ZombieAttackAi attackAi;
    public double moveX;
    public double moveY;
    public double moveZ;
    public int slowdown;
    public int stop;
    private boolean armor;
    private boolean hpMod;
    
    public EntityZombieDayZ(final cuqu cuqu) {
        super(cuqu);
        this.firstUpdate = true;
        this.texture = this.getRandomZombieTexture();
        this.attackAi = new ZombieAttackAi(this, 1.0);
        this.slowdown = 0;
        this.stop = 0;
        this.func_70105_a(0.7f, 1.7f);
        this.field_70714_bg._a(1, (hrmy)this.attackAi);
        this.field_70714_bg._a(2, (hrmy)new pzgw((EntityCreature)this, 0.7));
        this.field_70180_af._a(20, (Object)0);
        this.field_70180_af._b(20, (Object)this.texture);
    }
    
    public EntityZombieDayZ(final cuqu cuqu, final boolean armor) {
        this(cuqu);
        this.armor = armor;
        this.func_82164_bB();
        for (int i = 0; i < this.field_82174_bp.length; ++i) {
            this.field_82174_bp[i] = 0.04f;
        }
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(srlj._a)._a(36.0);
        this.func_110148_a(srlj._d)._a(0.35);
        this.func_110148_a(srlj._b)._a(32.0);
    }
    
    private int getRandomZombieTexture() {
        return super.field_70146_Z.nextInt(18);
    }
    
    protected boolean func_70692_ba() {
        return true;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected String func_70639_aQ() {
        return "mob.zombie.say";
    }
    
    protected String func_70621_aR() {
        return "mob.zombie.hurt";
    }
    
    protected String func_70673_aS() {
        return "mob.zombie.death";
    }
    
    protected void func_70036_a(final int n, final int n2, final int n3, final int n4) {
        super.field_70170_p.func_72956_a((Entity)this, "mob.zombie.step", 1.5f, (this instanceof EntityCrawler) ? 0.75f : 1.0f);
    }
    
    protected Entity func_70782_k() {
        return null;
    }
    
    public boolean func_70097_a(final pico pico, final float n) {
        if (this.field_70170_p.field_72995_K) {
            return true;
        }
        if ("fall".equals(pico.field_76373_n)) {
            if (!this.field_70128_L) {
                final EntityCrawler entityCrawler = new EntityCrawler(this.field_70170_p);
                entityCrawler.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
                this.field_70170_p.func_72838_d((Entity)entityCrawler);
                this.field_70128_L = true;
            }
            return true;
        }
        if ("inWall".equals(pico.field_76373_n)) {
            return false;
        }
        final boolean func_70097_a = super.func_70097_a(pico, n);
        if (func_70097_a && pico.func_76346_g() instanceof EntityPlayer) {
            this.stop = 4;
            this.slowdown = 15;
            final EntityPlayer entityPlayer = (EntityPlayer)pico.func_76346_g();
            if (VCore.isSinglePlayer() || !entityPlayer.field_71075_bZ._d) {
                this.func_70624_b((EntityLivingBase)entityPlayer);
            }
        }
        return func_70097_a;
    }
    
    protected void func_82164_bB() {
        if (!this.armor) {
            return;
        }
        this.armor = false;
        switch (this.field_70146_Z.nextInt(35)) {
            case 1: {
                this.func_70062_b(4, new ieta(HCS.samodelHead));
                this.func_70062_b(3, new ieta(HCS.samodelBody));
                this.func_70062_b(2, new ieta(HCS.samodelLegs));
                this.func_70062_b(1, new ieta(HCS.samodelBoots));
                break;
            }
            case 2: {
                this.func_70062_b(4, new ieta(HCS.ghileHead));
                this.func_70062_b(3, new ieta(HCS.ghileBody));
                this.func_70062_b(2, new ieta(HCS.ghileLegs));
                this.func_70062_b(1, new ieta(HCS.ghileBoots));
                break;
            }
            case 5: {
                this.func_70062_b(4, new ieta(HCS.RFGorHead));
                this.func_70062_b(3, new ieta(HCS.RFGorBody));
                this.func_70062_b(2, new ieta(HCS.RFGorLegs));
                this.func_70062_b(1, new ieta(HCS.RFGorBoots));
                break;
            }
            case 10: {
                this.func_70062_b(4, new ieta(HCS.RFLesHead));
                this.func_70062_b(3, new ieta(HCS.RFLesBody));
                this.func_70062_b(2, new ieta(HCS.RFLesLegs));
                this.func_70062_b(1, new ieta(HCS.RFLesBoots));
                break;
            }
            case 15: {
                this.func_70062_b(4, new ieta(HCS.ghileHead));
                break;
            }
            case 20: {
                this.func_70062_b(4, new ieta(HCS.samodelHead));
                this.func_70062_b(3, new ieta(HCS.samodelBody));
                break;
            }
            case 25: {
                this.func_70062_b(3, new ieta(HCS.RFLesBody));
                this.func_70062_b(2, new ieta(HCS.RFLesLegs));
                break;
            }
        }
    }
    
    protected void func_82160_b(final boolean b, final int n) {
        if (this.field_70170_p.field_72995_K || HCS.isHardcoreServer()) {
            return;
        }
        for (int i = 0; i < this.func_70035_c().length; ++i) {
            final ieta func_71124_b = this.func_71124_b(i);
            final boolean b2 = this.field_82174_bp[i] > 1.0f;
            if (func_71124_b != null && this.field_70146_Z.nextFloat() - n * 0.01f < this.field_82174_bp[i]) {
                if (!b2 && func_71124_b._f()) {
                    final int n2 = func_71124_b._k() - 1;
                    func_71124_b._b((int)(n2 - n2 * (this.field_70146_Z.nextFloat() * 0.2)));
                }
                this.field_70170_p.func_72838_d((Entity)new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u + n, this.field_70161_v, func_71124_b));
            }
        }
    }
    
    public void func_70645_a(final pico pico) {
        if (this.field_70729_aU || this.field_70128_L) {
            return;
        }
        if (zwaq.onLivingDeath((EntityLivingBase)this, pico)) {
            return;
        }
        final Entity func_76346_g = pico.func_76346_g();
        final EntityLivingBase func_94060_bK = this.func_94060_bK();
        if (this.field_70744_aE >= 0 && func_94060_bK != null) {
            func_94060_bK.func_70084_c((Entity)this, this.field_70744_aE);
        }
        if (func_76346_g != null) {
            func_76346_g.func_70074_a((EntityLivingBase)this);
            if (!this.field_70170_p.field_72995_K) {
                if (this instanceof EntityCrawler) {
                    if (func_76346_g instanceof EntityPlayer) {
                        dropRandomZombieLoot((Entity)this, HCS.zombieLoot((EntityPlayer)func_76346_g, (Entity)this));
                    }
                }
                else {
                    this.field_70170_p.func_72838_d((Entity)new EntityCorpseZ(this));
                }
                this.func_82160_b(this.field_70718_bc > 0, 0);
            }
        }
        this.field_70729_aU = true;
        this.field_70170_p.func_72960_a((Entity)this, (byte)3);
        if (this.field_70153_n != null) {
            this.field_70153_n.func_70106_y();
            this.field_70153_n = null;
        }
    }
    
    public boolean func_70652_k(final Entity entity) {
        if (!(entity instanceof EntityPlayer)) {
            return false;
        }
        final int totalArmorValue = zwaq.getTotalArmorValue((EntityPlayer)entity);
        if (!entity.func_70097_a(pico.func_76358_a((EntityLivingBase)this), (this.field_70146_Z.nextFloat() * 0.25f + 0.3f) / (1.0f - totalArmorValue / 25.0f))) {
            return false;
        }
        if (this.field_70146_Z.nextFloat() < 0.1f - 0.1f * totalArmorValue / 20.0f && entity.field_70154_o == null) {
            ((EntityLivingBase)entity).func_70690_d((kldu)new EnactEffect(Effect.bleeding.func_76396_c(), 4000, 1));
        }
        return true;
    }
    
    public void func_70071_h_() {
        if (this.field_70170_p.field_72995_K) {
            super.func_70071_h_();
            this.texture = this.field_70180_af._c(20);
            return;
        }
        if (this.stop > 0) {
            --this.stop;
        }
        if (this.slowdown > 0) {
            --this.slowdown;
        }
        this.func_82170_o(Effect.bleeding.func_76396_c());
        if (super.field_70170_p.field_73013_u == 0) {
            this.field_70128_L = true;
        }
        if (this.firstUpdate && !(this instanceof EntityCrawler)) {
            this.field_70170_p.func_72838_d((Entity)new EntityZombieHead(this));
            this.walkTo(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.firstUpdate = false;
        }
        if (this.func_70638_az() != null && (!this.func_70638_az().func_70089_S() || (!VCore.isSinglePlayer() && this.func_70638_az() instanceof EntityPlayer && ((EntityPlayer)this.func_70638_az()).field_71075_bZ._d))) {
            this.func_70624_b((EntityLivingBase)null);
        }
        if (this.func_70638_az() == null) {
            this.find_target();
        }
        super.func_70071_h_();
        final EntityLivingBase func_70638_az = this.func_70638_az();
        if (func_70638_az != null && !(this instanceof EntityCrawler) && this.func_70068_e((Entity)func_70638_az) < 16.0 && ((Entity)func_70638_az).field_70163_u > this.field_70163_u + 1.5 && (!VCore.isSinglePlayer() || !((EntityPlayer)func_70638_az).field_71075_bZ._d)) {
            if (this.field_70122_E) {
                if (super.field_70146_Z.nextInt(10) == 0) {
                    this.field_70181_x += (((Entity)func_70638_az).field_70163_u - this.field_70163_u) / 5.0;
                    zwaq.onLivingJump((EntityLivingBase)this);
                }
            }
            else {
                this.field_70159_w += (((Entity)func_70638_az).field_70165_t - this.field_70165_t) / 10.0;
                this.field_70179_y += (((Entity)func_70638_az).field_70161_v - this.field_70161_v) / 10.0;
            }
        }
        if (!this.attackAi.walkToPoint) {
            this.walkTo(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        }
    }
    
    public void walkTo(final double moveX, double n, final double moveZ) {
        while (this.field_70170_p.func_72798_a(dwbg._c(moveX), dwbg._c(n), dwbg._c(moveZ)) == 0) {
            if (--n <= 0.0) {
                return;
            }
        }
        this.moveX = moveX;
        this.moveY = dwbg._c(n + 1.0);
        this.moveZ = moveZ;
    }
    
    public void find_target() {
        double n = Double.MAX_VALUE;
        if (this.func_70638_az() == null || this.func_70638_az().field_70128_L) {
            final long g = this.field_70170_p.func_72912_H()._g();
            final boolean b = g > 13800L && g < 22200L;
            for (final EntityPlayer next : this.field_70170_p.field_73010_i) {
                if (next instanceof EntityPlayer) {
                    final EntityPlayer entityPlayer = next;
                    final double n2 = entityPlayer.func_70032_d((Entity)this);
                    if (n2 >= n || EntityZombieDayZ.detect_distances_f[EntityZombieDayZ.detect_distances_f.length - 1] < n2 || (!VCore.isSinglePlayer() && (entityPlayer.field_71075_bZ._a || !entityPlayer.func_70089_S()))) {
                        continue;
                    }
                    boolean b2 = false;
                    if (angularDistance(360.0f - (float)(Math.atan2(entityPlayer.field_70165_t - this.field_70165_t, entityPlayer.field_70161_v - this.field_70161_v) / 3.141592653589793) * 180.0f, this.field_70177_z) < 75.0) {
                        b2 = true;
                    }
                    final int visibility = ExtendedPlayer.server(entityPlayer).visibility;
                    if (EntityZombieDayZ.detect_distances_b[visibility] < n2 && (EntityZombieDayZ.detect_distances_f[Math.min(visibility, b ? 1 : 4)] < n2 || !b2 || !this.func_70685_l((Entity)entityPlayer))) {
                        continue;
                    }
                    this.func_70624_b((EntityLivingBase)entityPlayer);
                    n = n2;
                }
            }
        }
    }
    
    public static float angularDistance(final float n, final float n2) {
        final float n3 = Math.abs(n2 - n) % 360.0f;
        return (n3 > 180.0f) ? (360.0f - n3) : n3;
    }
    
    public zway func_110161_a(final zway zway) {
        this.field_70173_aa = 1;
        this.armor = true;
        this.func_82164_bB();
        return super.func_110161_a(zway);
    }
    
    public double func_70042_X() {
        return 1.2;
    }
    
    public void func_70690_d(final kldu kldu) {
    }
    
    public float func_70689_ay() {
        if (this.stop > 0) {
            return 0.0f;
        }
        float func_70689_ay = super.func_70689_ay();
        if (this.slowdown > 0) {
            func_70689_ay *= 0.75f;
        }
        return func_70689_ay;
    }
    
    public boolean func_70685_l(final Entity entity) {
        return this.field_70170_p.func_72831_a(this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u + this.func_70047_e(), this.field_70161_v), this.field_70170_p.func_82732_R()._a(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v), false, true) == null;
    }
    
    protected void func_85033_bc() {
        if (!this.func_70089_S()) {
            return;
        }
        final List func_72839_b = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D);
        if (func_72839_b != null && !func_72839_b.isEmpty()) {
            for (int i = 0; i < func_72839_b.size(); ++i) {
                final Entity entity = func_72839_b.get(i);
                if (entity.func_70089_S()) {
                    if (entity.func_70104_M()) {
                        this.func_82167_n(entity);
                    }
                    if (entity instanceof EntityZombieDayZ) {
                        final double n = this.field_70165_t - entity.field_70165_t;
                        final double n2 = this.field_70163_u - entity.field_70163_u;
                        final double n3 = this.field_70161_v - entity.field_70161_v;
                        if (dwbg._a(n * n + n2 * n2 + n3 * n3) < 0.125) {
                            final double n4 = this.field_70159_w - entity.field_70159_w;
                            final double n5 = this.field_70181_x - entity.field_70181_x;
                            final double n6 = this.field_70179_y - entity.field_70179_y;
                            if (dwbg._a(n4 * n4 + n5 * n5 + n6 * n6) < 0.0625) {
                                combine((EntityZombieDayZ)entity, this);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private static void combine(EntityZombieDayZ entityZombieDayZ, EntityZombieDayZ entityZombieDayZ2) {
        if (getArmor(entityZombieDayZ2) > getArmor(entityZombieDayZ)) {
            final EntityZombieDayZ entityZombieDayZ3 = entityZombieDayZ;
            entityZombieDayZ = entityZombieDayZ2;
            entityZombieDayZ2 = entityZombieDayZ3;
        }
        if (!entityZombieDayZ.hpMod) {
            entityZombieDayZ.hpMod = true;
            entityZombieDayZ.func_110148_a(srlj._a)._a(entityZombieDayZ.func_110148_a(srlj._a)._e() * 1.5);
        }
        if (entityZombieDayZ.func_110143_aJ() < entityZombieDayZ.func_110138_aP()) {
            entityZombieDayZ.func_70606_j(entityZombieDayZ.func_110138_aP());
        }
        entityZombieDayZ2.func_70106_y();
    }
    
    private static int getArmor(final EntityZombieDayZ entityZombieDayZ) {
        int n = 0;
        for (int i = 1; i <= 4; ++i) {
            final ieta func_71124_b = entityZombieDayZ.func_71124_b(i);
            if (func_71124_b != null && func_71124_b._a() instanceof qmjs) {
                n += ((qmjs)func_71124_b._a()).field_77879_b;
            }
        }
        return n;
    }
    
    public void func_70024_g(final double n, final double n2, final double n3) {
        final double n4 = dwbg._a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
        final double field_70159_w = this.field_70159_w + n;
        final double field_70181_x = this.field_70181_x + n2;
        final double field_70179_y = this.field_70179_y + n3;
        if (dwbg._a(field_70159_w * field_70159_w + field_70181_x * field_70181_x + field_70179_y * field_70179_y) < n4 * 1.1) {
            this.field_70159_w = field_70159_w;
            this.field_70181_x = field_70181_x;
            this.field_70179_y = field_70179_y;
            this.field_70160_al = true;
        }
    }
    
    public static void dropRandomZombieLoot(final Entity entity, final String s) {
        if (EntityZombieDayZ.randomDropCallback != null && s != null) {
            EntityZombieDayZ.randomDropCallback.dropZombieLoot(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, s);
        }
    }
    
    static {
        detect_distances_f = new int[] { 4, 16, 24, 48, 64 };
        detect_distances_b = new int[] { 2, 2, 4, 32, 48 };
        loot_from_zombie = new int[] { 5151, 5152, 5153, 5164, 5166, 5165, 5154, 14027, 14036, 14036, 6146, 6148, 5176, 341 };
    }
    
    public interface RandomDropCallback
    {
        void dropZombieLoot(final double p0, final double p1, final double p2, final String p3);
    }
}
