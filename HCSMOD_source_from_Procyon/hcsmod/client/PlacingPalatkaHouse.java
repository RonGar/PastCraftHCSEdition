// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import net.minecraft.entity.Entity;

public class PlacingPalatkaHouse extends Entity
{
    public boolean placeAllowed;
    public boolean house;
    public int age;
    
    public PlacingPalatkaHouse(final cuqu cuqu) {
        super(cuqu);
        this.placeAllowed = false;
        this.house = false;
        this.func_70105_a(3.0f, 1.0f);
    }
    
    public PlacingPalatkaHouse(final cuqu cuqu, final double n, final double n2, final double n3, final float n4, final boolean house) {
        this(cuqu);
        this.func_70080_a(n, n2, n3, n4, 0.0f);
        if (house) {
            this.func_70105_a(3.0f, 2.5f);
        }
        this.house = house;
    }
    
    protected void func_70088_a() {
    }
    
    protected void func_70037_a(final hsus hsus) {
    }
    
    protected void func_70014_b(final hsus hsus) {
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (++this.age > 2) {
            this.func_70106_y();
        }
    }
}
