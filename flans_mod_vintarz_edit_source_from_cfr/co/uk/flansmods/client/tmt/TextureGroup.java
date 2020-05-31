/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  dfsc
 *  net.minecraft.util.ResourceLocation
 *  zfwe
 */
package co.uk.flansmods.client.tmt;

import co.uk.flansmods.client.tmt.TexturedPolygon;
import java.util.ArrayList;
import net.minecraft.util.ResourceLocation;

public class TextureGroup {
    public ArrayList<TexturedPolygon> poly = new ArrayList();
    public String texture = "";

    public void addPoly(TexturedPolygon texturedPolygon) {
        this.poly.add(texturedPolygon);
    }

    public void loadTexture() {
        this.loadTexture(-1);
    }

    public void loadTexture(int n) {
        if (!this.texture.equals("")) {
            zfwe zfwe2 = dfsc._b._g;
            zfwe2._a(new ResourceLocation("", this.texture));
        } else if (n > -1) {
            dfsc._b._g._a(new ResourceLocation("", ""));
        }
    }
}

