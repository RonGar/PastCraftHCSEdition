// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.gui;

import java.util.ListIterator;
import java.util.Collection;
import net.minecraft.util.dwbg;
import java.net.URISyntaxException;
import java.net.URI;
import java.awt.Desktop;
import java.io.DataOutput;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import java.util.Iterator;
import net.minecraft.util.hrml;
import java.io.IOException;
import vintarz.core.VCP;
import net.minecraft.client.tuor;
import hcsmod.client.CClanSystem;
import java.util.List;
import net.minecraft.util.ResourceLocation;

public class GuiClanSystem extends dwms
{
    protected static final ResourceLocation field_110421_t;
    protected static final ResourceLocation trist;
    protected static final int xSize = 248;
    protected static final int ySize = 166;
    private static final String createClan = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c";
    private static final List dummyList;
    public int guiLeft;
    public int guiTop;
    public int scrollX;
    public int scrollY;
    public int scrollW;
    public int scrollItemInList;
    public int selectedItem;
    public float currentScroll;
    public boolean isScrolling;
    public boolean wasClicking;
    public List list;
    public CClanSystem.Action action;
    private zfly input;
    private String selectedString;
    private boolean needToReloadClanInfo;
    
    public GuiClanSystem() {
        this.scrollX = 229;
        this.scrollY = 5;
        this.scrollW = 104;
        this.needToReloadClanInfo = false;
        tuor._E()._r.func_71053_j();
    }
    
