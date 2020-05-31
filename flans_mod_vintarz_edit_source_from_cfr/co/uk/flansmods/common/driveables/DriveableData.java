/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  hcsmod.HCS
 *  hcsmod.server.HcsServer
 *  hsus
 *  ieta
 *  ivrb
 *  jhvs
 *  net.minecraft.entity.player.EntityPlayer
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.common.ItemPart;
import co.uk.flansmods.common.PartType;
import co.uk.flansmods.common.driveables.CollisionBox;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.driveables.PilotGun;
import co.uk.flansmods.common.guns.ItemBullet;
import hcsmod.HCS;
import hcsmod.server.HcsServer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;

public class DriveableData
implements ivrb {
    public int numGuns;
    public int numBombs;
    public int numCargo;
    public String type;
    public PartType engine;
    public ieta[] ammo;
    public ieta[] bombs;
    public ieta[] cargo;
    public ieta fuel;
    public float fuelInTank;
    public HashMap<EnumDriveablePart, DriveablePart> parts = new HashMap();

    public DriveableData(hsus hsus2) {
        this.readFromNBT(hsus2);
    }

    public void readFromNBT(hsus hsus2) {
        int n;
        if (hsus2 == null) {
            return;
        }
        if (!hsus2._c("Type")) {
            return;
        }
        this.type = hsus2._j("Type");
        DriveableType driveableType = DriveableType.getDriveable(this.type);
        this.numBombs = driveableType.numBombSlots;
        this.numCargo = driveableType.numCargoSlots;
        this.numGuns = driveableType.numPassengerGunners + driveableType.guns.size();
        this.engine = PartType.getPart(hsus2._j("Engine"));
        this.ammo = new ieta[this.numGuns];
        this.bombs = new ieta[this.numBombs];
        this.cargo = new ieta[this.numCargo];
        for (n = 0; n < this.numGuns; ++n) {
            this.ammo[n] = ieta._a((hsus)hsus2._m("Ammo " + n));
        }
        for (n = 0; n < this.numBombs; ++n) {
            this.bombs[n] = ieta._a((hsus)hsus2._m("Bombs " + n));
        }
        for (n = 0; n < this.numCargo; ++n) {
            this.cargo[n] = ieta._a((hsus)hsus2._m("Cargo " + n));
            if (!HCS.serverIsPresent || this.cargo[n] == null || !HcsServer.isBannedItem((ieta)this.cargo[n])) continue;
            this.cargo[n] = null;
        }
        this.fuel = ieta._a((hsus)hsus2._m("Fuel"));
        this.fuelInTank = hsus2._f("FuelInTank");
        for (EnumDriveablePart enumDriveablePart : EnumDriveablePart.values()) {
            this.parts.put(enumDriveablePart, new DriveablePart(enumDriveablePart, driveableType.health.get((Object)enumDriveablePart)));
        }
        for (DriveablePart driveablePart : this.parts.values()) {
            driveablePart.readFromNBT(hsus2);
        }
    }

    public void writeToNBT(hsus hsus2) {
        this.writeToNBT(hsus2, true);
    }

    public void writeToNBT(hsus hsus2, boolean bl) {
        int n;
        hsus2._a("Type", this.type);
        hsus2._a("Engine", this.engine.shortName);
        for (n = 0; n < this.ammo.length; ++n) {
            if (this.ammo[n] == null) continue;
            hsus2._a("Ammo " + n, this.ammo[n]._b(new hsus()));
        }
        for (n = 0; n < this.bombs.length; ++n) {
            if (this.bombs[n] == null) continue;
            hsus2._a("Bombs " + n, this.bombs[n]._b(new hsus()));
        }
        for (n = 0; n < this.cargo.length; ++n) {
            hsus object;
            if (!HCS.serverIsPresent || this.cargo[n] == null || (object = HcsServer.saveItemToNBT((ieta)this.cargo[n], (boolean)bl)) == null) continue;
            hsus2._a("Cargo " + n, object);
        }
        if (this.fuel != null) {
            hsus2._a("Fuel", this.fuel._b(new hsus()));
        }
        hsus2._a("FuelInTank", (int)this.fuelInTank);
        for (DriveablePart driveablePart : this.parts.values()) {
            driveablePart.writeToNBT(hsus2);
        }
    }

    public int func_70302_i_() {
        return this.getFuelSlot() + 1;
    }

    public ieta func_70301_a(int n) {
        ieta[] arrieta = this.ammo;
        if (n >= this.ammo.length) {
            arrieta = this.bombs;
            if ((n -= this.ammo.length) >= this.bombs.length) {
                arrieta = this.cargo;
                if ((n -= this.bombs.length) >= this.cargo.length) {
                    return this.fuel;
                }
            }
        }
        return arrieta[n];
    }

    public ieta func_70298_a(int n, int n2) {
        ieta[] arrieta = this.ammo;
        if (n >= this.ammo.length) {
            arrieta = this.bombs;
            if ((n -= this.ammo.length) >= this.bombs.length) {
                arrieta = this.cargo;
                if ((n -= this.bombs.length) >= this.cargo.length) {
                    n -= this.cargo.length;
                    arrieta = new ieta[]{this.fuel};
                    this.func_70299_a(this.getFuelSlot(), null);
                }
            }
        }
        if (arrieta[n] != null) {
            if (arrieta[n]._b <= n2) {
                ieta ieta2 = arrieta[n];
                arrieta[n] = null;
                return ieta2;
            }
            ieta ieta3 = arrieta[n]._a(n2);
            if (arrieta[n]._b <= 0) {
                arrieta[n] = null;
            }
            return ieta3;
        }
        return null;
    }

    public ieta func_70304_b(int n) {
        return this.func_70301_a(n);
    }

    public void func_70299_a(int n, ieta ieta2) {
        ieta[] arrieta = this.ammo;
        if (n >= this.ammo.length) {
            arrieta = this.bombs;
            if ((n -= this.ammo.length) >= this.bombs.length) {
                arrieta = this.cargo;
                if ((n -= this.bombs.length) >= this.cargo.length) {
                    this.fuel = ieta2;
                    return;
                }
            }
        }
        arrieta[n] = ieta2;
    }

    public String func_70303_b() {
        return "Flan's Secret Data";
    }

    public int func_70297_j_() {
        return 64;
    }

    public void func_70296_d() {
    }

    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return true;
    }

    public void func_70295_k_() {
    }

    public void func_70305_f() {
    }

    public int getAmmoInventoryStart() {
        return 0;
    }

    public int getBombInventoryStart() {
        return this.ammo.length;
    }

    public int getCargoInventoryStart() {
        return this.ammo.length + this.bombs.length;
    }

    public int getFuelSlot() {
        return this.ammo.length + this.bombs.length + this.cargo.length;
    }

    public boolean func_94042_c() {
        return false;
    }

    public boolean func_94041_b(int n, ieta ieta2) {
        if (n < this.getBombInventoryStart() && ieta2 != null && ieta2._a() instanceof ItemBullet) {
            return true;
        }
        if (n >= this.getBombInventoryStart() && n < this.getCargoInventoryStart() && ieta2 != null && ieta2._a() instanceof ItemBullet) {
            return true;
        }
        if (n >= this.getCargoInventoryStart() && n < this.getFuelSlot()) {
            return true;
        }
        return n == this.getFuelSlot() && ieta2 != null && ieta2._a() instanceof ItemPart && ((ItemPart)ieta2._a()).type.category == 9;
    }
}

