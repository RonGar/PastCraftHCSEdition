/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  antf
 *  cupi
 *  hcsmod.server.SPacketHandler
 *  ieta
 *  jhvs
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.hrml
 *  net.minecraft.util.hrmy
 *  tvhk
 *  zgmv
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.guns.AttachmentType;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.guns.EnumFireMode;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemAttachment;
import co.uk.flansmods.common.guns.ItemBullet;
import co.uk.flansmods.common.guns.ItemGun;
import co.uk.flansmods.common.teams.Gametype;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import co.uk.flansmods.vintarz.AttachmentTypeMod;
import co.uk.flansmods.vintarz.BulletTypeMod;
import co.uk.flansmods.vintarz.GunTypeMod;
import hcsmod.server.SPacketHandler;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.rojd;
import net.minecraft.util.hrml;
import net.minecraft.util.hrmy;

public class CommandTeams
extends tvhk {
    public static TeamsManager teamsManager = TeamsManager.getInstance();

    public String func_71517_b() {
        return "teams";
    }

    public boolean func_82358_a(String[] arrstring, int n) {
        return arrstring.length == 2 && arrstring[0].equals("replicate");
    }

    public void func_71515_b(antf antf2, String[] arrstring) {
        if (teamsManager == null) {
            antf2.func_70006_a(hrmy._d((String)"Teams mod is broken. You will need to look at the server side logs to see what's wrong"));
            return;
        }
        if (arrstring == null || arrstring.length == 0 || arrstring[0].equals("help") || arrstring[0].equals("?")) {
            if (arrstring.length == 2) {
                this.sendHelpInformation(antf2, Integer.parseInt(arrstring[1]));
            } else {
                this.sendHelpInformation(antf2, 1);
            }
            return;
        }
        if (arrstring[0].equals("off")) {
            CommandTeams.teamsManager.currentGametype = null;
            TeamsManager.messageAll("Flan's Teams Mod disabled");
            return;
        }
        if (arrstring[0].equals("survival")) {
            FlansMod.explosions = true;
            FlansMod.bombsEnabled = true;
            FlansMod.bulletsEnabled = true;
            FlansMod.forceAdventureMode = false;
            FlansMod.canBreakGuns = true;
            FlansMod.canBreakGlass = true;
            FlansMod.armourDrops = true;
            FlansMod.weaponDrops = 1;
            FlansMod.vehiclesNeedFuel = true;
            FlansMod.mechaLove = 0;
            FlansMod.aaLife = 0;
            FlansMod.vehicleLife = 0;
            FlansMod.planeLife = 0;
            FlansMod.mgLife = 0;
            TeamsManager.messageAll("Flan's Mod switching to survival presets");
            return;
        }
        if (arrstring[0].equals("arena")) {
            FlansMod.explosions = false;
            FlansMod.driveablesBreakBlocks = false;
            FlansMod.bombsEnabled = true;
            FlansMod.bulletsEnabled = true;
            FlansMod.forceAdventureMode = true;
            FlansMod.canBreakGuns = true;
            FlansMod.canBreakGlass = false;
            FlansMod.armourDrops = false;
            FlansMod.weaponDrops = 2;
            FlansMod.vehiclesNeedFuel = false;
            FlansMod.mechaLove = 120;
            FlansMod.aaLife = 120;
            FlansMod.vehicleLife = 120;
            FlansMod.planeLife = 120;
            FlansMod.mgLife = 120;
            TeamsManager.messageAll("Flan's Mod switching to arena mode presets");
            return;
        }
        if (arrstring[0].equals("listGametypes")) {
            antf2.func_70006_a(hrmy._d((String)"\u00a72Showing all avaliable gametypes"));
            antf2.func_70006_a(hrmy._d((String)"\u00a72To pick a gametype, use \"/teams setGametype <gametype>\" with the name in brackets"));
            for (Gametype gametype : Gametype.gametypes) {
                antf2.func_70006_a(hrmy._d((String)("\u00a7f" + gametype.name + " (" + gametype.shortName + ")")));
            }
            return;
        }
        if (arrstring[0].equals("setGametype")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)"\u00a74To set the gametype, use \"/teams setGametype <gametype>\" with a valid gametype."));
                return;
            }
            if (arrstring[1].toLowerCase().equals("none")) {
                if (CommandTeams.teamsManager.currentGametype != null) {
                    CommandTeams.teamsManager.currentGametype.stopGametype();
                }
                CommandTeams.teamsManager.currentGametype = null;
                for (FlansModPlayerData flansModPlayerData : FlansModPlayerHandler.serverSideData.values()) {
                    if (flansModPlayerData == null) continue;
                    flansModPlayerData.team = null;
                }
                return;
            }
            Gametype gametype = Gametype.getGametype(arrstring[1]);
            if (gametype == null) {
                antf2.func_70006_a(hrmy._d((String)"\u00a74Invalid gametype. To see gametypes available type \"/teams listGametypes\""));
                return;
            }
            if (CommandTeams.teamsManager.currentGametype != null) {
                CommandTeams.teamsManager.currentGametype.stopGametype();
            }
            CommandTeams.teamsManager.currentGametype = gametype;
            TeamsManager.messageAll("\u00a72" + antf2.func_70005_c_() + "\u00a7f changed the gametype to \u00a72" + gametype.name);
            if (CommandTeams.teamsManager.teams != null && gametype.numTeamsRequired == CommandTeams.teamsManager.teams.length) {
                TeamsManager.messageAll("\u00a7fTeams will remain the same unless altered by an op.");
            } else {
                CommandTeams.teamsManager.teams = new Team[gametype.numTeamsRequired];
                TeamsManager.messageAll("\u00a7fTeams must be reassigned for this gametype. Please wait for an op to do so.");
            }
            gametype.initGametype();
            return;
        }
        if (arrstring[0].equals("listMaps")) {
            if (CommandTeams.teamsManager.maps == null) {
                antf2.func_70006_a(hrmy._d((String)"The map list is null"));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)"\u00a72Listing maps and corresponding IDs"));
            for (int i = 0; i < CommandTeams.teamsManager.maps.size(); ++i) {
                TeamsManager.TeamsMap teamsMap = CommandTeams.teamsManager.maps.get(i);
                antf2.func_70006_a(hrmy._d((String)((teamsMap == CommandTeams.teamsManager.currentMap ? "\u00a74" : "") + i + ". " + teamsMap.name + " (" + teamsMap.shortName + ")")));
            }
            return;
        }
        if (arrstring[0].equals("addMap")) {
            if (arrstring.length < 3) {
                antf2.func_70006_a(hrmy._d((String)"You need to specify a map name"));
                return;
            }
            String string = arrstring[1];
            String string2 = arrstring[2];
            for (int i = 3; i < arrstring.length; ++i) {
                string2 = string2 + " " + arrstring[i];
            }
            CommandTeams.teamsManager.maps.add(new TeamsManager.TeamsMap(string, string2));
            antf2.func_70006_a(hrmy._d((String)("Added new map : " + string2 + " (" + string + ")")));
            return;
        }
        if (arrstring[0].equals("removeMap")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)"You need to specify a map's short name"));
                return;
            }
            TeamsManager.TeamsMap teamsMap = teamsManager.getTeamsMap(arrstring[1]);
            if (teamsMap != null) {
                CommandTeams.teamsManager.maps.remove(teamsMap);
            }
            antf2.func_70006_a(hrmy._d((String)("Removed map " + arrstring[1])));
            return;
        }
        if (arrstring[0].equals("setMap")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)"You need to specify a map's short name"));
                return;
            }
            TeamsManager.TeamsMap teamsMap = teamsManager.getTeamsMap(arrstring[1]);
            if (teamsMap != null) {
                TeamsManager.messageAll("\u00a72Map changed to " + teamsMap.name + ".");
                CommandTeams.teamsManager.currentMap = teamsMap;
                if (CommandTeams.teamsManager.currentGametype != null) {
                    CommandTeams.teamsManager.currentGametype.startNewRound();
                }
            }
            return;
        }
        if (arrstring[0].equals("listTeams")) {
            if (CommandTeams.teamsManager.currentGametype == null || CommandTeams.teamsManager.teams == null) {
                antf2.func_70006_a(hrmy._d((String)"\u00a74The gametype is not yet set. Set it by \"/teams setGametype <gametype>\""));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)"\u00a72Showing currently in use teams"));
            for (int i = 0; i < CommandTeams.teamsManager.teams.length; ++i) {
                Team team = CommandTeams.teamsManager.teams[i];
                if (team == null) {
                    antf2.func_70006_a(hrmy._d((String)("\u00a7f" + i + " : No team")));
                    continue;
                }
                antf2.func_70006_a(hrmy._d((String)("\u00a7" + team.textColour + i + " : " + team.name + " (" + team.shortName + ")")));
            }
            return;
        }
        if (arrstring[0].equals("listAllTeams")) {
            if (Team.teams.size() == 0) {
                antf2.func_70006_a(hrmy._d((String)"\u00a74No teams available. You need a content pack that has some teams with it"));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)"\u00a72Showing all avaliable teams"));
            antf2.func_70006_a(hrmy._d((String)"\u00a72To pick these teams, use /teams setTeams <team1> <team2> with the names in brackets"));
            for (Team team : Team.teams) {
                antf2.func_70006_a(hrmy._d((String)("\u00a7" + team.textColour + team.name + " (" + team.shortName + ")")));
            }
            return;
        }
        if (arrstring[0].equals("setTeams")) {
            if (CommandTeams.teamsManager.currentGametype == null || CommandTeams.teamsManager.teams == null) {
                antf2.func_70006_a(hrmy._d((String)"\u00a74No gametype selected. Please select the gametype with the setGametype command"));
                return;
            }
            if (arrstring.length - 1 != CommandTeams.teamsManager.teams.length) {
                antf2.func_70006_a(hrmy._d((String)("\u00a74Wrong number of teams given. This gametype requires " + CommandTeams.teamsManager.teams.length + " teams to work")));
                return;
            }
            Team[] arrteam = new Team[CommandTeams.teamsManager.teams.length];
            String string = "";
            for (int i = 0; i < arrstring.length - 1; ++i) {
                Team team = Team.getTeam(arrstring[i + 1]);
                if (team == null) {
                    antf2.func_70006_a(hrmy._d((String)("\u00a74" + arrstring[i + 1] + " is not a valid team")));
                    return;
                }
                for (int j = 0; j < i; ++j) {
                    if (team != arrteam[j]) continue;
                    antf2.func_70006_a(hrmy._d((String)("\u00a74You may not add " + arrstring[i + 1] + " twice")));
                    return;
                }
                arrteam[i] = team;
                string = string + (i == 0 ? "" : (i == arrstring.length - 2 ? " and " : ", ")) + "\u00a7" + team.textColour + team.name + "\u00a7f";
            }
            CommandTeams.teamsManager.teams = arrteam;
            CommandTeams.teamsManager.currentGametype.teamsSet();
            TeamsManager.messageAll("\u00a72" + antf2.func_70005_c_() + "\u00a7f changed the teams to be " + string);
            return;
        }
        if (arrstring[0].equals("getSticks") || arrstring[0].equals("getOpSticks") || arrstring[0].equals("getOpKit")) {
            EntityPlayerMP entityPlayerMP = this.getPlayer(antf2.func_70005_c_());
            if (entityPlayerMP != null) {
                entityPlayerMP.field_71071_by._c(new ieta(FlansMod.opStick, 1, 0));
                entityPlayerMP.field_71071_by._c(new ieta(FlansMod.opStick, 1, 1));
                entityPlayerMP.field_71071_by._c(new ieta(FlansMod.opStick, 1, 2));
                entityPlayerMP.field_71071_by._c(new ieta(FlansMod.opStick, 1, 3));
                antf2.func_70006_a(hrmy._d((String)"\u00a72Enjoy your op sticks."));
                antf2.func_70006_a(hrmy._d((String)"\u00a77The Stick of Connecting connects objects (spawners, banners etc) to bases (flagpoles etc)"));
                antf2.func_70006_a(hrmy._d((String)"\u00a77The Stick of Ownership sets the team that currently owns a base"));
                antf2.func_70006_a(hrmy._d((String)"\u00a77The Stick of Mapping sets the map that a base is currently associated with"));
                antf2.func_70006_a(hrmy._d((String)"\u00a77The Stick of Destruction deletes bases and team objects"));
            }
            return;
        }
        if (arrstring[0].equals("useRotation")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <true/false>")));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)("Map rotation is now " + ((FlansMod.useRotation = Boolean.parseBoolean(arrstring[1])) ? "enabled" : "disabled"))));
            return;
        }
        if (arrstring[0].equals("listRotation")) {
            antf2.func_70006_a(hrmy._d((String)"\u00a72Current Map Rotation"));
            for (int i = 0; i < TeamsManager.getInstance().rotation.size(); ++i) {
                TeamsManager.RotationEntry rotationEntry = TeamsManager.getInstance().rotation.get(i);
                String string = i + ". " + rotationEntry.map.shortName + ", " + rotationEntry.gametype.shortName;
                if (i == TeamsManager.getInstance().currentRotationEntry) {
                    string = "\u00a74" + string;
                }
                for (int j = 0; j < rotationEntry.teams.length; ++j) {
                    string = string + ", " + rotationEntry.teams[j].shortName;
                }
                antf2.func_70006_a(hrmy._d((String)string));
            }
            return;
        }
        if (arrstring[0].equals("removeMapFromRotation") || arrstring[0].equals("removeFromRotation") || arrstring[0].equals("removeRotation")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <ID>")));
                return;
            }
            int n = Integer.parseInt(arrstring[1]);
            antf2.func_70006_a(hrmy._d((String)("Removed map " + n + " (" + TeamsManager.getInstance().rotation.get((int)n).map.shortName + ") from rotation")));
            TeamsManager.getInstance().rotation.remove(n);
            return;
        }
        if (arrstring[0].equals("addMapToRotation") || arrstring[0].equals("addToRotation") || arrstring[0].equals("addRotation")) {
            if (arrstring.length < 5) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <Map> <Gametype> <Team1> <Team2> ...")));
                return;
            }
            TeamsManager.TeamsMap teamsMap = TeamsManager.getInstance().getTeamsMap(arrstring[1]);
            Gametype gametype = Gametype.getGametype(arrstring[2]);
            if (arrstring.length != 3 + gametype.numTeamsRequired) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <Map> <Gametype> <Team1> <Team2> ...")));
                return;
            }
            Team[] arrteam = new Team[gametype.numTeamsRequired];
            for (int i = 0; i < arrteam.length; ++i) {
                arrteam[i] = Team.getTeam(arrstring[3 + i]);
            }
            antf2.func_70006_a(hrmy._d((String)("Added map (" + teamsMap.shortName + ") to rotation")));
            TeamsManager.getInstance().rotation.add(new TeamsManager.RotationEntry(teamsMap, gametype, arrteam));
            return;
        }
        if (arrstring[0].equals("nextMap")) {
            teamsManager.switchToNextGametype();
            return;
        }
        if (arrstring[0].equals("goToMap")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <ID>")));
                return;
            }
            int n = Integer.parseInt(arrstring[1]) - 1;
            if (n == -1) {
                n = CommandTeams.teamsManager.rotation.size() - 1;
            }
            CommandTeams.teamsManager.currentRotationEntry = n;
            teamsManager.switchToNextGametype();
            return;
        }
        if (arrstring[0].equals("forceAdventure") || arrstring[0].equals("forceAdventureMode")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <true/false>")));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)("Adventure mode will " + ((FlansMod.forceAdventureMode = Boolean.parseBoolean(arrstring[1])) ? "now" : "no longer") + " be forced")));
            return;
        }
        if (arrstring[0].equals("explosions")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <true/false>")));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)("Expolsions are now " + ((FlansMod.explosions = Boolean.parseBoolean(arrstring[1])) ? "enabled" : "disabled"))));
            return;
        }
        if (arrstring[0].equals("bombs") || arrstring[0].equals("allowBombs")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <true/false>")));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)("Bombs are now " + ((FlansMod.bombsEnabled = Boolean.parseBoolean(arrstring[1])) ? "enabled" : "disabled"))));
            return;
        }
        if (arrstring[0].equals("bullets") || arrstring[0].equals("bulletsEnabled")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <true/false>")));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)("Bullets are now " + ((FlansMod.bulletsEnabled = Boolean.parseBoolean(arrstring[1])) ? "enabled" : "disabled"))));
            return;
        }
        if (arrstring[0].equals("canBreakGuns")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <true/false>")));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)("AAGuns and MGs can " + ((FlansMod.canBreakGuns = Boolean.parseBoolean(arrstring[1])) ? "now" : "no longer") + " be broken")));
            return;
        }
        if (arrstring[0].equals("canBreakGlass")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <true/false>")));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)("Glass and glowstone can " + ((FlansMod.canBreakGlass = Boolean.parseBoolean(arrstring[1])) ? "now" : "no longer") + " be broken")));
            return;
        }
        if (arrstring[0].equals("armourDrops") || arrstring[0].equals("armorDrops")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <true/false>")));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)("Armour will " + ((FlansMod.armourDrops = Boolean.parseBoolean(arrstring[1])) ? "now" : "no longer") + " be dropped")));
            return;
        }
        if (arrstring[0].equals("weaponDrops")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <on/off/smart>")));
                return;
            }
            if (arrstring[1].toLowerCase().equals("on")) {
                FlansMod.weaponDrops = 1;
                antf2.func_70006_a(hrmy._d((String)"Weapons will be dropped normally"));
            } else if (arrstring[1].toLowerCase().equals("off")) {
                FlansMod.weaponDrops = 0;
                antf2.func_70006_a(hrmy._d((String)"Weapons will be not be dropped"));
            } else if (arrstring[1].toLowerCase().equals("smart")) {
                FlansMod.weaponDrops = 2;
                antf2.func_70006_a(hrmy._d((String)"Smart drops enabled"));
            }
            return;
        }
        if (arrstring[0].equals("fuelNeeded")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <true/false>")));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)("Vehicles will " + ((FlansMod.vehiclesNeedFuel = Boolean.parseBoolean(arrstring[1])) ? "now" : "no longer") + " require fuel")));
            return;
        }
        if (arrstring[0].equals("mgLife")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <time>")));
                return;
            }
            FlansMod.mgLife = Integer.parseInt(arrstring[1]);
            if (FlansMod.mgLife > 0) {
                antf2.func_70006_a(hrmy._d((String)("MGs will despawn after " + FlansMod.mgLife + " seconds")));
            } else {
                antf2.func_70006_a(hrmy._d((String)"MGs will not despawn"));
            }
            return;
        }
        if (arrstring[0].equals("planeLife")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <time>")));
                return;
            }
            FlansMod.planeLife = Integer.parseInt(arrstring[1]);
            if (FlansMod.planeLife > 0) {
                antf2.func_70006_a(hrmy._d((String)("Planes will despawn after " + FlansMod.planeLife + " seconds")));
            } else {
                antf2.func_70006_a(hrmy._d((String)"Planes will not despawn"));
            }
            return;
        }
        if (arrstring[0].equals("vehicleLife")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <time>")));
                return;
            }
            FlansMod.vehicleLife = Integer.parseInt(arrstring[1]);
            if (FlansMod.vehicleLife > 0) {
                antf2.func_70006_a(hrmy._d((String)("Vehicles will despawn after " + FlansMod.vehicleLife + " seconds")));
            } else {
                antf2.func_70006_a(hrmy._d((String)"Vehicles will not despawn"));
            }
            return;
        }
        if (arrstring[0].equals("mechaLife")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <time>")));
                return;
            }
            FlansMod.mechaLove = Integer.parseInt(arrstring[1]);
            if (FlansMod.mechaLove > 0) {
                antf2.func_70006_a(hrmy._d((String)("Mechas will despawn after " + FlansMod.mechaLove + " seconds")));
            } else {
                antf2.func_70006_a(hrmy._d((String)"Mechas will not despawn"));
            }
            return;
        }
        if (arrstring[0].equals("aaLife")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <time>")));
                return;
            }
            FlansMod.aaLife = Integer.parseInt(arrstring[1]);
            if (FlansMod.aaLife > 0) {
                antf2.func_70006_a(hrmy._d((String)("AA Guns will despawn after " + FlansMod.aaLife + " seconds")));
            } else {
                antf2.func_70006_a(hrmy._d((String)"AA Guns will not despawn"));
            }
            return;
        }
        if (arrstring[0].equals("vehiclesBreakBlocks")) {
            if (arrstring.length != 2) {
                antf2.func_70006_a(hrmy._d((String)("Incorrect Usage : Should be /teams " + arrstring[0] + " <true/false>")));
                return;
            }
            antf2.func_70006_a(hrmy._d((String)("Vehicles will " + (FlansMod.driveablesBreakBlocks ? "now" : "no longer") + " break blocks")));
            return;
        }
        if (arrstring[0].equals("setVariable")) {
            if (TeamsManager.getInstance().currentGametype == null) {
                antf2.func_70006_a(hrmy._d((String)"There is no gametype to set variables for"));
                return;
            }
            if (arrstring.length != 3) {
                antf2.func_70006_a(hrmy._d((String)"Incorrect Usage : Should be /teams setVariable <variable> <value>"));
                return;
            }
            if (TeamsManager.getInstance().currentGametype.setVariable(arrstring[1], arrstring[2])) {
                antf2.func_70006_a(hrmy._d((String)("Set variable " + arrstring[1] + " in gametype " + TeamsManager.getInstance().currentGametype.shortName + " to " + arrstring[2])));
            } else {
                antf2.func_70006_a(hrmy._d((String)("Variable " + arrstring[1] + " did not exist in gametype " + TeamsManager.getInstance().currentGametype.shortName)));
            }
            return;
        }
        if (antf2 instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)antf2;
            FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData(entityPlayer);
            if (arrstring.length == 1) {
                if (arrstring[0].equals("la")) {
                    flansModPlayerData.lockAmmo = !flansModPlayerData.lockAmmo;
                    SPacketHandler.sendHint((EntityPlayer)entityPlayer, (String)"gunla", (String)("Gun L.A. " + flansModPlayerData.lockAmmo), (int)20);
                    return;
                }
            } else if (arrstring.length == 2) {
                if (arrstring[0].equals("replicate")) {
                    EntityPlayerMP entityPlayerMP = zgmv._H().__af()._h(arrstring[1]);
                    if (entityPlayerMP != null) {
                        FlansModPlayerData flansModPlayerData2 = FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayerMP);
                        if (flansModPlayerData2.overrideGuns != null) {
                            flansModPlayerData.overrideGuns = flansModPlayerData2.overrideGuns;
                            flansModPlayerData.overrideAttachments = flansModPlayerData2.overrideAttachments;
                            antf2.func_70006_a(hrmy._d((String)("\u0420\u0435\u043f\u043b\u0438\u043a\u0430\u0446\u0438\u044f: \u043f\u0430\u0440\u0430\u043c\u0435\u0442\u0440\u044b \u0441\u043a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u043d\u044b \u0443 \u0438\u0433\u0440\u043e\u043a\u0430 " + entityPlayerMP.func_70005_c_())));
                        } else if (flansModPlayerData.overrideGuns != null) {
                            flansModPlayerData2.overrideGuns = flansModPlayerData.overrideGuns;
                            flansModPlayerData2.overrideAttachments = flansModPlayerData.overrideAttachments;
                            antf2.func_70006_a(hrmy._d((String)("\u0420\u0435\u043f\u043b\u0438\u043a\u0430\u0446\u0438\u044f: \u043f\u0430\u0440\u0430\u043c\u0435\u0442\u0440\u044b \u043d\u0430\u0437\u043d\u0430\u0447\u0435\u043d\u044b \u0438\u0433\u0440\u043e\u043a\u0443 " + entityPlayerMP.func_70005_c_())));
                        } else {
                            antf2.func_70006_a(hrmy._d((String)"\u0414\u043b\u044f \u0440\u0435\u043f\u043b\u0438\u043a\u0430\u0446\u0438\u0438 \u0445\u043e\u0442\u044f \u0431\u044b \u043e\u0434\u0438\u043d \u0438\u0433\u0440\u043e\u043a \u0434\u043e\u043b\u0436\u0435\u043d \u043c\u043e\u0434\u0438\u0444\u0438\u0446\u0438\u0430\u0440\u043e\u0432\u0430\u0442\u044c \u043e\u0440\u0443\u0436\u0438\u0435."));
                        }
                    } else {
                        antf2.func_70006_a(hrmy._d((String)"\u0420\u0435\u043f\u043b\u0438\u043a\u0430\u0446\u0438\u044f \u043e\u0442\u043c\u0435\u043d\u0435\u043d\u0430 \u0432\u0441\u0435 \u043f\u0430\u0440\u0430\u043c\u0435\u0442\u0440\u044b \u043e\u0431\u043d\u0443\u043b\u0435\u043d\u044b."));
                    }
                    return;
                }
                if (arrstring[0].equals("hitboxExtend")) {
                    try {
                        EntityBullet.HITBOX_EXTEND = Float.parseFloat(arrstring[1]);
                        for (Object e : zgmv._H().__af()._e) {
                            if (!(e instanceof EntityPlayerMP)) continue;
                            SPacketHandler.sendHitboxExtend((EntityPlayer)((EntityPlayer)e));
                        }
                        entityPlayer.func_70006_a(hrmy._d((String)("\u0423\u0432\u0435\u043b\u0438\u0447\u0435\u043d\u0438\u0435 \u0445\u0438\u0442\u0431\u043e\u043a\u0441\u0430 \u0438\u0433\u0440\u043e\u043a\u0430 \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u043e \u043d\u0430 " + EntityBullet.HITBOX_EXTEND)));
                    }
                    catch (Throwable throwable) {}
                    return;
                }
                ieta ieta2 = entityPlayer.func_71045_bC();
                if (ieta2 != null) {
                    if (ieta2._a() instanceof ItemGun) {
                        GunTypeMod gunTypeMod;
                        GunType gunType = ((ItemGun)ieta2._a()).type;
                        if (flansModPlayerData.overrideGuns == null) {
                            flansModPlayerData.overrideGuns = new HashMap<GunType, GunTypeMod>();
                        }
                        if ((gunTypeMod = flansModPlayerData.overrideGuns.get(gunType)) == null) {
                            gunTypeMod = new GunTypeMod(gunType);
                            flansModPlayerData.overrideGuns.put(gunType, gunTypeMod);
                        }
                        if (arrstring[0].equals("damage")) {
                            gunTypeMod.damage = Float.parseFloat(arrstring[1]);
                            antf2.func_70006_a(hrmy._d((String)(gunType.shortName + " damage " + gunTypeMod.damage)));
                            return;
                        }
                        if (arrstring[0].equals("damagefar")) {
                            gunTypeMod.damageFar = Float.parseFloat(arrstring[1]);
                            antf2.func_70006_a(hrmy._d((String)(gunType.shortName + " damagefar " + gunTypeMod.damageFar)));
                            return;
                        }
                        if (arrstring[0].equals("recoil")) {
                            gunTypeMod.recoil = Float.parseFloat(arrstring[1]);
                            antf2.func_70006_a(hrmy._d((String)(gunType.shortName + " recoil " + gunTypeMod.recoil)));
                            return;
                        }
                        if (arrstring[0].equals("spread")) {
                            gunTypeMod.bulletSpread = Float.parseFloat(arrstring[1]);
                            antf2.func_70006_a(hrmy._d((String)(gunType.shortName + " spread " + gunTypeMod.bulletSpread)));
                            return;
                        }
                        if (arrstring[0].equals("shootdelay")) {
                            gunTypeMod.shootDelay = Integer.parseInt(arrstring[1]);
                            antf2.func_70006_a(hrmy._d((String)(gunType.shortName + " shootdelay " + gunTypeMod.shootDelay)));
                            return;
                        }
                        if (arrstring[0].equals("bulletspeed")) {
                            gunTypeMod.bulletSpeed = Float.parseFloat(arrstring[1]);
                            antf2.func_70006_a(hrmy._d((String)(gunType.shortName + " bulletspeed " + gunTypeMod.bulletSpeed)));
                            return;
                        }
                        if (arrstring[0].equals("ShootModeDanger")) {
                            gunType.mode = EnumFireMode.valueOf(arrstring[1]);
                        }
                    } else if (ieta2._a() instanceof ItemAttachment) {
                        AttachmentTypeMod attachmentTypeMod;
                        AttachmentType attachmentType = ((ItemAttachment)ieta2._a()).type;
                        if (flansModPlayerData.overrideAttachments == null) {
                            flansModPlayerData.overrideAttachments = new HashMap<AttachmentType, AttachmentTypeMod>();
                        }
                        if ((attachmentTypeMod = flansModPlayerData.overrideAttachments.get(attachmentType)) == null) {
                            attachmentTypeMod = new AttachmentTypeMod(attachmentType);
                            flansModPlayerData.overrideAttachments.put(attachmentType, attachmentTypeMod);
                        }
                        if (arrstring[0].equals("damage")) {
                            attachmentTypeMod.damageMultiplier = Float.parseFloat(arrstring[1]);
                            antf2.func_70006_a(hrmy._d((String)(attachmentType.shortName + " damage " + attachmentTypeMod.damageMultiplier)));
                            return;
                        }
                        if (arrstring[0].equals("spread")) {
                            attachmentTypeMod.spreadMultiplier = Float.parseFloat(arrstring[1]);
                            antf2.func_70006_a(hrmy._d((String)(attachmentType.shortName + " spread " + attachmentTypeMod.spreadMultiplier)));
                            return;
                        }
                        if (arrstring[0].equals("recoil")) {
                            attachmentTypeMod.recoilMultiplier = Float.parseFloat(arrstring[1]);
                            antf2.func_70006_a(hrmy._d((String)(attachmentType.shortName + " recoil " + attachmentTypeMod.recoilMultiplier)));
                            return;
                        }
                        if (arrstring[0].equals("bulletspeed")) {
                            attachmentTypeMod.bulletSpeedMultiplier = Float.parseFloat(arrstring[1]);
                            antf2.func_70006_a(hrmy._d((String)(attachmentType.shortName + " bulletspeed " + attachmentTypeMod.bulletSpeedMultiplier)));
                            return;
                        }
                    } else if (ieta2._a() instanceof ItemBullet) {
                        BulletTypeMod bulletTypeMod;
                        BulletType bulletType = ((ItemBullet)ieta2._a()).type;
                        if (flansModPlayerData.overrideBullets == null) {
                            flansModPlayerData.overrideBullets = new HashMap<BulletType, BulletTypeMod>();
                        }
                        if ((bulletTypeMod = flansModPlayerData.overrideBullets.get(bulletType)) == null) {
                            bulletTypeMod = new BulletTypeMod(bulletType);
                            flansModPlayerData.overrideBullets.put(bulletType, bulletTypeMod);
                        }
                        if (arrstring[0].equals("slowdown")) {
                            bulletTypeMod.slowdown = Float.parseFloat(arrstring[1]);
                            antf2.func_70006_a(hrmy._d((String)(bulletType.shortName + " slowdown " + bulletTypeMod.slowdown)));
                            return;
                        }
                    }
                }
            }
        }
        antf2.func_70006_a(hrmy._d((String)(arrstring[0] + " is not a valid teams command. Try /teams help")));
    }

    public void sendHelpInformation(antf antf2, int n) {
        if (n > 3 || n < 1) {
            antf2.func_70006_a(hrmy._d((String)"Invalid help page, should be in the range (1-3)")._a(hrml._m));
            return;
        }
        antf2.func_70006_a(hrmy._d((String)("\u00a72Listing teams commands \u00a7f[Page " + n + " of 3]")));
        switch (n) {
            case 1: {
                antf2.func_70006_a(hrmy._d((String)"/teams help [page]"));
                antf2.func_70006_a(hrmy._d((String)"/teams off"));
                antf2.func_70006_a(hrmy._d((String)"/teams arena"));
                antf2.func_70006_a(hrmy._d((String)"/teams survival"));
                antf2.func_70006_a(hrmy._d((String)"/teams getSticks"));
                antf2.func_70006_a(hrmy._d((String)"/teams listGametypes"));
                antf2.func_70006_a(hrmy._d((String)"/teams setGametype <name>"));
                antf2.func_70006_a(hrmy._d((String)"/teams listAllTeams"));
                antf2.func_70006_a(hrmy._d((String)"/teams listTeams"));
                antf2.func_70006_a(hrmy._d((String)"/teams setTeams <teamName1> <teamName2>"));
                break;
            }
            case 2: {
                antf2.func_70006_a(hrmy._d((String)"/teams addMap <shortName> <longName>"));
                antf2.func_70006_a(hrmy._d((String)"/teams listMaps"));
                antf2.func_70006_a(hrmy._d((String)"/teams removeMap <shortName>"));
                antf2.func_70006_a(hrmy._d((String)"/teams setMap <shortName>"));
                antf2.func_70006_a(hrmy._d((String)"/teams useRotation <true / false>"));
                antf2.func_70006_a(hrmy._d((String)"/teams addRotation <map> <gametype> <team1> <team2> ..."));
                antf2.func_70006_a(hrmy._d((String)"/teams listRotation"));
                antf2.func_70006_a(hrmy._d((String)"/teams removeRotation <ID>"));
                antf2.func_70006_a(hrmy._d((String)"/teams nextMap"));
                antf2.func_70006_a(hrmy._d((String)"/teams goToMap <ID>"));
                break;
            }
            case 3: {
                antf2.func_70006_a(hrmy._d((String)"/teams setVariable <variable> <value>"));
                antf2.func_70006_a(hrmy._d((String)"/teams forceAdventure <true / false>"));
                antf2.func_70006_a(hrmy._d((String)"/teams explosions <true / false>"));
                antf2.func_70006_a(hrmy._d((String)"/teams canBreakGuns <true / false>"));
                antf2.func_70006_a(hrmy._d((String)"/teams canBreakGlass <true / false>"));
                antf2.func_70006_a(hrmy._d((String)"/teams armourDrops <true / false>"));
                antf2.func_70006_a(hrmy._d((String)"/teams weaponDrops <off / on / smart>"));
                antf2.func_70006_a(hrmy._d((String)"/teams fuelNeeded <true / false>"));
                antf2.func_70006_a(hrmy._d((String)"/teams mgLife <time>"));
                antf2.func_70006_a(hrmy._d((String)"/teams planeLife <time>"));
                antf2.func_70006_a(hrmy._d((String)"/teams vehicleLife <time>"));
                antf2.func_70006_a(hrmy._d((String)"/teams aaLife <time>"));
                antf2.func_70006_a(hrmy._d((String)"/teams vehiclesBreakBlocks <true / false>"));
            }
        }
    }

    public EntityPlayerMP getPlayer(String string) {
        return zgmv._H().__af()._h(string);
    }

    public String func_71518_a(antf antf2) {
        return "Try \"/teams help\"";
    }
}

