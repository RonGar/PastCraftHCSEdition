/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  dfta
 *  dxti
 *  jhhk
 *  kjsv
 *  ncpk
 *  net.minecraft.client.tuor
 *  net.minecraft.util.ResourceLocation
 *  ogpr
 *  org.lwjgl.opengl.GL11
 *  uheb
 *  wnoj
 */
package co.uk.flansmods.client;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.teams.BlockSpawner;
import net.minecraft.client.tuor;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntitySpawnerRenderer
extends jhhk {
    private dfta blockRenderer;

    public void func_76894_a(ogpr ogpr2, double d, double d2, double d3, float f) {
        BlockSpawner.colouredPass = true;
        uheb uheb2 = uheb.field_78398_a;
        this.func_110628_a(wnoj._a);
        ncpk._a();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2884);
        if (tuor._C()) {
            GL11.glShadeModel((int)7425);
        } else {
            GL11.glShadeModel((int)7424);
        }
        uheb2.func_78382_b();
        uheb2.func_78373_b((double)((float)d - (float)ogpr2.field_70329_l), (double)((float)d2 - (float)ogpr2.field_70330_m), (double)((float)d3 - (float)ogpr2.field_70327_n));
        uheb2.func_78376_a(1, 1, 1);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)0.0f, (float)0.5f);
        this.blockRenderer._a(FlansMod.spawner, ogpr2.field_70329_l, ogpr2.field_70330_m, ogpr2.field_70327_n);
        uheb2.func_78373_b(0.0, 0.0, 0.0);
        uheb2.func_78381_a();
        ncpk._b();
        BlockSpawner.colouredPass = false;
    }

    public void func_76896_a(cuqu cuqu2) {
        this.blockRenderer = new dfta((dxti)cuqu2);
    }
}

