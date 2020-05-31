/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  aokp
 *  cpw.mods.fml.common.IPlayerTracker
 *  cpw.mods.fml.common.registry.GameRegistry
 *  cpw.mods.fml.common.uxsf
 *  cpw.mods.fml.relauncher.Side
 *  cupi
 *  cuqu
 *  dxut
 *  ekfx
 *  hclw
 *  hcsmod.HcsInteract
 *  hsus
 *  ieta
 *  iwsa
 *  jhvs
 *  jzvn
 *  jzvn$rojd
 *  jzvn$uxsf
 *  klva
 *  lobd
 *  maaq
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.flgb
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.passive.EntityHorse
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.entity.player.rojd
 *  net.minecraft.util.dwbg
 *  net.minecraft.util.idol
 *  net.minecraft.util.pico
 *  net.minecraft.util.samw
 *  net.minecraft.util.zwaq
 *  net.minecraftforge.common.bpzx
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.eidl
 *  net.minecraftforge.event.kjuq
 *  ogpr
 *  ohcq
 *  sbsi
 *  stnp
 *  twpo
 *  vlyb
 *  vlyb$uxsf
 *  zgmv
 *  zxiv
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.ItemPlane;
import co.uk.flansmods.common.ItemVehicle;
import co.uk.flansmods.common.guns.BulletType;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemAAGun;
import co.uk.flansmods.common.guns.ItemBullet;
import co.uk.flansmods.common.guns.ItemGun;
import co.uk.flansmods.common.teams.EntityGunItem;
import co.uk.flansmods.common.teams.Gametype;
import co.uk.flansmods.common.teams.GametypeCTF;
import co.uk.flansmods.common.teams.GametypeConquest;
import co.uk.flansmods.common.teams.GametypeDM;
import co.uk.flansmods.common.teams.GametypeNerf;
import co.uk.flansmods.common.teams.GametypeTDM;
import co.uk.flansmods.common.teams.ITeamBase;
import co.uk.flansmods.common.teams.ITeamObject;
import co.uk.flansmods.common.teams.ItemOpStick;
import co.uk.flansmods.common.teams.ItemTeamArmour;
import co.uk.flansmods.common.teams.PlayerClass;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.vintarz.Util;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.uxsf;
import cpw.mods.fml.relauncher.Side;
import hcsmod.HcsInteract;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.flgb;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.eidl;
import net.minecraft.entity.player.rojd;
import net.minecraft.util.dwbg;
import net.minecraft.util.idol;
import net.minecraft.util.pico;
import net.minecraft.util.samw;
import net.minecraft.util.zwaq;
import net.minecraftforge.common.bpzx;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.kjuq;

