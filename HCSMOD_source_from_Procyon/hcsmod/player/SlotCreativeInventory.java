// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.player;

import net.minecraft.util.roij;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
class SlotCreativeInventory extends kkuu
{
    private final kkuu theSlot;
    final GuiInventoryCreative theCreativeInventory;
    
    public SlotCreativeInventory(final GuiInventoryCreative theCreativeInventory, final kkuu theSlot, final int n) {
        super(theSlot.field_75224_c, n, 0, 0);
        this.theCreativeInventory = theCreativeInventory;
        this.theSlot = theSlot;
    }
    
    public void func_82870_a(final EntityPlayer entityPlayer, final ieta ieta) {
        this.theSlot.func_82870_a(entityPlayer, ieta);
    }
    
    public boolean func_75214_a(final ieta ieta) {
        return this.theSlot.func_75214_a(ieta);
    }
    
    public ieta func_75211_c() {
        return this.theSlot.func_75211_c();
    }
    
    public boolean func_75216_d() {
        return this.theSlot.func_75216_d();
    }
    
    public void func_75215_d(final ieta ieta) {
        this.theSlot.func_75215_d(ieta);
    }
    
    public void func_75218_e() {
        this.theSlot.func_75218_e();
    }
    
    public int func_75219_a() {
        return this.theSlot.func_75219_a();
    }
    
    public roij func_75212_b() {
        return this.theSlot.func_75212_b();
    }
    
    public ieta func_75209_a(final int n) {
        return this.theSlot.func_75209_a(n);
    }
    
    public boolean func_75217_a(final ivrb ivrb, final int n) {
        return this.theSlot.func_75217_a(ivrb, n);
    }
    
    static kkuu func_75240_a(final SlotCreativeInventory slotCreativeInventory) {
        return slotCreativeInventory.theSlot;
    }
}
