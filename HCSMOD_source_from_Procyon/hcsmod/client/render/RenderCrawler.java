// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.entity.Entity;
import hcsmod.entity.EntityCrawler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

public class RenderCrawler extends ycnh
{
    ResourceLocation texture;
    
    public RenderCrawler(final ModelBase modelBase, final float n) {
        super(modelBase, n);
        this.texture = new ResourceLocation("hcsmod:textures/entities/crawler.png");
    }
    
    public void renderCrawler(final EntityCrawler entityCrawler, final double n, final double n2, final double n3, final float n4, final float n5) {
        super.func_76986_a((Entity)entityCrawler, n, n2, n3, n4, n5);
    }
    
    public void func_76986_a(final Entity entity, final double n, final double n2, final double n3, final float n4, final float n5) {
        this.renderCrawler((EntityCrawler)entity, n, n2, n3, n4, n5);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return this.texture;
    }
}
