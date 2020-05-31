/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  dwms
 *  ieta
 *  ivrt
 *  jhvs
 *  ncpk
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  rord
 *  uyeb
 *  zfwe
 *  zwlp
 */
package co.uk.flansmods.client;

import co.uk.flansmods.client.GuiDriveableMenu;
import co.uk.flansmods.common.ContainerPlaneInventory;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.PilotGun;
import co.uk.flansmods.common.driveables.Seat;
import co.uk.flansmods.common.guns.GunType;
import java.util.ArrayList;
import net.minecraft.client.tuor;
import net.minecraft.entity.player.rojd;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiDriveableInventory
extends zwlp {
    private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/planeInventory.png");
    public ContainerPlaneInventory container;
    public rojd inventory;
    public cuqu world;
    public int scroll;
    public int numItems;
    public int maxScroll;
    public EntityDriveable driveable;
    public int screen;

    public GuiDriveableInventory(rojd rojd2, cuqu cuqu2, EntityDriveable entityDriveable, int n) {
        super((ivrt)new ContainerPlaneInventory(rojd2, cuqu2, entityDriveable, n));
        this.driveable = entityDriveable;
        this.inventory = rojd2;
        this.world = cuqu2;
        this.container = (ContainerPlaneInventory)this.field_74193_d;
        this.field_74195_c = 180;
        this.screen = n;
        this.maxScroll = this.container.maxScroll;
        this.numItems = this.container.numItems;
    }

    protected void func_74189_g(int n, int n2) {
        String string = " - Guns";
        if (this.screen == 1) {
            string = " - " + this.driveable.getBombInventoryName();
        }
        if (this.screen == 2) {
            string = " - Cargo";
        }
        this.field_73886_k._b(this.driveable.getDriveableType().name + string, 6, 6, 4210752);
        this.field_73886_k._b("Inventory", 8, this.field_74195_c - 96 + 2, 4210752);
        ncpk._c();
        GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
        if (this.screen == 0) {
            int n3;
            int n4 = 0;
            for (n3 = 0; n3 < this.driveable.getDriveableType().seats.length; ++n3) {
                if (n4 >= 3 + this.scroll || this.driveable.getDriveableType().seats[n3].gunType == null) continue;
                if (n4 >= this.scroll) {
                    this.field_73886_k._b(this.driveable.getDriveableType().seats[n3].gunName, 53, 29 + 19 * (n4 - this.scroll), 0);
                    this.drawStack(new ieta(this.driveable.getDriveableType().seats[n3].gunType.getItem()), 10, 25 + 19 * (n4 - this.scroll));
                }
                ++n4;
            }
            for (n3 = 0; n3 < this.driveable.getDriveableType().guns.size(); ++n3) {
                if (n4 >= 3 + this.scroll || this.driveable.getDriveableType().guns.get((int)n3).type == null) continue;
                if (n4 >= this.scroll) {
                    this.field_73886_k._b("Driver's gun " + (n3 + 1), 53, 29 + 19 * (n4 - this.scroll), 0);
                    this.drawStack(new ieta(this.driveable.getDriveableType().guns.get((int)n3).type.getItem()), 10, 25 + 19 * (n4 - this.scroll));
                }
                ++n4;
            }
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)32826);
        ncpk._a();
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2929);
    }

    private void drawStack(ieta ieta2, int n, int n2) {
        zwlp.field_74196_a._a(this.field_73886_k, this.field_73882_e._f, ieta2, n, n2);
        zwlp.field_74196_a._c(this.field_73886_k, this.field_73882_e._f, ieta2, n, n2);
    }

    private static String getGunSlotName(int n) {
        switch (n) {
            case 0: {
                return "Left Nose Gun";
            }
            case 1: {
                return "Right Nose Gun";
            }
            case 2: {
                return "Left Wing Gun";
            }
            case 3: {
                return "Right Wing Gun";
            }
            case 4: {
                return "Tail Gun";
            }
            case 5: {
                return "Left Bay Gun";
            }
            case 6: {
                return "Right Bay Gun";
            }
            case 7: {
                return "Dorsal Gun";
            }
        }
        return "Not a Gun";
    }

    protected void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.field_73882_e._f._a(texture);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        switch (this.screen) {
            case 0: {
                for (int i = 0; i < (this.numItems > 3 ? 3 : this.numItems); ++i) {
                    this.func_73729_b(n3 + 9, n4 + 24 + 19 * i, 176, 0, 37, 18);
                }
                break;
            }
            case 1: 
            case 2: {
                int n5 = (this.numItems + 7) / 8;
                for (int i = 0; i < (n5 > 3 ? 3 : n5); ++i) {
                    this.func_73729_b(n3 + 9, n4 + 24 + 19 * i, 7, 97, 18 * ((i + this.scroll + 1) * 8 <= this.numItems ? 8 : this.numItems % 8), 18);
                }
                break;
            }
        }
        if (this.scroll == 0) {
            this.func_73729_b(n3 + 161, n4 + 41, 176, 18, 10, 10);
        }
        if (this.scroll == this.maxScroll) {
            this.func_73729_b(n3 + 161, n4 + 53, 176, 28, 10, 10);
        }
    }

    protected void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        int n4 = n - (this.field_73880_f - this.field_74194_b) / 2;
        int n5 = n2 - (this.field_73881_g - this.field_74195_c) / 2;
        if (this.scroll > 0 && n4 > 161 && n4 < 171 && n5 > 41 && n5 < 51) {
            --this.scroll;
            this.container.updateScroll(this.scroll);
        }
        if (this.scroll < this.maxScroll && n4 > 161 && n4 < 171 && n5 > 53 && n5 < 63) {
            ++this.scroll;
            this.container.updateScroll(this.scroll);
        }
        if (n4 > 161 && n4 < 171 && n5 > 5 && n5 < 15) {
            this.field_73882_e._a((dwms)new GuiDriveableMenu(this.inventory, this.world, this.driveable));
        }
    }

    public boolean func_73868_f() {
        return false;
    }
}

