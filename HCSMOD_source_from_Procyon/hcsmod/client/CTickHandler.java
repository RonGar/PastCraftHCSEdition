// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.idqh;
import net.minecraft.util.samw;
import hcsmod.entity.EntityCorpse;
import co.uk.flansmods.common.driveables.EntityWheel;
import java.io.IOException;
import java.io.File;
import javax.management.AttributeList;
import javax.management.Attribute;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import vintarz.core.VCP;
import java.util.Iterator;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import hcsmod.client.gui.GuiClanSystem;
import org.lwjgl.input.Keyboard;
import hcsmod.surrond.HcsSurround;
import hcsmod.client.gui.GuiSpawnSelect;
import hcsmod.HcsInteract;
import hcsmod.entity.EntityPalatka;
import hcsmod.entity.EntityHouseCommon;
import hcsmod.player.Detectibility;
import hcsmod.items.ItemKoster;
import mcheli.MCH_ClientCommonTickHandler;
import net.minecraft.entity.player.EntityPlayer;
import hcsmod.items.ItemPalatka;
import net.minecraft.util.dwbg;
import trentv4.advanceddarkness.core.DummyContainerAdvancedDarkness;
import hcsmod.blocks.BlockModdedLeaves;
import hcsmod.HCS;
import hcsmod.player.ExtendedPlayer;
import hcsmod.client.hud.DayZHud;
import org.lwjgl.input.Mouse;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import net.minecraft.client.tuor;
import net.minecraft.entity.EntityLivingBase;
import java.util.Random;
import net.minecraft.client.entity.AbstractClientPlayer;
import cpw.mods.fml.common.ITickHandler;

public class CTickHandler implements ITickHandler
{
    static int juggerLabel;
    public static byte detect_level;
    public static int shootTime;
    private static byte timer;
    private static boolean playerExisted;
    private static AbstractClientPlayer menuPlayer;
    private static boolean firstTick;
    private static boolean gl;
    private static final Random rng;
    private static int shake_counter;
    private static float shake_x;
    private static float shake_y;
    private static int lastPotionDuration;
    private static long nextRes;
    public static int overrideDimensionId;
    
    public static EntityLivingBase menuPlayer() {
        if (CTickHandler.menuPlayer == null) {
            CTickHandler.menuPlayer = new AbstractClientPlayer(tuor._E()._P()._a());
        }
        return (EntityLivingBase)CTickHandler.menuPlayer;
    }
    
