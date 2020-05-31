// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import java.util.HashMap;
import net.minecraft.entity.EntityLivingBase;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.client.render.RenderItemObj;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import hcsmod.HCS;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public class ItemMeele extends ndbu
{
    public float field_77827_a;
    public String name;
    public static final Map<String, ResourceLocation> textures;
    private final boolean extraDamage;
    
    public ItemMeele(final int n, final tesa tesa, final String str) {
        super(n, tesa);
        this.extraDamage = (tesa == HCS.AXE);
        if (FMLLaunchHandler.side() == Side.CLIENT && str != null && !str.equals("") && !ItemMeele.textures.containsKey(str)) {
            ItemMeele.textures.put(str, new ResourceLocation("hcsmod", "textures/items/" + str + ".png"));
        }
        this.func_77637_a(tekj.field_78037_j);
        this.field_77777_bU = 1;
        this.func_77656_e(tesa._a());
        this.field_77827_a = tesa._c();
        this.name = str;
        this.func_77664_n();
        this.func_77655_b("hcsmod:." + str);
        if (FMLLaunchHandler.side() == Side.CLIENT) {
            mayf.registerItemRenderer(this.field_77779_bT, (rqjc)RenderItemObj.instance);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final qlze qlze) {
        super.field_77791_bV = qlze._a("hcsmod:" + this.name + "_icon");
    }
    
    public boolean func_77644_a(final ieta ieta, final EntityLivingBase entityLivingBase, final EntityLivingBase entityLivingBase2) {
        if (!entityLivingBase.field_70170_p.field_72995_K) {
            ieta._a(this.extraDamage ? 10 : 1, entityLivingBase2);
        }
        return true;
    }
    
    public rpnc func_77661_b(final ieta ieta) {
        return rpnc._a;
    }
    
    static {
        textures = new HashMap<String, ResourceLocation>();
    }
}
