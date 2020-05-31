/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 */
package co.uk.flansmods.api;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public interface IControllable {
    public void onMouseMoved(int var1, int var2);

    public boolean pressKey(int var1, EntityPlayer var2);

    public void updateKeyHeldState(int var1, boolean var2);

    public Entity getControllingEntity();

    public boolean isDead();

    public float getPlayerRoll();

    public float getCameraDistance();
}

