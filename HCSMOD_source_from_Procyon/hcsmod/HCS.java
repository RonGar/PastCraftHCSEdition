// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod;

import hcsmod.client.CreativeTab;
import java.util.Iterator;
import java.util.List;
import hcsmod.surrond.HcsSurround;
import hcsmod.client.CTickHandler;
import net.minecraft.client.tuor;
import co.uk.flansmods.vintarz.EntityShootFX;
import net.minecraft.util.dwbg;
import net.minecraft.entity.Entity;
import hcsmod.player.InventoryExtended;
import hcsmod.player.ExtendedPlayer;
import net.minecraft.entity.srlj;
import net.minecraft.entity.EntityLivingBase;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.event.kjuq;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import hcsmod.server.$;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import hcsmod.items.ItemRat2020;
import hcsmod.items.ItemWithDesc;
import hcsmod.items.ItemFoodBackpackmod;
import hcsmod.items.ItemDrinkBackpackmod;
import hcsmod.items.armor.ArmorSet;
import hcsmod.client.render.IVladruArmorModel;
import hcsmod.client.render.ArmorRender;
import hcsmod.items.ItemKoster;
import hcsmod.items.ItemPalatka;
import hcsmod.items.ItemPnv;
import hcsmod.items.ItemHealFood;
import hcsmod.items.ItemCustomGoldApple;
import hcsmod.items.ItemEmptyBottle;
import hcsmod.items.ItemWaterBottle;
import hcsmod.items.ItemBackpack;
import cpw.mods.fml.common.registry.GameRegistry;
import hcsmod.entity.EntityCorpseZ;
import hcsmod.entity.EntityCorpse;
import hcsmod.entity.EntityKoster;
import hcsmod.entity.EntityPalatka;
import hcsmod.blocks.HCSBlocks;
import cpw.mods.fml.common.registry.LanguageRegistry;
import hcsmod.effects.Effect;
import hcsmod.entity.EntityZombieHead;
import hcsmod.entity.EntityRat2020;
import hcsmod.entity.EntitySnowmanHCS;
import hcsmod.entity.EntityCrawler;
import hcsmod.entity.EntityZombieDayZ;
import net.minecraftforge.common.bpzx;
import cpw.mods.fml.common.registry.EntityRegistry;
import hcsmod.entity.EntityHouseCommon;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import hcsmod.flashlight.Flashlight;
import net.minecraftforge.common.zway;
import hcsmod.blocks.BlockModdedLeaves;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import co.uk.flansmods.common.guns.EntityBullet;
import vintarz.movement.server.MovementServer;
import net.vintarz.movement.MovementClient;
import net.minecraft.entity.player.EntityPlayer;
import hcsmod.server.HcsServer;
import hcsmod.client.HcsClient;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import hcsmod.items.ItemMeele;
import hcsmod.items.armor.ItemHCSArmor;
import hcsmod.items.ItemHeal;
import net.minecraft.util.rojd;
import cpw.mods.fml.common.ModMetadata;
import hcsmod.client.CPacketHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.Mod;

