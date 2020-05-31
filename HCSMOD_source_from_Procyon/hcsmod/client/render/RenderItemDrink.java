// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import java.util.HashMap;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.client.tuor;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.ResourceLocation;
import hcsmod.items.ItemDrinkBackpackmod;
import java.util.Map;

public class RenderItemDrink implements rqjc
{
    public static final RenderItemDrink instance;
    private static final Map<ItemDrinkBackpackmod, Integer> _displayLists_dont_touch;
    
    public boolean handleRenderType(final ieta ieta, final rqjc.uxsf uxsf) {
        return uxsf == rqjc.uxsf.EQUIPPED_FIRST_PERSON || uxsf == rqjc.uxsf.EQUIPPED || uxsf == rqjc.uxsf.ENTITY;
    }
    
    public boolean shouldUseRenderHelper(final rqjc.uxsf uxsf, final ieta ieta, final rqjc.eidn eidn) {
        return false;
    }
    
    public void renderItem(final rqjc.uxsf uxsf, final ieta ieta, final Object... array) {
        final ItemDrinkBackpackmod itemDrinkBackpackmod = (ItemDrinkBackpackmod)ieta._a();
        if (ieta._b() != null) {
            final ResourceLocation resourceLocation = ItemDrinkBackpackmod.textures.get(itemDrinkBackpackmod.name);
            if (resourceLocation != null && uxsf == rqjc.uxsf.EQUIPPED_FIRST_PERSON) {
                GL11.glEnable(32826);
                tuor._E()._f._a(resourceLocation);
                final String name = ((ItemDrinkBackpackmod)ieta._a()).name;
                switch (name) {
                    case "bandage": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.75, 2.700000047683716, 0.75);
                        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(100.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glCullFace(1028);
                        GL11.glScalef(3.0f, 3.0f, -3.0f);
                        GL11.glCallList(getDisplayListId((ItemDrinkBackpackmod)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glTranslated(0.0, 0.0, 0.0);
                        GL11.glPopMatrix();
                        break;
                    }
                    case "morphine": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(3.200000047683716, 1.2000000476837158, 3.0);
                        GL11.glRotatef(-160.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(140.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glCullFace(1028);
                        GL11.glScalef(3.0f, 3.0f, -3.0f);
                        GL11.glCallList(getDisplayListId((ItemDrinkBackpackmod)ieta._a()));
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
                        GL11.glCallList(getDisplayListId((ItemDrinkBackpackmod)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glTranslated(0.0, 0.0, 0.0);
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
            else if (uxsf == rqjc.uxsf.EQUIPPED) {
                GL11.glEnable(32826);
                tuor._E()._f._a(resourceLocation);
                final String name2 = ((ItemDrinkBackpackmod)ieta._a()).name;
                switch (name2) {
                    case "bandage":
                    case "morphine": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.42500001192092896, 0.4000000059604645, 1.600000023841858);
                        GL11.glCullFace(1028);
                        GL11.glScalef(2.0f, -2.0f, 2.0f);
                        GL11.glCallList(getDisplayListId((ItemDrinkBackpackmod)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                    default: {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.44999998807907104, 0.20000000298023224, 1.5499999523162842);
                        GL11.glCullFace(1028);
                        GL11.glScalef(2.0f, -2.0f, 2.0f);
                        GL11.glCallList(getDisplayListId((ItemDrinkBackpackmod)ieta._a()));
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
                final String name3 = ((ItemDrinkBackpackmod)ieta._a()).name;
                switch (name3) {
                    case "bandage": {
                        GL11.glPushMatrix();
                        GL11.glRotatef(field_70177_z, 0.0f, -1.0f, 0.0f);
                        GL11.glTranslated(0.0, -0.550000011920929, 2.5999999046325684);
                        GL11.glScalef(3.5f, 3.5f, 3.5f);
                        GL11.glCallList(getDisplayListId((ItemDrinkBackpackmod)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "morphine": {
                        GL11.glPushMatrix();
                        GL11.glRotatef(field_70177_z, 0.0f, -1.0f, 0.0f);
                        GL11.glTranslated(0.0, -0.6000000238418579, -2.5999999046325684);
                        GL11.glCullFace(1028);
                        GL11.glScalef(3.5f, 3.5f, -3.5f);
                        GL11.glCallList(getDisplayListId((ItemDrinkBackpackmod)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                    default: {
                        GL11.glPushMatrix();
                        GL11.glRotatef(field_70177_z, 0.0f, -1.0f, 0.0f);
                        GL11.glTranslated(0.0, 0.0, 2.5999999046325684);
                        GL11.glCullFace(1028);
                        GL11.glScalef(3.5f, -3.5f, 3.5f);
                        GL11.glCallList(getDisplayListId((ItemDrinkBackpackmod)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
        }
    }
    
    public static int getDisplayListId(final ItemDrinkBackpackmod itemDrinkBackpackmod) {
        final Integer n = RenderItemDrink._displayLists_dont_touch.get(itemDrinkBackpackmod);
        int i;
        if (n != null) {
            i = n;
        }
        else {
            i = GL11.glGenLists(1);
            GL11.glNewList(i, 4864);
            try {
                iwoh.loadModel("/assets/hcsmod/obj/" + itemDrinkBackpackmod.name + ".obj").renderAll();
            }
            catch (RuntimeException ex) {
                System.err.println("Block name: " + itemDrinkBackpackmod.name);
                throw ex;
            }
            GL11.glEndList();
            RenderItemDrink._displayLists_dont_touch.put(itemDrinkBackpackmod, i);
        }
        return i;
    }
    
    static {
        instance = new RenderItemDrink();
        _displayLists_dont_touch = new HashMap<ItemDrinkBackpackmod, Integer>();
    }
}
