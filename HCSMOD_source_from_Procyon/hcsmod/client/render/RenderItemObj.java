// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import java.util.HashMap;
import org.lwjgl.input.Mouse;
import net.minecraft.client.tuor;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.ResourceLocation;
import hcsmod.items.ItemMeele;
import java.util.Map;

public class RenderItemObj implements rqjc
{
    public static final RenderItemObj instance;
    private static final Map<ItemMeele, Integer> _displayLists_dont_touch;
    
    public boolean handleRenderType(final ieta ieta, final rqjc.uxsf uxsf) {
        return uxsf == rqjc.uxsf.EQUIPPED_FIRST_PERSON || uxsf == rqjc.uxsf.EQUIPPED || uxsf == rqjc.uxsf.ENTITY;
    }
    
    public boolean shouldUseRenderHelper(final rqjc.uxsf uxsf, final ieta ieta, final rqjc.eidn eidn) {
        return false;
    }
    
    public void renderItem(final rqjc.uxsf uxsf, final ieta ieta, final Object... array) {
        final ItemMeele itemMeele = (ItemMeele)ieta._a();
        if (ieta._b() != null) {
            final ResourceLocation resourceLocation = ItemMeele.textures.get(itemMeele.name);
            if (resourceLocation != null && uxsf == rqjc.uxsf.EQUIPPED_FIRST_PERSON) {
                GL11.glEnable(32826);
                tuor._E()._f._a(resourceLocation);
                final String name = ((ItemMeele)ieta._a()).name;
                switch (name) {
                    case "Axe1":
                    case "Axe2": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.1, 0.6000000238418579, -0.5);
                        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glScalef(0.1f, 0.1f, 0.1f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "ice_copie":
                    case "ice_kosa":
                    case "ice_sword":
                    case "ice_trezybetc": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.3, 0.4000000059604645, -0.5);
                        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glScalef(0.1f, 0.1f, 0.1f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "ice_knife": {
                        final float x = (Mouse.getX() / 1919.0f - 0.5f) * 500.0f;
                        if (System.currentTimeMillis() % 100L == 0L) {
                            System.out.println(x);
                        }
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.0, 0.47999998927116394, -0.5);
                        GL11.glRotatef(-56.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(197.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glScalef(0.1f, 0.1f, 0.1f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "knife": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.0, 0.5, -0.7);
                        GL11.glRotatef(135.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(-268.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glScalef(0.05f, 0.05f, 0.05f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "bita1":
                    case "bita2": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.1, 0.699999988079071, -0.5);
                        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                        GL11.glRotatef(-40.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glScalef(0.1f, 0.1f, 0.1f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
            else if (uxsf == rqjc.uxsf.EQUIPPED) {
                GL11.glEnable(32826);
                tuor._E()._f._a(resourceLocation);
                final String name2 = ((ItemMeele)ieta._a()).name;
                switch (name2) {
                    case "Axe1":
                    case "Axe2": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.5, 0.5, 0.0);
                        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glScalef(0.1f, 0.1f, 0.1f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "ice_copie":
                    case "ice_knife":
                    case "ice_kosa":
                    case "ice_sword": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.699999988079071, 0.3499999940395355, 0.0);
                        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glScalef(0.15f, 0.15f, 0.15f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "ice_trezybetc": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.5, 0.5, 0.0);
                        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glScalef(0.15f, 0.15f, 0.15f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "knife": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.5, 0.5, 0.0);
                        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glScalef(0.05f, 0.05f, 0.05f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "bita1":
                    case "bita2": {
                        GL11.glPushMatrix();
                        GL11.glTranslated(0.5, 0.5, 0.0);
                        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                        GL11.glRotatef(-40.0f, 0.0f, 1.0f, 0.0f);
                        GL11.glScalef(0.1f, 0.1f, 0.1f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
            else if (uxsf == rqjc.uxsf.ENTITY) {
                GL11.glEnable(32826);
                tuor._E()._f._a(resourceLocation);
                final String name3 = ((ItemMeele)ieta._a()).name;
                switch (name3) {
                    case "Axe1":
                    case "Axe2":
                    case "ice_copie":
                    case "ice_knife":
                    case "ice_kosa":
                    case "ice_sword":
                    case "ice_trezybetc": {
                        GL11.glPushMatrix();
                        GL11.glScalef(0.3f, 0.3f, 0.3f);
                        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "knife": {
                        GL11.glPushMatrix();
                        GL11.glScalef(0.15f, 0.15f, 0.15f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                    case "bita1":
                    case "bita2": {
                        GL11.glPushMatrix();
                        GL11.glScalef(0.3f, 0.2f, 0.3f);
                        GL11.glCallList(getDisplayListId((ItemMeele)ieta._a()));
                        GL11.glPopMatrix();
                        break;
                    }
                }
            }
        }
    }
    
    public static int getDisplayListId(final ItemMeele itemMeele) {
        final Integer n = RenderItemObj._displayLists_dont_touch.get(itemMeele);
        int i;
        if (n != null) {
            i = n;
        }
        else {
            i = GL11.glGenLists(1);
            GL11.glNewList(i, 4864);
            try {
                iwoh.loadModel("/assets/hcsmod/obj/" + itemMeele.name + ".obj").renderAll();
            }
            catch (RuntimeException ex) {
                System.err.println("Block name: " + itemMeele.name);
                throw ex;
            }
            GL11.glEndList();
            RenderItemObj._displayLists_dont_touch.put(itemMeele, i);
        }
        return i;
    }
    
    static {
        instance = new RenderItemObj();
        _displayLists_dont_touch = new HashMap<ItemMeele, Integer>();
    }
}
