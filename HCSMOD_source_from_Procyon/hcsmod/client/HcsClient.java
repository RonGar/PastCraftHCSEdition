// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import net.vintarz.movement.MovementClient;
import org.lwjgl.opengl.Display;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import net.minecraft.client.entity.EntityClientPlayerMP;
import co.uk.flansmods.client.FlansModClient;
import net.minecraft.entity.EntityLivingBase;
import java.io.IOException;
import net.minecraft.util.dfat;
import net.minecraft.util.idqh;
import org.lwjgl.opengl.GL11;
import vintarz.core.VCore;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import hcsmod.blocks.KolonkaRender;
import hcsmod.blocks.KolonkaEntity;
import hcsmod.client.render.RenderRoflShield;
import hcsmod.client.render.RenderCorpseZ;
import hcsmod.entity.EntityCorpseZ;
import hcsmod.client.render.RenderCorpse;
import hcsmod.entity.EntityCorpse;
import hcsmod.client.render.RenderNull;
import hcsmod.entity.EntityZombieHead;
import hcsmod.client.render.RenderKoster;
import hcsmod.entity.EntityKoster;
import hcsmod.client.render.RenderKosterClient;
import hcsmod.server.EntityHouseServer;
import hcsmod.client.render.RenderHouse;
import hcsmod.entity.EntityHouseCommon;
import hcsmod.client.render.RenderPalatka;
import hcsmod.entity.EntityPalatka;
import hcsmod.client.render.RenderPalatkaClient;
import hcsmod.client.render.RenderRat2020;
import hcsmod.entity.EntityRat2020;
import hcsmod.entity.EntitySnowmanHCS;
import net.minecraft.client.model.ModelBase;
import hcsmod.client.render.RenderCrawler;
import hcsmod.client.render.ModelCrawler;
import hcsmod.entity.EntityCrawler;
import hcsmod.client.render.RenderZombie;
import hcsmod.entity.EntityZombieDayZ;
import api.player.render.RenderPlayerAPI;
import hcsmod.client.render.ArmorRender;
import hcsmod.client.gui.GuiSpawnSelect;
import hcsmod.client.hud.DayZHud;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.ModContainer;
import java.io.InputStream;
import cpw.mods.fml.common.MetadataCollection;
import java.util.Map;
import cpw.mods.fml.common.FMLModContainer;
import cpw.mods.fml.common.discovery.ModCandidate;
import cpw.mods.fml.common.discovery.ContainerType;
import java.util.HashMap;
import java.io.File;
import net.minecraft.client.tuor;
import net.minecraft.util.ResourceLocation;
import java.util.List;
import vintarz.core.VCP;
import java.util.Queue;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class HcsClient
{
    public static String server;
    public static boolean isPVPserver;
    public static boolean isLiteserver;
    public static boolean isHarXserver;
    public static boolean fancyGuns;
    public static boolean clearDL;
    public static boolean ATTACH_RENDERED;
    public static float ambient_temp;
    public static float overheat;
    public static boolean gpsEnabled;
    public static int gpsX;
    public static int gpsZ;
    public static Queue<VCP> sendAfterTick;
    public static long lastDamage;
    public static List<HcsInteractable> interactables;
    public static List<HcsWorldRenderd> worldRendered;
    public static List<ResourceLocation> zombieTextures;
    public static Object interactTarget;
    public static boolean placeHouse;
    public static int hitCooldown;
    public static String customArmor;
    public static boolean resWarning;
    public static boolean resWarn;
    public static boolean leftMousePressed;
    public static boolean wasLeftMousePressed;
    public static int flansHealCooldown;
    public static int prevFlansHealCooldown;
    
    public static void addAssets() {
        final File file = new File(tuor._E()._N, "versions/assets_mc.zip");
        if (file.isFile()) {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("modid", "HCSMOD");
            final FMLModContainer fmlModContainer = new FMLModContainer("hcsmod.HCS", new ModCandidate(file, file, ContainerType.JAR), (Map)hashMap);
            fmlModContainer.bindMetadata(MetadataCollection.from((InputStream)null, ""));
            rojd.instance().addModAsResource((ModContainer)fmlModContainer);
        }
    }
    
    public static void init() {
        CTickHandler.loadPlayer();
        ServerList.setupServerList();
        TickRegistry.registerTickHandler((ITickHandler)new CTickHandler(), Side.CLIENT);
        bpzx.registerKeyBinding((bpzx.uxsf)new CKeyHandler());
        net.minecraftforge.common.bpzx.EVENT_BUS.register((Object)new CEventHandler());
        net.minecraftforge.common.bpzx.EVENT_BUS.register((Object)new DayZHud());
        net.minecraftforge.common.bpzx.EVENT_BUS.register((Object)GuiSpawnSelect.instance);
        RenderPlayerAPI.register("hcsmod", (Class)ArmorRender.class);
        wmvp.registerEntityRenderingHandler((Class)EntityZombieDayZ.class, (uyfg)new RenderZombie());
        wmvp.registerEntityRenderingHandler((Class)EntityCrawler.class, (uyfg)new RenderCrawler(new ModelCrawler(), 0.5f));
        wmvp.registerEntityRenderingHandler((Class)EntitySnowmanHCS.class, (uyfg)new pzyx());
        wmvp.registerEntityRenderingHandler((Class)EntityRat2020.class, (uyfg)new RenderRat2020());
        wmvp.registerEntityRenderingHandler((Class)PlacingPalatkaHouse.class, (uyfg)new RenderPalatkaClient());
        wmvp.registerEntityRenderingHandler((Class)EntityPalatka.class, (uyfg)new RenderPalatka());
        wmvp.registerEntityRenderingHandler((Class)EntityHouseCommon.class, (uyfg)new RenderHouse());
        try {
            wmvp.registerEntityRenderingHandler((Class)EntityHouseServer.class, (uyfg)new RenderHouse());
        }
        catch (Throwable t) {}
        wmvp.registerEntityRenderingHandler((Class)EntityKosterClient.class, (uyfg)new RenderKosterClient());
        wmvp.registerEntityRenderingHandler((Class)EntityKoster.class, (uyfg)new RenderKoster());
        wmvp.registerEntityRenderingHandler((Class)MenuPlayer.class, (uyfg)new MenuPlayerRenderer());
        wmvp.registerEntityRenderingHandler((Class)EntityZombieHead.class, (uyfg)new RenderNull());
        wmvp.registerEntityRenderingHandler((Class)EntityCorpse.class, (uyfg)new RenderCorpse());
        wmvp.registerEntityRenderingHandler((Class)EntityCorpseZ.class, (uyfg)new RenderCorpseZ());
        mayf.registerItemRenderer(jhvs.field_77716_q.field_77779_bT, (rqjc)new RenderRoflShield());
        zwak.bindTileEntitySpecialRenderer((Class)KolonkaEntity.class, (jhhk)new KolonkaRender());
        wmvp.registerEntityRenderingHandler((Class)InteractableRenderDummy.class, (uyfg)new uyfg() {
            public void func_76986_a(final Entity entity, final double n, final double n2, final double n3, final float n4, final float n5) {
                final Iterator<HcsInteractable> iterator = HcsClient.interactables.iterator();
                while (iterator.hasNext()) {
                    iterator.next().render(n5);
                }
                final Iterator<HcsWorldRenderd> iterator2 = HcsClient.worldRendered.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().render(n5);
                }
            }
            
            protected ResourceLocation func_110775_a(final Entity entity) {
                return null;
            }
        });
        for (int i = 0; i <= 17; ++i) {
            HcsClient.zombieTextures.add(i, new ResourceLocation("hcsmod:textures/entities/zombie_" + i + ".png"));
        }
        if (VCore.isSinglePlayer()) {
            final rord x;
            final String[] array;
            final uheb field_78398_a;
            int j = 0;
            final String[] array2;
            String s;
            int n;
            HcsClient.worldRendered.add(p0 -> {
                x = tuor._E()._x;
                array = new String[] { "\u0425\u041e\u0425\u041b\u041e\u0413\u0420\u0410\u041c\u041c\u0410", "\u0421\u043b\u0430\u0432\u0430", "\u0423\u043a\u0440\u0430\u0438\u043d\u0435", "\u0413\u0435\u0440\u043e\u044f\u043c", "\u0421\u043b\u0430\u0432\u0430" };
                GL11.glPushMatrix();
                GL11.glTranslatef((float)(0.0 - dfsc._d), (float)(94.0 - dfsc._e), (float)(0.0 - dfsc._f));
                GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                GL11.glRotatef((float)(System.currentTimeMillis() / 5L % 360L), 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-0.02666667f, -0.02666667f, 0.02666667f);
                GL11.glDisable(2896);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                field_78398_a = uheb.field_78398_a;
                GL11.glDisable(2884);
                while (j < 5) {
                    s = array2[j];
                    GL11.glDepthMask(false);
                    GL11.glDisable(3553);
                    field_78398_a.func_78382_b();
                    n = x._b(s) / 2;
                    field_78398_a.func_78369_a(0.4f, 0.4f, 1.0f, 0.25f);
                    field_78398_a.func_78377_a((double)(-n - 1), -1.0, 0.0);
                    field_78398_a.func_78377_a((double)(-n - 1), 8.0, 0.0);
                    field_78398_a.func_78377_a((double)(n + 1), 8.0, 0.0);
                    field_78398_a.func_78377_a((double)(n + 1), -1.0, 0.0);
                    field_78398_a.func_78381_a();
                    GL11.glEnable(3553);
                    GL11.glDepthMask(true);
                    x._b(s, -x._b(s) / 2, 0, -10240);
                    GL11.glTranslatef(0.0f, 9.0f, 0.0f);
                    ++j;
                }
                GL11.glEnable(2884);
                GL11.glEnable(2896);
                GL11.glDisable(3042);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glPopMatrix();
            });
        }
    }
    
    public static void broadcastBullet(final idqh idqh, final String s) {
        if (idqh == null) {
            return;
        }
        final VCP vcp = new VCP(10, "HCSMOD");
        try {
            vcp.writeFloat((float)idqh._f._c);
            vcp.writeFloat((float)idqh._f._d);
            vcp.writeFloat((float)idqh._f._e);
            vcp.writeByte((idqh._a == dfat._a) ? 1 : ((idqh._a == dfat._b) ? ((s != null) ? 3 : 2) : 0));
            if (idqh._a == dfat._b) {
                vcp.writeInt(idqh._g.field_70157_k);
                if (s != null) {
                    final byte[] bytes = s.getBytes("UTF-8");
                    vcp.writeByte(bytes.length);
                    vcp.write(bytes);
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        HcsClient.sendAfterTick.offer(vcp);
    }
    
    public static void meleeAttack() {
        final EntityClientPlayerMP r = tuor._E()._r;
        final ieta func_71045_bC = r.func_71045_bC();
        if (func_71045_bC != null && func_71045_bC._a().onEntitySwing((EntityLivingBase)r, func_71045_bC)) {
            return;
        }
        if (HcsClient.hitCooldown == 0) {
            HcsClient.hitCooldown = 6;
            final VCP vcp = new VCP(17, "HCSMOD");
            try {
                vcp.writeByte(FlansModClient.pingResponse);
            }
            catch (IOException ex) {}
            vcp.send();
            r.func_85030_a("hcsmod:swing", 1.0f, 1.0f);
        }
    }
    
    public static boolean warnAboutPCResources() {
        return HcsClient.resWarning;
    }
    
    public static void togglePCResourcesWarning() {
        HcsClient.resWarning = !HcsClient.resWarning;
        final File file = new File("vPRW");
        if (!HcsClient.resWarning) {
            try {
                file.createNewFile();
            }
            catch (IOException ex) {}
        }
        else {
            file.delete();
        }
    }
    
    public static boolean togglefancyGuns() {
        HcsClient.fancyGuns = !HcsClient.fancyGuns;
        final File file = new File("vFG");
        if (!HcsClient.fancyGuns) {
            try {
                file.createNewFile();
            }
            catch (IOException ex) {}
        }
        else {
            file.delete();
        }
        return HcsClient.fancyGuns;
    }
    
    public static void drawOutlinedRect(final float n, final float n2, final float n3, final float n4, final int n5, final int n6) {
        GL11.glEnable(2929);
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
        final float n7 = 1.0f / n6;
        drawRectF(n + n7, n2 + n7, n + n3 - n7, n2 + n4 - n7, -1728053248);
        GL11.glTranslatef(0.0f, 0.0f, -1.0f);
        drawRectF(n, n2, n + n3, n2 + n4, n5);
        GL11.glDisable(2929);
    }
    
    public static void drawRectF(float n, float n2, float n3, float n4, final int n5) {
        if (n < n3) {
            final float n6 = n;
            n = n3;
            n3 = n6;
        }
        if (n2 < n4) {
            final float n7 = n2;
            n2 = n4;
            n4 = n7;
        }
        final float n8 = (n5 >> 24 & 0xFF) / 255.0f;
        final float n9 = (n5 >> 16 & 0xFF) / 255.0f;
        final float n10 = (n5 >> 8 & 0xFF) / 255.0f;
        final float n11 = (n5 & 0xFF) / 255.0f;
        final uheb field_78398_a = uheb.field_78398_a;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(n9, n10, n11, n8);
        field_78398_a.func_78382_b();
        field_78398_a.func_78377_a((double)n, (double)n4, 0.0);
        field_78398_a.func_78377_a((double)n3, (double)n4, 0.0);
        field_78398_a.func_78377_a((double)n3, (double)n2, 0.0);
        field_78398_a.func_78377_a((double)n, (double)n2, 0.0);
        field_78398_a.func_78381_a();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }
    
    public static void flansHealCooldown() {
        if (HcsClient.flansHealCooldown > 0) {
            return;
        }
        HcsClient.flansHealCooldown = 10;
        HcsClient.prevFlansHealCooldown = 10;
    }
    
    static {
        HcsClient.server = "null";
        HcsClient.fancyGuns = true;
        HcsClient.clearDL = false;
        HcsClient.ATTACH_RENDERED = false;
        HcsClient.sendAfterTick = new LinkedBlockingQueue<VCP>();
        HcsClient.interactables = new ArrayList<HcsInteractable>();
        HcsClient.worldRendered = new ArrayList<HcsWorldRenderd>();
        HcsClient.zombieTextures = new ArrayList<ResourceLocation>();
        HcsClient.resWarning = true;
        HcsClient.resWarn = true;
        Display.setTitle("HCS Minecraft DayZ Client");
        DayZHud.hints.put("placeHouse", new DayZHud.Hint() {
            @Override
            public boolean remove() {
                return false;
            }
            
            @Override
            public void addHints(final List<String> list) {
                if (HcsClient.placeHouse) {
                    list.add("§d\u0412\u043a\u043b\u044e\u0447\u0435\u043d \u0440\u0435\u0436\u0438\u043c \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0438 \u0434\u043e\u043c\u0430");
                    list.add("§d\u041f\u0440\u0438\u0446\u0435\u043b\u044c\u0441\u044f \u043a\u0443\u0434\u0430 \u0435\u0433\u043e \u0441\u0442\u0430\u0432\u0438\u0442\u044c");
                    list.add("§d\u0438 \u0432\u0432\u0435\u0434\u0438 \u043a\u043e\u043c\u0430\u043d\u0434\u0443 §f/puthouse");
                    list.add("§d\u0412\u041d\u0418\u041c\u0410\u041d\u0418\u0415: \u0442\u0435\u0445\u043d\u0438\u043a\u0430 \u0438\u0437 \u0434\u043e\u043c\u0430 \u0431\u0443\u0434\u0435\u0442");
                    list.add("§d\u0441\u043f\u0430\u0443\u043d\u0438\u0442\u044c\u0441\u044f \u0442\u0430\u043c, \u0433\u0434\u0435 \u0442\u044b \u0441\u0442\u043e\u0438\u0448\u044c!");
                    list.add("§d\u041a\u043e\u0433\u0434\u0430 \u043f\u0438\u0448\u0435\u0448\u044c /puthouse \u041e\u0422\u041e\u0419\u0414\u0418");
                    list.add("§d\u041f\u041e\u0414\u0410\u041b\u042c\u0428\u0415 \u041e\u0422 \u041b\u042e\u0411\u042b\u0425 \u041f\u0420\u0415\u041f\u042f\u0422\u0421\u0422\u0412\u0418\u0419!");
                }
            }
        });
        MovementClient.addOnTeleportCallback((Runnable)new Runnable() {
            @Override
            public void run() {
                HcsClient.hitCooldown = 0;
            }
        });
        EntityClientPlayerMP.addOnSwingCallback((Runnable)new Runnable() {
            @Override
            public void run() {
                HcsClient.meleeAttack();
            }
        });
        if (new File("vPRW").exists()) {
            HcsClient.resWarning = false;
        }
        if (new File("vFG").exists()) {
            HcsClient.fancyGuns = false;
        }
    }
}
