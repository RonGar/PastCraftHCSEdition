// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.player;

import net.minecraft.client.tuor;
import hcsmod.effects.Effect;
import java.util.LinkedHashMap;
import net.minecraft.util.dwbg;
import hcsmod.client.gui.GuiClanSystem;
import java.net.URI;
import java.awt.Desktop;
import vintarz.ingamestore.client.GuiCategories;
import cpw.mods.fml.common.network.PacketDispatcher;
import co.uk.flansmods.common.network.PacketGunModButton;
import java.io.IOException;
import vintarz.core.VCP;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;
import java.util.Iterator;
import net.minecraft.util.rojd;
import org.lwjgl.input.Keyboard;
import hcsmod.client.CClanSystem;
import hcsmod.client.HcsClient;
import java.util.ArrayList;
import net.minecraft.entity.item.EntityItem;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public abstract class InventoryDayZ extends zwlp
{
    public static final Map<String, IPlayerState> playerState;
    private static final ResourceLocation pckpbg;
    private static final List<String> tmp_list;
    static final uyeb itemRenderer;
    private final List<EntityItem> temp;
    private GuiEntityItemButton hoveredButton;
    private zfly gpsX;
    private zfly gpsZ;
    private tdvs gpsButton;
    private int brButtonsOffset;
    
    InventoryDayZ(final ivrt ivrt) {
        super(ivrt);
        this.temp = new ArrayList<EntityItem>();
        this.gpsButton = new GuiTransparentButton(1, 0, 0, 32, 25, (String)null, new String[] { "\u041d\u0430\u0432\u0438\u0433\u0430\u0446\u0438\u044f \u043f\u043e \u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0430\u043c (X, Z).", "\u0412\u0432\u0435\u0434\u0438 \u0438\u0445 \u0438 \u043d\u0430\u0436\u043c\u0438 \u0412\u041a\u041b, \u043f\u043e\u0441\u043b\u0435 \u0447\u0435\u0433\u043e", " \u0438\u0434\u0438 \u043f\u043e \u0441\u0442\u0440\u0435\u043b\u043a\u0435 \u043d\u0430\u0434 \u0445\u043e\u0442\u0431\u0430\u0440\u043e\u043c." });
    }
    
    public void func_73866_w_() {
        super.func_73866_w_();
        final int n = this.field_74198_m + (this.field_73882_e._r.field_71075_bZ._d ? 100 : 0);
        this.gpsX = new zfly(this.field_73886_k, n + 99, this.field_74197_n + (this.field_73882_e._r.field_71075_bZ._d ? -24 : 54), 39, 10);
        this.gpsZ = new zfly(this.field_73886_k, n + 99, this.field_74197_n + (this.field_73882_e._r.field_71075_bZ._d ? -12 : 67), 39, 10);
        this.gpsX._f(5);
        this.gpsZ._f(5);
        this.gpsX._a(Integer.toString(HcsClient.gpsX));
        this.gpsZ._a(Integer.toString(HcsClient.gpsZ));
        this.field_73887_h.add(this.gpsButton);
        this.gpsButton.field_73744_e = (HcsClient.gpsEnabled ? "\u0412\u044b\u043a\u043b" : "\u0412\u043a\u043b");
        this.gpsButton.field_73746_c = n + 140;
        this.gpsButton.field_73743_d = this.field_74197_n + (this.field_73882_e._r.field_71075_bZ._d ? -25 : 53);
        final int n2 = this.field_74198_m + this.field_74194_b;
        this.brButtonsOffset = this.field_74197_n + 166;
        this.field_73887_h.add(new GuiTransparentButton(2, n2 - 2, this.brButtonsOffset -= 12, 112, 10, "\u0410\u043f\u0433\u0440\u0435\u0439\u0434 \u043e\u0440\u0443\u0436\u0438\u044f", new String[] { "\u041e\u0442\u043a\u0440\u044b\u0432\u0430\u0435\u0442\u0441\u044f \u043a\u043d\u043e\u043f\u043a\u043e\u0439 U", "(\u0435\u0441\u043b\u0438 \u0442\u044b \u043d\u0435 \u043c\u0435\u043d\u044f\u043b \u0435\u0435 \u0432 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0430\u0445)" }));
        this.field_73887_h.add(new GuiTransparentButton(3, n2 - 2, this.brButtonsOffset -= 12, 112, 10, "\u041c\u0430\u0433\u0430\u0437\u0438\u043d \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432", new String[] { "\u041e\u0442\u043a\u0440\u044b\u0432\u0430\u0435\u0442\u0441\u044f \u043a\u043d\u043e\u043f\u043a\u043e\u0439 F5" }));
        this.field_73887_h.add(new GuiTransparentButton(4, n2 - 2, this.brButtonsOffset -= 12, 112, 10, "\u0414\u043e\u043d\u0430\u0442 \u043c\u0430\u0433\u0430\u0437\u0438\u043d", new String[] { "\u0421\u0430\u0439\u0442 https://store.hcs.land/" }));
        this.field_73887_h.add(new GuiTransparentButton(6, n2 - 2, this.brButtonsOffset -= 12, 112, 10, "\u041e\u043d\u043b\u0430\u0439\u043d \u043a\u0430\u0440\u0442\u0430 DayZ", new String[] { "\u0421\u0430\u0439\u0442 https://dayzmap.hcs.land/", "\u041f\u0440\u0438 \u043e\u0442\u043a\u0440\u044b\u0442\u0438\u0438 \u043f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u043e\u0431\u043b\u0430\u0441\u0442\u044c", "\u0432 \u043a\u043e\u0442\u043e\u0440\u043e\u0439 \u0442\u044b \u043d\u0430\u0445\u043e\u0434\u0438\u0448\u044c\u0441\u044f." }));
        if (CClanSystem.CLANSYSTEM_ENABLED) {
            this.field_73887_h.add(new GuiTransparentButton(5, n2 - 2, this.brButtonsOffset -= 12, 112, 10, "\u041c\u0435\u043d\u044e \u043a\u043b\u0430\u043d\u043e\u0432", new String[] { "\u041e\u0442\u043a\u0440\u044b\u0432\u0430\u0435\u0442\u0441\u044f \u043a\u043d\u043e\u043f\u043a\u043e\u0439 F3" }));
        }
        this.brButtonsOffset -= 8;
    }
    
    private void updateKey(final int n) {
        hbei._a(n, this.field_73882_e._z == this && Keyboard.isKeyDown(n));
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) {
        this.gpsX._a(n, n2, n3);
        this.gpsZ._a(n, n2, n3);
        super.func_73864_a(n, n2, n3);
    }
    
    protected void func_73869_a(final char c, final int n) {
        final String b = this.gpsX._b();
        final String b2 = this.gpsZ._b();
        final int h = this.gpsX._h();
        final int h2 = this.gpsZ._h();
        zfly zfly = null;
        if (this.gpsX._a(c, n)) {
            zfly = this.gpsX;
        }
        if (this.gpsZ._a(c, n)) {
            zfly = this.gpsZ;
        }
        if (zfly == null) {
            super.func_73869_a(c, n);
        }
        else {
            try {
                final String b3 = zfly._b();
                if (b3.isEmpty() || b3.equals("-") || Math.abs(Integer.parseInt(b3)) < 10000) {
                    zfly = null;
                }
            }
            catch (Throwable t) {}
            if (zfly == null) {
                HcsClient.gpsEnabled = false;
            }
            else if (zfly == this.gpsX) {
                this.gpsX._a(b);
                this.gpsX._e(h);
            }
            else if (zfly == this.gpsZ) {
                this.gpsZ._a(b2);
                this.gpsZ._e(h2);
            }
        }
    }
    
    public void func_73876_c() {
        this.temp.clear();
        int n = 0;
        final rojd func_72314_b = this.field_73882_e._r.field_70121_D.func_72314_b(3.1, 1.0, 3.1);
        final Iterator<tdvs> iterator = (Iterator<tdvs>)this.field_73887_h.iterator();
        while (iterator.hasNext()) {
            final tdvs tdvs = iterator.next();
            if (tdvs.field_73741_f == 0) {
                final GuiEntityItemButton guiEntityItemButton = (GuiEntityItemButton)tdvs;
                if (guiEntityItemButton.ei.field_70128_L || !guiEntityItemButton.ei.field_70121_D.func_72326_a(func_72314_b) || n >= 45) {
                    iterator.remove();
                }
                else {
                    this.temp.add(guiEntityItemButton.ei);
                    guiEntityItemButton.field_73746_c = this.field_74198_m - 103 + n % 6 * 18;
                    guiEntityItemButton.field_73743_d = this.field_74197_n + 16 + n / 6 * 18;
                    ++n;
                }
            }
        }
        for (final EntityItem entityItem : this.field_73882_e._p.func_72872_a((Class)EntityItem.class, func_72314_b)) {
            if (!this.temp.contains(entityItem) && n < 45) {
                final GuiEntityItemButton guiEntityItemButton2 = new GuiEntityItemButton(this, entityItem);
                this.field_73887_h.add(guiEntityItemButton2);
                guiEntityItemButton2.field_73746_c = this.field_74198_m - 103 + n % 6 * 18;
                guiEntityItemButton2.field_73743_d = this.field_74197_n + 16 + n / 6 * 18;
                ++n;
            }
        }
        this.updateKey(this.field_73882_e._K.__bd._d);
        this.updateKey(this.field_73882_e._K.__bf._d);
        this.updateKey(this.field_73882_e._K.__be._d);
        this.updateKey(this.field_73882_e._K.__bg._d);
        this.updateKey(this.field_73882_e._K.__bh._d);
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        this.hoveredButton = null;
        InventoryDayZ.tmp_list.clear();
        super.func_73863_a(n, n2, n3);
        if (this.hoveredButton != null) {
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            final int field_73746_c = this.hoveredButton.field_73746_c;
            final int field_73743_d = this.hoveredButton.field_73743_d;
            this.func_73733_a(field_73746_c, field_73743_d, field_73746_c + 16, field_73743_d + 16, -2130706433, -2130706433);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            this.func_74184_a(this.hoveredButton.ei.func_92059_d(), n, n2);
        }
        if (!InventoryDayZ.tmp_list.isEmpty()) {
            this.drawHoveringText((List)InventoryDayZ.tmp_list, n, n2, this.field_73882_e._x);
        }
    }
    
    protected void func_74185_a(final float n, final int n2, final int n3) {
        this.field_73882_e._f._a(InventoryDayZ.pckpbg);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 10.0f);
        GL11.glEnable(3042);
        this.func_73729_b(this.field_74198_m - 112, this.field_74197_n, 143, 0, 112, 166);
        this.func_73729_b(this.field_74198_m + this.field_74194_b, this.field_74197_n, 0, 0, 112, 166);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        this.field_73882_e._x._b("\u041b\u0443\u0442 \u043f\u043e\u0431\u043b\u0438\u0437\u043e\u0441\u0442\u0438", this.field_74198_m - 100, this.field_74197_n + 4, 14737632);
        this.gpsX._f();
        this.gpsZ._f();
        GL11.glEnable(3042);
        final int n4 = this.field_74198_m + this.field_74194_b - 4;
        if (!this.field_73882_e._r.field_71075_bZ._d) {
            this.func_73732_a(this.field_73882_e._x, "GPS (x, z)", this.field_74198_m + 135, this.field_74197_n + 44, 14737632);
        }
        this.field_73882_e._x._b("\u0421\u043e\u0441\u0442\u043e\u044f\u043d\u0438\u0435 \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u0436\u0430", n4 + 2, this.field_74197_n + 2, 14737632);
        this.field_73882_e._x._b("\u041f\u043e\u043b\u0435\u0437\u043d\u044b\u0435 \u043a\u043d\u043e\u043f\u043a\u0438", n4 + 2, this.brButtonsOffset, 14737632);
        final int n5 = this.field_74198_m + this.field_74194_b - 2;
        int n6 = this.field_74197_n + 10;
        final EntityClientPlayerMP r = this.field_73882_e._r;
        final ExtendedPlayer client = ExtendedPlayer.client(((EntityPlayer)r).field_71092_bJ);
        for (final Map.Entry<String, IPlayerState> entry : InventoryDayZ.playerState.entrySet()) {
            drawOutlinedRect(n5, n6, 112, 10, -1773647800);
            this.field_73882_e._x._b(entry.getKey() + ": " + entry.getValue().status((EntityPlayer)r, client), n5 + 1, n6 + 1, -1);
            if (n2 >= n5 && n3 >= n6 && n2 <= n5 + 112 && n3 <= n6 + 10 && InventoryDayZ.tmp_list.isEmpty()) {
                entry.getValue().description(InventoryDayZ.tmp_list, (EntityPlayer)r, client);
            }
            n6 += 12;
        }
    }
    
    protected void func_73875_a(final tdvs tdvs) {
        if (tdvs.field_73741_f == 0) {
            if (this.field_73882_e._r.field_71071_by._g() == null) {
                final GuiEntityItemButton guiEntityItemButton = (GuiEntityItemButton)tdvs;
                try {
                    final VCP vcp = new VCP(6, "HCSMOD");
                    vcp.writeInt(guiEntityItemButton.ei.field_70157_k);
                    vcp.writeBoolean(Keyboard.isKeyDown(42));
                    vcp.send();
                }
                catch (IOException ex) {}
            }
        }
        else if (tdvs.field_73741_f == 1) {
            if (HcsClient.gpsEnabled = !HcsClient.gpsEnabled) {
                try {
                    HcsClient.gpsX = Integer.parseInt(this.gpsX._b());
                }
                catch (Throwable t) {
                    this.gpsX._a("0");
                    HcsClient.gpsX = 0;
                }
                try {
                    HcsClient.gpsZ = Integer.parseInt(this.gpsZ._b());
                }
                catch (Throwable t2) {
                    this.gpsZ._a("0");
                    HcsClient.gpsZ = 0;
                }
            }
            this.gpsButton.field_73744_e = (HcsClient.gpsEnabled ? "\u0412\u044b\u043a\u043b" : "\u0412\u043a\u043b");
        }
        else if (tdvs.field_73741_f == 2) {
            PacketDispatcher.sendPacketToServer(PacketGunModButton.buildButtonOpenGuiPacket());
        }
        else if (tdvs.field_73741_f == 3) {
            this.field_73882_e._a((dwms)new GuiCategories());
            new VCP(0, "vzshop").send();
        }
        else if (tdvs.field_73741_f == 4) {
            try {
                Desktop.getDesktop().browse(new URI("https://store.hcs.land/"));
            }
            catch (Throwable t3) {}
        }
        else if (tdvs.field_73741_f == 5) {
            if (CClanSystem.CLANSYSTEM_ENABLED) {
                this.field_73882_e._a((dwms)new GuiClanSystem());
            }
        }
        else if (tdvs.field_73741_f == 6) {
            try {
                Desktop.getDesktop().browse(new URI("https://dayzmap.hcs.land/#/" + dwbg._c(this.field_73882_e._r.field_70165_t) + "/64/" + dwbg._c(this.field_73882_e._r.field_70161_v) + "/max/0/0"));
            }
            catch (Throwable t4) {}
        }
    }
    
    public void func_73874_b() {
        this.updateKey(this.field_73882_e._K.__bd._d);
        this.updateKey(this.field_73882_e._K.__bf._d);
        this.updateKey(this.field_73882_e._K.__be._d);
        this.updateKey(this.field_73882_e._K.__bg._d);
        this.updateKey(this.field_73882_e._K.__bh._d);
        this.updateKey(this.field_73882_e._K.__bl._d);
        super.func_73874_b();
    }
    
    private static void drawOutlinedRect(final int n, final int n2, final int n3, final int n4, final int n5) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        func_73734_a(n + 1, n2 + 1, n + n3 - 1, n2 + n4 - 1, n5);
        func_73734_a(n, n2, n + n3, n2 + 1, -8947849);
        func_73734_a(n, n2 + 1, n + 1, n2 + n4, -8947849);
        func_73734_a(n + n3 - 1, n2 + 1, n + n3, n2 + n4, -8947849);
        func_73734_a(n + 1, n2 + n4 - 1, n + n3 - 1, n2 + n4, -8947849);
    }
    
    static {
        (playerState = new LinkedHashMap<String, IPlayerState>()).put("\u041a\u0440\u043e\u0432\u044c", new IPlayerState() {
            @Override
            public String status(final EntityPlayer entityPlayer, final ExtendedPlayer extendedPlayer) {
                return (int)(entityPlayer.func_110143_aJ() * 600.0f) + "/12000";
            }
            
            @Override
            public void description(final List<String> list, final EntityPlayer entityPlayer, final ExtendedPlayer extendedPlayer) {
                list.add("\u041f\u043e\u043f\u043e\u043b\u043d\u044f\u0442\u044c \u043a\u0440\u043e\u0432\u044c \u043c\u043e\u0436\u043d\u043e:");
                list.add(" \u043f\u0430\u043a\u0435\u0442\u043e\u043c \u043a\u0440\u043e\u0432\u0438");
                list.add(" \u043d\u0435\u043c\u043d\u043e\u0433\u043e \u043f\u043e\u043c\u043e\u0433\u0430\u0435\u0442 \u0435\u0434\u0430");
            }
        });
        InventoryDayZ.playerState.put("\u041a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u0435", new IPlayerState() {
            @Override
            public String status(final EntityPlayer entityPlayer, final ExtendedPlayer extendedPlayer) {
                return entityPlayer.func_82165_m(Effect.bleeding.func_76396_c()) ? "\u0435\u0441\u0442\u044c" : "\u043d\u0435\u0442";
            }
            
            @Override
            public void description(final List<String> list, final EntityPlayer entityPlayer, final ExtendedPlayer extendedPlayer) {
                list.add("\u0412 \u0441\u043b\u0443\u0447\u0430\u0435 \u043a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u044f");
                list.add(" \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439 \u0431\u0438\u043d\u0442\u044b.");
            }
        });
        InventoryDayZ.playerState.put("\u041d\u043e\u0433\u0438", new IPlayerState() {
            @Override
            public String status(final EntityPlayer entityPlayer, final ExtendedPlayer extendedPlayer) {
                return entityPlayer.func_70644_a(lodj.field_76421_d) ? "\u0441\u043b\u043e\u043c\u0430\u043d\u044b" : "\u0446\u0435\u043b\u044b";
            }
            
            @Override
            public void description(final List<String> list, final EntityPlayer entityPlayer, final ExtendedPlayer extendedPlayer) {
                list.add("\u0415\u0441\u043b\u0438 \u0441\u043b\u043e\u043c\u0430\u0435\u0448\u044c \u043d\u043e\u0433\u0438");
                list.add(" \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439 \u043c\u043e\u0440\u0444\u0438\u043d.");
            }
        });
        InventoryDayZ.playerState.put("\u0415\u0434\u0430", new IPlayerState() {
            @Override
            public String status(final EntityPlayer entityPlayer, final ExtendedPlayer extendedPlayer) {
                final int hunger = extendedPlayer.hunger;
                String s = "\u0441\u044b\u0442";
                if (hunger >= 78000) {
                    s = "\u0434\u043e\u0445\u043d\u0443 \u0441 \u0433\u043e\u043b\u043e\u0434\u0430";
                }
                else if (hunger >= 54600) {
                    s = "\u0433\u043e\u043b\u043e\u0434\u0435\u043d";
                }
                else if (hunger >= 12000) {
                    s = "\u043d\u0435\u043c\u043d\u043e\u0433\u043e \u0433\u043e\u043b\u043e\u0434\u0435\u043d";
                }
                return s;
            }
            
            @Override
            public void description(final List<String> list, final EntityPlayer entityPlayer, final ExtendedPlayer extendedPlayer) {
                list.add("\u0415\u0441\u043b\u0438 \u043f\u043e\u0435\u0448\u044c \u043a\u043e\u0433\u0434\u0430 \u0441\u044b\u0442 - \u0441\u0442\u043e\u0448\u043d\u0438\u0442.");
                list.add("\u041d\u0435\u043c\u043d\u043e\u0433\u043e \u0433\u043e\u043b\u043e\u0434\u0435\u043d - \u043d\u0438\u0447\u0435\u0433\u043e \u0441\u0442\u0440\u0430\u0448\u043d\u043e\u0433\u043e.");
                list.add("\u0413\u043e\u043b\u043e\u0434\u0435\u043d - \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u0431\u0435\u0436\u0430\u0442\u044c (\u0442\u043e\u043b\u044c\u043a\u043e \u0440\u044b\u0432\u043a\u0430\u043c\u0438).");
                list.add("\u0423\u043c\u0438\u0440\u0430\u044e \u043e\u0442 \u0433\u043e\u043b\u043e\u0434\u0430 - \u0433\u043e\u0432\u043e\u0440\u0438\u0442 \u0441\u0430\u043c\u043e \u0437\u0430 \u0441\u0435\u0431\u044f.");
            }
        });
        InventoryDayZ.playerState.put("\u0412\u043e\u0434\u0430", new IPlayerState() {
            @Override
            public String status(final EntityPlayer entityPlayer, final ExtendedPlayer extendedPlayer) {
                final int thirst = extendedPlayer.thirst;
                String s = "\u043d\u0430\u0441\u044b\u0449\u0435\u043d";
                if (thirst >= 78000) {
                    s = "\u0434\u043e\u0445\u043d\u0443 \u043e\u0442 \u0436\u0430\u0436\u0434\u044b";
                }
                else if (thirst >= 54600) {
                    s = "\u0445\u043e\u0447\u0443 \u043f\u0438\u0442\u044c";
                }
                else if (thirst >= 12000) {
                    s = "\u0432 \u043d\u043e\u0440\u043c\u0435";
                }
                return s;
            }
            
            @Override
            public void description(final List<String> list, final EntityPlayer entityPlayer, final ExtendedPlayer extendedPlayer) {
                list.add("\u0411\u0443\u0434\u0435\u0448\u044c \u043f\u0438\u0442\u044c \u043a\u043e\u0433\u0434\u0430 \u043d\u0430\u0441\u044b\u0449\u0435\u043d - \u0441\u0442\u043e\u0448\u043d\u0438\u0442.");
                list.add("\u041e\u0441\u0442\u0430\u043b\u044c\u043d\u044b\u0435 \u0441\u043e\u0441\u0442\u043e\u044f\u043d\u0438\u044f \u0432\u043f\u043e\u043b\u043d\u0435 \u043f\u043e\u043d\u044f\u0442\u043d\u044b.");
            }
        });
        InventoryDayZ.playerState.put("\u0422\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0430", new IPlayerState() {
            @Override
            public String status(final EntityPlayer entityPlayer, final ExtendedPlayer extendedPlayer) {
                String s = "\u043d\u043e\u0440\u043c\u0430";
                if (HcsClient.overheat <= -1.0f) {
                    s = "\u0437\u0430\u043c\u0435\u0440\u0437";
                }
                else if (HcsClient.overheat < 0.0f) {
                    s = "\u0445\u043e\u043b\u043e\u0434\u043d\u043e";
                }
                else if (HcsClient.overheat >= 1.0f) {
                    s = "\u0436\u0430\u0440\u043a\u043e";
                }
                else if (HcsClient.overheat > 0.0f) {
                    s = "\u0442\u0435\u043f\u043b\u043e";
                }
                if (extendedPlayer.temperature == -2.14748365E9f) {
                    return "\u043e\u0442\u043a\u043b.";
                }
                return s;
            }
            
            @Override
            public void description(final List<String> list, final EntityPlayer entityPlayer, final ExtendedPlayer extendedPlayer) {
                if (extendedPlayer.temperature == -2.14748365E9f) {
                    list.add("\u0422\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0430 \u043e\u0442\u043a\u043b\u044e\u0447\u0435\u043d\u0430 \u043d\u0430 \u044d\u0442\u043e\u043c \u0441\u0435\u0440\u0432\u0435\u0440\u0435.");
                    return;
                }
                list.add("\u0422\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0430 \u0441\u0435\u0439\u0447\u0430\u0441 \u0442\u0435\u0441\u0442\u0438\u0440\u0443\u0435\u0442\u0441\u044f/\u043e\u0442\u043b\u0430\u0436\u0438\u0432\u0430\u0435\u0442\u0441\u044f/\u0431\u0430\u043b\u0430\u043d\u0441\u0438\u0440\u0443\u0435\u0442\u0441\u044f.");
                list.add("\u0421\u043e\u0433\u0440\u0435\u0432\u0430\u0435\u0442 \u0431\u0440\u043e\u043d\u044f, \u043a\u043e\u0441\u0442\u0440\u044b, \u0445\u043e\u0434\u044c\u0431\u0430/\u0431\u0435\u0433, \u0434\u043e\u043c\u0430/\u043f\u0430\u043b\u0430\u0442\u043a\u0438/\u0442\u0440\u0430\u043d\u0441\u043f\u043e\u0440\u0442");
                list.add("\u0414\u043b\u044f \u043e\u0441\u0442\u044b\u0432\u0430\u043d\u0438\u044f \u0441\u043d\u0438\u043c\u0438 \u0431\u0440\u043e\u043d\u044e \u0438 \u043f\u043e\u0441\u0442\u043e\u0439 \u043d\u0430 \u043c\u0435\u0441\u0442\u0435, \u043d\u0435 \u0431\u0435\u0433\u0430\u044f");
                list.add("\u0412\u043e\u0434\u0430 \u043e\u0447\u0435\u043d\u044c \u0445\u043e\u043b\u043e\u0434\u043d\u0430\u044f, \u0434\u043e\u0436\u0434\u044c \u0442\u043e\u0436\u0435 \u0445\u043e\u043b\u043e\u0434\u043d\u044b\u0439. \u041d\u0435 \u0437\u0430\u043c\u0435\u0440\u0437\u043d\u0438.");
                list.add("\u041f\u043e\u0434 \u0434\u043e\u0436\u0434\u0435\u043c \u043f\u043e\u043b\u043e\u0436\u0438 \u0434\u043e\u0436\u0434\u0435\u0432\u0438\u043a \u0432 \u0441\u043b\u043e\u0442 \u043f\u043e\u0434 \u0440\u044e\u043a\u0437\u0430\u043a\u043e\u043c, \u044d\u0442\u043e \u0432\u0430\u0436\u043d\u043e.");
                list.add("\u041d\u043e\u0440\u043c\u0430\u043b\u044c\u043d\u044b\u0439 \u0433\u0430\u0439\u0434 \u0431\u0443\u0434\u0435\u0442 \u043a\u043e\u0433\u0434\u0430-\u043d\u0438\u0431\u0443\u0434\u044c \u043f\u043e\u0442\u043e\u043c. " + extendedPlayer.temperature);
            }
        });
        pckpbg = new ResourceLocation("hcsmod:pckpbg.png");
        tmp_list = new ArrayList<String>();
        itemRenderer = new uyeb();
    }
    
    public class GuiEntityItemButton extends tdvs
    {
        private static final String \u5350 = "\u5350";
        private final InventoryDayZ boss;
        EntityItem ei;
        
        private GuiEntityItemButton(final InventoryDayZ boss, final EntityItem ei) {
            super(0, 0, 0, 16, 16, "\u5350");
            this.boss = boss;
            this.ei = ei;
        }
        
        public void func_73737_a(final tuor tuor, final int n, final int n2) {
            if (!this.ei.field_70128_L) {
                ncpk._c();
                GL11.glPushMatrix();
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glEnable(32826);
                final int field_73746_c = this.field_73746_c;
                final int field_73743_d = this.field_73743_d;
                InventoryDayZ.itemRenderer._b(tuor._x, tuor._R(), this.ei.func_92059_d(), field_73746_c, field_73743_d);
                InventoryDayZ.itemRenderer._a(tuor._x, tuor._R(), this.ei.func_92059_d(), field_73746_c, field_73743_d, (String)null);
                GL11.glPopMatrix();
            }
            if (n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b) {
                this.boss.hoveredButton = this;
            }
        }
    }
    
    private class GuiTransparentButton extends tdvs
    {
        private int backround_color;
        private final String[] description;
        
        private GuiTransparentButton(final int n, final int n2, final int n3, final int n4, final int n5, final String s, final String... description) {
            super(n, n2, n3, n4, n5, s);
            this.backround_color = 4737096;
            this.description = description;
        }
        
        public void func_73737_a(final tuor tuor, final int n, final int n2) {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_82253_i = (n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b);
            drawOutlinedRect(this.field_73746_c, this.field_73743_d, this.field_73747_a, this.field_73745_b, (this.field_82253_i ? 192 : 100) << 24 | (this.backround_color & 0xFFFFFF));
            this.func_73732_a(tuor._x, this.field_73744_e, this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + (this.field_73745_b - 8) / 2, 14737632);
            if (this.description != null && n >= this.field_73746_c && n2 >= this.field_73743_d && n <= this.field_73746_c + this.field_73747_a && n2 <= this.field_73743_d + this.field_73745_b) {
                final String[] description = this.description;
                for (int length = description.length, i = 0; i < length; ++i) {
                    InventoryDayZ.tmp_list.add(description[i]);
                }
            }
        }
    }
    
    public interface IPlayerState
    {
        String status(final EntityPlayer p0, final ExtendedPlayer p1);
        
        void description(final List<String> p0, final EntityPlayer p1, final ExtendedPlayer p2);
    }
}
