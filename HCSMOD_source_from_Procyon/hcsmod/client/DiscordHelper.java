// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import club.minnced.discord.rpc.DiscordUser;
import net.minecraft.client.tuor;
import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRichPresence;
import club.minnced.discord.rpc.DiscordRPC;

public class DiscordHelper
{
    private static DiscordRPC lib;
    private static DiscordRichPresence rich;
    private static String baseImage;
    public static String state;
    public static String details;
    public static String largeImageKey;
    public static String largeImageText;
    public static String smallImageKey;
    public static String smallImageText;
    public static int partySize;
    public static int partyMax;
    public static long startTimestamp;
    private static int prevNumPlayers;
    
    public static void init(final String state, final String details) {
        final DiscordEventHandlers discordEventHandlers = new DiscordEventHandlers();
        discordEventHandlers.ready = (discordUser -> System.out.println("DiscordRPC \u0437\u0430\u0433\u0440\u0443\u0436\u0435\u043d."));
        DiscordHelper.lib.Discord_Initialize("649908607302893578", discordEventHandlers, true, "");
        DiscordHelper.state = state;
        DiscordHelper.details = details;
        DiscordHelper.largeImageKey = "logo-dayz";
        DiscordHelper.largeImageText = "DayZ";
        DiscordHelper.smallImageKey = DiscordHelper.baseImage;
        DiscordHelper.smallImageText = "hcs.land";
        Runtime.getRuntime().addShutdownHook(new Thread(() -> DiscordHelper.lib.Discord_Shutdown()));
        update();
    }
    
    public static void update() {
        DiscordHelper.rich.state = DiscordHelper.state;
        DiscordHelper.rich.details = DiscordHelper.details;
        DiscordHelper.rich.largeImageKey = DiscordHelper.largeImageKey;
        DiscordHelper.rich.largeImageText = DiscordHelper.largeImageText;
        DiscordHelper.rich.smallImageKey = DiscordHelper.smallImageKey;
        DiscordHelper.rich.smallImageText = DiscordHelper.smallImageText;
        DiscordHelper.rich.partySize = DiscordHelper.partySize;
        DiscordHelper.rich.partyMax = DiscordHelper.partyMax;
        DiscordHelper.rich.startTimestamp = DiscordHelper.startTimestamp;
        DiscordHelper.lib.Discord_UpdatePresence(DiscordHelper.rich);
    }
    
    public static void discordTick() {
        int size = 0;
        final ycmz z = tuor._E()._z();
        final String a = tuor._E()._P()._a();
        if (z != null) {
            size = z._h.size();
        }
        if (size != DiscordHelper.prevNumPlayers) {
            if (DiscordHelper.prevNumPlayers == -1) {
                init("\u0412 \u0433\u043b\u0430\u0432\u043d\u043e\u043c \u043c\u0435\u043d\u044e", a);
            }
            if (size == 0) {
                DiscordHelper.state = "\u0412 \u0433\u043b\u0430\u0432\u043d\u043e\u043c \u043c\u0435\u043d\u044e";
                DiscordHelper.details = a;
                DiscordHelper.startTimestamp = 0L;
                DiscordHelper.partySize = 0;
                DiscordHelper.partyMax = 0;
            }
            else {
                if (DiscordHelper.prevNumPlayers == 0) {
                    if (z._i < 0) {
                        z._i &= 0xFF;
                    }
                    DiscordHelper.state = HcsClient.server;
                    DiscordHelper.details = a;
                    DiscordHelper.partyMax = z._i;
                    DiscordHelper.startTimestamp = System.currentTimeMillis();
                }
                DiscordHelper.partySize = size;
            }
            update();
            DiscordHelper.prevNumPlayers = size;
        }
    }
    
    static {
        DiscordHelper.lib = DiscordRPC.INSTANCE;
        DiscordHelper.rich = new DiscordRichPresence();
        DiscordHelper.baseImage = "logo_base";
        DiscordHelper.prevNumPlayers = -1;
    }
}
