/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cuqu
 *  fmqx
 *  maaq
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PacketVehicleGUI
extends FlanPacketCommon {
    public static final byte packetID = 15;

    public static maaq buildGUIPacket(int n) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(15);
            dataOutputStream.writeInt(n);
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
            if (entityPlayer.field_70154_o != null && entityPlayer.field_70154_o instanceof EntitySeat) {
                EntityDriveable entityDriveable = ((EntitySeat)entityPlayer.field_70154_o).driveable;
                switch (n) {
                    case 0: {
                        entityPlayer.openGui((Object)FlansMod.instance, 6, entityPlayer.field_70170_p, entityDriveable.field_70176_ah, entityDriveable.field_70162_ai, entityDriveable.field_70164_aj);
                        break;
                    }
                    case 1: {
                        entityPlayer.openGui((Object)FlansMod.instance, 7, entityPlayer.field_70170_p, entityDriveable.field_70176_ah, entityDriveable.field_70162_ai, entityDriveable.field_70164_aj);
                        break;
                    }
                    case 2: {
                        entityPlayer.openGui((Object)FlansMod.instance, 8, entityPlayer.field_70170_p, entityDriveable.field_70176_ah, entityDriveable.field_70162_ai, entityDriveable.field_70164_aj);
                        break;
                    }
                    case 3: {
                        entityPlayer.openGui((Object)FlansMod.instance, 9, entityPlayer.field_70170_p, entityDriveable.field_70176_ah, entityDriveable.field_70162_ai, entityDriveable.field_70164_aj);
                        break;
                    }
                    case 4: {
                        entityPlayer.openGui((Object)FlansMod.instance, 10, entityPlayer.field_70170_p, entityDriveable.field_70176_ah, entityDriveable.field_70162_ai, entityDriveable.field_70164_aj);
                    }
                }
            }
        }
        catch (Exception exception) {
            FlansMod.log("error parsing GUI packet");
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 15;
    }
}

