// 
// Decompiled by Procyon v0.5.36
// 

package vintarz;

import java.nio.file.LinkOption;
import java.nio.file.Paths;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;

@Mod(modid = "RD")
public class RD
{
    public static String library;
    
    public static native byte[] rd(final byte[] p0);
    
    @Mod.EventHandler
    public void init(final FMLPreInitializationEvent fmlPreInitializationEvent) {
        try {
            RDDebug.init1(fmlPreInitializationEvent);
        }
        catch (Throwable t2) {}
        try {
            final String string = Paths.get(RD.library, new String[0]).toRealPath(new LinkOption[0]).toString();
            System.out.println(string);
            System.out.flush();
            System.load(string);
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
        try {
            RDDebug.init2(fmlPreInitializationEvent);
        }
        catch (Throwable t3) {}
    }
    
    static {
        RD.library = "../java" + System.getProperty("sun.arch.data.model") + "/RD.dll";
    }
}
