// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.effects;

import net.minecraft.util.pico;

public class DamageType extends pico
{
    public static final DamageType bleedOut;
    public static final DamageType thirstDeath;
    
    public DamageType(final String s) {
        super(s);
    }
    
    public pico func_76348_h() {
        return super.func_76348_h();
    }
    
    public pico func_76359_i() {
        return super.func_76359_i();
    }
    
    public pico func_76361_j() {
        return super.func_76361_j();
    }
    
    static {
        bleedOut = (DamageType)new DamageType("bleedOut").func_76348_h();
        thirstDeath = (DamageType)new DamageType("thirstDeath").func_76348_h();
    }
}
