/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  fmqx
 *  hrvk
 *  maaq
 *  net.minecraft.client.tuor
 *  rojd
 *  vintarz.core.VSP
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.util.Random;
import net.minecraft.client.tuor;
import vintarz.core.VSP;

public class PacketPlaySound
extends FlanPacketCommon {
    public static Random rand = new Random();
    public static final byte packetID = 8;

    public static void sendSoundPacket(double d, double d2, double d3, double d4, int n, String string, boolean bl) {
        PacketPlaySound.sendSoundPacket(d, d2, d3, d4, n, string, bl, false);
    }

    public static void sendSoundPacket(double d, double d2, double d3, double d4, int n, String string, boolean bl, boolean bl2) {
        PacketDispatcher.sendPacketToAllAround((double)d, (double)d2, (double)d3, (double)d4, (int)n, (maaq)PacketPlaySound.buildSoundPacket(d, d2, d3, string, bl, bl2));
    }

    public static maaq buildSoundPacket(double d, double d2, double d3, String string) {
        return PacketPlaySound.buildSoundPacket(d, d2, d3, string, false);
    }

    public static maaq buildSoundPacket(double d, double d2, double d3, String string, boolean bl) {
        return PacketPlaySound.buildSoundPacket(d, d2, d3, string, bl, false);
    }

    public static maaq buildSoundPacket(double d, double d2, double d3, String string, boolean bl, boolean bl2) {
        VSP vSP = new VSP(8, FlanPacketCommon.channelFlan);
        try {
            vSP.writeFloat((float)d);
            vSP.writeFloat((float)d2);
            vSP.writeFloat((float)d3);
            vSP.writeUTF(string);
            vSP.writeBoolean(bl);
            vSP.writeBoolean(bl2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return vSP.genPacket();
    }

    @Override
    public void interpret(DataInputStream dataInputStream, Object[] arrobject, Side side) {
        if (side.equals((Object)Side.CLIENT)) {
            this.interpretClient(dataInputStream, arrobject);
        } else {
            FlansMod.log("Sound packet recieved on server. Skipping interpretation.");
        }
    }

    @SideOnly(value=Side.CLIENT)
    private void interpretClient(DataInputStream dataInputStream, Object[] arrobject) {
        try {
            float f = dataInputStream.readFloat();
            float f2 = dataInputStream.readFloat();
            float f3 = dataInputStream.readFloat();
            String string = dataInputStream.readUTF();
            boolean bl = dataInputStream.readBoolean();
            boolean bl2 = dataInputStream.readBoolean();
            rojd.instance().getClient()._L._a("mob.chicken.say".equals(string) ? string : "flansmod:" + string, f, f2, f3, bl2 ? 0.5f : 4.0f, (bl ? 1.0f / (rand.nextFloat() * 0.4f + 0.8f) : 1.0f) * (bl2 ? 2.0f : 1.0f));
        }
        catch (Exception exception) {
            FlansMod.log("Error reading or playing sound");
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 8;
    }
}

