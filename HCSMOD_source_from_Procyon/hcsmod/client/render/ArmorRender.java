// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import hcsmod.items.armor.ItemHCSArmor;
import net.minecraft.client.model.ModelRenderer;
import hcsmod.HCS;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.kjuq;
import net.minecraft.client.entity.EntityClientPlayerMP;
import java.util.Iterator;
import hcsmod.player.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;
import hcsmod.client.CEventHandler;
import net.minecraftforge.common.bpzx;
import api.player.render.RenderPlayerAPI;
import hcsmod.jugger.ModelJugger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.tuor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import api.player.render.RenderPlayerBase;

@SideOnly(Side.CLIENT)
public class ArmorRender extends RenderPlayerBase
{
    private static tuor mc;
    private static final ResourceLocation czech_texture;
    private static final ResourceLocation survival_texture;
    private static final ResourceLocation assault_texture;
    public static ModelBackPack renderBackPack;
    public static ModelPNV pnv;
    public static final ResourceLocation pnv_texture;
    public static ModelVest vest;
    public static ResourceLocation PRESS_TEXTURE;
    public static ResourceLocation bpvest_texture;
    public static ModelJugger JAG;
    public static ModelSamodel samodel;
    public static ModelRF RF;
    public static ModelNY NY;
    public static ModelGhile ghile;
    public static ModelHelmet helmet;
    public static ModelHelmet helmetGL;
    public static ModelHelmet helmetPNV;
    public static Modelbalaclava balaclava;
    public static ModelJoker Joker;
    public static ModelKrampus Krampus;
    public static ModelArmor2020 Armor2020;
    public static ModelHeavy Heavy;
    public static ModelProta Prota;
    
    public ArmorRender(final RenderPlayerAPI renderPlayerAPI) {
        super(renderPlayerAPI);
        bpzx.EVENT_BUS.register((Object)this);
    }
    
