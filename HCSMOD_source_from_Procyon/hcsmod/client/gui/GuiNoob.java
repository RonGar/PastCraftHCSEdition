// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.gui;

import org.lwjgl.opengl.GL11;
import net.minecraft.util.ResourceLocation;

public class GuiNoob extends dwms
{
    private static final ResourceLocation rs;
    private static final double aspect_ratio = 1.0;
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        func_73734_a(0, 0, this.field_73880_f, this.field_73881_g, -14540254);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        this.field_73882_e._f._a(GuiNoob.rs);
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a(this.field_73880_f / 2.0 - this.field_73881_g / 2.0 * 1.0, (double)this.field_73881_g, 0.0, 0.0, 1.0);
        field_78398_a.func_78374_a(this.field_73880_f / 2.0 + this.field_73881_g / 2.0 * 1.0, (double)this.field_73881_g, 0.0, 1.0, 1.0);
        field_78398_a.func_78374_a(this.field_73880_f / 2.0 + this.field_73881_g / 2.0 * 1.0, 0.0, 0.0, 1.0, 0.0);
        field_78398_a.func_78374_a(this.field_73880_f / 2.0 - this.field_73881_g / 2.0 * 1.0, 0.0, 0.0, 0.0, 0.0);
        field_78398_a.func_78381_a();
        super.func_73863_a(n, n2, n3);
    }
    
    protected void func_73869_a(final char c, final int n) {
        this.field_73882_e._a((dwms)new GuiHcsMenu());
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) {
        this.func_73869_a(' ', 0);
    }
    
    static {
        rs = new ResourceLocation("hcsmod:noob.png");
    }
}
