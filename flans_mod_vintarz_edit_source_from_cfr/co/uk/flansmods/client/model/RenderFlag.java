/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.rojd
 *  org.lwjgl.opengl.GL11
 *  uyfg
 */
package co.uk.flansmods.client.model;

import co.uk.flansmods.client.model.ModelFlagpole;
import co.uk.flansmods.common.teams.EntityFlag;
import co.uk.flansmods.common.teams.EntityFlagpole;
import co.uk.flansmods.common.teams.Team;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.rojd;
import org.lwjgl.opengl.GL11;

public class RenderFlag
extends uyfg {
    private static final ResourceLocation texture = new ResourceLocation("flansmod", "teamsMod/Flagpole.png");
    public ModelFlagpole modelFlagpole = new ModelFlagpole();
    public static float angle;

    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.func_110777_b(entity);
        EntityFlag entityFlag = (EntityFlag)entity;
        Team team = entityFlag.getTeam();
        if (team == null) {
            GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
        } else {
            int n = team.teamColour;
            GL11.glColor3f((float)((float)(n >> 16 & 255) / 255.0f), (float)((float)(n >> 8 & 255) / 255.0f), (float)((float)(n & 255) / 255.0f));
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
        GL11.glRotatef((float)f, (float)0.0f, (float)1.0f, (float)0.0f);
        List list = entityFlag.field_70170_p.func_72872_a(EntityFlagpole.class, entityFlag.field_70121_D.func_72314_b(1.0, 2.0, 1.0));
        if (list.size() == 0) {
            GL11.glRotatef((float)angle, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glTranslatef((float)0.5f, (float)0.0f, (float)0.0f);
        }
        GL11.glScalef((float)-1.0f, (float)-1.0f, (float)1.0f);
        this.modelFlagpole.renderFlag(0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f, entityFlag);
        GL11.glPopMatrix();
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return texture;
    }
}

