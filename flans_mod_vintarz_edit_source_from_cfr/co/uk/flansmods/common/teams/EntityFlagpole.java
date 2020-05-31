/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  cuqv
 *  hsus
 *  ieta
 *  jhvs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.rojd
 *  net.minecraftforge.common.flgb
 *  net.minecraftforge.common.flgb$hrmy
 *  net.minecraftforge.common.flgb$idol
 *  yupu
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.teams.EntityFlag;
import co.uk.flansmods.common.teams.Gametype;
import co.uk.flansmods.common.teams.ITeamBase;
import co.uk.flansmods.common.teams.ITeamObject;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.rojd;
import net.minecraftforge.common.flgb;

public class EntityFlagpole
extends Entity
implements ITeamBase {
    public Team defaultTeam;
    public Team currentTeam;
    public TeamsManager.TeamsMap map;
    public List<ITeamObject> objects = new ArrayList<ITeamObject>();
    public String name = "Default Name";
    private int ID;
    private EntityFlag flag;
    public static TeamsManager teamsManager = TeamsManager.getInstance();
    private flgb.hrmy chunkTicket;
    private boolean uninitialized = true;
    private int loadDistance = 1;

    public EntityFlagpole(cuqu cuqu2) {
        super(cuqu2);
        this.func_70105_a(1.0f, 2.0f);
        this.field_70155_l = 100.0;
    }

    public EntityFlagpole(cuqu cuqu2, double d, double d2, double d3) {
        this(cuqu2);
        this.func_70107_b(d, d2, d3);
        this.flag = new EntityFlag(this.field_70170_p, this);
        this.objects.add(this.flag);
        this.field_70170_p.func_72838_d((Entity)this.flag);
        this.map = EntityFlagpole.teamsManager.currentMap;
    }

    public EntityFlagpole(cuqu cuqu2, int n, int n2, int n3) {
        this(cuqu2, (double)n + 0.5, (double)n2, (double)n3 + 0.5);
    }

    public rojd func_70046_E() {
        return null;
    }

    public boolean func_70067_L() {
        return true;
    }

    protected void func_70088_a() {
    }

    protected void func_70037_a(hsus hsus2) {
        this.setID(hsus2._f("ID"));
        this.currentTeam = this.defaultTeam = Team.getTeam(hsus2._j("Team"));
        if (this.currentTeam != null) {
            this.currentTeam.bases.add(this);
        }
        this.map = teamsManager.getTeamsMap(hsus2._j("Map"));
    }

    protected void func_70014_b(hsus hsus2) {
        if (this.defaultTeam != null) {
            hsus2._a("Team", this.defaultTeam.shortName);
        }
        hsus2._a("Map", this.map.shortName);
        hsus2._a("ID", this.getID());
    }

    @Override
    public Team getOwner() {
        return this.currentTeam;
    }

    @Override
    public TeamsManager.TeamsMap getMap() {
        return this.map;
    }

    @Override
    public void setMap(TeamsManager.TeamsMap teamsMap) {
        this.map = teamsMap;
    }

    @Override
    public List<ITeamObject> getObjects() {
        return this.objects;
    }

    @Override
    public void setBase(Team team) {
        this.updateOwners(team);
        this.currentTeam = this.defaultTeam = team;
    }

    @Override
    public void captureBase(Team team) {
        this.updateOwners(team);
        this.currentTeam = team;
        TeamsManager.messageAll("\u00a7" + team.textColour + team.name + "\u00a7f captured " + this.name + "!");
    }

    public void updateOwners(Team team) {
        ArrayList<EntityFlagpole> arrayList = new ArrayList<EntityFlagpole>();
        arrayList.add(this);
        for (Team team2 : Team.teams) {
            team2.bases.removeAll(arrayList);
        }
        if (team != null) {
            team.bases.add(this);
        }
    }

    @Override
    public void tick() {
    }

    @Override
    public void startRound() {
        this.updateOwners(this.defaultTeam);
        this.currentTeam = this.defaultTeam;
        for (ITeamObject iTeamObject : this.getObjects()) {
            iTeamObject.onBaseSet(this.defaultTeam);
        }
    }

    @Override
    public void addObject(ITeamObject iTeamObject) {
        this.objects.add(iTeamObject);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String string) {
        this.name = string;
    }

    @Override
    public void destroy() {
        this.func_70106_y();
    }

    @Override
    public Entity getEntity() {
        return this;
    }

    @Override
    public double getPosX() {
        return this.field_70165_t;
    }

    @Override
    public double getPosY() {
        return this.field_70163_u;
    }

    @Override
    public double getPosZ() {
        return this.field_70161_v;
    }

    @Override
    public cuqu getWorld() {
        return this.field_70170_p;
    }

    @Override
    public void setID(int n) {
        this.ID = n;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public ITeamObject getFlag() {
        return this.flag;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        this.updateChunkLoading();
    }

    public void forceChunkLoading(flgb.hrmy hrmy2) {
        this.chunkTicket = hrmy2;
        for (yupu yupu2 : this.getLoadArea()) {
            FlansMod.log(String.format("Force loading chunk %s in %s", new Object[]{yupu2, this.field_70170_p.field_73011_w.getClass()}));
            flgb.forceChunk((flgb.hrmy)hrmy2, (yupu)yupu2);
        }
    }

    public List<yupu> getLoadArea() {
        LinkedList<yupu> linkedList = new LinkedList<yupu>();
        qmzb qmzb2 = this.field_70170_p.func_72938_d(dwbg._c((double)this.field_70165_t), dwbg._c((double)this.field_70161_v));
        linkedList.add(new yupu(qmzb2._i, qmzb2._j));
        return linkedList;
    }

    public void updateChunkLoading() {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.uninitialized && this.chunkTicket == null) {
            this.chunkTicket = flgb.requestTicket((Object)FlansMod.instance, (cuqu)this.field_70170_p, (flgb.idol)flgb.idol.NORMAL);
            if (this.chunkTicket != null) {
                this.forceChunkLoading(this.chunkTicket);
            }
            this.uninitialized = false;
        }
    }

    public void func_70106_y() {
        super.func_70106_y();
        flgb.releaseTicket((flgb.hrmy)this.chunkTicket);
    }

    public boolean func_130002_c(EntityPlayer entityPlayer) {
        if (entityPlayer instanceof EntityPlayerMP && TeamsManager.getInstance().currentGametype != null) {
            TeamsManager.getInstance().currentGametype.baseClickedByPlayer(this, (EntityPlayerMP)entityPlayer);
        }
        return false;
    }

    public ieta getPickedResult(idqh idqh2) {
        ieta ieta2 = new ieta(FlansMod.flag.field_77779_bT, 1, 0);
        return ieta2;
    }
}

