/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  dwms
 *  hcsmod.client.HcsClient
 *  ieta
 *  jhvs
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.dwbg
 *  org.lwjgl.opengl.GL11
 *  rqjc
 *  rqjc$eidn
 *  rqjc$uxsf
 *  uyla
 *  zfwe
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.FlansModClient;
import co.uk.flansmods.client.FlansModResourceHandler;
import co.uk.flansmods.client.model.EnumAnimationType;
import co.uk.flansmods.client.model.GunAnimations;
import co.uk.flansmods.client.model.ModelAttachment;
import co.uk.flansmods.client.model.ModelGun;
import co.uk.flansmods.common.guns.AttachmentType;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.IScope;
import co.uk.flansmods.common.guns.ItemBullet;
import co.uk.flansmods.common.guns.ItemGun;
import co.uk.flansmods.common.vector.Vector3f;
import hcsmod.client.HcsClient;
import java.util.HashMap;
import java.util.Random;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.tuor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwbg;
import org.lwjgl.opengl.GL11;

public class RenderGun
implements rqjc {
    private static final Random rng = new Random();
    private ModelBiped mainModel = new ModelBiped();
    private static zfwe renderEngine = tuor._E()._f;
    public static ieta curritem;
    public static GunType currentRenderedGunType;
    public static rqjc.uxsf renderType;
    public static float smoothing;

    public boolean handleRenderType(ieta ieta2, rqjc.uxsf uxsf2) {
        switch (uxsf2) {
            case ENTITY: {
                if (!tuor._E()._K._q) {
                    return false;
                }
            }
            case EQUIPPED: 
            case EQUIPPED_FIRST_PERSON: {
                return ieta2 != null && ieta2._a() instanceof ItemGun && ((ItemGun)ieta2._a()).type.model != null;
            }
        }
        return false;
    }

    public boolean shouldUseRenderHelper(rqjc.uxsf uxsf2, ieta ieta2, rqjc.eidn eidn2) {
        return false;
    }

    public void renderItem(rqjc.uxsf uxsf2, ieta ieta2, Object ... arrobject) {
        if (!(ieta2._a() instanceof ItemGun)) {
            return;
        }
        GunType gunType = ((ItemGun)ieta2._a()).type;
        if (gunType == null) {
            return;
        }
        ModelGun modelGun = gunType.model;
        if (modelGun == null) {
            return;
        }
        GunAnimations gunAnimations = (GunAnimations)FlansModClient.gunAnimations.get(arrobject[1]);
        if (gunAnimations == null) {
            gunAnimations = new GunAnimations();
            if (uxsf2 != rqjc.uxsf.ENTITY) {
                FlansModClient.gunAnimations.put((EntityLivingBase)arrobject[1], gunAnimations);
            }
        }
        GL11.glPushMatrix();
        float f = 0.0f;
        block0 : switch (uxsf2) {
            case ENTITY: {
                EntityItem entityItem = (EntityItem)arrobject[1];
                if (entityItem.field_70125_A == 0.0f) {
                    entityItem.field_70125_A = rng.nextBoolean() ? 90.0f : -90.0f;
                    entityItem.field_70177_z = rng.nextFloat() * 360.0f;
                }
                GL11.glRotatef((float)entityItem.field_70177_z, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)entityItem.field_70125_A, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
                break;
            }
            case EQUIPPED: {
                GL11.glRotatef((float)35.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)-5.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glTranslatef((float)0.75f, (float)-0.22f, (float)-0.08f);
                GL11.glScalef((float)1.0f, (float)1.0f, (float)-1.0f);
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                float f2 = FlansModClient.lastZoomProgress + (FlansModClient.zoomProgress - FlansModClient.lastZoomProgress) * smoothing;
                GL11.glRotatef((float)(25.0f - 5.0f * f2), (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)-5.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                ItemGun itemGun = (ItemGun)ieta2._a();
                float f3 = (gunAnimations.lastGunSlide + (gunAnimations.gunSlide - gunAnimations.lastGunSlide) * smoothing) * 0.04f * itemGun.getClientRecoil(ieta2);
                GL11.glTranslatef((float)(-f3), (float)(-f3 * 0.1f), (float)0.0f);
                float f4 = 0.175f;
                AttachmentType attachmentType = gunType.getScope(ieta2);
                if (attachmentType != null) {
                    f4 = gunType.yOffset;
                    f4 += modelGun.scopeAttachPoint.y * gunType.modelScale;
                    f4 = ieta2._d == 14102 && HcsClient.fancyGuns ? (f4 -= 0.11f) : (f4 -= attachmentType.yOffset);
                }
                if (ieta2._d == 23869) {
                    f4 = 0.195f;
                }
                GL11.glTranslatef((float)0.25f, (float)(0.2f + f4 * f2), (float)(-0.597f - 0.405f * f2));
                GL11.glRotatef((float)(4.5f * f2), (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslatef((float)0.0f, (float)(-0.03f * f2), (float)0.0f);
                if (!gunAnimations.reloading) break;
                float f5 = gunAnimations.lastReloadAnimationProgress + (gunAnimations.reloadAnimationProgress - gunAnimations.lastReloadAnimationProgress) * smoothing;
                f = 1.0f;
                if (f5 < modelGun.tiltGunTime) {
                    f = f5 / modelGun.tiltGunTime;
                }
                if (f5 > modelGun.tiltGunTime + modelGun.unloadClipTime + modelGun.loadClipTime) {
                    f = 1.0f - (f5 - (modelGun.tiltGunTime + modelGun.unloadClipTime + modelGun.loadClipTime)) / modelGun.untiltGunTime;
                }
                switch (modelGun.animationType) {
                    case BOTTOM_CLIP: 
                    case PISTOL_CLIP: 
                    case SHOTGUN: 
                    case END_LOADED: {
                        GL11.glRotatef((float)(20.0f * f), (float)0.0f, (float)0.0f, (float)1.0f);
                        GL11.glRotatef((float)(15.0f * f), (float)1.0f, (float)0.0f, (float)0.0f);
                        break block0;
                    }
                    case RIFLE: {
                        GL11.glRotatef((float)(30.0f * f), (float)0.0f, (float)0.0f, (float)1.0f);
                        GL11.glRotatef((float)(-30.0f * f), (float)1.0f, (float)0.0f, (float)0.0f);
                    }
                }
            }
        }
        if (FlansModClient.currentScope == null || !FlansModClient.currentScope.hasZoomOverlay() || tuor._E()._z != null || FlansModClient.zoomProgress <= 0.8f) {
            renderType = uxsf2;
            this.renderGun(ieta2, gunType, 0.0625f, modelGun, gunAnimations, f);
        }
        GL11.glPopMatrix();
    }

    public void renderGun(ieta ieta2, GunType gunType, float f, ModelGun modelGun, GunAnimations gunAnimations, float f2) {
        int n;
        if (gunAnimations == null) {
            gunAnimations = GunAnimations.defaults;
        }
        AttachmentType attachmentType = gunType.getScope(ieta2);
        AttachmentType attachmentType2 = gunType.getBarrel(ieta2);
        AttachmentType attachmentType3 = gunType.getStock(ieta2);
        AttachmentType attachmentType4 = gunType.getGrip(ieta2);
        ieta[] arrieta = new ieta[gunType.numAmmoItemsInGun];
        boolean bl = true;
        for (n = 0; n < gunType.numAmmoItemsInGun; ++n) {
            arrieta[n] = ((ItemGun)ieta2._a()).getBulletItemStack(ieta2, n);
            if (arrieta[n] == null || !(arrieta[n]._a() instanceof ItemBullet) || arrieta[n]._j() >= arrieta[n]._k()) continue;
            bl = false;
        }
        curritem = ieta2;
        currentRenderedGunType = gunType;
        if (curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
            renderEngine._a(ModelGun.SAW_TEX);
        } else if (curritem != null && RenderGun.curritem._d == 23869) {
            renderEngine._a(ModelGun.NY2020_TEX);
        } else {
            renderEngine._a(FlansModResourceHandler.getTexture(gunType));
        }
        if (attachmentType != null) {
            GL11.glTranslatef((float)0.0f, (float)(-attachmentType.model.renderOffset / 16.0f), (float)0.0f);
        }
        if (renderType == rqjc.uxsf.EQUIPPED_FIRST_PERSON) {
            GL11.glPushMatrix();
            ResourceLocation resourceLocation = AbstractClientPlayer.func_110311_f((String)tuor._E()._r.field_71092_bJ);
            AbstractClientPlayer.func_110304_a((ResourceLocation)resourceLocation, (String)tuor._E()._r.field_71092_bJ);
            tuor._E()._f._a(resourceLocation);
            GL11.glScalef((float)0.05f, (float)0.05f, (float)0.05f);
            GL11.glScalef((float)1.5f, (float)1.0f, (float)1.5f);
            GL11.glTranslatef((float)-5.0f, (float)0.0f, (float)-1.0f);
            GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)-80.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            if (!ModelGun.DRAWING_INVENTORY) {
                this.mainModel.field_78113_g.func_78785_a(0.625f);
            }
            GL11.glPopMatrix();
        }
        GL11.glPushMatrix();
        GL11.glScalef((float)gunType.modelScale, (float)gunType.modelScale, (float)gunType.modelScale);
        if (curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
            renderEngine._a(ModelGun.SAW_TEX);
        } else if (curritem != null && RenderGun.curritem._d == 23869) {
            renderEngine._a(ModelGun.NY2020_TEX);
        } else {
            tuor._E()._f._a(FlansModResourceHandler.getTexture(currentRenderedGunType));
        }
        modelGun.renderGun(f);
        if (attachmentType == null && !modelGun.scopeIsOnSlide) {
            modelGun.renderDefaultScope(f);
        }
        if (attachmentType2 == null) {
            modelGun.renderDefaultBarrel(f);
        }
        if (attachmentType3 == null) {
            modelGun.renderDefaultStock(f);
        }
        if (attachmentType4 == null) {
            modelGun.renderDefaultGrip(f);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(-(gunAnimations.lastGunSlide + (gunAnimations.gunSlide - gunAnimations.lastGunSlide) * smoothing) * modelGun.gunSlideDistance), (float)0.0f, (float)0.0f);
        modelGun.renderSlide(f);
        if (attachmentType == null && modelGun.scopeIsOnSlide) {
            modelGun.renderDefaultScope(f);
        }
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(-(1.0f - Math.abs(gunAnimations.lastPumped + (gunAnimations.pumped - gunAnimations.lastPumped) * smoothing)) * modelGun.pumpHandleDistance), (float)0.0f, (float)0.0f);
        modelGun.renderPump(f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        n = 1;
        switch (modelGun.animationType) {
            case END_LOADED: {
                if (!bl) break;
                n = 0;
            }
        }
        if (n != 0 && gunAnimations.reloading && tuor._E()._K.__bw == 0) {
            float f3 = gunAnimations.lastReloadAnimationProgress + (gunAnimations.reloadAnimationProgress - gunAnimations.lastReloadAnimationProgress) * smoothing;
            float f4 = 0.0f;
            if (f3 > modelGun.tiltGunTime && f3 < modelGun.tiltGunTime + modelGun.unloadClipTime) {
                f4 = (f3 - modelGun.tiltGunTime) / modelGun.unloadClipTime;
            }
            if (f3 >= modelGun.tiltGunTime + modelGun.unloadClipTime && f3 < modelGun.tiltGunTime + modelGun.unloadClipTime + modelGun.loadClipTime) {
                f4 = 1.0f - (f3 - (modelGun.tiltGunTime + modelGun.unloadClipTime)) / modelGun.loadClipTime;
            }
            switch (modelGun.animationType) {
                case BOTTOM_CLIP: {
                    GL11.glRotatef((float)(-90.0f * f4 * f4), (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glTranslatef((float)0.0f, (float)(-1.0f * f4), (float)0.0f);
                    GL11.glTranslatef((float)(0.5f * f4), (float)0.0f, (float)0.0f);
                    break;
                }
                case PISTOL_CLIP: {
                    GL11.glRotatef((float)(-90.0f * f4 * f4), (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glTranslatef((float)0.0f, (float)(-1.0f * f4), (float)0.0f);
                    break;
                }
                case P90: {
                    GL11.glRotatef((float)(-15.0f * f2 * f2), (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glTranslatef((float)0.0f, (float)(0.075f * f2), (float)0.0f);
                    GL11.glTranslatef((float)(-2.0f * f4), (float)(-0.3f * f4), (float)(-0.5f * f4));
                    break;
                }
                case RIFLE: {
                    float f5 = f4 * modelGun.numBulletsInReloadAnimation;
                    int n2 = dwbg._d((float)f5);
                    float f6 = f5 - (float)n2;
                    GL11.glRotatef((float)(f6 * 15.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)(f6 * 15.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glTranslatef((float)(f6 * -1.0f), (float)0.0f, (float)(f6 * -0.5f));
                    break;
                }
                case SHOTGUN: {
                    float f7 = f4 * modelGun.numBulletsInReloadAnimation;
                    int n3 = dwbg._d((float)f7);
                    float f8 = f7 - (float)n3;
                    GL11.glRotatef((float)(f8 * -30.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glTranslatef((float)(f8 * -0.5f), (float)(f8 * -1.0f), (float)0.0f);
                    break;
                }
                case END_LOADED: {
                    float f9 = 1.0f;
                    if (f3 > modelGun.tiltGunTime) {
                        f9 = 1.0f - Math.min((f3 - modelGun.tiltGunTime) / (modelGun.unloadClipTime + modelGun.loadClipTime), 1.0f);
                    }
                    GL11.glTranslatef((float)f9, (float)0.0f, (float)0.0f);
                    if (!(f9 > 0.5f)) break;
                    GL11.glTranslatef((float)(-3.0f * (f9 - 0.5f)), (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)(-180.0f * (f9 - 0.5f)), (float)0.0f, (float)0.0f, (float)1.0f);
                }
            }
        }
        if (n != 0) {
            modelGun.renderAmmo(f);
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
        if (attachmentType != null) {
            GL11.glPushMatrix();
            if (curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
                renderEngine._a(ModelAttachment.REDDOT_SIGHT_TEX);
            } else {
                renderEngine._a(FlansModResourceHandler.getTexture(attachmentType));
            }
            GL11.glTranslatef((float)(modelGun.scopeAttachPoint.x * gunType.modelScale), (float)(modelGun.scopeAttachPoint.y * gunType.modelScale), (float)(modelGun.scopeAttachPoint.z * gunType.modelScale));
            if (modelGun.scopeIsOnSlide) {
                GL11.glTranslatef((float)(-(gunAnimations.lastGunSlide + (gunAnimations.gunSlide - gunAnimations.lastGunSlide) * smoothing) * modelGun.gunSlideDistance), (float)0.0f, (float)0.0f);
            }
            GL11.glScalef((float)attachmentType.modelScale, (float)attachmentType.modelScale, (float)attachmentType.modelScale);
            ModelAttachment modelAttachment = attachmentType.model;
            if (modelAttachment != null) {
                modelAttachment.renderAttachment(f, 0);
            }
            if (curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
                renderEngine._a(ModelGun.SAW_TEX);
            } else if (curritem != null && RenderGun.curritem._d == 23869) {
                renderEngine._a(ModelGun.NY2020_TEX);
            } else {
                renderEngine._a(FlansModResourceHandler.getTexture(gunType));
            }
            GL11.glPopMatrix();
        }
        if (attachmentType2 != null) {
            GL11.glPushMatrix();
            if (curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
                renderEngine._a(ModelAttachment.US_Silenser_TEX);
            } else {
                renderEngine._a(FlansModResourceHandler.getTexture(attachmentType2));
            }
            GL11.glTranslatef((float)(modelGun.barrelAttachPoint.x * gunType.modelScale), (float)(modelGun.barrelAttachPoint.y * gunType.modelScale), (float)(modelGun.barrelAttachPoint.z * gunType.modelScale));
            GL11.glScalef((float)attachmentType2.modelScale, (float)attachmentType2.modelScale, (float)attachmentType2.modelScale);
            ModelAttachment modelAttachment = attachmentType2.model;
            if (modelAttachment != null) {
                modelAttachment.renderAttachment(f, 1);
            }
            if (curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
                renderEngine._a(ModelGun.SAW_TEX);
            } else if (curritem != null && RenderGun.curritem._d == 23869) {
                renderEngine._a(ModelGun.NY2020_TEX);
            } else {
                renderEngine._a(FlansModResourceHandler.getTexture(gunType));
            }
            GL11.glPopMatrix();
        }
        if (attachmentType3 != null) {
            GL11.glPushMatrix();
            renderEngine._a(FlansModResourceHandler.getTexture(attachmentType3));
            GL11.glTranslatef((float)(modelGun.stockAttachPoint.x * gunType.modelScale), (float)(modelGun.stockAttachPoint.y * gunType.modelScale), (float)(modelGun.stockAttachPoint.z * gunType.modelScale));
            GL11.glScalef((float)attachmentType3.modelScale, (float)attachmentType3.modelScale, (float)attachmentType3.modelScale);
            ModelAttachment modelAttachment = attachmentType3.model;
            if (modelAttachment != null) {
                modelAttachment.renderAttachment(f, -1);
            }
            if (curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
                renderEngine._a(ModelGun.SAW_TEX);
            } else if (curritem != null && RenderGun.curritem._d == 23869) {
                renderEngine._a(ModelGun.NY2020_TEX);
            } else {
                renderEngine._a(FlansModResourceHandler.getTexture(gunType));
            }
            GL11.glPopMatrix();
        }
        if (attachmentType4 != null) {
            GL11.glPushMatrix();
            if (curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
                renderEngine._a(ModelAttachment.Vert_Grip_TEX);
            } else {
                renderEngine._a(FlansModResourceHandler.getTexture(attachmentType4));
            }
            GL11.glTranslatef((float)(modelGun.gripAttachPoint.x * gunType.modelScale), (float)(modelGun.gripAttachPoint.y * gunType.modelScale), (float)(modelGun.gripAttachPoint.z * gunType.modelScale));
            GL11.glScalef((float)attachmentType4.modelScale, (float)attachmentType4.modelScale, (float)attachmentType4.modelScale);
            ModelAttachment modelAttachment = attachmentType4.model;
            if (modelAttachment != null) {
                modelAttachment.renderAttachment(f, 2);
            }
            if (curritem != null && RenderGun.curritem._d == 14102 && HcsClient.fancyGuns) {
                renderEngine._a(ModelGun.SAW_TEX);
            } else if (curritem != null && RenderGun.curritem._d == 23869) {
                renderEngine._a(ModelGun.NY2020_TEX);
            } else {
                renderEngine._a(FlansModResourceHandler.getTexture(gunType));
            }
            GL11.glPopMatrix();
        }
    }

}

