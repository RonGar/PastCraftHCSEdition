// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import net.minecraft.entity.EntityLivingBase;
import hcsmod.entity.EntityRat2020;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import hcsmod.client.render.RenderItemRat2020;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import hcsmod.HCS;
import net.minecraft.util.ResourceLocation;

public class ItemRat2020 extends jhvs
{
    public String name;
    public static ResourceLocation textures;
    
    public ItemRat2020(final int n, final String s) {
        super(n);
        this.name = s;
        this.func_77637_a(HCS.modcreativetab);
        this.func_77625_d(20);
        if (FMLLaunchHandler.side() == Side.CLIENT && s != null && !s.equals("")) {
            ItemRat2020.textures = new ResourceLocation("hcsmod", "textures/items/" + s + ".png");
        }
        if (FMLLaunchHandler.side() == Side.CLIENT) {
            mayf.registerItemRenderer(this.field_77779_bT, (rqjc)RenderItemRat2020.instance);
        }
    }
    
    public void func_77624_a(final ieta ieta, final EntityPlayer entityPlayer, final List list, final boolean b) {
        list.add("\u042d\u0442\u043e \u043d\u043e\u0432\u043e\u0433\u043e\u0434\u043d\u044f\u044f \u0438\u0432\u0435\u043d\u0442\u043e\u0432\u0430\u044f \u0432\u0430\u043b\u044e\u0442\u0430");
    }
    
    public void func_94581_a(final qlze qlze) {
        super.field_77791_bV = qlze._a("hcsmod:" + this.name + "_icon");
    }
    
    public ieta func_77659_a(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if (!entityPlayer.field_71075_bZ._d) {
            --ieta._b;
        }
        entityPlayer.func_71038_i();
        cuqu.func_72956_a((Entity)entityPlayer, "random.bow", 0.5f, 0.4f / (ItemRat2020.field_77697_d.nextFloat() * 0.4f + 0.8f));
        if (!cuqu.field_72995_K) {
            cuqu.func_72838_d((Entity)new EntityRat2020(cuqu, (EntityLivingBase)entityPlayer, ItemRat2020.textures));
        }
        return ieta;
    }
    
    static {
        ItemRat2020.textures = null;
    }
}
