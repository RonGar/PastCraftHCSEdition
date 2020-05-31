// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;

public class InteractableRenderDummy extends Entity
{
    public static final InteractableRenderDummy instance;
    
    private InteractableRenderDummy() {
        super((cuqu)tuor._E()._p);
        this.field_70158_ak = true;
        this.func_70105_a(16.0f, 16.0f);
    }
    
    public void func_70071_h_() {
        this.field_70157_k = -1;
    }
    
    protected void func_70088_a() {
    }
    
    protected void func_70037_a(final hsus hsus) {
    }
    
    protected void func_70014_b(final hsus hsus) {
    }
    
    static {
        instance = new InteractableRenderDummy();
    }
}
