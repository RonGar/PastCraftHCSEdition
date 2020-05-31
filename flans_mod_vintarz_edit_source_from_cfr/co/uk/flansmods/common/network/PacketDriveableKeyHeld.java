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

import co.uk.flansmods.api.IControllable;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PacketDriveableKeyHeld
extends FlanPacketCommon {
    public static final byte packetID = 22;

    public static maaq buildKeyPacket(int n, boolean bl) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(22);
            dataOutputStream.writeInt(n);
            dataOutputStream.writeBoolean(bl);
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
        try {
            EntityPlayer entityPlayer = (EntityPlayer)arrobject[0];
            int n = dataInputStream.readInt();
            boolean bl = dataInputStream.readBoolean();
            if (entityPlayer.field_70154_o != null && entityPlayer.field_70154_o instanceof IControllable) {
                ((IControllable)entityPlayer.field_70154_o).updateKeyHeldState(n, bl);
            }
        }
        catch (Exception exception) {
            FlansMod.log("error parsing control packet");
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 22;
    }
}

