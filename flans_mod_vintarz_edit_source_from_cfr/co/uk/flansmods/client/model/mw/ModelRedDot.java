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

public class ModelRedDot
extends ModelAttachment {
    public ModelRedDot() {
        this.attachmentModel = new ModelRendererTurbo[5];
        this.attachmentModel[0] = new ModelRendererTurbo(this, 0, 0, 128, 32);
        this.attachmentModel[0].addBox(-16.0f, 0.0f, -8.0f, 32, 3, 16);
        this.attachmentModel[1] = new ModelRendererTurbo(this, 96, 0, 128, 32);
        this.attachmentModel[1].addBox(15.0f, 3.0f, 7.0f, 1, 14, 1);
        this.attachmentModel[2] = new ModelRendererTurbo(this, 100, 0, 128, 32);
        this.attachmentModel[2].addBox(15.0f, 3.0f, -8.0f, 1, 14, 1);
        this.attachmentModel[3] = new ModelRendererTurbo(this, 88, 3, 128, 32);
        this.attachmentModel[3].addBox(15.0f, 17.0f, -8.0f, 1, 1, 16);
        this.attachmentModel[4] = new ModelRendererTurbo(this, 0, 0, 128, 32);
        this.attachmentModel[4].addBox(15.0f, 9.5f, -0.5f, 1, 1, 1);
    }
}

