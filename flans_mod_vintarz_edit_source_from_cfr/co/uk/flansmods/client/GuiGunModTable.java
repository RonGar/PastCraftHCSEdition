/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  ieta
 *  ivrt
 *  jhvs
 *  kkuu
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  rord
 *  zfwe
 *  zwlp
 */
package co.uk.flansmods.client;

import co.uk.flansmods.client.ClientProxy;
import co.uk.flansmods.client.model.GunAnimations;
import co.uk.flansmods.client.model.ModelGun;
import co.uk.flansmods.client.model.RenderGun;
import co.uk.flansmods.common.guns.ContainerGunModTable;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemGun;
import java.util.Random;
import net.minecraft.client.tuor;
import net.minecraft.entity.player.rojd;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiGunModTable
extends zwlp {
    private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/gunTable.png");
    private static final Random rand = new Random();

    public GuiGunModTable(rojd rojd2, cuqu cuqu2) {
        super((ivrt)new ContainerGunModTable(rojd2, cuqu2));
        this.field_74195_c = 256;
    }

    public void func_73873_v_() {
        GuiGunModTable.func_73734_a((int)0, (int)0, (int)this.field_73880_f, (int)this.field_74197_n, (int)1677721600);
        GuiGunModTable.func_73734_a((int)0, (int)this.field_74197_n, (int)this.field_74198_m, (int)(this.field_74197_n + this.field_74195_c), (int)1677721600);
        GuiGunModTable.func_73734_a((int)(this.field_74198_m + 176), (int)this.field_74197_n, (int)this.field_73880_f, (int)(this.field_74197_n + this.field_74195_c), (int)1677721600);
        GuiGunModTable.func_73734_a((int)0, (int)(this.field_74197_n + this.field_74195_c), (int)this.field_73880_f, (int)this.field_73881_g, (int)1677721600);
    }

    protected void func_74189_g(int n, int n2) {
        this.field_73886_k._b("\u0418\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c", 8, this.field_74195_c - 94 + 2, 16777215);
        this.field_73886_k._b("\u041c\u043e\u0434\u0438\u0444\u0438\u043a\u0430\u0446\u0438\u044f \u043e\u0440\u0443\u0436\u0438\u044f", 8, 6, 16777215);
        ieta ieta2 = this.field_74193_d.func_75139_a(0).func_75211_c();
        if (ieta2 != null && ieta2._a() instanceof ItemGun) {
            GunType gunType = ((ItemGun)ieta2._a()).type;
            if (gunType.model != null) {
                ModelGun.DRAWING_INVENTORY = true;
                GL11.glPushMatrix();
                GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glTranslatef((float)110.0f, (float)54.0f, (float)100.0f);
                GL11.glRotatef((float)160.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)20.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glScalef((float)-50.0f, (float)50.0f, (float)50.0f);
                ClientProxy.gunRenderer.renderGun(ieta2, gunType, 0.0625f, gunType.model, GunAnimations.defaults, 0.0f);
                GL11.glPopMatrix();
                ModelGun.DRAWING_INVENTORY = false;
            }
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
        for (int i = 1; i < 13; ++i) {
            this.field_74193_d.func_75139_a((int)i).field_75221_f = -1000;
        }
        ieta ieta2 = this.field_74193_d.func_75139_a(0).func_75211_c();
        if (ieta2 != null && ieta2._a() instanceof ItemGun) {
            GunType gunType = ((ItemGun)ieta2._a()).type;
            if (gunType.allowBarrelAttachments) {
                this.func_73729_b(n3 + 51, n4 + 107, 176, 122, 22, 22);
                this.field_74193_d.func_75139_a((int)1).field_75221_f = 110;
            }
            if (gunType.allowScopeAttachments) {
                this.func_73729_b(n3 + 77, n4 + 81, 202, 96, 22, 22);
                this.field_74193_d.func_75139_a((int)2).field_75221_f = 84;
            }
            if (gunType.allowStockAttachments) {
                this.func_73729_b(n3 + 103, n4 + 107, 228, 122, 22, 22);
                this.field_74193_d.func_75139_a((int)3).field_75221_f = 110;
            }
            if (gunType.allowGripAttachments) {
                this.func_73729_b(n3 + 77, n4 + 133, 202, 148, 22, 22);
                this.field_74193_d.func_75139_a((int)4).field_75221_f = 136;
            }
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 4; ++j) {
                    if (i + j * 2 >= gunType.numGenericAttachmentSlots) continue;
                    this.field_74193_d.func_75139_a((int)(5 + i + j * 2)).field_75221_f = 83 + 18 * j;
                }
            }
        }
        GL11.glDisable((int)3042);
    }
}

