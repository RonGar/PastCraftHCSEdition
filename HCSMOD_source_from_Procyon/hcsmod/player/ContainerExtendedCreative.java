// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.player;

import net.minecraft.entity.player.rojd;
import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import java.util.List;

public class ContainerExtendedCreative extends ivrt
{
    public List itemList;
    
    public ContainerExtendedCreative(final EntityPlayer entityPlayer, final InventoryExtended inventoryExtended) {
        this.itemList = new ArrayList();
        final rojd field_71071_by = entityPlayer.field_71071_by;
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.func_75146_a(new kkuu((ivrb)GuiInventoryCreative.getInventory(), i * 9 + j, 9 + j * 18, 18 + i * 18));
            }
        }
        for (int k = 0; k < 9; ++k) {
            this.func_75146_a(new kkuu((ivrb)field_71071_by, k, 9 + k * 18, 112));
        }
        this.scrollTo(0.0f);
    }
    
    public boolean func_75145_c(final EntityPlayer entityPlayer) {
        return true;
    }
    
    public void scrollTo(final float n) {
        int n2 = (int)(n * (this.itemList.size() / 9 - 5 + 1) + 0.5);
        if (n2 < 0) {
            n2 = 0;
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 9; ++j) {
                final int n3 = j + (i + n2) * 9;
                if (n3 >= 0 && n3 < this.itemList.size()) {
                    GuiInventoryCreative.getInventory().func_70299_a(j + i * 9, (ieta)this.itemList.get(n3));
                }
                else {
                    GuiInventoryCreative.getInventory().func_70299_a(j + i * 9, (ieta)null);
                }
            }
        }
    }
    
    public boolean hasMoreThan1PageOfItemsInList() {
        return this.itemList.size() > 45;
    }
    
    protected void func_75133_b(final int n, final int n2, final boolean b, final EntityPlayer entityPlayer) {
    }
    
    public ieta func_82846_b(final EntityPlayer entityPlayer, final int n) {
        if (n >= this.field_75151_b.size() - 9 && n < this.field_75151_b.size()) {
            final kkuu kkuu = this.field_75151_b.get(n);
            if (kkuu != null && kkuu.func_75216_d()) {
                kkuu.func_75215_d((ieta)null);
            }
        }
        return null;
    }
    
    public boolean func_94530_a(final ieta ieta, final kkuu kkuu) {
        return kkuu.field_75221_f > 90;
    }
    
    public boolean func_94531_b(final kkuu kkuu) {
        return kkuu.field_75224_c instanceof rojd || (kkuu.field_75221_f > 90 && kkuu.field_75223_e <= 162);
    }
}
