// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import net.minecraftforge.event.hrmy;
import vintarz.ntr.client.ClientNtr;
import java.util.Comparator;
import hcsmod.player.ContainerExtended;
import hcsmod.client.gui.GuiHouse;
import hcsmod.player.GuiInventoryExtended;
import hcsmod.player.GuiInventoryCreative;
import hcsmod.client.gui.GuiHcsMenu;
import hcsmod.client.gui.GuiChangeLog;
import org.lwjgl.input.Keyboard;
import hcsmod.player.SlotArmorCustom;
import hcsmod.player.InventoryExtended;
import hcsmod.HCS;
import hcsmod.player.ExtendedPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
import org.lwjgl.opengl.GL11;
import net.minecraftforge.event.kjuq;
import net.minecraft.util.rojd;
import java.util.List;
import net.minecraft.util.idqh;
import net.minecraft.util.samw;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityDiggingFX;
import vintarz.core.VCore;
import hcsmod.entity.EntityZombieHead;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import co.uk.flansmods.vintarz.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.tuor;

public class CEventHandler
{
    private static final tuor mc;
    public static EntityPlayer renderedPlayer;
    public static int LIMIT_MAX_X;
    public static int LIMIT_MAX_Z;
    public static int LIMIT_MIN_X;
    public static int LIMIT_MIN_Z;
    
    @kjuq
    public void onPlayerAttack(final uzti uzti) {
        if (!Util.displayParticles()) {
            return;
        }
        if (uzti.entity == CEventHandler.mc._r) {
            final samw func_70666_h = CEventHandler.mc._r.func_70666_h(1.0f);
            double d = CEventHandler.mc._h._d();
            final idqh func_70614_a = CEventHandler.mc._s.func_70614_a(d, 1.0f);
            if (func_70614_a != null) {
                d = func_70614_a._f._d(func_70666_h);
            }
            final samw func_70676_i = CEventHandler.mc._s.func_70676_i(1.0f);
            final samw c = func_70666_h._c(func_70676_i._c * d, func_70676_i._d * d, func_70676_i._e * d);
            final List func_72839_b = CEventHandler.mc._p.func_72839_b((Entity)CEventHandler.mc._s, CEventHandler.mc._s.field_70121_D.func_72321_a(func_70676_i._c * d, func_70676_i._d * d, func_70676_i._e * d).func_72314_b(1.0, 1.0, 1.0));
            idqh idqh = null;
            for (int i = 0; i < func_72839_b.size(); ++i) {
                final Entity entity = func_72839_b.get(i);
                if (entity instanceof EntityLivingBase && entity.func_70067_L()) {
                    final float func_70111_Y = entity.func_70111_Y();
                    final rojd func_72314_b = entity.field_70121_D.func_72314_b((double)func_70111_Y, (double)func_70111_Y, (double)func_70111_Y);
                    final idqh func_72327_a = func_72314_b.func_72327_a(func_70666_h, c);
                    if (func_72314_b.func_72318_a(func_70666_h)) {
                        if (0.0 < d || d == 0.0) {
                            d = 0.0;
                        }
                    }
                    else if (func_72327_a != null) {
                        final double d2 = func_70666_h._d(func_72327_a._f);
                        if (d2 < d || d == 0.0) {
                            if (entity == CEventHandler.mc._s.field_70154_o && !entity.canRiderInteract()) {
                                if (d == 0.0) {
                                    idqh = func_72327_a;
                                }
                            }
                            else {
                                idqh = func_72327_a;
                                d = d2;
                            }
                        }
                    }
                }
            }
            if (idqh != null) {
                final samw f = idqh._f;
                final samw func_70040_Z = CEventHandler.mc._r.func_70040_Z();
                for (int n = (uzti.target instanceof EntityZombieHead) ? 6 : 3, j = 0; j < n; ++j) {
                    final EntityDiggingFX func_90019_g = new EntityDiggingFX((cuqu)tuor._E()._p, f._c, f._d, f._e, VCore.rnd.nextDouble() * 0.01 - func_70040_Z._c / 10.0, VCore.rnd.nextDouble() * 0.01 - func_70040_Z._d / 10.0, VCore.rnd.nextDouble() * 0.01 - func_70040_Z._e / 10.0, kjsv.field_71973_m[35], 14).func_90019_g(14);
                    func_90019_g.field_70155_l = 256.0;
                    tuor._E()._u._a((EntityFX)func_90019_g);
                }
            }
        }
    }
    
