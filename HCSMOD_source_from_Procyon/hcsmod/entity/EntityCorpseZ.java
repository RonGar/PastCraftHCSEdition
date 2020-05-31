// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.entity;

import hcsmod.HCS;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

public class EntityCorpseZ extends Entity
{
    public EntityCorpseZ(final cuqu cuqu) {
        super(cuqu);
        this.func_70105_a(1.0f, 0.1f);
    }
    
    public EntityCorpseZ(final EntityZombieDayZ entityZombieDayZ) {
        super(entityZombieDayZ.field_70170_p);
        this.field_70177_z = entityZombieDayZ.field_70177_z + 90.0f;
        this.func_70107_b(entityZombieDayZ.field_70165_t, entityZombieDayZ.field_70163_u, entityZombieDayZ.field_70161_v);
        this.func_70105_a(1.0f, 0.1f);
        this.field_70180_af._b(21, (Object)entityZombieDayZ.texture);
    }
    
    protected void func_70088_a() {
        this.field_70180_af._a(20, (Object)0);
        this.field_70180_af._a(21, (Object)0);
    }
    
    public void func_70030_z() {
        super.func_70030_z();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa > 1200) {
            this.func_70106_y();
            if (this.field_70146_Z.nextInt(5) == 0) {
                final EntityZombieDayZ entityZombieDayZ = new EntityZombieDayZ(this.field_70170_p);
                entityZombieDayZ.field_70177_z = this.field_70177_z;
                entityZombieDayZ.func_70634_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.field_70170_p.func_72838_d((Entity)entityZombieDayZ);
            }
        }
        if (!this.field_70122_E) {
            this.field_70181_x -= 0.02;
        }
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
    }
    
    public boolean func_85031_j(final Entity entity) {
        if (!this.field_70128_L && !this.field_70170_p.field_72995_K && entity instanceof EntityPlayer) {
            EntityZombieDayZ.dropRandomZombieLoot(this, HCS.zombieLoot((EntityPlayer)entity, this));
        }
        this.func_70106_y();
        return false;
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    protected void func_70037_a(final hsus hsus) {
    }
    
    protected void func_70014_b(final hsus hsus) {
    }
    
    public boolean func_70039_c(final hsus hsus) {
        return false;
    }
}
