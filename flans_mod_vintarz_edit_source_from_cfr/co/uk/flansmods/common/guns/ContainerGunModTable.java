/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  ieta
 *  ivrb
 *  ivrt
 *  kkuu
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.guns.InventoryGunModTable;
import co.uk.flansmods.common.guns.SlotGun;
import java.util.List;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;

public class ContainerGunModTable
extends ivrt {
    private InventoryGunModTable inventory;
    public rojd playerInv;
    public cuqu world;
    private ieta lastGun;

    public ContainerGunModTable(rojd rojd2, cuqu cuqu2) {
        int n;
        int n2;
        this.playerInv = rojd2;
        this.inventory = new InventoryGunModTable(cuqu2);
        this.world = cuqu2;
        SlotGun slotGun = new SlotGun((ivrb)this.inventory, 0, 80, 110, null);
        this.func_75146_a((kkuu)slotGun);
        this.func_75146_a((kkuu)new SlotGun((ivrb)this.inventory, 1, 54, 110, slotGun));
        this.func_75146_a((kkuu)new SlotGun((ivrb)this.inventory, 2, 80, 84, slotGun));
        this.func_75146_a((kkuu)new SlotGun((ivrb)this.inventory, 3, 106, 110, slotGun));
        this.func_75146_a((kkuu)new SlotGun((ivrb)this.inventory, 4, 80, 136, slotGun));
        for (n = 0; n < 4; ++n) {
            for (n2 = 0; n2 < 2; ++n2) {
                this.func_75146_a((kkuu)new SlotGun((ivrb)this.inventory, 5 + n * 2 + n2, 10 + n2 * 18, 83 + n * 18, slotGun));
            }
        }
        for (n = 0; n < 3; ++n) {
            for (n2 = 0; n2 < 9; ++n2) {
                this.func_75146_a(new kkuu((ivrb)this.playerInv, n2 + n * 9 + 9, 8 + n2 * 18, 176 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new kkuu((ivrb)this.playerInv, n, 8 + n * 18, 234));
        }
    }

    public void func_75134_a(EntityPlayer entityPlayer) {
        if (this.inventory.func_70301_a(0) != null) {
            entityPlayer.func_71021_b(this.inventory.func_70301_a(0));
        }
    }

    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    public ieta func_82846_b(EntityPlayer entityPlayer, int n) {
        ieta ieta2 = null;
        kkuu kkuu2 = (kkuu)this.field_75151_b.get(n);
        if (kkuu2 != null && kkuu2.func_75216_d()) {
            ieta ieta3 = kkuu2.func_75211_c();
            ieta2 = ieta3._l();
            if (n >= 13) {
                return null;
            }
            if (!this.func_75135_a(ieta3, 13, this.field_75151_b.size(), true)) {
                return null;
            }
            if (ieta3._b == 0) {
                kkuu2.func_75215_d(null);
            } else {
                kkuu2.func_75218_e();
            }
            if (ieta3._b == ieta2._b) {
                return null;
            }
            kkuu2.func_82870_a(entityPlayer, ieta3);
        }
        return ieta2;
    }

    public void pressButton(boolean bl, boolean bl2) {
    }
}

