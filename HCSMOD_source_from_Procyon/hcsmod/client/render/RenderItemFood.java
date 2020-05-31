// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import java.util.HashMap;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.client.tuor;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.ResourceLocation;
import hcsmod.items.ItemFoodBackpackmod;
import java.util.Map;

public class RenderItemFood implements rqjc
{
    public static final RenderItemFood instance;
    private static final Map<ItemFoodBackpackmod, Integer> _displayLists_dont_touch;
    
    public boolean handleRenderType(final ieta ieta, final rqjc.uxsf uxsf) {
        return uxsf == rqjc.uxsf.EQUIPPED_FIRST_PERSON || uxsf == rqjc.uxsf.EQUIPPED || uxsf == rqjc.uxsf.ENTITY;
    }
    
    public boolean shouldUseRenderHelper(final rqjc.uxsf uxsf, final ieta ieta, final rqjc.eidn eidn) {
        return false;
    }
    
    public void renderItem(final rqjc.uxsf uxsf, final ieta ieta, final Object... array) {
        final ItemFoodBackpackmod itemFoodBackpackmod = (ItemFoodBackpackmod)ieta._a();
        if (ieta._b() != null) {
            final ResourceLocation resourceLocation = ItemFoodBackpackmod.textures.get(itemFoodBackpackmod.name);
            if (resourceLocation != null && uxsf == rqjc.uxsf.EQUIPPED_FIRST_PERSON) {
                GL11.glEnable(32826);
                tuor._E()._f._a(resourceLocation);
                final String name = ((ItemFoodBackpackmod)ieta._a()).name;
                switch (name) {
                    case "MRE": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(3.200000047683716, 1.2000000476837158, 3.0);
                        GL11.glRotatef(-160.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(140.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glCullFace(1028);
                        GL11.glScalef(3.0f, 3.0f, -3.0f);
                        GL11.glCallList(getDisplayListId((ItemFoodBackpackmod)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                    default: {
                        GL11.glPushMatrix();
                        GL11.glTranslated(3.0, 0.8999999761581421, 3.0);
                        GL11.glRotatef(-160.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(140.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glCullFace(1028);
                        GL11.glScalef(3.0f, 3.0f, -3.0f);
                        GL11.glCallList(getDisplayListId((ItemFoodBackpackmod)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
            else if (uxsf == rqjc.uxsf.EQUIPPED) {
                GL11.glEnable(32826);
                tuor._E()._f._a(resourceLocation);
                final String name2 = ((ItemFoodBackpackmod)ieta._a()).name;
                switch (name2) {
                    case "MRE": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.44999998807907104, -0.800000011920929, 1.5499999523162842);
                        GL11.glRotatef(40.0f, 1.0f, 0.0f, 0.0f);
                        GL11.glCullFace(1028);
                        GL11.glScalef(2.0f, -2.0f, 2.0f);
                        GL11.glCallList(getDisplayListId((ItemFoodBackpackmod)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                    default: {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.44999998807907104, 0.20000000298023224, 1.5499999523162842);
                        GL11.glCullFace(1028);
                        GL11.glScalef(2.0f, -2.0f, 2.0f);
                        GL11.glCallList(getDisplayListId((ItemFoodBackpackmod)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
            else if (uxsf == rqjc.uxsf.ENTITY) {
                final float field_70177_z = ((EntityItem)array[1]).field_70177_z;
                GL11.glEnable(32826);
                tuor._E()._f._a(resourceLocation);
                final String name3 = ((ItemFoodBackpackmod)ieta._a()).name;
                switch (name3) {
                    case "MRE": {
                        GL11.glPushMatrix();
                        GL11.glRotatef(field_70177_z, 0.0f, -1.0f, 0.0f);
                        GL11.glTranslated(0.0, -1.25, 2.0);
                        GL11.glRotatef(40.0f, 1.0f, 0.0f, 0.0f);
                        GL11.glCullFace(1028);
                        GL11.glScalef(2.5f, -2.5f, 2.5f);
                        GL11.glCallList(getDisplayListId((ItemFoodBackpackmod)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                    default: {
                        GL11.glPushMatrix();
                        GL11.glRotatef(field_70177_z, 0.0f, -1.0f, 0.0f);
                        GL11.glTranslated(0.0, 0.0, 2.0);
                        GL11.glCullFace(1028);
                        GL11.glScalef(2.5f, -2.5f, 2.5f);
                        GL11.glCallList(getDisplayListId((ItemFoodBackpackmod)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
        }
    }
    
    public static int getDisplayListId(final ItemFoodBackpackmod itemFoodBackpackmod) {
        final Integer n = RenderItemFood._displayLists_dont_touch.get(itemFoodBackpackmod);
        int i;
        if (n != null) {
            i = n;
        }
        else {
            i = GL11.glGenLists(1);
            GL11.glNewList(i, 4864);
            try {
                iwoh.loadModel("/assets/hcsmod/obj/" + itemFoodBackpackmod.name + ".obj").renderAll();
            }
            catch (RuntimeException ex) {
                System.err.println("Block name: " + itemFoodBackpackmod.name);
                throw ex;
            }
            GL11.glEndList();
            RenderItemFood._displayLists_dont_touch.put(itemFoodBackpackmod, i);
        }
        return i;
    }
    
    static {
        instance = new RenderItemFood();
        _displayLists_dont_touch = new HashMap<ItemFoodBackpackmod, Integer>();
    }
}
