/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  brgb
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cuqu
 *  cuqv
 *  hsus
 *  ieta
 *  jhvs
 *  maaq
 *  mrcr
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.common.flgb
 *  net.minecraftforge.common.flgb$hrmy
 *  net.minecraftforge.common.flgb$idol
 *  ogpr
 *  yupu
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.ItemPlane;
import co.uk.flansmods.common.ItemVehicle;
import co.uk.flansmods.common.guns.ItemAAGun;
import co.uk.flansmods.common.teams.EntityTeamItem;
import co.uk.flansmods.common.teams.ITeamBase;
import co.uk.flansmods.common.teams.ITeamObject;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import cpw.mods.fml.common.network.PacketDispatcher;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.flgb;

public class TileEntitySpawner
extends ogpr
implements ITeamObject {
    public int spawnDelay = 1200;
    public List<ieta> stacksToSpawn = new ArrayList<ieta>();
    public List<EntityTeamItem> itemEntities = new ArrayList<EntityTeamItem>();
    public Entity spawnedEntity;
    public ITeamBase base;
    private int baseID = -1;
    private int dimension;
    public int currentDelay;
    private flgb.hrmy chunkTicket;
    private boolean uninitialized = true;
    private int loadDistance = 1;
    private String team;

    public TileEntitySpawner() {
        TeamsManager.getInstance().registerObject(this);
    }

    public maaq func_70319_e() {
        hsus hsus2 = new hsus();
        hsus2._a("Team", this.base == null || this.base.getOwner() == null ? "none" : this.base.getOwner().shortName);
        return new brgb(this.field_70329_l, this.field_70330_m, this.field_70327_n, 1, hsus2);
    }

    public void onDataPacket(mrcr mrcr2, brgb brgb2) {
        this.team = brgb2._e._j("Team");
    }

    public void func_70316_g() {
        int n;
        ITeamBase iTeamBase;
        if (this.field_70331_k.field_72995_K) {
            return;
        }
        this.updateChunkLoading();
        if (this.baseID >= 0 && this.base == null && (iTeamBase = TeamsManager.getInstance().getBase(this.baseID)) != null) {
            this.setBase(iTeamBase);
            iTeamBase.addObject(this);
        }
        if (this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n) != FlansMod.spawnerID) {
            this.destroy();
            return;
        }
        if (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n) == 1) {
            return;
        }
        for (n = this.itemEntities.size() - 1; n >= 0; --n) {
            if (!this.itemEntities.get((int)n).field_70128_L) continue;
            this.itemEntities.remove(n);
        }
        if (this.currentDelay > 0 && this.itemEntities.size() == 0) {
            --this.currentDelay;
        }
        if (this.currentDelay == 0) {
            this.currentDelay = this.spawnDelay;
            for (n = 0; n < this.stacksToSpawn.size(); ++n) {
                EntityTeamItem entityTeamItem;
                if (this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n) == 2) {
                    if (this.spawnedEntity != null && !this.spawnedEntity.field_70128_L) continue;
                    entityTeamItem = this.stacksToSpawn.get(n);
                    if (entityTeamItem != null && entityTeamItem._a() instanceof ItemPlane) {
                        this.spawnedEntity = ((ItemPlane)entityTeamItem._a()).spawnPlane(this.field_70331_k, (float)this.field_70329_l + 0.5f, (float)this.field_70330_m + 0.5f, (float)this.field_70327_n + 0.5f, (ieta)entityTeamItem);
                    }
                    if (entityTeamItem != null && entityTeamItem._a() instanceof ItemVehicle) {
                        this.spawnedEntity = ((ItemVehicle)entityTeamItem._a()).spawnVehicle(this.field_70331_k, (float)this.field_70329_l + 0.5f, (float)this.field_70330_m + 0.5f, (float)this.field_70327_n + 0.5f, (ieta)entityTeamItem);
                    }
                    if (entityTeamItem == null || !(entityTeamItem._a() instanceof ItemAAGun)) continue;
                    this.spawnedEntity = ((ItemAAGun)entityTeamItem._a()).spawnAAGun(this.field_70331_k, (float)this.field_70329_l + 0.5f, this.field_70330_m, (float)this.field_70327_n + 0.5f, (ieta)entityTeamItem);
                    continue;
                }
                entityTeamItem = new EntityTeamItem(this, n);
                this.field_70331_k.func_72838_d((Entity)entityTeamItem);
            }
        }
    }

    public void func_70310_b(hsus hsus2) {
        super.func_70310_b(hsus2);
        hsus2._a("delay", this.spawnDelay);
        hsus2._a("Base", this.baseID);
        hsus2._a("dim", this.field_70331_k.field_73011_w._i);
        hsus2._a("numStacks", this.stacksToSpawn.size());
        for (int i = 0; i < this.stacksToSpawn.size(); ++i) {
            hsus hsus3 = new hsus();
            this.stacksToSpawn.get(i)._b(hsus3);
            hsus2._a("stack" + i, hsus3);
        }
    }

    public void func_70307_a(hsus hsus2) {
        super.func_70307_a(hsus2);
        this.currentDelay = this.spawnDelay = hsus2._f("delay");
        this.baseID = hsus2._f("Base");
        this.dimension = hsus2._f("dim");
        this.setBase(TeamsManager.getInstance().getBase(this.baseID));
        if (this.base != null) {
            this.base.addObject(this);
        }
        for (int i = 0; i < hsus2._f("numStacks"); ++i) {
            this.stacksToSpawn.add(ieta._a((hsus)hsus2._m("stack" + i)));
        }
    }

    @Override
    public ITeamBase getBase() {
        return this.base;
    }

    public Team getTeam() {
        if (this.field_70331_k.field_72995_K) {
            return Team.getTeam(this.team);
        }
        return this.base == null ? null : this.base.getOwner();
    }

    @Override
    public void onBaseSet(Team team) {
        PacketDispatcher.sendPacketToAllInDimension((maaq)this.func_70319_e(), (int)(this.field_70331_k == null ? this.dimension : this.field_70331_k.field_73011_w._i));
    }

    @Override
    public void onBaseCapture(Team team) {
        this.onBaseSet(team);
    }

    @Override
    public void setBase(ITeamBase iTeamBase) {
        this.base = iTeamBase;
        if (iTeamBase != null) {
            this.baseID = iTeamBase.getID();
        }
        PacketDispatcher.sendPacketToAllInDimension((maaq)this.func_70319_e(), (int)(this.field_70331_k == null ? this.dimension : this.field_70331_k.field_73011_w._i));
    }

    @Override
    public void tick() {
    }

    @Override
    public void destroy() {
        this.field_70331_k.func_72832_d(this.field_70329_l, this.field_70330_m, this.field_70327_n, 0, 0, 5);
    }

    @Override
    public double getPosX() {
        return (float)this.field_70329_l + 0.5f;
    }

    @Override
    public double getPosY() {
        return (float)this.field_70330_m + 0.5f;
    }

    @Override
    public double getPosZ() {
        return (float)this.field_70327_n + 0.5f;
    }

    @Override
    public boolean isSpawnPoint() {
        int n = this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n);
        return n == 1;
    }

    public void forceChunkLoading(flgb.hrmy hrmy2) {
        this.chunkTicket = hrmy2;
        for (yupu yupu2 : this.getLoadArea()) {
            FlansMod.log(String.format("Force loading chunk %s in %s", new Object[]{yupu2, this.field_70331_k.field_73011_w.getClass()}));
            flgb.forceChunk((flgb.hrmy)hrmy2, (yupu)yupu2);
        }
    }

    public List<yupu> getLoadArea() {
        LinkedList<yupu> linkedList = new LinkedList<yupu>();
        qmzb qmzb2 = this.field_70331_k.func_72938_d(this.field_70329_l, this.field_70327_n);
        linkedList.add(new yupu(qmzb2._i, qmzb2._j));
        return linkedList;
    }

    public void updateChunkLoading() {
        if (this.field_70331_k.field_72995_K) {
            return;
        }
        if (this.uninitialized && this.chunkTicket == null) {
            this.chunkTicket = flgb.requestTicket((Object)FlansMod.instance, (cuqu)this.field_70331_k, (flgb.idol)flgb.idol.NORMAL);
            if (this.chunkTicket != null) {
                this.forceChunkLoading(this.chunkTicket);
            }
            this.uninitialized = false;
        }
    }

    public void func_70313_j() {
        super.func_70313_j();
        flgb.releaseTicket((flgb.hrmy)this.chunkTicket);
    }
}

