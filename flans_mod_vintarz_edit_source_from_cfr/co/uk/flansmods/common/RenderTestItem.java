/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ieta
 *  iwoh
 *  net.minecraft.client.tuor
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  rqjc
 *  rqjc$eidn
 *  rqjc$uxsf
 *  wovl
 *  zfwe
 */
package co.uk.flansmods.common;

import net.minecraft.client.tuor;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTestItem
implements rqjc {
    public static final wovl model = iwoh.loadModel((String)"FlansMod:obj/item.obj");
    public static final ResourceLocation texture = new ResourceLocation("FlansModVtzVldrFix", "textures/items/item_obj.png");

    public boolean handleRenderType(ieta ieta2, rqjc.uxsf uxsf2) {
        return uxsf2 != rqjc.uxsf.INVENTORY;
    }

    public boolean shouldUseRenderHelper(rqjc.uxsf uxsf2, ieta ieta2, rqjc.eidn eidn2) {
        return uxsf2 != rqjc.uxsf.INVENTORY;
    }

    public void renderItem(rqjc.uxsf uxsf2, ieta ieta2, Object ... arrobject) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.5f, (float)0.0f, (float)0.5f);
        tuor._E()._f._a(texture);
        model.renderAll();
        GL11.glPopMatrix();
    }
}

