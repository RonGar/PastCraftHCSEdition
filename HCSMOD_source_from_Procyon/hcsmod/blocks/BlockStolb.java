// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLiving;

public class BlockStolb extends samw
{
    public BlockStolb(final int n) {
        super(n, ccfp._d);
    }
    
    public void func_71902_a(final dxti dxti, final int n, final int n2, final int n3) {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public int func_71857_b() {
        return HCSBlocks.renderstolb_ID;
    }
    
    public boolean func_71926_d() {
        return false;
    }
    
    public boolean func_71886_c() {
        return false;
    }
    
    public void onBlockPlacedBy(final cuqu cuqu, final int n, final int n2, final int n3, final EntityLiving entityLiving, final ieta ieta) {
    }
    
    public ogpr func_72274_a(final cuqu cuqu) {
        return new TileEntityStolb();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final qlze qlze) {
        super.field_94336_cN = qlze._a("blockwithmodel:fence");
    }
}
