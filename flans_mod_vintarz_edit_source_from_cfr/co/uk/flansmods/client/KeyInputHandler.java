/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  bpzx
 *  bpzx$uxsf
 *  cpw.mods.fml.common.TickType
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  dwms
 *  hbei
 *  maaq
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  uyla
 */
package co.uk.flansmods.client;

import co.uk.flansmods.api.IControllable;
import co.uk.flansmods.client.FlansModClient;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.network.PacketGunModButton;
import co.uk.flansmods.common.network.PacketReload;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.EnumSet;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

@SideOnly(value=Side.CLIENT)
public class KeyInputHandler
extends bpzx.uxsf {
    private static final tuor mc = tuor._E();
    public static hbei accelerateKey = KeyInputHandler.mc._K.__bd;
    public static hbei decelerateKey = KeyInputHandler.mc._K.__bf;
    public static hbei leftKey = KeyInputHandler.mc._K.__be;
    public static hbei rightKey = KeyInputHandler.mc._K.__bg;
    public static hbei upKey = KeyInputHandler.mc._K.__bh;
    public static hbei exitKey = KeyInputHandler.mc._K.__bl;
    public static hbei gunKey = KeyInputHandler.mc._K.__bm;
    public static hbei reloadKey;
    public static hbei inventoryKey;
    protected static hbei openGunModKey;

    public KeyInputHandler() {
        super(new hbei[]{reloadKey, openGunModKey}, new boolean[]{false, false});
    }

    public String getLabel() {
        return "Flan Control key Ticker";
    }

    public void keyDown(EnumSet enumSet, hbei hbei2, boolean bl, boolean bl2) {
        if (KeyInputHandler.mc._z == null && !bl) {
            boolean bl3;
            int n = -1;
            EntityClientPlayerMP entityClientPlayerMP = KeyInputHandler.mc._r;
            Entity entity = entityClientPlayerMP.field_70154_o;
            if (entity instanceof EntitySeat) {
                if (hbei2 == accelerateKey) {
                    n = 0;
                } else if (hbei2 == decelerateKey) {
                    n = 1;
                } else if (hbei2 == leftKey) {
                    n = 2;
                } else if (hbei2 == rightKey) {
                    n = 3;
                } else if (hbei2 == upKey) {
                    n = 4;
                } else if (hbei2 == exitKey) {
                    n = 6;
                } else if (hbei2 == inventoryKey) {
                    n = 7;
                } else if (hbei2 == gunKey) {
                    n = 9;
                }
            }
            if (hbei2 == reloadKey && !(entity instanceof EntitySeat) && FlansModClient.clientPlayerData.shootTime <= 0) {
                PacketDispatcher.sendPacketToServer((maaq)PacketReload.buildReloadPacket());
                return;
            }
            if (hbei2 == openGunModKey) {
                PacketDispatcher.sendPacketToServer((maaq)PacketGunModButton.buildButtonOpenGuiPacket());
            }
            if (entity != null && entity instanceof IControllable) {
                hbei[] arrhbei = (hbei[])entity;
                if (hbei2._d == KeyInputHandler.mc._K.__bi._d) {
                    KeyInputHandler.mc._K.__bi._e = false;
                    KeyInputHandler.mc._K.__bi._f = 0;
                }
                bl3 = arrhbei.pressKey(n, (EntityPlayer)entityClientPlayerMP);
            } else {
                bl3 = false;
            }
            if (!bl3) {
                for (hbei hbei3 : KeyInputHandler.mc._K.__br) {
                    if (hbei2._d != hbei3._d || hbei3 == hbei2) continue;
                    hbei3._e = true;
                    hbei3._f = 1;
                }
            }
        }
    }

    public void keyUp(EnumSet enumSet, hbei hbei2, boolean bl) {
        if (!bl) {
            for (hbei hbei3 : KeyInputHandler.mc._K.__br) {
                if (hbei2._d != hbei3._d || hbei3 == hbei2) continue;
                hbei3._e = false;
            }
        }
    }

    public EnumSet ticks() {
        return EnumSet.of(TickType.CLIENT);
    }

    static {
        inventoryKey = reloadKey = new hbei("Reload key", 19);
        openGunModKey = new hbei("Open Gun Mod", 22);
    }
}

