// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelFence_3 extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape71;
    ModelRenderer Shape111;
    ModelRenderer Shape5;
    ModelRenderer Shape7;
    ModelRenderer Shape11;
    
    public ModelFence_3() {
        super.field_78090_t = 64;
        super.field_78089_u = 64;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 24, 1);
        this.Shape1.func_78793_a(6.0f, 0.0f, 0.0f);
        this.Shape1.func_78787_b(64, 64);
        this.Shape1.field_78809_i = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0546319f);
        (this.Shape71 = new ModelRenderer((ModelBase)this, 0, 27)).func_78789_a(0.0f, 0.0f, 0.0f, 16, 1, 1);
        this.Shape71.func_78793_a(-8.4f, 13.0f, 0.5f);
        this.Shape71.func_78787_b(64, 64);
        this.Shape71.field_78809_i = true;
        this.setRotation(this.Shape71, 0.0f, 0.0f, -0.1487144f);
        (this.Shape111 = new ModelRenderer((ModelBase)this, 0, 27)).func_78789_a(0.0f, 0.0f, 0.0f, 7, 1, 1);
        this.Shape111.func_78793_a(-8.0f, 5.0f, 0.5f);
        this.Shape111.func_78787_b(64, 64);
        this.Shape111.field_78809_i = true;
        this.setRotation(this.Shape111, 0.0f, -0.0523599f, 0.1396263f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 24, 1);
        this.Shape5.func_78793_a(-7.5f, 0.0f, 0.0f);
        this.Shape5.func_78787_b(64, 64);
        this.Shape5.field_78809_i = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase)this, 0, 27)).func_78789_a(0.0f, 0.0f, 0.0f, 14, 1, 1);
        this.Shape7.func_78793_a(-7.0f, 15.0f, 0.5f);
        this.Shape7.func_78787_b(64, 64);
        this.Shape7.field_78809_i = true;
        this.setRotation(this.Shape7, 0.0f, 0.0f, 0.3225245f);
        (this.Shape11 = new ModelRenderer((ModelBase)this, 0, 27)).func_78789_a(0.0f, 0.0f, 0.0f, 7, 1, 1);
        this.Shape11.func_78793_a(0.0f, 7.0f, 0.5f);
        this.Shape11.func_78787_b(64, 64);
        this.Shape11.field_78809_i = true;
        this.setRotation(this.Shape11, 0.0f, 0.0349066f, -0.1919862f);
    }
    
    public void func_78088_a(final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        super.func_78088_a(entity, n, n2, n3, n4, n5, n6);
        this.func_78087_a(n, n2, n3, n4, n5, n6, entity);
        this.Shape1.func_78785_a(n6);
        this.Shape7.func_78785_a(n6);
        this.Shape11.func_78785_a(n6);
        this.Shape5.func_78785_a(n6);
        this.Shape7.func_78785_a(n6);
        this.Shape11.func_78785_a(n6);
    }
    
    public void render(final float n) {
        this.Shape1.func_78785_a(n);
        this.Shape7.func_78785_a(n);
        this.Shape11.func_78785_a(n);
        this.Shape5.func_78785_a(n);
        this.Shape7.func_78785_a(n);
        this.Shape11.func_78785_a(n);
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
