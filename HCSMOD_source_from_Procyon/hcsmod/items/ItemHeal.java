// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.items;

import java.util.HashMap;
import hcsmod.player.ExtendedPlayer;
import hcsmod.effects.Effect;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.client.render.RenderHealObj;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import hcsmod.HCS;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public class ItemHeal extends jhvs
{
    public String name;
    public String texture;
    public static final Map<String, ResourceLocation> textures;
    public float healing;
    public int healDamageCancel;
    
    public ItemHeal(final int n, final float healing, final int n2, final int healDamageCancel, final String s, final String s2) {
        super(n);
        this.func_77625_d(1);
        this.func_77656_e(n2);
        this.func_77637_a(HCS.modcreativetab);
        this.healing = healing;
        this.name = s;
        this.texture = s2;
        this.healDamageCancel = healDamageCancel;
        this.func_77664_n();
        this.func_77655_b("hcsmod:" + s);
        if (FMLLaunchHandler.side() == Side.CLIENT && s != null && !s.equals("") && !ItemHeal.textures.containsKey(s)) {
            ItemHeal.textures.put(s, new ResourceLocation("hcsmod", "textures/items/" + s2 + ".png"));
        }
        if (FMLLaunchHandler.side() == Side.CLIENT) {
            mayf.registerItemRenderer(this.field_77779_bT, (rqjc)RenderHealObj.instance);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final qlze qlze) {
        super.field_77791_bV = qlze._a("hcsmod:" + this.name + "_icon");
    }
    
    public void func_77624_a(final ieta ieta, final EntityPlayer entityPlayer, final List list, final boolean b) {
        if (null != HCS.pills && super.field_77779_bT == HCS.pills.field_77779_bT) {
            list.add("\u041b\u0435\u0447\u0430\u0442 3000 \u043a\u0440\u043e\u0432\u0438");
            list.add("4 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u044f");
            list.add("\u041b\u0435\u0447\u0435\u043d\u0438\u0435 \u0441\u0431\u0440\u0430\u0441\u044b\u0432\u0430\u0435\u0442\u0441\u044f \u043f\u0440\u0438 \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0438 \u0443\u0440\u043e\u043d\u0430");
        }
        else if (null != HCS.firstAidKit && super.field_77779_bT == HCS.firstAidKit.field_77779_bT) {
            list.add("\u041b\u0435\u0447\u0438\u0442 12000 \u043a\u0440\u043e\u0432\u0438");
            list.add("1 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435");
            list.add("\u041d\u0435 \u043e\u0441\u0442\u0430\u043d\u0430\u0432\u0438\u043b\u0432\u0430\u0435\u0442 \u043a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u0435(\u0441\u043a\u0440\u0430\u0444\u0442\u044c \u0441 \u0431\u0438\u043d\u0442\u043e\u043c)");
            list.add("\u041b\u0435\u0447\u0435\u043d\u0438\u0435 \u0441\u0431\u0440\u0430\u0441\u044b\u0432\u0430\u0435\u0442\u0441\u044f \u043f\u0440\u0438 \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0438 >3\u043a \u0443\u0440\u043e\u043d\u0430");
        }
        else if (null != HCS.firstAidKit_b && super.field_77779_bT == HCS.firstAidKit_b.field_77779_bT) {
            list.add("\u041b\u0435\u0447\u0438\u0442 12000 \u043a\u0440\u043e\u0432\u0438");
            list.add("1 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435");
            list.add("\u041e\u0441\u0442\u0430\u043d\u0430\u0432\u0438\u043b\u0432\u0430\u0435\u0442 \u043a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u0435");
            list.add("\u041b\u0435\u0447\u0435\u043d\u0438\u0435 \u0441\u0431\u0440\u0430\u0441\u044b\u0432\u0430\u0435\u0442\u0441\u044f \u043f\u0440\u0438 \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0438 >3\u043a \u0443\u0440\u043e\u043d\u0430");
        }
        else if (null != HCS.small_firstAidKit && super.field_77779_bT == HCS.small_firstAidKit.field_77779_bT) {
            list.add("\u041b\u0435\u0447\u0438\u0442 12000 \u043a\u0440\u043e\u0432\u0438");
            list.add("1 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435");
            list.add("\u041b\u0435\u0447\u0435\u043d\u0438\u0435 \u0441\u0431\u0440\u0430\u0441\u044b\u0432\u0430\u0435\u0442\u0441\u044f \u043f\u0440\u0438 \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0438 \u0443\u0440\u043e\u043d\u0430");
        }
    }
    
    public ieta func_77659_a(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        if (cuqu.field_72995_K) {
            return ieta;
        }
        ieta._b(ieta._j() + 1);
        if (ieta._j() >= ieta._k()) {
            --ieta._b;
        }
        if (HCS.firstAidKit_b != null && super.field_77779_bT == HCS.firstAidKit_b.field_77779_bT && entityPlayer.func_70644_a((lodj)Effect.bleeding)) {
            entityPlayer.func_82170_o(Effect.bleeding.field_76415_H);
        }
        ExtendedPlayer.server(entityPlayer).startHeal(this.healing, (float)this.healDamageCancel);
        return ieta;
    }
    
    static {
        textures = new HashMap<String, ResourceLocation>();
    }
}
