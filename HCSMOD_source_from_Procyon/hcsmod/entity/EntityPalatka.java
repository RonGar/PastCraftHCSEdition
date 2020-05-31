// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import hcsmod.effects.Effect;
import net.minecraft.entity.item.EntityItem;
import hcsmod.HCS;
import net.minecraft.util.pico;
import net.minecraft.util.rojd;
import net.minecraft.entity.player.EntityPlayer;
import hcsmod.server.HcsServer;
import net.minecraft.util.hrmy;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.entity.Entity;

public class EntityPalatka extends Entity implements IEntityAdditionalSpawnData, ivrb
{
    static final hrmy dupe_warning;
    private String lastUser;
    private String placedBy;
    private int hitNum;
    private int hitTime;
    public Object oops;
    public double playerX;
    public double playerY;
    public double playerZ;
    public ieta[] inventory;
    
    public EntityPalatka(final cuqu cuqu) {
        super(cuqu);
        this.lastUser = "unknown";
        this.placedBy = "unknown";
        this.inventory = new ieta[36];
        this.func_70105_a(2.5f, 1.5f);
        if (!this.field_70170_p.field_72995_K && HcsServer.isPVPserver) {
            super.field_70128_L = true;
        }
    }
    
    public EntityPalatka(final EntityPlayer entityPlayer, final double n, final double n2, final double n3, final float n4) {
        this(entityPlayer.field_70170_p);
        this.placedBy = entityPlayer.field_71092_bJ;
        this.func_70080_a(n, n2, n3, n4, 0.0f);
    }
    
    protected void func_70088_a() {
    }
    
    protected void func_70037_a(final hsus hsus) {
        this.playerX = hsus._i("playerX");
        this.playerY = hsus._i("playerY");
        this.playerZ = hsus._i("playerZ");
        this.lastUser = hsus._j("lastUser");
        this.placedBy = hsus._j("placedBy");
        final tevp n = hsus._n("Items");
        this.inventory = new ieta[this.func_70302_i_()];
        for (int i = 0; i < n._d(); ++i) {
            final hsus hsus2 = (hsus)n._b(i);
            final int n2 = hsus2._d("Slot") & 0xFF;
            if (n2 >= 0 && n2 < this.inventory.length) {
                this.inventory[n2] = ieta._a(hsus2);
            }
        }
    }
    
    protected void func_70014_b(final hsus hsus) {
        hsus._a("playerX", this.playerX);
        hsus._a("playerY", this.playerY);
        hsus._a("playerZ", this.playerZ);
        hsus._a("lastUser", this.lastUser);
        hsus._a("placedBy", this.placedBy);
        final tevp tevp = new tevp();
        for (int i = 0; i < this.inventory.length; ++i) {
            if (this.inventory[i] != null) {
                final hsus hsus2 = new hsus();
                hsus2._a("Slot", (byte)i);
                this.inventory[i]._b(hsus2);
                tevp._a((zxiv)hsus2);
            }
        }
        hsus._a("Items", (zxiv)tevp);
    }
    
    public rojd func_70046_E() {
        return this.field_70121_D;
    }
    
    public boolean func_70097_a(final pico pico, final float n) {
        if (this.field_70170_p.field_72995_K || this.field_70128_L || this.field_70153_n != null || !(pico.func_76346_g() instanceof EntityPlayer)) {
            return true;
        }
        final EntityPlayer entityPlayer = (EntityPlayer)pico.func_76346_g();
        if (entityPlayer.func_70068_e((Entity)this) > 16.0) {
            return false;
        }
        this.hitTime = 20;
        ++this.hitNum;
        if (this.hitNum < 10) {
            return true;
        }
        if (!entityPlayer.field_71075_bZ._d) {
            this.func_70025_b(HCS.Palatka.field_77779_bT, 1);
        }
        for (int i = 0; i < this.inventory.length; ++i) {
            if (this.inventory[i] != null) {
                final EntityItem entityItem = new EntityItem(this.field_70170_p, this.field_70165_t + (this.field_70146_Z.nextFloat() * 0.8f + 0.1f), this.field_70163_u + (this.field_70146_Z.nextFloat() * 0.8f + 0.1f), this.field_70161_v + (this.field_70146_Z.nextFloat() * 0.8f + 0.1f), this.inventory[i]._l());
                this.inventory[i] = null;
                entityItem.field_70159_w = (float)this.field_70146_Z.nextGaussian() * 0.05f;
                entityItem.field_70181_x = (float)this.field_70146_Z.nextGaussian() * 0.05f + 0.2f;
                entityItem.field_70179_y = (float)this.field_70146_Z.nextGaussian() * 0.05f;
                this.field_70170_p.func_72838_d((Entity)entityItem);
            }
        }
        this.func_70106_y();
        return true;
    }
    
