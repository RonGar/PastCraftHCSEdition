/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.TypeFile;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ArmourType
extends InfoType {
    public static List<ArmourType> armours = new ArrayList<ArmourType>();
    public int type;
    public double defence;
    public String armourTextureName;

    public ArmourType(TypeFile typeFile) {
        super(typeFile);
        armours.add(this);
    }

    @Override
    protected void read(String[] arrstring, TypeFile typeFile) {
        super.read(arrstring, typeFile);
        try {
            if (arrstring[0].equals("Type")) {
                if (arrstring[1].equals("Hat") || arrstring[1].equals("Helmet")) {
                    this.type = 0;
                }
                if (arrstring[1].equals("Chest") || arrstring[1].equals("Body")) {
                    this.type = 1;
                }
                if (arrstring[1].equals("Legs") || arrstring[1].equals("Pants")) {
                    this.type = 2;
                }
                if (arrstring[1].equals("Shoes") || arrstring[1].equals("Boots")) {
                    this.type = 3;
                }
            }
            if (arrstring[0].equals("DamageReduction") || arrstring[0].equals("Defence")) {
                this.defence = Double.parseDouble(arrstring[1]);
            }
            if (arrstring[0].equals("ArmourTexture") || arrstring[0].equals("ArmorTexture")) {
                this.armourTextureName = arrstring[1];
            }
        }
        catch (Exception exception) {
            System.out.println("Reading armour file failed.");
            exception.printStackTrace();
        }
    }
}

