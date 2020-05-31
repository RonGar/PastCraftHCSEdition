/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.uxsf
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  hsus
 *  ieta
 *  jhvs
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.client.model.ModelAttachment;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.TypeFile;
import co.uk.flansmods.common.guns.EnumAttachmentType;
import co.uk.flansmods.common.guns.IScope;
import co.uk.flansmods.common.guns.ItemAttachment;
import cpw.mods.fml.common.uxsf;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class AttachmentType
extends InfoType
implements IScope {
    public static ArrayList attachments = new ArrayList();
    public EnumAttachmentType type = EnumAttachmentType.generic;
    public boolean silencer = false;
    public float spreadMultiplier = 1.0f;
    public float recoilMultiplier = 1.0f;
    public float damageMultiplier = 1.0f;
    public float meleeDamageMultiplier = 1.0f;
    public float bulletSpeedMultiplier = 1.0f;
    public float reloadTimeMultiplier = 1.0f;
    public float zoomLevel = 1.0f;
    public float FOVZoomLevel = 1.0f;
    public String zoomOverlay;
    public boolean hasScopeOverlay = false;
    @SideOnly(value=Side.CLIENT)
    public ModelAttachment model;
    public float modelScale = 1.0f;
    public int maxStackSize = 1;
    public boolean bipod;
    public float yOffset = 0.0f;

    public AttachmentType(TypeFile typeFile) {
        super(typeFile);
        attachments.add(this);
    }

    @Override
    protected void read(String[] arrstring, TypeFile typeFile) {
        super.read(arrstring, typeFile);
        try {
            if (arrstring[0].equals("yOffset")) {
                this.yOffset = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("AttachmentType")) {
                this.type = EnumAttachmentType.get(arrstring[1]);
            }
            if (uxsf.instance().getSide().isClient() && arrstring[0].equals("Model")) {
                this.model = FlansMod.proxy.loadModel(arrstring[1], this.shortName, ModelAttachment.class);
            }
            if (arrstring[0].equals("ModelScale")) {
                this.modelScale = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Texture")) {
                this.texture = arrstring[1];
            }
            if (arrstring[0].equals("Silencer")) {
                this.silencer = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("MeleeDamageMultiplier")) {
                this.meleeDamageMultiplier = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("DamageMultiplier")) {
                this.damageMultiplier = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("SpreadMultiplier")) {
                this.spreadMultiplier = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("RecoilMultiplier")) {
                this.recoilMultiplier = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("BulletSpeedMultiplier")) {
                this.bulletSpeedMultiplier = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("ReloadTimeMultiplier")) {
                this.reloadTimeMultiplier = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("ZoomLevel")) {
                this.zoomLevel = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("FOVZoomLevel")) {
                this.FOVZoomLevel = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("ZoomOverlay")) {
                this.hasScopeOverlay = true;
                if (arrstring[1].equals("None")) {
                    this.hasScopeOverlay = false;
                } else {
                    this.zoomOverlay = arrstring[1];
                }
            }
            if (arrstring[0].equals("Bipod")) {
                this.bipod = Boolean.parseBoolean(arrstring[1]);
            }
        }
        catch (Exception exception) {
            System.out.println("Reading attachment file failed.");
            exception.printStackTrace();
        }
    }

    @Override
    public void reloadModel() {
        this.model = FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelAttachment.class);
    }

    public static AttachmentType getFromNBT(hsus hsus2) {
        ieta ieta2 = ieta._a((hsus)hsus2);
        return ieta2 != null && ieta2._a() instanceof ItemAttachment ? ((ItemAttachment)ieta2._a()).type : null;
    }

    @Override
    public float getZoomFactor() {
        return this.zoomLevel;
    }

    @Override
    public boolean hasZoomOverlay() {
        return this.hasScopeOverlay;
    }

    @Override
    public String getZoomOverlay() {
        return this.zoomOverlay;
    }

    @Override
    public float getFOVFactor() {
        return this.FOVZoomLevel;
    }

    public static AttachmentType getAttachment(String string) {
        AttachmentType attachmentType;
        Iterator iterator = attachments.iterator();
        do {
            if (!iterator.hasNext()) {
                return null;
            }
            attachmentType = (AttachmentType)iterator.next();
        } while (!attachmentType.shortName.equals(string));
        return attachmentType;
    }
}

