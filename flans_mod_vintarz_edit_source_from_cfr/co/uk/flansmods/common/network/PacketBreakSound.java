/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cccu
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  fmqx
 *  hrvk
 *  kjsv
 *  maaq
 *  net.minecraft.client.particle.uxsf
 *  net.minecraft.client.tuor
 *  rojd
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
import net.minecraft.client.particle.uxsf;
import net.minecraft.client.tuor;

public class PacketBreakSound
extends FlanPacketCommon {
    public static final byte packetID = 1;

    public static maaq buildBreakSoundPacket(int n, int n2, int n3, int n4) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(1);
            dataOutputStream.writeInt(n);
            dataOutputStream.writeInt(n2);
            dataOutputStream.writeInt(n3);
            dataOutputStream.writeInt(n4);
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
            FlansMod.log("Sound packet recieved on server. Skipping interpretation.");
        }
    }

    @SideOnly(value=Side.CLIENT)
    private void interpretClient(DataInputStream dataInputStream, Object[] arrobject) {
        try {
            int n = dataInputStream.readInt();
            int n2 = dataInputStream.readInt();
            int n3 = dataInputStream.readInt();
            int n4 = dataInputStream.readInt();
            kjsv kjsv2 = kjsv.field_71973_m[n4];
            rojd.instance().getClient()._u._a(n, n2, n3, 1);
            rojd.instance().getClient()._L._a(kjsv2.field_72020_cn._c(), (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, (kjsv2.field_72020_cn._a() + 1.0f) / 2.0f, kjsv2.field_72020_cn._b() * 0.8f);
        }
        catch (Exception exception) {
            FlansMod.log("Error reading or playing break sound");
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 1;
    }
}

