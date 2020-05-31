// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelKoster extends ModelBase
{
    int DL;
    ModelRenderer Shape0;
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
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    
    public ModelKoster() {
        this.DL = -1;
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        (this.Shape0 = new ModelRenderer((ModelBase)this, 1, 55)).func_78789_a(-1.0f, 0.0f, 3.0f, 2, 2, 8);
        this.Shape0.func_78793_a(0.0f, 19.0f, 0.0f);
        this.Shape0.func_78787_b(128, 128);
        this.Shape0.field_78809_i = true;
        this.setRotation(this.Shape0, -0.2094395f, -1.011127f, 0.0f);
        (this.Shape1 = new ModelRenderer((ModelBase)this, 1, 55)).func_78789_a(-1.0f, 0.0f, 3.0f, 2, 2, 8);
        this.Shape1.func_78793_a(0.0f, 19.0f, 0.0f);
        this.Shape1.func_78787_b(128, 128);
        this.Shape1.field_78809_i = true;
        this.setRotation(this.Shape1, -0.2094395f, -0.3129957f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 1, 55)).func_78789_a(-1.0f, 0.0f, 3.0f, 2, 2, 8);
        this.Shape2.func_78793_a(0.0f, 19.0f, 0.0f);
        this.Shape2.func_78787_b(128, 128);
        this.Shape2.field_78809_i = true;
        this.setRotation(this.Shape2, -0.2094395f, -1.709259f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 1, 55)).func_78789_a(-1.0f, 0.0f, 3.0f, 2, 2, 8);
        this.Shape3.func_78793_a(0.0f, 19.0f, 0.0f);
        this.Shape3.func_78787_b(128, 128);
        this.Shape3.field_78809_i = true;
        this.setRotation(this.Shape3, -0.2094395f, -2.407391f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 36, 0)).func_78789_a(0.0f, 0.0f, -8.0f, 0, 18, 16);
        this.Shape4.func_78793_a(0.0f, 6.0f, 0.0f);
        this.Shape4.func_78787_b(128, 128);
        this.Shape4.field_78809_i = true;
        this.setRotation(this.Shape4, 0.0f, 1.579523f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 1, 55)).func_78789_a(-1.0f, 0.0f, 3.0f, 2, 2, 8);
        this.Shape5.func_78793_a(0.0f, 19.0f, 0.0f);
        this.Shape5.func_78787_b(128, 128);
        this.Shape5.field_78809_i = true;
        this.setRotation(this.Shape5, -0.2094395f, 3.177663f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase)this, 1, 55)).func_78789_a(-1.0f, 0.0f, 3.0f, 2, 2, 8);
        this.Shape6.func_78793_a(0.0f, 19.0f, 0.0f);
        this.Shape6.func_78787_b(128, 128);
        this.Shape6.field_78809_i = true;
        this.setRotation(this.Shape6, -0.2094395f, 1.781399f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase)this, 1, 55)).func_78789_a(-1.0f, 0.0f, 3.0f, 2, 2, 8);
        this.Shape7.func_78793_a(0.0f, 19.0f, 0.0f);
        this.Shape7.func_78787_b(128, 128);
        this.Shape7.field_78809_i = true;
        this.setRotation(this.Shape7, -0.2094395f, 1.083268f, 0.0f);
        (this.Shape8 = new ModelRenderer((ModelBase)this, 1, 55)).func_78789_a(-1.0f, 0.0f, 3.0f, 2, 2, 8);
        this.Shape8.func_78793_a(0.0f, 19.0f, 0.0f);
        this.Shape8.func_78787_b(128, 128);
        this.Shape8.field_78809_i = true;
        this.setRotation(this.Shape8, -0.2094395f, 2.479531f, 0.0f);
        (this.Shape9 = new ModelRenderer((ModelBase)this, 1, 55)).func_78789_a(-1.0f, 0.0f, 3.0f, 2, 2, 8);
        this.Shape9.func_78793_a(0.0f, 19.0f, 0.0f);
        this.Shape9.func_78787_b(128, 128);
        this.Shape9.field_78809_i = true;
        this.setRotation(this.Shape9, -0.2094395f, 0.385136f, 0.0f);
        (this.Shape10 = new ModelRenderer((ModelBase)this, 1, 0)).func_78789_a(0.0f, 0.0f, -8.0f, 0, 18, 16);
        this.Shape10.func_78793_a(0.0f, 6.0f, 0.0f);
        this.Shape10.func_78787_b(128, 128);
        this.Shape10.field_78809_i = true;
        this.setRotation(this.Shape10, 0.0f, 0.0f, 0.0f);
        (this.Shape11 = new ModelRenderer((ModelBase)this, 1, 40)).func_78789_a(-1.5f, 0.0f, 3.0f, 3, 3, 9);
        this.Shape11.func_78793_a(0.0f, 21.0f, 0.0f);
        this.Shape11.func_78787_b(128, 128);
        this.Shape11.field_78809_i = true;
        this.setRotation(this.Shape11, 0.0f, -2.792527f, 0.0f);
        (this.Shape12 = new ModelRenderer((ModelBase)this, 1, 40)).func_78789_a(-1.5f, 0.0f, 3.0f, 3, 3, 9);
        this.Shape12.func_78793_a(0.0f, 21.0f, 0.0f);
        this.Shape12.func_78787_b(128, 128);
        this.Shape12.field_78809_i = true;
        this.setRotation(this.Shape12, 0.0f, 2.792527f, 0.0f);
        (this.Shape13 = new ModelRenderer((ModelBase)this, 1, 40)).func_78789_a(-1.5f, 0.0f, 3.0f, 3, 3, 9);
        this.Shape13.func_78793_a(0.0f, 21.0f, 0.0f);
        this.Shape13.func_78787_b(128, 128);
        this.Shape13.field_78809_i = true;
        this.setRotation(this.Shape13, 0.0f, 2.094395f, 0.0f);
        (this.Shape14 = new ModelRenderer((ModelBase)this, 1, 40)).func_78789_a(-1.5f, 0.0f, 3.0f, 3, 3, 9);
        this.Shape14.func_78793_a(0.0f, 21.0f, 0.0f);
        this.Shape14.func_78787_b(128, 128);
        this.Shape14.field_78809_i = true;
        this.setRotation(this.Shape14, 0.0f, 1.396263f, 0.0f);
        (this.Shape15 = new ModelRenderer((ModelBase)this, 1, 40)).func_78789_a(-1.5f, 0.0f, 3.0f, 3, 3, 9);
        this.Shape15.func_78793_a(0.0f, 21.0f, 0.0f);
        this.Shape15.func_78787_b(128, 128);
        this.Shape15.field_78809_i = true;
        this.setRotation(this.Shape15, 0.0f, 0.6981317f, 0.0f);
        (this.Shape16 = new ModelRenderer((ModelBase)this, 1, 40)).func_78789_a(-1.5f, 0.0f, 3.0f, 3, 3, 9);
        this.Shape16.func_78793_a(0.0f, 21.0f, 0.0f);
        this.Shape16.func_78787_b(128, 128);
        this.Shape16.field_78809_i = true;
        this.setRotation(this.Shape16, 0.0f, 0.0f, 0.0f);
        (this.Shape17 = new ModelRenderer((ModelBase)this, 1, 40)).func_78789_a(-1.5f, 0.0f, 3.0f, 3, 3, 9);
        this.Shape17.func_78793_a(0.0f, 21.0f, 0.0f);
        this.Shape17.func_78787_b(128, 128);
        this.Shape17.field_78809_i = true;
        this.setRotation(this.Shape17, 0.0f, -2.094395f, 0.0f);
        (this.Shape18 = new ModelRenderer((ModelBase)this, 1, 40)).func_78789_a(-1.5f, 0.0f, 3.0f, 3, 3, 9);
        this.Shape18.func_78793_a(0.0f, 21.0f, 0.0f);
        this.Shape18.func_78787_b(128, 128);
        this.Shape18.field_78809_i = true;
        this.setRotation(this.Shape18, 0.0f, -0.6981317f, 0.0f);
        (this.Shape19 = new ModelRenderer((ModelBase)this, 1, 40)).func_78789_a(-1.5f, 0.0f, 3.0f, 3, 3, 9);
        this.Shape19.func_78793_a(0.0f, 21.0f, 0.0f);
        this.Shape19.func_78787_b(128, 128);
        this.Shape19.field_78809_i = true;
        this.setRotation(this.Shape19, 0.0f, -1.396263f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        if (this.DL != -1) {
            GL11.glCallList(this.DL);
        }
        else {
            GL11.glNewList(this.DL = GL11.glGenLists(1), 4864);
            NoDlModerRenderer.render(this.Shape0, n6);
            NoDlModerRenderer.render(this.Shape1, n6);
            NoDlModerRenderer.render(this.Shape2, n6);
            NoDlModerRenderer.render(this.Shape3, n6);
            NoDlModerRenderer.render(this.Shape5, n6);
            NoDlModerRenderer.render(this.Shape6, n6);
            NoDlModerRenderer.render(this.Shape7, n6);
            NoDlModerRenderer.render(this.Shape8, n6);
            NoDlModerRenderer.render(this.Shape9, n6);
            NoDlModerRenderer.render(this.Shape11, n6);
            NoDlModerRenderer.render(this.Shape12, n6);
            NoDlModerRenderer.render(this.Shape13, n6);
            NoDlModerRenderer.render(this.Shape14, n6);
            NoDlModerRenderer.render(this.Shape15, n6);
            NoDlModerRenderer.render(this.Shape16, n6);
            NoDlModerRenderer.render(this.Shape17, n6);
            NoDlModerRenderer.render(this.Shape18, n6);
            NoDlModerRenderer.render(this.Shape19, n6);
            GL11.glEndList();
        }
    }
    
    private void setRotation(final ModelRenderer modelRenderer, final float field_78795_f, final float field_78796_g, final float field_78808_h) {
        modelRenderer.field_78795_f = field_78795_f;
        modelRenderer.field_78796_g = field_78796_g;
        modelRenderer.field_78808_h = field_78808_h;
    }
}
