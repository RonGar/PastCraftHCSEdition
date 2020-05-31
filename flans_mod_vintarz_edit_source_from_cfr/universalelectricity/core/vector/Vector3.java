/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  dxti
 *  hsus
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.idol
 *  net.minecraft.util.idqh
 *  net.minecraft.util.rojd
 *  net.minecraft.util.samw
 *  net.minecraftforge.common.tuor
 *  ogpr
 */
package universalelectricity.core.vector;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.idol;
import net.minecraft.util.idqh;
import net.minecraft.util.rojd;
import net.minecraft.util.samw;
import net.minecraftforge.common.tuor;
import universalelectricity.core.vector.Vector2;

public class Vector3
implements Cloneable {
    public double x;
    public double y;
    public double z;

    public Vector3(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public Vector3() {
        this(0.0, 0.0, 0.0);
    }

    public Vector3(Vector3 vector3) {
        this(vector3.x, vector3.y, vector3.z);
    }

    public Vector3(double d) {
        this(d, d, d);
    }

    public Vector3(Entity entity) {
        this(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
    }

    public Vector3(ogpr ogpr2) {
        this(ogpr2.field_70329_l, ogpr2.field_70330_m, ogpr2.field_70327_n);
    }

    public Vector3(samw samw2) {
        this(samw2._c, samw2._d, samw2._e);
    }

    public Vector3(idqh idqh2) {
        this(idqh2._b, idqh2._c, idqh2._d);
    }

    public Vector3(idol idol2) {
        this(idol2._a, idol2._b, idol2._c);
    }

    public Vector3(tuor tuor2) {
        this(tuor2.offsetX, tuor2.offsetY, tuor2.offsetZ);
    }

    public Vector3(hsus hsus2) {
        this(hsus2._i("x"), hsus2._i("y"), hsus2._i("z"));
    }

    public Vector3(float f, float f2) {
        this(Math.cos(Math.toRadians(f + 90.0f)), Math.sin(Math.toRadians(-f2)), Math.sin(Math.toRadians(f + 90.0f)));
    }

    public int intX() {
        return (int)Math.floor(this.x);
    }

    public int intY() {
        return (int)Math.floor(this.y);
    }

    public int intZ() {
        return (int)Math.floor(this.z);
    }

    public float floatX() {
        return (float)this.x;
    }

    public float floatY() {
        return (float)this.y;
    }

    public float floatZ() {
        return (float)this.z;
    }

    public Vector3 clone() {
        return new Vector3(this);
    }

    public int getBlockID(dxti dxti2) {
        return dxti2.func_72798_a(this.intX(), this.intY(), this.intZ());
    }

    public int getBlockMetadata(dxti dxti2) {
        return dxti2.func_72805_g(this.intX(), this.intY(), this.intZ());
    }

    public ogpr getTileEntity(dxti dxti2) {
        return dxti2.func_72796_p(this.intX(), this.intY(), this.intZ());
    }

    public boolean setBlock(cuqu cuqu2, int n, int n2, int n3) {
        return cuqu2.func_72832_d(this.intX(), this.intY(), this.intZ(), n, n2, n3);
    }

    public boolean setBlock(cuqu cuqu2, int n, int n2) {
        return this.setBlock(cuqu2, n, n2, 3);
    }

    public boolean setBlock(cuqu cuqu2, int n) {
        return this.setBlock(cuqu2, n, 0);
    }

    public Vector2 toVector2() {
        return new Vector2(this.x, this.z);
    }

    public samw toVec3() {
        return samw._a((double)this.x, (double)this.y, (double)this.z);
    }

    public tuor toForgeDirection() {
        for (tuor tuor2 : tuor.VALID_DIRECTIONS) {
            if (this.x != (double)tuor2.offsetX || this.y != (double)tuor2.offsetY || this.z != (double)tuor2.offsetZ) continue;
            return tuor2;
        }
        return tuor.UNKNOWN;
    }

    public double getMagnitude() {
        return Math.sqrt(this.getMagnitudeSquared());
    }

    public double getMagnitudeSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public Vector3 normalize() {
        double d = this.getMagnitude();
        if (d != 0.0) {
            this.scale(1.0 / d);
        }
        return this;
    }

    public static double distance(Vector3 vector3, Vector3 vector32) {
        return vector3.distance(vector32);
    }

    @Deprecated
    public double distanceTo(Vector3 vector3) {
        return this.distance(vector3);
    }

    public double distance(Vector3 vector3) {
        Vector3 vector32 = this.clone().difference(vector3);
        return vector32.getMagnitude();
    }

    public Vector3 invert() {
        this.scale(-1.0);
        return this;
    }

    public Vector3 translate(Vector3 vector3) {
        this.x += vector3.x;
        this.y += vector3.y;
        this.z += vector3.z;
        return this;
    }

    public Vector3 translate(double d) {
        this.x += d;
        this.y += d;
        this.z += d;
        return this;
    }

    public static Vector3 translate(Vector3 vector3, Vector3 vector32) {
        vector3.x += vector32.x;
        vector3.y += vector32.y;
        vector3.z += vector32.z;
        return vector3;
    }

    public static Vector3 translate(Vector3 vector3, double d) {
        vector3.x += d;
        vector3.y += d;
        vector3.z += d;
        return vector3;
    }

    @Deprecated
    public Vector3 add(Vector3 vector3) {
        return this.translate(vector3);
    }

    @Deprecated
    public Vector3 add(double d) {
        return this.translate(d);
    }

    @Deprecated
    public Vector3 subtract(Vector3 vector3) {
        return this.translate(vector3.clone().invert());
    }

    @Deprecated
    public Vector3 subtract(double d) {
        return this.translate(-d);
    }

    public Vector3 difference(Vector3 vector3) {
        return this.translate(vector3.clone().invert());
    }

    public Vector3 difference(double d) {
        return this.translate(-d);
    }

    public Vector3 scale(double d) {
        this.x *= d;
        this.y *= d;
        this.z *= d;
        return this;
    }

    public Vector3 scale(Vector3 vector3) {
        this.x *= vector3.x;
        this.y *= vector3.y;
        this.z *= vector3.z;
        return this;
    }

    public static Vector3 scale(Vector3 vector3, double d) {
        return vector3.scale(d);
    }

    public static Vector3 scale(Vector3 vector3, Vector3 vector32) {
        return vector3.scale(vector32);
    }

    @Deprecated
    public Vector3 multiply(double d) {
        return this.scale(d);
    }

    @Deprecated
    public Vector3 multiply(Vector3 vector3) {
        return this.scale(vector3);
    }

    @Deprecated
    public static Vector3 subtract(Vector3 vector3, Vector3 vector32) {
        return new Vector3(vector3.x - vector32.x, vector3.y - vector32.y, vector3.z - vector32.z);
    }

    @Deprecated
    public static Vector3 add(Vector3 vector3, Vector3 vector32) {
        return new Vector3(vector3.x + vector32.x, vector3.y + vector32.y, vector3.z + vector32.z);
    }

    @Deprecated
    public static Vector3 add(Vector3 vector3, double d) {
        return new Vector3(vector3.x + d, vector3.y + d, vector3.z + d);
    }

    @Deprecated
    public static Vector3 multiply(Vector3 vector3, Vector3 vector32) {
        return new Vector3(vector3.x * vector32.x, vector3.y * vector32.y, vector3.z * vector32.z);
    }

    @Deprecated
    public static Vector3 multiply(Vector3 vector3, double d) {
        return new Vector3(vector3.x * d, vector3.y * d, vector3.z * d);
    }

    public Vector3 round() {
        return new Vector3(Math.round(this.x), Math.round(this.y), Math.round(this.z));
    }

    public Vector3 ceil() {
        return new Vector3(Math.ceil(this.x), Math.ceil(this.y), Math.ceil(this.z));
    }

    public Vector3 floor() {
        return new Vector3(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
    }

    public Vector3 toRound() {
        this.x = Math.round(this.x);
        this.y = Math.round(this.y);
        this.z = Math.round(this.z);
        return this;
    }

    public Vector3 toCeil() {
        this.x = Math.ceil(this.x);
        this.y = Math.ceil(this.y);
        this.z = Math.ceil(this.z);
        return this;
    }

    public Vector3 toFloor() {
        this.x = Math.floor(this.x);
        this.y = Math.floor(this.y);
        this.z = Math.floor(this.z);
        return this;
    }

    public List<Entity> getEntitiesWithin(cuqu cuqu2, Class<? extends Entity> class_) {
        return cuqu2.func_72872_a(class_, rojd.func_72330_a((double)this.intX(), (double)this.intY(), (double)this.intZ(), (double)(this.intX() + 1), (double)(this.intY() + 1), (double)(this.intZ() + 1)));
    }

    public Vector3 modifyPositionFromSide(tuor tuor2, double d) {
        return this.translate(new Vector3(tuor2).scale(d));
    }

    public Vector3 modifyPositionFromSide(tuor tuor2) {
        this.modifyPositionFromSide(tuor2, 1.0);
        return this;
    }

    public Vector3 toCrossProduct(Vector3 vector3) {
        double d = this.y * vector3.z - this.z * vector3.y;
        double d2 = this.z * vector3.x - this.x * vector3.z;
        double d3 = this.x * vector3.y - this.y * vector3.x;
        this.x = d;
        this.y = d2;
        this.z = d3;
        return this;
    }

    public Vector3 crossProduct(Vector3 vector3) {
        return this.clone().toCrossProduct(vector3);
    }

    public Vector3 xCrossProduct() {
        return new Vector3(0.0, this.z, -this.y);
    }

    public Vector3 zCrossProduct() {
        return new Vector3(-this.y, this.x, 0.0);
    }

    public double dotProduct(Vector3 vector3) {
        return this.x * vector3.x + this.y * vector3.y + this.z * vector3.z;
    }

    public Vector3 getPerpendicular() {
        if (this.z == 0.0) {
            return this.zCrossProduct();
        }
        return this.xCrossProduct();
    }

    public boolean isZero() {
        return this.x == 0.0 && this.y == 0.0 && this.z == 0.0;
    }

    public Vector3 rotate(float f, Vector3 vector3) {
        return Vector3.translateMatrix(Vector3.getRotationMatrix(f, vector3), this.clone());
    }

    public double[] getRotationMatrix(float f) {
        double[] arrd = new double[16];
        Vector3 vector3 = this.clone().normalize();
        double d = vector3.x;
        double d2 = vector3.y;
        double d3 = vector3.z;
        f = (float)((double)f * 0.0174532925);
        float f2 = (float)Math.cos(f);
        float f3 = 1.0f - f2;
        float f4 = (float)Math.sin(f);
        arrd[0] = d * d * (double)f3 + (double)f2;
        arrd[1] = d2 * d * (double)f3 + d3 * (double)f4;
        arrd[2] = d * d3 * (double)f3 - d2 * (double)f4;
        arrd[4] = d * d2 * (double)f3 - d3 * (double)f4;
        arrd[5] = d2 * d2 * (double)f3 + (double)f2;
        arrd[6] = d2 * d3 * (double)f3 + d * (double)f4;
        arrd[8] = d * d3 * (double)f3 + d2 * (double)f4;
        arrd[9] = d2 * d3 * (double)f3 - d * (double)f4;
        arrd[10] = d3 * d3 * (double)f3 + (double)f2;
        arrd[15] = 1.0;
        return arrd;
    }

    public static Vector3 translateMatrix(double[] arrd, Vector3 vector3) {
        double d = vector3.x * arrd[0] + vector3.y * arrd[1] + vector3.z * arrd[2] + arrd[3];
        double d2 = vector3.x * arrd[4] + vector3.y * arrd[5] + vector3.z * arrd[6] + arrd[7];
        double d3 = vector3.x * arrd[8] + vector3.y * arrd[9] + vector3.z * arrd[10] + arrd[11];
        vector3.x = d;
        vector3.y = d2;
        vector3.z = d3;
        return vector3;
    }

    public static double[] getRotationMatrix(float f, Vector3 vector3) {
        return vector3.getRotationMatrix(f);
    }

    public void rotate(double d, double d2, double d3) {
        double d4 = Math.toRadians(d);
        double d5 = Math.toRadians(d2);
        double d6 = Math.toRadians(d3);
        double d7 = this.x;
        double d8 = this.y;
        double d9 = this.z;
        this.x = d7 * Math.cos(d4) * Math.cos(d5) + d9 * (Math.cos(d4) * Math.sin(d5) * Math.sin(d6) - Math.sin(d4) * Math.cos(d6)) + d8 * (Math.cos(d4) * Math.sin(d5) * Math.cos(d6) + Math.sin(d4) * Math.sin(d6));
        this.z = d7 * Math.sin(d4) * Math.cos(d5) + d9 * (Math.sin(d4) * Math.sin(d5) * Math.sin(d6) + Math.cos(d4) * Math.cos(d6)) + d8 * (Math.sin(d4) * Math.sin(d5) * Math.cos(d6) - Math.cos(d4) * Math.sin(d6));
        this.y = -d7 * Math.sin(d5) + d9 * Math.cos(d5) * Math.sin(d6) + d8 * Math.cos(d5) * Math.cos(d6);
    }

    public void rotate(double d, double d2) {
        this.rotate(d, d2, 0.0);
    }

    public void rotate(double d) {
        double d2 = Math.toRadians(d);
        double d3 = this.x;
        double d4 = this.z;
        if (d != 0.0) {
            this.x = d3 * Math.cos(d2) - d4 * Math.sin(d2);
            this.z = d3 * Math.sin(d2) + d4 * Math.cos(d2);
        }
    }

    public static Vector3 getDeltaPositionFromRotation(float f, float f2) {
        return new Vector3(f, f2);
    }

    public double getAngle(Vector3 vector3) {
        return Vector3.anglePreNorm(this.clone().normalize(), vector3.clone().normalize());
    }

    public static double getAngle(Vector3 vector3, Vector3 vector32) {
        return vector3.getAngle(vector32);
    }

    public double anglePreNorm(Vector3 vector3) {
        return Math.acos(this.dotProduct(vector3));
    }

    public static double anglePreNorm(Vector3 vector3, Vector3 vector32) {
        return Math.acos(vector3.clone().dotProduct(vector32));
    }

    @Deprecated
    public static Vector3 readFromNBT(hsus hsus2) {
        return new Vector3(hsus2);
    }

    public hsus writeToNBT(hsus hsus2) {
        hsus2._a("x", this.x);
        hsus2._a("y", this.y);
        hsus2._a("z", this.z);
        return hsus2;
    }

    public static Vector3 UP() {
        return new Vector3(0.0, 1.0, 0.0);
    }

    public static Vector3 DOWN() {
        return new Vector3(0.0, -1.0, 0.0);
    }

    public static Vector3 NORTH() {
        return new Vector3(0.0, 0.0, -1.0);
    }

    public static Vector3 SOUTH() {
        return new Vector3(0.0, 0.0, 1.0);
    }

    public static Vector3 WEST() {
        return new Vector3(-1.0, 0.0, 0.0);
    }

    public static Vector3 EAST() {
        return new Vector3(1.0, 0.0, 0.0);
    }

    public idqh rayTrace(cuqu cuqu2, float f, float f2, boolean bl, double d) {
        idqh idqh2 = this.rayTraceBlocks(cuqu2, f, f2, bl, d);
        idqh idqh3 = this.rayTraceEntities(cuqu2, f, f2, bl, d);
        if (idqh2 == null) {
            return idqh3;
        }
        if (idqh3 == null) {
            return idqh2;
        }
        double d2 = this.distance(new Vector3(idqh2._f));
        double d3 = this.distance(new Vector3(idqh3._f));
        if (d3 < d2) {
            return idqh3;
        }
        return idqh2;
    }

    public idqh rayTraceBlocks(cuqu cuqu2, float f, float f2, boolean bl, double d) {
        Vector3 vector3 = Vector3.getDeltaPositionFromRotation(f, f2);
        Vector3 vector32 = Vector3.translate(this, Vector3.scale(vector3, d));
        return cuqu2.func_72831_a(this.toVec3(), vector32.toVec3(), bl, !bl);
    }

    @Deprecated
    public idqh rayTraceEntities(cuqu cuqu2, float f, float f2, boolean bl, double d) {
        return this.rayTraceEntities(cuqu2, f, f2, d);
    }

    public idqh rayTraceEntities(cuqu cuqu2, float f, float f2, double d) {
        return this.rayTraceEntities(cuqu2, Vector3.getDeltaPositionFromRotation(f, f2).scale(d));
    }

    public idqh rayTraceEntities(cuqu cuqu2, Vector3 vector3) {
        idqh idqh2 = null;
        samw samw2 = this.toVec3();
        samw samw3 = vector3.clone().difference(this).normalize().toVec3();
        double d = this.distance(vector3);
        samw samw4 = samw._a((double)(samw2._c + samw3._c * d), (double)(samw2._d + samw3._d * d), (double)(samw2._e + samw3._e * d));
        double d2 = 1.1 * d;
        rojd rojd2 = rojd.func_72332_a()._a(-d2, -d2, -d2, d2, d2, d2).func_72317_d(this.x, this.y, this.z);
        List list = cuqu2.func_72839_b(null, rojd2);
        double d3 = d;
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (Entity entity : list) {
            float f;
            idqh idqh3;
            rojd rojd3;
            if (entity == null || !entity.func_70067_L() || entity.field_70121_D == null || (idqh3 = (rojd3 = entity.field_70121_D.func_72314_b((double)(f = entity.func_70111_Y()), (double)f, (double)f)).func_72327_a(samw2, samw4)) == null) continue;
            if (rojd3.func_72318_a(samw2)) {
                if (!(0.0 < d3) && d3 != 0.0) continue;
                idqh2 = new idqh(entity);
                idqh2._f = idqh3._f;
                d3 = 0.0;
                continue;
            }
            double d4 = samw2._d(idqh3._f);
            if (!(d4 < d3) && d3 != 0.0) continue;
            idqh2 = new idqh(entity);
            idqh2._f = idqh3._f;
            d3 = d4;
        }
        return idqh2;
    }

    public int hashCode() {
        return ("X:" + this.x + "Y:" + this.y + "Z:" + this.z).hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof Vector3) {
            Vector3 vector3 = (Vector3)object;
            return this.x == vector3.x && this.y == vector3.y && this.z == vector3.z;
        }
        return false;
    }

    public String toString() {
        return "Vector3 [" + this.x + "," + this.y + "," + this.z + "]";
    }
}

