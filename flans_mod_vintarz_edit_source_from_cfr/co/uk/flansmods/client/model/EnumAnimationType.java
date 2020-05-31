/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.client.model;

public enum EnumAnimationType {
    NONE("NONE", 0),
    BOTTOM_CLIP("BOTTOM_CLIP", 1),
    PISTOL_CLIP("PISTOL_CLIP", 2),
    TOP_CLIP("TOP_CLIP", 3),
    SIDE_CLIP("SIDE_CLIP", 4),
    P90("P90", 5),
    SHOTGUN("SHOTGUN", 6),
    RIFLE("RIFLE", 7),
    REVOLVER("REVOLVER", 8),
    END_LOADED("END_LOADED", 9);
    
    private static final EnumAnimationType[] $VALUES;

    private EnumAnimationType(String string2, int n2) {
    }

    static {
        $VALUES = new EnumAnimationType[]{NONE, BOTTOM_CLIP, PISTOL_CLIP, TOP_CLIP, SIDE_CLIP, P90, SHOTGUN, RIFLE, REVOLVER, END_LOADED};
    }
}

