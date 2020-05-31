/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  antd
 *  com.google.common.eventbus.EventBus
 *  com.google.common.eventbus.Subscribe
 *  cpw.mods.fml.common.DummyModContainer
 *  cpw.mods.fml.common.FMLLog
 *  cpw.mods.fml.common.LoadController
 *  cpw.mods.fml.common.Loader
 *  cpw.mods.fml.common.ModMetadata
 *  cpw.mods.fml.common.WorldAccessContainer
 *  cpw.mods.fml.common.event.FMLConstructionEvent
 *  cpw.mods.fml.common.event.FMLLoadCompleteEvent
 *  cpw.mods.fml.common.event.FMLPostInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  cpw.mods.fml.common.event.FMLServerStartingEvent
 *  cpw.mods.fml.common.network.FMLNetworkHandler
 *  cpw.mods.fml.common.network.NetworkMod
 *  cpw.mods.fml.common.network.NetworkModHandler
 *  eidl
 *  hrmy
 *  hsus
 *  net.minecraftforge.classloading.FMLForgePlugin
 *  net.minecraftforge.common.eidn
 *  net.minecraftforge.common.flgb
 *  net.minecraftforge.common.hrmy
 *  net.minecraftforge.common.idol
 *  net.minecraftforge.common.network.ForgeConnectionHandler
 *  net.minecraftforge.common.network.ForgeNetworkHandler
 *  net.minecraftforge.common.network.ForgePacketHandler
 *  net.minecraftforge.common.network.ForgeTinyPacketHandler
 *  net.minecraftforge.common.wmvp
 *  net.minecraftforge.oredict.RecipeSorter
 *  net.minecraftforge.server.command.ForgeCommand
 *  scko
 *  ydxr
 *  zgmv
 *  zxiv
 */
package net.minecraftforge.common;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.WorldAccessContainer;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkModHandler;
import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import net.minecraftforge.classloading.FMLForgePlugin;
import net.minecraftforge.common.eidn;
import net.minecraftforge.common.flgb;
import net.minecraftforge.common.hrmy;
import net.minecraftforge.common.idol;
import net.minecraftforge.common.network.ForgeConnectionHandler;
import net.minecraftforge.common.network.ForgeNetworkHandler;
import net.minecraftforge.common.network.ForgePacketHandler;
import net.minecraftforge.common.network.ForgeTinyPacketHandler;
import net.minecraftforge.common.wmvp;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.server.command.ForgeCommand;

