/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.driveables;

import java.util.ArrayList;

public enum EnumDriveablePart {
    tailWheel(new EnumDriveablePart[0], "tailWheel", "Wheel (Tail)"),
    tail(new EnumDriveablePart[]{tailWheel}, "tail", "Tail"),
    bay(new EnumDriveablePart[]{tail}, "bay", "Bay"),
    topWing(new EnumDriveablePart[0], "topWing", "Top Wing"),
    leftWingWheel(new EnumDriveablePart[0], "leftWingWheel", "Wheel (Left Wing)"),
    leftWing(new EnumDriveablePart[]{topWing, leftWingWheel}, "leftWing", "Left Wing"),
    rightWingWheel(new EnumDriveablePart[0], "rightWingWheel", "Wheel (Right Wing)"),
    rightWing(new EnumDriveablePart[]{topWing, rightWingWheel}, "rightWing", "Right Wing"),
    nose(new EnumDriveablePart[0], "nose", "Nose"),
    coreWheel(new EnumDriveablePart[0], "coreWheel", "Wheel (Core)"),
    turret(new EnumDriveablePart[0], "turret", "Turret"),
    backWheel(new EnumDriveablePart[0], "backWheel", "Back Wheel"),
    frontWheel(new EnumDriveablePart[0], "frontWheel", "Front Wheel"),
    backLeftWheel(new EnumDriveablePart[0], "backLeftWheel", "Back Left Wheel"),
    frontLeftWheel(new EnumDriveablePart[0], "frontLeftWheel", "Front Left Wheel"),
    backRightWheel(new EnumDriveablePart[0], "backRightWheel", "Back Right Wheel"),
    frontRightWheel(new EnumDriveablePart[0], "frontRightWheel", "Front Right Wheel"),
    leftTrack(new EnumDriveablePart[0], "leftTrack", "Left Track"),
    rightTrack(new EnumDriveablePart[0], "rightTrack", "Right Track"),
    trailer(new EnumDriveablePart[0], "trailer", "Trailer"),
    leftArm(new EnumDriveablePart[0], "leftArm", "Left Arm"),
    rightArm(new EnumDriveablePart[0], "rightArm", "Right Arm"),
    head(new EnumDriveablePart[0], "head", "Head"),
    hips(new EnumDriveablePart[0], "hips", "Hips"),
    core(new EnumDriveablePart[]{bay, leftWing, rightWing, nose, turret, coreWheel, leftArm, rightArm, head, hips, backWheel, frontWheel, backLeftWheel, frontLeftWheel, backRightWheel, frontRightWheel, leftTrack, rightTrack, trailer}, "core", "Core");
    
    private String shortName;
    private String name;
    private EnumDriveablePart[] children;

    private EnumDriveablePart(EnumDriveablePart[] arrenumDriveablePart, String string2, String string3) {
        this.children = arrenumDriveablePart;
        this.shortName = string2;
        this.name = string3;
    }

    public EnumDriveablePart[] getChildren() {
        return this.children;
    }

    public EnumDriveablePart[] getParents() {
        ArrayList<EnumDriveablePart> arrayList = new ArrayList<EnumDriveablePart>();
        for (EnumDriveablePart enumDriveablePart : EnumDriveablePart.values()) {
            for (EnumDriveablePart enumDriveablePart2 : enumDriveablePart.getChildren()) {
                if (enumDriveablePart2 != this) continue;
                arrayList.add(enumDriveablePart);
            }
        }
        return arrayList.toArray((T[])new EnumDriveablePart[0]);
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getName() {
        return this.name;
    }

    public static EnumDriveablePart getPart(String string) {
        for (EnumDriveablePart enumDriveablePart : EnumDriveablePart.values()) {
            if (!enumDriveablePart.getShortName().equals(string)) continue;
            return enumDriveablePart;
        }
        return null;
    }

    public static boolean isWheel(EnumDriveablePart enumDriveablePart) {
        return enumDriveablePart == coreWheel || enumDriveablePart == tailWheel || enumDriveablePart == leftWingWheel || enumDriveablePart == rightWingWheel;
    }
}

