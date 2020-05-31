/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  fmqx
 *  maaq
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.client.GuiTeamScores;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.network.FlanPacketCommon;
import co.uk.flansmods.common.teams.Gametype;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PacketTeamInfo
extends FlanPacketCommon {
    public static final byte packetID = 18;

    public static maaq buildInfoPacket() {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(18);
            if (TeamsManager.getInstance().currentGametype == null) {
                dataOutputStream.writeUTF("No Gametype");
                dataOutputStream.writeInt(0);
            } else {
                dataOutputStream.writeUTF(TeamsManager.getInstance().currentGametype.name);
                dataOutputStream.writeUTF(TeamsManager.getInstance().currentMap.name);
                if (TeamsManager.getInstance().currentGametype.sortScoreboardByTeam()) {
                    dataOutputStream.writeBoolean(true);
                    if (TeamsManager.getInstance().teams == null) {
                        dataOutputStream.writeInt(0);
                    } else {
                        dataOutputStream.writeInt(TeamsManager.getInstance().teams.length);
                        for (int i = 0; i < TeamsManager.getInstance().teams.length; ++i) {
                            Team team = TeamsManager.getInstance().teams[i];
                            if (team == null) {
                                dataOutputStream.writeUTF("none");
                                continue;
                            }
                            dataOutputStream.writeUTF(team.shortName);
                            dataOutputStream.writeInt(team.score);
                            team.sortPlayers();
                            dataOutputStream.writeInt(team.members.size());
                            for (int j = 0; j < team.members.size(); ++j) {
                                String string = team.members.get(j);
                                FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData(string, Side.SERVER);
                                dataOutputStream.writeUTF(string);
                                if (flansModPlayerData == null) {
                                    dataOutputStream.writeInt(0);
                                    dataOutputStream.writeInt(0);
                                    dataOutputStream.writeInt(0);
                                    continue;
                                }
                                dataOutputStream.writeInt(flansModPlayerData.score);
                                dataOutputStream.writeInt(flansModPlayerData.kills);
                                dataOutputStream.writeInt(flansModPlayerData.deaths);
                            }
                        }
                    }
                } else {
                    Object object;
                    int n;
                    dataOutputStream.writeBoolean(false);
                    ArrayList<String> arrayList = new ArrayList<String>();
                    for (n = 0; n < TeamsManager.getInstance().teams.length; ++n) {
                        object = TeamsManager.getInstance().teams[n];
                        if (object == null || ((Team)object).members == null) continue;
                        arrayList.addAll(((Team)object).members);
                    }
                    Collections.sort(arrayList, new Team.ComparatorScore());
                    dataOutputStream.writeInt(arrayList.size());
                    for (n = 0; n < arrayList.size(); ++n) {
                        object = (String)arrayList.get(n);
                        FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData((String)object, Side.SERVER);
                        dataOutputStream.writeUTF((String)object);
                        if (flansModPlayerData == null) {
                            dataOutputStream.writeInt(0);
                            dataOutputStream.writeInt(0);
                            dataOutputStream.writeInt(0);
                            continue;
                        }
                        dataOutputStream.writeInt(flansModPlayerData.score);
                        dataOutputStream.writeInt(flansModPlayerData.kills);
                        dataOutputStream.writeInt(flansModPlayerData.deaths);
                    }
                }
            }
            dataOutputStream.writeBoolean(FlansMod.canBreakGlass);
            dataOutputStream.writeBoolean(FlansMod.vehiclesNeedFuel);
            dataOutputStream.writeBoolean(FlansMod.driveablesBreakBlocks);
            fmqx2._c = byteArrayOutputStream.toByteArray();
            fmqx2._b = fmqx2._c.length;
            dataOutputStream.close();
            byteArrayOutputStream.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return fmqx2;
    }

    @SideOnly(value=Side.CLIENT)
    @Override
    public void interpret(DataInputStream dataInputStream, Object[] arrobject, Side side) {
        GuiTeamScores.interpret(dataInputStream);
    }

    @Override
    public byte getPacketID() {
        return 18;
    }
}