@Mod(modid = "HCSMOD", version = "build 27.04.20.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true, clientPacketHandlerSpec = @NetworkMod.SidedPacketHandler(channels = { "HCSMOD" }, packetHandler = CPacketHandler.class))
public class HCS
{
    public static final boolean disableVehiclesBreaking = true;
    public static final int flansHealCooldown = 10;
    @Mod.Instance("HCSMOD")
    public static HCS INSTANCE;
    @Mod.Metadata
    public static ModMetadata meta;
    public static rojd maxX;
    public static rojd minX;
    public static rojd maxZ;
    public static rojd minZ;
    public static tekj modcreativetab;
    public static int PrefPNV;
    public static jhvo juggerarmor;
    public static jhvo RFarmor;
    public static jhvo NYarmor;
    public static jhvo krampus;
    public static jhvo ny2020armor;
    public static jhvo GHILE;
    public static jhvo HEAVYARMOR;
    public static jhvo PROTAARMOR;
    public static jhvs min;
    public static jhvs mid;
    public static jhvs max;
    public static jhvs bandage;
    public static jhvs morphine;
    public static jhvs cocacola;
    public static jhvs pepsi;
    public static ItemHeal small_firstAidKit;
    public static ItemHeal firstAidKit;
    public static ItemHeal firstAidKit_b;
    public static ItemHeal pills;
    public static jhvs mountaindew;
    public static jhvs SodaClays;
    public static jhvs SodaDrwaste;
    public static jhvs SodaMzly;
    public static jhvs SodaR4z0r;
    public static jhvs SodaRabbit;
    public static jhvs SodaSmasht;
    public static jhvs CanBakedBeans;
    public static jhvs CanFrankBeans;
    public static jhvs CanPasta;
    public static jhvs CanSardines;
    public static jhvs CanBoneboy;
    public static jhvs CanGriff;
    public static jhvs CanHerpy;
    public static jhvs CanOrlok;
    public static jhvs MRE;
    public static jhvs PNV;
    public static jhvs Palatka;
    public static jhvs Koster;
    public static jhvs PRESS;
    public static jhvs bpvest;
    public static jhvs gunrepair1;
    public static jhvs samodelHead;
    public static jhvs samodelBody;
    public static jhvs samodelLegs;
    public static jhvs samodelBoots;
    public static jhvs RFLesHead;
    public static jhvs RFLesBody;
    public static jhvs RFLesLegs;
    public static jhvs RFLesBoots;
    public static jhvs RFGorHead;
    public static jhvs RFGorBody;
    public static jhvs RFGorLegs;
    public static jhvs RFGorBoots;
    public static jhvs RFPesHead;
    public static jhvs RFPesBody;
    public static jhvs RFPesLegs;
    public static jhvs RFPesBoots;
    public static jhvs NewYearHead;
    public static jhvs NewYearBody;
    public static jhvs NewYearLegs;
    public static jhvs NewYearBoots;
    public static jhvs ghileHead;
    public static jhvs ghileBody;
    public static jhvs ghileLegs;
    public static jhvs ghileBoots;
    public static jhvs helmetgl;
    public static jhvs helmet;
    public static jhvs helmetpnv;
    public static jhvs balaclava_crw;
    public static jhvs JokerHead;
    public static jhvs JokerBody;
    public static jhvs JokerLegs;
    public static jhvs JokerBoots;
    public static jhvs Krampus_head;
    public static jhvs Krampus_body;
    public static jhvs Krampus_pants;
    public static jhvs Krampus_boots;
    public static jhvs Armor2020_head;
    public static jhvs Armor2020_body;
    public static jhvs Armor2020_pants;
    public static jhvs Armor2020_boots;
    public static jhvs prota_head;
    public static jhvs prota_body;
    public static jhvs prota_pants;
    public static jhvs prota_boots;
    public static jhvs heavy_head;
    public static jhvs heavy_body;
    public static jhvs heavy_pants;
    public static jhvs heavy_boots;
    public static ItemHCSArmor[] JAG;
    public static jhvs raincoat;
    public static jhvs warmclothes;
    public static jhvs holster;
    public static jhvs heatpack;
    public static ItemMeele axe;
    public static ItemMeele axe2;
    public static ItemMeele knife;
    public static ItemMeele bita1;
    public static ItemMeele bita2;
    public static ItemMeele ice_copie;
    public static ItemMeele ice_knife;
    public static ItemMeele ice_kosa;
    public static ItemMeele ice_sword;
    public static ItemMeele ice_trezybetc;
    public static jhvs Rat2020;
    public static tesa NY_ZNEC;
    public static tesa NY_HVOST;
    public static tesa NY_ALL;
    public static tesa AXE;
    public static tesa KNIFE;
    public static long worldSlowDown;
    public static boolean serverIsPresent;
    
    public HCS() {
        Thread.currentThread().setPriority(10);
        if (FMLLaunchHandler.side() == Side.CLIENT) {
            HcsClient.addAssets();
        }
    }
    
    public static boolean isHardcoreServer() {
        try {
            return HcsServer.isHardcoreServer();
        }
        catch (Throwable t) {
            return false;
        }
    }
    
    public static boolean isReallySprinting(final EntityPlayer entityPlayer) {
        if (entityPlayer.field_70170_p.field_72995_K) {
            return MovementClient.sprinting >= 0.5f;
        }
        try {
            return MovementServer.isReallySprinting(entityPlayer);
        }
        catch (Throwable t) {
            return false;
        }
    }
    
    public static boolean doAttack(final EntityBullet entityBullet) {
        return !HCS.serverIsPresent || HcsServer.doAttack(entityBullet);
    }
    
    @Mod.EventHandler
    public void preload(final FMLPreInitializationEvent fmlPreInitializationEvent) {
        kjsv.field_71973_m[kjsv.field_71952_K.field_71990_ca] = null;
        kjsv.field_71973_m[kjsv.field_71952_K.field_71990_ca] = new BlockModdedLeaves(kjsv.field_71952_K.field_71990_ca).func_71848_c(0.2f).func_71868_h(1).func_71884_a(kjsv.field_71965_g).func_71864_b("leaves").func_111022_d("leaves");
        kjsv.field_71973_m[kjsv.field_72004_bj.field_71990_ca] = null;
        kjsv.field_71973_m[kjsv.field_72004_bj.field_71990_ca] = new zfad(kjsv.field_72004_bj.field_71990_ca, ccfp._s, false).func_71848_c(0.3f).func_71884_a(kjsv.field_71974_j).func_71864_b("glass").func_111022_d("glass");
        if (fmlPreInitializationEvent.getSide().isClient()) {
            HCS.PrefPNV = addArmor("null");
        }
        else {
            HCS.PrefPNV = 0;
        }
        HCS.juggerarmor = zway.addArmorMaterial("juggerarmor", 22, new int[] { 3, 8, 6, 3 }, 0);
        HCS.juggerarmor._i = jhvs.field_77703_o;
        HCS.RFarmor = zway.addArmorMaterial("rfarmor", 22, new int[] { 3, 6, 4, 3 }, 0);
        HCS.RFarmor._i = jhvs.field_77703_o;
        HCS.NYarmor = zway.addArmorMaterial("nyarmor", 22, new int[] { 3, 8, 5, 3 }, 0);
        HCS.NYarmor._i = jhvs.field_77703_o;
        HCS.krampus = zway.addArmorMaterial("krampus", 22, new int[] { 3, 8, 6, 3 }, 0);
        HCS.krampus._i = jhvs.field_77703_o;
        HCS.ny2020armor = zway.addArmorMaterial("ny2020armor", 22, new int[] { 3, 7, 5, 3 }, 0);
        HCS.ny2020armor._i = jhvs.field_77703_o;
        HCS.GHILE = zway.addArmorMaterial("ghile", 15, new int[] { 3, 4, 3, 2 }, 0);
        HCS.HEAVYARMOR = zway.addArmorMaterial("HEAVYarmor", 50, (int[])new int[] { 3, 8, 5, 3 }, 1);
        HCS.PROTAARMOR = zway.addArmorMaterial("PROTAARMOR", 22, (int[])new int[] { 3, 8, 5, 3 }, 1);
        Flashlight.instance.preInit(fmlPreInitializationEvent);
    }
    
    @Mod.EventHandler
    public void load(final FMLInitializationEvent fmlInitializationEvent) {
        try {
            HcsServer.$();
            HCS.serverIsPresent = true;
        }
        catch (Throwable t) {
            if (!fmlInitializationEvent.getSide().isClient()) {
                throw t;
            }
            EntityRegistry.registerModEntity((Class)EntityHouseCommon.class, "ENTITYHouseSWAG1488", 3, (Object)HCS.INSTANCE, 64, Integer.MAX_VALUE, false);
        }
        bpzx.EVENT_BUS.register((Object)HCS.INSTANCE);
        EntityRegistry.registerGlobalEntityID((Class)EntityZombieDayZ.class, "Zombie", EntityRegistry.findGlobalUniqueEntityId(), 1, 2);
        EntityRegistry.registerGlobalEntityID((Class)EntityCrawler.class, "Crawler", EntityRegistry.findGlobalUniqueEntityId(), 1, 2);
        EntityRegistry.registerGlobalEntityID((Class)EntitySnowmanHCS.class, "SnowmanHCS", EntityRegistry.findGlobalUniqueEntityId(), 1, 2);
        EntityRegistry.registerModEntity((Class)EntityRat2020.class, "EntityRat", EntityRegistry.findGlobalUniqueEntityId(), (Object)this, 40, 2, true);
        EntityRegistry.registerModEntity((Class)EntityZombieHead.class, "ZombieHead", 2, (Object)this, 64, 1, false);
        Effect.loadEffects();
        Effect.register();
        LanguageRegistry.instance().addStringLocalization("entity.Zombie.name", "en_US", "Zombie");
        HCSBlocks.registerBlocks();
        EntityRegistry.registerModEntity((Class)EntityPalatka.class, "Palatka", 0, (Object)HCS.INSTANCE, 32, Integer.MAX_VALUE, false);
        EntityRegistry.registerModEntity((Class)EntityKoster.class, "Koster", 1, (Object)HCS.INSTANCE, 64, Integer.MAX_VALUE, false);
        EntityRegistry.registerModEntity((Class)EntityCorpse.class, "Corpse", 10, (Object)this, 32, 20, true);
        EntityRegistry.registerModEntity((Class)EntityCorpseZ.class, "CorpZe", 11, (Object)this, 48, 100, true);
        LanguageRegistry.instance().addStringLocalization("death.attack.thirstDeath", "%1$s ran out of water");
        LanguageRegistry.instance().addStringLocalization("death.attack.bleedOut", "%1$s lost too much blood");
        Flashlight.instance.Init(fmlInitializationEvent);
        GameRegistry.registerItem((jhvs)(HCS.axe = new ItemMeele(6000, HCS.AXE, "Axe1")), "axe");
        GameRegistry.registerItem((jhvs)(HCS.axe2 = new ItemMeele(6001, HCS.AXE, "Axe2")), "axe2");
        GameRegistry.registerItem((jhvs)(HCS.knife = new ItemMeele(6002, HCS.KNIFE, "knife")), "knife");
        GameRegistry.registerItem((jhvs)(HCS.bita1 = new ItemMeele(6003, HCS.KNIFE, "bita1")), "bita1");
        GameRegistry.registerItem((jhvs)(HCS.bita2 = new ItemMeele(6004, HCS.AXE, "bita2")), "bita2");
        GameRegistry.registerItem((jhvs)(HCS.ice_copie = new ItemMeele(6005, HCS.NY_HVOST, "ice_copie")), "ice_copie");
        GameRegistry.registerItem((jhvs)(HCS.ice_knife = new ItemMeele(6006, HCS.NY_ALL, "ice_knife")), "ice_knife");
        GameRegistry.registerItem((jhvs)(HCS.ice_kosa = new ItemMeele(6007, HCS.NY_ZNEC, "ice_kosa")), "ice_kosa");
        GameRegistry.registerItem((jhvs)(HCS.ice_sword = new ItemMeele(6008, HCS.NY_ALL, "ice_sword")), "ice_sword");
        GameRegistry.registerItem((jhvs)(HCS.ice_trezybetc = new ItemMeele(6009, HCS.NY_ALL, "ice_trezybetc")), "ice_trezybetc");
        LanguageRegistry.addName((Object)HCS.axe, "\u0422\u043e\u043f\u043e\u0440");
        LanguageRegistry.addName((Object)HCS.axe2, "\u0422\u043e\u043f\u043e\u0440");
        LanguageRegistry.addName((Object)HCS.knife, "\u041d\u043e\u0436");
        LanguageRegistry.addName((Object)HCS.bita1, "\u0411\u0438\u0442\u0430");
        LanguageRegistry.addName((Object)HCS.bita2, "\u041b\u044e\u0441\u0438\u043b\u044c");
        LanguageRegistry.addName((Object)HCS.ice_copie, "\u0425\u0432\u043e\u0441\u0442 \u041a\u0440\u0430\u043c\u043f\u0443\u0441\u0430");
        LanguageRegistry.addName((Object)HCS.ice_knife, "\u041a\u0440\u044b\u0441\u0438\u043d\u044b\u0439 \u043a\u043b\u0438\u043d\u043e\u043a");
        LanguageRegistry.addName((Object)HCS.ice_kosa, "\u0417\u0438\u043c\u043d\u0438\u0439 \u0436\u043d\u0435\u0446");
        LanguageRegistry.addName((Object)HCS.ice_sword, "\u0420\u0430\u0441\u0441\u0435\u043a\u0430\u044e\u0449\u0438\u0439 \u0441\u0447\u0430\u0441\u0442\u044c\u0435");
        LanguageRegistry.addName((Object)HCS.ice_trezybetc, "\u041b\u0435\u0434\u044f\u043d\u043e\u0439 \u043f\u043e\u0441\u0435\u0439\u0434\u043e\u043d");
        LanguageRegistry.addName((Object)(HCS.min = new ItemBackpack(5890).func_77655_b("czech")), "Czech backpack");
        LanguageRegistry.addName((Object)(HCS.mid = new ItemBackpack(5892).func_77655_b("survival")), "Survival backpack");
        LanguageRegistry.addName((Object)(HCS.max = new ItemBackpack(5893).func_77655_b("assault")), "Coyote  backpack");
        jhvs.field_77726_bs = (yudj)new ItemWaterBottle(jhvs.field_77726_bs.field_77779_bT - 256, 18000).func_77655_b("potion").func_111206_d("potion");
        jhvs.field_77729_bt = new ItemEmptyBottle(jhvs.field_77729_bt.field_77779_bT).func_77655_b("glassBottle").func_111206_d("potion_bottle_empty");
        jhvs.field_77778_at = new ItemCustomGoldApple(66, 4, 1.2f, false).func_77848_i().func_77655_b("appleGold").func_111206_d("apple_golden");
        jhvs.field_77782_ar = new ItemHealFood(64, 8, 0.8f, true).func_77655_b("porkchopCooked").func_111206_d("porkchop_cooked");
        jhvs.field_77734_bj = new ItemHealFood(108, 8, 0.8f, true).func_77655_b("beefCooked").func_111206_d("beef_cooked");
        jhvs.field_77753_aV = new ItemHealFood(94, 5, 0.6f, false).func_77655_b("fishCooked").func_111206_d("fish_cooked");
        jhvs.field_77736_bl = new ItemHealFood(110, 6, 0.6f, true).func_77655_b("chickenCooked").func_111206_d("chicken_cooked");
        LanguageRegistry.addName((Object)(HCS.PNV = new ItemPnv(7457).func_77655_b("pnv").func_77637_a(HCS.modcreativetab)), "PNV");
        HCS.Palatka = new ItemPalatka(7459).func_77655_b("palatka").func_77637_a(HCS.modcreativetab);
        LanguageRegistry.addName((Object)new ieta(HCS.Palatka, 1, 0), "\u041f\u0430\u043b\u0430\u0442\u043a\u0430");
        LanguageRegistry.addName((Object)new ieta(HCS.Palatka, 1, 1), "House 3 days");
        LanguageRegistry.addName((Object)new ieta(HCS.Palatka, 1, 2), "House week");
        LanguageRegistry.addName((Object)new ieta(HCS.Palatka, 1, 3), "House month");
        LanguageRegistry.addName((Object)new ieta(HCS.Palatka, 1, 4), "House 3 month");
        LanguageRegistry.addName((Object)new ieta(HCS.Palatka, 1, 5), "House free");
        LanguageRegistry.addName((Object)(HCS.Koster = new ItemKoster(7460).func_77655_b("koster").func_77637_a(HCS.modcreativetab)), "\u041a\u043e\u0441\u0442\u0435\u0440");
        for (int i = 0; i < 4; ++i) {
            HCS.JAG[i] = new ItemHCSArmor(CLIENT() ? ArmorRender.JAG : null, "textures/jugger.png", 7466 + i, HCS.juggerarmor, addArmor("JAG"), i);
            HCS.JAG[i].func_77655_b("JAG" + i).func_111206_d("jugger/jag" + i);
            HCS.JAG[i].setNoRepair();
        }
        LanguageRegistry.addName((Object)(HCS.PRESS = new ItemHCSArmor(null, "textures/PRESS.png", 7464, jhvo._b, addArmor("press"), 1).func_77655_b("press").func_111206_d("press").func_77637_a(HCS.modcreativetab)), "\u041f\u0420\u0415\u0421\u0421");
        LanguageRegistry.addName((Object)(HCS.bpvest = new ItemHCSArmor(null, "textures/bpvest.png", 7465, jhvo._e, addArmor("bpvest"), 1).func_77655_b("bpvest").func_111206_d("bpvest").func_77637_a(HCS.modcreativetab)), "\u0411\u0440\u043e\u043d\u0435\u0436\u0438\u043b\u0435\u0442");
        LanguageRegistry.addName((Object)(HCS.samodelHead = new ItemHCSArmor(CLIENT() ? ArmorRender.samodel : null, "textures/samodel.png", 7475, jhvo._b, addArmor("samodelHelmer"), 0).func_77655_b("samodelHelmer").func_111206_d("samodelHelmer").func_77637_a(HCS.modcreativetab)), "\u0421\u0430\u043c\u043e\u0434\u0435\u043b\u044c\u043d\u044b\u0439 \u0448\u043b\u0435\u043c");
        LanguageRegistry.addName((Object)(HCS.samodelBody = new ItemHCSArmor(CLIENT() ? ArmorRender.samodel : null, "textures/samodel.png", 7476, jhvo._b, addArmor("samodelBody"), 1).func_77655_b("samodelBody").func_111206_d("samodelBody").func_77637_a(HCS.modcreativetab)), "\u0421\u0430\u043c\u043e\u0434\u0435\u043b\u044c\u043d\u044b\u0439 \u043d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a");
        LanguageRegistry.addName((Object)(HCS.samodelLegs = new ItemHCSArmor(CLIENT() ? ArmorRender.samodel : null, "textures/samodel.png", 7477, jhvo._b, addArmor("samodelLegs"), 2).func_77655_b("samodelLegs").func_111206_d("samodelLegs").func_77637_a(HCS.modcreativetab)), "\u0421\u0430\u043c\u043e\u0434\u0435\u043b\u044c\u043d\u044b\u0435 \u0448\u0442\u0430\u043d\u044b");
        LanguageRegistry.addName((Object)(HCS.samodelBoots = new ItemHCSArmor(CLIENT() ? ArmorRender.samodel : null, "textures/samodel.png", 7478, jhvo._b, addArmor("samodelBoots"), 3).func_77655_b("samodelBoots").func_111206_d("samodelBoots").func_77637_a(HCS.modcreativetab)), "\u0421\u0430\u043c\u043e\u0434\u0435\u043b\u044c\u043d\u044b\u0435 \u0431\u043e\u0442\u0438\u043d\u043a\u0438");
        LanguageRegistry.addName((Object)(HCS.RFLesHead = new ItemHCSArmor(CLIENT() ? ArmorRender.RF : null, "textures/RFLes.png", 7479, HCS.RFarmor, addArmor("RFLesHead"), 0).func_77655_b("RFLesHead").func_111206_d("RFLesHead").func_77637_a(HCS.modcreativetab)), "\u0428\u043b\u0435\u043c \u043d\u0430\u0435\u043c\u043d\u0438\u043a\u0430");
        LanguageRegistry.addName((Object)(HCS.RFLesBody = new ItemHCSArmor(CLIENT() ? ArmorRender.RF : null, "textures/RFLes.png", 7480, HCS.RFarmor, addArmor("RFLesBody"), 1).func_77655_b("RFLesBody").func_111206_d("RFLesBody").func_77637_a(HCS.modcreativetab)), "\u041d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a \u043d\u0430\u0435\u043c\u043d\u0438\u043a\u0430");
        LanguageRegistry.addName((Object)(HCS.RFLesLegs = new ItemHCSArmor(CLIENT() ? ArmorRender.RF : null, "textures/RFLes.png", 7481, HCS.RFarmor, addArmor("RFLesLegs"), 2).func_77655_b("RFLesLegs").func_111206_d("RFLesLegs").func_77637_a(HCS.modcreativetab)), "\u0428\u0442\u0430\u043d\u044b \u043d\u0430\u0435\u043c\u043d\u0438\u043a\u0430");
        LanguageRegistry.addName((Object)(HCS.RFLesBoots = new ItemHCSArmor(CLIENT() ? ArmorRender.RF : null, "textures/RFLes.png", 7482, HCS.RFarmor, addArmor("RFLesBoots"), 3).func_77655_b("RFLesBoots").func_111206_d("RFLesBoots").func_77637_a(HCS.modcreativetab)), "\u0411\u043e\u0442\u0438\u043d\u043a\u0438 \u043d\u0430\u0435\u043c\u043d\u0438\u043a\u0430");
        LanguageRegistry.addName((Object)(HCS.RFGorHead = new ItemHCSArmor(CLIENT() ? ArmorRender.RF : null, "textures/RFGor.png", 7483, HCS.RFarmor, addArmor("RFGorHead"), 0).func_77655_b("RFGorHead").func_111206_d("RFGorHead").func_77637_a(HCS.modcreativetab)), "\u0428\u043b\u0435\u043c \u0427\u0412\u041a");
        LanguageRegistry.addName((Object)(HCS.RFGorBody = new ItemHCSArmor(CLIENT() ? ArmorRender.RF : null, "textures/RFGor.png", 7484, HCS.RFarmor, addArmor("RFGorBody"), 1).func_77655_b("RFGorBody").func_111206_d("RFGorBody").func_77637_a(HCS.modcreativetab)), "\u041d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a \u0427\u0412\u041a");
        LanguageRegistry.addName((Object)(HCS.RFGorLegs = new ItemHCSArmor(CLIENT() ? ArmorRender.RF : null, "textures/RFGor.png", 7485, HCS.RFarmor, addArmor("RFGorLegs"), 2).func_77655_b("RFGorLegs").func_111206_d("RFGorLegs").func_77637_a(HCS.modcreativetab)), "\u0428\u0442\u0430\u043d\u044b \u0427\u0412\u041a");
        LanguageRegistry.addName((Object)(HCS.RFGorBoots = new ItemHCSArmor(CLIENT() ? ArmorRender.RF : null, "textures/RFGor.png", 7486, HCS.RFarmor, addArmor("RFGorBoots"), 3).func_77655_b("RFGorBoots").func_111206_d("RFGorBoots").func_77637_a(HCS.modcreativetab)), "\u0411\u043e\u0442\u0438\u043d\u043a\u0438 \u0427\u0412\u041a");
        LanguageRegistry.addName((Object)(HCS.RFPesHead = new ItemHCSArmor(CLIENT() ? ArmorRender.RF : null, "textures/RFPes.png", 7487, HCS.RFarmor, addArmor("RFPesHead"), 0).func_77655_b("RFPesHead").func_111206_d("RFPesHead").func_77637_a(HCS.modcreativetab)), "\u0428\u043b\u0435\u043c \u043e\u0445\u043e\u0442\u043d\u0438\u043a\u0430");
        LanguageRegistry.addName((Object)(HCS.RFPesBody = new ItemHCSArmor(CLIENT() ? ArmorRender.RF : null, "textures/RFPes.png", 7488, HCS.RFarmor, addArmor("RFPesBody"), 1).func_77655_b("RFPesBody").func_111206_d("RFPesBody").func_77637_a(HCS.modcreativetab)), "\u041d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a \u043e\u0445\u043e\u0442\u043d\u0438\u043a\u0430");
        LanguageRegistry.addName((Object)(HCS.RFPesLegs = new ItemHCSArmor(CLIENT() ? ArmorRender.RF : null, "textures/RFPes.png", 7489, HCS.RFarmor, addArmor("RFPesLegs"), 2).func_77655_b("RFPesLegs").func_111206_d("RFPesLegs").func_77637_a(HCS.modcreativetab)), "\u0428\u0442\u0430\u043d\u044b \u043e\u0445\u043e\u0442\u043d\u0438\u043a\u0430");
        LanguageRegistry.addName((Object)(HCS.RFPesBoots = new ItemHCSArmor(CLIENT() ? ArmorRender.RF : null, "textures/RFPes.png", 7490, HCS.RFarmor, addArmor("RFPesBoots"), 3).func_77655_b("RFPesBoots").func_111206_d("RFPesBoots").func_77637_a(HCS.modcreativetab)), "\u0411\u043e\u0442\u0438\u043d\u043a\u0438 \u043e\u0445\u043e\u0442\u043d\u0438\u043a\u0430");
        LanguageRegistry.addName((Object)(HCS.ghileHead = new ItemHCSArmor(CLIENT() ? ArmorRender.ghile : null, "textures/ghile.png", 7491, HCS.GHILE, addArmor("ghilehead"), 0).func_77655_b("ghilehead").func_111206_d("ghilehead").func_77637_a(HCS.modcreativetab)), "\u041b\u0435\u0441\u043d\u043e\u0439 \u043a\u0430\u043c\u0443\u0444\u043b\u044f\u0436 \u0448\u043b\u0435\u043c");
        LanguageRegistry.addName((Object)(HCS.ghileBody = new ItemHCSArmor(CLIENT() ? ArmorRender.ghile : null, "textures/ghile.png", 7492, HCS.GHILE, addArmor("ghilebody"), 1).func_77655_b("ghilebody").func_111206_d("ghilebody").func_77637_a(HCS.modcreativetab)), "\u041b\u0435\u0441\u043d\u043e\u0439 \u043a\u0430\u043c\u0443\u0444\u043b\u044f\u0436 \u043d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a");
        LanguageRegistry.addName((Object)(HCS.ghileLegs = new ItemHCSArmor(CLIENT() ? ArmorRender.ghile : null, "textures/ghile.png", 7493, HCS.GHILE, addArmor("ghilelegs"), 2).func_77655_b("ghilelegs").func_111206_d("ghilelegs").func_77637_a(HCS.modcreativetab)), "\u041b\u0435\u0441\u043d\u043e\u0439 \u043a\u0430\u043c\u0443\u0444\u043b\u044f\u0436 \u0448\u0442\u0430\u043d\u044b");
        LanguageRegistry.addName((Object)(HCS.ghileBoots = new ItemHCSArmor(CLIENT() ? ArmorRender.ghile : null, "textures/ghile.png", 7494, HCS.GHILE, addArmor("ghileboots"), 3).func_77655_b("ghileboots").func_111206_d("ghileboots").func_77637_a(HCS.modcreativetab)), "\u041b\u0435\u0441\u043d\u043e\u0439 \u043a\u0430\u043c\u0443\u0444\u043b\u044f\u0436 \u0431\u043e\u0442\u0438\u043d\u043a\u0438");
        LanguageRegistry.addName((Object)(HCS.helmet = new ItemHCSArmor(CLIENT() ? ArmorRender.helmet : null, "textures/helmet.png", 7495, HCS.RFarmor, addArmor("helmet"), 0).func_77655_b("helmet").func_111206_d("helmet").func_77637_a(HCS.modcreativetab)), "\u0410\u0440\u043c\u0435\u0439\u0441\u043a\u0438\u0439 \u0448\u043b\u0435\u043c");
        LanguageRegistry.addName((Object)(HCS.helmetgl = new ItemHCSArmor(CLIENT() ? ArmorRender.helmetGL : null, "textures/helmet.png", 7496, HCS.RFarmor, addArmor("helmetgl"), 0).func_77655_b("helmetgl").func_111206_d("helmetgl").func_77637_a(HCS.modcreativetab)), "\u0410\u0440\u043c\u0435\u0439\u0441\u043a\u0438\u0439 \u0448\u043b\u0435\u043c \u0441 \u043e\u0447\u043a\u0430\u043c\u0438");
        LanguageRegistry.addName((Object)(HCS.helmetpnv = new ItemHCSArmor(CLIENT() ? ArmorRender.helmetPNV : null, "textures/helmet.png", 7497, HCS.RFarmor, addArmor("helmetpnv"), 0).func_77655_b("helmetpnv").func_111206_d("helmetpnv").func_77637_a(HCS.modcreativetab)), "\u0410\u0440\u043c\u0435\u0439\u0441\u043a\u0438\u0439 \u0448\u043b\u0435\u043c \u0441 \u041f\u041d\u0412");
        LanguageRegistry.addName((Object)(HCS.NewYearHead = new ItemHCSArmor(CLIENT() ? ArmorRender.NY : null, "textures/NY_armor.png", 7498, HCS.NYarmor, addArmor("NYHead"), 0).func_77655_b("NYHead").func_111206_d("NYHead").func_77637_a(HCS.modcreativetab)), "\u0428\u0430\u043f\u043a\u0430 \u0414\u0435\u0434\u0430 \u041c\u043e\u0440\u043e\u0437\u0430");
        LanguageRegistry.addName((Object)(HCS.NewYearBody = new ItemHCSArmor(CLIENT() ? ArmorRender.NY : null, "textures/NY_armor.png", 7499, HCS.NYarmor, addArmor("NYBody"), 1).func_77655_b("NYBody").func_111206_d("NYBody").func_77637_a(HCS.modcreativetab)), "\u0428\u0443\u0431\u0430 \u0414\u0435\u0434\u0430 \u041c\u043e\u0440\u043e\u0437\u0430");
        LanguageRegistry.addName((Object)(HCS.NewYearLegs = new ItemHCSArmor(CLIENT() ? ArmorRender.NY : null, "textures/NY_armor.png", 7500, HCS.NYarmor, addArmor("NYLegs"), 2).func_77655_b("NYLegs").func_111206_d("NYLegs").func_77637_a(HCS.modcreativetab)), "\u0428\u0442\u0430\u043d\u044b \u0414\u0435\u0434\u0430 \u041c\u043e\u0440\u043e\u0437\u0430");
        LanguageRegistry.addName((Object)(HCS.NewYearBoots = new ItemHCSArmor(CLIENT() ? ArmorRender.NY : null, "textures/NY_armor.png", 7501, HCS.NYarmor, addArmor("NYBoots"), 3).func_77655_b("NYBoots").func_111206_d("NYBoots").func_77637_a(HCS.modcreativetab)), "\u0412\u0430\u043b\u0435\u043d\u043a\u0438 \u0414\u0435\u0434\u0430 \u041c\u043e\u0440\u043e\u0437\u0430");
        LanguageRegistry.addName((Object)(HCS.balaclava_crw = new ItemHCSArmor(CLIENT() ? ArmorRender.balaclava : null, "textures/balaclava_crw.png", 7502, jhvo._b, addArmor("balaclava_crw"), 0).func_77655_b("balaclava_crw").func_111206_d("balaclava_crw").func_77637_a(HCS.modcreativetab)), "\u0411\u0430\u043b\u0430\u043a\u043b\u0430\u0432\u0430");
        LanguageRegistry.addName((Object)(HCS.JokerHead = new ItemHCSArmor(CLIENT() ? ArmorRender.Joker : null, "textures/Joker.png", 7503, HCS.NYarmor, addArmor("JokerHead"), 0).func_77655_b("JokerHead").func_111206_d("JokerHead").func_77637_a(HCS.modcreativetab)), "\u041c\u0430\u0441\u043a\u0430 \u0414\u0436\u043e\u043a\u0435\u0440\u0430");
        LanguageRegistry.addName((Object)(HCS.JokerBody = new ItemHCSArmor(CLIENT() ? ArmorRender.Joker : null, "textures/Joker.png", 7504, HCS.NYarmor, addArmor("JokerBody"), 1).func_77655_b("JokerBody").func_111206_d("JokerBody").func_77637_a(HCS.modcreativetab)), "\u0422\u0435\u043b\u043e \u0414\u0436\u043e\u043a\u0435\u0440\u0430");
        LanguageRegistry.addName((Object)(HCS.JokerLegs = new ItemHCSArmor(CLIENT() ? ArmorRender.Joker : null, "textures/Joker.png", 7505, HCS.NYarmor, addArmor("JokerLegs"), 2).func_77655_b("JokerLegs").func_111206_d("JokerLegs").func_77637_a(HCS.modcreativetab)), "\u0428\u0442\u0430\u043d\u044b \u0414\u0436\u043e\u043a\u0435\u0440\u0430");
        LanguageRegistry.addName((Object)(HCS.JokerBoots = new ItemHCSArmor(CLIENT() ? ArmorRender.Joker : null, "textures/Joker.png", 7506, HCS.NYarmor, addArmor("JokerBoots"), 3).func_77655_b("JokerBoots").func_111206_d("JokerBoots").func_77637_a(HCS.modcreativetab)), "\u0411\u043e\u0442\u0438\u043d\u043a\u0438 \u0414\u0436\u043e\u043a\u0435\u0440\u0430");
        LanguageRegistry.addName((Object)(HCS.Krampus_head = new ItemHCSArmor(CLIENT() ? ArmorRender.Krampus : null, "textures/Krampus.png", 7507, HCS.krampus, addArmor("Krampus_head"), 0).func_77655_b("Krampus_head").func_111206_d("Krampus_head").func_77637_a(HCS.modcreativetab)), "\u0413\u043e\u043b\u043e\u0432\u0430 \u041a\u0440\u0430\u043c\u043f\u0443\u0441\u0430");
        LanguageRegistry.addName((Object)(HCS.Krampus_body = new ItemHCSArmor(CLIENT() ? ArmorRender.Krampus : null, "textures/Krampus.png", 7508, HCS.krampus, addArmor("Krampus_body"), 1).func_77655_b("Krampus_body").func_111206_d("Krampus_body").func_77637_a(HCS.modcreativetab)), "\u041f\u043b\u0430\u0449 \u041a\u0440\u0430\u043c\u043f\u0443\u0441\u0430");
        LanguageRegistry.addName((Object)(HCS.Krampus_pants = new ItemHCSArmor(CLIENT() ? ArmorRender.Krampus : null, "textures/Krampus.png", 7509, HCS.krampus, addArmor("Krampus_pants"), 2).func_77655_b("Krampus_pants").func_111206_d("Krampus_pants").func_77637_a(HCS.modcreativetab)), "\u041b\u0430\u043f\u044b \u041a\u0440\u0430\u043c\u043f\u0443\u0441\u0430");
        LanguageRegistry.addName((Object)(HCS.Krampus_boots = new ItemHCSArmor(CLIENT() ? ArmorRender.Krampus : null, "textures/Krampus.png", 7510, HCS.krampus, addArmor("Krampus_boots"), 3).func_77655_b("Krampus_boots").func_111206_d("Krampus_boots").func_77637_a(HCS.modcreativetab)), "\u041a\u043e\u043f\u044b\u0442\u0430 \u041a\u0440\u0430\u043c\u043f\u0443\u0441\u0430");
        LanguageRegistry.addName((Object)(HCS.Armor2020_head = new ItemHCSArmor(CLIENT() ? ArmorRender.Armor2020 : null, "textures/Armor2020.png", 7511, HCS.ny2020armor, addArmor("Armor2020_head"), 0).func_77655_b("Armor2020_head").func_111206_d("Armor2020_head").func_77637_a(HCS.modcreativetab)), "\u0428\u0430\u043f\u043a\u0430 \u0423\u0448\u0430\u043d\u043a\u0430");
        LanguageRegistry.addName((Object)(HCS.Armor2020_body = new ItemHCSArmor(CLIENT() ? ArmorRender.Armor2020 : null, "textures/Armor2020.png", 7512, HCS.ny2020armor, addArmor("Armor2020_body"), 1).func_77655_b("Armor2020_body").func_111206_d("Armor2020_body").func_77637_a(HCS.modcreativetab)), "\u0421\u0435\u0432\u0435\u0440\u043d\u0430\u044f \u0448\u0443\u0431\u0430");
        LanguageRegistry.addName((Object)(HCS.Armor2020_pants = new ItemHCSArmor(CLIENT() ? ArmorRender.Armor2020 : null, "textures/Armor2020.png", 7513, HCS.ny2020armor, addArmor("Armor2020_pants"), 2).func_77655_b("Armor2020_pants").func_111206_d("Armor2020_pants").func_77637_a(HCS.modcreativetab)), "\u0423\u0442\u0435\u043f\u043b\u0435\u043d\u043d\u044b\u0435 \u0448\u0442\u0430\u043d\u044b");
        LanguageRegistry.addName((Object)(HCS.Armor2020_boots = new ItemHCSArmor(CLIENT() ? ArmorRender.Armor2020 : null, "textures/Armor2020.png", 7514, HCS.ny2020armor, addArmor("Armor2020_boots"), 3).func_77655_b("Armor2020_boots").func_111206_d("Armor2020_boots").func_77637_a(HCS.modcreativetab)), "\u0417\u0438\u043c\u043d\u0438\u0435 \u0412\u0430\u043b\u0435\u043d\u043a\u0438");
        LanguageRegistry.addName((Object)(HCS.heavy_head = new ItemHCSArmor(CLIENT() ? ArmorRender.Heavy : null, "textures/Heavy_tex.png", 2281, HCS.HEAVYARMOR, addArmor("heavy_head"), 0).func_77655_b("heavy_head").func_111206_d("Heavy_head_icon").func_77637_a(HCS.modcreativetab)), "Heavy \u0448\u043b\u0435\u043c");
        LanguageRegistry.addName((Object)(HCS.heavy_body = new ItemHCSArmor(CLIENT() ? ArmorRender.Heavy : null, "textures/Heavy_tex.png", 2283, HCS.HEAVYARMOR, addArmor("heavy_body"), 1).func_77655_b("heavy_body").func_111206_d("Heavy_body_icon").func_77637_a(HCS.modcreativetab)), "Heavy \u043d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a");
        LanguageRegistry.addName((Object)(HCS.heavy_pants = new ItemHCSArmor(CLIENT() ? ArmorRender.Heavy : null, "textures/Heavy_tex.png", 2284, HCS.HEAVYARMOR, addArmor("heavy_pants"), 2).func_77655_b("heavy_pants").func_111206_d("Heavy_pants_icon").func_77637_a(HCS.modcreativetab)), "Heavy \u0448\u0442\u0430\u043d\u044b");
        LanguageRegistry.addName((Object)(HCS.heavy_boots = new ItemHCSArmor(CLIENT() ? ArmorRender.Heavy : null, "textures/Heavy_tex.png", 2285, HCS.HEAVYARMOR, addArmor("heavy_boots"), 3).func_77655_b("heavy_boots").func_111206_d("Heavy_boots_icon").func_77637_a(HCS.modcreativetab)), "Heavy \u0431\u043e\u0442\u0438\u043d\u043a\u0438");
        LanguageRegistry.addName((Object)(HCS.prota_head = new ArmorSet(CLIENT() ? ArmorRender.Prota : null, "textures/Prota_tex.png", 2302, HCS.PROTAARMOR, addArmor("prota_head"), 0, "prota").func_77655_b("prota_head").func_111206_d("Prota_head_icon").func_77637_a(HCS.modcreativetab)), "X509 Prototype \u0448\u043b\u0435\u043c");
        LanguageRegistry.addName((Object)(HCS.prota_body = new ArmorSet(CLIENT() ? ArmorRender.Prota : null, "textures/Prota_tex.png", 2303, HCS.PROTAARMOR, addArmor("prota_body"), 1, "prota").func_77655_b("prota_body").func_111206_d("Prota_body_icon").func_77637_a(HCS.modcreativetab)), "X509 Prototype \u043d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a");
        LanguageRegistry.addName((Object)(HCS.prota_pants = new ArmorSet(CLIENT() ? ArmorRender.Prota : null, "textures/Prota_tex.png", 2304, HCS.PROTAARMOR, addArmor("prota_pants"), 2, "prota").func_77655_b("prota_pants").func_111206_d("Prota_pants_icon").func_77637_a(HCS.modcreativetab)), "X509 Prototype \u0448\u0442\u0430\u043d\u044b");
        LanguageRegistry.addName((Object)(HCS.prota_boots = new ArmorSet(CLIENT() ? ArmorRender.Prota : null, "textures/Prota_tex.png", 2305, HCS.PROTAARMOR, addArmor("prota_boots"), 3, "prota").func_77655_b("prota_boots").func_111206_d("Prota_boots_icon").func_77637_a(HCS.modcreativetab)), "X509 Prototype \u0431\u043e\u0442\u0438\u043d\u043a\u0438");
        LanguageRegistry.addName((Object)HCS.JAG[0], "Juggernaut helmet");
        LanguageRegistry.addName((Object)HCS.JAG[1], "Juggernaut bodyarmor");
        LanguageRegistry.addName((Object)HCS.JAG[2], "Juggernaut legs");
        LanguageRegistry.addName((Object)HCS.JAG[3], "Juggernaut boots");
        LanguageRegistry.addName((Object)(HCS.bandage = new ItemDrinkBackpackmod(4898, 0, "bandage").func_77655_b("bandage")), "\u0411\u0438\u043d\u0442");
        LanguageRegistry.addName((Object)(HCS.morphine = new ItemDrinkBackpackmod(4899, 0, "morphine").func_77655_b("morphine")), "Morphine Auto-Injector");
        LanguageRegistry.addName((Object)(HCS.cocacola = new ItemDrinkBackpackmod(4895, 35100, "CocaCola").func_77655_b("cocacola")), "Coca-Cola");
        LanguageRegistry.addName((Object)(HCS.pepsi = new ItemDrinkBackpackmod(4896, 35100, "PEPSI").func_77655_b("pepsi")), "Pepsi");
        LanguageRegistry.addName((Object)(HCS.mountaindew = new ItemDrinkBackpackmod(4897, 35100, "mntDEW").func_77655_b("mountaindew")), "Mountain Dew");
        LanguageRegistry.addName((Object)(HCS.SodaClays = new ItemDrinkBackpackmod(4900, 35100, "Mii_Soda").func_77655_b("SodaClays")), "Mii Soda");
        LanguageRegistry.addName((Object)(HCS.SodaDrwaste = new ItemDrinkBackpackmod(4901, 42900, "Lipton").func_77655_b("SodaDrwaste")), "Lipton");
        LanguageRegistry.addName((Object)(HCS.SodaMzly = new ItemDrinkBackpackmod(4903, 66300, "Heineken_Bear").func_77655_b("SodaMzly")), "Heineken Beer");
        LanguageRegistry.addName((Object)(HCS.SodaR4z0r = new ItemDrinkBackpackmod(4904, 35100, "Fanta").func_77655_b("SodaR4z0r")), "Fanta");
        LanguageRegistry.addName((Object)(HCS.SodaRabbit = new ItemDrinkBackpackmod(4905, 58500, "Kvass").func_77655_b("SodaRabbit")), "\u041a\u0432\u0430\u0441");
        LanguageRegistry.addName((Object)(HCS.SodaSmasht = new ItemDrinkBackpackmod(4906, 35100, "Sprite").func_77655_b("SodaSmasht")), "Sprite");
        LanguageRegistry.addName((Object)(HCS.CanBakedBeans = new ItemFoodBackpackmod(4907, 8, 0.8f, true, 39000, "Baked_Beans").func_77655_b("CanBakedBeans")), "Baked Beans");
        LanguageRegistry.addName((Object)(HCS.CanFrankBeans = new ItemFoodBackpackmod(4908, 8, 0.8f, false, 39000, "Beans_n_Franks").func_77655_b("CanFrankBeans")), "Frank Beans");
        LanguageRegistry.addName((Object)(HCS.CanPasta = new ItemFoodBackpackmod(4909, 8, 0.8f, false, 39000, "Franco_American").func_77655_b("CanPasta")), "Pasta");
        LanguageRegistry.addName((Object)(HCS.CanSardines = new ItemFoodBackpackmod(4910, 8, 0.8f, false, 35000, "Portola_Sardines").func_77655_b("CanSardines")), "Sardines");
        LanguageRegistry.addName((Object)(HCS.MRE = new ItemFoodBackpackmod(4911, 10, 0.8f, false, 70000, "MRE").func_77655_b("MRE")), "MRE");
        LanguageRegistry.addName((Object)(HCS.CanBoneboy = new ItemFoodBackpackmod(4912, 4, 0.8f, false, 39000, "Canned_meat").func_77655_b("CanBoneboy")), "Canned Meat");
        LanguageRegistry.addName((Object)(HCS.CanGriff = new ItemFoodBackpackmod(4913, 4, 0.8f, false, 45000, "Condensed_Milk").func_77655_b("CanGriff")), "\u0421\u0433\u0443\u0449\u0435\u043d\u043a\u0430");
        LanguageRegistry.addName((Object)(HCS.CanHerpy = new ItemFoodBackpackmod(4914, 4, 0.8f, false, 36000, "Pork_Cabbage").func_77655_b("CanHerpy")), "\u041a\u0430\u043f\u0443\u0441\u0442\u0430 \u0441\u043e \u0441\u0432\u0438\u043d\u0438\u043d\u043e\u0439");
        LanguageRegistry.addName((Object)(HCS.CanOrlok = new ItemFoodBackpackmod(4915, 4, 0.8f, false, 25000, "Stew_for_Dogs").func_77655_b("CanOrlok")), "\u0422\u0443\u0448\u0435\u043d\u043a\u0430 \u0434\u043b\u044f \u0441\u043e\u0431\u0430\u043a");
        LanguageRegistry.addName((Object)(HCS.firstAidKit = new ItemHeal(4916, 20.0f, 1, 5, "firstAidKit", "firstAidKit")), "\u0410\u043f\u0442\u0435\u0447\u043a\u0430");
        LanguageRegistry.addName((Object)(HCS.firstAidKit_b = new ItemHeal(4917, 20.0f, 1, 5, "firstAidKit_b", "firstAidKit")), "\u0410\u043f\u0442\u0435\u0447\u043a\u0430 \u0441 \u0431\u0438\u043d\u0442\u0430\u043c\u0438");
        LanguageRegistry.addName((Object)(HCS.small_firstAidKit = new ItemHeal(4918, 20.0f, 1, 1, "small_firstAidKit", "small_firstAidKit")), "\u041f\u0430\u043a\u0435\u0442 \u043a\u0440\u043e\u0432\u0438");
        LanguageRegistry.addName((Object)(HCS.pills = new ItemHeal(4919, 5.0f, 4, 1, "pills", "pills")), "\u0422\u0430\u0431\u043b\u0435\u0442\u043a\u0438");
        LanguageRegistry.addName((Object)(HCS.raincoat = new ItemWithDesc(4920).func_77655_b("raincoat").func_111206_d("hcsmod:raincoat").func_77637_a(HCS.modcreativetab)), "\u0414\u043e\u0436\u0434\u0435\u0432\u0438\u043a");
        LanguageRegistry.addName((Object)(HCS.gunrepair1 = new ItemWithDesc(4925).func_77655_b("gunrepair1").func_111206_d("hcsmod:gunrepair1").func_77637_a(HCS.modcreativetab).func_77656_e(10).func_77625_d(1)), "\u041d\u0430\u0431\u043e\u0440 \u043f\u043e\u0447\u0438\u043d\u043a\u0438 \u043e\u0440\u0443\u0436\u0438\u044f");
        LanguageRegistry.addName((Object)(HCS.holster = new ItemWithDesc(4930).func_77655_b("holster").func_111206_d("hcsmod:holster").func_77637_a(HCS.modcreativetab).func_77625_d(1)), "\u041a\u043e\u0431\u0443\u0440\u0430");
        LanguageRegistry.addName((Object)(HCS.warmclothes = new ItemWithDesc(4931).func_77655_b("warmclothes").func_111206_d("hcsmod:warmclothes").func_77637_a(HCS.modcreativetab).func_77625_d(1)), "\u0422\u0435\u043f\u043b\u0430\u044f \u043e\u0434\u0435\u0436\u0434\u0430");
        LanguageRegistry.addName((Object)(HCS.Rat2020 = new ItemRat2020(4932, "Rat2020").func_77655_b("Rat2020").func_111206_d("hcsmod:Rat2020").func_77637_a(HCS.modcreativetab).func_77625_d(20)), "\u0421\u0442\u0430\u0442\u0443\u044d\u0442\u043a\u0430 2020");
        GameRegistry.addShapelessRecipe(new ieta((jhvs)HCS.firstAidKit_b), new Object[] { HCS.firstAidKit, HCS.bandage });
    }
    
    private static boolean CLIENT() {
        return FMLLaunchHandler.side() == Side.CLIENT;
    }
    
    @Mod.EventHandler
    public void postload(final FMLPostInitializationEvent fmlPostInitializationEvent) {
        GameRegistry.addRecipe(new ieta(HCS.heavy_head, 1), (Object[])new Object[] { "YXY", "AZA", 'X', qmjs.field_77812_ad, 'Y', jhvs.field_77698_e[28889], 'Z', jhvs.field_77698_e[7713], 'A', jhvs.field_77703_o });
        GameRegistry.addRecipe(new ieta(HCS.heavy_body, 1), (Object[])new Object[] { "YXY", "ZAZ", "Z#Z", 'X', qmjs.field_77822_ae, 'Y', jhvs.field_77698_e[28889], 'Z', jhvs.field_77703_o, 'A', new ieta(jhvs.field_77756_aW, 1, 4) });
        GameRegistry.addRecipe(new ieta(HCS.heavy_pants, 1), (Object[])new Object[] { "YXY", "ZAZ", "Z#Z", 'X', qmjs.field_77824_af, 'Y', jhvs.field_77698_e[28889], 'Z', jhvs.field_77703_o, 'A', new ieta(jhvs.field_77756_aW, 1, 4) });
        GameRegistry.addRecipe(new ieta(HCS.heavy_boots, 1), (Object[])new Object[] { "YXY", "ZAZ", 'X', qmjs.field_77818_ag, 'Y', jhvs.field_77698_e[28889], 'Z', jhvs.field_77703_o, 'A', new ieta(jhvs.field_77756_aW, 1, 4) });
        if (fmlPostInitializationEvent.getSide().isClient()) {
            HcsClient.init();
        }
        Flashlight.instance.postInit(fmlPostInitializationEvent);
        if (fmlPostInitializationEvent.getSide() == Side.CLIENT) {
            try {
                new $();
            }
            catch (Throwable t) {}
        }
    }
    
    @Mod.EventHandler
    public void serverStarting(final FMLServerStartingEvent fmlServerStartingEvent) {
        HcsServer.$(fmlServerStartingEvent);
        applyBlockMods();
    }
    
    @Mod.EventHandler
    public void serverStarted(final FMLServerStartedEvent fmlServerStartedEvent) {
        HcsServer.$(fmlServerStartedEvent);
    }
    
    @kjuq
    @SideOnly(Side.CLIENT)
    public void onSound(final twod twod) {
        twod.manager._a("hcsmod:swing1.ogg");
        twod.manager._a("hcsmod:swing2.ogg");
        twod.manager._a("hcsmod:swing3.ogg");
        twod.manager._a("hcsmod:swing4.ogg");
        twod.manager._a("hcsmod:swing5.ogg");
        twod.manager._a("hcsmod:swing6.ogg");
        twod.manager._a("hcsmod:swing7.ogg");
        twod.manager._a("hcsmod:swing8.ogg");
        twod.manager._a("hcsmod:swing9.ogg");
    }
    
    @kjuq
    public void antiKnockBackCheatHAHA(final iwsa iwsa) {
        if (iwsa.entity instanceof EntityLivingBase) {
            ((EntityLivingBase)iwsa.entity).func_110148_a(srlj._c)._a(1.0);
        }
    }
    
    public static int getBackpackLVL(final EntityPlayer entityPlayer, final Side side) {
        final InventoryExtended inventoryExtended = (side == Side.CLIENT) ? ExtendedPlayer.client(entityPlayer.field_71092_bJ).inventory : ExtendedPlayer.server(entityPlayer).inventory;
        if (inventoryExtended != null && inventoryExtended.inventoryStacks[3] != null) {
            if (inventoryExtended.inventoryStacks[3]._d == HCS.min.field_77779_bT) {
                return 1;
            }
            if (inventoryExtended.inventoryStacks[3]._d == HCS.mid.field_77779_bT) {
                return 2;
            }
            if (inventoryExtended.inventoryStacks[3]._d == HCS.max.field_77779_bT) {
                return 3;
            }
        }
        return 0;
    }
    
    public static void feedAndWater(final String s) {
        final ExtendedPlayer server = ExtendedPlayer.server((EntityPlayer)zgmv._H().__af()._h(s));
        server.feed(1, 78000);
        server.water(1, 78000);
    }
    
    public static void heal(final String s, final float n) {
        ExtendedPlayer.server((EntityPlayer)zgmv._H().__af()._h(s)).startHeal(n);
    }
    
    public static void applyBlockMods() {
        for (final kjsv kjsv : kjsv.field_71973_m) {
            if (kjsv != null) {
                kjsv.func_71875_q();
            }
        }
    }
    
    public static int addArmor(final String s) {
        if (CLIENT()) {
            return wmvp.addNewArmourRendererPrefix(s);
        }
        return 0;
    }
    
    public static boolean inEmptyChunk(final Entity entity) {
        if (!entity.field_70170_p.field_72995_K) {
            return false;
        }
        final int c = dwbg._c(entity.field_70121_D.field_72340_a);
        final int c2 = dwbg._c(entity.field_70121_D.field_72338_b);
        final int c3 = dwbg._c(entity.field_70121_D.field_72339_c);
        final int e = dwbg._e(entity.field_70121_D.field_72336_d);
        final int e2 = dwbg._e(entity.field_70121_D.field_72337_e);
        final int e3 = dwbg._e(entity.field_70121_D.field_72334_f);
        for (int i = c; i <= e; ++i) {
            for (int j = c2; j <= e2; ++j) {
                for (int k = c3; k <= e3; ++k) {
                    if (entity.field_70170_p.func_72938_d(dwbg._c(entity.field_70165_t), dwbg._c(entity.field_70161_v)) instanceof ifck) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static String zombieLoot(final EntityPlayer entityPlayer, final Entity entity) {
        try {
            return HcsServer.zombieLoot(entityPlayer, entity);
        }
        catch (Throwable t) {
            return null;
        }
    }
    
    public static void shoot(final EntityPlayer entityPlayer) {
        shoot(entityPlayer, null);
    }
    
    public static void shoot(final EntityPlayer entityPlayer, final EntityShootFX entityShootFX) {
        if (entityPlayer.field_70170_p.field_72995_K) {
            final EntityLivingBase s = tuor._E()._s;
            if (entityPlayer == s) {
                CTickHandler.shootTime = 4;
            }
            if (entityShootFX != null) {
                HcsSurround.loudSound(entityShootFX.func_70032_d((Entity)s));
            }
        }
        else {
            final qmzb func_72938_d = entityPlayer.field_70170_p.func_72938_d(dwbg._c(entityPlayer.field_70165_t), dwbg._c(entityPlayer.field_70161_v));
            for (int i = func_72938_d._i - 5; i <= func_72938_d._i + 5; ++i) {
                for (int j = func_72938_d._j - 5; j <= func_72938_d._j + 5; ++j) {
                    final List[] m = entityPlayer.field_70170_p.func_72964_e(i, j)._m;
                    for (int length = m.length, k = 0; k < length; ++k) {
                        for (final EntityZombieDayZ next : m[k]) {
                            if (next instanceof EntityZombieDayZ) {
                                final EntityZombieDayZ entityZombieDayZ = next;
                                entityZombieDayZ.walkTo(entityPlayer.field_70165_t, entityPlayer.field_70163_u + entityPlayer.func_70047_e(), entityPlayer.field_70161_v);
                                entityZombieDayZ.attackAi.walkToPoint = true;
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static boolean isEntityInSafezone(final Entity entity) {
        return entity.field_70165_t > -147.0 && entity.field_70165_t < 163.0 && entity.field_70161_v > -156.0 && entity.field_70161_v < 153.0 && entity.field_70163_u > 10.0;
    }
    
    public static float daytime(final cuqu cuqu) {
        int n = (int)(cuqu.func_72820_D() % 24000L);
        if (n < 12000) {
            return 1.0f;
        }
        if (n < 13800) {
            n -= 12000;
            return 1.0f - n / 900.0f;
        }
        if (n > 22200) {
            n -= 22200;
            return n / 900.0f;
        }
        return 0.0f;
    }
    
    public static boolean isHealOtherItem(final ieta ieta) {
        return ieta != null && (ieta._a() instanceof ItemCustomGoldApple || ieta._a() instanceof ItemHeal);
    }
    
    public static void setWorldBorders(final float n, final float n2, final float n3, final float n4) {
        HCS.maxX = rojd.func_72330_a((double)n2, 0.0, (double)n3, (double)n2, 255.0, (double)n4);
        HCS.minX = rojd.func_72330_a((double)n, 0.0, (double)n3, (double)n, 255.0, (double)n4);
        HCS.maxZ = rojd.func_72330_a((double)n, 0.0, (double)n4, (double)n2, 255.0, (double)n4);
        HCS.minZ = rojd.func_72330_a((double)n, 0.0, (double)n3, (double)n2, 255.0, (double)n3);
    }
    
    static {
        HCS.modcreativetab = new CreativeTab("HCS Stuff");
        HCS.JAG = new ItemHCSArmor[4];
        HCS.NY_ZNEC = zway.addToolMaterial("NY_ZNEC", 0, 30, 0.0f, 3.0f, 0);
        HCS.NY_HVOST = zway.addToolMaterial("NY_HVOST", 0, 70, 0.0f, 2.0f, 0);
        HCS.NY_ALL = zway.addToolMaterial("NY_ALL", 0, 1561, 0.0f, 1.0f, 0);
        HCS.AXE = zway.addToolMaterial("AXE", 0, 1000, 0.0f, 1.0f, 0);
        HCS.KNIFE = zway.addToolMaterial("KNIFE", 0, 100, 0.0f, 0.0f, 0);
        HCS.worldSlowDown = 6L;
    }
}
