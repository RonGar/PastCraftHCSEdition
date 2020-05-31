/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.Player
 *  cpw.mods.fml.relauncher.Side
 *  ctpu
 *  cuqu
 *  fmqx
 *  mrcr
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.player.EntityPlayer
 *  rojd
 */
package co.uk.flansmods.client.network;

import co.uk.flansmods.common.network.FlanPacketCommon;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import java.io.DataInputStream;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.entity.player.EntityPlayer;

public class FlanPacketClient
extends FlanPacketCommon {
    @Override
    public void onPacketData(mrcr mrcr2, fmqx fmqx2, Player player) {
        EntityClientPlayerMP entityClientPlayerMP = rojd.instance().getClient()._r;
        if (fmqx2._a.equals(FlanPacketCommon.channelFlan)) {
            ctpu ctpu2 = tuor._E()._p;
            FlanPacketClient.receive(fmqx2, (EntityPlayer)entityClientPlayerMP, mrcr2, Side.CLIENT, (cuqu)ctpu2);
        }
    }

    @Override
    public void interpret(DataInputStream dataInputStream, Object[] arrobject, Side side) {
    }

    @Override
    public byte getPacketID() {
        return 0;
    }
}

