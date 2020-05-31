/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.guns;

public enum DamageMultiplier {
    BODY("\u0442\u0435\u043b\u043e", 0.8f),
    HEAD("\u0433\u043e\u043b\u043e\u0432\u0443", 1.2f),
    RETARD("\u043b\u0435\u0436\u0430\u0447\u0435\u0433\u043e", 1.5f);
    
    public static final DamageMultiplier[] VALUES;
    public final float value;
    public final String where;

    private DamageMultiplier(String string2, float f) {
        this.where = string2;
        this.value = f;
    }

    static {
        VALUES = DamageMultiplier.values();
    }
}