    public void tickStart(final EnumSet<TickType> set, final Object... array) {
        if (set.contains(TickType.RENDER)) {
            HcsClient.wasLeftMousePressed = HcsClient.leftMousePressed;
            HcsClient.leftMousePressed = Mouse.isButtonDown(0);
            DayZHud.renderStart();
            tuor._E()._K.__aV = false;
            final ctpu p2 = tuor._E()._p;
            if (p2 != null) {
                ((cuqu)p2).field_73011_w._i = CTickHandler.overrideDimensionId;
            }
        }
        else if (set.contains(TickType.CLIENT)) {
            final tuor e = tuor._E();
            final kldu func_70660_b;
            if (CTickHandler.lastPotionDuration >= 0 && e._r != null && (func_70660_b = e._r.func_70660_b(lodj.field_76439_r)) != null) {
                func_70660_b.field_76460_b = CTickHandler.lastPotionDuration;
            }
            if (e._p == null) {
                HcsClient.placeHouse = false;
                HcsClient.server = "null";
                HcsClient.customArmor = null;
                HcsClient.isPVPserver = false;
                HcsClient.isLiteserver = false;
                HcsClient.isHarXserver = false;
                ExtendedPlayer.cExPlayers.clear();
                HcsClient.overheat = 0.0f;
            }
            if (CTickHandler.shootTime > 0) {
                --CTickHandler.shootTime;
            }
            if (CTickHandler.firstTick) {
                HCS.applyBlockMods();
                CTickHandler.firstTick = false;
            }
            final boolean q = e._K._q;
            if (q != CTickHandler.gl) {
                BlockModdedLeaves.instance.func_72133_a(q);
                CTickHandler.gl = q;
            }
            if (CTickHandler.juggerLabel > 0) {
                --CTickHandler.juggerLabel;
            }
            if (rojd.instance().getClient()._p != null) {
                try {
                    DummyContainerAdvancedDarkness.cwt = (int)(rojd.instance().getClient()._p.func_72820_D() % 24000L);
                }
                catch (Throwable t) {}
            }
            if (++CTickHandler.timer > 100) {
                CTickHandler.timer = 0;
                for (int size = ServerList.servers.size(), i = 0; i < size; ++i) {
                    ServerList.servers.get(i)._h = false;
                }
            }
            final EntityClientPlayerMP r = tuor._E()._r;
            if (r != null) {
                DayZHud.debug.put("posY", Integer.toString(dwbg._c(((EntityPlayer)r).field_70121_D.field_72338_b)));
                DayZHud.debug.put("r_Yaw", Integer.toString(dwbg._c((double)((EntityPlayer)r).field_70177_z)));
                if (HcsClient.placeHouse) {
                    if (((EntityPlayer)r).func_71045_bC() != null) {
                        HcsClient.placeHouse = false;
                    }
                    else {
                        ItemPalatka.palatkaClient(new ieta(HCS.Palatka.field_77779_bT, 1, 1), ((EntityPlayer)r).field_70170_p, (EntityPlayer)r);
                    }
                }
                int n = 0;
                float n2;
                if (e._z instanceof tuwd) {
                    n2 = 0.0f;
                }
                else if (HcsClient.overheat > 0.0f) {
                    n2 = 0.07f * HcsClient.overheat;
                    n = CTickHandler.rng.nextInt(20) + 20;
                }
                else if (HcsClient.overheat < 0.0f) {
                    n2 = -0.25f * HcsClient.overheat;
                    n = 1;
                }
                else {
                    n2 = 0.0f;
                }
                if (n2 > 0.0f) {
                    if (++CTickHandler.shake_counter >= n) {
                        CTickHandler.shake_x = CTickHandler.rng.nextFloat() - 0.5f;
                        CTickHandler.shake_y = CTickHandler.rng.nextFloat() - 0.5f;
                        Label_0605: {
                            Label_0596: {
                                if (CTickHandler.rng.nextBoolean()) {
                                    if (CTickHandler.shake_x < 0.0f) {
                                        break Label_0596;
                                    }
                                }
                                else if (CTickHandler.shake_x <= 0.0f) {
                                    break Label_0596;
                                }
                                CTickHandler.shake_x += 0.5f;
                                break Label_0605;
                            }
                            CTickHandler.shake_x -= 0.5f;
                        }
                        Label_0654: {
                            Label_0645: {
                                if (CTickHandler.rng.nextBoolean()) {
                                    if (CTickHandler.shake_y < 0.0f) {
                                        break Label_0645;
                                    }
                                }
                                else if (CTickHandler.shake_y <= 0.0f) {
                                    break Label_0645;
                                }
                                CTickHandler.shake_y += 0.5f;
                                break Label_0654;
                            }
                            CTickHandler.shake_y -= 0.5f;
                        }
                        CTickHandler.shake_x *= n2;
                        CTickHandler.shake_y *= n2;
                        CTickHandler.shake_counter = 0;
                    }
                    final EntityPlayer entityPlayer = (EntityPlayer)r;
                    entityPlayer.field_70125_A += CTickHandler.shake_x;
                    final EntityPlayer entityPlayer2 = (EntityPlayer)r;
                    entityPlayer2.field_70177_z += CTickHandler.shake_y;
                    MCH_ClientCommonTickHandler.mouseDeltaPrevX = ((EntityPlayer)r).field_70177_z;
                    MCH_ClientCommonTickHandler.mouseDeltaPrevY = ((EntityPlayer)r).field_70125_A;
                }
                if (!((EntityPlayer)r).func_70093_af()) {
                    final double n3 = dwbg._c(((EntityPlayer)r).field_70121_D.field_72338_b);
                    if (((EntityPlayer)r).field_70121_D.field_72338_b > n3 + 0.45) {
                        ((EntityPlayer)r).field_70138_W = (float)(n3 + 1.0 - ((EntityPlayer)r).field_70121_D.field_72338_b);
                    }
                    else {
                        ((EntityPlayer)r).field_70138_W = 1.0f;
                    }
                }
                else {
                    ((EntityPlayer)r).field_70138_W = 0.5f;
                }
                if (HcsClient.server == null || !HcsClient.server.contains(" RPG ")) {
                    if (((EntityPlayer)r).field_70165_t > 4460.0) {
                        ((EntityPlayer)r).field_70165_t = 4450.0;
                    }
                    if (((EntityPlayer)r).field_70165_t < -4460.0) {
                        ((EntityPlayer)r).field_70165_t = -4450.0;
                    }
                    if (((EntityPlayer)r).field_70161_v > 4460.0) {
                        ((EntityPlayer)r).field_70161_v = 4450.0;
                    }
                    if (((EntityPlayer)r).field_70161_v < -4460.0) {
                        ((EntityPlayer)r).field_70161_v = -4450.0;
                    }
                }
                final ieta func_71045_bC = ((EntityPlayer)r).func_71045_bC();
                if (func_71045_bC != null) {
                    if (func_71045_bC._a() instanceof ItemPalatka) {
                        ItemPalatka.palatkaClient(func_71045_bC, ((EntityPlayer)r).field_70170_p, (EntityPlayer)r);
                    }
                    else if (func_71045_bC._a() instanceof ItemKoster) {
                        ItemKoster.KosterClient(func_71045_bC, ((EntityPlayer)r).field_70170_p, (EntityPlayer)r);
                    }
                }
                if (((EntityPlayer)r).func_70660_b(lodj.field_76439_r) != null && ((EntityPlayer)r).func_70660_b(lodj.field_76439_r).field_76460_b <= 0) {
                    ((EntityPlayer)r).func_70618_n(lodj.field_76439_r.func_76396_c());
                }
                CTickHandler.detect_level = Detectibility.update((EntityPlayer)r);
                HcsClient.interactTarget = null;
                if (((EntityPlayer)r).field_70154_o instanceof EntityHouseCommon || ((EntityPlayer)r).field_70154_o instanceof EntityPalatka) {
                    HcsClient.interactTarget = HcsInteract.$(((EntityPlayer)r).field_70154_o, HcsInteract.OPEN_INVENTORY);
                }
                else if (e._z == null && ((EntityPlayer)r).field_70154_o == null) {
                    HcsClient.interactTarget = getTargetObject(((EntityPlayer)r).field_70170_p, (EntityPlayer)r);
                }
                if (((EntityPlayer)r).func_70089_S() && ((EntityPlayer)r).field_70165_t * ((EntityPlayer)r).field_70165_t + (((EntityPlayer)r).field_70163_u - 1.0) * (((EntityPlayer)r).field_70163_u - 1.0) + ((EntityPlayer)r).field_70161_v * ((EntityPlayer)r).field_70161_v <= 25.0 && tuor._E()._z != GuiSpawnSelect.instance && zgmv._H() == null) {
                    tuor._E()._a((dwms)GuiSpawnSelect.instance());
                }
                for (int j = 0; j < 5; ++j) {
                    menuPlayer().func_70062_b(j, ((EntityPlayer)r).func_71124_b(j));
                }
                if (((EntityPlayer)r).field_70173_aa % 5 == 0) {
                    CTickHandler.menuPlayer.func_70037_a(savePlayer((EntityPlayer)r));
                }
                if (((EntityPlayer)r).field_70737_aN > 0) {
                    HcsClient.lastDamage = System.currentTimeMillis();
                }
                HcsSurround.tick();
                if (!((EntityPlayer)r).field_70170_p.field_72996_f.contains(InteractableRenderDummy.instance)) {
                    ((EntityPlayer)r).field_70170_p.field_72996_f.add(InteractableRenderDummy.instance);
                }
            }
            final boolean playerExisted = r != null;
            if (!playerExisted && CTickHandler.playerExisted) {
                savePlayer((EntityPlayer)CTickHandler.menuPlayer);
            }
            if (!(CTickHandler.playerExisted = playerExisted)) {
                final EntityLivingBase menuPlayer = menuPlayer();
                ++menuPlayer.field_70173_aa;
                if (menuPlayer().field_70737_aN > 0) {
                    final EntityLivingBase menuPlayer2 = menuPlayer();
                    --menuPlayer2.field_70737_aN;
                }
            }
            if (CClanSystem.CLANSYSTEM_ENABLED && Keyboard.isKeyDown(61)) {
                if (e._z instanceof GuiClanSystem) {
                    final GuiClanSystem guiClanSystem = (GuiClanSystem)e._z;
                    guiClanSystem.action = null;
                    guiClanSystem.func_73866_w_();
                }
                else if (e._z == null) {
                    e._a((dwms)new GuiClanSystem());
                    e._K.__bv = false;
                }
            }
            else if (!CClanSystem.CLANSYSTEM_ENABLED && e._z instanceof GuiClanSystem) {
                e._a((dwms)null);
            }
        }
        else if (set.contains(TickType.PLAYER) && array[0] == tuor._E()._r) {
            tuor._E();
            if (HcsClient.hitCooldown > 0) {
                --HcsClient.hitCooldown;
            }
            HcsClient.prevFlansHealCooldown = HcsClient.flansHealCooldown;
            if (HcsClient.flansHealCooldown > 0) {
                --HcsClient.flansHealCooldown;
            }
            final tuor e2 = tuor._E();
            final EntityClientPlayerMP r2 = e2._r;
            if (((EntityPlayer)r2).field_71092_bJ.equals("VinTarZ") && Keyboard.isKeyDown(184)) {
                Entity entity = null;
                for (final Entity next : e2._p.field_72996_f) {
                    if (next instanceof EntityOtherPlayerMP) {
                        entity = next;
                        break;
                    }
                }
                if (entity != null) {
                    e2._r.field_70177_z = -(float)Math.toDegrees(Math.atan2(entity.field_70165_t - ((EntityPlayer)r2).field_70165_t, entity.field_70161_v - ((EntityPlayer)r2).field_70161_v));
                }
            }
        }
    }
    
