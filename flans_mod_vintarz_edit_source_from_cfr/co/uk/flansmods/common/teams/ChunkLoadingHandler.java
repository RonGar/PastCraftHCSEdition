/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  cuqu
 *  hsus
 *  net.minecraftforge.common.flgb
 *  net.minecraftforge.common.flgb$eidn
 *  net.minecraftforge.common.flgb$hrmy
 *  ogpr
 */
package co.uk.flansmods.common.teams;

import co.uk.flansmods.common.teams.TileEntitySpawner;
import java.util.List;
import net.minecraftforge.common.flgb;

public class ChunkLoadingHandler
implements flgb.eidn {
    public void ticketsLoaded(List<flgb.hrmy> list, cuqu cuqu2) {
        for (flgb.hrmy hrmy2 : list) {
            int n;
            int n2;
            int n3 = hrmy2.getModData()._f("xCoord");
            ogpr ogpr2 = cuqu2.func_72796_p(n3, n2 = hrmy2.getModData()._f("yCoord"), n = hrmy2.getModData()._f("zCoord"));
            if (!(ogpr2 instanceof TileEntitySpawner)) continue;
            ((TileEntitySpawner)ogpr2).forceChunkLoading(hrmy2);
        }
    }
}

