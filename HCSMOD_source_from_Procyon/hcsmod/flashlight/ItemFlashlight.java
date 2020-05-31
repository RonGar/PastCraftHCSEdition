// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.flashlight;

import co.uk.flansmods.client.KeyInputHandler;
import java.util.List;
import hcsmod.player.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlashlight extends jhvs
{
    public static final int batteryID = 7456;
    
    public ItemFlashlight(final int n) {
        super(n - 256);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final qlze qlze) {
        this.field_77791_bV = qlze._a("hcsmod:flashlight");
    }
    
    public ieta func_77659_a(final ieta ieta, final cuqu cuqu, final EntityPlayer entityPlayer) {
        final ExtendedPlayer server = ExtendedPlayer.server(entityPlayer);
        if (server.inventory.inventoryStacks[4] == null) {
            server.inventory.inventoryStacks[4] = ieta._l();
            --ieta._b;
        }
        return ieta;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ieta ieta, final EntityPlayer entityPlayer, final List list, final boolean b) {
        if (ieta._q() == null) {
            ieta._d(new hsus());
        }
        boolean b2 = false;
        final int f = ieta._q()._f("F");
        if (f == 0) {
            final short e = ieta._q()._e("f");
            if (e == 0) {
                list.add("§a\u0414\u043b\u044f \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0438 \u0431\u0430\u0442\u0430\u0440\u0435\u0438 \u0432\u043e\u0437\u044c\u043c\u0438 \u0444\u043e\u043d\u0430\u0440\u044c \u0432 \u0440\u0443\u043a\u0443,");
                list.add("§a\u0437\u0430\u043a\u0440\u043e\u0439 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c \u0438 \u043d\u0430\u0436\u043c\u0438 \u043a\u043d\u043e\u043a\u0443 \u0432\u043a\u043b/\u0432\u044b\u043a\u043b.");
                b2 = true;
            }
            else {
                list.add("§4\u0412\u044b\u043a\u043b\u044e\u0447\u0435\u043d, \u0437\u0430\u0440\u044f\u0434: " + ((e - 1) / 60 + 1) + "\u043c\u0438\u043d.");
            }
        }
        else {
            final int n = f - Flashlight.getFlashlightTime(FlashlightClient.deltaTime);
            String string;
            if (n > 60) {
                string = "\u0437\u0430\u0440\u044f\u0434: " + ((n - 1) / 60 + 1) + "\u043c\u0438\u043d.";
            }
            else {
                string = "\u0431\u0430\u0442\u0430\u0440\u0435\u044f \u043f\u043e\u0447\u0442\u0438 \u0440\u0430\u0437\u0440\u044f\u0436\u0435\u043d\u0430";
            }
            list.add("§2\u0412\u043a\u043b\u044e\u0447\u0435\u043d, " + string);
        }
        list.add("§5\u041a\u043d\u043e\u043f\u043a\u0430 \u0432\u043a\u043b/\u0432\u044b\u043a\u043b: " + uyla._c(KeyHandler.toggle._d));
        if (!b2) {
            list.add("§e\u0414\u043b\u044f \u0437\u0430\u043c\u0435\u043d\u044b \u0431\u0430\u0442\u0430\u0440\u0435\u0438 \u0432\u043e\u0437\u044c\u043c\u0438 \u0444\u043e\u043d\u0430\u0440\u044c \u0432 \u0440\u0443\u043a\u0443,");
            list.add("§e\u0437\u0430\u043a\u0440\u043e\u0439 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c \u0438 \u043d\u0430\u0436\u043c\u0438 \u043a\u043d\u043e\u043a\u0443 " + uyla._c(KeyInputHandler.reloadKey._d));
        }
    }
}
