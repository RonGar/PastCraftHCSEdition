// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.gui;

import java.io.IOException;
import vintarz.core.VCP;
import net.minecraft.client.tuor;
import hcsmod.entity.EntityHouseCommon;
import net.minecraft.entity.player.EntityPlayer;

public class GuiCodeLock extends dwms
{
    private final EntityPlayer thePlayer;
    private final int entityId;
    private zfly input;
    private tdvs ok;
    private tdvs close;
    
    public GuiCodeLock(final EntityPlayer thePlayer, final int entityId) {
        this.thePlayer = thePlayer;
        this.entityId = entityId;
    }
    
    public void func_73866_w_() {
        super.func_73866_w_();
        this.field_73887_h.clear();
        this.field_73887_h.add(this.ok = new tdvs(0, this.field_73880_f / 2, this.field_73881_g / 2 + 1, 40, 20, "OK"));
        this.ok.field_73742_g = false;
        this.field_73887_h.add(this.close = new tdvs(1, this.field_73880_f / 2 - 40, this.field_73881_g / 2 + 1, 40, 20, "CLOSE"));
        (this.input = new zfly(this.field_73886_k, this.field_73880_f / 2 - 40, this.field_73881_g / 2 - 20, 80, 20))._b(true);
        this.input._f(10);
    }
    
    public void func_73876_c() {
        if (!(this.thePlayer.field_70170_p.func_73045_a(this.entityId) instanceof EntityHouseCommon)) {
            tuor._E()._a((dwms)null);
        }
    }
    
    protected void func_73875_a(final tdvs tdvs) {
        if (tdvs == this.ok) {
            this.input._c(false);
            this.ok.field_73742_g = false;
            try {
                final VCP vcp = new VCP(3, "HCSMOD");
                vcp.writeInt(this.entityId);
                vcp.writeUTF(this.input._b());
                vcp.send();
            }
            catch (IOException ex) {}
        }
        else if (tdvs == this.close) {
            tuor._E()._a((dwms)null);
        }
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        this.func_73732_a(this.field_73886_k, "\u0412\u0432\u0435\u0434\u0438 \u043f\u0430\u0440\u043e\u043b\u044c, \u043c\u0438\u043d\u0438\u043c\u0443\u043c 4 \u0441\u0438\u043c\u0432\u043e\u043b\u0430, \u043c\u043e\u0436\u043d\u043e \u043f\u0443\u0441\u0442\u043e\u0439:", this.field_73880_f / 2, this.field_73881_g / 2 - 32, 16777215);
        this.input._f();
        super.func_73863_a(n, n2, n3);
    }
    
    public boolean func_73868_f() {
        return false;
    }
    
    protected void func_73869_a(final char c, final int n) {
        this.input._a(c, n);
        this.ok.field_73742_g = (this.input._b().trim().length() >= 4 || this.input._b().trim().length() == 0);
        if (n != 28 && n != 156) {
            if (n == 1) {
                this.func_73875_a(this.close);
            }
        }
        else {
            this.func_73875_a(this.close);
        }
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) {
        super.func_73864_a(n, n2, n3);
        this.input._a(n, n2, n3);
    }
}
