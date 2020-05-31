// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelBlock extends ModelBase
{
    ModelRenderer Base;
    ModelRenderer SASAI;
    ModelRenderer Lalka;
    ModelRenderer LOL;
    
    public ModelBlock() {
        super.field_78090_t = 128;
        super.field_78089_u = 32;
        (this.Base = new ModelRenderer((ModelBase)this, 0, 12)).func_78789_a(-6.0f, 0.0f, 0.0f, 32, 16, 3);
        this.Base.func_78793_a(-2.0f, 7.466667f, 0.0f);
        this.Base.func_78787_b(128, 32);
        this.Base.field_78809_i = true;
        this.setRotation(this.Base, 0.0f, 0.0f, 0.0f);
        (this.SASAI = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 32, 7, 3);
        this.SASAI.func_78793_a(-8.0f, 16.46667f, 0.0f);
        this.SASAI.func_78787_b(128, 32);
        this.SASAI.field_78809_i = true;
        this.setRotation(this.SASAI, -0.3035221f, 0.0f, 0.0f);
        (this.Lalka = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 32, 7, 3);
        this.Lalka.func_78793_a(-8.0f, 17.0f, 0.0f);
        this.Lalka.func_78787_b(128, 32);
        this.Lalka.field_78809_i = true;
        this.setRotation(this.Lalka, 0.3346075f, 0.0f, 0.0f);
        (this.LOL = new ModelRenderer((ModelBase)this, 1, 8)).func_78789_a(0.0f, 0.0f, 0.0f, 32, 2, 11);
        this.LOL.func_78793_a(-8.0f, 22.53333f, -4.0f);
        this.LOL.func_78787_b(128, 32);
        this.LOL.field_78809_i = true;
        this.setRotation(this.LOL, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        super.func_78088_a(entity, n, n2, n3, n4, n5, n6);
        this.func_78087_a(n, n2, n3, n4, n5, n6, entity);
        this.Base.func_78785_a(n6);
        this.SASAI.func_78785_a(n6);
        this.Lalka.func_78785_a(n6);
        this.LOL.func_78785_a(n6);
    }
    
    public void render(final float n) {
        this.Base.func_78785_a(n);
        this.SASAI.func_78785_a(n);
        this.Lalka.func_78785_a(n);
        this.LOL.func_78785_a(n);
    }
    
    private void setRotation(final ModelRenderer modelRenderer, final float field_78795_f, final float field_78796_g, final float field_78808_h) {
        modelRenderer.field_78795_f = field_78795_f;
        modelRenderer.field_78796_g = field_78796_g;
        modelRenderer.field_78808_h = field_78808_h;
    }
    
    public void func_78087_a(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final Entity entity) {
        super.func_78087_a(n, n2, n3, n4, n5, n6, entity);
    }
}
