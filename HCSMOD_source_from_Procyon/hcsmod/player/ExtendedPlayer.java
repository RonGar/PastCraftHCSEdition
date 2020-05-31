// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.player;

import net.minecraft.util.hrmy;
import java.util.Iterator;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import net.minecraft.client.tuor;
import net.minecraft.entity.player.EntityPlayer;
import hcsmod.server.HcsServer;
import net.minecraft.entity.Entity;
import java.util.HashMap;
import java.util.Map;
import net.minecraftforge.common.hrml;

public class ExtendedPlayer implements hrml
{
    public static Map<String, ExtendedPlayer> cExPlayers;
    public static final String EXT_PROP_NAME = "HCSEXTPLR";
    public static final int SHIELD_CHARGE = 600;
    public static final int SHIELD_ACTIVE = 20;
    public static final float HEAL_AMMOUNT = 20.0f;
    public final boolean isClient;
    public final InventoryExtended inventory;
    public final ieta[] previousItems;
    public int thirst;
    public int hunger;
    public int zombieKills;
    public int playerKills;
    public boolean regen;
    public int shieldCharge;
    public long shieldTimeout;
    public int visibility;
    public final Map<String, Long> spawnCooldowns;
    public long damageStart;
    public long damageTimeout;
    public float damageAmmount;
    public long housePvpTimeout;
    public float healing;
    public float prevHealing;
    public float healDamageCancel;
    public float temperature;
    public int pauseHeal;
    public double prevX;
    public double prevY;
    public double prevZ;
    public long logoutTime;
    public byte logoutId;
    public double logoutX;
    public double logoutY;
    public double logoutZ;
    public float logoutP;
    public float logoutYw;
    public float logoutH;
    public int guns_offset;
    public boolean guns_3rd_left;
    public boolean placeHouse;
    public boolean hasHousesForTransfer;
    public int lastRadarUpdate;
    public int hitCooldown;
    public hrml serverStorage;
    
    private ExtendedPlayer(final boolean isClient) {
        this.previousItems = new ieta[6];
        this.visibility = 0;
        this.spawnCooldowns = new HashMap<String, Long>();
        this.temperature = 25.0f;
        this.pauseHeal = 0;
        this.guns_offset = 0;
        this.guns_3rd_left = false;
        this.isClient = isClient;
        this.inventory = new InventoryExtended();
    }
    
    public ExtendedPlayer(final InventoryExtended inventory, final boolean isClient) {
        this.previousItems = new ieta[6];
        this.visibility = 0;
        this.spawnCooldowns = new HashMap<String, Long>();
        this.temperature = 25.0f;
        this.pauseHeal = 0;
        this.guns_offset = 0;
        this.guns_3rd_left = false;
        this.isClient = isClient;
        this.inventory = inventory;
    }
    
    public void init(final Entity entity, final cuqu cuqu) {
        if (cuqu != null && !cuqu.field_72995_K) {
            HcsServer.initExtendedPlayer(this, entity, cuqu);
        }
    }
    
    public static void register(final EntityPlayer entityPlayer) {
        entityPlayer.registerExtendedProperties("HCSEXTPLR", (hrml)new ExtendedPlayer(entityPlayer.field_70170_p == null || entityPlayer.field_70170_p.field_72995_K));
    }
    
    public static ExtendedPlayer client(final String s) {
        ExtendedPlayer extendedPlayer = ExtendedPlayer.cExPlayers.get(s);
        if (extendedPlayer == null) {
            extendedPlayer = new ExtendedPlayer(true);
            extendedPlayer.temperature = -2.14748365E9f;
            ExtendedPlayer.cExPlayers.put(s, extendedPlayer);
            if (tuor._E()._r != null && s.equals(tuor._E()._r.field_71092_bJ)) {
                try {
                    final FileInputStream fileInputStream = new FileInputStream(new File("vGunSettings"));
                    Throwable t = null;
                    try {
                        final int read = fileInputStream.read();
                        extendedPlayer.guns_offset = (read & 0x7);
                        extendedPlayer.guns_3rd_left = ((read & 0x8) == 0x8);
                        fileInputStream.close();
                    }
                    catch (Throwable t2) {
                        t = t2;
                        throw t2;
                    }
                    finally {
                        if (t != null) {
                            try {
                                fileInputStream.close();
                            }
                            catch (Throwable exception) {
                                t.addSuppressed(exception);
                            }
                        }
                        else {
                            fileInputStream.close();
                        }
                    }
                }
                catch (IOException ex) {}
            }
        }
        return extendedPlayer;
    }
    
