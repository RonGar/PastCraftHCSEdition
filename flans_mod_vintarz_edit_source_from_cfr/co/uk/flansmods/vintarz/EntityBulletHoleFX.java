/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  iwoh
 *  kjsv
 *  net.minecraft.client.particle.EntityFX
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.dfau
 *  ntaf
 *  org.lwjgl.opengl.GL11
 *  uheb
 *  wngx
 *  wovl
 *  zfwe
 */
package co.uk.flansmods.vintarz;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dfau;
import org.lwjgl.opengl.GL11;

public class EntityBulletHoleFX
extends EntityFX {
    public static final wovl model;
    static int displayListId;
    private static final ResourceLocation[][] textures;
    public static List<EntityBulletHoleFX> bulletHoles;
    private final float rotation;
    private final float size;
    private final int type;
    private final int texturenum;
    private final int x;
    private final int y;
    private final int z;
    private final int bId;
    private final int state;
    private final dfau side;
    private final float offset;
    private static boolean wasPressed;

    public EntityBulletHoleFX(cuqu cuqu2, double d, double d2, double d3, int n, int n2, int n3, int n4, dfau dfau2, int n5, float f) {
        super(cuqu2, d, d2, d3);
        if (kjsv.field_71973_m[n4] instanceof ntaf && this.field_70170_p.func_72798_a(n, n2 - 1, n3) == n4) {
            --n2;
        }
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.bId = n4;
        this.side = dfau2;
        this.state = this.field_70170_p.func_72805_g(n, n2, n3);
        this.field_70547_e = 100;
        this.field_70155_l = 6.0;
        this.type = n5;
        this.texturenum = this.field_70146_Z.nextInt(textures[n5].length);
        this.rotation = this.field_70146_Z.nextFloat() * 360.0f;
        this.offset = this.field_70146_Z.nextFloat() - 0.5f;
        this.size = f;
        bulletHoles.add(this);
    }

    public void func_70071_h_() {
        if (this.field_70546_d++ >= this.field_70547_e || this.field_70170_p.func_72798_a(this.x, this.y, this.z) != this.bId || this.field_70170_p.func_72805_g(this.x, this.y, this.z) != this.state) {
            this.func_70106_y();
        }
    }

    public void func_70106_y() {
        super.func_70106_y();
        bulletHoles.remove((Object)this);
    }

    public void func_70539_a(uheb uheb2, float f, float f2, float f3, float f4, float f5, float f6) {
        GL11.glEnable((int)32826);
        EntityLivingBase entityLivingBase = tuor._E()._s;
        EntityFX.field_70556_an = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * (double)f;
        EntityFX.field_70554_ao = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * (double)f;
        EntityFX.field_70555_ap = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * (double)f;
        GL11.glPushMatrix();
        GL11.glTranslated((double)(this.field_70165_t - field_70556_an), (double)(this.field_70163_u - field_70554_ao), (double)(this.field_70161_v - field_70555_ap));
        int n = this.x;
        int n2 = this.y;
        int n3 = this.z;
        if (this.side == dfau._a) {
            GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            --n2;
        } else if (this.side == dfau._c) {
            GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            --n3;
        } else if (this.side == dfau._d) {
            GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            ++n3;
        } else if (this.side == dfau._e) {
            GL11.glRotatef((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            --n;
        } else if (this.side == dfau._f) {
            GL11.glRotatef((float)-90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            ++n;
        } else {
            ++n2;
        }
        int n4 = this.field_70170_p.func_72802_i(n, n2, n3, 0);
        int n5 = n4 % 65536;
        int n6 = n4 / 65536;
        wngx._a((int)wngx._b, (float)((float)n5 / 1.0f), (float)((float)n6 / 1.0f));
        GL11.glRotatef((float)this.rotation, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glScalef((float)this.size, (float)1.0f, (float)this.size);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)Math.max(0.0f, (float)(this.field_70547_e - this.field_70546_d) / 2.0f));
        GL11.glDisable((int)3008);
        GL11.glPolygonOffset((float)(-4.0f + this.offset), (float)-3.0f);
        GL11.glEnable((int)32823);
        GL11.glEnable((int)3008);
        tuor._E()._R()._a(textures[this.type][this.texturenum]);
        if (displayListId != 0) {
            GL11.glCallList((int)displayListId);
        } else {
            displayListId = GL11.glGenLists((int)1);
            GL11.glNewList((int)displayListId, (int)4864);
            try {
                model.renderAll();
            }
            catch (RuntimeException runtimeException) {
                System.out.println("\u041d\u0435 \u0437\u0430\u0433\u0440\u0443\u0436\u0435\u043d\u0430 \u043c\u043e\u0434\u0435\u043b\u044c \u0434\u044b\u0440\u043a\u0438 \u043e\u0442 \u043f\u0443\u043b\u0438!");
            }
            GL11.glEndList();
        }
        GL11.glDisable((int)3008);
        GL11.glPolygonOffset((float)0.0f, (float)0.0f);
        GL11.glDisable((int)32823);
        GL11.glEnable((int)3008);
        GL11.glPopMatrix();
    }

    public int func_70537_b() {
        return 3;
    }

    static {
        int n;
        model = iwoh.loadModel((String)"/assets/flansmod/bulletholes/0.obj");
        displayListId = 0;
        textures = new ResourceLocation[5][];
        bulletHoles = new LinkedList<EntityBulletHoleFX>();
        List[] arrlist = new List[textures.length];
        for (int i = 0; i < arrlist.length; ++i) {
            arrlist[i] = new ArrayList();
        }
        InputStream inputStream = EntityBulletHoleFX.class.getResourceAsStream("/assets/flansmod/bulletholes/0.txt");
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        for (n = 0; n < textures.length; ++n) {
            int n2 = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i <= n2; ++i) {
                arrlist[n].add(new ResourceLocation("flansmod:bulletholes/" + n + "." + i + ".png"));
            }
        }
        for (n = 0; n < arrlist.length; ++n) {
            EntityBulletHoleFX.textures[n] = arrlist[n].toArray((T[])new ResourceLocation[arrlist[n].size()]);
        }
        wasPressed = false;
    }
}

