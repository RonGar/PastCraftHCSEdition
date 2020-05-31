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

public class ModelAssault extends ModelBiped
{
    int DL;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ResourceLocation assault;
    
    public ModelAssault() {
        this.DL = -1;
        this.assault = new ResourceLocation("hcsmod:textures/models/assault.png");
        super.field_78090_t = 64;
        super.field_78089_u = 32;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 20, 11)).func_78789_a(0.0f, 0.0f, 0.0f, 6, 9, 3);
        this.Shape1.func_78793_a(-4.0f, 4.0f, 0.0f);
        this.Shape1.func_78787_b(64, 32);
        this.Shape1.field_78809_i = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 25, 24)).func_78789_a(0.0f, 0.0f, 0.0f, 4, 3, 1);
        this.Shape2.func_78793_a(-3.0f, 9.0f, -1.0f);
        this.Shape2.func_78787_b(64, 32);
        this.Shape2.field_78809_i = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 12, 16)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.Shape4.func_78793_a(-5.0f, 9.0f, 1.0f);
        this.Shape4.func_78787_b(64, 32);
        this.Shape4.field_78809_i = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 39, 16)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.Shape5.func_78793_a(2.0f, 9.0f, 1.0f);
        this.Shape5.func_78787_b(64, 32);
        this.Shape5.field_78809_i = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        super.func_78088_a(entity, n, n2, n3, n4, n5, n6);
        this.func_78087_a(n, n2, n3, n4, n5, n6, entity);
        rojd.instance().getClient()._R()._a(this.assault);
        if (entity instanceof EntityPlayer) {
            final EntityPlayer entityPlayer = (EntityPlayer)entity;
            if (entityPlayer.func_70093_af() && !entityPlayer.func_70090_H()) {
                GL11.glPushMatrix();
                GL11.glTranslatef(0.0f, 0.1f, 0.0f);
                GL11.glRotatef(25.0f, 1.0f, 0.0f, 0.0f);
                GL11.glPopMatrix();
            }
        }
        GL11.glPushMatrix();
        GL11.glScalef(1.2f, 1.2f, 1.2f);
        GL11.glRotatef(180.0f, 0.0f, -1.0f, 0.0f);
        GL11.glTranslatef(0.06f, -0.25f, -0.3f);
        this.Shape1.func_78785_a(n6);
        this.Shape2.func_78785_a(n6);
        this.Shape4.func_78785_a(n6);
        this.Shape5.func_78785_a(n6);
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
