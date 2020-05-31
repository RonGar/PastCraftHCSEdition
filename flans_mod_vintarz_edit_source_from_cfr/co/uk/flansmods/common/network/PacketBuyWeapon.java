/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  fmqx
 *  kjsv
 *  maaq
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.BlockGunBox;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.GunBoxType;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;

public class PacketBuyWeapon
extends FlanPacketCommon {
    public static final byte packetID = 5;

    public static maaq buildBuyWeaponPacket(GunBoxType gunBoxType, int n, int n2) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(5);
            dataOutputStream.writeUTF(gunBoxType.shortName);
            dataOutputStream.writeInt(n);
            dataOutputStream.writeInt(n2);
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
        } else {
            FlansMod.logLoudly("Recieved Weapon packet on Client. Skipped interpretation");
        }
    }

    public void interpretServer(DataInputStream dataInputStream, Object[] arrobject) {
        try {
            String string = dataInputStream.readUTF();
            int n = dataInputStream.readInt();
            int n2 = dataInputStream.readInt();
            GunBoxType gunBoxType = GunBoxType.getBox(string);
            EntityPlayer entityPlayer = (EntityPlayer)arrobject[1];
            FlansMod.gunBoxBlock.purchaseItem(n, n2, entityPlayer.field_71071_by, gunBoxType);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 5;
    }
}

