/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cccu
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.ObfuscationReflectionHelper
 *  cpw.mods.fml.common.network.IPacketHandler
 *  cpw.mods.fml.common.network.NetworkRegistry
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.common.registry.TickRegistry
 *  cpw.mods.fml.relauncher.Side
 *  ctpu
 *  cuqu
 *  dfsc
 *  dwms
 *  dycj
 *  hbei
 *  hcsmod.client.hud.DayZHud
 *  hcsmod.client.hud.DayZHud$Hint
 *  hrvk
 *  ieta
 *  jhvs
 *  jiqw
 *  kjsv
 *  kkfb
 *  maaq
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.particle.EntityDiggingFX
 *  net.minecraft.client.particle.EntityFX
 *  net.minecraft.client.particle.uxsf
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.jgtk
 *  net.minecraft.util.samw
 *  net.minecraftforge.common.bpzx
 *  net.minecraftforge.event.eidl
 *  net.minecraftforge.event.kjuq
 *  org.lwjgl.opengl.GL11
 *  owus
 *  rojd
 *  twod
 *  uyla
 *  vintarz.core.VCore
 *  wngx
 *  xryw
 *  xrzg
 *  xrzg$eidn
 */
package co.uk.flansmods.client;

import co.uk.flansmods.api.IControllable;
import co.uk.flansmods.client.GuiDriveableController;
import co.uk.flansmods.client.GuiTeamScores;
import co.uk.flansmods.client.TickHandlerClient;
import co.uk.flansmods.client.model.GunAnimations;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.IScope;
import co.uk.flansmods.common.guns.ItemGun;
import co.uk.flansmods.common.network.PacketAiming;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.vintarz.EntityTraceFX;
import co.uk.flansmods.vintarz.Util;
import co.uk.flansmods.vintarz.VPrecisePing;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import hcsmod.client.hud.DayZHud;
import java.io.File;
import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.uxsf;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.jgtk;
import net.minecraft.util.samw;
import net.minecraftforge.common.bpzx;
import net.minecraftforge.event.eidl;
import net.minecraftforge.event.kjuq;
import org.lwjgl.opengl.GL11;
import vintarz.core.VCore;

