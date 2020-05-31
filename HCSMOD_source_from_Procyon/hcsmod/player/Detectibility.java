// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.player;

import hcsmod.HCS;
import net.minecraft.entity.player.EntityPlayer;

public class Detectibility
{
    public static byte update(final EntityPlayer entityPlayer) {
        int n = 0;
        final boolean b = Math.abs(entityPlayer.field_70159_w) > 0.01 || Math.abs(entityPlayer.field_70179_y) > 0.01 || entityPlayer.field_70181_x < -0.08 || entityPlayer.field_70181_x > 0.0;
        final boolean b2 = entityPlayer.field_70131_O < 1.5f || entityPlayer.func_70093_af();
        if (entityPlayer.field_70131_O > 1.5f) {
            ++n;
        }
        if (b) {
            n = Math.max(n + 1, 2);
        }
        if (!b2 && b) {
            ++n;
        }
        if (entityPlayer.field_70181_x > 0.35 || entityPlayer.field_70181_x < -0.4 || HCS.isReallySprinting(entityPlayer)) {
            n = 4;
        }
        if (entityPlayer.field_70170_p.func_72912_H()._p()) {
            n = Math.min(n, 1);
        }
        return (byte)Math.min(n, 4);
    }
}
