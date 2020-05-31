/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  hrvk
 *  net.minecraft.client.tuor
 *  net.minecraft.util.ResourceLocation
 *  rojd
 */
package co.uk.flansmods.client;

import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.guns.GunType;
import java.util.HashMap;
import net.minecraft.client.tuor;
import net.minecraft.util.ResourceLocation;

public class FlansModResourceHandler {
    private static HashMap iconMap = new HashMap();
    private static HashMap textureMap = new HashMap();
    private static HashMap scopeMap = new HashMap();
    private static HashMap soundMap = new HashMap();

    public static ResourceLocation getIcon(InfoType infoType) {
        if (iconMap.containsKey(infoType)) {
            return (ResourceLocation)iconMap.get(infoType);
        }
        ResourceLocation resourceLocation = new ResourceLocation("flansmod", "textures/items/" + infoType.iconPath + ".png");
        iconMap.put(infoType, resourceLocation);
        return resourceLocation;
    }

    public static ResourceLocation getTexture(InfoType infoType) {
        if (textureMap.containsKey(infoType)) {
            return (ResourceLocation)textureMap.get(infoType);
        }
        ResourceLocation resourceLocation = new ResourceLocation("flansmod", "skins/" + infoType.texture + ".png");
        textureMap.put(infoType, resourceLocation);
        return resourceLocation;
    }

    public static ResourceLocation getDeployableTexture(GunType gunType) {
        if (textureMap.containsKey(gunType)) {
            return (ResourceLocation)textureMap.get(gunType);
        }
        ResourceLocation resourceLocation = new ResourceLocation("flansmod", "skins/" + gunType.deployableTexture + ".png");
        textureMap.put(gunType, resourceLocation);
        return resourceLocation;
    }

    public static ResourceLocation getScope(String string) {
        if (scopeMap.containsKey(string)) {
            return (ResourceLocation)scopeMap.get(string);
        }
        ResourceLocation resourceLocation = new ResourceLocation("flansmod", "gui/" + string + ".png");
        scopeMap.put(string, resourceLocation);
        return resourceLocation;
    }

    public static void getSound(String string, String string2, String string3) {
        rojd.instance().getClient()._L._a("flansmod:" + string3 + ".ogg");
    }
}

