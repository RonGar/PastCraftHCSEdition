// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.gui;

import net.minecraft.client.tuor;
import hcsmod.client.HcsClient;
import org.lwjgl.opengl.GL11;
import java.util.Collection;
import java.io.BufferedReader;
import java.nio.file.FileSystem;
import java.nio.file.OpenOption;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.function.IntFunction;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.nio.file.FileSystems;
import java.net.URI;
import java.net.URLEncoder;
import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiChangeLog extends dwms
{
    private static final boolean UPDATE_ON_OPEN;
    private static final ResourceLocation bg;
    private static final ScrollHelper scroll;
    private static final List<String> cache;
    private static final String[][] changelog;
    public static boolean updated;
    private float mouseX;
    private float mouseY;
    private int selected;
    private int left;
    private static int guiScale;
    
    public GuiChangeLog() {
        GuiChangeLog.updated = false;
        if (GuiChangeLog.UPDATE_ON_OPEN) {
            final Charset forName = Charset.forName("UTF8");
            final ArrayList<String[]> list = new ArrayList<String[]>();
            String s = null;
            final HashMap<String, String> env = new HashMap<String, String>();
            env.put("create", "false");
            final String replace = Paths.get("versions/changelog.zip", new String[0]).toAbsolutePath().toString().replace(File.separator, "/");
            try (final FileSystem fileSystem = FileSystems.newFileSystem(URI.create("jar:file:/" + URLEncoder.encode(replace, Charset.defaultCharset().name())), env)) {
                final Path[] a = Files.list(fileSystem.getRootDirectories().iterator().next()).toArray((IntFunction<Path[]>)new IntFunction<Path[]>() {
                    @Override
                    public Path[] apply(final int n) {
                        return new Path[n];
                    }
                });
                Arrays.sort(a, new Comparator<Path>() {
                    @Override
                    public int compare(final Path path, final Path path2) {
                        try {
                            return -Files.readAttributes(path, BasicFileAttributes.class, new LinkOption[0]).creationTime().compareTo(Files.readAttributes(path2, BasicFileAttributes.class, new LinkOption[0]).creationTime());
                        }
                        catch (IOException ex) {
                            return 0;
                        }
                    }
                });
                final ArrayList<String> list2 = new ArrayList<String>();
                for (final Path path : a) {
                    Label_0415: {
                        if (Files.isRegularFile(path, new LinkOption[0])) {
                            list2.clear();
                            final String replace2 = path.getFileName().toString().replace(".txt", "");
                            try (final BufferedReader bufferedReader = Files.newBufferedReader(path, forName)) {
                                list2.add(replace2);
                                String line;
                                while ((line = bufferedReader.readLine()) != null) {
                                    list2.add(line);
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            }
                            catch (IOException ex) {
                                ex.printStackTrace();
                                break Label_0415;
                            }
                            if (list2.size() > 1) {
                                if (s == null) {
                                    s = replace2;
                                }
                                list.add(list2.toArray(new String[list2.size()]));
                            }
                        }
                    }
                }
                if (fileSystem != null) {
                    fileSystem.close();
                }
            }
            catch (Exception ex2) {}
            final Path value = Paths.get("vLast", new String[0]);
            byte[] allBytes = null;
            final byte[] array2 = (byte[])((s == null) ? null : s.getBytes());
            try {
                allBytes = Files.readAllBytes(value);
            }
            catch (IOException ex3) {}
            if (!Arrays.equals(allBytes, array2)) {
                if (array2 != null) {
                    try {
                        Files.write(value, array2, new OpenOption[0]);
                    }
                    catch (IOException ex4) {}
                }
                GuiChangeLog.updated = true;
            }
            for (int min = Math.min(GuiChangeLog.changelog.length, list.size()), j = 0; j < min; ++j) {
                GuiChangeLog.changelog[j] = (String[])list.get(j);
            }
        }
    }
    
    public void func_73876_c() {
    }
    
    public void func_73866_w_() {
        GuiChangeLog.guiScale = Math.max(1, new gowi(this.field_73882_e._K, this.field_73882_e._l, this.field_73882_e._m).func_78325_e());
        if (this.field_73887_h.isEmpty()) {
            this.field_73887_h.add(this.button(0, this.field_73880_f - 115, this.field_73881_g - 13, 110, 11, "§d\u0417\u0430\u043a\u0440\u044b\u0442\u044c"));
            this.field_73887_h.add(this.button(1, this.field_73880_f / 2 + 1, this.field_73881_g - 13, 24, 12, "§a>>>"));
            this.field_73887_h.add(this.button(2, this.field_73880_f / 2 - 24, this.field_73881_g - 13, 24, 12, "§a<<<"));
        }
        if (this.selected < 0 || this.selected >= GuiChangeLog.changelog.length) {
            return;
        }
        GuiChangeLog.cache.clear();
        for (int i = 1; i < GuiChangeLog.changelog[this.selected].length; ++i) {
            GuiChangeLog.cache.addAll(this.field_73882_e._x._c(GuiChangeLog.changelog[this.selected][i], 300));
        }
        int max = 0;
        GuiChangeLog.scroll.iniStart();
        GuiChangeLog.scroll.initAddContentHeight(4);
        for (int j = 0; j < GuiChangeLog.cache.size(); ++j) {
            max = Math.max(max, this.field_73882_e._x._b((String)GuiChangeLog.cache.get(j)));
            GuiChangeLog.scroll.initAddContentHeight(9);
        }
        this.left = this.field_73880_f / 2 - max / 2 - 2;
        GuiChangeLog.scroll.initFinish(0, 17, this.field_73881_g - 14, this.field_73880_f - 6, 6);
    }
    
    protected void func_73875_a(final tdvs tdvs) {
        final int selected = this.selected;
        if (tdvs.field_73741_f == 0) {
            this.field_73882_e._a((dwms)new GuiHcsMenu());
        }
        else if (tdvs.field_73741_f == 1) {
            final int n = this.selected - 1;
            this.selected = n;
            this.selected = Math.max(n, 0);
        }
        else if (tdvs.field_73741_f == 2) {
            this.selected = Math.min(++this.selected, GuiChangeLog.changelog.length - 1);
        }
        if (this.selected != selected) {
            this.func_73866_w_();
        }
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        this.mouseX = (this.mouseX * 29.0f + -(n / (float)this.field_73880_f - 0.5f)) / 30.0f;
        this.mouseY = (this.mouseY * 29.0f + -(n2 / (float)this.field_73881_g - 0.5f)) / 30.0f;
        if (this.mouseX > 0.5f) {
            this.mouseX = 0.5f;
        }
        else if (this.mouseX < -0.5f) {
            this.mouseX = -0.5f;
        }
        if (this.mouseY > 0.5f) {
            this.mouseY = 0.5f;
        }
        else if (this.mouseY < -0.5f) {
            this.mouseY = -0.5f;
        }
        final float n4 = this.field_73880_f / (float)this.field_73881_g;
        final float n5 = (float)(Math.min(this.field_73880_f, this.field_73881_g) / 25);
        double n6 = Math.max(n5, 10.0f);
        double n7 = Math.max(n5, 10.0f);
        final double n8 = this.mouseX * n6 * 2.0;
        final double n9 = this.mouseY * n7 * 2.0;
        if (1.7777778f > n4) {
            n6 += (this.field_73881_g * 1.7777778f - this.field_73880_f) / 2.0f;
        }
        else {
            n7 += (this.field_73880_f / 1.7777778f - this.field_73881_g) / 2.0f;
        }
        this.field_73882_e._R()._a(GuiChangeLog.bg);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a(n8 - n6, this.field_73881_g + n7 * 1.25 + n9, 0.0, 0.0, 1.0);
        field_78398_a.func_78374_a(this.field_73880_f + n6 + n8, this.field_73881_g + n7 * 1.25 + n9, 0.0, 1.0, 1.0);
        field_78398_a.func_78374_a(this.field_73880_f + n6 + n8, n9 - n7 * 0.75, 0.0, 1.0, 0.0);
        field_78398_a.func_78374_a(n8 - n6, n9 - n7 * 0.75, 0.0, 0.0, 0.0);
        field_78398_a.func_78381_a();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        HcsClient.drawRectF(0.0f, 0.0f, (float)this.field_73880_f, 17.0f + 1.0f / GuiChangeLog.guiScale, -1728053248);
        GL11.glTranslatef(0.0f, 0.0f, -1.0f);
        HcsClient.drawOutlinedRect(0.0f, 17.0f, (float)this.field_73880_f, (float)(this.field_73881_g - 14 - 17), -5592406, GuiChangeLog.guiScale);
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
        HcsClient.drawOutlinedRect((float)(this.field_73880_f - 6), 17.0f, 6.0f, (float)(this.field_73881_g - 14 - 17), -5592406, GuiChangeLog.guiScale);
        this.func_73731_b(this.field_73886_k, "HCS DayZ Client " + GuiHcsMenu.HcsModVersion, 3, this.field_73881_g - 10, 16777215);
        super.func_73863_a(n, n2, n3);
        if (this.selected < 0 || this.selected >= GuiChangeLog.changelog.length) {
            return;
        }
        GL11.glPushMatrix();
        GL11.glScalef(2.0f, 2.0f, 1.0f);
        final String string = "\u0418\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u044f \u0432\u0435\u0440\u0441\u0438\u0438 " + GuiChangeLog.changelog[this.selected][0];
        this.field_73882_e._x._a(string, this.field_73880_f / 4 - this.field_73882_e._x._b(string) / 2, 0, -2039584);
        GL11.glPopMatrix();
        GuiChangeLog.scroll.drawScrollbar();
        int n10 = 20;
        GuiChangeLog.scroll.beginRender();
        for (int i = 0; i < GuiChangeLog.cache.size(); ++i) {
            this.field_73882_e._x._b((String)GuiChangeLog.cache.get(i), this.left, n10, -2565928);
            n10 += 9;
        }
        GuiChangeLog.scroll.finishRender(n, n2);
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) {
        super.func_73864_a(n, n2, n3);
    }
    
    public boolean func_73868_f() {
        return false;
    }
    
    private tdvs button(final int n, final int n2, final int n3, final int n4, final int n5, final String s) {
        return new tdvs(n, n2, n3, n4, n5, s) {
            public void func_73737_a(final tuor tuor, final int n, final int n2) {
                if (this.field_73748_h) {
                    final float n3 = 1.0f / GuiChangeLog.guiScale;
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
        UPDATE_ON_OPEN = Boolean.parseBoolean(System.getProperty("hcsmod.changelog.update", "false"));
        bg = new ResourceLocation("hcsmod:menubg.png");
        scroll = new ScrollHelper();
        cache = new ArrayList<String>();
        final Charset forName = Charset.forName("UTF8");
        final ArrayList<String[]> list = new ArrayList<String[]>();
        String s = null;
        final HashMap<String, String> env = new HashMap<String, String>();
        env.put("create", "false");
        final String replace = Paths.get("versions/changelog.zip", new String[0]).toAbsolutePath().toString().replace(File.separator, "/");
        try (final FileSystem fileSystem = FileSystems.newFileSystem(URI.create("jar:file:/" + URLEncoder.encode(replace, Charset.defaultCharset().name())), env)) {
            final Path[] a = Files.list(fileSystem.getRootDirectories().iterator().next()).toArray((IntFunction<Path[]>)new IntFunction<Path[]>() {
                @Override
                public Path[] apply(final int n) {
                    return new Path[n];
                }
            });
            Arrays.sort(a, new Comparator<Path>() {
                @Override
                public int compare(final Path path, final Path path2) {
                    try {
                        return -Files.readAttributes(path, BasicFileAttributes.class, new LinkOption[0]).creationTime().compareTo(Files.readAttributes(path2, BasicFileAttributes.class, new LinkOption[0]).creationTime());
                    }
                    catch (IOException ex) {
                        return 0;
                    }
                }
            });
            final ArrayList<String> list2 = new ArrayList<String>();
            for (final Path path : a) {
                Label_0441: {
                    if (Files.isRegularFile(path, new LinkOption[0])) {
                        list2.clear();
                        final String replace2 = path.getFileName().toString().replace(".txt", "");
                        try (final BufferedReader bufferedReader = Files.newBufferedReader(path, forName)) {
                            list2.add(replace2);
                            String line;
                            while ((line = bufferedReader.readLine()) != null) {
                                list2.add(line);
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        }
                        catch (IOException ex) {
                            ex.printStackTrace();
                            break Label_0441;
                        }
                        if (list2.size() > 1) {
                            if (s == null) {
                                s = replace2;
                            }
                            list.add(list2.toArray(new String[list2.size()]));
                        }
                    }
                }
            }
            if (fileSystem != null) {
                fileSystem.close();
            }
        }
        catch (Exception ex2) {}
        final Path value = Paths.get("vLast", new String[0]);
        byte[] allBytes = null;
        final byte[] array2 = (byte[])((s == null) ? null : s.getBytes());
        try {
            allBytes = Files.readAllBytes(value);
        }
        catch (IOException ex3) {}
        if (!Arrays.equals(allBytes, array2)) {
            if (array2 != null) {
                try {
                    Files.write(value, array2, new OpenOption[0]);
                }
                catch (IOException ex4) {}
            }
            GuiChangeLog.updated = true;
        }
        changelog = list.toArray(new String[list.size()][]);
        GuiChangeLog.guiScale = 1;
    }
}
