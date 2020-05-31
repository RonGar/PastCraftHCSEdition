/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  net.minecraft.entity.Entity
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.teams.ITeamObject;
import co.uk.flansmods.common.teams.Team;
import co.uk.flansmods.common.teams.TeamsManager;
import java.util.List;
import net.minecraft.entity.Entity;

public interface ITeamBase {
    public void startRound();

    public Team getOwner();

    public TeamsManager.TeamsMap getMap();

    public void setMap(TeamsManager.TeamsMap var1);

    public String getName();

    public void setName(String var1);

    public List<ITeamObject> getObjects();

    public void addObject(ITeamObject var1);

    public void setBase(Team var1);

    public void captureBase(Team var1);

    public void tick();

    public void destroy();

    public Entity getEntity();

    public double getPosX();

    public double getPosY();

    public double getPosZ();

    public cuqu getWorld();

    public void setID(int var1);

    public int getID();

    public ITeamObject getFlag();
}

