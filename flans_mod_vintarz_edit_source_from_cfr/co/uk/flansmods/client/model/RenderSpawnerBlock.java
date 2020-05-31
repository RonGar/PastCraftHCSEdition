/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  dfta
 *  dxti
 *  kjsv
 *  owbd
 */
package co.uk.flansmods.client.model;

public class RenderSpawnerBlock
implements owbd {
    public void renderInventoryBlock(kjsv kjsv2, int n, int n2, dfta dfta2) {
    }

    public boolean renderWorldBlock(dxti dxti2, int n, int n2, int n3, kjsv kjsv2, int n4, dfta dfta2) {
        dfta2._a(kjsv2, n, n2, n3);
        return false;
    }

    public boolean shouldRender3DInInventory() {
        return false;
    }

    public int getRenderId() {
        return 0;
    }
}

