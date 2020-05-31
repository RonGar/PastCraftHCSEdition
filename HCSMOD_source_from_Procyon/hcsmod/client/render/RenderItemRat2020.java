// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import java.util.HashMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.client.tuor;
import org.lwjgl.opengl.GL11;
import hcsmod.items.ItemRat2020;
import java.util.Map;

public class RenderItemRat2020 implements rqjc
{
    public static final RenderItemRat2020 instance;
    private static final Map<ItemRat2020, Integer> _displayLists_dont_touch;
    
    public boolean handleRenderType(final ieta ieta, final rqjc.uxsf uxsf) {
        return uxsf == rqjc.uxsf.EQUIPPED_FIRST_PERSON || uxsf == rqjc.uxsf.EQUIPPED || uxsf == rqjc.uxsf.ENTITY;
    }
    
    public boolean shouldUseRenderHelper(final rqjc.uxsf uxsf, final ieta ieta, final rqjc.eidn eidn) {
        return false;
    }
    
    public void renderItem(final rqjc.uxsf uxsf, final ieta ieta, final Object... array) {
        ieta._a();
        if (ieta._b() != null) {
            final ResourceLocation textures = ItemRat2020.textures;
            if (textures != null && uxsf == rqjc.uxsf.EQUIPPED_FIRST_PERSON) {
                GL11.glEnable(32826);
                tuor._E()._f._a(textures);
                final String name = ((ItemRat2020)ieta._a()).name;
                switch (name) {
                    case "Rat2020": {
                        GL11.glPushMatrix();
                        GL11.glCullFace(1028);
                        GL11.glRotatef(-64.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(4.0f, 1.0f, 0.0f, 0.0f);
                        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glTranslated(0.5, 0.30000001192092896, -0.800000011920929);
                        GL11.glScalef(-0.02f, 0.02f, 0.02f);
                        GL11.glCallList(getDisplayListId((ItemRat2020)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
            else if (uxsf == rqjc.uxsf.EQUIPPED) {
                GL11.glEnable(32826);
                tuor._E()._f._a(textures);
                final String name2 = ((ItemRat2020)ieta._a()).name;
                switch (name2) {
                    case "Rat2020": {
                        GL11.glPushMatrix();
                        GL11.glCullFace(1028);
                        GL11.glTranslated(0.5, 0.07000000029802322, 0.20000000298023224);
                        GL11.glScalef(-0.015f, 0.015f, 0.015f);
                        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.2f);
                        GL11.glCallList(getDisplayListId((ItemRat2020)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
            else if (uxsf == rqjc.uxsf.ENTITY) {
                final float field_70177_z = ((EntityItem)array[1]).field_70177_z;
                GL11.glEnable(32826);
                tuor._E()._f._a(textures);
                final String name3 = ((ItemRat2020)ieta._a()).name;
                switch (name3) {
                    case "Rat2020": {
                        GL11.glPushMatrix();
                        GL11.glRotatef(field_70177_z, 0.0f, 1.0f, 0.0f);
                        GL11.glTranslated(0.0, 0.0, 0.0);
                        GL11.glCullFace(1028);
                        GL11.glScalef(-0.02f, 0.02f, 0.02f);
                        GL11.glCallList(getDisplayListId((ItemRat2020)ieta._a()));
                        GL11.glCullFace(1029);
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
        }
    }
    
    public static int getDisplayListId(final ItemRat2020 itemRat2020) {
        final Integer n = RenderItemRat2020._displayLists_dont_touch.get(itemRat2020);
        int i;
        if (n != null) {
            i = n;
        }
        else {
            i = GL11.glGenLists(1);
            GL11.glNewList(i, 4864);
            try {
                iwoh.loadModel("/assets/hcsmod/obj/" + itemRat2020.name + ".obj").renderAll();
            }
            catch (RuntimeException ex) {
                System.err.println("Block name: " + itemRat2020.name);
                throw ex;
            }
            GL11.glEndList();
            RenderItemRat2020._displayLists_dont_touch.put(itemRat2020, i);
        }
        return i;
    }
    
    static {
        instance = new RenderItemRat2020();
        _displayLists_dont_touch = new HashMap<ItemRat2020, Integer>();
    }
}
