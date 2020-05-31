// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import org.lwjgl.opengl.GL11;
import net.minecraft.util.ResourceLocation;

public class RendererEZHBlock extends jhhk
{
    private static ModelEzh model;
    private static final ResourceLocation model_texture;
    
    public RendererEZHBlock() {
        RendererEZHBlock.model = new ModelEzh();
    }
    
    public void func_76894_a(final ogpr ogpr, final double n, final double n2, final double n3, final float n4) {
        this.renderTileEntity((TileEntityLAXAXAX)ogpr, n, n2, n3, n4);
    }
    
    public void renderTileEntity(final TileEntityLAXAXAX tileEntityLAXAXAX, final double n, final double n2, final double n3, final float n4) {
        int func_72805_g = 0;
        if (tileEntityLAXAXAX.field_70331_k != null) {
            func_72805_g = tileEntityLAXAXAX.field_70331_k.func_72805_g(tileEntityLAXAXAX.field_70329_l, tileEntityLAXAXAX.field_70330_m, tileEntityLAXAXAX.field_70327_n);
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
        this.func_110628_a(RendererEZHBlock.model_texture);
        RendererEZHBlock.model.render(0.0625f);
        GL11.glPopMatrix();
    }
    
    static {
        model_texture = new ResourceLocation("blockwithmodel:textures/models/ezh.png");
    }
}
