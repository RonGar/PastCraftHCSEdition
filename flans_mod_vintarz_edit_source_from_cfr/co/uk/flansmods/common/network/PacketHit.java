/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  fmqx
 *  maaq
 *  vintarz.core.VSP
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.network.FlanPacketCommon;
import co.uk.flansmods.vintarz.CrosshairRenderer;
import cpw.mods.fml.relauncher.Side;
import java.io.DataInputStream;
import java.io.IOException;
import vintarz.core.VSP;

public class PacketHit
extends FlanPacketCommon {
    public static final byte packetID = 24;

    public static maaq buildPacket(boolean bl) {
        VSP vSP = new VSP(24, FlanPacketCommon.channelFlan);
        try {
            vSP.writeBoolean(bl);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return vSP.genPacket();
    }

    @Override
    public void interpret(DataInputStream dataInputStream, Object[] arrobject, Side side) {
        try {
            if (dataInputStream.readBoolean()) {
                CrosshairRenderer.death_count = 10;
            } else {
                CrosshairRenderer.hit_count = 5;
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 24;
    }
}