    @kjuq
    public void $(final xryw xryw) {
        CEventHandler.renderedPlayer = (EntityPlayer)ArmorRender.mc._r;
        GL11.glDisable(2896);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2884);
        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        GL11.glDepthMask(false);
        GL11.glDisable(3553);
        for (final EntityClientPlayerMP next : ArmorRender.mc._p.field_72996_f) {
            if (next != ArmorRender.mc._r && next instanceof EntityPlayer) {
                final EntityPlayer entityPlayer = (EntityPlayer)next;
                final ExtendedPlayer client = ExtendedPlayer.client(entityPlayer.field_71092_bJ);
                if (client.shieldCharge < 0) {
                    GL11.glColor4d(0.5, 0.0, 0.0, 0.2);
                    drawShield(entityPlayer, xryw.partialTicks);
                }
                else {
                    if (entityPlayer == ArmorRender.mc._r) {
                        if (client.shieldCharge != 127) {
                            continue;
                        }
                    }
                    else if (client.shieldCharge <= 0) {
                        continue;
                    }
                    GL11.glColor4d(0.0, 0.0, 0.5, 0.2);
                    drawShield(entityPlayer, xryw.partialTicks);
                }
            }
        }
        GL11.glEnable(3553);
        GL11.glDepthMask(true);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(2884);
        GL11.glDisable(3042);
    }
    
    private static void drawShield(final EntityPlayer entityPlayer, final float n) {
        final double n2 = entityPlayer.field_70142_S + (entityPlayer.field_70165_t - entityPlayer.field_70142_S) * n;
        final double n3 = entityPlayer.field_70137_T + (entityPlayer.field_70163_u - entityPlayer.field_70137_T) * n - (entityPlayer.field_70121_D.field_72338_b - entityPlayer.field_70121_D.field_72337_e);
        final double n4 = entityPlayer.field_70136_U + (entityPlayer.field_70161_v - entityPlayer.field_70136_U) * n;
        GL11.glPushMatrix();
        GL11.glTranslated(n2 - dfsc._d, n3 - dfsc._e, n4 - dfsc._f);
        drawBB((Entity)entityPlayer);
        GL11.glPopMatrix();
    }
    
    public static void drawBB(final Entity entity) {
        final double n = entity.field_70121_D.field_72338_b - entity.field_70121_D.field_72337_e - 0.029999999329447746;
        final double n2 = entity.func_70093_af() ? 0.05 : 0.15;
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78377_a(-0.45, n2, -0.45);
        field_78398_a.func_78377_a(0.45, n2, -0.45);
        field_78398_a.func_78377_a(0.45, n, -0.45);
        field_78398_a.func_78377_a(-0.45, n, -0.45);
        field_78398_a.func_78377_a(-0.45, n, 0.45);
        field_78398_a.func_78377_a(0.45, n, 0.45);
        field_78398_a.func_78377_a(0.45, n2, 0.45);
        field_78398_a.func_78377_a(-0.45, n2, 0.45);
        field_78398_a.func_78377_a(-0.45, n, -0.45);
        field_78398_a.func_78377_a(0.45, n, -0.45);
        field_78398_a.func_78377_a(0.45, n, 0.45);
        field_78398_a.func_78377_a(-0.45, n, 0.45);
        field_78398_a.func_78377_a(-0.45, n2, 0.45);
        field_78398_a.func_78377_a(0.45, n2, 0.45);
        field_78398_a.func_78377_a(0.45, n2, -0.45);
        field_78398_a.func_78377_a(-0.45, n2, -0.45);
        field_78398_a.func_78377_a(-0.45, n, 0.45);
        field_78398_a.func_78377_a(-0.45, n2, 0.45);
        field_78398_a.func_78377_a(-0.45, n2, -0.45);
        field_78398_a.func_78377_a(-0.45, n, -0.45);
        field_78398_a.func_78377_a(0.45, n, -0.45);
        field_78398_a.func_78377_a(0.45, n2, -0.45);
        field_78398_a.func_78377_a(0.45, n2, 0.45);
        field_78398_a.func_78377_a(0.45, n, 0.45);
        field_78398_a.func_78381_a();
    }
    
    public void renderSpecials(final AbstractClientPlayer abstractClientPlayer, final float n) {
        super.renderSpecials(abstractClientPlayer, n);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(32826);
        final ieta ieta = ExtendedPlayer.client(abstractClientPlayer.field_71092_bJ).inventory.inventoryStacks[3];
        if (ieta != null) {
            float n2;
            if (abstractClientPlayer.field_71071_by._b[2] != null) {
                n2 = 0.06f;
            }
            else {
                n2 = 0.0f;
            }
            if (ieta._d == HCS.min.field_77779_bT) {
                GL11.glPushMatrix();
                ArmorRender.mc._R()._a(ArmorRender.czech_texture);
                super.renderPlayerAPI.getModelBipedMainField().field_78115_e.func_78794_c(0.0625f);
                GL11.glTranslatef(0.0f, 0.0f, n2);
                ArmorRender.renderBackPack.render(0);
                GL11.glPopMatrix();
            }
            if (ieta._d == HCS.mid.field_77779_bT) {
                GL11.glPushMatrix();
                ArmorRender.mc._R()._a(ArmorRender.survival_texture);
                super.renderPlayerAPI.getModelBipedMainField().field_78115_e.func_78794_c(0.0625f);
                GL11.glTranslatef(0.0f, 0.0f, n2);
                ArmorRender.renderBackPack.render(1);
                GL11.glPopMatrix();
            }
            if (ieta._d == HCS.max.field_77779_bT) {
                GL11.glPushMatrix();
                ArmorRender.mc._R()._a(ArmorRender.assault_texture);
                super.renderPlayerAPI.getModelBipedMainField().field_78115_e.func_78794_c(0.0625f);
                GL11.glTranslatef(0.0f, 0.0f, n2);
                ArmorRender.renderBackPack.render(2);
                GL11.glPopMatrix();
            }
        }
        final ieta ieta2 = ExtendedPlayer.client(abstractClientPlayer.field_71092_bJ).inventory.inventoryStacks[5];
        if (ieta2 != null && ieta2._d == HCS.PNV.field_77779_bT) {
            GL11.glPushMatrix();
            ArmorRender.mc._R()._a(ArmorRender.pnv_texture);
            super.renderPlayerAPI.getModelBipedMainField().field_78116_c.func_78794_c(0.0625f);
            ArmorRender.pnv.render(1);
            GL11.glPopMatrix();
        }
        final ieta ieta3 = abstractClientPlayer.field_71071_by._b[2];
        if (ieta3 != null && ieta3._d == HCS.PRESS.field_77779_bT) {
            GL11.glPushMatrix();
            ArmorRender.mc._R()._a(ArmorRender.PRESS_TEXTURE);
            super.renderPlayerAPI.getModelBipedMainField().field_78115_e.func_78794_c(0.0625f);
            ArmorRender.vest.render(0);
            GL11.glPopMatrix();
        }
        if (ieta3 != null && ieta3._d == HCS.bpvest.field_77779_bT) {
            GL11.glPushMatrix();
            ArmorRender.mc._R()._a(ArmorRender.bpvest_texture);
            super.renderPlayerAPI.getModelBipedMainField().field_78115_e.func_78794_c(0.0625f);
            ArmorRender.vest.render(1);
            GL11.glPopMatrix();
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        final ieta ieta4 = abstractClientPlayer.field_71071_by._b[3];
        if (ieta4 != null) {
            final ieta ieta5 = abstractClientPlayer.field_71071_by._b[2];
            if (ieta5 != null && ieta5._d == HCS.JAG[1].field_77779_bT && ieta4._d == HCS.JAG[0].field_77779_bT) {
                this.render(ieta4, ModelPart.JAGVOROT, super.renderPlayerAPI.getModelBipedMainField().field_78116_c);
            }
            else {
                this.render(ieta4, ModelPart.HEAD, super.renderPlayerAPI.getModelBipedMainField().field_78116_c);
            }
        }
        final ieta ieta6 = abstractClientPlayer.field_71071_by._b[2];
        if (ieta6 != null) {
            this.render(ieta6, ModelPart.BODY, super.renderPlayerAPI.getModelBipedMainField().field_78115_e);
            this.render(ieta6, ModelPart.RARM, super.renderPlayerAPI.getModelBipedMainField().field_78112_f);
            this.render(ieta6, ModelPart.LARM, super.renderPlayerAPI.getModelBipedMainField().field_78113_g);
        }
        final ieta ieta7 = abstractClientPlayer.field_71071_by._b[1];
        if (ieta7 != null) {
            this.render(ieta7, ModelPart.RLEG, super.renderPlayerAPI.getModelBipedMainField().field_78123_h);
            this.render(ieta7, ModelPart.LLEG, super.renderPlayerAPI.getModelBipedMainField().field_78124_i);
        }
        final ieta ieta8 = abstractClientPlayer.field_71071_by._b[0];
        if (ieta8 != null) {
            this.render(ieta8, ModelPart.RBOOT, super.renderPlayerAPI.getModelBipedMainField().field_78123_h);
            this.render(ieta8, ModelPart.LBOOT, super.renderPlayerAPI.getModelBipedMainField().field_78124_i);
        }
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }
    
    private void render(final ieta ieta, final ModelPart modelPart, final ModelRenderer modelRenderer) {
        if (ieta._a() instanceof ItemHCSArmor) {
            final ItemHCSArmor itemHCSArmor = (ItemHCSArmor)ieta._a();
            if (itemHCSArmor.model != null) {
                GL11.glPushMatrix();
                ArmorRender.mc._R()._a(itemHCSArmor.texture);
                modelRenderer.func_78794_c(0.0625f);
                itemHCSArmor.model.render(modelPart);
                GL11.glPopMatrix();
            }
        }
    }
    
    static {
        ArmorRender.mc = tuor._E();
        czech_texture = new ResourceLocation("hcsmod:textures/models/czech.png");
        survival_texture = new ResourceLocation("hcsmod:textures/models/assault.png");
        assault_texture = new ResourceLocation("hcsmod:textures/models/survival.png");
        ArmorRender.renderBackPack = new ModelBackPack();
        ArmorRender.pnv = new ModelPNV();
        pnv_texture = new ResourceLocation("hcsmod:textures/PNV.png");
        ArmorRender.vest = new ModelVest();
        ArmorRender.PRESS_TEXTURE = new ResourceLocation("hcsmod:textures/PRESS.png");
        ArmorRender.bpvest_texture = new ResourceLocation("hcsmod:textures/bpvest.png");
        ArmorRender.JAG = new ModelJugger();
        ArmorRender.samodel = new ModelSamodel();
        ArmorRender.RF = new ModelRF();
        ArmorRender.NY = new ModelNY();
        ArmorRender.ghile = new ModelGhile();
        ArmorRender.helmet = new ModelHelmet();
        ArmorRender.helmetGL = new ModelHelmet.GL();
        ArmorRender.helmetPNV = new ModelHelmet.PNV();
        ArmorRender.balaclava = new Modelbalaclava();
        ArmorRender.Joker = new ModelJoker();
        ArmorRender.Krampus = new ModelKrampus();
        ArmorRender.Armor2020 = new ModelArmor2020();
        ArmorRender.Heavy = new ModelHeavy();
        ArmorRender.Prota = new ModelProta();
    }
    
    public enum ModelPart
    {
        BODY, 
        HEAD, 
        LARM, 
        RARM, 
        LLEG, 
        RLEG, 
        LBOOT, 
        RBOOT, 
        JAGVOROT;
    }
}
