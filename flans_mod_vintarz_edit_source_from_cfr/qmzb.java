/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  bain
 *  ccfp
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqm
 *  cuqu
 *  cuqv
 *  ejxc
 *  hcno
 *  hcno$eidn
 *  ifcm
 *  ifqy
 *  ifqy$eidn
 *  ifqy$uxsf
 *  ivyf
 *  iwft
 *  kjsv
 *  loks
 *  lolm
 *  mquq
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.rojd
 *  net.minecraftforge.common.bpzx
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.eidl
 *  ogpr
 *  qmzw
 *  yupu
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.dwbg;
import net.minecraft.util.rojd;
import net.minecraftforge.common.bpzx;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.eidl;

public class qmzb {
    public static boolean _a;
    public ejxc[] _b = new ejxc[16];
    public byte[] _c = new byte[256];
    public int[] _d = new int[256];
    public boolean[] _e = new boolean[256];
    public boolean _f;
    public cuqu _g;
    public int[] _h;
    public final int _i;
    public final int _j;
    public boolean _k;
    public Map _l = new HashMap();
    public List[] _m = new List[16];
    public boolean _n;
    public boolean _o;
    public boolean _p;
    public long _q;
    public int _r;
    public long _s;
    public int _t = 4096;

    public qmzb(cuqu cuqu2, int n, int n2) {
        this._g = cuqu2;
        this._i = n;
        this._j = n2;
        this._h = new int[256];
        for (int i = 0; i < this._m.length; ++i) {
            this._m[i] = new ArrayList();
        }
        Arrays.fill(this._d, -999);
        Arrays.fill(this._c, (byte)-1);
    }

