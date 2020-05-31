// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.player;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.flashlight.Flashlight;
import hcsmod.HCS;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.roij;

public class SlotArmorCustom extends kkuu
{
    public static roij pnv;
    public static roij backpack;
    public static roij flashlight;
    public static roij jammer;
    public static roij raincoat;
    public static roij holster;
    public static roij warmclothes;
    final int armorType;
    
    public SlotArmorCustom(final EntityPlayer entityPlayer, final ivrb ivrb, final int n, final int n2, final int n3, final int armorType) {
        super(ivrb, n, n2, n3);
        this.armorType = armorType;
    }
    
    public SlotArmorCustom(final InventoryExtended inventoryExtended, final kkuu kkuu, final int n, final int armorType) {
        super((ivrb)inventoryExtended, n, kkuu.field_75223_e, kkuu.field_75221_f);
        this.armorType = armorType;
    }
    
    public int func_75219_a() {
        return 1;
    }
    
    public boolean func_75214_a(final ieta ieta) {
        final jhvs jhvs = (ieta == null) ? null : ieta._a();
        return jhvs != null && ((this.armorType == 2 && (jhvs.field_77779_bT == HCS.min.field_77779_bT || jhvs.field_77779_bT == HCS.mid.field_77779_bT || jhvs.field_77779_bT == HCS.max.field_77779_bT)) || (this.armorType == 0 && jhvs == HCS.PNV) || (this.armorType == 1 && jhvs == Flashlight.flashlight) || (this.armorType == 3 && jhvs == HCS.raincoat) || (this.armorType == 4 && jhvs == HCS.holster) || (this.armorType == 5 && jhvs == HCS.warmclothes));
    }
    
    @SideOnly(Side.CLIENT)
    public roij func_75212_b() {
        if (this.armorType == 0) {
            return SlotArmorCustom.pnv;
        }
        if (this.armorType == 2) {
            return SlotArmorCustom.backpack;
        }
        if (this.armorType == 1) {
            return SlotArmorCustom.flashlight;
        }
        if (this.armorType == 3) {
            return SlotArmorCustom.raincoat;
        }
        if (this.armorType == 4) {
            return SlotArmorCustom.holster;
        }
        if (this.armorType == 5) {
            return SlotArmorCustom.warmclothes;
        }
        return null;
    }
}
