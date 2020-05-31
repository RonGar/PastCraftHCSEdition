// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import net.minecraft.util.rojd;

public class BlockFlame extends srni
{
    public BlockFlame(final int n) {
        super(n);
        this.func_71900_a(1.0f);
        this.func_71875_q();
    }
    
    public boolean func_71926_d() {
        return false;
    }
    
    public boolean isAirBlock(final cuqu cuqu, final int n, final int n2, final int n3) {
        return true;
    }
    
    public boolean func_71918_c(final dxti dxti, final int n, final int n2, final int n3) {
        return false;
    }
    
    public boolean func_71886_c() {
        return false;
    }
    
    public rojd func_71872_e(final cuqu cuqu, final int n, final int n2, final int n3) {
        return null;
    }
    
    public boolean func_71913_a(final int n, final boolean b) {
        return b && n == 0;
    }
    
    public boolean func_71924_d(final dxti dxti, final int n, final int n2, final int n3, final int n4) {
        final ccfp func_72803_f = dxti.func_72803_f(n, n2, n3);
        return func_72803_f != this.field_72018_cp && (n4 == 1 || (func_72803_f != ccfp._w && super.func_71924_d(dxti, n, n2, n3, n4)));
    }
    
    public void func_94332_a(final qlze qlze) {
        super.func_94332_a(qlze);
        this.field_94336_cN = qlze._a("hcsmod:Empty");
    }
}
