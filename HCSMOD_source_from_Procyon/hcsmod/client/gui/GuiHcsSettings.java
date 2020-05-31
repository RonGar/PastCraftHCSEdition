// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.gui;

import java.io.IOException;
import java.io.FileOutputStream;
import net.minecraft.util.dwbg;
import org.lwjgl.opengl.GL11;
import vintarz.prw.PreRenderedWorld;
import org.lwjgl.input.Keyboard;
import hcsmod.client.hud.DayZHud;
import hcsmod.client.HcsClient;
import hcsmod.flashlight.FlashlightClient;
import net.minecraft.client.tuor;
import hcsmod.player.ExtendedPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiHcsSettings extends dwms
{
    public static final ResourceLocation palette;
    private dwms parentScreen;
    private boolean color;
    private boolean prw;
    private tdvs lowHPbutton;
    private int cx;
    private int cy;
    
    public GuiHcsSettings(final dwms parentScreen) {
        this.color = false;
        this.prw = false;
        this.parentScreen = parentScreen;
    }
    
    public void func_73866_w_() {
        int n = this.field_73881_g / 2 - 84 - 12;
        final ExtendedPlayer client = ExtendedPlayer.client(this.field_73882_e._r.field_71092_bJ);
        this.field_73887_h.add(new jhjl(-1, this.field_73880_f / 2 + 2, n, 98, 20, (jhjl.uxsf)new jhjl.uxsf() {
            public String get(final float n) {
                ExtendedPlayer.client(tuor._E()._r.field_71092_bJ).guns_offset = (int)Math.min(n * 7.0f / 6.0f * 6.0f, 6.0f);
                return null;
            }
        }, "\u0421\u043b\u043e\u0442\u044b \u043e\u0440\u0443\u0436\u0438\u044f", client.guns_offset / 6.0f));
        n += 24;
        this.field_73887_h.add(new tdvs(2, this.field_73880_f / 2 + 2, n, 98, 20, "\u041a\u043e\u0431\u0443\u0440\u0430: " + (client.guns_3rd_left ? "\u0441\u043b\u0435\u0432\u0430" : "\u0441\u043f\u0440\u0430\u0432\u0430")));
        n += 24;
        this.field_73887_h.add(new tdvs(1, this.field_73880_f / 2 + 2, n, 98, 20, "\u0427\u0443\u0436\u0438\u0435 \u0444\u043e\u043d\u0430\u0440\u0438: " + (FlashlightClient.seeOtherPlayers() ? "\u0432\u043a\u043b" : "\u0432\u044b\u043a\u043b")));
        n += 24;
        this.field_73887_h.add(new tdvs(5, this.field_73880_f / 2 + 2, n, 98, 20, "\u041e\u0440\u0443\u0436\u0438\u0435: " + (HcsClient.fancyGuns ? "\u041d\u041e\u0412\u041e\u0415" : "\u0421\u0422\u0410\u0420\u041e\u0415")));
        if (DayZHud.DEBUG) {
            if (Keyboard.isKeyDown(46)) {
                PreRenderedWorld.VBO = false;
            }
            else if (Keyboard.isKeyDown(49)) {
                PreRenderedWorld.VBO = true;
            }
        }
        n += 24;
        if (PreRenderedWorld.VBO) {
            this.field_73887_h.add(new jhjl(-1, this.field_73880_f / 2 - 100, n, 200, 20, (jhjl.uxsf)new jhjl.uxsf() {
                public String get(final float n) {
                    PreRenderedWorld.userRadiusWorld = (int)(64.0f * n);
                    GuiHcsSettings.this.prw = true;
                    return PreRenderedWorld.userRadiusWorld * 16 + "\u043c\u0435\u0442\u0440.";
                }
            }, "\u0414\u0430\u043b\u044c\u043d\u044f\u044f \u043f\u0440\u043e\u0433\u0440\u0443\u0437\u043a\u0430 \u043c\u0438\u0440\u0430: ", PreRenderedWorld.userRadiusWorld / 64.0f));
            n += 24;
            this.field_73887_h.add(new tdvs(4, this.field_73880_f / 2 - 100, n, "\u0421\u0442\u0438\u043b\u044c \u0434\u0430\u043b\u044c\u043d\u0435\u0439 \u043f\u0440\u043e\u0433\u0440\u0443\u0437\u043a\u0438: " + (PreRenderedWorld.singleColored ? "\u043e\u0434\u0438\u043d \u0446\u0432\u0435\u0442" : "\u0442\u0435\u043a\u0441\u0442\u0443\u0440\u044b")));
        }
        else {
            n += 24;
        }
        if (DayZHud.SHADER != null) {
            n += 24;
            this.field_73887_h.add(this.lowHPbutton = new tdvs(6, this.field_73880_f / 2 - 100, n, "\u042d\u043a\u0440\u0430\u043d \u043a\u043e\u0433\u0434\u0430 \u043c\u0430\u043b\u043e \u043a\u0440\u043e\u0432\u0438: " + (DayZHud.ENABLE_SHADER ? "\u0447\u0435\u0440\u043d\u043e-\u0431\u0435\u043b\u044b\u0439" : "\u0441\u0435\u0440\u044b\u0439")));
        }
        n += 24;
        this.field_73887_h.add(new tdvs(3, this.field_73880_f / 2 - 100, n, "\u0421\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u043e \u043f\u0440\u043e\u0438\u0437\u0432\u043e\u0434\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u0438: " + (HcsClient.warnAboutPCResources() ? "\u0412\u041a\u041b" : "\u0412\u042b\u041a\u041b")));
        n += 24;
        this.field_73887_h.add(new tdvs(0, this.field_73880_f / 2 - 100, n, "\u041d\u0430\u0437\u0430\u0434"));
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        GL11.glEnable(3042);
        int n4 = this.field_73880_f / 2;
        if (!this.color) {
            if (this.lowHPbutton != null && this.lowHPbutton.func_82252_a()) {
                this.lowHPbutton.func_73737_a(this.field_73882_e, n, n2);
                DayZHud.SHOW_LOW_HP = true;
                this.func_73732_a(this.field_73882_e._x, "\u0427\u0435\u0440\u043d\u043e-\u0431\u0435\u043b\u044b\u0439 \u044d\u043a\u0440\u0430\u043d \u0441\u0438\u043b\u044c\u043d\u043e \u0440\u0435\u0436\u0435\u0442 FPS \u043d\u0430 \u043d\u0435\u043a\u043e\u0442\u043e\u0440\u044b\u0445 \u0432\u0438\u0434\u0435\u043e\u043a\u0430\u0440\u0442\u0430\u0445", n4, this.field_73881_g / 2 + 70, -1);
                return;
            }
            this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, -1072689136, -804253680);
            super.func_73863_a(n, n2, n3);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, this.color ? 0.75f : 0.5f);
        this.field_73882_e._f._a(GuiHcsSettings.palette);
        final int n5 = this.field_73881_g / 2 - 54;
        DayZHud.drawTexturedRect(n4 - 100, n5 - 50, 100.0, 100.0);
        if (!this.color) {
            func_73734_a(n4 - 100, n5 - 5, n4, n5 + 5, 2130706432);
            this.func_73732_a(this.field_73882_e._x, "\u0426\u0432\u0435\u0442 \u0438\u043d\u0442\u0435\u0440\u0444\u0435\u0439\u0441\u0430", n4 - 50, n5 - 4, -1);
            if (!PreRenderedWorld.VBO) {
                int n6 = this.field_73881_g / 2 + 6;
                this.func_73732_a(this.field_73882_e._x, "\u0414\u0430\u043b\u044c\u043d\u044f\u044f \u043f\u0440\u043e\u0433\u0440\u0443\u0437\u043a\u0430 \u043c\u0438\u0440\u0430", n4, n6, -1);
                n6 += 12;
                this.func_73732_a(this.field_73882_e._x, "\u043d\u0435 \u043f\u043e\u0434\u0434\u0435\u0440\u0436\u0438\u0432\u0430\u0435\u0442\u0441\u044f", n4, n6, -1);
                n6 += 12;
                this.func_73732_a(this.field_73882_e._x, "\u043d\u0430 \u0442\u0432\u043e\u0451\u043c \u043a\u043e\u043c\u043f\u044c\u044e\u0442\u0435\u0440\u0435.", n4, n6, -1);
            }
        }
        else {
            this.color(n, n2);
            n4 -= 50;
            func_73734_a(n4 + this.cx - 5, n5 + this.cy - 5, n4 + this.cx + 5, n5 + this.cy + 5, -16777216);
            func_73734_a(n4 + this.cx - 4, n5 + this.cy - 4, n4 + this.cx + 4, n5 + this.cy + 4, 0xFF000000 | DayZHud.UI_COLOR);
        }
    }
    
    protected void func_73869_a(final char c, final int n) {
        if (n == 1) {
            this.field_73882_e._a(this.parentScreen);
        }
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) {
        final int n4 = this.field_73880_f / 2 - 50 - n;
        final int n5 = this.field_73881_g / 2 - 54 - n2;
        if (dwbg._c((float)(n4 * n4 + n5 * n5)) <= 51.0f) {
            this.color = true;
            this.func_85041_a(n, n2, n3, 0L);
        }
        super.func_73864_a(n, n2, n3);
    }
    
    protected void func_73879_b(final int n, final int n2, final int n3) {
        if (this.color) {
            this.color = false;
            DayZHud.saveUiColor();
        }
        if (this.prw) {
            this.prw = false;
            PreRenderedWorld.saveSettings();
        }
        super.func_73879_b(n, n2, n3);
    }
    
    protected void color(final int n, final int n2) {
        this.cx = this.field_73880_f / 2 - 50 - n;
        this.cy = this.field_73881_g / 2 - 54 - n2;
        float n3 = (float)(0.5 + 0.5 * Math.atan2(this.cy, this.cx) / 3.141592653589793);
        if (n3 >= 1.0f) {
            n3 = 0.0f;
        }
        final float n4 = Math.min(dwbg._c((float)(this.cx * this.cx + this.cy * this.cy)), 50.0f) / 75.0f;
        DayZHud.UI_COLOR = hsv2rgb(n3, n4, 1.0f);
        this.cx = (int)(dwbg._b(n3 * 3.1415927f * 2.0f) * n4 * 75.0f);
        this.cy = (int)(dwbg._a(n3 * 3.1415927f * 2.0f) * n4 * 75.0f);
    }
    
    protected void func_73875_a(final tdvs tdvs) {
        final ExtendedPlayer client = ExtendedPlayer.client(this.field_73882_e._r.field_71092_bJ);
        switch (tdvs.field_73741_f) {
            case 0: {
                this.field_73882_e._a(this.parentScreen);
                break;
            }
            case 1: {
                if (FlashlightClient.toggleOtherPlayers()) {
                    tdvs.field_73744_e = "\u0427\u0443\u0436\u0438\u0435 \u0444\u043e\u043d\u0430\u0440\u0438: \u0432\u043a\u043b";
                    break;
                }
                tdvs.field_73744_e = "\u0427\u0443\u0436\u0438\u0435 \u0444\u043e\u043d\u0430\u0440\u0438: \u0432\u044b\u043a\u043b";
                break;
            }
            case 2: {
                client.guns_3rd_left = !client.guns_3rd_left;
                tdvs.field_73744_e = "\u041a\u043e\u0431\u0443\u0440\u0430: " + (client.guns_3rd_left ? "\u0441\u043b\u0435\u0432\u0430" : "\u0441\u043f\u0440\u0430\u0432\u0430");
                break;
            }
            case 3: {
                HcsClient.togglePCResourcesWarning();
                tdvs.field_73744_e = "\u0421\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u043e \u043f\u0440\u043e\u0438\u0437\u0432\u043e\u0434\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u0438: " + (HcsClient.warnAboutPCResources() ? "\u0412\u041a\u041b" : "\u0412\u042b\u041a\u041b");
                break;
            }
            case 4: {
                PreRenderedWorld.singleColored = !PreRenderedWorld.singleColored;
                PreRenderedWorld.saveSettings();
                tdvs.field_73744_e = "\u0421\u0442\u0438\u043b\u044c \u0434\u0430\u043b\u044c\u043d\u0435\u0439 \u043f\u0440\u043e\u0433\u0440\u0443\u0437\u043a\u0438: " + (PreRenderedWorld.singleColored ? "\u043e\u0434\u0438\u043d \u0446\u0432\u0435\u0442" : "\u0442\u0435\u043a\u0441\u0442\u0443\u0440\u044b");
                break;
            }
            case 5: {
                if (HcsClient.togglefancyGuns()) {
                    tdvs.field_73744_e = "\u041e\u0440\u0443\u0436\u0438\u0435: \u041d\u041e\u0412\u041e\u0415";
                }
                else {
                    tdvs.field_73744_e = "\u041e\u0440\u0443\u0436\u0438\u0435: \u0421\u0422\u0410\u0420\u041e\u0415";
                }
                HcsClient.clearDL = true;
                break;
            }
            case 6: {
                DayZHud.ENABLE_SHADER = !DayZHud.ENABLE_SHADER;
                try {
                    final FileOutputStream fileOutputStream = new FileOutputStream("vLowHP", false);
                    Throwable t = null;
                    try {
                        if (DayZHud.ENABLE_SHADER) {
                            fileOutputStream.write(0);
                        }
                        fileOutputStream.close();
                    }
                    catch (Throwable t2) {
                        t = t2;
                        throw t2;
                    }
                    finally {
                        if (t != null) {
                            try {
                                fileOutputStream.close();
                            }
                            catch (Throwable exception) {
                                t.addSuppressed(exception);
                            }
                        }
                        else {
                            fileOutputStream.close();
                        }
                    }
                }
                catch (IOException cause) {
                    throw new RuntimeException(cause);
                }
                tdvs.field_73744_e = "\u042d\u043a\u0440\u0430\u043d \u043a\u043e\u0433\u0434\u0430 \u043c\u0430\u043b\u043e \u043a\u0440\u043e\u0432\u0438: " + (DayZHud.ENABLE_SHADER ? "\u0447\u0435\u0440\u043d\u043e-\u0431\u0435\u043b\u044b\u0439" : "\u0441\u0435\u0440\u044b\u0439");
                break;
            }
        }
    }
    
    public static int hsv2rgb(final float n, final float n2, final float n3) {
        final int n4 = (int)(n * 6.0f);
        final float n5 = n * 6.0f - n4;
        final float n6 = n3 * (1.0f - n2);
        final float n7 = n3 * (1.0f - n5 * n2);
        final float n8 = n3 * (1.0f - (1.0f - n5) * n2);
        switch (n4) {
            case 0: {
                return rgb2int(n3, n8, n6);
            }
            case 1: {
                return rgb2int(n7, n3, n6);
            }
            case 2: {
                return rgb2int(n6, n3, n8);
            }
            case 3: {
                return rgb2int(n6, n7, n3);
            }
            case 4: {
                return rgb2int(n8, n6, n3);
            }
            case 5: {
                return rgb2int(n3, n6, n7);
            }
            default: {
                return 0;
            }
        }
    }
    
    public static int rgb2int(final float n, final float n2, final float n3) {
        return 0x0 | (int)(n * 255.0f) << 16 | (int)(n2 * 255.0f) << 8 | (int)(n3 * 255.0f);
    }
    
    static {
        palette = new ResourceLocation("hcsmod:palette.png");
    }
}
