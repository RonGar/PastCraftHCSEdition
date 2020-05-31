/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ccfp
 *  cpw.mods.fml.relauncher.FMLLaunchHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ctpu
 *  cuqu
 *  hrvk
 *  ieta
 *  jhvs
 *  kjsv
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.particle.EntityDiggingFX
 *  net.minecraft.client.particle.EntityFX
 *  net.minecraft.client.particle.uxsf
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.dfat
 *  net.minecraft.util.dfau
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  vintarz.core.VCore
 */
package co.uk.flansmods.vintarz;

import co.uk.flansmods.client.FlansModClient;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.guns.AttachmentType;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemGun;
import co.uk.flansmods.vintarz.EntityBulletHoleFX;
import co.uk.flansmods.vintarz.EntityTraceFX;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.uxsf;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dfat;
import net.minecraft.util.dfau;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import vintarz.core.VCore;

public class Util {
    public static final String[][] material_sounds = new String[5][];
    public static final Random rng = new Random();
    public static boolean isAimingClient;
    public static final Map<ccfp, Integer> materials;
    public static boolean areClientBulletsBeingUpdated;
    public static Random rand;

    @SideOnly(value=Side.CLIENT)
    public static void clientBulletUpdate(EntityBullet entityBullet) {
        if (!areClientBulletsBeingUpdated && entityBullet.owner == tuor._E()._r && !entityBullet.type.smokeTrail) {
            return;
        }
        FlansModClient.clientTracers.add(new EntityTraceFX(areClientBulletsBeingUpdated && entityBullet.field_70173_aa == 0, entityBullet.field_70169_q, entityBullet.field_70167_r, entityBullet.field_70166_s, entityBullet.field_70165_t, entityBullet.field_70163_u, entityBullet.field_70161_v));
    }

    @SideOnly(value=Side.CLIENT)
    public static void clientBulletEffects(idqh idqh2, EntityBullet entityBullet, boolean bl) {
        block17 : {
            double d;
            double d2;
            double d3;
            double d4;
            double d5;
            double d6;
            block16 : {
                if (areClientBulletsBeingUpdated) {
                    return;
                }
                cuqu cuqu2 = entityBullet.field_70170_p;
                d2 = entityBullet.field_70165_t - entityBullet.field_70169_q;
                d = entityBullet.field_70163_u - entityBullet.field_70167_r;
                d5 = entityBullet.field_70161_v - entityBullet.field_70166_s;
                double d7 = Math.sqrt(d2 * d2 + d * d + d5 * d5);
                d2 /= d7;
                d /= d7;
                d5 /= d7;
                if (bl && entityBullet.owner != tuor._E()._r) {
                    FlansModClient.clientTracers.add(new EntityTraceFX(false, entityBullet.field_70169_q, entityBullet.field_70167_r, entityBullet.field_70166_s, entityBullet.field_70165_t, entityBullet.field_70163_u, entityBullet.field_70161_v));
                }
                if (idqh2 == null) {
                    return;
                }
                d4 = entityBullet.field_70165_t;
                d3 = entityBullet.field_70163_u;
                d6 = entityBullet.field_70161_v;
                if (idqh2._a != dfat._a) break block16;
                int n = idqh2._b;
                int n2 = idqh2._c;
                int n3 = idqh2._d;
                int n4 = tuor._E()._p.func_72798_a(n, n2, n3);
                Integer n5 = materials.get((Object)kjsv.field_71973_m[n4].field_72018_cp);
                if (n5 != null) {
                    String[] arrstring;
                    dfau dfau2 = dfau.values()[idqh2._e];
                    if (Util.displayParticles()) {
                        double d8 = (rand.nextDouble() * 0.5 + 0.5) * 2.5E-4;
                        double d9 = Math.abs(d4 - (double)dwbg._c((double)(d4 > 0.0 ? d4 + 0.5 : d4 - 0.5)));
                        double d10 = Math.abs(d3 - (double)dwbg._c((double)(d3 > 0.0 ? d3 + 0.5 : d3 - 0.5)));
                        double d11 = Math.abs(d6 - (double)dwbg._c((double)(d6 > 0.0 ? d6 + 0.5 : d6 - 0.5)));
                        if (d9 != 0.0) {
                            d8 = Math.min(d9 * 0.005, d8);
                        }
                        if (d10 != 0.0) {
                            d8 = Math.min(d10 * 0.005, d8);
                        }
                        if (d11 != 0.0) {
                            d8 = Math.min(d11 * 0.005, d8);
                        }
                        if (d8 < 1.25E-4) {
                            d8 = 0.0;
                        }
                        if (d8 > 0.0) {
                            d9 = d8 * 20.0;
                            for (EntityBulletHoleFX entityBulletHoleFX : EntityBulletHoleFX.bulletHoles) {
                                if (!(entityBulletHoleFX.func_70092_e(d4, d3, d6) < d9)) continue;
                                d8 = 0.0;
                                break;
                            }
                            if (d8 > 0.0) {
                                tuor._E()._u._a((EntityFX)new EntityBulletHoleFX((cuqu)tuor._E()._p, d4, d3, d6, n, n2, n3, n4, dfau2, n5, (float)d8));
                            }
                        }
                    }
                    if ((arrstring = material_sounds[n5]).length > 0) {
                        String string = arrstring[rng.nextInt(arrstring.length)];
                        tuor._E()._L._a(string, (float)d4, (float)d3, (float)d6, rng.nextFloat() * 0.4f + 1.8f, rng.nextFloat() * 0.4f + 0.8f);
                    }
                }
                if (!bl || !Util.displayParticles()) break block17;
                for (int i = 0; i < 1; ++i) {
                    int n6 = cuqu2.func_72798_a(n, n2, n3);
                    int n7 = cuqu2.func_72805_g(n, n2, n3);
                    EntityDiggingFX entityDiggingFX = new EntityDiggingFX((cuqu)tuor._E()._p, d4, d3, d6, VCore.rnd.nextDouble() * 0.01 - d2, VCore.rnd.nextDouble() * 0.01 - d, VCore.rnd.nextDouble() * 0.01 - d5, kjsv.field_71973_m[n6], n7).func_90019_g(n3);
                    entityDiggingFX.field_70155_l = 256.0;
                    tuor._E()._u._a((EntityFX)entityDiggingFX);
                }
                break block17;
            }
            if (idqh2._a == dfat._b && idqh2._g instanceof EntityLivingBase && Util.displayParticles()) {
                for (int i = 0; i < 3; ++i) {
                    EntityDiggingFX entityDiggingFX = new EntityDiggingFX((cuqu)tuor._E()._p, d4, d3, d6, VCore.rnd.nextDouble() * 0.01 - d2, VCore.rnd.nextDouble() * 0.01 - d, VCore.rnd.nextDouble() * 0.01 - d5, kjsv.field_71973_m[35], 14).func_90019_g(14);
                    entityDiggingFX.field_70155_l = 256.0;
                    tuor._E()._u._a((EntityFX)entityDiggingFX);
                }
            }
        }
    }

