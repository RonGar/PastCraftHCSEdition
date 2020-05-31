/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  antd
 *  ccfp
 *  cpw.mods.fml.common.IFMLSidedHandler
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.Loader
 *  cpw.mods.fml.common.Mod
 *  cpw.mods.fml.common.Mod$EventHandler
 *  cpw.mods.fml.common.Mod$Instance
 *  cpw.mods.fml.common.SidedProxy
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPostInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  cpw.mods.fml.common.event.FMLServerStartedEvent
 *  cpw.mods.fml.common.network.IConnectionHandler
 *  cpw.mods.fml.common.network.IGuiHandler
 *  cpw.mods.fml.common.network.NetworkMod
 *  cpw.mods.fml.common.network.NetworkMod$SidedPacketHandler
 *  cpw.mods.fml.common.network.NetworkRegistry
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.common.network.Player
 *  cpw.mods.fml.common.registry.EntityRegistry
 *  cpw.mods.fml.common.registry.GameRegistry
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  cpw.mods.fml.common.registry.TickRegistry
 *  cpw.mods.fml.common.uxsf
 *  cpw.mods.fml.relauncher.Side
 *  cuqu
 *  ekfx
 *  hbdy
 *  hcsmod.HcsInteract
 *  hcsmod.items.ItemKoster
 *  hcsmod.items.ItemPalatka
 *  ieta
 *  jhvs
 *  kjsv
 *  maaq
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.util.pico
 *  net.minecraftforge.common.bpzx
 *  net.minecraftforge.common.flgb
 *  net.minecraftforge.common.flgb$eidn
 *  net.minecraftforge.common.hrmy
 *  net.minecraftforge.common.wmvp
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.Event$eidn
 *  net.minecraftforge.event.eidl
 *  net.minecraftforge.event.hrmy
 *  net.minecraftforge.event.kjuq
 *  rpdj
 *  rpnz
 *  vlyb
 *  vlyb$uxsf
 *  yudj
 *  zgmv
 *  zhav
 */
package co.uk.flansmods.common;

import co.uk.flansmods.client.network.FlanPacketClient;
import co.uk.flansmods.common.BlockGunBox;
import co.uk.flansmods.common.BlockPlaneWorkbench;
import co.uk.flansmods.common.CommonGuiHandler;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.EntityParachute;
import co.uk.flansmods.common.EnumType;
import co.uk.flansmods.common.FlansHooks;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.GunBoxType;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.ItemBlockManyNames;
import co.uk.flansmods.common.ItemPart;
import co.uk.flansmods.common.ItemPlane;
import co.uk.flansmods.common.ItemTool;
import co.uk.flansmods.common.ItemVehicle;
import co.uk.flansmods.common.PartType;
import co.uk.flansmods.common.ServerTickHandler;
import co.uk.flansmods.common.TileEntityGunBox;
import co.uk.flansmods.common.ToolType;
import co.uk.flansmods.common.TypeFile;
import co.uk.flansmods.common.driveables.EntityPlane;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.EntityVehicle;
import co.uk.flansmods.common.driveables.EntityWheel;
import co.uk.flansmods.common.driveables.PlaneType;
import co.uk.flansmods.common.driveables.VehicleType;
import co.uk.flansmods.common.guns.AAGunType;
import co.uk.flansmods.common.guns.AttachmentType;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.EntityAAGun;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.guns.EntityGrenade;
import co.uk.flansmods.common.guns.GrenadeType;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemAAGun;
import co.uk.flansmods.common.guns.ItemAttachment;
import co.uk.flansmods.common.guns.ItemBullet;
import co.uk.flansmods.common.guns.ItemGrenade;
import co.uk.flansmods.common.guns.ItemGun;
import co.uk.flansmods.common.network.FlanPacketCommon;
import co.uk.flansmods.common.network.FlansModContentPackVerifier;
import co.uk.flansmods.common.network.PacketHit;
import co.uk.flansmods.common.teams.ArmourType;
import co.uk.flansmods.common.teams.BlockSpawner;
import co.uk.flansmods.common.teams.ChunkLoadingHandler;
import co.uk.flansmods.common.teams.CommandTeams;
import co.uk.flansmods.common.teams.EntityFlag;
import co.uk.flansmods.common.teams.EntityFlagpole;
import co.uk.flansmods.common.teams.EntityGunItem;
import co.uk.flansmods.common.teams.EntityTeamItem;
import co.uk.flansmods.common.teams.ItemFlagpole;
import co.uk.flansmods.common.teams.ItemOpStick;
import co.uk.flansmods.common.teams.ItemTeamArmour;
import co.uk.flansmods.common.teams.PlayerClass;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import co.uk.flansmods.common.teams.TileEntitySpawner;
import co.uk.flansmods.vintarz.BulletCombiner;
import co.uk.flansmods.vintarz.EntityShootFX;
import cpw.mods.fml.common.IFMLSidedHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.uxsf;
import cpw.mods.fml.relauncher.Side;
import hcsmod.HcsInteract;
import hcsmod.items.ItemKoster;
import hcsmod.items.ItemPalatka;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.pico;
import net.minecraftforge.common.bpzx;
import net.minecraftforge.common.flgb;
import net.minecraftforge.common.wmvp;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.eidl;
import net.minecraftforge.event.hrmy;
import net.minecraftforge.event.kjuq;

