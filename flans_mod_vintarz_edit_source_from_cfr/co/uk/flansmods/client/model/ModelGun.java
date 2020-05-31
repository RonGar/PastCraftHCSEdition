/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  aozt
 *  hcsmod.client.HcsClient
 *  ieta
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.tuor
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  rqjc
 *  rqjc$uxsf
 *  zfwe
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.FlansModResourceHandler;
import co.uk.flansmods.client.model.EnumAnimationType;
import co.uk.flansmods.client.model.RenderGun;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.vector.Vector3f;
import hcsmod.client.HcsClient;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.tuor;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ModelGun
extends ModelBase {
    private ModelBiped mainModel = new ModelBiped();
    private static final Map<Object, Integer> displayLists = new HashMap<Object, Integer>();
    public static boolean DRAWING_INVENTORY = false;
    aozt SAW = new aozt("SAW.obj", ModelGun.class.getResourceAsStream("/assets/hcsmod/obj/SAW.obj"));
    aozt NY2020 = new aozt("ny2020.obj", ModelGun.class.getResourceAsStream("/assets/hcsmod/obj/ny2020.obj"));
    public static ResourceLocation SAW_TEX = new ResourceLocation("hcsmod:textures/SAW.png");
    public static ResourceLocation NY2020_TEX = new ResourceLocation("hcsmod:textures/ny2020_tex.png");
    public ModelRendererTurbo[] gunModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] defaultBarrelModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] defaultScopeModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] defaultStockModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] defaultGripModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] ammoModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] slideModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] pumpModel = new ModelRendererTurbo[0];
    public Vector3f barrelAttachPoint = new Vector3f();
    public Vector3f scopeAttachPoint = new Vector3f();
    public Vector3f stockAttachPoint = new Vector3f();
    public Vector3f gripAttachPoint = new Vector3f();
    public float gunSlideDistance = 0.25f;
    public EnumAnimationType animationType = EnumAnimationType.NONE;
    public float tiltGunTime = 0.25f;
    public float unloadClipTime = 0.25f;
    public float loadClipTime = 0.25f;
    public float untiltGunTime = 0.25f;
    public boolean scopeIsOnSlide = false;
    public float numBulletsInReloadAnimation = 1.0f;
    public int pumpDelay = 0;
    public int pumpDelayAfterReload = 0;
    public int pumpTime = 1;
    public float pumpHandleDistance = 0.25f;

    public void renderGun(float f) {
        this.render(this.gunModel, f, 0);
    }

    public void renderSlide(float f) {
        this.render(this.slideModel, f, 1);
    }

    public void renderPump(float f) {
        this.render(this.pumpModel, f, 2);
    }

    public void renderDefaultScope(float f) {
        this.render(this.defaultScopeModel, f, -1);
    }

    public void renderDefaultBarrel(float f) {
        this.render(this.defaultBarrelModel, f, -1);
    }

    public void renderDefaultStock(float f) {
        this.render(this.defaultStockModel, f, -1);
    }

    public void renderDefaultGrip(float f) {
        this.render(this.defaultGripModel, f, -1);
    }

    public void renderAmmo(float f) {
        if (RenderGun.renderType == rqjc.uxsf.EQUIPPED_FIRST_PERSON) {
            GL11.glPushMatrix();
            GL11.glScalef((float)0.05f, (float)0.05f, (float)0.05f);
            GL11.glScalef((float)1.5f, (float)1.0f, (float)1.5f);
            GL11.glTranslatef((float)-4.0f, (float)-1.0f, (float)-2.0f);
            GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)-50.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)-10.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            ResourceLocation resourceLocation = AbstractClientPlayer.func_110311_f((String)tuor._E()._r.field_71092_bJ);
            AbstractClientPlayer.func_110304_a((ResourceLocation)resourceLocation, (String)tuor._E()._r.field_71092_bJ);
            tuor._E()._f._a(resourceLocation);
            if (!DRAWING_INVENTORY) {
                this.mainModel.field_78113_g.func_78785_a(0.625f);
            }
            GL11.glPopMatrix();
        }
        if (RenderGun.curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
            tuor._E()._f._a(SAW_TEX);
        } else if (RenderGun.curritem != null && RenderGun.curritem._d == 23869) {
            tuor._E()._f._a(NY2020_TEX);
        } else {
            tuor._E()._f._a(FlansModResourceHandler.getTexture(RenderGun.currentRenderedGunType));
        }
        this.render(this.ammoModel, f, 3);
    }

    private void render(ModelRendererTurbo[] arrmodelRendererTurbo, float f, int n) {
        ModelRendererTurbo[] arrmodelRendererTurbo2 = arrmodelRendererTurbo;
        Integer n2 = displayLists.get(arrmodelRendererTurbo);
        if (HcsClient.clearDL) {
            for (Integer arrmodelRendererTurbo3 : displayLists.values()) {
                GL11.glDeleteLists((int)arrmodelRendererTurbo3, (int)1);
            }
            displayLists.clear();
            HcsClient.clearDL = false;
        }
        if (n2 != null) {
            if (RenderGun.curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
                GL11.glPushMatrix();
                GL11.glScalef((float)0.015f, (float)0.015f, (float)0.015f);
                GL11.glTranslatef((float)0.0f, (float)4.0f, (float)0.0f);
                GL11.glCallList((int)n2);
                GL11.glPopMatrix();
            } else if (RenderGun.curritem != null && RenderGun.curritem._d == 23869) {
                GL11.glPushMatrix();
                GL11.glScalef((float)0.015f, (float)0.015f, (float)0.015f);
                GL11.glTranslatef((float)0.0f, (float)4.0f, (float)0.0f);
                GL11.glCallList((int)n2);
                GL11.glPopMatrix();
            } else {
                GL11.glCallList((int)n2);
            }
        } else {
            int n3 = GL11.glGenLists((int)1);
            GL11.glNewList((int)n3, (int)4864);
            if (RenderGun.curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
                switch (n) {
                    case 0: {
                        this.SAW.renderPart("korpus");
                        this.SAW.renderPart("krishka");
                        this.SAW.renderPart("ruchka");
                        this.SAW.renderPart("shtorka");
                        break;
                    }
                    case 1: {
                        this.SAW.renderPart("zatvor");
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        this.SAW.renderPart("korob");
                        this.SAW.renderPart("lenta1");
                        this.SAW.renderPart("lenta2");
                        this.SAW.renderPart("lenta3");
                        this.SAW.renderPart("lenta4");
                        this.SAW.renderPart("lenta5");
                        this.SAW.renderPart("lenta6");
                        break;
                    }
                    default: {
                        break;
                    }
                }
            } else if (RenderGun.curritem != null && RenderGun.curritem._d == 23869) {
                switch (n) {
                    case 0: {
                        this.NY2020.renderPart("korpus");
                        this.NY2020.renderPart("zatvor");
                        break;
                    }
                    case 1: {
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        this.NY2020.renderPart("magazin");
                        break;
                    }
                    default: {
                        break;
                    }
                }
            } else {
                for (ModelRendererTurbo modelRendererTurbo : arrmodelRendererTurbo2) {
                    if (modelRendererTurbo == null) continue;
                    modelRendererTurbo.renderNoDL(f);
                }
            }
            GL11.glEndList();
            displayLists.put(arrmodelRendererTurbo, n3);
        }
    }

    public void flipAll() {
        this.flip(this.gunModel);
        this.flip(this.defaultBarrelModel);
        this.flip(this.defaultScopeModel);
        this.flip(this.defaultStockModel);
        this.flip(this.defaultGripModel);
        this.flip(this.ammoModel);
        this.flip(this.slideModel);
        this.flip(this.pumpModel);
    }

    protected void flip(ModelRendererTurbo[] arrmodelRendererTurbo) {
        ModelRendererTurbo[] arrmodelRendererTurbo2 = arrmodelRendererTurbo;
        int n = arrmodelRendererTurbo.length;
        for (int i = 0; i < n; ++i) {
            ModelRendererTurbo modelRendererTurbo = arrmodelRendererTurbo2[i];
            modelRendererTurbo.doMirror(false, true, true);
            modelRendererTurbo.func_78793_a(modelRendererTurbo.field_78800_c, -modelRendererTurbo.field_78797_d, -modelRendererTurbo.field_78798_e);
        }
    }

    public void translateAll(float f, float f2, float f3) {
        this.translate(this.gunModel, f, f2, f3);
        this.translate(this.defaultBarrelModel, f, f2, f3);
        this.translate(this.defaultScopeModel, f, f2, f3);
        this.translate(this.defaultStockModel, f, f2, f3);
        this.translate(this.defaultGripModel, f, f2, f3);
        this.translate(this.ammoModel, f, f2, f3);
        this.translate(this.slideModel, f, f2, f3);
        this.translate(this.pumpModel, f, f2, f3);
    }

    protected void translate(ModelRendererTurbo[] arrmodelRendererTurbo, float f, float f2, float f3) {
        ModelRendererTurbo[] arrmodelRendererTurbo2 = arrmodelRendererTurbo;
        int n = arrmodelRendererTurbo.length;
        for (int i = 0; i < n; ++i) {
            ModelRendererTurbo modelRendererTurbo = arrmodelRendererTurbo2[i];
            modelRendererTurbo.field_78800_c += f;
            modelRendererTurbo.field_78797_d += f2;
            modelRendererTurbo.field_78798_e += f3;
        }
    }
}

