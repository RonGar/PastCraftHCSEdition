/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  gowi
 *  hasa
 *  ieta
 *  iwpo
 *  iwpo$eidl
 *  iwpo$eidn
 *  jhvs
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraftforge.event.kjuq
 *  org.lwjgl.opengl.GL11
 *  uyla
 */
package co.uk.flansmods.vintarz;

import co.uk.flansmods.client.FlansModClient;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.guns.AttachmentType;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemGun;
import co.uk.flansmods.vintarz.BulletSpread;
import co.uk.flansmods.vintarz.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraftforge.event.kjuq;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class CrosshairRenderer {
    public static int death_count = 0;
    public static int hit_count = 0;

    @kjuq
    public void onHUDDrawing(iwpo.eidl eidl2) {
        if (eidl2.type == iwpo.eidn.CROSSHAIRS) {
            eidl2.setCanceled(true);
            CrosshairRenderer.renderCrosshairs(eidl2.resolution.func_78326_a(), eidl2.resolution.func_78328_b(), eidl2.partialTicks);
        }
    }

    protected static void renderCrosshairs(int n, int n2, float f) {
        jhvs jhvs2;
        double d = 70.0f + 40.0f * tuor._E()._K.__bE;
        d = d / 2.0 * 3.1415927 / 180.0;
        d = 1.0 / Math.tan(d);
        int n3 = n / 2;
        int n4 = n2 / 2;
        FlansModPlayerData flansModPlayerData = FlansModClient.clientPlayerData;
        double d2 = BulletSpread.prevClientSpread + (flansModPlayerData.bulletSpread - BulletSpread.prevClientSpread) * f;
        d2 *= 0.0044;
        d2 *= d;
        int n5 = (int)(d2 *= (double)n2);
        GL11.glDisable((int)3553);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)775, (int)769);
        boolean bl = Util.isAimingClient && n5 == 0;
        boolean bl2 = false;
        boolean bl3 = false;
        ieta ieta2 = tuor._E()._r.func_71045_bC();
        if (ieta2 != null && (jhvs2 = ieta2._a()) instanceof ItemGun) {
            ItemGun itemGun = (ItemGun)jhvs2;
            GunType gunType = itemGun.type;
            AttachmentType attachmentType = gunType.getScope(ieta2);
            if (attachmentType != null) {
                bl2 = true;
            }
            if ((attachmentType = gunType.getGrip(ieta2)) != null && attachmentType.bipod && FlansModClient.bipod) {
                bl3 = true;
            }
        }
        if (!bl || !bl2 || bl3) {
            int n6 = FlansModClient.bipod ? 2 : 0;
            tuor._E()._H.func_73729_b(n3 - n5 - 4 + n6, n4, 0, 0, 4 - n6, 1);
            tuor._E()._H.func_73729_b(n3 + n5 + 1, n4, 0, 0, 4 - n6, 1);
            if (!bl || !bl2) {
                if (FlansModClient.bipod) {
                    tuor._E()._H.func_73729_b(n3 - n5 - 7 + n6, n4, 0, 0, 2, 1);
                    tuor._E()._H.func_73729_b(n3 + n5 + 4, n4, 0, 0, 2, 1);
                }
                tuor._E()._H.func_73729_b(n3, n4 + n5 + 1, 0, 0, 1, 4);
                if (!bl) {
                    tuor._E()._H.func_73729_b(n3, n4 - n5 - 4, 0, 0, 1, 4);
                }
            }
        }
        if (hit_count > 0 || death_count > 0) {
            tuor._E()._H.func_73729_b(n3, n4, 0, 0, 1, 1);
            tuor._E()._H.func_73729_b(n3 - 1, n4 - 1, 0, 0, 1, 1);
            tuor._E()._H.func_73729_b(n3 + 1, n4 + 1, 0, 0, 1, 1);
            tuor._E()._H.func_73729_b(n3 - 1, n4 + 1, 0, 0, 1, 1);
            tuor._E()._H.func_73729_b(n3 + 1, n4 - 1, 0, 0, 1, 1);
        }
        if (death_count > 0) {
            tuor._E()._H.func_73729_b(n3 - 2, n4 - 2, 0, 0, 1, 1);
            tuor._E()._H.func_73729_b(n3 + 2, n4 + 2, 0, 0, 1, 1);
            tuor._E()._H.func_73729_b(n3 - 2, n4 + 2, 0, 0, 1, 1);
            tuor._E()._H.func_73729_b(n3 + 2, n4 - 2, 0, 0, 1, 1);
        }
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3553);
    }
}

