/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.TickType
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  ctpu
 *  cuqu
 *  dwms
 *  eitc
 *  gowi
 *  hasa
 *  hcsmod.player.ExtendedPlayer
 *  ieta
 *  iwpo
 *  iwpo$eidn
 *  jhvs
 *  kkfb
 *  ncpk
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.lmwe
 *  net.minecraft.util.rojd
 *  net.minecraftforge.common.bpzx
 *  net.minecraftforge.event.eidl
 *  net.minecraftforge.event.hrmy
 *  net.minecraftforge.event.kjuq
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 *  rojd
 *  rord
 *  uheb
 *  uyeb
 *  uyla
 *  wngx
 *  zfwe
 */
package co.uk.flansmods.client;

import co.uk.flansmods.client.FlansModClient;
import co.uk.flansmods.client.FlansModResourceHandler;
import co.uk.flansmods.client.GuiTeamScores;
import co.uk.flansmods.client.model.RenderFlag;
import co.uk.flansmods.client.model.RenderGun;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.IScope;
import co.uk.flansmods.common.guns.ItemGun;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.vintarz.BulletSpread;
import co.uk.flansmods.vintarz.CrosshairRenderer;
import co.uk.flansmods.vintarz.EntityBulletHoleFX;
import co.uk.flansmods.vintarz.Util;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.ReflectionHelper;
import hcsmod.player.ExtendedPlayer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidl;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.lmwe;
import net.minecraftforge.common.bpzx;
import net.minecraftforge.event.hrmy;
import net.minecraftforge.event.kjuq;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class TickHandlerClient
implements ITickHandler {
    public static final ResourceLocation gui = new ResourceLocation("FlansMod", "textures/gui/gui.png");
    public static final ResourceLocation headshot = new ResourceLocation("flansmod", "textures/headshot.png");
    public static final ResourceLocation teamScores = new ResourceLocation("FlansMod", "textures/gui/teamScores.png");
    private static uyeb itemRenderer = new uyeb();
    private static List<KillMessage> killMessages = new ArrayList<KillMessage>();
    private boolean wasAimingClient;
    private final Field equippedProgress;
    private int lastSelectedSlot = -1;
    private boolean debugKeyWasPressed;
    private boolean lastTickWasRender;
    private cuqu lastClientWorld;
    private long nextBHCleanup;

    public TickHandlerClient() {
        bpzx.EVENT_BUS.register((Object)this);
        this.equippedProgress = ReflectionHelper.findField(eitc.class, (String[])new String[]{"equippedProgress", "g", "field_78454_c"});
        if (this.equippedProgress != null) {
            this.equippedProgress.setAccessible(true);
        }
    }

    @kjuq(priority=hrmy.NORMAL)
    public void eventHandler(iwpo iwpo2) {
        tuor tuor2 = tuor._E();
        if (iwpo2.type == iwpo.eidn.CROSSHAIRS && FlansModClient.currentScope != null) {
            iwpo2.setCanceled(true);
        } else if (!iwpo2.isCancelable() && iwpo2.type == iwpo.eidn.HOTBAR) {
            int n;
            KillMessage killMessage;
            gowi gowi2 = new gowi(FlansModClient.minecraft._K, FlansModClient.minecraft._l, FlansModClient.minecraft._m);
            int n2 = gowi2.func_78326_a();
            int n3 = gowi2.func_78328_b();
            if (!(FlansModClient.minecraft._r == null || GuiTeamScores.numTeams <= 0 && GuiTeamScores.sortedByTeam || GuiTeamScores.getPlayerData(FlansModClient.minecraft._r.field_71092_bJ) == null)) {
                GL11.glEnable((int)3042);
                GL11.glDisable((int)2929);
                GL11.glDepthMask((boolean)false);
                GL11.glBlendFunc((int)770, (int)771);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glDisable((int)3008);
                tuor2._f._a(GuiTeamScores.texture);
                uheb uheb2 = uheb.field_78398_a;
                uheb2.func_78382_b();
                uheb2.func_78374_a((double)(n2 / 2 - 43), 27.0, -90.0, 0.33203125, 0.10546875);
                uheb2.func_78374_a((double)(n2 / 2 + 43), 27.0, -90.0, 0.66796875, 0.10546875);
                uheb2.func_78374_a((double)(n2 / 2 + 43), 0.0, -90.0, 0.66796875, 0.0);
                uheb2.func_78374_a((double)(n2 / 2 - 43), 0.0, -90.0, 0.33203125, 0.0);
                uheb2.func_78381_a();
                if (GuiTeamScores.numTeams == 2 && GuiTeamScores.sortedByTeam) {
                    int n4 = GuiTeamScores.teamData[0].team.teamColour;
                    GL11.glColor4f((float)((float)(n4 >> 16 & 255) / 256.0f), (float)((float)(n4 >> 8 & 255) / 256.0f), (float)((float)(n4 & 255) / 256.0f), (float)1.0f);
                    uheb2.func_78382_b();
                    uheb2.func_78374_a((double)(n2 / 2 - 43), 27.0, -90.0, 0.0, 0.48828125);
                    uheb2.func_78374_a((double)(n2 / 2 - 19), 27.0, -90.0, 0.09375, 0.48828125);
                    uheb2.func_78374_a((double)(n2 / 2 - 19), 0.0, -90.0, 0.09375, 0.3828125);
                    uheb2.func_78374_a((double)(n2 / 2 - 43), 0.0, -90.0, 0.0, 0.3828125);
                    uheb2.func_78381_a();
                    n4 = GuiTeamScores.teamData[1].team.teamColour;
                    GL11.glColor4f((float)((float)(n4 >> 16 & 255) / 256.0f), (float)((float)(n4 >> 8 & 255) / 256.0f), (float)((float)(n4 & 255) / 256.0f), (float)1.0f);
                    uheb2.func_78382_b();
                    uheb2.func_78374_a((double)(n2 / 2 + 19), 27.0, -90.0, 0.2421875, 0.48828125);
                    uheb2.func_78374_a((double)(n2 / 2 + 43), 27.0, -90.0, 0.3359375, 0.48828125);
                    uheb2.func_78374_a((double)(n2 / 2 + 43), 0.0, -90.0, 0.3359375, 0.3828125);
                    uheb2.func_78374_a((double)(n2 / 2 + 19), 0.0, -90.0, 0.2421875, 0.3828125);
                    uheb2.func_78381_a();
                    GL11.glDepthMask((boolean)true);
                    GL11.glEnable((int)2929);
                    GL11.glEnable((int)3008);
                    GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                    tuor2._x._b(GuiTeamScores.teamData[0].score + "", n2 / 2 - 35, 9, 0);
                    tuor2._x._b(GuiTeamScores.teamData[0].score + "", n2 / 2 - 36, 8, 16777215);
                    tuor2._x._b(GuiTeamScores.teamData[1].score + "", n2 / 2 + 35 - tuor2._x._b(GuiTeamScores.teamData[1].score + ""), 9, 0);
                    tuor2._x._b(GuiTeamScores.teamData[1].score + "", n2 / 2 + 34 - tuor2._x._b(GuiTeamScores.teamData[1].score + ""), 8, 16777215);
                }
                tuor2._x._b(GuiTeamScores.gametype + "", n2 / 2 + 48, 9, 0);
                tuor2._x._b(GuiTeamScores.gametype + "", n2 / 2 + 47, 8, 16777215);
                tuor2._x._b(GuiTeamScores.map + "", n2 / 2 - 47 - tuor2._x._b(GuiTeamScores.map + ""), 9, 0);
                tuor2._x._b(GuiTeamScores.map + "", n2 / 2 - 48 - tuor2._x._b(GuiTeamScores.map + ""), 8, 16777215);
                GL11.glDepthMask((boolean)true);
                GL11.glEnable((int)2929);
                GL11.glEnable((int)3008);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                String string = FlansModClient.minecraft._r.field_71092_bJ;
                tuor2._x._b(GuiTeamScores.getPlayerData((String)string).score + "", n2 / 2 - 7, 1, 0);
                tuor2._x._b(GuiTeamScores.getPlayerData((String)string).kills + "", n2 / 2 - 7, 9, 0);
                tuor2._x._b(GuiTeamScores.getPlayerData((String)string).deaths + "", n2 / 2 - 7, 17, 0);
            }
            uheb uheb3 = uheb.field_78398_a;
            GL11.glEnable((int)3042);
            n2 -= 16;
            n3 -= 20;
            for (n = 0; n < killMessages.size(); ++n) {
                killMessage = killMessages.get(n);
                String string = "\u00a7" + killMessage.killedName;
                int n5 = n2 - tuor2._x._b(string) - 2;
                tuor2._x._b(string, n5, n3 - 14 - killMessage.line * 16, -1056964609);
                if (killMessage.headshot) {
                    string = "\u00a7" + killMessage.killerName;
                    int n6 = n5 - 16;
                    int n7 = n3 - 14 - killMessage.line * 16;
                    tuor2._x._b(string, n6 - tuor2._x._b(string) - 16, n3 - 14 - killMessage.line * 16, -1056964609);
                    GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
                    tuor2._f._a(headshot);
                    uheb3.func_78382_b();
                    uheb3.func_78374_a((double)(n6 - 16), (double)(n7 + 10), 90.0, 0.0, 1.0);
                    uheb3.func_78374_a((double)(n6 + 0), (double)(n7 + 10), 90.0, 1.0, 1.0);
                    uheb3.func_78374_a((double)(n6 + 0), (double)(n7 - 6), 90.0, 1.0, 0.0);
                    uheb3.func_78374_a((double)(n6 - 16), (double)(n7 - 6), 90.0, 0.0, 0.0);
                    uheb3.func_78381_a();
                    continue;
                }
                string = "\u00a7" + killMessage.killerName;
                tuor2._x._b(string, n5 - tuor2._x._b(string) - 16, n3 - 14 - killMessage.line * 16, -1056964609);
            }
            GL11.glDisable((int)3042);
            ncpk._c();
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glEnable((int)32826);
            wngx._a((int)wngx._b, (float)240.0f, (float)240.0f);
            for (n = 0; n < killMessages.size(); ++n) {
                killMessage = killMessages.get(n);
                this.drawSlotInventory(tuor2._x, new ieta(killMessage.weapon.item), n2 - tuor2._x._b("\u00a7" + killMessage.killedName) - 18, n3 - 18 - killMessage.line * 16);
            }
            GL11.glDisable((int)3042);
            ncpk._a();
        }
    }

    public void tickStart(EnumSet enumSet, Object ... arrobject) {
        if (enumSet.equals(EnumSet.of(TickType.RENDER))) {
            this.rTickStart(rojd.instance().getClient(), ((Float)arrobject[0]).floatValue());
            RenderGun.smoothing = ((Float)arrobject[0]).floatValue();
        }
        if (enumSet.equals(EnumSet.of(TickType.CLIENT))) {
            ++FlansModClient.ticks;
            long l = System.currentTimeMillis();
            if (l > this.nextBHCleanup) {
                this.nextBHCleanup = l + 10000L;
                EntityBulletHoleFX.bulletHoles.clear();
            }
            this.cTickStart(rojd.instance().getClient());
            if (tuor._E()._p != this.lastClientWorld) {
                FlansModClient.clientBullets.clear();
                this.lastClientWorld = tuor._E()._p;
            }
            if (this.lastClientWorld != null) {
                Iterator<EntityBullet> iterator = FlansModClient.clientBullets.iterator();
                Util.areClientBulletsBeingUpdated = true;
                while (iterator.hasNext()) {
                    EntityBullet entityBullet = iterator.next();
                    ++entityBullet.field_70173_aa;
                    entityBullet.func_70071_h_();
                    if (!entityBullet.field_70128_L) continue;
                    iterator.remove();
                }
                Util.areClientBulletsBeingUpdated = false;
            }
        }
    }

    public void tickEnd(EnumSet enumSet, Object ... arrobject) {
        if (enumSet.equals(EnumSet.of(TickType.RENDER))) {
            this.rTickEnd(rojd.instance().getClient());
        }
        if (enumSet.equals(EnumSet.of(TickType.CLIENT))) {
            this.cTickEnd(rojd.instance().getClient());
        }
    }

    public void cTickStart(tuor tuor2) {
        if (this.lastTickWasRender) {
            this.lastTickWasRender = false;
            for (EntityDriveable entityDriveable : EntityDriveable.vehiclesInClient) {
                entityDriveable.field_70121_D.field_72340_a = entityDriveable.field_70165_t - 0.5;
                entityDriveable.field_70121_D.field_72338_b = entityDriveable.field_70163_u - (double)entityDriveable.field_70129_M + (double)entityDriveable.field_70139_V;
                entityDriveable.field_70121_D.field_72339_c = entityDriveable.field_70161_v - 0.5;
                entityDriveable.field_70121_D.field_72336_d = entityDriveable.field_70165_t + 0.5;
                entityDriveable.field_70121_D.field_72337_e = entityDriveable.field_70163_u - (double)entityDriveable.field_70129_M + (double)entityDriveable.field_70139_V + 1.0;
                entityDriveable.field_70121_D.field_72334_f = entityDriveable.field_70161_v + 0.5;
            }
        }
        if (tuor._E()._r != null && tuor._E()._r.field_71075_bZ._d) {
            boolean bl = Keyboard.isKeyDown((int)68);
            if (bl && !this.debugKeyWasPressed) {
                FlansMod.DEBUG = !FlansMod.DEBUG;
            }
            this.debugKeyWasPressed = bl;
        } else {
            FlansMod.DEBUG = false;
        }
        if (tuor._E()._r != null) {
            FlansModPlayerData flansModPlayerData = FlansModClient.clientPlayerData;
            BulletSpread.prevClientSpread = flansModPlayerData.bulletSpread;
            BulletSpread.tickWeaponSpread((EntityPlayer)tuor._E()._r, flansModPlayerData);
        }
    }

    public void cTickEnd(tuor tuor2) {
        Iterator<KillMessage> iterator = killMessages.iterator();
        while (iterator.hasNext()) {
            KillMessage killMessage = iterator.next();
            if (--killMessage.timer > 0) continue;
            iterator.remove();
        }
        if (CrosshairRenderer.death_count > 0) {
            --CrosshairRenderer.death_count;
        }
        if (CrosshairRenderer.hit_count > 0) {
            --CrosshairRenderer.hit_count;
        }
        RenderFlag.angle += 2.0f;
        FlansModClient.tick();
    }

    public void rTickStart(tuor tuor2, float f) {
        if (!this.lastTickWasRender) {
            this.lastTickWasRender = true;
            for (EntityDriveable entityDriveable : EntityDriveable.vehiclesInClient) {
                entityDriveable.field_70121_D.field_72340_a = entityDriveable.field_70165_t - 3.0;
                entityDriveable.field_70121_D.field_72338_b = entityDriveable.field_70163_u - (double)entityDriveable.field_70129_M + (double)entityDriveable.field_70139_V - 0.5;
                entityDriveable.field_70121_D.field_72339_c = entityDriveable.field_70161_v - 3.0;
                entityDriveable.field_70121_D.field_72336_d = entityDriveable.field_70165_t + 3.0;
                entityDriveable.field_70121_D.field_72337_e = entityDriveable.field_70163_u - (double)entityDriveable.field_70129_M + (double)entityDriveable.field_70139_V + 3.0;
                entityDriveable.field_70121_D.field_72334_f = entityDriveable.field_70161_v + 3.0;
            }
        }
        try {
            if (tuor2._r != null) {
                if (tuor2._r.func_71045_bC() != null && tuor2._r.func_71045_bC()._a() instanceof ItemGun) {
                    float f2 = ((Float)this.equippedProgress.get((Object)tuor2._B.field_78516_c)).floatValue();
                    if (this.lastSelectedSlot != tuor2._r.field_71071_by._c) {
                        this.lastSelectedSlot = f2 == 1.0f ? tuor2._r.field_71071_by._c : -1;
                    } else if (f2 != 1.0f) {
                        tuor2._B.field_78516_c.func_78444_b();
                        tuor2._B.field_78516_c.func_78441_a();
                        this.equippedProgress.set((Object)tuor2._B.field_78516_c, Float.valueOf(1.0f));
                        tuor2._B.field_78516_c.func_78441_a();
                    }
                } else {
                    this.lastSelectedSlot = -1;
                }
            } else {
                this.lastSelectedSlot = -1;
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        if (tuor2._r != null) {
            ExtendedPlayer extendedPlayer = ExtendedPlayer.client((String)tuor2._r.field_71092_bJ);
            if (Util.isFlansWeapon(tuor2._r.func_71045_bC()) && ((ItemGun)tuor2._r.func_71045_bC()._a()).type.damage > 0.0f && !ItemGun.slotIsWeapon(tuor2._r.field_71071_by._c, extendedPlayer)) {
                tuor2._B.field_78516_c.func_78444_b();
            }
        }
        if (tuor2._z == null && FlansModClient.controlModeMouse) {
            EntityDriveable entityDriveable;
            lmwe lmwe2 = tuor2._M;
            entityDriveable = tuor2._r.field_70154_o;
            if (entityDriveable instanceof EntityDriveable) {
                EntityDriveable entityDriveable2 = entityDriveable;
                entityDriveable2.onMouseMoved(lmwe2._a, lmwe2._b);
            }
        }
        FlansModClient.renderTick(f);
    }

    public void rTickEnd(tuor tuor2) {
        gowi gowi2 = new gowi(FlansModClient.minecraft._K, FlansModClient.minecraft._l, FlansModClient.minecraft._m);
        int n = gowi2.func_78326_a();
        int n2 = gowi2.func_78328_b();
        if (FlansModClient.currentScope != null && FlansModClient.currentScope.hasZoomOverlay() && rojd.instance().getClient()._z == null && FlansModClient.zoomProgress > 0.8f) {
            FlansModClient.minecraft._B.func_78478_c();
            GL11.glEnable((int)3042);
            GL11.glDisable((int)2929);
            GL11.glDepthMask((boolean)false);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glColor4f((float)tuor2._H.field_73843_a, (float)tuor2._H.field_73843_a, (float)tuor2._H.field_73843_a, (float)1.0f);
            GL11.glDisable((int)3008);
            tuor2._f._a(FlansModResourceHandler.getScope(FlansModClient.currentScope.getZoomOverlay()));
            uheb uheb2 = uheb.field_78398_a;
            uheb2.func_78382_b();
            uheb2.func_78374_a((double)(n / 2 - 2 * n2), (double)n2, -90.0, 0.0, 1.0);
            uheb2.func_78374_a((double)(n / 2 + 2 * n2), (double)n2, -90.0, 1.0, 1.0);
            uheb2.func_78374_a((double)(n / 2 + 2 * n2), 0.0, -90.0, 1.0, 0.0);
            uheb2.func_78374_a((double)(n / 2 - 2 * n2), 0.0, -90.0, 0.0, 0.0);
            uheb2.func_78381_a();
            GL11.glDepthMask((boolean)true);
            GL11.glEnable((int)2929);
            GL11.glEnable((int)3008);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
    }

    private void drawSlotInventory(rord rord2, ieta ieta2, int n, int n2) {
        if (ieta2 != null && ieta2._d != 0 && ieta2._a() != null) {
            itemRenderer._a(rord2, FlansModClient.minecraft._f, ieta2, n, n2);
            itemRenderer._c(rord2, FlansModClient.minecraft._f, ieta2, n, n2);
        }
    }

    public EnumSet ticks() {
        return EnumSet.of(TickType.RENDER, TickType.CLIENT, TickType.PLAYER);
    }

    public String getLabel() {
        return "FlansModClient";
    }

    public static void addKillMessage(String[] arrstring, boolean bl) {
        if (arrstring.length == 4) {
            Object object = killMessages.iterator();
            while (object.hasNext()) {
                KillMessage killMessage;
                KillMessage killMessage2 = killMessage = object.next();
                if (++killMessage2.line < 5) continue;
                killMessage2.timer = 0;
            }
            object = new KillMessage(arrstring, bl);
            killMessages.add((KillMessage)object);
        }
    }

    private static class KillMessage {
        public String killerName;
        public String killedName;
        public InfoType weapon;
        public int timer;
        public int line;
        public boolean headshot;

        public KillMessage(String[] arrstring, boolean bl) {
            this.killerName = arrstring[3];
            this.killedName = arrstring[2];
            this.weapon = InfoType.getType(arrstring[1]);
            this.line = 0;
            this.timer = 200;
            this.headshot = bl;
        }
    }

}