@Mod(modid="FlansModVtzVldrFix0", name="Flan's Mod modified by VinTarZ+vladru", version="HcsDayZ")
@NetworkMod(clientSideRequired=true, serverSideRequired=true, channels={"flansmods"}, clientPacketHandlerSpec=@NetworkMod.SidedPacketHandler(channels={"flansmods"}, packetHandler=FlanPacketClient.class), serverPacketHandlerSpec=@NetworkMod.SidedPacketHandler(channels={"flansmods"}, packetHandler=FlanPacketCommon.class))
public class FlansMod {
    @SidedProxy(clientSide="co.uk.flansmods.client.ClientProxy", serverSide="co.uk.flansmods.common.CommonProxy")
    public static CommonProxy proxy;
    @Mod.Instance(value="FlansModVtzVldrFix0")
    public static FlansMod instance;
    public static TeamsManager teamsManager;
    public static FlansHooks hooks;
    public static net.minecraftforge.common.hrmy configuration;
    public static int craftingTableID;
    public static int spawnerID;
    public static int gunBoxID;
    public static CreativeTabFlan tabFlanGuns;
    public static CreativeTabFlan tabFlanDriveables;
    public static CreativeTabFlan tabFlanParts;
    public static CreativeTabFlan tabFlanTeams;
    public static CreativeTabFlan tabFlanMechas;
    public static boolean DEBUG;
    public static ArrayList bulletItems;
    public static ArrayList partItems;
    public static ArrayList toolItems;
    public static ArrayList attachmentItems;
    public static ArrayList gunItems;
    public static ArrayList aaGunItems;
    public static ArrayList mechaToolItems;
    public static ArrayList mechaItems;
    public static ArrayList grenadeItems;
    public static ArrayList<jhvs> armourItems;
    public static boolean inMCP;
    public static boolean ABORT;
    public static long lastTime;
    public static boolean useRotation;
    public static boolean explosions;
    public static boolean driveablesBreakBlocks;
    public static boolean bombsEnabled;
    public static boolean bulletsEnabled;
    public static boolean forceAdventureMode;
    public static boolean canBreakGuns;
    public static boolean canBreakGlass;
    public static boolean armourDrops;
    public static int weaponDrops;
    public static boolean vehiclesNeedFuel;
    public static int mgLife;
    public static int planeLife;
    public static int vehicleLife;
    public static int mechaLove;
    public static int aaLife;
    public static kjsv craftingTable;
    public static kjsv spawner;
    public static jhvs opStick;
    public static jhvs flag;
    public static int ticker;
    public static String errorString;
    public static int errorStringTimer;
    public static FlansModPlayerHandler playerHandler;
    public static List planeItems;
    public static List vehicleItems;
    public static boolean isICBMSentryLoaded;
    public static BlockGunBox gunBoxBlock;
    public static File flanDir;

