// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import java.util.HashMap;
import hcsmod.player.ExtendedPlayer;
import hcsmod.effects.Effect;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import hcsmod.client.render.RenderItemDrink;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import hcsmod.HCS;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public class ItemDrinkBackpackmod extends jhvs
{
    public String name;
    private int potionId;
    private int potionDuration;
    private int potionAmplifier;
    private float potionEffectProbability;
    private int q;
    public static final Map<String, ResourceLocation> textures;
    
    public ItemDrinkBackpackmod(final int n, final int q, final String s) {
        super(n);
        this.name = s;
        this.func_77627_a(true);
        this.func_77637_a(HCS.modcreativetab);
        this.func_77625_d(4);
        this.q = q;
        if (FMLLaunchHandler.side() == Side.CLIENT && s != null && !s.equals("") && !ItemDrinkBackpackmod.textures.containsKey(s)) {
            ItemDrinkBackpackmod.textures.put(s, new ResourceLocation("hcsmod", "textures/items/" + s + ".png"));
        }
        if (FMLLaunchHandler.side() == Side.CLIENT) {
            mayf.registerItemRenderer(this.field_77779_bT, (rqjc)RenderItemDrink.instance);
        }
    }
    
    public void func_77624_a(final ieta ieta, final EntityPlayer entityPlayer, final List list, final boolean b) {
        if (null != HCS.bandage && super.field_77779_bT == HCS.bandage.field_77779_bT) {
            list.add("\u041e\u0441\u0442\u0430\u043d\u0430\u0432\u043b\u0438\u0432\u0430\u0435\u0442 \u043a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u0435");
        }
        else if (null != HCS.morphine && super.field_77779_bT == HCS.morphine.field_77779_bT) {
            list.add("\u041b\u0435\u0447\u0438\u0442 \u043f\u043e\u043b\u043e\u043c\u0430\u043d\u043d\u044b\u0435 \u043d\u043e\u0433\u0438");
        }
        else {
            list.add("\u0412\u043e\u0441\u043f\u043e\u043b\u043d\u044f\u0435\u0442 \u0436\u0430\u0436\u0434\u0443 \u043d\u0430 " + (int)(this.q / 78000.0f * 100.0f) + "%");
            list.add("\u0412\u043e\u0441\u0441\u0442\u0430\u043d\u0430\u0432\u043b\u0438\u0432\u0430\u0435\u0442 1200 \u043a\u0440\u043e\u0432\u0438");
        }
    }
    
    public ieta func_77654_b(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if (cuqu.field_72995_K) {
            return ieta;
        }
        if (HCS.morphine != null && super.field_77779_bT == HCS.morphine.field_77779_bT) {
            if (entityPlayer.func_70644_a(lodj.field_76421_d)) {
                entityPlayer.func_82170_o(lodj.field_76421_d.field_76415_H);
            }
            --ieta._b;
            this.onFoodEaten(ieta, cuqu, entityPlayer);
        }
        else if (HCS.bandage != null && super.field_77779_bT == HCS.bandage.field_77779_bT) {
            if (entityPlayer.func_70644_a((lodj)Effect.bleeding)) {
                entityPlayer.func_82170_o(Effect.bleeding.field_76415_H);
            }
            --ieta._b;
            this.onFoodEaten(ieta, cuqu, entityPlayer);
        }
        else {
            --ieta._b;
            entityPlayer.func_70691_i(2.0f);
            final ExtendedPlayer server = ExtendedPlayer.server(entityPlayer);
            if (server.thirst < 12000) {
                final kldu func_70660_b = entityPlayer.func_70660_b(lodj.field_76431_k);
                int n = 150;
                if (func_70660_b != null) {
                    n = 150 + func_70660_b.field_76460_b;
                }
                entityPlayer.func_70690_d(new kldu(lodj.field_76431_k.field_76415_H, n));
            }
            server.water(1, this.q);
            this.onFoodEaten(ieta, cuqu, entityPlayer);
        }
        return ieta;
    }
    
    protected void onFoodEaten(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if (!cuqu.field_72995_K && this.potionId > 0 && cuqu.field_73012_v.nextFloat() < this.potionEffectProbability) {
            entityPlayer.func_70690_d(new kldu(this.potionId, this.potionDuration * 20, this.potionAmplifier));
        }
    }
    
    public int func_77626_a(final ieta ieta) {
        return 32;
    }
    
    public rpnc func_77661_b(final ieta ieta) {
        return rpnc._c;
    }
    
    public ieta func_77659_a(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        entityPlayer.func_71008_a(ieta, this.func_77626_a(ieta));
        return ieta;
    }
    
    public ItemDrinkBackpackmod setPotionEffect(final int potionId, final int potionDuration, final int potionAmplifier, final float potionEffectProbability) {
        this.potionId = potionId;
        this.potionDuration = potionDuration;
        this.potionAmplifier = potionAmplifier;
        this.potionEffectProbability = potionEffectProbability;
        return this;
    }
    
    public void func_94581_a(final qlze qlze) {
        super.field_77791_bV = qlze._a("hcsmod:" + this.name + "_icon");
    }
    
    static {
        textures = new HashMap<String, ResourceLocation>();
    }
}
