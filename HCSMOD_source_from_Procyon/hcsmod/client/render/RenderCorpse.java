// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.entity.AbstractClientPlayer;
import hcsmod.entity.EntityCorpse;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBiped;

public class RenderCorpse extends uyfg
{
    private ModelBiped mainModel;
    private ResourceLocation skin;
    
    public RenderCorpse() {
        this.mainModel = new ModelBiped();
        this.skin = null;
    }
    
    public void doRenderCorpse(final EntityCorpse entityCorpse, final double n, final double n2, final double n3, final float n4, final float n5) {
        AbstractClientPlayer.func_110304_a(this.skin = AbstractClientPlayer.func_110311_f(entityCorpse.getUsernameKilled()), entityCorpse.getUsernameKilled());
        this.func_110776_a(this.skin);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)n, (float)n2 + 0.125f, (float)n3);
        GL11.glRotatef(-entityCorpse.field_70177_z, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glTranslatef(0.0f, -0.5f, 0.0f);
        GL11.glScaled(0.1, 0.1, 0.1);
        final int lifeStage = entityCorpse.getLifeStage();
        this.mainModel.func_78087_a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, (Entity)entityCorpse);
        if (lifeStage > 13) {
            GL11.glColor3f(0.25f, 0.25f, 0.25f);
        }
        else if (lifeStage > 12) {
            GL11.glColor3f(0.5f, 0.5f, 0.5f);
        }
        else {
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
        }
        this.mainModel.field_78116_c.func_78785_a(0.625f);
        this.mainModel.field_78115_e.func_78785_a(0.625f);
        if (lifeStage < 12) {
            if (lifeStage > 10) {
                GL11.glColor3f(0.25f, 0.25f, 0.25f);
            }
            else if (lifeStage > 9) {
                GL11.glColor3f(0.5f, 0.5f, 0.5f);
            }
            else {
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
            }
            this.mainModel.field_78112_f.func_78785_a(0.625f);
        }
        if (lifeStage < 9) {
            if (lifeStage > 7) {
                GL11.glColor3f(0.25f, 0.25f, 0.25f);
            }
            else if (lifeStage > 6) {
                GL11.glColor3f(0.5f, 0.5f, 0.5f);
            }
            else {
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
            }
            this.mainModel.field_78113_g.func_78785_a(0.625f);
        }
        if (lifeStage < 6) {
            if (lifeStage > 4) {
                GL11.glColor3f(0.25f, 0.25f, 0.25f);
            }
            else if (lifeStage > 3) {
                GL11.glColor3f(0.5f, 0.5f, 0.5f);
            }
            else {
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
            }
            this.mainModel.field_78123_h.func_78785_a(0.625f);
        }
        if (lifeStage < 3) {
            if (lifeStage > 1) {
                GL11.glColor3f(0.25f, 0.25f, 0.25f);
            }
            else if (lifeStage > 0) {
                GL11.glColor3f(0.5f, 0.5f, 0.5f);
            }
            else {
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
            }
            this.mainModel.field_78124_i.func_78785_a(0.625f);
        }
        this.mainModel.field_78114_d.func_78785_a(0.625f);
        GL11.glPopMatrix();
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
    }
    
    public void func_76986_a(final Entity entity, final double n, final double n2, final double n3, final float n4, final float n5) {
        GL11.glEnable(32826);
        this.doRenderCorpse((EntityCorpse)entity, n, n2, n3, n4, n5);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return null;
    }
}