@NetworkMod(channels={"FORGE"}, connectionHandler=ForgeConnectionHandler.class, packetHandler=ForgePacketHandler.class, tinyPacketHandler=ForgeTinyPacketHandler.class)
public class ForgeDummyContainer
extends DummyModContainer
implements WorldAccessContainer {
    public static int clumpingThreshold = 64;
    public static boolean removeErroringEntities = false;
    public static boolean removeErroringTileEntities = false;
    public static boolean disableStitchedFileSaving = false;
    public static boolean forceDuplicateFluidBlockCrash = true;
    public static boolean fullBoundingBoxLadders = false;
    public static double zombieSummonBaseChance = 0.1;
    public static int[] blendRanges = new int[]{20, 15, 10, 5};
    public static float zombieBabyChance = 0.05f;
    public static boolean shouldSortRecipies = false;

    public ForgeDummyContainer() {
        super(new ModMetadata());
        hrmy hrmy2;
        wmvp wmvp2;
        ModMetadata modMetadata = this.getMetadata();
        modMetadata.modId = "Forge";
        modMetadata.name = "Minecraft Forge";
        modMetadata.version = String.format("%d.%d.%d.%d", 9, 11, 1, 965);
        modMetadata.credits = "Made possible with help from many people";
        modMetadata.authorList = Arrays.asList("LexManos", "Eloraam", "Spacetoad");
        modMetadata.description = "Minecraft Forge is a common open source API allowing a broad range of mods to work cooperatively together. It allows many mods to be created without them editing the main Minecraft code.";
        modMetadata.url = "http://MinecraftForge.net";
        modMetadata.updateUrl = "http://MinecraftForge.net/forum/index.php/topic,5.0.html";
        modMetadata.screenshots = new String[0];
        modMetadata.logoFile = "/forge_logo.png";
        File file = new File(Loader.instance().getConfigDir(), "forge.cfg");
        try {
            hrmy2 = new hrmy(file);
        }
        catch (Exception exception) {
            System.out.println("Error loading forge.cfg, deleting file and resetting: ");
            exception.printStackTrace();
            if (file.exists()) {
                file.delete();
            }
            hrmy2 = new hrmy(file);
        }
        if (!hrmy2.isChild) {
            hrmy2.load();
            wmvp2 = hrmy2.get("general", "enableGlobalConfig", false);
            if (wmvp2.getBoolean(false)) {
                hrmy.enableGlobalConfig();
            }
        }
        wmvp2 = hrmy2.get("general", "clumpingThreshold", 64);
        wmvp2.comment = "Controls the number threshold at which Packet51 is preferred over Packet52, default and minimum 64, maximum 1024";
        clumpingThreshold = wmvp2.getInt(64);
        if (clumpingThreshold > 1024 || clumpingThreshold < 64) {
            clumpingThreshold = 64;
            wmvp2.set(64);
        }
        wmvp2 = hrmy2.get("general", "removeErroringEntities", false);
        wmvp2.comment = "Set this to just remove any TileEntity that throws a error in there update method instead of closing the server and reporting a crash log. BE WARNED THIS COULD SCREW UP EVERYTHING USE SPARINGLY WE ARE NOT RESPONSIBLE FOR DAMAGES.";
        removeErroringEntities = wmvp2.getBoolean(false);
        if (removeErroringEntities) {
            FMLLog.warning((String)"Enabling removal of erroring Entities - USE AT YOUR OWN RISK", (Object[])new Object[0]);
        }
        wmvp2 = hrmy2.get("general", "removeErroringTileEntities", false);
        wmvp2.comment = "Set this to just remove any TileEntity that throws a error in there update method instead of closing the server and reporting a crash log. BE WARNED THIS COULD SCREW UP EVERYTHING USE SPARINGLY WE ARE NOT RESPONSIBLE FOR DAMAGES.";
        removeErroringTileEntities = wmvp2.getBoolean(false);
        if (removeErroringTileEntities) {
            FMLLog.warning((String)"Enabling removal of erroring Tile Entities - USE AT YOUR OWN RISK", (Object[])new Object[0]);
        }
        wmvp2 = hrmy2.get("general", "fullBoundingBoxLadders", false);
        wmvp2.comment = "Set this to check the entire entity's collision bounding box for ladders instead of just the block they are in. Causes noticable differences in mechanics so default is vanilla behavior. Default: false";
        fullBoundingBoxLadders = wmvp2.getBoolean(false);
        wmvp2 = hrmy2.get("general", "forceDuplicateFluidBlockCrash", true);
        wmvp2.comment = "Set this to force a crash if more than one block attempts to link back to the same Fluid. Enabled by default.";
        forceDuplicateFluidBlockCrash = wmvp2.getBoolean(true);
        if (!forceDuplicateFluidBlockCrash) {
            FMLLog.warning((String)"Disabling forced crashes on duplicate Fluid Blocks - USE AT YOUR OWN RISK", (Object[])new Object[0]);
        }
        wmvp2 = hrmy2.get("general", "biomeSkyBlendRange", new int[]{20, 15, 10, 5});
        wmvp2.comment = "Control the range of sky blending for colored skies in biomes.";
        blendRanges = wmvp2.getIntList();
        wmvp2 = hrmy2.get("general", "zombieBaseSummonChance", 0.1);
        wmvp2.comment = "Base zombie summoning spawn chance. Allows changing the bonus zombie summoning mechanic.";
        zombieSummonBaseChance = wmvp2.getDouble(0.1);
        wmvp2 = hrmy2.get("general", "zombieBabyChance", 0.05);
        wmvp2.comment = "Chance that a zombie (or subclass) is a baby. Allows changing the zombie spawning mechanic.";
        zombieBabyChance = (float)wmvp2.getDouble(0.05);
        wmvp2 = hrmy2.get("general", "sortRecipies", shouldSortRecipies);
        wmvp2.comment = "Set to true to enable the post initlization sorting of crafting recipes using Froge's sorter. May cause desyncing on conflicting recipies. ToDo: Set to true by default in 1.7";
        shouldSortRecipies = wmvp2.getBoolean(shouldSortRecipies);
        if (hrmy2.hasChanged()) {
            hrmy2.save();
        }
    }

    public boolean registerBus(EventBus eventBus, LoadController loadController) {
        eventBus.register((Object)this);
        return true;
    }

    @Subscribe
    public void modConstruction(FMLConstructionEvent fMLConstructionEvent) {
        FMLLog.info((String)"Registering Forge Packet Handler", (Object[])new Object[0]);
        try {
            FMLNetworkHandler.instance().registerNetworkMod((NetworkModHandler)new ForgeNetworkHandler(this));
            FMLLog.info((String)"Succeeded registering Forge Packet Handler", (Object[])new Object[0]);
        }
        catch (Exception exception) {
            FMLLog.log((Level)Level.SEVERE, (Throwable)exception, (String)"Failed to register packet handler for Forge", (Object[])new Object[0]);
        }
    }

    @Subscribe
    public void preInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        flgb.captureConfig((File)fMLPreInitializationEvent.getModConfigurationDirectory());
    }

    @Subscribe
    public void postInit(FMLPostInitializationEvent fMLPostInitializationEvent) {
        eidn.registerAllBiomesAndGenerateEvents();
        flgb.loadConfiguration();
    }

    @Subscribe
    public void onAvalible(FMLLoadCompleteEvent fMLLoadCompleteEvent) {
        if (shouldSortRecipies) {
            RecipeSorter.sortCraftManager();
        }
    }

    @Subscribe
    public void serverStarting(FMLServerStartingEvent fMLServerStartingEvent) {
        fMLServerStartingEvent.registerServerCommand((antd)new ForgeCommand(fMLServerStartingEvent.getServer()));
    }

    public hsus getDataForWriting(ydxr ydxr2, scko scko2) {
        hsus hsus2 = new hsus();
        hsus hsus3 = idol.saveDimensionDataMap();
        hsus2._a("DimensionData", hsus3);
        return hsus2;
    }

    public void readData(ydxr ydxr2, scko scko2, Map<String, zxiv> map, hsus hsus2) {
        if (hsus2._c("DimensionData")) {
            idol.loadDimensionDataMap(hsus2._c("DimensionData") ? hsus2._m("DimensionData") : null);
        }
    }

    public File getSource() {
        return FMLForgePlugin.forgeLocation;
    }

    public Class<?> getCustomResourcePackClass() {
        if (this.getSource().isDirectory()) {
            return hrmy.class;
        }
        return eidl.class;
    }
}

