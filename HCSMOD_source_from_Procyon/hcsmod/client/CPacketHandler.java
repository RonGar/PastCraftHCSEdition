// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import java.util.List;
import hcsmod.flashlight.FlashlightClient;
import hcsmod.flashlight.Flashlight;
import co.uk.flansmods.common.guns.ItemGun;
import net.vintarz.movement.Movement;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.client.FlansModClient;
import java.io.IOException;
import hcsmod.HCS;
import vintarz.core.VCP;
import hcsmod.client.gui.GuiSpawnSelect;
import hcsmod.jugger.RenderSpot;
import hcsmod.jugger.JuggerHud;
import net.minecraft.entity.player.EntityPlayer;
import hcsmod.client.gui.GuiCodeLock;
import java.util.Random;
import hcsmod.client.hud.DayZHud;
import net.minecraft.client.tuor;
import hcsmod.player.ExtendedPlayer;
import java.io.DataInput;
import vintarz.core.VRP;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.network.IPacketHandler;

public class CPacketHandler implements IPacketHandler
{
    public void onPacketData(final mrcr mrcr, final fmqx fmqx, final Player player) {
        final VRP vrp = new VRP(fmqx);
        final byte type = vrp.type;
        if (type == 0) {
            try {
                final ieta[] array = new ieta[6];
                for (int i = 0; i < 6; ++i) {
                    array[i] = maaq.func_73276_c((DataInput)vrp);
                }
                final String utf = vrp.readUTF();
                final ExtendedPlayer client = ExtendedPlayer.client(utf);
                final byte byte1 = vrp.readByte();
                if (!utf.equals(tuor._E()._r.field_71092_bJ)) {
                    client.shieldCharge = byte1;
                    if (client.shieldCharge == 2) {
                        client.shieldCharge = -1;
                    }
                }
                System.arraycopy(array, 0, client.inventory.inventoryStacks, 0, 6);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if (type == 1) {
            try {
                final byte byte2 = vrp.readByte();
                if (byte2 == 0) {
                    ExtendedPlayer.client(tuor._E()._r.field_71092_bJ).zombieKills = vrp.readInt();
                }
                else if (byte2 == 1) {
                    ExtendedPlayer.client(tuor._E()._r.field_71092_bJ).playerKills = vrp.readInt();
                }
                else if (byte2 == 2) {
                    ExtendedPlayer.client(tuor._E()._r.field_71092_bJ).healing = (float)vrp.readUnsignedByte();
                }
            }
            catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        else if (type == 2) {
            try {
                final ExtendedPlayer client2 = ExtendedPlayer.client(tuor._E()._r.field_71092_bJ);
                client2.thirst = vrp.readInt();
                client2.hunger = vrp.readInt();
                DayZHud.debug.put("hunger", String.valueOf(client2.hunger));
                DayZHud.debug.put("thirst", String.valueOf(client2.thirst));
            }
            catch (Exception ex3) {
                ex3.printStackTrace();
            }
        }
        else if (type == 3) {
            try {
                final Random random = new Random();
                final double double1 = vrp.readDouble();
                final double double2 = vrp.readDouble();
                final double double3 = vrp.readDouble();
                for (int j = 0; j < 128; ++j) {
                    tuor._E()._p.func_72869_a("explode", double1 + random.nextDouble(), double2 + random.nextDouble(), double3 + random.nextDouble(), (random.nextDouble() - 0.5) / 2.0, (random.nextDouble() - 0.5) / 2.0, (random.nextDouble() - 0.5) / 2.0);
                }
            }
            catch (Exception ex4) {
                ex4.printStackTrace();
            }
        }
        else if (type == 4) {
            CTickHandler.juggerLabel = 200;
        }
        else if (type == 5) {
            try {
                tuor._E()._a((dwms)new GuiCodeLock((EntityPlayer)tuor._E()._r, vrp.readInt()));
            }
            catch (Exception ex5) {
                ex5.printStackTrace();
            }
        }
        else if (type == 6) {
            JuggerHud.entities.clear();
            try {
                while (vrp.available() > 0) {
                    JuggerHud.entities.add(new RenderSpot(vrp.readByte(), vrp.readByte(), vrp.readByte()));
                }
            }
            catch (Throwable t) {
                t.printStackTrace();
            }
        }
        else if (type == 7) {
            try {
                final int unsignedByte = vrp.readUnsignedByte();
                GuiSpawnSelect.spawns.clear();
                for (int k = 0; k < unsignedByte; ++k) {
                    GuiSpawnSelect.spawns.add(new GuiSpawnSelect.SpawnPoint(vrp.readUTF(), vrp.readByte(), vrp.readByte()));
                }
                GuiSpawnSelect.instance.func_73866_w_();
            }
            catch (Throwable t2) {}
        }
        else if (type == 8) {
            try {
                ExtendedPlayer.client(tuor._E()._r.field_71092_bJ).shieldCharge = vrp.readShort();
            }
            catch (Exception ex6) {
                ex6.printStackTrace();
            }
        }
        else if (type == 9) {
            try {
                CClanSystem.handleData((DataInput)vrp);
            }
            catch (Exception ex7) {
                ex7.printStackTrace();
            }
        }
        else if (type == 10) {
            try {
                final ExtendedPlayer client3 = ExtendedPlayer.client(tuor._E()._r.field_71092_bJ);
                int n;
                if (!client3.guns_3rd_left) {
                    n = (client3.guns_offset & 0x7);
                }
                else {
                    n = ((client3.guns_offset & 0x7) | 0x8);
                }
                final VCP vcp = new VCP(14, "HCSMOD");
                vcp.writeByte(n);
                vcp.send();
            }
            catch (Exception ex8) {
                ex8.printStackTrace();
            }
            try {
                CClanSystem.CLANSYSTEM_ENABLED = vrp.readBoolean();
                HcsClient.server = vrp.readUTF();
                HcsClient.isPVPserver = HcsClient.server.toLowerCase().contains("pvp");
                HcsClient.isLiteserver = HcsClient.server.toLowerCase().contains("lite");
                HcsClient.isHarXserver = HcsClient.server.toLowerCase().contains("hardcore");
                HcsClient.customArmor = null;
                CEventHandler.LIMIT_MAX_X = vrp.readInt();
                CEventHandler.LIMIT_MAX_Z = vrp.readInt();
                CEventHandler.LIMIT_MIN_X = vrp.readInt();
                CEventHandler.LIMIT_MIN_Z = vrp.readInt();
                HCS.setWorldBorders((float)CEventHandler.LIMIT_MIN_X, (float)CEventHandler.LIMIT_MAX_X, (float)CEventHandler.LIMIT_MIN_Z, (float)CEventHandler.LIMIT_MAX_Z);
            }
            catch (Exception ex9) {
                ex9.printStackTrace();
            }
        }
        else if (type == 11) {
            try {
                final ExtendedPlayer client4 = ExtendedPlayer.client(tuor._E()._r.field_71092_bJ);
                client4.temperature = vrp.readUnsignedShort() / 1024.0f;
                HcsClient.ambient_temp = vrp.readUnsignedShort() / 1024.0f;
                HcsClient.overheat = vrp.readByte() / 127.0f;
                DayZHud.debug.put("temperature", String.valueOf(client4.temperature));
                DayZHud.debug.put("ambient", String.valueOf(HcsClient.ambient_temp));
                DayZHud.debug.put("overheat", String.valueOf(HcsClient.overheat));
            }
            catch (Exception ex10) {
                ex10.printStackTrace();
            }
        }
        else if (type == 12) {
            try {
                final byte[] bytes = new byte[vrp.readUnsignedByte()];
                vrp.readFully(bytes);
                final String[] split = new String(bytes, "UTF-8").split("\n", 2);
                final String string = "serverhint" + split[0];
                if (split.length == 2) {
                    final ServerHint serverHint = new ServerHint(vrp.readUnsignedByte(), split[1]);
                    DayZHud.hints.put(string, serverHint);
                    if (split[0].equals("netping")) {
                        serverHint.hide = true;
                    }
                }
                else {
                    DayZHud.hints.remove(string);
                }
            }
            catch (IOException ex11) {
                ex11.printStackTrace();
            }
        }
        else if (type == 13) {
            if (tuor._E()._z instanceof tuwd) {
                final tuwd tuwd = (tuwd)tuor._E()._z;
                try {
                    if (tuwd._e == vrp.readUnsignedByte()) {
                        tuwd._d.field_73744_e = "§2\u0411\u0435\u0437\u043e\u043f\u0430\u0441\u043d\u044b\u0439 \u0432\u044b\u0445\u043e\u0434 \u0447\u0435\u0440\u0435\u0437 " + vrp.readUnsignedByte();
                    }
                }
                catch (IOException ex12) {}
            }
        }
        else if (type == 14) {
            try {
                FlansModClient.bipod = vrp.readBoolean();
            }
            catch (IOException ex13) {}
        }
        else if (type == 15) {
            try {
                HcsClient.placeHouse = vrp.readBoolean();
            }
            catch (IOException ex14) {}
        }
        else if (type == 16) {
            try {
                FlansModClient.clientPlayerData.syncGunRng(vrp.readLong());
            }
            catch (IOException ex15) {}
        }
        else if (type == 17) {
            try {
                ItemGun.CHS = (Movement.CJS = (EntityBullet.FOOL = vrp.readBoolean()));
            }
            catch (IOException ex16) {}
        }
        else if (type == 18) {
            final StringBuilder sb = new StringBuilder();
            try {
                sb.append(vrp.readByte());
                sb.append(' ');
                sb.append(vrp.readByte());
                sb.append(' ');
                sb.append(vrp.readByte());
            }
            catch (IOException ex17) {}
            HcsClient.customArmor = sb.toString();
        }
        else if (type == 19) {
            try {
                FlashlightClient.deltaTime = Flashlight.getFlashlightTime(true) - vrp.readInt();
            }
            catch (IOException ex18) {}
        }
        else if (type == 20) {
            try {
                EntityBullet.HITBOX_EXTEND = vrp.readFloat();
            }
            catch (IOException ex19) {}
        }
        else if (type == 21) {
            try {
                jhvs.field_77698_e[vrp.readUnsignedShort()].func_77656_e(vrp.readUnsignedShort());
            }
            catch (IOException ex20) {}
        }
        else if (type == 22) {
            try {
                CTickHandler.overrideDimensionId = vrp.readByte();
            }
            catch (IOException ex21) {}
        }
    }
    
    private static class ServerHint implements DayZHud.Hint
    {
        private final long time;
        private final String str;
        private boolean hide;
        
        private ServerHint(final int n, final String str) {
            this.time = System.currentTimeMillis() + n * 50L;
            this.str = str;
        }
        
        @Override
        public boolean remove() {
            return System.currentTimeMillis() > this.time || tuor._E()._p == null;
        }
        
        @Override
        public void addHints(final List<String> list) {
            if (tuor._E()._K.__bo._e || !this.hide) {
                for (final String s : this.str.split("\n")) {
                    if (!s.isEmpty()) {
                        list.add(s);
                    }
                }
            }
        }
    }
}
