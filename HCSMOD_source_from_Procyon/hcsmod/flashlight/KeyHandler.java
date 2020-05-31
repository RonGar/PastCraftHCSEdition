// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.flashlight;

import vintarz.core.VCP;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import net.minecraft.client.tuor;

public class KeyHandler extends bpzx.uxsf
{
    static tuor mc;
    protected static hbei toggle;
    
    public KeyHandler() {
        super(new hbei[] { KeyHandler.toggle }, new boolean[] { false });
    }
    
    public String getLabel() {
        return "FlashLightMod KeyHandler";
    }
    
    public void keyDown(final EnumSet<TickType> set, final hbei hbei, final boolean b, final boolean b2) {
        if (b) {
            return;
        }
        if (KeyHandler.mc._r != null && KeyHandler.mc._z == null) {
            new VCP(1, "HCSMOD").send();
        }
    }
    
    public void keyUp(final EnumSet<TickType> set, final hbei hbei, final boolean b) {
    }
    
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT);
    }
    
    static {
        KeyHandler.mc = tuor._E();
        KeyHandler.toggle = new hbei("flashlight", 21);
    }
}