    public void func_73874_b() {
        super.func_73874_b();
        if (this.needToReloadClanInfo) {
            final VCP vcp = new VCP(7, "HCSMOD");
            try {
                vcp.writeByte(12);
                vcp.writeBoolean(false);
                vcp.writeUTF(tuor._E()._r.field_71092_bJ);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            vcp.send();
            this.needToReloadClanInfo = false;
        }
    }
    
    public void func_73866_w_() {
        super.func_73866_w_();
        this.field_73887_h.clear();
        this.guiLeft = (this.field_73880_f - 248) / 2;
        this.guiTop = (this.field_73881_g - 166) / 2;
        final VCP vcp = new VCP(7, "HCSMOD");
        try {
            vcp.writeByte(10);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        vcp.send();
        if (this.needToReloadClanInfo) {
            final VCP vcp2 = new VCP(7, "HCSMOD");
            try {
                vcp2.writeByte(12);
                vcp2.writeBoolean(false);
                vcp2.writeUTF(tuor._E()._r.field_71092_bJ);
            }
            catch (IOException ex2) {
                ex2.printStackTrace();
            }
            vcp2.send();
            this.needToReloadClanInfo = false;
        }
        if (CClanSystem.yourClan == null) {
            if (this.action == CClanSystem.Action.CREATE) {
                (this.input = new zfly(this.field_73886_k, this.guiLeft + 125, this.guiTop + 119, 118, 20))._b(true);
                this.input._f(32);
                this.field_73887_h.add(enable(new tdvs(0, this.guiLeft + 125, this.guiTop + 141, 118, 20, "\u0427\u0438\u0442\u0430\u0439 \u043f\u0440\u0430\u0432\u0438\u043b\u0430"), false));
                this.field_73887_h.add(new tdvs(1, this.guiLeft + 125, this.guiTop + 75, 118, 20, "\u041f\u0440\u0430\u0432\u0438\u043b\u0430 \u043a\u043b\u0430\u043d\u043e\u0432"));
                this.list = null;
            }
            else {
                this.field_73887_h.add(new tdvs(0, this.guiLeft + 125, this.guiTop + 119, 118, 20, "\u0412\u0441\u0442\u0443\u043f\u0438\u0442\u044c \u0432 \u043a\u043b\u0430\u043d"));
                this.field_73887_h.add(new tdvs(1, this.guiLeft + 125, this.guiTop + 141, 118, 20, "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043a\u043b\u0430\u043d"));
                this.list = CClanSystem.clansList;
                this.input = null;
                this.scrollItemInList = 11;
            }
        }
        else {
            this.input = null;
            if (this.action == CClanSystem.Action.ACCEPTREQUESTS) {
                this.field_73887_h.add(enable(new tdvs(0, this.guiLeft + 125, this.guiTop + 119, 118, 20, "\u041f\u0440\u0438\u043d\u044f\u0442\u044c \u0437\u0430\u044f\u0432\u043a\u0443"), false));
                this.field_73887_h.add(enable(new tdvs(1, this.guiLeft + 125, this.guiTop + 141, 118, 20, "\u041e\u0442\u043a\u043b\u043e\u043d\u0438\u0442\u044c"), false));
                if (this.list == null) {
                    this.list = GuiClanSystem.dummyList;
                }
                this.scrollItemInList = 11;
            }
            else if (this.action == CClanSystem.Action.CLAN_LIST) {
                this.field_73887_h.add(enable(new tdvs(0, this.guiLeft + 125, this.guiTop + 113, 118, 20, "\u0414\u0430\u043d\u043d\u044b\u0435 \u043a\u043b\u0430\u043d\u0430"), true));
                this.field_73887_h.add(enable(new tdvs(1, this.guiLeft + 125, this.guiTop + 135, 118, 20, "\u0418\u0433\u0440\u043e\u043a\u0438 \u043a\u043b\u0430\u043d\u0430"), true));
                this.list = CClanSystem.clansList;
                this.scrollItemInList = 10;
            }
            else if (this.action == CClanSystem.Action.EDITMEMBERS) {
                final boolean b = this.field_73882_e._r.field_71092_bJ.equals(CClanSystem.clanOwner) && !CClanSystem.showMemberOfOtherClan;
                this.field_73887_h.add(show(enable(new tdvs(0, this.guiLeft + 125, this.guiTop + 97, 118, 20, "\u0417\u0430\u0445\u0432\u0430\u0442 \u0442\u0435\u0440\u0440\u0438\u0442\u043e\u0440\u0438\u0439: ?"), false), b));
                this.field_73887_h.add(show(enable(new tdvs(1, this.guiLeft + 125, this.guiTop + 119, 118, 20, "\u041f\u0440\u0438\u0435\u043c \u0432 \u043a\u043b\u0430\u043d: ?"), false), b));
                this.field_73887_h.add(show(enable(new tdvs(2, this.guiLeft + 125, this.guiTop + 141, 118, 20, hrml._m + "\u0412\u044b\u0433\u043d\u0430\u0442\u044c \u0438\u0437 \u043a\u043b\u0430\u043d\u0430"), false), CClanSystem.canAcceptMembers && !CClanSystem.showMemberOfOtherClan));
                if (this.list == null) {
                    this.list = GuiClanSystem.dummyList;
                }
                this.scrollItemInList = 9;
            }
            else {
                this.field_73887_h.add(new tdvs(0, this.guiLeft + 125, this.guiTop + 140, 118, 20, hrml._m + (this.field_73882_e._r.field_71092_bJ.equals(CClanSystem.clanOwner) ? "\u0420\u0430\u0441\u0444\u043e\u0440\u043c\u0438\u0440\u043e\u0432\u0430\u0442\u044c" : (CClanSystem.isMember ? "\u0414\u0435\u0437\u0435\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c" : "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c \u0437\u0430\u044f\u0432\u043a\u0443"))));
                if (CClanSystem.canAcceptMembers) {
                    this.field_73887_h.add(new tdvs(1, this.guiLeft + 125, this.guiTop + 5, 118, 20, "\u0417\u0430\u044f\u0432\u043a\u0438 \u043d\u0430 \u0432\u0441\u0442\u0443\u043f\u043b\u0435\u043d\u0438\u0435"));
                }
                this.field_73887_h.add(enable(new tdvs(2, this.guiLeft + 125, this.guiTop + 30, 118, 20, "\u0421\u043f\u0438\u0441\u043e\u043a \u043a\u043b\u0430\u043d\u043e\u0432"), true));
                if (CClanSystem.canAcceptMembers) {
                    this.field_73887_h.add(new tdvs(3, this.guiLeft + 125, this.guiTop + 55, 118, 20, "\u0423\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u0430\u043c\u0438"));
                }
                else if (CClanSystem.isMember) {
                    this.field_73887_h.add(new tdvs(3, this.guiLeft + 125, this.guiTop + 55, 118, 20, "\u0421\u043f\u0438\u0441\u043e\u043a \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u043e\u0432"));
                }
                if (CClanSystem.canCaptureBases) {
                    this.field_73887_h.add(new tdvs(4, this.guiLeft + 125, this.guiTop + 100, 118, 20, "\u0417\u0430\u0445\u0432\u0430\u0442\u0438\u0442\u044c \u0431\u0430\u0437\u0443"));
                }
                this.list = null;
            }
        }
        if (this.list != null) {
            if (this.list == GuiClanSystem.dummyList) {
                this.selectedItem = -1;
                this.selectedString = null;
            }
            else {
                this.selectedItem = -1;
                int selectedItem = 0;
                final Iterator<Object> iterator = (Iterator<Object>)this.list.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().toString().equals(this.selectedString)) {
                        this.selectedItem = selectedItem;
                        break;
                    }
                    ++selectedItem;
                }
                if (this.selectedItem == -1) {
                    this.selectedString = null;
                }
            }
        }
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        GL11.glPushAttrib(8192);
        ncpk._a();
        final int n4 = this.scrollItemInList * 10;
        final boolean buttonDown = Mouse.isButtonDown(0);
        final int guiLeft = this.guiLeft;
        final int guiTop = this.guiTop;
        final int n5 = guiLeft + this.scrollX;
        final int n6 = guiTop + this.scrollY;
        final int n7 = n5 + 14;
        final int n8 = n6 + n4;
        if (!this.wasClicking && buttonDown && n >= n5 && n2 >= n6 && n < n7 && n2 < n8) {
            this.isScrolling = (this.list != null);
        }
        if (!buttonDown) {
            this.isScrolling = false;
        }
        this.wasClicking = buttonDown;
        if (this.isScrolling) {
            this.currentScroll = (n2 - n6 - 7.5f) / (n8 - n6 - 15.0f);
            if (this.currentScroll < 0.0f) {
                this.currentScroll = 0.0f;
            }
            if (this.currentScroll > 1.0f) {
                this.currentScroll = 1.0f;
            }
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(GuiClanSystem.field_110421_t);
        this.func_73729_b(guiLeft, guiTop, 0, 0, 248, 166);
        super.func_73863_a(n, n2, n3);
        if (this.input != null) {
            this.input._f();
        }
        ncpk._c();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        final int n9 = this.guiLeft + 5;
        int n10 = this.guiTop + 13;
        if (this.action != CClanSystem.Action.EDITMEMBERS) {
            final rord x = this.field_73882_e._x;
            final String s = "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043a\u043b\u0430\u043d\u0430:";
            final int n11 = n9;
            n10 += 10;
            x._b(s, n11, n10, 2236962);
            final rord x2 = this.field_73882_e._x;
            final String clanStr = clanStr(CClanSystem.yourClan);
            final int n12 = n9;
            n10 += 10;
            x2._b(clanStr, n12, n10, 2236962);
            final rord x3 = this.field_73882_e._x;
            final String s2 = "\u0421\u043e\u0437\u0434\u0430\u0442\u0435\u043b\u044c:";
            final int n13 = n9;
            n10 += 10;
            x3._b(s2, n13, n10, 2236962);
            final rord x4 = this.field_73882_e._x;
            final String clanStr2 = clanStr((CClanSystem.clanOwnerOnline ? "On:" : "") + CClanSystem.clanOwner);
            final int n14 = n9;
            n10 += 10;
            x4._b(clanStr2, n14, n10, 2236962);
            final rord x5 = this.field_73882_e._x;
            final String s3 = "\u0423\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u043e\u0432 \u043a\u043b\u0430\u043d\u0430:";
            final int n15 = n9;
            n10 += 10;
            x5._b(s3, n15, n10, 2236962);
            final rord x6 = this.field_73882_e._x;
            final String clanStr3 = clanStr(CClanSystem.members);
            final int n16 = n9;
            n10 += 10;
            x6._b(clanStr3, n16, n10, 2236962);
            final rord x7 = this.field_73882_e._x;
            final String s4 = "\u0414\u043e \u0441\u043d\u044f\u0442\u0438\u044f \u043d\u0430\u043b\u043e\u0433\u0430(\u043c\u0438\u043d\u0443\u0442):";
            final int n17 = n9;
            n10 += 10;
            x7._b(s4, n17, n10, 2236962);
            final rord x8 = this.field_73882_e._x;
            final String clanStr4 = clanStr(CClanSystem.timeToNalog);
            final int n18 = n9;
            n10 += 10;
            x8._b(clanStr4, n18, n10, 2236962);
            final rord x9 = this.field_73882_e._x;
            final String s5 = "\u041e\u0447\u043a\u0438 \u0440\u0435\u043f\u0443\u0442\u0430\u0446\u0438\u0438:";
            final int n19 = n9;
            n10 += 10;
            x9._b(s5, n19, n10, 2236962);
            final rord x10 = this.field_73882_e._x;
            final String clanStr5 = clanStr(CClanSystem.rp);
            final int n20 = n9;
            n10 += 10;
            x10._b(clanStr5, n20, n10, 2236962);
            final rord x11 = this.field_73882_e._x;
            final String s6 = "\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0431\u0430\u0437:";
            final int n21 = n9;
            n10 += 10;
            x11._b(s6, n21, n10, 2236962);
            final rord x12 = this.field_73882_e._x;
            final String clanStr6 = clanStr(CClanSystem.bases);
            final int n22 = n9;
            n10 += 10;
            x12._b(clanStr6, n22, n10, 2236962);
            final rord x13 = this.field_73882_e._x;
            final String s7 = "\u0422\u0432\u043e\u044f \u0440\u0435\u043f\u0443\u0442\u0430\u0446\u0438\u044f:";
            final int n23 = n9;
            n10 += 10;
            x13._b(s7, n23, n10, 2236962);
            final rord x14 = this.field_73882_e._x;
            final String clanStr7 = clanStr(CClanSystem.allies);
            final int n24 = n9;
            n10 += 10;
            x14._b(clanStr7, n24, n10, 2236962);
        }
        else {
            final rord x15 = this.field_73882_e._x;
            final String s8 = "\u0422\u0432\u043e\u044f \u0440\u0435\u043f\u0443\u0442\u0430\u0446\u0438\u044f:";
            final int n25 = n9;
            n10 += 130;
            x15._b(s8, n25, n10, 2236962);
            final rord x16 = this.field_73882_e._x;
            final String clanStr8 = clanStr(CClanSystem.allies);
            final int n26 = n9;
            n10 += 10;
            x16._b(clanStr8, n26, n10, 2236962);
        }
        if (CClanSystem.yourClan == null) {
            if (this.action == CClanSystem.Action.CREATE) {
                this.field_73882_e._x._b("\u0421\u043e\u0437\u0434\u0430\u043d\u0438\u0435 \u043a\u043b\u0430\u043d\u0430", n9, this.guiTop + 5, 16777215);
                final int n27 = this.guiLeft + 125;
                int n28 = this.guiTop - 5;
                final rord x17 = this.field_73882_e._x;
                final String s9 = "\u041f\u0440\u0430\u0432\u0438\u043b\u0430 \u043a\u043b\u0430\u043d\u043e\u0432:";
                final int n29 = n27;
                n28 += 10;
                x17._b(s9, n29, n28, 2236962);
                final rord x18 = this.field_73882_e._x;
                final String s10 = "\u041f\u0435\u0440\u0435\u0434 \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u0435\u043c";
                final int n30 = n27;
                n28 += 20;
                x18._b(s10, n30, n28, 2236962);
                final rord x19 = this.field_73882_e._x;
                final String s11 = "\u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0439 \u043f\u0440\u0430\u0432\u0438\u043b\u0430";
                final int n31 = n27;
                n28 += 10;
                x19._b(s11, n31, n28, 2236962);
                final rord x20 = this.field_73882_e._x;
                final String s12 = "\u0442\u0430\u043c \u0442\u044b \u043d\u0430\u0439\u0434\u0435\u0448\u044c";
                final int n32 = n27;
                n28 += 10;
                x20._b(s12, n32, n28, 2236962);
                final rord x21 = this.field_73882_e._x;
                final String s13 = "\u043a\u0430\u043a \u043d\u0430\u0436\u0430\u0442\u044c";
                final int n33 = n27;
                n28 += 10;
                x21._b(s13, n33, n28, 2236962);
                final rord x22 = this.field_73882_e._x;
                final String s14 = "\u043a\u043d\u043e\u043f\u043a\u0443 \u0441\u043e\u0437\u0434\u0430\u0442\u044c";
                final int n34 = n27;
                n28 += 10;
                x22._b(s14, n34, n28, 2236962);
                this.field_73882_e._x._b("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043a\u043b\u0430\u043d\u0430:", n27, this.guiTop + 108, 2236962);
            }
            else {
                this.field_73882_e._x._b("\u0422\u044b \u043d\u0435 \u0432 \u043a\u043b\u0430\u043d\u0435", n9, this.guiTop + 5, 16777215);
                final int n35 = this.guiLeft + 125;
                int n36 = this.guiTop - 5;
                final rord x23 = this.field_73882_e._x;
                final String s15 = "\u0416\u0434\u0438 \u043e\u0434\u043e\u0431\u0440\u0435\u043d\u0438\u044f \u0437\u0430\u044f\u0432\u043a\u0438";
                final int n37 = n35;
                n36 += 10;
                x23._b(s15, n37, n36, 2236962);
            }
        }
        else if (this.action == CClanSystem.Action.ACCEPTREQUESTS) {
            this.field_73882_e._x._b("\u0423\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0437\u0430\u044f\u0432\u043a\u0430\u043c\u0438", n9, this.guiTop + 5, 16777215);
            this.field_73882_e._x._b("(F3 - \u0433\u043b\u0430\u0432\u043d\u0430\u044f)", n9, this.guiTop + 15, 16777215);
            final boolean field_73742_g = this.selectedItem != -1;
            final Iterator<tdvs> iterator = (Iterator<tdvs>)this.field_73887_h.iterator();
            while (iterator.hasNext()) {
                iterator.next().field_73742_g = field_73742_g;
            }
        }
        else if (this.action == CClanSystem.Action.CLAN_LIST) {
            this.field_73882_e._x._b("\u0421\u043f\u0438\u0441\u043e\u043a \u043a\u043b\u0430\u043d\u043e\u0432", n9, this.guiTop + 5, 16777215);
        }
        else if (this.action == CClanSystem.Action.EDITMEMBERS) {
            this.field_73882_e._x._b("\u0423\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u0430\u043c\u0438", n9, this.guiTop + 5, 16777215);
            this.field_73882_e._x._b("(F3 - \u0433\u043b\u0430\u0432\u043d\u0430\u044f)", n9, this.guiTop + 15, 16777215);
            final boolean field_73742_g2 = this.selectedItem != -1;
            final Iterator<tdvs> iterator2 = (Iterator<tdvs>)this.field_73887_h.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().field_73742_g = field_73742_g2;
            }
            final tdvs tdvs = this.field_73887_h.get(0);
            final tdvs tdvs2 = this.field_73887_h.get(1);
            if (field_73742_g2) {
                final CClanSystem.ClanMember clanMember = this.list.get(this.selectedItem);
                tdvs.field_73744_e = "\u0417\u0430\u0445\u0432\u0430\u0442 \u0442\u0435\u0440\u0440\u0438\u0442\u043e\u0440\u0438\u0439: " + (clanMember.captureBases ? "+" : "-");
                tdvs2.field_73744_e = "\u041f\u0440\u0438\u0435\u043c \u0432 \u043a\u043b\u0430\u043d: " + (clanMember.acceptMembers ? "+" : "-");
            }
            else {
                tdvs.field_73744_e = "\u0417\u0430\u0445\u0432\u0430\u0442 \u0442\u0435\u0440\u0440\u0438\u0442\u043e\u0440\u0438\u0439: ?";
                tdvs2.field_73744_e = "\u041f\u0440\u0438\u0435\u043c \u0432 \u043a\u043b\u0430\u043d: ?";
            }
        }
        else if (!CClanSystem.isMember) {
            this.field_73882_e._x._b("\u0417\u0430\u044f\u0432\u043a\u0430 \u0440\u0430\u0441\u0441\u043c\u0430\u0442\u0440\u0438\u0432\u0435\u0442\u0441\u044f", n9, this.guiTop + 5, 16777215);
        }
        else {
            this.field_73882_e._x._b("\u0422\u0432\u043e\u0439 \u043a\u043b\u0430\u043d", n9, this.guiTop + 5, 16777215);
            if (CClanSystem.isMember) {
                if (CClanSystem.canCaptureBases && !CClanSystem.base.isEmpty()) {
                    final String[] split = CClanSystem.base.split("\n", 2);
                    this.field_73882_e._x._b("\u0422\u044b \u043d\u0430 \u0442\u0435\u0440\u0440\u0438\u0442\u043e\u0440\u0438\u0438", this.guiLeft + 125, this.guiTop + 80, 2236962);
                    this.field_73882_e._x._b(split[0], this.guiLeft + 125, this.guiTop + 90, 2236962);
                }
                this.field_73882_e._x._b("\u042d\u0442\u043e \u043f\u0440\u0438\u0432\u0435\u0434\u0435\u0442 \u043a \u043f\u043e\u0442\u0435\u0440\u0435", this.guiLeft + 125, this.guiTop + 120, 16720418);
                this.field_73882_e._x._b("\u043e\u0447\u043a\u043e\u0432 \u0440\u0435\u043f\u0443\u0442\u0430\u0446\u0438\u0438", this.guiLeft + 125, this.guiTop + 130, 16720418);
            }
        }
        if (this.list != null) {
            final int n38 = (this.list.size() > this.scrollItemInList) ? ((int)((this.list.size() - this.scrollItemInList) * this.currentScroll)) : 0;
            final int n39 = (this.list.size() > this.scrollItemInList) ? this.scrollItemInList : this.list.size();
            final int n40 = this.guiLeft + this.scrollX - this.scrollW + 2;
            int n41 = this.guiTop - 5;
            qlob.func_73734_a(this.guiLeft + this.scrollX - this.scrollW, this.guiTop + this.scrollY, this.guiLeft + 248 - 19, this.guiTop + this.scrollY + n4, -14540254);
            qlob.func_73734_a(this.guiLeft + 248 - 19, this.guiTop + this.scrollY, this.guiLeft + 248 - 5, this.guiTop + this.scrollY + n4, -16777216);
            final int n42 = this.guiLeft + this.scrollX;
            final int n43 = (int)(this.guiTop + this.scrollY + (n4 - 12) * this.currentScroll);
            qlob.func_73734_a(n42 + 2, n43 + 2, n42 + 12, n43 + 10, -1);
            int n44 = -1;
            if (n > this.guiLeft + this.scrollX - this.scrollW && n < this.guiLeft + this.scrollX && n2 > this.guiTop + this.scrollY && n2 < this.guiTop + this.scrollY + n4) {
                n44 = n38 + (n2 - this.guiTop - this.scrollY) / 10;
            }
            for (int i = 0; i < n39; ++i) {
                final int n45 = i + n38;
                if (n45 < this.list.size()) {
                    if (n44 == n45) {
                        qlob.func_73734_a(n40 - 1, n41 + 10, n40 + this.scrollW - 3, n41 + 20, -15658735);
                    }
                    else if (this.selectedItem == n45) {
                        qlob.func_73734_a(n40 - 1, n41 + 10, n40 + this.scrollW - 3, n41 + 20, -16777216);
                    }
                    final Object value = this.list.get(n45);
                    if (value instanceof CClanSystem.ClanMember) {
                        if (((CClanSystem.ClanMember)value).online) {
                            final rord x24 = this.field_73882_e._x;
                            final String string = "ON:" + value.toString();
                            final int n46 = n40;
                            n41 += 10;
                            x24._b(string, n46, n41, (value instanceof CClanSystem.ColoredString) ? ((CClanSystem.ColoredString)value).color : -1);
                        }
                        else {
                            final rord x25 = this.field_73882_e._x;
                            final String string2 = value.toString();
                            final int n47 = n40;
                            n41 += 10;
                            x25._b(string2, n47, n41, (value instanceof CClanSystem.ColoredString) ? ((CClanSystem.ColoredString)value).color : -1);
                        }
                    }
                    else {
                        final rord x26 = this.field_73882_e._x;
                        final String string3 = value.toString();
                        final int n48 = n40;
                        n41 += 10;
                        x26._b(string3, n48, n41, (value instanceof CClanSystem.ColoredString) ? ((CClanSystem.ColoredString)value).color : -1);
                    }
                }
            }
        }
        GL11.glDisable(3042);
        ncpk._a();
        GL11.glPopAttrib();
    }
    
