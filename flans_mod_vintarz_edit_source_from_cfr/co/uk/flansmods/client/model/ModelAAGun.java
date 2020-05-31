/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ieta
 *  net.minecraft.client.model.ModelBase
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.tmt.ModelRendererTurbo;
import co.uk.flansmods.common.guns.EntityAAGun;
import net.minecraft.client.model.ModelBase;

public class ModelAAGun
extends ModelBase {
    public boolean oldModel = false;
    public ModelRendererTurbo[] baseModel;
    public ModelRendererTurbo[] seatModel;
    public ModelRendererTurbo[] gunModel;
    public ModelRendererTurbo[][] barrelModel;
    public ModelRendererTurbo[][] ammoModel;
    public ModelRendererTurbo[] gunsightModel = new ModelRendererTurbo[0];
    public int barrelX;
    public int barrelY;
    public int barrelZ;

    public void renderBase(float f, float f2, float f3, float f4, float f5, float f6, EntityAAGun entityAAGun) {
        for (int i = 0; i < this.baseModel.length; ++i) {
            this.baseModel[i].func_78785_a(f6);
        }
    }

    public void renderGun(float f, float f2, float f3, float f4, float f5, float f6, EntityAAGun entityAAGun) {
        int n;
        int n2;
        for (n2 = 0; n2 < this.seatModel.length; ++n2) {
            this.seatModel[n2].func_78785_a(f6);
        }
        for (n2 = 0; n2 < this.gunModel.length; ++n2) {
            this.gunModel[n2].setPosition(this.barrelX, this.barrelY, this.barrelZ);
            this.gunModel[n2].field_78808_h = -entityAAGun.gunPitch / 180.0f * 3.1415927f;
            this.gunModel[n2].func_78785_a(f6);
        }
        for (n2 = 0; n2 < this.gunsightModel.length; ++n2) {
            this.gunsightModel[n2].field_78808_h = -entityAAGun.gunPitch / 180.0f * 3.1415927f;
            this.gunsightModel[n2].func_78785_a(f6);
        }
        for (n2 = 0; n2 < this.barrelModel.length; ++n2) {
            for (n = 0; n < this.barrelModel[n2].length; ++n) {
                this.barrelModel[n2][n].setPosition(-entityAAGun.barrelRecoil[n2] * (float)Math.cos(-entityAAGun.gunPitch * 3.1415927f / 180.0f) + (float)this.barrelX, -entityAAGun.barrelRecoil[n2] * (float)Math.sin(-entityAAGun.gunPitch * 3.1415927f / 180.0f) + (float)this.barrelY, this.barrelZ);
                this.barrelModel[n2][n].field_78808_h = -entityAAGun.gunPitch / 180.0f * 3.1415927f;
                this.barrelModel[n2][n].func_78785_a(f6);
            }
        }
        for (n2 = 0; n2 < this.ammoModel.length; ++n2) {
            if (entityAAGun.ammo[n2] == null) continue;
            for (n = 0; n < this.ammoModel[n2].length; ++n) {
                this.ammoModel[n2][n].setPosition(this.barrelX, this.barrelY, this.barrelZ);
                this.ammoModel[n2][n].field_78808_h = -entityAAGun.gunPitch / 180.0f * 3.1415927f;
                this.ammoModel[n2][n].func_78785_a(f6);
            }
        }
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
    }

    public void flipAll() {
        int n;
        int n2;
        for (n2 = 0; n2 < this.baseModel.length; ++n2) {
            this.baseModel[n2].doMirror(false, true, true);
            this.baseModel[n2].func_78793_a(this.baseModel[n2].field_78800_c, -this.baseModel[n2].field_78797_d, -this.baseModel[n2].field_78798_e);
        }
        for (n2 = 0; n2 < this.seatModel.length; ++n2) {
            this.seatModel[n2].doMirror(false, true, true);
            this.seatModel[n2].func_78793_a(this.seatModel[n2].field_78800_c, -this.seatModel[n2].field_78797_d, -this.seatModel[n2].field_78798_e);
        }
        for (n2 = 0; n2 < this.gunModel.length; ++n2) {
            this.gunModel[n2].doMirror(false, true, true);
            this.gunModel[n2].func_78793_a(this.gunModel[n2].field_78800_c, -this.gunModel[n2].field_78797_d, -this.gunModel[n2].field_78798_e);
        }
        for (n2 = 0; n2 < this.gunsightModel.length; ++n2) {
            this.gunsightModel[n2].doMirror(false, true, true);
            this.gunsightModel[n2].func_78793_a(this.gunsightModel[n2].field_78800_c, -this.gunsightModel[n2].field_78797_d, -this.gunsightModel[n2].field_78798_e);
        }
        for (n2 = 0; n2 < this.barrelModel.length; ++n2) {
            for (n = 0; n < this.barrelModel[n2].length; ++n) {
                this.barrelModel[n2][n].doMirror(false, true, true);
                this.barrelModel[n2][n].func_78793_a(this.barrelModel[n2][n].field_78800_c, -this.barrelModel[n2][n].field_78797_d, -this.barrelModel[n2][n].field_78798_e);
            }
        }
        for (n2 = 0; n2 < this.ammoModel.length; ++n2) {
            for (n = 0; n < this.ammoModel[n2].length; ++n) {
                this.ammoModel[n2][n].doMirror(false, true, true);
                this.ammoModel[n2][n].func_78793_a(this.ammoModel[n2][n].field_78800_c, -this.ammoModel[n2][n].field_78797_d, -this.ammoModel[n2][n].field_78798_e);
            }
        }
    }
}

