/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.zwaq
 */
package co.uk.flansmods.common.driveables;

import co.uk.flansmods.common.driveables.DriveableType;
import co.uk.flansmods.common.driveables.EntityDriveable;
import net.minecraft.entity.Entity;
import net.minecraft.util.zwaq;

public class EntityDamageSourceCollision
extends zwaq {
    public EntityDriveable source;

    public EntityDamageSourceCollision(EntityDriveable entityDriveable) {
        super(entityDriveable.getDriveableType().shortName, (Entity)entityDriveable);
        this.source = entityDriveable;
    }
}

