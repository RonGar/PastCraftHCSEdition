/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.driveables.EntityPlane;
import co.uk.flansmods.common.driveables.EntityVehicle;
import co.uk.flansmods.common.driveables.PlaneType;
import co.uk.flansmods.common.driveables.VehicleType;

public enum EnumType {
    bullet("bullet", 0, "bullets"),
    aa("aa", 1, "aaguns"),
    vehicle("vehicle", 2, "vehicles"),
    plane("plane", 3, "planes"),
    mechaItem("mechaItem", 4, "mechaItems"),
    mecha("mecha", 5, "mechas"),
    attachment("attachment", 6, "attachments"),
    gun("gun", 7, "guns"),
    grenade("grenade", 8, "grenades"),
    tool("tool", 9, "tools"),
    armour("armour", 10, "armorFiles"),
    playerClass("playerClass", 11, "classes"),
    team("team", 12, "teams"),
    box("box", 13, "boxes"),
    part("part", 14, "parts");
    
    public String folderName;
    private static final EnumType[] $VALUES;

    private EnumType(String string2, int n2, String string3) {
        this.folderName = string3;
    }

    public static EnumType get(String string) {
        for (EnumType enumType : EnumType.values()) {
            if (!enumType.folderName.equals(string)) continue;
            return enumType;
        }
        return null;
    }

    public static EnumType getFromObject(Object object) {
        return !(object instanceof EntityPlane) && !(object instanceof PlaneType) ? (!(object instanceof EntityVehicle) && !(object instanceof VehicleType) ? null : vehicle) : plane;
    }

    static {
        $VALUES = new EnumType[]{bullet, aa, vehicle, plane, mechaItem, mecha, attachment, gun, grenade, tool, armour, playerClass, team, box, part};
    }
}

