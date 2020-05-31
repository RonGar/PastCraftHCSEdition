/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  hsus
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.util.pico
 *  net.minecraft.util.samw
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.teams.Gametype;
import co.uk.flansmods.common.teams.ITeamBase;
import co.uk.flansmods.common.teams.ITeamObject;
import co.uk.flansmods.common.teams.PlayerClass;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.pico;
import net.minecraft.util.samw;

public class GametypeTDM
extends Gametype {
    public boolean friendlyFire = false;
    public boolean autoBalance = true;
    public int scoreLimit = 25;
    public int newRoundTimer = 0;
    public int time;
    public int autoBalanceInterval = 1200;

    public GametypeTDM() {
        super("Team Deathmatch", "TDM", 2);
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
        GametypeTDM.resetScores();
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
        if (GametypeTDM.teamsManager.teams != null) {
            for (Team team : GametypeTDM.teamsManager.teams) {
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
        if (GametypeTDM.teamsManager.teams == null || GametypeTDM.teamsManager.teams[0] == null || GametypeTDM.teamsManager.teams[1] == null) {
            return false;
        }
        int n2 = GametypeTDM.teamsManager.teams[0].members.size();
        return Math.abs(n2 - (n = GametypeTDM.teamsManager.teams[1].members.size())) > 1;
    }

    public void autobalance() {
        int n;
        int n2;
        if (GametypeTDM.teamsManager.teams == null || GametypeTDM.teamsManager.teams[0] == null || GametypeTDM.teamsManager.teams[1] == null) {
            return;
        }
        int n3 = GametypeTDM.teamsManager.teams[0].members.size();
        if (n3 - (n2 = GametypeTDM.teamsManager.teams[1].members.size()) > 1) {
            for (n = 0; n < (n3 - n2) / 2; ++n) {
                GametypeTDM.sendClassMenuToPlayer(this.getPlayer(GametypeTDM.teamsManager.teams[1].addPlayer(GametypeTDM.teamsManager.teams[0].removeWorstPlayer())));
            }
        }
        if (n2 - n3 > 1) {
            for (n = 0; n < (n2 - n3) / 2; ++n) {
                GametypeTDM.sendClassMenuToPlayer(this.getPlayer(GametypeTDM.teamsManager.teams[0].addPlayer(GametypeTDM.teamsManager.teams[1].removeWorstPlayer())));
            }
        }
    }

    @Override
    public void playerJoined(EntityPlayerMP entityPlayerMP) {
        GametypeTDM.sendTeamsMenuToPlayer(entityPlayerMP);
    }

    @Override
    public boolean playerChoseTeam(EntityPlayerMP entityPlayerMP, Team team, Team team2) {
        int n;
        int n2;
        int n3;
        if (GametypeTDM.teamsManager.teams == null || GametypeTDM.teamsManager.teams[0] == null || GametypeTDM.teamsManager.teams[1] == null) {
            return false;
        }
        if (team == Team.spectators) {
            return true;
        }
        if (this.autoBalance && (n2 = team.members.size()) > (n = (n3 = GametypeTDM.teamsManager.teams[0].members.size() + GametypeTDM.teamsManager.teams[1].members.size()) - n2)) {
            return false;
        }
        if (team2 != null && team2 != Team.spectators && team2 != team && GametypeTDM.isAValidTeam(team2, true)) {
            ++GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).deaths;
            --GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
            GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).playerClass = null;
            GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).newPlayerClass = null;
        }
        GametypeTDM.sendClassMenuToPlayer(entityPlayerMP);
        if (team != team2) {
            teamsManager.forceRespawn(entityPlayerMP);
        }
        return true;
    }

    @Override
    public boolean playerChoseClass(EntityPlayerMP entityPlayerMP, PlayerClass playerClass) {
        Team team = GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).team;
        if (!team.classes.contains(playerClass)) {
            return false;
        }
        GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).newPlayerClass = playerClass;
        if (GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).playerClass == null) {
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
        if (GametypeTDM.getPlayerData(entityPlayerMP) == null || GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).team == null) {
            return false;
        }
        if (this.newRoundTimer > 0) {
            return false;
        }
        EntityPlayerMP entityPlayerMP2 = GametypeTDM.getPlayerFromDamageSource(pico2);
        if (entityPlayerMP2 != null) {
            if (GametypeTDM.getPlayerData(entityPlayerMP2) == null || GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP2).team == null) {
                return false;
            }
            if (GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP2).team == Team.spectators) {
                return false;
            }
            if (GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).team == GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP2).team) {
                return this.friendlyFire;
            }
        }
        return GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).team != Team.spectators;
    }

    @Override
    public void playerKilled(EntityPlayerMP entityPlayerMP, pico pico2) {
        EntityPlayerMP entityPlayerMP2 = GametypeTDM.getPlayerFromDamageSource(pico2);
        if (entityPlayerMP2 != null) {
            if (entityPlayerMP2 == entityPlayerMP) {
                --GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
            } else {
                GametypeTDM.givePoints(entityPlayerMP2, 1);
                ++GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP2).kills;
            }
        } else {
            --GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
        }
        ++GametypeTDM.getPlayerData((EntityPlayerMP)entityPlayerMP).deaths;
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
    }

    @Override
    public samw getSpawnPoint(EntityPlayerMP entityPlayerMP) {
        FlansModPlayerData flansModPlayerData = GametypeTDM.getPlayerData(entityPlayerMP);
        ArrayList<ITeamObject> arrayList = new ArrayList<ITeamObject>();
        if (flansModPlayerData.team == null) {
            return null;
        }
        for (int i = 0; i < flansModPlayerData.team.bases.size(); ++i) {
            ITeamBase iTeamBase = flansModPlayerData.team.bases.get(i);
            if (iTeamBase.getMap() != GametypeTDM.teamsManager.currentMap) continue;
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
        this.scoreLimit = hsus2._f("TDMScoreLimit");
        this.friendlyFire = hsus2._o("TDMFriendlyFire");
        this.autoBalance = hsus2._o("TDMAutoBalance");
    }

    @Override
    public void saveToNBT(hsus hsus2) {
        hsus2._a("TDMScoreLimit", this.scoreLimit);
        hsus2._a("TDMFriendlyFire", this.friendlyFire);
        hsus2._a("TDMAutoBalance", this.autoBalance);
    }

    @Override
    public boolean sortScoreboardByTeam() {
        return true;
    }
}

