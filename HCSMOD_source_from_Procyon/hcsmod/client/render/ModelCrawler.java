// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.util.dwbg;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelCrawler extends ModelBase
{
    ModelRenderer Head;
    ModelRenderer Torso;
    ModelRenderer Left_arm;
    ModelRenderer Spine_1;
    ModelRenderer Left_rib_1;
    ModelRenderer Right_rib_1;
    ModelRenderer Right_rib_2;
    ModelRenderer Left_rib_2;
    ModelRenderer Spine_2;
    ModelRenderer Right_arm;
    
    public ModelCrawler() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.Head = new ModelRenderer((ModelBase)this, 30, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 8, 8, 8);
        this.Head.func_78793_a(-4.0f, 14.0f, -11.5f);
        this.Head.func_78787_b(128, 64);
        this.Head.field_78809_i = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Torso = new ModelRenderer((ModelBase)this, 34, 17)).func_78789_a(0.0f, 0.0f, 0.0f, 8, 7, 4);
        this.Torso.func_78793_a(-4.0f, 22.0f, -4.0f);
        this.Torso.func_78787_b(128, 64);
        this.Torso.field_78809_i = true;
        this.setRotation(this.Torso, 1.33843f, 0.0f, 0.0f);
        (this.Left_arm = new ModelRenderer((ModelBase)this, 59, 17)).func_78789_a(0.0f, 0.0f, 0.0f, 4, 12, 4);
        this.Left_arm.func_78793_a(4.0f, 19.0f, -2.0f);
        this.Left_arm.func_78787_b(128, 64);
        this.Left_arm.field_78809_i = true;
        this.setRotation(this.Left_arm, -1.487144f, 0.0f, 0.0f);
        (this.Spine_1 = new ModelRenderer((ModelBase)this, 44, 29)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Spine_1.func_78793_a(-0.5f, 21.5f, 3.0f);
        this.Spine_1.func_78787_b(128, 64);
        this.Spine_1.field_78809_i = true;
        this.setRotation(this.Spine_1, 1.33843f, 0.0f, 0.0f);
        (this.Left_rib_1 = new ModelRenderer((ModelBase)this, 49, 30)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.Left_rib_1.func_78793_a(0.5f, 21.8f, 4.0f);
        this.Left_rib_1.func_78787_b(128, 64);
        this.Left_rib_1.field_78809_i = true;
        this.setRotation(this.Left_rib_1, 1.33843f, 0.0f, 0.0f);
        (this.Right_rib_1 = new ModelRenderer((ModelBase)this, 37, 30)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 1, 1);
        this.Right_rib_1.func_78793_a(-2.5f, 21.8f, 4.0f);
        this.Right_rib_1.func_78787_b(128, 64);
        this.Right_rib_1.field_78809_i = true;
        this.setRotation(this.Right_rib_1, 1.33843f, 0.0f, 0.0f);
        (this.Right_rib_2 = new ModelRenderer((ModelBase)this, 37, 33)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Right_rib_2.func_78793_a(-2.5f, 22.8f, 3.7f);
        this.Right_rib_2.func_78787_b(128, 64);
        this.Right_rib_2.field_78809_i = true;
        this.setRotation(this.Right_rib_2, 1.33843f, 0.0f, 0.0f);
        (this.Left_rib_2 = new ModelRenderer((ModelBase)this, 51, 33)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Left_rib_2.func_78793_a(1.5f, 22.8f, 3.7f);
        this.Left_rib_2.func_78787_b(128, 64);
        this.Left_rib_2.field_78809_i = true;
        this.setRotation(this.Left_rib_2, 1.33843f, 0.0f, 0.0f);
        (this.Spine_2 = new ModelRenderer((ModelBase)this, 44, 33)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.Spine_2.func_78793_a(-0.5f, 22.0f, 4.866667f);
        this.Spine_2.func_78787_b(128, 64);
        this.Spine_2.field_78809_i = true;
        this.setRotation(this.Spine_2, 0.9666439f, 0.0f, 0.0f);
        (this.Right_arm = new ModelRenderer((ModelBase)this, 17, 17)).func_78789_a(0.0f, 0.0f, 0.0f, 4, 12, 4);
        this.Right_arm.func_78793_a(-8.0f, 19.0f, -2.0f);
        this.Right_arm.func_78787_b(128, 64);
        this.Right_arm.field_78809_i = true;
        this.setRotation(this.Right_arm, -1.487144f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        super.func_78088_a(entity, n, n2, n3, n4, n5, n6);
        this.func_78087_a(n, n2, n3, n4, n5, n6, entity);
        GL11.glTranslatef(0.0f, 0.0f, 0.3f);
        this.Head.func_78785_a(n6);
        this.Torso.func_78785_a(n6);
        this.Left_arm.func_78785_a(n6);
        this.Spine_1.func_78785_a(n6);
        this.Left_rib_1.func_78785_a(n6);
        this.Right_rib_1.func_78785_a(n6);
        this.Right_rib_2.func_78785_a(n6);
        this.Left_rib_2.func_78785_a(n6);
        this.Spine_2.func_78785_a(n6);
        this.Right_arm.func_78785_a(n6);
    }
    
    private void setRotation(final ModelRenderer modelRenderer, final float field_78795_f, final float field_78796_g, final float field_78808_h) {
        modelRenderer.field_78795_f = field_78795_f;
        modelRenderer.field_78796_g = field_78796_g;
        modelRenderer.field_78808_h = field_78808_h;
    }
    
    public void func_78087_a(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final Entity entity) {
        super.func_78087_a(n, n2, n3, n4, n5, n6, entity);
        this.Left_arm.field_78796_g = dwbg._b(n * 0.6662f) * 1.4f * n2;
        this.Right_arm.field_78796_g = dwbg._b(n * 0.6662f + 3.1415927f) * 1.4f * n2;
    }
}
