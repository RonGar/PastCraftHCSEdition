// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.player;

import net.minecraft.entity.player.EntityPlayer;

public class InventoryExtended implements ivrb
{
    public ieta[] inventoryStacks;
    
    public InventoryExtended() {
        this.inventoryStacks = new ieta[6];
    }
    
    public int func_70302_i_() {
        return this.inventoryStacks.length;
    }
    
    public ieta func_70301_a(final int n) {
        return this.inventoryStacks[n];
    }
    
    public ieta func_70298_a(final int n, final int n2) {
        if (this.inventoryStacks[n] == null) {
            return null;
        }
        if (this.inventoryStacks[n]._b <= n2) {
            final ieta ieta = this.inventoryStacks[n];
            this.inventoryStacks[n] = null;
            return ieta;
        }
        final ieta a = this.inventoryStacks[n]._a(n2);
        if (this.inventoryStacks[n]._b == 0) {
            this.inventoryStacks[n] = null;
        }
        return a;
    }
    
    public ieta func_70304_b(final int n) {
        return null;
    }
    
    public void func_70299_a(final int n, final ieta ieta) {
        this.inventoryStacks[n] = ieta;
        if (ieta != null && ieta._b > this.func_70297_j_()) {
            ieta._b = this.func_70297_j_();
        }
    }
    
    public String func_70303_b() {
        return "HCS Player Inv";
    }
    
    public boolean func_94042_c() {
        return false;
    }
    
    public int func_70297_j_() {
        return 64;
    }
    
    public void func_70296_d() {
    }
    
    public boolean func_70300_a(final EntityPlayer entityPlayer) {
        return true;
    }
    
    public void func_70295_k_() {
    }
    
    public void func_70305_f() {
    }
    
    public boolean func_94041_b(final int n, final ieta ieta) {
        return false;
    }
    
    public void readFromNBT(final tevp tevp) {
        this.inventoryStacks = new ieta[6];
        for (int i = 0; i < tevp._d(); ++i) {
            final hsus hsus = (hsus)tevp._b(i);
            final int n = hsus._d("Slot") & 0xFF;
            final ieta a = ieta._a(hsus);
            if (a != null) {
                this.inventoryStacks[n] = a;
            }
        }
    }
    
    public tevp writeToNBT(final tevp tevp) {
        for (int i = 0; i < this.inventoryStacks.length; ++i) {
            if (this.inventoryStacks[i] != null) {
                final hsus hsus = new hsus();
                hsus._a("Slot", (byte)i);
                this.inventoryStacks[i]._b(hsus);
                tevp._a((zxiv)hsus);
            }
        }
        return tevp;
    }
    
    public void copyInventory(final InventoryExtended inventoryExtended) {
        for (int i = 0; i < this.inventoryStacks.length; ++i) {
            this.inventoryStacks[i] = ieta._c(inventoryExtended.inventoryStacks[i]);
        }
    }
    
    public void dropAllItems(final EntityPlayer entityPlayer) {
        for (final ieta ieta : this.inventoryStacks) {
            if (ieta != null) {
                entityPlayer.func_71019_a(ieta._l(), true);
            }
        }
        this.inventoryStacks = new ieta[6];
    }
    
    public void clearInventory() {
        for (int i = 0; i < this.inventoryStacks.length; ++i) {
            this.inventoryStacks[i] = null;
        }
    }
}
