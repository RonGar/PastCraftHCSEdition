// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;

public class ModelPNV extends ModelBase
{
    int DL;
    aozt model_pnv;
    
    public ModelPNV() {
        this.DL = -1;
        this.model_pnv = new aozt("PNV.obj", ModelSamodel.class.getResourceAsStream("/assets/hcsmod/obj/PNV.obj"));
        GL11.glNewList(this.DL = GL11.glGenLists(1), 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model_pnv.renderAll();
        GL11.glPopMatrix();
        GL11.glEndList();
    }
    
    public void render(final int n) {
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.12f, 0.0f);
        GL11.glScalef(0.01f, -0.01f, 0.01f);
        GL11.glCallList(this.DL);
    }
}
