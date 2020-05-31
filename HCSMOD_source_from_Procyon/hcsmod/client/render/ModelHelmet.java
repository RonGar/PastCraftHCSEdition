// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import org.lwjgl.opengl.GL11;

public class ModelHelmet implements IVladruArmorModel
{
    private static final int HELMET = 0;
    private static final int HEHELMETGL = 1;
    private static final int HELMETPNV = 2;
    private static final int helmet;
    private static final int helmetgl;
    private static final int helmetpnv;
    private static aozt model;
    
    protected void renderIntertnal(final int n) {
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, -0.24f, 0.0f);
        GL11.glScalef(-0.0025f, -0.0025f, 0.0025f);
        switch (n) {
            case 1: {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
                GL11.glScalef(1.05f, 1.05f, 1.05f);
                GL11.glCallList(ModelHelmet.helmetgl);
                break;
            }
            case 0: {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
                GL11.glScalef(1.05f, 1.05f, 1.05f);
                GL11.glCallList(ModelHelmet.helmet);
                break;
            }
            case 2: {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
                GL11.glScalef(1.05f, 1.05f, 1.05f);
                GL11.glCallList(ModelHelmet.helmetpnv);
                break;
            }
        }
    }
    
    @Override
    public void render(final ArmorRender.ModelPart modelPart) {
        if (modelPart == ArmorRender.ModelPart.HEAD) {
            this.renderIntertnal(0);
        }
    }
    
    static {
        ModelHelmet.model = new aozt("helmet.obj", ModelHelmet.class.getResourceAsStream("/assets/hcsmod/obj/helmet.obj"));
        GL11.glNewList(helmetgl = GL11.glGenLists(6), 4864);
        GL11.glPushMatrix();
        ModelHelmet.model.renderPart("helmet");
        ModelHelmet.model.renderPart("oculus");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(helmet = ModelHelmet.helmetgl + 1, 4864);
        GL11.glPushMatrix();
        ModelHelmet.model.renderPart("helmet");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(helmetpnv = ModelHelmet.helmet + 1, 4864);
        GL11.glPushMatrix();
        ModelHelmet.model.renderPart("helmet");
        ModelHelmet.model.renderPart("oculus");
        ModelHelmet.model.renderPart("pnv");
        GL11.glPopMatrix();
        GL11.glEndList();
    }
    
    public static class PNV extends ModelHelmet
    {
        @Override
        public void render(final ArmorRender.ModelPart modelPart) {
            if (modelPart == ArmorRender.ModelPart.HEAD) {
                this.renderIntertnal(2);
            }
        }
    }
    
    public static class GL extends ModelHelmet
    {
        @Override
        public void render(final ArmorRender.ModelPart modelPart) {
            if (modelPart == ArmorRender.ModelPart.HEAD) {
                this.renderIntertnal(1);
            }
        }
    }
}
