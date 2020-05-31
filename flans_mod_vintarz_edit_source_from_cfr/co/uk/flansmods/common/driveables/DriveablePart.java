/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  hsus
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.common.driveables.CollisionBox;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.vector.Vector3f;

public class DriveablePart {
    public EnumDriveablePart type;
    public CollisionBox box;
    public int maxHealth;
    public int health;
    public int fireTime;
    public boolean onFire;
    public boolean dead;

    public DriveablePart(EnumDriveablePart enumDriveablePart, CollisionBox collisionBox) {
        this.type = enumDriveablePart;
        this.box = collisionBox;
        this.maxHealth = collisionBox == null ? 0 : collisionBox.health;
        this.health = this.maxHealth;
    }

    public void update(EntityDriveable entityDriveable) {
        if (this.fireTime > 0) {
            --this.fireTime;
        }
        if (this.fireTime == 0) {
            this.onFire = false;
        }
        if (this.onFire) {
            --this.health;
        }
        if (this.health <= 0 && this.maxHealth > 0) {
            this.dead = true;
        }
    }

    public void writeToNBT(hsus hsus2) {
        hsus2._a(this.type.getShortName() + "_Health", this.health);
        hsus2._a(this.type.getShortName() + "_Fire", this.onFire);
    }

    public void readFromNBT(hsus hsus2) {
        if (!hsus2._c(this.type.getShortName() + "_Health")) {
            this.health = this.maxHealth;
            this.onFire = false;
            return;
        }
        this.health = hsus2._f(this.type.getShortName() + "_Health");
        this.onFire = hsus2._o(this.type.getShortName() + "_Fire");
    }

    public float smashIntoGround(EntityDriveable entityDriveable, float f) {
        if (this.box == null || this.dead) {
            return 0.0f;
        }
        if (!entityDriveable.canHitPart(this.type)) {
            return 0.0f;
        }
        if (this.maxHealth == 0) {
            return f;
        }
        this.health -= (int)(f / 2.0f);
        return f / 2.0f;
    }

    public boolean rayTrace(EntityDriveable entityDriveable, EntityBullet entityBullet, Vector3f vector3f, Vector3f vector3f2) {
        boolean bl;
        if (this.box == null || this.health <= 0 || this.dead) {
            return false;
        }
        if (!entityDriveable.canHitPart(this.type)) {
            return false;
        }
        boolean bl2 = this.coordIsEntering(vector3f.x, vector3f.x + vector3f2.x, (float)this.box.x / 16.0f, (float)(this.box.x + this.box.w) / 16.0f);
        boolean bl3 = this.coordIsEntering(vector3f.y, vector3f.y + vector3f2.y, (float)this.box.y / 16.0f, (float)(this.box.y + this.box.h) / 16.0f);
        boolean bl4 = this.coordIsEntering(vector3f.z, vector3f.z + vector3f2.z, (float)this.box.z / 16.0f, (float)(this.box.z + this.box.d) / 16.0f);
        boolean bl5 = this.coordIsIn(vector3f.x, vector3f.x + vector3f2.x, (float)this.box.x / 16.0f, (float)(this.box.x + this.box.w) / 16.0f);
        boolean bl6 = this.coordIsIn(vector3f.y, vector3f.y + vector3f2.y, (float)this.box.y / 16.0f, (float)(this.box.y + this.box.h) / 16.0f);
        boolean bl7 = this.coordIsIn(vector3f.z, vector3f.z + vector3f2.z, (float)this.box.z / 16.0f, (float)(this.box.z + this.box.d) / 16.0f);
        boolean bl8 = bl = bl2 && bl6 && bl7 || bl5 && bl3 && bl7 || bl5 && bl6 && bl4;
        if (entityBullet != null && bl && !entityBullet.field_70170_p.field_72995_K) {
            this.health = (int)((float)this.health - entityBullet.damage * entityBullet.type.damageVsDriveable);
            if (entityBullet.type.fire > 0) {
                this.onFire = true;
            }
        }
        return bl;
    }

    private boolean coordIsEntering(float f, float f2, float f3, float f4) {
        if (f < f3 && f2 >= f3) {
            return true;
        }
        return f > f4 && f2 <= f4;
    }

    private boolean coordIsIn(float f, float f2, float f3, float f4) {
        if (f >= f3 && f <= f4) {
            return true;
        }
        if (f2 >= f3 && f2 <= f4) {
            return true;
        }
        if (f < f3 && f2 > f4) {
            return true;
        }
        return f2 < f3 && f > f4;
    }

    public void attack(float f, boolean bl, EntityDriveable entityDriveable) {
        if (!(entityDriveable.field_70165_t > -147.0 && entityDriveable.field_70165_t < 163.0 && entityDriveable.field_70161_v > -156.0 && entityDriveable.field_70161_v < 153.0 && entityDriveable.field_70163_u > 10.0)) {
            this.health = (int)((float)this.health - f);
            if (bl) {
                this.onFire = true;
            }
        }
    }
}

