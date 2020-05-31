// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.client.model.ModelBox;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class NoDlModerRenderer
{
    public static void render(final ModelRenderer modelRenderer, final float n) {
        GL11.glTranslatef(modelRenderer.field_82906_o, modelRenderer.field_82908_p, modelRenderer.field_82907_q);
        if (modelRenderer.field_78795_f == 0.0f && modelRenderer.field_78796_g == 0.0f && modelRenderer.field_78808_h == 0.0f) {
            if (modelRenderer.field_78800_c == 0.0f && modelRenderer.field_78797_d == 0.0f && modelRenderer.field_78798_e == 0.0f) {
                actuallyRender(modelRenderer, n);
                if (modelRenderer.field_78805_m != null) {
                    for (int i = 0; i < modelRenderer.field_78805_m.size(); ++i) {
                        ((ModelRenderer)modelRenderer.field_78805_m.get(i)).func_78785_a(n);
                    }
                }
            }
            else {
                GL11.glTranslatef(modelRenderer.field_78800_c * n, modelRenderer.field_78797_d * n, modelRenderer.field_78798_e * n);
                actuallyRender(modelRenderer, n);
                if (modelRenderer.field_78805_m != null) {
                    for (int j = 0; j < modelRenderer.field_78805_m.size(); ++j) {
                        ((ModelRenderer)modelRenderer.field_78805_m.get(j)).func_78785_a(n);
                    }
                }
                GL11.glTranslatef(-modelRenderer.field_78800_c * n, -modelRenderer.field_78797_d * n, -modelRenderer.field_78798_e * n);
            }
        }
        else {
            GL11.glPushMatrix();
            GL11.glTranslatef(modelRenderer.field_78800_c * n, modelRenderer.field_78797_d * n, modelRenderer.field_78798_e * n);
            if (modelRenderer.field_78808_h != 0.0f) {
                GL11.glRotatef(modelRenderer.field_78808_h * 57.295776f, 0.0f, 0.0f, 1.0f);
            }
            if (modelRenderer.field_78796_g != 0.0f) {
                GL11.glRotatef(modelRenderer.field_78796_g * 57.295776f, 0.0f, 1.0f, 0.0f);
            }
            if (modelRenderer.field_78795_f != 0.0f) {
                GL11.glRotatef(modelRenderer.field_78795_f * 57.295776f, 1.0f, 0.0f, 0.0f);
            }
            actuallyRender(modelRenderer, n);
            if (modelRenderer.field_78805_m != null) {
                for (int k = 0; k < modelRenderer.field_78805_m.size(); ++k) {
                    ((ModelRenderer)modelRenderer.field_78805_m.get(k)).func_78785_a(n);
                }
            }
            GL11.glPopMatrix();
        }
        GL11.glTranslatef(-modelRenderer.field_82906_o, -modelRenderer.field_82908_p, -modelRenderer.field_82907_q);
    }
    
    private static void actuallyRender(final ModelRenderer modelRenderer, final float n) {
        final uheb field_78398_a = uheb.field_78398_a;
        for (int i = 0; i < modelRenderer.field_78804_l.size(); ++i) {
            ((ModelBox)modelRenderer.field_78804_l.get(i)).func_78245_a(field_78398_a, n);
        }
    }
}
