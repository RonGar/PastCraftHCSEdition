// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import org.lwjgl.opengl.GL11;
import net.minecraft.util.ResourceLocation;

public class RendererBlockFence_5 extends jhhk
{
    private static ModelFence_5 model;
    private static final ResourceLocation model_texture;
    
    public RendererBlockFence_5() {
        RendererBlockFence_5.model = new ModelFence_5();
    }
    
    public void func_76894_a(final ogpr ogpr, final double n, final double n2, final double n3, final float n4) {
        this.renderTileEntity((TileEntityBlockFence_5)ogpr, n, n2, n3, n4);
    }
    
    public void renderTileEntity(final TileEntityBlockFence_5 tileEntityBlockFence_5, final double n, final double n2, final double n3, final float n4) {
        int func_72805_g = 0;
        if (tileEntityBlockFence_5.field_70331_k != null) {
            func_72805_g = tileEntityBlockFence_5.field_70331_k.func_72805_g(tileEntityBlockFence_5.field_70329_l, tileEntityBlockFence_5.field_70330_m, tileEntityBlockFence_5.field_70327_n);
        }
        int n5 = 0;
        if (func_72805_g == 0) {
            n5 = 0;
        }
        if (func_72805_g == 1) {
            n5 = 90;
        }
        if (func_72805_g == 2) {
            n5 = 180;
        }
        if (func_72805_g == 3) {
            n5 = 270;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)n + 0.5f, (float)n2 + 1.5f, (float)n3 + 0.5f);
        GL11.glColor4f(0.75f, 0.75f, 0.75f, 1.0f);
        GL11.glRotatef((float)n5, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        this.func_110628_a(RendererBlockFence_5.model_texture);
        RendererBlockFence_5.model.render(0.0625f);
        GL11.glPopMatrix();
    }
    
    static {
        model_texture = new ResourceLocation("blockwithmodel:textures/models/lowfencestraight.png");
    }
}