    public boolean func_130002_c(final EntityPlayer entityPlayer) {
        if (this.field_70170_p.field_72995_K || !entityPlayer.func_70089_S()) {
            return false;
        }
        final ieta func_71045_bC = entityPlayer.func_71045_bC();
        if (func_71045_bC != null && func_71045_bC._d == 510) {
            entityPlayer.func_70006_a(hrmy._d("Owner(\"" + this.placedBy + "\"); LastUser(\"" + this.lastUser + "\");"));
            return true;
        }
        this.lastUser = entityPlayer.field_71092_bJ;
        if (entityPlayer == this.field_70153_n) {
            entityPlayer.func_71007_a((ivrb)this);
            return true;
        }
        if (entityPlayer.func_70093_af()) {
            entityPlayer.func_71007_a((ivrb)this);
            return true;
        }
        if (this.field_70153_n == null) {
            entityPlayer.func_70095_a(false);
            this.playerX = entityPlayer.field_70165_t;
            this.playerY = entityPlayer.field_70163_u;
            this.playerZ = entityPlayer.field_70161_v;
            entityPlayer.func_70078_a((Entity)this);
            return true;
        }
        return false;
    }
    
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }
    
    public void func_70071_h_() {
        if (this.hitNum > 0 && --this.hitTime < 0) {
            this.hitTime = 0;
            this.hitNum = 0;
        }
        if (!this.field_70170_p.field_72995_K) {
            HcsServer.tickPalatka(this);
        }
        if (this.field_70153_n instanceof EntityPlayer) {
            final EntityPlayer entityPlayer = (EntityPlayer)this.field_70153_n;
            if (entityPlayer.func_70660_b((lodj)Effect.bleeding) != null) {
                final kldu func_70660_b = entityPlayer.func_70660_b((lodj)Effect.bleeding);
                func_70660_b.field_76460_b -= 9;
            }
            if (entityPlayer.func_70660_b(lodj.field_76421_d) != null) {
                final kldu func_70660_b2 = entityPlayer.func_70660_b(lodj.field_76421_d);
                func_70660_b2.field_76460_b -= 9;
            }
        }
    }
    
    public double func_70042_X() {
        return -0.1;
    }
    
    public int func_70302_i_() {
        return this.inventory.length;
    }
    
    public ieta func_70301_a(final int n) {
        return this.inventory[n];
    }
    
    public ieta func_70298_a(final int n, final int n2) {
        if (this.inventory[n] == null) {
            return null;
        }
        if (this.inventory[n]._b <= n2) {
            final ieta ieta = this.inventory[n];
            this.inventory[n] = null;
            return ieta;
        }
        final ieta a = this.inventory[n]._a(n2);
        if (this.inventory[n]._b == 0) {
            this.inventory[n] = null;
        }
        return a;
    }
    
    public ieta func_70304_b(final int n) {
        if (this.inventory[n] != null) {
            final ieta ieta = this.inventory[n];
            this.inventory[n] = null;
            return ieta;
        }
        return null;
    }
    
    public void func_70299_a(final int n, final ieta ieta) {
        this.inventory[n] = ieta;
        if (ieta != null && ieta._b > this.func_70297_j_()) {
            ieta._b = this.func_70297_j_();
        }
    }
    
    public String func_70303_b() {
        return "Palatka";
    }
    
    public boolean func_94042_c() {
        return false;
    }
    
    public int func_70297_j_() {
        return 64;
    }
    
    public void func_70296_d() {
    }
    
    public boolean func_70300_a(final EntityPlayer entityPlayer) {
        return !this.field_70128_L && entityPlayer.func_70068_e((Entity)this) <= 16.0;
    }
    
    public boolean func_94041_b(final int n, final ieta ieta) {
        return true;
    }
    
    public void func_70295_k_() {
    }
    
    public void func_70305_f() {
    }
    
    public void writeSpawnData(final ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeDouble(this.field_70165_t);
        byteArrayDataOutput.writeDouble(this.field_70163_u);
        byteArrayDataOutput.writeDouble(this.field_70161_v);
    }
    
    public void readSpawnData(final ByteArrayDataInput byteArrayDataInput) {
        this.field_70165_t = byteArrayDataInput.readDouble();
        this.field_70163_u = byteArrayDataInput.readDouble();
        this.field_70161_v = byteArrayDataInput.readDouble();
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }
    
    static {
        dupe_warning = hrmy._d("\u0414\u0440\u0443\u0433\u043e\u0439 \u0438\u0433\u0440\u043e\u043a \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u0431\u043b\u0438\u0437\u043a\u043e!");
    }
}
