/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  aozt
 *  hcsmod.client.HcsClient
 *  ieta
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.model.ModelGun;
import co.uk.flansmods.client.model.RenderGun;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import hcsmod.client.HcsClient;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ModelAttachment
extends ModelBase {
    private static int scope;
    private static int barrel;
    private static int foregrip;
    aozt REDDOT_SIGHT = new aozt("REDDOT_SIGHT.obj", ModelGun.class.getResourceAsStream("/assets/hcsmod/obj/REDDOT_SIGHT.obj"));
    aozt US_Silenser = new aozt("US_Silenser.obj", ModelGun.class.getResourceAsStream("/assets/hcsmod/obj/US_Silenser.obj"));
    aozt Vert_Grip = new aozt("Vert_Grip.obj", ModelGun.class.getResourceAsStream("/assets/hcsmod/obj/Vert_Grip.obj"));
    public static ResourceLocation REDDOT_SIGHT_TEX;
    public static ResourceLocation US_Silenser_TEX;
    public static ResourceLocation Vert_Grip_TEX;
    private static final Map displayLists;
    public ModelRendererTurbo[] attachmentModel = new ModelRendererTurbo[0];
    public float renderOffset = 0.0f;

    public void renderAttachment(float f, int n) {
        if (!HcsClient.ATTACH_RENDERED) {
            scope = GL11.glGenLists((int)3);
            GL11.glNewList((int)scope, (int)4864);
            this.REDDOT_SIGHT.renderAll();
            GL11.glEndList();
            barrel = scope + 1;
            GL11.glNewList((int)barrel, (int)4864);
            this.US_Silenser.renderAll();
            GL11.glEndList();
            foregrip = barrel + 1;
            GL11.glNewList((int)foregrip, (int)4864);
            this.Vert_Grip.renderAll();
            GL11.glEndList();
            HcsClient.ATTACH_RENDERED = true;
        }
        if (RenderGun.curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
            switch (n) {
                case 0: {
                    GL11.glPopMatrix();
                    GL11.glPushMatrix();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)0.015f, (float)0.36f, (float)0.0f);
                    GL11.glScalef((float)0.02f, (float)0.02f, (float)0.02f);
                    GL11.glPushAttrib((int)8192);
                    GL11.glDisable((int)2884);
                    GL11.glCallList((int)scope);
                    GL11.glPopAttrib();
                    GL11.glPopMatrix();
                    break;
                }
                case 1: {
                    GL11.glPopMatrix();
                    GL11.glPushMatrix();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)1.0f, (float)0.2725f, (float)0.0f);
                    GL11.glScalef((float)0.02f, (float)0.02f, (float)0.02f);
                    GL11.glCallList((int)barrel);
                    GL11.glPopMatrix();
                    break;
                }
                case 2: {
                    GL11.glPopMatrix();
                    GL11.glPushMatrix();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)0.5f, (float)0.16f, (float)0.0f);
                    GL11.glScalef((float)0.02f, (float)0.02f, (float)0.02f);
                    GL11.glCallList((int)foregrip);
                    GL11.glPopMatrix();
                }
            }
            return;
        }
        ModelRendererTurbo[] arrmodelRendererTurbo = this.attachmentModel;
        int n2 = arrmodelRendererTurbo.length;
        Integer n3 = (Integer)displayLists.get((Object)this);
        if (n3 != null) {
            GL11.glCallList((int)n3);
        } else {
            int n4 = GL11.glGenLists((int)1);
            GL11.glNewList((int)n4, (int)4864);
            for (int i = 0; i < n2; ++i) {
                ModelRendererTurbo modelRendererTurbo = arrmodelRendererTurbo[i];
                if (modelRendererTurbo == null) continue;
                modelRendererTurbo.renderNoDL(f);
            }
            GL11.glEndList();
            displayLists.put(this, n4);
        }
    }

    static {
        REDDOT_SIGHT_TEX = new ResourceLocation("hcsmod:textures/REDDOT_SIGHT.png");
        US_Silenser_TEX = new ResourceLocation("hcsmod:textures/US_Silenser.png");
        Vert_Grip_TEX = new ResourceLocation("hcsmod:textures/Vert_Grip.png");
        displayLists = new HashMap();
    }
}

