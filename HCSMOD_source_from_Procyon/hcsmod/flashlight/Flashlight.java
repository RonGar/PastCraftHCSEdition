// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.flashlight;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.bpzx;
import cpw.mods.fml.common.registry.LanguageRegistry;
import hcsmod.HCS;
import cpw.mods.fml.common.event.FMLInitializationEvent;

public class Flashlight
{
    public static final int itemID = 8267;
    public static Flashlight instance;
    public static jhvs flashlight;
    public static jhvs battery;
    
    private Flashlight() {
    }
    
    public void Init(final FMLInitializationEvent fmlInitializationEvent) {
        Flashlight.flashlight = new ItemFlashlight(8267).func_77655_b("flashlight").func_77625_d(1).func_77637_a(HCS.modcreativetab);
        Flashlight.battery = new ItemBattery(7456).func_77655_b("battery").func_77625_d(1).func_77637_a(HCS.modcreativetab);
        LanguageRegistry.addName((Object)Flashlight.flashlight, "\u0424\u043e\u043d\u0430\u0440\u0438\u043a");
        LanguageRegistry.addName((Object)Flashlight.battery, "\u0411\u0430\u0442\u0430\u0440\u0435\u0439\u043a\u0430");
        bpzx.EVENT_BUS.register((Object)this);
    }
    
    public void preInit(final FMLPreInitializationEvent fmlPreInitializationEvent) {
    }
    
    public void postInit(final FMLPostInitializationEvent fmlPostInitializationEvent) {
        if (Side.CLIENT == FMLLaunchHandler.side()) {
            TickRegistry.registerTickHandler((ITickHandler)new TickHandler(), Side.CLIENT);
            FlashlightClient.initialize();
            bpzx.registerKeyBinding((bpzx.uxsf)new KeyHandler());
        }
        TickRegistry.registerTickHandler((ITickHandler)new TickHandler(), Side.SERVER);
    }
    
    public static int getFlashlightTime(final boolean b) {
        return (int)(System.currentTimeMillis() / 1000L - 1530220589L);
    }
    
    public static int getFlashlightTime(final int n) {
        return getFlashlightTime(true) - n;
    }
    
    static {
        Flashlight.instance = new Flashlight();
    }
}
