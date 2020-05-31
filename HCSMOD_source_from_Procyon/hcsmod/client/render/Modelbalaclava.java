// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import org.lwjgl.opengl.GL11;

public class Modelbalaclava implements IVladruArmorModel
{
    int DL;
    aozt model_balaclava;
    
    public Modelbalaclava() {
        this.DL = -1;
        this.model_balaclava = new aozt("balaclava_crw.obj", ModelSamodel.class.getResourceAsStream("/assets/hcsmod/obj/balaclava_crw.obj"));
        GL11.glNewList(this.DL = GL11.glGenLists(1), 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model_balaclava.renderAll();
        GL11.glPopMatrix();
        GL11.glEndList();
    }
    
    @Override
    public void render(final ArmorRender.ModelPart modelPart) {
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        GL11.glScalef(0.01f, -0.01f, 0.01f);
        GL11.glCallList(this.DL);
    }
}
