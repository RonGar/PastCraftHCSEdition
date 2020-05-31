/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ccfp
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ctpu
 *  cuqu
 *  fmqx
 *  jhvs
 *  kjsv
 *  maaq
 *  net.minecraft.client.particle.EntityAuraFX
 *  net.minecraft.client.particle.EntityBreakingFX
 *  net.minecraft.client.particle.EntityBubbleFX
 *  net.minecraft.client.particle.EntityCloudFX
 *  net.minecraft.client.particle.EntityCritFX
 *  net.minecraft.client.particle.EntityDiggingFX
 *  net.minecraft.client.particle.EntityDropParticleFX
 *  net.minecraft.client.particle.EntityEnchantmentTableParticleFX
 *  net.minecraft.client.particle.EntityExplodeFX
 *  net.minecraft.client.particle.EntityFX
 *  net.minecraft.client.particle.EntityFireworkSparkFX
 *  net.minecraft.client.particle.EntityFlameFX
 *  net.minecraft.client.particle.EntityFootStepFX
 *  net.minecraft.client.particle.EntityHeartFX
 *  net.minecraft.client.particle.EntityHugeExplodeFX
 *  net.minecraft.client.particle.EntityLargeExplodeFX
 *  net.minecraft.client.particle.EntityLavaFX
 *  net.minecraft.client.particle.EntityNoteFX
 *  net.minecraft.client.particle.EntityPortalFX
 *  net.minecraft.client.particle.EntityReddustFX
 *  net.minecraft.client.particle.EntitySmokeFX
 *  net.minecraft.client.particle.EntitySnowShovelFX
 *  net.minecraft.client.particle.EntitySpellParticleFX
 *  net.minecraft.client.particle.EntitySplashFX
 *  net.minecraft.client.particle.EntitySuspendFX
 *  net.minecraft.client.particle.uxsf
 *  net.minecraft.client.tuor
 *  rojd
 *  vintarz.core.VCore
 *  vintarz.core.VSP
 *  zfwe
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.network.FlanPacketCommon;
import co.uk.flansmods.vintarz.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Random;
import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.client.particle.EntityBubbleFX;
import net.minecraft.client.particle.EntityCloudFX;
import net.minecraft.client.particle.EntityCritFX;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityDropParticleFX;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.client.particle.EntityExplodeFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntityFootStepFX;
import net.minecraft.client.particle.EntityHeartFX;
import net.minecraft.client.particle.EntityHugeExplodeFX;
import net.minecraft.client.particle.EntityLargeExplodeFX;
import net.minecraft.client.particle.EntityLavaFX;
import net.minecraft.client.particle.EntityNoteFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.particle.EntitySnowShovelFX;
import net.minecraft.client.particle.EntitySpellParticleFX;
import net.minecraft.client.particle.EntitySplashFX;
import net.minecraft.client.particle.EntitySuspendFX;
import net.minecraft.client.particle.uxsf;
import net.minecraft.client.tuor;
import vintarz.core.VCore;
import vintarz.core.VSP;

