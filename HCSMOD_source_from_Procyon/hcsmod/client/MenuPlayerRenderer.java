// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import net.minecraft.client.tuor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.ResourceLocation;

public class MenuPlayerRenderer extends ycnh
{
    public static final ResourceLocation locationStevePng;
    private anli downloadImageSkin;
    private ResourceLocation locationSkin;
    private static String username;
    
    public MenuPlayerRenderer() {
        super((ModelBase)new ModelBiped(), 0.0f);
        if (MenuPlayerRenderer.username != null && !MenuPlayerRenderer.username.isEmpty()) {
            this.locationSkin = AbstractClientPlayer.func_110311_f(MenuPlayerRenderer.username);
            this.downloadImageSkin = AbstractClientPlayer.func_110304_a(this.locationSkin, MenuPlayerRenderer.username);
        }
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return this.locationSkin;
    }
    
    public void renderZombie(final MenuPlayer menuPlayer, final double n, final double n2, final double n3, final float n4, final float n5) {
        this.func_110776_a(this.func_110775_a((Entity)menuPlayer));
        super.func_77101_a((EntityLivingBase)menuPlayer, n, n2, n3, n4, n5);
    }
    
    public void func_76986_a(final Entity entity, final double n, final double n2, final double n3, final float n4, final float n5) {
        this.renderZombie((MenuPlayer)entity, n, n2, n3, n4, n5);
    }
    
    static {
        locationStevePng = new ResourceLocation("textures/entity/steve.png");
        MenuPlayerRenderer.username = tuor._E()._P()._a();
    }
}
