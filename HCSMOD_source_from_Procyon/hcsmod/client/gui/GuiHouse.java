// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.gui;

import org.lwjgl.opengl.GL11;
import java.io.IOException;
import vintarz.core.VCP;
import java.util.Iterator;
import java.util.List;
import hcsmod.cunches.IVehicle;
import net.minecraft.entity.Entity;
import net.minecraft.client.tuor;
import hcsmod.entity.EntityHouseCommon;
import net.minecraft.util.ResourceLocation;

public class GuiHouse extends zwlp
{
    private static final ResourceLocation field_110421_t;
    private ivrb upperChestInventory;
    private ivrb lowerChestInventory;
    private String kek;
    private EntityHouseCommon house;
    private final tdvs stoveButton;
    private int inventoryRows;
    
    public GuiHouse(final ivrb upperChestInventory, final ivrb lowerChestInventory) {
        super((ivrt)new rpkb(upperChestInventory, lowerChestInventory));
        this.stoveButton = new tdvs(0, 0, 0, 100, 20, "");
        this.field_73882_e = tuor._E();
        this.upperChestInventory = upperChestInventory;
        this.lowerChestInventory = lowerChestInventory;
        this.field_73885_j = false;
        this.inventoryRows = lowerChestInventory.func_70302_i_() / 9;
        this.field_74195_c = 114 + this.inventoryRows * 18;
        this.kek = this.lowerChestInventory.func_70303_b();
        final int index = this.kek.indexOf(58);
        this.house = (EntityHouseCommon)this.field_73882_e._p.func_73045_a(Integer.parseInt(this.kek.substring(3, index)));
        this.kek = this.kek.substring(index + 1);
    }
    
    public void func_73876_c() {
        final List func_94576_a = this.field_73882_e._p.func_94576_a((Entity)this.house, this.house.field_70121_D.func_72314_b(24.0, 24.0, 24.0), (mquq)new mquq() {
            public boolean func_82704_a(final Entity entity) {
                return entity instanceof IVehicle && !((IVehicle)entity).hasDriver() && GuiHouse.this.house.func_70032_d(entity) < 24.0;
            }
        });
        this.field_73887_h.clear();
        final String[] listSavedVehs = this.house.listSavedVehs();
        int n = -10;
        int n2 = 0;
        for (final String s : listSavedVehs) {
            if (!s.isEmpty()) {
                final List field_73887_h = this.field_73887_h;
                final int n3 = --n2;
                final int n4 = 0;
                n += 20;
                field_73887_h.add(new tdvs(n3, n4, n, 100, 20, s));
            }
        }
        int n5 = -10;
        for (final IVehicle vehicle : func_94576_a) {
            final List field_73887_h2 = this.field_73887_h;
            final int field_70157_k = vehicle.entity().field_70157_k;
            final int n6 = this.field_73880_f - 100;
            n5 += 20;
            field_73887_h2.add(new tdvs(field_70157_k, n6, n5, 100, 20, vehicle.vehName()));
        }
        this.field_73887_h.add(this.stoveButton);
        this.stoveButton.field_73746_c = this.field_73880_f - 100;
        this.stoveButton.field_73743_d = this.field_73881_g - 20;
        if (tuor._E()._r.field_70154_o == this.house) {
            this.stoveButton.field_73742_g = true;
            this.stoveButton.field_73744_e = (this.house.isStoveEnabled() ? "\u041f\u043e\u0433\u0430\u0441\u0438\u0442\u044c \u043f\u0435\u0447\u044c" : "\u0417\u0430\u0436\u0435\u0447\u044c \u043f\u0435\u0447\u044c");
        }
        else {
            this.stoveButton.field_73742_g = false;
            this.stoveButton.field_73744_e = "\u0421\u044f\u0434\u044c \u0432 \u0434\u043e\u043c";
        }
    }
    
    protected void func_73875_a(final tdvs tdvs) {
        if (tdvs == this.stoveButton) {
            new VCP(9, "HCSMOD").send();
            return;
        }
        final Iterator<tdvs> iterator = (Iterator<tdvs>)this.field_73887_h.iterator();
        while (iterator.hasNext()) {
            iterator.next().field_73742_g = false;
        }
        if (tdvs.field_73741_f >= 0) {
            try {
                final VCP vcp = new VCP(2, "HCSMOD");
                vcp.writeInt(tdvs.field_73741_f);
                vcp.send();
            }
            catch (IOException ex) {}
        }
        else {
            final int n = -1 - tdvs.field_73741_f;
            try {
                final VCP vcp2 = new VCP(4, "HCSMOD");
                vcp2.writeInt(n);
                vcp2.send();
            }
            catch (IOException ex2) {}
        }
    }
    
    protected void func_74189_g(final int n, final int n2) {
        this.field_73886_k._b(this.kek, 8, 6, 4210752);
        this.field_73886_k._b(this.upperChestInventory.func_94042_c() ? this.upperChestInventory.func_70303_b() : kkkz._a(this.upperChestInventory.func_70303_b()), 8, this.field_74195_c - 96 + 2, 4210752);
        this.field_73886_k._b("\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u043d\u044b\u0439 \u0442\u0440\u0430\u043d\u0441\u043f\u043e\u0440\u0442", 1 - this.field_74198_m, 1 - this.field_74197_n, 16777215);
        final String s = "\u0422\u0440\u0430\u043d\u0441\u043f\u043e\u0440\u0442 \u043e\u043a\u043e\u043b\u043e \u0434\u043e\u043c\u0430";
        this.field_73886_k._b(s, -this.field_74198_m + this.field_73880_f - this.field_73886_k._b(s), 1 - this.field_74197_n, 16777215);
        this.field_73886_k._b(this.house.isStoveCharged() ? "\u041f\u0435\u0447\u044c \u0442\u043e\u043f\u0438\u0442\u0441\u044f" : "\u041d\u0435\u0442 \u0442\u043e\u043f\u043b\u0438\u0432\u0430", 1 - this.field_74198_m, -10 - this.field_74197_n + this.field_73881_g, 16777215);
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        super.func_73863_a(n, n2, n3);
    }
    
    protected void func_74185_a(final float n, final int n2, final int n3) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(GuiHouse.field_110421_t);
        final int n4 = (this.field_73880_f - this.field_74194_b) / 2;
        final int n5 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n4, n5, 0, 0, this.field_74194_b, this.inventoryRows * 18 + 17);
        this.func_73729_b(n4, n5 + this.inventoryRows * 18 + 17, 0, 126, this.field_74194_b, 96);
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) {
        super.func_73864_a(n, n2, n3);
    }
    
    static {
        field_110421_t = new ResourceLocation("textures/gui/container/generic_54.png");
    }
}
