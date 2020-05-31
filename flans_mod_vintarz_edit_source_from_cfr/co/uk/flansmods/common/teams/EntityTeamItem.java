/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.io.ByteArrayDataInput
 *  com.google.common.io.ByteArrayDataOutput
 *  cpw.mods.fml.common.registry.GameRegistry
 *  cpw.mods.fml.common.registry.IEntityAdditionalSpawnData
 *  cuqu
 *  hclw
 *  hsus
 *  ieta
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.pico
 *  net.minecraftforge.common.bpzx
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.Event$eidn
 *  net.minecraftforge.event.eidl
 *  zxiv
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TileEntitySpawner;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;
import net.minecraft.util.pico;
import net.minecraftforge.common.bpzx;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.eidl;

public class EntityTeamItem
extends EntityItem
implements IEntityAdditionalSpawnData {
    public TileEntitySpawner spawner;
    public double angle;
    public int xCoord;
    public int yCoord;
    public int zCoord;

    public EntityTeamItem(TileEntitySpawner tileEntitySpawner, int n) {
        super(tileEntitySpawner.field_70331_k, (double)((float)tileEntitySpawner.field_70329_l + 0.5f), (double)((float)tileEntitySpawner.field_70330_m + 0.5f), (double)((float)tileEntitySpawner.field_70327_n + 0.5f), tileEntitySpawner.stacksToSpawn.get(n)._l());
        tileEntitySpawner.itemEntities.add(this);
        this.angle = (double)n * 3.141592653589793 * 2.0 / (double)tileEntitySpawner.stacksToSpawn.size();
        this.field_70179_y = 0.0;
        this.field_70181_x = 0.0;
        this.field_70159_w = 0.0;
        this.lifespan = 1000000000;
        this.spawner = tileEntitySpawner;
    }

    public EntityTeamItem(cuqu cuqu2) {
        super(cuqu2);
    }

    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
    }

    public void func_70071_h_() {
        ++this.field_70173_aa;
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.field_70126_B = this.field_70177_z;
        ++this.field_70292_b;
        if (this.field_70170_p.field_72995_K) {
            this.angle += 0.05;
            this.func_70107_b((double)((float)this.xCoord + 0.5f) + Math.cos(this.angle) * 0.30000001192092896, (double)((float)this.yCoord + 0.5f), (double)((float)this.zCoord + 0.5f) + Math.sin(this.angle) * 0.30000001192092896);
        }
    }

    public boolean attackEntityFrom(pico pico2, int n) {
        return false;
    }

    public void func_70100_b_(EntityPlayer entityPlayer) {
        if (!this.field_70170_p.field_72995_K) {
            hclw hclw2 = new hclw(entityPlayer, (EntityItem)this);
            if (bpzx.EVENT_BUS.post((Event)hclw2)) {
                return;
            }
            Team team = this.spawner.getTeam();
            Team team2 = FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayer).team;
            if (team != null && team2 != team) {
                return;
            }
            int n = this.func_92059_d()._b;
            if (hclw2.getResult() == Event.eidn.ALLOW || n <= 0 || entityPlayer.field_71071_by._c(this.func_92059_d())) {
                GameRegistry.onPickupNotification((EntityPlayer)entityPlayer, (EntityItem)this);
                this.func_85030_a("random.pop", 0.2f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                entityPlayer.func_71001_a((Entity)this, n);
                if (this.func_92059_d()._b <= 0) {
                    this.spawner.itemEntities.remove((Object)this);
                    this.func_70106_y();
                }
            }
        }
    }

    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        try {
            byteArrayDataOutput.writeInt(this.spawner.field_70329_l);
            byteArrayDataOutput.writeInt(this.spawner.field_70330_m);
            byteArrayDataOutput.writeInt(this.spawner.field_70327_n);
            byteArrayDataOutput.writeDouble(this.angle);
            hsus hsus2 = new hsus();
            this.func_92059_d()._b(hsus2);
            zxiv._a((zxiv)hsus2, (DataOutput)byteArrayDataOutput);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.func_70106_y();
        }
    }

    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        try {
            this.xCoord = byteArrayDataInput.readInt();
            this.yCoord = byteArrayDataInput.readInt();
            this.zCoord = byteArrayDataInput.readInt();
            this.angle = byteArrayDataInput.readDouble();
            this.func_92058_a(ieta._a((hsus)((hsus)zxiv._a((DataInput)byteArrayDataInput))));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void func_70037_a(hsus hsus2) {
        this.func_70106_y();
    }
}