    @kjuq
    public void worldBorderRender(final xryw xryw) {
        final EntityClientPlayerMP r = CEventHandler.mc._r;
        GL11.glDisable(2896);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2884);
        GL11.glDepthMask(false);
        GL11.glDisable(3553);
        GL11.glColor4f(1.0f, 0.0f, 0.0f, 0.4f);
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78373_b(-dfsc._d, -dfsc._e, -dfsc._f);
        if (((EntityPlayer)r).field_70165_t > CEventHandler.LIMIT_MAX_X - 64) {
            field_78398_a.func_78377_a((double)CEventHandler.LIMIT_MAX_X, ((EntityPlayer)r).field_70163_u + 16.0, ((EntityPlayer)r).field_70161_v - 32.0);
            field_78398_a.func_78377_a((double)CEventHandler.LIMIT_MAX_X, ((EntityPlayer)r).field_70163_u + 16.0, ((EntityPlayer)r).field_70161_v + 32.0);
            field_78398_a.func_78377_a((double)CEventHandler.LIMIT_MAX_X, ((EntityPlayer)r).field_70163_u - 16.0, ((EntityPlayer)r).field_70161_v + 32.0);
            field_78398_a.func_78377_a((double)CEventHandler.LIMIT_MAX_X, ((EntityPlayer)r).field_70163_u - 16.0, ((EntityPlayer)r).field_70161_v - 32.0);
        }
        if (((EntityPlayer)r).field_70165_t < CEventHandler.LIMIT_MIN_X + 64) {
            field_78398_a.func_78377_a((double)CEventHandler.LIMIT_MIN_X, ((EntityPlayer)r).field_70163_u + 16.0, ((EntityPlayer)r).field_70161_v - 32.0);
            field_78398_a.func_78377_a((double)CEventHandler.LIMIT_MIN_X, ((EntityPlayer)r).field_70163_u + 16.0, ((EntityPlayer)r).field_70161_v + 32.0);
            field_78398_a.func_78377_a((double)CEventHandler.LIMIT_MIN_X, ((EntityPlayer)r).field_70163_u - 16.0, ((EntityPlayer)r).field_70161_v + 32.0);
            field_78398_a.func_78377_a((double)CEventHandler.LIMIT_MIN_X, ((EntityPlayer)r).field_70163_u - 16.0, ((EntityPlayer)r).field_70161_v - 32.0);
        }
        if (((EntityPlayer)r).field_70161_v > CEventHandler.LIMIT_MAX_Z - 64) {
            field_78398_a.func_78377_a(((EntityPlayer)r).field_70165_t - 32.0, ((EntityPlayer)r).field_70163_u + 16.0, (double)CEventHandler.LIMIT_MAX_Z);
            field_78398_a.func_78377_a(((EntityPlayer)r).field_70165_t + 32.0, ((EntityPlayer)r).field_70163_u + 16.0, (double)CEventHandler.LIMIT_MAX_Z);
            field_78398_a.func_78377_a(((EntityPlayer)r).field_70165_t + 32.0, ((EntityPlayer)r).field_70163_u - 16.0, (double)CEventHandler.LIMIT_MAX_Z);
            field_78398_a.func_78377_a(((EntityPlayer)r).field_70165_t - 32.0, ((EntityPlayer)r).field_70163_u - 16.0, (double)CEventHandler.LIMIT_MAX_Z);
        }
        if (((EntityPlayer)r).field_70161_v < CEventHandler.LIMIT_MIN_Z + 64) {
            field_78398_a.func_78377_a(((EntityPlayer)r).field_70165_t - 32.0, ((EntityPlayer)r).field_70163_u + 16.0, (double)CEventHandler.LIMIT_MIN_Z);
            field_78398_a.func_78377_a(((EntityPlayer)r).field_70165_t + 32.0, ((EntityPlayer)r).field_70163_u + 16.0, (double)CEventHandler.LIMIT_MIN_Z);
            field_78398_a.func_78377_a(((EntityPlayer)r).field_70165_t + 32.0, ((EntityPlayer)r).field_70163_u - 16.0, (double)CEventHandler.LIMIT_MIN_Z);
            field_78398_a.func_78377_a(((EntityPlayer)r).field_70165_t - 32.0, ((EntityPlayer)r).field_70163_u - 16.0, (double)CEventHandler.LIMIT_MIN_Z);
        }
        field_78398_a.func_78373_b(0.0, 0.0, 0.0);
        field_78398_a.func_78381_a();
        GL11.glEnable(3553);
        GL11.glDepthMask(true);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(2884);
        GL11.glDisable(3042);
    }
    
    @kjuq
    public void onEntityUpdate(final zycd.eidn eidn) {
        if (eidn.entityLiving == CEventHandler.mc._r) {
            if (eidn.entityLiving.func_82165_m(lodj.field_76421_d.field_76415_H)) {
                CEventHandler.mc._K.__bh._e = false;
                CEventHandler.mc._K.__bh._f = 0;
            }
            final InventoryExtended inventory = ExtendedPlayer.client(((EntityPlayer)eidn.entityLiving).field_71092_bJ).inventory;
            if (inventory != null && inventory.inventoryStacks[5] != null && inventory.inventoryStacks[5]._d == HCS.PNV.field_77779_bT) {
                eidn.entityLiving.func_70690_d(new kldu(lodj.field_76439_r.field_76415_H, 2, 1));
            }
            final ieta func_71124_b = eidn.entityLiving.func_71124_b(4);
            if (func_71124_b != null && (func_71124_b._d == HCS.JAG[0].field_77779_bT || func_71124_b._d == HCS.helmetpnv.field_77779_bT || func_71124_b._d == HCS.heavy_head.field_77779_bT || func_71124_b._d == HCS.prota_head.field_77779_bT)) {
                eidn.entityLiving.func_70690_d(new kldu(lodj.field_76439_r.field_76415_H, 2, 1));
            }
        }
    }
    
    @kjuq
    public void createCustomArmorIcons(final klti klti) {
        if (klti.map._f == 1) {
            SlotArmorCustom.pnv = klti.map._a("hcsmod:iconPnv");
            SlotArmorCustom.backpack = klti.map._a("hcsmod:iconBackpack");
            SlotArmorCustom.flashlight = klti.map._a("hcsmod:iconFlash");
            SlotArmorCustom.jammer = klti.map._a("hcsmod:iconJammer");
            SlotArmorCustom.raincoat = klti.map._a("hcsmod:iconraincoat");
            SlotArmorCustom.holster = klti.map._a("hcsmod:iconholster");
            SlotArmorCustom.warmclothes = klti.map._a("hcsmod:iconwarmclothes");
        }
    }
    
    @kjuq
    public void rah(final xrzg.eidl.eidn eidn) {
        CEventHandler.renderedPlayer = eidn.entityPlayer;
        if (eidn.entityPlayer.field_71071_by._b[3] != null) {
            eidn.renderHelmet = false;
        }
    }
    
    @kjuq
    public void onGui(final oyax oyax) {
        if (oyax.gui instanceof tdun || (oyax.gui instanceof ancw && (!Keyboard.isKeyDown(42) || !Keyboard.isKeyDown(29) || !Keyboard.isKeyDown(56)))) {
            if (GuiChangeLog.updated) {
                oyax.gui = new GuiChangeLog();
            }
            else {
                oyax.gui = new GuiHcsMenu();
            }
        }
        else if (oyax.gui instanceof tduh) {
            oyax.gui = null;
            CEventHandler.mc._r.func_71004_bE();
        }
        else if (oyax.gui instanceof kkdv) {
            if (((EntityPlayer)CEventHandler.mc._r).field_71075_bZ._d) {
                oyax.gui = (dwms)new GuiInventoryCreative((EntityPlayer)CEventHandler.mc._r, ExtendedPlayer.client(CEventHandler.mc._P()._a()).inventory);
            }
            else {
                oyax.gui = (dwms)new GuiInventoryExtended((EntityPlayer)CEventHandler.mc._r, ExtendedPlayer.client(CEventHandler.mc._P()._a()).inventory);
            }
        }
        else if (oyax.gui instanceof ofkw) {
            final ofkw ofkw = (ofkw)oyax.gui;
            final ivrb c = ofkw._c;
            if (c.func_70303_b().startsWith("VhS")) {
                oyax.gui = (dwms)new GuiHouse(ofkw._b, c);
            }
        }
        if (oyax.gui instanceof GuiHcsMenu) {
            GuiHcsMenu.nextServerOnlineUpdate = 0L;
        }
    }
    
    @kjuq
    public void interact(final vlyb vlyb) {
        if (vlyb.action.equals((Object)vlyb.uxsf.LEFT_CLICK_BLOCK) && !CEventHandler.mc._r.field_71075_bZ._d) {
            vlyb.setCanceled(true);
        }
    }
    
    @kjuq
    public void fuck(final dycj dycj) {
        if (dycj.message != null && (dycj.message.contains(" left the game.") || dycj.message.contains(" joined the game."))) {
            dycj.setCanceled(true);
        }
    }
    
    @kjuq
    public void onEntityJoinWorld(final iwsa iwsa) throws ClassNotFoundException {
        if (iwsa.world.field_72995_K && iwsa.entity instanceof EntityPlayer && ((EntityPlayer)iwsa.entity).field_71092_bJ.equals(CEventHandler.mc._r.field_71092_bJ)) {
            final EntityPlayer entityPlayer = (EntityPlayer)iwsa.entity;
            entityPlayer.field_71069_bz = (ivrt)new ContainerExtended(entityPlayer, ExtendedPlayer.client(CEventHandler.mc._r.field_71092_bJ).inventory);
            entityPlayer.field_71070_bA = entityPlayer.field_71069_bz;
        }
    }
    
    @kjuq
    public void drawBlockBB(final uiqb uiqb) {
        if (!uiqb.player.field_71075_bZ._d) {
            uiqb.setCanceled(true);
        }
    }
    
    @kjuq
    public void renderGameOverlay(final iwpo.eidl eidl) {
        if (eidl.type == iwpo.eidn.PLAYER_LIST) {
            eidl.setCanceled(true);
            final ycmz field_71174_a = CEventHandler.mc._r.field_71174_a;
            final List h = field_71174_a._h;
            h.sort(new Comparator<flqn>() {
                @Override
                public int compare(final flqn flqn, final flqn flqn2) {
                    final rord x = CEventHandler.mc._x;
                    return Integer.compare(x._b(flqn2._a), x._b(flqn._a));
                }
            });
            if (field_71174_a._i < 0) {
                field_71174_a._i &= 0xFF;
            }
            int n = field_71174_a._i;
            if (h.size() > n) {
                n = h.size();
            }
            final int n2 = (eidl.resolution.func_78328_b() - 21 - 15) / 9;
            final int n3 = n2 * 9;
            int n4 = -3;
            int n5 = 0;
            for (int i = 0; i < n; i += n2) {
                if (i < h.size()) {
                    n4 += Math.max(CEventHandler.mc._x._b(h.get(i)._a), 50);
                    n4 += 3;
                }
                else {
                    n4 += 53;
                }
            }
            final int n6 = eidl.resolution.func_78326_a() / 2 - n4 / 2;
            qlob.func_73734_a(n6 - 1, 14, n6 + n4 + 1, 15 + n3, Integer.MIN_VALUE);
            int n7 = n6;
            int n8 = 15;
            int max = 0;
            for (int j = 0; j < n; ++j) {
                if (j < h.size()) {
                    final flqn flqn = h.get(j);
                    if (max == 0) {
                        max = Math.max(CEventHandler.mc._x._b(h.get(j)._a), 50);
                    }
                    qlob.func_73734_a(n7, n8, n7 + max, n8 + 8, 550895526);
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    GL11.glEnable(3008);
                    tuor._E()._x._a(cdma._a((pjqg)CEventHandler.mc._p.func_96441_U()._g(flqn._a), flqn._a), n7, n8, ClientNtr.allies.contains(flqn._a) ? 5635925 : 16777215);
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                }
                else {
                    if (max == 0) {
                        max = 50;
                    }
                    qlob.func_73734_a(n7, n8, n7 + max, n8 + 8, 550895526);
                }
                n8 += 9;
                if (++n5 >= n2) {
                    n8 = 15;
                    n7 += max + 3;
                    n5 = 0;
                    max = 0;
                }
            }
        }
    }
    
    @kjuq(priority = hrmy.HIGHEST)
    public void customAttack(final uzti uzti) {
        if (uzti.entity == CEventHandler.mc._r && uzti.target instanceof EntityPlayer) {
            uzti.setCanceled(true);
        }
    }
    
    static {
        mc = tuor._E();
        CEventHandler.LIMIT_MAX_X = 4410;
        CEventHandler.LIMIT_MAX_Z = 4410;
        CEventHandler.LIMIT_MIN_X = -4091;
        CEventHandler.LIMIT_MIN_Z = -4095;
    }
}
