// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.entity;

import hcsmod.HCS;
import net.minecraft.entity.item.EntityItem;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

public class EntityCorpse extends Entity implements ivrb
{
    public ieta[] mainItemsStored;
    public String corpsePlayerName;
    public long removeTime;
    private int opened;
    public String attacker;
    
    public EntityCorpse(final cuqu cuqu) {
        super(cuqu);
        this.mainItemsStored = new ieta[45];
        this.corpsePlayerName = "";
        this.opened = 0;
        this.attacker = "";
        this.func_70105_a(0.5f, 0.5f);
        this.field_70158_ak = true;
    }
    
    public EntityCorpse(final EntityPlayer entityPlayer, final List<EntityItem> list, final EntityPlayer entityPlayer2) {
        this(entityPlayer.field_70170_p);
        if (entityPlayer2 != null) {
            this.attacker = entityPlayer2.field_71092_bJ;
        }
        this.field_70177_z = entityPlayer.field_70177_z + 90.0f;
        this.setUsernameKilled(this.corpsePlayerName = entityPlayer.func_70023_ak());
        this.setAttacker(this.attacker);
        this.func_70107_b(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v);
        this.mainItemsStored = new ieta[Math.max(45, ((list.size() - 1) / 9 + 1) * 9)];
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) != null) {
                this.func_70299_a(i, list.get(i).func_92059_d());
            }
        }
        if (!list.isEmpty()) {
            this.removeTime = System.currentTimeMillis() + 180000L;
        }
        else {
            this.removeTime = System.currentTimeMillis() + 1000L;
        }
    }
    
    protected void func_70088_a() {
        this.field_70180_af._a(20, (Object)"");
        this.field_70180_af._a(21, (Object)0);
        this.field_70180_af._a(22, (Object)"");
    }
    
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.field_70127_C = this.field_70125_A;
        this.field_70126_B = this.field_70177_z;
        if (!this.field_70170_p.field_72995_K) {
            this.removeTime -= 150L;
            while (this.removeTime < System.currentTimeMillis()) {
                this.setLifeStage(this.getLifeStage() + 1);
                boolean b = true;
                final ieta[] mainItemsStored = this.mainItemsStored;
                for (int length = mainItemsStored.length, i = 0; i < length; ++i) {
                    if (mainItemsStored[i] != null) {
                        this.removeTime += 180000L;
                        b = false;
                        break;
                    }
                }
                if (b) {
                    this.removeTime += 1000L;
                }
            }
            if (this.getLifeStage() > 14) {
                this.func_70106_y();
                return;
            }
            if (!HCS.inEmptyChunk(this)) {
                if (!this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty()) {
                    this.func_70107_b(this.field_70165_t, this.field_70163_u + this.field_70131_O, this.field_70161_v);
                }
                else {
                    this.field_70181_x -= 0.8;
                }
                this.func_70091_d(this.field_70159_w *= 0.7, this.field_70181_x *= 0.7, this.field_70179_y *= 0.7);
            }
            final double n = this.field_70165_t - this.field_70169_q;
            final double n2 = this.field_70163_u - this.field_70167_r;
            final double n3 = this.field_70161_v - this.field_70166_s;
            this.field_70160_al = (n * n + n2 * n2 + n3 * n3 > 0.00390625);
        }
    }
    
    public void func_70106_y() {
        for (int i = 0; i < this.mainItemsStored.length; ++i) {
            if (this.opened > 0 && this.mainItemsStored[i] != null) {
                this.func_70099_a(this.mainItemsStored[i], 1.0f);
            }
            this.mainItemsStored[i] = null;
        }
        super.func_70106_y();
    }
    
    public boolean func_85031_j(final Entity entity) {
        if (!this.field_70170_p.field_72995_K) {
            this.setLifeStage(this.getLifeStage() + 3);
        }
        return false;
    }
    
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }
    
    protected void func_70037_a(final hsus hsus) {
        this.attacker = hsus._j("attacker");
        this.setUsernameKilled(this.corpsePlayerName = hsus._j("texture"));
        this.setAttacker(this.attacker);
        this.removeTime = hsus._g("removeTime");
        final tevp n = hsus._n("Items");
        this.mainItemsStored = new ieta[Math.max(45, ((n._d() - 1) / 9 + 1) * 9)];
        for (int i = 0; i < n._d(); ++i) {
            final hsus hsus2 = (hsus)n._b(i);
            final int n2 = hsus2._d("Slot") & 0xFF;
            if (n2 >= 0) {
                if (n2 < this.mainItemsStored.length) {
                    this.mainItemsStored[n2] = ieta._a(hsus2);
                }
            }
        }
    }
    
    protected void func_70014_b(final hsus hsus) {
        hsus._a("attacker", this.attacker);
        hsus._a("texture", this.corpsePlayerName);
        hsus._a("removeTime", this.removeTime);
        final tevp tevp = new tevp();
        for (int i = 0; i < this.mainItemsStored.length; ++i) {
            if (this.mainItemsStored[i] != null) {
                final hsus hsus2 = new hsus();
                hsus2._a("Slot", (byte)i);
                this.mainItemsStored[i]._b(hsus2);
                tevp._a((zxiv)hsus2);
            }
        }
        hsus._a("Items", (zxiv)tevp);
    }
    
    public void setUsernameKilled(final String s) {
        this.field_70180_af._b(20, (Object)s);
    }
    
    public void setLifeStage(final int i) {
        this.field_70180_af._b(21, (Object)i);
    }
    
    public void setAttacker(final String s) {
        this.field_70180_af._b(22, (Object)s);
    }
    
    public String getUsernameKilled() {
        return this.field_70180_af._e(20);
    }
    
    public int getLifeStage() {
        return this.field_70180_af._c(21);
    }
    
    public String getAttacker() {
        return this.field_70180_af._e(22);
    }
    
    public int func_70302_i_() {
        return this.mainItemsStored.length;
    }
    
    public ieta func_70301_a(final int n) {
        return this.mainItemsStored[n];
    }
    
    public ieta func_70298_a(final int n, final int n2) {
        if (this.mainItemsStored[n] == null) {
            return null;
        }
        if (this.mainItemsStored[n]._b <= n2) {
            final ieta ieta = this.mainItemsStored[n];
            this.mainItemsStored[n] = null;
            return ieta;
        }
        final ieta a = this.mainItemsStored[n]._a(n2);
        if (this.mainItemsStored[n]._b == 0) {
            this.mainItemsStored[n] = null;
        }
        return a;
    }
    
    public ieta func_70304_b(final int n) {
        if (this.mainItemsStored[n] != null) {
            final ieta ieta = this.mainItemsStored[n];
            this.mainItemsStored[n] = null;
            return ieta;
        }
        return null;
    }
    
    public void func_70299_a(final int n, final ieta ieta) {
        this.mainItemsStored[n] = ieta;
        if (ieta != null && ieta._b > this.func_70297_j_()) {
            ieta._b = this.func_70297_j_();
        }
    }
    
    public String func_70303_b() {
        return this.getUsernameKilled() + "'s Corpse";
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
        return !this.field_70128_L && entityPlayer.func_70068_e((Entity)this) <= 64.0;
    }
    
    public void func_70295_k_() {
        ++this.opened;
    }
    
    public void func_70305_f() {
        --this.opened;
    }
    
    public boolean func_94041_b(final int n, final ieta ieta) {
        return false;
    }
}
