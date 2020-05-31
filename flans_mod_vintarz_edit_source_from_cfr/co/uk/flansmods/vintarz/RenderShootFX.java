/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.dwbg
 *  org.lwjgl.opengl.GL11
 *  uheb
 *  uyfg
 */
package co.uk.flansmods.vintarz;

import co.uk.flansmods.vintarz.EntityShootFX;
import co.uk.flansmods.vintarz.Util;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwbg;
import org.lwjgl.opengl.GL11;

public class RenderShootFX
extends uyfg {
    private String textureName;
    private double distance;
    ResourceLocation tex1 = new ResourceLocation("flansmod:gun_shot0.png");
    ResourceLocation tex2 = new ResourceLocation("flansmod:gun_shot1.png");

    public RenderShootFX(String string, double d) {
        this.textureName = string;
        this.distance = d;
        this.tex1 = new ResourceLocation("flansmod:" + string + "0.png");
        this.tex2 = new ResourceLocation("flansmod:" + string + "1.png");
    }

    public void doRenderShoot(Entity entity, double d, double d2, double d3, float f, float f2) {
        double d4;
        double d5;
        EntityShootFX entityShootFX = (EntityShootFX)entity;
        EntityPlayer entityPlayer = entityShootFX.shooter;
        if (entityPlayer != null) {
            double d6 = entityPlayer.field_70169_q + (entityPlayer.field_70165_t - entityPlayer.field_70169_q) * (double)f2;
            d4 = entityPlayer.field_70167_r + (entityPlayer.field_70163_u - entityPlayer.field_70167_r) * (double)f2;
            d5 = entityPlayer.field_70166_s + (entityPlayer.field_70161_v - entityPlayer.field_70166_s) * (double)f2;
            entityShootFX.func_70012_b(d6, d4 + (double)entityPlayer.func_70047_e(), d5, entityPlayer.field_70177_z, entityPlayer.field_70125_A);
            if (!Util.isAiming(entityPlayer)) {
                entityShootFX.field_70165_t -= (double)(dwbg._b((float)(entityShootFX.field_70177_z / 180.0f * 3.141593f)) * 0.15f);
                entityShootFX.field_70161_v -= (double)(dwbg._a((float)(entityShootFX.field_70177_z / 180.0f * 3.141593f)) * 0.15f);
            }
            entityShootFX.field_70163_u -= 0.125;
            if (entityPlayer.func_70093_af()) {
                entityShootFX.field_70163_u -= 0.1;
            }
            float f3 = entityPlayer == tuor._E()._r ? 0.4f : 1.25f;
            float f4 = entityShootFX.field_70177_z;
            float f5 = entityShootFX.field_70125_A;
            entityShootFX.field_70165_t -= (double)(dwbg._a((float)(f4 / 180.0f * 3.141593f)) * dwbg._b((float)(f5 / 180.0f * 3.141593f)) * f3);
            entityShootFX.field_70161_v += (double)(dwbg._b((float)(f4 / 180.0f * 3.141593f)) * dwbg._b((float)(f5 / 180.0f * 3.141593f)) * f3);
            entityShootFX.field_70163_u -= (double)(dwbg._a((float)(f5 / 180.0f * 3.141593f)) * f3);
            f4 = entityShootFX.field_70177_z;
            f5 = entityShootFX.field_70125_A + 90.0f;
            entityShootFX.field_70165_t -= (double)(dwbg._a((float)(f4 / 180.0f * 3.141593f)) * dwbg._b((float)(f5 / 180.0f * 3.141593f)) * 0.12f);
            entityShootFX.field_70161_v += (double)(dwbg._b((float)(f4 / 180.0f * 3.141593f)) * dwbg._b((float)(f5 / 180.0f * 3.141593f)) * 0.12f);
            entityShootFX.field_70163_u -= (double)(dwbg._a((float)(f5 / 180.0f * 3.141593f)) * 0.12f);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
        GL11.glScalef((float)0.4f, (float)0.4f, (float)0.4f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)2896);
        this.func_110776_a(this.tex1);
        uheb uheb2 = uheb.field_78398_a;
        GL11.glRotatef((float)(90.0f - entity.field_70177_z), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
        d4 = Math.toRadians(entity.field_70125_A);
        d5 = this.distance;
        double d7 = d5 + 1.0;
        double d8 = Math.sin(d4) * 0.5;
        double d9 = Math.cos(d4) * 0.5;
        double d10 = Math.sin(d4) * d5;
        double d11 = Math.sin(d4) * d7;
        double d12 = Math.cos(d4) * d5;
        double d13 = Math.cos(d4) * d7;
        GL11.glTranslatef((float)((float)(-2.0 * d9)), (float)((float)(-d8) * 2.0f), (float)0.0f);
        uheb2.func_78382_b();
        uheb2.func_78374_a(d12 + d8, d10 - d9, 0.0, 0.0, 1.0);
        uheb2.func_78374_a(d13 + d8, d11 - d9, 0.0, 1.0, 1.0);
        uheb2.func_78374_a(d13 - d8, d11 + d9, 0.0, 1.0, 0.0);
        uheb2.func_78374_a(d12 - d8, d10 + d9, 0.0, 0.0, 0.0);
        uheb2.func_78381_a();
        uheb2.func_78382_b();
        uheb2.func_78374_a(d12 + d8, d10 - d9, 0.0, 0.0, 1.0);
        uheb2.func_78374_a(d12 - d8, d10 + d9, 0.0, 0.0, 0.0);
        uheb2.func_78374_a(d13 - d8, d11 + d9, 0.0, 1.0, 0.0);
        uheb2.func_78374_a(d13 + d8, d11 - d9, 0.0, 1.0, 1.0);
        uheb2.func_78381_a();
        uheb2.func_78382_b();
        uheb2.func_78374_a(d12, d10, -0.5, 0.0, 1.0);
        uheb2.func_78374_a(d13, d11, -0.5, 1.0, 1.0);
        uheb2.func_78374_a(d13, d11, 0.5, 1.0, 0.0);
        uheb2.func_78374_a(d12, d10, 0.5, 0.0, 0.0);
        uheb2.func_78381_a();
        uheb2.func_78382_b();
        uheb2.func_78374_a(d12, d10, -0.5, 0.0, 1.0);
        uheb2.func_78374_a(d12, d10, 0.5, 0.0, 0.0);
        uheb2.func_78374_a(d13, d11, 0.5, 1.0, 0.0);
        uheb2.func_78374_a(d13, d11, -0.5, 1.0, 1.0);
        uheb2.func_78381_a();
        this.func_110776_a(this.tex2);
        uheb2.func_78382_b();
        uheb2.func_78374_a(d13 + d8, d11 - d9, -0.5, 0.0, 1.0);
        uheb2.func_78374_a(d13 + d8, d11 - d9, 0.5, 1.0, 1.0);
        uheb2.func_78374_a(d13 - d8, d11 + d9, 0.5, 1.0, 0.0);
        uheb2.func_78374_a(d13 - d8, d11 + d9, -0.5, 0.0, 0.0);
        uheb2.func_78381_a();
        GL11.glEnable((int)2896);
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.doRenderShoot(entity, d, d2, d3, f, f2);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return null;
    }
}

