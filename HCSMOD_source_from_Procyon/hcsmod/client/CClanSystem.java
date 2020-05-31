// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.client.tuor;
import hcsmod.client.gui.GuiClanSystem;
import java.io.DataInput;
import java.util.List;
import hcsmod.client.hud.DayZHud;

public class CClanSystem implements DayZHud.Hint
{
    private static final CClanSystem instance;
    public static final List<String> clansList;
    public static String yourClan;
    public static String clanOwner;
    public static boolean clanOwnerOnline;
    public static int members;
    public static int timeToNalog;
    public static int rp;
    public static int bases;
    public static int allies;
    public static boolean isMember;
    public static boolean canAcceptMembers;
    public static boolean canModAllies;
    public static boolean canCaptureBases;
    public static boolean CLANSYSTEM_ENABLED;
    public static boolean showMemberOfOtherClan;
    public static String base;
    public static int rpForCapture;
    public static int rpForHolding;
    
    private CClanSystem() {
        DayZHud.hints.put("clansystem", this);
    }
    
    public static void handleData(final DataInput dataInput) throws IOException {
        switch (dataInput.readUnsignedByte()) {
            case 0: {
                CClanSystem.yourClan = null;
                final int unsignedShort = dataInput.readUnsignedShort();
                CClanSystem.clansList.clear();
                for (int i = 0; i < unsignedShort; ++i) {
                    CClanSystem.clansList.add(dataInput.readUTF());
                }
                if (tuor._E()._z instanceof GuiClanSystem) {
                    final GuiClanSystem guiClanSystem = (GuiClanSystem)tuor._E()._z;
                    guiClanSystem.action = null;
                    guiClanSystem.func_73866_w_();
                }
                break;
            }
            case 1: {
                CClanSystem.yourClan = dataInput.readUTF();
                CClanSystem.clanOwner = dataInput.readUTF();
                CClanSystem.clanOwnerOnline = dataInput.readBoolean();
                CClanSystem.members = dataInput.readUnsignedShort();
                CClanSystem.timeToNalog = dataInput.readUnsignedShort();
                CClanSystem.rp = dataInput.readUnsignedShort();
                CClanSystem.bases = dataInput.readUnsignedShort();
                CClanSystem.allies = dataInput.readUnsignedShort();
                final int unsignedByte = dataInput.readUnsignedByte();
                CClanSystem.isMember = ((unsignedByte & 0x1) == 0x1);
                CClanSystem.canAcceptMembers = ((unsignedByte & 0x2) == 0x2);
                CClanSystem.canCaptureBases = ((unsignedByte & 0x4) == 0x4);
                CClanSystem.canModAllies = false;
                if (CClanSystem.clanOwner.equals(tuor._E()._r.field_71092_bJ)) {
                    CClanSystem.canAcceptMembers = (CClanSystem.canModAllies = true);
                }
                if (tuor._E()._z instanceof GuiClanSystem) {
                    final GuiClanSystem guiClanSystem2 = (GuiClanSystem)tuor._E()._z;
                    if (!CClanSystem.isMember || (!CClanSystem.canAcceptMembers && guiClanSystem2.action == Action.ACCEPTREQUESTS)) {
                        guiClanSystem2.action = null;
                    }
                    if (guiClanSystem2.action == null) {
                        guiClanSystem2.func_73866_w_();
                    }
                }
                break;
            }
            case 2: {
                final ArrayList<String> list = new ArrayList<String>();
                for (int unsignedShort2 = dataInput.readUnsignedShort(), j = 0; j < unsignedShort2; ++j) {
                    list.add(dataInput.readUTF());
                }
                if (tuor._E()._z instanceof GuiClanSystem) {
                    final GuiClanSystem guiClanSystem3 = (GuiClanSystem)tuor._E()._z;
                    if (guiClanSystem3.action == Action.ACCEPTREQUESTS) {
                        guiClanSystem3.list = list;
                        guiClanSystem3.func_73866_w_();
                    }
                }
                break;
            }
            case 3: {
                final ArrayList<ColoredString> list2 = new ArrayList<ColoredString>();
                for (int unsignedShort3 = dataInput.readUnsignedShort(), k = 0; k < unsignedShort3; ++k) {
                    list2.add(new ColoredString(dataInput.readUTF(), dataInput.readInt()));
                }
                if (tuor._E()._z instanceof GuiClanSystem) {
                    final GuiClanSystem guiClanSystem4 = (GuiClanSystem)tuor._E()._z;
                    if (guiClanSystem4.action == Action.CLAN_LIST) {
                        guiClanSystem4.list = list2;
                        guiClanSystem4.func_73866_w_();
                    }
                }
                break;
            }
            case 4: {
                final ArrayList<ClanMember> list3 = new ArrayList<ClanMember>();
                CClanSystem.showMemberOfOtherClan = dataInput.readBoolean();
                for (int unsignedShort4 = dataInput.readUnsignedShort(), l = 0; l < unsignedShort4; ++l) {
                    final ClanMember clanMember = new ClanMember(dataInput.readUTF());
                    clanMember.online = dataInput.readBoolean();
                    final int unsignedByte2 = dataInput.readUnsignedByte();
                    clanMember.captureBases = ((unsignedByte2 & 0x1) == 0x1);
                    clanMember.acceptMembers = ((unsignedByte2 & 0x2) == 0x2);
                    clanMember.editRelationships = ((unsignedByte2 & 0x4) == 0x4);
                    list3.add(clanMember);
                }
                if (tuor._E()._z instanceof GuiClanSystem) {
                    final GuiClanSystem guiClanSystem5 = (GuiClanSystem)tuor._E()._z;
                    if (guiClanSystem5.action == Action.EDITMEMBERS) {
                        guiClanSystem5.list = list3;
                        guiClanSystem5.func_73866_w_();
                    }
                }
                break;
            }
            case 5: {
                CClanSystem.base = dataInput.readUTF();
                CClanSystem.rpForCapture = dataInput.readShort();
                CClanSystem.rpForHolding = dataInput.readShort();
                break;
            }
            case 6: {
                CClanSystem.timeToNalog = dataInput.readShort();
                break;
            }
            case 7: {
                final int unsignedShort5 = dataInput.readUnsignedShort();
                CClanSystem.clansList.clear();
                for (int n = 0; n < unsignedShort5; ++n) {
                    CClanSystem.clansList.add(dataInput.readUTF());
                }
                if (tuor._E()._z instanceof GuiClanSystem) {
                    final GuiClanSystem guiClanSystem6 = (GuiClanSystem)tuor._E()._z;
                    guiClanSystem6.action = Action.CLAN_LIST;
                    guiClanSystem6.func_73866_w_();
                }
                break;
            }
            case 8: {
                CClanSystem.yourClan = dataInput.readUTF();
                CClanSystem.clanOwner = dataInput.readUTF();
                CClanSystem.clanOwnerOnline = dataInput.readBoolean();
                CClanSystem.members = dataInput.readUnsignedShort();
                CClanSystem.rp = dataInput.readUnsignedShort();
                CClanSystem.bases = dataInput.readUnsignedShort();
                break;
            }
        }
    }
    
