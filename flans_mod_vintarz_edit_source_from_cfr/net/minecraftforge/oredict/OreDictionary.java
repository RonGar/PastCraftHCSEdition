/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ccbi
 *  hbtt
 *  ieta
 *  jhvs
 *  kjsv
 *  ndfh
 *  net.minecraftforge.common.bpzx
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.eidl
 *  net.minecraftforge.event.tuph
 *  net.minecraftforge.oredict.ShapedOreRecipe
 *  net.minecraftforge.oredict.ShapelessOreRecipe
 *  qmoh
 *  rpnz
 *  tdol
 */
package net.minecraftforge.oredict;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraftforge.common.bpzx;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.eidl;
import net.minecraftforge.event.tuph;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class OreDictionary {
    private static boolean hasInit = false;
    private static int maxID = 0;
    private static HashMap<String, Integer> oreIDs = new HashMap();
    private static HashMap<Integer, ArrayList<ieta>> oreStacks = new HashMap();
    public static final int WILDCARD_VALUE = 32767;

    public static void initVanillaEntries() {
        ieta[] arrieta;
        if (!hasInit) {
            OreDictionary.registerOre("logWood", new ieta(kjsv.field_71951_J, 1, 32767));
            OreDictionary.registerOre("plankWood", new ieta(kjsv.field_71988_x, 1, 32767));
            OreDictionary.registerOre("slabWood", new ieta((kjsv)kjsv.field_72092_bO, 1, 32767));
            OreDictionary.registerOre("stairWood", kjsv.field_72063_at);
            OreDictionary.registerOre("stairWood", kjsv.field_72072_bX);
            OreDictionary.registerOre("stairWood", kjsv.field_72070_bY);
            OreDictionary.registerOre("stairWood", kjsv.field_72074_bW);
            OreDictionary.registerOre("stickWood", jhvs.field_77669_D);
            OreDictionary.registerOre("treeSapling", new ieta(kjsv.field_71987_y, 1, 32767));
            OreDictionary.registerOre("treeLeaves", new ieta((kjsv)kjsv.field_71952_K, 1, 32767));
            OreDictionary.registerOre("oreGold", kjsv.field_71941_G);
            OreDictionary.registerOre("oreIron", kjsv.field_71949_H);
            OreDictionary.registerOre("oreLapis", kjsv.field_71947_N);
            OreDictionary.registerOre("oreDiamond", kjsv.field_72073_aw);
            OreDictionary.registerOre("oreRedstone", kjsv.field_72047_aN);
            OreDictionary.registerOre("oreEmerald", kjsv.field_72068_bR);
            OreDictionary.registerOre("oreQuartz", kjsv.field_94342_cr);
            OreDictionary.registerOre("stone", kjsv.field_71981_t);
            OreDictionary.registerOre("cobblestone", kjsv.field_71978_w);
            OreDictionary.registerOre("record", jhvs.field_77819_bI);
            OreDictionary.registerOre("record", jhvs.field_77797_bJ);
            OreDictionary.registerOre("record", jhvs.field_77799_bK);
            OreDictionary.registerOre("record", jhvs.field_77793_bL);
            OreDictionary.registerOre("record", jhvs.field_77795_bM);
            OreDictionary.registerOre("record", jhvs.field_77805_bN);
            OreDictionary.registerOre("record", jhvs.field_77807_bO);
            OreDictionary.registerOre("record", jhvs.field_77801_bP);
            OreDictionary.registerOre("record", jhvs.field_77803_bQ);
            OreDictionary.registerOre("record", jhvs.field_77783_bR);
            OreDictionary.registerOre("record", jhvs.field_77781_bS);
            OreDictionary.registerOre("record", jhvs.field_85180_cf);
        }
        HashMap<Object, String> hashMap = new HashMap<Object, String>();
        hashMap.put((Object)new ieta(jhvs.field_77669_D), "stickWood");
        hashMap.put((Object)new ieta(kjsv.field_71988_x), "plankWood");
        hashMap.put((Object)new ieta(kjsv.field_71988_x, 1, 32767), "plankWood");
        hashMap.put((Object)new ieta(kjsv.field_71981_t), "stone");
        hashMap.put((Object)new ieta(kjsv.field_71981_t, 1, 32767), "stone");
        hashMap.put((Object)new ieta(kjsv.field_71978_w), "cobblestone");
        hashMap.put((Object)new ieta(kjsv.field_71978_w, 1, 32767), "cobblestone");
        String[] arrstring = new String[]{"dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple", "dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite"};
        for (int i = 0; i < 16; ++i) {
            arrieta = new ieta(jhvs.field_77756_aW, 1, i);
            if (!hasInit) {
                OreDictionary.registerOre(arrstring[i], (ieta)arrieta);
            }
            hashMap.put(arrieta, arrstring[i]);
        }
        hasInit = true;
        ieta[] arrieta2 = hashMap.keySet().toArray((T[])new ieta[hashMap.keySet().size()]);
        arrieta = new ieta[]{new ieta(kjsv.field_71948_O), new ieta(jhvs.field_77743_bc), new ieta(kjsv.field_72007_bm), new ieta((kjsv)kjsv.field_72079_ak), new ieta(kjsv.field_72057_aH), new ieta(kjsv.field_82515_ce), new ieta(kjsv.field_72063_at), new ieta(kjsv.field_72072_bX), new ieta(kjsv.field_72070_bY), new ieta(kjsv.field_72074_bW)};
        List list = rpnz._a()._b();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        for (Object e : list) {
            ieta ieta2;
            hbtt hbtt2;
            if (e instanceof hbtt) {
                hbtt2 = (hbtt)e;
                ieta2 = hbtt2.func_77571_b();
                if (ieta2 != null) {
                    if (OreDictionary.containsMatch(false, arrieta, ieta2)) continue;
                }
                if (!OreDictionary.containsMatch(true, hbtt2._c, arrieta2)) continue;
                arrayList.add((Object)hbtt2);
                arrayList2.add((Object)new ShapedOreRecipe(hbtt2, hashMap));
                continue;
            }
            if (!(e instanceof ndfh)) continue;
            hbtt2 = (ndfh)e;
            ieta2 = hbtt2.func_77571_b();
            if (ieta2 != null) {
                if (OreDictionary.containsMatch(false, arrieta, ieta2)) continue;
            }
            if (!OreDictionary.containsMatch(true, hbtt2._b.toArray((T[])new ieta[hbtt2._b.size()]), arrieta2)) continue;
            arrayList.add((Object)((qmoh)e));
            ShapelessOreRecipe shapelessOreRecipe = new ShapelessOreRecipe((ndfh)hbtt2, hashMap);
            arrayList2.add((Object)shapelessOreRecipe);
        }
        list.removeAll(arrayList);
        list.addAll(arrayList2);
        if (arrayList.size() > 0) {
            System.out.println("Replaced " + arrayList.size() + " ore recipies");
        }
    }

    public static int getOreID(String string) {
        Integer n = oreIDs.get(string);
        if (n == null) {
            n = maxID++;
            oreIDs.put(string, n);
            oreStacks.put(n, new ArrayList());
        }
        return n;
    }

    public static String getOreName(int n) {
        for (Map.Entry<String, Integer> entry : oreIDs.entrySet()) {
            if (n != entry.getValue()) continue;
            return entry.getKey();
        }
        return "Unknown";
    }

    public static int getOreID(ieta ieta2) {
        if (ieta2 == null) {
            return -1;
        }
        for (Map.Entry<Integer, ArrayList<ieta>> entry : oreStacks.entrySet()) {
            for (ieta ieta3 : entry.getValue()) {
                if (ieta2._d != ieta3._d || ieta3._j() != 32767 && ieta2._j() != ieta3._j()) continue;
                return entry.getKey();
            }
        }
        return -1;
    }

    public static ArrayList<ieta> getOres(String string) {
        return OreDictionary.getOres(OreDictionary.getOreID(string));
    }

    public static String[] getOreNames() {
        return oreIDs.keySet().toArray(new String[oreIDs.keySet().size()]);
    }

    public static ArrayList<ieta> getOres(Integer n) {
        ArrayList<Object> arrayList = oreStacks.get(n);
        if (arrayList == null) {
            arrayList = new ArrayList();
            oreStacks.put(n, arrayList);
        }
        return arrayList;
    }

    private static boolean containsMatch(boolean bl, ieta[] arrieta, ieta ... arrieta2) {
        for (ieta ieta2 : arrieta) {
            for (ieta ieta3 : arrieta2) {
                if (!OreDictionary.itemMatches(ieta3, ieta2, bl)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean itemMatches(ieta ieta2, ieta ieta3, boolean bl) {
        if (ieta3 == null && ieta2 != null || ieta3 != null && ieta2 == null) {
            return false;
        }
        return ieta2._d == ieta3._d && (ieta2._j() == 32767 && !bl || ieta2._j() == ieta3._j());
    }

    public static void registerOre(String string, jhvs jhvs2) {
        OreDictionary.registerOre(string, new ieta(jhvs2));
    }

    public static void registerOre(String string, kjsv kjsv2) {
        OreDictionary.registerOre(string, new ieta(kjsv2));
    }

    public static void registerOre(String string, ieta ieta2) {
        OreDictionary.registerOre(string, OreDictionary.getOreID(string), ieta2);
    }

    public static void registerOre(int n, jhvs jhvs2) {
        OreDictionary.registerOre(n, new ieta(jhvs2));
    }

    public static void registerOre(int n, kjsv kjsv2) {
        OreDictionary.registerOre(n, new ieta(kjsv2));
    }

    public static void registerOre(int n, ieta ieta2) {
        OreDictionary.registerOre(OreDictionary.getOreName(n), n, ieta2);
    }

    private static void registerOre(String string, int n, ieta ieta2) {
        ArrayList<ieta> arrayList = OreDictionary.getOres(n);
        ieta2 = ieta2._l();
        arrayList.add(ieta2);
        bpzx.EVENT_BUS.post((Event)new OreRegisterEvent(string, ieta2));
    }

    static {
        OreDictionary.initVanillaEntries();
    }

    public static class OreRegisterEvent
    extends Event {
        public final String Name;
        public final ieta Ore;
        private static tuph LISTENER_LIST;

        public OreRegisterEvent(String string, ieta ieta2) {
            this.Name = string;
            this.Ore = ieta2;
        }

        public OreRegisterEvent() {
        }

        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new tuph(super.getListenerList());
        }

        public tuph getListenerList() {
            return LISTENER_LIST;
        }
    }

}

