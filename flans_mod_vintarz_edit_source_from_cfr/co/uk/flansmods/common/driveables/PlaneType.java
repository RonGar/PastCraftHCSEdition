/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ieta
 *  jhvs
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.client.model.ModelDriveable;
import co.uk.flansmods.client.model.ModelPlane;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.PartType;
import co.uk.flansmods.common.TypeFile;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.driveables.Propeller;
import co.uk.flansmods.common.vector.Vector3f;
import java.util.ArrayList;

public class PlaneType
extends DriveableType {
    public float lookDownModifier = 1.0f;
    public float lookUpModifier = 1.0f;
    public float rollLeftModifier = 1.0f;
    public float rollRightModifier = 1.0f;
    public float turnLeftModifier = 1.0f;
    public float turnRightModifier = 1.0f;
    public float lift = 1.0f;
    public Vector3f bombPosition;
    public int planeShootDelay;
    public int planeBombDelay;
    public ArrayList<Propeller> propellers = new ArrayList();
    public boolean hasGear = false;
    public boolean hasDoor = false;
    public boolean hasWing = false;
    public float restingPitch = 0.0f;
    public boolean invInflight = true;
    public static ArrayList<PlaneType> types = new ArrayList();

    public PlaneType(TypeFile typeFile) {
        super(typeFile);
        types.add(this);
    }

    @Override
    protected void read(String[] arrstring, TypeFile typeFile) {
        super.read(arrstring, typeFile);
        try {
            if (arrstring[0].equals("TurnLeftSpeed")) {
                this.turnLeftModifier = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("TurnRightSpeed")) {
                this.turnRightModifier = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("LookUpSpeed")) {
                this.lookUpModifier = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("LookDownSpeed")) {
                this.lookDownModifier = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("RollLeftSpeed")) {
                this.rollLeftModifier = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("RollRightSpeed")) {
                this.rollRightModifier = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Lift")) {
                this.lift = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("BombPosition")) {
                this.bombPosition = new Vector3f(Float.parseFloat(arrstring[1]) / 16.0f, Float.parseFloat(arrstring[2]) / 16.0f, Float.parseFloat(arrstring[3]) / 16.0f);
            }
            if (arrstring[0].equals("ShootDelay")) {
                this.planeShootDelay = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("BombDelay")) {
                this.planeBombDelay = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("Propeller")) {
                Propeller propeller = new Propeller(Integer.parseInt(arrstring[1]), Integer.parseInt(arrstring[2]), Integer.parseInt(arrstring[3]), Integer.parseInt(arrstring[4]), EnumDriveablePart.getPart(arrstring[5]), PartType.getPart(arrstring[6]));
                this.propellers.add(propeller);
                this.recipe.add(new ieta(propeller.itemType.item));
            }
            if (arrstring[0].equals("PropSoundLength")) {
                this.engineSoundLength = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("PropSound")) {
                this.engineSound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "driveables", arrstring[1]);
            }
            if (arrstring[0].equals("ShootSound")) {
                this.shootMainSound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "driveables", arrstring[1]);
            }
            if (arrstring[0].equals("BombSound")) {
                this.shootSecondarySound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "driveables", arrstring[1]);
            }
            if (arrstring[0].equals("HasGear")) {
                this.hasGear = arrstring[1].equals("True");
            }
            if (arrstring[0].equals("HasDoor")) {
                this.hasDoor = arrstring[1].equals("True");
            }
            if (arrstring[0].equals("HasWing")) {
                this.hasWing = arrstring[1].equals("True");
            }
            if (arrstring[0].equals("RestingPitch")) {
                this.restingPitch = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("InflightInventory")) {
                this.invInflight = arrstring[1].equals("False");
            }
        }
        catch (Exception exception) {}
    }

    @Override
    public int numEngines() {
        return this.propellers.size();
    }

    @Override
    public ArrayList<ieta> getItemsRequired(DriveablePart driveablePart, PartType partType) {
        ArrayList<ieta> arrayList = super.getItemsRequired(driveablePart, partType);
        for (Propeller propeller : this.propellers) {
            if (propeller.planePart != driveablePart.type) continue;
            arrayList.add(new ieta(propeller.itemType.item));
            arrayList.add(new ieta(partType.item));
        }
        return arrayList;
    }

    public static PlaneType getPlane(String string) {
        for (PlaneType planeType : types) {
            if (!planeType.shortName.equals(string)) continue;
            return planeType;
        }
        return null;
    }

    @Override
    public void reloadModel() {
        this.model = FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelPlane.class);
    }
}