    public static void writeClanJoinRequest(final DataOutput dataOutput, final String s) throws IOException {
        dataOutput.writeByte(0);
        dataOutput.writeUTF(s);
    }
    
    public static void writeLeaveClan(final DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(1);
    }
    
    public static void writeCreateClan(final DataOutput dataOutput, final String s) throws IOException {
        dataOutput.writeByte(2);
        dataOutput.writeUTF(s);
    }
    
    @Override
    public boolean remove() {
        return false;
    }
    
    @Override
    public void addHints(final List<String> list) {
        if (CClanSystem.CLANSYSTEM_ENABLED) {
            if (CClanSystem.yourClan != null && !(tuor._E()._z instanceof GuiClanSystem)) {
                list.add((CClanSystem.isMember ? "§3[\u0412 \u043a\u043b\u0430\u043d\u0435]§r " : "§3[\u0417\u0430\u044f\u0432\u043a\u0430 \u0432]§r ") + CClanSystem.yourClan);
            }
            if (!CClanSystem.base.isEmpty()) {
                final String[] split = CClanSystem.base.split("\n", 2);
                list.add("§3[\u041a\u043b\u0430\u043d \u0431\u0430\u0437\u0430]§r " + split[0]);
                if (split.length == 2) {
                    list.add("§3[\u0412\u043b\u0430\u0434\u0435\u043b\u0435\u0446]§r " + split[1]);
                }
                list.add("§3[RP \u0434\u043b\u044f \u0437\u0430\u0445\u0432\u0430\u0442\u0430]§r " + CClanSystem.rpForCapture);
                list.add("§3[RP \u043d\u0430\u043b\u043e\u0433\u0430]§r " + CClanSystem.rpForHolding);
            }
        }
    }
    
    static {
        instance = new CClanSystem();
        clansList = new ArrayList<String>();
        CClanSystem.clanOwnerOnline = false;
        CClanSystem.showMemberOfOtherClan = false;
        CClanSystem.base = "";
        CClanSystem.rpForCapture = 0;
        CClanSystem.rpForHolding = 0;
    }
    
    public enum Action
    {
        CREATE, 
        ACCEPTREQUESTS, 
        CLAN_LIST, 
        EDITMEMBERS;
    }
    
    public static class ColoredString
    {
        public final String str;
        public final int color;
        
        public ColoredString(final String str, final int color) {
            this.str = str;
            this.color = color;
        }
        
        @Override
        public String toString() {
            return this.str;
        }
    }
    
    public static class ClanMember
    {
        public final String str;
        public boolean captureBases;
        public boolean acceptMembers;
        public boolean editRelationships;
        public boolean online;
        
        public ClanMember(final String str) {
            this.str = str;
        }
        
        @Override
        public String toString() {
            return this.str;
        }
    }
}
