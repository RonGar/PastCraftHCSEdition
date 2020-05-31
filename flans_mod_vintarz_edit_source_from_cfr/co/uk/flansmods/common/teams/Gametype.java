/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.common.network.Player
 *  cpw.mods.fml.common.uxsf
 *  cupi
 *  hsus
 *  maaq
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.util.pico
 *  net.minecraft.util.samw
 *  net.minecraft.util.uxrp
 *  net.minecraft.util.zwaq
 *  zgmv
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.network.PacketTeamSelect;
import co.uk.flansmods.common.teams.ITeamBase;
import co.uk.flansmods.common.teams.ITeamObject;
import co.uk.flansmods.common.teams.PlayerClass;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.uxsf;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.pico;
import net.minecraft.util.samw;
import net.minecraft.util.uxrp;
import net.minecraft.util.zwaq;

public abstract class Gametype {
    public static List<Gametype> gametypes = new ArrayList<Gametype>();
    public static TeamsManager teamsManager = TeamsManager.getInstance();
    public static Random rand = new Random();
    public String name;
    public String shortName;
    public int numTeamsRequired;

    public static Gametype getGametype(String string) {
        for (Gametype gametype : gametypes) {
            if (!gametype.shortName.equals(string)) continue;
            return gametype;
        }
        return null;
    }

    public Gametype(String string, String string2, int n) {
        this.name = string;
        this.shortName = string2;
        this.numTeamsRequired = n;
        gametypes.add(this);
    }

    public EntityPlayerMP getPlayer(String string) {
        return zgmv._a((zgmv)uxsf.instance().getMinecraftServerInstance())._h(string);
    }

