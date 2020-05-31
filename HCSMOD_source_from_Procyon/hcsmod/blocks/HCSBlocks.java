// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.uxsf;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class HCSBlocks
{
    static kjsv kolonka;
    public static kjsv koster;
    public static tekj modcreativetab;
    public static int renderFenceID;
    public static kjsv blockFence;
    public static int renderFence_2ID;
    public static kjsv blockFence_2;
    public static int renderFence_3ID;
    public static kjsv blockFence_3;
    public static int renderFence_4ID;
    public static kjsv blockFence_4;
    public static int renderFence_5ID;
    public static kjsv blockFence_5;
    public static int renderFence_6ID;
    public static kjsv blockFence_6;
    public static int renderhedgehog_ID;
    public static kjsv blockhedgehog;
    public static int renderblock_ID;
    public static kjsv blockblock;
    public static int renderstolb_ID;
    public static kjsv blockstolb;
    public static kjsv webpplus;
    public static int renderEZH_ID;
    public static kjsv blockEZH;
    
    public static void registerBlocks() {
        GameRegistry.registerBlock(HCSBlocks.kolonka = new KolonkaBlock(510).func_71849_a(HCSBlocks.modcreativetab).func_71864_b("kolonka"), "Kolonka");
        GameRegistry.registerTileEntity((Class)KolonkaEntity.class, "tileEntityKolonka");
        LanguageRegistry.addName((Object)HCSBlocks.kolonka, "Kolonka");
        GameRegistry.registerBlock(HCSBlocks.blockFence, "Block Fence");
        GameRegistry.registerTileEntity((Class)TileEntityBlockFence.class, "TileEntityBlockFence");
        LanguageRegistry.addName((Object)HCSBlocks.blockFence, "Planks barricade");
        GameRegistry.registerBlock(HCSBlocks.blockFence_2, "Block Fence 2");
        GameRegistry.registerTileEntity((Class)TileEntityBlockFence_2.class, "TileEntityBlockFence_2");
        LanguageRegistry.addName((Object)HCSBlocks.blockFence_2, "Broken high fence");
        GameRegistry.registerBlock(HCSBlocks.blockFence_3, "Block Fence 3");
        GameRegistry.registerTileEntity((Class)TileEntityBlockFence_3.class, "TileEntityBlockFence_3");
        LanguageRegistry.addName((Object)HCSBlocks.blockFence_3, "Broke high fence 1");
        GameRegistry.registerBlock(HCSBlocks.blockFence_4, "Block Fence 4");
        GameRegistry.registerTileEntity((Class)TileEntityBlockFence_4.class, "TileEntityBlockFence_4");
        LanguageRegistry.addName((Object)HCSBlocks.blockFence_4, "Broken high fence 2");
        GameRegistry.registerBlock(HCSBlocks.blockFence_5, "Block Fence 5");
        GameRegistry.registerTileEntity((Class)TileEntityBlockFence_5.class, "TileEntityBlockFence_5");
        LanguageRegistry.addName((Object)HCSBlocks.blockFence_5, "High fence corner");
        GameRegistry.registerBlock(HCSBlocks.blockFence_6, "Block Fence 6");
        GameRegistry.registerTileEntity((Class)TileEntityBlockFence_6.class, "TileEntityBlockFence_6");
        LanguageRegistry.addName((Object)HCSBlocks.blockFence_6, "High fence straight");
        GameRegistry.registerBlock(HCSBlocks.blockhedgehog, "Block hedgehog");
        GameRegistry.registerTileEntity((Class)TileEntityHedgehog.class, "TileEntityHedgehog");
        LanguageRegistry.addName((Object)HCSBlocks.blockhedgehog, "Block hedgehog");
        GameRegistry.registerBlock(HCSBlocks.blockstolb, "Block stolb");
        GameRegistry.registerTileEntity((Class)TileEntityStolb.class, "TileEntityStolb");
        LanguageRegistry.addName((Object)HCSBlocks.blockstolb, "Block stolb");
        GameRegistry.registerBlock(HCSBlocks.webpplus, "Web plus");
        LanguageRegistry.addName((Object)HCSBlocks.webpplus, "Web plus");
        GameRegistry.registerBlock(HCSBlocks.blockEZH, "Block ezh");
        GameRegistry.registerTileEntity((Class)TileEntityLAXAXAX.class, "TileEntityLAXAXAX");
        LanguageRegistry.addName((Object)HCSBlocks.blockEZH, "Block ezh");
        if (uxsf.instance().getSide() == Side.CLIENT) {
            ClientProxy.blockRenderers();
        }
    }
    
    static {
        HCSBlocks.modcreativetab = new CreativeTab("HCS Blocks");
        HCSBlocks.blockFence = new BlockFence(500).func_71849_a(HCSBlocks.modcreativetab).func_71864_b("blockFence");
        HCSBlocks.blockFence_2 = new BlockFence_2(501).func_71849_a(HCSBlocks.modcreativetab).func_71864_b("blockFence_2");
        HCSBlocks.blockFence_3 = new BlockFence_3(502).func_71849_a(HCSBlocks.modcreativetab).func_71864_b("blockFence_3");
        HCSBlocks.blockFence_4 = new BlockFence_4(503).func_71849_a(HCSBlocks.modcreativetab).func_71864_b("blockFence_4");
        HCSBlocks.blockFence_5 = new BlockFence_5(504).func_71849_a(HCSBlocks.modcreativetab).func_71864_b("blockFence_5");
        HCSBlocks.blockFence_6 = new BlockFence_6(505).func_71849_a(HCSBlocks.modcreativetab).func_71864_b("blockFence_6");
        HCSBlocks.blockhedgehog = new BlockHedgehog(506).func_71849_a(HCSBlocks.modcreativetab).func_71864_b("blockhedgehog");
        HCSBlocks.blockblock = new BlockBlock(507).func_71849_a(HCSBlocks.modcreativetab).func_71864_b("blockblock");
        HCSBlocks.blockstolb = new BlockStolb(508).func_71849_a(HCSBlocks.modcreativetab).func_71864_b("blockstolb");
        HCSBlocks.webpplus = new BlockWebPlus(509).func_71849_a(HCSBlocks.modcreativetab).func_71864_b("webpplus");
        HCSBlocks.blockEZH = new BlockEZH(511).func_71849_a(HCSBlocks.modcreativetab).func_71864_b("blockEZH");
    }
}
