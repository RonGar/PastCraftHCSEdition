/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ctpu
 *  cuqu
 *  fmqx
 *  maaq
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.dfat
 *  net.minecraft.util.idqh
 *  net.minecraft.util.samw
 *  vintarz.core.VSP
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.network.FlanPacketCommon;
import co.uk.flansmods.vintarz.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.IOException;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.util.dfat;
import net.minecraft.util.idqh;
import net.minecraft.util.samw;
import vintarz.core.VSP;

public class PacketBullet
extends FlanPacketCommon {
    public static final byte packetID = 25;

    public static maaq buildPacket(double d, double d2, double d3, double d4, double d5, double d6, idqh idqh2, Entity entity, float f, boolean bl) {
        VSP vSP = new VSP(25, FlanPacketCommon.channelFlan);
        try {
            vSP.writeInt(entity == null ? -1 : entity.field_70157_k);
            vSP.writeFloat((float)d4);
            vSP.writeFloat((float)d5);
            vSP.writeFloat((float)d6);
            vSP.writeFloat((float)d);
            vSP.writeFloat((float)d2);
            vSP.writeFloat((float)d3);
            if (idqh2 == null) {
                vSP.writeByte(0);
            } else if (idqh2._a == dfat._a) {
                vSP.writeByte(bl ? 1 : 3);
                vSP.writeShort(idqh2._b);
                vSP.writeByte(idqh2._c);
                vSP.writeShort(idqh2._d);
                vSP.writeByte(idqh2._e);
            } else if (idqh2._a == dfat._b) {
                vSP.writeByte(bl ? 2 : 4);
                vSP.writeInt(idqh2._g.field_70157_k);
            } else {
                vSP.writeByte(0);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return vSP.genPacket();
    }

    @SideOnly(value=Side.CLIENT)
    @Override
    public void interpret(DataInputStream dataInputStream, Object[] arrobject, Side side) {
        try {
            EntityBullet entityBullet = new EntityBullet((cuqu)tuor._E()._p);
            idqh idqh2 = null;
            entityBullet.owner = entityBullet.field_70170_p.func_73045_a(dataInputStream.readInt());
            entityBullet.field_70169_q = dataInputStream.readFloat();
            entityBullet.field_70167_r = dataInputStream.readFloat();
            entityBullet.field_70166_s = dataInputStream.readFloat();
            entityBullet.field_70165_t = dataInputStream.readFloat();
            entityBullet.field_70163_u = dataInputStream.readFloat();
            entityBullet.field_70161_v = dataInputStream.readFloat();
            samw samw2 = samw._a((double)entityBullet.field_70165_t, (double)entityBullet.field_70163_u, (double)entityBullet.field_70161_v);
            boolean bl = true;
            int n = dataInputStream.readUnsignedByte();
            if (n == 1) {
                idqh2 = new idqh((int)dataInputStream.readShort(), dataInputStream.readUnsignedByte(), (int)dataInputStream.readShort(), (int)dataInputStream.readByte(), samw2);
            } else if (n == 2) {
                Entity entity = ((Entity)arrobject[0]).field_70170_p.func_73045_a(dataInputStream.readInt());
                idqh2 = new idqh(entity);
                idqh2._f = samw2;
            } else if (n == 3) {
                idqh2 = new idqh((int)dataInputStream.readShort(), dataInputStream.readUnsignedByte(), (int)dataInputStream.readShort(), (int)dataInputStream.readByte(), samw2);
                bl = false;
            } else if (n != 0) {
                return;
            }
            entityBullet.field_70159_w = entityBullet.field_70165_t - entityBullet.field_70169_q;
            entityBullet.field_70181_x = entityBullet.field_70163_u - entityBullet.field_70167_r;
            entityBullet.field_70179_y = entityBullet.field_70161_v - entityBullet.field_70166_s;
            Util.clientBulletEffects(idqh2, entityBullet, bl);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 25;
    }
}

