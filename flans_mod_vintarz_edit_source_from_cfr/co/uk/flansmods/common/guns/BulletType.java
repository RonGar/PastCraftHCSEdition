/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.TypeFile;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.model.ModelBase;

public class BulletType
extends InfoType {
    public Object model;
    public float fallSpeed = 1.0f;
    public float damageVsLiving = 1.0f;
    public float damageVsDriveable = 1.0f;
    public int explosion = 0;
    public boolean explodeOnImpact = false;
    public int fuse = 0;
    public int flak = 0;
    public int fire = 0;
    public String dropItemOnReload = null;
    public String dropItemOnShoot = null;
    public String dropItemOnHit = null;
    public boolean breaksGlass = false;
    public boolean penetratesEntities = false;
    public boolean penetratesBlocks = false;
    public String trailParticles = "smoke";
    public String flakParticles = "largesmoke";
    public boolean smokeTrail = false;
    public boolean isBomb = false;
    public boolean isShell = false;
    public float hitBoxSize = 0.5f;
    public String hitSound;
    public int roundsPerItem = 1;
    public int maxStackSize = 1;
    public static List bullets = new ArrayList();
    public boolean hasLight = false;
    public float slowdown = 0.0f;

    public BulletType(TypeFile typeFile) {
        super(typeFile);
        this.texture = "defaultBullet";
        bullets.add(this);
    }

    @Override
    protected void read(String[] arrstring, TypeFile typeFile) {
        super.read(arrstring, typeFile);
        try {
            if (arrstring[0].equals("Model")) {
                this.model = FlansMod.proxy.loadModel(arrstring[1], this.shortName, ModelBase.class);
            }
            if (arrstring[0].equals("Texture")) {
                this.texture = arrstring[1];
            }
            if (arrstring[0].equals("FallSpeed")) {
                this.fallSpeed = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Slowdown")) {
                this.slowdown = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(arrstring[1])));
            }
            if (arrstring[0].equals("Damage") || arrstring[0].equals("DamageVsLiving") || arrstring[0].equals("DamageVsPlayer")) {
                this.damageVsLiving = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("DamageVsVehicles")) {
                this.damageVsDriveable = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Explosion")) {
                this.explosion = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("FlakParticles")) {
                this.flak = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("Fire")) {
                this.fire = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("ExpodeOnImpact")) {
                this.explodeOnImpact = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("Fuse")) {
                this.fuse = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("BreaksGlass")) {
                this.breaksGlass = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("HitBoxSize")) {
                this.hitBoxSize = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("HitSound")) {
                this.hitSound = arrstring[1];
            }
            if (arrstring[0].equals("Penetrates")) {
                this.penetratesEntities = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("SmokeTrail")) {
                this.smokeTrail = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("RoundsPerItem")) {
                this.roundsPerItem = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("MaxStackSize")) {
                this.maxStackSize = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("Bomb")) {
                this.isBomb = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("Shell")) {
                this.isShell = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("DropItemOnShoot")) {
                this.dropItemOnShoot = arrstring[1];
            }
            if (arrstring[0].equals("DropItemOnReload")) {
                this.dropItemOnReload = arrstring[1];
            }
            if (arrstring[0].equals("DropItemOnHit")) {
                this.dropItemOnHit = arrstring[1];
            }
            if (arrstring[0].equals("HasLight")) {
                this.hasLight = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
        }
        catch (Exception exception) {
            System.out.println("Reading bullet file failed.");
            exception.printStackTrace();
        }
    }

    public static BulletType getBullet(String string) {
        BulletType bulletType;
        Iterator iterator = bullets.iterator();
        do {
            if (!iterator.hasNext()) {
                return null;
            }
            bulletType = (BulletType)iterator.next();
        } while (!bulletType.shortName.equals(string));
        return bulletType;
    }

    public static BulletType getBullet(int n) {
        BulletType bulletType;
        Iterator iterator = bullets.iterator();
        do {
            if (!iterator.hasNext()) {
                return null;
            }
            bulletType = (BulletType)iterator.next();
        } while (bulletType.itemID != n);
        return bulletType;
    }

    @Override
    public void reloadModel() {
        this.model = FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelBase.class);
    }
}

