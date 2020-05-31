/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ccfp
 *  com.google.common.io.ByteArrayDataInput
 *  com.google.common.io.ByteArrayDataOutput
 *  cpw.mods.fml.common.registry.IEntityAdditionalSpawnData
 *  cuqu
 *  hsus
 *  ieta
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.pico
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.ToolType;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import java.io.PrintStream;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.pico;

public class EntityParachute
extends Entity
implements IEntityAdditionalSpawnData {
    public ToolType type;

    public EntityParachute(cuqu cuqu2) {
        super(cuqu2);
        this.field_70158_ak = true;
        System.out.println(cuqu2.field_72995_K ? "Client paraspawn" : "Server paraspawn");
    }

    public EntityParachute(cuqu cuqu2, ToolType toolType, EntityPlayer entityPlayer) {
        this(cuqu2);
        this.type = toolType;
        this.func_70107_b(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (!(this.field_70170_p.field_72995_K || this.field_70153_n != null && this.field_70153_n.field_70154_o == this)) {
            this.func_70106_y();
        }
        if (this.field_70153_n != null) {
            this.field_70153_n.field_70143_R = 0.0f;
        }
        this.field_70181_x = -0.1;
        if (this.field_70153_n != null && this.field_70153_n instanceof EntityLivingBase) {
            double d = ((EntityLivingBase)this.field_70153_n).field_70701_bs;
            double d2 = ((EntityLivingBase)this.field_70153_n).field_70702_br;
            double d3 = -Math.sin(this.field_70153_n.field_70177_z * 3.1415927f / 180.0f);
            double d4 = Math.cos(this.field_70153_n.field_70177_z * 3.1415927f / 180.0f);
            this.field_70159_w += (d * d3 + d2 * d4) * 0.0020000000949949026;
            this.field_70179_y += (d * d4 - d2 * d3) * 0.0020000000949949026;
            this.field_70126_B = this.field_70177_z;
            this.field_70177_z = this.field_70153_n.field_70177_z;
        }
        this.field_70159_w *= 0.800000011920929;
        this.field_70179_y *= 0.800000011920929;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        if (this.field_70122_E || this.field_70170_p.func_72803_f(dwbg._c((double)this.field_70165_t), dwbg._c((double)this.field_70163_u), dwbg._c((double)this.field_70161_v)) == ccfp._h) {
            this.func_70106_y();
        }
    }

    protected void func_70069_a(float f) {
    }

    public boolean func_70097_a(pico pico2, float f) {
        this.func_70106_y();
        return true;
    }

    protected void func_70088_a() {
    }

    protected void func_70037_a(hsus hsus2) {
        this.type = ToolType.getType(hsus2._j("Type"));
    }

    protected void func_70014_b(hsus hsus2) {
        hsus2._a("Type", this.type.shortName);
    }

    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeUTF(this.type.shortName);
    }

    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        this.type = ToolType.getType(byteArrayDataInput.readUTF());
    }

    public ieta getPickedResult(idqh idqh2) {
        ieta ieta2 = new ieta(this.type.itemID, 1, 0);
        return ieta2;
    }
}

