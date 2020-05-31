// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import hcsmod.client.render.NoDlModerRenderer;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class KolonkaModel extends ModelBase
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
    
    public KolonkaModel() {
        this.DL = -1;
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        (this.Shape0 = new ModelRenderer((ModelBase)this, 1, 50)).func_78789_a(0.0f, 0.0f, 0.0f, 14, 1, 14);
        this.Shape0.func_78793_a(-7.0f, 17.0f, -7.0f);
        this.Shape0.func_78787_b(128, 128);
        this.Shape0.field_78809_i = true;
        this.setRotation(this.Shape0, 0.0f, 0.0f, 0.0f);
        (this.Shape1 = new ModelRenderer((ModelBase)this, 21, 28)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.Shape1.func_78793_a(-0.5f, 2.0f, -0.5f);
        this.Shape1.func_78787_b(128, 128);
        this.Shape1.field_78809_i = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 1, 67)).func_78789_a(0.0f, 0.0f, 0.0f, 12, 6, 12);
        this.Shape2.func_78793_a(-6.0f, 18.0f, -6.0f);
        this.Shape2.func_78787_b(128, 128);
        this.Shape2.field_78809_i = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 1, 35)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Shape3.func_78793_a(-1.7f, 7.0f, 0.0f);
        this.Shape3.func_78787_b(128, 128);
        this.Shape3.field_78809_i = true;
        this.setRotation(this.Shape3, -0.7853982f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 1, 39)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 8, 2);
        this.Shape4.func_78793_a(-1.0f, 9.0f, -1.0f);
        this.Shape4.func_78787_b(128, 128);
        this.Shape4.field_78809_i = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 1, 35)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Shape5.func_78793_a(-1.2f, 9.5f, 0.0f);
        this.Shape5.func_78787_b(128, 128);
        this.Shape5.field_78809_i = true;
        this.setRotation(this.Shape5, -0.7853982f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase)this, 1, 35)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Shape6.func_78793_a(0.2f, 9.5f, 0.0f);
        this.Shape6.func_78787_b(128, 128);
        this.Shape6.field_78809_i = true;
        this.setRotation(this.Shape6, -0.7853982f, 0.0f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase)this, 1, 35)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Shape7.func_78793_a(0.7f, 7.0f, 0.0f);
        this.Shape7.func_78787_b(128, 128);
        this.Shape7.field_78809_i = true;
        this.setRotation(this.Shape7, -0.7853982f, 0.0f, 0.0f);
        (this.Shape8 = new ModelRenderer((ModelBase)this, 21, 35)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.Shape8.func_78793_a(-0.5f, 6.0f, 4.5f);
        this.Shape8.func_78787_b(128, 128);
        this.Shape8.field_78809_i = true;
        this.setRotation(this.Shape8, -0.4363323f, 0.0f, 0.0f);
        (this.Shape9 = new ModelRenderer((ModelBase)this, 21, 28)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.Shape9.func_78793_a(-0.5f, 7.0f, -4.0f);
        this.Shape9.func_78787_b(128, 128);
        this.Shape9.field_78809_i = true;
        this.setRotation(this.Shape9, 0.0f, 0.0f, 0.0f);
        (this.Shape10 = new ModelRenderer((ModelBase)this, 13, 32)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 11, 1);
        this.Shape10.func_78793_a(-0.5f, 3.5f, -4.0f);
        this.Shape10.func_78787_b(128, 128);
        this.Shape10.field_78809_i = true;
        this.setRotation(this.Shape10, -0.8726646f, 0.0f, 0.0f);
        (this.Shape11 = new ModelRenderer((ModelBase)this, 21, 28)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.Shape11.func_78793_a(-0.5f, 2.0f, -3.0f);
        this.Shape11.func_78787_b(128, 128);
        this.Shape11.field_78809_i = true;
        this.setRotation(this.Shape11, 0.0f, 0.0f, 0.0f);
        (this.Shape12 = new ModelRenderer((ModelBase)this, 21, 28)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.Shape12.func_78793_a(-0.5f, 2.0f, -4.0f);
        this.Shape12.func_78787_b(128, 128);
        this.Shape12.field_78809_i = true;
        this.setRotation(this.Shape12, 0.0f, 0.0f, 0.0f);
        (this.Shape13 = new ModelRenderer((ModelBase)this, 1, 24)).func_78789_a(0.0f, 0.0f, 0.0f, 3, 4, 3);
        this.Shape13.func_78793_a(-1.5f, 5.0f, -1.5f);
        this.Shape13.func_78787_b(128, 128);
        this.Shape13.field_78809_i = true;
        this.setRotation(this.Shape13, 0.0f, 0.0f, 0.0f);
        (this.Shape14 = new ModelRenderer((ModelBase)this, 21, 28)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.Shape14.func_78793_a(-0.5f, 6.0f, 1.5f);
        this.Shape14.func_78787_b(128, 128);
        this.Shape14.field_78809_i = true;
        this.setRotation(this.Shape14, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final float n) {
        if (this.DL != -1) {
            GL11.glCallList(this.DL);
        }
        else {
            GL11.glNewList(this.DL = GL11.glGenLists(1), 4864);
            NoDlModerRenderer.render(this.Shape0, n);
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
            NoDlModerRenderer.render(this.Shape13, n);
            NoDlModerRenderer.render(this.Shape14, n);
            GL11.glEndList();
        }
    }
    
    private void setRotation(final ModelRenderer modelRenderer, final float field_78795_f, final float field_78796_g, final float field_78808_h) {
        modelRenderer.field_78795_f = field_78795_f;
        modelRenderer.field_78796_g = field_78796_g;
        modelRenderer.field_78808_h = field_78808_h;
    }
}
