// 
// Decompiled by Procyon v0.5.36
// 

package atomicstryker.dynamiclights.common;

import java.util.Map;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class DLFMLCorePlugin implements IFMLLoadingPlugin
{
    public String[] getASMTransformerClass() {
        return new String[] { "atomicstryker.dynamiclights.common.DLTransformer" };
    }
    
    public String getModContainerClass() {
        return null;
    }
    
    public String getSetupClass() {
        return null;
    }
    
    public void injectData(final Map<String, Object> map) {
    }
    
    public String[] getLibraryRequestClass() {
        return null;
    }
}
