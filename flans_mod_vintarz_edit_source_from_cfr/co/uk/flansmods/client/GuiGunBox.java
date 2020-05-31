/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ctpu
 *  dwms
 *  gowi
 *  hbei
 *  ieta
 *  jhvs
 *  ncpk
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  rojd
 *  rord
 *  scko
 *  uyeb
 *  uyla
 *  wngx
 *  zfwe
 */
package co.uk.flansmods.client;

import co.uk.flansmods.common.BlockGunBox;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.GunBoxType;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.guns.BulletType;
import java.util.List;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiGunBox
extends dwms {
    private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/weaponBox.png");
    private net.minecraft.entity.player.rojd inventory;
    private tuor field_73882_e;
    private static uyeb itemRenderer = new uyeb();
    private GunBoxType type;
    private int page;
    private int guiOriginX;
    private int guiOriginY;
    private int scroll;
    private long lastTime;

    public GuiGunBox(net.minecraft.entity.player.rojd rojd2, GunBoxType gunBoxType) {
        this.inventory = rojd2;
        this.field_73882_e = rojd.instance().getClient();
        this.type = gunBoxType;
        this.page = 0;
    }

    public void func_73863_a(int n, int n2, float f) {
        int n3;
        long l = this.field_73882_e._p.func_72912_H()._g();
        if (l > this.lastTime) {
            this.lastTime = l;
            if (l % 40L == 0L) {
                ++this.scroll;
            }
        }
        gowi gowi2 = new gowi(this.field_73882_e._K, this.field_73882_e._l, this.field_73882_e._m);
        int n4 = gowi2.func_78326_a();
        int n5 = gowi2.func_78328_b();
        rord rord2 = this.field_73882_e._x;
        this.func_73873_v_();
        GL11.glEnable((int)3042);
        this.field_73882_e._f._a(texture);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int n6 = this.guiOriginX = n4 / 2 - 88;
        int n7 = this.guiOriginY = n5 / 2 - 102;
        this.func_73729_b(n6, n7, 0, 0, 176, 204);
        this.func_73732_a(this.field_73886_k, this.type.name, n4 / 2, n7 + 5, 16777215);
        this.field_73882_e._f._a(texture);
        if (this.type.numGuns > this.page * 2 + 1 && this.type.guns[this.page * 2] != null && this.type.guns[this.page * 2 + 1] != null) {
            this.func_73729_b(n6 + 89, n7 + 18, 5, 18, 82, 90);
        }
        if (this.page == 0) {
            this.func_73729_b(n6 + 77, n7 + 109, 176, 0, 10, 10);
        }
        if (this.type.numGuns <= this.page * 2 + 2) {
            this.func_73729_b(n6 + 89, n7 + 109, 186, 0, 10, 10);
        }
        ncpk._c();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)32826);
        wngx._a((int)wngx._b, (float)240.0f, (float)240.0f);
        this.drawRecipe(rord2, n6, n7, this.page * 2, 0);
        if (this.type.numGuns > this.page * 2 + 1) {
            this.drawRecipe(rord2, n6, n7, this.page * 2 + 1, 1);
        }
        for (n3 = 0; n3 < 3; ++n3) {
            for (int i = 0; i < 9; ++i) {
                this.drawSlotInventory(this.inventory.func_70301_a(i + (n3 + 1) * 9), n6 + 8 + i * 18, n7 + 122 + n3 * 18);
            }
        }
        for (n3 = 0; n3 < 9; ++n3) {
            this.drawSlotInventory(this.inventory.func_70301_a(n3), n6 + 8 + n3 * 18, n7 + 180);
        }
        GL11.glDisable((int)3042);
    }

    private void drawRecipe(rord rord2, int n, int n2, int n3, int n4) {
        n += n4 * 84;
        if (this.type.guns[n3] != null) {
            int n5;
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.drawSlotInventory(new ieta(this.type.guns[n3].getItem()), n + 9, n2 + 44);
            if (this.type.bullets[n3] != null) {
                this.drawSlotInventory(new ieta(this.type.bullets[n3].getItem()), n + 9, n2 + 66);
            }
            if (this.type.altBullets[n3] != null) {
                this.drawSlotInventory(new ieta(this.type.altBullets[n3].getItem()), n + 9, n2 + 88);
            }
            int n6 = this.type.gunParts[n3].size();
            int n7 = 0;
            if (n6 >= 4) {
                n7 = this.scroll % (n6 - 2);
            }
            for (n5 = 0; n5 < (n6 < 3 ? n6 : 3); ++n5) {
                this.drawSlotInventory((ieta)this.type.gunParts[n3].get(n7 + n5), n + 30 + n5 * 19, n2 + 44);
            }
            if (this.type.bullets[n3] != null) {
                n6 = this.type.bulletParts[n3].size();
                n7 = 0;
                if (n6 >= 4) {
                    n7 = this.scroll % (n6 - 2);
                }
                for (n5 = 0; n5 < (n6 < 3 ? n6 : 3); ++n5) {
                    this.drawSlotInventory((ieta)this.type.bulletParts[n3].get(n7 + n5), n + 30 + n5 * 19, n2 + 66);
                }
            }
            if (this.type.altBullets[n3] != null) {
                n6 = this.type.altBulletParts[n3].size();
                n7 = 0;
                if (n6 >= 4) {
                    n7 = this.scroll % (n6 - 2);
                }
                for (n5 = 0; n5 < (n6 < 3 ? n6 : 3); ++n5) {
                    this.drawSlotInventory((ieta)this.type.altBulletParts[n3].get(n7 + n5), n + 30 + n5 * 19, n2 + 88);
                }
            }
            ncpk._a();
            String string = this.type.guns[n3].name;
            if (string.length() > 12) {
                int n8 = string.indexOf(" ", 10);
                if (n8 != -1) {
                    this.func_73732_a(rord2, string.substring(0, n8), n + 46, n2 + 22, 16777215);
                    this.func_73732_a(rord2, string.substring(n8 + 1, string.length()), n + 46, n2 + 32, 16777215);
                } else {
                    this.func_73732_a(rord2, string, n + 46, n2 + 25, 16777215);
                }
            } else {
                this.func_73732_a(rord2, string, n + 46, n2 + 25, 16777215);
            }
            ncpk._c();
        }
    }

    private void drawSlotInventory(ieta ieta2, int n, int n2) {
        if (ieta2 != null && ieta2._d != 0 && ieta2._a() != null) {
            itemRenderer._a(this.field_73886_k, this.field_73882_e._f, ieta2, n, n2);
            itemRenderer._c(this.field_73886_k, this.field_73882_e._f, ieta2, n, n2);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
        }
    }

    protected void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        int n4 = n - this.guiOriginX;
        int n5 = n2 - this.guiOriginY;
        if (n3 == 0 || n3 == 1) {
            if (n4 > 77 && n4 < 87 && n5 > 109 && n5 < 119 && this.page > 0) {
                --this.page;
            }
            if (n4 > 89 && n4 < 99 && n5 > 109 && n5 < 119 && this.type.numGuns > this.page * 2 + 2) {
                ++this.page;
            }
            if (this.type.guns[this.page * 2] != null && n4 > 7 && n4 < 27 && n5 > 42 && n5 < 62) {
                FlansMod.gunBoxBlock.buyGun(this.page * 2, this.inventory, this.type);
            }
            if (this.type.bullets[this.page * 2] != null && n4 > 7 && n4 < 27 && n5 > 64 && n5 < 84) {
                FlansMod.gunBoxBlock.buyAmmo(this.page * 2, this.inventory, this.type);
            }
            if (this.type.altBullets[this.page * 2] != null && n4 > 7 && n4 < 27 && n5 > 86 && n5 < 106) {
                FlansMod.gunBoxBlock.buyAltAmmo(this.page * 2, this.inventory, this.type);
            }
            if (this.page * 2 + 1 < this.type.numGuns && this.type.guns[this.page * 2 + 1] != null && n4 > 91 && n4 < 111 && n5 > 42 && n5 < 62) {
                FlansMod.gunBoxBlock.buyGun(this.page * 2 + 1, this.inventory, this.type);
            }
            if (this.page * 2 + 1 < this.type.numGuns && this.type.bullets[this.page * 2 + 1] != null && n4 > 91 && n4 < 111 && n5 > 64 && n5 < 84) {
                FlansMod.gunBoxBlock.buyAmmo(this.page * 2 + 1, this.inventory, this.type);
            }
            if (this.page * 2 + 1 < this.type.numGuns && this.type.altBullets[this.page * 2 + 1] != null && n4 > 91 && n4 < 111 && n5 > 86 && n5 < 106) {
                FlansMod.gunBoxBlock.buyAltAmmo(this.page * 2 + 1, this.inventory, this.type);
            }
        }
    }

    protected void func_73869_a(char c, int n) {
        if (n == 1 || n == this.field_73882_e._K.__bi._d) {
            this.field_73882_e._r.func_71053_j();
        }
    }

    public boolean func_73868_f() {
        return false;
    }
}

