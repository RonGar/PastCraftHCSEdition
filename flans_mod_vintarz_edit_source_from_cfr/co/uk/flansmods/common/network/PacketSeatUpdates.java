/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.relauncher.Side
 *  cuqu
 *  fmqx
 *  maaq
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.RotatedAxes;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.Seat;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PacketSeatUpdates
extends FlanPacketCommon {
    public static final byte packetID = 21;

    public static maaq buildUpdatePacket(EntitySeat entitySeat) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(21);
            dataOutputStream.writeInt(entitySeat.driveable.field_70157_k);
            dataOutputStream.writeInt(entitySeat.seatInfo.id);
            dataOutputStream.writeFloat(entitySeat.looking.getYaw());
            dataOutputStream.writeFloat(entitySeat.looking.getPitch());
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
            EntityDriveable entityDriveable = null;
            for (Object e : entityPlayer.field_70170_p.field_72996_f) {
                if (!(e instanceof EntityDriveable) || ((Entity)e).field_70157_k != n) continue;
                entityDriveable = (EntityDriveable)e;
                break;
            }
            if (entityDriveable != null) {
                int n2 = dataInputStream.readInt();
                float f = dataInputStream.readFloat();
                float f2 = dataInputStream.readFloat();
                if (side == Side.CLIENT && entityDriveable.seats[n2] != null && entityDriveable.seats[n2].field_70153_n == entityPlayer) {
                    return;
                }
                entityDriveable.seats[n2].prevLooking = entityDriveable.seats[n2].looking.clone();
                entityDriveable.seats[n2].looking.setAngles(f, f2, 0.0f);
                if (side == Side.SERVER) {
                    PacketDispatcher.sendPacketToAllAround((double)entityDriveable.field_70165_t, (double)entityDriveable.field_70163_u, (double)entityDriveable.field_70161_v, (double)50.0, (int)entityDriveable.field_71093_bK, (maaq)PacketSeatUpdates.buildUpdatePacket(entityDriveable.seats[n2]));
                }
            }
        }
        catch (Exception exception) {
            FlansMod.log("Error parsing seat updates packet");
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 21;
    }
}

