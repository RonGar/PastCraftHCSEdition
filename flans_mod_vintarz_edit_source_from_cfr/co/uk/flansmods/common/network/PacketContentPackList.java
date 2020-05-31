/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  brcy
 *  cpw.mods.fml.relauncher.Side
 *  fmqx
 *  maaq
 *  net.minecraft.entity.player.EntityPlayerMP
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketContentPackList
extends FlanPacketCommon {
    public static final byte packetID = 16;

    public static maaq buildContentPackListPacket(List list) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(16);
            dataOutputStream.writeInt(list.size());
            for (int i = 0; i < list.size(); ++i) {
                dataOutputStream.writeUTF(((File)list.get(i)).getName());
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

    @Override
    public void interpret(DataInputStream dataInputStream, Object[] arrobject, Side side) {
        if (side.equals((Object)Side.SERVER)) {
            this.interpretServer(dataInputStream, arrobject);
        }
    }

    public void interpretServer(DataInputStream dataInputStream, Object[] arrobject) {
        try {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)arrobject[0];
            ArrayList<String> arrayList = new ArrayList<String>();
            for (File file : FlansMod.proxy.getContentList()) {
                arrayList.add(file.getName());
            }
            int n = dataInputStream.readInt();
            for (int i = 0; i < n; ++i) {
                String string2 = dataInputStream.readUTF();
                arrayList.remove(string2);
            }
            if (!arrayList.isEmpty()) {
                String string = "You lack content packs : ";
                for (String string2 : arrayList) {
                    string = string + string2 + ". ";
                }
                entityPlayerMP.field_71135_a._a(string);
            }
        }
        catch (Exception exception) {
            FlansMod.log("Error reading packet or spawning particles");
            exception.printStackTrace();
        }
    }
}

