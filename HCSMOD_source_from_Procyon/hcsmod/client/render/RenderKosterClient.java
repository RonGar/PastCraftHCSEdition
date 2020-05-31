// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import hcsmod.client.EntityKosterClient;
import net.minecraft.util.ResourceLocation;

public class RenderKosterClient extends uyfg
{
    private static ModelKoster model;
    private static ResourceLocation gtex;
    
    public void render(final EntityKosterClient entityKosterClient, final double n, final double n2, final double n3, final float n4, final float n5) {
        if (entityKosterClient.placeAllowed) {
            GL11.glColor3f(0.0f, 1.0f, 0.0f);
        }
        else {
            GL11.glColor3f(1.0f, 0.0f, 0.0f);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)n, (float)n2 + 2.25f, (float)n3);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(n4 - 45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(1.5f, 1.5f, 1.5f);
        this.func_110776_a(RenderKosterClient.gtex);
        RenderKosterClient.model.func_78088_a(entityKosterClient, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
    
    public void func_76986_a(final Entity entity, final double n, final double n2, final double n3, final float n4, final float n5) {
        GL11.glEnable(32826);
        this.render((EntityKosterClient)entity, n, n2, n3, n4, n5);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return null;
    }
    
    static {
        RenderKosterClient.model = new ModelKoster();
        RenderKosterClient.gtex = new ResourceLocation("hcsmod:textures/koster.png");
    }
}
