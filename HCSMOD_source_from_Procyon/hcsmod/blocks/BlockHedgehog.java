// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.pico;
import net.minecraft.entity.Entity;
import net.minecraft.util.rojd;

public class BlockHedgehog extends samw
{
    public BlockHedgehog(final int n) {
        super(n, ccfp._d);
    }
    
    public void func_71902_a(final dxti dxti, final int n, final int n2, final int n3) {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public int func_71857_b() {
        return HCSBlocks.renderhedgehog_ID;
    }
    
    public boolean func_71926_d() {
        return false;
    }
    
    public rojd func_71872_e(final cuqu cuqu, final int n, final int n2, final int n3) {
        return null;
    }
    
    public boolean func_71886_c() {
        return false;
    }
    
    public void func_71869_a(final cuqu cuqu, final int n, final int n2, final int n3, final Entity entity) {
        if (entity.field_70173_aa % 5 == 0) {
            entity.func_70097_a(pico.field_76367_g, 1.0f);
        }
        entity.func_70110_aj();
    }
    
    public ogpr func_72274_a(final cuqu cuqu) {
        return new TileEntityHedgehog();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final qlze qlze) {
        super.field_94336_cN = qlze._a("blockwithmodel:fence");
    }
}
