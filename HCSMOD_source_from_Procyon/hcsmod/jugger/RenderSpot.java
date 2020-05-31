// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.jugger;

import java.util.ArrayList;
import java.util.List;

public class RenderSpot
{
    private static final List<RenderColor> TYPES;
    public static final byte UNKNOWN;
    public static final byte ZOMBIE;
    public static final byte PLAYER_OTHER;
    public static final byte PLAYER_FRIEND;
    public static final byte PLAYER_ADMIN;
    public static final byte ANIMAL;
    public static final byte VEH_AIR;
    public static final byte VEH_LAND;
    public final float x;
    public final float z;
    public final float d;
    public final RenderColor c;
    
    public RenderSpot(final byte b, final byte b2, final byte b3) {
        this.x = b;
        this.z = b2;
        this.d = (float)Math.sqrt(this.x * this.x + this.z * this.z);
        this.c = RenderSpot.TYPES.get(b3);
    }
    
    static {
        TYPES = new ArrayList<RenderColor>();
        UNKNOWN = new RenderColor(0.75f, 0.75f, 0.75f).id();
        ZOMBIE = new RenderColor(0.75f, 0.0f, 0.0f).id();
        PLAYER_OTHER = new RenderColor(0.75f, 0.75f, 0.0f).id();
        PLAYER_FRIEND = new RenderColor(0.0f, 0.75f, 0.0f).id();
        PLAYER_ADMIN = new RenderColor(0.0f, 0.0f, 0.0f).id();
        ANIMAL = new RenderColor(0.0f, 0.0f, 0.75f).id();
        VEH_AIR = new RenderColor(0.0f, 0.75f, 0.75f).id();
        VEH_LAND = new RenderColor(0.75f, 0.0f, 0.75f).id();
    }
    
    public static class RenderColor
    {
        public final float r;
        public final float g;
        public final float b;
        
        public RenderColor(final float r, final float g, final float b) {
            this.r = r;
            this.g = g;
            this.b = b;
            RenderSpot.TYPES.add(this);
        }
        
        public byte id() {
            return (byte)RenderSpot.TYPES.indexOf(this);
        }
    }
}
