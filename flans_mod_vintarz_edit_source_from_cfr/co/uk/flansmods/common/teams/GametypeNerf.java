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
import co.uk.flansmods.common.guns.EntityDamageSourceGun;
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

public class GametypeNerf
extends Gametype {
    public boolean friendlyFire = false;
    public boolean autoBalance = true;
    public int scoreLimit = 25;
    public int newRoundTimer = 0;
    public int time;
    public int autoBalanceInterval = 1200;

    public GametypeNerf() {
        super("Nerf Team Deathmatch", "Nerf", 2);
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
        GametypeNerf.resetScores();
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
        if (GametypeNerf.teamsManager.teams != null) {
            for (Team team : GametypeNerf.teamsManager.teams) {
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
        if (GametypeNerf.teamsManager.teams == null || GametypeNerf.teamsManager.teams[0] == null || GametypeNerf.teamsManager.teams[1] == null) {
            return false;
        }
        int n2 = GametypeNerf.teamsManager.teams[0].members.size();
        return Math.abs(n2 - (n = GametypeNerf.teamsManager.teams[1].members.size())) > 1;
    }

    public void autobalance() {
        int n;
        int n2;
        if (GametypeNerf.teamsManager.teams == null || GametypeNerf.teamsManager.teams[0] == null || GametypeNerf.teamsManager.teams[1] == null) {
            return;
        }
        int n3 = GametypeNerf.teamsManager.teams[0].members.size();
        if (n3 - (n2 = GametypeNerf.teamsManager.teams[1].members.size()) > 1) {
            for (n = 0; n < (n3 - n2) / 2; ++n) {
                GametypeNerf.sendClassMenuToPlayer(this.getPlayer(GametypeNerf.teamsManager.teams[1].addPlayer(GametypeNerf.teamsManager.teams[0].removeWorstPlayer())));
            }
        }
        if (n2 - n3 > 1) {
            for (n = 0; n < (n2 - n3) / 2; ++n) {
                GametypeNerf.sendClassMenuToPlayer(this.getPlayer(GametypeNerf.teamsManager.teams[0].addPlayer(GametypeNerf.teamsManager.teams[1].removeWorstPlayer())));
            }
        }
    }

    @Override
    public void playerJoined(EntityPlayerMP entityPlayerMP) {
        GametypeNerf.sendTeamsMenuToPlayer(entityPlayerMP);
    }

    @Override
    public boolean playerChoseTeam(EntityPlayerMP entityPlayerMP, Team team, Team team2) {
        int n;
        int n2;
        int n3;
        if (GametypeNerf.teamsManager.teams == null || GametypeNerf.teamsManager.teams[0] == null || GametypeNerf.teamsManager.teams[1] == null) {
            return false;
        }
        if (this.autoBalance && (n2 = team.members.size()) > (n = (n3 = GametypeNerf.teamsManager.teams[0].members.size() + GametypeNerf.teamsManager.teams[1].members.size()) - n2)) {
            return false;
        }
        if (team2 != null && team2 != Team.spectators && team2 != team && GametypeNerf.isAValidTeam(team2, true)) {
            ++GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).deaths;
            --GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
            GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).playerClass = null;
            GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).newPlayerClass = null;
        }
        GametypeNerf.sendClassMenuToPlayer(entityPlayerMP);
        if (team != team2) {
            teamsManager.forceRespawn(entityPlayerMP);
        }
        return true;
    }

    @Override
    public boolean playerChoseClass(EntityPlayerMP entityPlayerMP, PlayerClass playerClass) {
        Team team = GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).team;
        if (!team.classes.contains(playerClass)) {
            return false;
        }
        GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).newPlayerClass = playerClass;
        if (GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).playerClass == null) {
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
        if (GametypeNerf.getPlayerData(entityPlayerMP) == null || GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).team == null) {
            return false;
        }
        if (this.newRoundTimer > 0) {
            return false;
        }
        if (GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).out) {
            return false;
        }
        if (GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).team == Team.spectators) {
            return false;
        }
        EntityPlayerMP entityPlayerMP2 = GametypeNerf.getPlayerFromDamageSource(pico2);
        if (entityPlayerMP2 != null) {
            if (GametypeNerf.getPlayerData(entityPlayerMP2) == null || GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP2).team == null) {
                return false;
            }
            if (GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP2).team == Team.spectators) {
                return false;
            }
            if (GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).team == GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP2).team && !this.friendlyFire) {
                return false;
            }
            if (GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP2).out) {
                return false;
            }
            if (pico2 instanceof EntityDamageSourceGun) {
                GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).out = true;
                GametypeNerf.givePoints(entityPlayerMP2, 1);
                ++GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP2).kills;
                ++GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).deaths;
                entityPlayerMP.func_71035_c("You are hit. Go back to base to respawn");
                entityPlayerMP2.func_71035_c("You hit " + entityPlayerMP.field_71092_bJ + ". He is out until he returns to base");
            }
        }
        return false;
    }

    @Override
    public void playerKilled(EntityPlayerMP entityPlayerMP, pico pico2) {
    }

    @Override
    public void baseAttacked(ITeamBase iTeamBase, pico pico2) {
    }

    @Override
    public void objectAttacked(ITeamObject iTeamObject, pico pico2) {
    }

    @Override
    public void baseClickedByPlayer(ITeamBase iTeamBase, EntityPlayerMP entityPlayerMP) {
        if (GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).out) {
            GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).out = false;
            entityPlayerMP.func_71035_c("You are back in the game!");
        }
    }

    @Override
    public void objectClickedByPlayer(ITeamObject iTeamObject, EntityPlayerMP entityPlayerMP) {
        if (GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).out) {
            GametypeNerf.getPlayerData((EntityPlayerMP)entityPlayerMP).out = false;
            entityPlayerMP.func_71035_c("You are back in the game!");
        }
    }

    @Override
    public samw getSpawnPoint(EntityPlayerMP entityPlayerMP) {
        FlansModPlayerData flansModPlayerData = GametypeNerf.getPlayerData(entityPlayerMP);
        ArrayList<ITeamObject> arrayList = new ArrayList<ITeamObject>();
        if (flansModPlayerData.team == null) {
            return null;
        }
        for (int i = 0; i < flansModPlayerData.team.bases.size(); ++i) {
            ITeamBase iTeamBase = flansModPlayerData.team.bases.get(i);
            if (iTeamBase.getMap() != GametypeNerf.teamsManager.currentMap) continue;
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

