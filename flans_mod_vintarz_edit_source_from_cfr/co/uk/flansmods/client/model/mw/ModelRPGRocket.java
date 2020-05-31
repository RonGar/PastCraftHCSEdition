/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.entity.Entity
 *  org.lwjgl.opengl.GL11
 */
package co.uk.flansmods.client.model.mw;

import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelRPGRocket
extends ModelBase {
    public ModelRendererTurbo[] bulletModel = new ModelRendererTurbo[3];

    public ModelRPGRocket() {
        this.bulletModel[0] = new ModelRendererTurbo(this, 14, 12, 64, 32);
        this.bulletModel[0].addBox(-1.5f, 0.0f, -1.5f, 3, 1, 3);
        this.bulletModel[1] = new ModelRendererTurbo(this, 26, 9, 64, 32);
        this.bulletModel[1].addTrapezoid(-2.0f, 1.0f, -2.0f, 4, 3, 4, 0.0f, -1.0f, 4);
        this.bulletModel[2] = new ModelRendererTurbo(this, 38, 6, 64, 32);
        this.bulletModel[2].addTrapezoid(-2.0f, 4.0f, -2.0f, 4, 3, 4, 0.0f, -1.0f, 5);
    }

    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        for (ModelRendererTurbo modelRendererTurbo : this.bulletModel) {
            modelRendererTurbo.func_78785_a(f6);
        }
    }
}

