// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import net.minecraft.util.rojd;

public interface HcsInteractable
{
    rojd boundingBox();
    
    void interactWith();
    
    void render(final float p0);
    
    String name();
}
