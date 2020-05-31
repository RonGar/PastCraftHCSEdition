// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.entity.EntityPalatka;
import net.minecraft.util.dwbg;
import hcsmod.server.EntityHouseServer;
import hcsmod.entity.EntityHouseCommon;
import java.util.List;
import net.minecraft.util.idqh;
import net.minecraft.util.samw;
import hcsmod.client.PlacingPalatkaHouse;
import net.minecraft.entity.Entity;
import hcsmod.server.HcsServer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.roij;
import net.minecraft.util.hrmy;

public class ItemPalatka extends jhvs
{
    public static final hrmy wrongPlace;
    protected roij itemIconH;
    
    public ItemPalatka(final int n) {
        super(n);
        this.func_77637_a(tekj.field_78028_d);
        this.func_77625_d(1);
    }
    
    public ieta func_77659_a(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if (!cuqu.field_72995_K) {
            HcsServer.palatkaRightClick(entityPlayer, cuqu, ieta);
        }
        return ieta;
    }
    
    public static void palatkaClient(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        final samw a = cuqu.func_82732_R()._a(entityPlayer.field_70165_t, entityPlayer.field_70163_u + entityPlayer.func_70047_e(), entityPlayer.field_70161_v);
        final samw func_70040_Z = entityPlayer.func_70040_Z();
        final idqh func_72831_a = cuqu.func_72831_a(a, cuqu.func_82732_R()._a(entityPlayer.field_70165_t + func_70040_Z._c * 6.0, entityPlayer.field_70163_u + entityPlayer.func_70047_e() + func_70040_Z._d * 6.0, entityPlayer.field_70161_v + func_70040_Z._e * 6.0), false, true);
        if (func_72831_a != null && func_72831_a._e == 1) {
            PlacingPalatkaHouse placingPalatkaHouse = null;
            final List func_72839_b = cuqu.func_72839_b((Entity)entityPlayer, entityPlayer.field_70121_D.func_72314_b(12.0, 6.0, 12.0));
            for (int i = 0; i < func_72839_b.size(); ++i) {
                if (func_72839_b.get(i) instanceof PlacingPalatkaHouse) {
                    placingPalatkaHouse = func_72839_b.get(i);
                    break;
                }
            }
            if (placingPalatkaHouse != null) {
                placingPalatkaHouse.age = 0;
                placingPalatkaHouse.func_70080_a(func_72831_a._f._c, func_72831_a._f._d, func_72831_a._f._e, (ieta._j() > 0) ? ((int)((entityPlayer.field_70177_z - 45.0f) / 90.0f) * 90.0f + 45.0f) : entityPlayer.field_70177_z, 0.0f);
                placingPalatkaHouse.house = (ieta._j() > 0);
                placingPalatkaHouse.placeAllowed = checkPlacement(placingPalatkaHouse, entityPlayer);
            }
            else {
                final PlacingPalatkaHouse placingPalatkaHouse2 = new PlacingPalatkaHouse(cuqu, func_72831_a._f._c, func_72831_a._f._d, func_72831_a._f._e, (ieta._j() > 0) ? ((int)((entityPlayer.field_70177_z - 45.0f) / 90.0f) * 90.0f + 45.0f) : entityPlayer.field_70177_z, ieta._j() > 0);
                cuqu.func_72838_d((Entity)placingPalatkaHouse2);
                placingPalatkaHouse2.placeAllowed = checkPlacement(placingPalatkaHouse2, entityPlayer);
            }
        }
    }
    
    public static boolean checkPlacement(final Entity entity, final EntityPlayer entityPlayer) {
        if (entity instanceof EntityHouseCommon && EntityHouseServer.wrongPlace(entity.field_70165_t, entity.field_70161_v)) {
            entityPlayer.func_70006_a(ItemPalatka.wrongPlace);
            return false;
        }
        final int c = dwbg._c(entity.field_70121_D.field_72336_d);
        final int c2 = dwbg._c(entity.field_70121_D.field_72334_f);
        for (int i = dwbg._c(entity.field_70121_D.field_72340_a); i <= c; ++i) {
            for (int j = dwbg._c(entity.field_70121_D.field_72339_c); j <= c2; ++j) {
                final int c3 = dwbg._c(entity.field_70163_u);
                if (!entity.field_70170_p.func_72799_c(i, c3, j) || !entity.field_70170_p.func_72799_c(i, c3 + 1, j) || !entity.field_70170_p.func_72809_s(i, c3 - 1, j)) {
                    return false;
                }
            }
        }
        return entity.field_70170_p.func_94576_a(entity, entity.field_70121_D.func_72314_b(1.5, 0.0, 1.5), (mquq)new mquq() {
            public boolean func_82704_a(final Entity entity) {
                return entity instanceof EntityHouseCommon || entity instanceof EntityPalatka;
            }
        }).isEmpty();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final qlze qlze) {
        super.field_77791_bV = qlze._a("hcsmod:palatka");
        this.itemIconH = qlze._a("hcsmod:house");
    }
    
    public String func_77667_c(final ieta ieta) {
        return this.func_77658_a() + ieta._j();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77633_a(final int n, final tekj tekj, final List list) {
        list.add(new ieta(n, 1, 0));
        list.add(new ieta(n, 1, 1));
        list.add(new ieta(n, 1, 2));
        list.add(new ieta(n, 1, 3));
        list.add(new ieta(n, 1, 4));
        list.add(new ieta(n, 1, 5));
    }
    
    @SideOnly(Side.CLIENT)
    public roij func_77617_a(final int n) {
        if (n > 0) {
            return this.itemIconH;
        }
        return this.field_77791_bV;
    }
    
    static {
        wrongPlace = hrmy._d("§c\u0422\u0443\u0442 \u043d\u0435\u043b\u044c\u0437\u044f \u0441\u0442\u0430\u0432\u0438\u0442\u044c \u0434\u043e\u043c!");
    }
}
