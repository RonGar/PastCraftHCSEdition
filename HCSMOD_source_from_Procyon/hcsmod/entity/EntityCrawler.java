// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.entity;

import net.minecraft.entity.srlj;

public class EntityCrawler extends EntityZombieDayZ
{
    public EntityCrawler(final cuqu cuqu) {
        super(cuqu, false);
        this.func_70105_a(0.7f, 0.6f);
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(srlj._a)._a(this.func_110148_a(srlj._a)._e() / 2.0);
        this.func_110148_a(srlj._d)._a(0.25);
    }
}
