/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ieta
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 */
package co.uk.flansmods.client.model;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;

public class GunAnimations {
    public static GunAnimations defaults = new GunAnimations();
    public float gunSlide = 0.0f;
    public float lastGunSlide = 0.0f;
    public int timeUntilPump = 0;
    public int timeToPumpFor = 0;
    public float pumped = -1.0f;
    public float lastPumped = -1.0f;
    public boolean pumping = false;
    public boolean reloading = false;
    public float reloadAnimationTime = 0.0f;
    public float reloadAnimationProgress = 0.0f;
    public float lastReloadAnimationProgress = 0.0f;
    public ieta is;

    public void update() {
        ieta._b((ieta)this.is, (ieta)tuor._E()._r.func_71045_bC());
        this.lastPumped = this.pumped;
        if (this.timeUntilPump > 0) {
            --this.timeUntilPump;
            if (this.timeUntilPump == 0) {
                this.pumping = true;
                this.pumped = -1.0f;
                this.lastPumped = -1.0f;
            }
        }
        if (this.pumping) {
            this.pumped += 2.0f / (float)this.timeToPumpFor;
            if (this.pumped >= 0.999f) {
                this.pumping = false;
            }
        }
        this.lastGunSlide = this.gunSlide;
        if (this.gunSlide > 0.0f) {
            this.gunSlide *= 0.85f;
        }
        this.lastReloadAnimationProgress = this.reloadAnimationProgress;
        if (this.reloading) {
            this.reloadAnimationProgress += 1.0f / this.reloadAnimationTime;
        }
        if (this.reloading && this.reloadAnimationProgress >= 1.0f) {
            this.reloading = false;
        }
    }

    public void doShoot(int n, int n2) {
        this.gunSlide = 1.0f;
        this.lastGunSlide = 1.0f;
        this.timeUntilPump = n;
        this.timeToPumpFor = n2;
    }

    public void doReload(int n, int n2, int n3) {
        this.is = tuor._E()._r.func_71045_bC();
        this.reloading = true;
        this.reloadAnimationProgress = 0.0f;
        this.lastReloadAnimationProgress = 0.0f;
        this.reloadAnimationTime = n;
        this.timeUntilPump = n2;
        this.timeToPumpFor = n3;
    }
}

