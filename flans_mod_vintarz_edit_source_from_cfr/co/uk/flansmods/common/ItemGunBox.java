/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  ieta
 *  jhvs
 *  net.minecraft.entity.player.EntityPlayer
 *  ogpr
 *  oxfi
 *  tekj
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.GunBoxType;
import co.uk.flansmods.common.TileEntityGunBox;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class ItemGunBox
extends oxfi {
    public static final String tagTypeName = "type";

    public ItemGunBox(int n) {
        super(n);
        this.func_77627_a(true);
    }

    public String func_77667_c(ieta ieta2) {
        GunBoxType gunBoxType = GunBoxType.getBox(ieta2._j());
        return gunBoxType == null ? "" : gunBoxType.shortName;
    }

    public void func_77633_a(int n, tekj tekj2, List list) {
        for (GunBoxType gunBoxType : GunBoxType.gunBoxMap.values()) {
            list.add(new ieta(n, 1, gunBoxType.gunBoxID));
        }
    }

    public boolean placeBlockAt(ieta ieta2, EntityPlayer entityPlayer, cuqu cuqu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        GunBoxType gunBoxType = GunBoxType.getBox(ieta2._j());
        if (gunBoxType == null) {
            return false;
        }
        boolean bl = super.placeBlockAt(ieta2, entityPlayer, cuqu2, n, n2, n3, n4, f, f2, f3, n5);
        if (bl) {
            TileEntityGunBox tileEntityGunBox = (TileEntityGunBox)cuqu2.func_72796_p(n, n2, n3);
            tileEntityGunBox.setShortName(gunBoxType.shortName);
        }
        return bl;
    }
}