public class PacketFlak
extends FlanPacketCommon {
    public static final byte packetID = 14;
    public static Random rand = new Random();

    public static maaq buildFlakPacket(double d, double d2, double d3, int n, String string) {
        VSP vSP = new VSP(14, FlanPacketCommon.channelFlan);
        try {
            vSP.writeDouble(d);
            vSP.writeDouble(d2);
            vSP.writeDouble(d3);
            vSP.writeInt(n);
            vSP.writeUTF(string);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return vSP.genPacket();
    }

    public static maaq buildFlakPacket(double d, double d2, double d3, int n, String string, double d4, double d5, double d6) {
        VSP vSP = new VSP(14, FlanPacketCommon.channelFlan);
        try {
            vSP.writeDouble(d);
            vSP.writeDouble(d2);
            vSP.writeDouble(d3);
            vSP.writeInt(n);
            vSP.writeUTF(string);
            vSP.writeDouble(d4);
            vSP.writeDouble(d5);
            vSP.writeDouble(d6);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return vSP.genPacket();
    }

    @Override
    public void interpret(DataInputStream dataInputStream, Object[] arrobject, Side side) {
        if (side.isClient()) {
            this.interpretClient(dataInputStream, arrobject, side);
        } else {
            FlansMod.log("Flak packet received on server. Skipping interpretation.");
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void interpretClient(DataInputStream dataInputStream, Object[] arrobject, Side side) {
        if (!Util.displayParticles()) {
            return;
        }
        try {
            cuqu cuqu2 = (cuqu)arrobject[0];
            double d = dataInputStream.readDouble();
            double d2 = dataInputStream.readDouble();
            double d3 = dataInputStream.readDouble();
            int n = dataInputStream.readInt();
            String string = dataInputStream.readUTF();
            if (string.startsWith("tilecrack_")) {
                double d4 = dataInputStream.readDouble();
                double d5 = dataInputStream.readDouble();
                double d6 = dataInputStream.readDouble();
                for (int i = 0; i < n; ++i) {
                    String[] arrstring = string.split("_", 3);
                    int n2 = Integer.parseInt(arrstring[1]);
                    int n3 = Integer.parseInt(arrstring[2]);
                    EntityDiggingFX entityDiggingFX = new EntityDiggingFX((cuqu)tuor._E()._p, d, d2, d3, VCore.rnd.nextDouble() * 0.01 - d4, VCore.rnd.nextDouble() * 0.01 - d5, VCore.rnd.nextDouble() * 0.01 - d6, kjsv.field_71973_m[n2], n3).func_90019_g(n3);
                    entityDiggingFX.field_70155_l = 256.0;
                    tuor._E()._u._a((EntityFX)entityDiggingFX);
                }
                return;
            }
            for (int i = 0; i < n; ++i) {
                EntityFX entityFX = this.getParticle(string, cuqu2, d + rand.nextGaussian(), d2 + rand.nextGaussian(), d3 + rand.nextGaussian());
                entityFX.field_70159_w = rand.nextGaussian() / 20.0;
                entityFX.field_70181_x = rand.nextGaussian() / 20.0;
                entityFX.field_70179_y = rand.nextGaussian() / 20.0;
                entityFX.field_70155_l = 256.0;
                rojd.instance().getClient()._u._a(entityFX);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public byte getPacketID() {
        return 14;
    }

    @SideOnly(value=Side.CLIENT)
    public EntityFX getParticle(String string, cuqu cuqu2, double d, double d2, double d3) {
        tuor tuor2 = tuor._E();
        return !string.equals("mobSpell") && !string.equals("mobSpellAmbient") ? null : (string.equals("heart") ? new EntityHeartFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("slime") ? new EntityBreakingFX(cuqu2, d, d2, d3, jhvs.field_77761_aM) : (string.equals("snowshovel") ? new EntitySnowShovelFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("dripLava") ? new EntityDropParticleFX(cuqu2, d, d2, d3, ccfp._i) : (string.equals("dripWater") ? new EntityDropParticleFX(cuqu2, d, d2, d3, ccfp._h) : (string.equals("snowballpoof") ? new EntityBreakingFX(cuqu2, d, d2, d3, jhvs.field_77768_aD) : (string.equals("reddust") ? new EntityReddustFX(cuqu2, d, d2, d3, 0.01f, 0.01f, 0.01f) : (string.equals("cloud") ? new EntityCloudFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("largesmoke") ? new EntitySmokeFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01, 2.5f) : (string.equals("splash") ? new EntitySplashFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("footstep") ? new EntityFootStepFX(tuor2._f, cuqu2, d, d2, d3) : (string.equals("lava") ? new EntityLavaFX(cuqu2, d, d2, d3) : (string.equals("flame") ? new EntityFlameFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("explode") ? new EntityExplodeFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("enchantmenttable") ? new EntityEnchantmentTableParticleFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("portal") ? new EntityPortalFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("note") ? new EntityNoteFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("spell") ? new EntitySpellParticleFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("smoke") ? new EntitySmokeFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("crit") ? new EntityCritFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("townaura") ? new EntityAuraFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("depthsuspend") ? new EntityAuraFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("suspended") ? new EntitySuspendFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("bubble") ? new EntityBubbleFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("fireworksSpark") ? new EntityFireworkSparkFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01, tuor2._u) : (string.equals("largeexplode") ? new EntityLargeExplodeFX(tuor2._f, cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : (string.equals("hugeexplosion") ? new EntityHugeExplodeFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01) : new EntitySpellParticleFX(cuqu2, d, d2, d3, 0.01, 0.01, 0.01))))))))))))))))))))))))))));
    }
}

