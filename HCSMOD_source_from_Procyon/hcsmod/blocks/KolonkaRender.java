// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.tuor;
import org.lwjgl.opengl.GL11;

public class KolonkaRender extends jhhk
{
    private final KolonkaModel model;
    
    public KolonkaRender() {
        this.model = new KolonkaModel();
    }
    
    private void adjustRotatePivotViaMeta(final cuqu cuqu, final int n, final int n2, final int n3) {
        final int func_72805_g = cuqu.func_72805_g(n, n2, n3);
        GL11.glPushMatrix();
        GL11.glRotatef((float)(func_72805_g * -90), 0.0f, 0.0f, 1.0f);
        GL11.glPopMatrix();
    }
    
    public void func_76894_a(final ogpr ogpr, final double n, final double n2, final double n3, final float n4) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)n + 0.5f, (float)n2 + 1.5f, (float)n3 + 0.5f);
        tuor._E()._f._a(new ResourceLocation("hcsmod:textures/kolonka.png"));
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        this.model.render(0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
    
    private void adjustLightFixture(final cuqu cuqu, final int n, final int n2, final int n3, final kjsv kjsv) {
        final uheb field_78398_a = uheb.field_78398_a;
        final float func_71870_f = kjsv.func_71870_f((dxti)cuqu, n, n2, n3);
        final int func_72802_i = cuqu.func_72802_i(n, n2, n3, 0);
        final int n4 = func_72802_i % 65536;
        final int n5 = func_72802_i / 65536;
        field_78398_a.func_78386_a(func_71870_f, func_71870_f, func_71870_f);
        wngx._a(wngx._b, (float)n4, (float)n5);
    }
}
