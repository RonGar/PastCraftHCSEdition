// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

public class BlockFence_6Handler implements owbd
{
    public void renderInventoryBlock(final kjsv kjsv, final int n, final int n2, final dfta dfta) {
        if (kjsv == HCSBlocks.blockFence_6) {
            nctg._b._a((ogpr)new TileEntityBlockFence_2(), 0.0, 0.0, 0.0, n * 90.0f);
        }
    }
    
    public boolean renderWorldBlock(final dxti dxti, final int n, final int n2, final int n3, final kjsv kjsv, final int n4, final dfta dfta) {
        return false;
    }
    
    public boolean shouldRender3DInInventory() {
        return true;
    }
    
    public int getRenderId() {
        return 0;
    }
}
