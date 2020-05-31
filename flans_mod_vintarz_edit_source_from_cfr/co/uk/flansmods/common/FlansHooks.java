/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.Loader
 *  ieta
 *  jhvs
 */
package co.uk.flansmods.common;

import cpw.mods.fml.common.Loader;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class FlansHooks {
    public Class BuildCraftEnergy;
    public ieta BuildCraftFuelBucket;
    public ieta BuildCraftOilBucket;
    public boolean BuildCraftLoaded;

    public void hook() {
        if (Loader.isModLoaded((String)"BuildCraft|Energy")) {
            this.BuildCraftFuelBucket = this.getBuildCraftItem("bucketFuel");
            this.BuildCraftOilBucket = this.getBuildCraftItem("bucketOil");
            System.out.println("[Flan] BuildCraft integration loaded.");
            this.BuildCraftLoaded = true;
        }
    }

    public ieta getBuildCraftItem(String string) {
        try {
            Object object;
            if (this.BuildCraftEnergy == null) {
                this.BuildCraftEnergy = Class.forName("buildcraft.BuildCraftEnergy");
            }
            if (this.BuildCraftEnergy == null) {
                this.BuildCraftEnergy = Class.forName("net.minecraft.src.buildcraft.BuildCraftEnergy");
            }
            if ((object = this.BuildCraftEnergy.getField(string).get(null)) instanceof jhvs) {
                return new ieta((jhvs)object);
            }
            throw new Exception();
        }
        catch (Exception exception) {
            System.out.println("[Flan] Unable to retrieve BuildCraft item " + string + ".");
            return null;
        }
    }
}

