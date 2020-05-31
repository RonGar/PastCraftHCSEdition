// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.client.tuor;
import hcsmod.items.armor.ItemHCSArmor;
import net.minecraft.client.model.ModelRenderer;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import hcsmod.client.HcsClient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import hcsmod.entity.EntityZombieDayZ;
import net.minecraft.client.model.ModelBiped;

public class RenderZombie extends uyfb
{
    public RenderZombie() {
        super((ModelBiped)new ModelZombie(), 0.5f, 1.0f);
    }
    
    public void renderZombie(final EntityZombieDayZ entityZombieDayZ, final double n, final double n2, final double n3, final float n4, final float n5) {
        super.func_77031_a((EntityLiving)entityZombieDayZ, n, n2, n3, n4, n5);
    }
    
    public void func_76986_a(final Entity entity, final double n, final double n2, final double n3, final float n4, final float n5) {
        this.renderZombie((EntityZombieDayZ)entity, n, n2, n3, n4, n5);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        if (entity instanceof EntityZombieDayZ) {
            return HcsClient.zombieTextures.get(((EntityZombieDayZ)entity).texture);
        }
        return null;
    }
    
    protected void func_77029_c(final EntityLivingBase entityLivingBase, final float n) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        final ieta func_71124_b = entityLivingBase.func_71124_b(1);
        if (func_71124_b != null) {
            this.render(func_71124_b, ArmorRender.ModelPart.HEAD, this.field_77071_a.field_78116_c);
        }
        final ieta func_71124_b2 = entityLivingBase.func_71124_b(2);
        if (func_71124_b2 != null) {
            this.render(func_71124_b2, ArmorRender.ModelPart.BODY, this.field_77071_a.field_78115_e);
            this.render(func_71124_b2, ArmorRender.ModelPart.RARM, this.field_77071_a.field_78112_f);
            this.render(func_71124_b2, ArmorRender.ModelPart.LARM, this.field_77071_a.field_78113_g);
        }
        final ieta func_71124_b3 = entityLivingBase.func_71124_b(3);
        if (func_71124_b3 != null) {
            this.render(func_71124_b3, ArmorRender.ModelPart.RLEG, this.field_77071_a.field_78123_h);
            this.render(func_71124_b3, ArmorRender.ModelPart.LLEG, this.field_77071_a.field_78124_i);
        }
        final ieta func_71124_b4 = entityLivingBase.func_71124_b(4);
        if (func_71124_b4 != null) {
            this.render(func_71124_b4, ArmorRender.ModelPart.RBOOT, this.field_77071_a.field_78123_h);
            this.render(func_71124_b4, ArmorRender.ModelPart.LBOOT, this.field_77071_a.field_78124_i);
        }
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }
    
    private void render(final ieta ieta, final ArmorRender.ModelPart modelPart, final ModelRenderer modelRenderer) {
        if (ieta._a() instanceof ItemHCSArmor) {
            final ItemHCSArmor itemHCSArmor = (ItemHCSArmor)ieta._a();
            if (itemHCSArmor.model != null) {
                GL11.glPushMatrix();
                tuor._E()._R()._a(itemHCSArmor.texture);
                modelRenderer.func_78794_c(0.0625f);
                itemHCSArmor.model.render(modelPart);
                GL11.glPopMatrix();
            }
        }
    }
}
