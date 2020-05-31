// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import java.util.ArrayList;
import org.lwjgl.opengl.GL11;
import java.io.IOException;
import vintarz.core.VCP;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import java.util.Iterator;
import net.minecraft.util.ResourceLocation;
import java.util.List;

public class GuiSpawnSelect extends dwms
{
    public static final GuiSpawnSelect instance;
    public static final List<SpawnPoint> spawns;
    private static final ResourceLocation rs;
    private static final String str_rnd = "\u0421\u043b\u0443\u0447\u0430\u0439\u043d\u043e\u0435 \u043c\u0435\u0441\u0442\u043e \u043d\u0430 \u0431\u0435\u0440\u0435\u0433\u0443";
    
    private GuiSpawnSelect() {
    }
    
    public static GuiSpawnSelect instance() {
        GuiSpawnSelect.spawns.clear();
        return GuiSpawnSelect.instance;
    }
    
    public void func_73866_w_() {
        super.func_73866_w_();
        this.field_73887_h.clear();
        final int b = this.field_73882_e._x._b("\u0421\u043b\u0443\u0447\u0430\u0439\u043d\u043e\u0435 \u043c\u0435\u0441\u0442\u043e \u043d\u0430 \u0431\u0435\u0440\u0435\u0433\u0443");
        this.field_73887_h.add(0, new tdvs(0, (int)(this.field_73880_f / 2.0) - b / 2, 1, b + 10, 20, "\u0421\u043b\u0443\u0447\u0430\u0439\u043d\u043e\u0435 \u043c\u0435\u0441\u0442\u043e \u043d\u0430 \u0431\u0435\u0440\u0435\u0433\u0443"));
        for (final SpawnPoint spawnPoint : GuiSpawnSelect.spawns) {
            final int b2 = this.field_73882_e._x._b(spawnPoint.text);
            final tdvs tdvs = new tdvs(0, (int)(this.field_73880_f / 2.05 + this.field_73881_g * spawnPoint.x / 250.0) - b2 / 2, (int)(this.field_73881_g / 1.775 + this.field_73881_g * spawnPoint.z / 250.0), b2 + 10, 20, spawnPoint.text);
            try {
                Integer.parseInt(spawnPoint.text);
                tdvs.field_73742_g = false;
            }
            catch (Throwable t) {}
            this.field_73887_h.add(tdvs);
        }
    }
    
    public void func_73876_c() {
        final EntityClientPlayerMP r = tuor._E()._r;
        if (r == null || ((EntityPlayer)r).field_70165_t * ((EntityPlayer)r).field_70165_t + (((EntityPlayer)r).field_70163_u - 1.0) * (((EntityPlayer)r).field_70163_u - 1.0) + ((EntityPlayer)r).field_70161_v * ((EntityPlayer)r).field_70161_v > 25.0) {
            tuor._E()._a((dwms)null);
        }
    }
    
    protected void func_73875_a(final tdvs tdvs) {
        final EntityClientPlayerMP r = tuor._E()._r;
        if (r != null) {
            if (tdvs.field_73744_e == "\u0421\u043b\u0443\u0447\u0430\u0439\u043d\u043e\u0435 \u043c\u0435\u0441\u0442\u043e \u043d\u0430 \u0431\u0435\u0440\u0435\u0433\u0443") {
                ((EntityPlayer)r).field_70181_x = 1.0;
                final double n = ((EntityPlayer)r).field_70165_t + 0.10000000149011612;
                final double n2 = ((EntityPlayer)r).field_70161_v + 0.10000000149011612;
                final double n3 = n * n + n2 * n2;
                final double field_70159_w = n / n3;
                final double field_70179_y = n2 / n3;
                ((EntityPlayer)r).field_70159_w = field_70159_w;
                ((EntityPlayer)r).field_70179_y = field_70179_y;
            }
            try {
                final VCP vcp = new VCP(5, "HCSMOD");
                vcp.writeUTF((tdvs.field_73744_e == "\u0421\u043b\u0443\u0447\u0430\u0439\u043d\u043e\u0435 \u043c\u0435\u0441\u0442\u043e \u043d\u0430 \u0431\u0435\u0440\u0435\u0433\u0443") ? "" : tdvs.field_73744_e);
                vcp.send();
            }
            catch (IOException ex) {}
        }
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        func_73734_a(0, 0, this.field_73880_f, this.field_73881_g, -14540254);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        this.field_73882_e._f._a(GuiSpawnSelect.rs);
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a(this.field_73880_f / 2.0 - this.field_73881_g / 2.0 * 1.0985567010309278, (double)this.field_73881_g, 0.0, 0.0, 1.0);
        field_78398_a.func_78374_a(this.field_73880_f / 2.0 + this.field_73881_g / 2.0 * 1.0985567010309278, (double)this.field_73881_g, 0.0, 1.0, 1.0);
        field_78398_a.func_78374_a(this.field_73880_f / 2.0 + this.field_73881_g / 2.0 * 1.0985567010309278, 0.0, 0.0, 1.0, 0.0);
        field_78398_a.func_78374_a(this.field_73880_f / 2.0 - this.field_73881_g / 2.0 * 1.0985567010309278, 0.0, 0.0, 0.0, 0.0);
        field_78398_a.func_78381_a();
        super.func_73863_a(n, n2, n3);
    }
    
    public boolean func_73868_f() {
        return false;
    }
    
    static {
        instance = new GuiSpawnSelect();
        spawns = new ArrayList<SpawnPoint>();
        rs = new ResourceLocation("hcsmod:map.png");
    }
    
    public static class SpawnPoint
    {
        public final String text;
        public final int x;
        public final int z;
        
        public SpawnPoint(final String text, final int x, final int z) {
            this.text = text;
            this.x = x;
            this.z = z;
        }
    }
}
