// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import hcsmod.HCS;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class HCSTab extends tekj
{
    public HCSTab(final String s) {
        super(s);
    }
    
    @SideOnly(Side.CLIENT)
    public String func_78024_c() {
        return "HCS Stuff";
    }
    
    @SideOnly(Side.CLIENT)
    public int func_78012_e() {
        return HCS.max.field_77779_bT;
    }
}
