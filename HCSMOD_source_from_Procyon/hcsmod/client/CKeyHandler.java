// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.util.dfat;
import co.uk.flansmods.common.FlansMod;
import hcsmod.HcsInteract;
import java.io.IOException;
import vintarz.core.VCP;
import hcsmod.entity.EntityCorpse;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.tuor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CKeyHandler extends bpzx.uxsf
{
    private static final tuor mc;
    public static hbei interact;
    public static hbei unload;
    private static EntityPlayer targetedPlayer;
    
    public CKeyHandler() {
        super(new hbei[] { CKeyHandler.interact, CKeyHandler.unload }, new boolean[] { true, false });
    }
    
    public String getLabel() {
        return "HCSMOD KeyHandler";
    }
    
    public void keyDown(final EnumSet<TickType> set, final hbei hbei, final boolean b, final boolean b2) {
        if (b) {
            return;
        }
        if (CKeyHandler.mc._z != null) {
            return;
        }
        if (hbei == CKeyHandler.interact) {
            if (b2) {
                if (HcsClient.interactTarget instanceof HcsInteractable) {
                    ((HcsInteractable)HcsClient.interactTarget).interactWith();
                }
                else if (HcsClient.interactTarget instanceof EntityCorpse) {
                    try {
                        final VCP vcp = new VCP(2, "HCSMOD");
                        vcp.writeInt(((EntityCorpse)HcsClient.interactTarget).field_70157_k);
                        vcp.send();
                    }
                    catch (Exception ex) {}
                }
                else if (HcsClient.interactTarget instanceof EntityPlayer) {
                    CKeyHandler.targetedPlayer = (EntityPlayer)HcsClient.interactTarget;
                    final VCP vcp2 = new VCP(1, "vExchange");
                    try {
                        vcp2.writeInt(CKeyHandler.targetedPlayer.field_70157_k);
                    }
                    catch (IOException ex2) {}
                    vcp2.send();
                }
                else if (HcsClient.interactTarget instanceof HcsInteract) {
                    final HcsInteract hcsInteract = (HcsInteract)HcsClient.interactTarget;
                    if (hcsInteract == HcsInteract.VEH_CRAFT) {
                        FlansMod.craftingTable.func_71903_a((cuqu)CKeyHandler.mc._p, HcsInteract.blockX, HcsInteract.blockY, HcsInteract.blockZ, (EntityPlayer)CKeyHandler.mc._r, HcsInteract.blockF, 0.0f, 0.0f, 0.0f);
                    }
                    else if (hcsInteract.type == dfat._a) {
                        final VCP vcp3 = new VCP(15, "HCSMOD");
                        try {
                            vcp3.writeShort(HcsInteract.blockX);
                            vcp3.writeByte(HcsInteract.blockY);
                            vcp3.writeShort(HcsInteract.blockZ);
                            vcp3.writeByte(HcsInteract.blockF);
                        }
                        catch (IOException ex3) {}
                        vcp3.send();
                        if (hcsInteract == HcsInteract.DOOR) {
                            final EntityClientPlayerMP r = CKeyHandler.mc._r;
                            final int c = ((ntaf)kjsv.field_72054_aE)._c((dxti)((EntityPlayer)r).field_70170_p, HcsInteract.blockX, HcsInteract.blockY, HcsInteract.blockZ);
                            final int n = (c & 0x7) ^ 0x4;
                            if ((c & 0x8) == 0x0) {
                                ((EntityPlayer)r).field_70170_p.func_72921_c(HcsInteract.blockX, HcsInteract.blockY, HcsInteract.blockZ, n, 2);
                                ((EntityPlayer)r).field_70170_p.func_72909_d(HcsInteract.blockX, HcsInteract.blockY, HcsInteract.blockZ, HcsInteract.blockX, HcsInteract.blockY, HcsInteract.blockZ);
                            }
                            else {
                                ((EntityPlayer)r).field_70170_p.func_72921_c(HcsInteract.blockX, HcsInteract.blockY - 1, HcsInteract.blockZ, n, 2);
                                ((EntityPlayer)r).field_70170_p.func_72909_d(HcsInteract.blockX, HcsInteract.blockY - 1, HcsInteract.blockZ, HcsInteract.blockX, HcsInteract.blockY, HcsInteract.blockZ);
                            }
                            ((EntityPlayer)r).field_70170_p.func_72889_a((EntityPlayer)r, 1003, HcsInteract.blockX, HcsInteract.blockY, HcsInteract.blockZ, 0);
                        }
                    }
                    else if (hcsInteract.type == dfat._b) {
                        final VCP vcp4 = new VCP(16, "HCSMOD");
                        try {
                            vcp4.writeInt(HcsInteract.entityId);
                        }
                        catch (IOException ex4) {}
                        vcp4.send();
                    }
                }
            }
            else if (CKeyHandler.targetedPlayer != HcsClient.interactTarget) {
                this.unTargetPlayer();
            }
        }
        else if (hbei == CKeyHandler.unload) {
            new VCP(11, "HCSMOD").send();
        }
    }
    
    private void unTargetPlayer() {
        if (CKeyHandler.targetedPlayer != null) {
            CKeyHandler.targetedPlayer = null;
            new VCP(0, "vExchange").send();
        }
    }
    
    public void keyUp(final EnumSet<TickType> set, final hbei hbei, final boolean b) {
        if (hbei == CKeyHandler.interact) {
            this.unTargetPlayer();
        }
    }
    
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT);
    }
    
    static {
        mc = tuor._E();
        CKeyHandler.interact = new hbei("hcsmod_interact", 33);
        CKeyHandler.unload = new hbei("hcsmod_unload", 41);
    }
}
