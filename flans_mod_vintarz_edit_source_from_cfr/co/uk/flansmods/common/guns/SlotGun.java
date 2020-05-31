/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  ieta
 *  ivrb
 *  jhvs
 *  kkuu
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.rojd
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.guns.AttachmentType;
import co.uk.flansmods.common.guns.EnumAttachmentType;
import co.uk.flansmods.common.guns.GunType;
import co.uk.flansmods.common.guns.ItemAttachment;
import co.uk.flansmods.common.guns.ItemGun;
import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.rojd;

public class SlotGun
extends kkuu {
    private int slotID;
    private SlotGun gunSlot;

    public SlotGun(ivrb ivrb2, int n, int n2, int n3, SlotGun slotGun) {
        super(ivrb2, n, n2, n3);
        this.slotID = n;
        this.gunSlot = slotGun;
    }

    public boolean func_75214_a(ieta ieta2) {
        switch (this.slotID) {
            case 0: {
                return ieta2 == null || ieta2._a() instanceof ItemGun && !((ItemGun)ieta2._a()).type.deployable;
            }
            case 1: {
                return ieta2 == null || this.canAttachToCurrentGun(ieta2) && ((ItemAttachment)ieta2._a()).type.type == EnumAttachmentType.barrel;
            }
            case 2: {
                return ieta2 == null || this.canAttachToCurrentGun(ieta2) && ((ItemAttachment)ieta2._a()).type.type == EnumAttachmentType.sights;
            }
            case 3: {
                return ieta2 == null || this.canAttachToCurrentGun(ieta2) && ((ItemAttachment)ieta2._a()).type.type == EnumAttachmentType.stock;
            }
            case 4: {
                return ieta2 == null || this.canAttachToCurrentGun(ieta2) && ((ItemAttachment)ieta2._a()).type.type == EnumAttachmentType.grip;
            }
        }
        return ieta2 == null || this.canAttachToCurrentGun(ieta2) && ((ItemAttachment)ieta2._a()).type.type == EnumAttachmentType.generic;
    }

    public boolean canAttachToCurrentGun(ieta ieta2) {
        if (ieta2 != null && ieta2._a() instanceof ItemAttachment && this.gunSlot.func_75216_d() && this.gunSlot.func_75211_c()._a() instanceof ItemGun) {
            AttachmentType attachmentType = ((ItemAttachment)ieta2._a()).type;
            GunType gunType = ((ItemGun)this.gunSlot.func_75211_c()._a()).type;
            return gunType.allowAllAttachments || gunType.allowedAttachments.contains(attachmentType);
        }
        return false;
    }

    public void func_82870_a(EntityPlayer entityPlayer, ieta ieta2) {
        super.func_82870_a(entityPlayer, ieta2);
        if (!entityPlayer.field_70170_p.field_72995_K && this.slotID == 0 && entityPlayer.field_71071_by._g() == null) {
            entityPlayer.func_71053_j();
        }
    }
}

