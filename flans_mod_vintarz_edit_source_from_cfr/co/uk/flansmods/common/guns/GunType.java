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
 *  net.minecraft.util.dwbg
 *  tevp
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.client.model.ModelGun;
import co.uk.flansmods.client.model.ModelMG;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.TypeFile;
import co.uk.flansmods.common.guns.AttachmentType;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.EnumFireMode;
import co.uk.flansmods.common.guns.IScope;
import co.uk.flansmods.common.guns.ItemBullet;
import co.uk.flansmods.vintarz.AttachmentTypeMod;
import co.uk.flansmods.vintarz.GunTypeMod;
import cpw.mods.fml.common.uxsf;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.util.dwbg;

public class GunType
extends InfoType
implements IScope {
    public List ammo = new ArrayList();
    public boolean canForceReload = true;
    public int reloadTime;
    public float recoil;
    public float bulletSpread;
    public float damage = 0.0f;
    public float damageFar = 1.0f;
    public float meleeDamage = 1.0f;
    public float bulletSpeed = 5.0f;
    public int numBullets = 1;
    public int shootDelay = 0;
    public int numAmmoItemsInGun = 1;
    public EnumFireMode mode = EnumFireMode.FULLAUTO;
    public boolean canShootUnderwater = true;
    public String shootSound;
    public int shootSoundLength;
    public boolean distortSound = true;
    public String reloadSound;
    public boolean deployable = false;
    @SideOnly(value=Side.CLIENT)
    public ModelMG deployableModel;
    public String deployableTexture;
    public float standBackDist = 1.5f;
    public float topViewLimit = -60.0f;
    public float bottomViewLimit = 30.0f;
    public float sideViewLimit = 45.0f;
    public float pivotHeight = 0.375f;
    public String defaultScopeTexture;
    public boolean hasScopeOverlay = false;
    public float zoomLevel = 1.0f;
    public float FOVFactor = 1.5f;
    @SideOnly(value=Side.CLIENT)
    public ModelGun model;
    public float modelScale = 1.0f;
    public boolean allowAllAttachments = false;
    public ArrayList allowedAttachments = new ArrayList();
    public boolean allowBarrelAttachments = false;
    public boolean allowScopeAttachments = false;
    public boolean allowStockAttachments = false;
    public boolean allowGripAttachments = false;
    public int numGenericAttachmentSlots = 0;
    public float yOffset = 0.0f;
    public static List guns = new ArrayList();

    public GunType(TypeFile typeFile) {
        super(typeFile);
        guns.add(this);
    }

    @Override
    protected void read(String[] arrstring, TypeFile typeFile) {
        super.read(arrstring, typeFile);
        try {
            BulletType bulletType;
            if (arrstring[0].equals("yOffset")) {
                this.yOffset = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Damage")) {
                this.damage = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("DamageFar")) {
                this.damageFar = dwbg._a((float)Float.parseFloat(arrstring[1]), (float)0.0f, (float)1.0f);
            }
            if (arrstring[0].equals("MeleeDamage")) {
                this.meleeDamage = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("CanForceReload")) {
                this.canForceReload = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("ReloadTime")) {
                this.reloadTime = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("Recoil")) {
                this.recoil = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Accuracy") || arrstring[0].equals("Spread")) {
                this.bulletSpread = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("NumBullets")) {
                this.numBullets = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("ShootDelay")) {
                this.shootDelay = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("SoundLength")) {
                this.shootSoundLength = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("DistortSound")) {
                this.distortSound = arrstring[1].equals("True");
            }
            if (arrstring[0].equals("ShootSound")) {
                this.shootSound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "guns", arrstring[1]);
            }
            if (arrstring[0].equals("ReloadSound")) {
                this.reloadSound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "guns", arrstring[1]);
            }
            if (arrstring[0].equals("Mode")) {
                EnumFireMode enumFireMode = this.mode = arrstring[1].equals("FullAuto") ? EnumFireMode.FULLAUTO : EnumFireMode.SEMIAUTO;
            }
            if (arrstring[0].equals("Scope")) {
                this.hasScopeOverlay = true;
                if (arrstring[1].equals("None")) {
                    this.hasScopeOverlay = false;
                } else {
                    this.defaultScopeTexture = arrstring[1];
                }
            }
            if (arrstring[0].equals("ZoomLevel")) {
                this.zoomLevel = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("FOVZoomLevel")) {
                this.FOVFactor = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Deployable")) {
                this.deployable = arrstring[1].equals("True");
            }
            if (uxsf.instance().getSide().isClient() && this.deployable && arrstring[0].equals("DeployedModel")) {
                this.deployableModel = FlansMod.proxy.loadModel(arrstring[1], this.shortName, ModelMG.class);
            }
            if (uxsf.instance().getSide().isClient() && arrstring[0].equals("Model")) {
                this.model = FlansMod.proxy.loadModel(arrstring[1], this.shortName, ModelGun.class);
            }
            if (arrstring[0].equals("ModelScale")) {
                this.modelScale = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Texture")) {
                this.texture = arrstring[1];
            }
            if (arrstring[0].equals("DeployedTexture")) {
                this.deployableTexture = arrstring[1];
            }
            if (arrstring[0].equals("StandBackDistance")) {
                this.standBackDist = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("TopViewLimit")) {
                this.topViewLimit = -Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("BottomViewLimit")) {
                this.bottomViewLimit = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("SideViewLimit")) {
                this.sideViewLimit = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("PivotHeight")) {
                this.pivotHeight = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Ammo") && (bulletType = BulletType.getBullet(arrstring[1])) != null) {
                this.ammo.add(bulletType);
            }
            if (arrstring[0].equals("NumAmmoSlots") || arrstring[0].equals("NumAmmoItemsInGun") || arrstring[0].equals("LoadIntoGun")) {
                this.numAmmoItemsInGun = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("BulletSpeed")) {
                this.bulletSpeed = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("CanShootUnderwater")) {
                this.canShootUnderwater = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("AllowAllAttachments")) {
                this.allowAllAttachments = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("AllowAttachments")) {
                for (int i = 1; i < arrstring.length; ++i) {
                    this.allowedAttachments.add(AttachmentType.getAttachment(arrstring[i]));
                }
            }
            if (arrstring[0].equals("AllowBarrelAttachments")) {
                this.allowBarrelAttachments = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("AllowScopeAttachments")) {
                this.allowScopeAttachments = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("AllowStockAttachments")) {
                this.allowStockAttachments = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("AllowGripAttachments")) {
                this.allowGripAttachments = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("NumGenericAttachmentSlots")) {
                this.numGenericAttachmentSlots = Integer.parseInt(arrstring[1]);
            }
        }
        catch (Exception exception) {
            System.out.println("Reading gun file failed.");
            exception.printStackTrace();
        }
    }

    public boolean isAmmo(BulletType bulletType) {
        return this.ammo.contains(bulletType);
    }

    public boolean isAmmo(ieta ieta2) {
        return ieta2 == null ? false : (ieta2._a() instanceof ItemBullet ? this.isAmmo(((ItemBullet)ieta2._a()).type) : false);
    }

    @Override
    public void reloadModel() {
        this.model = FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelGun.class);
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
        return this.defaultScopeTexture;
    }

    @Override
    public float getFOVFactor() {
        return this.FOVFactor;
    }

    public IScope getCurrentScope(ieta ieta2) {
        AttachmentType attachmentType = this.getScope(ieta2);
        return (IScope)((Object)(attachmentType == null ? this : attachmentType));
    }

    public ArrayList<AttachmentType> getCurrentAttachments(ieta ieta2) {
        this.checkForTags(ieta2);
        ArrayList<AttachmentType> arrayList = new ArrayList<AttachmentType>();
        hsus hsus2 = ieta2._e._m("attachments");
        hsus2._n("generics");
        for (int i = 0; i < this.numGenericAttachmentSlots; ++i) {
            this.appendToList(ieta2, "generic_" + i, arrayList);
        }
        this.appendToList(ieta2, "barrel", arrayList);
        this.appendToList(ieta2, "scope", arrayList);
        this.appendToList(ieta2, "stock", arrayList);
        this.appendToList(ieta2, "grip", arrayList);
        return arrayList;
    }

    private void appendToList(ieta ieta2, String string, ArrayList arrayList) {
        AttachmentType attachmentType = this.getAttachment(ieta2, string);
        if (attachmentType != null) {
            arrayList.add(attachmentType);
        }
    }

    public AttachmentType getBarrel(ieta ieta2) {
        return this.getAttachment(ieta2, "barrel");
    }

    public AttachmentType getScope(ieta ieta2) {
        return this.getAttachment(ieta2, "scope");
    }

    public AttachmentType getStock(ieta ieta2) {
        return this.getAttachment(ieta2, "stock");
    }

    public AttachmentType getGrip(ieta ieta2) {
        return this.getAttachment(ieta2, "grip");
    }

    public AttachmentType getGeneric(ieta ieta2, int n) {
        return this.getAttachment(ieta2, "generic_" + n);
    }

    public ieta getBarrelItemStack(ieta ieta2) {
        return this.getAttachmentItemStack(ieta2, "barrel");
    }

    public ieta getScopeItemStack(ieta ieta2) {
        return this.getAttachmentItemStack(ieta2, "scope");
    }

    public ieta getStockItemStack(ieta ieta2) {
        return this.getAttachmentItemStack(ieta2, "stock");
    }

    public ieta getGripItemStack(ieta ieta2) {
        return this.getAttachmentItemStack(ieta2, "grip");
    }

    public ieta getGenericItemStack(ieta ieta2, int n) {
        return this.getAttachmentItemStack(ieta2, "generic_" + n);
    }

    public AttachmentType getAttachment(ieta ieta2, String string) {
        this.checkForTags(ieta2);
        return AttachmentType.getFromNBT(ieta2._e._m("attachments")._m(string));
    }

    public ieta getAttachmentItemStack(ieta ieta2, String string) {
        this.checkForTags(ieta2);
        return ieta._a((hsus)ieta2._e._m("attachments")._m(string));
    }

    private void checkForTags(ieta ieta2) {
        if (!ieta2._p()) {
            ieta2._e = new hsus("tag");
        }
        if (!ieta2._e._c("attachments")) {
            hsus hsus2 = new hsus("attachments");
            for (int i = 0; i < this.numGenericAttachmentSlots; ++i) {
                hsus2._a("generic_" + i, new hsus());
            }
            hsus2._a("barrel", new hsus());
            hsus2._a("scope", new hsus());
            hsus2._a("stock", new hsus());
            hsus2._a("grip", new hsus());
            ieta2._e._a("attachments", hsus2);
        }
    }

    public float getMeleeDamage(ieta ieta2) {
        float f = this.meleeDamage;
        for (AttachmentType attachmentType : this.getCurrentAttachments(ieta2)) {
            f *= attachmentType.meleeDamageMultiplier;
        }
        return f;
    }

    public float getDamage(ieta ieta2) {
        return this.getDamage(ieta2, null, null);
    }

    public float getDamage(ieta ieta2, GunTypeMod gunTypeMod, FlansModPlayerData flansModPlayerData) {
        float f = gunTypeMod != null ? gunTypeMod.damage : this.damage;
        for (AttachmentType attachmentType : this.getCurrentAttachments(ieta2)) {
            AttachmentTypeMod attachmentTypeMod = flansModPlayerData == null ? null : (flansModPlayerData.overrideAttachments == null ? null : flansModPlayerData.overrideAttachments.get(attachmentType));
            f *= attachmentTypeMod != null ? attachmentTypeMod.damageMultiplier : attachmentType.damageMultiplier;
        }
        return f;
    }

    public float getDamage(ieta ieta2, GunTypeMod gunTypeMod, FlansModPlayerData flansModPlayerData, float f) {
        f = dwbg._a((float)f, (float)0.0f, (float)1.0f);
        float f2 = this.getDamage(ieta2, gunTypeMod, flansModPlayerData);
        float f3 = f2 * (gunTypeMod != null ? gunTypeMod.damageFar : this.damageFar);
        return f2 * (1.0f - f) + f3 * f;
    }

    public GunTypeMod getMod(FlansModPlayerData flansModPlayerData) {
        if (flansModPlayerData != null && flansModPlayerData.overrideGuns != null) {
            return flansModPlayerData.overrideGuns.get(this);
        }
        return null;
    }

    public float getSpread(ieta ieta2, GunTypeMod gunTypeMod, FlansModPlayerData flansModPlayerData) {
        float f = gunTypeMod != null ? gunTypeMod.bulletSpread : this.bulletSpread;
        for (AttachmentType attachmentType : this.getCurrentAttachments(ieta2)) {
            AttachmentTypeMod attachmentTypeMod;
            AttachmentTypeMod attachmentTypeMod2 = attachmentTypeMod = flansModPlayerData.overrideAttachments == null ? null : flansModPlayerData.overrideAttachments.get(attachmentType);
            if (attachmentType.bipod && !flansModPlayerData.bipod) continue;
            f *= attachmentTypeMod != null ? attachmentTypeMod.spreadMultiplier : attachmentType.spreadMultiplier;
        }
        return f;
    }

    public float getRecoil(ieta ieta2, GunTypeMod gunTypeMod, FlansModPlayerData flansModPlayerData) {
        float f = gunTypeMod != null ? gunTypeMod.recoil : this.recoil;
        for (AttachmentType attachmentType : this.getCurrentAttachments(ieta2)) {
            AttachmentTypeMod attachmentTypeMod;
            AttachmentTypeMod attachmentTypeMod2 = attachmentTypeMod = flansModPlayerData.overrideAttachments == null ? null : flansModPlayerData.overrideAttachments.get(attachmentType);
            if (attachmentType.bipod && !flansModPlayerData.bipod) continue;
            f *= attachmentTypeMod != null ? attachmentTypeMod.recoilMultiplier : attachmentType.recoilMultiplier;
        }
        return f;
    }

    public float getBulletSpeed(ieta ieta2, GunTypeMod gunTypeMod, FlansModPlayerData flansModPlayerData) {
        float f = gunTypeMod != null ? gunTypeMod.bulletSpeed : this.bulletSpeed;
        for (AttachmentType attachmentType : this.getCurrentAttachments(ieta2)) {
            AttachmentTypeMod attachmentTypeMod;
            AttachmentTypeMod attachmentTypeMod2 = attachmentTypeMod = flansModPlayerData.overrideAttachments == null ? null : flansModPlayerData.overrideAttachments.get(attachmentType);
            if (attachmentType.bipod && !flansModPlayerData.bipod) continue;
            f *= attachmentTypeMod != null ? attachmentTypeMod.bulletSpeedMultiplier : attachmentType.bulletSpeedMultiplier;
        }
        return f;
    }

    public float getReloadTime(ieta ieta2) {
        float f = this.reloadTime;
        for (AttachmentType attachmentType : this.getCurrentAttachments(ieta2)) {
            f *= attachmentType.reloadTimeMultiplier;
        }
        return f;
    }

    public static GunType getGun(String string) {
        GunType gunType;
        Iterator iterator = guns.iterator();
        do {
            if (!iterator.hasNext()) {
                return null;
            }
            gunType = (GunType)iterator.next();
        } while (!gunType.shortName.equals(string));
        return gunType;
    }
}

