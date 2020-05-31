/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.uxsf
 *  cpw.mods.fml.relauncher.Side
 *  ieta
 *  jhvs
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.client.model.ModelAAGun;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.TypeFile;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.ItemBullet;
import cpw.mods.fml.common.uxsf;
import cpw.mods.fml.relauncher.Side;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AAGunType
extends InfoType {
    public List ammo = new ArrayList();
    public int reloadTime;
    public int recoil = 5;
    public int accuracy;
    public int damage;
    public int shootDelay;
    public int numBarrels;
    public boolean fireAlternately;
    public int health;
    public int gunnerX;
    public int gunnerY;
    public int gunnerZ;
    public String shootSound;
    public String reloadSound;
    public ModelAAGun model;
    public float topViewLimit = 75.0f;
    public float bottomViewLimit = 0.0f;
    public int[] barrelX;
    public int[] barrelY;
    public int[] barrelZ;
    public static List infoTypes = new ArrayList();

    public AAGunType(TypeFile typeFile) {
        super(typeFile);
        infoTypes.add(this);
    }

    @Override
    protected void read(String[] arrstring, TypeFile typeFile) {
        super.read(arrstring, typeFile);
        try {
            BulletType bulletType;
            if (uxsf.instance().getSide().isClient() && arrstring[0].equals("Model")) {
                this.model = FlansMod.proxy.loadModel(arrstring[1], this.shortName, ModelAAGun.class);
            }
            if (arrstring[0].equals("Texture")) {
                this.texture = arrstring[1];
            }
            if (arrstring[0].equals("Damage")) {
                this.damage = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("ReloadTime")) {
                this.reloadTime = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("Recoil")) {
                this.recoil = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("Accuracy")) {
                this.accuracy = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("ShootDelay")) {
                this.shootDelay = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("ShootSound")) {
                this.shootSound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "aaguns", arrstring[1]);
            }
            if (arrstring[0].equals("ReloadSound")) {
                this.reloadSound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "aaguns", arrstring[1]);
            }
            if (arrstring[0].equals("FireAlternately")) {
                this.fireAlternately = arrstring[1].equals("True");
            }
            if (arrstring[0].equals("NumBarrels")) {
                this.numBarrels = Integer.parseInt(arrstring[1]);
                this.barrelX = new int[this.numBarrels];
                this.barrelY = new int[this.numBarrels];
                this.barrelZ = new int[this.numBarrels];
            }
            if (arrstring[0].equals("Barrel")) {
                int n = Integer.parseInt(arrstring[1]);
                this.barrelX[n] = Integer.parseInt(arrstring[2]);
                this.barrelY[n] = Integer.parseInt(arrstring[3]);
                this.barrelZ[n] = Integer.parseInt(arrstring[4]);
            }
            if (arrstring[0].equals("Health")) {
                this.health = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("TopViewLimit")) {
                this.topViewLimit = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("BottomViewLimit")) {
                this.bottomViewLimit = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Ammo") && (bulletType = BulletType.getBullet(arrstring[1])) != null) {
                this.ammo.add(bulletType);
            }
            if (arrstring[0].equals("GunnerPos")) {
                this.gunnerX = Integer.parseInt(arrstring[1]);
                this.gunnerY = Integer.parseInt(arrstring[2]);
                this.gunnerZ = Integer.parseInt(arrstring[3]);
            }
        }
        catch (Exception exception) {
            FlansMod.log("" + exception);
        }
    }

    public boolean isAmmo(BulletType bulletType) {
        return this.ammo.contains(bulletType);
    }

    public boolean isAmmo(ieta ieta2) {
        return ieta2 == null ? false : (ieta2._a() instanceof ItemBullet ? this.isAmmo(((ItemBullet)ieta2._a()).type) : false);
    }

    public static AAGunType getAAGun(String string) {
        AAGunType aAGunType;
        Iterator iterator = infoTypes.iterator();
        do {
            if (!iterator.hasNext()) {
                return null;
            }
            aAGunType = (AAGunType)iterator.next();
        } while (!aAGunType.shortName.equals(string));
        return aAGunType;
    }

    @Override
    public void reloadModel() {
        this.model = FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelAAGun.class);
    }
}

