/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.hrmy
 *  net.minecraft.util.zwaq
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.InfoType;
import co.uk.flansmods.common.teams.Team;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.hrmy;
import net.minecraft.util.zwaq;

public class EntityDamageSourceGun
extends zwaq {
    public InfoType weapon;
    public EntityPlayer shooter;
    public boolean headshot;

    public EntityDamageSourceGun(String string, EntityPlayer entityPlayer, InfoType infoType, boolean bl) {
        super(string, (Entity)entityPlayer);
        this.weapon = infoType;
        this.shooter = entityPlayer;
        this.field_76386_o = entityPlayer;
        this.headshot = bl;
    }

    public EntityDamageSourceGun(String string, Entity entity, EntityPlayer entityPlayer, InfoType infoType) {
        super(string, entity);
        this.weapon = infoType;
        this.shooter = entityPlayer;
        this.field_76386_o = entityPlayer;
    }

    public hrmy func_76360_b(EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntityPlayer && this.shooter != null && FlansModPlayerHandler.getPlayerData(this.shooter) != null) {
            EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
            Team team = FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayer).team;
            Team team2 = FlansModPlayerHandler.getPlayerData((EntityPlayer)this.shooter).team;
            return hrmy._b((String)((this.headshot ? "flanDeathH." : "flanDeath.") + this.weapon.shortName + "." + (team == null ? "f" : Character.valueOf(team.textColour)) + entityPlayer.field_71092_bJ + "." + (team2 == null ? "f" : Character.valueOf(team2.textColour)) + this.shooter.func_70023_ak()), (Object[])new Object[0]);
        }
        return super.func_76360_b(entityLivingBase);
    }
}

