/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.client.model.mw;

import co.uk.flansmods.client.model.mw.ModelM9;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelM1911
extends ModelM9 {
    public ModelM1911() {
        this.gunModel = new ModelRendererTurbo[4];
        this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, 32, 16);
        this.gunModel[0].addBox(-1.0f, 0.0f, -1.0f, 3, 2, 2);
        this.gunModel[1] = new ModelRendererTurbo(this, 20, 0, 32, 16);
        this.gunModel[1].addBox(-2.0f, -2.0f, -1.0f, 3, 2, 2);
        this.gunModel[2] = new ModelRendererTurbo(this, 0, 6, 32, 16);
        this.gunModel[2].addBox(-1.0f, 2.0f, -1.0f, 8, 1, 2);
        this.gunModel[3] = new ModelRendererTurbo(this, 0, 9, 32, 16);
        this.gunModel[3].addBox(-0.5f, 3.5f, -0.5f, 8, 1, 1);
        this.ammoModel[0] = new ModelRendererTurbo(this, 14, 0, 32, 16);
        this.ammoModel[0].addBox(-1.0f, -1.8f, -0.5f, 2, 4, 1);
    }
}

