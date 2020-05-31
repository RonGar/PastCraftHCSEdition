// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import hcsmod.client.EntityKosterClient;
import net.minecraft.util.idqh;
import net.minecraft.util.samw;
import net.minecraft.entity.Entity;
import hcsmod.entity.EntityKoster;
import net.minecraft.util.dwbg;
import net.minecraft.entity.player.EntityPlayer;

public class ItemKoster extends jhvs
{
    public ItemKoster(final int n) {
        super(n);
        this.func_77637_a(tekj.field_78028_d);
        this.func_77625_d(1);
    }
    
    public ieta func_77659_a(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if (cuqu.field_72995_K) {
            return ieta;
        }
        final samw a = cuqu.func_82732_R()._a(entityPlayer.field_70165_t, entityPlayer.field_70163_u + entityPlayer.func_70047_e(), entityPlayer.field_70161_v);
        final samw func_70040_Z = entityPlayer.func_70040_Z();
        final idqh func_72831_a = cuqu.func_72831_a(a, cuqu.func_82732_R()._a(entityPlayer.field_70165_t + func_70040_Z._c * 4.0, entityPlayer.field_70163_u + entityPlayer.func_70047_e() + func_70040_Z._d * 4.0, entityPlayer.field_70161_v + func_70040_Z._e * 4.0), false, true);
        if (func_72831_a != null && func_72831_a._e == 1) {
            final EntityKoster entityKoster = new EntityKoster(cuqu, dwbg._c(func_72831_a._f._c) + 0.5, func_72831_a._f._d, dwbg._c(func_72831_a._f._e) + 0.5, entityPlayer.field_70177_z);
            if (!checkPlacement(entityKoster)) {
                return ieta;
            }
            entityKoster.blockX = func_72831_a._b;
            entityKoster.blockY = func_72831_a._c + 1;
            entityKoster.blockZ = func_72831_a._d;
            cuqu.func_72838_d((Entity)entityKoster);
            --ieta._b;
        }
        return ieta;
    }
    
    public static void KosterClient(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        final samw a = cuqu.func_82732_R()._a(entityPlayer.field_70165_t, entityPlayer.field_70163_u + entityPlayer.func_70047_e(), entityPlayer.field_70161_v);
        final samw func_70040_Z = entityPlayer.func_70040_Z();
        final idqh func_72831_a = cuqu.func_72831_a(a, cuqu.func_82732_R()._a(entityPlayer.field_70165_t + func_70040_Z._c * 4.0, entityPlayer.field_70163_u + entityPlayer.func_70047_e() + func_70040_Z._d * 4.0, entityPlayer.field_70161_v + func_70040_Z._e * 4.0), false, true);
        if (func_72831_a != null && func_72831_a._e == 1) {
            final double n = dwbg._c(func_72831_a._f._c) + 0.5;
            final double n2 = dwbg._c(func_72831_a._f._e) + 0.5;
            EntityKosterClient entityKosterClient = null;
            for (final EntityKosterClient next : cuqu.func_72839_b((Entity)entityPlayer, entityPlayer.field_70121_D.func_72314_b(12.0, 6.0, 12.0))) {
                if (next instanceof EntityKosterClient) {
                    entityKosterClient = next;
                    break;
                }
            }
            if (entityKosterClient != null) {
                entityKosterClient.age = 0;
                entityKosterClient.func_70080_a(n, func_72831_a._f._d, n2, entityPlayer.field_70177_z, 0.0f);
                entityKosterClient.placeAllowed = checkPlacement(entityKosterClient);
            }
            else {
                final EntityKosterClient entityKosterClient2 = new EntityKosterClient(cuqu, n, func_72831_a._f._d, n2, entityPlayer.field_70177_z);
                cuqu.func_72838_d((Entity)entityKosterClient2);
                entityKosterClient2.placeAllowed = checkPlacement(entityKosterClient2);
            }
        }
    }
    
    public static boolean checkPlacement(final Entity entity) {
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
        return entity.field_70170_p.func_72839_b(entity, entity.field_70121_D.func_72314_b(0.1, 1.0, 0.1)).isEmpty();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final qlze qlze) {
        super.field_77791_bV = qlze._a("hcsmod:koster");
    }
}
