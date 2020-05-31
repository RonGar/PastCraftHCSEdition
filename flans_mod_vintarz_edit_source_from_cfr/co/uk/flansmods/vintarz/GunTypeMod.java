/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.vintarz;

import co.uk.flansmods.common.guns.GunType;

public class GunTypeMod {
    public float damage;
    public float recoil;
    public float bulletSpread;
    public int shootDelay;
    public float damageFar;
    public float bulletSpeed;

    public GunTypeMod(GunType gunType) {
        this.damage = gunType.damage;
        this.recoil = gunType.recoil;
        this.bulletSpread = gunType.bulletSpread;
        this.shootDelay = gunType.shootDelay;
        this.damageFar = gunType.damageFar;
        this.bulletSpeed = gunType.bulletSpeed;
    }
}

