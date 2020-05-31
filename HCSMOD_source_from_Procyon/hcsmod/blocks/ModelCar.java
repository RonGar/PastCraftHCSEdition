// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.blocks;

import org.lwjgl.opengl.GL11;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;

@SideOnly(Side.CLIENT)
public class ModelCar extends ModelBase
{
    private wovl modelTutBox;
    public ResourceLocation texture;
    
    public ModelCar() {
        this.modelTutBox = iwoh.loadModel("blockwithmodel:textures/models/model_car.obj");
        this.texture = new ResourceLocation("blockwithmodel:textures/models/texture_car.png");
    }
    
    public void render() {
        this.modelTutBox.renderAll();
    }
    
    public void render(final TileEntityBlockCar tileEntityBlockCar, final double n, final double n2, final double n3) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        rojd.instance().getClient()._f._a(this.texture);
        this.render();
        GL11.glPopMatrix();
    }
}
