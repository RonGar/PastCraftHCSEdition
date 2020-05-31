/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.guns;

public enum EnumAttachmentType {
    barrel("barrel", 0),
    sights("sights", 1),
    stock("stock", 2),
    grip("grip", 3),
    generic("generic", 4);
    
    private static final EnumAttachmentType[] $VALUES;

    private EnumAttachmentType(String string2, int n2) {
    }

    public static EnumAttachmentType get(String string) {
        for (EnumAttachmentType enumAttachmentType : EnumAttachmentType.values()) {
            if (!enumAttachmentType.toString().equals(string)) continue;
            return enumAttachmentType;
        }
        return generic;
    }

    static {
        $VALUES = new EnumAttachmentType[]{barrel, sights, stock, grip, generic};
    }
}

