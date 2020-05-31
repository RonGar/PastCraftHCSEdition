// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.hud;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.EXTFramebufferObject;
import java.io.IOException;
import org.lwjgl.opengl.GL20;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;
import net.minecraft.client.tuor;

public class DayZShader
{
    private static final tuor mc;
    public float grayscale;
    private final int program;
    private final int uGrayScale;
    private int framebufferID;
    private int colorTextureID;
    private int depthRenderBufferID;
    private int textureWidth;
    private int textureHeight;
    private float prevGrayscale;
    private boolean active;
    
    public static DayZShader createIfSupported() {
        final ContextCapabilities capabilities = GLContext.getCapabilities();
        if (capabilities.OpenGL20 && capabilities.GL_EXT_framebuffer_object && capabilities.GL_ARB_texture_non_power_of_two) {
            try {
                return new DayZShader();
            }
            catch (Exception ex) {
                return null;
            }
        }
        return null;
    }
    
    private DayZShader() throws IOException {
        this.prevGrayscale = Float.NaN;
        final StringJoiner stringJoiner = new StringJoiner("\n");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/assets/hcsmod/DayZShader.fsh")));
        Throwable t = null;
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringJoiner.add(line);
            }
            bufferedReader.close();
        }
        catch (Throwable t2) {
            t = t2;
            throw t2;
        }
        finally {
            if (t != null) {
                try {
                    bufferedReader.close();
                }
                catch (Throwable exception) {
                    t.addSuppressed(exception);
                }
            }
            else {
                bufferedReader.close();
            }
        }
        this.program = GL20.glCreateProgram();
        final int glCreateShader = GL20.glCreateShader(35632);
        GL20.glShaderSource(glCreateShader, (CharSequence)stringJoiner.toString());
        GL20.glCompileShader(glCreateShader);
        GL20.glAttachShader(this.program, glCreateShader);
        GL20.glLinkProgram(this.program);
        this.uGrayScale = GL20.glGetUniformLocation(this.program, (CharSequence)"GS");
        this.resize();
    }
    
    private void resize() {
        if (DayZShader.mc._l != this.textureWidth || DayZShader.mc._m != this.textureHeight) {
            this.textureWidth = DayZShader.mc._l;
            this.textureHeight = DayZShader.mc._m;
            if (this.framebufferID != 0) {
                EXTFramebufferObject.glDeleteFramebuffersEXT(this.framebufferID);
            }
            if (this.colorTextureID != 0) {
                GL11.glDeleteTextures(this.colorTextureID);
            }
            if (this.depthRenderBufferID != 0) {
                EXTFramebufferObject.glDeleteRenderbuffersEXT(this.depthRenderBufferID);
            }
            this.framebufferID = EXTFramebufferObject.glGenFramebuffersEXT();
            this.colorTextureID = GL11.glGenTextures();
            this.depthRenderBufferID = EXTFramebufferObject.glGenRenderbuffersEXT();
            GL11.glBindTexture(3553, 0);
            EXTFramebufferObject.glBindFramebufferEXT(36160, this.framebufferID);
            GL11.glBindTexture(3553, this.colorTextureID);
            GL11.glTexParameterf(3553, 10241, 9729.0f);
            GL11.glTexImage2D(3553, 0, 32856, this.textureWidth, this.textureHeight, 0, 6408, 5124, (ByteBuffer)null);
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064, 3553, this.colorTextureID, 0);
            EXTFramebufferObject.glBindRenderbufferEXT(36161, this.depthRenderBufferID);
            EXTFramebufferObject.glRenderbufferStorageEXT(36161, 33190, this.textureWidth, this.textureHeight);
            EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, this.depthRenderBufferID);
            EXTFramebufferObject.glBindFramebufferEXT(36160, 0);
        }
    }
    
    public void renderStart() {
        this.resize();
        if (this.framebufferID == 0) {
            return;
        }
        GL11.glBindTexture(3553, 0);
        EXTFramebufferObject.glBindFramebufferEXT(36160, this.framebufferID);
        GL11.glViewport(0, 0, this.textureWidth, this.textureHeight);
        GL11.glClear(16640);
        this.active = true;
    }
    
    public void draw(final gowi gowi) {
        if (!this.active) {
            return;
        }
        this.active = false;
        GL11.glBindTexture(3553, 0);
        EXTFramebufferObject.glBindFramebufferEXT(36160, 0);
        final boolean b = this.prevGrayscale != 0.0f || this.grayscale != 0.0f;
        if (b) {
            GL20.glUseProgram(this.program);
            if (this.grayscale != this.prevGrayscale) {
                GL20.glUniform1f(this.uGrayScale, this.grayscale);
                this.prevGrayscale = this.grayscale;
            }
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glClear(16640);
        GL11.glBindTexture(3553, this.colorTextureID);
        GL11.glDisable(3042);
        final double func_78327_c = gowi.func_78327_c();
        final double func_78324_d = gowi.func_78324_d();
        final uheb field_78398_a = uheb.field_78398_a;
        field_78398_a.func_78382_b();
        field_78398_a.func_78374_a(0.0, func_78324_d, 0.0, 0.0, 0.0);
        field_78398_a.func_78374_a(func_78327_c, func_78324_d, 0.0, 1.0, 0.0);
        field_78398_a.func_78374_a(func_78327_c, 0.0, 0.0, 1.0, 1.0);
        field_78398_a.func_78374_a(0.0, 0.0, 0.0, 0.0, 1.0);
        field_78398_a.func_78381_a();
        if (b) {
            GL20.glUseProgram(0);
        }
    }
    
    public void renderEnd() {
        if (!this.active) {
            return;
        }
        this.active = false;
        GL11.glBindTexture(3553, 0);
        EXTFramebufferObject.glBindFramebufferEXT(36160, 0);
    }
    
    static {
        mc = tuor._E();
    }
}
