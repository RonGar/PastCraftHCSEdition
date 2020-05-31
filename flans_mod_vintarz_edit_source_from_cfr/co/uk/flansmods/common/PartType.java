/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ieta
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.EnumType;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.TypeFile;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class PartType
extends InfoType {
    public int category;
    public int stackSize;
    public float engineSpeed = 1.0f;
    public float fuelConsumption = 1.0f;
    public int fuel = 0;
    public List<EnumType> worksWith = Arrays.asList(new EnumType[]{EnumType.mecha, EnumType.plane, EnumType.vehicle});
    public ArrayList<ieta> partBoxRecipe = new ArrayList();
    public static HashMap<EnumType, PartType> defaultEngines = new HashMap();
    public static List<PartType> parts = new ArrayList<PartType>();

    public PartType(TypeFile typeFile) {
        super(typeFile);
        parts.add(this);
    }

    @Override
    protected void read(TypeFile typeFile) {
        super.read(typeFile);
        if (this.category == 2) {
            for (EnumType enumType : this.worksWith) {
                if (defaultEngines.containsKey((Object)enumType)) {
                    PartType partType = defaultEngines.get((Object)enumType);
                    if (!this.isInferiorEngine(partType)) continue;
                    defaultEngines.put(enumType, this);
                    continue;
                }
                defaultEngines.put(enumType, this);
            }
        }
    }

    @Override
    protected void read(String[] arrstring, TypeFile typeFile) {
        super.read(arrstring, typeFile);
        try {
            if (arrstring[0].equals("Category")) {
                this.category = this.getCategory(arrstring[1]);
            }
            if (arrstring[0].equals("StackSize")) {
                this.stackSize = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("EngineSpeed")) {
                this.engineSpeed = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("FuelConsumption")) {
                this.fuelConsumption = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Fuel")) {
                this.fuel = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("PartBoxRecipe")) {
                ieta[] arrieta = new ieta[(arrstring.length - 2) / 2];
                for (int i = 0; i < (arrstring.length - 2) / 2; ++i) {
                    int n = Integer.parseInt(arrstring[2 * i + 2]);
                    boolean bl = arrstring[2 * i + 3].contains(".");
                    String string = bl ? arrstring[2 * i + 3].split("\\.")[0] : arrstring[2 * i + 3];
                    int n2 = bl ? Integer.parseInt(arrstring[2 * i + 3].split("\\.")[1]) : 0;
                    arrieta[i] = PartType.getRecipeElement(string, n, n2);
                }
                this.partBoxRecipe.addAll(Arrays.asList(arrieta));
            }
            if (arrstring[0].equals("WorksWith")) {
                this.worksWith = new ArrayList<EnumType>();
                for (int i = 0; i < arrstring.length - 1; ++i) {
                    this.worksWith.add(EnumType.get(arrstring[i + 1]));
                }
            }
        }
        catch (Exception exception) {
            System.out.println("Reading part file failed.");
            exception.printStackTrace();
        }
    }

    public boolean isInferiorEngine(PartType partType) {
        return this.engineSpeed > partType.engineSpeed;
    }

    public static PartType getPart(String string) {
        for (PartType partType : parts) {
            if (!partType.shortName.equals(string)) continue;
            return partType;
        }
        return null;
    }

    private int getCategory(String string) {
        if (string.equals("Cockpit")) {
            return 0;
        }
        if (string.equals("Wing")) {
            return 1;
        }
        if (string.equals("Engine")) {
            return 2;
        }
        if (string.equals("Propeller")) {
            return 3;
        }
        if (string.equals("Bay")) {
            return 4;
        }
        if (string.equals("Tail")) {
            return 5;
        }
        if (string.equals("Wheel")) {
            return 6;
        }
        if (string.equals("Chassis")) {
            return 7;
        }
        if (string.equals("Turret")) {
            return 8;
        }
        if (string.equals("Fuel")) {
            return 9;
        }
        if (string.equals("Misc")) {
            return 10;
        }
        return 10;
    }
}

