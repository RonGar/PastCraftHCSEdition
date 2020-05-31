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

import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PacketRepairDriveable
extends FlanPacketCommon {
    public static final byte packetID = 17;

    public static maaq buildRepairPacket(EnumDriveablePart enumDriveablePart) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(17);
            dataOutputStream.writeUTF(enumDriveablePart.getShortName());
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
            EnumDriveablePart enumDriveablePart = EnumDriveablePart.getPart(dataInputStream.readUTF());
            EntityPlayer entityPlayer = (EntityPlayer)arrobject[0];
            FlansMod.proxy.repairDriveable(entityPlayer, ((EntitySeat)entityPlayer.field_70154_o).driveable, ((EntitySeat)entityPlayer.field_70154_o).driveable.getDriveableData().parts.get((Object)enumDriveablePart));
        }
        catch (Exception exception) {
            FlansMod.log("Error repairing driveable");
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 17;
    }
}

