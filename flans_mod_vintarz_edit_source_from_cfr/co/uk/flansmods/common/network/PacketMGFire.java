/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  fmqx
 *  maaq
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.guns.EntityAAGun;
import co.uk.flansmods.common.guns.EntityMG;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PacketMGFire
extends FlanPacketCommon {
    public static final byte packetID = 12;

    public static maaq buildMGFirePacket(boolean bl) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(12);
            dataOutputStream.writeBoolean(bl);
            fmqx2._c = byteArrayOutputStream.toByteArray();
            fmqx2._b = fmqx2._c.length;
            fmqx2.field_73287_r = true;
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
        if (!side.isClient()) {
            try {
                EntityPlayer entityPlayer = (EntityPlayer)arrobject[0];
                EntityMG entityMG = FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayer).mountingGun;
                if (entityMG != null) {
                    entityMG.mouseHeld(dataInputStream.readBoolean());
                } else if (entityPlayer.field_70154_o instanceof EntityAAGun) {
                    ((EntityAAGun)entityPlayer.field_70154_o).setMouseHeld(dataInputStream.readBoolean());
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    @Override
    public byte getPacketID() {
        return 12;
    }
}

