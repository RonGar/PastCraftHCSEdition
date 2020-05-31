/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ccfp
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  dxti
 *  ieta
 *  jhvs
 *  kjsv
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.util.roij
 *  net.minecraft.util.rojd
 *  ogpr
 *  owcl
 *  qlze
 *  samw
 *  tekj
 *  zgmv
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.teams.EntityTeamItem;
import co.uk.flansmods.common.teams.Gametype;
import co.uk.flansmods.common.teams.ITeamObject;
import co.uk.flansmods.common.teams.ItemOpStick;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import co.uk.flansmods.common.teams.TileEntitySpawner;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.roij;
import net.minecraft.util.rojd;

public class BlockSpawner
extends samw {
    public static boolean colouredPass = false;
    public roij[][] icons;

    public BlockSpawner(int n, ccfp ccfp2) {
        super(n, ccfp2);
        this.func_71849_a((tekj)FlansMod.tabFlanTeams);
    }

    public void func_71879_a(int n, tekj tekj2, List list) {
        list.add(new ieta(n, 1, 0));
        list.add(new ieta(n, 1, 1));
        list.add(new ieta(n, 1, 2));
    }

    public roij func_71858_a(int n, int n2) {
        return this.icons[colouredPass ? 1 : 0][n2];
    }

    public rojd func_71872_e(cuqu cuqu2, int n, int n2, int n3) {
        return null;
    }

    public boolean func_71926_d() {
        return false;
    }

    public boolean func_71886_c() {
        return false;
    }

    public boolean func_71918_c(dxti dxti2, int n, int n2, int n3) {
        return true;
    }

    public boolean func_71930_b(cuqu cuqu2, int n, int n2, int n3) {
        return cuqu2.func_72797_t(n, n2 - 1, n3) || owcl._a((int)cuqu2.func_72798_a(n, n2 - 1, n3));
    }

    public void func_71869_a(cuqu cuqu2, int n, int n2, int n3, Entity entity) {
        if (!cuqu2.field_72995_K) {
            cuqu2.func_72805_g(n, n2, n3);
        }
    }

    public void func_71902_a(dxti dxti2, int n, int n2, int n3) {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.03125f, 1.0f);
    }

    public void func_71919_f() {
        this.func_71905_a(0.0f, 0.484375f, 0.0f, 1.0f, 0.515625f, 1.0f);
    }

    public int func_71915_e() {
        return 1;
    }

    public ogpr func_72274_a(cuqu cuqu2) {
        return new TileEntitySpawner();
    }

    public int func_71920_b(dxti dxti2, int n, int n2, int n3) {
        if (!colouredPass) {
            return 16777215;
        }
        try {
            TileEntitySpawner tileEntitySpawner = (TileEntitySpawner)dxti2.func_72796_p(n, n2, n3);
            Team team = tileEntitySpawner.getTeam();
            return team.teamColour;
        }
        catch (Exception exception) {
            return 16777215;
        }
    }

    public boolean func_71903_a(cuqu cuqu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (cuqu2.field_72995_K) {
            return true;
        }
        if (TeamsManager.getInstance().currentGametype != null) {
            TeamsManager.getInstance().currentGametype.objectClickedByPlayer((TileEntitySpawner)cuqu2.func_72796_p(n, n2, n3), (EntityPlayerMP)entityPlayer);
        }
        if (zgmv._a((zgmv)zgmv._H())._g(entityPlayer.field_71092_bJ)) {
            TileEntitySpawner tileEntitySpawner = (TileEntitySpawner)cuqu2.func_72796_p(n, n2, n3);
            ieta ieta2 = entityPlayer.func_71045_bC();
            if (ieta2 == null || ieta2._a() == null) {
                tileEntitySpawner.spawnDelay = (tileEntitySpawner.spawnDelay + 200) % 6000;
                entityPlayer.func_71035_c("Set spawn delay to " + tileEntitySpawner.spawnDelay / 20);
            } else if (!(ieta2._a() instanceof ItemOpStick)) {
                tileEntitySpawner.stacksToSpawn.add(ieta2._l());
                for (Entity entity : tileEntitySpawner.itemEntities) {
                    entity.func_70106_y();
                }
                tileEntitySpawner.currentDelay = 10;
            }
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(qlze qlze2) {
        this.icons = new roij[2][3];
        for (int i = 0; i < 2; ++i) {
            this.icons[i][0] = qlze2._a("FlansMod:spawner_item_" + (i + 1));
            this.icons[i][1] = qlze2._a("FlansMod:spawner_player_" + (i + 1));
            this.icons[i][2] = qlze2._a("FlansMod:spawner_vehicle_" + (i + 1));
        }
    }
}

