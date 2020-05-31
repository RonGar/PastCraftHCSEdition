// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.player.ExtendedPlayer;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class ItemWaterBottle extends yudj
{
    private int healAmount;
    
    public ItemWaterBottle(final int n, final int healAmount) {
        super(n);
        this.healAmount = healAmount;
        this.func_77627_a(false);
    }
    
    public void func_77624_a(final ieta ieta, final EntityPlayer entityPlayer, final List list, final boolean b) {
        list.add("\u0412\u043e\u0441\u043f\u043e\u043b\u043d\u044f\u0435\u0442 \u0436\u0430\u0436\u0434\u0443 \u043d\u0430 70%");
    }
    
    public ieta func_77654_b(ieta func_77654_b, final cuqu cuqu, final EntityPlayer entityPlayer) {
        func_77654_b = super.func_77654_b(func_77654_b, cuqu, entityPlayer);
        ExtendedPlayer.server(entityPlayer).water(1, 55000);
        return func_77654_b;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77633_a(final int n, final tekj tekj, final List list) {
        list.add(new ieta(n, 1, 0));
    }
}
