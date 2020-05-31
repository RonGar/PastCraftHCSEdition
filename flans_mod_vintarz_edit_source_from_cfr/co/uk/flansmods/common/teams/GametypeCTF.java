/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  hsus
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.util.pico
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.teams.EntityFlag;
import co.uk.flansmods.common.teams.Gametype;
import co.uk.flansmods.common.teams.ITeamBase;
import co.uk.flansmods.common.teams.ITeamObject;
import co.uk.flansmods.common.teams.PlayerClass;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.pico;
import net.minecraft.util.samw;

public class GametypeCTF
extends Gametype {
    public boolean friendlyFire = false;
    public boolean autoBalance = true;
    public int scoreLimit = 5;
    public int newRoundTimer = 0;
    public int time;
    public int autoBalanceInterval = 1200;

    public GametypeCTF() {
        super("Capture the Flag", "CTF", 2);
    }

    @Override
    public void initGametype() {
        this.startNewRound();
    }

    @Override
    public void teamsSet() {
        this.startNewRound();
    }

    @Override
    public void stopGametype() {
        super.stopGametype();
        GametypeCTF.resetScores();
    }

    @Override
    public void tick() {
        --this.newRoundTimer;
        if (this.newRoundTimer == 0) {
            if (FlansMod.useRotation) {
                TeamsManager.getInstance().switchToNextGametype();
                return;
            }
            this.startNewRound();
        }
        if (GametypeCTF.teamsManager.teams != null) {
            for (Team team : GametypeCTF.teamsManager.teams) {
                if (team == null || team.score < this.scoreLimit || this.newRoundTimer >= 0) continue;
                TeamsManager.messageAll("\u00a7" + team.textColour + team.name + "\u00a7f won!");
                this.newRoundTimer = 200;
                TeamsManager.messageAll("\u00a7fThe next round will start in 10 seconds");
                this.time = -300;
            }
        }
        ++this.time;
        if (this.autoBalance && this.time % this.autoBalanceInterval == this.autoBalanceInterval - 200 && this.needAutobalance()) {
            TeamsManager.messageAll("\u00a7fAutobalancing teams...");
        }
        if (this.autoBalance && this.time % this.autoBalanceInterval == 0 && this.needAutobalance()) {
            this.autobalance();
        }
    }

    public boolean needAutobalance() {
        int n;
        if (GametypeCTF.teamsManager.teams == null || GametypeCTF.teamsManager.teams[0] == null || GametypeCTF.teamsManager.teams[1] == null) {
            return false;
        }
        int n2 = GametypeCTF.teamsManager.teams[0].members.size();
        return Math.abs(n2 - (n = GametypeCTF.teamsManager.teams[1].members.size())) > 1;
    }

    public void autobalance() {
        int n;
        int n2;
        if (GametypeCTF.teamsManager.teams == null || GametypeCTF.teamsManager.teams[0] == null || GametypeCTF.teamsManager.teams[1] == null) {
            return;
        }
        int n3 = GametypeCTF.teamsManager.teams[0].members.size();
        if (n3 - (n2 = GametypeCTF.teamsManager.teams[1].members.size()) > 1) {
            for (n = 0; n < (n3 - n2) / 2; ++n) {
                GametypeCTF.sendClassMenuToPlayer(this.getPlayer(GametypeCTF.teamsManager.teams[1].addPlayer(GametypeCTF.teamsManager.teams[0].removeWorstPlayer())));
            }
        }
        if (n2 - n3 > 1) {
            for (n = 0; n < (n2 - n3) / 2; ++n) {
                GametypeCTF.sendClassMenuToPlayer(this.getPlayer(GametypeCTF.teamsManager.teams[0].addPlayer(GametypeCTF.teamsManager.teams[1].removeWorstPlayer())));
            }
        }
    }

    @Override
    public void playerJoined(EntityPlayerMP entityPlayerMP) {
        GametypeCTF.sendTeamsMenuToPlayer(entityPlayerMP);
    }

    @Override
    public boolean playerChoseTeam(EntityPlayerMP entityPlayerMP, Team team, Team team2) {
        int n;
        int n2;
        int n3;
        if (GametypeCTF.teamsManager.teams == null || GametypeCTF.teamsManager.teams[0] == null || GametypeCTF.teamsManager.teams[1] == null) {
            return false;
        }
        if (this.autoBalance && (n2 = team.members.size()) > (n = (n3 = GametypeCTF.teamsManager.teams[0].members.size() + GametypeCTF.teamsManager.teams[1].members.size()) - n2)) {
            return false;
        }
        if (team2 != null && team2 != Team.spectators && team2 != team && GametypeCTF.isAValidTeam(team2, true)) {
            ++GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).deaths;
            --GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
            GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).playerClass = null;
            GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).newPlayerClass = null;
        }
        GametypeCTF.sendClassMenuToPlayer(entityPlayerMP);
        if (team != team2) {
            teamsManager.forceRespawn(entityPlayerMP);
        }
        return true;
    }

    @Override
    public boolean playerChoseClass(EntityPlayerMP entityPlayerMP, PlayerClass playerClass) {
        Team team = GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).team;
        if (!team.classes.contains(playerClass)) {
            return false;
        }
        GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).newPlayerClass = playerClass;
        if (GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).playerClass == null) {
            teamsManager.resetInventory((EntityPlayer)entityPlayerMP);
        } else {
            entityPlayerMP.func_71035_c("You will respawn with the " + playerClass.name.toLowerCase() + " class");
        }
        return true;
    }

    @Override
    public void playerQuit(EntityPlayerMP entityPlayerMP) {
    }

    @Override
    public boolean playerAttacked(EntityPlayerMP entityPlayerMP, pico pico2) {
        if (GametypeCTF.getPlayerData(entityPlayerMP) == null || GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).team == null) {
            return false;
        }
        if (this.newRoundTimer > 0) {
            return false;
        }
        EntityPlayerMP entityPlayerMP2 = GametypeCTF.getPlayerFromDamageSource(pico2);
        if (entityPlayerMP2 != null) {
            if (GametypeCTF.getPlayerData(entityPlayerMP2) == null || GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP2).team == null) {
                return false;
            }
            if (GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP2).team == Team.spectators) {
                return false;
            }
            if (GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).team == GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP2).team) {
                return this.friendlyFire;
            }
        }
        return GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).team != Team.spectators;
    }

    @Override
    public void playerKilled(EntityPlayerMP entityPlayerMP, pico pico2) {
        EntityPlayerMP entityPlayerMP2 = GametypeCTF.getPlayerFromDamageSource(pico2);
        if (entityPlayerMP2 != null) {
            if (entityPlayerMP2 == entityPlayerMP) {
                --GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
            } else {
                ++GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP2).score;
                ++GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP2).kills;
            }
        } else {
            --GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
        }
        ++GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).deaths;
        for (Team team : GametypeCTF.teamsManager.teams) {
            for (ITeamBase iTeamBase : team.bases) {
                iTeamBase.getFlag();
            }
        }
    }

    @Override
    public void baseAttacked(ITeamBase iTeamBase, pico pico2) {
    }

    @Override
    public void objectAttacked(ITeamObject iTeamObject, pico pico2) {
    }

    @Override
    public void baseClickedByPlayer(ITeamBase iTeamBase, EntityPlayerMP entityPlayerMP) {
    }

    @Override
    public void objectClickedByPlayer(ITeamObject iTeamObject, EntityPlayerMP entityPlayerMP) {
        EntityFlag entityFlag;
        Team team;
        if (iTeamObject instanceof EntityFlag && (entityFlag = (EntityFlag)iTeamObject).getBase().getOwner() != null && entityFlag.getBase().getOwner() != Team.spectators && (team = GametypeCTF.getPlayerData((EntityPlayerMP)entityPlayerMP).team) != null && team != Team.spectators) {
            if (team == entityFlag.getBase().getOwner()) {
                EntityFlag entityFlag2;
                if (entityFlag.field_70154_o == null && !entityFlag.isHome) {
                    entityFlag.reset();
                    TeamsManager.messageAll("\u00a7f" + entityPlayerMP.field_71092_bJ + " returned the \u00a7" + entityFlag.getBase().getOwner().textColour + entityFlag.getBase().getOwner().name + "\u00a7f flag");
                } else if (entityPlayerMP.field_70153_n instanceof EntityFlag && (entityFlag2 = (EntityFlag)entityPlayerMP.field_70153_n).getBase().getOwner() != null && entityFlag2.getBase().getOwner() != team && entityFlag2.getBase().getOwner() != Team.spectators && entityFlag.isHome && this.newRoundTimer <= 0) {
                    ++team.score;
                    entityFlag2.reset();
                    TeamsManager.messageAll("\u00a7f" + entityPlayerMP.field_71092_bJ + " captured the \u00a7" + entityFlag2.getBase().getOwner().textColour + entityFlag2.getBase().getOwner().name + "\u00a7f flag");
                }
            } else if (entityFlag.field_70154_o == entityPlayerMP) {
                entityFlag.func_70078_a(null);
                TeamsManager.messageAll("\u00a7f" + entityPlayerMP.field_71092_bJ + " dropped the \u00a7" + entityFlag.getBase().getOwner().textColour + entityFlag.getBase().getOwner().name + "\u00a7f flag");
            } else if (entityFlag.field_70154_o == null) {
                entityFlag.func_70078_a((Entity)entityPlayerMP);
                TeamsManager.messageAll("\u00a7f" + entityPlayerMP.field_71092_bJ + " picked up the \u00a7" + entityFlag.getBase().getOwner().textColour + entityFlag.getBase().getOwner().name + "\u00a7f flag");
                entityFlag.isHome = false;
            }
        }
    }

    @Override
    public samw getSpawnPoint(EntityPlayerMP entityPlayerMP) {
        FlansModPlayerData flansModPlayerData = GametypeCTF.getPlayerData(entityPlayerMP);
        ArrayList<ITeamObject> arrayList = new ArrayList<ITeamObject>();
        if (flansModPlayerData.team == null) {
            return null;
        }
        for (int i = 0; i < flansModPlayerData.team.bases.size(); ++i) {
            ITeamBase iTeamBase = flansModPlayerData.team.bases.get(i);
            if (iTeamBase.getMap() != GametypeCTF.teamsManager.currentMap) continue;
            for (int j = 0; j < iTeamBase.getObjects().size(); ++j) {
                if (!iTeamBase.getObjects().get(j).isSpawnPoint()) continue;
                arrayList.add(iTeamBase.getObjects().get(j));
            }
        }
        if (arrayList.size() > 0) {
            ITeamObject iTeamObject = (ITeamObject)arrayList.get(rand.nextInt(arrayList.size()));
            return samw._a((double)iTeamObject.getPosX(), (double)iTeamObject.getPosY(), (double)iTeamObject.getPosZ());
        }
        return null;
    }

    @Override
    public void playerRespawned(EntityPlayerMP entityPlayerMP) {
    }

    @Override
    public boolean setVariable(String string, String string2) {
        if (string.toLowerCase().equals("scorelimit")) {
            this.scoreLimit = Integer.parseInt(string2);
            return true;
        }
        if (string.toLowerCase().equals("friendlyfire")) {
            this.friendlyFire = Boolean.parseBoolean(string2);
            return true;
        }
        if (string.toLowerCase().equals("autobalance")) {
            this.autoBalance = Boolean.parseBoolean(string2);
            return true;
        }
        return false;
    }

    @Override
    public void readFromNBT(hsus hsus2) {
        this.scoreLimit = hsus2._f("CTFScoreLimit");
        this.friendlyFire = hsus2._o("CTFFriendlyFire");
        this.autoBalance = hsus2._o("CTFAutoBalance");
    }

    @Override
    public void saveToNBT(hsus hsus2) {
        hsus2._a("CTFScoreLimit", this.scoreLimit);
        hsus2._a("CTFFriendlyFire", this.friendlyFire);
        hsus2._a("CTFAutoBalance", this.autoBalance);
    }

    @Override
    public boolean sortScoreboardByTeam() {
        return true;
    }
}

