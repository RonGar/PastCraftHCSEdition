// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.jugger;

import hcsmod.client.render.ArmorRender;
import org.lwjgl.opengl.GL11;
import hcsmod.client.render.IVladruArmorModel;

public class ModelJugger implements IVladruArmorModel
{
    public static final int BODY = 0;
    public static final int HEAD = 1;
    public static final int LARM = 2;
    public static final int RARM = 3;
    public static final int LLEG = 4;
    public static final int RLEG = 5;
    public static final int LBOOT = 6;
    public static final int RBOOT = 7;
    private final int body;
    private final int head;
    private final int larm;
    private final int rarm;
    private final int lleg;
    private final int rleg;
    private final int lboot;
    private final int rboot;
    private final int vorot;
    aozt model;
    
    public ModelJugger() {
        this.model = new aozt("jugger.obj", ModelJugger.class.getResourceAsStream("/assets/hcsmod/obj/jugger.obj"));
        GL11.glNewList(this.head = GL11.glGenLists(9), 4864);
        this.model.renderPart("head");
        GL11.glEndList();
        GL11.glNewList(this.body = this.head + 1, 4864);
        this.model.renderPart("body");
        GL11.glEndList();
        GL11.glNewList(this.larm = this.body + 1, 4864);
        this.model.renderPart("left_arm");
        GL11.glEndList();
        GL11.glNewList(this.rarm = this.larm + 1, 4864);
        this.model.renderPart("right_arm");
        GL11.glEndList();
        GL11.glNewList(this.lleg = this.rarm + 1, 4864);
        this.model.renderPart("left_leg");
        GL11.glEndList();
        GL11.glNewList(this.rleg = this.lleg + 1, 4864);
        this.model.renderPart("right_leg");
        GL11.glEndList();
        GL11.glNewList(this.lboot = this.rleg + 1, 4864);
        this.model.renderPart("left_boot");
        GL11.glEndList();
        GL11.glNewList(this.rboot = this.lboot + 1, 4864);
        this.model.renderPart("right_boot");
        GL11.glEndList();
        GL11.glNewList(this.vorot = this.rboot + 1, 4864);
        this.model.renderPart("vorot");
        GL11.glEndList();
    }
    
    @Override
    public void render(final ArmorRender.ModelPart modelPart) {
        GL11.glTranslatef(0.0f, 1.55f, 0.0f);
        GL11.glScalef(0.0101f, -0.0101f, 0.0101f);
        GL11.glPushAttrib(8200);
        GL11.glEnable(2884);
        GL11.glCullFace(1028);
        switch (modelPart) {
            case BODY: {
                GL11.glTranslatef(0.0f, 2.0f, 0.0f);
                GL11.glCallList(this.body);
                GL11.glCallList(this.vorot);
                break;
            }
            case HEAD: {
                GL11.glTranslatef(0.0f, -15.0f, 0.0f);
                GL11.glScalef(1.1f, 1.1f, 1.1f);
                GL11.glCallList(this.head);
                break;
            }
            case JAGVOROT: {
                GL11.glTranslatef(0.0f, 2.0f, 0.0f);
                GL11.glCallList(this.head);
                break;
            }
            case LARM: {
                GL11.glTranslatef(-32.0f, 16.0f, 0.0f);
                GL11.glCallList(this.larm);
                break;
            }
            case RARM: {
                GL11.glTranslatef(32.0f, 16.0f, 0.0f);
                GL11.glCallList(this.rarm);
                break;
            }
            case LLEG: {
                GL11.glTranslatef(-13.0f, 80.0f, 0.0f);
                GL11.glCallList(this.lleg);
                break;
            }
            case RLEG: {
                GL11.glTranslatef(13.0f, 80.0f, 0.0f);
                GL11.glCallList(this.rleg);
                break;
            }
            case RBOOT: {
                GL11.glTranslatef(12.0f, 80.0f, 0.0f);
                GL11.glCallList(this.rboot);
                break;
            }
            case LBOOT: {
                GL11.glTranslatef(-12.0f, 80.0f, 0.0f);
                GL11.glCallList(this.lboot);
                break;
            }
        }
        GL11.glPopAttrib();
    }
}
