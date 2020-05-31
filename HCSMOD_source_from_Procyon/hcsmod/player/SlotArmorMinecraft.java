// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.player;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.roij;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class SlotArmorMinecraft extends kkuu
{
    final int armorType;
    final EntityPlayer thePlayer;
    
    public SlotArmorMinecraft(final EntityPlayer thePlayer, final ivrb ivrb, final int n, final int n2, final int n3, final int armorType) {
        super(ivrb, n, n2, n3);
        this.thePlayer = thePlayer;
        this.armorType = armorType;
    }
    
    public int func_75219_a() {
        return 1;
    }
    
    public boolean func_75214_a(final ieta ieta) {
        final jhvs jhvs = (ieta == null) ? null : ieta._a();
        return jhvs != null && jhvs.isValidArmor(ieta, this.armorType, (Entity)this.thePlayer);
    }
    
    @SideOnly(Side.CLIENT)
    public roij func_75212_b() {
        return qmjs.func_94602_b(this.armorType);
    }
}
