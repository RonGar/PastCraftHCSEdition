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
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import vintarz.core.VSP;

public class PacketDriveableDamage
extends FlanPacketCommon {
    public static final byte packetID = 11;

    public static maaq buildUpdatePacket(EntityDriveable entityDriveable) {
        if (FMLLaunchHandler.side() == Side.SERVER) {
            return PacketDriveableDamage.buildUpdatePacketServer(entityDriveable);
        }
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(11);
            dataOutputStream.writeInt(entityDriveable.field_70157_k);
            for (EnumDriveablePart enumDriveablePart : EnumDriveablePart.values()) {
                DriveablePart driveablePart = entityDriveable.getDriveableData().parts.get((Object)enumDriveablePart);
                dataOutputStream.writeShort((short)driveablePart.health);
                dataOutputStream.writeBoolean(driveablePart.onFire);
            }
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
        VSP vSP = new VSP(11, FlanPacketCommon.channelFlan);
        try {
            vSP.writeInt(entityDriveable.field_70157_k);
            for (EnumDriveablePart enumDriveablePart : EnumDriveablePart.values()) {
                DriveablePart driveablePart = entityDriveable.getDriveableData().parts.get((Object)enumDriveablePart);
                vSP.writeShort((int)((short)driveablePart.health));
                vSP.writeBoolean(driveablePart.onFire);
            }
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
            for (Object object : entityPlayer.field_70170_p.field_72996_f) {
                if (!(object instanceof EntityDriveable) || ((Entity)object).field_70157_k != n) continue;
                entityDriveable = (EntityDriveable)object;
                break;
            }
            if (entityDriveable != null) {
                for (EnumDriveablePart enumDriveablePart : EnumDriveablePart.values()) {
                    DriveablePart driveablePart = entityDriveable.getDriveableData().parts.get((Object)enumDriveablePart);
                    driveablePart.health = dataInputStream.readShort();
                    driveablePart.onFire = dataInputStream.readBoolean();
                }
            }
        }
        catch (Exception exception) {
            FlansMod.log("error parsing control packet");
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 11;
    }
}

