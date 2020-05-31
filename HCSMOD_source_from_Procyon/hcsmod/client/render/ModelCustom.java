// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import java.util.List;
import vintarz.core.VTechneModelLoader;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelCustom extends ModelBase
{
    ModelRenderer[] parts;
    ResourceLocation tex;
    
    public ModelCustom() {
    }
    
    public ModelCustom(final String s, final String s2) {
        this.tex = ((s2 == null) ? null : new ResourceLocation(s2));
        VTechneModelLoader.loadModel(s, (ModelBase)this);
        final List boxList = VTechneModelLoader.VTM.boxList;
        this.parts = new ModelRenderer[boxList.size()];
        for (int i = 0; i < this.parts.length; ++i) {
            this.parts[i] = boxList.get(i);
        }
        this.field_78090_t = VTechneModelLoader.VTM.textureWidth;
        this.field_78089_u = VTechneModelLoader.VTM.textureHeight;
    }
    
    public void render(final float n) {
        if (this.tex != null) {
            rojd.instance().getClient()._R()._a(this.tex);
        }
        if (this.parts != null) {
            final ModelRenderer[] parts = this.parts;
            for (int length = parts.length, i = 0; i < length; ++i) {
                parts[i].func_78785_a(n);
            }
        }
    }
}
