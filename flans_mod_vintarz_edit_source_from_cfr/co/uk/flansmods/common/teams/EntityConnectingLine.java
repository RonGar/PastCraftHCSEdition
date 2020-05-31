/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  ieta
 *  jhvs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.entity.projectile.EntityFishHook
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.teams.ITeamBase;
import co.uk.flansmods.common.teams.ITeamObject;
import co.uk.flansmods.common.teams.ItemOpStick;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;
import net.minecraft.entity.projectile.EntityFishHook;

public class EntityConnectingLine
extends EntityFishHook {
    public Object connectedTo;

    public EntityConnectingLine(cuqu cuqu2) {
        super(cuqu2);
    }

    public EntityConnectingLine(cuqu cuqu2, EntityPlayer entityPlayer, ITeamBase iTeamBase) {
        super(cuqu2);
        this.field_70205_c = this;
        this.field_70158_ak = true;
        this.field_70204_b = entityPlayer;
        this.field_70204_b.field_71104_cf = this;
        this.func_70105_a(0.25f, 0.25f);
        this.func_70107_b(iTeamBase.getPosX(), iTeamBase.getPosY(), iTeamBase.getPosZ());
        this.field_70129_M = 0.0f;
        this.field_70159_w = 0.0;
        this.field_70179_y = 0.0;
        this.field_70181_x = 0.0;
        this.connectedTo = iTeamBase;
    }

    public EntityConnectingLine(cuqu cuqu2, EntityPlayer entityPlayer, ITeamObject iTeamObject) {
        super(cuqu2);
        this.field_70205_c = this;
        this.field_70158_ak = true;
        this.field_70204_b = entityPlayer;
        this.field_70204_b.field_71104_cf = this;
        this.func_70105_a(0.25f, 0.25f);
        this.func_70107_b(iTeamObject.getPosX(), iTeamObject.getPosY(), iTeamObject.getPosZ());
        this.field_70129_M = 0.0f;
        this.field_70159_w = 0.0;
        this.field_70179_y = 0.0;
        this.field_70181_x = 0.0;
        this.connectedTo = iTeamObject;
    }

    public void func_70071_h_() {
        ieta ieta2 = this.field_70204_b.field_71071_by._a();
        if (ieta2 == null || !(ieta2._a() instanceof ItemOpStick) || ieta2._j() != 1) {
            this.func_70106_y();
            this.field_70204_b.field_71104_cf = null;
        }
    }
}