    protected void func_73875_a(final tdvs tdvs) {
        if (CClanSystem.yourClan == null) {
            if (this.action == CClanSystem.Action.CREATE) {
                if (tdvs.field_73741_f == 0 && ((tdvs.field_73744_e != "\u0421\u043e\u0437\u0434\u0430\u0442\u044c" && Keyboard.isKeyDown(42)) || (tdvs.field_73744_e == "\u0421\u043e\u0437\u0434\u0430\u0442\u044c" && Keyboard.isKeyDown(29)))) {
                    if (tdvs.field_73744_e != "\u0421\u043e\u0437\u0434\u0430\u0442\u044c") {
                        tdvs.field_73744_e = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c";
                    }
                    else {
                        final VCP vcp = new VCP(7, "HCSMOD");
                        try {
                            CClanSystem.writeCreateClan((DataOutput)vcp, this.input._b());
                            vcp.send();
                        }
                        catch (Throwable t) {}
                        CClanSystem.yourClan = this.input._b();
                        this.action = null;
                        this.func_73866_w_();
                    }
                }
                else if (tdvs.field_73741_f == 1) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://hcs.land/clanrules.html"));
                    }
                    catch (IOException ex4) {}
                    catch (URISyntaxException ex5) {}
                }
            }
            else if (tdvs.field_73741_f == 0) {
                String s = "";
                try {
                    s = CClanSystem.clansList.get(this.selectedItem);
                }
                catch (Throwable t2) {}
                final VCP vcp2 = new VCP(7, "HCSMOD");
                try {
                    CClanSystem.writeClanJoinRequest((DataOutput)vcp2, s);
                }
                catch (IOException ex6) {}
                vcp2.send();
            }
            else if (tdvs.field_73741_f == 1) {
                this.action = CClanSystem.Action.CREATE;
                this.func_73866_w_();
            }
        }
        else if (this.action == CClanSystem.Action.ACCEPTREQUESTS) {
            if (this.selectedItem != -1) {
                final VCP vcp3 = new VCP(7, "HCSMOD");
                if (tdvs.field_73741_f == 0) {
                    try {
                        vcp3.writeByte(4);
                    }
                    catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else if (tdvs.field_73741_f == 1) {
                    try {
                        vcp3.writeByte(5);
                    }
                    catch (IOException ex7) {}
                }
                try {
                    vcp3.writeUTF(this.selectedString);
                }
                catch (IOException ex8) {}
                vcp3.send();
            }
        }
        else if (this.action == CClanSystem.Action.CLAN_LIST) {
            if (this.selectedItem != -1) {
                if (tdvs.field_73741_f == 0) {
                    this.needToReloadClanInfo = true;
                    final VCP vcp4 = new VCP(7, "HCSMOD");
                    try {
                        vcp4.writeByte(12);
                        vcp4.writeBoolean(true);
                        vcp4.writeUTF(this.selectedString);
                    }
                    catch (IOException ex2) {
                        ex2.printStackTrace();
                    }
                    vcp4.send();
                }
                else if (tdvs.field_73741_f == 1) {
                    final VCP vcp5 = new VCP(7, "HCSMOD");
                    try {
                        vcp5.writeByte(61);
                        vcp5.writeUTF(this.selectedString);
                        vcp5.send();
                        this.list = GuiClanSystem.dummyList;
                    }
                    catch (IOException ex9) {}
                    this.action = CClanSystem.Action.EDITMEMBERS;
                    this.func_73866_w_();
                }
            }
        }
        else if (this.action == CClanSystem.Action.EDITMEMBERS) {
            if (this.selectedItem != -1) {
                final CClanSystem.ClanMember clanMember = this.list.get(this.selectedItem);
                if (tdvs.field_73741_f == 2) {
                    final VCP vcp6 = new VCP(7, "HCSMOD");
                    try {
                        vcp6.writeByte(8);
                        vcp6.writeUTF(clanMember.toString());
                        vcp6.send();
                    }
                    catch (IOException ex10) {}
                }
                else {
                    if (tdvs.field_73741_f == 0) {
                        clanMember.captureBases = !clanMember.captureBases;
                    }
                    else if (tdvs.field_73741_f == 1) {
                        clanMember.acceptMembers = !clanMember.acceptMembers;
                    }
                    final VCP vcp7 = new VCP(7, "HCSMOD");
                    int n = 0;
                    if (clanMember.captureBases) {
                        ++n;
                    }
                    if (clanMember.acceptMembers) {
                        n += 2;
                    }
                    if (clanMember.editRelationships) {
                        n += 4;
                    }
                    try {
                        vcp7.writeByte(7);
                        vcp7.writeUTF(clanMember.toString());
                        vcp7.writeByte(n);
                        vcp7.send();
                    }
                    catch (IOException ex11) {}
                }
            }
        }
        else {
            final VCP vcp8 = new VCP(7, "HCSMOD");
            if (tdvs.field_73741_f == 0) {
                try {
                    CClanSystem.writeLeaveClan((DataOutput)vcp8);
                }
                catch (IOException ex3) {
                    ex3.printStackTrace();
                }
            }
            else if (tdvs.field_73741_f == 1) {
                try {
                    vcp8.writeByte(3);
                }
                catch (IOException ex12) {}
                this.action = CClanSystem.Action.ACCEPTREQUESTS;
                this.func_73866_w_();
            }
            else if (tdvs.field_73741_f == 2) {
                try {
                    vcp8.writeByte(11);
                }
                catch (IOException ex13) {}
                this.action = CClanSystem.Action.CLAN_LIST;
                this.func_73866_w_();
            }
            else if (tdvs.field_73741_f == 3) {
                try {
                    vcp8.writeByte(6);
                }
                catch (IOException ex14) {}
                this.action = CClanSystem.Action.EDITMEMBERS;
                this.func_73866_w_();
            }
            else if (tdvs.field_73741_f == 4) {
                try {
                    vcp8.writeByte(9);
                }
                catch (IOException ex15) {}
            }
            vcp8.send();
        }
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) {
        super.func_73864_a(n, n2, n3);
        if (this.input != null) {
            this.input._a(n, n2, n3);
        }
        if (this.list != null) {
            final int selectedItem = (this.list.size() > this.scrollItemInList) ? ((int)((this.list.size() - this.scrollItemInList) * this.currentScroll)) : 0;
            if (n > this.guiLeft + this.scrollX - this.scrollW && n < this.guiLeft + this.scrollX && n2 > this.guiTop + this.scrollY && n2 < this.guiTop + this.scrollY + this.scrollItemInList * 10) {
                final int n4 = n2 - this.guiTop - this.scrollY;
                this.selectedItem = selectedItem;
                this.selectedItem += n4 / 10;
                if (this.selectedItem >= 0 && this.selectedItem < this.list.size()) {
                    this.selectedString = this.list.get(this.selectedItem).toString();
                }
                else {
                    this.selectedItem = -1;
                }
            }
        }
    }
    
    protected void func_73869_a(final char c, final int n) {
        if (this.input != null) {
            this.input._a(c, n);
            if (this.action == CClanSystem.Action.CREATE) {
                this.field_73887_h.get(0).field_73742_g = (this.input._b().trim().length() >= 3);
            }
        }
        super.func_73869_a(c, n);
    }
    
    private static String clanStr(final Object o) {
        return (CClanSystem.yourClan == null) ? "-" : ((o != null) ? o.toString() : "null");
    }
    
    public void func_73867_d() {
        super.func_73867_d();
        int eventDWheel = Mouse.getEventDWheel();
        if (eventDWheel != 0 && this.list != null) {
            final int n = (this.list.size() > this.scrollItemInList) ? (this.list.size() - this.scrollItemInList) : 0;
            if (eventDWheel > 0) {
                eventDWheel = 3;
            }
            if (eventDWheel < 0) {
                eventDWheel = -3;
            }
            this.currentScroll -= (float)(eventDWheel / (double)n);
            if (this.currentScroll < 0.0f) {
                this.currentScroll = 0.0f;
            }
            if (this.currentScroll > 1.0f) {
                this.currentScroll = 1.0f;
            }
            if (this.selectedItem >= 0 && this.selectedItem < this.list.size()) {
                this.selectedString = this.list.get(this.selectedItem).toString();
            }
            else {
                this.selectedItem = -1;
            }
        }
    }
    
    public static tdvs enable(final tdvs tdvs, final boolean field_73742_g) {
        tdvs.field_73742_g = field_73742_g;
        return tdvs;
    }
    
    public static tdvs show(final tdvs tdvs, final boolean field_73748_h) {
        tdvs.field_73748_h = field_73748_h;
        return tdvs;
    }
    
    public boolean func_73868_f() {
        return false;
    }
    
    private void watermark() {
        GL11.glEnable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.75f);
        final int n = (int)((int)dwbg._c((float)(this.field_73880_f * this.field_73880_f + this.field_73881_g * this.field_73881_g)) / 6.5f);
        final int n2 = this.field_73880_f - n;
        final int n3 = this.field_73881_g - n;
        this.field_73882_e._f._a(GuiClanSystem.trist);
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a((double)(n2 + 0), (double)(n3 + n), (double)this.field_73735_i, 0.0, 1.0);
        field_78398_a.func_78374_a((double)(n2 + n), (double)(n3 + n), (double)this.field_73735_i, 1.0, 1.0);
        field_78398_a.func_78374_a((double)(n2 + n), (double)(n3 + 0), (double)this.field_73735_i, 1.0, 0.0);
        field_78398_a.func_78374_a((double)(n2 + 0), (double)(n3 + 0), (double)this.field_73735_i, 0.0, 0.0);
        field_78398_a.func_78381_a();
    }
    
    static {
        field_110421_t = new ResourceLocation("textures/gui/demo_background.png");
        trist = new ResourceLocation("hcsmod:dragon_trainer_tristana.png");
        dummyList = new List() {
            @Override
            public int size() {
                return 0;
            }
            
            @Override
            public boolean isEmpty() {
                return true;
            }
            
            @Override
            public boolean contains(final Object o) {
                return false;
            }
            
            @Override
            public Iterator iterator() {
                return null;
            }
            
            @Override
            public Object[] toArray() {
                return new Object[0];
            }
            
            @Override
            public Object[] toArray(final Object[] array) {
                return new Object[0];
            }
            
            @Override
            public boolean add(final Object o) {
                return false;
            }
            
            @Override
            public boolean remove(final Object o) {
                return false;
            }
            
            @Override
            public boolean containsAll(final Collection collection) {
                return false;
            }
            
            @Override
            public boolean addAll(final Collection collection) {
                return false;
            }
            
            @Override
            public boolean addAll(final int n, final Collection collection) {
                return false;
            }
            
            @Override
            public boolean removeAll(final Collection collection) {
                return false;
            }
            
            @Override
            public boolean retainAll(final Collection collection) {
                return false;
            }
            
            @Override
            public void clear() {
            }
            
            @Override
            public Object get(final int n) {
                return null;
            }
            
            @Override
            public Object set(final int n, final Object o) {
                return null;
            }
            
            @Override
            public void add(final int n, final Object o) {
            }
            
            @Override
            public Object remove(final int n) {
                return null;
            }
            
            @Override
            public int indexOf(final Object o) {
                return -1;
            }
            
            @Override
            public int lastIndexOf(final Object o) {
                return -1;
            }
            
            @Override
            public ListIterator listIterator() {
                return null;
            }
            
            @Override
            public ListIterator listIterator(final int n) {
                return null;
            }
            
            @Override
            public List subList(final int n, final int n2) {
                return null;
            }
        };
    }
}
