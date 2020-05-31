/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  hsus
 *  ieta
 *  jhvs
 *  jyub
 *  zxiv
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemGun;

public class InventoryGunModTable
extends jyub {
    public ieta lastGunStack;
    public GunType gunType;
    public int genericScroll = 0;
    private boolean busy = false;
    private cuqu w;

    public InventoryGunModTable(cuqu cuqu2) {
        super("Gun Modification Table", true, 13);
        this.w = cuqu2;
    }

    public void func_70296_d() {
        ieta ieta2;
        if (!this.busy && (ieta2 = this.func_70301_a(0)) != null && ieta2._a() instanceof ItemGun) {
            this.gunType = ((ItemGun)ieta2._a()).type;
            if (ieta2 != this.lastGunStack) {
                hsus hsus2;
                this.busy = true;
                if (ieta2._e == null) {
                    ieta2._d(new hsus());
                }
                if (!ieta2._e._c("attachments")) {
                    hsus2 = new hsus();
                    this.writeAttachmentTags(hsus2, null, "barrel");
                    this.writeAttachmentTags(hsus2, null, "scope");
                    this.writeAttachmentTags(hsus2, null, "stock");
                    this.writeAttachmentTags(hsus2, null, "grip");
                    ieta2._e._a("attachments", hsus2);
                }
                hsus2 = ieta2._e._m("attachments");
                this.func_70299_a(1, ieta._a((hsus)hsus2._m("barrel")));
                this.func_70299_a(2, ieta._a((hsus)hsus2._m("scope")));
                this.func_70299_a(3, ieta._a((hsus)hsus2._m("stock")));
                this.func_70299_a(4, ieta._a((hsus)hsus2._m("grip")));
                this.genericScroll = 0;
                for (int i = 0; i < Math.min(this.gunType.numGenericAttachmentSlots, 8); ++i) {
                    this.func_70299_a(5 + i, ieta._a((hsus)hsus2._m("generic_" + i)));
                }
                this.busy = false;
            } else {
                hsus hsus3 = (hsus)ieta2._e._c();
                hsus hsus4 = new hsus();
                this.writeAttachmentTags(hsus4, this.func_70301_a(1), "barrel");
                this.writeAttachmentTags(hsus4, this.func_70301_a(2), "scope");
                this.writeAttachmentTags(hsus4, this.func_70301_a(3), "stock");
                this.writeAttachmentTags(hsus4, this.func_70301_a(4), "grip");
                for (int i = 0; i < this.gunType.numGenericAttachmentSlots; ++i) {
                    if (i >= this.genericScroll * 4 && i < this.genericScroll * 4 + 8) {
                        this.writeAttachmentTags(hsus4, this.func_70301_a(i - this.genericScroll * 4 + 5), "generic_" + i);
                        continue;
                    }
                    hsus4._a("generic_" + i, this.func_70301_a((int)0)._e._b("generic_" + i));
                }
                hsus3._a("attachments", hsus4);
                ieta2._e = hsus3;
            }
            this.lastGunStack = ieta2;
        }
    }

    public void writeAttachmentTags(hsus hsus2, ieta ieta2, String string) {
        hsus hsus3 = new hsus();
        if (ieta2 != null) {
            ieta2._b(hsus3);
        }
        hsus2._a(string, hsus3);
    }

    public void func_70295_k_() {
    }

    public void func_70305_f() {
    }

    public boolean func_94041_b(int n, ieta ieta2) {
        return false;
    }
}

