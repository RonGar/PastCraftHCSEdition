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

public class ModelSilencer
extends ModelAttachment {
    public ModelSilencer() {
        this.attachmentModel = new ModelRendererTurbo[1];
        this.attachmentModel[0] = new ModelRendererTurbo(this, 0, 0, 16, 4);
        this.attachmentModel[0].addBox(0.0f, -1.0f, -1.0f, 6, 2, 2);
    }
}

