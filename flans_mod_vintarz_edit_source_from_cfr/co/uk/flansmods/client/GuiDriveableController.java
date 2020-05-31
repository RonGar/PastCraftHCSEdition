/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  dwms
 *  hbei
 *  kkdv
 *  nceh
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.lmwe
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  uyla
 */
package co.uk.flansmods.client;

import co.uk.flansmods.api.IControllable;
import co.uk.flansmods.client.KeyInputHandler;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;
import net.minecraft.util.lmwe;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GuiDriveableController
extends dwms {
    private IControllable plane;
    private boolean leftMouseHeld;
    private boolean rightMouseHeld;

    public GuiDriveableController(IControllable iControllable) {
        this.plane = iControllable;
    }

    public void func_73874_b() {
        this.field_73882_e._M._b();
    }

    public void func_73867_d() {
        EntityPlayer entityPlayer = (EntityPlayer)this.plane.getControllingEntity();
        if (entityPlayer != this.field_73882_e._r) {
            this.field_73882_e._a(null);
        } else {
            int n = Mouse.getDWheel();
            if (n != 0) {
                entityPlayer.field_71071_by._b(n);
            }
            if (!this.leftMouseHeld && Mouse.isButtonDown((int)0)) {
                this.leftMouseHeld = true;
                this.plane.updateKeyHeldState(9, true);
            }
            if (this.leftMouseHeld && !Mouse.isButtonDown((int)0)) {
                this.leftMouseHeld = false;
                this.plane.updateKeyHeldState(9, false);
            }
            if (!this.rightMouseHeld && Mouse.isButtonDown((int)1)) {
                this.rightMouseHeld = true;
                this.plane.updateKeyHeldState(8, true);
            }
            if (this.rightMouseHeld && !Mouse.isButtonDown((int)1)) {
                this.rightMouseHeld = false;
                this.plane.updateKeyHeldState(8, false);
            }
        }
    }

    protected void func_73869_a(char c, int n) {
        if (n == 1) {
            this.field_73882_e._a(null);
            this.field_73882_e._q();
        }
        if (n == 59) {
            boolean bl = this.field_73882_e._K.__bv = !this.field_73882_e._K.__bv;
        }
        if (n == 66) {
            boolean bl = this.field_73882_e._K.__bB = !this.field_73882_e._K.__bB;
        }
        if (n == this.field_73882_e._K.__bi._d) {
            this.field_73882_e._a((dwms)new kkdv((EntityPlayer)this.field_73882_e._r));
        }
        if (n == this.field_73882_e._K.__bk._d) {
            this.field_73882_e._a((dwms)new nceh());
        }
        if (n == this.field_73882_e._K.__bq._d) {
            this.field_73882_e._a((dwms)new nceh("/"));
        }
    }

    public void func_73862_m() {
        EntityPlayer entityPlayer = (EntityPlayer)this.plane.getControllingEntity();
        if (entityPlayer != this.field_73882_e._r) {
            this.field_73882_e._a(null);
        } else {
            if (!Mouse.isGrabbed()) {
                this.field_73882_e._M._a();
            }
            this.func_73867_d();
            while (Keyboard.next()) {
                this.func_73860_n();
            }
            int n = Mouse.getDX();
            int n2 = Mouse.getDY();
            this.plane.onMouseMoved(n, n2);
            if (this.plane != null && !this.plane.isDead() && this.plane.getControllingEntity() != null && this.plane.getControllingEntity() instanceof EntityPlayer) {
                if (FlansMod.proxy.keyDown(KeyInputHandler.accelerateKey._d)) {
                    this.plane.pressKey(0, entityPlayer);
                }
                if (FlansMod.proxy.keyDown(KeyInputHandler.decelerateKey._d)) {
                    this.plane.pressKey(1, entityPlayer);
                }
                if (FlansMod.proxy.keyDown(KeyInputHandler.leftKey._d)) {
                    this.plane.pressKey(2, entityPlayer);
                }
                if (FlansMod.proxy.keyDown(KeyInputHandler.rightKey._d)) {
                    this.plane.pressKey(3, entityPlayer);
                }
                if (FlansMod.proxy.keyDown(KeyInputHandler.upKey._d)) {
                    this.plane.pressKey(4, entityPlayer);
                }
                if (FlansMod.proxy.keyDown(KeyInputHandler.exitKey._d)) {
                    this.plane.pressKey(6, entityPlayer);
                }
                if (FlansMod.proxy.keyDown(KeyInputHandler.inventoryKey._d)) {
                    this.plane.pressKey(7, entityPlayer);
                }
                if (FlansMod.proxy.keyDown(KeyInputHandler.gunKey._d)) {
                    this.plane.pressKey(9, entityPlayer);
                }
            } else {
                this.field_73882_e._a(null);
            }
        }
    }

    public void func_73871_c(int n) {
    }

    public boolean func_73868_f() {
        return false;
    }
}

