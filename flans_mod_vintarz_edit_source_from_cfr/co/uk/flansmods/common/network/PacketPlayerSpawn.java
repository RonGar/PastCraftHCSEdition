/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ctpu
 *  fmqx
 *  maaq
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.player.EntityPlayer
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.List;
import net.minecraft.client.tuor;
import net.minecraft.entity.player.EntityPlayer;

public class PacketPlayerSpawn
extends FlanPacketCommon {
    public static final byte packetID = 20;

    public static maaq buildPlayerSpawnPacket(EntityPlayer entityPlayer, double d, double d2, double d3) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(20);
            dataOutputStream.writeUTF(entityPlayer.field_71092_bJ);
            dataOutputStream.writeDouble(d);
            dataOutputStream.writeDouble(d2);
            dataOutputStream.writeDouble(d3);
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
        if (side.equals((Object)Side.CLIENT)) {
            this.interpretClient(dataInputStream, arrobject);
        } else {
            FlansMod.log("Received player spawn packet on server! Doing nothing");
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void interpretClient(DataInputStream dataInputStream, Object[] arrobject) {
        try {
            String string = dataInputStream.readUTF();
            dataInputStream.readDouble();
            dataInputStream.readDouble();
            dataInputStream.readDouble();
            tuor._E();
            for (Object e : tuor._E()._p.field_73010_i) {
                EntityPlayer entityPlayer = (EntityPlayer)e;
                if (entityPlayer.field_70128_L) continue;
                entityPlayer.field_71092_bJ.equals(string);
            }
        }
        catch (Exception exception) {
            FlansMod.log("Error reading packet or setting player spawn position");
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 20;
    }
}

