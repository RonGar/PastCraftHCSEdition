// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import org.lwjgl.opengl.GL11;

public class ModelRF implements IVladruArmorModel
{
    private final int body;
    private final int head;
    private final int larm;
    private final int rarm;
    private final int lleg;
    private final int rleg;
    private final int lboot;
    private final int rboot;
    aozt model;
    
    public ModelRF() {
        this.model = new aozt("RFarmor.obj", ModelRF.class.getResourceAsStream("/assets/hcsmod/obj/RFarmor.obj"));
        GL11.glNewList(this.head = GL11.glGenLists(6), 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("helmet");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.body = this.head + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("body");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.larm = this.body + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("left_arm");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.rarm = this.larm + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("right_arm");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.lleg = this.rarm + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("left_leg");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.rleg = this.lleg + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("right_leg");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.lboot = this.rleg + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("left_boot");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.rboot = this.lboot + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("right_boot");
        GL11.glPopMatrix();
        GL11.glEndList();
    }
    
    @Override
    public void render(final ArmorRender.ModelPart modelPart) {
        GL11.glTranslatef(0.0f, 1.55f, 0.0f);
        GL11.glScalef(-0.301f, -0.301f, 0.301f);
        switch (modelPart) {
            case HEAD: {
                GL11.glTranslatef(0.0f, 0.2f, 0.0f);
                GL11.glScalef(1.05f, 1.05f, 1.05f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glCallList(this.head);
                break;
            }
            case BODY: {
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(0.0f, 0.31f, 0.0f);
                GL11.glCallList(this.body);
                break;
            }
            case LARM: {
                GL11.glTranslatef(1.2f, 0.3f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(1.12f, 1.12f, 1.12f);
                GL11.glCallList(this.larm);
                break;
            }
            case RARM: {
                GL11.glTranslatef(-1.2f, 0.3f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(1.12f, 1.12f, 1.12f);
                GL11.glCallList(this.rarm);
                break;
            }
            case LLEG: {
                GL11.glTranslatef(0.42f, 3.0f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glCallList(this.lleg);
                break;
            }
            case RLEG: {
                GL11.glTranslatef(-0.42f, 3.0f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glCallList(this.rleg);
                break;
            }
            case LBOOT: {
                GL11.glTranslatef(0.41f, 2.6f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glCallList(this.lboot);
                break;
            }
            case RBOOT: {
                GL11.glTranslatef(-0.41f, 2.6f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glCallList(this.rboot);
                break;
            }
        }
    }
}
