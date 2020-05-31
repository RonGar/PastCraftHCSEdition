/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.io.ByteArrayDataInput
 *  com.google.common.io.ByteArrayDataOutput
 *  cpw.mods.fml.common.registry.IEntityAdditionalSpawnData
 *  cuqu
 *  hcsmod.HCS
 *  hsus
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.dwbg
 */
package co.uk.flansmods.vintarz;

import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.vintarz.Util;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import hcsmod.HCS;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwbg;

public class EntityShootFX
extends Entity
implements IEntityAdditionalSpawnData {
    public EntityPlayer shooter;

    public EntityShootFX(cuqu cuqu2) {
        super(cuqu2);
        this.field_70155_l = 10.0;
        this.func_70105_a(0.5f, 0.5f);
    }

    public EntityShootFX(EntityBullet entityBullet, EntityPlayer entityPlayer) {
        super(entityBullet.field_70170_p);
        this.field_70155_l = 10.0;
        this.func_70105_a(0.5f, 0.5f);
        this.func_70012_b(entityBullet.field_70165_t, entityBullet.field_70163_u, entityBullet.field_70161_v, -entityBullet.field_70177_z, -entityBullet.field_70125_A);
        this.field_70165_t -= (double)(dwbg._a((float)(this.field_70177_z / 180.0f * 3.141593f)) * dwbg._b((float)(this.field_70125_A / 180.0f * 3.141593f)) * 0.75f);
        this.field_70161_v += (double)(dwbg._b((float)(this.field_70177_z / 180.0f * 3.141593f)) * dwbg._b((float)(this.field_70125_A / 180.0f * 3.141593f)) * 0.75f);
        this.field_70163_u -= (double)(dwbg._a((float)(this.field_70125_A / 180.0f * 3.141593f)) * 0.75f);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70129_M = 0.0f;
        this.shooter = entityPlayer;
    }

    public void func_70071_h_() {
        this.func_70106_y();
    }

    protected void func_70088_a() {
    }

    protected void func_70037_a(hsus hsus2) {
    }

    protected void func_70014_b(hsus hsus2) {
    }

    public int func_70070_b(float f) {
        return 15728880;
    }

    public float func_70013_c(float f) {
        return 1.0f;
    }

    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeInt(this.shooter.field_70157_k);
    }

    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        int n = byteArrayDataInput.readInt();
        EntityShootFX entityShootFX = this;
        Entity entity = entityShootFX.field_70170_p.func_73045_a(n);
        if (entity instanceof EntityPlayer) {
            this.shooter = (EntityPlayer)entity;
            HCS.shoot((EntityPlayer)this.shooter, (EntityShootFX)this);
            double d = this.shooter.field_70169_q;
            double d2 = this.shooter.field_70167_r;
            double d3 = this.shooter.field_70166_s;
            entityShootFX.func_70012_b(d, d2 + (double)this.shooter.func_70047_e(), d3, this.shooter.field_70177_z, this.shooter.field_70125_A);
            if (!Util.isAiming(this.shooter)) {
                entityShootFX.field_70165_t -= (double)(dwbg._b((float)(entityShootFX.field_70177_z / 180.0f * 3.141593f)) * 0.15f);
                entityShootFX.field_70161_v -= (double)(dwbg._a((float)(entityShootFX.field_70177_z / 180.0f * 3.141593f)) * 0.15f);
            }
            entityShootFX.field_70163_u -= 0.125;
            if (this.shooter.func_70093_af()) {
                entityShootFX.field_70163_u -= 0.1;
            }
            float f = this.shooter == tuor._E()._r ? 0.4f : 1.25f;
            float f2 = entityShootFX.field_70177_z;
            float f3 = entityShootFX.field_70125_A;
            entityShootFX.field_70165_t -= (double)(dwbg._a((float)(f2 / 180.0f * 3.141593f)) * dwbg._b((float)(f3 / 180.0f * 3.141593f)) * f);
            entityShootFX.field_70161_v += (double)(dwbg._b((float)(f2 / 180.0f * 3.141593f)) * dwbg._b((float)(f3 / 180.0f * 3.141593f)) * f);
            entityShootFX.field_70163_u -= (double)(dwbg._a((float)(f3 / 180.0f * 3.141593f)) * f);
            f2 = entityShootFX.field_70177_z;
            f3 = entityShootFX.field_70125_A + 90.0f;
            entityShootFX.field_70165_t -= (double)(dwbg._a((float)(f2 / 180.0f * 3.141593f)) * dwbg._b((float)(f3 / 180.0f * 3.141593f)) * 0.12f);
            entityShootFX.field_70161_v += (double)(dwbg._b((float)(f2 / 180.0f * 3.141593f)) * dwbg._b((float)(f3 / 180.0f * 3.141593f)) * 0.12f);
            entityShootFX.field_70163_u -= (double)(dwbg._a((float)(f3 / 180.0f * 3.141593f)) * 0.12f);
        }
    }
}

