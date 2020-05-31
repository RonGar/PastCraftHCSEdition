/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  hsus
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.util.pico
 *  net.minecraft.util.rojd
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.pico;
import net.minecraft.util.rojd;
import net.minecraft.util.samw;

public class GametypeConquest
extends Gametype {
    public boolean friendlyFire = false;
    public boolean autoBalance = true;
    public int newRoundTimer = 0;
    public int time;
    public int autoBalanceInterval = 1200;
    public int baseRange = 5;
    public int captureTimerLimit = 400;
    public HashMap<Integer, Integer> captureTimers = new HashMap();

    public GametypeConquest() {
        super("Conquest (Broken)", "CON", 2);
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
        GametypeConquest.resetScores();
    }

    @Override
    public void tick() {
        Object object;
        --this.newRoundTimer;
        if (this.newRoundTimer == 0) {
            if (FlansMod.useRotation) {
                TeamsManager.getInstance().switchToNextGametype();
                return;
            }
            this.startNewRound();
        }
        if (GametypeConquest.teamsManager.teams != null) {
            for (int i = 0; i < 2; ++i) {
                Team object2 = GametypeConquest.teamsManager.teams[i];
                if (object2 == null || object2.bases.size() != 0 || this.newRoundTimer >= 0) continue;
                boolean team = false;
                for (String string : object2.members) {
                    object = this.getPlayer(string);
                    if (object == null || ((EntityPlayer)object).field_70128_L) continue;
                    team = true;
                }
                if (team) continue;
                Team n = GametypeConquest.teamsManager.teams[1 - i];
                TeamsManager.messageAll("\u00a7" + n.textColour + n.name + "\u00a7f won!");
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
        for (ITeamBase iTeamBase : GametypeConquest.teamsManager.bases) {
            Team team = iTeamBase.getOwner();
            if (team == null || team == Team.spectators) continue;
            int n = this.captureTimers.containsKey(iTeamBase.getID()) ? this.captureTimers.get(iTeamBase.getID()) : 0;
            List list = iTeamBase.getWorld().func_72872_a(EntityPlayerMP.class, rojd.func_72330_a((double)(iTeamBase.getPosX() - (double)this.baseRange), (double)(iTeamBase.getPosY() - (double)this.baseRange), (double)(iTeamBase.getPosZ() - (double)this.baseRange), (double)(iTeamBase.getPosX() + (double)this.baseRange), (double)(iTeamBase.getPosY() + (double)this.baseRange), (double)(iTeamBase.getPosZ() + (double)this.baseRange)));
            object = new ArrayList();
            for (Object object2 : list) {
                EntityPlayerMP entityPlayerMP = (EntityPlayerMP)object2;
                if (GametypeConquest.getPlayerData(entityPlayerMP) == null) continue;
                Team team2 = GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).team;
                if (team2 != team && team2 != Team.spectators && team2 != null && !entityPlayerMP.field_70128_L) {
                    object.add(entityPlayerMP);
                }
                if (team2 != team) continue;
                object = new ArrayList();
                break;
            }
            n = object.size() == 0 ? 0 : (n += object.size());
            if (n >= this.captureTimerLimit) {
                Object object2;
                Team team3 = GametypeConquest.getPlayerData((EntityPlayerMP)((EntityPlayerMP)object.get((int)0))).team;
                iTeamBase.captureBase(team3);
                for (ITeamObject iTeamObject : iTeamBase.getObjects()) {
                    iTeamObject.onBaseCapture(team3);
                }
                object2 = object.iterator();
                while (object2.hasNext()) {
                    EntityPlayerMP entityPlayerMP = (EntityPlayerMP)object2.next();
                    GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).score += 5;
                }
                n = 0;
            }
            this.captureTimers.put(iTeamBase.getID(), n);
        }
    }

    public boolean needAutobalance() {
        int n;
        if (GametypeConquest.teamsManager.teams == null || GametypeConquest.teamsManager.teams[0] == null || GametypeConquest.teamsManager.teams[1] == null) {
            return false;
        }
        int n2 = GametypeConquest.teamsManager.teams[0].members.size();
        return Math.abs(n2 - (n = GametypeConquest.teamsManager.teams[1].members.size())) > 1;
    }

    public void autobalance() {
        int n;
        int n2;
        if (GametypeConquest.teamsManager.teams == null || GametypeConquest.teamsManager.teams[0] == null || GametypeConquest.teamsManager.teams[1] == null) {
            return;
        }
        int n3 = GametypeConquest.teamsManager.teams[0].members.size();
        if (n3 - (n2 = GametypeConquest.teamsManager.teams[1].members.size()) > 1) {
            for (n = 0; n < (n3 - n2) / 2; ++n) {
                GametypeConquest.sendClassMenuToPlayer(this.getPlayer(GametypeConquest.teamsManager.teams[1].addPlayer(GametypeConquest.teamsManager.teams[0].removeWorstPlayer())));
            }
        }
        if (n2 - n3 > 1) {
            for (n = 0; n < (n2 - n3) / 2; ++n) {
                GametypeConquest.sendClassMenuToPlayer(this.getPlayer(GametypeConquest.teamsManager.teams[0].addPlayer(GametypeConquest.teamsManager.teams[1].removeWorstPlayer())));
            }
        }
    }

    @Override
    public void playerJoined(EntityPlayerMP entityPlayerMP) {
        GametypeConquest.sendTeamsMenuToPlayer(entityPlayerMP);
    }

    @Override
    public boolean playerChoseTeam(EntityPlayerMP entityPlayerMP, Team team, Team team2) {
        int n;
        int n2;
        int n3;
        if (this.autoBalance && (n2 = team.members.size()) > (n = (n3 = GametypeConquest.teamsManager.teams[0].members.size() + GametypeConquest.teamsManager.teams[1].members.size()) - n2)) {
            return false;
        }
        if (team2 != null && team2 != Team.spectators && team2 != team && GametypeConquest.isAValidTeam(team2, true)) {
            ++GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).deaths;
            --GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
            GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).playerClass = null;
            GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).newPlayerClass = null;
        }
        GametypeConquest.sendClassMenuToPlayer(entityPlayerMP);
        if (team != team2) {
            teamsManager.forceRespawn(entityPlayerMP);
        }
        return true;
    }

    @Override
    public boolean playerChoseClass(EntityPlayerMP entityPlayerMP, PlayerClass playerClass) {
        Team team = GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).team;
        if (!team.classes.contains(playerClass)) {
            return false;
        }
        GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).newPlayerClass = playerClass;
        if (GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).playerClass == null) {
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
        if (GametypeConquest.getPlayerData(entityPlayerMP) == null || GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).team == null) {
            return false;
        }
        if (this.newRoundTimer > 0) {
            return false;
        }
        EntityPlayerMP entityPlayerMP2 = GametypeConquest.getPlayerFromDamageSource(pico2);
        if (entityPlayerMP2 != null) {
            if (GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP2).team == Team.spectators) {
                return false;
            }
            if (GametypeConquest.getPlayerData(entityPlayerMP2) == null || GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP2).team == null) {
                return false;
            }
            if (GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).team == GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP2).team) {
                return this.friendlyFire;
            }
        }
        return GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).team != Team.spectators;
    }

    @Override
    public void playerKilled(EntityPlayerMP entityPlayerMP, pico pico2) {
        EntityPlayerMP entityPlayerMP2 = GametypeConquest.getPlayerFromDamageSource(pico2);
        if (entityPlayerMP2 != null) {
            if (entityPlayerMP2 == entityPlayerMP) {
                --GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
            } else {
                GametypeConquest.givePoints(entityPlayerMP2, 1);
                ++GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP2).kills;
            }
        } else {
            --GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).score;
        }
        ++GametypeConquest.getPlayerData((EntityPlayerMP)entityPlayerMP).deaths;
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
        FlansModPlayerData flansModPlayerData = GametypeConquest.getPlayerData(entityPlayerMP);
        ArrayList<ITeamObject> arrayList = new ArrayList<ITeamObject>();
        if (flansModPlayerData.team == null) {
            return null;
        }
        for (ITeamBase iTeamBase : flansModPlayerData.team.bases) {
            for (ITeamObject iTeamObject : iTeamBase.getObjects()) {
                if (!iTeamObject.isSpawnPoint()) continue;
                arrayList.add(iTeamObject);
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
        if (string.toLowerCase().equals("friendlyfire")) {
            this.friendlyFire = Boolean.parseBoolean(string2);
            return true;
        }
        if (string.toLowerCase().equals("capturetime")) {
            this.captureTimerLimit = Integer.parseInt(string2) * 20;
            if (this.captureTimerLimit <= 0) {
                this.captureTimerLimit = 400;
            }
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
        this.friendlyFire = hsus2._o("ConqFriendlyFire");
        this.autoBalance = hsus2._o("ConqAutoBalance");
        this.captureTimerLimit = hsus2._f("ConqCaptureTime");
        if (this.captureTimerLimit <= 0) {
            this.captureTimerLimit = 400;
        }
    }

    @Override
    public void saveToNBT(hsus hsus2) {
        hsus2._a("ConqFriendlyFire", this.friendlyFire);
        hsus2._a("ConqAutoBalance", this.autoBalance);
        hsus2._a("ConqCaptureTime", this.captureTimerLimit);
    }

    @Override
    public boolean sortScoreboardByTeam() {
        return true;
    }
}

