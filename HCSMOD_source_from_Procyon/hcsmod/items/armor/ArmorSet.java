// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items.armor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.pico;
import net.minecraft.entity.EntityLivingBase;
import hcsmod.client.render.IVladruArmorModel;
import net.minecraftforge.common.owbd;

public class ArmorSet extends ItemHCSArmor implements owbd
{
    public String setName;
    
    public ArmorSet(final IVladruArmorModel vladruArmorModel, final String s, final int n, final jhvo jhvo, final int n2, final int n3, final String setName) {
        super(vladruArmorModel, s, n, jhvo, n2, n3);
        this.setName = setName;
    }
    
    public owbd.uxsf getProperties(final EntityLivingBase entityLivingBase, final ieta ieta, final pico pico, final double n, final int n2) {
        return new owbd.uxsf(0, this.field_77879_b / 25.0, this.func_77612_l() + 1 - ieta._j());
    }
    
    public int getArmorDisplay(final EntityPlayer entityPlayer, final ieta ieta, final int n) {
        if (n != 1) {
            return this.field_77879_b;
        }
        final ieta[] b = entityPlayer.field_71071_by._b;
        final int length = b.length;
        int i = 0;
        while (i < length) {
            final ieta ieta2 = b[i];
            if (ieta2 != null) {
                final jhvs a = ieta2._a();
                if (a instanceof ArmorSet && ((ArmorSet)a).setName.equals(this.setName)) {
                    ++i;
                    continue;
                }
            }
            return this.field_77879_b;
        }
        return this.field_77879_b + 1;
    }
    
    public void damageArmor(final EntityLivingBase entityLivingBase, final ieta ieta, final pico pico, final int n, final int n2) {
        ieta._a(n, entityLivingBase);
    }
}
