// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.jugger;

import java.util.ArrayList;
import java.util.Iterator;
import hcsmod.player.ExtendedPlayer;
import hcsmod.HCS;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.tuor;
import net.minecraft.util.ResourceLocation;
import java.util.List;

public class JuggerHud
{
    public static final List<RenderSpot> entities;
    private static ResourceLocation radar_bg;
    private static ResourceLocation radar_tgt;
    private static ResourceLocation eu_bg;
    private static ResourceLocation eu_lvl;
    
    public static void renderJagHud(final tuor tuor) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        drawEU(tuor);
        if (tuor._r.func_82169_q(3) == null || tuor._r.func_82169_q(3)._d != HCS.JAG[0].field_77779_bT) {
            JuggerHud.entities.clear();
            return;
        }
        drawRadar(tuor);
    }
    
    private static void drawEU(final tuor tuor) {
        double n = 0.0;
        double n2 = 0.0;
        for (int i = 0; i < 4; ++i) {
            n2 += HCS.JAG[i].func_77612_l();
            if (tuor._r.func_82169_q(3 - i) != null && tuor._r.func_82169_q(3 - i)._d == HCS.JAG[i].field_77779_bT) {
                n += HCS.JAG[i].func_77612_l() - tuor._r.func_82169_q(3 - i)._j();
            }
        }
        if (n <= 0.0) {
            return;
        }
        tuor._f._a(JuggerHud.eu_bg);
        draw(1.0, 11.0, 40.0, 40.0, 1.0);
        tuor._f._a(JuggerHud.eu_lvl);
        draw(2.0, 12.0, 24.0, 24.0, n / n2);
        for (int j = 0; j < 4; ++j) {
            if (tuor._r.func_82169_q(3 - j) == null || tuor._r.func_82169_q(3 - j)._d != HCS.JAG[j].field_77779_bT) {
                return;
            }
        }
        tuor._f._a(JuggerHud.eu_bg);
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a(1.0, 91.0, -90.0, 0.0, 0.0);
        field_78398_a.func_78374_a(41.0, 91.0, -90.0, 1.0, 0.0);
        field_78398_a.func_78374_a(41.0, 51.0, -90.0, 1.0, 1.0);
        field_78398_a.func_78374_a(1.0, 51.0, -90.0, 0.0, 1.0);
        field_78398_a.func_78381_a();
        tuor._f._a(JuggerHud.eu_lvl);
        int shieldCharge = ExtendedPlayer.client(tuor._r.field_71092_bJ).shieldCharge;
        if (shieldCharge < 0) {
            shieldCharge = -shieldCharge;
            GL11.glColor3f(1.0f, 0.0f, 0.0f);
        }
        final float n3 = shieldCharge / 127.0f;
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a(2.0, 90.0, -90.0, 0.0, 0.0);
        field_78398_a.func_78374_a(26.0, 90.0, -90.0, 1.0, 0.0);
        final float n4 = 24.0f * (1.0f - n3);
        field_78398_a.func_78374_a(26.0, (double)(66.0f + n4), -90.0, 1.0, (double)n3);
        field_78398_a.func_78374_a(2.0, (double)(66.0f + n4), -90.0, 0.0, (double)n3);
        field_78398_a.func_78381_a();
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
    }
    
    private static void drawRadar(final tuor tuor) {
        tuor._f._a(JuggerHud.radar_bg);
        draw(1.0, 11.0, 80.0, 80.0);
        tuor._f._a(JuggerHud.radar_tgt);
        for (final RenderSpot renderSpot : JuggerHud.entities) {
            if (renderSpot.c.id() == RenderSpot.UNKNOWN || renderSpot.c.id() == RenderSpot.ANIMAL) {
                final double n = tuor._r.field_70177_z / 180.0 * 3.141592653589793 + Math.atan2(renderSpot.x, renderSpot.z);
                final double n2 = -Math.sin(n) * renderSpot.d * 0.3;
                final double n3 = Math.cos(n) * renderSpot.d * 0.3;
                GL11.glColor4f(renderSpot.c.r, renderSpot.c.g, renderSpot.c.b, 1.0f);
                draw(40.25 + n2, 50.25 - n3, 1.5, 1.5);
            }
        }
        for (final RenderSpot renderSpot2 : JuggerHud.entities) {
            if (renderSpot2.c.id() == RenderSpot.ZOMBIE || renderSpot2.c.id() == RenderSpot.PLAYER_ADMIN) {
                final double n4 = tuor._r.field_70177_z / 180.0 * 3.141592653589793 + Math.atan2(renderSpot2.x, renderSpot2.z);
                final double n5 = -Math.sin(n4) * renderSpot2.d * 0.3;
                final double n6 = Math.cos(n4) * renderSpot2.d * 0.3;
                GL11.glColor4f(renderSpot2.c.r, renderSpot2.c.g, renderSpot2.c.b, 1.0f);
                draw(40.25 + n5, 50.25 - n6, 1.5, 1.5);
            }
        }
        for (final RenderSpot renderSpot3 : JuggerHud.entities) {
            if (renderSpot3.c.id() == RenderSpot.VEH_AIR || renderSpot3.c.id() == RenderSpot.VEH_LAND || renderSpot3.c.id() == RenderSpot.PLAYER_FRIEND) {
                final double n7 = tuor._r.field_70177_z / 180.0 * 3.141592653589793 + Math.atan2(renderSpot3.x, renderSpot3.z);
                final double n8 = -Math.sin(n7) * renderSpot3.d * 0.3;
                final double n9 = Math.cos(n7) * renderSpot3.d * 0.3;
                GL11.glColor4f(renderSpot3.c.r, renderSpot3.c.g, renderSpot3.c.b, 1.0f);
                draw(40.25 + n8, 50.25 - n9, 1.5, 1.5);
            }
        }
        for (final RenderSpot renderSpot4 : JuggerHud.entities) {
            if (renderSpot4.c.id() == RenderSpot.PLAYER_OTHER) {
                final double n10 = tuor._r.field_70177_z / 180.0 * 3.141592653589793 + Math.atan2(renderSpot4.x, renderSpot4.z);
                final double n11 = -Math.sin(n10) * renderSpot4.d * 0.3;
                final double n12 = Math.cos(n10) * renderSpot4.d * 0.3;
                GL11.glColor4f(renderSpot4.c.r, renderSpot4.c.g, renderSpot4.c.b, 1.0f);
                draw(40.25 + n11, 50.25 - n12, 1.5, 1.5);
            }
        }
    }
    
    private static void draw(final double n, final double n2, final double n3, final double n4, final double n5) {
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a(n, n2 + n4, -90.0, 0.0, 1.0);
        field_78398_a.func_78374_a(n + n3, n2 + n4, -90.0, 1.0, 1.0);
        field_78398_a.func_78374_a(n + n3, n2 + n4 * (1.0 - n5), -90.0, 1.0, 1.0 - n5);
        field_78398_a.func_78374_a(n, n2 + n4 * (1.0 - n5), -90.0, 0.0, 1.0 - n5);
        field_78398_a.func_78381_a();
    }
    
    private static void draw(final double n, final double n2, final double n3, final double n4) {
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a(n, n2 + n4, -90.0, 0.0, 1.0);
        field_78398_a.func_78374_a(n + n3, n2 + n4, -90.0, 1.0, 1.0);
        field_78398_a.func_78374_a(n + n3, n2, -90.0, 1.0, 0.0);
        field_78398_a.func_78374_a(n, n2, -90.0, 0.0, 0.0);
        field_78398_a.func_78381_a();
    }
    
    static {
        entities = new ArrayList<RenderSpot>();
        JuggerHud.radar_bg = new ResourceLocation("hcsmod:jugger/radar.png");
        JuggerHud.radar_tgt = new ResourceLocation("hcsmod:jugger/spot.png");
        JuggerHud.eu_bg = new ResourceLocation("hcsmod:jugger/charge_base.png");
        JuggerHud.eu_lvl = new ResourceLocation("hcsmod:jugger/charge_level.png");
    }
}
