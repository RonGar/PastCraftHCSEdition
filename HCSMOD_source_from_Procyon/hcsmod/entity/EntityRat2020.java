// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.pico;
import net.minecraft.util.idqh;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityRat2020 extends EntityThrowable
{
    public float rotation;
    public float preRotation;
    public static ResourceLocation textures;
    
    public EntityRat2020(final cuqu cuqu) {
        super(cuqu);
    }
    
    public EntityRat2020(final cuqu cuqu, final EntityLivingBase entityLivingBase, final ResourceLocation textures) {
        super(cuqu, entityLivingBase);
        EntityRat2020.textures = textures;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.preRotation = this.rotation;
            this.rotation -= 40.0f;
        }
    }
    
    protected void func_70184_a(final idqh idqh) {
        if (idqh._g != null) {
            idqh._g.func_70097_a(pico.func_76356_a((Entity)this, (Entity)this.func_85052_h()), 1.0f);
        }
        for (int i = 0; i < 8; ++i) {
            this.field_70170_p.func_72869_a("tilecrack_1_0", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0);
        }
        if (!this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
    }
}
