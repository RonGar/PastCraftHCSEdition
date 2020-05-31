/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ieta
 *  jhvs
 *  net.minecraft.entity.player.EntityPlayer
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.TypeFile;
import co.uk.flansmods.common.teams.ArmourType;
import co.uk.flansmods.common.teams.ITeamBase;
import co.uk.flansmods.common.teams.ItemTeamArmour;
import co.uk.flansmods.common.teams.PlayerClass;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class Team {
    public static List<Team> teams = new ArrayList<Team>();
    public static Team spectators = new Team("spectators", "Spectators", 16777215, '7');
    public List<String> members = new ArrayList<String>();
    public List<ITeamBase> bases = new ArrayList<ITeamBase>();
    public List<PlayerClass> classes = new ArrayList<PlayerClass>();
    public int score = 0;
    public String shortName;
    public String name;
    public int teamColour = 16777215;
    public char textColour = (char)102;
    public ieta hat;
    public ieta chest;
    public ieta legs;
    public ieta shoes;

    public Team(String string, String string2, int n, char c) {
        this.shortName = string;
        this.name = string2;
        this.teamColour = n;
        this.textColour = c;
        teams.add(this);
    }

    public Team(TypeFile typeFile) {
        do {
            String string;
            String[] arrstring;
            try {
                string = typeFile.readLine();
            }
            catch (Exception exception) {
                break;
            }
            if (string == null) break;
            if (string.startsWith("//") || (arrstring = string.split(" ")).length < 2) continue;
            this.read(arrstring, typeFile);
        } while (true);
        teams.add(this);
    }

    protected void read(String[] arrstring, TypeFile typeFile) {
        try {
            ArmourType armourType;
            if (arrstring[0].equals("Name")) {
                this.name = arrstring[1];
                for (int i = 0; i < arrstring.length - 2; ++i) {
                    this.name = this.name + " " + arrstring[i + 2];
                }
            }
            if (arrstring[0].equals("ShortName")) {
                this.shortName = arrstring[1];
            }
            if (arrstring[0].equals("TeamColour")) {
                this.teamColour = (Integer.parseInt(arrstring[1]) << 16) + (Integer.parseInt(arrstring[2]) << 8) + Integer.parseInt(arrstring[3]);
            }
            if (arrstring[0].equals("TextColour")) {
                if (arrstring[1].equals("Black")) {
                    this.textColour = (char)48;
                }
                if (arrstring[1].equals("Blue")) {
                    this.textColour = (char)49;
                }
                if (arrstring[1].equals("Green")) {
                    this.textColour = (char)50;
                }
                if (arrstring[1].equals("Aqua")) {
                    this.textColour = (char)51;
                }
                if (arrstring[1].equals("Red")) {
                    this.textColour = (char)52;
                }
                if (arrstring[1].equals("Purple")) {
                    this.textColour = (char)53;
                }
                if (arrstring[1].equals("Orange")) {
                    this.textColour = (char)54;
                }
                if (arrstring[1].equals("LGrey")) {
                    this.textColour = (char)55;
                }
                if (arrstring[1].equals("Grey")) {
                    this.textColour = (char)56;
                }
                if (arrstring[1].equals("LBlue")) {
                    this.textColour = (char)57;
                }
                if (arrstring[1].equals("LGreen")) {
                    this.textColour = (char)97;
                }
                if (arrstring[1].equals("LAqua")) {
                    this.textColour = (char)98;
                }
                if (arrstring[1].equals("Red")) {
                    this.textColour = (char)99;
                }
                if (arrstring[1].equals("Pink")) {
                    this.textColour = (char)100;
                }
                if (arrstring[1].equals("Yellow")) {
                    this.textColour = (char)101;
                }
                if (arrstring[1].equals("White")) {
                    this.textColour = (char)102;
                }
            }
            if (arrstring[0].equals("Hat") || arrstring[0].equals("Helmet")) {
                if (arrstring[1].equals("None")) {
                    return;
                }
                for (jhvs jhvs2 : FlansMod.armourItems) {
                    armourType = ((ItemTeamArmour)jhvs2).type;
                    if (armourType == null || !armourType.shortName.equals(arrstring[1])) continue;
                    this.hat = new ieta(jhvs2);
                }
            }
            if (arrstring[0].equals("Chest") || arrstring[0].equals("Top")) {
                if (arrstring[1].equals("None")) {
                    return;
                }
                for (jhvs jhvs2 : FlansMod.armourItems) {
                    armourType = ((ItemTeamArmour)jhvs2).type;
                    if (armourType == null || !armourType.shortName.equals(arrstring[1])) continue;
                    this.chest = new ieta(jhvs2);
                }
            }
            if (arrstring[0].equals("Legs") || arrstring[0].equals("Bottom")) {
                if (arrstring[1].equals("None")) {
                    return;
                }
                for (jhvs jhvs2 : FlansMod.armourItems) {
                    armourType = ((ItemTeamArmour)jhvs2).type;
                    if (armourType == null || !armourType.shortName.equals(arrstring[1])) continue;
                    this.legs = new ieta(jhvs2);
                }
            }
            if (arrstring[0].equals("Shoes") || arrstring[0].equals("Boots")) {
                if (arrstring[1].equals("None")) {
                    return;
                }
                for (jhvs jhvs2 : FlansMod.armourItems) {
                    armourType = ((ItemTeamArmour)jhvs2).type;
                    if (armourType == null || !armourType.shortName.equals(arrstring[1])) continue;
                    this.shoes = new ieta(jhvs2);
                }
            }
            if (arrstring[0].equals("AddDefaultClass") || arrstring[0].equals("AddClass")) {
                this.classes.add(PlayerClass.getClass(arrstring[1]));
            }
        }
        catch (Exception exception) {
            System.out.println("Reading team file failed.");
            exception.printStackTrace();
        }
    }

    public static Team getTeam(String string) {
        for (Team team : teams) {
            if (!team.shortName.equals(string)) continue;
            return team;
        }
        return null;
    }

    public void addBase(ITeamBase iTeamBase) {
        this.bases.add(iTeamBase);
    }

    public void removeBase(ITeamBase iTeamBase) {
        this.bases.remove(iTeamBase);
    }

    public void removePlayer(EntityPlayer entityPlayer) {
        this.removePlayer(entityPlayer.field_71092_bJ);
    }

    public String removePlayer(String string) {
        this.members.remove(string);
        if (FlansModPlayerHandler.getPlayerData(string) != null) {
            FlansModPlayerHandler.getPlayerData((String)string).team = null;
        }
        return string;
    }

    public EntityPlayer addPlayer(EntityPlayer entityPlayer) {
        this.addPlayer(entityPlayer.field_71092_bJ);
        return entityPlayer;
    }

    public String addPlayer(String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(string);
        for (Team team : teams) {
            team.members.removeAll(arrayList);
        }
        this.members.add(string);
        FlansModPlayerHandler.getPlayerData((String)string).team = this;
        return string;
    }

    public String removeWorstPlayer() {
        this.sortPlayers();
        if (this.members.size() == 0) {
            return null;
        }
        return this.removePlayer(this.members.get(this.members.size() - 1));
    }

    public void sortPlayers() {
        Collections.sort(this.members, new ComparatorScore());
    }

    public static class ComparatorScore
    implements Comparator<String> {
        @Override
        public int compare(String string, String string2) {
            FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData(string);
            FlansModPlayerData flansModPlayerData2 = FlansModPlayerHandler.getPlayerData(string2);
            if (flansModPlayerData == null || flansModPlayerData2 == null) {
                return 0;
            }
            return flansModPlayerData2.score - flansModPlayerData.score;
        }
    }

}

