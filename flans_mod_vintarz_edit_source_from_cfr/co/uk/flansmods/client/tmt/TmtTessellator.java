/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.ARBBufferObject
 *  org.lwjgl.opengl.ContextCapabilities
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GLContext
 *  uheb
 *  wngx
 *  zwqa
 */
package co.uk.flansmods.client.tmt;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import org.lwjgl.opengl.ARBBufferObject;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

@SideOnly(value=Side.CLIENT)
public class TmtTessellator
extends uheb {
    private static int nativeBufferSize = 2097152;
    private static int trivertsInBuffer = nativeBufferSize / 48 * 6;
    public static boolean renderingWorldRenderer = false;
    public boolean defaultTexture = false;
    private int rawBufferSize = 0;
    public int textureID = 0;
    private static boolean convertQuadsToTriangles = false;
    private static boolean tryVBO = false;
    private static ByteBuffer byteBuffer = zwqa._c((int)(nativeBufferSize * 4));
    private static IntBuffer intBuffer = byteBuffer.asIntBuffer();
    private static FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
    private static ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
    private int[] rawBuffer;
    private int vertexCount = 0;
    private double textureU;
    private double textureV;
    private double textureW;
    private int brightness;
    private int color;
    private boolean hasColor = false;
    private boolean hasTexture = false;
    private boolean hasBrightness = false;
    private boolean hasNormals = false;
    private int rawBufferIndex = 0;
    private int addedVertices = 0;
    private boolean isColorDisabled = false;
    public int field_78409_u;
    public double field_78408_v;
    public double field_78407_w;
    public double field_78417_x;
    private int normal;
    public static TmtTessellator instance = new TmtTessellator(2097152);
    public boolean field_78415_z = false;
    private static boolean useVBO = false;
    private static IntBuffer vertexBuffers;
    private int vboIndex = 0;
    private static int vboCount;
    private int bufferSize;

    private TmtTessellator(int n) {
    }

    public TmtTessellator() {
    }

    public int func_78381_a() {
        int n;
        if (!this.field_78415_z) {
            throw new IllegalStateException("Not tesselating!");
        }
        this.field_78415_z = false;
        int n2 = 0;
        while (n2 < this.vertexCount) {
            n = this.field_78409_u == 7 && convertQuadsToTriangles ? Math.min(this.vertexCount - n2, trivertsInBuffer) : Math.min(this.vertexCount - n2, nativeBufferSize >> 5);
            intBuffer.clear();
            intBuffer.put(this.rawBuffer, n2 * 10, n * 10);
            byteBuffer.position(0);
            byteBuffer.limit(n * 40);
            n2 += n;
            if (useVBO) {
                this.vboIndex = (this.vboIndex + 1) % vboCount;
                ARBBufferObject.glBindBufferARB((int)34962, (int)vertexBuffers.get(this.vboIndex));
                ARBBufferObject.glBufferDataARB((int)34962, (ByteBuffer)byteBuffer, (int)35040);
            }
            if (this.hasTexture) {
                if (useVBO) {
                    GL11.glTexCoordPointer((int)4, (int)5126, (int)40, (long)12L);
                } else {
                    floatBuffer.position(3);
                    GL11.glTexCoordPointer((int)4, (int)40, (FloatBuffer)floatBuffer);
                }
                GL11.glEnableClientState((int)32888);
            }
            if (this.hasBrightness) {
                wngx._b((int)wngx._b);
                if (useVBO) {
                    GL11.glTexCoordPointer((int)2, (int)5122, (int)40, (long)36L);
                } else {
                    shortBuffer.position(18);
                    GL11.glTexCoordPointer((int)2, (int)40, (ShortBuffer)shortBuffer);
                }
                GL11.glEnableClientState((int)32888);
                wngx._b((int)wngx._a);
            }
            if (this.hasColor) {
                if (useVBO) {
                    GL11.glColorPointer((int)4, (int)5121, (int)40, (long)28L);
                } else {
                    byteBuffer.position(28);
                    GL11.glColorPointer((int)4, (boolean)true, (int)40, (ByteBuffer)byteBuffer);
                }
                GL11.glEnableClientState((int)32886);
            }
            if (this.hasNormals) {
                if (useVBO) {
                    GL11.glNormalPointer((int)5121, (int)40, (long)32L);
                } else {
                    byteBuffer.position(32);
                    GL11.glNormalPointer((int)40, (ByteBuffer)byteBuffer);
                }
                GL11.glEnableClientState((int)32885);
            }
            if (useVBO) {
                GL11.glVertexPointer((int)3, (int)5126, (int)40, (long)0L);
            } else {
                floatBuffer.position(0);
                GL11.glVertexPointer((int)3, (int)40, (FloatBuffer)floatBuffer);
            }
            GL11.glEnableClientState((int)32884);
            if (this.field_78409_u == 7 && convertQuadsToTriangles) {
                GL11.glDrawArrays((int)4, (int)0, (int)n);
            } else {
                GL11.glDrawArrays((int)this.field_78409_u, (int)0, (int)n);
            }
            GL11.glDisableClientState((int)32884);
            if (this.hasTexture) {
                GL11.glDisableClientState((int)32888);
            }
            if (this.hasBrightness) {
                wngx._b((int)wngx._b);
                GL11.glDisableClientState((int)32888);
                wngx._b((int)wngx._a);
            }
            if (this.hasColor) {
                GL11.glDisableClientState((int)32886);
            }
            if (!this.hasNormals) continue;
            GL11.glDisableClientState((int)32885);
        }
        if (this.rawBufferSize > 131072 && this.rawBufferIndex < this.rawBufferSize << 3) {
            this.rawBufferSize = 0;
            this.rawBuffer = null;
        }
        n = this.rawBufferIndex * 4;
        this.reset();
        return n;
    }

    private void reset() {
        this.vertexCount = 0;
        byteBuffer.clear();
        this.rawBufferIndex = 0;
        this.addedVertices = 0;
    }

    public void func_78382_b() {
        this.func_78371_b(7);
    }

    public void func_78371_b(int n) {
        if (this.field_78415_z) {
            throw new IllegalStateException("Already tesselating!");
        }
        this.field_78415_z = true;
        this.reset();
        this.field_78409_u = n;
        this.hasNormals = false;
        this.hasColor = false;
        this.hasTexture = false;
        this.hasBrightness = false;
        this.isColorDisabled = false;
    }

    public void func_78385_a(double d, double d2) {
        this.hasTexture = true;
        this.textureU = d;
        this.textureV = d2;
        this.textureW = 1.0;
    }

    public void setTextureUVW(double d, double d2, double d3) {
        this.hasTexture = true;
        this.textureU = d;
        this.textureV = d2;
        this.textureW = d3;
    }

    public void func_78380_c(int n) {
        this.hasBrightness = true;
        this.brightness = n;
    }

    public void func_78386_a(float f, float f2, float f3) {
        this.func_78376_a((int)(f * 255.0f), (int)(f2 * 255.0f), (int)(f3 * 255.0f));
    }

    public void func_78369_a(float f, float f2, float f3, float f4) {
        this.func_78370_a((int)(f * 255.0f), (int)(f2 * 255.0f), (int)(f3 * 255.0f), (int)(f4 * 255.0f));
    }

    public void func_78376_a(int n, int n2, int n3) {
        this.func_78370_a(n, n2, n3, 255);
    }

    public void func_78370_a(int n, int n2, int n3, int n4) {
        if (!this.isColorDisabled) {
            if (n > 255) {
                n = 255;
            }
            if (n2 > 255) {
                n2 = 255;
            }
            if (n3 > 255) {
                n3 = 255;
            }
            if (n4 > 255) {
                n4 = 255;
            }
            if (n < 0) {
                n = 0;
            }
            if (n2 < 0) {
                n2 = 0;
            }
            if (n3 < 0) {
                n3 = 0;
            }
            if (n4 < 0) {
                n4 = 0;
            }
            this.hasColor = true;
            this.color = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN ? n4 << 24 | n3 << 16 | n2 << 8 | n : n << 24 | n2 << 16 | n3 << 8 | n4;
        }
    }

    public void func_78374_a(double d, double d2, double d3, double d4, double d5) {
        this.func_78385_a(d4, d5);
        this.func_78377_a(d, d2, d3);
    }

    public void addVertexWithUVW(double d, double d2, double d3, double d4, double d5, double d6) {
        this.setTextureUVW(d4, d5, d6);
        this.func_78377_a(d, d2, d3);
    }

    public void func_78377_a(double d, double d2, double d3) {
        if (this.rawBufferIndex >= this.rawBufferSize - 40) {
            if (this.rawBufferSize == 0) {
                this.rawBufferSize = 65536;
                this.rawBuffer = new int[this.rawBufferSize];
            } else {
                this.rawBufferSize *= 2;
                this.rawBuffer = Arrays.copyOf(this.rawBuffer, this.rawBufferSize);
            }
        }
        ++this.addedVertices;
        if (this.field_78409_u == 7 && convertQuadsToTriangles && this.addedVertices % 4 == 0) {
            for (int i = 0; i < 2; ++i) {
                int n = 10 * (3 - i);
                if (this.hasTexture) {
                    this.rawBuffer[this.rawBufferIndex + 3] = this.rawBuffer[this.rawBufferIndex - n + 3];
                    this.rawBuffer[this.rawBufferIndex + 4] = this.rawBuffer[this.rawBufferIndex - n + 4];
                    this.rawBuffer[this.rawBufferIndex + 5] = this.rawBuffer[this.rawBufferIndex - n + 5];
                    this.rawBuffer[this.rawBufferIndex + 6] = this.rawBuffer[this.rawBufferIndex - n + 6];
                }
                if (this.hasBrightness) {
                    this.rawBuffer[this.rawBufferIndex + 9] = this.rawBuffer[this.rawBufferIndex - n + 9];
                }
                if (this.hasColor) {
                    this.rawBuffer[this.rawBufferIndex + 7] = this.rawBuffer[this.rawBufferIndex - n + 7];
                }
                this.rawBuffer[this.rawBufferIndex + 0] = this.rawBuffer[this.rawBufferIndex - n + 0];
                this.rawBuffer[this.rawBufferIndex + 1] = this.rawBuffer[this.rawBufferIndex - n + 1];
                this.rawBuffer[this.rawBufferIndex + 2] = this.rawBuffer[this.rawBufferIndex - n + 2];
                ++this.vertexCount;
                this.rawBufferIndex += 10;
            }
        }
        if (this.hasTexture) {
            this.rawBuffer[this.rawBufferIndex + 3] = Float.floatToRawIntBits((float)this.textureU);
            this.rawBuffer[this.rawBufferIndex + 4] = Float.floatToRawIntBits((float)this.textureV);
            this.rawBuffer[this.rawBufferIndex + 5] = Float.floatToRawIntBits(0.0f);
            this.rawBuffer[this.rawBufferIndex + 6] = Float.floatToRawIntBits((float)this.textureW);
        }
        if (this.hasBrightness) {
            this.rawBuffer[this.rawBufferIndex + 9] = this.brightness;
        }
        if (this.hasColor) {
            this.rawBuffer[this.rawBufferIndex + 7] = this.color;
        }
        if (this.hasNormals) {
            this.rawBuffer[this.rawBufferIndex + 8] = this.normal;
        }
        this.rawBuffer[this.rawBufferIndex + 0] = Float.floatToRawIntBits((float)(d + this.field_78408_v));
        this.rawBuffer[this.rawBufferIndex + 1] = Float.floatToRawIntBits((float)(d2 + this.field_78407_w));
        this.rawBuffer[this.rawBufferIndex + 2] = Float.floatToRawIntBits((float)(d3 + this.field_78417_x));
        this.rawBufferIndex += 10;
        ++this.vertexCount;
    }

    public void func_78378_d(int n) {
        int n2 = n >> 16 & 255;
        int n3 = n >> 8 & 255;
        int n4 = n & 255;
        this.func_78376_a(n2, n3, n4);
    }

    public void func_78384_a(int n, int n2) {
        int n3 = n >> 16 & 255;
        int n4 = n >> 8 & 255;
        int n5 = n & 255;
        this.func_78370_a(n3, n4, n5, n2);
    }

    public void func_78383_c() {
        this.isColorDisabled = true;
    }

    public void func_78375_b(float f, float f2, float f3) {
        this.hasNormals = true;
        byte by = (byte)(f * 127.0f);
        byte by2 = (byte)(f2 * 127.0f);
        byte by3 = (byte)(f3 * 127.0f);
        this.normal = by & 255 | (by2 & 255) << 8 | (by3 & 255) << 16;
    }

    public void func_78373_b(double d, double d2, double d3) {
        this.field_78408_v = d;
        this.field_78407_w = d2;
        this.field_78417_x = d3;
    }

    public void func_78372_c(float f, float f2, float f3) {
        this.field_78408_v += (double)f;
        this.field_78407_w += (double)f2;
        this.field_78417_x += (double)f3;
    }

    static {
        vboCount = 10;
        TmtTessellator.instance.defaultTexture = true;
        boolean bl = useVBO = tryVBO && GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
        if (useVBO) {
            vertexBuffers = zwqa._d((int)vboCount);
            ARBBufferObject.glGenBuffersARB((IntBuffer)vertexBuffers);
        }
    }
}