    public static boolean isFlansWeapon(ieta ieta2) {
        return ieta2 != null && ieta2._a() instanceof ItemGun;
    }

    public static boolean hasScope(ieta ieta2) {
        if (!Util.isFlansWeapon(ieta2)) {
            return false;
        }
        return ((ItemGun)ieta2._a()).type.getScope(ieta2) != null;
    }

    public static boolean isAiming(EntityPlayer entityPlayer) {
        return Util.isFlansWeapon(entityPlayer.func_71045_bC()) && (FMLLaunchHandler.side().equals((Object)Side.CLIENT) ? isAimingClient : FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayer).isAiming);
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean displayParticles() {
        return tuor._S > 60;
    }

    static {
        materials = new HashMap<ccfp, Integer>();
        areClientBulletsBeingUpdated = false;
        rand = new Random();
        if (FMLLaunchHandler.side() != Side.SERVER) {
            int n;
            materials.put(ccfp._b, 1);
            materials.put(ccfp._c, 1);
            materials.put(ccfp._m, 0);
            materials.put(ccfp._p, 1);
            materials.put(ccfp._A, 0);
            materials.put(ccfp._d, 3);
            materials.put(ccfp._n, 1);
            materials.put(ccfp._r, 0);
            materials.put(ccfp._u, 2);
            materials.put(ccfp._e, 0);
            materials.put(ccfp._f, 2);
            materials.put(ccfp._y, 0);
            materials.put(ccfp._g, 2);
            materials.put(ccfp._v, 0);
            materials.put(ccfp._x, 0);
            materials.put(ccfp._z, 3);
            materials.put(ccfp._B, 1);
            materials.put(ccfp._E, 1);
            materials.put(ccfp._G, 2);
            materials.put(ccfp._s, 4);
            materials.put(ccfp._t, 2);
            materials.put(ccfp._w, 4);
            rng.setSeed(System.currentTimeMillis());
            List[] arrlist = new List[material_sounds.length];
            for (int i = 0; i < arrlist.length; ++i) {
                arrlist[i] = new ArrayList();
            }
            InputStream inputStream = Util.class.getResourceAsStream("/assets/flansmod/sound/bullethit.txt");
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            for (n = 0; n < material_sounds.length; ++n) {
                int n2 = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i <= n2; ++i) {
                    arrlist[n].add("flansmod:" + n + "_" + i + "_bullethit");
                }
            }
            for (n = 0; n < arrlist.length; ++n) {
                Util.material_sounds[n] = arrlist[n].toArray(new String[arrlist[n].size()]);
            }
        }
    }
}