    public static ExtendedPlayer server(final EntityPlayer entityPlayer) {
        if (entityPlayer.getExtendedProperties("HCSEXTPLR") == null) {
            register(entityPlayer);
        }
        return (ExtendedPlayer)entityPlayer.getExtendedProperties("HCSEXTPLR");
    }
    
    public void saveNBTData(final hsus hsus) {
        hsus._a("Thirst", this.thirst);
        hsus._a("Food", this.hunger);
        hsus._a("ZombieKills", this.zombieKills);
        hsus._a("PlayerKills", this.playerKills);
        hsus._a("JugShieldCharge", this.shieldCharge);
        hsus._a("hcs_temperature", this.temperature);
        hsus._a("HCSINV", (zxiv)this.inventory.writeToNBT(hsus._n("HCSINV")));
        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, Long> entry : this.spawnCooldowns.entrySet()) {
            final Long n = entry.getValue();
            if (n != null && n > System.currentTimeMillis()) {
                sb.append(entry.getKey());
                sb.append(" ");
                sb.append(n.toString());
                sb.append("\n");
            }
        }
        hsus._a("RsCooldown", sb.toString());
        if (this.housePvpTimeout > System.currentTimeMillis()) {
            hsus._a("housePvpTimeout", this.housePvpTimeout);
        }
        if (this.serverStorage != null) {
            this.serverStorage.saveNBTData(hsus);
        }
    }
    
    public void loadNBTData(final hsus hsus) {
        this.thirst = hsus._f("Thirst");
        this.hunger = hsus._f("Food");
        this.zombieKills = hsus._f("ZombieKills");
        this.playerKills = hsus._f("PlayerKills");
        this.shieldCharge = hsus._f("JugShieldCharge");
        if (hsus._c("hcs_temperature")) {
            this.temperature = hsus._h("hcs_temperature");
        }
        this.inventory.readFromNBT(hsus._n("HCSINV"));
        final String j = hsus._j("RsCooldown");
        if (j != null && !j.isEmpty()) {
            final String[] split = j.split("\n");
            for (int i = 0; i < split.length; ++i) {
                final int lastIndex = split[i].lastIndexOf(" ");
                if (lastIndex > 0) {
                    try {
                        this.spawnCooldowns.put(split[i].substring(0, lastIndex), Long.parseLong(split[i].substring(lastIndex + 1)));
                    }
                    catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        }
        if (hsus._c("housePvpTimeout")) {
            this.housePvpTimeout = hsus._g("housePvpTimeout");
        }
        if (this.serverStorage != null) {
            this.serverStorage.loadNBTData(hsus);
        }
    }
    
    public void feed(final int n, final int n2) {
        if (n == 0) {
            this.hunger = 5000;
        }
        if (n == 1) {
            if (this.hunger - n2 >= 0) {
                this.hunger -= n2;
            }
            else {
                this.hunger = 0;
            }
        }
    }
    
    public void water(final int n, final int n2) {
        if (n == 0) {
            this.thirst = 5000;
        }
        if (n == 1) {
            if (this.thirst - n2 >= 0) {
                this.thirst -= n2;
            }
            else {
                this.thirst = 0;
            }
        }
    }
    
    public void startHeal(final float n) {
        this.startHeal(20.0f, n);
    }
    
    public void startHeal(final float healing, final float healDamageCancel) {
        this.healing = healing;
        this.healDamageCancel = healDamageCancel;
    }
    
    public void checkHousesForTransfer(final EntityPlayer entityPlayer) {
        try {
            this.hasHousesForTransfer = (sbsi._a(new File("HouseTransfer/" + entityPlayer.field_71092_bJ)) != null);
        }
        catch (IOException ex) {
            this.hasHousesForTransfer = false;
        }
    }
    
    public void hasHousesForTransfer(final EntityPlayer entityPlayer) {
        entityPlayer.func_70006_a(hrmy._d("§d\u0423 \u0442\u0435\u0431\u044f \u0435\u0441\u0442\u044c \u0434\u043e\u043c\u0430 \u0434\u043b\u044f \u043f\u0435\u0440\u0435\u043d\u043e\u0441\u0430 \u043d\u0430 \u044d\u0442\u043e\u0442 \u0441\u0435\u0440\u0432\u0435\u0440."));
        entityPlayer.func_70006_a(hrmy._d("§d\u0414\u043b\u044f \u0438\u0445 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0438 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439 \u043a\u043e\u043c\u0430\u043d\u0434\u0443 §f/gethouse"));
    }
    
    static {
        ExtendedPlayer.cExPlayers = new HashMap<String, ExtendedPlayer>();
    }
}
