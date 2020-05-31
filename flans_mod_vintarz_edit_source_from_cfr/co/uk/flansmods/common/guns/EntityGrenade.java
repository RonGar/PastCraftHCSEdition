/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.io.ByteArrayDataInput
 *  com.google.common.io.ByteArrayDataOutput
 *  cpw.mods.fml.common.registry.IEntityAdditionalSpawnData
 *  cuqu
 *  hsus
 *  ieta
 *  ifck
 *  kjsv
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.util.dfat
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.pico
 *  net.minecraft.util.rojd
 *  net.minecraft.util.samw
 *  net.minecraft.util.uxrp
 *  srni
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.RotatedAxes;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.guns.EntityDamageSourceGun;
import co.uk.flansmods.common.guns.FlansModExplosion;
import co.uk.flansmods.common.guns.GrenadeType;
import co.uk.flansmods.common.teams.Gametype;
import co.uk.flansmods.common.teams.TeamsManager;
import co.uk.flansmods.common.vector.Vector;
import co.uk.flansmods.common.vector.Vector3f;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.dfat;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.pico;
import net.minecraft.util.rojd;
import net.minecraft.util.samw;
import net.minecraft.util.uxrp;

public class EntityGrenade
extends Entity
implements IEntityAdditionalSpawnData {
    public GrenadeType type;
    public EntityLivingBase thrower;
    public RotatedAxes axes = new RotatedAxes();
    public Vector3f angularVelocity = new Vector3f(0.0f, 0.0f, 0.0f);
    public float prevRotationRoll = 0.0f;
    public int smokeTime = 0;
    public boolean smoking = false;
    public boolean stuck = false;
    public int stuckToX;
    public int stuckToY;
    public int stuckToZ;
    public boolean detonated = false;

    public EntityGrenade(cuqu cuqu2) {
        super(cuqu2);
    }

    public EntityGrenade(cuqu cuqu2, GrenadeType grenadeType, EntityLivingBase entityLivingBase) {
        this(cuqu2);
        this.func_70107_b(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + (double)entityLivingBase.func_70047_e(), entityLivingBase.field_70161_v);
        this.type = grenadeType;
        this.thrower = entityLivingBase;
        this.func_70105_a(grenadeType.hitBoxSize, grenadeType.hitBoxSize);
        this.axes.setAngles(entityLivingBase.field_70177_z + 90.0f, grenadeType.spinWhenThrown ? entityLivingBase.field_70125_A : 0.0f, 0.0f);
        this.field_70126_B = grenadeType.spinWhenThrown ? entityLivingBase.field_70177_z + 90.0f : 0.0f;
        this.field_70177_z = this.field_70126_B;
        this.field_70125_A = this.field_70127_C = entityLivingBase.field_70125_A;
        float f = 0.5f * this.type.throwSpeed;
        this.field_70159_w = this.axes.getXAxis().x * f;
        this.field_70181_x = this.axes.getXAxis().y * f;
        this.field_70179_y = this.axes.getXAxis().z * f;
        this.field_70159_w += entityLivingBase.field_70159_w;
        this.field_70181_x += entityLivingBase.field_70181_x;
        this.field_70179_y += entityLivingBase.field_70179_y;
        if (this.type.spinWhenThrown) {
            this.angularVelocity = new Vector3f(0.0f, 0.0f, 10.0f);
        }
    }

    public boolean func_70067_L() {
        return true;
    }

    public void func_70071_h_() {
        if (this.field_70170_p.field_72995_K && this.field_70170_p.func_72938_d(dwbg._c((double)this.field_70165_t), dwbg._c((double)this.field_70161_v)) instanceof ifck) {
            return;
        }
        super.func_70071_h_();
        if (this.type.despawnTime > 0 && this.field_70173_aa > this.type.despawnTime) {
            this.detonated = true;
            this.func_70106_y();
        } else {
            if (this.field_70170_p.field_72995_K) {
                if (this.type.trailParticles) {
                    this.field_70170_p.func_72869_a(this.type.trailParticleType, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0);
                }
                if (!this.smoking) {
                    for (int i = 0; i < 20; ++i) {
                        this.field_70170_p.func_72869_a(this.type.trailParticleType, this.field_70165_t + this.field_70146_Z.nextGaussian(), this.field_70163_u + this.field_70146_Z.nextGaussian(), this.field_70161_v + this.field_70146_Z.nextGaussian(), 0.0, 0.0, 0.0);
                    }
                    --this.smokeTime;
                    if (this.smokeTime == 0) {
                        this.func_70106_y();
                    }
                }
            }
            if (!this.field_70170_p.field_72995_K) {
                if (this.field_70173_aa > this.type.fuse && this.type.fuse > 0) {
                    this.detonate();
                }
                if (this.type.livingProximityTrigger > 0.0f || this.type.driveableProximityTrigger > 0.0f) {
                    float f = Math.max(this.type.livingProximityTrigger, this.type.driveableProximityTrigger);
                    List list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b((double)f, (double)f, (double)f));
                    for (Object e : list) {
                        if (e == this.thrower && this.field_70173_aa < 10) continue;
                        if (e instanceof EntityLivingBase && this.func_70032_d((Entity)e) < this.type.livingProximityTrigger) {
                            if (TeamsManager.getInstance() != null && TeamsManager.getInstance().currentGametype != null && e instanceof EntityPlayerMP && this.thrower instanceof EntityPlayer && !TeamsManager.getInstance().currentGametype.playerAttacked((EntityPlayerMP)e, (pico)new EntityDamageSourceGun(this.type.shortName, this, (EntityPlayer)this.thrower, this.type))) continue;
                            this.detonate();
                            break;
                        }
                        if (!(e instanceof EntityDriveable) || !(this.func_70032_d((Entity)e) < this.type.driveableProximityTrigger)) continue;
                        this.detonate();
                        break;
                    }
                }
            }
            if (this.stuck && this.field_70170_p.func_72799_c(this.stuckToX, this.stuckToY, this.stuckToZ)) {
                this.stuck = false;
            }
            if (!this.stuck) {
                this.field_70126_B = this.axes.getYaw();
                this.field_70127_C = this.axes.getPitch();
                this.prevRotationRoll = this.axes.getRoll();
                if (this.angularVelocity.lengthSquared() > 1.0E-8f) {
                    this.axes.rotateLocal(this.angularVelocity.length(), this.angularVelocity.normalise(null));
                }
                Vector3f vector3f = new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                Vector3f vector3f2 = new Vector3f(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                Vector3f vector3f3 = Vector3f.add(vector3f, vector3f2, null);
                idqh idqh2 = FlansModExplosion.rayTraceBlocks(this.field_70170_p, vector3f.toVec3(), vector3f3.toVec3(), (Object)this);
                if (idqh2 != null && idqh2._a == dfat._a) {
                    if (this.type.detonateOnImpact) {
                        this.detonate();
                    } else if (!this.type.penetratesBlocks) {
                        Vector3f vector3f4 = new Vector3f(idqh2._f);
                        Vector3f vector3f5 = Vector3f.sub(vector3f4, vector3f, null);
                        Vector3f vector3f6 = Vector3f.sub(vector3f2, vector3f5, null);
                        int n = idqh2._e;
                        switch (n) {
                            case 0: 
                            case 1: {
                                vector3f6.setY(-vector3f6.getY());
                                break;
                            }
                            case 2: 
                            case 3: {
                                vector3f6.setZ(-vector3f6.getZ());
                                break;
                            }
                            case 4: 
                            case 5: {
                                vector3f6.setX(-vector3f6.getX());
                            }
                        }
                        float f = Math.abs(vector3f2.lengthSquared()) < 1.0E-8f ? 1.0f : vector3f6.length() / vector3f2.length();
                        vector3f6.scale(this.type.bounciness / 2.0f);
                        switch (n) {
                            case 0: 
                            case 1: {
                                vector3f6.setY(dwbg._a((float)vector3f6.getY(), (float)-0.1f, (float)0.1f));
                                break;
                            }
                            case 2: 
                            case 3: {
                                vector3f6.setZ(dwbg._a((float)vector3f6.getZ(), (float)-0.1f, (float)0.1f));
                                break;
                            }
                            case 4: 
                            case 5: {
                                vector3f6.setX(dwbg._a((float)vector3f6.getX(), (float)-0.1f, (float)0.1f));
                            }
                        }
                        this.field_70165_t += (double)(vector3f5.x + vector3f6.x);
                        this.field_70163_u += (double)(vector3f5.y + vector3f6.y);
                        this.field_70161_v += (double)(vector3f5.z + vector3f6.z);
                        this.field_70159_w = vector3f6.x / f;
                        this.field_70181_x = vector3f6.y / f;
                        this.field_70179_y = vector3f6.z / f;
                        vector3f2 = new Vector3f(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                        Vector3f.add(this.angularVelocity, new Vector3f(this.field_70146_Z.nextGaussian() * 90.0, this.field_70146_Z.nextGaussian() * 90.0, this.field_70146_Z.nextGaussian() * 90.0), this.angularVelocity);
                        this.angularVelocity.scale(vector3f2.lengthSquared());
                        if ((double)vector3f2.lengthSquared() > 0.01) {
                            this.func_85030_a(this.type.bounceSound, 1.0f, 1.2f / (this.field_70146_Z.nextFloat() * 0.2f + 0.9f));
                        }
                        if (this.type.sticky) {
                            this.field_70165_t = vector3f4.x;
                            this.field_70163_u = vector3f4.y;
                            this.field_70161_v = vector3f4.z;
                            this.field_70179_y = 0.0;
                            this.field_70181_x = 0.0;
                            this.field_70159_w = 0.0;
                            this.angularVelocity.set(0.0f, 0.0f, 0.0f);
                            float f2 = this.axes.getYaw();
                            switch (idqh2._e) {
                                case 0: {
                                    this.axes.setAngles(f2, 180.0f, 0.0f);
                                    break;
                                }
                                case 1: {
                                    this.axes.setAngles(f2, 0.0f, 0.0f);
                                    break;
                                }
                                case 2: {
                                    this.axes.setAngles(270.0f, 90.0f, 0.0f);
                                    this.axes.rotateLocalYaw(f2);
                                    break;
                                }
                                case 3: {
                                    this.axes.setAngles(90.0f, 90.0f, 0.0f);
                                    this.axes.rotateLocalYaw(f2);
                                    break;
                                }
                                case 4: {
                                    this.axes.setAngles(180.0f, 90.0f, 0.0f);
                                    this.axes.rotateLocalYaw(f2);
                                    break;
                                }
                                case 5: {
                                    this.axes.setAngles(0.0f, 90.0f, 0.0f);
                                    this.axes.rotateLocalYaw(f2);
                                }
                            }
                            this.stuck = true;
                            this.stuckToX = idqh2._b;
                            this.stuckToY = idqh2._c;
                            this.stuckToZ = idqh2._d;
                        }
                    }
                } else {
                    this.field_70165_t += this.field_70159_w;
                    this.field_70163_u += this.field_70181_x;
                    this.field_70161_v += this.field_70179_y;
                }
                this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            }
            this.field_70181_x -= 0.024525 * (double)this.type.fallSpeed;
        }
    }

    public boolean func_70097_a(pico pico2, float f) {
        if (this.type.detonateWhenShot) {
            this.detonate();
        }
        return this.type.detonateWhenShot;
    }

    public void detonate() {
        if (this.field_70173_aa >= this.type.primeDelay && !this.detonated) {
            this.detonated = true;
            this.func_85030_a(this.type.detonateSound, 1.0f, 1.2f / (this.field_70146_Z.nextFloat() * 0.2f + 0.9f));
            if (!this.field_70170_p.field_72995_K && this.type.explosionRadius > 0.1f) {
                if (this.thrower instanceof EntityPlayer && !"VinTarZ".equals(((EntityPlayer)this.thrower).func_70005_c_())) {
                    new co.uk.flansmods.common.guns.FlansModExplosion(this.field_70170_p, this, (EntityPlayer)this.thrower, this.type, this.field_70165_t, this.field_70163_u + 0.0625, this.field_70161_v, this.type.explosionRadius);
                } else {
                    new co.uk.flansmods.common.guns.FlansModExplosion(this.field_70170_p, this, null, this.type, this.field_70165_t, this.field_70163_u + 0.0625, this.field_70161_v, this.type.explosionRadius);
                }
            }
            if (this.type.fireRadius > 0.1f) {
                for (float f = -this.type.fireRadius; f < this.type.fireRadius; f += 1.0f) {
                    for (float f2 = -this.type.fireRadius; f2 < this.type.fireRadius; f2 += 1.0f) {
                        for (float f3 = -this.type.fireRadius; f3 < this.type.fireRadius; f3 += 1.0f) {
                            int n;
                            int n2;
                            int n3 = dwbg._d((float)f);
                            if (this.field_70170_p.func_72798_a(n3, n2 = dwbg._d((float)f2), n = dwbg._d((float)f3)) != 0) continue;
                            this.field_70170_p.func_94575_c(n3, n2, n, kjsv.field_72067_ar.field_71990_ca);
                        }
                    }
                }
            }
            for (int i = 0; i < this.type.explodeParticles; ++i) {
                this.field_70170_p.func_72869_a(this.type.explodeParticleType, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian(), this.field_70146_Z.nextGaussian(), this.field_70146_Z.nextGaussian());
            }
            if (!this.field_70170_p.field_72995_K && this.type.dropItemOnDetonate != null) {
                String string = this.type.dropItemOnDetonate;
                int n = 0;
                if (string.contains(".")) {
                    n = Integer.parseInt(string.split("\\.")[1]);
                    string = string.split("\\.")[0];
                }
                ieta ieta2 = InfoType.getRecipeElement(string, n);
                this.func_70099_a(ieta2, 1.0f);
            }
            if (this.type.smokeTime > 0) {
                this.smoking = true;
                this.smokeTime = this.type.smokeTime;
            } else {
                this.func_70106_y();
            }
        }
    }

    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
    }

    private pico getGrenadeDamage() {
        return this.thrower instanceof EntityPlayer ? new EntityDamageSourceGun(this.type.shortName, this, (EntityPlayer)this.thrower, this.type).func_76349_b() : new uxrp(this.type.shortName, (Entity)this, (Entity)this.thrower).func_76349_b();
    }

    protected void func_70088_a() {
    }

    protected void func_70037_a(hsus hsus2) {
        this.type = GrenadeType.getGrenade(hsus2._j("Type"));
        this.thrower = this.field_70170_p.func_72924_a(hsus2._j("Thrower"));
        this.field_70177_z = hsus2._h("RotationYaw");
        this.field_70125_A = hsus2._h("RotationPitch");
        this.axes.setAngles(this.field_70177_z, this.field_70125_A, 0.0f);
    }

    protected void func_70014_b(hsus hsus2) {
        hsus2._a("Type", this.type.shortName);
        if (this.thrower != null) {
            hsus2._a("Thrower", this.thrower.func_70023_ak());
        }
        hsus2._a("RotationYaw", this.axes.getYaw());
        hsus2._a("RotationPitch", this.axes.getPitch());
    }

    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeUTF(this.type.shortName);
        byteArrayDataOutput.writeInt(this.thrower == null ? 0 : this.thrower.field_70157_k);
        byteArrayDataOutput.writeFloat(this.axes.getYaw());
        byteArrayDataOutput.writeFloat(this.axes.getPitch());
    }

    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        this.type = GrenadeType.getGrenade(byteArrayDataInput.readUTF());
        this.func_70105_a(this.type.hitBoxSize, this.type.hitBoxSize);
        this.thrower = (EntityLivingBase)this.field_70170_p.func_73045_a(byteArrayDataInput.readInt());
        this.func_70101_b(byteArrayDataInput.readFloat(), byteArrayDataInput.readFloat());
        this.field_70126_B = this.field_70177_z;
        this.field_70127_C = this.field_70125_A;
        this.axes.setAngles(this.field_70177_z, this.field_70125_A, 0.0f);
        if (this.type.spinWhenThrown) {
            this.angularVelocity = new Vector3f(0.0f, 0.0f, 10.0f);
        }
    }
}

