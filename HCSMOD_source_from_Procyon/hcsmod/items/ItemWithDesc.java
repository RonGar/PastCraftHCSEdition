// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import hcsmod.HCS;

public class ItemWithDesc extends jhvs
{
    public ItemWithDesc(final int n) {
        super(n);
        this.func_77627_a(true);
        this.func_77637_a(HCS.modcreativetab);
        this.func_77625_d(4);
    }
    
    public void func_77624_a(final ieta ieta, final EntityPlayer entityPlayer, final List list, final boolean b) {
        if (null != HCS.raincoat && super.field_77779_bT == HCS.raincoat.field_77779_bT) {
            list.add("\u0414\u043e\u0436\u0434\u0435\u0432\u0438\u043a \u043f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u043d\u0435 \u0437\u0430\u043c\u0435\u0440\u0437\u0430\u0442\u044c \u043f\u043e\u0434 \u0434\u043e\u0436\u0434\u0435\u043c");
        }
        if (null != HCS.holster && super.field_77779_bT == HCS.holster.field_77779_bT) {
            list.add("\u041a\u043e\u0431\u0443\u0440\u0430 \u043f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c 3 \u043e\u0440\u0443\u0436\u0438\u044f");
        }
        if (null != HCS.warmclothes && super.field_77779_bT == HCS.warmclothes.field_77779_bT) {
            list.add("\u0422\u0435\u043f\u043b\u0430\u044f \u043e\u0434\u0435\u0436\u0434\u0430 \u043f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u043d\u0435 \u0437\u0430\u043c\u0435\u0440\u0437\u0430\u0442\u044c \u0432 \u0445\u043e\u043b\u043e\u0434\u043d\u0443\u044e \u043f\u043e\u0433\u043e\u0434\u0443");
        }
        if (null != HCS.gunrepair1 && super.field_77779_bT == HCS.gunrepair1.field_77779_bT) {
            list.add("\u041f\u043e\u043b\u043d\u043e\u0441\u0442\u044c\u044e \u0447\u0438\u043d\u0438\u0442 \u043b\u044e\u0431\u043e\u0435 \u043e\u0440\u0443\u0436\u0438\u0435");
            list.add("\u041f\u043e\u043b\u043e\u0436\u0438\u0442\u0435 \u0441\u043b\u043e\u043c\u0430\u043d\u043d\u043e\u0435 \u043e\u0440\u0443\u0436\u0438\u0435 \u0438 \u044d\u0442\u043e\u0442 \u043d\u0430\u0431\u043e\u0440 \u0432 \u0441\u043b\u043e\u0442\u044b \u043a\u0440\u0430\u0444\u0442\u0430");
        }
    }
    
    public int func_77626_a(final ieta ieta) {
        return 32;
    }
    
    public rpnc func_77661_b(final ieta ieta) {
        return rpnc._c;
    }
    
    public void func_94581_a(final qlze qlze) {
        if (null != HCS.raincoat && super.field_77779_bT == HCS.raincoat.field_77779_bT) {
            super.field_77791_bV = qlze._a("hcsmod:raincoat");
        }
        if (null != HCS.holster && super.field_77779_bT == HCS.holster.field_77779_bT) {
            super.field_77791_bV = qlze._a("hcsmod:holster");
        }
        if (null != HCS.warmclothes && super.field_77779_bT == HCS.warmclothes.field_77779_bT) {
            super.field_77791_bV = qlze._a("hcsmod:warmclothes");
        }
        if (null != HCS.gunrepair1 && super.field_77779_bT == HCS.gunrepair1.field_77779_bT) {
            super.field_77791_bV = qlze._a("hcsmod:gunrepair1");
        }
    }
}
