// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.hud;

import org.lwjgl.opengl.GLContext;
import java.io.File;
import net.minecraft.client.entity.EntityClientPlayerMP;
import hcsmod.effects.Effect;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import net.minecraft.util.dwbg;
import hcsmod.client.CTickHandler;
import net.vintarz.movement.MovementClient;
import cpw.mods.fml.common.Mod;
import net.minecraftforge.common.zwaq;
import co.uk.flansmods.common.guns.ItemGun;
import hcsmod.HcsInteract;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import hcsmod.client.HcsInteractable;
import hcsmod.entity.EntityCorpse;
import org.lwjgl.input.Mouse;
import hcsmod.client.CKeyHandler;
import net.minecraftforge.event.hrmy;
import net.minecraftforge.event.kjuq;
import java.util.Iterator;
import hcsmod.player.InventoryExtended;
import co.uk.flansmods.common.ItemTool;
import hcsmod.entity.EntityHouseCommon;
import hcsmod.jugger.JuggerHud;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;
import hcsmod.client.HcsClient;
import hcsmod.HCS;
import org.lwjgl.opengl.GL11;
import hcsmod.player.ExtendedPlayer;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.List;
import net.minecraft.client.tuor;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public class DayZHud
{
    public static final Map<String, String> debug;
    public static final boolean DEBUG;
    public static int UI_COLOR;
    public static final String[] directions;
    public static boolean ENABLE_SHADER;
    private static ResourceLocation circle;
    private static ResourceLocation leaves;
    private static ResourceLocation arrow;
    private static tuor mc;
    private static final ResourceLocation low_hp_screen;
    private static final ResourceLocation blood;
    private static final ResourceLocation food;
    private static final ResourceLocation thrist;
    public static final ResourceLocation gun;
    private static final ResourceLocation pwrn;
    private static final ResourceLocation detect;
    private static final ResourceLocation detect_1;
    private static final ResourceLocation detect_2;
    private static final ResourceLocation detect_3;
    private static final ResourceLocation detect_4;
    private static boolean wasF1;
    public static boolean hideHud;
    private static final List<String> $tmp_list;
    public static final Map<String, Hint> hints;
    public static final DayZShader SHADER;
    public static boolean SHOW_LOW_HP;
    
    public static void renderStart() {
        if (DayZHud.mc._p != null && DayZHud.SHADER != null && DayZHud.ENABLE_SHADER) {
            DayZHud.SHADER.renderStart();
        }
    }
    
    public static void renderEnd() {
        if (DayZHud.mc._p != null && DayZHud.SHADER != null) {
            DayZHud.SHADER.renderEnd();
        }
    }
    
    public static int loadUiColor() {
        int n = 12648384;
        try {
            final DataInputStream dataInputStream = new DataInputStream(new FileInputStream("vUiColor"));
            Throwable t = null;
            try {
                n = (dataInputStream.readInt() & 0xFFFFFF);
                dataInputStream.close();
            }
            catch (Throwable t2) {
                t = t2;
                throw t2;
            }
            finally {
                if (t != null) {
                    try {
                        dataInputStream.close();
                    }
                    catch (Throwable exception) {
                        t.addSuppressed(exception);
                    }
                }
                else {
                    dataInputStream.close();
                }
            }
        }
        catch (IOException ex) {}
        return n;
    }
    
    public static void saveUiColor() {
        try {
            final DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("vUiColor"));
            Throwable t = null;
            try {
                dataOutputStream.writeInt(DayZHud.UI_COLOR & 0xFFFFFF);
                dataOutputStream.close();
            }
            catch (Throwable t2) {
                t = t2;
                throw t2;
            }
            finally {
                if (t != null) {
                    try {
                        dataOutputStream.close();
                    }
                    catch (Throwable exception) {
                        t.addSuppressed(exception);
                    }
                }
                else {
                    dataOutputStream.close();
                }
            }
        }
        catch (IOException ex) {}
    }
    
    @kjuq(priority = hrmy.LOWEST, receiveCanceled = true)
    public void $(final iwpo.eidl eidl) {
        final gowi resolution = eidl.resolution;
        final ExtendedPlayer client = ExtendedPlayer.client(DayZHud.mc._r.field_71092_bJ);
        if (eidl.type == iwpo.eidn.ALL) {
            final double func_78327_c = resolution.func_78327_c();
            final double func_78324_d = resolution.func_78324_d();
            GL11.glClear(256);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0, func_78327_c, func_78324_d, 0.0, 1000.0, 3000.0);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
            GL11.glDisable(3008);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            if (DayZHud.mc._r != null && DayZHud.mc._r.func_70055_a(ccfp._j)) {
                GL11.glDisable(3553);
                GL11.glBlendFunc(774, 0);
                GL11.glColor4f(0.33f, 1.0f, 0.33f, 1.0f);
                drawRect(0.0, 0.0, resolution.func_78326_a(), resolution.func_78328_b());
                GL11.glEnable(3553);
                GL11.glBlendFunc(770, 771);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                DayZHud.mc._f._a(DayZHud.leaves);
                drawRect(0.0, 0.0, resolution.func_78326_a(), resolution.func_78328_b());
            }
            if (client != null) {
                final InventoryExtended inventory = client.inventory;
                if (DayZHud.mc._K.__bw == 0 && inventory != null && inventory.inventoryStacks[5] != null && inventory.inventoryStacks[5]._d == HCS.PNV.field_77779_bT) {
                    drawNV(resolution.func_78326_a(), resolution.func_78328_b());
                }
            }
            if (DayZHud.mc._K.__bw == 0 && DayZHud.mc._r.field_71071_by._b[3] != null && DayZHud.mc._r.field_71071_by._b[3]._d == HCS.helmetpnv.field_77779_bT) {
                drawNV(resolution.func_78326_a(), resolution.func_78328_b());
            }
            int color = 0;
            if (HcsClient.overheat > 0.0f) {
                color = ((int)(255.0f - 100.0f * HcsClient.overheat) << 8 | (int)(255.0f - 100.0f * HcsClient.overheat) | 0xFFFF0000);
            }
            else if (HcsClient.overheat < 0.0f) {
                color = ((int)(255.0f - 100.0f * -HcsClient.overheat) << 16 | (int)(255.0f - 100.0f * -HcsClient.overheat) << 8 | 0xFF0000FF);
            }
            if (color != 0) {
                setColor(color);
                GL11.glBlendFunc(774, 0);
                GL11.glDisable(3553);
                drawRect(0.0, 0.0, resolution.func_78326_a(), resolution.func_78328_b());
                GL11.glEnable(3553);
                GL11.glBlendFunc(770, 771);
            }
            final float n = DayZHud.SHOW_LOW_HP ? 0.0f : DayZHud.mc._r.func_110143_aJ();
            DayZHud.SHOW_LOW_HP = false;
            if (n <= 10.0f) {
                final float min = Math.min((10.0f - n) / 6.6666665f, 1.0f);
                if (DayZHud.SHADER == null || !DayZHud.ENABLE_SHADER) {
                    GL11.glDisable(3553);
                    GL11.glColor4f(0.2f, 0.2f, 0.2f, min * 0.75f);
                    drawRect(0.0, 0.0, func_78327_c, func_78324_d);
                    GL11.glEnable(3553);
                }
                else {
                    DayZHud.SHADER.grayscale = min * 0.8f;
                }
            }
            else if (DayZHud.SHADER != null) {
                DayZHud.SHADER.grayscale = 0.0f;
            }
            final float n2 = (HcsClient.lastDamage + 1000L - System.currentTimeMillis()) / 1000.0f;
            if (n2 > 0.0f && n2 <= 1.0f) {
                DayZHud.mc._R()._a(DayZHud.low_hp_screen);
                GL11.glColor4f(1.0f, 0.0f, 0.0f, n2 / 10.0f);
                drawRect(0.0, 0.0, func_78327_c, func_78324_d);
            }
            float field_71086_bY = 0.0f;
            if (ExtendedPlayer.client(tuor._E()._r.field_71092_bJ).hunger >= 78000) {
                field_71086_bY = 0.25f;
            }
            if (ExtendedPlayer.client(tuor._E()._r.field_71092_bJ).thirst >= 78000) {
                field_71086_bY += 0.25f;
            }
            if (field_71086_bY > 0.0f) {
                tuor._E()._r.field_71080_cy = 0.0f;
                tuor._E()._r.field_71086_bY = field_71086_bY;
            }
            if ((HcsClient.resWarning && HcsClient.resWarn) || (DayZHud.DEBUG && Keyboard.isKeyDown(45))) {
                GL11.glDisable(3553);
                GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.2f);
                drawRect(resolution.func_78326_a() / 2 - 64, 19.0, 128.0, 44.0);
                GL11.glEnable(3553);
                setColor(0xFF000000 | DayZHud.UI_COLOR);
                DayZHud.mc._f._a(DayZHud.pwrn);
                drawTexturedRect(resolution.func_78326_a() / 2 - 64, 20.0, 128.0, 64.0);
            }
            if (DayZHud.SHADER != null) {
                DayZHud.SHADER.draw(resolution);
            }
            final boolean keyDown = Keyboard.isKeyDown(59);
            if (keyDown && !DayZHud.wasF1) {
                DayZHud.hideHud = !DayZHud.hideHud;
            }
            DayZHud.wasF1 = keyDown;
            if (DayZHud.hideHud) {
                eidl.setCanceled(true);
            }
        }
        else if (eidl.type == iwpo.eidn.HOTBAR) {
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            drawDayzGui(resolution.func_78326_a(), resolution.func_78328_b(), DayZHud.mc, (EntityPlayer)DayZHud.mc._r);
            JuggerHud.renderJagHud(DayZHud.mc);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            renderUseProgress(resolution.func_78326_a(), resolution.func_78328_b());
            renderWaterOxygen(resolution.func_78326_a(), resolution.func_78328_b());
            renderTargetItem(resolution.func_78326_a(), resolution.func_78328_b(), eidl.partialTicks);
            if (DayZHud.mc._r != null && DayZHud.mc._r.field_70154_o instanceof EntityHouseCommon) {
                final String s = "\u0414\u043b\u044f \u0441\u043c\u0435\u043d\u044b \u043f\u0430\u0440\u043e\u043b\u044f \u0443\u0434\u0430\u0440\u044c \u0440\u0443\u043a\u043e\u0439 (\u043b\u0435\u0432\u0430\u044f \u043a\u043d\u043e\u043f\u043a\u0430 \u043c\u044b\u0448\u0438).";
                DayZHud.mc._x._a(s, resolution.func_78326_a() / 2 - DayZHud.mc._x._b(s) / 2, resolution.func_78328_b() / 2 + 14, DayZHud.UI_COLOR);
            }
            if (!DayZHud.$tmp_list.isEmpty()) {
                int n3 = 14;
                for (final String s2 : DayZHud.$tmp_list) {
                    final int b = DayZHud.mc._x._b(s2);
                    qlob.func_73734_a(resolution.func_78326_a() - b - 9, n3, resolution.func_78326_a() - 5, n3 + 9, 1073741824);
                    DayZHud.mc._x._b(s2, resolution.func_78326_a() - b - 7, n3 + 1, 0x7F000000 | DayZHud.UI_COLOR);
                    n3 += 10;
                }
            }
            if (DayZHud.mc._z == null) {
                drawDebugInfo();
            }
            GL11.glDisable(3042);
            int n4 = eidl.resolution.func_78326_a() / 2 - 108;
            for (int i = 0; i < 9; ++i) {
                n4 += 20;
                final ieta ieta = DayZHud.mc._r.field_71071_by._a[i];
                if (ieta != null) {
                    final jhvs a = ieta._a();
                    if (a instanceof ItemTool) {
                        final ItemTool itemTool = (ItemTool)a;
                        if (itemTool.type.healPlayers) {
                            final int n5 = eidl.resolution.func_78328_b() - 19;
                            final int n6 = (int)(16.0f * ((HcsClient.prevFlansHealCooldown + (HcsClient.flansHealCooldown - HcsClient.prevFlansHealCooldown) * eidl.partialTicks) / 10.0f));
                            final int n7 = n5 + (16 - n6);
                            final int n8 = 16 - (16 - n6);
                            GL11.glEnable(3042);
                            GL11.glBlendFunc(770, 771);
                            GL11.glColor4f(1.0f, 0.0f, 0.0f, 0.666f);
                            GL11.glDisable(3553);
                            drawRect(n4, n7, 16.0, n8);
                            GL11.glEnable(3553);
                        }
                        else if (itemTool.type.parachute && DayZHud.mc._r.field_71071_by._c == i && DayZHud.mc._r.field_70143_R > 2.0f) {
                            final int n9 = eidl.resolution.func_78328_b() - 19;
                            GL11.glEnable(3042);
                            GL11.glBlendFunc(770, 771);
                            GL11.glColor4f(0.0f, 1.0f, 0.0f, 0.333f);
                            GL11.glDisable(3553);
                            drawRect(n4, n9, 16.0, 16.0);
                            GL11.glEnable(3553);
                        }
                    }
                }
            }
        }
        else if (eidl.type == iwpo.eidn.ARMOR || eidl.type == iwpo.eidn.EXPERIENCE || eidl.type == iwpo.eidn.HEALTH || eidl.type == iwpo.eidn.HEALTHMOUNT || eidl.type == iwpo.eidn.JUMPBAR || eidl.type == iwpo.eidn.AIR || eidl.type == iwpo.eidn.FOOD) {
            eidl.setCanceled(true);
        }
    }
    
    private static void renderTargetItem(final int n, final int n2, final float n3) {
        String s;
        try {
            s = Keyboard.getKeyName(CKeyHandler.interact._d);
        }
        catch (Exception ex) {
            s = Mouse.getButtonName(CKeyHandler.interact._d);
        }
        if (DayZHud.mc._z != null) {
            return;
        }
        if (HcsClient.interactTarget instanceof EntityCorpse) {
            final EntityCorpse entityCorpse = (EntityCorpse)HcsClient.interactTarget;
            final int n4 = n / 2;
            int n5 = n2 / 2;
            final String string = "\u0422\u0440\u0443\u043f [" + entityCorpse.getUsernameKilled() + "]";
            final rord x = DayZHud.mc._x;
            final String s2 = string;
            final int n6 = n4 - DayZHud.mc._x._b(string) / 2;
            n5 += 2;
            x._b(s2, n6, n5, DayZHud.UI_COLOR);
            if (!entityCorpse.getAttacker().isEmpty()) {
                final String string2 = "\u0443\u0431\u0438\u043b [" + entityCorpse.getAttacker() + "]";
                final rord x2 = DayZHud.mc._x;
                final String s3 = string2;
                final int n7 = n4 - DayZHud.mc._x._b(string2) / 2;
                n5 += 9;
                x2._b(s3, n7, n5, DayZHud.UI_COLOR);
            }
            final String string3 = "\u043d\u0430\u0436\u043c\u0438 [ " + s + " ]";
            DayZHud.mc._x._b(string3, n4 - DayZHud.mc._x._b(string3) / 2, n5 + 9, DayZHud.UI_COLOR);
        }
        else if (HcsClient.interactTarget instanceof HcsInteractable) {
            final HcsInteractable hcsInteractable = (HcsInteractable)HcsClient.interactTarget;
            final int n8 = n / 2;
            final int n9 = n2 / 2;
            final String name = hcsInteractable.name();
            DayZHud.mc._x._b(name, n8 - DayZHud.mc._x._b(name) / 2, n9 + 2, DayZHud.UI_COLOR);
            final String string4 = "\u043d\u0430\u0436\u043c\u0438 [ " + s + " ]";
            DayZHud.mc._x._b(string4, n8 - DayZHud.mc._x._b(string4) / 2, n9 + 11, DayZHud.UI_COLOR);
        }
        else if (HcsClient.interactTarget instanceof EntityOtherPlayerMP) {
            final EntityOtherPlayerMP entityOtherPlayerMP = (EntityOtherPlayerMP)HcsClient.interactTarget;
            final int n10 = n / 2;
            final int n11 = n2 / 2;
            if (HCS.isHealOtherItem(DayZHud.mc._r.func_71045_bC())) {
                final String string5 = "\u0412\u044b\u043b\u0435\u0447\u0438\u0442\u044c [" + entityOtherPlayerMP.field_71092_bJ + "]";
                DayZHud.mc._x._b(string5, n10 - DayZHud.mc._x._b(string5) / 2, n11 + 2, DayZHud.UI_COLOR);
                final String string6 = "\u043d\u0430\u0436\u043c\u0438 [ " + s + " ]";
                DayZHud.mc._x._b(string6, n10 - DayZHud.mc._x._b(string6) / 2, n11 + 11, DayZHud.UI_COLOR);
            }
            else {
                final String string7 = "\u041e\u0431\u043c\u0435\u043d [" + entityOtherPlayerMP.field_71092_bJ + "]";
                DayZHud.mc._x._b(string7, n10 - DayZHud.mc._x._b(string7) / 2, n11 + 2, DayZHud.UI_COLOR);
                final String string8 = "\u043d\u0430\u0436\u043c\u0438 [ " + s + " ]";
                DayZHud.mc._x._b(string8, n10 - DayZHud.mc._x._b(string8) / 2, n11 + 11, DayZHud.UI_COLOR);
            }
        }
        else if (HcsClient.interactTarget == HcsInteract.CAMP_FIRE) {
            final String s4 = "\u0417\u0430\u0436\u0435\u0447\u044c (\u0432\u043e\u0437\u044c\u043c\u0438 \u0437\u0430\u0436\u0438\u0433\u0430\u043b\u043a\u0443 \u0432 \u0440\u0443\u043a\u0443) ";
            final int n12 = n / 2;
            final int n13 = n2 / 2;
            DayZHud.mc._x._b(s4, n12 - DayZHud.mc._x._b(s4) / 2, n13 + 2, DayZHud.UI_COLOR);
            final String s5 = "\u041f\u043e\u0436\u0430\u0440\u0438\u0442\u044c \u043c\u044f\u0441\u043e (\u0432\u043e\u0437\u044c\u043c\u0438 \u0435\u0433\u043e \u0432 \u0440\u0443\u043a\u0443)";
            final int n14 = n12;
            DayZHud.mc._x._b(s5, n14 - DayZHud.mc._x._b(s5) / 2, n13 + 9 + 2, DayZHud.UI_COLOR);
            final String s6 = "\u041f\u043e\u0442\u0443\u0448\u0438\u0442\u044c (\u0432\u043e\u0437\u044c\u043c\u0438 \u0431\u0443\u0442\u044b\u043b\u043a\u0443 \u0441 \u0432\u043e\u0434\u043e\u0439) ";
            final int n15 = n14;
            DayZHud.mc._x._b(s6, n15 - DayZHud.mc._x._b(s6) / 2, n2 / 2 + 18 + 2, DayZHud.UI_COLOR);
            final String string9 = "\u0438 \u043d\u0430\u0436\u043c\u0438 \u043a\u043d\u043e\u043f\u043a\u0443 [ " + s + " ]";
            DayZHud.mc._x._b(string9, n15 - DayZHud.mc._x._b(string9) / 2, n2 / 2 + 27 + 2, DayZHud.UI_COLOR);
        }
        else if (HcsClient.interactTarget instanceof HcsInteract) {
            final String string10 = ((HcsInteract)HcsClient.interactTarget).name + " [ " + s + " ]";
            DayZHud.mc._x._b(string10, n / 2 - DayZHud.mc._x._b(string10) / 2, n2 / 2 + 2, DayZHud.UI_COLOR);
        }
    }
    
    private static void renderUseProgress(final int n, final int n2) {
        final int n3 = n2 - 23;
        final int n4 = n / 2 - 90;
        final double n5 = (DayZHud.mc._r.func_71011_bu() != null) ? DayZHud.mc._r.func_71011_bu()._n() : 0.0;
        final double n6 = DayZHud.mc._r.func_71052_bv();
        if (n5 != 0.0) {
            qlob.func_73734_a(n4, n3, (int)(n4 + Math.min(1.0 - n6 / n5, 1.0) * 180.0), n3 + 2, Integer.MIN_VALUE | DayZHud.UI_COLOR);
        }
    }
    
    private static void renderWaterOxygen(final int n, final int n2) {
        final int n3 = n2 - 2;
        final int n4 = n / 2 - 90;
        final double b = 300.0 - DayZHud.mc._r.func_70086_ai();
        if (b != 0.0) {
            final double min = Math.min(1.0 - Math.min(300.0, b) / 300.0, 1.0);
            qlob.func_73734_a((int)(n4 + min * 180.0), n3, n4 + 180, n3 + 2, -2130722624);
            qlob.func_73734_a(n4, n3, (int)(n4 + min * 180.0), n3 + 2, -2141847553);
        }
    }
    
    private static void drawNV(final int n, final int n2) {
        setColor(-8913033);
        GL11.glBlendFunc(774, 0);
        GL11.glDisable(3553);
        drawRect(0.0, 0.0, n, n2);
        GL11.glEnable(3553);
        GL11.glBlendFunc(770, 771);
    }
    
    public static void drawDayzGui(final int n, final int n2, final tuor tuor, final EntityPlayer entityPlayer) {
        final ExtendedPlayer client = ExtendedPlayer.client(tuor._r.field_71092_bJ);
        GL11.glEnable(3042);
        for (int i = 0; i < 9; ++i) {
            if (!HcsClient.isPVPserver && !HcsClient.isLiteserver && tuor._r.field_71071_by.func_70301_a(i) == null && ItemGun.slotIsWeapon(i, client)) {
                drawTexturedRect(DayZHud.gun, n / 2 - 87.5f + i * 20, n2 - 18.5f, 15.0f, 15.0f, (i == tuor._r.field_71071_by._c) ? -1.0f : 2.0f);
            }
        }
        GL11.glDisable(3008);
        GL11.glEnable(3553);
        GL11.glBlendFunc(770, 771);
        final String string = "hcs.land " + entityPlayer.field_71092_bJ;
        final int min = Math.min(tuor._x._b(string), 80);
        GL11.glDisable(3553);
        GL11.glShadeModel(7425);
        final uheb field_78398_a = uheb.field_78398_a;
        final int n3 = n - 100;
        final int n4 = n - 80;
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.15f);
        drawTexturedRect(n / 2 - 70, 0.0, 140.0, 14.0);
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.25f);
        drawTexturedRect(0.0, 0.0, min - 10, 9.0);
        drawTexturedRect(n4, 0.0, 80.0, 9.0);
        field_78398_a.func_78382_b();
        field_78398_a.func_78369_a(0.0f, 0.0f, 0.0f, 0.25f);
        field_78398_a.func_78377_a((double)n4, 9.0, 0.0);
        field_78398_a.func_78377_a((double)n4, 0.0, 0.0);
        field_78398_a.func_78369_a(0.0f, 0.0f, 0.0f, 0.0f);
        field_78398_a.func_78377_a((double)n3, 0.0, 0.0);
        field_78398_a.func_78377_a((double)n3, 9.0, 0.0);
        field_78398_a.func_78381_a();
        final int n5 = min - 10;
        final int n6 = min + 10;
        field_78398_a.func_78382_b();
        field_78398_a.func_78369_a(0.0f, 0.0f, 0.0f, 0.0f);
        field_78398_a.func_78377_a((double)n6, 9.0, 0.0);
        field_78398_a.func_78377_a((double)n6, 0.0, 0.0);
        field_78398_a.func_78369_a(0.0f, 0.0f, 0.0f, 0.25f);
        field_78398_a.func_78377_a((double)n5, 0.0, 0.0);
        field_78398_a.func_78377_a((double)n5, 9.0, 0.0);
        field_78398_a.func_78381_a();
        final int n7 = n / 2 - 80;
        final int n8 = n7 - 10;
        final int n9 = n7 + 10;
        field_78398_a.func_78382_b();
        field_78398_a.func_78369_a(0.0f, 0.0f, 0.0f, 0.15f);
        field_78398_a.func_78377_a((double)n9, 14.0, 0.0);
        field_78398_a.func_78377_a((double)n9, 0.0, 0.0);
        field_78398_a.func_78369_a(0.0f, 0.0f, 0.0f, 0.0f);
        field_78398_a.func_78377_a((double)n8, 0.0, 0.0);
        field_78398_a.func_78377_a((double)n8, 14.0, 0.0);
        field_78398_a.func_78381_a();
        final int n10 = n / 2 + 80;
        final int n11 = n10 - 10;
        final int n12 = n10 + 10;
        field_78398_a.func_78382_b();
        field_78398_a.func_78369_a(0.0f, 0.0f, 0.0f, 0.0f);
        field_78398_a.func_78377_a((double)n12, 14.0, 0.0);
        field_78398_a.func_78377_a((double)n12, 0.0, 0.0);
        field_78398_a.func_78369_a(0.0f, 0.0f, 0.0f, 0.15f);
        field_78398_a.func_78377_a((double)n11, 0.0, 0.0);
        field_78398_a.func_78377_a((double)n11, 14.0, 0.0);
        field_78398_a.func_78381_a();
        GL11.glShadeModel(7424);
        GL11.glEnable(3553);
        float n13 = (entityPlayer.field_70177_z + 180.0f) % 360.0f;
        if (n13 < 0.0f) {
            n13 += 360.0f;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.75f);
        setColor(Integer.MIN_VALUE | DayZHud.UI_COLOR);
        GL11.glDisable(3553);
        GL11.glBegin(4);
        GL11.glVertex3f((float)(n / 2 + 2), 0.5f, 0.0f);
        GL11.glVertex3f((float)(n / 2 - 2), 0.5f, 0.0f);
        GL11.glVertex3f((float)(n / 2), 4.5f, 0.0f);
        GL11.glEnd();
        GL11.glEnable(3553);
        final int n14 = (int)(n13 / 15.0f) * 15;
        GL11.glPushMatrix();
        GL11.glTranslatef(-n13 % 15.0f * 1.5f, 0.0f, 0.0f);
        for (int j = -45; j <= 60; j += 15) {
            int k = (j + n14) % 360;
            if (k < 0) {
                k += 360;
            }
            int n15 = 0xC0000000 | DayZHud.UI_COLOR;
            int n16 = 1;
            int n17 = 1;
            String string2;
            if (k == 0) {
                string2 = "N";
            }
            else if (k == 45) {
                string2 = "NE";
            }
            else if (k == 90) {
                string2 = "E";
            }
            else if (k == 135) {
                string2 = "SE";
            }
            else if (k == 180) {
                string2 = "S";
            }
            else if (k == 225) {
                string2 = "SW";
            }
            else if (k == 270) {
                string2 = "W";
            }
            else if (k == 315) {
                string2 = "NW";
            }
            else {
                string2 = Integer.toString(k);
                n15 = (Integer.MIN_VALUE | DayZHud.UI_COLOR);
                n16 = 0;
                n17 = 0;
            }
            final int n18 = (int)(((n15 & 0xFF000000) >>> 24) * Math.min(Math.min(Math.abs(angularDistance((float)(j + n14 + 30 + 30), n13) / 15.0f), Math.abs(angularDistance((float)(j + n14 - 30 - 30), n13) / 15.0f)), 1.0f)) << 24 | (n15 & DayZHud.UI_COLOR);
            if ((n18 >>> 24 & 0xFF) >= 4) {
                tuor._x._b(string2, n / 2 - tuor._x._b(string2) / 2 + (int)(j * 1.5f) + n16, 6 + n17, n18);
                GL11.glDisable(3553);
                final boolean b = k % 45 == 0;
                drawRect(n / 2 + (int)(j * 1.5f), (b ? 3 : 4) + n17, 1.0, b ? 2.0 : 1.0);
                GL11.glEnable(3553);
            }
        }
        GL11.glPopMatrix();
        GL11.glEnable(3008);
        final int totalArmorValue = zwaq.getTotalArmorValue((EntityPlayer)tuor._r);
        final String string3 = HCS.class.getAnnotation(Mod.class).version() + " ";
        qlob.func_73734_a(0, n2 - 17, n / 2 - 91, n2, 1073741824);
        qlob.func_73734_a(n / 2 + 91, n2 - 17, n, n2, 1073741824);
        GL11.glEnable(3042);
        tuor._x._b(string, 1, 1, 0xFF000000 | DayZHud.UI_COLOR);
        final String replace = (tuor._S + "fps " + string3).replace("fps build ", "fps v.");
        tuor._x._b(replace, n - tuor._x._b(replace), 1, 0xFF000000 | DayZHud.UI_COLOR);
        final String s = "\u0443\u0431\u0438\u0439\u0441\u0442\u0432\u0430";
        tuor._x._b(s, n - tuor._x._b(s), n2 - 25, 0x7F000000 | DayZHud.UI_COLOR);
        final String string4 = client.playerKills + " \u0438\u0433\u0440\u043e\u043a\u0438";
        tuor._x._b(string4, n - tuor._x._b(string4), n2 - 16, 0xFF000000 | DayZHud.UI_COLOR);
        final String string5 = client.zombieKills + " \u0437\u043e\u043c\u0431\u0438";
        tuor._x._b(string5, n - tuor._x._b(string5), n2 - 8, 0xFF000000 | DayZHud.UI_COLOR);
        String string6 = "\u043d\u0435\u0442";
        final ieta a = tuor._r.field_71071_by._a();
        if (a != null && a._a() instanceof ItemGun) {
            final ieta bulletItemStack = ((ItemGun)a._a()).getBulletItemStack(a, 0);
            if (bulletItemStack != null && bulletItemStack._a() != null) {
                string6 = bulletItemStack._k() - bulletItemStack._j() + "/" + bulletItemStack._k();
            }
        }
        tuor._x._b(string6, n / 2 - 91 - tuor._x._b(string6), n2 - 8, 0xFF000000 | DayZHud.UI_COLOR);
        final String s2 = "\u043f\u0430\u0442\u0440\u043e\u043d\u044b";
        tuor._x._b(s2, n / 2 - 91 - tuor._x._b(s2), n2 - 16, 0x7F000000 | DayZHud.UI_COLOR);
        final String server = HcsClient.server;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.0f, 100.0f);
        tuor._x._b(server, 2, n2 - 25, 0xFF000000 | DayZHud.UI_COLOR);
        GL11.glPopMatrix();
        tuor._x._b("\u0431\u0440\u043e\u043d\u044f", 1, n2 - 16, 0x7F000000 | DayZHud.UI_COLOR);
        tuor._x._b((HcsClient.customArmor != null) ? HcsClient.customArmor : (totalArmorValue + "/20"), 1, n2 - 8, 0xFF000000 | DayZHud.UI_COLOR);
        if (HcsClient.gpsEnabled) {
            GL11.glPushMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            GL11.glTranslatef((float)(n / 2), (float)(n2 - 31), 0.0f);
            GL11.glRotated(entityPlayer.field_70177_z + Math.toDegrees(Math.atan2(HcsClient.gpsX - entityPlayer.field_70165_t, HcsClient.gpsZ - entityPlayer.field_70161_v)), 0.0, 0.0, -1.0);
            tuor._R()._a(DayZHud.arrow);
            drawRect(-8.0, -8.0, 16.0, 16.0);
            GL11.glPopMatrix();
        }
        drawTexturedRect(DayZHud.blood, (float)(n - 20), (float)(n2 - 99), 24.0f, 24.0f, Math.max(Math.min(tuor._r.func_110143_aJ() / 20.0f, 1.0f), 0.0f));
        drawTexturedRect(DayZHud.thrist, (float)(n - 20), (float)(n2 - 74), 24.0f, 24.0f, 1.0f - client.thirst / 78000.0f);
        drawTexturedRect(DayZHud.food, (float)(n - 20), (float)(n2 - 49), 24.0f, 24.0f, 1.0f - client.hunger / 78000.0f);
        drawTexturedRect(DayZHud.detect, (float)(n - 22), (float)(n2 - 123), 25.0f, 25.0f, MovementClient.sprinting);
        if (CTickHandler.detect_level > 0 || CTickHandler.shootTime > 0) {
            if (CTickHandler.shootTime == 0) {
                switch (CTickHandler.detect_level) {
                    case 1: {
                        tuor._R()._a(DayZHud.detect_1);
                        break;
                    }
                    case 2: {
                        tuor._R()._a(DayZHud.detect_2);
                        break;
                    }
                    case 3: {
                        tuor._R()._a(DayZHud.detect_3);
                        break;
                    }
                    case 4: {
                        tuor._R()._a(DayZHud.detect_4);
                        break;
                    }
                }
                setColor(0xC0000000 | DayZHud.UI_COLOR);
            }
            else {
                tuor._R()._a(DayZHud.detect_4);
                GL11.glColor4f(1.0f, 0.0f, 0.0f, 0.75f);
            }
            final uheb field_78398_a2 = uheb.field_78398_a;
            field_78398_a2.func_78382_b();
            field_78398_a2.func_78374_a((double)(n - 28), (double)(n2 - 90), 90.0, 0.0, 1.0);
            field_78398_a2.func_78374_a((double)(n - 4), (double)(n2 - 90), 90.0, 1.0, 1.0);
            field_78398_a2.func_78374_a((double)(n - 4), (double)(n2 - 114), 90.0, 1.0, 0.0);
            field_78398_a2.func_78374_a((double)(n - 28), (double)(n2 - 114), 90.0, 0.0, 0.0);
            field_78398_a2.func_78381_a();
        }
    }
    
    private static void drawDebugInfo() {
        if (DayZHud.mc._r.field_71075_bZ._d) {
            GL11.glPushMatrix();
            final String[] array = new String[DayZHud.debug.size()];
            final String[] array2 = new String[array.length];
            final int[] array3 = new int[array.length];
            int n = 0;
            int max = 0;
            int max2 = 0;
            for (final Map.Entry<String, String> entry : DayZHud.debug.entrySet()) {
                array[n] = entry.getKey();
                final int a = max;
                final int[] array4 = array3;
                final int n2 = n;
                final int b = DayZHud.mc._x._b(array[n]);
                array4[n2] = b;
                max = Math.max(a, b);
                array2[n] = entry.getValue();
                max2 = Math.max(max2, DayZHud.mc._x._b(array2[n]));
                ++n;
            }
            GL11.glTranslatef(85.0f, 17.0f, 0.0f);
            qlob.func_73734_a(-2, -2, max + max2 + 4, array.length * 11 + 12, 2130706432);
            qlob.func_73734_a(max, 9, max + 1, array.length * 11 + 10, 0x7F000000 | DayZHud.UI_COLOR);
            DayZHud.mc._x._b("DEV", 0, 0, 0xFF000000 | DayZHud.UI_COLOR);
            int i;
            for (i = 0; i < array.length; ++i) {
                final int n3 = (i + 1) * 11;
                GL11.glEnable(3042);
                DayZHud.mc._x._b(array[i], max - array3[i], n3, 0xC0000000 | DayZHud.UI_COLOR);
                DayZHud.mc._x._b(array2[i], max + 2, n3, 0xC0000000 | DayZHud.UI_COLOR);
                qlob.func_73734_a(0, n3 - 2, max + max2 + 2, n3 - 1, 0x7F000000 | DayZHud.UI_COLOR);
            }
            qlob.func_73734_a(0, (i + 1) * 11 - 2, max + max2 + 2, (i + 1) * 11 - 1, 0x7F000000 | DayZHud.UI_COLOR);
            GL11.glPopMatrix();
        }
    }
    
    private static void drawRect(final double n, final double n2, final double n3, final double n4) {
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a(n + 0.0, n2 + n4, 0.0, 0.0, 1.0);
        field_78398_a.func_78374_a(n + n3, n2 + n4, 0.0, 1.0, 1.0);
        field_78398_a.func_78374_a(n + n3, n2 + 0.0, 0.0, 1.0, 0.0);
        field_78398_a.func_78374_a(n + 0.0, n2 + 0.0, 0.0, 0.0, 0.0);
        field_78398_a.func_78381_a();
    }
    
    public static void drawTexturedRect(final ResourceLocation resourceLocation, final float n, final float n2, final float n3, final float n4, float n5) {
        DayZHud.mc._f._a(resourceLocation);
        final long currentTimeMillis = System.currentTimeMillis();
        final float n6 = -0.01f + (float)(-0.05 * Math.sin(6.283185307179586 * (currentTimeMillis % 3000L) / 3000.0));
        final float n7 = -0.01f + (float)(-0.05 * Math.sin(6.283185307179586 * ((currentTimeMillis + 1000L) % 3000L) / 3000.0));
        final uheb field_78398_a = uheb.field_78398_a;
        GL11.glColor4f(0.5f, 0.5f, 0.5f, 0.75f);
        if (n5 < 0.0f) {
            field_78398_a.func_78382_b();
            field_78398_a.func_78374_a((double)(n + 0.0f), (double)(n2 + n4), 90.0, 0.0, 1.0);
            field_78398_a.func_78374_a((double)(n + n3), (double)(n2 + n4), 90.0, 1.0, 1.0);
            field_78398_a.func_78374_a((double)(n + n3), (double)(n2 + 0.0f), 90.0, 1.0, 0.0);
            field_78398_a.func_78374_a((double)(n + 0.0f), (double)(n2 + 0.0f), 90.0, 0.0, 0.0);
            field_78398_a.func_78381_a();
        }
        else if (n5 > 1.0f) {
            setColor(Integer.MAX_VALUE);
            field_78398_a.func_78382_b();
            field_78398_a.func_78374_a((double)(n + 0.0f), (double)(n2 + n4), 90.0, 0.0, 1.0);
            field_78398_a.func_78374_a((double)(n + n3), (double)(n2 + n4), 90.0, 1.0, 1.0);
            field_78398_a.func_78374_a((double)(n + n3), (double)n2, 90.0, 1.0, 0.0);
            field_78398_a.func_78374_a((double)(n + 0.0f), (double)n2, 90.0, 0.0, 0.0);
            field_78398_a.func_78381_a();
        }
        else {
            n5 = 1.0f - n5;
            field_78398_a.func_78382_b();
            field_78398_a.func_78374_a((double)(n + 0.0f), (double)(n2 + n4 * dwbg._a(n5 - n6 + 0.020833334f, 0.0f, 1.0f)), 90.0, 0.0, (double)(1.0f * dwbg._a(n5 - n6 + 0.020833334f, 0.0f, 1.0f)));
            field_78398_a.func_78374_a((double)(n + n3), (double)(n2 + n4 * dwbg._a(n5 - n7 + 0.020833334f, 0.0f, 1.0f)), 90.0, 1.0, (double)(1.0f * dwbg._a(n5 - n7 + 0.020833334f, 0.0f, 1.0f)));
            field_78398_a.func_78374_a((double)(n + n3), (double)(n2 + 0.0f), 90.0, 1.0, 0.0);
            field_78398_a.func_78374_a((double)(n + 0.0f), (double)(n2 + 0.0f), 90.0, 0.0, 0.0);
            field_78398_a.func_78381_a();
            setColor(0x64000000 | DayZHud.UI_COLOR);
            field_78398_a.func_78382_b();
            field_78398_a.func_78374_a((double)(n + n3), (double)(n2 + n4 * (n5 - n7)), 90.0, 1.0, (double)(n5 - n7));
            field_78398_a.func_78374_a((double)(n + 0.0f), (double)(n2 + n4 * (n5 - n6)), 90.0, 0.0, (double)(n5 - n6));
            field_78398_a.func_78374_a((double)(n + 0.0f), (double)(n2 + n4 * dwbg._a(n5 - n6 + 0.020833334f, 0.0f, 1.0f)), 90.0, 0.0, (double)dwbg._a(n5 - n6 + 0.020833334f, 0.0f, 1.0f));
            field_78398_a.func_78374_a((double)(n + n3), (double)(n2 + n4 * dwbg._a(n5 - n7 + 0.020833334f, 0.0f, 1.0f)), 90.0, 1.0, (double)dwbg._a(n5 - n7 + 0.020833334f, 0.0f, 1.0f));
            field_78398_a.func_78381_a();
            setColor(0xC0000000 | DayZHud.UI_COLOR);
            field_78398_a.func_78382_b();
            field_78398_a.func_78374_a((double)(n + 0.0f), (double)(n2 + n4), 90.0, 0.0, 1.0);
            field_78398_a.func_78374_a((double)(n + n3), (double)(n2 + n4), 90.0, 1.0, 1.0);
            field_78398_a.func_78374_a((double)(n + n3), (double)(n2 + n4 * dwbg._a(n5 - n7 + 0.020833334f, 0.0f, 1.0f)), 90.0, 1.0, (double)dwbg._a(n5 - n7 + 0.020833334f, 0.0f, 1.0f));
            field_78398_a.func_78374_a((double)(n + 0.0f), (double)(n2 + n4 * dwbg._a(n5 - n6 + 0.020833334f, 0.0f, 1.0f)), 90.0, 0.0, (double)dwbg._a(n5 - n6 + 0.020833334f, 0.0f, 1.0f));
            field_78398_a.func_78381_a();
        }
    }
    
    public static void drawTexturedRectEasy(final ResourceLocation resourceLocation, final float n, final float n2, final float n3, final float n4) {
        DayZHud.mc._f._a(resourceLocation);
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a((double)(n + 0.0f), (double)(n2 + n4), 90.0, 0.0, 1.0);
        field_78398_a.func_78374_a((double)(n + n3), (double)(n2 + n4), 90.0, 1.0, 1.0);
        field_78398_a.func_78374_a((double)(n + n3), (double)(n2 + 0.0f), 90.0, 1.0, 0.0);
        field_78398_a.func_78374_a((double)(n + 0.0f), (double)(n2 + 0.0f), 90.0, 0.0, 0.0);
        field_78398_a.func_78381_a();
    }
    
    public static void tickHints() {
        if (DayZHud.mc._r == null) {
            return;
        }
        DayZHud.$tmp_list.clear();
        final Iterator<Hint> iterator = DayZHud.hints.values().iterator();
        while (iterator.hasNext()) {
            final Hint hint = iterator.next();
            if (hint.remove()) {
                iterator.remove();
            }
            else {
                hint.addHints(DayZHud.$tmp_list);
            }
        }
    }
    
    public static void drawTexturedRect(final double n, final double n2, final double n3, final double n4) {
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a(n + 0.0, n2 + n4, 0.0, 0.0, 1.0);
        field_78398_a.func_78374_a(n + n3, n2 + n4, 0.0, 1.0, 1.0);
        field_78398_a.func_78374_a(n + n3, n2 + 0.0, 0.0, 1.0, 0.0);
        field_78398_a.func_78374_a(n + 0.0, n2 + 0.0, 0.0, 0.0, 0.0);
        field_78398_a.func_78381_a();
    }
    
    private static float angularDistance(final float n, final float n2) {
        final float n3 = Math.abs(n2 - n) % 360.0f;
        return (n3 > 180.0f) ? (360.0f - n3) : n3;
    }
    
    public static void setColor(final int n) {
        GL11.glColor4f((n >> 16 & 0xFF) / 255.0f, (n >> 8 & 0xFF) / 255.0f, (n & 0xFF) / 255.0f, (n >> 24 & 0xFF) / 255.0f);
    }
    
    static {
        debug = new LinkedHashMap<String, String>();
        DEBUG = Boolean.parseBoolean(System.getProperty("vz.dayz.hud.debug"));
        DayZHud.UI_COLOR = loadUiColor();
        directions = new String[] { "S", "SW", "W", "NW", "N", "NE", "E", "SE" };
        DayZHud.circle = new ResourceLocation("hcsmod:circle.png");
        DayZHud.leaves = new ResourceLocation("hcsmod:green.png");
        DayZHud.arrow = new ResourceLocation("hcsmod:arrow.png");
        DayZHud.mc = tuor._E();
        low_hp_screen = new ResourceLocation("hcsmod:textures/gui/blood_hud.png");
        blood = new ResourceLocation("hcsmod:textures/gui/blood.png");
        food = new ResourceLocation("hcsmod:textures/gui/food.png");
        thrist = new ResourceLocation("hcsmod:textures/gui/water.png");
        gun = new ResourceLocation("hcsmod:textures/items/gun.png");
        pwrn = new ResourceLocation("hcsmod:pwrn.png");
        detect = new ResourceLocation("hcsmod:textures/gui/run.png");
        detect_1 = new ResourceLocation("hcsmod:textures/gui/detect/level_1.png");
        detect_2 = new ResourceLocation("hcsmod:textures/gui/detect/level_2.png");
        detect_3 = new ResourceLocation("hcsmod:textures/gui/detect/level_3.png");
        detect_4 = new ResourceLocation("hcsmod:textures/gui/detect/level_4.png");
        $tmp_list = new ArrayList<String>();
        (hints = new LinkedHashMap<String, Hint>()).put("charstatus", new Hint() {
            @Override
            public boolean remove() {
                return false;
            }
            
            @Override
            public void addHints(final List<String> list) {
                final EntityClientPlayerMP r = DayZHud.mc._r;
                final ExtendedPlayer client = ExtendedPlayer.client(((EntityPlayer)r).field_71092_bJ);
                list.add("\u041a\u0440\u043e\u0432\u044c: " + (int)(((EntityPlayer)r).func_110143_aJ() * 600.0f));
                list.add("GPS: " + dwbg._c(((EntityPlayer)r).field_70165_t) + ", " + dwbg._c(((EntityPlayer)r).field_70161_v));
                if (client.healing > 0.0f) {
                    list.add("§a\u041b\u0435\u0447\u0435\u043d\u0438\u0435: " + (100 - (int)client.healing) + "%");
                }
                if (((EntityPlayer)r).func_82165_m(Effect.bleeding.func_76396_c())) {
                    list.add("§c\u041a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u0435");
                }
                if (((EntityPlayer)r).func_70644_a(lodj.field_76421_d)) {
                    list.add("§c\u0421\u043b\u043e\u043c\u0430\u043d\u044b \u043d\u043e\u0433\u0438");
                }
                final int hunger = client.hunger;
                if (hunger >= 78000) {
                    list.add("§c\u0423\u043c\u0438\u0440\u0430\u044e \u043e\u0442 \u0433\u043e\u043b\u043e\u0434\u0430");
                }
                else if (hunger >= 54600) {
                    list.add("§e\u0413\u043e\u043b\u043e\u0434\u0435\u043d");
                }
                final int thirst = client.thirst;
                if (thirst >= 78000) {
                    list.add("§c\u0423\u043c\u0438\u0440\u0430\u044e \u043e\u0442 \u0436\u0430\u0436\u0434\u044b");
                }
                else if (thirst >= 54600) {
                    list.add("§e\u0425\u043e\u0447\u0443 \u043f\u0438\u0442\u044c");
                }
                if (HcsClient.overheat <= -1.0f) {
                    list.add("§c\u0417\u0430\u043c\u0435\u0440\u0437\u0430\u044e \u043d\u0430\u0441\u043c\u0435\u0440\u0442\u044c");
                }
                else if (HcsClient.overheat < 0.0f) {
                    list.add("§e\u0425\u043e\u043b\u043e\u0434\u043d\u043e, \u043d\u0430\u0434\u043e \u0441\u043e\u0433\u0440\u0435\u0442\u044c\u0441\u044f");
                }
                else if (HcsClient.overheat >= 1.0f) {
                    list.add("§c\u0423\u043c\u0438\u0440\u0430\u044e \u043e\u0442 \u0436\u0430\u0440\u044b");
                }
                else if (HcsClient.overheat > 0.0f) {
                    list.add("§e\u0421\u043b\u0438\u0448\u043a\u043e\u043c \u0442\u0435\u043f\u043b\u043e");
                }
            }
        });
        SHADER = DayZShader.createIfSupported();
        final File file = new File("vLowHP");
        if (!file.exists()) {
            DayZHud.ENABLE_SHADER = GLContext.getCapabilities().OpenGL30;
        }
        else {
            DayZHud.ENABLE_SHADER = (file.length() > 0L);
        }
    }
    
    public interface Hint
    {
        boolean remove();
        
        void addHints(final List<String> p0);
    }
}
