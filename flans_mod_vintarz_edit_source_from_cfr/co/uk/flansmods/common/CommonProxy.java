/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.registry.TickRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cuqu
 *  hsus
 *  ieta
 *  ivrt
 *  jhvs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.CommonTickHandler;
import co.uk.flansmods.common.ContainerPlaneInventory;
import co.uk.flansmods.common.ContainerPlaneMenu;
import co.uk.flansmods.common.EnumType;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.GunBoxType;
import co.uk.flansmods.common.ItemPart;
import co.uk.flansmods.common.PartType;
import co.uk.flansmods.common.driveables.CollisionBox;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.guns.ContainerGunModTable;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;

public class CommonProxy {
    protected static Pattern zipJar = Pattern.compile("(.+).(zip|jar)$");

    public List<File> getContentList(Method method, ClassLoader classLoader) {
        ArrayList<File> arrayList = new ArrayList<File>();
        for (File file : FlansMod.flanDir.listFiles()) {
            if (!file.isDirectory() && !zipJar.matcher(file.getName()).matches()) continue;
            FlansMod.log("Loaded content pack : " + file.getName());
            arrayList.add(file);
        }
        FlansMod.log("Loaded content pack list server side.");
        return arrayList;
    }

    public void load() {
    }

    public List<File> getContentList() {
        return null;
    }

    public void registerTileEntityRenderers() {
    }

    public void loadDefaultGraphics() {
    }

    public void loadKeyBindings() {
    }

    public void doTutorialStuff(EntityPlayer entityPlayer, EntityDriveable entityDriveable) {
    }

    public void changeControlMode(EntityPlayer entityPlayer) {
    }

    public boolean mouseControlEnabled() {
        return false;
    }

    public void openDriveableMenu(EntityPlayer entityPlayer, cuqu cuqu2, EntityDriveable entityDriveable) {
    }

    public <T> T loadModel(String string, String string2, Class<T> class_) {
        return null;
    }

    public void loadSound(String string, String string2, String string3) {
    }

    public boolean isThePlayer(EntityPlayer entityPlayer) {
        return false;
    }

    public void buyGun(GunBoxType gunBoxType, int n) {
    }

    public void buyAmmo(GunBoxType gunBoxType, int n, int n2) {
    }

    public Object getClientGui(int n, EntityPlayer entityPlayer, cuqu cuqu2, int n2, int n3, int n4) {
        return null;
    }

    public ivrt getServerGui(int n, EntityPlayer entityPlayer, cuqu cuqu2, int n2, int n3, int n4) {
        switch (n) {
            case 2: {
                return new ContainerGunModTable(entityPlayer.field_71071_by, cuqu2);
            }
            case 3: {
                return new ContainerPlaneMenu(entityPlayer.field_71071_by, cuqu2);
            }
            case 4: {
                return new ContainerPlaneMenu(entityPlayer.field_71071_by, cuqu2, true, ((EntitySeat)entityPlayer.field_70154_o).driveable);
            }
            case 6: {
                return new ContainerPlaneInventory(entityPlayer.field_71071_by, cuqu2, ((EntitySeat)entityPlayer.field_70154_o).driveable, 0);
            }
            case 7: {
                return new ContainerPlaneInventory(entityPlayer.field_71071_by, cuqu2, ((EntitySeat)entityPlayer.field_70154_o).driveable, 1);
            }
            case 8: {
                return new ContainerPlaneMenu(entityPlayer.field_71071_by, cuqu2, true, ((EntitySeat)entityPlayer.field_70154_o).driveable);
            }
            case 9: {
                return new ContainerPlaneInventory(entityPlayer.field_71071_by, cuqu2, ((EntitySeat)entityPlayer.field_70154_o).driveable, 2);
            }
        }
        return null;
    }

    public void playBlockBreakSound(int n, int n2, int n3, int n4) {
    }

    public void doTickStuff() {
        TickRegistry.registerTickHandler((ITickHandler)new CommonTickHandler(), (Side)Side.SERVER);
    }

