// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.player.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;

public class ItemPnv extends jhvs
{
    public ItemPnv(final int n) {
        super(n);
        this.func_77637_a(tekj.field_78037_j);
        this.func_77625_d(1);
    }
    
    public ieta func_77659_a(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        final ExtendedPlayer server = ExtendedPlayer.server(entityPlayer);
        if (server.inventory.inventoryStacks[5] == null) {
            server.inventory.inventoryStacks[5] = new ieta(ieta._d, 1, 0);
            --ieta._b;
        }
        return ieta;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final qlze qlze) {
        super.field_77791_bV = qlze._a("hcsmod:pnv");
    }
}