    public void tickEnd(final EnumSet<TickType> set, final Object... array) {
        if (set.contains(TickType.CLIENT)) {
            DiscordHelper.discordTick();
            DayZHud.tickHints();
            VCP vcp;
            while ((vcp = HcsClient.sendAfterTick.poll()) != null) {
                vcp.send();
            }
            final tuor e = tuor._E();
            if (e._r != null) {
                InteractableRenderDummy.instance.func_70107_b(e._r.field_70165_t, e._r.field_70163_u, e._r.field_70161_v);
            }
            final kldu func_70660_b;
            if (e._r != null && (func_70660_b = e._r.func_70660_b(lodj.field_76439_r)) != null) {
                CTickHandler.lastPotionDuration = func_70660_b.field_76460_b;
                func_70660_b.field_76460_b = 500;
            }
            else {
                CTickHandler.lastPotionDuration = -1;
            }
            if (e._p != null) {
                DayZHud.debug.put("LoadedEntities", String.valueOf(e._p.field_72996_f.size()));
            }
            if (HcsClient.resWarning && tuor._E()._K._p == 0) {
                final long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis > CTickHandler.nextRes) {
                    CTickHandler.nextRes = currentTimeMillis + 1000L;
                    HcsClient.resWarn = (getProcessCpuLoad() < 0.8 / Runtime.getRuntime().availableProcessors());
                }
            }
            else {
                HcsClient.resWarn = false;
            }
        }
        else if (set.contains(TickType.RENDER)) {
            DayZHud.renderEnd();
            CEventHandler.renderedPlayer = null;
            final ctpu p2 = rojd.instance().getClient()._p;
            if (p2 != null) {
                int n = (int)(((cuqu)p2).func_72820_D() % 24000L);
                float n2;
                if (n < 12000) {
                    n2 = 1.0f;
                }
                else if (n < 13800) {
                    n -= 12000;
                    n2 = 1.0f - n / 900.0f;
                }
                else if (n > 22200) {
                    n -= 22200;
                    n2 = -1.0f + n / 900.0f;
                }
                else {
                    n2 = -1.0f;
                }
                if (n2 > 0.0f) {
                    n2 *= 0.5;
                }
                tuor._E()._K.__bF = (HcsClient.isHarXserver ? n2 : 0.5f);
            }
        }
    }
    
    public static double getProcessCpuLoad() {
        try {
            final AttributeList attributes = ManagementFactory.getPlatformMBeanServer().getAttributes(ObjectName.getInstance("java.lang:type=OperatingSystem"), new String[] { "ProcessCpuLoad" });
            if (attributes.isEmpty()) {
                return Double.NaN;
            }
            final Double n = (Double)((ArrayList<Attribute>)attributes).get(0).getValue();
            if (n == -1.0) {
                return 1.0;
            }
            return n;
        }
        catch (Exception ex) {
            return 1.0;
        }
    }
    
    private static hsus savePlayer(final EntityPlayer entityPlayer) {
        final File file = new File(tuor._E()._N, "/saves/player.dat");
        final hsus hsus = new hsus("dummy");
        entityPlayer.func_70014_b(hsus);
        hsus._a("Sleeping", false);
        final hsus hsus2 = new hsus("VINTARZHCSEXINV");
        ExtendedPlayer.client(tuor._E()._P()._a()).saveNBTData(hsus2);
        hsus._a("VINTARZHCSEXINV", hsus2);
        try {
            sbsi._b(hsus, file);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return hsus;
    }
    
    private static Object getTargetObject(final cuqu cuqu, final EntityPlayer entityPlayer) {
        final samw func_70666_h = entityPlayer.func_70666_h(1.0f);
        final samw func_70040_Z = entityPlayer.func_70040_Z();
        final idqh func_72831_a = cuqu.func_72831_a(func_70666_h, cuqu.func_82732_R()._a(func_70666_h._c + func_70040_Z._c * 2.5, func_70666_h._d + func_70040_Z._d * 2.5, func_70666_h._e + func_70040_Z._e * 2.5), false, true);
        final samw a = cuqu.func_82732_R()._a(entityPlayer.field_70165_t, entityPlayer.field_70163_u + entityPlayer.func_70047_e(), entityPlayer.field_70161_v);
        samw samw;
        if (func_72831_a != null) {
            samw = cuqu.func_82732_R()._a(func_72831_a._f._c, func_72831_a._f._d, func_72831_a._f._e);
        }
        else {
            samw = cuqu.func_82732_R()._a(entityPlayer.field_70165_t + func_70040_Z._c * 2.5, entityPlayer.func_70047_e() + entityPlayer.field_70163_u + func_70040_Z._d * 2.5, entityPlayer.field_70161_v + func_70040_Z._e * 2.5);
        }
        double d = samw._d(a);
        Object o = null;
        final List func_72839_b = cuqu.func_72839_b((Entity)entityPlayer, entityPlayer.field_70121_D.func_72314_b(0.25, 0.0, 0.25).func_72321_a(func_70040_Z._c * 3.0, func_70040_Z._d * 3.0, func_70040_Z._e * 3.0));
        for (int i = 0; i < func_72839_b.size(); ++i) {
            final Entity entity = func_72839_b.get(i);
            if (entity != InteractableRenderDummy.instance) {
                if (!(entity instanceof EntityWheel)) {
                    net.minecraft.util.rojd rojd = entity.field_70121_D;
                    if (entity instanceof EntityCorpse) {
                        rojd = rojd.func_72314_b(0.25, 0.0, 0.25);
                    }
                    else if (entity instanceof EntityPlayer) {
                        rojd = rojd.func_72329_c().func_72317_d(0.0, 0.25, 0.0);
                    }
                    final idqh func_72327_a = rojd.func_72327_a(a, samw);
                    if (func_72327_a != null) {
                        final double d2 = a._d(func_72327_a._f);
                        if (d2 < d) {
                            o = entity;
                            d = d2;
                        }
                    }
                }
            }
        }
        final List<HcsInteractable> interactables = HcsClient.interactables;
        for (int j = 0; j < interactables.size(); ++j) {
            final HcsInteractable hcsInteractable = interactables.get(j);
            final net.minecraft.util.rojd boundingBox = hcsInteractable.boundingBox();
            if (entityPlayer.func_70092_e((boundingBox.field_72340_a + boundingBox.field_72336_d) / 2.0, (boundingBox.field_72338_b + boundingBox.field_72337_e) / 2.0, (boundingBox.field_72339_c + boundingBox.field_72334_f) / 2.0) <= 16.0) {
                final idqh func_72327_a2 = boundingBox.func_72327_a(a, samw);
                if (func_72327_a2 != null) {
                    final double d3 = a._d(func_72327_a2._f);
                    if (d3 < d) {
                        o = hcsInteractable;
                        d = d3;
                    }
                }
            }
        }
        return HcsInteract.findInteractable(func_72831_a, o, tuor._E()._J, cuqu);
    }
    
    static void loadPlayer() {
        try {
            final hsus a = sbsi._a(new File(tuor._E()._N, "/saves/player.dat"));
            if (a == null) {
                return;
            }
            a._a("Sleeping", false);
            a._a("SleepTimer", (short)0);
            (CTickHandler.menuPlayer = new AbstractClientPlayer(tuor._E()._P()._a())).func_70037_a(a);
            ExtendedPlayer.client(tuor._E()._P()._a()).loadNBTData(a._m("VINTARZHCSEXINV"));
        }
        catch (Throwable t) {}
    }
    
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT, TickType.RENDER, TickType.PLAYER);
    }
    
    public String getLabel() {
        return "HCS Client TH";
    }
    
    static {
        CTickHandler.juggerLabel = 0;
        CTickHandler.detect_level = 0;
        CTickHandler.shootTime = 0;
        CTickHandler.timer = 0;
        CTickHandler.firstTick = true;
        CTickHandler.gl = false;
        rng = new Random();
        CTickHandler.overrideDimensionId = 0;
    }
}
