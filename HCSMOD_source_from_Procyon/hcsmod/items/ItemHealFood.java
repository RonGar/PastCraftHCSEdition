// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import hcsmod.player.ExtendedPlayer;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class ItemHealFood extends uhwz
{
    public ItemHealFood(final int n, final int n2, final float n3, final boolean b) {
        super(n, n2, n3, b);
        this.func_77625_d(4);
        this.func_77848_i();
    }
    
    public void func_77624_a(final ieta ieta, final EntityPlayer entityPlayer, final List list, final boolean b) {
        list.add("\u0412\u043e\u0441\u043f\u043e\u043b\u043d\u044f\u0435\u0442 \u0433\u043e\u043b\u043e\u0434 \u043d\u0430 100%");
        list.add("\u0412\u043e\u0441\u0441\u0442\u0430\u043d\u0430\u0432\u043b\u0438\u0432\u0430\u0435\u0442 6000 \u043a\u0440\u043e\u0432\u0438");
    }
    
    public ieta func_77654_b(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if (cuqu.field_72995_K) {
            return ieta;
        }
        super.func_77654_b(ieta, cuqu, entityPlayer);
        entityPlayer.func_70691_i(10.0f);
        ExtendedPlayer.server(entityPlayer).feed(1, 78000);
        return ieta;
    }
}
