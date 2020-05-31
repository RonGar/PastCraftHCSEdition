// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.effects;

import java.util.ArrayList;
import java.util.List;

public class EnactEffect extends kldu
{
    public EnactEffect(final int n, final int n2, final int n3) {
        super(n, n2, n3);
    }
    
    public EnactEffect(final lodj lodj, final int n, final int n2) {
        this(lodj.func_76396_c(), n, n2);
    }
    
    public EnactEffect(final int n, final int n2, final int n3, final List curativeItems) {
        super(n, n2, n3);
        if (curativeItems == null) {
            this.setCurativeItems((List)new ArrayList());
        }
        else {
            this.setCurativeItems(curativeItems);
        }
    }
}
