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

public class ModelForegrip
extends ModelAttachment {
    public ModelForegrip() {
        this.attachmentModel = new ModelRendererTurbo[2];
        this.attachmentModel[0] = new ModelRendererTurbo(this, 0, 0, 16, 8);
        this.attachmentModel[0].addBox(-2.0f, -1.0f, -1.0f, 4, 1, 2);
        this.attachmentModel[1] = new ModelRendererTurbo(this, 10, 1, 16, 8);
        this.attachmentModel[1].addBox(-1.0f, -6.0f, -1.0f, 2, 5, 2);
    }
}

