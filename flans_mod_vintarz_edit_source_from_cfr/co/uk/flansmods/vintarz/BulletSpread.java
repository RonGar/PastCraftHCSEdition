/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  hcsmod.player.ExtendedPlayer
 *  ieta
 *  jhvs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.entity.player.rojd
 */
package co.uk.flansmods.vintarz;

import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemGun;
import co.uk.flansmods.vintarz.Util;
import hcsmod.player.ExtendedPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidl;
import net.minecraft.entity.player.rojd;

public class BulletSpread {
    public static boolean hasScope = false;
    public static float prevClientSpread;

    public static float updateSpread(EntityPlayer entityPlayer, FlansModPlayerData flansModPlayerData, float f, float f2) {
        f /= 1.5f;
        if (ItemGun.slotIsWeapon(entityPlayer.field_71071_by._c, entityPlayer.field_70170_p.field_72995_K ? ExtendedPlayer.client((String)entityPlayer.field_71092_bJ) : ExtendedPlayer.server((EntityPlayer)entityPlayer)) && entityPlayer.func_71045_bC() != null && Util.isFlansWeapon(entityPlayer.func_71045_bC())) {
            boolean bl;
            float f3;
            boolean bl2;
            boolean bl3 = ((ItemGun)entityPlayer.func_71045_bC()._a()).type.numBullets != 1;
            float f4 = f3 = (float)Math.sqrt(ItemGun.getClientSpread(entityPlayer.func_71045_bC()));
            if (bl3) {
                f += f3;
            }
            boolean bl4 = bl = entityPlayer.field_70701_bs != 0.0f || entityPlayer.field_70702_br != 0.0f;
            if (entityPlayer.field_70170_p.field_72995_K) {
                hasScope = Util.hasScope(entityPlayer.func_71045_bC());
            }
            boolean bl5 = Util.isAiming(entityPlayer);
            boolean bl6 = entityPlayer.func_70051_ag();
            boolean bl7 = entityPlayer.func_70093_af();
            boolean bl8 = bl2 = entityPlayer.field_70131_O <= 1.0f;
            if (bl2) {
                f3 *= 0.33333334f;
            } else if (bl7) {
                f3 *= 0.6666667f;
            } else if (bl6) {
                f3 *= 1.5f;
            }
            if (!bl5 || bl6 || ((ItemGun)entityPlayer.func_71045_bC()._a()).type.deployable) {
                f += f3;
            }
            if (bl) {
                f += f3 * 0.5f;
            }
            if (!entityPlayer.field_70122_E && entityPlayer.field_70154_o == null && !entityPlayer.field_71075_bZ._b) {
                f += f4 * 2.0f;
            }
            ++flansModPlayerData.spreadTicks;
            return f += f2;
        }
        flansModPlayerData.spreadTicks = 0;
        return 0.0f;
    }

    public static void tickWeaponSpread(EntityPlayer entityPlayer, FlansModPlayerData flansModPlayerData) {
        flansModPlayerData.weaponSpread = Math.min(flansModPlayerData.weaponSpread, 30.0f);
        if (flansModPlayerData.weaponSpread > 0.0f) {
            flansModPlayerData.weaponSpread /= 3.0f;
        }
        flansModPlayerData.bulletSpread = BulletSpread.updateSpread(entityPlayer, flansModPlayerData, flansModPlayerData.bulletSpread, flansModPlayerData.weaponSpread);
    }
}

