/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  bpzx
 *  bpzx$uxsf
 *  cpw.mods.fml.common.FMLModContainer
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.MetadataCollection
 *  cpw.mods.fml.common.ModContainer
 *  cpw.mods.fml.common.discovery.ContainerType
 *  cpw.mods.fml.common.discovery.ModCandidate
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  cpw.mods.fml.common.registry.TickRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cuqu
 *  dwms
 *  hbei
 *  jhhk
 *  jhvs
 *  maaq
 *  mayf
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 *  net.minecraftforge.common.bpzx
 *  net.minecraftforge.event.eidl
 *  ogpr
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  rojd
 *  rqjc
 *  uyfg
 *  wmvp
 *  zwak
 */
package co.uk.flansmods.client;

import co.uk.flansmods.client.FlansModClient;
import co.uk.flansmods.client.FlansModResourceHandler;
import co.uk.flansmods.client.GuiDriveableCrafting;
import co.uk.flansmods.client.GuiDriveableFuel;
import co.uk.flansmods.client.GuiDriveableInventory;
import co.uk.flansmods.client.GuiDriveableMenu;
import co.uk.flansmods.client.GuiDriveableRepair;
import co.uk.flansmods.client.GuiGunBox;
import co.uk.flansmods.client.GuiGunModTable;
import co.uk.flansmods.client.KeyInputHandler;
import co.uk.flansmods.client.TickHandlerClient;
import co.uk.flansmods.client.TileEntitySpawnerRenderer;
import co.uk.flansmods.client.debug.EntityDebugAABB;
import co.uk.flansmods.client.debug.EntityDebugVector;
import co.uk.flansmods.client.debug.RenderDebugAABB;
import co.uk.flansmods.client.debug.RenderDebugVector;
import co.uk.flansmods.client.model.ModelGun;
import co.uk.flansmods.client.model.RenderAAGun;
import co.uk.flansmods.client.model.RenderBullet;
import co.uk.flansmods.client.model.RenderFlag;
import co.uk.flansmods.client.model.RenderFlagpole;
import co.uk.flansmods.client.model.RenderGrenade;
import co.uk.flansmods.client.model.RenderGun;
import co.uk.flansmods.client.model.RenderMG;
import co.uk.flansmods.client.model.RenderNull;
import co.uk.flansmods.client.model.RenderParachute;
import co.uk.flansmods.client.model.RenderPlane;
import co.uk.flansmods.client.model.RenderVehicle;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.EntityParachute;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.GunBoxType;
import co.uk.flansmods.common.TileEntityGunBox;
import co.uk.flansmods.common.driveables.DriveablePart;
import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import co.uk.flansmods.common.driveables.EntityPlane;
import co.uk.flansmods.common.driveables.EntitySeat;
import co.uk.flansmods.common.driveables.EntityVehicle;
import co.uk.flansmods.common.driveables.EntityWheel;
import co.uk.flansmods.common.driveables.EnumDriveablePart;
import co.uk.flansmods.common.guns.EntityAAGun;
import co.uk.flansmods.common.guns.EntityBullet;
import co.uk.flansmods.common.guns.EntityGrenade;
import co.uk.flansmods.common.guns.EntityMG;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.network.PacketBuyWeapon;
import co.uk.flansmods.common.network.PacketDriveableCrafting;
import co.uk.flansmods.common.network.PacketRepairDriveable;
import co.uk.flansmods.common.teams.EntityFlag;
import co.uk.flansmods.common.teams.EntityFlagpole;
import co.uk.flansmods.common.teams.TileEntitySpawner;
import co.uk.flansmods.vintarz.CrosshairRenderer;
import co.uk.flansmods.vintarz.EntityShootFX;
import co.uk.flansmods.vintarz.RenderShootFX;
import cpw.mods.fml.common.FMLModContainer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.discovery.ContainerType;
import cpw.mods.fml.common.discovery.ModCandidate;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.eidl;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class ClientProxy
extends CommonProxy {
    public static String modelDir = "co.uk.flansmods.client.model.";
    public static RenderGun gunRenderer;
    public List contentPacks;

    @Override
    public void load() {
        new FlansModClient().load();
        gunRenderer = new RenderGun();
        for (GunType gunType : GunType.guns) {
            if (gunType.model == null) continue;
            mayf.registerItemRenderer((int)gunType.item.field_77779_bT, (rqjc)gunRenderer);
        }
        net.minecraftforge.common.bpzx.EVENT_BUS.register((Object)new CrosshairRenderer());
        wmvp.registerEntityRenderingHandler(EntityShootFX.class, (uyfg)new RenderShootFX("gun_shot", 0.1));
    }

    public List getContentList(Method method, ClassLoader classLoader) {
        this.contentPacks = new ArrayList();
        for (File file : FlansMod.flanDir.listFiles()) {
            if (!file.isDirectory() && !CommonProxy.zipJar.matcher(file.getName()).matches()) continue;
            try {
                method.invoke(classLoader, file.toURI().toURL());
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("modid", "FlansMod");
                hashMap.put("name", "Flan's Mod : " + file.getName());
                hashMap.put("version", "1");
                FMLModContainer fMLModContainer = new FMLModContainer("co.uk.flansmods.common.FlansMod", new ModCandidate(file, file, file.isDirectory() ? ContainerType.DIR : ContainerType.JAR), hashMap);
                fMLModContainer.bindMetadata(MetadataCollection.from(null, (String)""));
                rojd.instance().addModAsResource((ModContainer)fMLModContainer);
            }
            catch (Exception exception) {
                FlansMod.log("Failed to load images for content pack : " + file.getName());
                exception.printStackTrace();
            }
            FlansMod.log("Loaded content pack : " + file.getName());
            this.contentPacks.add(file);
        }
        FlansMod.log("Loaded textures and models.");
        return this.contentPacks;
    }

    public List getContentList() {
        return this.contentPacks;
    }

    @Override
    public void loadDefaultGraphics() {
        wmvp.registerEntityRenderingHandler(EntityGrenade.class, (uyfg)new RenderGrenade());
        wmvp.registerEntityRenderingHandler(EntityPlane.class, (uyfg)new RenderPlane());
        wmvp.registerEntityRenderingHandler(EntityVehicle.class, (uyfg)new RenderVehicle());
        wmvp.registerEntityRenderingHandler(EntityAAGun.class, (uyfg)new RenderAAGun());
        wmvp.registerEntityRenderingHandler(EntityFlagpole.class, (uyfg)new RenderFlagpole());
        wmvp.registerEntityRenderingHandler(EntityFlag.class, (uyfg)new RenderFlag());
        wmvp.registerEntityRenderingHandler(EntitySeat.class, (uyfg)new RenderNull());
        wmvp.registerEntityRenderingHandler(EntityWheel.class, (uyfg)new RenderNull());
        wmvp.registerEntityRenderingHandler(EntityMG.class, (uyfg)new RenderMG());
        wmvp.registerEntityRenderingHandler(EntityParachute.class, (uyfg)new RenderParachute());
        wmvp.registerEntityRenderingHandler(EntityDebugVector.class, (uyfg)new RenderDebugVector());
        wmvp.registerEntityRenderingHandler(EntityDebugAABB.class, (uyfg)new RenderDebugAABB());
        wmvp.registerEntityRenderingHandler(EntityBullet.class, (uyfg)new RenderBullet());
    }

    @Override
    public void registerTileEntityRenderers() {
        zwak.bindTileEntitySpecialRenderer(TileEntitySpawner.class, (jhhk)new TileEntitySpawnerRenderer());
    }

    @Override
    public void loadKeyBindings() {
        bpzx.registerKeyBinding((bpzx.uxsf)new KeyInputHandler());
    }

    @Override
    public void doTutorialStuff(EntityPlayer entityPlayer, EntityDriveable entityDriveable) {
        if (!FlansModClient.doneTutorial) {
            FlansModClient.doneTutorial = true;
        }
    }

    @Override
    public void changeControlMode(EntityPlayer entityPlayer) {
        if (FlansModClient.flipControlMode()) {
            entityPlayer.func_71035_c("Mouse Control mode is now set to " + FlansModClient.controlModeMouse);
        }
    }

    @Override
    public boolean mouseControlEnabled() {
        return FlansModClient.controlModeMouse;
    }

    @Override
    public void playBlockBreakSound(int n, int n2, int n3, int n4) {
        super.playBlockBreakSound(n, n2, n3, n4);
    }

    @Override
    public void doTickStuff() {
        super.doTickStuff();
        TickRegistry.registerTickHandler((ITickHandler)new TickHandlerClient(), (Side)Side.CLIENT);
    }

    @Override
    public Object getClientGui(int n, EntityPlayer entityPlayer, cuqu cuqu2, int n2, int n3, int n4) {
        if (n >= 6 && n <= 10 && (EntitySeat)entityPlayer.field_70154_o == null) {
            return null;
        }
        switch (n) {
            case 0: {
                return new GuiDriveableCrafting(entityPlayer.field_71071_by, cuqu2, n2, n3, n4);
            }
            case 1: {
                return new GuiDriveableRepair(entityPlayer);
            }
            case 2: {
                return new GuiGunModTable(entityPlayer.field_71071_by, cuqu2);
            }
            default: {
                return null;
            }
            case 5: {
                return new GuiGunBox(entityPlayer.field_71071_by, ((TileEntityGunBox)cuqu2.func_72796_p(n2, n3, n4)).getType());
            }
            case 6: {
                return new GuiDriveableInventory(entityPlayer.field_71071_by, cuqu2, ((EntitySeat)entityPlayer.field_70154_o).driveable, 0);
            }
            case 7: {
                return new GuiDriveableInventory(entityPlayer.field_71071_by, cuqu2, ((EntitySeat)entityPlayer.field_70154_o).driveable, 1);
            }
            case 8: {
                return new GuiDriveableFuel(entityPlayer.field_71071_by, cuqu2, ((EntitySeat)entityPlayer.field_70154_o).driveable);
            }
            case 9: 
        }
        return new GuiDriveableInventory(entityPlayer.field_71071_by, cuqu2, ((EntitySeat)entityPlayer.field_70154_o).driveable, 2);
    }

    @Override
    public void openDriveableMenu(EntityPlayer entityPlayer, cuqu cuqu2, EntityDriveable entityDriveable) {
        rojd.instance().getClient()._a((dwms)new GuiDriveableMenu(entityPlayer.field_71071_by, cuqu2, entityDriveable));
    }

    private String getModelName(String string) {
        String[] arrstring = string.split("\\.");
        if (arrstring.length == 1) {
            return "Model" + string;
        }
        if (arrstring.length <= 1) {
            return string;
        }
        String string2 = "Model" + arrstring[arrstring.length - 1];
        for (int i = arrstring.length - 2; i >= 0; --i) {
            string2 = arrstring[i] + "." + string2;
        }
        return string2;
    }

    public Object loadModel(String string, String string2, Class class_) {
        if (string != null && string2 != null) {
            try {
                return class_.cast(Class.forName(modelDir + this.getModelName(string)).getConstructor(new Class[0]).newInstance(new Object[0]));
            }
            catch (Exception exception) {
                FlansMod.log("Failed to load model : " + string2 + " (" + string + ")");
                return null;
            }
        }
        return null;
    }

    @Override
    public void loadSound(String string, String string2, String string3) {
        FlansModResourceHandler.getSound(string, string2, string3);
    }

    @Override
    public boolean isThePlayer(EntityPlayer entityPlayer) {
        return entityPlayer == rojd.instance().getClient()._r;
    }

    @Override
    public void buyGun(GunBoxType gunBoxType, int n) {
        PacketDispatcher.sendPacketToServer((maaq)PacketBuyWeapon.buildBuyWeaponPacket(gunBoxType, 0, n));
        FlansModClient.clientPlayerData.shootTime = 10;
    }

    @Override
    public void buyAmmo(GunBoxType gunBoxType, int n, int n2) {
        PacketDispatcher.sendPacketToServer((maaq)PacketBuyWeapon.buildBuyWeaponPacket(gunBoxType, n2, n));
        FlansModClient.clientPlayerData.shootTime = 10;
    }

    @Override
    public void craftDriveable(EntityPlayer entityPlayer, DriveableType driveableType) {
        super.craftDriveable(entityPlayer, driveableType);
        if (entityPlayer.field_70170_p.field_72995_K) {
            PacketDispatcher.sendPacketToServer((maaq)PacketDriveableCrafting.buildCraftingPacket(driveableType.shortName));
        }
    }

    @Override
    public void repairDriveable(EntityPlayer entityPlayer, EntityDriveable entityDriveable, DriveablePart driveablePart) {
        super.repairDriveable(entityPlayer, entityDriveable, driveablePart);
        if (entityPlayer.field_70170_p.field_72995_K) {
            PacketDispatcher.sendPacketToServer((maaq)PacketRepairDriveable.buildRepairPacket(driveablePart.type));
        }
    }

    @Override
    public boolean isScreenOpen() {
        return tuor._E()._z != null;
    }

    @Override
    public boolean isKeyDown(int n) {
        switch (n) {
            case 0: {
                return this.keyDown(KeyInputHandler.accelerateKey._d);
            }
            case 1: {
                return this.keyDown(KeyInputHandler.decelerateKey._d);
            }
            case 2: {
                return this.keyDown(KeyInputHandler.leftKey._d);
            }
            case 3: {
                return this.keyDown(KeyInputHandler.rightKey._d);
            }
            case 4: {
                return this.keyDown(KeyInputHandler.upKey._d);
            }
        }
        return false;
    }

    @Override
    public boolean keyDown(int n) {
        boolean bl = n < 0 ? Mouse.isButtonDown((int)(n + 100)) : Keyboard.isKeyDown((int)n);
        return bl;
    }

    @Override
    public void resetItemEquip() {
    }
}

