// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

public class ClientProxy
{
    public static void blockRenderers() {
        HCSBlocks.koster = new BlockFlame(3900).func_111022_d("fire");
        zwak.bindTileEntitySpecialRenderer((Class)TileEntityBlockFence.class, (jhhk)new RendererBlockFence());
        wmvp.registerBlockHandler(HCSBlocks.renderFenceID = wmvp.getNextAvailableRenderId(), (owbd)new BlockFenceHandler());
        zwak.bindTileEntitySpecialRenderer((Class)TileEntityBlockFence_2.class, (jhhk)new RendererBlockFence_2());
        wmvp.registerBlockHandler(HCSBlocks.renderFence_2ID = wmvp.getNextAvailableRenderId(), (owbd)new BlockFence_2Handler());
        zwak.bindTileEntitySpecialRenderer((Class)TileEntityBlockFence_3.class, (jhhk)new RendererBlockFence_3());
        wmvp.registerBlockHandler(HCSBlocks.renderFence_3ID = wmvp.getNextAvailableRenderId(), (owbd)new BlockFence_3Handler());
        zwak.bindTileEntitySpecialRenderer((Class)TileEntityBlockFence_4.class, (jhhk)new RendererBlockFence_4());
        wmvp.registerBlockHandler(HCSBlocks.renderFence_4ID = wmvp.getNextAvailableRenderId(), (owbd)new BlockFence_4Handler());
        zwak.bindTileEntitySpecialRenderer((Class)TileEntityBlockFence_5.class, (jhhk)new RendererBlockFence_5());
        wmvp.registerBlockHandler(HCSBlocks.renderFence_5ID = wmvp.getNextAvailableRenderId(), (owbd)new BlockFence_5Handler());
        zwak.bindTileEntitySpecialRenderer((Class)TileEntityBlockFence_6.class, (jhhk)new RendererBlockFence_6());
        wmvp.registerBlockHandler(HCSBlocks.renderFence_6ID = wmvp.getNextAvailableRenderId(), (owbd)new BlockFence_6Handler());
        zwak.bindTileEntitySpecialRenderer((Class)TileEntityHedgehog.class, (jhhk)new RendererBlockHedgehog());
        wmvp.registerBlockHandler(HCSBlocks.renderhedgehog_ID = wmvp.getNextAvailableRenderId(), (owbd)new BlockHedgehogHandler());
        zwak.bindTileEntitySpecialRenderer((Class)TileEntityBlock.class, (jhhk)new RendererBlock());
        wmvp.registerBlockHandler(HCSBlocks.renderblock_ID = wmvp.getNextAvailableRenderId(), (owbd)new BlockHandler());
        zwak.bindTileEntitySpecialRenderer((Class)TileEntityStolb.class, (jhhk)new RendererStolbBlock());
        wmvp.registerBlockHandler(HCSBlocks.renderstolb_ID = wmvp.getNextAvailableRenderId(), (owbd)new BlockStolbHandler());
        zwak.bindTileEntitySpecialRenderer((Class)TileEntityKANUS.class, (jhhk)new RendererKANUSBlock());
        zwak.bindTileEntitySpecialRenderer((Class)TileEntityLAXAXAX.class, (jhhk)new RendererEZHBlock());
        wmvp.registerBlockHandler(HCSBlocks.renderEZH_ID = wmvp.getNextAvailableRenderId(), (owbd)new BlockEZHHandler());
    }
}
