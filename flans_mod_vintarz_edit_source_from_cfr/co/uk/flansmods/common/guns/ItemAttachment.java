/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cuqu
 *  hcsmod.server.SPacketHandler
 *  ieta
 *  jhvs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.eidl
 *  net.minecraft.util.roij
 *  qlze
 *  tekj
 */
package co.uk.flansmods.common.guns;

import co.uk.flansmods.common.CreativeTabFlan;
import co.uk.flansmods.common.FlansMod;
import co.uk.flansmods.common.FlansModPlayerData;
import co.uk.flansmods.common.FlansModPlayerHandler;
import co.uk.flansmods.common.guns.AttachmentType;
import co.uk.flansmods.vintarz.AttachmentTypeMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hcsmod.server.SPacketHandler;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidl;
import net.minecraft.util.roij;

public class ItemAttachment
extends jhvs {
    public AttachmentType type;

    public ItemAttachment(int n, AttachmentType attachmentType) {
        super(n);
        this.type = attachmentType;
        this.type.item = this;
        this.field_77777_bU = attachmentType.maxStackSize;
        this.func_77637_a((tekj)FlansMod.tabFlanGuns);
    }

    @SideOnly(value=Side.CLIENT)
    public int func_82790_a(ieta ieta2, int n) {
        return this.type.colour;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(qlze qlze2) {
        this.field_77791_bV = qlze2._a("FlansMod:" + this.type.iconPath);
    }

    public void func_77663_a(ieta ieta2, cuqu cuqu2, Entity entity, int n, boolean bl) {
        if (bl && !cuqu2.field_72995_K && entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            if (entityPlayer.field_71075_bZ._d) {
                FlansModPlayerData flansModPlayerData = FlansModPlayerHandler.getPlayerData(entityPlayer);
                AttachmentTypeMod attachmentTypeMod = flansModPlayerData.overrideAttachments == null ? null : flansModPlayerData.overrideAttachments.get(this.type);
                float f = attachmentTypeMod != null ? attachmentTypeMod.damageMultiplier : this.type.damageMultiplier;
                float f2 = attachmentTypeMod != null ? attachmentTypeMod.spreadMultiplier : this.type.spreadMultiplier;
                float f3 = attachmentTypeMod != null ? attachmentTypeMod.recoilMultiplier : this.type.recoilMultiplier;
                SPacketHandler.sendHint((EntityPlayer)entityPlayer, (String)"attinf", (String)("\u041e\u0431\u0432\u0435\u0441: " + this.type.shortName + "\ndamage: " + f + "\nspread: " + f2 + "\nrecoil: " + f3), (int)20);
            }
        }
    }

    public void func_77624_a(ieta ieta2, EntityPlayer entityPlayer, List list, boolean bl) {
        if (this.type.description != null) {
            for (String string : this.type.description.split("_")) {
                list.add(string);
            }
        }
    }
}

