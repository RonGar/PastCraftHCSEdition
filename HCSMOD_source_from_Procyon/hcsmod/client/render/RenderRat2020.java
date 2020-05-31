// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import hcsmod.entity.EntityRat2020;

public class RenderRat2020 extends uyfg
{
    private static wovl model;
    private static int displayListId;
    
    public RenderRat2020() {
        super.field_76989_e = 0.5f;
    }
    
    public void render(final EntityRat2020 entityRat2020, final double n, final double n2, final double n3, final float n4, final float n5) {
        if (entityRat2020.field_70173_aa < 2) {
            return;
        }
        this.func_110777_b((Entity)entityRat2020);
        GL11.glPushMatrix();
        GL11.glCullFace(1028);
        GL11.glTranslatef((float)n, (float)n2, (float)n3);
        GL11.glRotatef(entityRat2020.field_70177_z + 180.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(entityRat2020.preRotation + (entityRat2020.rotation - entityRat2020.preRotation) * n5, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(-0.01f, 0.01f, 0.01f);
        GL11.glTranslatef(0.0f, -7.0f, 0.0f);
        if (RenderRat2020.displayListId == -1) {
            GL11.glNewList(RenderRat2020.displayListId = GL11.glGenLists(1), 4864);
            RenderRat2020.model.renderAll();
            GL11.glEndList();
        }
        GL11.glCallList(RenderRat2020.displayListId);
        GL11.glCullFace(1029);
        GL11.glPopMatrix();
    }
    
    public void func_76986_a(final Entity entity, final double n, final double n2, final double n3, final float n4, final float n5) {
        this.render((EntityRat2020)entity, n, n2, n3, n4, n5);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return new ResourceLocation("hcsmod", "textures/items/Rat2020.png");
    }
    
    static {
        RenderRat2020.model = iwoh.loadModel("/assets/hcsmod/obj/Rat2020.obj");
        RenderRat2020.displayListId = -1;
    }
}
