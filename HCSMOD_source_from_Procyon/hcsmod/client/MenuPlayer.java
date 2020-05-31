// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import net.minecraft.entity.EntityLiving;

public class MenuPlayer extends EntityLiving
{
    static ieta[] items;
    
    public MenuPlayer() {
        super((cuqu)null);
    }
    
    public ieta func_70694_bm() {
        return MenuPlayer.items[0];
    }
    
    public ieta func_71124_b(final int n) {
        return MenuPlayer.items[n];
    }
    
    public void func_70062_b(final int n, final ieta ieta) {
        MenuPlayer.items[n] = ieta;
    }
    
    public ieta[] func_70035_c() {
        return null;
    }
    
    public float func_70013_c(final float n) {
        return 1.0f;
    }
    
    static {
        MenuPlayer.items = new ieta[5];
    }
}
