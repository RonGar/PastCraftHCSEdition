/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ieta
 *  ivrb
 *  jhvs
 *  kkuu
 */
package co.uk.flansmods.vintarz;

import co.uk.flansmods.common.ItemVehicle;

public class SlotVehInv
extends kkuu {
    public SlotVehInv(ivrb ivrb2, int n, int n2, int n3) {
        super(ivrb2, n, n2, n3);
    }

    public boolean func_75214_a(ieta ieta2) {
        jhvs jhvs2 = ieta2 == null ? null : ieta2._a();
        return jhvs2 != null && !(jhvs2 instanceof ItemVehicle);
    }
}

