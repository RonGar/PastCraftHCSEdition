// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.dwbg;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;

@SideOnly(Side.CLIENT)
public class ModelZombie extends ModelBiped
{
    public void func_78087_a(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final Entity entity) {
        super.func_78087_a(n, n2, n3, n4, n5, n6, entity);
        final float a = dwbg._a(super.field_78095_p * 3.1415927f);
        final float a2 = dwbg._a((1.0f - (1.0f - super.field_78095_p) * (1.0f - super.field_78095_p)) * 3.1415927f);
        super.field_78112_f.field_78808_h = 0.0f;
        super.field_78113_g.field_78808_h = 0.0f;
        super.field_78112_f.field_78796_g = -(0.1f - a * 0.6f);
        super.field_78113_g.field_78796_g = 0.1f - a * 0.6f;
        super.field_78112_f.field_78795_f = -1.5707964f;
        super.field_78113_g.field_78795_f = -1.5707964f;
        final ModelRenderer field_78112_f = super.field_78112_f;
        field_78112_f.field_78795_f -= a * 1.2f - a2 * 0.4f;
        final ModelRenderer field_78113_g = super.field_78113_g;
        field_78113_g.field_78795_f -= a * 1.2f - a2 * 0.4f;
        final ModelRenderer field_78112_f2 = super.field_78112_f;
        field_78112_f2.field_78808_h += dwbg._b(n3 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_78113_g2 = super.field_78113_g;
        field_78113_g2.field_78808_h -= dwbg._b(n3 * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer field_78112_f3 = super.field_78112_f;
        field_78112_f3.field_78795_f += dwbg._a(n3 * 0.067f) * 0.05f;
        final ModelRenderer field_78113_g3 = super.field_78113_g;
        field_78113_g3.field_78795_f -= dwbg._a(n3 * 0.067f) * 0.05f;
    }
}
