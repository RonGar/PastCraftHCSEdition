// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.dwbg;
import net.minecraft.entity.monster.EntitySnowman;

public class EntitySnowmanHCS extends EntitySnowman
{
    public EntitySnowmanHCS(final cuqu cuqu) {
        super(cuqu);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        for (int i = 0; i < 4; ++i) {
            final int c = dwbg._c(this.field_70165_t + (i % 2 * 2 - 1) * 0.25f);
            final int c2 = dwbg._c(this.field_70163_u);
            final int c3 = dwbg._c(this.field_70161_v + (i / 2 % 2 * 2 - 1) * 0.25f);
            if (this.field_70170_p.func_72798_a(c, c2, c3) == 78 && this.field_70170_p.func_72807_a(c, c3)._k() < 0.8f && kjsv.field_72037_aS.func_71930_b(this.field_70170_p, c, c2, c3)) {
                this.field_70170_p.func_94575_c(c, c2, c3, 0);
            }
        }
    }
    
    public void func_82196_d(final EntityLivingBase entityLivingBase, final float n) {
    }
}
