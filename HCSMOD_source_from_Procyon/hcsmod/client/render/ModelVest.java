// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import org.lwjgl.opengl.GL11;

public class ModelVest
{
    private final int press;
    private final int bpvest;
    aozt model_press;
    aozt model_bpvest;
    
    public ModelVest() {
        this.model_press = new aozt("press.obj", ModelSamodel.class.getResourceAsStream("/assets/hcsmod/obj/press.obj"));
        this.model_bpvest = new aozt("bpvest.obj", ModelSamodel.class.getResourceAsStream("/assets/hcsmod/obj/bpvest.obj"));
        GL11.glNewList(this.press = GL11.glGenLists(1), 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model_press.renderAll();
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.bpvest = GL11.glGenLists(1), 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model_bpvest.renderAll();
        GL11.glPopMatrix();
        GL11.glEndList();
    }
    
    public void render(final int n) {
        if (n == 0) {
            GL11.glTranslatef(0.0f, 0.46f, 0.15f);
            GL11.glPushAttrib(8200);
            GL11.glEnable(2884);
            GL11.glCullFace(1029);
            GL11.glScalef(0.0031f, -0.0031f, -0.0035030001f);
            GL11.glCallList(this.press);
            GL11.glPopAttrib();
        }
        else {
            GL11.glTranslatef(0.0f, 0.58f, 0.0f);
            GL11.glPushAttrib(8200);
            GL11.glEnable(2884);
            GL11.glCullFace(1029);
            GL11.glScalef(0.00285f, -0.00285f, -0.00285f);
            GL11.glCallList(this.bpvest);
            GL11.glPopAttrib();
        }
    }
}