    public void craftDriveable(EntityPlayer entityPlayer, DriveableType driveableType) {
        rojd rojd2 = new rojd(null);
        rojd2._a(entityPlayer.field_71071_by);
        boolean bl = true;
        for (ieta ieta2 : driveableType.recipe) {
            int n = 0;
            for (int i = 0; i < entityPlayer.field_71071_by.func_70302_i_(); ++i) {
                Object object = entityPlayer.field_71071_by.func_70301_a(i);
                if (object == null || object._d != ieta2._d || object._j() != ieta2._j()) continue;
                int n2 = Math.min(object._b, ieta2._b - n);
                object._b -= n2;
                if (object._b <= 0) {
                    object = null;
                }
                entityPlayer.field_71071_by.func_70299_a(i, object);
                if ((n += n2) == ieta2._b) break;
            }
            if (n >= ieta2._b) continue;
            bl = false;
            break;
        }
        if (!bl) {
            entityPlayer.field_71071_by._a(rojd2);
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < rojd2.func_70302_i_(); ++i) {
            ieta ieta3 = rojd2.func_70301_a(i);
            if (ieta3 == null || !(ieta3._a() instanceof ItemPart)) continue;
            PartType partType = ((ItemPart)ieta3._a()).type;
            if (partType.category != 2 || !partType.worksWith.contains((Object)EnumType.getFromObject(driveableType))) continue;
            if (hashMap.containsKey(partType)) {
                ((ieta)hashMap.get((Object)partType))._b += ieta3._b;
                continue;
            }
            hashMap.put(partType, ieta3);
        }
        float f = -1.0f;
        ieta ieta4 = null;
        for (Object object : hashMap.keySet()) {
            if (!(object.engineSpeed > f) || ((ieta)hashMap.get((Object)object))._b < driveableType.numEngines()) continue;
            f = object.engineSpeed;
            ieta4 = (ieta)hashMap.get(object);
        }
        if (ieta4 == null) {
            entityPlayer.field_71071_by._a(rojd2);
            return;
        }
        int n = 0;
        for (int i = 0; i < entityPlayer.field_71071_by.func_70302_i_(); ++i) {
            ieta ieta5 = entityPlayer.field_71071_by.func_70301_a(i);
            if (ieta5 == null || ieta5._d != ieta4._d) continue;
            int n3 = Math.min(ieta5._b, driveableType.numEngines() - n);
            ieta5._b -= n3;
            if (ieta5._b <= 0) {
                ieta5 = null;
            }
            entityPlayer.field_71071_by.func_70299_a(i, ieta5);
            if ((n += n3) == driveableType.numEngines()) break;
        }
        ieta ieta6 = new ieta(driveableType.item);
        hsus hsus2 = new hsus();
        hsus2._a("Engine", ((ItemPart)ieta4._a()).type.shortName);
        hsus2._a("Type", driveableType.shortName);
        for (EnumDriveablePart enumDriveablePart : EnumDriveablePart.values()) {
            hsus2._a(enumDriveablePart.getShortName() + "_Health", driveableType.health.get((Object)enumDriveablePart) == null ? 0 : driveableType.health.get((Object)enumDriveablePart).health);
            hsus2._a(enumDriveablePart.getShortName() + "_Fire", false);
        }
        ieta6._e = hsus2;
        if (!entityPlayer.field_71071_by._c(ieta6)) {
            entityPlayer.func_71021_b(ieta6);
        }
    }

    public void repairDriveable(EntityPlayer entityPlayer, EntityDriveable entityDriveable, DriveablePart driveablePart) {
        for (Object object : driveablePart.type.getParents()) {
            if (entityDriveable.isPartIntact((EnumDriveablePart)((Object)object))) continue;
            return;
        }
        rojd rojd2 = new rojd(null);
        rojd2._a(entityPlayer.field_71071_by);
        int n = 1;
        ArrayList<ieta> arrayList = entityDriveable.getDriveableType().getItemsRequired(driveablePart, entityDriveable.getDriveableData().engine);
        for (ieta ieta2 : arrayList) {
            int n2 = 0;
            for (int i = 0; i < rojd2.func_70302_i_(); ++i) {
                ieta ieta3 = rojd2.func_70301_a(i);
                if (ieta3 == null || ieta3._d != ieta2._d || ieta3._j() != ieta2._j()) continue;
                int n3 = Math.min(ieta3._b, ieta2._b - n2);
                ieta3._b -= n3;
                if (ieta3._b <= 0) {
                    ieta3 = null;
                }
                rojd2.func_70299_a(i, ieta3);
                if ((n2 += n3) == ieta2._b) break;
            }
            if (n2 >= ieta2._b) continue;
            n = 0;
        }
        if (n != 0) {
            entityPlayer.field_71071_by._a(rojd2);
            driveablePart.health = Math.max(1, driveablePart.maxHealth);
            driveablePart.onFire = false;
            driveablePart.dead = false;
            entityDriveable.checkParts();
        }
    }

    public boolean isScreenOpen() {
        return false;
    }

    public boolean isKeyDown(int n) {
        return false;
    }

    public boolean keyDown(int n) {
        return false;
    }

    public void resetItemEquip() {
    }
}

