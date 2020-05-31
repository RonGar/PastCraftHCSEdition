/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Throwables
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.common.FMLLog
 *  cpw.mods.fml.common.LoaderException
 *  cpw.mods.fml.common.ModClassLoader
 *  cpw.mods.fml.common.ModContainer
 *  cpw.mods.fml.common.discovery.ASMDataTable
 *  cpw.mods.fml.common.discovery.ContainerType
 *  cpw.mods.fml.common.discovery.ModCandidate
 *  cpw.mods.fml.common.discovery.ModDiscoverer$1
 *  cpw.mods.fml.relauncher.CoreModManager
 */
package cpw.mods.fml.common.discovery;

import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.ModClassLoader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.discovery.ContainerType;
import cpw.mods.fml.common.discovery.ModCandidate;
import cpw.mods.fml.common.discovery.ModDiscoverer;
import cpw.mods.fml.relauncher.CoreModManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Exception performing whole class analysis.
 */
public class ModDiscoverer {
    private static Pattern zipJar;
    private List<ModCandidate> candidates;
    private ASMDataTable dataTable;
    private List<File> nonModLibs;

    public ModDiscoverer() {
        this.candidates = Lists.newArrayList();
        this.dataTable = new ASMDataTable();
        this.nonModLibs = Lists.newArrayList();
    }

    public void findClasspathMods(ModClassLoader modClassLoader) {
        ImmutableList immutableList = ImmutableList.builder().addAll((Iterable)modClassLoader.getDefaultLibraries()).addAll((Iterable)CoreModManager.getLoadedCoremods()).addAll((Iterable)CoreModManager.getReparseableCoremods()).build();
        File[] arrfile = modClassLoader.getParentSources();
        if (arrfile.length == 1 && arrfile[0].isFile()) {
            FMLLog.fine((String)"Minecraft is a file at %s, loading", (Object[])new Object[]{arrfile[0].getAbsolutePath()});
            this.candidates.add(new ModCandidate(arrfile[0], arrfile[0], ContainerType.JAR, true, true));
        } else {
            for (int i = 0; i < arrfile.length; ++i) {
                if (arrfile[i].isFile()) {
                    if (immutableList.contains(arrfile[i].getName())) {
                        FMLLog.finer((String)"Skipping known library file %s", (Object[])new Object[]{arrfile[i].getAbsolutePath()});
                        continue;
                    }
                    FMLLog.fine((String)"Found a minecraft related file at %s, examining for mod candidates", (Object[])new Object[]{arrfile[i].getAbsolutePath()});
                    this.candidates.add(new ModCandidate(arrfile[i], arrfile[i], ContainerType.JAR, i == 0, true));
                    continue;
                }
                if (!arrfile[i].isDirectory()) continue;
                FMLLog.fine((String)"Found a minecraft related directory at %s, examining for mod candidates", (Object[])new Object[]{arrfile[i].getAbsolutePath()});
                this.candidates.add(new ModCandidate(arrfile[i], arrfile[i], ContainerType.DIR, i == 0, true));
            }
        }
    }

    public void findModDirMods(File file) {
        File[] arrfile = file.listFiles();
        Arrays.sort(arrfile, new /* Unavailable Anonymous Inner Class!! */);
        for (File file2 : arrfile) {
            if (CoreModManager.getLoadedCoremods().contains(file2.getName())) {
                FMLLog.finer((String)"Skipping already parsed coremod or tweaker %s", (Object[])new Object[]{file2.getName()});
                continue;
            }
            if (file2.isDirectory()) {
                FMLLog.fine((String)"Found a candidate mod directory %s", (Object[])new Object[]{file2.getName()});
                this.candidates.add(new ModCandidate(file2, file2, ContainerType.DIR));
                continue;
            }
            Matcher matcher = zipJar.matcher(file2.getName());
            if (matcher.matches()) {
                FMLLog.fine((String)"Found a candidate zip or jar file %s", (Object[])new Object[]{matcher.group(0)});
                this.candidates.add(new ModCandidate(file2, file2, ContainerType.JAR));
                continue;
            }
            FMLLog.fine((String)"Ignoring unknown file %s in mods directory", (Object[])new Object[]{file2.getName()});
        }
    }

    public List<ModContainer> identifyMods() {
        ArrayList arrayList = Lists.newArrayList();
        for (ModCandidate modCandidate : this.candidates) {
            try {
                List list = modCandidate.explore(this.dataTable);
                if (list.isEmpty() && !modCandidate.isClasspath()) {
                    this.nonModLibs.add(modCandidate.getModContainer());
                    continue;
                }
                arrayList.addAll(list);
            }
            catch (LoaderException loaderException) {
                FMLLog.log((Level)Level.WARNING, (Throwable)loaderException, (String)"Identified a problem with the mod candidate %s, ignoring this source", (Object[])new Object[]{modCandidate.getModContainer()});
            }
            catch (Throwable throwable) {
                Throwables.propagate((Throwable)throwable);
            }
        }
        return arrayList;
    }

    public ASMDataTable getASMTable() {
        return this.dataTable;
    }

    public List<File> getNonModLibs() {
        return this.nonModLibs;
    }

    static {
        zipJar = Pattern.compile("(.+).(zip|jar)$");
    }
}

