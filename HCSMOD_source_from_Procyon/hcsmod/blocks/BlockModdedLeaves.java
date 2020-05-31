// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import net.minecraft.util.rojd;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.uxsf;

public class BlockModdedLeaves extends ccbi
{
    public static BlockModdedLeaves instance;
    public static boolean enableLeavesRender;
    
    public BlockModdedLeaves(final int n) {
        super(n);
        this.func_71907_b(false);
        BlockModdedLeaves.instance = this;
        if (uxsf.instance().getSide().equals((Object)Side.CLIENT)) {
            BlockModdedLeaves.instance.func_72133_a(false);
        }
    }
    
    public rojd func_71872_e(final cuqu cuqu, final int n, final int n2, final int n3) {
        return null;
    }
    
    public boolean func_71926_d() {
        return false;
    }
    
    public boolean func_71924_d(final dxti dxti, final int n, final int n2, final int n3, final int n4) {
        return false;
    }
    
    public void func_94332_a(final qlze qlze) {
        super.func_94332_a(qlze);
        kjsv.field_71952_K.func_94332_a(qlze);
    }
    
    public boolean func_71877_c(final dxti dxti, final int n, final int n2, final int n3, final int n4) {
        return BlockModdedLeaves.enableLeavesRender && super.func_71877_c(dxti, n, n2, n3, n4);
    }
    
    static {
        BlockModdedLeaves.enableLeavesRender = true;
    }
}
