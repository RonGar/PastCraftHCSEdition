// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import org.lwjgl.opengl.GL11;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelCzech extends ModelBiped
{
    int DL;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape4;
    ModelRenderer Shape41;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ResourceLocation czech_texture;
    
    public ModelCzech() {
        this.DL = -1;
        this.czech_texture = new ResourceLocation("hcsmod:textures/models/czech.png");
        super.field_78090_t = 128;
        super.field_78089_u = 64;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 34, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 8, 12, 4);
        this.Shape1.func_78793_a(-4.0f, 0.0f, 2.0f);
        this.Shape1.func_78787_b(128, 64);
        this.Shape1.field_78809_i = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 59, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 6, 2, 3);
        this.Shape2.func_78793_a(-3.0f, -2.0f, 2.0f);
        this.Shape2.func_78787_b(128, 64);
        this.Shape2.field_78809_i = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 83, 10)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 5, 3);
        this.Shape4.func_78793_a(-5.0f, 6.0f, 2.0f);
        this.Shape4.func_78787_b(128, 64);
        this.Shape4.field_78809_i = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        (this.Shape41 = new ModelRenderer((ModelBase)this, 59, 10)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 5, 3);
        this.Shape41.func_78793_a(4.0f, 6.0f, 2.0f);
        this.Shape41.func_78787_b(128, 64);
        this.Shape41.field_78809_i = true;
        this.setRotation(this.Shape41, 0.0f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 68, 10)).func_78789_a(0.0f, 0.0f, 0.0f, 6, 2, 1);
        this.Shape5.func_78793_a(-3.0f, 9.0f, 6.0f);
        this.Shape5.func_78787_b(128, 64);
        this.Shape5.field_78809_i = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase)this, 68, 14)).func_78789_a(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.Shape6.func_78793_a(-2.0f, 8.0f, 6.0f);
        this.Shape6.func_78787_b(128, 64);
        this.Shape6.field_78809_i = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase)this, 58, 26)).func_78789_a(0.0f, 0.0f, 0.0f, 6, 4, 1);
        this.Shape7.func_78793_a(-3.0f, 1.0f, 6.0f);
        this.Shape7.func_78787_b(128, 64);
        this.Shape7.field_78809_i = true;
        this.setRotation(this.Shape7, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        super.func_78088_a(entity, n, n2, n3, n4, n5, n6);
        this.func_78087_a(n, n2, n3, n4, n5, n6, entity);
        rojd.instance().getClient()._R()._a(this.czech_texture);
        if (entity instanceof EntityPlayer) {
            final EntityPlayer entityPlayer = (EntityPlayer)entity;
            if (entityPlayer.func_70093_af() && !entityPlayer.func_70090_H()) {
                GL11.glPushMatrix();
                GL11.glTranslatef(0.0f, 0.1f, 0.0f);
                GL11.glRotatef(25.0f, 1.0f, 0.0f, 0.0f);
                GL11.glPopMatrix();
            }
        }
        this.Shape1.func_78785_a(n6);
        this.Shape2.func_78785_a(n6);
        this.Shape4.func_78785_a(n6);
        this.Shape41.func_78785_a(n6);
        this.Shape5.func_78785_a(n6);
        this.Shape6.func_78785_a(n6);
        this.Shape7.func_78785_a(n6);
    }
    
    public void render(final float n) {
        if (this.DL != -1) {
            GL11.glCallList(this.DL);
        }
        else {
            GL11.glNewList(this.DL = GL11.glGenLists(1), 4864);
            NoDlModerRenderer.render(this.Shape1, n);
            NoDlModerRenderer.render(this.Shape2, n);
            NoDlModerRenderer.render(this.Shape4, n);
            NoDlModerRenderer.render(this.Shape5, n);
            NoDlModerRenderer.render(this.Shape6, n);
            NoDlModerRenderer.render(this.Shape7, n);
            NoDlModerRenderer.render(this.Shape41, n);
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
