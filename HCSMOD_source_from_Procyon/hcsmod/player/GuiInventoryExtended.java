// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.player;

import net.minecraft.entity.Entity;
import hcsmod.client.hud.DayZHud;
import co.uk.flansmods.common.guns.ItemGun;
import hcsmod.client.HcsClient;
import net.minecraft.entity.EntityLivingBase;
import hcsmod.HCS;
import net.minecraft.client.tuor;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiInventoryExtended extends InventoryDayZ
{
    protected static final ResourceLocation field_110408_a;
    private float xSize_lo;
    private float ySize_lo;
    private InventoryExtended ie;
    
    public GuiInventoryExtended(final EntityPlayer entityPlayer, final InventoryExtended inventoryExtended) {
        super((ivrt)new ContainerExtended(entityPlayer, inventoryExtended));
        this.field_73885_j = true;
        entityPlayer.func_71064_a((dgqn)pjtw._f, 1);
    }
    
    @Override
    public void func_73876_c() {
        if (this.field_73882_e._h._i()) {
            this.field_73882_e._a((dwms)new GuiInventoryCreative((EntityPlayer)this.field_73882_e._r, this.ie));
        }
        super.func_73876_c();
    }
    
    @Override
    public void func_73866_w_() {
        if (this.field_73882_e._h._i()) {
            this.field_73882_e._a((dwms)new GuiInventoryCreative((EntityPlayer)this.field_73882_e._r, this.ie));
        }
        super.func_73866_w_();
    }
    
    @SideOnly(Side.CLIENT)
    protected void func_74189_g(final int n, final int n2) {
    }
    
    @Override
    public void func_73863_a(final int n, final int n2, final float n3) {
        super.func_73863_a(n, n2, n3);
        this.xSize_lo = (float)n;
        this.ySize_lo = (float)n2;
    }
    
    public void func_73873_v_() {
        func_73734_a(0, 0, this.field_73880_f, this.field_74197_n, 1677721600);
        func_73734_a(0, this.field_74197_n, this.field_74198_m - 111, this.field_74197_n + this.field_74195_c, 1677721600);
        func_73734_a(this.field_74198_m + 288, this.field_74197_n, this.field_73880_f, this.field_74197_n + this.field_74195_c, 1677721600);
        func_73734_a(0, this.field_74197_n + this.field_74195_c, this.field_73880_f, this.field_73881_g, 1677721600);
    }
    
    @Override
    protected void func_74185_a(final float n, final int n2, final int n3) {
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(GuiInventoryExtended.field_110408_a);
        this.func_73729_b(this.field_74198_m, this.field_74197_n, 0, 0, this.field_74194_b, this.field_74195_c);
        this.field_73882_e._f._a(GuiInventoryExtended.field_110408_a);
        final int backpackLVL = HCS.getBackpackLVL((EntityPlayer)tuor._E()._r, Side.CLIENT);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.func_73729_b(this.field_74198_m + 7 + j * 18, this.field_74197_n + 155 - (4 - i) * 18, (i < backpackLVL) ? 176 : 194, 0, 18, 18);
            }
        }
        func_110423_a(this.field_74198_m + 51, this.field_74197_n + 75, 30, this.field_74198_m + 51 - this.xSize_lo, this.field_74197_n + 75 - 50 - this.ySize_lo, (EntityLivingBase)this.field_73882_e._r);
        final ExtendedPlayer client = ExtendedPlayer.client(this.field_73882_e._r.field_71092_bJ);
        GL11.glEnable(3042);
        for (int k = 0; k < 9; ++k) {
            if (!HcsClient.isPVPserver && !HcsClient.isLiteserver && this.field_73882_e._r.field_71071_by.func_70301_a(k) == null && ItemGun.slotIsWeapon(k, client)) {
                DayZHud.drawTexturedRect(DayZHud.gun, this.field_74198_m + 8.5f + k * 18, this.field_74197_n + this.field_74195_c - 23.5f, 15.0f, 15.0f, 2.0f);
            }
        }
        super.func_74185_a(n, n2, n3);
    }
    
    public static void func_110423_a(final int n, final int n2, final int n3, final float n4, final float n5, final EntityLivingBase entityLivingBase) {
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(n + 18.0f, (float)n2, 50.0f);
        GL11.glScalef((float)(-n3), (float)n3, (float)n3);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        final float field_70761_aq = entityLivingBase.field_70761_aq;
        final float field_70177_z = entityLivingBase.field_70177_z;
        final float field_70125_A = entityLivingBase.field_70125_A;
        final float field_70758_at = entityLivingBase.field_70758_at;
        final float field_70759_as = entityLivingBase.field_70759_as;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        ncpk._b();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-(float)Math.atan(n5 / 40.0f) * 20.0f, 1.0f, 0.0f, 0.0f);
        entityLivingBase.field_70761_aq = (float)Math.atan(n4 / 40.0f - 0.5) * 20.0f;
        entityLivingBase.field_70177_z = (float)Math.atan(n4 / 40.0f) * 40.0f;
        entityLivingBase.field_70125_A = -(float)Math.atan(n5 / 40.0f) * 20.0f;
        entityLivingBase.field_70759_as = entityLivingBase.field_70177_z;
        entityLivingBase.field_70758_at = entityLivingBase.field_70177_z;
        GL11.glTranslatef(0.0f, entityLivingBase.field_70129_M, 0.0f);
        dfsc._b._l = 180.0f;
        dfsc._b._a((Entity)entityLivingBase, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        entityLivingBase.field_70761_aq = field_70761_aq;
        entityLivingBase.field_70177_z = field_70177_z;
        entityLivingBase.field_70125_A = field_70125_A;
        entityLivingBase.field_70758_at = field_70758_at;
        entityLivingBase.field_70759_as = field_70759_as;
        GL11.glPopMatrix();
        ncpk._a();
        GL11.glDisable(32826);
        wngx._a(wngx._b);
        GL11.glDisable(3553);
        wngx._a(wngx._a);
    }
    
    static {
        field_110408_a = new ResourceLocation("hcsmod:inventory.png");
    }
}
