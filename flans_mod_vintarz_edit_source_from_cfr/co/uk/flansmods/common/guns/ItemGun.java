/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ccfp
 *  co.uk.flansmods.vintarz.
 *  co.uk.flansmods.vintarz.$.TiProebal
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cupi
 *  cuqu
 *  dwms
 *  eitc
 *  hbei
 *  hcsmod.HCS
 *  hcsmod.client.HcsClient
 *  hcsmod.client.hud.DayZHud
 *  hcsmod.client.hud.DayZHud$Hint
 *  hcsmod.player.ExtendedPlayer
 *  hcsmod.player.InventoryExtended
 *  hcsmod.server.HcsServer
 *  hcsmod.server.SPacketHandler
 *  hrvk
 *  hsus
 *  ieta
 *  jhvs
 *  kjsv
 *  kkfb
 *  maaq
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.roij
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  qlze
 *  rojd
 *  rpnc
 *  tekj
 *  tevp
 *  uyla
 *  vintarz.core.VCore
 *  zgmv
 *  zxiv
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.client.FlansModClient;
import co.uk.flansmods.client.model.GunAnimations;
import co.uk.flansmods.client.model.ModelGun;
import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.guns.AttachmentType;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.DamageMultiplier;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.guns.EnumFireMode;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.IScope;
import co.uk.flansmods.common.guns.ItemBullet;
import co.uk.flansmods.common.network.PacketAiming;
import co.uk.flansmods.common.network.PacketGunFire;
import co.uk.flansmods.common.network.PacketPlaySound;
import co.uk.flansmods.vintarz.;
import co.uk.flansmods.vintarz.BulletSpread;
import co.uk.flansmods.vintarz.BulletTypeMod;
import co.uk.flansmods.vintarz.EntityShootFX;
import co.uk.flansmods.vintarz.GunTypeMod;
import co.uk.flansmods.vintarz.Util;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.HCS;
import hcsmod.client.HcsClient;
import hcsmod.client.hud.DayZHud;
import hcsmod.player.ExtendedPlayer;
import hcsmod.player.InventoryExtended;
import hcsmod.server.HcsServer;
import hcsmod.server.SPacketHandler;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.eidl;
import net.minecraft.util.roij;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import vintarz.core.VCore;

