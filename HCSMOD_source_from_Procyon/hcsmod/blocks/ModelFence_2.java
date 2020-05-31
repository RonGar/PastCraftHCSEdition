// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelFence_2 extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape11;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape3;
    
    public ModelFence_2() {
        super.field_78090_t = 64;
        super.field_78089_u = 64;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 24, 1);
        this.Shape1.func_78793_a(6.0f, 0.0f, 0.0f);
        this.Shape1.func_78787_b(64, 64);
        this.Shape1.field_78809_i = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0174533f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(3.5f, 0.0f, 0.0f, 2, 24, 1);
        this.Shape2.func_78793_a(1.0f, 0.0f, 0.0f);
        this.Shape2.func_78787_b(64, 64);
        this.Shape2.field_78809_i = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.1115358f);
        (this.Shape7 = new ModelRenderer((ModelBase)this, 0, 27)).func_78789_a(0.0f, 0.0f, 0.0f, 16, 1, 1);
        this.Shape7.func_78793_a(-8.4f, 4.0f, 0.5f);
        this.Shape7.func_78787_b(64, 64);
        this.Shape7.field_78809_i = true;
        this.setRotation(this.Shape7, 0.0f, 0.0f, 0.5432208f);
        (this.Shape8 = new ModelRenderer((ModelBase)this, 0, 27)).func_78789_a(0.0f, 0.0f, 0.0f, 8, 1, 1);
        this.Shape8.func_78793_a(-8.0f, 12.0f, 0.5f);
        this.Shape8.func_78787_b(64, 64);
        this.Shape8.field_78809_i = true;
        this.setRotation(this.Shape8, 0.0f, 0.0f, 0.2094395f);
        (this.Shape11 = new ModelRenderer((ModelBase)this, 0, 27)).func_78789_a(0.0f, 0.0f, 0.0f, 5, 1, 1);
        this.Shape11.func_78793_a(-8.0f, 3.0f, 0.5f);
        this.Shape11.func_78787_b(64, 64);
        this.Shape11.field_78809_i = true;
        this.setRotation(this.Shape11, 0.0f, -0.0523599f, 0.1396263f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 24, 1);
        this.Shape4.func_78793_a(-5.5f, 0.0f, 0.0f);
        this.Shape4.func_78787_b(64, 64);
        this.Shape4.field_78809_i = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, -0.0743572f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 24, 1);
        this.Shape5.func_78793_a(-7.5f, 0.0f, 0.0f);
        this.Shape5.func_78787_b(64, 64);
        this.Shape5.field_78809_i = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 0, 27)).func_78789_a(0.0f, 0.0f, 0.0f, 7, 1, 1);
        this.Shape3.func_78793_a(1.0f, 18.0f, 0.5f);
        this.Shape3.func_78787_b(64, 64);
        this.Shape3.field_78809_i = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.3354337f);
    }
    
    public void func_78088_a(final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        super.func_78088_a(entity, n, n2, n3, n4, n5, n6);
        this.func_78087_a(n, n2, n3, n4, n5, n6, entity);
        this.Shape1.func_78785_a(n6);
        this.Shape2.func_78785_a(n6);
        this.Shape7.func_78785_a(n6);
        this.Shape8.func_78785_a(n6);
        this.Shape11.func_78785_a(n6);
        this.Shape4.func_78785_a(n6);
        this.Shape5.func_78785_a(n6);
        this.Shape3.func_78785_a(n6);
    }
    
    public void render(final float n) {
        this.Shape1.func_78785_a(n);
        this.Shape2.func_78785_a(n);
        this.Shape7.func_78785_a(n);
        this.Shape8.func_78785_a(n);
        this.Shape11.func_78785_a(n);
        this.Shape4.func_78785_a(n);
        this.Shape5.func_78785_a(n);
        this.Shape3.func_78785_a(n);
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
