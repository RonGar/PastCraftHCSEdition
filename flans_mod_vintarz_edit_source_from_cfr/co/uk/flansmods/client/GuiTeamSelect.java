/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  dwms
 *  hbei
 *  ieta
 *  maaq
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  rojd
 *  rord
 *  tdvs
 *  uyeb
 *  uyla
 *  zfwe
 */
package co.uk.flansmods.client;

import co.uk.flansmods.common.network.PacketTeamSelect;
import co.uk.flansmods.common.teams.PlayerClass;
import co.uk.flansmods.common.teams.Team;
import cpw.mods.fml.common.network.PacketDispatcher;
import java.util.List;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiTeamSelect
extends dwms {
    private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/teams.png");
    private static uyeb itemRenderer = new uyeb();
    private boolean classMenu;
    private static Team[] teamChoices;
    private PlayerClass[] classChoices;
    private int guiHeight;

    public GuiTeamSelect() {
        if (teamChoices == null) {
            rojd.instance().getClient()._a(null);
        } else {
            this.classMenu = false;
            this.guiHeight = 29 + 24 * teamChoices.length;
        }
    }

    public GuiTeamSelect(Team[] arrteam) {
        this.classMenu = false;
        teamChoices = arrteam;
        this.guiHeight = 29 + 24 * arrteam.length;
    }

    public GuiTeamSelect(PlayerClass[] arrplayerClass) {
        this.classMenu = true;
        this.classChoices = arrplayerClass;
        this.guiHeight = 29 + 24 * arrplayerClass.length;
    }

    public void func_73866_w_() {
        super.func_73866_w_();
        if (this.classMenu) {
            for (int i = 0; i < this.classChoices.length; ++i) {
                if (this.classChoices[i] == null) continue;
                this.field_73887_h.add(new tdvs(i, this.field_73880_f / 2 - 128 + 9, this.field_73881_g / 2 - this.guiHeight / 2 + 24 + 24 * i, 73, 20, this.classChoices[i].name));
            }
        } else {
            if (teamChoices == null) {
                rojd.instance().getClient()._a(null);
                return;
            }
            for (int i = 0; i < teamChoices.length; ++i) {
                if (teamChoices[i] == null) continue;
                this.field_73887_h.add(new tdvs(i, this.field_73880_f / 2 - 128 + 10, this.field_73881_g / 2 - this.guiHeight / 2 + 24 + 24 * i, 236, 20, "\u00a7" + GuiTeamSelect.teamChoices[i].textColour + GuiTeamSelect.teamChoices[i].name));
            }
        }
    }

    public void func_73863_a(int n, int n2, float f) {
        int n3;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.field_73882_e._f._a(texture);
        this.func_73729_b(this.field_73880_f / 2 - 128, this.field_73881_g / 2 - this.guiHeight / 2, 0, 0, 256, 22);
        this.func_73729_b(this.field_73880_f / 2 - 128, this.field_73881_g / 2 + this.guiHeight / 2 - 6, 0, 73, 256, 7);
        if (this.classMenu) {
            for (n3 = 0; n3 < this.classChoices.length; ++n3) {
                this.func_73729_b(this.field_73880_f / 2 - 128, this.field_73881_g / 2 - this.guiHeight / 2 + 22 + 24 * n3, 0, 23, 256, 24);
            }
        } else {
            for (n3 = 0; n3 < teamChoices.length; ++n3) {
                this.func_73729_b(this.field_73880_f / 2 - 128, this.field_73881_g / 2 - this.guiHeight / 2 + 22 + 24 * n3, 0, 48, 256, 24);
            }
        }
        this.field_73886_k._a(this.classMenu ? "Choose a Class" : "Choose a Team", this.field_73880_f / 2 - 120, this.field_73881_g / 2 - this.guiHeight / 2 + 8, 16777215);
        super.func_73863_a(n, n2, f);
        if (this.classMenu) {
            for (n3 = 0; n3 < this.classChoices.length; ++n3) {
                for (int i = 0; i < this.classChoices[n3].startingItems.size(); ++i) {
                    this.drawSlotInventory(this.classChoices[n3].startingItems.get(i), this.field_73880_f / 2 - 128 + 85 + 18 * i, this.field_73881_g / 2 - this.guiHeight / 2 + 26 + 24 * n3);
                }
            }
        }
    }

    protected void func_73875_a(tdvs tdvs2) {
        if (this.classMenu) {
            PacketDispatcher.sendPacketToServer((maaq)PacketTeamSelect.buildSelectionPacket(this.classChoices[tdvs2.field_73741_f].shortName, true));
        } else {
            PacketDispatcher.sendPacketToServer((maaq)PacketTeamSelect.buildSelectionPacket(GuiTeamSelect.teamChoices[tdvs2.field_73741_f].shortName, false));
        }
        tuor._E()._a(null);
    }

    private void drawSlotInventory(ieta ieta2, int n, int n2) {
        itemRenderer._a(this.field_73886_k, this.field_73882_e._f, ieta2, n, n2);
        itemRenderer._c(this.field_73886_k, this.field_73882_e._f, ieta2, n, n2);
    }

    public boolean func_73868_f() {
        return false;
    }

    protected void func_73869_a(char c, int n) {
        if (n == 1 || n == this.field_73882_e._K.__bi._d) {
            this.field_73882_e._r.func_71053_j();
            if (this.classMenu) {
                if (this.classChoices != null && this.classChoices.length > 0) {
                    PacketDispatcher.sendPacketToServer((maaq)PacketTeamSelect.buildSelectionPacket(this.classChoices[0].shortName, true));
                }
            } else {
                PacketDispatcher.sendPacketToServer((maaq)PacketTeamSelect.buildSelectionPacket(Team.spectators.shortName, false));
            }
        }
    }

    public void func_73874_b() {
    }
}

