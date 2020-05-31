/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cupi
 *  cuqu
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idqh
 *  net.minecraft.util.pzgw
 *  net.minecraft.util.samw
 *  vintarz.core.VSP
 *  zgmv
 */
package co.uk.flansmods.common;

import co.uk.flansmods.common.guns.AttachmentType;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.EntityGrenade;
import co.uk.flansmods.common.guns.EntityMG;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.teams.PlayerClass;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.vintarz.AttachmentTypeMod;
import co.uk.flansmods.vintarz.BulletTypeMod;
import co.uk.flansmods.vintarz.GunTypeMod;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.dwbg;
import net.minecraft.util.idqh;
import net.minecraft.util.pzgw;
import net.minecraft.util.samw;
import vintarz.core.VSP;

public class FlansModPlayerData {
    public String username;
    public EntityMG mountingGun;
    public Team team;
    public PlayerClass playerClass;
    public PlayerClass newPlayerClass;
    public boolean isAiming;
    public int shootTime;
    public int shootClickDelay;
    public int spawnDelay;
    public double spawnX;
    public double spawnY;
    public double spawnZ;
    public float weaponSpread;
    public float bulletSpread;
    public float prevRotationRoll;
    public float rotationRoll;
    public ArrayList<EntityGrenade> remoteExplosives = new ArrayList();
    public int score;
    public int kills;
    public int deaths;
    public boolean out;
    public int x1;
    public int y1;
    public int z1;
    public int x2;
    public int y2;
    public int z2;
    public boolean lockAmmo;
    public boolean bipod;
    public Map<GunType, GunTypeMod> overrideGuns;
    public Map<AttachmentType, AttachmentTypeMod> overrideAttachments;
    public Map<BulletType, BulletTypeMod> overrideBullets;
    public long seed;
    public boolean spreadTicked;
    public int spreadTicks;

    public FlansModPlayerData(String string) {
        this.username = string;
    }

    public void tick() {
        EntityPlayerMP entityPlayerMP;
        if (this.shootTime > 0) {
            --this.shootTime;
        }
        if (this.shootClickDelay > 0) {
            --this.shootClickDelay;
        }
        --this.spawnDelay;
        zgmv zgmv2 = zgmv._H();
        if (zgmv2 != null && zgmv2.__af() != null && (entityPlayerMP = zgmv2.__af()._h(this.username)) != null) {
            double d = entityPlayerMP.field_70165_t - (double)dwbg._a((float)(entityPlayerMP.field_70177_z / 180.0f * 3.141593f)) * 0.425;
            double d2 = entityPlayerMP.field_70161_v + (double)dwbg._b((float)(entityPlayerMP.field_70177_z / 180.0f * 3.141593f)) * 0.425;
            double d3 = entityPlayerMP.field_70163_u + (double)entityPlayerMP.func_70047_e();
            if (entityPlayerMP.func_70093_af()) {
                d3 -= 0.125;
            }
            samw samw2 = entityPlayerMP.field_70170_p.func_82732_R()._a(entityPlayerMP.field_70165_t, d3, entityPlayerMP.field_70161_v);
            samw samw3 = entityPlayerMP.field_70170_p.func_82732_R()._a(d, d3, d2);
            boolean bl = this.bipod;
            this.bipod = entityPlayerMP.field_70170_p.func_72831_a(samw2, samw3, false, true) == null ? entityPlayerMP.field_70170_p.func_72831_a(samw2 = entityPlayerMP.field_70170_p.func_82732_R()._a(d, d3, d2), samw3 = entityPlayerMP.field_70170_p.func_82732_R()._a(d, d3 - 0.7, d2), false, true) != null : false;
            if (bl != this.bipod) {
                VSP vSP = new VSP(14, "HCSMOD");
                try {
                    vSP.writeBoolean(this.bipod);
                }
                catch (IOException iOException) {}
                vSP.send((EntityPlayer)entityPlayerMP);
            }
        }
    }

    public void setSpawn(double d, double d2, double d3, int n) {
        this.spawnX = d;
        this.spawnY = d2;
        this.spawnZ = d3;
        this.spawnDelay = n;
    }

    public PlayerClass getPlayerClass() {
        if (this.playerClass != this.newPlayerClass) {
            this.playerClass = this.newPlayerClass;
        }
        return this.playerClass;
    }

    public void resetScore() {
        this.deaths = 0;
        this.kills = 0;
        this.score = 0;
    }

    public void syncGunRng(long l) {
        this.seed = l;
    }
}

