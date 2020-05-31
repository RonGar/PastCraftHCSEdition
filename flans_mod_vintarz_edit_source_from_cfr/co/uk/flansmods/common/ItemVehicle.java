/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  hcsmod.cunches.IItemVehicle
 *  hsus
 *  ieta
 *  jhvs
 *  jinw
 *  maai
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.util.dfat
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.roij
 *  net.minecraft.util.samw
 *  qlze
 *  sbsi
 *  tekj
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.EnumType;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.PartType;
import co.uk.flansmods.common.driveables.CollisionBox;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.EntityVehicle;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.driveables.VehicleType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.cunches.IItemVehicle;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidl;
import net.minecraft.util.dfat;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.roij;
import net.minecraft.util.samw;

public class ItemVehicle
extends maai
implements IItemVehicle {
    public VehicleType type;

    public ItemVehicle(int n, VehicleType vehicleType) {
        super(n);
        this.field_77777_bU = 1;
        this.type = vehicleType;
        this.type.item = this;
        this.func_77637_a((tekj)FlansMod.tabFlanDriveables);
    }

    public boolean func_77651_p() {
        return true;
    }

    private hsus getTagCompound(ieta ieta2, cuqu cuqu2) {
        if (ieta2._e == null) {
            if (!cuqu2.field_72995_K) {
                ieta2._e = this.getOldTagCompound(ieta2, cuqu2);
            }
            if (ieta2._e == null) {
                ieta2._e = new hsus();
                ieta2._e._a("Type", this.type.shortName);
                ieta2._e._a("Engine", PartType.defaultEngines.get((Object)EnumType.vehicle).shortName);
            }
        }
        return ieta2._e;
    }

    private hsus getOldTagCompound(ieta ieta2, cuqu cuqu2) {
        try {
            File file = cuqu2.func_72860_G().func_75758_b("vehicle_" + ieta2._j());
            FileInputStream fileInputStream = new FileInputStream(file);
            hsus hsus2 = sbsi._a((InputStream)fileInputStream)._m("data");
            for (EnumDriveablePart enumDriveablePart : EnumDriveablePart.values()) {
                hsus2._a(enumDriveablePart.getShortName() + "_Health", this.type.health.get((Object)enumDriveablePart) == null ? 0 : ((CollisionBox)this.type.health.get((Object)enumDriveablePart)).health);
                hsus2._a(enumDriveablePart.getShortName() + "_Fire", false);
            }
            fileInputStream.close();
            return hsus2;
        }
        catch (IOException iOException) {
            FlansMod.log("Failed to read old vehicle file");
            iOException.printStackTrace();
            return null;
        }
    }

    public void func_77624_a(ieta ieta2, EntityPlayer entityPlayer, List list, boolean bl) {
        String string;
        PartType partType;
        hsus hsus2;
        if (this.type.description != null) {
            hsus2 = this.type.description.split("_");
            int n = ((hsus)hsus2).length;
            for (int i = 0; i < n; ++i) {
                hsus hsus3 = hsus2[i];
                list.add(hsus3);
            }
        }
        if ((partType = PartType.getPart(string = (hsus2 = this.getTagCompound(ieta2, entityPlayer.field_70170_p))._j("Engine"))) != null) {
            list.add(partType.name);
        }
    }

    public ieta func_77659_a(ieta ieta2, cuqu cuqu2, EntityPlayer entityPlayer) {
        samw samw2;
        float f = dwbg._b((float)(-entityPlayer.field_70177_z * 0.01745329f - 3.141593f));
        float f2 = dwbg._a((float)(-entityPlayer.field_70177_z * 0.01745329f - 3.141593f));
        float f3 = -dwbg._b((float)(-entityPlayer.field_70125_A * 0.01745329f));
        float f4 = dwbg._a((float)(-entityPlayer.field_70125_A * 0.01745329f));
        samw samw3 = samw._a((double)entityPlayer.field_70165_t, (double)(entityPlayer.field_70163_u + 1.62 - (double)entityPlayer.field_70129_M), (double)entityPlayer.field_70161_v);
        idqh idqh2 = cuqu2.func_72901_a(samw3, samw2 = samw3._c((double)(f2 * f3) * 5.0, (double)f4 * 5.0, (double)(f * f3) * 5.0), true);
        if (idqh2 == null) {
            return ieta2;
        }
        if (idqh2._a == dfat._a) {
            int n = idqh2._b;
            int n2 = idqh2._c;
            int n3 = idqh2._d;
            if (!cuqu2.field_72995_K) {
                cuqu2.func_72838_d((Entity)new EntityVehicle(cuqu2, (double)n + 0.5, (double)n2 + 2.5, (double)n3 + 0.5, entityPlayer, this.type, this.getData(ieta2, cuqu2)));
            }
            if (!entityPlayer.field_71075_bZ._d) {
                --ieta2._b;
            }
        }
        return ieta2;
    }

    public Entity spawnVehicle(cuqu cuqu2, double d, double d2, double d3, ieta ieta2) {
        EntityVehicle entityVehicle = new EntityVehicle(cuqu2, d, d2, d3, this.type, this.getData(ieta2, cuqu2));
        if (!cuqu2.field_72995_K) {
            cuqu2.func_72838_d((Entity)entityVehicle);
        }
        return entityVehicle;
    }

    public DriveableData getData(ieta ieta2, cuqu cuqu2) {
        return new DriveableData(this.getTagCompound(ieta2, cuqu2));
    }

    @SideOnly(value=Side.CLIENT)
    public int func_82790_a(ieta ieta2, int n) {
        return this.type.colour;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(qlze qlze2) {
        this.field_77791_bV = qlze2._a("FlansMod:" + this.type.iconPath);
    }

    public void func_77633_a(int n, tekj tekj2, List list) {
        ieta ieta2 = new ieta(n, 1, 0);
        hsus hsus2 = new hsus();
        try {
            hsus2._a("Type", this.type.shortName);
        }
        catch (Throwable throwable) {}
        if (PartType.defaultEngines.containsKey((Object)EnumType.vehicle)) {
            hsus2._a("Engine", PartType.defaultEngines.get((Object)EnumType.vehicle).shortName);
        }
        for (EnumDriveablePart enumDriveablePart : EnumDriveablePart.values()) {
            hsus2._a(enumDriveablePart.getShortName() + "_Health", this.type.health.get((Object)enumDriveablePart) == null ? 0 : ((CollisionBox)this.type.health.get((Object)enumDriveablePart)).health);
            hsus2._a(enumDriveablePart.getShortName() + "_Fire", false);
        }
        ieta2._e = hsus2;
        list.add(ieta2);
    }

    public boolean spawnAndSetDriver(EntityPlayer entityPlayer, ieta ieta2) {
        cuqu cuqu2 = entityPlayer.field_70170_p;
        if (!cuqu2.field_72995_K) {
            EntityVehicle entityVehicle;
            try {
                entityVehicle = new EntityVehicle(cuqu2, entityPlayer.field_70165_t, entityPlayer.field_70163_u + 2.5, entityPlayer.field_70161_v, entityPlayer, this.type, this.getData(ieta2, cuqu2));
            }
            catch (Throwable throwable) {
                return false;
            }
            cuqu2.func_72838_d((Entity)entityVehicle);
            entityVehicle.setDriver(entityPlayer);
        }
        return true;
    }
}

