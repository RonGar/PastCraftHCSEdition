// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.pico;
import net.minecraft.util.rojd;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.entity.Entity;

public class EntityHouseCommon extends Entity implements IEntityAdditionalSpawnData
{
    public long removeTime;
    
    public EntityHouseCommon(final cuqu cuqu) {
        super(cuqu);
        this.removeTime = -1L;
        this.func_70105_a(3.0f, 2.4f);
    }
    
    protected void func_70088_a() {
        this.func_70096_w()._a(6, (Object)new String());
        this.func_70096_w()._a(7, (Object)0);
        this.func_70096_w()._a(8, (Object)0);
    }
    
    public String[] listSavedVehs() {
        return this.func_70096_w()._e(6).split("\n");
    }
    
    protected void func_70037_a(final hsus hsus) {
    }
    
    protected void func_70014_b(final hsus hsus) {
    }
    
    public rojd func_70046_E() {
        return this.field_70121_D;
    }
    
    public boolean func_70097_a(final pico pico, final float n) {
        return false;
    }
    
    public boolean func_130002_c(final EntityPlayer entityPlayer) {
        return false;
    }
    
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }
    
    public boolean isStoveEnabled() {
        return (this.func_70096_w()._a(7) & 0x1) == 0x1;
    }
    
    public boolean isStoveCharged() {
        return (this.func_70096_w()._a(7) & 0x2) == 0x2;
    }
    
    public void func_70071_h_() {
        if (!this.field_70170_p.field_72995_K && this.isStoveCharged() && this.field_70173_aa % 2 == 0) {
            this.field_70170_p.func_72869_a("explode", this.field_70165_t + -Math.cos(Math.toRadians(this.field_70177_z - 14.0f)) * 1.7, this.field_70163_u + 2.8, this.field_70161_v + -Math.sin(Math.toRadians(this.field_70177_z - 14.0f)) * 1.7, 0.0, 0.05, 0.0);
        }
    }
    
    public double func_70042_X() {
        return 0.5;
    }
    
    public void writeSpawnData(final ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeLong(this.removeTime);
        byteArrayDataOutput.writeDouble(this.field_70165_t);
        byteArrayDataOutput.writeDouble(this.field_70163_u);
        byteArrayDataOutput.writeDouble(this.field_70161_v);
    }
    
    public void readSpawnData(final ByteArrayDataInput byteArrayDataInput) {
        this.removeTime = byteArrayDataInput.readLong();
        this.field_70165_t = byteArrayDataInput.readDouble();
        this.field_70163_u = byteArrayDataInput.readDouble();
        this.field_70161_v = byteArrayDataInput.readDouble();
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }
}
