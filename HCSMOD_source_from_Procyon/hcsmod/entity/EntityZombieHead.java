// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.srlj;
import net.minecraft.util.pico;
import net.minecraft.entity.EntityLivingBase;

public class EntityZombieHead extends EntityLivingBase
{
    private boolean firstUpdate;
    private EntityZombieDayZ zombie;
    private static final ieta[] \u0437\u0430\u0435\u0431\u0430\u043b;
    
    public EntityZombieHead(final cuqu cuqu) {
        super(cuqu);
        this.firstUpdate = true;
        this.func_70105_a(0.8f, 0.8f);
        if (!cuqu.field_72995_K) {
            this.func_70106_y();
        }
    }
    
    public EntityZombieHead(final EntityZombieDayZ zombie) {
        super(zombie.field_70170_p);
        this.firstUpdate = true;
        this.func_70105_a(0.8f, 0.8f);
        this.func_70107_b(zombie.field_70165_t, zombie.field_70163_u + 1.0, zombie.field_70161_v);
        this.zombie = zombie;
    }
    
    public boolean func_70097_a(final pico pico, final float n) {
        if (this.field_70170_p.field_72995_K) {
            return true;
        }
        if (this.field_70154_o != null && !this.field_70154_o.field_70128_L) {
            this.field_70154_o.func_70097_a(pico, n * 3.0f);
        }
        else {
            this.func_70106_y();
        }
        return false;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(srlj._a)._a(1.0);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.firstUpdate) {
            this.func_70078_a((Entity)this.zombie);
            this.firstUpdate = false;
        }
        if (this.field_70154_o == null || this.field_70154_o.field_70128_L) {
            this.field_70154_o = null;
            this.func_70106_y();
        }
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    public void func_70037_a(final hsus hsus) {
    }
    
    public void func_70014_b(final hsus hsus) {
    }
    
    public ieta func_70694_bm() {
        return null;
    }
    
    public ieta func_71124_b(final int n) {
        return null;
    }
    
    public void func_70062_b(final int n, final ieta ieta) {
    }
    
    public ieta[] func_70035_c() {
        return EntityZombieHead.\u0437\u0430\u0435\u0431\u0430\u043b;
    }
    
    public boolean func_98035_c(final hsus hsus) {
        return false;
    }
    
    public boolean func_70039_c(final hsus hsus) {
        return false;
    }
    
    static {
        \u0437\u0430\u0435\u0431\u0430\u043b = new ieta[0];
    }
}