    @Mod.EventHandler
    public void preLoad(FMLPreInitializationEvent fMLPreInitializationEvent) {
        FlansMod.log("Preinitializing Flan's mod.");
        configuration = new net.minecraftforge.common.hrmy(fMLPreInitializationEvent.getSuggestedConfigurationFile());
        FlansMod.loadProperties();
        flanDir = new File(fMLPreInitializationEvent.getModConfigurationDirectory().getParentFile(), "/Flan/");
        if (!flanDir.exists()) {
            FlansMod.log("Flan folder not found. Creating empty folder.");
            FlansMod.log("You should get some content packs and put them in the Flan folder.");
            flanDir.mkdirs();
            flanDir.mkdir();
        }
        playerHandler = new FlansModPlayerHandler();
        teamsManager = new TeamsManager();
        try {
            Class.forName("net.minecraft.src.ModLoader");
        }
        catch (Exception exception) {
            inMCP = true;
        }
        bpzx.EVENT_BUS.register((Object)this);
        FlansMod.log("Preinitializing complete.");
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent fMLInitializationEvent) {
        FlansMod.log("Loading Flan's mod.");
        TickRegistry.registerTickHandler((ITickHandler)new ServerTickHandler(), (Side)Side.SERVER);
        proxy.doTickStuff();
        EntityRegistry.registerModEntity(EntityShootFX.class, (String)"VTZflanSFX", (int)1, (Object)this, (int)128, (int)2, (boolean)true);
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabFlan0", "Flan's Mod Guns");
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabFlan1", "Flan's Mod Vehicles");
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabFlan2", "Flan's Mod Parts");
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabFlan3", "Flan's Mod Team Stuff");
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabFlan4", "Flan's Mod Mechas");
        NetworkRegistry.instance().registerConnectionHandler((IConnectionHandler)new FlansModContentPackVerifier());
        craftingTable = new BlockPlaneWorkbench(craftingTableID, 1, 0).func_71864_b("flansCraftingBench");
        GameRegistry.registerBlock((kjsv)craftingTable, ItemBlockManyNames.class, (String)"planeCraftingTable");
        LanguageRegistry.addName((Object)new ieta(craftingTable, 1, 0), (String)"Vehicle Crafting Table");
        LanguageRegistry.addName((Object)new ieta(craftingTable, 1, 1), (String)"Gun Modification Table");
        LanguageRegistry.addName((Object)new ieta(craftingTable, 1, 2), (String)"Part Crafting Table : Coming Soon");
        GameRegistry.addRecipe((ieta)new ieta(craftingTable, 1, 0), (Object[])new Object[]{"BBB", "III", "III", Character.valueOf('B'), jhvs.field_77670_E, Character.valueOf('I'), jhvs.field_77703_o});
        GameRegistry.addRecipe((ieta)new ieta(craftingTable, 1, 1), (Object[])new Object[]{"ICI", "III", Character.valueOf('C'), jhvs.field_77721_bz, Character.valueOf('I'), jhvs.field_77703_o});
        EntityRegistry.registerGlobalEntityID(EntityPlane.class, (String)"Plane", (int)EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityPlane.class, (String)"Plane", (int)90, (Object)this, (int)128, (int)15, (boolean)false);
        EntityRegistry.registerGlobalEntityID(EntityVehicle.class, (String)"Vehicle", (int)EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityVehicle.class, (String)"Vehicle", (int)95, (Object)this, (int)128, (int)10, (boolean)false);
        EntityRegistry.registerGlobalEntityID(EntitySeat.class, (String)"Seat", (int)EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntitySeat.class, (String)"Seat", (int)99, (Object)this, (int)128, (int)20, (boolean)false);
        EntityRegistry.registerGlobalEntityID(EntityWheel.class, (String)"Wheel", (int)EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityWheel.class, (String)"Wheel", (int)103, (Object)this, (int)128, (int)20, (boolean)false);
        EntityRegistry.registerGlobalEntityID(EntityParachute.class, (String)"Parachute", (int)EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityParachute.class, (String)"Parachute", (int)101, (Object)this, (int)40, (int)20, (boolean)false);
        EntityRegistry.registerModEntity(EntityBullet.class, (String)"Bullet", (int)96, (Object)this, (int)40, (int)100, (boolean)false);
        EntityRegistry.registerGlobalEntityID(EntityGrenade.class, (String)"Grenade", (int)EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityGrenade.class, (String)"Grenade", (int)100, (Object)this, (int)40, (int)5, (boolean)true);
        EntityRegistry.registerGlobalEntityID(EntityAAGun.class, (String)"AAGun", (int)EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityAAGun.class, (String)"AAGun", (int)92, (Object)this, (int)40, (int)500, (boolean)false);
        GameRegistry.registerTileEntity(TileEntityGunBox.class, (String)"GunBoxTE");
        NetworkRegistry.instance().registerGuiHandler((Object)this, (IGuiHandler)new CommonGuiHandler());
        opStick = new ItemOpStick(23540);
        LanguageRegistry.addName((Object)new ieta(opStick, 1, 0), (String)"Stick of Ownership");
        LanguageRegistry.addName((Object)new ieta(opStick, 1, 1), (String)"Stick of Connecting");
        LanguageRegistry.addName((Object)new ieta(opStick, 1, 2), (String)"Stick of Mapping");
        LanguageRegistry.addName((Object)new ieta(opStick, 1, 3), (String)"Stick of Destruction");
        EntityRegistry.registerGlobalEntityID(EntityFlagpole.class, (String)"Flagpole", (int)EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityFlagpole.class, (String)"Flagpole", (int)93, (Object)this, (int)64, (int)5, (boolean)true);
        EntityRegistry.registerGlobalEntityID(EntityFlag.class, (String)"Flag", (int)EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityFlag.class, (String)"Flag", (int)94, (Object)this, (int)40, (int)5, (boolean)true);
        flag = new ItemFlagpole(23541).func_77655_b("flagpole");
        LanguageRegistry.addName((Object)flag, (String)"Flag");
        spawner = new BlockSpawner(spawnerID, ccfp._f).func_71864_b("teamsSpawner").func_71875_q().func_71894_b(1000000.0f);
        GameRegistry.registerBlock((kjsv)spawner, ItemBlockManyNames.class, (String)"teamSpawner");
        LanguageRegistry.addName((Object)new ieta(spawner, 1, 0), (String)"Item Spawner");
        LanguageRegistry.addName((Object)new ieta(spawner, 1, 1), (String)"Player Spawner");
        LanguageRegistry.addName((Object)new ieta(spawner, 1, 2), (String)"Vehicle Spawner");
        GameRegistry.registerTileEntity(TileEntitySpawner.class, (String)"TeamsSpawner");
        EntityRegistry.registerGlobalEntityID(EntityTeamItem.class, (String)"TeamsItem", (int)EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityTeamItem.class, (String)"TeamsItem", (int)97, (Object)this, (int)100, (int)10000, (boolean)true);
        EntityRegistry.registerGlobalEntityID(EntityGunItem.class, (String)"GunItem", (int)EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityGunItem.class, (String)"GunItem", (int)98, (Object)this, (int)100, (int)20, (boolean)true);
        flgb.setForcedChunkLoadingCallback((Object)this, (flgb.eidn)new ChunkLoadingHandler());
        proxy.registerTileEntityRenderers();
        proxy.loadDefaultGraphics();
        this.readContentPacks(fMLInitializationEvent);
        proxy.load();
        proxy.loadKeyBindings();
        FlansMod.log("Loading complete.");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent fMLPostInitializationEvent) {
        Loader.instance();
        isICBMSentryLoaded = Loader.isModLoaded((String)"ICBM|Sentry");
        hooks.hook();
        rpnz._a()._b().add(BulletCombiner.instance);
        System.out.println("[Flan] Hooking complete.");
    }

