// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.flashlight;

import java.util.ArrayList;
import net.minecraft.client.tuor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import java.util.Iterator;
import java.io.IOException;
import java.util.List;
import java.io.File;

public class FlashlightClient
{
    public static int deltaTime;
    private static File f;
    private static boolean seeOtherPlayers;
    static dxti lastWorld;
    static final List<LightPoint> lightList;
    
    public static void initialize() {
        if (FlashlightClient.f.exists()) {
            FlashlightClient.seeOtherPlayers = true;
        }
    }
    
    public static boolean toggleOtherPlayers() {
        FlashlightClient.seeOtherPlayers = !FlashlightClient.seeOtherPlayers;
        if (FlashlightClient.seeOtherPlayers) {
            try {
                FlashlightClient.f.createNewFile();
            }
            catch (IOException ex) {}
        }
        else {
            FlashlightClient.f.delete();
        }
        return FlashlightClient.seeOtherPlayers;
    }
    
    public static boolean seeOtherPlayers() {
        return FlashlightClient.seeOtherPlayers;
    }
    
    public static int getLightValue(final dxti lastWorld, final int n, final int n2, final int n3, final int n4) {
        final int n5 = (kjsv.field_71973_m[n] != null) ? kjsv.field_71973_m[n].getLightValue(lastWorld, n2, n3, n4) : 0;
        if (lastWorld instanceof aokp) {
            return n5;
        }
        if (!lastWorld.equals(FlashlightClient.lastWorld)) {
            FlashlightClient.lastWorld = lastWorld;
            FlashlightClient.lightList.clear();
        }
        if (!FlashlightClient.lightList.isEmpty()) {
            for (final LightPoint lightPoint : FlashlightClient.lightList) {
                if (lightPoint.getX() == n2 && lightPoint.getY() == n3 && lightPoint.getZ() == n4 && 15 > n5) {
                    return 15;
                }
            }
        }
        return n5;
    }
    
    private static void addLightSource(final LightPoint lightPoint) {
        if (!FlashlightClient.lightList.contains(lightPoint)) {
            FlashlightClient.lightList.add(lightPoint);
        }
    }
    
    static {
        FlashlightClient.f = null;
        if (FMLLaunchHandler.side() == Side.CLIENT) {
            FlashlightClient.f = new File(tuor._E()._N, "flashlight");
        }
        FlashlightClient.seeOtherPlayers = true;
        lightList = new ArrayList<LightPoint>();
    }
    
    public static class LightPoint
    {
        public final float distance;
        private int prevX;
        private int prevY;
        private int prevZ;
        private int x;
        private int y;
        private int z;
        private boolean moved;
        private boolean unused;
        private boolean dead;
        
        public LightPoint(final float distance) {
            this.distance = distance;
            final int n = 0;
            this.prevZ = n;
            this.prevY = n;
            this.prevX = n;
            this.z = n;
            this.y = n;
            this.x = n;
        }
        
        public final boolean onUpdate(final cuqu cuqu) {
            if (this.moved) {
                this.moved = false;
                cuqu.func_72936_c(cuqm._b, this.prevX, this.prevY, this.prevZ);
                cuqu.func_72936_c(cuqm._b, this.x, this.y, this.z);
            }
            if (!this.unused) {
                this.unused = true;
                return false;
            }
            this.onDeath();
            return this.dead = true;
        }
        
        public final int getX() {
            return this.x;
        }
        
        public final int getY() {
            return this.y;
        }
        
        public final int getZ() {
            return this.z;
        }
        
        public void update() {
            this.unused = false;
        }
        
        public final void update(final int x, final int y, final int z) {
            if (!this.dead) {
                addLightSource(this);
            }
            this.update();
            if (x != this.x || y != this.y || z != this.z) {
                this.prevX = this.x;
                this.prevY = this.y;
                this.prevZ = this.z;
                this.x = x;
                this.y = y;
                this.z = z;
                this.moved = true;
            }
        }
        
        public final boolean isDead() {
            return this.dead;
        }
        
        protected void onDeath() {
        }
    }
}
