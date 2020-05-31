// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import hcsmod.entity.EntityKoster;
import net.minecraft.util.ResourceLocation;

public class RenderKoster extends uyfg
{
    private static ModelKoster model;
    private static ResourceLocation gtex;
    static float scale;
    
    public void render(final EntityKoster entityKoster, final double n, final double n2, final double n3, final float n4, final float n5) {
        RenderKoster.scale = 1.5f;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)n, (float)n2 + 2.25f, (float)n3);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(n4 - 45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(RenderKoster.scale, RenderKoster.scale, RenderKoster.scale);
        this.func_110776_a(RenderKoster.gtex);
        RenderKoster.model.func_78088_a(entityKoster, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
    
    public void func_76986_a(final Entity entity, final double n, final double n2, final double n3, final float n4, final float n5) {
        GL11.glEnable(32826);
        this.render((EntityKoster)entity, n, n2, n3, n4, n5);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return RenderKoster.gtex;
    }
    
    static {
        RenderKoster.model = new ModelKoster();
        RenderKoster.gtex = new ResourceLocation("hcsmod:textures/koster.png");
        RenderKoster.scale = 1.5f;
    }
}
