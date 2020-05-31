/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.idqh
 *  net.minecraft.util.rojd
 */
package co.uk.flansmods.vintarz;

import net.minecraft.util.idqh;
import net.minecraft.util.rojd;

public class PlayerRayTraceResult {
    public final idqh hit;
    public final rojd hitBox;
    public final float playerYaw;

    public PlayerRayTraceResult(idqh idqh2, rojd rojd2, float f) {
        this.hit = idqh2;
        this.hitBox = rojd2;
        this.playerYaw = f;
    }
}

