/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  hsus
 *  ieta
 *  jhvs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.eidl
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.util.idqh
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.teams.EntityFlagpole;
import co.uk.flansmods.common.teams.Gametype;
import co.uk.flansmods.common.teams.ITeamBase;
import co.uk.flansmods.common.teams.ITeamObject;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.eidl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.idqh;

public class EntityFlag
extends Entity
implements ITeamObject {
    public int baseID;
    public EntityFlagpole base;
    public boolean isHome = true;

    public EntityFlag(cuqu cuqu2) {
        super(cuqu2);
        this.func_70105_a(1.0f, 1.0f);
        this.field_70155_l = 100.0;
        this.field_70158_ak = true;
    }

    public EntityFlag(cuqu cuqu2, EntityFlagpole entityFlagpole) {
        this(cuqu2);
        this.func_70107_b(entityFlagpole.field_70165_t, entityFlagpole.field_70163_u + 2.0, entityFlagpole.field_70161_v);
        this.setBase(entityFlagpole);
    }

    public boolean func_70067_L() {
        return true;
    }

    protected void func_70088_a() {
        this.field_70180_af._a(16, (Object)new String("none"));
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.base == null && !this.field_70170_p.field_72995_K) {
            this.setBase(TeamsManager.getInstance().getBase(this.baseID));
        }
        if (this.field_70154_o != null && this.field_70154_o.field_70128_L) {
            if (this.field_70154_o instanceof EntityPlayerMP) {
                EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this.field_70154_o;
                Team team = FlansModPlayerHandler.getPlayerData((String)entityPlayerMP.field_71092_bJ).team;
                TeamsManager.getInstance();
                TeamsManager.messageAll("\u00a7f" + entityPlayerMP.field_71092_bJ + " dropped the \u00a7" + team.textColour + team.name + "\u00a7f flag");
            }
            this.field_70154_o = null;
        }
    }

    public void reset() {
        this.func_70078_a(null);
        this.func_70107_b(this.base.field_70165_t, this.base.field_70163_u + 2.0, this.base.field_70161_v);
        this.isHome = true;
    }

    protected void func_70037_a(hsus hsus2) {
        this.baseID = hsus2._f("Base");
        this.setBase(TeamsManager.getInstance().getBase(this.baseID));
    }

    protected void func_70014_b(hsus hsus2) {
        hsus2._a("Base", this.base.getID());
    }

    @Override
    public ITeamBase getBase() {
        return this.base;
    }

    @Override
    public void onBaseSet(Team team) {
        if (team != null) {
            this.field_70180_af._b(16, (Object)team.shortName);
        } else {
            this.field_70180_af._b(16, (Object)"none");
        }
        this.func_70107_b(this.base.field_70165_t, this.base.field_70163_u + 2.0, this.base.field_70161_v);
    }

    @Override
    public void onBaseCapture(Team team) {
        this.onBaseSet(team);
    }

    @Override
    public void tick() {
    }

    @Override
    public void setBase(ITeamBase iTeamBase) {
        this.base = (EntityFlagpole)iTeamBase;
        if (this.base != null) {
            this.base.addObject(this);
            Team team = this.base.getOwner();
            this.onBaseSet(team);
        }
    }

    @Override
    public void destroy() {
        this.func_70106_y();
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

    public String getTeamName() {
        return this.field_70180_af._e(16);
    }

    public Team getTeam() {
        return Team.getTeam(this.getTeamName());
    }

    @Override
    public boolean isSpawnPoint() {
        return false;
    }

    public boolean func_130002_c(EntityPlayer entityPlayer) {
        if (entityPlayer instanceof EntityPlayerMP && TeamsManager.getInstance().currentGametype != null) {
            TeamsManager.getInstance().currentGametype.objectClickedByPlayer(this, (EntityPlayerMP)entityPlayer);
        }
        return false;
    }

    public ieta getPickedResult(idqh idqh2) {
        ieta ieta2 = new ieta(FlansMod.flag.field_77779_bT, 1, 0);
        return ieta2;
    }
}

