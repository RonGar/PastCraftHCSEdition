// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import org.lwjgl.opengl.GL11;

public class ModelSamodel implements IVladruArmorModel
{
    public static final int BODY = 0;
    public static final int HEAD = 1;
    public static final int LARM = 2;
    public static final int RARM = 3;
    public static final int LLEG = 4;
    public static final int RLEG = 5;
    private final int body;
    private final int head;
    private final int larm;
    private final int rarm;
    private final int lleg;
    private final int rleg;
    aozt model;
    
    public ModelSamodel() {
        this.model = new aozt("samodel.obj", ModelSamodel.class.getResourceAsStream("/assets/hcsmod/obj/samodel.obj"));
        GL11.glNewList(this.head = GL11.glGenLists(6), 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("Head");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.body = this.head + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("Torso");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.larm = this.body + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("LArm");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.rarm = this.larm + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("RArm");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.lleg = this.rarm + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("LLeg");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.rleg = this.lleg + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("RLeg");
        GL11.glPopMatrix();
        GL11.glEndList();
    }
    
    @Override
    public void render(final ArmorRender.ModelPart modelPart) {
        GL11.glTranslatef(0.0f, 1.55f, 0.0f);
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        GL11.glPushAttrib(8200);
        GL11.glEnable(2884);
        GL11.glCullFace(1029);
        switch (modelPart) {
            case BODY: {
                GL11.glCallList(this.body);
                break;
            }
            case HEAD: {
                GL11.glScalef(1.05f, 1.05f, 1.05f);
                GL11.glTranslatef(0.0f, -0.05f, 0.0f);
                GL11.glCallList(this.head);
                break;
            }
            case LARM: {
                GL11.glTranslatef(0.31f, 0.05f, 0.0f);
                GL11.glCallList(this.larm);
                break;
            }
            case RARM: {
                GL11.glTranslatef(-0.31f, 0.4f, 0.0f);
                GL11.glCallList(this.rarm);
                break;
            }
            case LLEG: {
                GL11.glTranslatef(0.12f, 0.75f, 0.0f);
                GL11.glCallList(this.lleg);
                break;
            }
            case RLEG: {
                GL11.glTranslatef(-0.12f, 0.75f, 0.0f);
                GL11.glCallList(this.rleg);
                break;
            }
        }
        GL11.glPopAttrib();
    }
}
