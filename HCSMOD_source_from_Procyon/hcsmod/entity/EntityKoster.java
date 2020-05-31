// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import vintarz.core.VSP;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.rojd;
import hcsmod.blocks.HCSBlocks;
import hcsmod.flashlight.FlashlightClient;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.entity.Entity;

public class EntityKoster extends Entity implements IEntityAdditionalSpawnData
{
    private final FlashlightClient.LightPoint light;
    int fireTime;
    long placed;
    public int blockX;
    public int blockY;
    public int blockZ;
    
    public EntityKoster(final cuqu cuqu) {
        super(cuqu);
        this.light = new FlashlightClient.LightPoint(0.0f) {
            @Override
            public void update() {
                super.update();
                if (EntityKoster.this.field_70170_p.func_72799_c(EntityKoster.this.blockX, EntityKoster.this.blockY, EntityKoster.this.blockZ)) {
                    EntityKoster.this.field_70170_p.func_94575_c(EntityKoster.this.blockX, EntityKoster.this.blockY, EntityKoster.this.blockZ, HCSBlocks.koster.field_71990_ca);
                }
            }
            
            @Override
            protected void onDeath() {
                if (EntityKoster.this.field_70170_p.func_72798_a(EntityKoster.this.blockX, EntityKoster.this.blockY, EntityKoster.this.blockZ) == HCSBlocks.koster.field_71990_ca) {
                    EntityKoster.this.field_70170_p.func_94571_i(EntityKoster.this.blockX, EntityKoster.this.blockY, EntityKoster.this.blockZ);
                }
            }
        };
        this.fireTime = 0;
        this.func_70105_a(2.0f, 0.4f);
    }
    
    public EntityKoster(final cuqu cuqu, final double n, final double n2, final double n3, final float n4) {
        this(cuqu);
        this.func_70080_a(n, n2, n3, n4, 0.0f);
    }
    
    protected void func_70088_a() {
        this.func_70096_w()._a(2, (Object)0);
    }
    
    public boolean isActive() {
        return this.func_70096_w()._a(2) == 1;
    }
    
    private void setActive(final boolean b) {
        this.placed = System.currentTimeMillis();
        this.func_70096_w()._b(2, (Object)(byte)(b ? 1 : 0));
    }
    
    protected void func_70037_a(final hsus hsus) {
        this.setActive(hsus._o("isFire"));
        this.placed = hsus._g("placed");
        this.blockX = hsus._f("bX");
        this.blockY = hsus._f("bY");
        this.blockZ = hsus._f("bZ");
    }
    
    protected void func_70014_b(final hsus hsus) {
        hsus._a("isFire", this.isActive());
        hsus._a("placed", this.placed);
        hsus._a("bX", this.blockX);
        hsus._a("bY", this.blockY);
        hsus._a("bZ", this.blockZ);
    }
    
    public rojd func_70046_E() {
        return this.field_70121_D;
    }
    
    public boolean func_130002_c(final EntityPlayer entityPlayer) {
        if (!this.field_70170_p.field_72995_K && entityPlayer.func_71045_bC() != null) {
            final ieta func_71045_bC = entityPlayer.func_71045_bC();
            if (!this.isActive() && func_71045_bC._d == jhvs.field_77709_i.field_77779_bT) {
                this.setActive(true);
                this.field_70170_p.func_72956_a((Entity)this, "fire.ignite", 1.0f, 1.8f);
                entityPlayer.func_71045_bC()._a(1, (EntityLivingBase)entityPlayer);
                return true;
            }
            if (this.isActive() && func_71045_bC._d == jhvs.field_77784_aq.field_77779_bT) {
                final ieta ieta = func_71045_bC;
                --ieta._b;
                entityPlayer.func_71021_b(new ieta(jhvs.field_77782_ar)).field_70293_c = 0;
                return true;
            }
            if (this.isActive() && func_71045_bC._d == jhvs.field_77741_bi.field_77779_bT) {
                final ieta ieta2 = func_71045_bC;
                --ieta2._b;
                entityPlayer.func_71021_b(new ieta(jhvs.field_77734_bj)).field_70293_c = 0;
                return true;
            }
            if (this.isActive() && func_71045_bC._d == jhvs.field_77735_bk.field_77779_bT) {
                final ieta ieta3 = func_71045_bC;
                --ieta3._b;
                entityPlayer.func_71021_b(new ieta(jhvs.field_77736_bl)).field_70293_c = 0;
                return true;
            }
            if (this.isActive() && func_71045_bC._d == jhvs.field_77754_aU.field_77779_bT) {
                final ieta ieta4 = func_71045_bC;
                --ieta4._b;
                entityPlayer.func_71021_b(new ieta(jhvs.field_77753_aV)).field_70293_c = 0;
                return true;
            }
            if (func_71045_bC._d == jhvs.field_77726_bs.field_77779_bT) {
                final ieta ieta5 = func_71045_bC;
                --ieta5._b;
                if (!entityPlayer.field_71075_bZ._d) {
                    entityPlayer.func_71021_b(new ieta(jhvs.field_77729_bt)).field_70293_c = 0;
                }
                new Random();
                if (this.isActive()) {
                    try {
                        final VSP vsp = new VSP(3, "HCSMOD");
                        vsp.writeDouble(this.field_70165_t);
                        vsp.writeDouble(this.field_70163_u);
                        vsp.writeDouble(this.field_70161_v);
                        vsp.sendAllInRange(this.field_70170_p, 32, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    }
                    catch (Exception ex) {}
                }
                this.func_70106_y();
                return true;
            }
        }
        return false;
    }
    
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }
    
    public void func_70071_h_() {
        if (this.placed == 0L) {
            this.placed = System.currentTimeMillis();
        }
        if (!this.field_70170_p.field_72995_K && this.placed < System.currentTimeMillis() - 2400000L) {
            this.func_70106_y();
            return;
        }
        if (!this.isActive()) {
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            this.light.update(this.blockX, this.blockY, this.blockZ);
        }
    }
    
    public void writeSpawnData(final ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeInt(this.blockX);
        byteArrayDataOutput.writeInt(this.blockY);
        byteArrayDataOutput.writeInt(this.blockZ);
        byteArrayDataOutput.writeDouble(this.field_70165_t);
        byteArrayDataOutput.writeDouble(this.field_70163_u);
        byteArrayDataOutput.writeDouble(this.field_70161_v);
    }
    
    public void readSpawnData(final ByteArrayDataInput byteArrayDataInput) {
        this.blockX = byteArrayDataInput.readInt();
        this.blockY = byteArrayDataInput.readInt();
        this.blockZ = byteArrayDataInput.readInt();
        this.field_70165_t = byteArrayDataInput.readDouble();
        this.field_70163_u = byteArrayDataInput.readDouble();
        this.field_70161_v = byteArrayDataInput.readDouble();
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }
}
