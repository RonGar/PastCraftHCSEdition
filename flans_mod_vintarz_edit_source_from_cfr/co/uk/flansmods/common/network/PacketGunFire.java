/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cuqu
 *  fmqx
 *  hcsmod.server.HcsServer
 *  hcsmod.server.SPacketHandler
 *  ieta
 *  jhvs
 *  maaq
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.entity.player.rojd
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.guns.ItemGun;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.Side;
import hcsmod.server.HcsServer;
import hcsmod.server.SPacketHandler;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.eidl;
import net.minecraft.entity.player.rojd;

public class PacketGunFire
extends FlanPacketCommon {
    public static final byte packetID = 13;

    public static maaq buildGunFirePacket(long l, int n) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(13);
            dataOutputStream.writeLong(l);
            dataOutputStream.writeByte(n);
        }
        catch (IOException iOException) {}
        return new fmqx(FlanPacketCommon.channelFlan, byteArrayOutputStream.toByteArray());
    }

    @Override
    public void interpret(DataInputStream dataInputStream, Object[] arrobject, Side side) {
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP)arrobject[0];
        if (!entityPlayerMP.field_71075_bZ._d && entityPlayerMP.field_70165_t >= -80.0 && entityPlayerMP.field_70165_t <= 80.0 && entityPlayerMP.field_70161_v >= -80.0 && entityPlayerMP.field_70161_v <= 80.0) {
            SPacketHandler.sendHint((EntityPlayer)entityPlayerMP, (String)"SSGF", (String)"\u00a7e\u0421\u0442\u0440\u0435\u043b\u044c\u0431\u0430 \u043d\u0430 \u0441\u0435\u0439\u0444\u0437\u043e\u043d\u0435 \u043d\u0435 \u0442\u0440\u0430\u0442\u0438\u0442 \u043f\u0430\u0442\u0440\u043e\u043d\u044b.\n\u00a7e\u0412\u044b\u0441\u0442\u0440\u0435\u043b\u044b \u043d\u0430 \u0441\u0435\u0439\u0444\u0437\u043e\u043d\u0435 \u043d\u0435 \u0432\u0438\u0434\u044f\u0442 \u0434\u0440\u0443\u0433\u0438\u0435 \u0438\u0433\u0440\u043e\u043a\u0438.", (int)200);
            return;
        }
        cuqu cuqu2 = (cuqu)arrobject[1];
        ieta ieta2 = entityPlayerMP.field_71071_by._a();
        if (ieta2 != null && ieta2._a() != null && ieta2._a() instanceof ItemGun) {
            try {
                HcsServer.shoot((ItemGun)((ItemGun)ieta2._a()), (ieta)ieta2, (cuqu)cuqu2, (EntityPlayerMP)entityPlayerMP, (long)dataInputStream.readLong(), (int)dataInputStream.readUnsignedByte());
            }
            catch (IOException iOException) {}
        }
    }

    @Override
    public byte getPacketID() {
        return 13;
    }
}

