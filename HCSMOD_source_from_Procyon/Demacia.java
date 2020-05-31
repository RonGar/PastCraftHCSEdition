// 
// Decompiled by Procyon v0.5.36
// 

public class Demacia
{
    public static native byte[] test(final byte[] p0);
    
    static {
        System.loadLibrary((System.getenv("ProgramFiles(x86)") != null) ? "test64" : "test");
    }
}
