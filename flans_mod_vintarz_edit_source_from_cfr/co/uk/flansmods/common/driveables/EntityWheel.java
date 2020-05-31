/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  bain
 *  com.google.common.io.ByteArrayDataInput
 *  com.google.common.io.ByteArrayDataOutput
 *  cpw.mods.fml.common.registry.IEntityAdditionalSpawnData
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  hcsmod.HCS
 *  hcsmod.entity.EntityHouseCommon
 *  hsus
 *  iemm
 *  kjsv
 *  mquq
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.pzgm
 *  net.minecraft.util.rojd
 *  wnud
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.common.RotatedAxes;
import co.uk.flansmods.common.driveables.DriveablePosition;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.vector.Vector3f;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.HCS;
import hcsmod.entity.EntityHouseCommon;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.dwbg;
import net.minecraft.util.pzgm;
import net.minecraft.util.rojd;

public class EntityWheel
extends Entity
implements IEntityAdditionalSpawnData {
    public EntityDriveable vehicle;
    public int ID;
    @SideOnly(value=Side.CLIENT)
    public boolean foundVehicle;
    private int vehicleID;

    public EntityWheel(cuqu cuqu2) {
        super(cuqu2);
        this.func_70105_a(2.0f, 2.0f);
        this.field_70138_W = 1.0f;
    }

    public void func_85030_a(String string, float f, float f2) {
    }

    public boolean func_70039_c(hsus hsus2) {
        return false;
    }

    public EntityWheel(cuqu cuqu2, EntityDriveable entityDriveable, int n) {
        this(cuqu2);
        this.vehicle = entityDriveable;
        this.vehicleID = entityDriveable.field_70157_k;
        this.ID = n;
        this.initPosition();
    }

    public void initPosition() {
        Vector3f vector3f = this.vehicle.axes.findLocalVectorGlobally(this.vehicle.getDriveableType().wheelPositions[this.ID].position);
        this.func_70107_b(this.vehicle.field_70165_t + (double)vector3f.x, this.vehicle.field_70163_u + (double)vector3f.y, this.vehicle.field_70161_v + (double)vector3f.z);
        this.field_70138_W = this.vehicle.getDriveableType().wheelStepHeight;
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
    }

    protected void func_70069_a(float f) {
        if (this.vehicle == null || f <= 0.0f) {
            return;
        }
    }

    protected void func_70088_a() {
    }

    protected void func_70037_a(hsus hsus2) {
        this.func_70106_y();
    }

    protected void func_70014_b(hsus hsus2) {
    }

    public void func_70071_h_() {
        this.func_70066_B();
        if (this.field_70170_p.field_72995_K && !this.foundVehicle) {
            this.vehicle = (EntityDriveable)this.field_70170_p.func_73045_a(this.vehicleID);
            if (this.vehicle == null) {
                return;
            }
            this.foundVehicle = true;
            this.vehicle.wheels[this.ID] = this;
        }
        if (this.vehicle == null) {
            return;
        }
        if (!this.field_70175_ag) {
            this.field_70170_p.func_72838_d((Entity)this);
        }
        if (this.vehicle.field_70128_L) {
            this.func_70106_y();
        }
    }

    private static List<rojd> getCollidingBoundingBoxes(Entity entity, rojd rojd2) {
        List list = entity.field_70170_p.func_72840_a(rojd2);
        for (Object e : entity.field_70170_p.func_94576_a(entity, rojd2.func_72314_b(2.0, 2.0, 2.0), new mquq(){

            public boolean func_82704_a(Entity entity) {
                return entity instanceof EntityHouseCommon;
            }
        })) {
            rojd rojd3 = ((Entity)e).func_70046_E();
            if (rojd3 != null && rojd3.func_72326_a(rojd2)) {
                list.add(rojd3);
            }
            if ((rojd3 = entity.func_70114_g((Entity)e)) == null || !rojd3.func_72326_a(rojd2)) continue;
            list.add(rojd3);
        }
        list.add(HCS.maxX);
        list.add(HCS.minX);
        list.add(HCS.maxZ);
        list.add(HCS.minZ);
        return list;
    }

    public void func_70091_d(double d, double d2, double d3) {
        if (this.field_70145_X) {
            this.field_70121_D.func_72317_d(d, d2, d3);
            this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0;
            this.field_70163_u = this.field_70121_D.field_72338_b + (double)this.field_70129_M - (double)this.field_70139_V;
            this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0;
        } else {
            int n;
            double d4;
            double d5;
            int n2;
            double d6;
            int n3;
            this.field_70170_p.field_72984_F._a("move");
            this.field_70139_V *= 0.4f;
            double d7 = this.field_70165_t;
            double d8 = this.field_70163_u;
            double d9 = this.field_70161_v;
            if (this.field_70134_J) {
                this.field_70134_J = false;
                d *= 0.25;
                d2 *= 0.05000000074505806;
                d3 *= 0.25;
                this.field_70159_w = 0.0;
                this.field_70181_x = 0.0;
                this.field_70179_y = 0.0;
            }
            double d10 = d;
            double d11 = d2;
            double d12 = d3;
            rojd rojd2 = this.field_70121_D.func_72329_c();
            if (this.field_70122_E) {
                this.func_70093_af();
            }
            List<rojd> list = EntityWheel.getCollidingBoundingBoxes(this, this.field_70121_D.func_72321_a(d, d2, d3));
            for (n3 = 0; n3 < list.size(); ++n3) {
                d2 = list.get(n3).func_72323_b(this.field_70121_D, d2);
            }
            this.field_70121_D.func_72317_d(0.0, d2, 0.0);
            if (!this.field_70135_K && d11 != d2) {
                d3 = 0.0;
                d2 = 0.0;
                d = 0.0;
            }
            n3 = this.field_70122_E || d11 != d2 && d11 < 0.0 ? 1 : 0;
            for (n = 0; n < list.size(); ++n) {
                d = list.get(n).func_72316_a(this.field_70121_D, d);
            }
            this.field_70121_D.func_72317_d(d, 0.0, 0.0);
            if (!this.field_70135_K && d10 != d) {
                d3 = 0.0;
                d2 = 0.0;
                d = 0.0;
            }
            for (n = 0; n < list.size(); ++n) {
                d3 = list.get(n).func_72322_c(this.field_70121_D, d3);
            }
            this.field_70121_D.func_72317_d(0.0, 0.0, d3);
            if (!this.field_70135_K && d12 != d3) {
                d3 = 0.0;
                d2 = 0.0;
                d = 0.0;
            }
            if (this.field_70138_W > 0.0f && n3 != 0 && this.field_70139_V < 0.05f && (d10 != d || d12 != d3)) {
                d4 = d;
                d5 = d2;
                d6 = d3;
                d = d10;
                d2 = this.field_70138_W;
                d3 = d12;
                rojd rojd3 = this.field_70121_D.func_72329_c();
                this.field_70121_D.func_72328_c(rojd2);
                list = EntityWheel.getCollidingBoundingBoxes(this, this.field_70121_D.func_72321_a(d10, d2, d12));
                for (n2 = 0; n2 < list.size(); ++n2) {
                    d2 = list.get(n2).func_72323_b(this.field_70121_D, d2);
                }
                this.field_70121_D.func_72317_d(0.0, d2, 0.0);
                if (!this.field_70135_K && d11 != d2) {
                    d3 = 0.0;
                    d2 = 0.0;
                    d = 0.0;
                }
                for (n2 = 0; n2 < list.size(); ++n2) {
                    d = list.get(n2).func_72316_a(this.field_70121_D, d);
                }
                this.field_70121_D.func_72317_d(d, 0.0, 0.0);
                if (!this.field_70135_K && d10 != d) {
                    d3 = 0.0;
                    d2 = 0.0;
                    d = 0.0;
                }
                for (n2 = 0; n2 < list.size(); ++n2) {
                    d3 = list.get(n2).func_72322_c(this.field_70121_D, d3);
                }
                this.field_70121_D.func_72317_d(0.0, 0.0, d3);
                if (!this.field_70135_K && d12 != d3) {
                    d3 = 0.0;
                    d2 = 0.0;
                    d = 0.0;
                }
                if (!this.field_70135_K && d11 != d2) {
                    d3 = 0.0;
                    d2 = 0.0;
                    d = 0.0;
                } else {
                    d2 = -this.field_70138_W;
                    for (n2 = 0; n2 < list.size(); ++n2) {
                        d2 = list.get(n2).func_72323_b(this.field_70121_D, d2);
                    }
                    this.field_70121_D.func_72317_d(0.0, d2, 0.0);
                }
                if (d4 * d4 + d6 * d6 >= d * d + d3 * d3) {
                    d = d4;
                    d2 = d5;
                    d3 = d6;
                    this.field_70121_D.func_72328_c(rojd3);
                }
            }
            this.field_70170_p.field_72984_F._b();
            this.field_70170_p.field_72984_F._a("rest");
            this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0;
            this.field_70163_u = this.field_70121_D.field_72338_b + (double)this.field_70129_M - (double)this.field_70139_V;
            this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0;
            this.field_70123_F = d10 != d || d12 != d3;
            this.field_70124_G = d11 != d2;
            this.field_70122_E = d11 != d2 && d11 < 0.0;
            this.field_70132_H = this.field_70123_F || this.field_70124_G;
            this.func_70064_a(d2, this.field_70122_E);
            if (d10 != d) {
                this.field_70159_w = 0.0;
            }
            if (d11 != d2) {
                this.field_70181_x = 0.0;
            }
            if (d12 != d3) {
                this.field_70179_y = 0.0;
            }
            d4 = this.field_70165_t - d7;
            d5 = this.field_70163_u - d8;
            d6 = this.field_70161_v - d9;
            if (this.func_70041_e_() && this.field_70154_o == null) {
                int n4;
                int n5;
                int n6 = dwbg._c((double)this.field_70165_t);
                int n7 = this.field_70170_p.func_72798_a(n6, n2 = dwbg._c((double)(this.field_70163_u - 0.20000000298023224 - (double)this.field_70129_M)), n5 = dwbg._c((double)this.field_70161_v));
                if (n7 == 0 && ((n4 = this.field_70170_p.func_85175_e(n6, n2 - 1, n5)) == 11 || n4 == 32 || n4 == 21)) {
                    n7 = this.field_70170_p.func_72798_a(n6, n2 - 1, n5);
                }
                if (n7 != kjsv.field_72055_aF.field_71990_ca) {
                    d5 = 0.0;
                }
                this.field_70140_Q = (float)((double)this.field_70140_Q + (double)dwbg._a((double)(d4 * d4 + d6 * d6)) * 0.6);
                this.field_82151_R = (float)((double)this.field_82151_R + (double)dwbg._a((double)(d4 * d4 + d5 * d5 + d6 * d6)) * 0.6);
            }
            try {
                this.func_70017_D();
            }
            catch (Throwable throwable) {
                iemm iemm2 = iemm._a((Throwable)throwable, (String)"Checking entity tile collision");
                wnud wnud2 = iemm2._a("Entity being checked for collision");
                this.func_85029_a(wnud2);
                throw new pzgm(iemm2);
            }
            boolean bl = this.func_70026_G();
            if (this.field_70170_p.func_72978_e(this.field_70121_D.func_72331_e(0.001, 0.001, 0.001))) {
                this.func_70081_e(1);
                if (!bl) {
                    ++this.field_70151_c;
                    if (this.field_70151_c == 0) {
                        this.func_70015_d(8);
                    }
                }
            } else if (this.field_70151_c <= 0) {
                this.field_70151_c = -this.field_70174_ab;
            }
            if (bl && this.field_70151_c > 0) {
                this.func_85030_a("random.fizz", 0.7f, 1.6f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4f);
                this.field_70151_c = -this.field_70174_ab;
            }
            this.field_70170_p.field_72984_F._b();
        }
    }

    public double getSpeedXZ() {
        return Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
    }

    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
    }

    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeInt(this.vehicleID);
        byteArrayDataOutput.writeInt(this.ID);
    }

    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        this.vehicleID = byteArrayDataInput.readInt();
        this.ID = byteArrayDataInput.readInt();
        this.vehicle = (EntityDriveable)this.field_70170_p.func_73045_a(this.vehicleID);
        if (this.vehicle != null) {
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        }
    }

}

