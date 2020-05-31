// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod;

import co.uk.flansmods.common.BlockPlaneWorkbench;
import co.uk.flansmods.common.driveables.EntitySeat;
import mcheli.aircraft.MCH_EntitySeat;
import hcsmod.entity.EntityPalatka;
import hcsmod.entity.EntityKoster;
import hcsmod.entity.EntityHouseCommon;
import net.minecraft.entity.Entity;
import mcheli.aircraft.MCH_EntityAircraft;
import net.minecraft.util.idqh;
import net.minecraft.util.dfat;

public enum HcsInteract
{
    DOOR("\u0414\u0432\u0435\u0440\u044c", dfat._a), 
    CRATE("\u042f\u0449\u0438\u043a", dfat._a), 
    LEVER("\u0420\u044b\u0447\u0430\u0433", dfat._a), 
    TRAPDOOR("\u041b\u044e\u043a", dfat._a), 
    BUTTON("\u041a\u043d\u043e\u043f\u043a\u0430", dfat._a), 
    BOTTLE("\u0421\u0435\u0441\u0442\u044c", dfat._b), 
    VEH_CRAFT("\u041a\u0440\u0430\u0444\u0442 \u043c\u0430\u0448\u0438\u043d", dfat._a), 
    PILOT("\u0421\u0435\u0441\u0442\u044c \u043f\u0438\u043b\u043e\u0442\u043e\u043c", dfat._b), 
    DRIVER("\u0421\u0435\u0441\u0442\u044c \u0432\u043e\u0434\u0438\u0442\u0435\u043b\u0435\u043c", dfat._b), 
    HOUSE("\u0414\u043e\u043c", dfat._b), 
    PALATKE("\u041f\u0430\u043b\u0430\u0442\u043a\u0430", dfat._b), 
    OPEN_INVENTORY("\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c", dfat._b), 
    WORKBENCH("\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u0432\u0435\u0440\u0441\u0442\u0430\u043a", dfat._a), 
    CAMP_FIRE("\u041a\u043e\u0441\u0442\u0435\u0440", dfat._b);
    
    public final String name;
    public final dfat type;
    public static boolean $;
    public static int blockX;
    public static int blockY;
    public static int blockZ;
    public static int blockF;
    public static int entityId;
    
    private HcsInteract(final String name2, final dfat type) {
        this.name = name2;
        this.type = type;
    }
    
    public static Object findInteractable(final idqh idqh, final Object o, final idqh idqh2, final cuqu cuqu) {
        if (o instanceof MCH_EntityAircraft) {
            return $((Entity)o, HcsInteract.PILOT);
        }
        if (o instanceof EntityHouseCommon) {
            return $((Entity)o, HcsInteract.HOUSE);
        }
        if (o instanceof EntityKoster) {
            return $((Entity)o, HcsInteract.CAMP_FIRE);
        }
        if (o instanceof EntityPalatka) {
            return $((Entity)o, HcsInteract.PALATKE);
        }
        if (o instanceof MCH_EntitySeat) {
            return $((Entity)o, HcsInteract.BOTTLE);
        }
        if (o instanceof EntitySeat) {
            if (((EntitySeat)o).driver) {
                return $((Entity)o, HcsInteract.DRIVER);
            }
            return $((Entity)o, HcsInteract.BOTTLE);
        }
        else {
            if (o != null) {
                return o;
            }
            if (idqh != null) {
                final kjsv kjsv = kjsv.field_71973_m[cuqu.func_72798_a(idqh._b, idqh._c, idqh._d)];
                if (kjsv instanceof ntaf) {
                    return $(idqh, HcsInteract.DOOR);
                }
                if (kjsv instanceof ntdx) {
                    return $(idqh, HcsInteract.TRAPDOOR);
                }
                if (kjsv instanceof dwdz) {
                    return $(idqh, HcsInteract.CRATE);
                }
                if (kjsv instanceof BlockPlaneWorkbench) {
                    return $(idqh, HcsInteract.VEH_CRAFT);
                }
                if (kjsv instanceof qlkv) {
                    return $(idqh, HcsInteract.WORKBENCH);
                }
            }
            if (idqh2 != null && idqh2._a == dfat._a) {
                final kjsv kjsv2 = kjsv.field_71973_m[cuqu.func_72798_a(idqh2._b, idqh2._c, idqh2._d)];
                if (kjsv2 instanceof lmwe) {
                    return $(idqh2, HcsInteract.BUTTON);
                }
                if (kjsv2 instanceof owfy) {
                    return $(idqh2, HcsInteract.LEVER);
                }
            }
            return null;
        }
    }
    
    public static Object $(final Entity entity, final Object o) {
        HcsInteract.entityId = entity.field_70157_k;
        return o;
    }
    
    public static Object $(final idqh idqh, final Object o) {
        HcsInteract.blockX = idqh._b;
        HcsInteract.blockY = idqh._c;
        HcsInteract.blockZ = idqh._d;
        HcsInteract.blockF = idqh._e;
        return o;
    }
    
    public static boolean $(final kjsv kjsv) {
        return kjsv instanceof ntaf || kjsv instanceof dwdz || kjsv instanceof owfy || kjsv instanceof ntdx || kjsv instanceof lmwe || kjsv instanceof BlockPlaneWorkbench || kjsv instanceof qlkv;
    }
    
    public static boolean $(final Entity entity) {
        return (entity instanceof EntitySeat || entity instanceof MCH_EntityAircraft || entity instanceof MCH_EntitySeat || entity instanceof EntityPalatka || entity instanceof EntityKoster || entity instanceof EntityHouseCommon) && entity.func_70089_S();
    }
}
