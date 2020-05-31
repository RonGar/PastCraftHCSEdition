// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import org.lwjgl.opengl.GL11;

public class ModelArmor2020 implements IVladruArmorModel
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
    
    public ModelArmor2020() {
        this.model = new aozt("Armor2020.obj", ModelArmor2020.class.getResourceAsStream("/assets/hcsmod/obj/Armor2020.obj"));
        GL11.glNewList(this.head = GL11.glGenLists(6), 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("Head");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.body = this.head + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("Body");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.larm = this.body + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("Left_right");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.rarm = this.larm + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("Right_arm");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.lleg = this.rarm + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("Left_pant");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.rleg = this.lleg + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("Right_pant");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.lboot = this.rleg + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("Left_leg");
        GL11.glPopMatrix();
        GL11.glEndList();
        GL11.glNewList(this.rboot = this.lboot + 1, 4864);
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.model.renderPart("Right_leg");
        GL11.glPopMatrix();
        GL11.glEndList();
    }
    
    @Override
    public void render(final ArmorRender.ModelPart modelPart) {
        GL11.glTranslatef(0.0f, 1.55f, 0.0f);
        GL11.glScalef(-0.0015f, -0.0015f, -0.0015f);
        GL11.glPushAttrib(8200);
        GL11.glEnable(2884);
        GL11.glCullFace(1028);
        switch (modelPart) {
            case HEAD: {
                GL11.glTranslatef(0.0f, 0.2f, 0.0f);
                GL11.glScalef(1.0f, 1.05f, 1.05f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glCallList(this.head);
                break;
            }
            case BODY: {
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(0.0f, 49.0f, 0.0f);
                GL11.glCallList(this.body);
                break;
            }
            case LARM: {
                GL11.glTranslatef(240.0f, 22.0f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(1.12f, 1.12f, 1.12f);
                GL11.glCallList(this.larm);
                break;
            }
            case RARM: {
                GL11.glTranslatef(-240.0f, 22.0f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(1.12f, 1.12f, 1.12f);
                GL11.glCallList(this.rarm);
                break;
            }
            case LLEG: {
                GL11.glTranslatef(80.0f, 540.0f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glCallList(this.lleg);
                break;
            }
            case RLEG: {
                GL11.glTranslatef(-80.0f, 540.0f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glCallList(this.rleg);
                break;
            }
            case LBOOT: {
                GL11.glTranslatef(80.0f, 537.0f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glCallList(this.lboot);
                break;
            }
            case RBOOT: {
                GL11.glTranslatef(-80.0f, 537.0f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glCallList(this.rboot);
                break;
            }
        }
        GL11.glPopAttrib();
    }
}
