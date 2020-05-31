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
import co.uk.flansmods.common.FlansModPlayerHandler;
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

public class GametypeDM
extends Gametype {
    public int scoreLimit = 25;
    public int newRoundTimer = 0;
    public int time;

    public GametypeDM() {
        super("Deathmatch", "DM", 2);
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
    public void startNewRound() {
        GametypeDM.respawnAll();
        for (EntityPlayer entityPlayer : GametypeDM.getPlayers()) {
            GametypeDM.getPlayerData((EntityPlayerMP)((EntityPlayerMP)entityPlayer)).playerClass = null;
            GametypeDM.getPlayerData((EntityPlayerMP)((EntityPlayerMP)entityPlayer)).newPlayerClass = null;
            if (GametypeDM.getPlayerData((EntityPlayerMP)((EntityPlayerMP)entityPlayer)).team == null) continue;
            GametypeDM.getPlayerData((EntityPlayerMP)((EntityPlayerMP)entityPlayer)).team.removePlayer(entityPlayer);
        }
        GametypeDM.resetScores();
        TeamsManager.messageAll("\u00a7fA new round has started!");
        if (GametypeDM.teamsManager.teams != null) {
            for (Team team : GametypeDM.teamsManager.teams) {
                if (team != null) continue;
                return;
            }
            GametypeDM.showTeamsMenuToAll(false);
        }
    }

    @Override
    public void stopGametype() {
        GametypeDM.resetScores();
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
        if (GametypeDM.teamsManager.teams != null) {
            for (Team team : GametypeDM.teamsManager.teams) {
                if (team == null) continue;
                for (String string : team.members) {
                    FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData(string);
                    if (flansModPlayerData.score < this.scoreLimit || this.newRoundTimer >= 0) continue;
                    TeamsManager.messageAll(string + "\u00a7f won!");
                    this.newRoundTimer = 200;
                    TeamsManager.messageAll("\u00a7fThe next round will start in 10 seconds");
                    this.time = -300;
                }
            }
        }
        ++this.time;
    }

    @Override
    public void playerJoined(EntityPlayerMP entityPlayerMP) {
        GametypeDM.sendTeamsMenuToPlayer(entityPlayerMP);
    }

    @Override
    public boolean playerChoseTeam(EntityPlayerMP entityPlayerMP, Team team, Team team2) {
        if (team2 != null && team2 != Team.spectators && team2 != team && GametypeDM.isAValidTeam(team2, true)) {
            ++GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP).deaths;
            --GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
            GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP).playerClass = null;
            GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP).newPlayerClass = null;
        }
        GametypeDM.sendClassMenuToPlayer(entityPlayerMP);
        if (team != team2) {
            teamsManager.forceRespawn(entityPlayerMP);
        }
        return true;
    }

    @Override
    public boolean playerChoseClass(EntityPlayerMP entityPlayerMP, PlayerClass playerClass) {
        Team team = GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP).team;
        if (!team.classes.contains(playerClass)) {
            return false;
        }
        GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP).newPlayerClass = playerClass;
        if (GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP).playerClass == null) {
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
        if (GametypeDM.getPlayerData(entityPlayerMP) == null || GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP).team == null) {
            return false;
        }
        if (this.newRoundTimer > 0) {
            return false;
        }
        EntityPlayerMP entityPlayerMP2 = GametypeDM.getPlayerFromDamageSource(pico2);
        if (entityPlayerMP2 != null) {
            if (GametypeDM.getPlayerData(entityPlayerMP2) == null || GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP2).team == null) {
                return false;
            }
            if (GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP2).team == Team.spectators) {
                return false;
            }
        }
        return GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP).team != Team.spectators;
    }

    @Override
    public void playerKilled(EntityPlayerMP entityPlayerMP, pico pico2) {
        EntityPlayerMP entityPlayerMP2 = GametypeDM.getPlayerFromDamageSource(pico2);
        if (entityPlayerMP2 != null) {
            if (entityPlayerMP2 == entityPlayerMP) {
                --GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
            } else {
                ++GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP2).score;
                ++GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP2).kills;
            }
        } else {
            --GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
        }
        ++GametypeDM.getPlayerData((EntityPlayerMP)entityPlayerMP).deaths;
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
        ArrayList<ITeamObject> arrayList = new ArrayList<ITeamObject>();
        FlansModPlayerData flansModPlayerData = GametypeDM.getPlayerData(entityPlayerMP);
        if (flansModPlayerData != null && flansModPlayerData.team == Team.spectators) {
            for (int i = 0; i < flansModPlayerData.team.bases.size(); ++i) {
                ITeamBase iTeamBase = flansModPlayerData.team.bases.get(i);
                if (iTeamBase.getMap() != GametypeDM.teamsManager.currentMap) continue;
                for (int j = 0; j < iTeamBase.getObjects().size(); ++j) {
                    if (!iTeamBase.getObjects().get(j).isSpawnPoint()) continue;
                    arrayList.add(iTeamBase.getObjects().get(j));
                }
            }
        } else {
            Team[] arrteam = GametypeDM.teamsManager.teams;
            int n = arrteam.length;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < flansModPlayerData.team.bases.size(); ++j) {
                    ITeamBase iTeamBase = flansModPlayerData.team.bases.get(j);
                    if (iTeamBase.getMap() != GametypeDM.teamsManager.currentMap) continue;
                    for (int k = 0; k < iTeamBase.getObjects().size(); ++k) {
                        if (!iTeamBase.getObjects().get(k).isSpawnPoint()) continue;
                        arrayList.add(iTeamBase.getObjects().get(k));
                    }
                }
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
        return false;
    }

    @Override
    public void readFromNBT(hsus hsus2) {
        this.scoreLimit = hsus2._f("DMScoreLimit");
    }

    @Override
    public void saveToNBT(hsus hsus2) {
        hsus2._a("DMScoreLimit", this.scoreLimit);
    }

    @Override
    public boolean sortScoreboardByTeam() {
        return false;
    }
}

