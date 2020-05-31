/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.FMLLaunchHandler
 *  cpw.mods.fml.relauncher.Side
 *  cuqu
 *  fmqx
 *  maaq
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  vintarz.core.VSP
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.RotatedAxes;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.network.FlanPacketCommon;
import co.uk.flansmods.common.vector.Vector3f;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import vintarz.core.VSP;

public class PacketVehicleControl
extends FlanPacketCommon {
    public static final byte packetID = 3;

    public static maaq buildUpdatePacket(EntityDriveable entityDriveable) {
        if (FMLLaunchHandler.side() == Side.SERVER) {
            return PacketVehicleControl.buildUpdatePacketServer(entityDriveable);
        }
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(3);
            dataOutputStream.writeInt(entityDriveable.field_70157_k);
            dataOutputStream.writeFloat((float)entityDriveable.field_70165_t);
            dataOutputStream.writeFloat((float)entityDriveable.field_70163_u);
            dataOutputStream.writeFloat((float)entityDriveable.field_70161_v);
            dataOutputStream.writeFloat(entityDriveable.axes.getYaw());
            dataOutputStream.writeFloat(entityDriveable.axes.getPitch());
            dataOutputStream.writeFloat(entityDriveable.axes.getRoll());
            dataOutputStream.writeFloat((float)entityDriveable.field_70159_w);
            dataOutputStream.writeFloat((float)entityDriveable.field_70181_x);
            dataOutputStream.writeFloat((float)entityDriveable.field_70179_y);
            dataOutputStream.writeFloat(entityDriveable.angularVelocity.x);
            dataOutputStream.writeFloat(entityDriveable.angularVelocity.y);
            dataOutputStream.writeFloat(entityDriveable.angularVelocity.z);
            dataOutputStream.writeFloat(entityDriveable.throttle);
            dataOutputStream.writeFloat(entityDriveable.driveableData.fuelInTank);
            entityDriveable.writeUpdateData(dataOutputStream);
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

    private static maaq buildUpdatePacketServer(EntityDriveable entityDriveable) {
        VSP vSP = new VSP(3, FlanPacketCommon.channelFlan);
        try {
            vSP.writeInt(entityDriveable.field_70157_k);
            vSP.writeFloat((float)entityDriveable.field_70165_t);
            vSP.writeFloat((float)entityDriveable.field_70163_u);
            vSP.writeFloat((float)entityDriveable.field_70161_v);
            vSP.writeFloat(entityDriveable.axes.getYaw());
            vSP.writeFloat(entityDriveable.axes.getPitch());
            vSP.writeFloat(entityDriveable.axes.getRoll());
            vSP.writeFloat((float)entityDriveable.field_70159_w);
            vSP.writeFloat((float)entityDriveable.field_70181_x);
            vSP.writeFloat((float)entityDriveable.field_70179_y);
            vSP.writeFloat(entityDriveable.angularVelocity.x);
            vSP.writeFloat(entityDriveable.angularVelocity.y);
            vSP.writeFloat(entityDriveable.angularVelocity.z);
            vSP.writeFloat(entityDriveable.throttle);
            vSP.writeFloat(entityDriveable.driveableData.fuelInTank);
            entityDriveable.writeUpdateData((DataOutputStream)vSP);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return vSP.genPacket();
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
                if (!side.isClient() || entityDriveable.seats[0] == null || entityDriveable.seats[0].field_70153_n != entityPlayer) break;
                return;
            }
            if (entityDriveable != null) {
                entityDriveable.setPositionRotationAndMotion(dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat(), 0.0f);
                entityDriveable.driveableData.fuelInTank = dataInputStream.readFloat();
                entityDriveable.readUpdateData(dataInputStream);
            }
        }
        catch (Exception exception) {
            FlansMod.log("error parsing control packet");
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 3;
    }
}

