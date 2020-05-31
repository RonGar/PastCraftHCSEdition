// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.render;

import net.minecraft.entity.Entity;
import net.minecraft.client.tuor;
import org.lwjgl.opengl.GL11;
import hcsmod.entity.EntityHouseCommon;
import net.minecraft.util.ResourceLocation;

public class RenderHouse extends uyfg
{
    private static wovl modelH;
    private static ResourceLocation gtexH;
    private static final String cheater = "\u0414\u043e\u043c \u0447\u0438\u0442\u0435\u0440\u0430, \u043e\u0442\u043a\u0440\u044b\u0442 \u0434\u043b\u044f \u0433\u0440\u0430\u0431\u0435\u0436\u0430.";
    private static int displayListId;
    
    public void render(final EntityHouseCommon entityHouseCommon, final double n, final double n2, final double n3, final float n4, final float n5) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)n, (float)n2 + 1.5f, (float)n3);
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(n4 - 45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        GL11.glTranslatef(0.0f, -1.5f, 0.0f);
        GL11.glRotatef(90.0f, 0.0f, -1.0f, 0.0f);
        GL11.glScalef(0.095f, 0.095f, 0.095f);
        GL11.glPushAttrib(8200);
        GL11.glEnable(2884);
        GL11.glCullFace(1029);
        render();
        GL11.glPopAttrib();
        GL11.glPopMatrix();
        if (entityHouseCommon.func_70096_w()._a(8) > 0) {
            final rord x = tuor._E()._x;
            GL11.glTranslatef(0.0f, 1.4f, 0.0f);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-dfsc._b._l, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(dfsc._b._m, 1.0f, 0.0f, 0.0f);
            GL11.glScalef(-0.02666667f, -0.02666667f, 0.02666667f);
            GL11.glDisable(2896);
            GL11.glDepthMask(false);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            final uheb field_78398_a = uheb.field_78398_a;
            GL11.glDisable(3553);
            field_78398_a.func_78382_b();
            final int n6 = x._b("\u0414\u043e\u043c \u0447\u0438\u0442\u0435\u0440\u0430, \u043e\u0442\u043a\u0440\u044b\u0442 \u0434\u043b\u044f \u0433\u0440\u0430\u0431\u0435\u0436\u0430.") / 2;
            field_78398_a.func_78369_a(0.0f, 0.0f, 0.0f, 0.25f);
            field_78398_a.func_78377_a((double)(-n6 - 1), -1.0, 0.0);
            field_78398_a.func_78377_a((double)(-n6 - 1), 8.0, 0.0);
            field_78398_a.func_78377_a((double)(n6 + 1), 8.0, 0.0);
            field_78398_a.func_78377_a((double)(n6 + 1), -1.0, 0.0);
            field_78398_a.func_78381_a();
            GL11.glEnable(3553);
            GL11.glDepthMask(true);
            x._b("\u0414\u043e\u043c \u0447\u0438\u0442\u0435\u0440\u0430, \u043e\u0442\u043a\u0440\u044b\u0442 \u0434\u043b\u044f \u0433\u0440\u0430\u0431\u0435\u0436\u0430.", -x._b("\u0414\u043e\u043c \u0447\u0438\u0442\u0435\u0440\u0430, \u043e\u0442\u043a\u0440\u044b\u0442 \u0434\u043b\u044f \u0433\u0440\u0430\u0431\u0435\u0436\u0430.") / 2, 0, -32640);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        GL11.glPopMatrix();
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
    }
    
    public static void render() {
        tuor._E()._R()._a(RenderHouse.gtexH);
        if (RenderHouse.displayListId == -1) {
            GL11.glNewList(RenderHouse.displayListId = GL11.glGenLists(1), 4864);
            RenderHouse.modelH.renderAll();
            GL11.glEndList();
        }
        GL11.glCallList(RenderHouse.displayListId);
    }
    
    public void func_76986_a(final Entity entity, final double n, final double n2, final double n3, final float n4, final float n5) {
        GL11.glEnable(32826);
        this.render((EntityHouseCommon)entity, n, n2, n3, n4, n5);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return RenderHouse.gtexH;
    }
    
    static {
        RenderHouse.modelH = iwoh.loadModel("/assets/hcsmod/house/Home_HCS1488.obj");
        RenderHouse.gtexH = new ResourceLocation("hcsmod:house/Home_HCS1488.png");
        RenderHouse.displayListId = -1;
    }
}
