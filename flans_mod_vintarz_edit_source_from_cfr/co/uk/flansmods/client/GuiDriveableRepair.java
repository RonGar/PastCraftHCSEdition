/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  dwms
 *  gowi
 *  ieta
 *  jhvs
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  rord
 *  tdvs
 *  uyeb
 *  uyla
 *  zfwe
 */
package co.uk.flansmods.client;

import co.uk.flansmods.client.GuiDriveableMenu;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.PartType;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiDriveableRepair
extends dwms {
    private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/repair.png");
    private EntityPlayer driver;
    private EntityDriveable driving;
    private ArrayList partsToDraw = new ArrayList();
    private static uyeb itemRenderer = new uyeb();
    private int guiOriginX;
    private int guiOriginY;

    public GuiDriveableRepair(EntityPlayer entityPlayer) {
        this.driver = entityPlayer;
        this.driving = ((EntitySeat)entityPlayer.field_70154_o).driveable;
        for (DriveablePart driveablePart : this.driving.getDriveableData().parts.values()) {
            if (driveablePart.maxHealth <= 0 || driveablePart.type == EnumDriveablePart.leftTrack || driveablePart.type == EnumDriveablePart.rightTrack) continue;
            this.partsToDraw.add(driveablePart);
        }
    }

    public void func_73866_w_() {
        super.func_73866_w_();
        for (int i = 0; i < this.partsToDraw.size(); ++i) {
            this.field_73887_h.add(new tdvs(i, 0, 0, 55, 20, "Repair"));
        }
    }

    protected void func_73875_a(tdvs tdvs2) {
        FlansMod.proxy.repairDriveable(this.driver, this.driving, (DriveablePart)this.partsToDraw.get(tdvs2.field_73741_f));
    }

    private void updateButtons() {
        int n = 43;
        for (int i = 0; i < this.partsToDraw.size(); ++i) {
            DriveablePart driveablePart = (DriveablePart)this.partsToDraw.get(i);
            tdvs tdvs2 = (tdvs)this.field_73887_h.get(i);
            tdvs2.field_73746_c = this.guiOriginX + 9;
            tdvs2.field_73743_d = driveablePart.health < driveablePart.maxHealth ? this.guiOriginY + n : -1000;
            n += driveablePart.health < driveablePart.maxHealth ? 40 : 20;
        }
    }

    public void func_73863_a(int n, int n2, float f) {
        int n3 = 31;
        for (DriveablePart driveablePart : this.partsToDraw) {
            n3 += driveablePart.health < driveablePart.maxHealth ? 40 : 20;
        }
        this.updateButtons();
        gowi gowi2 = new gowi(this.field_73882_e._K, this.field_73882_e._l, this.field_73882_e._m);
        int n4 = gowi2.func_78326_a();
        int n5 = gowi2.func_78328_b();
        this.func_73873_v_();
        GL11.glEnable((int)3042);
        this.field_73882_e._f._a(texture);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.guiOriginX = n4 / 2 - 101;
        this.guiOriginY = n5 / 2 - n3 / 2;
        this.func_73729_b(this.guiOriginX, this.guiOriginY, 0, 0, 202, 23);
        this.func_73729_b(this.guiOriginX, this.guiOriginY + n3 - 8, 0, 65, 202, 8);
        this.func_73731_b(this.field_73886_k, this.driving.getDriveableType().name + " - Repair", this.guiOriginX + 7, this.guiOriginY + 7, 16777215);
        int n6 = 23;
        for (DriveablePart driveablePart : this.partsToDraw) {
            boolean bl = driveablePart.health < driveablePart.maxHealth;
            this.field_73882_e._f._a(texture);
            this.func_73729_b(this.guiOriginX, this.guiOriginY + n6, 0, 24, 202, bl ? 40 : 20);
            float f2 = (float)driveablePart.health / (float)driveablePart.maxHealth;
            GL11.glColor3f((float)(1.0f - f2), (float)f2, (float)0.0f);
            this.func_73729_b(this.guiOriginX + 121, this.guiOriginY + n6 + 2, 0, 73, (int)(70.0f * f2), 16);
            this.func_73731_b(this.field_73886_k, driveablePart.type.getName(), this.guiOriginX + 10, this.guiOriginY + n6 + 6, 16777215);
            this.func_73732_a(this.field_73886_k, (int)(f2 * 100.0f) + "%", this.guiOriginX + 158, this.guiOriginY + n6 + 6, 16777215);
            if (bl) {
                rojd rojd2 = new rojd(null);
                rojd2._a(this.driver.field_71071_by);
                ArrayList<ieta> arrayList = this.driving.getDriveableType().getItemsRequired(driveablePart, this.driving.getDriveableData().engine);
                for (int i = 0; i < 7; ++i) {
                    int n7 = i + FlansMod.ticker / 60 % Math.max(1, arrayList.size() - 6);
                    if (n7 >= arrayList.size()) continue;
                    ieta ieta2 = arrayList.get(n7);
                    int n8 = 0;
                    for (int j = 0; j < rojd2.func_70302_i_(); ++j) {
                        ieta ieta3 = rojd2.func_70301_a(j);
                        if (ieta3 == null || ieta3._d != ieta2._d || ieta3._j() != ieta2._j()) continue;
                        int n9 = Math.min(ieta3._b, ieta2._b - n8);
                        ieta3._b -= n9;
                        if (ieta3._b <= 0) {
                            ieta3 = null;
                        }
                        rojd2.func_70299_a(j, ieta3);
                        if ((n8 += n9) == ieta2._b) break;
                    }
                    if (n8 < ieta2._b) {
                        this.field_73882_e._f._a(texture);
                        this.func_73729_b(this.guiOriginX + 67 + 18 * i, this.guiOriginY + n6 + 22, 202, 0, 16, 16);
                    }
                    this.drawSlotInventory(arrayList.get(n7), this.guiOriginX + 67 + 18 * i, this.guiOriginY + n6 + 22);
                }
            }
            n6 += bl ? 40 : 20;
        }
        super.func_73863_a(n, n2, f);
    }

    protected void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        int n4 = n - this.guiOriginX;
        int n5 = n2 - this.guiOriginY;
        if (n4 > 185 && n4 < 195 && n5 > 5 && n5 < 15) {
            this.field_73882_e._a((dwms)new GuiDriveableMenu(this.driver.field_71071_by, this.driver.field_70170_p, this.driving));
        }
    }

    private void drawSlotInventory(ieta ieta2, int n, int n2) {
        if (ieta2 != null && ieta2._d != 0 && ieta2._a() != null) {
            itemRenderer._a(this.field_73886_k, this.field_73882_e._f, ieta2, n, n2);
            itemRenderer._c(this.field_73886_k, this.field_73882_e._f, ieta2, n, n2);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
        }
    }

    public boolean func_73868_f() {
        return false;
    }
}

