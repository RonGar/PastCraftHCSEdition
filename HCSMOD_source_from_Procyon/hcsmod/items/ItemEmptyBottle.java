// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import net.minecraft.util.idqh;
import net.minecraft.util.dfat;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.roij;

public class ItemEmptyBottle extends jhxl
{
    public ItemEmptyBottle(final int n) {
        super(n - 256);
    }
    
    @SideOnly(Side.CLIENT)
    public roij func_77617_a(final int n) {
        return jhvs.field_77726_bs.func_77617_a(0);
    }
    
    public void func_77624_a(final ieta ieta, final EntityPlayer entityPlayer, final List list, final boolean b) {
        list.add("1. \u041d\u0430\u0432\u0435\u0434\u0438\u0442\u0435\u0441\u044c \u043d\u0430 \u043a\u043e\u043b\u043e\u043d\u043a\u0443 \u0438\u043b\u0438 \u0432\u043e\u0434\u0443");
        list.add("2. \u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u041f\u041a\u041c, \u0447\u0442\u043e\u0431\u044b \u043d\u0430\u043f\u043e\u043b\u043d\u0438\u0442\u044c");
    }
    
    public ieta func_77659_a(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if (cuqu.field_72995_K) {
            return ieta;
        }
        final idqh func_77621_a = this.func_77621_a(cuqu, entityPlayer, true);
        if (func_77621_a == null) {
            return ieta;
        }
        if (func_77621_a._a == dfat._a && cuqu.func_72803_f(func_77621_a._b, func_77621_a._c, func_77621_a._d) == ccfp._h) {
            --ieta._b;
            if (ieta._b <= 0) {
                return new ieta((jhvs)jhvs.field_77726_bs);
            }
            if (!entityPlayer.field_71071_by._c(new ieta((jhvs)jhvs.field_77726_bs))) {
                entityPlayer.func_71021_b(new ieta(jhvs.field_77726_bs.field_77779_bT, 1, 0));
            }
        }
        return ieta;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final qlze qlze) {
    }
}
