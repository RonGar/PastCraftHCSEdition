/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  dwms
 *  fmqx
 *  maaq
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.player.EntityPlayerMP
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.client.GuiTeamSelect;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.network.FlanPacketCommon;
import co.uk.flansmods.common.teams.PlayerClass;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import net.minecraft.client.tuor;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketTeamSelect
extends FlanPacketCommon {
    public static final byte packetID = 6;

    public static maaq buildTeamChoicesPacket(Team[] arrteam) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(6);
            dataOutputStream.writeBoolean(false);
            dataOutputStream.writeByte(arrteam.length);
            for (int i = 0; i < arrteam.length; ++i) {
                dataOutputStream.writeUTF(arrteam[i] == null ? Team.spectators.shortName : arrteam[i].shortName);
            }
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

    public static maaq buildClassChoicesPacket(PlayerClass[] arrplayerClass) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(6);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeByte(arrplayerClass.length);
            for (int i = 0; i < arrplayerClass.length; ++i) {
                dataOutputStream.writeUTF(arrplayerClass[i].shortName);
            }
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

    public static maaq buildSelectionPacket(String string, boolean bl) {
        fmqx fmqx2 = new fmqx();
        fmqx2._a = FlanPacketCommon.channelFlan;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(6);
            dataOutputStream.writeBoolean(bl);
            dataOutputStream.writeUTF(string);
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

    @Override
    public void interpret(DataInputStream dataInputStream, Object[] arrobject, Side side) {
        if (side.equals((Object)Side.CLIENT)) {
            this.interpretClient(dataInputStream, arrobject);
        }
        if (side.equals((Object)Side.SERVER)) {
            this.interpretServer(dataInputStream, arrobject);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void interpretClient(DataInputStream dataInputStream, Object[] arrobject) {
        try {
            boolean bl = dataInputStream.readBoolean();
            if (bl) {
                int n = dataInputStream.readByte();
                PlayerClass[] arrplayerClass = new PlayerClass[n];
                for (int i = 0; i < n; ++i) {
                    arrplayerClass[i] = PlayerClass.getClass(dataInputStream.readUTF());
                }
                tuor._E()._a((dwms)new GuiTeamSelect(arrplayerClass));
            } else {
                int n = dataInputStream.readByte();
                Team[] arrteam = new Team[n];
                for (int i = 0; i < n; ++i) {
                    arrteam[i] = Team.getTeam(dataInputStream.readUTF());
                }
                tuor._E()._a((dwms)new GuiTeamSelect(arrteam));
            }
        }
        catch (Exception exception) {
            FlansMod.log("Error reading packet or opening team gui");
            exception.printStackTrace();
        }
    }

    public void interpretServer(DataInputStream dataInputStream, Object[] arrobject) {
        try {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)arrobject[0];
            boolean bl = dataInputStream.readBoolean();
            String string = dataInputStream.readUTF();
            if (bl) {
                TeamsManager.getInstance().playerSelectedClass(entityPlayerMP, string);
            } else {
                TeamsManager.getInstance().playerSelectedTeam(entityPlayerMP, string);
            }
        }
        catch (Exception exception) {
            FlansMod.log("Error reading packet or selecting team / class");
            exception.printStackTrace();
        }
    }
}

