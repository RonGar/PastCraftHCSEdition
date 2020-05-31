// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import hcsmod.player.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;

public class ItemCustomGoldApple extends kkyv
{
    public ItemCustomGoldApple(final int n, final int n2, final float n3, final boolean b) {
        super(n, n2, n3, b);
        this.func_77625_d(1);
    }
    
    public ieta func_77659_a(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if (cuqu.field_72995_K) {
            return ieta;
        }
        ieta._b = 0;
        ExtendedPlayer.server(entityPlayer).startHeal(1.0f);
        return ieta;
    }
}
