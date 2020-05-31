/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  net.minecraft.entity.Entity
 *  ogpr
 */
package icbm.api;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.Entity;
import universalelectricity.core.vector.Vector2;
import universalelectricity.core.vector.Vector3;
import universalelectricity.prefab.vector.Region2;

public class RadarRegistry {
    private static Set<ogpr> detectableTileEntities = new HashSet<ogpr>();
    private static Set<Entity> detectableEntities = new HashSet<Entity>();

    public static void register(ogpr ogpr2) {
        if (!detectableTileEntities.contains((Object)ogpr2)) {
            detectableTileEntities.add(ogpr2);
        }
    }

    public static void unregister(ogpr ogpr2) {
        if (detectableTileEntities.contains((Object)ogpr2)) {
            detectableTileEntities.remove((Object)ogpr2);
        }
    }

    public static void register(Entity entity) {
        if (!detectableEntities.contains((Object)entity)) {
            detectableEntities.add(entity);
        }
    }

    public static void unregister(Entity entity) {
        if (detectableEntities.contains((Object)entity)) {
            detectableEntities.remove((Object)entity);
        }
    }

    public static List<ogpr> getTileEntitiesInArea(Vector2 vector2, Vector2 vector22) {
        RadarRegistry.cleanUpArray();
        ArrayList<ogpr> arrayList = new ArrayList<ogpr>();
        for (ogpr ogpr2 : detectableTileEntities) {
            if (!new Region2(vector2, vector22).isIn(new Vector3(ogpr2).toVector2())) continue;
            arrayList.add(ogpr2);
        }
        return arrayList;
    }

    public static List<Entity> getEntitiesWithinRadius(Vector2 vector2, int n) {
        RadarRegistry.cleanUpArray();
        ArrayList<Entity> arrayList = new ArrayList<Entity>();
        for (Entity entity : detectableEntities) {
            Vector3 vector3 = new Vector3(entity);
            if (!(Vector2.distance(vector2, vector3.toVector2()) <= (double)n)) continue;
            arrayList.add(entity);
        }
        return arrayList;
    }

    public static Set<ogpr> getTileEntities() {
        RadarRegistry.cleanUpArray();
        return detectableTileEntities;
    }

    public static Set<Entity> getEntities() {
        RadarRegistry.cleanUpArray();
        return detectableEntities;
    }

    public static void cleanUpArray() {
        try {
            ogpr ogpr2;
            Iterator<ogpr> iterator = detectableTileEntities.iterator();
            while (iterator.hasNext()) {
                ogpr2 = iterator.next();
                if (ogpr2 == null) {
                    iterator.remove();
                    continue;
                }
                if (ogpr2.func_70320_p()) {
                    iterator.remove();
                    continue;
                }
                if (ogpr2.field_70331_k.func_72796_p(ogpr2.field_70329_l, ogpr2.field_70330_m, ogpr2.field_70327_n) == ogpr2) continue;
                iterator.remove();
            }
            ogpr2 = detectableEntities.iterator();
            while (ogpr2.hasNext()) {
                Entity entity = (Entity)ogpr2.next();
                if (entity == null) {
                    ogpr2.remove();
                    continue;
                }
                if (!entity.field_70128_L) continue;
                ogpr2.remove();
            }
        }
        catch (Exception exception) {
            System.out.println("Failed to clean up radar list properly.");
            exception.printStackTrace();
        }
    }
}

