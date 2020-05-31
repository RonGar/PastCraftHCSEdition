/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.uxsf
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.TypeFile;
import cpw.mods.fml.common.uxsf;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.model.ModelBase;

public class GrenadeType
extends InfoType {
    public static ArrayList grenades = new ArrayList();
    public int meleeDamage = 1;
    public int maxStackSize = 1;
    public int despawnTime = 0;
    public int throwDelay = 0;
    public String throwSound = "";
    public String dropItemOnThrow = null;
    public boolean detonateOnImpact = false;
    public float bounciness = 0.9f;
    public int hitEntityDamage = 0;
    public float throwSpeed = 1.0f;
    public float fallSpeed = 1.0f;
    public boolean breaksGlass = false;
    public boolean penetratesEntities = false;
    public boolean penetratesBlocks = false;
    public float hitBoxSize = 0.5f;
    public String bounceSound = "";
    public boolean sticky = false;
    public float livingProximityTrigger = -1.0f;
    public float driveableProximityTrigger = -1.0f;
    public int fuse = 0;
    public boolean detonateWhenShot = false;
    public boolean remote = false;
    public float fireRadius = 0.0f;
    public float explosionRadius = 0.0f;
    public boolean explosionBreaksBlocks = false;
    public float explosionDamageVsLiving = 0.0f;
    public float explosionDamageVsDriveable = 0.0f;
    public String dropItemOnDetonate = null;
    public String detonateSound = "";
    public int primeDelay = 0;
    @SideOnly(value=Side.CLIENT)
    public ModelBase model;
    public boolean trailParticles = false;
    public String trailParticleType = "smoke";
    public int explodeParticles = 0;
    public String explodeParticleType = "largesmoke";
    public int smokeTime = 0;
    public String smokeParticleType = "explode";
    public boolean spinWhenThrown = true;

    public GrenadeType(TypeFile typeFile) {
        super(typeFile);
        grenades.add(this);
    }

    @Override
    protected void read(String[] arrstring, TypeFile typeFile) {
        super.read(arrstring, typeFile);
        try {
            if (uxsf.instance().getSide().isClient() && arrstring[0].equals("Model")) {
                this.model = FlansMod.proxy.loadModel(arrstring[1], this.shortName, ModelBase.class);
            }
            if (arrstring[0].equals("Texture")) {
                this.texture = arrstring[1];
            }
            if (arrstring[0].equals("MeleeDamage")) {
                this.meleeDamage = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("StackSize")) {
                this.maxStackSize = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("ThrowDelay")) {
                this.throwDelay = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("ThrowSound")) {
                this.throwSound = arrstring[1];
            }
            if (arrstring[0].equals("DropItemOnThrow")) {
                this.dropItemOnThrow = arrstring[1];
            }
            if (arrstring[0].equals("DetonateOnImpact")) {
                this.detonateOnImpact = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("Bounciness")) {
                this.bounciness = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("HitEntityDamage")) {
                this.hitEntityDamage = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("ThrowSpeed")) {
                this.throwSpeed = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("FallSpeed")) {
                this.fallSpeed = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("BreaksGlass")) {
                this.breaksGlass = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("PenetratesEntities")) {
                this.penetratesEntities = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("PenetratesBlocks")) {
                this.penetratesBlocks = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("HitBoxSize")) {
                this.hitBoxSize = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("BounceSound")) {
                this.bounceSound = arrstring[1];
            }
            if (arrstring[0].equals("Sticky")) {
                this.sticky = Boolean.parseBoolean(arrstring[1]);
            }
            if (arrstring[0].equals("LivingProximityTrigger")) {
                this.livingProximityTrigger = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("VehicleProximityTrigger")) {
                this.driveableProximityTrigger = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Fuse")) {
                this.fuse = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("DetonateWhenShot")) {
                this.detonateWhenShot = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("PrimeDelay") || arrstring[0].equals("TriggerDelay")) {
                this.primeDelay = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("FireRadius")) {
                this.fireRadius = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("ExplosionRadius")) {
                this.explosionRadius = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("ExplosionDamageVsLiving")) {
                this.explosionDamageVsLiving = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("ExplosionDamageVsDrivable")) {
                this.explosionDamageVsDriveable = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("ExplosionBreaksBlocks")) {
                this.explosionBreaksBlocks = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("DropItemOnDetonate")) {
                this.dropItemOnDetonate = arrstring[1];
            }
            if (arrstring[0].equals("DetonateSound")) {
                this.detonateSound = arrstring[1];
            }
            if (arrstring[0].equals("HasTrailParticles")) {
                this.trailParticles = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("TrailParticles")) {
                this.trailParticleType = arrstring[1];
            }
            if (arrstring[0].equals("NumExplodeParticles")) {
                this.explodeParticles = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("ExplodeParticles")) {
                this.explodeParticleType = arrstring[1];
            }
            if (arrstring[0].equals("SmokeTime")) {
                this.smokeTime = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("SmokeParticles")) {
                this.smokeParticleType = arrstring[1];
            }
            if (arrstring[0].equals("SpinWhenThrown")) {
                this.spinWhenThrown = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("Remote")) {
                this.remote = Boolean.parseBoolean(arrstring[1].toLowerCase());
            }
            if (arrstring[0].equals("DespawnTime")) {
                this.despawnTime = Integer.parseInt(arrstring[1]);
            }
        }
        catch (Exception exception) {
            System.out.println("Reading grenade file failed.");
            exception.printStackTrace();
        }
    }

    public static GrenadeType getGrenade(String string) {
        GrenadeType grenadeType;
        Iterator iterator = grenades.iterator();
        do {
            if (!iterator.hasNext()) {
                return null;
            }
            grenadeType = (GrenadeType)iterator.next();
        } while (!grenadeType.shortName.equals(string));
        return grenadeType;
    }

    @Override
    public void reloadModel() {
        this.model = FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelBase.class);
    }
}

