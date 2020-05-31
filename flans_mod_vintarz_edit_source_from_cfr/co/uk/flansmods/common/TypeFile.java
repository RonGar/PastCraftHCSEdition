/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.EnumType;
import java.util.ArrayList;
import java.util.HashMap;

public class TypeFile {
    public EnumType type;
    public String name;
    public ArrayList<String> lines;
    public static HashMap<EnumType, ArrayList<TypeFile>> files = new HashMap();
    private int readerPosition = 0;

    public TypeFile(EnumType enumType, String string) {
        this.type = enumType;
        this.name = string;
        this.lines = new ArrayList();
        files.get((Object)this.type).add(this);
    }

    public String readLine() {
        if (this.readerPosition == this.lines.size()) {
            return null;
        }
        return this.lines.get(this.readerPosition++);
    }

    static {
        for (EnumType enumType : EnumType.values()) {
            files.put(enumType, new ArrayList());
        }
    }
}

