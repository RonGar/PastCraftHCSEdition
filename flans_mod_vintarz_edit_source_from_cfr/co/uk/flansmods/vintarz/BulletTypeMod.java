/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.vintarz;

import co.uk.flansmods.common.guns.BulletType;

public class BulletTypeMod {
    public final BulletType type;
    public float slowdown;

    public BulletTypeMod(BulletType bulletType) {
        this.type = bulletType;
        this.slowdown = bulletType.slowdown;
    }
}

