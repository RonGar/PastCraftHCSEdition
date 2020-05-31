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
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.vintarz.SlotVehFuel;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;

public class ContainerPlaneMenu
extends ivrt {
    public EntityDriveable plane;
    public boolean isFuel;
    public rojd inventory;
    public cuqu world;

    public ContainerPlaneMenu(rojd rojd2, cuqu cuqu2) {
        this(rojd2, cuqu2, false, null);
    }

    public ContainerPlaneMenu(rojd rojd2, cuqu cuqu2, boolean bl, EntityDriveable entityDriveable) {
        this.inventory = rojd2;
        this.world = cuqu2;
        this.plane = entityDriveable;
        this.isFuel = bl;
        if (this.isFuel) {
            int n;
            this.func_75146_a((kkuu)new SlotVehFuel(this.plane.driveableData, this.plane.driveableData.getFuelSlot(), 35, 44));
            for (n = 0; n < 3; ++n) {
                for (int i = 0; i < 9; ++i) {
                    this.func_75146_a(new kkuu((ivrb)rojd2, i + n * 9 + 9, 8 + i * 18, 79 + (this.isFuel ? 0 : 19) + n * 18));
                }
            }
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new kkuu((ivrb)rojd2, n, 8 + n * 18, 137 + (this.isFuel ? 0 : 19)));
            }
        }
    }

    public ieta func_82846_b(EntityPlayer entityPlayer, int n) {
        ieta ieta2 = null;
        kkuu kkuu2 = (kkuu)this.field_75151_b.get(n);
        if (kkuu2 != null && kkuu2.func_75216_d()) {
            ieta ieta3 = kkuu2.func_75211_c();
            ieta2 = ieta3._l();
            if (n != 0 ? !this.func_75135_a(ieta3, 0, 1, false) : !this.func_75135_a(ieta3, 1, this.field_75151_b.size(), true)) {
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

    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }
}

