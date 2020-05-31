// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.flashlight;

import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.tuor;

public class ItemRenderFlashlight implements rqjc
{
    private wovl model;
    
    public ItemRenderFlashlight() {
        this.model = iwoh.loadModel("/flashlightmod/textures/models/light.obj");
    }
    
    public boolean handleRenderType(final ieta ieta, final rqjc.uxsf uxsf) {
        switch (uxsf) {
            case EQUIPPED: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public boolean shouldUseRenderHelper(final rqjc.uxsf uxsf, final ieta ieta, final rqjc.eidn eidn) {
        return false;
    }
    
    public void renderItem(final rqjc.uxsf uxsf, final ieta ieta, final Object... array) {
        tuor._E();
        switch (uxsf) {
            case EQUIPPED: {
                GL11.glPushMatrix();
                if (array[1] != null & array[1] instanceof EntityPlayer) {
                    GL11.glScalef(0.6f, 0.6f, 0.6f);
                    if (array[1] != tuor._E()._s || tuor._E()._K.__bw != 0 || ((tuor._E()._z instanceof kkdv || tuor._E()._z instanceof bqho) && dfsc._b._l == 180.0f)) {
                        GL11.glTranslatef(1.0f, 0.4f, 0.0f);
                        GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
                        GL11.glRotatef(190.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glScalef(0.21f, 0.21f, 0.18f);
                    }
                    else {
                        GL11.glTranslatef(0.9f, 0.63f, -0.1f);
                        GL11.glRotatef(150.0f, 1.0f, 0.0f, 0.0f);
                        GL11.glRotatef(65.0f, -10.0f, 1.0f, 3.0f);
                        GL11.glRotatef(-105.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(240.0f, 80.0f, 0.0f, 0.0f);
                        GL11.glScalef(0.13f, 0.13f, 0.08f);
                        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glTranslatef(0.9f, 0.0f, -2.0f);
                    }
                }
                else {
                    GL11.glTranslatef(1.0f, 0.4f, 0.0f);
                    GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
                    GL11.glRotatef(190.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glScalef(0.21f, 0.21f, 0.18f);
                }
                this.model.renderAll();
                GL11.glPopMatrix();
                break;
            }
        }
    }
}
