/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  hsus
 *  ieta
 *  jhvs
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.TypeFile;
import co.uk.flansmods.common.guns.AttachmentType;
import co.uk.flansmods.common.guns.EnumAttachmentType;
import co.uk.flansmods.common.guns.ItemGun;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class PlayerClass {
    public static List<PlayerClass> classes = new ArrayList<PlayerClass>();
    public String name;
    public String shortName;
    public List<ieta> startingItems = new ArrayList<ieta>();
    public boolean horse = false;

    public PlayerClass(TypeFile typeFile) {
        do {
            String string;
            String[] arrstring;
            try {
                string = typeFile.readLine();
            }
            catch (Exception exception) {
                break;
            }
            if (string == null) break;
            if (string.startsWith("//") || (arrstring = string.split(" ")).length < 2) continue;
            this.read(arrstring, typeFile);
        } while (true);
        classes.add(this);
    }

    protected void read(String[] arrstring, TypeFile typeFile) {
        try {
            if (arrstring[0].equals("Name")) {
                this.name = arrstring[1];
                for (int i = 0; i < arrstring.length - 2; ++i) {
                    this.name = this.name + " " + arrstring[i + 2];
                }
            }
            if (arrstring[0].equals("ShortName")) {
                this.shortName = arrstring[1];
            }
            if (arrstring[0].equals("AddItem")) {
                jhvs jhvs2 = null;
                int n = 1;
                int n2 = 0;
                String[] arrstring2 = arrstring[1].split("\\+");
                for (jhvs jhvs3 : jhvs.field_77698_e) {
                    if (jhvs3 == null || jhvs3.func_77658_a() == null || !jhvs3.func_77658_a().equals(arrstring2[0]) && (jhvs3.func_77658_a().split("\\.").length <= 1 || !jhvs3.func_77658_a().split("\\.")[1].equals(arrstring2[0]))) continue;
                    jhvs2 = jhvs3;
                }
                for (InfoType infoType : InfoType.infoTypes) {
                    if (!infoType.shortName.equals(arrstring2[0])) continue;
                    jhvs2 = infoType.item;
                }
                if (jhvs2 == null) {
                    FlansMod.log("Tried to add " + arrstring[1] + " to player class " + this.shortName + " but the item did not exist");
                    return;
                }
                if (arrstring.length > 2) {
                    n = Integer.parseInt(arrstring[2]);
                }
                if (arrstring.length > 3) {
                    n2 = Integer.parseInt(arrstring[3]);
                }
                ieta ieta2 = new ieta(jhvs2, n, n2);
                if (arrstring2.length > 1 && jhvs2 instanceof ItemGun) {
                    hsus hsus2 = new hsus();
                    hsus hsus3 = new hsus();
                    int n3 = 0;
                    for (int i = 0; i < arrstring2.length - 1; ++i) {
                        AttachmentType attachmentType = AttachmentType.getAttachment(arrstring2[i + 1]);
                        String string = null;
                        switch (attachmentType.type) {
                            case sights: {
                                string = "scope";
                                break;
                            }
                            case barrel: {
                                string = "barrel";
                                break;
                            }
                            case stock: {
                                string = "stock";
                                break;
                            }
                            case grip: {
                                string = "grip";
                                break;
                            }
                            case generic: {
                                string = "generic_" + n3++;
                            }
                        }
                        hsus hsus4 = new hsus();
                        new ieta(attachmentType.item)._b(hsus4);
                        hsus3._a(string, hsus4);
                    }
                    hsus2._a("attachments", hsus3);
                    ieta2._e = hsus2;
                }
                this.startingItems.add(ieta2);
            }
        }
        catch (Exception exception) {
            System.out.println("Reading class file failed.");
            exception.printStackTrace();
        }
    }

    public static PlayerClass getClass(String string) {
        for (PlayerClass playerClass : classes) {
            if (!playerClass.shortName.equals(string)) continue;
            return playerClass;
        }
        return null;
    }

}

