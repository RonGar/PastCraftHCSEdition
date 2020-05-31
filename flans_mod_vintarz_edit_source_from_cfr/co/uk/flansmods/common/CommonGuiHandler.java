/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.IGuiHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cupi
 *  cuqu
 *  dwms
 *  ivrt
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.rojd
 *  rojd
 *  zgmv
 */
package co.uk.flansmods.common;

import co.uk.flansmods.client.GuiGunBox;
import co.uk.flansmods.common.CommonProxy;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.GunBoxType;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommonGuiHandler
implements IGuiHandler {
    public Object getServerGuiElement(int n, EntityPlayer entityPlayer, cuqu cuqu2, int n2, int n3, int n4) {
        return FlansMod.proxy.getServerGui(n, entityPlayer, cuqu2, n2, n3, n4);
    }

    public Object getClientGuiElement(int n, EntityPlayer entityPlayer, cuqu cuqu2, int n2, int n3, int n4) {
        return FlansMod.proxy.getClientGui(n, entityPlayer, cuqu2, n2, n3, n4);
    }

    @SideOnly(value=Side.CLIENT)
    public static void openGunBoxGui(EntityPlayer entityPlayer, GunBoxType gunBoxType) {
        EntityPlayerMP entityPlayerMP = rojd.instance().getServer().__af()._h(entityPlayer.field_71092_bJ);
        rojd.instance().displayGuiScreen(entityPlayer, (dwms)new GuiGunBox(entityPlayerMP.field_71071_by, gunBoxType));
    }
}

