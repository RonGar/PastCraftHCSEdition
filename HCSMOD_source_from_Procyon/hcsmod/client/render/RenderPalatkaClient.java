// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import hcsmod.client.PlacingPalatkaHouse;

public class RenderPalatkaClient extends uyfg
{
    public void render(final PlacingPalatkaHouse placingPalatkaHouse, final double n, final double n2, final double n3, final float n4, final float n5) {
        if (placingPalatkaHouse.placeAllowed) {
            GL11.glColor3f(0.0f, 1.0f, 0.0f);
        }
        else {
            GL11.glColor3f(1.0f, 0.0f, 0.0f);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)n, (float)n2 + 1.5f, (float)n3);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(n4 - 45.0f, 0.0f, 1.0f, 0.0f);
        if (placingPalatkaHouse.house) {
            GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
            GL11.glTranslatef(0.0f, -1.5f, 0.0f);
            GL11.glRotatef(90.0f, 0.0f, -1.0f, 0.0f);
            GL11.glScalef(0.095f, 0.095f, 0.095f);
            RenderHouse.render();
        }
        else {
            GL11.glTranslatef(0.0f, 0.0f, -1.75f);
            this.func_110776_a(RenderPalatka.gtex);
            RenderPalatka.model.func_78088_a(placingPalatkaHouse, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        }
        GL11.glPopMatrix();
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
    }
    
    public void func_76986_a(final Entity entity, final double n, final double n2, final double n3, final float n4, final float n5) {
        GL11.glEnable(32826);
        this.render((PlacingPalatkaHouse)entity, n, n2, n3, n4, n5);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return null;
    }
}
