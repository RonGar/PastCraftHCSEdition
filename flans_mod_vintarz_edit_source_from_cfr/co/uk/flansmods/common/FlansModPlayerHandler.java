/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.IPlayerTracker
 *  cpw.mods.fml.common.registry.GameRegistry
 *  cpw.mods.fml.relauncher.Side
 *  hcsmod.HCS
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.kjuq
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.util.pico
 *  net.minecraftforge.common.bpzx
 *  net.minecraftforge.event.eidl
 *  net.minecraftforge.event.kjuq
 *  zhav
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.teams.Gametype;
import co.uk.flansmods.common.teams.TeamsManager;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import hcsmod.HCS;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.pico;
import net.minecraftforge.common.bpzx;
import net.minecraftforge.event.eidl;
import net.minecraftforge.event.kjuq;

public class FlansModPlayerHandler
implements IPlayerTracker {
    public static Map<String, FlansModPlayerData> serverSideData = new HashMap<String, FlansModPlayerData>();
    public static Map<String, FlansModPlayerData> clientSideData = new HashMap<String, FlansModPlayerData>();
    public static ArrayList<String> clientsToRemoveAfterThisRound = new ArrayList();

    public FlansModPlayerHandler() {
        bpzx.EVENT_BUS.register((Object)this);
        GameRegistry.registerPlayerTracker((IPlayerTracker)this);
    }

    @kjuq
    public void onEntityHurt(zhav zhav2) {
        Object object;
        EntityLivingBase entityLivingBase = zhav2.entityLiving;
        if (entityLivingBase.field_70154_o instanceof EntitySeat) {
            if (zhav2.source == pico.field_76368_d || zhav2.source == pico.field_76379_h) {
                zhav2.ammount = 0.0f;
            } else {
                object = (EntitySeat)entityLivingBase.field_70154_o;
                EntityDriveable entityDriveable = ((EntitySeat)object).driveable;
                if (entityDriveable.getDriveableData().parts.get((Object)EnumDriveablePart.core).health > 650) {
                    zhav2.ammount *= 0.1f;
                } else if (entityDriveable.getDriveableData().parts.get((Object)EnumDriveablePart.core).health > 450) {
                    zhav2.ammount *= 0.4f;
                } else if (entityDriveable.getDriveableData().parts.get((Object)EnumDriveablePart.core).health > 350) {
                    zhav2.ammount *= 0.89f;
                }
            }
        }
        if (entityLivingBase.field_70154_o != null && (object = net.minecraft.entity.kjuq._b((Entity)entityLivingBase.field_70154_o)) != null && ((String)object).startsWith("mcheli.")) {
            boolean bl = HCS.isHardcoreServer();
            zhav2.ammount *= bl ? 0.7f : 0.3f;
            entityLivingBase.field_70154_o.func_70097_a(zhav2.source, bl ? zhav2.ammount : zhav2.ammount / 2.0f);
        }
    }

    public void tick() {
        for (FlansModPlayerData flansModPlayerData : serverSideData.values()) {
            flansModPlayerData.tick();
        }
        for (FlansModPlayerData flansModPlayerData : clientSideData.values()) {
            flansModPlayerData.tick();
        }
    }

    public static FlansModPlayerData getPlayerData(EntityPlayer entityPlayer) {
        return FlansModPlayerHandler.getPlayerData(entityPlayer.field_71092_bJ, Side.SERVER);
    }

    public static FlansModPlayerData getPlayerData(String string) {
        return FlansModPlayerHandler.getPlayerData(string, Side.SERVER);
    }

    public static FlansModPlayerData getPlayerData(EntityPlayer entityPlayer, Side side) {
        if (entityPlayer == null) {
            return null;
        }
        return FlansModPlayerHandler.getPlayerData(entityPlayer.field_71092_bJ, side);
    }

    public static FlansModPlayerData getPlayerData(String string, Side side) {
        if (side.isClient() && !clientSideData.containsKey(string)) {
            clientSideData.put(string, new FlansModPlayerData(string));
        }
        return side.isClient() ? clientSideData.get(string) : serverSideData.get(string);
    }

    public void onPlayerLogin(EntityPlayer entityPlayer) {
        if (!serverSideData.containsKey(entityPlayer.field_71092_bJ)) {
            serverSideData.put(entityPlayer.field_71092_bJ, new FlansModPlayerData(entityPlayer.field_71092_bJ));
        }
        if (TeamsManager.getInstance().currentGametype != null && TeamsManager.getInstance().areTeamsValid()) {
            Gametype.sendTeamsMenuToPlayer((EntityPlayerMP)entityPlayer);
        }
        if (clientsToRemoveAfterThisRound.contains(entityPlayer.field_71092_bJ)) {
            clientsToRemoveAfterThisRound.remove(entityPlayer.field_71092_bJ);
        }
    }

    public void onPlayerLogout(EntityPlayer entityPlayer) {
        if (TeamsManager.getInstance().currentGametype == null) {
            serverSideData.remove(entityPlayer.field_71092_bJ);
        } else {
            clientsToRemoveAfterThisRound.add(entityPlayer.field_71092_bJ);
        }
    }

    public void onPlayerChangedDimension(EntityPlayer entityPlayer) {
    }

    public void onPlayerRespawn(EntityPlayer entityPlayer) {
    }

    public static void roundEnded() {
        for (String string : clientsToRemoveAfterThisRound) {
            serverSideData.remove(string);
        }
    }
}

