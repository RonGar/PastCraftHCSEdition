/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  dwms
 *  gowi
 *  hbei
 *  ieta
 *  jhvs
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
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

import co.uk.flansmods.client.FlansModResourceHandler;
import co.uk.flansmods.client.model.ModelDriveable;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.EnumType;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.ItemPart;
import co.uk.flansmods.common.PartType;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.PilotGun;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiDriveableCrafting
extends dwms {
    private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/driveableCrafting.png");
    private net.minecraft.entity.player.rojd inventory;
    private tuor field_73882_e;
    private cuqu world;
    private int x;
    private int y;
    private int z;
    private static uyeb itemRenderer = new uyeb();
    private int guiOriginX;
    private int guiOriginY;
    private static int blueprintsScroll = 0;
    private int recipeScroll = 0;
    private static int selectedBlueprint = 0;
    private float spinner = 0.0f;
    private boolean canCraft = false;

    public GuiDriveableCrafting(net.minecraft.entity.player.rojd rojd2, cuqu cuqu2, int n, int n2, int n3) {
        this.inventory = rojd2;
        this.field_73882_e = rojd.instance().getClient();
        this.world = cuqu2;
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public void func_73866_w_() {
        super.func_73866_w_();
        this.field_73887_h.add(new tdvs(0, this.field_73880_f / 2 + 22, this.field_73881_g / 2 + 63, 40, 20, "Craft"));
    }

    protected void func_73875_a(tdvs tdvs2) {
        if (tdvs2.field_73741_f == 0) {
            FlansMod.proxy.craftDriveable(this.inventory._d, DriveableType.types.get(selectedBlueprint));
        }
    }

    public void func_73863_a(int n, int n2, float f) {
        int n3;
        DriveableType driveableType;
        gowi gowi2 = new gowi(this.field_73882_e._K, this.field_73882_e._l, this.field_73882_e._m);
        int n4 = gowi2.func_78326_a();
        int n5 = gowi2.func_78328_b();
        this.func_73873_v_();
        GL11.glEnable((int)3042);
        this.field_73882_e._f._a(texture);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.guiOriginX = n4 / 2 - 88;
        this.guiOriginY = n5 / 2 - 99;
        this.func_73729_b(this.guiOriginX, this.guiOriginY, 0, 0, 176, 198);
        this.func_73731_b(this.field_73886_k, "Vehicle Crafting", this.guiOriginX + 6, this.guiOriginY + 6, 16777215);
        this.func_73731_b(this.field_73886_k, "Requires", this.guiOriginX + 6, this.guiOriginY + 125, 16777215);
        this.func_73731_b(this.field_73886_k, "Engine", this.guiOriginX + 114, this.guiOriginY + 141, 16777215);
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 8; ++j) {
                n3 = blueprintsScroll * 8 + 8 * i + j;
                if (n3 == selectedBlueprint) {
                    this.field_73882_e._f._a(texture);
                    this.func_73729_b(this.guiOriginX + 8 + j * 18, this.guiOriginY + 18 + i * 18, 213, 11, 16, 16);
                }
                if (n3 >= DriveableType.types.size()) continue;
                driveableType = DriveableType.types.get(n3);
                this.drawSlotInventory(new ieta(driveableType.item), this.guiOriginX + 8 + j * 18, this.guiOriginY + 18 + i * 18);
            }
        }
        this.spinner += 1.0f;
        if (selectedBlueprint < DriveableType.types.size()) {
            this.canCraft = true;
            DriveableType driveableType2 = DriveableType.types.get(selectedBlueprint);
            if (driveableType2 != null) {
                ieta ieta2;
                int n6;
                GL11.glPushMatrix();
                GL11.glEnable((int)2929);
                GL11.glTranslatef((float)(n4 / 2 - 46), (float)(n5 / 2 - 10), (float)100.0f);
                GL11.glScalef((float)(-50.0f * driveableType2.modelScale / driveableType2.cameraDistance), (float)(50.0f * driveableType2.modelScale / driveableType2.cameraDistance), (float)(50.0f * driveableType2.modelScale / driveableType2.cameraDistance));
                GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)30.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)(this.spinner / 5.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                this.field_73882_e._f._a(FlansModResourceHandler.getTexture(driveableType2));
                driveableType2.model.render(driveableType2);
                GL11.glDisable((int)2929);
                GL11.glPopMatrix();
                String string = driveableType2.name;
                if (string.length() > 16) {
                    string = string.substring(0, 15) + "...";
                }
                this.func_73731_b(this.field_73886_k, string, this.guiOriginX + 82, this.guiOriginY + 64, 16777215);
                this.func_73731_b(this.field_73886_k, "Cargo Slots : " + driveableType2.numCargoSlots, this.guiOriginX + 82, this.guiOriginY + 74, 16777215);
                this.func_73731_b(this.field_73886_k, "Bomb Slots : " + driveableType2.numBombSlots, this.guiOriginX + 82, this.guiOriginY + 84, 16777215);
                this.func_73731_b(this.field_73886_k, "Passengers : " + driveableType2.numPassengers, this.guiOriginX + 82, this.guiOriginY + 94, 16777215);
                this.func_73731_b(this.field_73886_k, "Guns : " + (driveableType2.numPassengerGunners + driveableType2.guns.size()), this.guiOriginX + 82, this.guiOriginY + 104, 16777215);
                this.func_73731_b(this.field_73886_k, driveableType2.numEngines() + "x", this.guiOriginX + 100, this.guiOriginY + 141, 16777215);
                driveableType = new net.minecraft.entity.player.rojd(null);
                driveableType._a(this.inventory);
                for (n3 = 0; n3 < 3; ++n3) {
                    for (n6 = 0; n6 < 4; ++n6) {
                        int n7 = this.recipeScroll * 4 + n3 * 4 + n6;
                        if (n7 >= driveableType2.recipe.size()) continue;
                        ieta2 = driveableType2.recipe.get(n7);
                        int n8 = 0;
                        for (int i = 0; i < driveableType.func_70302_i_(); ++i) {
                            PartType partType = driveableType.func_70301_a(i);
                            if (partType == null || ((ieta)partType)._d != ieta2._d || partType._j() != ieta2._j()) continue;
                            int n9 = Math.min(((ieta)partType)._b, ieta2._b - n8);
                            ((ieta)partType)._b -= n9;
                            if (((ieta)partType)._b <= 0) {
                                partType = null;
                            }
                            driveableType.func_70299_a(i, (ieta)partType);
                            if ((n8 += n9) == ieta2._b) break;
                        }
                        if (n8 < ieta2._b) {
                            this.field_73882_e._f._a(texture);
                            this.func_73729_b(this.guiOriginX + 8 + n6 * 18, this.guiOriginY + 138 + n3 * 18, 195, 11, 16, 16);
                            this.canCraft = false;
                        }
                        this.drawSlotInventory(ieta2, this.guiOriginX + 8 + n6 * 18, this.guiOriginY + 138 + n3 * 18);
                    }
                }
                HashMap<PartType, ieta> hashMap = new HashMap<PartType, ieta>();
                for (n6 = 0; n6 < driveableType.func_70302_i_(); ++n6) {
                    ieta2 = driveableType.func_70301_a(n6);
                    if (ieta2 == null || !(ieta2._a() instanceof ItemPart)) continue;
                    PartType partType = ((ItemPart)ieta2._a()).type;
                    if (partType.category != 2 || !partType.worksWith.contains((Object)EnumType.getFromObject(driveableType2))) continue;
                    if (hashMap.containsKey(partType)) {
                        ieta ieta3 = (ieta)hashMap.get(partType);
                        ieta3._b += ieta2._b;
                        continue;
                    }
                    hashMap.put(partType, ieta2);
                }
                float f2 = -1.0f;
                ieta2 = null;
                for (PartType partType : hashMap.keySet()) {
                    if (!(partType.engineSpeed > f2) || ((ieta)hashMap.get((Object)partType))._b < driveableType2.numEngines()) continue;
                    f2 = partType.engineSpeed;
                    ieta2 = (ieta)hashMap.get(partType);
                }
                this.field_73882_e._f._a(texture);
                if (ieta2 == null) {
                    this.func_73729_b(this.guiOriginX + 152, this.guiOriginY + 138, 195, 11, 16, 16);
                    this.canCraft = false;
                } else {
                    this.drawSlotInventory(ieta2, this.guiOriginX + 152, this.guiOriginY + 138);
                }
            }
            if (!this.canCraft) {
                this.field_73882_e._f._a(texture);
                this.func_73729_b(this.guiOriginX + 108, this.guiOriginY + 160, 176, 28, 44, 24);
                this.func_73731_b(this.field_73886_k, "Craft", this.guiOriginX + 116, this.guiOriginY + 168, 10526880);
            } else {
                super.func_73863_a(n, n2, f);
            }
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

    protected void func_73869_a(char c, int n) {
        if (n == 1 || n == this.field_73882_e._K.__bi._d) {
            this.field_73882_e._r.func_71053_j();
        }
    }

    protected void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        int n4 = n - this.guiOriginX;
        int n5 = n2 - this.guiOriginY;
        if (n3 == 0 || n3 == 1) {
            DriveableType driveableType;
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (n4 < 8 + j * 18 || n4 > 26 + j * 18 || n5 < 18 + 18 * i || n5 > 42 + 18 * i) continue;
                    selectedBlueprint = blueprintsScroll * 8 + i * 8 + j;
                }
            }
            if (n4 >= 157 && n4 <= 167 && n5 >= 21 && n5 <= 31 && blueprintsScroll > 0) {
                // empty if block
            }
            if (n4 >= 157 && n4 <= 167 && n5 >= 39 && n5 <= 49 && --blueprintsScroll * 8 + 16 < DriveableType.types.size()) {
                ++blueprintsScroll;
            }
            if (selectedBlueprint >= DriveableType.types.size()) {
                return;
            }
            if (n4 >= 83 && n4 <= 93 && n5 >= 141 && n5 <= 151 && this.recipeScroll > 0) {
                --this.recipeScroll;
            }
            if (n4 >= 83 && n4 <= 93 && n5 >= 177 && n5 <= 187 && (driveableType = DriveableType.types.get(selectedBlueprint)) != null && this.recipeScroll * 4 + 12 < driveableType.recipe.size()) {
                ++this.recipeScroll;
            }
        }
    }

    public boolean func_73868_f() {
        return false;
    }
}

