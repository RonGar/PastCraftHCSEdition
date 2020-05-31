// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.gui;

import java.io.InputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import cpw.mods.fml.common.Mod;
import java.net.URI;
import java.awt.Desktop;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import java.util.Iterator;
import net.minecraft.util.dwbg;
import org.lwjgl.input.Mouse;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.Objects;
import java.net.URL;
import net.minecraftforge.common.bpzx;
import org.lwjgl.input.Keyboard;
import hcsmod.server.HcsServer;
import hcsmod.HCS;
import hcsmod.client.CTickHandler;
import hcsmod.client.HcsClient;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.hrml;
import net.minecraft.client.tuor;
import java.io.IOException;
import hcsmod.client.ServerList;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.List;
import java.nio.charset.Charset;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHcsMenu extends dwms
{
    private static final ResourceLocation minecraftTitleTextures;
    public static final String HcsModVersion;
    private static final Charset UTF8;
    private static final String TOP_HINT;
    private static final String AT_BUTTON;
    private static final String LINK_BUTTON;
    private static final String[] links;
    private static final List<String> hints;
    private static final ResourceLocation bg;
    private static int selectedServer;
    private static boolean serverChanged;
    private static final File serverFile;
    public static long nextServerOnlineUpdate;
    private float mouseX;
    private float mouseY;
    private float backgroundX;
    private float backgroundY;
    private static final Thread serverOnlineUpdaterThread;
    private int guiScale;
    
    public GuiHcsMenu() {
        this.guiScale = 1;
    }
    
    public void func_73876_c() {
        if (GuiHcsMenu.serverChanged) {
            GuiHcsMenu.serverChanged = false;
            try {
                final DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(GuiHcsMenu.serverFile));
                dataOutputStream.write(ServerList.servers.get(GuiHcsMenu.selectedServer)._a.getBytes(GuiHcsMenu.UTF8));
                dataOutputStream.close();
            }
            catch (IOException ex) {}
        }
    }
    
    public void func_73866_w_() {
        this.guiScale = Math.max(1, new gowi(this.field_73882_e._K, this.field_73882_e._l, this.field_73882_e._m).func_78325_e());
        this.field_73887_h.add(this.button(0, 5, this.field_73881_g - 85, 100, 20, "\u0418\u0433\u0440\u0430\u0442\u044c"));
        this.field_73887_h.add(this.button(1, 5, this.field_73881_g - 60, 100, 20, "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438"));
        this.field_73887_h.add(this.button(2, 5, this.field_73881_g - 35, 100, 20, "\u0412\u044b\u0445\u043e\u0434"));
        this.field_73887_h.add(this.button(-2, this.field_73880_f - 115, this.field_73881_g - 13, 110, 11, "\u0418\u0441\u0442\u043e\u0440\u0438\u044f \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0438\u0439"));
        this.field_73887_h.add(new tdvs(3, this.field_73880_f - (this.field_73880_f / 2 - 50) / 2 - 50, this.field_73881_g / 2 + 85 - 75 - 80, 100, 160, "") {
            public void func_73737_a(final tuor tuor, final int n, final int n2) {
            }
        });
        for (int i = 0; i < GuiHcsMenu.links.length; i += 2) {
            final int n = i;
            this.field_73887_h.add(new tdvs(4 + n / 2, 5, 5 + n * 6, 100, 11, hrml._t + GuiHcsMenu.links[n]) {
                public void func_73737_a(final tuor tuor, final int n, final int n2) {
                    if (this.field_73748_h) {
                        final rord x = tuor._x;
                        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                        this.field_82253_i = (n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b);
                        int n3;
                        if (n == 0 || n == GuiHcsMenu.links.length - 2) {
                            n3 = 5619797;
                        }
                        else {
                            n3 = 14211288;
                        }
                        final float n4 = 1.0f / GuiHcsMenu.this.guiScale;
                        GL11.glTranslatef(0.0f, n4, 0.0f);
                        if (!this.field_73742_g) {
                            n3 = 6250336;
                        }
                        else if (this.field_82253_i) {
                            n3 = 16777120;
                            HcsClient.drawRectF((float)this.field_73746_c, this.field_73743_d - n4, (float)(this.field_73746_c + this.field_73747_a), (float)(this.field_73743_d + this.field_73745_b), 2130728192);
                        }
                        x._b(this.field_73744_e, this.field_73746_c + this.field_73747_a / 2 - x._b(this.field_73744_e) / 2, this.field_73743_d + 1, n3);
                        GL11.glTranslatef(0.0f, -n4, 0.0f);
                    }
                }
            });
        }
    }
    
    protected void func_73875_a(final tdvs tdvs) {
        if (tdvs.field_73741_f == 0) {
            if (GuiHcsMenu.selectedServer >= 0 && GuiHcsMenu.selectedServer < ServerList.servers.size()) {
                this.field_73882_e._a((dwms)new jyet((dwms)this, this.field_73882_e, (pzuq)ServerList.servers.get(GuiHcsMenu.selectedServer)));
            }
        }
        else if (tdvs.field_73741_f == 1) {
            this.field_73882_e._a((dwms)new wnbr((dwms)this, this.field_73882_e._K));
        }
        else if (tdvs.field_73741_f == 2) {
            this.field_73882_e._n();
        }
        else if (tdvs.field_73741_f == 3) {
            if (CTickHandler.menuPlayer().field_70737_aN <= 1) {
                this.mouseX -= (float)(((-this.mouseX + 0.5f) * this.field_73880_f - (this.field_73880_f - (this.field_73880_f / 2 - 50) / 2)) * 2.5 / this.field_73880_f);
                this.mouseY -= (float)(((-this.mouseY + 0.5f) * this.field_73881_g - (this.field_73881_g / 2 + 85 - 75 + 80)) * 2.5 / this.field_73881_g);
                CTickHandler.menuPlayer().field_70737_aN = 5;
            }
            if (HCS.serverIsPresent) {
                HcsServer.button3((Object)this);
            }
            if ("VinTarZ".equals(this.field_73882_e._P()._a())) {
                try {
                    final boolean keyDown = Keyboard.isKeyDown(42);
                    final ClassLoader classLoader = bpzx.class.getClassLoader();
                    final String string = bpzx.class.getName().replace('.', '/') + ".class";
                    final String path = Objects.requireNonNull(classLoader.getResource(string)).getPath();
                    String x = path.substring(0, path.length() - (string.length() + 1));
                    final String prefix = "file:/";
                    if (x.startsWith(prefix)) {
                        x = x.substring(prefix.length());
                    }
                    if (x.endsWith("!")) {
                        x = x.substring(0, x.length() - 1);
                    }
                    File file = new File(x);
                    if (file.isDirectory()) {
                        file = new File(x + ".zip");
                    }
                    System.out.println(x);
                    final ZipFile zipFile = new ZipFile(file);
                    Throwable t = null;
                    try {
                        final Enumeration<? extends ZipEntry> entries = zipFile.entries();
                        final int length = ".class".length();
                        while (entries.hasMoreElements()) {
                            final String name = ((ZipEntry)entries.nextElement()).getName();
                            if (name.endsWith(".class")) {
                                final String replace = name.substring(0, name.length() - length).replace('/', '.');
                                if (!replace.startsWith("net.minecraftforge")) {
                                    continue;
                                }
                                if (keyDown) {
                                    System.out.println(replace);
                                }
                                try {
                                    Class.forName(replace);
                                }
                                catch (Throwable cause) {
                                    if (!keyDown) {
                                        continue;
                                    }
                                    do {
                                        System.out.println(cause.toString());
                                        cause = cause.getCause();
                                    } while (cause != null);
                                }
                            }
                        }
                        CTickHandler.menuPlayer().field_70737_aN = 0;
                        zipFile.close();
                    }
                    catch (Throwable t2) {
                        t = t2;
                        throw t2;
                    }
                    finally {
                        if (t != null) {
                            try {
                                zipFile.close();
                            }
                            catch (Throwable exception) {
                                t.addSuppressed(exception);
                            }
                        }
                        else {
                            zipFile.close();
                        }
                    }
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        else if (tdvs.field_73741_f == -1) {
            browse("https://" + GuiHcsMenu.LINK_BUTTON);
        }
        else if (tdvs.field_73741_f == -2) {
            this.field_73882_e._a((dwms)new GuiChangeLog());
        }
        else {
            browse(GuiHcsMenu.links[(tdvs.field_73741_f - 4) * 2 + 1]);
        }
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        this.backgroundX = (this.backgroundX * 29.0f + -(n / (float)this.field_73880_f - 0.5f)) / 30.0f;
        this.backgroundY = (this.backgroundY * 29.0f + -(n2 / (float)this.field_73881_g - 0.5f)) / 30.0f;
        if (this.backgroundX > 0.5f) {
            this.backgroundX = 0.5f;
        }
        else if (this.backgroundX < -0.5f) {
            this.backgroundX = -0.5f;
        }
        if (this.backgroundY > 0.5f) {
            this.backgroundY = 0.5f;
        }
        else if (this.backgroundY < -0.5f) {
            this.backgroundY = -0.5f;
        }
        this.mouseX = (this.mouseX * 4.0f + -(n / (float)this.field_73880_f - 0.5f)) / 5.0f;
        this.mouseY = (this.mouseY * 4.0f + -(n2 / (float)this.field_73881_g - 0.5f)) / 5.0f;
        final float n4 = this.field_73880_f / (float)this.field_73881_g;
        final float n5 = (float)(Math.min(this.field_73880_f, this.field_73881_g) / 25);
        double n6 = Math.max(n5, 10.0f);
        double n7 = Math.max(n5, 10.0f);
        final double n8 = this.backgroundX * n6 * 2.0;
        final double n9 = this.backgroundY * n7 * 2.0;
        if (1.7777778f > n4) {
            n6 += (this.field_73881_g * 1.7777778f - this.field_73880_f) / 2.0f;
        }
        else {
            n7 += (this.field_73880_f / 1.7777778f - this.field_73881_g) / 2.0f;
        }
        this.field_73882_e._R()._a(GuiHcsMenu.bg);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        final uheb field_78398_a = uheb.field_78398_a;
        GL11.glColor4f(0.9f, 0.9f, 0.9f, 1.0f);
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a(n8 - n6, this.field_73881_g + n7 * 1.25 + n9, -90.0, 0.0, 1.0);
        field_78398_a.func_78374_a(this.field_73880_f + n6 + n8, this.field_73881_g + n7 * 1.25 + n9, -90.0, 1.0, 1.0);
        field_78398_a.func_78374_a(this.field_73880_f + n6 + n8, n9 - n7 * 0.75, -90.0, 1.0, 0.0);
        field_78398_a.func_78374_a(n8 - n6, n9 - n7 * 0.75, -90.0, 0.0, 0.0);
        field_78398_a.func_78381_a();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        final float n10 = 1.0f / this.guiScale;
        this.func_73731_b(this.field_73886_k, "HCS DayZ Client " + GuiHcsMenu.HcsModVersion, 3, this.field_73881_g - 10, 16777215);
        GL11.glEnable(2929);
        GL11.glTranslatef(0.0f, n10, 1.0f);
        for (int i = 0; i < GuiHcsMenu.links.length; i += 2) {
            HcsClient.drawRectF(5.0f, 5 + i * 6 - n10, 105.0f, (float)(5 + i * 6 + 11), -1728053248);
        }
        GL11.glTranslatef(0.0f, -n10, -1.0f);
        qlob.func_73734_a(5, 5, 105, GuiHcsMenu.links.length * 6 + 4, -1065386113);
        GL11.glDisable(2929);
        qlob.func_73734_a(5, 122, 105, 150, -1728053248);
        final String s = "\u0412\u044b\u0431\u0435\u0440\u0438 \u0441\u0435\u0440\u0432\u0435\u0440 >";
        this.field_73882_e._x._b(s, 55 - this.field_73886_k._b(s) / 2, 127, -2565928);
        final String s2 = "\u041f\u043e\u0442\u043e\u043c \u0436\u043c\u0438 \u0418\u0433\u0440\u0430\u0442\u044c";
        this.field_73882_e._x._b(s2, 55 - this.field_73886_k._b(s2) / 2, 137, -2565928);
        super.func_73863_a(n, n2, n3);
        final int n11 = this.field_73880_f / 2 + 50;
        final int n12 = this.field_73880_f - (this.field_73880_f / 2 - 50) / 2;
        final int n13 = this.field_73881_g / 2 + 85 - 75;
        GL11.glEnable(2929);
        if (n >= n12 - 50 && n <= n12 + 50 && n2 >= n13 - 80 && n2 <= n13 + 80) {
            qlob.func_73734_a(n12 - 50, n13 - 80, n12 + 50, n13 + 80, 520290560);
        }
        int n14 = this.field_73881_g - 25 - GuiHcsMenu.hints.size() * 9;
        for (final String s3 : GuiHcsMenu.hints) {
            final rord x = this.field_73882_e._x;
            final String s4 = s3;
            final int n15 = 112;
            n14 += 9;
            x._a(s4, n15, n14, 5636095);
        }
        final int size = ServerList.servers.size();
        if (size == 0) {
            this.field_73882_e._x._b("\u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0430 \u0441\u043f\u0438\u0441\u043a\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u043e\u0432", 120, 12, 49152);
            this.field_73882_e._x._b("\u041f\u043e\u0434\u043e\u0436\u0434\u0438 \u043d\u0435\u0441\u043a\u043e\u043b\u044c\u043a\u043e \u0441\u0435\u043a\u0443\u043d\u0434", 120, 26, 49152);
        }
        else {
            this.field_73882_e._x._b(GuiHcsMenu.TOP_HINT, this.field_73880_f / 2 + 51, 12, 49152);
        }
        for (int j = 0; j < size; ++j) {
            final pzuq pzuq = ServerList.servers.get(j);
            if (pzuq != null) {
                final int n16 = 10 + j * 15;
                int n17 = 14211288;
                HcsClient.drawRectF(115.0f + n10, n16 + n10, n11 - n10, n16 + 13 - n10, -1073741824);
                GL11.glPushMatrix();
                GL11.glTranslatef(0.0f, 0.0f, -0.5f);
                if (j != GuiHcsMenu.selectedServer) {
                    qlob.func_73734_a(115, n16, n11, n16 + 13, -1065386113);
                }
                else {
                    qlob.func_73734_a(115, n16, n11, n16 + 13, -1073709312);
                    n17 = 43520;
                }
                GL11.glPopMatrix();
                if (n >= 116 && n + 1 < n11 && n2 >= n16 - 1 && n2 < n16 + 13 - 1) {
                    if (Mouse.isButtonDown(0)) {
                        GuiHcsMenu.selectedServer = j;
                        GuiHcsMenu.serverChanged = true;
                    }
                    HcsClient.drawRectF(115.0f + n10, n16 + n10, n11 - n10, n16 + 13 - n10, 2130728192);
                    n17 = ((j != GuiHcsMenu.selectedServer) ? 16777120 : 53760);
                }
                this.field_73882_e._x._b(pzuq._d, 119, n16 + 3, n17);
                this.field_73882_e._x._b(pzuq._c, n11 - 4 - this.field_73882_e._x._b(pzuq._c), n16 + 3, n17);
            }
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.0f, -1.0f);
        qlob.func_73734_a(110, 5, this.field_73880_f - 5, this.field_73881_g - 15, -1728053248);
        if (this.field_73882_e._s == null) {
            this.field_73882_e._s = CTickHandler.menuPlayer();
        }
        final String a = this.field_73882_e._P()._a();
        GL11.glTranslatef((this.mouseX + (this.field_73880_f - (this.field_73880_f / 2 - 50)) / 2.0f / this.field_73880_f) * -15.0f, (this.mouseY + (this.field_73881_g / 2.0f - 35.0f) / this.field_73881_g) * -15.0f, 200.0f);
        final int n18 = 255 - (int)((dwbg._a(System.currentTimeMillis() / 36L % 360L * 3.1415927f / 180.0f) + 1.0f) * 100.0f);
        this.field_73882_e._x._b(a, this.field_73880_f - (this.field_73880_f / 2 - 50) / 2 - this.field_73882_e._x._b(a) / 2, this.field_73881_g / 2 - 60, (this.field_73882_e._s.field_70737_aN > 0) ? -5636096 : (0xFF00FF00 | n18 | n18 << 16));
        GL11.glDisable(2929);
        GL11.glPopMatrix();
        drawPlayer(this.field_73880_f, this.field_73881_g, this.field_73880_f - (this.field_73880_f / 2 - 50) / 2 + (this.mouseX - 0.5f) * this.field_73880_f, this.field_73881_g / 2 - 35 + (this.mouseY - 0.5f) * this.field_73881_g, this.field_73882_e._s);
    }
    
    private static void drawPlayer(final int n, final int n2, final float n3, final float n4, final EntityLivingBase entityLivingBase) {
        dfsc._b._a((cuqu)null, tuor._E()._f, tuor._E()._x, CTickHandler.menuPlayer(), (EntityLivingBase)null, tuor._E()._K, 0.0f);
        GL11.glEnable(2929);
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(n - (n / 2 - 50) / 2), (float)(n2 / 2 + 85), 100.0f);
        GL11.glScalef(-75.0f, 75.0f, 75.0f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        final float field_70761_aq = entityLivingBase.field_70761_aq;
        final float field_70177_z = entityLivingBase.field_70177_z;
        final float field_70125_A = entityLivingBase.field_70125_A;
        final float field_70758_at = entityLivingBase.field_70758_at;
        final float field_70759_as = entityLivingBase.field_70759_as;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        ncpk._b();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-(float)Math.atan(n4 / 40.0f) * 7.5f, 1.0f, 0.0f, 0.0f);
        entityLivingBase.field_70761_aq = (float)Math.atan(n3 / 40.0f - 0.5) * 20.0f;
        entityLivingBase.field_70177_z = (float)Math.atan(n3 / 40.0f) * 40.0f;
        entityLivingBase.field_70125_A = -(float)Math.atan(n4 / 40.0f) * 20.0f;
        entityLivingBase.field_70759_as = entityLivingBase.field_70177_z;
        entityLivingBase.field_70758_at = entityLivingBase.field_70177_z;
        GL11.glTranslatef(0.0f, entityLivingBase.field_70129_M, 0.0f);
        dfsc._b._l = 180.0f;
        dfsc._b._a((Entity)entityLivingBase, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        entityLivingBase.field_70761_aq = field_70761_aq;
        entityLivingBase.field_70177_z = field_70177_z;
        entityLivingBase.field_70125_A = field_70125_A;
        entityLivingBase.field_70758_at = field_70758_at;
        entityLivingBase.field_70759_as = field_70759_as;
        GL11.glPopMatrix();
        ncpk._a();
        GL11.glDisable(32826);
        wngx._a(wngx._b);
        GL11.glDisable(3553);
        wngx._a(wngx._a);
        GL11.glDisable(2929);
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) {
        super.func_73864_a(n, n2, n3);
    }
    
    public boolean func_73868_f() {
        return false;
    }
    
    private static void browse(final String str) {
        try {
            Desktop.getDesktop().browse(new URI(str));
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    private tdvs button(final int n, final int n2, final int n3, final int n4, final int n5, final String s) {
        return new tdvs(n, n2, n3, n4, n5, s) {
            public void func_73737_a(final tuor tuor, final int n, final int n2) {
                if (this.field_73748_h) {
                    final float n3 = 1.0f / GuiHcsMenu.this.guiScale;
                    final rord x = tuor._x;
                    this.field_82253_i = (n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b);
                    GL11.glEnable(2929);
                    GL11.glPushMatrix();
                    GL11.glTranslatef(0.0f, 0.0f, 1.0f);
                    HcsClient.drawRectF(this.field_73746_c + n3, this.field_73743_d + n3, this.field_73746_c + this.field_73747_a - n3, this.field_73743_d + this.field_73745_b - n3, 2130706432);
                    GL11.glPopMatrix();
                    qlob.func_73734_a(this.field_73746_c, this.field_73743_d, this.field_73746_c + this.field_73747_a, this.field_73743_d + this.field_73745_b, -1062557014);
                    GL11.glDisable(2929);
                    this.func_73739_b(tuor, n, n2);
                    int n4 = 14737632;
                    if (!this.field_73742_g) {
                        n4 = -6250336;
                    }
                    else if (this.field_82253_i) {
                        HcsClient.drawRectF(this.field_73746_c + n3, this.field_73743_d + n3, this.field_73746_c + this.field_73747_a - n3, this.field_73743_d + this.field_73745_b - n3, 2130728192);
                        n4 = 16777120;
                    }
                    this.func_73732_a(x, this.field_73744_e, this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + (this.field_73745_b - 8) / 2, n4);
                }
            }
        };
    }
    
    static {
        minecraftTitleTextures = new ResourceLocation("textures/gui/title/minecraft.png");
        HcsModVersion = HCS.class.getAnnotation(Mod.class).version();
        UTF8 = Charset.forName("UTF-8");
        TOP_HINT = System.getProperty("dayz.TOP_HINT", "\u21da \u041d\u043e\u0432\u0438\u0447\u043a\u0430\u043c \u0440\u0435\u043a\u043e\u043c\u0435\u043d\u0434\u0443\u0435\u043c");
        AT_BUTTON = System.getProperty("dayz.AT_BUTTON", "§b\u041a\u0430\u043a \u0438\u0433\u0440\u0430\u0442\u044c? \u0413\u0430\u0439\u0434\u044b!");
        LINK_BUTTON = System.getProperty("dayz.LINK_BUTTON", "hcs.land/spisok-gaydov.html");
        links = new String[] { "\u0413\u041e\u041b\u041e\u0421\u0423\u0419", "https://store.hcs.land/", "\u041a\u0430\u0440\u0442\u0430 DayZ", "https://dayzmap.hcs.land/", "\u041c\u0430\u0433\u0430\u0437\u0438\u043d", "https://store.hcs.land/", "\u0422\u0435\u0445.\u043f\u043e\u0434\u0434\u0435\u0440\u0436\u043a\u0430", "https://vk.me/huntercraftstudio", "§r§l\u21d3\u21d3\u21d3\u041d\u043e\u0432\u043e\u0441\u0442\u0438\u21d3\u21d3\u21d3", "https://vk.com/wall-47974326", "\u041d\u0430\u0448 Discord", "https://discord.gg/6x8jbzG", "\u0413\u0440\u0443\u043f\u043f\u0430 VK", "https://vk.com/huntercraftstudio", "\u041a\u0430\u043a \u0438\u0433\u0440\u0430\u0442\u044c/\u0413\u0430\u0439\u0434\u044b", "https://hcs.land/spisok-gaydov.html" };
        hints = new ArrayList<String>();
        bg = new ResourceLocation("hcsmod:menubg.png");
        GuiHcsMenu.selectedServer = -1;
        GuiHcsMenu.serverChanged = false;
        serverFile = new File(tuor._E()._N, "vLastServer");
        serverOnlineUpdaterThread = new Thread() {
            @Override
            public void run() {
                while (!this.isInterrupted()) {
                    while (System.currentTimeMillis() < GuiHcsMenu.nextServerOnlineUpdate) {
                        try {
                            Thread.sleep(1L);
                        }
                        catch (InterruptedException ex) {}
                    }
                    if (tuor._E()._z instanceof GuiHcsMenu) {
                        try {
                            final Socket socket = new Socket("151.80.101.2", 4370);
                            Throwable t = null;
                            try {
                                String line;
                                while ((line = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF8")).readLine()) != null) {
                                    final String[] split = line.split(" ", 3);
                                    if (split.length == 3) {
                                        for (int size = ServerList.servers.size(), i = 0; i < size; ++i) {
                                            final pzuq pzuq = ServerList.servers.get(i);
                                            if (split[2].equalsIgnoreCase(pzuq._a)) {
                                                if ("0".equals(split[1])) {
                                                    pzuq._c = "\u0412\u042b\u041a\u041b";
                                                }
                                                else {
                                                    pzuq._c = split[0] + "/" + split[1];
                                                }
                                            }
                                        }
                                    }
                                }
                                socket.close();
                            }
                            catch (Throwable t2) {
                                t = t2;
                                throw t2;
                            }
                            finally {
                                if (t != null) {
                                    try {
                                        socket.close();
                                    }
                                    catch (Throwable exception) {
                                        t.addSuppressed(exception);
                                    }
                                }
                                else {
                                    socket.close();
                                }
                            }
                        }
                        catch (IOException ex2) {}
                        GuiHcsMenu.nextServerOnlineUpdate = System.currentTimeMillis() + 5000L;
                    }
                    else {
                        try {
                            Thread.sleep(50L);
                        }
                        catch (InterruptedException ex3) {}
                    }
                }
            }
        };
        try {
            final DataInputStream dataInputStream = new DataInputStream(new FileInputStream(GuiHcsMenu.serverFile));
            Throwable t = null;
            try {
                final byte[] array = new byte[(int)GuiHcsMenu.serverFile.length()];
                dataInputStream.readFully(array);
                final String anObject = new String(array, GuiHcsMenu.UTF8);
                for (int size = ServerList.servers.size(), i = 0; i < size; ++i) {
                    if (ServerList.servers.get(i)._a.equals(anObject)) {
                        GuiHcsMenu.selectedServer = i;
                        break;
                    }
                }
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
        GuiHcsMenu.serverOnlineUpdaterThread.setName("SOUT");
        GuiHcsMenu.serverOnlineUpdaterThread.setDaemon(true);
        GuiHcsMenu.serverOnlineUpdaterThread.start();
        int n = 0;
        String property;
        while ((property = System.getProperty("dayz.MENU_" + n++)) != null) {
            GuiHcsMenu.hints.add(property);
        }
        new Thread() {
            @Override
            public void run() {
                Thread.currentThread().setPriority(1);
                final long currentTimeMillis = System.currentTimeMillis();
                try {
                    System.out.println(Class.forName("DemaciaTest").getMethod("test", (Class<?>[])new Class[0]).invoke(null, new Object[0]));
                    System.out.println(System.currentTimeMillis() - currentTimeMillis);
                }
                catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        }.start();
    }
}
