/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
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
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PacketLocked
extends FlanPacketCommon {
    public static final byte packetID = 26;

    public static maaq buildLockedPacket() {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(26);
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
            EntitySeat entitySeat = (EntitySeat)entityPlayer.field_70154_o;
            EntityDriveable entityDriveable = entitySeat.driveable;
            if (entityDriveable != null && entitySeat.driver) {
                String string = entityDriveable.locked();
                if (string == null) {
                    entityDriveable.lock(entityPlayer.field_71092_bJ);
                } else {
                    entityDriveable.lock(null);
                }
            }
        }
        catch (Exception exception) {
            FlansMod.log("error parsing control packet");
            exception.printStackTrace();
        }
    }

    private void interpretServer(DataInputStream dataInputStream, Object[] arrobject) {
    }

    @SideOnly(value=Side.CLIENT)
    private void interpretClient(DataInputStream dataInputStream, Object[] arrobject) {
    }
}

