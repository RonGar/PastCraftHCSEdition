/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cuqu
 *  ivrt
 *  maaq
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  rord
 *  tdvs
 *  zfwe
 *  zwlp
 */
package co.uk.flansmods.client;

import co.uk.flansmods.common.ContainerPlaneMenu;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.driveables.DriveableData;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.network.PacketDriveableDamage;
import co.uk.flansmods.common.network.PacketLocked;
import co.uk.flansmods.common.network.PacketVehicleGUI;
import cpw.mods.fml.common.network.PacketDispatcher;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidl;
import net.minecraft.entity.player.rojd;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiDriveableMenu
extends zwlp {
    private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/planeMenu.png");
    public cuqu world;
    public rojd inventory;
    public EntityDriveable entity;
    private String lockedString = "";
    private tdvs lockButton;

    public GuiDriveableMenu(rojd rojd2, cuqu cuqu2, EntityDriveable entityDriveable) {
        super((ivrt)new ContainerPlaneMenu(rojd2, cuqu2));
        this.entity = entityDriveable;
        this.field_74195_c = 180;
        this.world = cuqu2;
        this.inventory = rojd2;
    }

    public void func_73866_w_() {
        ivrt ivrt2 = this.field_73882_e._r.field_71070_bA;
        super.func_73866_w_();
        this.field_73882_e._r.field_71070_bA = ivrt2;
        this.lockButton = new tdvs(0, this.field_73880_f / 2 - 60, this.field_73881_g / 2 - 71, 58, 20, "");
        this.field_73887_h.add(this.lockButton);
        if (this.inventory._d.field_71075_bZ._d) {
            this.field_73887_h.add(new tdvs(1, this.field_73880_f / 2 + 2, this.field_73881_g / 2 - 71, 58, 20, "\u0412\u0437\u043e\u0440\u0432\u0430\u0442\u044c"));
        }
        this.field_73887_h.add(new tdvs(2, this.field_73880_f / 2 - 60, this.field_73881_g / 2 - 49, 58, 20, "\u0422\u043e\u043f\u043b\u0438\u0432\u043e"));
        this.field_73887_h.add(new tdvs(3, this.field_73880_f / 2 + 2, this.field_73881_g / 2 - 49, 58, 20, "\u0411\u0430\u0433\u0430\u0436\u043d\u0438\u043a"));
        this.field_73887_h.add(new tdvs(4, this.field_73880_f / 2 - 60, this.field_73881_g / 2 - 27, 58, 20, "\u0421\u043e\u0441\u0442\u043e\u044f\u043d\u0438\u0435"));
    }

    protected void func_73875_a(tdvs tdvs2) {
        if (tdvs2.field_73741_f == 0) {
            PacketDispatcher.sendPacketToServer((maaq)PacketLocked.buildLockedPacket());
        }
        if (tdvs2.field_73741_f == 1 && this.inventory._d.field_71075_bZ._d) {
            this.entity.getDriveableData().parts.get((Object)EnumDriveablePart.core).health = -1;
            PacketDispatcher.sendPacketToServer((maaq)PacketDriveableDamage.buildUpdatePacket(this.entity));
        }
        if (tdvs2.field_73741_f == 2) {
            PacketDispatcher.sendPacketToServer((maaq)PacketVehicleGUI.buildGUIPacket(2));
            this.inventory._d.openGui((Object)FlansMod.instance, 8, this.world, this.entity.field_70176_ah, this.entity.field_70162_ai, this.entity.field_70164_aj);
        }
        if (tdvs2.field_73741_f == 3) {
            PacketDispatcher.sendPacketToServer((maaq)PacketVehicleGUI.buildGUIPacket(3));
            this.inventory._d.openGui((Object)FlansMod.instance, 9, this.world, this.entity.field_70176_ah, this.entity.field_70162_ai, this.entity.field_70164_aj);
        }
        if (tdvs2.field_73741_f == 4) {
            this.inventory._d.openGui((Object)FlansMod.instance, 1, this.world, this.entity.field_70176_ah, this.entity.field_70162_ai, this.entity.field_70164_aj);
        }
    }

    protected void func_74189_g(int n, int n2) {
        this.field_73886_k._b(this.entity.getDriveableType().name, 6, 6, 13290186);
        if (this.lockedString != null) {
            this.field_73886_k._b("\u041c\u0430\u0448\u0438\u043d\u0430 \u0437\u0430\u043a\u0440\u044b\u0442\u0430, \u043f\u043e\u043a\u0430 \u0438\u0433\u0440\u043e\u043a " + this.lockedString + " \u043e\u043d\u043b\u0430\u0439\u043d", 3, -12, 13290186);
        }
    }

    protected void func_74185_a(float f, int n, int n2) {
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.field_73882_e._f._a(texture);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        GL11.glDisable((int)3042);
    }

    public void func_73876_c() {
        super.func_73876_c();
        String string = this.entity.locked();
        if (string != null) {
            if (!string.equals(this.lockedString)) {
                this.lockedString = string;
                this.lockButton.field_73744_e = "\u0417\u0430\u043a\u0440\u044b\u0442\u0430";
            }
        } else if (this.lockedString != null) {
            this.lockedString = null;
            this.lockButton.field_73744_e = "\u041e\u0442\u043a\u0440\u044b\u0442\u0430";
        }
    }
}

