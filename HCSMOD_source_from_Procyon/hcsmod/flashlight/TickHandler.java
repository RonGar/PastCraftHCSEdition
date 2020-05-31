// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.flashlight;

import java.util.HashMap;
import net.minecraft.util.idqh;
import net.minecraft.util.samw;
import net.minecraft.util.dwbg;
import co.uk.flansmods.common.guns.FlansModExplosion;
import hcsmod.server.HcsServer;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import net.minecraft.client.tuor;
import hcsmod.player.ExtendedPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import java.util.Map;
import cpw.mods.fml.common.ITickHandler;

public class TickHandler implements ITickHandler
{
    public static final Map<String, FlashlightClient.LightPoint[]> lightPoints;
    static int ticks;
    
    public void tickStart(final EnumSet<TickType> set, final Object... array) {
    }
    
    public void tickEnd(final EnumSet<TickType> set, final Object... array) {
        if (set.contains(TickType.PLAYER)) {
            final EntityPlayer entityPlayer = (EntityPlayer)array[0];
            tickFlashlight(entityPlayer, entityPlayer.func_71045_bC());
            tickFlashlight(entityPlayer, ((FMLLaunchHandler.side() == Side.CLIENT) ? ExtendedPlayer.client(entityPlayer.field_71092_bJ) : ExtendedPlayer.server(entityPlayer)).inventory.inventoryStacks[4]);
        }
        else if (set.contains(TickType.CLIENT)) {
            this.tickClient();
        }
    }
    
    @SideOnly(Side.CLIENT)
    private void tickClient() {
        final ctpu p = tuor._E()._p;
        if (p == null || FlashlightClient.lastWorld != p) {
            FlashlightClient.lightList.clear();
            TickHandler.lightPoints.clear();
        }
        else if (TickHandler.ticks-- <= 0) {
            TickHandler.ticks = ((tuor._S > 120) ? 1 : ((tuor._S > 60) ? 2 : ((tuor._S > 30) ? 3 : 4)));
            final int length;
            int i = 0;
            TickHandler.lightPoints.values().removeIf(array -> {
                length = array.length;
                while (i < length) {
                    if (!array[i].isDead()) {
                        return false;
                    }
                    else {
                        ++i;
                    }
                }
                return true;
            });
            final Iterator<FlashlightClient.LightPoint> iterator = FlashlightClient.lightList.iterator();
            while (iterator.hasNext()) {
                final FlashlightClient.LightPoint lightPoint = iterator.next();
                if (lightPoint != null && lightPoint.onUpdate((cuqu)p)) {
                    iterator.remove();
                    ((cuqu)p).func_72936_c(cuqm._b, lightPoint.getX(), lightPoint.getY(), lightPoint.getZ());
                }
            }
        }
    }
    
    private static void tickFlashlight(final EntityPlayer entityPlayer, final ieta ieta) {
        if (ieta != null && ieta._a() == Flashlight.flashlight) {
            if (ieta._q() == null) {
                ieta._d(new hsus());
            }
            if (!entityPlayer.field_70170_p.field_72995_K) {
                HcsServer.tickFlashlight(ieta);
            }
            else {
                tickFlashLightClient(ieta, entityPlayer.field_70170_p, entityPlayer);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public static void tickFlashLightClient(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if ((entityPlayer == tuor._E()._r || FlashlightClient.seeOtherPlayers()) && ieta._q() != null && ieta._q()._f("F") != 0) {
            if (!TickHandler.lightPoints.containsKey(entityPlayer.field_71092_bJ)) {
                TickHandler.lightPoints.put(entityPlayer.field_71092_bJ, new FlashlightClient.LightPoint[] { new FlashlightClient.LightPoint(5.0f), new FlashlightClient.LightPoint(10.0f), new FlashlightClient.LightPoint(15.0f) });
            }
            final samw func_70040_Z = entityPlayer.func_70040_Z();
            samw a = cuqu.func_82732_R()._a(entityPlayer.field_70165_t, entityPlayer.field_70163_u + entityPlayer.func_70047_e(), entityPlayer.field_70161_v);
            for (final FlashlightClient.LightPoint lightPoint : TickHandler.lightPoints.get(entityPlayer.field_71092_bJ)) {
                if (TickHandler.ticks != 0) {
                    lightPoint.update();
                }
                else {
                    final samw a2 = cuqu.func_82732_R()._a(entityPlayer.field_70165_t + func_70040_Z._c * lightPoint.distance, entityPlayer.field_70163_u + func_70040_Z._d * lightPoint.distance + entityPlayer.func_70047_e(), entityPlayer.field_70161_v + func_70040_Z._e * lightPoint.distance);
                    final idqh rayTraceBlocks = FlansModExplosion.rayTraceBlocks(cuqu, a, a2, (Object)null);
                    a = a2;
                    if (rayTraceBlocks != null) {
                        final int e = rayTraceBlocks._e;
                        int b = rayTraceBlocks._b;
                        int c = rayTraceBlocks._c;
                        int d = rayTraceBlocks._d;
                        if (cuqu.func_72804_r(b, c, d)) {
                            if (e == 0) {
                                --c;
                            }
                            else if (e == 1) {
                                ++c;
                            }
                            else if (e == 2) {
                                --d;
                            }
                            else if (e == 3) {
                                ++d;
                            }
                            else if (e == 4) {
                                --b;
                            }
                            else if (e == 5) {
                                ++b;
                            }
                        }
                        lightPoint.update(b, c, d);
                        return;
                    }
                    lightPoint.update(dwbg._c(a2._c), dwbg._c(a2._d), dwbg._c(a2._e));
                }
            }
        }
    }
    
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.PLAYER, TickType.CLIENT);
    }
    
    public String getLabel() {
        return "FlashLight TickHandler";
    }
    
    static {
        lightPoints = new HashMap<String, FlashlightClient.LightPoint[]>();
        TickHandler.ticks = 0;
    }
}
