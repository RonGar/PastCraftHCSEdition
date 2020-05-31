// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.flashlight;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBattery extends jhvs
{
    public ItemBattery(final int n) {
        super(n - 256);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final qlze qlze) {
        this.field_77791_bV = qlze._a("hcsmod:battery");
    }
}
