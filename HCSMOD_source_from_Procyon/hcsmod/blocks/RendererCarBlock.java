// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import org.lwjgl.opengl.GL11;
import net.minecraft.util.ResourceLocation;

public class RendererCarBlock extends jhhk
{
    private static ModelCar model;
    private static final ResourceLocation model_texture;
    
    public RendererCarBlock() {
        RendererCarBlock.model = new ModelCar();
    }
    
    public void func_76894_a(final ogpr ogpr, final double n, final double n2, final double n3, final float n4) {
        this.renderTileEntity((TileEntityBlockFence_2)ogpr, n, n2, n3, n4);
    }
    
    public void renderTileEntity(final TileEntityBlockFence_2 tileEntityBlockFence_2, final double n, final double n2, final double n3, final float n4) {
        int func_72805_g = 0;
        if (tileEntityBlockFence_2.field_70331_k != null) {
            func_72805_g = tileEntityBlockFence_2.field_70331_k.func_72805_g(tileEntityBlockFence_2.field_70329_l, tileEntityBlockFence_2.field_70330_m, tileEntityBlockFence_2.field_70327_n);
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
        RendererCarBlock.model.render();
        GL11.glPopMatrix();
    }
    
    static {
        model_texture = new ResourceLocation("blockwithmodel:textures/models/lowfencestraight.png");
    }
}
