// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import java.util.HashMap;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.client.tuor;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.ResourceLocation;
import hcsmod.items.ItemHeal;
import java.util.Map;

public class RenderHealObj implements rqjc
{
    public static final RenderHealObj instance;
    private static final Map<ItemHeal, Integer> _displayLists_dont_touch;
    
    public boolean handleRenderType(final ieta ieta, final rqjc.uxsf uxsf) {
        return uxsf == rqjc.uxsf.EQUIPPED_FIRST_PERSON || uxsf == rqjc.uxsf.EQUIPPED || uxsf == rqjc.uxsf.ENTITY;
    }
    
    public boolean shouldUseRenderHelper(final rqjc.uxsf uxsf, final ieta ieta, final rqjc.eidn eidn) {
        return false;
    }
    
    public void renderItem(final rqjc.uxsf uxsf, final ieta ieta, final Object... array) {
        final ItemHeal itemHeal = (ItemHeal)ieta._a();
        if (ieta._b() != null) {
            final ResourceLocation resourceLocation = ItemHeal.textures.get(itemHeal.name);
            if (resourceLocation != null && uxsf == rqjc.uxsf.EQUIPPED_FIRST_PERSON) {
                GL11.glEnable(32826);
                tuor._E()._f._a(resourceLocation);
                final String name = ((ItemHeal)ieta._a()).name;
                switch (name) {
                    case "firstAidKit":
                    case "firstAidKit_b": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(2.2, 1.1, 1.5);
                        GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(25.0f, 1.0f, 0.0f, 0.0f);
                        GL11.glScalef(1.9f, 1.9f, 1.9f);
                        GL11.glCallList(getDisplayListId((ItemHeal)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "small_firstAidKit": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(1.0, 2.3, 1.0);
                        GL11.glRotatef(70.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(60.0f, 1.0f, 0.0f, 0.0f);
                        GL11.glCullFace(1028);
                        GL11.glScalef(3.0f, 3.0f, -3.0f);
                        GL11.glCallList(getDisplayListId((ItemHeal)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                    case "pills": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.98, 0.5, 0.25);
                        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
                        GL11.glCullFace(1028);
                        GL11.glScalef(2.5f, 2.5f, -2.5f);
                        GL11.glCallList(getDisplayListId((ItemHeal)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
            else if (uxsf == rqjc.uxsf.EQUIPPED) {
                GL11.glEnable(32826);
                tuor._E()._f._a(resourceLocation);
                final String name2 = ((ItemHeal)ieta._a()).name;
                switch (name2) {
                    case "firstAidKit":
                    case "firstAidKit_b": {
                        GL11.glPushMatrix();
                        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glTranslated(0.0, 0.6800000071525574, 1.3600000143051147);
                        GL11.glScalef(1.0f, 1.0f, 1.0f);
                        GL11.glCallList(getDisplayListId((ItemHeal)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "pills": {
                        GL11.glPushMatrix();
                        GL11.glRotatef(-100.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glTranslated(-0.5799999833106995, 0.7200000286102295, -0.019999999552965164);
                        GL11.glScalef(1.0f, 1.0f, 1.0f);
                        GL11.glCallList(getDisplayListId((ItemHeal)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "small_firstAidKit": {
                        GL11.glPushMatrix();
                        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glTranslated(0.0, 0.6800000071525574, 1.2599999904632568);
                        GL11.glScalef(1.0f, 1.0f, 1.0f);
                        GL11.glCallList(getDisplayListId((ItemHeal)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
            else if (uxsf == rqjc.uxsf.ENTITY) {
                final float field_70177_z = ((EntityItem)array[1]).field_70177_z;
                GL11.glEnable(32826);
                tuor._E()._f._a(resourceLocation);
                final String name3 = ((ItemHeal)ieta._a()).name;
                switch (name3) {
                    case "firstAidKit":
                    case "firstAidKit_b": {
                        GL11.glPushMatrix();
                        GL11.glRotatef(field_70177_z, 0.0f, -1.0f, 0.0f);
                        GL11.glTranslated(0.0, 0.20000000298023224, 2.0);
                        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glScalef(2.5f, 2.5f, 2.5f);
                        GL11.glCallList(getDisplayListId((ItemHeal)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "small_firstAidKit": {
                        GL11.glPushMatrix();
                        GL11.glRotatef(field_70177_z, 0.0f, -1.0f, 0.0f);
                        GL11.glTranslated(0.0, -0.25, -2.0);
                        GL11.glCullFace(1028);
                        GL11.glScalef(2.5f, 2.5f, -2.5f);
                        GL11.glCallList(getDisplayListId((ItemHeal)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                    case "pills": {
                        GL11.glPushMatrix();
                        GL11.glRotatef(field_70177_z, 0.0f, -1.0f, 0.0f);
                        GL11.glCullFace(1028);
                        GL11.glScalef(2.5f, 2.5f, -2.5f);
                        GL11.glCallList(getDisplayListId((ItemHeal)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
        }
    }
    
    public static int getDisplayListId(final ItemHeal itemHeal) {
        final Integer n = RenderHealObj._displayLists_dont_touch.get(itemHeal);
        int i;
        if (n != null) {
            i = n;
        }
        else {
            i = GL11.glGenLists(1);
            GL11.glNewList(i, 4864);
            try {
                iwoh.loadModel("/assets/hcsmod/obj/" + itemHeal.name + ".obj").renderAll();
            }
            catch (RuntimeException ex) {
                System.err.println("Item name: " + itemHeal.name);
                throw ex;
            }
            GL11.glEndList();
            RenderHealObj._displayLists_dont_touch.put(itemHeal, i);
        }
        return i;
    }
    
    static {
        instance = new RenderHealObj();
        _displayLists_dont_touch = new HashMap<ItemHeal, Integer>();
    }
}
