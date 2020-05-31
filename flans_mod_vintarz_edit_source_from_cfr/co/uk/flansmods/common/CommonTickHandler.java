/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.TickType
 *  cpw.mods.fml.common.uxsf
 *  zgmv
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.uxsf;
import java.util.EnumSet;

public class CommonTickHandler
implements ITickHandler {
    public void tickStart(EnumSet enumSet, Object ... arrobject) {
    }

    public void tickEnd(EnumSet enumSet, Object ... arrobject) {
        if (enumSet.equals(EnumSet.of(TickType.SERVER))) {
            this.sTick(uxsf.instance().getMinecraftServerInstance());
        }
    }

    public void sTick(zgmv zgmv2) {
        FlansMod.playerHandler.tick();
        ++FlansMod.ticker;
    }

    public EnumSet ticks() {
        return EnumSet.of(TickType.SERVER);
    }

    public String getLabel() {
        return null;
    }
}

