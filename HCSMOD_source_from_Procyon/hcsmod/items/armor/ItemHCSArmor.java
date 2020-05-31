// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items.armor;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.HCS;
import net.minecraft.util.ResourceLocation;
import hcsmod.client.render.IVladruArmorModel;

public class ItemHCSArmor extends qmjs
{
    public IVladruArmorModel model;
    public ResourceLocation texture;
    
    public ItemHCSArmor(final IVladruArmorModel model, final String s, final int n, final jhvo jhvo, final int n2, final int n3) {
        super(n, jhvo, n2, n3);
        this.model = model;
        this.texture = new ResourceLocation("hcsmod", s);
        this.func_77637_a(HCS.modcreativetab);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final qlze qlze) {
        this.field_77791_bV = qlze._a("hcsmod:" + this.func_111208_A());
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ieta ieta, final EntityPlayer entityPlayer, final List list, final boolean b) {
        if (ieta._q() != null && ieta._q()._c("juggerOwner")) {
            list.add("\u0412\u043b\u0430\u0434\u0435\u043b\u0435\u0446: " + ieta._q()._j("juggerOwner"));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLivingBase entityLivingBase, final ieta ieta, final int n) {
        return null;
    }
    
    public String getArmorTexture(final ieta ieta, final Entity entity, final int n, final String s) {
        return "hcsmod:textures/armorEmpty.png";
    }
    
    public ieta func_77659_a(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if (!cuqu.field_72995_K) {
            return super.func_77659_a(ieta, cuqu, entityPlayer);
        }
        return ieta;
    }
}
