/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.uxsf
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ieta
 *  jhvs
 *  zgcg
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.client.model.ModelDriveable;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.PartType;
import co.uk.flansmods.common.TypeFile;
import co.uk.flansmods.common.driveables.CollisionBox;
import co.uk.flansmods.common.driveables.CollisionPoint;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.DriveablePosition;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.driveables.PilotGun;
import co.uk.flansmods.common.driveables.Seat;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.vector.Vector3f;
import cpw.mods.fml.common.uxsf;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;

public class DriveableType
extends InfoType {
    @SideOnly(value=Side.CLIENT)
    public ModelDriveable model;
    public ArrayList<CollisionPoint> points = new ArrayList();
    public HashMap<EnumDriveablePart, CollisionBox> health = new HashMap();
    public HashMap<EnumDriveablePart, ieta[]> partwiseRecipe = new HashMap();
    public ArrayList<ieta> recipe = new ArrayList();
    public int numPassengers = 0;
    public Seat[] seats;
    public int numPassengerGunners = 0;
    public int nextGunID = 0;
    public int numCargoSlots;
    public int numBombSlots;
    public int fuelTankSize = 100;
    public ArrayList<PilotGun> guns = new ArrayList();
    public Vector3f rotatedDriverOffset = new Vector3f();
    public float yOffset = 0.625f;
    public float cameraDistance = 5.0f;
    public float maxThrottle = 1.0f;
    public float maxNegativeThrottle = 0.0f;
    public float mass = 1.0f;
    public DriveablePosition[] wheelPositions = new DriveablePosition[4];
    public float wheelSpringStrength = 0.5f;
    public float wheelStepHeight = 1.5f;
    public ArrayList<DriveablePosition> collisionPoints = new ArrayList();
    public float drag = 1.0f;
    public float momentOfInertia = 1.0f;
    public float bounciness = 0.4f;
    public float bulletDetectionRadius = 5.0f;
    public boolean onRadar = false;
    public String startSound;
    public int startSoundLength;
    public String engineSound;
    public int engineSoundLength;
    public String shootMainSound;
    public String shootSecondarySound;
    public static ArrayList<DriveableType> types = new ArrayList();

    public DriveableType(TypeFile typeFile) {
        super(typeFile);
        for (String string : typeFile.lines) {
            String[] arrstring;
            if (string == null) break;
            if (string.startsWith("//") || (arrstring = string.split(" ")).length < 2) continue;
            if (arrstring[0].equals("Passengers")) {
                this.numPassengers = Integer.parseInt(arrstring[1]);
                this.seats = new Seat[this.numPassengers + 1];
            }
            if (!arrstring[0].equals("NumWheels")) continue;
            this.wheelPositions = new DriveablePosition[Integer.parseInt(arrstring[1])];
        }
        types.add(this);
    }

    @Override
    protected void read(String[] arrstring, TypeFile typeFile) {
        super.read(arrstring, typeFile);
        try {
            int n;
            Object object;
            int n2;
            int n3;
            Object object2;
            if (uxsf.instance().getSide().isClient() && arrstring[0].equals("Model")) {
                this.model = FlansMod.proxy.loadModel(arrstring[1], this.shortName, ModelDriveable.class);
            }
            if (arrstring[0].equals("Texture")) {
                this.texture = arrstring[1];
            }
            if (arrstring[0].equals("MaxThrottle")) {
                this.maxThrottle = 1.0f;
            }
            if (arrstring[0].equals("MaxNegativeThrottle")) {
                this.maxNegativeThrottle = 0.2f;
            }
            if (arrstring[0].equals("Mass")) {
                this.mass = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("MomentOfInertia")) {
                this.momentOfInertia = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Drag")) {
                this.drag = 1.0f;
            }
            if (arrstring[0].equals("CollisionPoint") || arrstring[0].equals("AddCollisionPoint")) {
                this.collisionPoints.add(new DriveablePosition(arrstring));
            }
            if (arrstring[0].equals("Bounciness")) {
                this.bounciness = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("Wheel") || arrstring[0].equals("WheelPosition")) {
                DriveablePosition driveablePosition = new DriveablePosition(new Vector3f(Float.parseFloat(arrstring[2]) / 16.0f, Float.parseFloat(arrstring[3]) / 16.0f, Float.parseFloat(arrstring[4]) / 16.0f), arrstring.length > 5 ? EnumDriveablePart.getPart(arrstring[5]) : EnumDriveablePart.coreWheel);
                this.wheelPositions[Integer.parseInt((String)arrstring[1])] = driveablePosition;
                object2 = driveablePosition;
                ((DriveablePosition)object2).originaZ = object2.position.z;
                object2.position.z = 0.0f;
                if (object2.position.x > 0.0f) {
                    object2.position.x = 0.875f;
                }
            }
            if (arrstring[0].equals("WheelRadius") || arrstring[0].equals("WheelStepHeight")) {
                this.wheelStepHeight = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("WheelSpringStrength") || arrstring[0].equals("SpringStrength")) {
                this.wheelSpringStrength = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("CargoSlots")) {
                this.numCargoSlots = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("BombSlots") || arrstring[0].equals("ShellSlots")) {
                this.numBombSlots = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("FuelTankSize")) {
                this.fuelTankSize = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("BulletDetection")) {
                this.bulletDetectionRadius = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("AddRecipeParts")) {
                object2 = EnumDriveablePart.getPart(arrstring[1]);
                object = new ieta[(arrstring.length - 2) / 2];
                for (n2 = 0; n2 < (arrstring.length - 2) / 2; ++n2) {
                    n3 = Integer.parseInt(arrstring[2 * n2 + 2]);
                    n = arrstring[2 * n2 + 3].contains(".");
                    String string = n != 0 ? arrstring[2 * n2 + 3].split("\\.")[0] : arrstring[2 * n2 + 3];
                    int n4 = n != 0 ? Integer.parseInt(arrstring[2 * n2 + 3].split("\\.")[1]) : 0;
                    object[n2] = DriveableType.getRecipeElement(string, n3, n4);
                    this.recipe.add(object[n2]);
                }
                this.partwiseRecipe.put((EnumDriveablePart)((Object)object2), (ieta[])object);
            }
            if (arrstring[0].equals("AddDye")) {
                int n5 = Integer.parseInt(arrstring[1]);
                int n6 = -1;
                n2 = 0;
                do {
                    if (n2 >= 16) break;
                    if (zgcg._a[n2].equals(arrstring[2])) {
                        n6 = n2;
                    }
                    ++n2;
                } while (true);
                if (n6 == -1) {
                    FlansMod.log("Failed to find dye colour : " + arrstring[2] + " while adding " + typeFile.name);
                    return;
                }
                this.recipe.add(new ieta(jhvs.field_77756_aW, n5, n6));
            }
            if (arrstring[0].equals("SetupPart")) {
                object2 = EnumDriveablePart.getPart(arrstring[1]);
                object = new CollisionBox(Integer.parseInt(arrstring[2]), Integer.parseInt(arrstring[3]), Integer.parseInt(arrstring[4]), Integer.parseInt(arrstring[5]), Integer.parseInt(arrstring[6]), Integer.parseInt(arrstring[7]), Integer.parseInt(arrstring[8]));
                this.health.put((EnumDriveablePart)((Object)object2), (CollisionBox)object);
                for (n2 = 0; n2 < 2; ++n2) {
                    for (n3 = 0; n3 < 2; ++n3) {
                        for (n = 0; n < 2; ++n) {
                            this.points.add(new CollisionPoint(object.x + n2 * object.w, object.y + n3 * object.h, object.z + n * object.d, ((EnumDriveablePart)((Object)object2)).getShortName(), 1.0f));
                        }
                    }
                }
            }
            if (arrstring[0].equals("Driver") || arrstring[0].equals("Pilot")) {
                this.seats[0] = arrstring.length > 4 ? new Seat(Integer.parseInt(arrstring[1]), Integer.parseInt(arrstring[2]), Integer.parseInt(arrstring[3]), Float.parseFloat(arrstring[4]), Float.parseFloat(arrstring[5]), Float.parseFloat(arrstring[6]), Float.parseFloat(arrstring[7])) : new Seat(Integer.parseInt(arrstring[1]), Integer.parseInt(arrstring[2]), Integer.parseInt(arrstring[3]));
            }
            if (arrstring[0].equals("RotatedDriverOffset")) {
                this.rotatedDriverOffset = new Vector3f((float)Integer.parseInt(arrstring[1]) / 16.0f, (float)Integer.parseInt(arrstring[2]) / 16.0f, (float)Integer.parseInt(arrstring[3]) / 16.0f);
            }
            if (arrstring[0].equals("Passenger")) {
                object2 = new Seat(arrstring);
                this.seats[object2.id] = object2;
                if (((Seat)object2).gunType != null) {
                    ((Seat)object2).gunnerID = this.numPassengerGunners++;
                    this.recipe.add(new ieta(object2.gunType.item));
                }
            }
            if (arrstring[0].equals("AddGun")) {
                object2 = new PilotGun(arrstring);
                this.guns.add((PilotGun)object2);
                ((PilotGun)object2).gunID = this.nextGunID++;
                this.recipe.add(new ieta(object2.type.item));
            }
            if (arrstring[0].equals("YOffset")) {
                this.yOffset = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("CameraDistance")) {
                this.cameraDistance = Float.parseFloat(arrstring[1]);
            }
            if (arrstring[0].equals("StartSoundLength")) {
                this.startSoundLength = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("EngineSoundLength")) {
                this.engineSoundLength = Integer.parseInt(arrstring[1]);
            }
            if (arrstring[0].equals("StartSound")) {
                this.startSound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "driveables", arrstring[1]);
            }
            if (arrstring[0].equals("EngineSound")) {
                this.engineSound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "driveables", arrstring[1]);
            }
            if (arrstring[0].equals("ShootMainSound")) {
                this.shootMainSound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "driveables", arrstring[1]);
            }
            if (arrstring[0].equals("ShootSecondarySound")) {
                this.shootSecondarySound = arrstring[1];
                FlansMod.proxy.loadSound(this.contentPack, "driveables", arrstring[1]);
            }
            if (arrstring[0].equals("OnRadar")) {
                this.onRadar = arrstring[1].equals("True");
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int numEngines() {
        return 1;
    }

    public int ammoSlots() {
        return this.numPassengerGunners + this.guns.size();
    }

    public ArrayList<ieta> getItemsRequired(DriveablePart driveablePart, PartType partType) {
        ArrayList<ieta> arrayList = new ArrayList<ieta>();
        if (this.partwiseRecipe.get((Object)driveablePart.type) != null) {
            for (ieta ieta2 : this.partwiseRecipe.get((Object)driveablePart.type)) {
                arrayList.add(ieta2._l());
            }
        }
        for (PilotGun pilotGun : this.guns) {
            if (pilotGun.driveablePart != driveablePart.type) continue;
            arrayList.add(new ieta(pilotGun.type.item));
        }
        for (Seat seat : this.seats) {
            if (seat == null || seat.part != driveablePart.type || seat.gunType == null) continue;
            arrayList.add(new ieta(seat.gunType.item));
        }
        return arrayList;
    }

    public static DriveableType getDriveable(String string) {
        for (DriveableType driveableType : types) {
            if (!driveableType.shortName.equals(string)) continue;
            return driveableType;
        }
        return null;
    }
}

