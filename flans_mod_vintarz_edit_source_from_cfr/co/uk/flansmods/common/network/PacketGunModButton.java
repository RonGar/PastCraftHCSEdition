/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cuqu
 *  fmqx
 *  ivrt
 *  maaq
 *  net.minecraft.entity.player.EntityPlayer
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.guns.ContainerGunModTable;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import net.minecraft.entity.player.EntityPlayer;

public class PacketGunModButton
extends FlanPacketCommon {
    public static final byte packetID = 2;

    public static maaq buildButtonPressPacket(boolean bl, boolean bl2) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(2);
            dataOutputStream.writeBoolean(false);
            dataOutputStream.writeBoolean(bl);
            dataOutputStream.writeBoolean(bl2);
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

    public static maaq buildButtonOpenGuiPacket() {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(2);
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
            if (entityPlayer.field_71070_bA instanceof ContainerGunModTable) {
                ContainerGunModTable containerGunModTable = (ContainerGunModTable)entityPlayer.field_71070_bA;
                if (!dataInputStream.readBoolean()) {
                    containerGunModTable.pressButton(dataInputStream.readBoolean(), dataInputStream.readBoolean());
                }
            } else {
                entityPlayer.openGui((Object)FlansMod.instance, 2, entityPlayer.field_70170_p, 0, 0, 0);
            }
        }
        catch (Exception exception) {}
    }

    @Override
    public byte getPacketID() {
        return 2;
    }
}

