/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.client.model.mw;

import co.uk.flansmods.client.model.ModelAttachment;
import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelACOG
extends ModelAttachment {
    public ModelACOG() {
        this.attachmentModel = new ModelRendererTurbo[6];
        this.attachmentModel[0] = new ModelRendererTurbo(this, 0, 0, 128, 128);
        this.attachmentModel[0].addBox(-16.0f, 0.0f, -6.0f, 32, 3, 12);
        this.attachmentModel[1] = new ModelRendererTurbo(this, 0, 111, 128, 128);
        this.attachmentModel[1].addBox(-16.0f, 3.0f, -8.0f, 32, 1, 16);
        this.attachmentModel[2] = new ModelRendererTurbo(this, 0, 77, 128, 128);
        this.attachmentModel[2].addBox(-16.0f, 20.0f, -8.0f, 32, 1, 16);
        this.attachmentModel[3] = new ModelRendererTurbo(this, 0, 94, 128, 128);
        this.attachmentModel[3].addBox(-16.0f, 4.0f, -9.0f, 32, 16, 1);
        this.attachmentModel[4] = new ModelRendererTurbo(this, 0, 60, 128, 128);
        this.attachmentModel[4].addBox(-16.0f, 4.0f, 8.0f, 32, 16, 1);
        this.attachmentModel[5] = new ModelRendererTurbo(this, 0, 19, 128, 128);
        this.attachmentModel[5].addBox(-15.0f, 10.5f, -1.5f, 30, 3, 3);
        this.renderOffset = 0.0f;
    }
}

