/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  ieta
 *  ivrb
 *  ivrt
 *  kkuu
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.vintarz.SlotVehInv;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;

public class ContainerPlaneInventory
extends ivrt {
    public rojd inventory;
    public cuqu world;
    public EntityDriveable plane;
    public int numItems;
    public int screen;
    public int maxScroll;
    public int scroll;

    public ContainerPlaneInventory(rojd rojd2, cuqu cuqu2, EntityDriveable entityDriveable, int n) {
        int n2;
        int n3;
        this.inventory = rojd2;
        this.world = cuqu2;
        this.plane = entityDriveable;
        this.screen = n;
        this.numItems = 0;
        switch (n) {
            case 0: {
                this.numItems = this.plane.driveableData.numGuns;
                this.maxScroll = this.numItems > 3 ? this.numItems - 3 : 0;
                break;
            }
            case 1: {
                this.numItems = this.plane.getDriveableType().numBombSlots;
                this.maxScroll = (this.numItems + 7) / 8 > 3 ? (this.numItems + 7) / 8 - 3 : 0;
                break;
            }
            case 2: {
                this.numItems = this.plane.getDriveableType().numCargoSlots;
                this.maxScroll = (this.numItems + 7) / 8 > 3 ? (this.numItems + 7) / 8 - 3 : 0;
            }
        }
        switch (this.screen) {
            case 0: {
                int n4;
                n3 = 0;
                for (n2 = 0; n2 < this.plane.driveableData.numGuns; ++n2) {
                    n4 = -1000;
                    if (n3 < 3 + this.scroll && n3 >= this.scroll) {
                        n4 = 25 + 19 * n3;
                    }
                    this.func_75146_a(new kkuu((ivrb)this.plane.driveableData, n2, 29, n4));
                    ++n3;
                }
                break;
            }
            case 1: 
            case 2: {
                int n4;
                n3 = this.plane.driveableData.getBombInventoryStart();
                if (this.screen == 2) {
                    n3 = this.plane.driveableData.getCargoInventoryStart();
                }
                n2 = (this.numItems + 7) / 8;
                for (n4 = 0; n4 < n2; ++n4) {
                    int n5 = -1000;
                    if (n4 < 3 + this.scroll && n4 >= this.scroll) {
                        n5 = 25 + 19 * (n4 - this.scroll);
                    }
                    for (int i = 0; i < ((n4 + this.scroll + 1) * 8 <= this.numItems ? 8 : this.numItems % 8); ++i) {
                        this.func_75146_a((kkuu)new SlotVehInv(this.plane.driveableData, n3 + n4 * 8 + i, 10 + 18 * i, n5));
                    }
                }
                break;
            }
        }
        for (n3 = 0; n3 < 3; ++n3) {
            for (n2 = 0; n2 < 9; ++n2) {
                this.func_75146_a(new kkuu((ivrb)rojd2, n2 + n3 * 9 + 9, 8 + n2 * 18, 98 + n3 * 18));
            }
        }
        for (n3 = 0; n3 < 9; ++n3) {
            this.func_75146_a(new kkuu((ivrb)rojd2, n3, 8 + n3 * 18, 156));
        }
    }

    public void updateScroll(int n) {
        this.scroll = n;
        switch (this.screen) {
            case 0: {
                int n2 = 0;
                for (int i = 0; i < this.plane.driveableData.numGuns; ++i) {
                    int n3 = -1000;
                    if (n2 < 3 + this.scroll && n2 >= this.scroll) {
                        n3 = 25 + 19 * (n2 - this.scroll);
                    }
                    ((kkuu)this.field_75151_b.get((int)n2)).field_75221_f = n3;
                    ++n2;
                }
                return;
            }
            case 1: 
            case 2: {
                int n4 = (this.numItems + 7) / 8;
                for (int i = 0; i < n4; ++i) {
                    int n5 = -1000;
                    if (i < 3 + this.scroll && i >= this.scroll) {
                        n5 = 25 + 19 * (i - this.scroll);
                    }
                    for (int j = 0; j < ((i + 1) * 8 <= this.numItems ? 8 : this.numItems % 8); ++j) {
                        ((kkuu)this.field_75151_b.get((int)(i * 8 + j))).field_75221_f = n5;
                    }
                }
                break;
            }
        }
    }

    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    public ieta func_82846_b(EntityPlayer entityPlayer, int n) {
        ieta ieta2 = null;
        kkuu kkuu2 = (kkuu)this.field_75151_b.get(n);
        if (kkuu2 != null && kkuu2.func_75216_d()) {
            ieta ieta3 = kkuu2.func_75211_c();
            ieta2 = ieta3._l();
            if (n >= this.numItems ? !this.func_75135_a(ieta3, 0, this.numItems, false) : !this.func_75135_a(ieta3, this.numItems, this.field_75151_b.size(), true)) {
                return null;
            }
            if (ieta3._b == 0) {
                kkuu2.func_75215_d(null);
            } else {
                kkuu2.func_75218_e();
            }
            if (ieta3._b == ieta2._b) {
                return null;
            }
            kkuu2.func_82870_a(entityPlayer, ieta3);
        }
        return ieta2;
    }
}

