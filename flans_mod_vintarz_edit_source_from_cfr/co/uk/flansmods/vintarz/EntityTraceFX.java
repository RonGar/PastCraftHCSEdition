/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  dfsc
 *  net.minecraft.util.dwbg
 *  org.lwjgl.opengl.GL11
 */
package co.uk.flansmods.vintarz;

import co.uk.flansmods.client.FlansModClient;
import net.minecraft.util.dwbg;
import org.lwjgl.opengl.GL11;

public class EntityTraceFX {
    private static int dl_id = -1;
    private double x;
    private double y;
    private double z;
    private double q;
    private double w;
    private double e;
    private float rotationYaw;
    private float rotationPitch;
    private int ticks;
    private boolean oob;
    private boolean flag;

    public EntityTraceFX(boolean bl, double d, double d2, double d3, double d4, double d5, double d6) {
        this.oob = bl;
        this.ticks = FlansModClient.ticks;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.q = d4;
        this.w = d5;
        this.e = d6;
        double d7 = d4 - d;
        double d8 = d5 - d2;
        double d9 = d6 - d3;
        float f = (float)Math.sqrt(d7 * d7 + d9 * d9);
        this.rotationYaw = (float)(Math.atan2(d7, d9) * 180.0 / 3.1415927410125732);
        this.rotationPitch = (float)(Math.atan2(d8, f) * 180.0 / 3.1415927410125732);
    }

    public boolean renderParticleAndDelete(float f) {
        boolean bl;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        if (this.ticks < FlansModClient.ticks - 1) {
            return true;
        }
        boolean bl2 = this.ticks == FlansModClient.ticks;
        boolean bl3 = bl = this.ticks <= FlansModClient.ticks - 1;
        if (bl2 || bl) {
            f3 = (float)(this.x + (this.q - this.x) * (double)f);
            f7 = (float)(this.y + (this.w - this.y) * (double)f);
            f2 = (float)(this.z + (this.e - this.z) * (double)f);
        } else {
            f3 = (float)this.q;
            f7 = (float)this.w;
            f2 = (float)this.e;
        }
        if (bl) {
            f4 = f3 - (float)this.q;
            f6 = f7 - (float)this.w;
            f5 = f2 - (float)this.e;
        } else {
            f4 = f3 - (float)this.x;
            f6 = f7 - (float)this.y;
            f5 = f2 - (float)this.z;
        }
        float f8 = dwbg._c((float)(f4 * f4 + f6 * f6 + f5 * f5));
        float f9 = -0.05f;
        float f10 = bl ? f8 : -f8;
        f4 = ((float)this.x + (float)this.q) / 2.0f - (float)dfsc._d;
        f6 = ((float)this.y + (float)this.w) / 2.0f - (float)dfsc._e;
        f5 = ((float)this.z + (float)this.e) / 2.0f - (float)dfsc._f;
        f8 = dwbg._c((float)(f4 * f4 + f6 * f6 + f5 * f5));
        boolean bl4 = f8 < 32.0f;
        boolean bl5 = f8 > 16.0f;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)f3, (float)f7, (float)f2);
        GL11.glRotatef((float)this.rotationYaw, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)this.rotationPitch, (float)-1.0f, (float)0.0f, (float)0.0f);
        if (bl2) {
            if (bl4) {
                if (dl_id == -1) {
                    if (dl_id == -1) {
                        dl_id = GL11.glGenLists((int)1);
                    }
                    GL11.glNewList((int)dl_id, (int)4865);
                    GL11.glBegin((int)7);
                    GL11.glVertex3f((float)-0.001f, (float)-0.001f, (float)0.0f);
                    GL11.glVertex3f((float)-0.007f, (float)-0.007f, (float)-0.05f);
                    GL11.glVertex3f((float)-0.007f, (float)0.007f, (float)-0.05f);
                    GL11.glVertex3f((float)-0.001f, (float)0.001f, (float)0.0f);
                    GL11.glVertex3f((float)0.001f, (float)-0.001f, (float)0.0f);
                    GL11.glVertex3f((float)0.007f, (float)-0.007f, (float)-0.05f);
                    GL11.glVertex3f((float)0.007f, (float)0.007f, (float)-0.05f);
                    GL11.glVertex3f((float)0.001f, (float)0.001f, (float)0.0f);
                    GL11.glVertex3f((float)-0.001f, (float)0.001f, (float)0.0f);
                    GL11.glVertex3f((float)-0.007f, (float)0.007f, (float)-0.05f);
                    GL11.glVertex3f((float)0.007f, (float)0.007f, (float)-0.05f);
                    GL11.glVertex3f((float)0.001f, (float)0.001f, (float)0.0f);
                    GL11.glVertex3f((float)-0.001f, (float)-0.001f, (float)0.0f);
                    GL11.glVertex3f((float)-0.007f, (float)-0.007f, (float)-0.05f);
                    GL11.glVertex3f((float)0.007f, (float)-0.007f, (float)-0.05f);
                    GL11.glVertex3f((float)0.001f, (float)-0.001f, (float)0.0f);
                    GL11.glVertex3f((float)-0.001f, (float)-0.001f, (float)0.0f);
                    GL11.glVertex3f((float)0.001f, (float)-0.001f, (float)0.0f);
                    GL11.glVertex3f((float)0.001f, (float)0.001f, (float)0.0f);
                    GL11.glVertex3f((float)-0.001f, (float)0.001f, (float)0.0f);
                    GL11.glVertex3f((float)-0.007f, (float)-0.007f, (float)-0.05f);
                    GL11.glVertex3f((float)0.007f, (float)-0.007f, (float)-0.05f);
                    GL11.glVertex3f((float)0.007f, (float)0.007f, (float)-0.05f);
                    GL11.glVertex3f((float)-0.007f, (float)0.007f, (float)-0.05f);
                    GL11.glEnd();
                    GL11.glEndList();
                } else {
                    GL11.glCallList((int)dl_id);
                }
            }
            if (bl5) {
                GL11.glBegin((int)0);
                GL11.glVertex3f((float)0.0f, (float)0.0f, (float)0.0f);
                GL11.glEnd();
            }
        }
        if (bl4) {
            if (!bl2) {
                f9 = 0.0f;
            }
            float f11 = 0.005f;
            float f12 = 0.005f;
            if (bl) {
                f11 = 0.0f;
            } else if (this.oob) {
                f12 = 0.0f;
            } else {
                f11 = 0.005f;
            }
            GL11.glBegin((int)7);
            GL11.glVertex3f((float)(-f11), (float)(-f11), (float)f9);
            GL11.glVertex3f((float)(-f12), (float)(-f12), (float)f10);
            GL11.glVertex3f((float)f12, (float)f12, (float)f10);
            GL11.glVertex3f((float)f11, (float)f11, (float)f9);
            GL11.glVertex3f((float)(-f11), (float)f11, (float)f9);
            GL11.glVertex3f((float)(-f12), (float)f12, (float)f10);
            GL11.glVertex3f((float)f12, (float)(-f12), (float)f10);
            GL11.glVertex3f((float)f11, (float)(-f11), (float)f9);
            GL11.glEnd();
        }
        if (!this.flag) {
            this.flag = true;
            if (this.oob) {
                this.x = f3;
                this.y = f7;
                this.z = f2;
            }
        }
        if (bl5) {
            GL11.glBegin((int)1);
            GL11.glVertex3f((float)0.0f, (float)0.0f, (float)f10);
            GL11.glVertex3f((float)0.0f, (float)0.0f, (float)0.0f);
            GL11.glEnd();
        }
        GL11.glPopMatrix();
        return false;
    }
}

