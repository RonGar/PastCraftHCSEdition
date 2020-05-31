/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.TickType
 *  cpw.mods.fml.common.network.IPacketHandler
 *  cpw.mods.fml.common.network.Player
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  dwms
 *  fmqx
 *  hcsmod.client.hud.DayZHud
 *  hcsmod.client.hud.DayZHud$Hint
 *  mrcr
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.tuor
 *  net.minecraft.util.dwbg
 */
package co.uk.flansmods.vintarz;

import co.uk.flansmods.client.FlansModClient;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.client.hud.DayZHud;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.tuor;
import net.minecraft.util.dwbg;

@SideOnly(value=Side.CLIENT)
public class VPrecisePing
implements ITickHandler,
IPacketHandler,
DayZHud.Hint {
    public static VPrecisePing VPrecisePing = new VPrecisePing();
    private int otherPlayerMPPosRotationIncrements;
    private byte[] positions = new byte[3];
    private int nextPosition;
    private int ticksSinceLastPingPacket;

    public VPrecisePing() {
        DayZHud.hints.put("VPrecisePing", this);
    }

    public boolean remove() {
        return false;
    }

    public void addHints(List<String> list) {
        tuor tuor2 = tuor._E();
        if (!(this.ticksSinceLastPingPacket <= 10 || tuor2._z != null && tuor2._z.func_73868_f())) {
            list.add("\u00a7e\u041e\u0431\u043d\u0430\u0440\u0443\u0436\u0435\u043d\u0430 \u043f\u043e\u0442\u0435\u0440\u044f \u0441\u0432\u044f\u0437\u0438");
            list.add("\u00a7e\u0421\u043e\u0432\u0435\u0442\u0443\u0435\u043c \u0441\u0434\u0435\u043b\u0430\u0442\u044c \u00a76\u0441\u043a\u0440\u0438\u043d\u0448\u043e\u0442\u00a7e(\u00a74F2\u00a7e) \u0438\u043b\u0438 \u00a76\u0432\u0438\u0434\u0435\u043e\u00a7e!");
        }
    }

    public void onPacketData(mrcr mrcr2, fmqx fmqx2, Player player) {
        byte by;
        this.positions[this.nextPosition] = by = fmqx2._c[0];
        if (++this.nextPosition >= this.positions.length) {
            int n = this.positions.length * 3 / 2;
            byte[] arrby = new byte[n];
            System.arraycopy(this.positions, 0, arrby, 0, this.positions.length);
            this.positions = arrby;
        }
        if (this.nextPosition > 1) {
            this.otherPlayerMPPosRotationIncrements = 2;
        }
        this.ticksSinceLastPingPacket = 0;
    }

    public void tickStart(EnumSet<TickType> enumSet, Object ... arrobject) {
        this.ticksSinceLastPingPacket = tuor._E()._r != null ? ++this.ticksSinceLastPingPacket : 0;
        if (this.otherPlayerMPPosRotationIncrements > 0) {
            int n = Math.max(0, this.nextPosition - 1);
            int n2 = this.nextPosition <= this.otherPlayerMPPosRotationIncrements ? 0 : dwbg._d((float)((float)n / (float)this.otherPlayerMPPosRotationIncrements));
            FlansModClient.pingResponse = this.positions[n2] & 255;
            if (this.nextPosition > 0) {
                this.nextPosition -= ++n2;
                if (this.nextPosition > 0) {
                    System.arraycopy(this.positions, n2, this.positions, 0, this.nextPosition);
                }
            }
            --this.otherPlayerMPPosRotationIncrements;
        }
    }

    public void tickEnd(EnumSet<TickType> enumSet, Object ... arrobject) {
    }

    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT);
    }

    public String getLabel() {
        return "VPrecisePingClient";
    }
}

