/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.client.model.ModelBase;

public class ModelDriveable
extends ModelBase {
    public static final float pi = 3.1415927f;
    public static final float tau = 6.2831855f;
    public HashMap gunModels = new HashMap();
    public ModelRendererTurbo[] bodyModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] bodyDoorOpenModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] bodyDoorCloseModel = new ModelRendererTurbo[0];

    public void render(EntityDriveable entityDriveable, float f) {
    }

    public void render(DriveableType driveableType) {
        this.renderPart(this.bodyModel);
        this.renderPart(this.bodyDoorCloseModel);
        Iterator iterator = this.gunModels.values().iterator();
        while (iterator.hasNext()) {
            ModelRendererTurbo[][] arrmodelRendererTurbo;
            ModelRendererTurbo[][] arrmodelRendererTurbo2 = arrmodelRendererTurbo = (ModelRendererTurbo[][])iterator.next();
            int n = arrmodelRendererTurbo.length;
            for (int i = 0; i < n; ++i) {
                ModelRendererTurbo[] arrmodelRendererTurbo3 = arrmodelRendererTurbo2[i];
                this.renderPart(arrmodelRendererTurbo3);
            }
        }
    }

    public void renderPart(ModelRendererTurbo[] arrmodelRendererTurbo) {
        ModelRendererTurbo[] arrmodelRendererTurbo2 = arrmodelRendererTurbo;
        int n = arrmodelRendererTurbo.length;
        for (int i = 0; i < n; ++i) {
            ModelRendererTurbo modelRendererTurbo = arrmodelRendererTurbo2[i];
            modelRendererTurbo.func_78785_a(0.0625f);
        }
    }

    public void registerGunModel(String string, ModelRendererTurbo[][] arrmodelRendererTurbo) {
        this.gunModels.put(string, arrmodelRendererTurbo);
    }

    protected void flip(ModelRendererTurbo[] arrmodelRendererTurbo) {
        ModelRendererTurbo[] arrmodelRendererTurbo2 = arrmodelRendererTurbo;
        int n = arrmodelRendererTurbo.length;
        for (int i = 0; i < n; ++i) {
            ModelRendererTurbo modelRendererTurbo = arrmodelRendererTurbo2[i];
            modelRendererTurbo.doMirror(false, true, true);
            modelRendererTurbo.func_78793_a(modelRendererTurbo.field_78800_c, -modelRendererTurbo.field_78797_d, -modelRendererTurbo.field_78798_e);
        }
    }

    public void flipAll() {
        this.flip(this.bodyModel);
        this.flip(this.bodyDoorOpenModel);
        this.flip(this.bodyDoorCloseModel);
        Iterator iterator = this.gunModels.values().iterator();
        while (iterator.hasNext()) {
            ModelRendererTurbo[][] arrmodelRendererTurbo;
            ModelRendererTurbo[][] arrmodelRendererTurbo2 = arrmodelRendererTurbo = (ModelRendererTurbo[][])iterator.next();
            int n = arrmodelRendererTurbo.length;
            for (int i = 0; i < n; ++i) {
                ModelRendererTurbo[] arrmodelRendererTurbo3 = arrmodelRendererTurbo2[i];
                this.flip(arrmodelRendererTurbo3);
            }
        }
    }

    protected void translate(ModelRendererTurbo[] arrmodelRendererTurbo, float f, float f2, float f3) {
        ModelRendererTurbo[] arrmodelRendererTurbo2 = arrmodelRendererTurbo;
        int n = arrmodelRendererTurbo.length;
        for (int i = 0; i < n; ++i) {
            ModelRendererTurbo modelRendererTurbo = arrmodelRendererTurbo2[i];
            modelRendererTurbo.field_78800_c += f;
            modelRendererTurbo.field_78797_d += f2;
            modelRendererTurbo.field_78798_e += f3;
        }
    }

    public void translateAll(float f, float f2, float f3) {
        this.translate(this.bodyModel, f, f2, f3);
        this.translate(this.bodyDoorOpenModel, f, f2, f3);
        this.translate(this.bodyDoorCloseModel, f, f2, f3);
        Iterator iterator = this.gunModels.values().iterator();
        while (iterator.hasNext()) {
            ModelRendererTurbo[][] arrmodelRendererTurbo;
            ModelRendererTurbo[][] arrmodelRendererTurbo2 = arrmodelRendererTurbo = (ModelRendererTurbo[][])iterator.next();
            int n = arrmodelRendererTurbo.length;
            for (int i = 0; i < n; ++i) {
                ModelRendererTurbo[] arrmodelRendererTurbo3 = arrmodelRendererTurbo2[i];
                this.translate(arrmodelRendererTurbo3, f, f2, f3);
            }
        }
    }

    public void translateAll(int n, int n2, int n3) {
        this.translateAll((float)n, (float)n2, (float)n3);
    }
}

