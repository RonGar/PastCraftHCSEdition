// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import org.lwjgl.opengl.GL11;

public class ModelBackPack
{
    private final int czech;
    private final int assault;
    private final int survival;
    aozt model_czech;
    aozt model_assault;
    aozt model_survival;
    
    public ModelBackPack() {
        this.model_czech = new aozt("czech.obj", ModelSamodel.class.getResourceAsStream("/assets/hcsmod/obj/czech.obj"));
        this.model_assault = new aozt("assault.obj", ModelSamodel.class.getResourceAsStream("/assets/hcsmod/obj/assault.obj"));
        this.model_survival = new aozt("survival.obj", ModelSamodel.class.getResourceAsStream("/assets/hcsmod/obj/survival.obj"));
        GL11.glNewList(this.czech = GL11.glGenLists(1), 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model_czech.renderAll();
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.assault = GL11.glGenLists(1), 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model_assault.renderAll();
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.survival = GL11.glGenLists(1), 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model_survival.renderAll();
        GL11.glPopMatrix();
        GL11.glEndList();
    }
    
    public void render(final int n) {
        GL11.glPushAttrib(8200);
        GL11.glEnable(2884);
        GL11.glCullFace(1028);
        switch (n) {
            case 0: {
                GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(0.1f, 1.55f, 0.0f);
                GL11.glScalef(0.01f, -0.01f, 0.01f);
                GL11.glCallList(this.czech);
                break;
            }
            case 1: {
                GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(0.1f, 1.45f, 0.0f);
                GL11.glScalef(0.01f, -0.01f, 0.01f);
                GL11.glCallList(this.assault);
                break;
            }
            case 2: {
                GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(0.1f, 1.5f, 0.0f);
                GL11.glScalef(0.01f, -0.01f, 0.01f);
                GL11.glCallList(this.survival);
                break;
            }
        }
        GL11.glPopAttrib();
    }
}