public class FlansModClient
extends FlansMod {
    public static boolean doneTutorial = false;
    public static boolean controlModeMouse = false;
    public static int controlModeSwitchTimer = 20;
    public static float recoilUp;
    public static float recoilSide;
    public static int recoilTicks;
    public static int recoilSwitch;
    public static boolean recoilLeft;
    public static float recoilDirection;
    public static float recoilDampen;
    public static HashMap gunAnimations;
    public static int scopeTime;
    public static IScope currentScope;
    public static float zoomProgress;
    public static float lastZoomProgress;
    public static float lastZoomLevel;
    public static float lastFOVZoomLevel;
    public static float originalMouseSensitivity;
    public static float originalFOV;
    public static int originalThirdPerson;
    public static boolean inPlane;
    public static tuor minecraft;
    public static final FlansModPlayerData clientPlayerData;
    public static boolean sync;
    public static boolean bipod;
    public static List<EntityBullet> clientBullets;
    public static List<EntityTraceFX> clientTracers;
    public static int pingResponse;
    public static int ticks;
    public static Map<Object, Long> penObjects;

    public void load() {
        if (FlansMod.ABORT) {
            FlansModClient.log("Failed to load dependencies! Not loading Flan's Mod.");
        } else {
            FlansModClient.log("Loading Flan's mod.");
            bpzx.EVENT_BUS.register((Object)this);
            TickRegistry.registerTickHandler((ITickHandler)VPrecisePing.VPrecisePing, (Side)Side.CLIENT);
            NetworkRegistry.instance().registerChannel((IPacketHandler)VPrecisePing.VPrecisePing, "P", Side.CLIENT);
        }
    }

    @kjuq
    public void $(twod twod2) {
        for (String[] arrstring : Util.material_sounds) {
            for (int i = 0; i < arrstring.length; ++i) {
                twod2.manager._a(arrstring[i] + ".ogg");
                arrstring[i] = arrstring[i].replace("/", ".");
            }
        }
    }

    @kjuq
    public void renderLiving(xrzg.eidn eidn2) {
        owus.NAME_TAG_RANGE = 64.0f;
        owus.NAME_TAG_RANGE_SNEAK = 32.0f;
        if (eidn2.entity instanceof EntityPlayer && GuiTeamScores.gametype != null && !"No Gametype".equals(GuiTeamScores.gametype)) {
            Team team;
            GuiTeamScores.PlayerData playerData = GuiTeamScores.getPlayerData(eidn2.entity.func_70023_ak());
            GuiTeamScores.PlayerData playerData2 = GuiTeamScores.getPlayerData(FlansModClient.minecraft._r.field_71092_bJ);
            Team team2 = playerData == null ? Team.spectators : playerData.team.team;
            Team team3 = team = playerData2 == null ? Team.spectators : playerData2.team.team;
            if (team == Team.spectators) {
                return;
            }
            if (team2 == Team.spectators) {
                eidn2.setCanceled(true);
                return;
            }
            if (team2 != team) {
                owus.NAME_TAG_RANGE = 0.0f;
                owus.NAME_TAG_RANGE_SNEAK = 0.0f;
                return;
            }
            if (!GuiTeamScores.sortedByTeam) {
                owus.NAME_TAG_RANGE = 0.0f;
                owus.NAME_TAG_RANGE_SNEAK = 0.0f;
                return;
            }
        }
    }

    @kjuq
    public void $(xryw xryw2) {
        EntityClientPlayerMP entityClientPlayerMP = tuor._E()._r;
        if (entityClientPlayerMP != null) {
            float f = entityClientPlayerMP.field_70177_z;
            float f2 = zoomProgress;
            float f3 = 1.0f - f2;
            entityClientPlayerMP.field_71163_h *= f3;
            entityClientPlayerMP.field_71163_h += f * f2;
            entityClientPlayerMP.field_71154_f *= f3;
            entityClientPlayerMP.field_71154_f += f * f2;
            f = entityClientPlayerMP.field_70125_A;
            f2 = zoomProgress;
            f3 = 1.0f - f2;
            entityClientPlayerMP.field_71164_i *= f3;
            entityClientPlayerMP.field_71164_i += f * f2;
            entityClientPlayerMP.field_71155_g *= f3;
            entityClientPlayerMP.field_71155_g += f * f2;
        }
        if (clientTracers.isEmpty()) {
            return;
        }
        if (EntityBullet.FOOL) {
            GL11.glColor4f((float)1.0f, (float)0.0f, (float)1.0f, (float)1.0f);
        } else {
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)0.0f, (float)1.0f);
        }
        GL11.glEnable((int)32826);
        wngx._a((int)wngx._b, (float)240.0f, (float)240.0f);
        GL11.glDisable((int)3553);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)(-dfsc._d)), (float)((float)(-dfsc._e)), (float)((float)(-dfsc._f)));
        GL11.glPushAttrib((int)11063);
        GL11.glDisable((int)2884);
        GL11.glLineWidth((float)1.0f);
        GL11.glPointSize((float)2.0f);
        Iterator<EntityTraceFX> iterator = clientTracers.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().renderParticleAndDelete(xryw2.partialTicks)) continue;
            iterator.remove();
        }
        GL11.glPopAttrib();
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void tick() {
        Iterator<Long> iterator = penObjects.values().iterator();
        long l = System.currentTimeMillis();
        while (iterator.hasNext()) {
            if (iterator.next() >= l) continue;
            iterator.remove();
        }
        if (FlansModClient.minecraft._r != null) {
            Object object2;
            float f;
            EntityPlayer entityPlayer;
            if (FlansModClient.minecraft._r.field_70154_o instanceof IControllable && FlansModClient.minecraft._z == null) {
                minecraft._a((dwms)new GuiDriveableController((IControllable)FlansModClient.minecraft._r.field_70154_o));
            }
            if (FlansModClient.clientPlayerData.shootTime > 0) {
                --FlansModClient.clientPlayerData.shootTime;
            }
            if (scopeTime > 0) {
                --scopeTime;
            }
            if (recoilSwitch > 0 && ++recoilTicks > recoilSwitch) {
                recoilSwitch = 0;
                recoilTicks = 0;
                boolean bl = recoilLeft = !recoilLeft;
            }
            if (recoilLeft) {
                if (recoilDirection > -1.0f) {
                    float f2;
                    recoilDirection -= 0.05f;
                    if (f2 < -1.0f) {
                        recoilDirection = -1.0f;
                    }
                }
            } else if (recoilDirection < 1.0f) {
                float f3;
                recoilDirection += 0.05f;
                if (f3 > 1.0f) {
                    recoilDirection = 1.0f;
                }
            }
            if ((f = recoilUp - recoilDampen) != 0.0f) {
                if (Math.abs(f) > 0.01f) {
                    recoilDampen += f * 0.19999999f;
                    if (f < 0.0f) {
                        f *= 0.8f;
                    }
                    FlansModClient.minecraft._r.field_70125_A -= f * 0.14142136f;
                } else {
                    recoilDampen = recoilUp;
                }
            }
            FlansModClient.minecraft._r.field_70177_z += recoilSide * recoilDirection * 0.14142136f;
            if (recoilUp != 0.0f) {
                float f4;
                recoilUp *= 0.8f;
                if (f4 < 0.01f) {
                    recoilUp = 0.0f;
                }
            }
            if (recoilSide != 0.0f) {
                float f5;
                recoilSide *= 0.8f;
                if (f5 < 0.01f) {
                    recoilSide = 0.0f;
                }
            }
            for (Object object2 : gunAnimations.values()) {
                ((GunAnimations)object2).update();
            }
            for (Object object2 : FlansModClient.minecraft._p.field_73010_i) {
                entityPlayer = (EntityPlayer)object2;
                ieta ieta2 = entityPlayer.func_71045_bC();
                if (ieta2 == null || !(ieta2._a() instanceof ItemGun)) continue;
                if (entityPlayer == FlansModClient.minecraft._r && FlansModClient.minecraft._K.__bw == 0) {
                    entityPlayer.func_71041_bz();
                    continue;
                }
                entityPlayer.func_71041_bz();
                entityPlayer.func_71008_a(ieta2, 1);
            }
            object2 = null;
            entityPlayer = FlansModClient.minecraft._r.field_71071_by._a();
            if (entityPlayer != null) {
                object2 = entityPlayer._a();
            }
            if (!(currentScope == null || object2 instanceof ItemGun && tuor._E()._z == null && ((ItemGun)object2).type.getCurrentScope((ieta)entityPlayer) == currentScope)) {
                currentScope = null;
                PacketDispatcher.sendPacketToServer((maaq)PacketAiming.buildAimingPacket(false));
                Util.isAimingClient = false;
                FlansModClient.minecraft._K.__bE = originalFOV;
                FlansModClient.minecraft._K._j = originalMouseSensitivity;
                FlansModClient.minecraft._K.__bw = originalThirdPerson;
                scopeTime = 10;
            }
            lastZoomProgress = zoomProgress;
            zoomProgress = currentScope == null ? (zoomProgress *= 0.66f) : 1.0f - (1.0f - zoomProgress) * 0.66f;
            if (FlansModClient.minecraft._r.field_70154_o instanceof IControllable) {
                inPlane = true;
                try {
                    ObfuscationReflectionHelper.setPrivateValue(kkfb.class, (Object)FlansModClient.minecraft._B, (Object)Float.valueOf(((IControllable)FlansModClient.minecraft._r.field_70154_o).getPlayerRoll()), (String[])new String[]{"camRoll", "N", "field_78495_O"});
                }
                catch (Exception exception) {}
                if (FlansModClient.minecraft._r.field_70154_o instanceof IControllable) {
                    try {
                        ObfuscationReflectionHelper.setPrivateValue(kkfb.class, (Object)FlansModClient.minecraft._B, (Object)Float.valueOf(((IControllable)FlansModClient.minecraft._r.field_70154_o).getCameraDistance()), (String[])new String[]{"thirdPersonDistance", "A", "field_78490_B"});
                    }
                    catch (Exception exception) {}
                }
            } else if (inPlane) {
                try {
                    ObfuscationReflectionHelper.setPrivateValue(kkfb.class, (Object)FlansModClient.minecraft._B, (Object)Float.valueOf(0.0f), (String[])new String[]{"camRoll", "N", "field_78495_O"});
                }
                catch (Exception exception) {}
                try {
                    ObfuscationReflectionHelper.setPrivateValue(kkfb.class, (Object)FlansModClient.minecraft._B, (Object)Float.valueOf(4.0f), (String[])new String[]{"thirdPersonDistance", "A", "field_78490_B"});
                }
                catch (Exception exception) {}
                inPlane = false;
            }
            if (controlModeSwitchTimer > 0) {
                --controlModeSwitchTimer;
            }
            if (FlansMod.errorStringTimer > 0) {
                --FlansMod.errorStringTimer;
            }
        }
        if (tuor._E()._p == null) {
            bipod = false;
        }
    }

    public static void renderTick(float f) {
        if (Math.abs(zoomProgress - lastZoomProgress) > 1.0E-4f) {
            float f2 = lastZoomProgress + (zoomProgress - lastZoomProgress) * f;
            float f3 = zoomProgress > 0.8f ? 1.0f : 0.0f;
            double d = f3 * lastZoomLevel + (1.0f - f3);
            float f4 = f2 * lastFOVZoomLevel + (1.0f - f2);
            if (Math.abs(d - 1.0) < 0.009999999776482582) {
                d = 1.0;
            }
            try {
                ObfuscationReflectionHelper.setPrivateValue(kkfb.class, (Object)FlansModClient.minecraft._B, (Object)d, (String[])new String[]{"cameraZoom", "Y", "field_78503_V"});
                FlansModClient.minecraft._K.__bE = ((originalFOV * 40.0f + 70.0f) / f4 - 70.0f) / 40.0f;
            }
            catch (Exception exception) {}
        }
    }

    @kjuq
    public void chatMessage(dycj dycj2) {
        int n;
        String string;
        if (dycj2.message.startsWith("{\"translate\":\"flanDeath.")) {
            String[] arrstring = dycj2.message.split("\\.");
            arrstring[arrstring.length - 1] = arrstring[arrstring.length - 1].split("\"}")[0];
            dycj2.setCanceled(true);
            TickHandlerClient.addKillMessage(arrstring, false);
        } else if (dycj2.message.startsWith("{\"translate\":\"flanDeathH.")) {
            String[] arrstring = dycj2.message.split("\\.");
            arrstring[arrstring.length - 1] = arrstring[arrstring.length - 1].split("\"}")[0];
            dycj2.setCanceled(true);
            TickHandlerClient.addKillMessage(arrstring, true);
        } else if (dycj2.message.startsWith("{\"translate\":\"death.") && (n = dycj2.message.indexOf(string = "\",\"using\":[\"")) != -1) {
            if (!dycj2.message.substring(n += string.length() - 1).contains("\"" + tuor._E()._P()._a() + "\"")) {
                dycj2.setCanceled(true);
            }
            System.out.println(dycj2.message);
        }
    }

    @kjuq
    public void fov(jiqw jiqw2) {
        if (tuor._E()._K.__aG._e) {
            jiqw2.newfov *= 0.5f;
        }
    }

    private boolean checkFileExists(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (Exception exception) {
                FlansMod.log("Failed to create file");
                FlansMod.log(file.getAbsolutePath());
            }
            return false;
        }
        return true;
    }

    public static boolean flipControlMode() {
        if (controlModeSwitchTimer > 0) {
            return false;
        }
        controlModeMouse = !controlModeMouse;
        rojd.instance().getClient()._a((dwms)(controlModeMouse ? new GuiDriveableController((IControllable)rojd.instance().getClient()._r.field_70154_o) : null));
        controlModeSwitchTimer = 40;
        return true;
    }

    public static void reloadModels() {
        for (InfoType infoType : InfoType.infoTypes) {
            infoType.reloadModel();
        }
    }

    public static void penetrationEffects(kjsv kjsv2, idqh idqh2, Object object) {
        if (penObjects.containsKey(object)) {
            return;
        }
        penObjects.put(object, System.currentTimeMillis() + 125L);
        float f = (float)idqh2._f._c;
        float f2 = (float)idqh2._f._d;
        float f3 = (float)idqh2._f._e;
        tuor._E()._L._a(kjsv2.field_72020_cn._c(), f, f2, f3, 1.0f, 1.0f);
        ctpu ctpu2 = tuor._E()._p;
        int n = idqh2._b;
        int n2 = idqh2._c;
        int n3 = idqh2._d;
        for (int i = 0; i < 4; ++i) {
            ctpu2.func_72798_a(n, n2, n3);
            int n4 = ctpu2.func_72805_g(n, n2, n3);
            EntityDiggingFX entityDiggingFX = new EntityDiggingFX((cuqu)tuor._E()._p, (double)f, (double)f2, (double)f3, VCore.rnd.nextDouble() * 0.05, VCore.rnd.nextDouble() * 0.05, VCore.rnd.nextDouble() * 0.05, kjsv.field_72014_bd, n4).func_90019_g(n3);
            entityDiggingFX.field_70155_l = 256.0;
            tuor._E()._u._a((EntityFX)entityDiggingFX);
        }
    }

    static {
        recoilDirection = 1.0f;
        gunAnimations = new HashMap();
        currentScope = null;
        zoomProgress = 0.0f;
        lastZoomProgress = 0.0f;
        lastZoomLevel = 1.0f;
        lastFOVZoomLevel = 1.0f;
        originalMouseSensitivity = 0.5f;
        originalFOV = 90.0f;
        originalThirdPerson = 0;
        inPlane = false;
        minecraft = rojd.instance().getClient();
        clientPlayerData = new FlansModPlayerData(minecraft._P()._a());
        sync = false;
        bipod = false;
        clientBullets = new LinkedList<EntityBullet>();
        clientTracers = new LinkedList<EntityTraceFX>();
        penObjects = new HashMap<Object, Long>();
        DayZHud.hints.put("FlansThrottle", new DayZHud.Hint(){

            public boolean remove() {
                return false;
            }

            public void addHints(List<String> list) {
                EntityClientPlayerMP entityClientPlayerMP = tuor._E()._r;
                if (entityClientPlayerMP.field_70154_o instanceof EntitySeat) {
                    EntitySeat entitySeat = (EntitySeat)entityClientPlayerMP.field_70154_o;
                    if (entitySeat.driver && entitySeat.driveable != null) {
                        list.add("\u0413\u0430\u0437: " + Integer.toString(dwbg._f((float)(entitySeat.driveable.throttle * 100.0f))) + "%");
                    }
                }
            }
        });
    }

}

