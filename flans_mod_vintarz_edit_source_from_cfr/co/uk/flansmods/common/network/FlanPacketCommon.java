/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  aokp
 *  cpw.mods.fml.common.IFMLSidedHandler
 *  cpw.mods.fml.common.network.IPacketHandler
 *  cpw.mods.fml.common.network.Player
 *  cpw.mods.fml.common.uxsf
 *  cpw.mods.fml.relauncher.Side
 *  cupi
 *  cuqu
 *  fmqx
 *  mrcr
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  zgmv
 */
package co.uk.flansmods.common.network;

import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.network.PacketAiming;
import co.uk.flansmods.common.network.PacketBreakSound;
import co.uk.flansmods.common.network.PacketBullet;
import co.uk.flansmods.common.network.PacketBuyWeapon;
import co.uk.flansmods.common.network.PacketContentPackList;
import co.uk.flansmods.common.network.PacketDriveableCrafting;
import co.uk.flansmods.common.network.PacketDriveableDamage;
import co.uk.flansmods.common.network.PacketDriveableKeyHeld;
import co.uk.flansmods.common.network.PacketFlak;
import co.uk.flansmods.common.network.PacketGunBoxTE;
import co.uk.flansmods.common.network.PacketGunFire;
import co.uk.flansmods.common.network.PacketGunModButton;
import co.uk.flansmods.common.network.PacketHit;
import co.uk.flansmods.common.network.PacketLocked;
import co.uk.flansmods.common.network.PacketMGFire;
import co.uk.flansmods.common.network.PacketMGMount;
import co.uk.flansmods.common.network.PacketPlaySound;
import co.uk.flansmods.common.network.PacketPlayerSpawn;
import co.uk.flansmods.common.network.PacketReload;
import co.uk.flansmods.common.network.PacketRepairDriveable;
import co.uk.flansmods.common.network.PacketSeatUpdates;
import co.uk.flansmods.common.network.PacketTeamInfo;
import co.uk.flansmods.common.network.PacketTeamSelect;
import co.uk.flansmods.common.network.PacketVehicleControl;
import co.uk.flansmods.common.network.PacketVehicleGUI;
import co.uk.flansmods.common.network.PacketVehicleKey;
import cpw.mods.fml.common.IFMLSidedHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.uxsf;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class FlanPacketCommon
implements IPacketHandler {
    public static String channelFlan = "flansmods";
    protected fmqx internalPacket;

    public void onPacketData(mrcr mrcr2, fmqx fmqx2, Player player) {
        String string = ((EntityPlayer)player).field_71092_bJ;
        EntityPlayerMP entityPlayerMP = uxsf.instance().getSidedDelegate().getServer().__af()._h(string);
        if (fmqx2._a.equals(channelFlan)) {
            aokp aokp2 = (aokp)entityPlayerMP.field_70170_p;
            FlanPacketCommon.receive(fmqx2, (EntityPlayer)entityPlayerMP, mrcr2, Side.SERVER, (cuqu)aokp2);
        }
    }

    public static final void receive(fmqx fmqx2, EntityPlayer entityPlayer, mrcr mrcr2, Side side, cuqu cuqu2) {
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(fmqx2._c));
            int n = dataInputStream.read();
            switch (n) {
                case 1: {
                    new PacketBreakSound().interpret(dataInputStream, null, side);
                    break;
                }
                case 2: {
                    new PacketGunModButton().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 3: {
                    new PacketVehicleControl().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 4: {
                    new PacketVehicleKey().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 5: {
                    new PacketBuyWeapon().interpret(dataInputStream, new Object[]{cuqu2, entityPlayer}, side);
                    break;
                }
                case 6: {
                    new PacketTeamSelect().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 7: {
                    new PacketGunBoxTE().interpret(dataInputStream, new Object[]{cuqu2}, side);
                    break;
                }
                case 8: {
                    new PacketPlaySound().interpret(dataInputStream, null, side);
                    break;
                }
                case 9: {
                    new PacketDriveableCrafting().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 10: {
                    new PacketMGMount().interpret(dataInputStream, new Object[]{cuqu2}, side);
                    break;
                }
                case 11: {
                    new PacketDriveableDamage().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 12: {
                    new PacketMGFire().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 13: {
                    new PacketGunFire().interpret(dataInputStream, new Object[]{entityPlayer, cuqu2}, side);
                    break;
                }
                case 14: {
                    new PacketFlak().interpret(dataInputStream, new Object[]{cuqu2}, side);
                    break;
                }
                case 15: {
                    new PacketVehicleGUI().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 16: {
                    new PacketContentPackList().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 17: {
                    new PacketRepairDriveable().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 18: {
                    new PacketTeamInfo().interpret(dataInputStream, new Object[0], side);
                    break;
                }
                case 19: {
                    new PacketReload().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 20: {
                    new PacketPlayerSpawn().interpret(dataInputStream, null, side);
                    break;
                }
                case 21: {
                    new PacketSeatUpdates().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 22: {
                    new PacketDriveableKeyHeld().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 23: {
                    new PacketAiming().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 24: {
                    new PacketHit().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 25: {
                    new PacketBullet().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                case 26: {
                    new PacketLocked().interpret(dataInputStream, new Object[]{entityPlayer}, side);
                    break;
                }
                default: {
                    FlansMod.logLoudly("Unknown packet type recieved");
                }
            }
            dataInputStream.close();
        }
        catch (Exception exception) {
            FlansMod.log("Error recieving packet");
            exception.printStackTrace();
        }
    }

    public void interpret(DataInputStream dataInputStream, Object[] arrobject, Side side) {
    }

    public byte getPacketID() {
        return 0;
    }
}

