// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import hcsmod.player.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import hcsmod.HCS;

public class ItemBackpack extends jhvs
{
    public ItemBackpack(final int n) {
        super(n);
        this.func_77625_d(1);
        this.func_77637_a(HCS.modcreativetab);
    }
    
    public ieta func_77659_a(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if (cuqu.field_72995_K) {
            return ieta;
        }
        final ExtendedPlayer server = ExtendedPlayer.server(entityPlayer);
        if (server.inventory.inventoryStacks[3] == null) {
            server.inventory.inventoryStacks[3] = ieta._l();
            --ieta._b;
        }
        return ieta;
    }
    
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(final ieta ieta, final Entity entity, final int n, final String s) {
        switch (n) {
            case 2: {
                return "hcsmod:textures/models/null.png";
            }
            default: {
                return "hcsmod:textures/models/null.png";
            }
        }
    }
    
    public void func_94581_a(final qlze qlze) {
        if (super.field_77779_bT == HCS.min.field_77779_bT) {
            super.field_77791_bV = qlze._a("hcsmod:czech");
        }
        if (super.field_77779_bT == HCS.mid.field_77779_bT) {
            super.field_77791_bV = qlze._a("hcsmod:survival");
        }
        if (super.field_77779_bT == HCS.max.field_77779_bT) {
            super.field_77791_bV = qlze._a("hcsmod:assault");
        }
    }
}