    @Mod.EventHandler
    public void registerCommand(FMLServerStartedEvent fMLServerStartedEvent) {
        hbdy hbdy2 = (hbdy)uxsf.instance().getSidedDelegate().getServer()._I();
        hbdy2.func_71560_a((antd)new CommandTeams());
    }

    private void getTypeFiles(List list) {
        for (File file : list) {
            EnumType[] arrenumType;
            if (file.isDirectory()) {
                for (Object object2 : EnumType.values()) {
                    arrenumType = new File(file, "/" + object2.folderName + "/");
                    if (!arrenumType.exists()) continue;
                    for (String[] arrstring : (Object)arrenumType.listFiles()) {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new FileReader((File)arrstring));
                            String[] arrstring2 = arrstring.getName().split("/");
                            TypeFile typeFile = new TypeFile((EnumType)((Object)object2), arrstring2[arrstring2.length - 1].split("\\.")[0]);
                            do {
                                String string;
                                try {
                                    string = bufferedReader.readLine();
                                }
                                catch (Exception exception) {
                                    break;
                                }
                                if (string == null) break;
                                typeFile.lines.add(string);
                            } while (true);
                            bufferedReader.close();
                        }
                        catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                    }
                }
                continue;
            }
            try {
                Object object;
                new java.util.zip.ZipFile(file);
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipInputStream));
                zipInputStream.getNextEntry();
                block13 : do {
                    Object object2;
                    if ((object = (Object)zipInputStream.getNextEntry()) == null) continue;
                    object2 = null;
                    arrenumType = EnumType.values();
                    Object object3 = arrenumType.length;
                    for (int i = 0; i < object3; ++i) {
                        String[] arrstring;
                        Object object4 = (Object)arrenumType[i];
                        if (!((ZipEntry)object).getName().startsWith(object4.folderName + "/") || ((ZipEntry)object).getName().split(object4.folderName + "/").length <= 1 || ((ZipEntry)object).getName().split(object4.folderName + "/")[1].length() <= 0) continue;
                        arrstring = ((ZipEntry)object).getName().split("/");
                        object2 = new TypeFile((EnumType)((Object)object4), arrstring[arrstring.length - 1].split("\\.")[0]);
                    }
                    if (object2 == null) continue;
                    do {
                        String string;
                        try {
                            string = bufferedReader.readLine();
                        }
                        catch (Exception exception) {
                            continue block13;
                        }
                        if (string == null) continue block13;
                        ((TypeFile)object2).lines.add(string);
                    } while (true);
                } while (object != null);
                bufferedReader.close();
                zipInputStream.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    private void readContentPacks(FMLInitializationEvent fMLInitializationEvent) {
        jhvs jhvs2;
        InfoType infoType;
        ClassLoader classLoader = zgmv.class.getClassLoader();
        Method method = null;
        try {
            method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            method.setAccessible(true);
        }
        catch (Exception exception) {
            FlansMod.log("Failed to get class loader. All content loading will now fail.");
            exception.printStackTrace();
        }
        List<File> list = proxy.getContentList(method, classLoader);
        fMLInitializationEvent.getSide().equals((Object)Side.CLIENT);
        this.getTypeFiles(list);
        for (TypeFile object : TypeFile.files.get((Object)EnumType.bullet)) {
            try {
                infoType = new BulletType(object);
                infoType.read(object);
                jhvs2 = new ItemBullet(((BulletType)infoType).itemID - 256, (BulletType)infoType).func_77655_b(((BulletType)infoType).shortName);
                bulletItems.add(jhvs2);
                LanguageRegistry.addName((Object)jhvs2, (String)((BulletType)infoType).name);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add bullet : " + object.name);
                exception.printStackTrace();
            }
        }
        FlansMod.log("Loaded bullets.");
        for (TypeFile typeFile : TypeFile.files.get((Object)EnumType.attachment)) {
            try {
                infoType = new AttachmentType(typeFile);
                infoType.read(typeFile);
                jhvs2 = new ItemAttachment(((AttachmentType)infoType).itemID - 256, (AttachmentType)infoType).func_77655_b(((AttachmentType)infoType).shortName);
                attachmentItems.add(jhvs2);
                LanguageRegistry.addName((Object)jhvs2, (String)((AttachmentType)infoType).name);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add attachment : " + typeFile.name);
                exception.printStackTrace();
            }
        }
        FlansMod.log("Loaded attachments.");
        for (TypeFile typeFile : TypeFile.files.get((Object)EnumType.gun)) {
            try {
                infoType = new GunType(typeFile);
                infoType.read(typeFile);
                jhvs2 = new ItemGun(((GunType)infoType).itemID - 256, (GunType)infoType).func_77655_b(((GunType)infoType).iconPath);
                gunItems.add(jhvs2);
                LanguageRegistry.addName((Object)jhvs2, (String)((GunType)infoType).name);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add gun : " + typeFile.name);
                exception.printStackTrace();
            }
        }
        FlansMod.log("Loaded guns.");
        for (TypeFile typeFile : TypeFile.files.get((Object)EnumType.grenade)) {
            try {
                infoType = new GrenadeType(typeFile);
                infoType.read(typeFile);
                jhvs2 = new ItemGrenade(((GrenadeType)infoType).itemID - 256, (GrenadeType)infoType).func_77655_b(((GrenadeType)infoType).iconPath);
                grenadeItems.add(jhvs2);
                LanguageRegistry.addName((Object)jhvs2, (String)((GrenadeType)infoType).name);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add grenade : " + typeFile.name);
                exception.printStackTrace();
            }
        }
        FlansMod.log("Loaded grenades.");
        for (TypeFile typeFile : TypeFile.files.get((Object)EnumType.part)) {
            try {
                infoType = new PartType(typeFile);
                ((PartType)infoType).read(typeFile);
                jhvs2 = new ItemPart(((PartType)infoType).itemID - 256, (PartType)infoType).func_77655_b(((PartType)infoType).iconPath);
                partItems.add(jhvs2);
                LanguageRegistry.addName((Object)jhvs2, (String)((PartType)infoType).name);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add part : " + typeFile.name);
                exception.printStackTrace();
            }
        }
        FlansMod.log("Loaded parts.");
        for (TypeFile typeFile : TypeFile.files.get((Object)EnumType.plane)) {
            try {
                infoType = new PlaneType(typeFile);
                infoType.read(typeFile);
                jhvs2 = new ItemPlane(((PlaneType)infoType).itemID - 256, (PlaneType)infoType).func_77655_b(((PlaneType)infoType).iconPath);
                planeItems.add(jhvs2);
                LanguageRegistry.addName((Object)jhvs2, (String)((PlaneType)infoType).name);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add plane : " + typeFile.name);
                exception.printStackTrace();
            }
        }
        FlansMod.log("Loaded planes.");
        for (TypeFile typeFile : TypeFile.files.get((Object)EnumType.vehicle)) {
            try {
                infoType = new VehicleType(typeFile);
                infoType.read(typeFile);
                jhvs2 = new ItemVehicle(((VehicleType)infoType).itemID - 256, (VehicleType)infoType).func_77655_b(((VehicleType)infoType).iconPath);
                vehicleItems.add(jhvs2);
                LanguageRegistry.addName((Object)jhvs2, (String)((VehicleType)infoType).name);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add vehicle : " + typeFile.name);
                exception.printStackTrace();
            }
        }
        FlansMod.log("Loaded vehicles.");
        for (TypeFile typeFile : TypeFile.files.get((Object)EnumType.aa)) {
            try {
                infoType = new AAGunType(typeFile);
                infoType.read(typeFile);
                jhvs2 = new ItemAAGun(((AAGunType)infoType).itemID - 256, (AAGunType)infoType).func_77655_b(((AAGunType)infoType).iconPath);
                aaGunItems.add(jhvs2);
                LanguageRegistry.addName((Object)jhvs2, (String)((AAGunType)infoType).name);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add AA gun : " + typeFile.name);
                exception.printStackTrace();
            }
        }
        FlansMod.log("Loaded AA guns.");
        for (TypeFile typeFile : TypeFile.files.get((Object)EnumType.tool)) {
            try {
                infoType = new ToolType(typeFile);
                infoType.read(typeFile);
                jhvs2 = new ItemTool(((ToolType)infoType).itemID - 256, (ToolType)infoType).func_77655_b(((ToolType)infoType).iconPath);
                toolItems.add(jhvs2);
                LanguageRegistry.addName((Object)jhvs2, (String)((ToolType)infoType).name);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add tool : " + typeFile.name);
                exception.printStackTrace();
            }
        }
        FlansMod.log("Loaded tools.");
        for (TypeFile typeFile : TypeFile.files.get((Object)EnumType.box)) {
            try {
                infoType = new GunBoxType(typeFile);
                ((GunBoxType)infoType).read(typeFile);
                ((GunBoxType)infoType).item = jhvs.field_77698_e[FlansMod.gunBoxBlock.field_71990_ca];
                ((GunBoxType)infoType).itemID = FlansMod.gunBoxBlock.field_71990_ca;
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add gun box : " + typeFile.name);
            }
        }
        FlansMod.log("Loaded gun boxes.");
        for (TypeFile typeFile : TypeFile.files.get((Object)EnumType.armour)) {
            try {
                infoType = new ArmourType(typeFile);
                infoType.read(typeFile);
                jhvs2 = new ItemTeamArmour((ArmourType)infoType).func_77655_b(((ArmourType)infoType).iconPath);
                armourItems.add(jhvs2);
                LanguageRegistry.addName((Object)jhvs2, (String)((ArmourType)infoType).name);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add armour : " + typeFile.name);
                exception.printStackTrace();
            }
        }
        FlansMod.log("Loaded armour.");
        for (TypeFile typeFile : TypeFile.files.get((Object)EnumType.playerClass)) {
            try {
                new co.uk.flansmods.common.teams.PlayerClass(typeFile);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add class : " + typeFile.name);
                exception.printStackTrace();
            }
        }
        FlansMod.log("Loaded classes.");
        for (TypeFile typeFile : TypeFile.files.get((Object)EnumType.team)) {
            try {
                new co.uk.flansmods.common.teams.Team(typeFile);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to add team : " + typeFile.name);
                exception.printStackTrace();
            }
        }
        FlansMod.log("Loaded teams.");
        for (InfoType infoType2 : InfoType.infoTypes) {
            infoType2.addRecipe();
        }
        FlansMod.log("Loaded recipes.");
    }

    public static void loadProperties() {
        configuration.load();
        craftingTableID = configuration.getBlock("Crafting Table", craftingTableID).getInt(craftingTableID);
        spawnerID = configuration.getBlock("Team Spawner", spawnerID).getInt(spawnerID);
        gunBoxID = configuration.getBlock("Gun Box", gunBoxID).getInt(gunBoxID);
        configuration.save();
    }

    public static void logQuietly(String string) {
    }

    public static void logLoudly(String string) {
        errorString = string;
        errorStringTimer = 100;
        System.out.println("SERIOUS PROBLEM!");
        FlansMod.log(string);
    }

    public static void log(Object object) {
        System.out.println("Flan's Mod : " + object);
    }

    @kjuq(priority=hrmy.HIGHEST)
    public void interact(vlyb vlyb2) {
        if (vlyb2.action == vlyb.uxsf.RIGHT_CLICK_BLOCK && !vlyb2.entityPlayer.field_71075_bZ._d) {
            if (vlyb2.entity.field_70170_p.field_72995_K) {
                if (!FlansMod.isAllowedItem(vlyb2.entityPlayer.func_71045_bC())) {
                    vlyb2.setCanceled(true);
                }
            } else if (!HcsInteract.$) {
                if (!FlansMod.isAllowedItem(vlyb2.entityPlayer.func_71045_bC())) {
                    vlyb2.setCanceled(true);
                } else {
                    vlyb2.useBlock = Event.eidn.DENY;
                    vlyb2.useItem = Event.eidn.ALLOW;
                }
            }
        }
    }

    private static boolean isAllowedItem(ieta ieta2) {
        return ieta2 != null && (ieta2._a() instanceof ItemPalatka || ieta2._a() instanceof ItemKoster || ieta2._a() instanceof yudj);
    }

    @kjuq
    public void hitBoxDamage(zhav zhav2) {
        if (zhav2.source.func_76346_g() != null && zhav2.source.func_76346_g() instanceof EntityPlayer) {
            PacketDispatcher.sendPacketToPlayer((maaq)PacketHit.buildPacket(false), (Player)((Player)zhav2.source.func_76346_g()));
        }
    }

    @kjuq
    public void hitBoxKill(ekfx ekfx2) {
        if (ekfx2.source.func_76346_g() != null && ekfx2.source.func_76346_g() instanceof EntityPlayer) {
            PacketDispatcher.sendPacketToPlayer((maaq)PacketHit.buildPacket(true), (Player)((Player)ekfx2.source.func_76346_g()));
        }
    }

    static {
        hooks = new FlansHooks();
        craftingTableID = 255;
        spawnerID = 254;
        gunBoxID = 200;
        tabFlanGuns = new CreativeTabFlan(0);
        tabFlanDriveables = new CreativeTabFlan(1);
        tabFlanParts = new CreativeTabFlan(2);
        tabFlanTeams = new CreativeTabFlan(3);
        tabFlanMechas = new CreativeTabFlan(4);
        DEBUG = false;
        bulletItems = new ArrayList();
        partItems = new ArrayList();
        toolItems = new ArrayList();
        attachmentItems = new ArrayList();
        gunItems = new ArrayList();
        aaGunItems = new ArrayList();
        mechaToolItems = new ArrayList();
        mechaItems = new ArrayList();
        grenadeItems = new ArrayList();
        armourItems = new ArrayList();
        inMCP = false;
        ABORT = false;
        useRotation = false;
        explosions = true;
        driveablesBreakBlocks = false;
        bombsEnabled = true;
        bulletsEnabled = true;
        forceAdventureMode = true;
        canBreakGuns = true;
        canBreakGlass = true;
        armourDrops = true;
        weaponDrops = 1;
        vehiclesNeedFuel = true;
        mgLife = 0;
        planeLife = 0;
        vehicleLife = 0;
        mechaLove = 0;
        aaLife = 0;
        errorString = "";
        errorStringTimer = 0;
        planeItems = new ArrayList();
        vehicleItems = new ArrayList();
    }
}

