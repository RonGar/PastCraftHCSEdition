// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.player;

import net.minecraft.entity.player.EntityPlayer;

public class ContainerExtended extends wnya
{
    public ContainerExtended(final EntityPlayer entityPlayer, final InventoryExtended inventoryExtended) {
        super(entityPlayer.field_71071_by, !entityPlayer.field_70170_p.field_72995_K, entityPlayer);
        int field_75222_d = 0;
        final kkuu kkuu2;
        final kkuu kkuu = kkuu2 = this.field_75151_b.get(0);
        kkuu2.field_75223_e += 9;
        final kkuu kkuu3 = kkuu;
        kkuu3.field_75221_f -= 10;
        ++field_75222_d;
        for (int i = 0; i < 4; ++i) {
            final kkuu kkuu5;
            final kkuu kkuu4 = kkuu5 = this.field_75151_b.get(field_75222_d);
            kkuu5.field_75223_e += 28;
            final kkuu kkuu6 = kkuu4;
            kkuu6.field_75221_f -= 18;
            ++field_75222_d;
        }
        field_75222_d += 4;
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                final SlotInventory slotInventory = new SlotInventory(entityPlayer, (ivrb)entityPlayer.field_71071_by, k + (j + 1) * 9, 8 + k * 18, 84 + j * 18, j);
                slotInventory.field_75222_d = field_75222_d;
                this.field_75151_b.set(field_75222_d, slotInventory);
                ++field_75222_d;
            }
        }
        for (int l = 0; l < 4; ++l) {
            this.func_75146_a((kkuu)new SlotArmorCustom(entityPlayer, (ivrb)inventoryExtended, inventoryExtended.func_70302_i_() - 1 - l, 26, 8 + l * 18, l));
        }
        this.func_75146_a((kkuu)new SlotArmorCustom(entityPlayer, (ivrb)inventoryExtended, inventoryExtended.func_70302_i_() - 1 - 4, 98, 8, 4));
        this.func_75146_a((kkuu)new SlotArmorCustom(entityPlayer, (ivrb)inventoryExtended, inventoryExtended.func_70302_i_() - 1 - 5, 98, 26, 5));
    }
}
