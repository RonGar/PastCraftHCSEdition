/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.common.network.Player
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  fmqx
 *  hcsmod.flashlight.Flashlight
 *  hsus
 *  ieta
 *  jhvs
 *  maaq
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.client.FlansModClient;
import co.uk.flansmods.client.model.GunAnimations;
import co.uk.flansmods.client.model.ModelGun;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemGun;
import co.uk.flansmods.common.network.FlanPacketCommon;
import co.uk.flansmods.common.network.PacketPlaySound;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.flashlight.Flashlight;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;

public class PacketReload
extends FlanPacketCommon {
    public static final byte packetID = 19;

    public static maaq buildReloadPacket() {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(19);
            fmqx2._c = byteArrayOutputStream.toByteArray();
            fmqx2._b = fmqx2._c.length;
            dataOutputStream.close();
            byteArrayOutputStream.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return fmqx2;
    }

    @Override
    public void interpret(DataInputStream dataInputStream, Object[] arrobject, Side side) {
        if (side.equals((Object)Side.CLIENT)) {
            this.interpretClient(dataInputStream, arrobject);
        } else {
            this.interpretServer(dataInputStream, arrobject);
        }
    }

    private void interpretServer(DataInputStream dataInputStream, Object[] arrobject) {
        EntityPlayer entityPlayer = (EntityPlayer)arrobject[0];
        ieta ieta2 = entityPlayer.func_71045_bC();
        if (ieta2 != null && ieta2._d == Flashlight.flashlight.field_77779_bT) {
            hsus hsus2 = ieta2._q();
            if (hsus2 == null) {
                hsus2 = new hsus();
                ieta2._d(hsus2);
            }
            if (entityPlayer.field_71071_by._d(7456)) {
                entityPlayer.field_71071_by._c(7456);
                hsus2._a("f", (short)1800);
                hsus2._p("F");
            }
            return;
        }
        FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData(entityPlayer);
        if (flansModPlayerData != null && ieta2 != null && ieta2._a() instanceof ItemGun) {
            GunType gunType = ((ItemGun)ieta2._a()).type;
            if (((ItemGun)ieta2._a()).reload(ieta2, entityPlayer.field_70170_p, entityPlayer, true)) {
                flansModPlayerData.shootTime = gunType.reloadTime;
                PacketDispatcher.sendPacketToPlayer((maaq)PacketReload.buildReloadPacket(), (Player)((Player)entityPlayer));
                if (gunType.reloadSound != null) {
                    PacketDispatcher.sendPacketToAllAround((double)entityPlayer.field_70165_t, (double)entityPlayer.field_70163_u, (double)entityPlayer.field_70161_v, (double)50.0, (int)entityPlayer.field_71093_bK, (maaq)PacketPlaySound.buildSoundPacket(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, gunType.reloadSound, false));
                }
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    private void interpretClient(DataInputStream dataInputStream, Object[] arrobject) {
        try {
            EntityPlayer entityPlayer = (EntityPlayer)arrobject[0];
            ieta ieta2 = entityPlayer.func_71045_bC();
            if (ieta2 != null && ieta2._a() instanceof ItemGun) {
                GunAnimations gunAnimations;
                GunType gunType = ((ItemGun)ieta2._a()).type;
                FlansModClient.clientPlayerData.shootTime = ItemGun.getClientReloadTime(ieta2);
                if (FlansModClient.gunAnimations.containsKey((Object)entityPlayer)) {
                    gunAnimations = (GunAnimations)FlansModClient.gunAnimations.get((Object)entityPlayer);
                } else {
                    gunAnimations = new GunAnimations();
                    FlansModClient.gunAnimations.put(entityPlayer, gunAnimations);
                }
                int n = gunType.model == null ? 0 : gunType.model.pumpDelayAfterReload;
                int n2 = gunType.model == null ? 1 : gunType.model.pumpTime;
                gunAnimations.doReload(gunType.reloadTime, n, n2);
            }
        }
        catch (Exception exception) {
            FlansMod.log("Error \"reload\"ing from reload packet");
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 19;
    }
}

