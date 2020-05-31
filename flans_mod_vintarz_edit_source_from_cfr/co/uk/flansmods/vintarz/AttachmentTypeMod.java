/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.vintarz;

import co.uk.flansmods.common.guns.AttachmentType;

public class AttachmentTypeMod {
    public final AttachmentType type;
    public float spreadMultiplier;
    public float recoilMultiplier;
    public float damageMultiplier;
    public float bulletSpeedMultiplier;

    public AttachmentTypeMod(AttachmentType attachmentType) {
        this.type = attachmentType;
        this.spreadMultiplier = attachmentType.spreadMultiplier;
        this.recoilMultiplier = attachmentType.recoilMultiplier;
        this.damageMultiplier = attachmentType.damageMultiplier;
        this.bulletSpeedMultiplier = attachmentType.bulletSpeedMultiplier;
    }
}

