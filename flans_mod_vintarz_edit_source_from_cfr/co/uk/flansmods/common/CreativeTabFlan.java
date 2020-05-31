/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ieta
 *  jhvs
 *  kjsv
 *  tekj
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.guns.GunType;
import java.util.ArrayList;
import java.util.List;

public class CreativeTabFlan
extends tekj {
    public int type;
    public int icon;
    public int time = 0;

    public CreativeTabFlan(int n) {
        super("tabFlan" + n);
        this.type = n;
    }

    public ieta getIconItemStack() {
        this.icon = FlansMod.ticker / 20;
        switch (this.type) {
            case 0: {
                return GunType.guns.size() == 0 ? new ieta(kjsv.field_72101_ab, 1, 4) : new ieta(((GunType)GunType.guns.get((int)(this.icon % GunType.guns.size()))).item);
            }
            case 1: {
                return DriveableType.types.size() == 0 ? new ieta(kjsv.field_72101_ab, 1, 14) : new ieta(DriveableType.types.get((int)(this.icon % DriveableType.types.size())).item);
            }
            case 2: {
                return FlansMod.partItems.size() == 0 ? new ieta(kjsv.field_72101_ab, 1, 5) : new ieta((jhvs)FlansMod.partItems.get(this.icon % FlansMod.partItems.size()));
            }
            case 3: {
                return FlansMod.armourItems.size() == 0 ? new ieta(kjsv.field_72101_ab, 1, 11) : new ieta(FlansMod.armourItems.get(this.icon % FlansMod.armourItems.size()));
            }
            case 4: {
                return FlansMod.mechaItems.size() == 0 ? new ieta(kjsv.field_72101_ab, 1, 10) : new ieta((jhvs)FlansMod.mechaItems.get(this.icon % FlansMod.mechaItems.size()));
            }
        }
        return new ieta(FlansMod.craftingTable);
    }
}

