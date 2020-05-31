// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.cunches;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public interface IVehicle
{
    String vehName();
    
    void setDriver(final EntityPlayer p0);
    
    boolean hasDriver();
    
    Entity entity();
}
