// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import hcsmod.HCS;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTab extends tekj
{
    public CreativeTab(final String s) {
        super(s);
    }
    
    @SideOnly(Side.CLIENT)
    public String func_78024_c() {
        return "hcsmod";
    }
    
    @SideOnly(Side.CLIENT)
    public int func_78012_e() {
        return HCS.max.field_77779_bT;
    }
}
