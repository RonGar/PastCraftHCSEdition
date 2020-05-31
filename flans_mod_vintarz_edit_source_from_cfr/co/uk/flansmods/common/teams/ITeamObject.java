/*
 * Decompiled with CFR 0.145.
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.teams.ITeamBase;
import co.uk.flansmods.common.teams.Team;

public interface ITeamObject {
    public ITeamBase getBase();

    public void onBaseSet(Team var1);

    public void onBaseCapture(Team var1);

    public void setBase(ITeamBase var1);

    public void tick();

    public void destroy();

    public double getPosX();

    public double getPosY();

    public double getPosZ();

    public boolean isSpawnPoint();
}

