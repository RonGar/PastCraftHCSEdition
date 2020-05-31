// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import hcsmod.client.HcsClient;
import net.minecraft.util.ResourceLocation;
import hcsmod.entity.EntityCorpseZ;

public class RenderCorpseZ extends uyfg
{
    private ModelZombie mainModel;
    
    public RenderCorpseZ() {
        this.mainModel = new ModelZombie();
    }
    
    public void doRenderCorpse(final EntityCorpseZ entityCorpseZ, final double n, final double n2, final double n3, final float n4, final float n5) {
        this.func_110776_a((ResourceLocation)HcsClient.zombieTextures.get(entityCorpseZ.func_70096_w()._c(21)));
        GL11.glPushMatrix();
        GL11.glTranslatef((float)n, (float)n2 + 0.2f, (float)n3);
        GL11.glRotatef(-entityCorpseZ.field_70177_z, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, -1.0f, 0.0f);
        GL11.glScaled(0.1, 0.1, 0.1);
        this.mainModel.func_78087_a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, entityCorpseZ);
        this.mainModel.field_78116_c.func_78785_a(0.625f);
        this.mainModel.field_78115_e.func_78785_a(0.625f);
        this.mainModel.field_78112_f.func_78785_a(0.625f);
        this.mainModel.field_78124_i.func_78785_a(0.625f);
        this.mainModel.field_78123_h.func_78785_a(0.625f);
        GL11.glPopMatrix();
    }
    
    public void func_76986_a(final Entity entity, final double n, final double n2, final double n3, final float n4, final float n5) {
        this.doRenderCorpse((EntityCorpseZ)entity, n, n2, n3, n4, n5);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return null;
    }
}
