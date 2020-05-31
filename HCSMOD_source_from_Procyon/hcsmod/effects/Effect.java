// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.effects;

import net.minecraftforge.common.hrmy;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Effect extends lodj
{
    public static Effect bleeding;
    public static int bleedingId;
    
    public Effect(final int n, final boolean b, final int n2, final String str) {
        super(n, b, n2);
        this.func_76390_b("potion." + str);
        LanguageRegistry.instance().addStringLocalization(this.func_76393_a(), str);
    }
    
    public lodj func_76399_b(final int n, final int n2) {
        super.func_76399_b(n, n2);
        return this;
    }
    
    public static void loadEffects() {
        Effect.bleeding = new Effect(Effect.bleedingId, true, 5149489, "Bleeding");
    }
    
    public static void effectConfig(final hrmy hrmy) {
        Effect.bleedingId = hrmy.get("effect", "bleedingId", 29, "Bleeding Effect ID").getInt();
    }
    
    public static void register() {
        lodj.field_76425_a[Effect.bleeding.func_76396_c()] = Effect.bleeding;
    }
}