    public qmzb(cuqu cuqu2, byte[] arrby, int n, int n2) {
        this(cuqu2, n, n2);
        int n3 = arrby.length / 256;
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < n3; ++k) {
                    int n4 = arrby[i << 11 | j << 7 | k] & 255;
                    if (n4 == 0) continue;
                    int n5 = k >> 4;
                    if (this._b[n5] == null) {
                        this._b[n5] = new ejxc(n5 << 4, !cuqu2.field_73011_w._g);
                    }
                    this._b[n5]._a(i, k & 15, j, n4);
                }
            }
        }
    }

    public boolean _a(int n, int n2) {
        return n == this._i && n2 == this._j;
    }

    public int _b(int n, int n2) {
        return this._h[n2 << 4 | n];
    }

    public int _a() {
        for (int i = this._b.length - 1; i >= 0; --i) {
            if (this._b[i] == null) continue;
            return this._b[i]._c();
        }
        return 0;
    }

    public ejxc[] _b() {
        return this._b;
    }

    @SideOnly(value=Side.CLIENT)
    public void _c() {
        int n = this._a();
        for (int i = 0; i < 16; ++i) {
            block1 : for (int j = 0; j < 16; ++j) {
                this._d[i + (j << 4)] = -999;
                for (int k = n + 16 - 1; k > 0; --k) {
                    if (this._c(i, k - 1, j) == 0) {
                        continue;
                    }
                    this._h[j << 4 | i] = k;
                    continue block1;
                }
            }
        }
        this._o = true;
    }

    public void _d() {
        int n;
        int n2;
        int n3 = this._a();
        this._r = Integer.MAX_VALUE;
        for (n2 = 0; n2 < 16; ++n2) {
            for (n = 0; n < 16; ++n) {
                int n4;
                this._d[n2 + (n << 4)] = -999;
                for (n4 = n3 + 16 - 1; n4 > 0; --n4) {
                    if (this._c(n2, n4 - 1, n) == 0) {
                        continue;
                    }
                    this._h[n << 4 | n2] = n4;
                    if (n4 >= this._r) break;
                    this._r = n4;
                    break;
                }
                if (this._g.field_73011_w._g) continue;
                n4 = 15;
                int n5 = n3 + 16 - 1;
                do {
                    ejxc ejxc2;
                    if ((n4 -= this._c(n2, n5, n)) <= 0 || (ejxc2 = this._b[n5 >> 4]) == null) continue;
                    ejxc2._c(n2, n5 & 15, n, n4);
                    this._g.func_72902_n((this._i << 4) + n2, n5, (this._j << 4) + n);
                } while (--n5 > 0 && n4 > 0);
            }
        }
        this._o = true;
        for (n2 = 0; n2 < 16; ++n2) {
            for (n = 0; n < 16; ++n) {
                this._c(n2, n);
            }
        }
    }

    public void _c(int n, int n2) {
        this._e[n + n2 * 16] = true;
        this._k = true;
    }

    public void _e() {
        this._g.field_72984_F._a("recheckGaps");
        if (this._g.func_72873_a(this._i * 16 + 8, 0, this._j * 16 + 8, 16)) {
            for (int i = 0; i < 16; ++i) {
                for (int j = 0; j < 16; ++j) {
                    if (!this._e[i + j * 16]) continue;
                    this._e[i + j * 16] = false;
                    int n = this._b(i, j);
                    int n2 = this._i * 16 + i;
                    int n3 = this._j * 16 + j;
                    int n4 = this._g.func_82734_g(n2 - 1, n3);
                    int n5 = this._g.func_82734_g(n2 + 1, n3);
                    int n6 = this._g.func_82734_g(n2, n3 - 1);
                    int n7 = this._g.func_82734_g(n2, n3 + 1);
                    if (n5 < n4) {
                        n4 = n5;
                    }
                    if (n6 < n4) {
                        n4 = n6;
                    }
                    if (n7 < n4) {
                        n4 = n7;
                    }
                    this._a(n2, n3, n4);
                    this._a(n2 - 1, n3, n);
                    this._a(n2 + 1, n3, n);
                    this._a(n2, n3 - 1, n);
                    this._a(n2, n3 + 1, n);
                }
            }
            this._k = false;
        }
        this._g.field_72984_F._b();
    }

    public void _a(int n, int n2, int n3) {
        int n4 = this._g.func_72976_f(n, n2);
        if (n4 > n3) {
            this._a(n, n2, n3, n4 + 1);
        } else if (n4 < n3) {
            this._a(n, n2, n4, n3 + 1);
        }
    }

    public void _a(int n, int n2, int n3, int n4) {
        if (n4 > n3 && this._g.func_72873_a(n, 0, n2, 16)) {
            for (int i = n3; i < n4; ++i) {
                this._g.func_72936_c(cuqm._a, n, i, n2);
            }
            this._o = true;
        }
    }

    public void _b(int n, int n2, int n3) {
        int n4;
        int n5 = n4 = this._h[n3 << 4 | n] & 255;
        if (n2 > n4) {
            n5 = n2;
        }
        while (n5 > 0 && this._c(n, n5 - 1, n3) == 0) {
            --n5;
        }
        if (n5 != n4) {
            int n6;
            int n7;
            this._g.func_72975_g(n + this._i * 16, n3 + this._j * 16, n5, n4);
            this._h[n3 << 4 | n] = n5;
            int n8 = this._i * 16 + n;
            int n9 = this._j * 16 + n3;
            if (!this._g.field_73011_w._g) {
                ejxc ejxc2;
                if (n5 < n4) {
                    for (n7 = n5; n7 < n4; ++n7) {
                        ejxc2 = this._b[n7 >> 4];
                        if (ejxc2 == null) continue;
                        ejxc2._c(n, n7 & 15, n3, 15);
                        this._g.func_72902_n((this._i << 4) + n, n7, (this._j << 4) + n3);
                    }
                } else {
                    for (n7 = n4; n7 < n5; ++n7) {
                        ejxc2 = this._b[n7 >> 4];
                        if (ejxc2 == null) continue;
                        ejxc2._c(n, n7 & 15, n3, 0);
                        this._g.func_72902_n((this._i << 4) + n, n7, (this._j << 4) + n3);
                    }
                }
                n7 = 15;
                while (n5 > 0 && n7 > 0) {
                    ejxc ejxc3;
                    if ((n6 = this._c(n, --n5, n3)) == 0) {
                        n6 = 1;
                    }
                    if ((n7 -= n6) < 0) {
                        n7 = 0;
                    }
                    if ((ejxc3 = this._b[n5 >> 4]) == null) continue;
                    ejxc3._c(n, n5 & 15, n3, n7);
                }
            }
            n7 = this._h[n3 << 4 | n];
            n6 = n4;
            int n10 = n7;
            if (n7 < n4) {
                n6 = n7;
                n10 = n4;
            }
            if (n7 < this._r) {
                this._r = n7;
            }
            if (!this._g.field_73011_w._g) {
                this._a(n8 - 1, n9, n6, n10);
                this._a(n8 + 1, n9, n6, n10);
                this._a(n8, n9 - 1, n6, n10);
                this._a(n8, n9 + 1, n6, n10);
                this._a(n8, n9, n6, n10);
            }
            this._o = true;
        }
    }

    public int _c(int n, int n2, int n3) {
        int n4 = (this._i << 4) + n;
        int n5 = (this._j << 4) + n3;
        kjsv kjsv2 = kjsv.field_71973_m[this._d(n, n2, n3)];
        return kjsv2 == null ? 0 : kjsv2.getLightOpacity(this._g, n4, n2, n5);
    }

    public int _d(int n, int n2, int n3) {
        if (n2 >> 4 >= this._b.length) {
            return 0;
        }
        ejxc ejxc2 = this._b[n2 >> 4];
        return ejxc2 != null ? ejxc2._a(n, n2 & 15, n3) : 0;
    }

    public int _e(int n, int n2, int n3) {
        if (n2 >> 4 >= this._b.length) {
            return 0;
        }
        ejxc ejxc2 = this._b[n2 >> 4];
        return ejxc2 != null ? ejxc2._b(n, n2 & 15, n3) : 0;
    }

    public boolean _a(int n, int n2, int n3, int n4, int n5) {
        ogpr ogpr2;
        int n6 = n3 << 4 | n;
        if (n2 >= this._d[n6] - 1) {
            this._d[n6] = -999;
        }
        int n7 = this._h[n6];
        int n8 = this._d(n, n2, n3);
        int n9 = this._e(n, n2, n3);
        if (n8 == n4 && n9 == n5) {
            return false;
        }
        ejxc ejxc2 = this._b[n2 >> 4];
        boolean bl = false;
        if (ejxc2 == null) {
            if (n4 == 0) {
                return false;
            }
            ejxc ejxc3 = new ejxc(n2 >> 4 << 4, !this._g.field_73011_w._g);
            this._b[n2 >> 4] = ejxc3;
            ejxc2 = ejxc3;
            bl = n2 >= n7;
        }
        int n10 = this._i * 16 + n;
        int n11 = this._j * 16 + n3;
        if (n8 != 0 && !this._g.field_72995_K) {
            kjsv.field_71973_m[n8].func_71927_h(this._g, n10, n2, n11, n9);
        }
        ejxc2._a(n, n2 & 15, n3, n4);
        if (n8 != 0) {
            if (!this._g.field_72995_K) {
                kjsv.field_71973_m[n8].func_71852_a(this._g, n10, n2, n11, n8, n9);
            } else if (kjsv.field_71973_m[n8] != null && kjsv.field_71973_m[n8].hasTileEntity(n9) && (ogpr2 = this._j(n10 & 15, n2, n11 & 15)) != null && ogpr2.shouldRefresh(n8, n4, n9, n5, this._g, n10, n2, n11)) {
                this._g.func_72932_q(n10, n2, n11);
            }
        }
        if (ejxc2._a(n, n2 & 15, n3) != n4) {
            return false;
        }
        ejxc2._b(n, n2 & 15, n3, n5);
        if (bl) {
            this._d();
        } else {
            if (this._c(n, n2, n3) > 0) {
                if (n2 >= n7) {
                    this._b(n, n2 + 1, n3);
                }
            } else if (n2 == n7 - 1) {
                this._b(n, n2, n3);
            }
            this._c(n, n3);
        }
        if (n4 != 0) {
            if (!this._g.field_72995_K) {
                kjsv.field_71973_m[n4].func_71861_g(this._g, n10, n2, n11);
            }
            if (kjsv.field_71973_m[n4] != null && kjsv.field_71973_m[n4].hasTileEntity(n5)) {
                ogpr2 = this._g(n, n2, n3);
                if (ogpr2 == null) {
                    ogpr2 = kjsv.field_71973_m[n4].createTileEntity(this._g, n5);
                    this._g.func_72837_a(n10, n2, n11, ogpr2);
                }
                if (ogpr2 != null) {
                    ogpr2.func_70321_h();
                    ogpr2.field_70325_p = n5;
                }
            }
        }
        this._o = true;
        return true;
    }

    public boolean _b(int n, int n2, int n3, int n4) {
        ogpr ogpr2;
        ejxc ejxc2 = this._b[n2 >> 4];
        if (ejxc2 == null) {
            return false;
        }
        int n5 = ejxc2._b(n, n2 & 15, n3);
        if (n5 == n4) {
            return false;
        }
        this._o = true;
        ejxc2._b(n, n2 & 15, n3, n4);
        int n6 = ejxc2._a(n, n2 & 15, n3);
        if (n6 > 0 && kjsv.field_71973_m[n6] != null && kjsv.field_71973_m[n6].hasTileEntity(n4) && (ogpr2 = this._g(n, n2, n3)) != null) {
            ogpr2.func_70321_h();
            ogpr2.field_70325_p = n4;
        }
        return true;
    }

    public int _a(cuqm cuqm2, int n, int n2, int n3) {
        ejxc ejxc2 = this._b[n2 >> 4];
        return ejxc2 == null ? (this._f(n, n2, n3) ? cuqm2._c : 0) : (cuqm2 == cuqm._a ? (this._g.field_73011_w._g ? 0 : ejxc2._c(n, n2 & 15, n3)) : (cuqm2 == cuqm._b ? ejxc2._d(n, n2 & 15, n3) : cuqm2._c));
    }

    public void _a(cuqm cuqm2, int n, int n2, int n3, int n4) {
        ejxc ejxc2 = this._b[n2 >> 4];
        if (ejxc2 == null) {
            ejxc ejxc3 = new ejxc(n2 >> 4 << 4, !this._g.field_73011_w._g);
            this._b[n2 >> 4] = ejxc3;
            ejxc2 = ejxc3;
            this._d();
        }
        this._o = true;
        if (cuqm2 == cuqm._a) {
            if (!this._g.field_73011_w._g) {
                ejxc2._c(n, n2 & 15, n3, n4);
            }
        } else if (cuqm2 == cuqm._b) {
            ejxc2._d(n, n2 & 15, n3, n4);
        }
    }

    public int _c(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        ejxc ejxc2 = this._b[n2 >> 4];
        if (ejxc2 == null) {
            return !this._g.field_73011_w._g && n4 < cuqm._a._c ? cuqm._a._c - n4 : 0;
        }
        int n7 = n6 = this._g.field_73011_w._g ? 0 : ejxc2._c(n, n2 & 15, n3);
        if (n6 > 0) {
            _a = true;
        }
        if ((n5 = ejxc2._d(n, n2 & 15, n3)) > (n6 -= n4)) {
            n6 = n5;
        }
        return n6;
    }

    public void _a(Entity entity) {
        int n;
        this._p = true;
        int n2 = dwbg._c((double)(entity.field_70165_t / 16.0));
        int n3 = dwbg._c((double)(entity.field_70161_v / 16.0));
        if (n2 != this._i || n3 != this._j) {
            this._g.func_98180_V()._c("Wrong location! " + (Object)entity);
            Thread.dumpStack();
        }
        if ((n = dwbg._c((double)(entity.field_70163_u / 16.0))) < 0) {
            n = 0;
        }
        if (n >= this._m.length) {
            n = this._m.length - 1;
        }
        bpzx.EVENT_BUS.post((Event)new hcno.eidn(entity, this._i, this._j, entity.field_70176_ah, entity.field_70164_aj));
        entity.field_70175_ag = true;
        entity.field_70176_ah = this._i;
        entity.field_70162_ai = n;
        entity.field_70164_aj = this._j;
        this._m[n].add(entity);
    }

    public void _b(Entity entity) {
        this._a(entity, entity.field_70162_ai);
    }

    public void _a(Entity entity, int n) {
        if (n < 0) {
            n = 0;
        }
        if (n >= this._m.length) {
            n = this._m.length - 1;
        }
        this._m[n].remove((Object)entity);
    }

    public boolean _f(int n, int n2, int n3) {
        return n2 >= this._h[n3 << 4 | n];
    }

    public ogpr _g(int n, int n2, int n3) {
        loks loks2 = new loks(n, n2, n3);
        ogpr ogpr2 = (ogpr)this._l.get((Object)loks2);
        if (ogpr2 != null && ogpr2.func_70320_p()) {
            this._l.remove((Object)loks2);
            ogpr2 = null;
        }
        if (ogpr2 == null) {
            int n4 = this._d(n, n2, n3);
            int n5 = this._e(n, n2, n3);
            if (n4 <= 0 || !kjsv.field_71973_m[n4].hasTileEntity(n5)) {
                return null;
            }
            if (ogpr2 == null) {
                ogpr2 = kjsv.field_71973_m[n4].createTileEntity(this._g, n5);
                this._g.func_72837_a(this._i * 16 + n, n2, this._j * 16 + n3, ogpr2);
            }
            ogpr2 = (ogpr)this._l.get((Object)loks2);
        }
        return ogpr2;
    }

    public void _a(ogpr ogpr2) {
        int n = ogpr2.field_70329_l - this._i * 16;
        int n2 = ogpr2.field_70330_m;
        int n3 = ogpr2.field_70327_n - this._j * 16;
        this._a(n, n2, n3, ogpr2);
        if (this._f) {
            this._g.addTileEntity(ogpr2);
        }
    }

    public void _a(int n, int n2, int n3, ogpr ogpr2) {
        loks loks2 = new loks(n, n2, n3);
        ogpr2.func_70308_a(this._g);
        ogpr2.field_70329_l = this._i * 16 + n;
        ogpr2.field_70330_m = n2;
        ogpr2.field_70327_n = this._j * 16 + n3;
        kjsv kjsv2 = kjsv.field_71973_m[this._d(n, n2, n3)];
        if (kjsv2 != null && kjsv2.hasTileEntity(this._e(n, n2, n3))) {
            if (this._l.containsKey((Object)loks2)) {
                ((ogpr)this._l.get((Object)loks2)).func_70313_j();
            }
            ogpr2.func_70312_q();
            this._l.put(loks2, ogpr2);
        }
    }

    public void _h(int n, int n2, int n3) {
        ogpr ogpr2;
        loks loks2 = new loks(n, n2, n3);
        if (this._f && (ogpr2 = (ogpr)this._l.remove((Object)loks2)) != null) {
            ogpr2.func_70313_j();
        }
    }

    public void _f() {
        this._f = true;
        this._g.func_72852_a(this._l.values());
        for (int i = 0; i < this._m.length; ++i) {
            for (Entity entity : this._m[i]) {
                entity.func_110123_P();
            }
            this._g.func_72868_a(this._m[i]);
        }
        bpzx.EVENT_BUS.post((Event)new ifqy.uxsf(this));
    }

    public void _g() {
        this._f = false;
        for (ogpr ogpr2 : this._l.values()) {
            this._g.func_72928_a(ogpr2);
        }
        for (int i = 0; i < this._m.length; ++i) {
            this._g.func_72828_b(this._m[i]);
        }
        bpzx.EVENT_BUS.post((Event)new ifqy.eidn(this));
    }

    public void _h() {
        this._o = true;
    }

    public void _a(Entity entity, rojd rojd2, List list, mquq mquq2) {
        int n = dwbg._c((double)((rojd2.field_72338_b - cuqu.MAX_ENTITY_RADIUS) / 16.0));
        int n2 = dwbg._c((double)((rojd2.field_72337_e + cuqu.MAX_ENTITY_RADIUS) / 16.0));
        if (n < 0) {
            n = 0;
            n2 = Math.max(0, n2);
        }
        if (n2 >= this._m.length) {
            n2 = this._m.length - 1;
            n = Math.min(n, n2);
        }
        for (int i = n; i <= n2; ++i) {
            List list2 = this._m[i];
            for (int j = 0; j < list2.size(); ++j) {
                Entity entity2 = (Entity)list2.get(j);
                if (entity2 == entity || !entity2.field_70121_D.func_72326_a(rojd2) || mquq2 != null && !mquq2.func_82704_a(entity2)) continue;
                list.add(entity2);
                Entity[] arrentity = entity2.func_70021_al();
                if (arrentity == null) continue;
                for (int k = 0; k < arrentity.length; ++k) {
                    entity2 = arrentity[k];
                    if (entity2 == entity || !entity2.field_70121_D.func_72326_a(rojd2) || mquq2 != null && !mquq2.func_82704_a(entity2)) continue;
                    list.add(entity2);
                }
            }
        }
    }

    public void _a(Class class_, rojd rojd2, List list, mquq mquq2) {
        int n = dwbg._c((double)((rojd2.field_72338_b - cuqu.MAX_ENTITY_RADIUS) / 16.0));
        int n2 = dwbg._c((double)((rojd2.field_72337_e + cuqu.MAX_ENTITY_RADIUS) / 16.0));
        if (n < 0) {
            n = 0;
        } else if (n >= this._m.length) {
            n = this._m.length - 1;
        }
        if (n2 >= this._m.length) {
            n2 = this._m.length - 1;
        } else if (n2 < 0) {
            n2 = 0;
        }
        for (int i = n; i <= n2; ++i) {
            List list2 = this._m[i];
            for (int j = 0; j < list2.size(); ++j) {
                Entity entity = (Entity)list2.get(j);
                if (!class_.isAssignableFrom(entity.getClass()) || !entity.field_70121_D.func_72326_a(rojd2) || mquq2 != null && !mquq2.func_82704_a(entity)) continue;
                list.add(entity);
            }
        }
    }

    public boolean _a(boolean bl) {
        if (bl ? this._p && this._g.func_82737_E() != this._q || this._o : this._p && this._g.func_82737_E() >= this._q + 600L) {
            return true;
        }
        return this._o;
    }

    public Random _a(long l) {
        return new Random(this._g.func_72905_C() + (long)(this._i * this._i * 4987142) + (long)(this._i * 5947611) + (long)(this._j * this._j) * 4392871L + (long)(this._j * 389711) ^ l);
    }

    public boolean _i() {
        return false;
    }

    public void _a(ifcm ifcm2, ifcm ifcm3, int n, int n2) {
        if (!this._n && ifcm2._a(n + 1, n2 + 1) && ifcm2._a(n, n2 + 1) && ifcm2._a(n + 1, n2)) {
            ifcm2._a(ifcm3, n, n2);
        }
        if (ifcm2._a(n - 1, n2) && !ifcm2._d((int)(n - 1), (int)n2)._n && ifcm2._a(n - 1, n2 + 1) && ifcm2._a(n, n2 + 1) && ifcm2._a(n - 1, n2 + 1)) {
            ifcm2._a(ifcm3, n - 1, n2);
        }
        if (ifcm2._a(n, n2 - 1) && !ifcm2._d((int)n, (int)(n2 - 1))._n && ifcm2._a(n + 1, n2 - 1) && ifcm2._a(n + 1, n2 - 1) && ifcm2._a(n + 1, n2)) {
            ifcm2._a(ifcm3, n, n2 - 1);
        }
        if (ifcm2._a(n - 1, n2 - 1) && !ifcm2._d((int)(n - 1), (int)(n2 - 1))._n && ifcm2._a(n, n2 - 1) && ifcm2._a(n - 1, n2)) {
            ifcm2._a(ifcm3, n - 1, n2 - 1);
        }
    }

    public int _d(int n, int n2) {
        int n3 = n | n2 << 4;
        int n4 = this._d[n3];
        if (n4 == -999) {
            int n5 = this._a() + 15;
            n4 = -1;
            while (n5 > 0 && n4 == -1) {
                ccfp ccfp2;
                int n6 = this._d(n, n5, n2);
                ccfp ccfp3 = ccfp2 = n6 == 0 ? ccfp._a : kjsv.field_71973_m[n6].field_72018_cp;
                if (!ccfp2._d() && !ccfp2._a()) {
                    --n5;
                    continue;
                }
                n4 = n5 + 1;
            }
            this._d[n3] = n4;
        }
        return n4;
    }

    public void _j() {
        if (this._k && !this._g.field_73011_w._g) {
            this._e();
        }
    }

    public yupu _k() {
        return new yupu(this._i, this._j);
    }

    public boolean _e(int n, int n2) {
        if (n < 0) {
            n = 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        for (int i = n; i <= n2; i += 16) {
            ejxc ejxc2 = this._b[i >> 4];
            if (ejxc2 == null || ejxc2._a()) continue;
            return false;
        }
        return true;
    }

    public void _a(ejxc[] arrejxc) {
        this._b = arrejxc;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(byte[] arrby, int n, int n2, boolean bl) {
        int n3;
        lolm lolm2;
        for (ogpr ogpr2 : this._l.values()) {
            ogpr2.func_70321_h();
            ogpr2.func_70322_n();
            ogpr2.func_70311_o();
        }
        int n4 = 0;
        boolean bl2 = !this._g.field_73011_w._g;
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if ((n & 1 << n3) != 0) {
                if (this._b[n3] == null) {
                    this._b[n3] = new ejxc(n3 << 4, bl2);
                }
                lolm2 = this._b[n3]._e();
                System.arraycopy(arrby, n4, (Object)lolm2, 0, ((byte[])lolm2).length);
                n4 += ((lolm)lolm2).length;
                continue;
            }
            if (!bl || this._b[n3] == null) continue;
            this._b[n3] = null;
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if ((n & 1 << n3) == 0 || this._b[n3] == null) continue;
            lolm2 = this._b[n3]._h();
            System.arraycopy(arrby, n4, lolm2._a, 0, lolm2._a.length);
            n4 += lolm2._a.length;
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if ((n & 1 << n3) == 0 || this._b[n3] == null) continue;
            lolm2 = this._b[n3]._i();
            System.arraycopy(arrby, n4, lolm2._a, 0, lolm2._a.length);
            n4 += lolm2._a.length;
        }
        if (bl2) {
            for (n3 = 0; n3 < this._b.length; ++n3) {
                if ((n & 1 << n3) == 0 || this._b[n3] == null) continue;
                lolm2 = this._b[n3]._j();
                System.arraycopy(arrby, n4, lolm2._a, 0, lolm2._a.length);
                n4 += lolm2._a.length;
            }
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if ((n2 & 1 << n3) != 0) {
                if (this._b[n3] == null) {
                    n4 += 2048;
                    continue;
                }
                lolm2 = this._b[n3]._g();
                if (lolm2 == null) {
                    lolm2 = this._b[n3]._k();
                }
                System.arraycopy(arrby, n4, lolm2._a, 0, lolm2._a.length);
                n4 += lolm2._a.length;
                continue;
            }
            if (!bl || this._b[n3] == null || this._b[n3]._g() == null) continue;
            this._b[n3]._f();
        }
        if (bl) {
            System.arraycopy(arrby, n4, this._c, 0, this._c.length);
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if (this._b[n3] == null || (n & 1 << n3) == 0) continue;
            this._b[n3]._d();
        }
        this._c();
        ArrayList<ogpr> arrayList = new ArrayList<ogpr>();
        for (ogpr ogpr3 : this._l.values()) {
            int n5 = ogpr3.field_70329_l & 15;
            int n6 = ogpr3.field_70330_m;
            int n7 = ogpr3.field_70327_n & 15;
            kjsv kjsv2 = ogpr3.func_70311_o();
            if (kjsv2 == null || kjsv2.field_71990_ca != this._d(n5, n6, n7) || ogpr3.func_70322_n() != this._e(n5, n6, n7)) {
                arrayList.add(ogpr3);
            }
            ogpr3.func_70321_h();
        }
        for (ogpr ogpr4 : arrayList) {
            ogpr4.func_70313_j();
        }
    }

    public iwft _a(int n, int n2, qmzw qmzw2) {
        int n3 = this._c[n2 << 4 | n] & 255;
        if (n3 == 255) {
            iwft iwft2 = qmzw2._a((this._i << 4) + n, (this._j << 4) + n2);
            n3 = iwft2._N;
            this._c[n2 << 4 | n] = (byte)(n3 & 255);
        }
        return iwft._a[n3] == null ? iwft._c : iwft._a[n3];
    }

    public byte[] _l() {
        return this._c;
    }

    public void _a(byte[] arrby) {
        this._c = arrby;
    }

    public void _m() {
        this._t = 0;
    }

    public void _n() {
        for (int i = 0; i < 8; ++i) {
            if (this._t >= 4096) {
                return;
            }
            int n = this._t % 16;
            int n2 = this._t / 16 % 16;
            int n3 = this._t / 256;
            ++this._t;
            int n4 = (this._i << 4) + n2;
            int n5 = (this._j << 4) + n3;
            for (int j = 0; j < 16; ++j) {
                int n6 = (n << 4) + j;
                if ((this._b[n] != null || j != 0 && j != 15 && n2 != 0 && n2 != 15 && n3 != 0 && n3 != 15) && (this._b[n] == null || this._b[n]._a(n2, j, n3) != 0)) continue;
                if (kjsv.field_71984_q[this._g.func_72798_a(n4, n6 - 1, n5)] > 0) {
                    this._g.func_72969_x(n4, n6 - 1, n5);
                }
                if (kjsv.field_71984_q[this._g.func_72798_a(n4, n6 + 1, n5)] > 0) {
                    this._g.func_72969_x(n4, n6 + 1, n5);
                }
                if (kjsv.field_71984_q[this._g.func_72798_a(n4 - 1, n6, n5)] > 0) {
                    this._g.func_72969_x(n4 - 1, n6, n5);
                }
                if (kjsv.field_71984_q[this._g.func_72798_a(n4 + 1, n6, n5)] > 0) {
                    this._g.func_72969_x(n4 + 1, n6, n5);
                }
                if (kjsv.field_71984_q[this._g.func_72798_a(n4, n6, n5 - 1)] > 0) {
                    this._g.func_72969_x(n4, n6, n5 - 1);
                }
                if (kjsv.field_71984_q[this._g.func_72798_a(n4, n6, n5 + 1)] > 0) {
                    this._g.func_72969_x(n4, n6, n5 + 1);
                }
                this._g.func_72969_x(n4, n6, n5);
            }
        }
    }

    public void _i(int n, int n2, int n3) {
        ogpr ogpr2;
        loks loks2 = new loks(n, n2, n3);
        if (this._f && (ogpr2 = (ogpr)this._l.get((Object)loks2)) != null && ogpr2.func_70320_p()) {
            this._l.remove((Object)loks2);
        }
    }

    public ogpr _j(int n, int n2, int n3) {
        loks loks2 = new loks(n, n2, n3);
        ogpr ogpr2 = (ogpr)this._l.get((Object)loks2);
        if (ogpr2 != null && ogpr2.func_70320_p()) {
            this._l.remove((Object)loks2);
            ogpr2 = null;
        }
        return ogpr2;
    }
}

