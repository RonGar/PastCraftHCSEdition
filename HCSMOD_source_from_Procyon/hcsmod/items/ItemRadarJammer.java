// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import hcsmod.player.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import hcsmod.HCS;

public class ItemRadarJammer extends jhvs
{
    public ItemRadarJammer(final int n) {
        super(n);
        this.func_77637_a(HCS.modcreativetab);
        this.func_77625_d(1);
        this.func_77656_e(24000);
    }
    
    public ieta func_77659_a(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        final ExtendedPlayer server = ExtendedPlayer.server(entityPlayer);
        if (server.inventory.inventoryStacks[2] == null) {
            server.inventory.inventoryStacks[2] = ieta._l();
            --ieta._b;
        }
        return ieta;
    }
}
