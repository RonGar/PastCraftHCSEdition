// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.player;

import hcsmod.HCS;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;

public class SlotInventory extends kkuu
{
    final int level;
    final EntityPlayer thePlayer;
    
    public SlotInventory(final EntityPlayer thePlayer, final ivrb ivrb, final int n, final int n2, final int n3, final int level) {
        super(ivrb, n, n2, n3);
        this.thePlayer = thePlayer;
        this.level = level;
    }
    
    public SlotInventory(final kkuu kkuu, final EntityPlayer thePlayer, final int level) {
        super(kkuu.field_75224_c, kkuu.field_75222_d, kkuu.field_75223_e, kkuu.field_75221_f);
        this.thePlayer = thePlayer;
        this.level = level;
    }
    
    public int func_75219_a() {
        return 64;
    }
    
    public boolean func_75214_a(final ieta ieta) {
        return HCS.getBackpackLVL(this.thePlayer, this.thePlayer.field_70170_p.field_72995_K ? Side.CLIENT : Side.SERVER) > this.level;
    }
}
