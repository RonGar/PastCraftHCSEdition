/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cuqu
 *  fmqx
 *  maaq
 *  ogpr
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.TileEntityGunBox;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PacketGunBoxTE
extends FlanPacketCommon {
    public static final byte packetID = 7;

    public static maaq buildGunBoxPacket(TileEntityGunBox tileEntityGunBox) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(7);
            dataOutputStream.writeInt(tileEntityGunBox.field_70329_l);
            dataOutputStream.writeInt(tileEntityGunBox.field_70330_m);
            dataOutputStream.writeInt(tileEntityGunBox.field_70327_n);
            dataOutputStream.writeUTF(tileEntityGunBox.getShortName());
            fmqx2._c = byteArrayOutputStream.toByteArray();
            fmqx2._b = fmqx2._c.length;
            fmqx2.field_73287_r = true;
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
            int n = dataInputStream.readInt();
            int n2 = dataInputStream.readInt();
            int n3 = dataInputStream.readInt();
            String string = dataInputStream.readUTF();
            cuqu cuqu2 = (cuqu)arrobject[0];
            TileEntityGunBox tileEntityGunBox = (TileEntityGunBox)cuqu2.func_72796_p(n, n2, n3);
            tileEntityGunBox.setShortName(string);
            cuqu2.func_72845_h(n, n2, n3);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 7;
    }
}

