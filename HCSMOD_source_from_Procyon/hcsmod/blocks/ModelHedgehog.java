// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import hcsmod.client.render.NoDlModerRenderer;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelHedgehog extends ModelBase
{
    int DL;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    
    public ModelHedgehog() {
        this.DL = -1;
        super.field_78090_t = 64;
        super.field_78089_u = 64;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 18, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 33, 2);
        this.Shape1.func_78793_a(-2.0f, -2.0f, 7.0f);
        this.Shape1.func_78787_b(64, 64);
        this.Shape1.field_78809_i = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.6981317f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 4, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 32, 0);
        this.Shape2.func_78793_a(-2.0f, -1.0f, 7.0f);
        this.Shape2.func_78787_b(64, 64);
        this.Shape2.field_78809_i = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.6981317f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 32, 0);
        this.Shape3.func_78793_a(-2.0f, -1.0f, 9.0f);
        this.Shape3.func_78787_b(64, 64);
        this.Shape3.field_78809_i = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.6981317f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, -33.0f, 0.0f, 1, 36, 2);
        this.Shape4.func_78793_a(-10.0f, 21.6f, -4.866667f);
        this.Shape4.func_78787_b(64, 64);
        this.Shape4.field_78809_i = true;
        this.setRotation(this.Shape4, 0.0f, -1.553343f, 0.8726646f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, -5.0f, 0.0f, 1, 35, 2);
        this.Shape5.func_78793_a(-13.0f, 3.933333f, 1.0f);
        this.Shape5.func_78787_b(64, 64);
        this.Shape5.field_78809_i = true;
        this.setRotation(this.Shape5, 0.0f, 1.553343f, 0.8726646f);
        (this.Shape6 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 33, 2);
        this.Shape6.func_78793_a(-23.0f, 3.0f, 9.0f);
        this.Shape6.func_78787_b(64, 64);
        this.Shape6.field_78809_i = true;
        this.setRotation(this.Shape6, 0.1115358f, 0.1707118f, -0.8901179f);
        (this.Shape7 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, -4.0f, 0.0f, 1, 34, 0);
        this.Shape7.func_78793_a(-13.0f, 4.0f, 0.0f);
        this.Shape7.func_78787_b(64, 64);
        this.Shape7.field_78809_i = true;
        this.setRotation(this.Shape7, 0.0f, 1.553343f, 0.8726646f);
        (this.Shape8 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-2.0f, -3.0f, 0.0f, 1, 34, 0);
        this.Shape8.func_78793_a(-11.0f, 5.0f, -2.0f);
        this.Shape8.func_78787_b(64, 64);
        this.Shape8.field_78809_i = true;
        this.setRotation(this.Shape8, 0.0f, 1.553343f, 0.8726646f);
        (this.Shape9 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, -0.3f, 1, 35, 0);
        this.Shape9.func_78793_a(-9.0f, 2.0f, 21.06667f);
        this.Shape9.func_78787_b(64, 64);
        this.Shape9.field_78809_i = true;
        this.setRotation(this.Shape9, 0.0f, 1.605703f, -0.8726646f);
        (this.Shape10 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-1.0f, -3.0f, -0.4f, 1, 35, 0);
        this.Shape10.func_78793_a(-11.0f, 3.0f, 18.0f);
        this.Shape10.func_78787_b(64, 64);
        this.Shape10.field_78809_i = true;
        this.setRotation(this.Shape10, 0.0f, 1.605703f, -0.8726646f);
        (this.Shape11 = new ModelRenderer((ModelBase)this, 20, 0)).func_78789_a(0.0f, 0.0f, -0.3f, 1, 32, 0);
        this.Shape11.func_78793_a(-23.0f, 4.0f, 9.4f);
        this.Shape11.func_78787_b(64, 64);
        this.Shape11.field_78809_i = true;
        this.setRotation(this.Shape11, 0.111544f, 0.1707107f, -0.8901179f);
        (this.Shape12 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 32, 0);
        this.Shape12.func_78793_a(-23.0f, 4.0f, 11.0f);
        this.Shape12.func_78787_b(64, 64);
        this.Shape12.field_78809_i = true;
        this.setRotation(this.Shape12, 0.111544f, 0.1707107f, -0.8901179f);
    }
    
    public void func_78088_a(final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        super.func_78088_a(entity, n, n2, n3, n4, n5, n6);
        this.func_78087_a(n, n2, n3, n4, n5, n6, entity);
        this.Shape1.func_78785_a(n6);
        this.Shape2.func_78785_a(n6);
        this.Shape3.func_78785_a(n6);
        this.Shape4.func_78785_a(n6);
        this.Shape5.func_78785_a(n6);
        this.Shape6.func_78785_a(n6);
        this.Shape7.func_78785_a(n6);
        this.Shape8.func_78785_a(n6);
        this.Shape9.func_78785_a(n6);
        this.Shape10.func_78785_a(n6);
        this.Shape11.func_78785_a(n6);
        this.Shape12.func_78785_a(n6);
    }
    
    public void render(final float n) {
        if (this.DL != -1) {
            GL11.glCallList(this.DL);
        }
        else {
            GL11.glNewList(this.DL = GL11.glGenLists(1), 4864);
            NoDlModerRenderer.render(this.Shape1, n);
            NoDlModerRenderer.render(this.Shape2, n);
            NoDlModerRenderer.render(this.Shape3, n);
            NoDlModerRenderer.render(this.Shape4, n);
            NoDlModerRenderer.render(this.Shape5, n);
            NoDlModerRenderer.render(this.Shape6, n);
            NoDlModerRenderer.render(this.Shape7, n);
            NoDlModerRenderer.render(this.Shape8, n);
            NoDlModerRenderer.render(this.Shape9, n);
            NoDlModerRenderer.render(this.Shape10, n);
            NoDlModerRenderer.render(this.Shape11, n);
            NoDlModerRenderer.render(this.Shape12, n);
            GL11.glEndList();
        }
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
