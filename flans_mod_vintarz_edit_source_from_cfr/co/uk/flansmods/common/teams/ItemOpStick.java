/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  ieta
 *  jhvs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.entity.projectile.EntityFishHook
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.roij
 *  qlze
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.teams.EntityConnectingLine;
import co.uk.flansmods.common.teams.ITeamBase;
import co.uk.flansmods.common.teams.ITeamObject;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.rojd;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.util.dwbg;
import net.minecraft.util.roij;

public class ItemOpStick
extends jhvs {
    public static final String[] stickNames = new String[]{"opStick_ownership", "opStick_connecting", "opStick_mapping", "opStick_destruction"};
    @SideOnly(value=Side.CLIENT)
    private roij[] icons;

    public ItemOpStick(int n) {
        super(n - 256);
        this.func_77655_b("opStick");
        this.func_77627_a(true);
    }

    public boolean func_77629_n_() {
        return true;
    }

    public boolean func_77662_d() {
        return true;
    }

    public void clickedEntity(cuqu cuqu2, EntityPlayer entityPlayer, Entity entity) {
        if (!(entityPlayer instanceof EntityPlayerMP)) {
            return;
        }
        if (entity instanceof ITeamBase) {
            this.clickedBase(cuqu2, (EntityPlayerMP)entityPlayer, (ITeamBase)entity);
        }
        if (entity instanceof ITeamObject) {
            this.clickedObject(cuqu2, (EntityPlayerMP)entityPlayer, (ITeamObject)entity);
        }
    }

    public void clickedBase(cuqu cuqu2, EntityPlayerMP entityPlayerMP, ITeamBase iTeamBase) {
        int n = entityPlayerMP.field_71071_by._a()._j();
        TeamsManager teamsManager = TeamsManager.getInstance();
        switch (n) {
            case 0: {
                if (teamsManager.teams == null) {
                    TeamsManager.messagePlayer(entityPlayerMP, "Please set up teams before editing this base");
                    return;
                }
                Team team = iTeamBase.getOwner();
                Team team2 = null;
                if (team == null) {
                    team2 = teamsManager.teams != null ? teamsManager.teams[0] : Team.spectators;
                } else if (team == Team.spectators) {
                    team2 = null;
                } else {
                    for (int i = 0; i < teamsManager.teams.length; ++i) {
                        if (team != teamsManager.teams[i]) continue;
                        team2 = i == teamsManager.teams.length - 1 ? Team.spectators : teamsManager.teams[i + 1];
                    }
                }
                TeamsManager.messagePlayer(entityPlayerMP, "Base owner changed to " + (team2 == null ? "none" : team2.shortName));
                if (team != null) {
                    team.bases.remove(iTeamBase);
                }
                iTeamBase.setBase(team2);
                if (team2 != null) {
                    team2.bases.add(iTeamBase);
                }
                for (ITeamObject iTeamObject : iTeamBase.getObjects()) {
                    iTeamObject.onBaseSet(team2);
                }
                break;
            }
            case 1: {
                if (entityPlayerMP.field_71104_cf == null) {
                    EntityConnectingLine entityConnectingLine = new EntityConnectingLine(cuqu2, (EntityPlayer)entityPlayerMP, iTeamBase);
                    cuqu2.func_72838_d((Entity)entityConnectingLine);
                    break;
                }
                if (!(entityPlayerMP.field_71104_cf instanceof EntityConnectingLine)) break;
                EntityConnectingLine entityConnectingLine = (EntityConnectingLine)entityPlayerMP.field_71104_cf;
                if (entityConnectingLine.connectedTo instanceof ITeamObject) {
                    ITeamObject iTeamObject = (ITeamObject)entityConnectingLine.connectedTo;
                    iTeamObject.setBase(iTeamBase);
                    iTeamBase.addObject(iTeamObject);
                    entityConnectingLine.func_70106_y();
                    entityPlayerMP.field_71104_cf = null;
                    TeamsManager.messagePlayer(entityPlayerMP, "Successfully connected.");
                    break;
                }
                TeamsManager.messagePlayer(entityPlayerMP, "Cannot connect bases to bases.");
                break;
            }
            case 2: {
                TeamsManager.TeamsMap teamsMap = iTeamBase.getMap();
                int n2 = teamsManager.maps.indexOf(teamsMap);
                TeamsManager.TeamsMap teamsMap2 = teamsManager.maps.get((n2 + 1) % teamsManager.maps.size());
                iTeamBase.setMap(teamsMap2);
                TeamsManager.messagePlayer(entityPlayerMP, "Set map for this base to " + teamsMap2.name + ".");
                break;
            }
            case 3: {
                iTeamBase.destroy();
            }
        }
    }

    public void clickedObject(cuqu cuqu2, EntityPlayerMP entityPlayerMP, ITeamObject iTeamObject) {
        int n = entityPlayerMP.field_71071_by._a()._j();
        TeamsManager.getInstance();
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                if (entityPlayerMP.field_71104_cf == null) {
                    EntityConnectingLine entityConnectingLine = new EntityConnectingLine(cuqu2, (EntityPlayer)entityPlayerMP, iTeamObject);
                    cuqu2.func_72838_d((Entity)entityConnectingLine);
                    break;
                }
                if (!(entityPlayerMP.field_71104_cf instanceof EntityConnectingLine)) break;
                EntityConnectingLine entityConnectingLine = (EntityConnectingLine)entityPlayerMP.field_71104_cf;
                if (entityConnectingLine.connectedTo instanceof ITeamBase) {
                    ITeamBase iTeamBase = (ITeamBase)entityConnectingLine.connectedTo;
                    iTeamObject.setBase(iTeamBase);
                    iTeamBase.addObject(iTeamObject);
                    TeamsManager.messagePlayer(entityPlayerMP, "Successfully connected.");
                    break;
                }
                TeamsManager.messagePlayer(entityPlayerMP, "Cannot connect objects to objects.");
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                iTeamObject.destroy();
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(qlze qlze2) {
        this.icons = new roij[stickNames.length];
        for (int i = 0; i < stickNames.length; ++i) {
            this.icons[i] = qlze2._a("FlansMod:" + stickNames[i]);
            this.field_77791_bV = this.icons[i];
        }
    }

    public roij func_77617_a(int n) {
        int n2 = dwbg._a((int)n, (int)0, (int)15);
        return this.icons[n2];
    }

    public String func_77667_c(ieta ieta2) {
        return super.func_77658_a() + "." + ieta2._j();
    }
}