    public static FlansModPlayerData getPlayerData(EntityPlayerMP entityPlayerMP) {
        return FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayerMP);
    }

    public static void sendPacketToPlayer(maaq maaq2, EntityPlayerMP entityPlayerMP) {
        PacketDispatcher.sendPacketToPlayer((maaq)maaq2, (Player)((Player)entityPlayerMP));
    }

    public static void sendTeamsMenuToPlayer(EntityPlayerMP entityPlayerMP) {
        if (Gametype.teamsManager.teams == null) {
            return;
        }
        Team[] arrteam = new Team[Gametype.teamsManager.teams.length + 1];
        for (int i = 0; i < Gametype.teamsManager.teams.length; ++i) {
            arrteam[i] = Gametype.teamsManager.teams[i];
        }
        arrteam[Gametype.teamsManager.teams.length] = Team.spectators;
        Gametype.getPlayerData((EntityPlayerMP)entityPlayerMP).team = Team.spectators;
        Gametype.sendPacketToPlayer(PacketTeamSelect.buildTeamChoicesPacket(arrteam), entityPlayerMP);
    }

    public static void sendClassMenuToPlayer(EntityPlayerMP entityPlayerMP) {
        Team team = Gametype.getPlayerData((EntityPlayerMP)entityPlayerMP).team;
        if (team == null) {
            Gametype.sendTeamsMenuToPlayer(entityPlayerMP);
        } else if (team != Team.spectators && team.classes.size() > 0) {
            Gametype.sendPacketToPlayer(PacketTeamSelect.buildClassChoicesPacket(team.classes.toArray(new PlayerClass[team.classes.size()])), entityPlayerMP);
        }
    }

    public static String[] getPlayerNames() {
        return zgmv._H()._i();
    }

    public static List<EntityPlayer> getPlayers() {
        return zgmv._H().__af()._e;
    }

    public static void showTeamsMenuToAll(boolean bl) {
        for (EntityPlayer entityPlayer : Gametype.getPlayers()) {
            if (Gametype.getPlayerData((EntityPlayerMP)entityPlayer) == null) continue;
            if (Gametype.getPlayerData((EntityPlayerMP)((EntityPlayerMP)entityPlayer)).team == null || !Gametype.isAValidTeam(Gametype.getPlayerData((EntityPlayerMP)((EntityPlayerMP)entityPlayer)).team, bl)) {
                Gametype.sendTeamsMenuToPlayer((EntityPlayerMP)entityPlayer);
                continue;
            }
            if (Gametype.getPlayerData((EntityPlayerMP)((EntityPlayerMP)entityPlayer)).playerClass != null) continue;
            Gametype.sendClassMenuToPlayer((EntityPlayerMP)entityPlayer);
        }
    }

    public static boolean isAValidTeam(Team team, boolean bl) {
        if (Gametype.teamsManager.teams == null) {
            return false;
        }
        if (team == Team.spectators && bl) {
            return true;
        }
        for (Team team2 : Gametype.teamsManager.teams) {
            if (team2 != team) continue;
            return true;
        }
        return false;
    }

    public static void resetScores() {
        if (Gametype.teamsManager.teams != null) {
            for (Team team : Gametype.teamsManager.teams) {
                if (team == null) continue;
                team.score = 0;
            }
        }
        for (EntityPlayer entityPlayer : Gametype.getPlayers()) {
            Gametype.getPlayerData((EntityPlayerMP)entityPlayer).resetScore();
        }
    }

    public static void respawnAll() {
        for (EntityPlayer entityPlayer : Gametype.getPlayers()) {
            TeamsManager.getInstance().forceRespawn((EntityPlayerMP)entityPlayer);
        }
    }

    public static void givePoints(EntityPlayerMP entityPlayerMP, int n) {
        FlansModPlayerData flansModPlayerData = Gametype.getPlayerData(entityPlayerMP);
        flansModPlayerData.score += n;
        if (flansModPlayerData.team != null) {
            flansModPlayerData.team.score += n;
        }
    }

    public static EntityPlayerMP getPlayerFromDamageSource(pico pico2) {
        EntityPlayerMP entityPlayerMP = null;
        if (pico2 instanceof zwaq && ((zwaq)pico2).func_76346_g() instanceof EntityPlayerMP) {
            entityPlayerMP = (EntityPlayerMP)((zwaq)pico2).func_76346_g();
        }
        if (pico2 instanceof uxrp && ((uxrp)pico2).func_76364_f() instanceof EntityPlayerMP) {
            entityPlayerMP = (EntityPlayerMP)((uxrp)pico2).func_76364_f();
        }
        return entityPlayerMP;
    }

    public abstract void teamsSet();

    public abstract void initGametype();

    public void startNewRound() {
        FlansModPlayerHandler.roundEnded();
        for (ITeamBase iTeamBase : Gametype.teamsManager.bases) {
            iTeamBase.startRound();
        }
        Gametype.respawnAll();
        for (EntityPlayer entityPlayer : Gametype.getPlayers()) {
            Gametype.getPlayerData((EntityPlayerMP)((EntityPlayerMP)entityPlayer)).playerClass = null;
            Gametype.getPlayerData((EntityPlayerMP)((EntityPlayerMP)entityPlayer)).newPlayerClass = null;
            if (Gametype.getPlayerData((EntityPlayerMP)((EntityPlayerMP)entityPlayer)).team == null) continue;
            Gametype.getPlayerData((EntityPlayerMP)((EntityPlayerMP)entityPlayer)).team.removePlayer(entityPlayer);
        }
        Gametype.resetScores();
        TeamsManager.messageAll("\u00a7fA new round has started!");
        if (Gametype.teamsManager.teams != null) {
            for (Team team : Gametype.teamsManager.teams) {
                if (team != null) continue;
                return;
            }
            Gametype.showTeamsMenuToAll(false);
        }
    }

    public void stopGametype() {
        FlansModPlayerHandler.roundEnded();
    }

    public abstract void tick();

    public abstract void playerJoined(EntityPlayerMP var1);

    public abstract void playerRespawned(EntityPlayerMP var1);

    public abstract void playerQuit(EntityPlayerMP var1);

    public abstract boolean playerChoseTeam(EntityPlayerMP var1, Team var2, Team var3);

    public abstract boolean playerChoseClass(EntityPlayerMP var1, PlayerClass var2);

    public abstract boolean playerAttacked(EntityPlayerMP var1, pico var2);

    public abstract void playerKilled(EntityPlayerMP var1, pico var2);

    public abstract void baseAttacked(ITeamBase var1, pico var2);

    public abstract void objectAttacked(ITeamObject var1, pico var2);

    public abstract void baseClickedByPlayer(ITeamBase var1, EntityPlayerMP var2);

    public abstract void objectClickedByPlayer(ITeamObject var1, EntityPlayerMP var2);

    public abstract samw getSpawnPoint(EntityPlayerMP var1);

    public abstract boolean setVariable(String var1, String var2);

    public abstract void readFromNBT(hsus var1);

    public abstract void saveToNBT(hsus var1);

    public abstract boolean sortScoreboardByTeam();
}

