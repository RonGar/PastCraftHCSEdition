/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ctpu
 *  dwms
 *  gowi
 *  net.minecraft.client.tuor
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  rord
 *  scko
 *  uyla
 *  zfwe
 */
package co.uk.flansmods.client;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.teams.Team;
import java.io.DataInputStream;
import net.minecraft.client.tuor;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiTeamScores
extends dwms {
    public static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/teamsScores.png");
    public static String map;
    public static String gametype;
    public static int numTeams;
    public static TeamData[] teamData;
    public static boolean sortedByTeam;
    public static int numLines;

    public static PlayerData getPlayerData(String string) {
        if (teamData == null) {
            return null;
        }
        for (TeamData teamData : GuiTeamScores.teamData) {
            if (teamData == null || teamData.playerData == null) {
                return null;
            }
            for (PlayerData playerData : teamData.playerData) {
                if (playerData == null || playerData.username == null || !playerData.username.equals(string)) continue;
                return playerData;
            }
        }
        return null;
    }

    public static void interpret(DataInputStream dataInputStream) {
        try {
            gametype = dataInputStream.readUTF();
            if (gametype.equals("No Gametype")) {
                numTeams = 0;
                teamData = new TeamData[0];
            } else {
                map = dataInputStream.readUTF();
                sortedByTeam = dataInputStream.readBoolean();
                if (sortedByTeam) {
                    numLines = numTeams = dataInputStream.readInt();
                    if (numTeams == 0) {
                        return;
                    }
                    teamData = new TeamData[numTeams];
                    for (int i = 0; i < numTeams; ++i) {
                        GuiTeamScores.teamData[i] = new TeamData();
                        String string = dataInputStream.readUTF();
                        if (string.equals("none")) continue;
                        GuiTeamScores.teamData[i].team = Team.getTeam(string);
                        GuiTeamScores.teamData[i].score = dataInputStream.readInt();
                        GuiTeamScores.teamData[i].numPlayers = dataInputStream.readInt();
                        GuiTeamScores.teamData[i].playerData = new PlayerData[GuiTeamScores.teamData[i].numPlayers];
                        numLines += GuiTeamScores.teamData[i].numPlayers;
                        for (int j = 0; j < GuiTeamScores.teamData[i].numPlayers; ++j) {
                            GuiTeamScores.teamData[i].playerData[j] = new PlayerData();
                            GuiTeamScores.teamData[i].playerData[j].team = teamData[i];
                            GuiTeamScores.teamData[i].playerData[j].username = dataInputStream.readUTF();
                            GuiTeamScores.teamData[i].playerData[j].score = dataInputStream.readInt();
                            GuiTeamScores.teamData[i].playerData[j].kills = dataInputStream.readInt();
                            GuiTeamScores.teamData[i].playerData[j].deaths = dataInputStream.readInt();
                        }
                    }
                } else {
                    numLines = 0;
                    teamData = new TeamData[]{new TeamData()};
                    GuiTeamScores.teamData[0].team = null;
                    GuiTeamScores.teamData[0].score = 0;
                    GuiTeamScores.teamData[0].numPlayers = dataInputStream.readInt();
                    GuiTeamScores.teamData[0].playerData = new PlayerData[GuiTeamScores.teamData[0].numPlayers];
                    numLines += GuiTeamScores.teamData[0].numPlayers;
                    for (int i = 0; i < GuiTeamScores.teamData[0].numPlayers; ++i) {
                        GuiTeamScores.teamData[0].playerData[i] = new PlayerData();
                        GuiTeamScores.teamData[0].playerData[i].team = teamData[0];
                        GuiTeamScores.teamData[0].playerData[i].username = dataInputStream.readUTF();
                        GuiTeamScores.teamData[0].playerData[i].score = dataInputStream.readInt();
                        GuiTeamScores.teamData[0].playerData[i].kills = dataInputStream.readInt();
                        GuiTeamScores.teamData[0].playerData[i].deaths = dataInputStream.readInt();
                    }
                }
            }
            FlansMod.canBreakGlass = dataInputStream.readBoolean();
            FlansMod.vehiclesNeedFuel = dataInputStream.readBoolean();
            FlansMod.driveablesBreakBlocks = dataInputStream.readBoolean();
            FlansMod.driveablesBreakBlocks = false;
        }
        catch (Exception exception) {
            FlansMod.log("Error reading team info packet");
            exception.printStackTrace();
        }
    }

    public void func_73863_a(int n, int n2, float f) {
        if (gametype != null && !gametype.equals("") && teamData != null && teamData.length >= 1) {
            int n3;
            this.field_73882_e._p.func_72912_H();
            gowi gowi2 = new gowi(this.field_73882_e._K, this.field_73882_e._l, this.field_73882_e._m);
            int n4 = gowi2.func_78326_a();
            int n5 = gowi2.func_78328_b();
            this.func_73873_v_();
            GL11.glEnable((int)3042);
            this.field_73882_e._f._a(texture);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            int n6 = 34 + 9 * numLines;
            int n7 = n4 / 2 - 128;
            int n8 = n5 / 2 - n6 / 2;
            this.func_73729_b(n7, n8, 0, 45, 256, 24);
            for (n3 = 0; n3 < numLines; ++n3) {
                this.func_73729_b(n7, n8 + 24 + 9 * n3, 0, 71, 256, 9);
            }
            this.func_73729_b(n7, n5 / 2 + n6 / 2 - 10, 0, 87, 256, 10);
            this.func_73732_a(this.field_73886_k, gametype, n4 / 2, n8 + 4, 16777215);
            this.func_73731_b(this.field_73886_k, "Name", n7 + 8, n8 + 14, 16777215);
            this.func_73731_b(this.field_73886_k, "Score", n7 + 100, n8 + 14, 16777215);
            this.func_73731_b(this.field_73886_k, "Kills", n7 + 150, n8 + 14, 16777215);
            this.func_73731_b(this.field_73886_k, "Deaths", n7 + 200, n8 + 14, 16777215);
            n3 = 0;
            if (sortedByTeam) {
                for (int i = 0; i < numTeams; ++i) {
                    if (teamData[i] == null || GuiTeamScores.teamData[i].team == null) continue;
                    this.func_73731_b(this.field_73886_k, "\u00a7" + GuiTeamScores.teamData[i].team.textColour + GuiTeamScores.teamData[i].team.name, n7 + 8, n8 + 25 + 9 * n3, 16777215);
                    this.func_73731_b(this.field_73886_k, "" + GuiTeamScores.teamData[i].score, n7 + 100, n8 + 25 + 9 * n3, 16777215);
                    ++n3;
                    for (int j = 0; j < GuiTeamScores.teamData[i].numPlayers; ++j) {
                        this.func_73731_b(this.field_73886_k, GuiTeamScores.teamData[i].playerData[j].username, n7 + 8, n8 + 25 + 9 * n3, 16777215);
                        this.func_73731_b(this.field_73886_k, "" + GuiTeamScores.teamData[i].playerData[j].score, n7 + 100, n8 + 25 + 9 * n3, 16777215);
                        this.func_73731_b(this.field_73886_k, "" + GuiTeamScores.teamData[i].playerData[j].kills, n7 + 150, n8 + 25 + 9 * n3, 16777215);
                        this.func_73731_b(this.field_73886_k, "" + GuiTeamScores.teamData[i].playerData[j].deaths, n7 + 200, n8 + 25 + 9 * n3, 16777215);
                        ++n3;
                    }
                }
            } else {
                for (int i = 0; i < GuiTeamScores.teamData[0].numPlayers; ++i) {
                    this.func_73731_b(this.field_73886_k, GuiTeamScores.teamData[0].playerData[i].username, n7 + 8, n8 + 25 + 9 * n3, 16777215);
                    this.func_73731_b(this.field_73886_k, "" + GuiTeamScores.teamData[0].playerData[i].score, n7 + 100, n8 + 25 + 9 * n3, 16777215);
                    this.func_73731_b(this.field_73886_k, "" + GuiTeamScores.teamData[0].playerData[i].kills, n7 + 150, n8 + 25 + 9 * n3, 16777215);
                    this.func_73731_b(this.field_73886_k, "" + GuiTeamScores.teamData[0].playerData[i].deaths, n7 + 200, n8 + 25 + 9 * n3, 16777215);
                    ++n3;
                }
            }
            GL11.glDisable((int)3042);
        } else {
            this.field_73882_e._a(null);
        }
    }

    public boolean func_73868_f() {
        return false;
    }

    public static class TeamData {
        public Team team;
        public int score;
        public int numPlayers;
        public PlayerData[] playerData;
    }

    public static class PlayerData {
        public String username;
        public int score;
        public int kills;
        public int deaths;
        public TeamData team;
    }

}

