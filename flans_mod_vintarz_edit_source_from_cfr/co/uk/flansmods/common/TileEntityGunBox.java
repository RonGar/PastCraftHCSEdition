/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  hsus
 *  maaq
 *  ogpr
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.GunBoxType;
import co.uk.flansmods.common.network.PacketGunBoxTE;
import java.util.HashMap;

public class TileEntityGunBox
extends ogpr {
    private String shortName;

    public void func_70310_b(hsus hsus2) {
        super.func_70310_b(hsus2);
        hsus2._a("type", this.shortName);
    }

    public void func_70307_a(hsus hsus2) {
        super.func_70307_a(hsus2);
        this.shortName = hsus2._j("type");
    }

    public boolean canUpdate() {
        return false;
    }

    public GunBoxType getType() {
        return (GunBoxType)GunBoxType.gunBoxMap.get(this.shortName);
    }

    public maaq func_70319_e() {
        return PacketGunBoxTE.buildGunBoxPacket(this);
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String string) {
        this.shortName = string;
    }
}