public class ItemGun
extends jhvs {
    public GunType type;
    private static boolean mouseHeld;
    public int soundDelay;
    public static boolean CHS;

    public ItemGun(int n, GunType gunType) {
        super(n);
        this.field_77777_bU = 1;
        this.type = gunType;
        this.type.item = this;
        this.func_77656_e(1000);
        this.func_77637_a((tekj)FlansMod.tabFlanGuns);
    }

    public boolean func_77651_p() {
        return true;
    }

    public ieta getBulletItemStack(ieta ieta2, int n) {
        if (!ieta2._p()) {
            ieta2._e = new hsus("tag");
            return null;
        }
        if (ieta2._e._c("ammo")) {
            tevp tevp2 = ieta2._e._n("ammo");
            hsus hsus2 = (hsus)tevp2._b(n);
            return !hsus2._c("id") ? null : new ieta((int)hsus2._e("id"), (int)hsus2._e("num"), (int)hsus2._e("dam"));
        }
        tevp tevp3 = new tevp();
        for (int i = 0; i < this.type.numAmmoItemsInGun; ++i) {
            tevp3._a((zxiv)new hsus());
        }
        ieta2._e._a("ammo", (zxiv)tevp3);
        return null;
    }

    public void setBulletItemStack(ieta ieta2, ieta ieta3, int n) {
        tevp tevp2;
        if (!ieta2._p()) {
            ieta2._e = new hsus("tag");
        }
        if (!ieta2._e._c("ammo")) {
            tevp2 = new tevp();
            for (int i = 0; i < this.type.numAmmoItemsInGun; ++i) {
                tevp2._a((zxiv)new hsus());
            }
            ieta2._e._a("ammo", (zxiv)tevp2);
        }
        tevp2 = ieta2._e._n("ammo");
        hsus hsus2 = (hsus)tevp2._b(n);
        if (ieta3 == null) {
            hsus2._p("id");
            hsus2._p("num");
            hsus2._p("dam");
        } else {
            hsus2._a("id", (short)ieta3._d);
            hsus2._a("num", (short)ieta3._b);
            hsus2._a("dam", (short)ieta3._j());
        }
    }

    public void func_77624_a(ieta ieta2, EntityPlayer entityPlayer, List list, boolean bl) {
        Object object2;
        if (ieta2._j() + 1 >= ieta2._k()) {
            list.add("\u00a7c\u041e\u0440\u0443\u0436\u0438\u0435 \u0421\u041b\u041e\u041c\u0410\u041d\u041e");
            list.add("\u041c\u043e\u0436\u043d\u043e \u043f\u043e\u0447\u0438\u043d\u0438\u0442\u044c \u0432 \u043a\u0440\u0430\u0444\u0442\u0435");
            list.add("\u0436\u0435\u043b\u0435\u0437\u043e\u043c \u0438\u043b\u0438 \u0440\u0435\u043c\u043e\u043d\u0442\u043d\u044b\u043c \u043d\u0430\u0431\u043e\u0440\u043e\u043c");
        }
        for (int i = 0; i < this.type.numAmmoItemsInGun; ++i) {
            ieta ieta3 = this.getBulletItemStack(ieta2, i);
            if (ieta3 == null || !(ieta3._a() instanceof ItemBullet)) continue;
            BulletType infoType = ((ItemBullet)ieta3._a()).type;
            object2 = "\u00a7e" + infoType.name + " " + (ieta3._k() - ieta3._j()) + "/" + ieta3._k();
            list.add(object2);
        }
        if (Keyboard.isKeyDown((int)42) || Keyboard.isKeyDown((int)54)) {
            list.add("\u00a7f\u0423\u0440\u043e\u043d " + ItemGun.getClientDamage(ieta2));
            for (Object object2 : DamageMultiplier.VALUES) {
                list.add("\u0412 " + object2.where + " x" + String.format("%.1f", Float.valueOf(object2.value)).replace(',', '.') + ": " + (int)((float)ItemGun.getClientDamage(ieta2) * object2.value));
            }
        } else if (ItemGun.getClientDamage(ieta2) != 0) {
            list.add("\u0423\u0440\u043e\u043d " + ItemGun.getClientDamage(ieta2) + " [SHIFT]");
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMaximumFractionDigits(1);
            list.add("\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u0440\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c " + decimalFormat.format(20.0f / (float)this.getClientShootDelay(ieta2)) + " \u0432\u044b\u0441\u0442\u0440./\u0441");
            list.add("\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u043f\u0443\u043b\u0438 " + ItemGun.getClientBulletSpeed(ieta2) * 20.0f + " \u0431\u043b\u043e\u043a\u043e\u0432./\u0441");
            list.add("\u0420\u0430\u0437\u0431\u0440\u043e\u0441 " + ItemGun.getClientSpread(ieta2));
            list.add("\u041e\u0442\u0434\u0430\u0447\u0430 " + this.getClientRecoil(ieta2));
            if (!this.type.getCurrentAttachments(ieta2).isEmpty()) {
                list.add("\u00a76\u041e\u0431\u0432\u0435\u0441\u044b:");
                for (AttachmentType attachmentType : this.type.getCurrentAttachments(ieta2)) {
                    object2 = attachmentType.name;
                    list.add(object2);
                }
            } else {
                list.add("\u00a76\u041e\u0431\u0432\u0435\u0441\u043e\u0432 \u043d\u0435\u0442.");
            }
        } else {
            list.add("\u0412\u043e\u0437\u044c\u043c\u0438\u0442\u0435 \u043e\u0440\u0443\u0436\u0438\u0435 \u0432 \u0440\u0443\u043a\u0438,");
            list.add("\u0447\u0442\u043e\u0431\u044b \u0443\u0432\u0438\u0434\u0435\u0442\u044c \u0445\u0430\u0440\u0430\u043a\u0442\u0435\u0440\u0438\u0441\u0442\u0438\u043a\u0438.");
        }
        if (ieta2._j() + 1 < ieta2._k()) {
            list.add("\u00a7f\u041f\u0435\u0440\u0435\u0437\u0430\u0440\u044f\u0434\u0438\u0442\u044c: R");
            list.add("\u00a7f\u0420\u0430\u0437\u0440\u044f\u0434\u0438\u0442\u044c: ~(\u0401)");
            list.add("\u00a7f\u041e\u0431\u0432\u0435\u0441\u0438\u0442\u044c: U");
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void onUpdateClient(ieta ieta2, cuqu cuqu2, Entity entity, int n, boolean bl) {
        boolean bl2;
        if (entity != tuor._E()._r || ((EntityPlayer)entity).field_71071_by._a() != ieta2) {
            return;
        }
        boolean bl3 = bl2 = ItemGun.getClientDamage(ieta2) == 0 || ItemGun.slotIsWeapon(tuor._E()._r.field_71071_by._c, ExtendedPlayer.client((String)tuor._E()._r.field_71092_bJ));
        if (bl2) {
            boolean bl4 = mouseHeld;
            boolean bl5 = mouseHeld = tuor._E()._K.__bm._e && tuor._E()._z == null;
            if (this.type.deployable) {
                mouseHeld = Mouse.isButtonDown((int)1);
                return;
            }
            if (mouseHeld && (this.type.mode == EnumFireMode.FULLAUTO || !bl4)) {
                long l = System.nanoTime();
                PacketDispatcher.sendPacketToServer((maaq)PacketGunFire.buildGunFirePacket(l, FlansModClient.pingResponse));
                this.clientSideShoot((EntityPlayer)entity, ieta2, l);
            }
            uyla uyla2 = rojd.instance().getClient()._K;
            IScope iScope = this.type.getCurrentScope(ieta2);
            if (Mouse.isButtonDown((int)1) && tuor._E()._z == null && FlansModClient.scopeTime <= 0 && rojd.instance().getClient()._z == null) {
                if (FlansModClient.currentScope == null) {
                    PacketDispatcher.sendPacketToServer((maaq)PacketAiming.buildAimingPacket(true));
                    Util.isAimingClient = true;
                    FlansModClient.currentScope = iScope;
                    FlansModClient.lastZoomLevel = iScope.getZoomFactor();
                    FlansModClient.lastFOVZoomLevel = iScope.getFOVFactor();
                    float f = FlansModClient.originalMouseSensitivity = uyla2._j;
                    uyla2._j = f / (float)Math.sqrt(iScope.getZoomFactor());
                    FlansModClient.originalThirdPerson = uyla2.__bw;
                    uyla2.__bw = 0;
                    FlansModClient.originalFOV = uyla2.__bE;
                } else {
                    PacketDispatcher.sendPacketToServer((maaq)PacketAiming.buildAimingPacket(false));
                    Util.isAimingClient = false;
                    FlansModClient.currentScope = null;
                    uyla2._j = FlansModClient.originalMouseSensitivity;
                    uyla2.__bw = FlansModClient.originalThirdPerson;
                    uyla2.__bE = FlansModClient.originalFOV;
                }
                FlansModClient.scopeTime = 10;
            }
        } else if (!DayZHud.hints.containsKey("gunslot")) {
            DayZHud.hints.put("gunslot", new DayZHud.Hint(){

                public boolean remove() {
                    return !Util.isFlansWeapon(tuor._E()._r.func_71045_bC()) || ((ItemGun)tuor._E()._r.func_71045_bC()._a()).type.damage == 0.0f || ItemGun.slotIsWeapon(tuor._E()._r.field_71071_by._c, ExtendedPlayer.client((String)tuor._E()._r.field_71092_bJ));
                }

                public void addHints(List<String> list) {
                    list.add("\u00a7c\u041e\u0440\u0443\u0436\u0438\u0435 \u043c\u043e\u0436\u043d\u043e \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u0442\u043e\u043b\u044c\u043a\u043e \u0432 \u0441\u043f\u0435\u0446\u0438\u0430\u043b\u044c\u043d\u043e\u043c \u0441\u043b\u043e\u0442\u0435");
                }
            });
        }
        if (this.soundDelay > 0) {
            --this.soundDelay;
        }
    }

    private int getClientShootDelay(ieta ieta2) {
        if (!ItemGun.checkClientInfo(ieta2, "stme")) {
            return 0;
        }
        return ieta2._e._d("stme") & 255;
    }

    public static int getClientReloadTime(ieta ieta2) {
        if (!ItemGun.checkClientInfo(ieta2, "rtme")) {
            return 0;
        }
        return ieta2._e._e("rtme") & 65535;
    }

    public float getClientRecoil(ieta ieta2) {
        if (!ItemGun.checkClientInfo(ieta2, "recl")) {
            return 0.0f;
        }
        return (float)ieta2._e._e("recl") / 100.0f;
    }

    public static float getClientSpread(ieta ieta2) {
        if (!ItemGun.checkClientInfo(ieta2, "sprd")) {
            return 0.0f;
        }
        return (float)ieta2._e._e("sprd") / 100.0f;
    }

    public static short getClientDamage(ieta ieta2) {
        if (!ItemGun.checkClientInfo(ieta2, "gdmg")) {
            return 0;
        }
        return ieta2._e._e("gdmg");
    }

    public static float getClientBulletSpeed(ieta ieta2) {
        if (!ItemGun.checkClientInfo(ieta2, "gibs")) {
            return 0.0f;
        }
        return (float)(ieta2._e._d("gibs") & 255) / 2.0f;
    }

    public static float getClientBulletSlowdown(ieta ieta2) {
        if (!ItemGun.checkClientInfo(ieta2, "gbsm")) {
            return 0.0f;
        }
        return (float)(ieta2._e._d("gbsm") & 255) / 255.0f;
    }

    private static boolean checkClientInfo(ieta ieta2, String string) {
        return ieta2 != null && ieta2._e != null && ieta2._e._c(string);
    }

    public void onUpdateServer(ieta ieta2, cuqu cuqu2, Entity entity, int n, boolean bl) {
        if (entity instanceof EntityPlayerMP) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)entity;
            if (entityPlayerMP.field_71071_by._a() != ieta2) {
                return;
            }
            this.updateTagInfo(ieta2, entityPlayerMP);
        }
    }

    private void updateTagInfo(ieta ieta2, EntityPlayerMP entityPlayerMP) {
        Object object;
        GunTypeMod gunTypeMod;
        FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayerMP);
        hsus hsus2 = ieta2._q();
        if (hsus2 == null) {
            hsus2 = new hsus("tag");
            ieta2._d(hsus2);
        }
        hsus2._a("stme", (byte)((gunTypeMod = this.type.getMod(flansModPlayerData)) != null ? gunTypeMod.shootDelay : this.type.shootDelay));
        hsus2._a("rtme", (short)this.type.getReloadTime(ieta2));
        hsus2._a("recl", (short)(this.type.getRecoil(ieta2, gunTypeMod, flansModPlayerData) * 100.0f));
        hsus2._a("sprd", (short)(this.type.getSpread(ieta2, gunTypeMod, flansModPlayerData) * 100.0f));
        float f = this.type.getDamage(ieta2, gunTypeMod, flansModPlayerData);
        hsus2._a("gdmg", (short)(f < 50.0f ? f * 600.0f : f));
        hsus2._a("gibs", (byte)(this.type.getBulletSpeed(ieta2, gunTypeMod, flansModPlayerData) * 3.0f * 2.0f));
        Object object2 = null;
        for (int i = 0; i < this.type.numAmmoItemsInGun; ++i) {
            object = this.getBulletItemStack(ieta2, i);
            if (object == null || object._a() == null || object._j() >= object._k()) continue;
            object2 = object;
            break;
        }
        if (object2 != null) {
            object = ((ItemBullet)object2._a()).type;
            BulletTypeMod bulletTypeMod = flansModPlayerData.overrideBullets == null ? null : flansModPlayerData.overrideBullets.get(object);
            hsus2._a("gbsm", (byte)((bulletTypeMod != null ? bulletTypeMod.slowdown : object.slowdown) * 255.0f));
        }
    }

    public void func_77663_a(ieta ieta2, cuqu cuqu2, Entity entity, int n, boolean bl) {
        if (cuqu2.field_72995_K) {
            this.onUpdateClient(ieta2, cuqu2, entity, n, bl);
        } else {
            this.onUpdateServer(ieta2, cuqu2, entity, n, bl);
        }
    }

    public void serverSideShoot(ieta ieta2, cuqu cuqu2, EntityPlayerMP entityPlayerMP, int n, long l) {
        if (!this.type.deployable) {
            FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayerMP);
            if (flansModPlayerData.shootTime <= 0) {
                ExtendedPlayer extendedPlayer;
                int n2;
                ExtendedPlayer extendedPlayer2 = null;
                for (n2 = 0; n2 < this.type.numAmmoItemsInGun; ++n2) {
                    extendedPlayer = this.getBulletItemStack(ieta2, n2);
                    if (extendedPlayer == null || extendedPlayer._a() == null || extendedPlayer._j() >= extendedPlayer._k()) continue;
                    extendedPlayer2 = extendedPlayer;
                    break;
                }
                if (!ItemGun.slotIsWeapon(entityPlayerMP.field_71071_by._c, extendedPlayer = ExtendedPlayer.server((EntityPlayer)entityPlayerMP))) {
                    SPacketHandler.sendHint((EntityPlayer)entityPlayerMP, (String)"gnst", (String)"\u00a7c\u041e\u0440\u0443\u0436\u0438\u0435 \u043c\u043e\u0436\u043d\u043e \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u0442\u043e\u043b\u044c\u043a\u043e \u0432 \u0441\u043f\u0435\u0446\u0438\u0430\u043b\u044c\u043d\u043e\u043c \u0441\u043b\u043e\u0442\u0435", (int)40);
                } else if (extendedPlayer2 == null || !(extendedPlayer2._a() instanceof ItemBullet)) {
                    SPacketHandler.sendHint((EntityPlayer)entityPlayerMP, (String)"ndrld1", (String)"\u00a7c\u041d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e \u043f\u0435\u0440\u0435\u0437\u0430\u0440\u044f\u0434\u0438\u0442\u044c \u043e\u0440\u0443\u0436\u0438\u0435\n\u00a7c\u043d\u0430\u0436\u043c\u0438\u0442\u0435 R", (int)40);
                } else if (ieta2._j() + 1 < ieta2._k()) {
                    this.shoot(ieta2, cuqu2, (ieta)extendedPlayer2, (EntityPlayer)entityPlayerMP, n, l);
                    if (!flansModPlayerData.lockAmmo) {
                        extendedPlayer2._b(extendedPlayer2._j() + 1);
                        this.setBulletItemStack(ieta2, (ieta)extendedPlayer2, n2);
                    }
                } else {
                    SPacketHandler.sendHint((EntityPlayer)entityPlayerMP, (String)"gnbr", (String)"\u00a7c\u041e\u0440\u0443\u0436\u0438\u0435 \u0441\u043b\u043e\u043c\u0430\u043d\u043e, \u043f\u043e\u0447\u0438\u043d\u0438\u0442\u0435 \u0435\u0433\u043e", (int)40);
                }
            }
        }
    }

    public boolean reload(ieta ieta2, cuqu cuqu2, EntityPlayer entityPlayer, boolean bl) {
        boolean bl2;
        FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData(entityPlayer);
        boolean bl3 = bl2 = entityPlayer.field_71075_bZ._d || flansModPlayerData != null && flansModPlayerData.lockAmmo;
        if (flansModPlayerData != null && flansModPlayerData.lockAmmo) {
            bl2 = true;
        }
        if (cuqu2.field_72995_K) {
            return false;
        }
        if (this.type.deployable) {
            return false;
        }
        if (bl && !this.type.canForceReload) {
            return false;
        }
        boolean bl4 = false;
        for (int i = 0; i < this.type.numAmmoItemsInGun; ++i) {
            Object object;
            ieta ieta3 = this.getBulletItemStack(ieta2, i);
            if (ieta3 != null && ieta3._j() != ieta3._k() && !bl) continue;
            int n = -1;
            Object object2 = false;
            for (int j = 0; j < entityPlayer.field_71071_by._a.length; ++j) {
                ieta ieta4 = entityPlayer.field_71071_by._a[j];
                if (ieta4 == null || !(ieta4._a() instanceof ItemBullet) || !this.type.isAmmo(((ItemBullet)ieta4._a()).type) || (object = (Object)(ieta4._k() - ieta4._j())) <= object2) continue;
                n = j;
                object2 = object;
            }
            if (n == -1) continue;
            ieta ieta5 = entityPlayer.field_71071_by._a[n];
            ieta5._a();
            if (ieta3 != null && ieta3._a() instanceof ItemBullet && ((ItemBullet)ieta3._a()).type.dropItemOnReload != null && !bl2) {
                ItemGun.dropItem(cuqu2, (Entity)entityPlayer, ((ItemBullet)ieta3._a()).type.dropItemOnReload);
            }
            if (ieta3 != null && ieta3._j() < ieta3._k() && !bl2 && !entityPlayer.field_71071_by._c(ieta3)) {
                entityPlayer.func_70099_a(ieta3, 0.5f);
            }
            object = ieta5._l();
            object._b = 1;
            this.setBulletItemStack(ieta2, (ieta)object, i);
            this.updateTagInfo(ieta2, (EntityPlayerMP)entityPlayer);
            if (!bl2) {
                --ieta5._b;
            }
            if (ieta5._b <= 0) {
                ieta5 = null;
            }
            entityPlayer.field_71071_by._a[n] = ieta5;
            bl4 = true;
        }
        return bl4;
    }

    public void unload(ieta ieta2, EntityPlayer entityPlayer) {
        if (!this.type.deployable && this.type.canForceReload) {
            for (int i = 0; i < this.type.numAmmoItemsInGun; ++i) {
                FlansModPlayerData flansModPlayerData;
                ieta ieta3 = this.getBulletItemStack(ieta2, i);
                if (ieta3 == null || ieta3._j() >= ieta3._k() || (flansModPlayerData = FlansModPlayerHandler.getPlayerData(entityPlayer)) != null && flansModPlayerData.lockAmmo) continue;
                if (!entityPlayer.field_71075_bZ._d && !entityPlayer.field_71071_by._c(ieta3)) {
                    entityPlayer.func_70099_a(ieta3, entityPlayer.func_70047_e());
                }
                this.setBulletItemStack(ieta2, null, i);
            }
        }
    }

    public static void dropItem(cuqu cuqu2, Entity entity, String string) {
        if (string != null) {
            int n = 0;
            if (string.contains(".")) {
                n = Integer.parseInt(string.split("\\.")[1]);
                string = string.split("\\.")[0];
            }
            ieta ieta2 = InfoType.getRecipeElement(string, n);
            entity.func_70099_a(ieta2, 0.5f);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void clientSideShoot(EntityPlayer entityPlayer, ieta ieta2, long l) {
        if (FlansModClient.clientPlayerData.shootTime <= 0 && ieta2._j() + 1 < ieta2._k()) {
            ieta ieta3 = null;
            for (int i = 0; i < this.type.numAmmoItemsInGun; ++i) {
                ieta ieta4 = this.getBulletItemStack(ieta2, i);
                if (ieta4 == null || ieta4._a() == null || ieta4._j() >= ieta4._k()) continue;
                ieta3 = ieta4;
                break;
            }
            if (ieta3 != null) {
                GunAnimations gunAnimations;
                FlansModPlayerData flansModPlayerData = FlansModClient.clientPlayerData;
                for (int i = flansModPlayerData.spreadTicks; i < 5; ++i) {
                    BulletSpread.tickWeaponSpread(entityPlayer, flansModPlayerData);
                }
                flansModPlayerData.isAiming = Util.isAimingClient;
                ItemBullet itemBullet = (ItemBullet)ieta3._a();
                if (!itemBullet.type.smokeTrail) {
                    l = flansModPlayerData.seed ^ l;
                    EntityBullet.bulletRng.setSeed(l);
                    Util.areClientBulletsBeingUpdated = true;
                    int n = this.type.numBullets;
                    float f = ItemGun.getClientBulletSpeed(ieta2);
                    float f2 = ItemGun.getClientBulletSlowdown(ieta2);
                    for (int i = 0; i < n; ++i) {
                        ((ItemBullet)ieta3._a()).getEntity(entityPlayer, 0, flansModPlayerData, flansModPlayerData.bulletSpread, 0.0f, f, this.type.numBullets > 1, f2, this.type, l);
                        ++l;
                    }
                    Util.areClientBulletsBeingUpdated = false;
                    AttachmentType attachmentType = this.type.getBarrel(ieta2);
                    boolean bl = CHS || attachmentType != null && attachmentType.silencer;
                    rojd.instance().getClient()._L._a("flansmod:" + this.type.shootSound, (float)entityPlayer.field_70165_t, (float)entityPlayer.field_70163_u, (float)entityPlayer.field_70161_v, bl ? 0.5f : 8.0f, (this.type.distortSound ? 1.0f / (field_77697_d.nextFloat() * 0.1f + 0.95f) : 1.0f) * (bl ? 2.0f : 1.0f));
                    if (CHS) {
                        rojd.instance().getClient()._L._a("mob.chicken.say", (float)entityPlayer.field_70165_t, (float)entityPlayer.field_70163_u, (float)entityPlayer.field_70161_v, 8.0f, (this.type.distortSound ? 1.0f / (field_77697_d.nextFloat() * 0.1f + 0.95f) : 1.0f) * 1.0f);
                    }
                }
                if (FlansModClient.gunAnimations.containsKey((Object)entityPlayer)) {
                    gunAnimations = (GunAnimations)FlansModClient.gunAnimations.get((Object)entityPlayer);
                } else {
                    gunAnimations = new GunAnimations();
                    FlansModClient.gunAnimations.put(entityPlayer, gunAnimations);
                }
                int n = this.type.model == null ? 0 : this.type.model.pumpDelay;
                int n2 = this.type.model == null ? 1 : this.type.model.pumpTime;
                gunAnimations.doShoot(n, n2);
                float f = this.getClientRecoil(ieta2);
                float f3 = f * 0.1f;
                FlansModClient.recoilUp += f;
                FlansModClient.recoilSide += f3;
                EntityClientPlayerMP entityClientPlayerMP = tuor._E()._r;
                entityClientPlayerMP.field_70177_z += f3 * FlansModClient.recoilDirection;
                if (this.type.mode == EnumFireMode.SEMIAUTO) {
                    FlansModClient.recoilDirection = FlansModClient.recoilLeft ? -1.0f : 1.0f;
                    FlansModClient.recoilUp += f;
                    FlansModClient.recoilSide += f;
                    if (FlansModClient.recoilSwitch == 0) {
                        FlansModClient.recoilSwitch = field_77697_d.nextInt(30) + 10;
                    }
                } else {
                    if (FlansModClient.recoilSwitch == 0) {
                        FlansModClient.recoilSwitch = field_77697_d.nextInt(40) + 40;
                    }
                    f3 = Math.max(0.1f, f3);
                    entityClientPlayerMP.field_70125_A = field_77697_d.nextBoolean() ? (entityClientPlayerMP.field_70125_A += f3) : (entityClientPlayerMP.field_70125_A -= f3);
                }
                flansModPlayerData.weaponSpread = ItemGun.getClientSpread(ieta2) * 2.0f;
                FlansModClient.clientPlayerData.shootTime = this.getClientShootDelay(ieta2);
            }
        }
    }

    private void shoot(ieta ieta2, cuqu cuqu2, ieta ieta3, EntityPlayer entityPlayer, int n, long l) {
        int n2;
        Object object;
        BulletType bulletType = ((ItemBullet)ieta3._a()).type;
        if (this.soundDelay <= 0 && this.type.shootSound != null) {
            object = this.type.getBarrel(ieta2);
            n2 = CHS || object != null && ((AttachmentType)object).silencer ? 1 : 0;
            zgmv._H().__af()._a(entityPlayer, entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, 128.0, entityPlayer.field_71093_bK, PacketPlaySound.buildSoundPacket(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, this.type.shootSound, this.type.distortSound, n2 != 0));
            if (CHS) {
                zgmv._H().__af()._a(entityPlayer, entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, 128.0, entityPlayer.field_71093_bK, PacketPlaySound.buildSoundPacket(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, "mob.chicken.say", this.type.distortSound, false));
            }
            this.soundDelay = this.type.shootSoundLength;
        }
        object = null;
        if (!cuqu2.field_72995_K) {
            boolean bl;
            AttachmentType attachmentType;
            try {
                n2 = .TiProebal.getPingFor((int)n);
            }
            catch (Throwable throwable) {
                n2 = 0;
            }
            FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData(entityPlayer);
            for (int i = flansModPlayerData.spreadTicks; i < 5; ++i) {
                BulletSpread.tickWeaponSpread(entityPlayer, flansModPlayerData);
            }
            if (flansModPlayerData.overrideGuns != null) {
                object = flansModPlayerData.overrideGuns.get(this.type);
            }
            EntityBullet entityBullet = null;
            float f = this.type.getDamage(ieta2, this.type.getMod(flansModPlayerData), flansModPlayerData);
            if (f >= 50.0f) {
                f /= 600.0f;
            }
            f -= f * 0.25f * (float)(ieta2._j() / ieta2._k());
            float f2 = (float)((int)(this.type.getBulletSpeed(ieta2, (GunTypeMod)object, flansModPlayerData) * 3.0f * 2.0f)) / 2.0f;
            BulletTypeMod bulletTypeMod = flansModPlayerData.overrideBullets == null ? null : flansModPlayerData.overrideBullets.get(bulletType);
            float f3 = (float)((int)((bulletTypeMod != null ? bulletTypeMod.slowdown : bulletType.slowdown) * 255.0f)) / 255.0f;
            int n3 = Math.max(this.type.numBullets, 1);
            f /= (float)n3;
            for (int i = 0; i < n3; ++i) {
                entityBullet = ((ItemBullet)ieta3._a()).getEntity(entityPlayer, n2, flansModPlayerData, flansModPlayerData.bulletSpread, f, f2, n3 > 1, f3, this.type, l);
                ++l;
            }
            if (!(HcsServer.isPVPserver || HcsServer.isLiteserver || ieta2._j() >= ieta2._k() || flansModPlayerData.lockAmmo || field_77697_d.nextInt(2) != 0)) {
                ieta2._b(ieta2._j() + 1);
            }
            boolean bl2 = bl = (attachmentType = this.type.getBarrel(ieta2)) != null && attachmentType.silencer || this.type.shortName.endsWith("_s");
            if (!bl) {
                cuqu2.func_72838_d((Entity)new EntityShootFX(entityBullet, entityPlayer));
                HCS.shoot((EntityPlayer)entityPlayer);
            }
            if (bulletType.dropItemOnShoot != null && !entityPlayer.field_71075_bZ._d) {
                ItemGun.dropItem(cuqu2, (Entity)entityPlayer, bulletType.dropItemOnShoot);
            }
            flansModPlayerData.weaponSpread = this.type.getSpread(ieta2, (GunTypeMod)object, flansModPlayerData) * 3.0f;
        }
        FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayer).shootTime = object != null ? ((GunTypeMod)object).shootDelay : this.type.shootDelay;
    }

    public ieta func_77659_a(ieta ieta2, cuqu cuqu2, EntityPlayer entityPlayer) {
        if (cuqu2.field_72995_K) {
            for (int i = 0; i < 3; ++i) {
                tuor._E()._B.field_78516_c.func_78441_a();
            }
        }
        return ieta2;
    }

    private boolean isSolid(cuqu cuqu2, int n, int n2, int n3) {
        int n4 = cuqu2.func_72798_a(n, n2, n3);
        return n4 != 0 && kjsv.field_71973_m[n4].field_72018_cp._b() && kjsv.field_71973_m[n4].func_71926_d();
    }

    public float getDamageVsEntity(Entity entity, ieta ieta2) {
        return this.type.getMeleeDamage(ieta2);
    }

    public boolean func_77662_d() {
        return true;
    }

    public boolean onEntitySwing(EntityLivingBase entityLivingBase, ieta ieta2) {
        return this.type.meleeDamage != 0.0f;
    }

    @SideOnly(value=Side.CLIENT)
    public int func_82790_a(ieta ieta2, int n) {
        return this.type.colour;
    }

    public boolean isItemStackDamageable() {
        return true;
    }

    public void func_77633_a(int n, tekj tekj2, List list) {
        hsus hsus2;
        ieta ieta2 = new ieta(n, 1, 0);
        ieta2._e = hsus2 = new hsus();
        list.add(ieta2);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(qlze qlze2) {
        this.field_77791_bV = qlze2._a("FlansMod:" + this.type.iconPath);
    }

    public int func_77626_a(ieta ieta2) {
        return 100;
    }

    public rpnc func_77661_b(ieta ieta2) {
        return rpnc._e;
    }

    public boolean func_77648_a(ieta ieta2, EntityPlayer entityPlayer, cuqu cuqu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        return !this.type.deployable;
    }

    public float func_77638_a(ieta ieta2, kjsv kjsv2) {
        return 0.0f;
    }

    public int getDamage(ieta ieta2) {
        return super.getDamage(ieta2);
    }

    public boolean func_77644_a(ieta ieta2, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        return false;
    }

    public boolean onItemUseFirst(ieta ieta2, EntityPlayer entityPlayer, cuqu cuqu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        return !this.type.deployable;
    }

    public boolean onBlockStartBreak(ieta ieta2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        return true;
    }

    public boolean onLeftClickEntity(ieta ieta2, EntityPlayer entityPlayer, Entity entity) {
        return true;
    }

    public static boolean slotIsWeapon(int n, ExtendedPlayer extendedPlayer) {
        if (VCore.isSinglePlayer()) {
            return true;
        }
        if (extendedPlayer.isClient && (HcsClient.isPVPserver || HcsClient.isLiteserver)) {
            return true;
        }
        if (!extendedPlayer.isClient && (HcsServer.isPVPserver || HcsServer.isLiteserver)) {
            return true;
        }
        if (n >= extendedPlayer.guns_offset && n <= extendedPlayer.guns_offset + 2) {
            if (!extendedPlayer.guns_3rd_left && n == extendedPlayer.guns_offset + 2 || extendedPlayer.guns_3rd_left && n == extendedPlayer.guns_offset) {
                InventoryExtended inventoryExtended = extendedPlayer.inventory;
                return inventoryExtended != null && inventoryExtended.inventoryStacks[1] != null && inventoryExtended.inventoryStacks[1]._d == HCS.holster.field_77779_bT;
            }
            return true;
        }
        return false;
    }

}

