/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  ieta
 *  jhvs
 *  pjdo
 *  qmoh
 */
package co.uk.flansmods.vintarz;

import co.uk.flansmods.common.guns.ItemBullet;

public class BulletCombiner
implements qmoh {
    public static final BulletCombiner instance = new BulletCombiner();

    private BulletCombiner() {
    }

    public boolean func_77569_a(pjdo pjdo2, cuqu cuqu2) {
        return this.func_77572_b(pjdo2) != null;
    }

    public ieta func_77572_b(pjdo pjdo2) {
        int n = 0;
        ieta ieta2 = null;
        ieta ieta3 = null;
        for (int i = 0; i < pjdo2.func_70302_i_(); ++i) {
            ieta ieta4 = pjdo2.func_70301_a(i);
            if (ieta4 == null) continue;
            if (n == 0) {
                ieta2 = ieta4;
            }
            if (n == 1) {
                ieta3 = ieta4;
            }
            ++n;
        }
        if (n == 2 && ieta2._a() == ieta3._a() && ieta2._b == 1 && ieta3._b == 1 && ieta2._a() instanceof ItemBullet) {
            int n2 = ieta2._k() - ieta2._j();
            n2 += ieta3._k() - ieta3._j();
            n2 = Math.min(n2, ieta2._k());
            return new ieta(ieta2._a(), 1, ieta2._k() - n2);
        }
        return null;
    }

    public int func_77570_a() {
        return 0;
    }

    public ieta func_77571_b() {
        return null;
    }
}

