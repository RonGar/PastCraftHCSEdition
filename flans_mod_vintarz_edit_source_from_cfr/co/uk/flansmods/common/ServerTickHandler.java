/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.TickType
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.vintarz.BulletSpread;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class ServerTickHandler
implements ITickHandler {
    public void tickStart(EnumSet enumSet, Object ... arrobject) {
        EntityPlayer entityPlayer = (EntityPlayer)arrobject[0];
        if (entityPlayer instanceof EntityPlayerMP) {
            FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData(entityPlayer);
            if (!flansModPlayerData.spreadTicked) {
                BulletSpread.tickWeaponSpread(entityPlayer, flansModPlayerData);
            }
            flansModPlayerData.spreadTicked = false;
        }
    }

    public void tickEnd(EnumSet enumSet, Object ... arrobject) {
    }

    public EnumSet ticks() {
        return EnumSet.of(TickType.PLAYER);
    }

    public String getLabel() {
        return "FlansMod ServerTickhandler";
    }
}

