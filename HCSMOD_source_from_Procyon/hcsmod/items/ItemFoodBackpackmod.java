// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import java.util.HashMap;
import hcsmod.player.ExtendedPlayer;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import hcsmod.client.render.RenderItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import hcsmod.HCS;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public class ItemFoodBackpackmod extends uhwz
{
    private int q;
    public String name;
    public static final Map<String, ResourceLocation> textures;
    
    public ItemFoodBackpackmod(final int n, final int n2, final float n3, final boolean b, final int q, final String s) {
        super(n, n2, n3, b);
        this.name = s;
        this.func_77637_a(HCS.modcreativetab);
        this.func_77625_d(4);
        this.func_77848_i();
        this.q = q;
        if (FMLLaunchHandler.side() == Side.CLIENT && s != null && !s.equals("") && !ItemFoodBackpackmod.textures.containsKey(s)) {
            ItemFoodBackpackmod.textures.put(s, new ResourceLocation("hcsmod", "textures/items/" + s + ".png"));
        }
        if (FMLLaunchHandler.side() == Side.CLIENT) {
            mayf.registerItemRenderer(this.field_77779_bT, (rqjc)RenderItemFood.instance);
        }
    }
    
    public void func_77624_a(final ieta ieta, final EntityPlayer entityPlayer, final List list, final boolean b) {
        if (null != HCS.MRE && super.field_77779_bT == HCS.MRE.field_77779_bT) {
            list.add("\u0412\u043e\u0441\u043f\u043e\u043b\u043d\u044f\u0435\u0442 \u0436\u0430\u0436\u0434\u0443 \u0438 \u0433\u043e\u043b\u043e\u0434 \u043d\u0430 " + (int)(this.q / 78000.0f * 100.0f) + "%");
            list.add("\u0412\u043e\u0441\u0441\u0442\u0430\u043d\u0430\u0432\u043b\u0438\u0432\u0430\u0435\u0442 1200 \u043a\u0440\u043e\u0432\u0438");
        }
        else {
            list.add("\u0412\u043e\u0441\u043f\u043e\u043b\u043d\u044f\u0435\u0442 \u0433\u043e\u043b\u043e\u0434 \u043d\u0430 " + (int)(this.q / 78000.0f * 100.0f) + "%");
            list.add("\u0412\u043e\u0441\u0441\u0442\u0430\u043d\u0430\u0432\u043b\u0438\u0432\u0430\u0435\u0442 1200 \u043a\u0440\u043e\u0432\u0438");
        }
    }
    
    public int func_77626_a(final ieta ieta) {
        return 32;
    }
    
    public rpnc func_77661_b(final ieta ieta) {
        return rpnc._b;
    }
    
    public ieta func_77654_b(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if (!cuqu.field_72995_K) {
            super.func_77654_b(ieta, cuqu, entityPlayer);
            entityPlayer.func_70691_i(2.0f);
            final ExtendedPlayer server = ExtendedPlayer.server(entityPlayer);
            if (server.hunger < 12000) {
                final kldu func_70660_b = entityPlayer.func_70660_b(lodj.field_76431_k);
                int n = 150;
                if (func_70660_b != null) {
                    n = 150 + func_70660_b.field_76460_b;
                }
                entityPlayer.func_70690_d(new kldu(lodj.field_76431_k.field_76415_H, n));
            }
            server.feed(1, this.q);
            if (this == HCS.MRE) {
                server.water(1, this.q);
            }
        }
        return ieta;
    }
    
    public void func_94581_a(final qlze qlze) {
        super.field_77791_bV = qlze._a("hcsmod:" + this.name + "_icon");
    }
    
    static {
        textures = new HashMap<String, ResourceLocation>();
    }
}
