/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.entity.Entity
 */
package co.uk.flansmods.client.model.ww2;

import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelWW2Parachute
extends ModelBase {
    public ModelRendererTurbo backpackModel = new ModelRendererTurbo(this, 0, 0, 128, 128);
    public ModelRendererTurbo[] parachuteModel = new ModelRendererTurbo[6];

    public ModelWW2Parachute() {
        this.backpackModel.addBox(-4.0f, 26.0f, -6.0f, 8, 12, 2);
        this.parachuteModel[0] = new ModelRendererTurbo(this, 0, 16, 128, 128);
        this.parachuteModel[0].addTrapezoid(-12.0f, 38.0f, -12.0f, 24, 24, 24, 0.0f, -8.0f, 4);
        this.parachuteModel[1] = new ModelRendererTurbo(this, 72, 0, 128, 128);
        this.parachuteModel[1].addTrapezoid(-8.0f, 62.0f, -8.0f, 16, 8, 16, 0.0f, 4.0f, 4);
        this.parachuteModel[2] = new ModelRendererTurbo(this, 0, 64, 128, 128);
        this.parachuteModel[2].addTrapezoid(-8.0f, 70.0f, -8.0f, 16, 4, 16, 0.0f, -4.0f, 5);
        this.parachuteModel[3] = new ModelRendererTurbo(this, 0, 16, 128, 128);
        this.parachuteModel[3].flip = true;
        this.parachuteModel[3].addTrapezoid(-12.0f, 38.0f, -12.0f, 24, 24, 24, 0.0f, -8.0f, 4);
        this.parachuteModel[4] = new ModelRendererTurbo(this, 72, 0, 128, 128);
        this.parachuteModel[4].flip = true;
        this.parachuteModel[4].addTrapezoid(-8.0f, 62.0f, -8.0f, 16, 8, 16, 0.0f, 4.0f, 4);
        this.parachuteModel[5] = new ModelRendererTurbo(this, 0, 64, 128, 128);
        this.parachuteModel[5].flip = true;
        this.parachuteModel[5].addTrapezoid(-8.0f, 70.0f, -8.0f, 16, 4, 16, 0.0f, -4.0f, 5);
    }

    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.backpackModel.func_78785_a(f6);
        for (ModelRendererTurbo modelRendererTurbo : this.parachuteModel) {
            modelRendererTurbo.func_78785_a(f6);
        }
    }
}

