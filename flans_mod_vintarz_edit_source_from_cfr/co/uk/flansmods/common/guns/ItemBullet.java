/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  ieta
 *  jhvs
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.roij
 *  net.minecraft.util.samw
 *  qlze
 *  tekj
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.vector.Vector3f;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.roij;
import net.minecraft.util.samw;

public class ItemBullet
extends jhvs {
    public BulletType type;

    public ItemBullet(int n, BulletType bulletType) {
        super(n);
        this.type = bulletType;
        this.func_77656_e(this.type.roundsPerItem);
        this.func_77625_d(this.type.maxStackSize);
        this.func_77627_a(true);
        this.type.item = this;
        this.func_77637_a((tekj)FlansMod.tabFlanGuns);
    }

    @SideOnly(value=Side.CLIENT)
    public int func_82790_a(ieta ieta2, int n) {
        return this.type.colour;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(qlze qlze2) {
        this.field_77791_bV = qlze2._a("FlansMod:" + this.type.iconPath);
    }

    public void func_77624_a(ieta ieta2, EntityPlayer entityPlayer, List list, boolean bl) {
        list.add("\u041f\u0430\u0442\u0440\u043e\u043d\u044b: " + (ieta2._k() - ieta2._j()) + "/" + ieta2._k());
        if (this.type.description != null) {
            for (String string : this.type.description.split("_")) {
                list.add(string);
            }
        }
    }

    public EntityBullet getEntity(cuqu cuqu2, samw samw2, float f, float f2, double d, double d2, double d3, EntityLivingBase entityLivingBase, float f3, int n, InfoType infoType) {
        return new EntityBullet(cuqu2, samw2, f, f2, d, d2, d3, entityLivingBase, f3, this.type, infoType);
    }

    public EntityBullet getEntity(cuqu cuqu2, Vector3f vector3f, Vector3f vector3f2, EntityLivingBase entityLivingBase, float f, float f2, float f3, int n, InfoType infoType) {
        return new EntityBullet(cuqu2, vector3f, vector3f2, entityLivingBase, f, f2, this.type, f3, infoType);
    }

    public EntityBullet getEntity(cuqu cuqu2, samw samw2, float f, float f2, EntityLivingBase entityLivingBase, float f3, float f4, int n, InfoType infoType) {
        return new EntityBullet(cuqu2, samw2, f, f2, entityLivingBase, f3, f4, this.type, infoType);
    }

    public EntityBullet getEntity(EntityPlayer entityPlayer, int n, FlansModPlayerData flansModPlayerData, float f, float f2, float f3, boolean bl, float f4, InfoType infoType, long l) {
        return new EntityBullet(entityPlayer, n, flansModPlayerData, f, f2, this.type, f3, bl, f4, infoType, l);
    }
}

