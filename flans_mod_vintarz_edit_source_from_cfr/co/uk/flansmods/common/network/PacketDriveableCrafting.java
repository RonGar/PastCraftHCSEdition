/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  fmqx
 *  maaq
 *  net.minecraft.entity.player.EntityPlayer
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import net.minecraft.entity.player.EntityPlayer;

public class PacketDriveableCrafting
extends FlanPacketCommon {
    public static final byte packetID = 9;

    public static maaq buildCraftingPacket(String string) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(9);
            dataOutputStream.writeUTF(string);
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
            DriveableType driveableType = DriveableType.getDriveable(dataInputStream.readUTF());
            EntityPlayer entityPlayer = (EntityPlayer)arrobject[0];
            FlansMod.proxy.craftDriveable(entityPlayer, driveableType);
        }
        catch (Exception exception) {
            FlansMod.log("Error crafting driveable");
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 9;
    }
}

