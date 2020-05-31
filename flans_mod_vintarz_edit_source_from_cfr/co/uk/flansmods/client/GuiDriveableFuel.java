/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ctpu
 *  cuqu
 *  dwms
 *  ivrt
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  rord
 *  scko
 *  zfwe
 *  zwlp
 */
package co.uk.flansmods.client;

import co.uk.flansmods.client.GuiDriveableMenu;
import co.uk.flansmods.common.ContainerPlaneMenu;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import net.minecraft.client.tuor;
import net.minecraft.entity.player.rojd;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiDriveableFuel
extends zwlp {
    private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/planeFuel.png");
    public cuqu world;
    public rojd inventory;
    public EntityDriveable plane;
    private int anim = 0;
    private long lastTime;

    public GuiDriveableFuel(rojd rojd2, cuqu cuqu2, EntityDriveable entityDriveable) {
        super((ivrt)new ContainerPlaneMenu(rojd2, cuqu2, true, entityDriveable));
        this.plane = entityDriveable;
        this.field_74195_c = 161;
        this.world = cuqu2;
        this.inventory = rojd2;
    }

    protected void func_74189_g(int n, int n2) {
        this.field_73886_k._b(this.plane.getDriveableType().name + " - Fuel", 6, 6, 4210752);
        this.field_73886_k._b("Inventory", 8, this.field_74195_c - 96 + 2, 4210752);
    }

    protected void func_74185_a(float f, int n, int n2) {
        long l = this.field_73882_e._p.func_72912_H()._g();
        if (l > this.lastTime) {
            this.lastTime = l;
            if (l % 5L == 0L) {
                ++this.anim;
            }
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.field_73882_e._f._a(texture);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        int n5 = this.plane.getDriveableType().fuelTankSize;
        float f2 = this.plane.driveableData.fuelInTank;
        if (this.plane.fuelling) {
            this.func_73729_b(n3 + 15, n4 + 44, 176 + 15 * (this.anim % 4), 0, 15, 16);
        }
        if (f2 < (float)(n5 / 8) && this.anim % 4 > 1) {
            this.func_73729_b(n3 + 16, n4 + 25, 176, 16, 6, 6);
        }
        if (f2 > 0.0f) {
            this.func_73729_b(n3 + 26, n4 + 21, 0, 161, (int)(129.0f * f2 / (float)n5), 15);
        }
    }

    protected void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        int n4 = n - (this.field_73880_f - this.field_74194_b) / 2;
        int n5 = n2 - (this.field_73881_g - this.field_74195_c) / 2;
        if (n4 > 161 && n4 < 171 && n5 > 5 && n5 < 15) {
            this.field_73882_e._a((dwms)new GuiDriveableMenu(this.inventory, this.world, this.plane));
        }
    }
}

