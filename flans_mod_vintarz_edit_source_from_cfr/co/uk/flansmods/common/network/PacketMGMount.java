/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cuqu
 *  fmqx
 *  maaq
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.guns.EntityMG;
import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PacketMGMount
extends FlanPacketCommon {
    public static final byte packetID = 10;

    public static maaq buildMGPacket(EntityPlayer entityPlayer, EntityMG entityMG, boolean bl) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(10);
            dataOutputStream.writeInt(entityPlayer.field_70157_k);
            dataOutputStream.writeInt(entityMG.field_70157_k);
            dataOutputStream.writeBoolean(bl);
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
            cuqu cuqu2 = (cuqu)arrobject[0];
            int n = dataInputStream.readInt();
            EntityPlayer entityPlayer = null;
            for (Object e : cuqu2.field_72996_f) {
                if (!(e instanceof EntityPlayer) || ((Entity)e).field_70157_k != n) continue;
                entityPlayer = (EntityPlayer)e;
                break;
            }
            int n2 = dataInputStream.readInt();
            EntityMG entityMG = null;
            for (Object e : cuqu2.field_72996_f) {
                if (!(e instanceof EntityMG) || ((Entity)e).field_70157_k != n2) continue;
                entityMG = (EntityMG)((Object)e);
                break;
            }
            boolean bl = dataInputStream.readBoolean();
            entityMG.mountGun(entityPlayer, bl);
        }
        catch (Exception exception) {
            FlansMod.log("Error reading mountMG packet");
            exception.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 10;
    }
}

