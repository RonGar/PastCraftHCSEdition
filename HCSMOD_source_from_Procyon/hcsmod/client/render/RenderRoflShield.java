// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.client.tuor;
import org.lwjgl.opengl.GL11;
import hcsmod.client.CEventHandler;
import net.minecraft.util.ResourceLocation;

public class RenderRoflShield implements rqjc
{
    private final ResourceLocation resourceLocation;
    private int displayListId;
    
    public RenderRoflShield() {
        this.resourceLocation = new ResourceLocation("hcsmod", "rolf/ballistic_shield.png");
        this.displayListId = -1;
    }
    
    public boolean handleRenderType(final ieta ieta, final rqjc.uxsf uxsf) {
        return CEventHandler.renderedPlayer != null && CEventHandler.renderedPlayer.func_70632_aY() && (uxsf == rqjc.uxsf.EQUIPPED_FIRST_PERSON || uxsf == rqjc.uxsf.EQUIPPED);
    }
    
    public boolean shouldUseRenderHelper(final rqjc.uxsf uxsf, final ieta ieta, final rqjc.eidn eidn) {
        return false;
    }
    
    public void renderItem(final rqjc.uxsf uxsf, final ieta ieta, final Object... array) {
        if (ieta._b() != null) {
            if (uxsf == rqjc.uxsf.EQUIPPED_FIRST_PERSON) {
                GL11.glEnable(32826);
                tuor._E()._f._a(this.resourceLocation);
                GL11.glPushMatrix();
                GL11.glTranslatef(0.95f, 0.95f, -0.7f);
                GL11.glRotatef(150.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-105.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScalef(0.02f, 0.02f, 0.02f);
                GL11.glCallList(this.getDisplayListId());
                GL11.glPopMatrix();
            }
            else if (uxsf == rqjc.uxsf.EQUIPPED) {
                GL11.glEnable(32826);
                tuor._E()._f._a(this.resourceLocation);
                GL11.glPushMatrix();
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslated(0.44999998807907104, -0.5, -0.15000000596046448);
                GL11.glScalef(0.01f, 0.01f, 0.01f);
                GL11.glCallList(this.getDisplayListId());
                GL11.glPopMatrix();
            }
        }
    }
    
    private int getDisplayListId() {
        if (this.displayListId == -1) {
            GL11.glNewList(this.displayListId = GL11.glGenLists(1), 4864);
            try {
                iwoh.loadModel("/assets/hcsmod/rolf/ballistic_shield.obj").renderAll();
            }
            catch (RuntimeException ex) {
                System.err.println("ROFL shield (iron sword)");
                throw ex;
            }
            GL11.glEndList();
        }
        return this.displayListId;
    }
}