public class TeamsManager
implements IPlayerTracker {
    public Gametype currentGametype;
    public TeamsMap currentMap;
    public Team[] teams;
    public static TeamsManager instance;
    public List<ITeamBase> bases;
    public List<ITeamObject> objects;
    public List<TeamsMap> maps;
    private int nextBaseID = 1;
    private long time;
    public List<RotationEntry> rotation;
    public int currentRotationEntry;

    public TeamsManager() {
        instance = this;
        bpzx.EVENT_BUS.register((Object)this);
        GameRegistry.registerPlayerTracker((IPlayerTracker)this);
        this.bases = new ArrayList<ITeamBase>();
        this.objects = new ArrayList<ITeamObject>();
        this.maps = new ArrayList<TeamsMap>();
        this.maps.add(TeamsMap.def);
        this.rotation = new ArrayList<RotationEntry>();
        this.currentMap = TeamsMap.def;
        new co.uk.flansmods.common.teams.GametypeTDM();
        new co.uk.flansmods.common.teams.GametypeConquest();
        new co.uk.flansmods.common.teams.GametypeDM();
        new co.uk.flansmods.common.teams.GametypeCTF();
        new co.uk.flansmods.common.teams.GametypeNerf();
    }

    public void reset() {
        this.currentGametype = null;
        this.currentMap = TeamsMap.def;
        this.teams = null;
        this.bases = new ArrayList<ITeamBase>();
        this.objects = new ArrayList<ITeamObject>();
        this.maps = new ArrayList<TeamsMap>();
        this.maps.add(TeamsMap.def);
        this.rotation = new ArrayList<RotationEntry>();
    }

    public static TeamsManager getInstance() {
        return instance;
    }

    public void tick() {
        if (this.currentGametype != null) {
            this.currentGametype.tick();
        }
        ++this.time;
        for (ITeamBase object : this.bases) {
            object.tick();
        }
        for (ITeamObject iTeamObject : this.objects) {
            iTeamObject.tick();
        }
        for (Object object : zgmv._a((zgmv)uxsf.instance().getMinecraftServerInstance())._e) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)object;
            FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayerMP);
            try {
                if (flansModPlayerData.spawnDelay != 0) continue;
                aokp aokp2 = (aokp)entityPlayerMP.field_70170_p;
                aokp2.func_73039_n()._a((Entity)entityPlayerMP, (maaq)new lobd((Entity)entityPlayerMP));
            }
            catch (NullPointerException nullPointerException) {}
        }
    }

    public void switchToNextGametype() {
        FlansModPlayerHandler.roundEnded();
        this.currentRotationEntry = (this.currentRotationEntry + 1) % this.rotation.size();
        RotationEntry rotationEntry = this.rotation.get(this.currentRotationEntry);
        if (this.currentGametype != null && this.currentGametype != rotationEntry.gametype) {
            this.currentGametype.stopGametype();
        }
        this.currentGametype = rotationEntry.gametype;
        this.currentMap = rotationEntry.map;
        this.teams = rotationEntry.teams;
        this.currentGametype.initGametype();
    }

    public EntityPlayerMP getPlayer(String string) {
        return zgmv._a((zgmv)uxsf.instance().getMinecraftServerInstance())._h(string);
    }

    public static void log(String string) {
        FlansMod.log("Teams Info : " + string);
    }

    public static void messagePlayer(EntityPlayerMP entityPlayerMP, String string) {
        entityPlayerMP.func_71035_c(string);
    }

    public static void messageAll(String string) {
        FlansMod.log("Teams Announcement : " + string);
        for (EntityPlayerMP entityPlayerMP : zgmv._H().__af()._e) {
            entityPlayerMP.func_71035_c(string);
        }
    }

    @kjuq
    public void onPlayerUpdate(twpo twpo2) {
        ieta ieta2;
        jhvs jhvs2;
        if (!HcsInteract.$) {
            twpo2.setCanceled(true);
        }
        if ((ieta2 = twpo2.entityPlayer.field_71071_by._a()) != null && (jhvs2 = ieta2._a()) instanceof ItemOpStick) {
            ((ItemOpStick)jhvs2).clickedEntity(twpo2.entityPlayer.field_70170_p, twpo2.entityPlayer, twpo2.target);
        }
    }

    @kjuq
    public void onEntityHurt(stnp stnp2) {
        if (stnp2.entity instanceof EntityPlayerMP && this.currentGametype != null && !this.currentGametype.playerAttacked((EntityPlayerMP)stnp2.entity, stnp2.source)) {
            stnp2.setCanceled(true);
        }
    }

    @kjuq
    public void onEntityKilled(ekfx ekfx2) {
        if (ekfx2.entity instanceof EntityPlayerMP && this.currentGametype != null) {
            ieta ieta2;
            Entity entity;
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)ekfx2.entity;
            this.currentGametype.playerKilled(entityPlayerMP, ekfx2.source);
            if (ekfx2.source instanceof zwaq && (entity = ekfx2.source.func_76364_f()) instanceof EntityPlayer && (ieta2 = ((EntityPlayer)entity).func_71045_bC()) != null && ieta2._a() != null && ieta2._a() instanceof ItemGun) {
                TeamsManager.messageAll("flanDeath." + ((ItemGun)ieta2._a()).type.shortName + "." + FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayerMP).team.textColour + ekfx2.entity.func_70023_ak() + "." + FlansModPlayerHandler.getPlayerData((EntityPlayer)((EntityPlayer)entity)).team.textColour + entity.func_70023_ak());
            }
        }
    }

    @kjuq
    public void entityJoinedWorld(iwsa iwsa2) {
        if (iwsa2.entity instanceof ITeamBase) {
            this.registerBase((ITeamBase)iwsa2.entity);
        }
        if (iwsa2.entity instanceof ITeamObject) {
            this.objects.add((ITeamObject)iwsa2.entity);
        }
    }

    @kjuq
    public void playerInteracted(vlyb vlyb2) {
        if (vlyb2.action == vlyb.uxsf.LEFT_CLICK_BLOCK && (!vlyb2.entityPlayer.field_71075_bZ._e || Util.isFlansWeapon(vlyb2.entityPlayer.func_71045_bC()))) {
            vlyb2.setCanceled(true);
            return;
        }
        if (vlyb2.entityPlayer.field_70170_p.field_72995_K) {
            return;
        }
        ogpr ogpr2 = vlyb2.entityPlayer.field_70170_p.func_72796_p(vlyb2.x, vlyb2.y, vlyb2.z);
        if (ogpr2 != null) {
            ieta ieta2 = vlyb2.entityPlayer.func_71045_bC();
            if (ieta2 != null && ieta2._a() != null && ieta2._a() instanceof ItemOpStick) {
                if (ogpr2 instanceof ITeamObject) {
                    ((ItemOpStick)ieta2._a()).clickedObject(vlyb2.entityPlayer.field_70170_p, (EntityPlayerMP)vlyb2.entityPlayer, (ITeamObject)ogpr2);
                }
                if (ogpr2 instanceof ITeamBase) {
                    ((ItemOpStick)ieta2._a()).clickedBase(vlyb2.entityPlayer.field_70170_p, (EntityPlayerMP)vlyb2.entityPlayer, (ITeamBase)ogpr2);
                }
            } else if (this.currentGametype != null) {
                if (ogpr2 instanceof ITeamObject) {
                    this.currentGametype.objectClickedByPlayer((ITeamObject)ogpr2, (EntityPlayerMP)vlyb2.entityPlayer);
                }
                if (ogpr2 instanceof ITeamBase) {
                    this.currentGametype.baseClickedByPlayer((ITeamBase)ogpr2, (EntityPlayerMP)vlyb2.entityPlayer);
                }
            }
        }
    }

    @kjuq
    public void playerDrops(klva klva2) {
        Object object;
        EntityGunItem entityGunItem;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (FlansMod.weaponDrops == 2) {
            for (EntityItem entityItem : klva2.drops) {
                entityGunItem = entityItem.func_92059_d();
                if (entityGunItem == null || entityGunItem._a() == null || !(entityGunItem._a() instanceof ItemGun)) continue;
                object = new EntityGunItem(entityItem);
                ((ieta)entityGunItem)._b = 0;
                boolean bl = false;
                for (EntityItem entityItem2 : arrayList) {
                    if (((ItemGun)entityGunItem._a()).type != ((ItemGun)entityItem2.func_92059_d()._a()).type) continue;
                    bl = true;
                }
                if (bl) continue;
                klva2.entityPlayer.field_70170_p.func_72838_d((Entity)object);
                arrayList.add(object);
            }
        }
        for (EntityItem entityItem : arrayList) {
            entityGunItem = (EntityGunItem)entityItem;
            object = ((ItemGun)entityGunItem.func_92059_d()._a()).type;
            for (Object object2 : klva2.drops) {
                BulletType bulletType;
                ieta ieta2 = object2.func_92059_d();
                if (ieta2 == null || !(ieta2._a() instanceof ItemBullet) || !((GunType)object).isAmmo(bulletType = ((ItemBullet)ieta2._a()).type)) continue;
                entityGunItem.ammoStacks.add(ieta2._l());
                ieta2._b = 0;
            }
        }
        for (EntityItem entityItem : klva2.drops) {
            entityGunItem = entityItem.func_92059_d();
            if (entityGunItem == null || entityGunItem._a() == null || ((ieta)entityGunItem)._b <= 0) continue;
            if (entityGunItem._a() instanceof ItemGun || entityGunItem._a() instanceof ItemPlane || entityGunItem._a() instanceof ItemVehicle || entityGunItem._a() instanceof ItemAAGun || entityGunItem._a() instanceof ItemBullet) {
                if (FlansMod.weaponDrops == 1) continue;
                arrayList.add((Object)entityItem);
                continue;
            }
            if (!(entityGunItem._a() instanceof ItemTeamArmour) || FlansMod.armourDrops) continue;
            arrayList.add((Object)entityItem);
        }
        klva2.drops.removeAll(arrayList);
    }

    @kjuq
    public void playerLoot(hclw hclw2) {
        FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData(hclw2.entityPlayer);
        if (flansModPlayerData != null && flansModPlayerData.team == Team.spectators) {
            hclw2.setCanceled(true);
        }
    }

    @kjuq
    public void chunkLoaded(ohcq ohcq2) {
        qmzb qmzb2 = ohcq2.getChunk();
        for (List list : qmzb2._m) {
            for (Entity entity : list) {
                if (entity instanceof ITeamBase) {
                    this.bases.add((ITeamBase)entity);
                    if (((ITeamBase)entity).getID() > this.nextBaseID) {
                        FlansMod.log("Loaded base with ID higher than the supposed highest ID. Adjusted highest ID");
                        this.nextBaseID = ((ITeamBase)entity).getID();
                    }
                }
                if (!(entity instanceof ITeamObject)) continue;
                this.objects.add((ITeamObject)entity);
            }
        }
    }

    @kjuq
    public void worldData(jzvn jzvn2) {
        if (jzvn2.world.field_72995_K) {
            return;
        }
        if (jzvn2 instanceof jzvn.uxsf) {
            this.loadPerWorldData((Event)jzvn2, jzvn2.world);
            this.savePerWorldData((Event)jzvn2, jzvn2.world);
        }
        if (jzvn2 instanceof jzvn.rojd) {
            this.savePerWorldData((Event)jzvn2, jzvn2.world);
        }
    }

    private void loadPerWorldData(Event event, cuqu cuqu2) {
        this.reset();
        File file = new File(uxsf.instance().getSide().isClient() ? "saves/" + zgmv._H()._N() : zgmv._H()._j(), "teams.dat");
        if (!this.checkFileExists(file)) {
            return;
        }
        try {
            int n;
            hsus hsus2 = sbsi._a((DataInput)new DataInputStream(new FileInputStream(file)));
            this.nextBaseID = hsus2._f("NextBaseID");
            for (n = 0; n < hsus2._f("NumMaps"); ++n) {
                String string = hsus2._j("MapShortName " + n);
                if (string.equals("default")) continue;
                this.maps.add(new TeamsMap(string, hsus2._j("MapName " + n)));
            }
            this.currentMap = this.getTeamsMap(hsus2._j("Map"));
            this.currentGametype = Gametype.getGametype(hsus2._j("Gametype"));
            if (this.currentGametype != null) {
                this.currentGametype.initGametype();
                this.currentGametype.readFromNBT(hsus2);
                this.teams = new Team[this.currentGametype.numTeamsRequired];
                for (n = 0; n < this.teams.length; ++n) {
                    this.teams[n] = Team.getTeam(hsus2._j("Team " + n));
                }
            }
            n = hsus2._f("RotationSize");
            for (int i = 0; i < n; ++i) {
                TeamsMap teamsMap = this.getTeamsMap(hsus2._j("RotationMap " + i));
                Gametype gametype = Gametype.getGametype(hsus2._j("RotationGametype " + i));
                int n2 = hsus2._f("RotationTeams " + i);
                Team[] arrteam = new Team[n2];
                for (int j = 0; j < n2; ++j) {
                    arrteam[j] = Team.getTeam(hsus2._j("RotationTeam " + i + " " + j));
                }
                if (teamsMap == null || gametype == null) continue;
                this.rotation.add(new RotationEntry(teamsMap, gametype, arrteam));
            }
            FlansMod.useRotation = hsus2._o("UseRotation");
            FlansMod.bombsEnabled = hsus2._o("Bombs");
            FlansMod.bulletsEnabled = hsus2._o("Bullets");
            FlansMod.explosions = hsus2._o("Explosions");
            FlansMod.forceAdventureMode = hsus2._o("ForceAdventure");
            FlansMod.canBreakGuns = hsus2._o("CanBreakGuns");
            FlansMod.canBreakGlass = hsus2._o("CanBreakGlass");
            FlansMod.armourDrops = hsus2._o("ArmourDrops");
            FlansMod.weaponDrops = hsus2._f("WeaponDrops");
            FlansMod.vehiclesNeedFuel = hsus2._o("NeedFuel");
            FlansMod.mgLife = hsus2._f("MGLife");
            FlansMod.aaLife = hsus2._f("AALife");
            FlansMod.vehicleLife = hsus2._f("VehicleLife");
            FlansMod.mechaLove = hsus2._f("MechaLove");
            FlansMod.planeLife = hsus2._f("PlaneLife");
        }
        catch (Exception exception) {
            FlansMod.log("Failed to load from teams.dat");
            exception.printStackTrace();
        }
    }

    private void savePerWorldData(Event event, cuqu cuqu2) {
        File file = new File(uxsf.instance().getSide().isClient() ? "saves/" + zgmv._H()._N() : zgmv._H()._j(), "teams.dat");
        this.checkFileExists(file);
        try {
            hsus hsus2 = new hsus();
            hsus2._a("NextBaseID", this.nextBaseID);
            hsus2._a("NumMaps", this.maps.size());
            if (this.maps != null) {
                for (int i = 0; i < this.maps.size(); ++i) {
                    if (this.maps.get(i) == null) continue;
                    hsus2._a("MapShortName " + i, this.maps.get((int)i).shortName);
                    hsus2._a("MapName " + i, this.maps.get((int)i).name);
                }
            }
            if (this.currentMap != null) {
                hsus2._a("Map", this.currentMap.shortName);
            }
            hsus2._a("Gametype", this.currentGametype == null ? "None" : this.currentGametype.shortName);
            for (Gametype object : Gametype.gametypes) {
                object.saveToNBT(hsus2);
            }
            if (this.teams != null) {
                for (int i = 0; i < this.teams.length; ++i) {
                    if (this.teams[i] == null) continue;
                    hsus2._a("Team " + i, this.teams[i].shortName);
                }
            }
            if (this.rotation != null) {
                hsus2._a("RotationSize", this.rotation.size());
                for (int i = 0; i < this.rotation.size(); ++i) {
                    RotationEntry rotationEntry = this.rotation.get(i);
                    if (rotationEntry == null) continue;
                    hsus2._a("RotationMap " + i, rotationEntry.map.shortName);
                    hsus2._a("RotationGametype " + i, rotationEntry.gametype.shortName);
                    hsus2._a("RotationTeams " + i, rotationEntry.teams.length);
                    for (int j = 0; j < rotationEntry.teams.length; ++j) {
                        hsus2._a("RotationTeam " + i + " " + j, rotationEntry.teams[j].shortName);
                    }
                }
            } else {
                hsus2._a("RotationSize", 0);
            }
            hsus2._a("UseRotation", FlansMod.useRotation);
            hsus2._a("Bombs", FlansMod.bombsEnabled);
            hsus2._a("Bullets", FlansMod.bulletsEnabled);
            hsus2._a("Explosions", FlansMod.explosions);
            hsus2._a("ForceAdventure", FlansMod.forceAdventureMode);
            hsus2._a("CanBreakGuns", FlansMod.canBreakGuns);
            hsus2._a("CanBreakGlass", FlansMod.canBreakGlass);
            hsus2._a("ArmourDrops", FlansMod.armourDrops);
            hsus2._a("WeaponDrops", FlansMod.weaponDrops);
            hsus2._a("NeedFuel", FlansMod.vehiclesNeedFuel);
            hsus2._a("MGLife", FlansMod.mgLife);
            hsus2._a("AALife", FlansMod.aaLife);
            hsus2._a("VehicleLife", FlansMod.vehicleLife);
            hsus2._a("MechaLove", FlansMod.mechaLove);
            hsus2._a("PlaneLife", FlansMod.planeLife);
            hsus2._a("BreakBlocks", false);
            sbsi._a((hsus)hsus2, (DataOutput)new DataOutputStream(new FileOutputStream(file)));
        }
        catch (Exception exception) {
            FlansMod.log("Failed to save to teams.dat");
        }
    }

    private boolean checkFileExists(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (Exception exception) {
                FlansMod.log("Failed to create file");
                FlansMod.log(file.getAbsolutePath());
            }
            return false;
        }
        return true;
    }

    public ITeamBase getBase(int n) {
        for (ITeamBase iTeamBase : this.bases) {
            if (iTeamBase.getID() != n) continue;
            return iTeamBase;
        }
        return null;
    }

    public void registerBase(ITeamBase iTeamBase) {
        if (iTeamBase.getID() == 0) {
            iTeamBase.setID(this.nextBaseID++);
        }
        this.bases.add(iTeamBase);
    }

    public void registerObject(ITeamObject iTeamObject) {
        this.objects.add(iTeamObject);
    }

    public void onPlayerLogin(EntityPlayer entityPlayer) {
        if (entityPlayer instanceof EntityPlayerMP) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)entityPlayer;
            if (this.currentGametype != null) {
                this.currentGametype.playerJoined(entityPlayerMP);
            }
        }
    }

    public void onPlayerLogout(EntityPlayer entityPlayer) {
        for (Team team : Team.teams) {
            team.removePlayer(entityPlayer);
        }
    }

    public void onPlayerChangedDimension(EntityPlayer entityPlayer) {
    }

    public void onPlayerRespawn(EntityPlayer entityPlayer) {
        if (this.currentGametype != null) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)entityPlayer;
            FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayerMP);
            if (entityPlayerMP != null && flansModPlayerData != null && flansModPlayerData.team == Team.spectators && zgmv._a((zgmv)entityPlayerMP.field_71133_b)._g(entityPlayerMP.field_71092_bJ)) {
                return;
            }
            samw samw2 = this.currentGametype.getSpawnPoint(entityPlayerMP);
            if (samw2 != null) {
                entityPlayer.func_71063_a(new idol(dwbg._c((double)samw2._c), dwbg._c((double)samw2._d) + 1, dwbg._c((double)samw2._e)), true);
                flansModPlayerData.setSpawn(samw2._c, samw2._d, samw2._e, 5);
                entityPlayerMP.func_70012_b(samw2._c, samw2._d, samw2._e, 0.0f, 0.0f);
                if (flansModPlayerData.playerClass != null && flansModPlayerData.playerClass.horse) {
                    EntityHorse entityHorse = new EntityHorse(entityPlayerMP.field_70170_p);
                    hsus hsus2 = new hsus();
                    entityHorse.func_70109_d(hsus2);
                    hsus2._a("Tame", true);
                    hsus2._a("Temper", 0);
                    hsus2._a("OwnerName", entityPlayerMP.field_71092_bJ);
                    hsus2._a("SaddleItem", (zxiv)new ieta(jhvs.field_77765_aA)._b(new hsus("SaddleItem")));
                    hsus2._a("Type", 0);
                    hsus2._a("Variant", 0);
                    entityHorse.func_70020_e(hsus2);
                    entityHorse.func_70107_b(entityPlayerMP.field_70165_t, entityPlayerMP.field_70163_u, entityPlayerMP.field_70161_v);
                    entityPlayerMP.field_70170_p.func_72838_d((Entity)entityHorse);
                    entityPlayerMP.func_70078_a((Entity)entityHorse);
                }
                if (FlansMod.forceAdventureMode && entityPlayer.field_71075_bZ._e) {
                    entityPlayer.func_71033_a(dxut._d);
                }
                this.resetInventory(entityPlayer);
            }
            this.currentGametype.playerRespawned((EntityPlayerMP)entityPlayer);
        }
    }

    public void forceRespawn(EntityPlayerMP entityPlayerMP) {
        entityPlayerMP.field_71071_by._b = new ieta[4];
        entityPlayerMP.field_71071_by._a = new ieta[36];
        entityPlayerMP.func_70691_i(9001.0f);
        if (FlansMod.forceAdventureMode && entityPlayerMP.field_71075_bZ._e) {
            entityPlayerMP.func_71033_a(dxut._d);
        }
        this.onPlayerRespawn((EntityPlayer)entityPlayerMP);
    }

    public void playerSelectedTeam(EntityPlayerMP entityPlayerMP, String string) {
        Team team = Gametype.getPlayerData((EntityPlayerMP)entityPlayerMP).team;
        if (team != null && team.shortName.equals(string)) {
            Gametype.sendClassMenuToPlayer(entityPlayerMP);
            return;
        }
        Team team2 = null;
        for (Team team3 : this.teams) {
            if (team3 == null || !team3.shortName.equals(string)) continue;
            team2 = team3;
        }
        if (string.equals(Team.spectators.shortName)) {
            team2 = Team.spectators;
        }
        if (team2 == null) {
            team2 = Team.spectators;
        }
        if (team2 != null && this.currentGametype != null) {
            FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayerMP).team = team2;
            boolean bl = this.currentGametype.playerChoseTeam(entityPlayerMP, team2, team);
            if (bl) {
                team2.addPlayer((EntityPlayer)entityPlayerMP);
                TeamsManager.messageAll(entityPlayerMP.field_71092_bJ + " joined \u00a7" + team2.textColour + team2.name);
            } else {
                entityPlayerMP.func_71035_c("You may not pick that team");
                Gametype.sendTeamsMenuToPlayer(entityPlayerMP);
            }
        }
        if (team2 == Team.spectators) {
            FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayerMP).newPlayerClass = null;
            FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayerMP).playerClass = null;
            this.resetInventory((EntityPlayer)entityPlayerMP);
            entityPlayerMP.field_71075_bZ._c = true;
        } else {
            entityPlayerMP.field_71075_bZ._c = false;
        }
    }

    public void playerSelectedClass(EntityPlayerMP entityPlayerMP, String string) {
        Team team = FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayerMP).team;
        if (team == null) {
            return;
        }
        PlayerClass playerClass = null;
        for (PlayerClass playerClass2 : team.classes) {
            if (!playerClass2.shortName.equals(string)) continue;
            playerClass = playerClass2;
        }
        if (playerClass != null) {
            if (this.currentGametype != null) {
                this.currentGametype.playerChoseClass(entityPlayerMP, playerClass);
            }
            FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayerMP).playerClass = playerClass;
        }
    }

    public void resetInventory(EntityPlayer entityPlayer) {
        Team team = FlansModPlayerHandler.getPlayerData((EntityPlayer)entityPlayer).team;
        PlayerClass playerClass = FlansModPlayerHandler.getPlayerData(entityPlayer).getPlayerClass();
        if (team == null) {
            return;
        }
        entityPlayer.field_71071_by._b = new ieta[4];
        entityPlayer.field_71071_by._a = new ieta[36];
        if (team.hat != null) {
            entityPlayer.field_71071_by._b[3] = team.hat._l();
        }
        if (team.chest != null) {
            entityPlayer.field_71071_by._b[2] = team.chest._l();
        }
        if (team.legs != null) {
            entityPlayer.field_71071_by._b[1] = team.legs._l();
        }
        if (team.shoes != null) {
            entityPlayer.field_71071_by._b[0] = team.shoes._l();
        }
        if (playerClass == null) {
            return;
        }
        for (ieta ieta2 : playerClass.startingItems) {
            entityPlayer.field_71071_by._c(ieta2._l());
        }
        for (int i = 0; i < entityPlayer.field_71071_by.func_70302_i_(); ++i) {
            ieta ieta2;
            ieta2 = entityPlayer.field_71071_by.func_70301_a(i);
            if (ieta2 == null || !(ieta2._a() instanceof ItemGun)) continue;
            ((ItemGun)ieta2._a()).reload(ieta2, entityPlayer.field_70170_p, entityPlayer, true);
        }
    }

    public boolean areTeamsValid() {
        if (this.teams == null) {
            return false;
        }
        for (Team team : this.teams) {
            if (team != null) continue;
            return false;
        }
        return true;
    }

    public TeamsMap getTeamsMap(String string) {
        for (TeamsMap teamsMap : this.maps) {
            if (!teamsMap.shortName.equals(string)) continue;
            return teamsMap;
        }
        return null;
    }

    public static class RotationEntry {
        public TeamsMap map;
        public Gametype gametype;
        public Team[] teams;

        public RotationEntry(TeamsMap teamsMap, Gametype gametype, Team[] arrteam) {
            this.map = teamsMap;
            this.gametype = gametype;
            this.teams = arrteam;
        }
    }

    public static class TeamsMap {
        public static TeamsMap def = new TeamsMap("default", "Default");
        public String name;
        public String shortName;

        public TeamsMap(String string, String string2) {
            this.shortName = string;
            this.name = string2;
        }
    }

}

