// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.player;

import net.minecraft.entity.EntityLivingBase;
import java.util.Map;
import net.minecraft.util.hrml;
import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Mouse;
import net.minecraft.client.tuor;
import java.util.ArrayList;
import java.util.Iterator;
import org.lwjgl.input.Keyboard;
import net.minecraft.entity.player.rojd;
import net.minecraft.entity.player.EntityPlayer;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiInventoryCreative extends InventoryDayZ
{
    private static final ResourceLocation field_110424_t;
    private static jyub inventory;
    private static int selectedTabIndex;
    private float currentScroll;
    private boolean isScrolling;
    private boolean wasClicking;
    private zfly searchField;
    private List backupContainerSlots;
    private kkuu field_74235_v;
    private boolean field_74234_w;
    private hawv field_82324_x;
    private static int tabPage;
    private int maxPages;
    
    public GuiInventoryCreative(final EntityPlayer entityPlayer, final InventoryExtended inventoryExtended) {
        super(new ContainerExtendedCreative(entityPlayer, inventoryExtended));
        this.maxPages = 0;
        entityPlayer.field_71070_bA = this.field_74193_d;
        this.field_73885_j = true;
        entityPlayer.func_71064_a((dgqn)pjtw._f, 1);
        this.field_74195_c = 136;
        this.field_74194_b = 195;
    }
    
    @Override
    public void func_73876_c() {
        if (!this.field_73882_e._h._i()) {
            this.field_73882_e._a((dwms)new kkdv((EntityPlayer)this.field_73882_e._r));
        }
        super.func_73876_c();
    }
    
    protected void func_74191_a(final kkuu kkuu, final int n, final int n2, int n3) {
        this.field_74234_w = true;
        final boolean b = n3 == 1;
        n3 = ((n == -999 && n3 == 0) ? 4 : n3);
        if (kkuu == null && GuiInventoryCreative.selectedTabIndex != tekj.field_78036_m.func_78021_a() && n3 != 5) {
            final rojd field_71071_by = this.field_73882_e._r.field_71071_by;
            if (field_71071_by._g() != null) {
                if (n2 == 0) {
                    this.field_73882_e._r.func_71021_b(field_71071_by._g());
                    this.field_73882_e._h._a(field_71071_by._g());
                    field_71071_by._d((ieta)null);
                }
                if (n2 == 1) {
                    final ieta a = field_71071_by._g()._a(1);
                    this.field_73882_e._r.func_71021_b(a);
                    this.field_73882_e._h._a(a);
                    if (field_71071_by._g()._b == 0) {
                        field_71071_by._d((ieta)null);
                    }
                }
            }
        }
        else if (kkuu == this.field_74235_v && b) {
            for (int i = 0; i < this.field_73882_e._r.field_71069_bz.func_75138_a().size(); ++i) {
                this.field_73882_e._h._a((ieta)null, i);
            }
        }
        else if (GuiInventoryCreative.selectedTabIndex == tekj.field_78036_m.func_78021_a()) {
            if (kkuu == this.field_74235_v) {
                this.field_73882_e._r.field_71071_by._d((ieta)null);
            }
            else if (n3 == 4 && kkuu != null && kkuu.func_75216_d()) {
                final ieta func_75209_a = kkuu.func_75209_a((n2 == 0) ? 1 : kkuu.func_75211_c()._d());
                this.field_73882_e._r.func_71021_b(func_75209_a);
                this.field_73882_e._h._a(func_75209_a);
            }
            else if (n3 == 4 && this.field_73882_e._r.field_71071_by._g() != null) {
                this.field_73882_e._r.func_71021_b(this.field_73882_e._r.field_71071_by._g());
                this.field_73882_e._h._a(this.field_73882_e._r.field_71071_by._g());
                this.field_73882_e._r.field_71071_by._d((ieta)null);
            }
            else if (kkuu instanceof SlotArmorCustom) {
                this.field_73882_e._h._a(this.field_74193_d.field_75152_c, this.field_73882_e._r.field_71069_bz.field_75151_b.size() - kkuu.getSlotIndex() - 1, n2, n3, (EntityPlayer)this.field_73882_e._r);
                this.field_73882_e._r.field_71069_bz.func_75142_b();
            }
            else {
                this.field_73882_e._r.field_71069_bz.func_75144_a((kkuu == null) ? n : SlotCreativeInventory.func_75240_a((SlotCreativeInventory)kkuu).field_75222_d, n2, n3, (EntityPlayer)this.field_73882_e._r);
                this.field_73882_e._r.field_71069_bz.func_75142_b();
            }
        }
        else if (n3 != 5 && kkuu.field_75224_c == GuiInventoryCreative.inventory) {
            final rojd field_71071_by2 = this.field_73882_e._r.field_71071_by;
            final ieta g = field_71071_by2._g();
            final ieta func_75211_c = kkuu.func_75211_c();
            if (n3 == 2) {
                if (func_75211_c != null && n2 >= 0 && n2 < 9) {
                    final ieta l = func_75211_c._l();
                    l._b = l._d();
                    this.field_73882_e._r.field_71071_by.func_70299_a(n2, l);
                    this.field_73882_e._r.field_71069_bz.func_75142_b();
                }
                return;
            }
            if (n3 == 3) {
                if (field_71071_by2._g() == null && kkuu.func_75216_d()) {
                    final ieta j = kkuu.func_75211_c()._l();
                    j._b = j._d();
                    field_71071_by2._d(j);
                }
                return;
            }
            if (n3 == 4) {
                if (func_75211_c != null) {
                    final ieta k = func_75211_c._l();
                    k._b = ((n2 == 0) ? 1 : k._d());
                    this.field_73882_e._r.func_71021_b(k);
                    this.field_73882_e._h._a(k);
                }
                return;
            }
            if (g != null && func_75211_c != null && g._b(func_75211_c) && ieta._a(g, func_75211_c)) {
                if (n2 == 0) {
                    if (b) {
                        g._b = g._d();
                    }
                    else if (g._b < g._d()) {
                        final ieta ieta = g;
                        ++ieta._b;
                    }
                }
                else if (g._b <= 1) {
                    field_71071_by2._d((ieta)null);
                }
                else {
                    final ieta ieta2 = g;
                    --ieta2._b;
                }
            }
            else if (func_75211_c != null && g == null) {
                field_71071_by2._d(ieta._c(func_75211_c));
                final ieta g2 = field_71071_by2._g();
                if (b) {
                    g2._b = g2._d();
                }
            }
            else {
                field_71071_by2._d((ieta)null);
            }
        }
        else {
            this.field_74193_d.func_75144_a((kkuu == null) ? n : kkuu.field_75222_d, n2, n3, (EntityPlayer)this.field_73882_e._r);
            if (ivrt.func_94532_c(n2) == 2) {
                for (int n4 = 0; n4 < 9; ++n4) {
                    this.field_73882_e._h._a(this.field_74193_d.func_75139_a(45 + n4).func_75211_c(), 36 + n4);
                }
            }
            else if (kkuu != null) {
                this.field_73882_e._h._a(this.field_74193_d.func_75139_a(kkuu.field_75222_d).func_75211_c(), kkuu.field_75222_d - this.field_74193_d.field_75151_b.size() + 9 + 36);
            }
        }
    }
    
    @Override
    public void func_73866_w_() {
        if (this.field_73882_e._h._i()) {
            super.func_73866_w_();
            Keyboard.enableRepeatEvents(true);
            (this.searchField = new zfly(this.field_73886_k, this.field_74198_m + 82, this.field_74197_n + 6, 89, this.field_73886_k._c))._f(15);
            this.searchField._a(false);
            this.searchField._e(false);
            this.searchField._g(16777215);
            final int selectedTabIndex = GuiInventoryCreative.selectedTabIndex;
            GuiInventoryCreative.selectedTabIndex = -1;
            this.setCurrentCreativeTab(tekj.field_78032_a[selectedTabIndex]);
            this.field_82324_x = new hawv(this.field_73882_e);
            this.field_73882_e._r.field_71069_bz.func_75132_a((qmhj)this.field_82324_x);
            final int length = tekj.field_78032_a.length;
            if (length > 12) {
                this.field_73887_h.add(new tdvs(101, this.field_74198_m, this.field_74197_n - 50, 20, 20, "<"));
                this.field_73887_h.add(new tdvs(102, this.field_74198_m + this.field_74194_b - 20, this.field_74197_n - 50, 20, 20, ">"));
                this.maxPages = (length - 12) / 10 + 1;
            }
        }
        else {
            this.field_73882_e._a((dwms)new kkdv((EntityPlayer)this.field_73882_e._r));
        }
    }
    
    @Override
    public void func_73874_b() {
        super.func_73874_b();
        if (this.field_73882_e._r != null && this.field_73882_e._r.field_71071_by != null) {
            this.field_73882_e._r.field_71069_bz.func_82847_b((qmhj)this.field_82324_x);
        }
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    protected void func_73869_a(final char c, final int n) {
        if (!tekj.field_78032_a[GuiInventoryCreative.selectedTabIndex].hasSearchBar()) {
            if (uyla._a(this.field_73882_e._K.__bk)) {
                this.setCurrentCreativeTab(tekj.field_78027_g);
            }
            else {
                super.func_73869_a(c, n);
            }
        }
        else {
            if (this.field_74234_w) {
                this.field_74234_w = false;
                this.searchField._a("");
            }
            if (!this.func_82319_a(n)) {
                if (this.searchField._a(c, n)) {
                    this.updateCreativeSearch();
                }
                else {
                    super.func_73869_a(c, n);
                }
            }
        }
    }
    
    private void updateCreativeSearch() {
        final ContainerExtendedCreative containerExtendedCreative = (ContainerExtendedCreative)this.field_74193_d;
        containerExtendedCreative.itemList.clear();
        final tekj tekj = tekj.field_78032_a[GuiInventoryCreative.selectedTabIndex];
        if (tekj.hasSearchBar() && tekj != tekj.field_78027_g) {
            tekj.func_78018_a(containerExtendedCreative.itemList);
            this.updateFilteredItems(containerExtendedCreative);
            return;
        }
        for (final jhvs jhvs : jhvs.field_77698_e) {
            if (jhvs != null && jhvs.func_77640_w() != null) {
                jhvs.func_77633_a(jhvs.field_77779_bT, (tekj)null, containerExtendedCreative.itemList);
            }
        }
        final oxau[] a = oxau._a;
        for (int j = 0; j < 256; ++j) {
            final oxau oxau = a[j];
            if (oxau != null && oxau._u != null) {
                jhvs.field_92105_bW._a(oxau, containerExtendedCreative.itemList);
            }
        }
        this.updateFilteredItems(containerExtendedCreative);
    }
    
    private void updateFilteredItems(final ContainerExtendedCreative containerExtendedCreative) {
        final Iterator iterator = containerExtendedCreative.itemList.iterator();
        final String lowerCase = this.searchField._b().toLowerCase();
        while (iterator.hasNext()) {
            final ieta ieta = iterator.next();
            boolean b = false;
            final Iterator iterator2 = ieta._a((EntityPlayer)this.field_73882_e._r, this.field_73882_e._K.__aS).iterator();
            while (iterator2.hasNext()) {
                if (!iterator2.next().toLowerCase().contains(lowerCase)) {
                    continue;
                }
                b = true;
                break;
            }
            if (!b) {
                iterator.remove();
            }
        }
        containerExtendedCreative.scrollTo(this.currentScroll = 0.0f);
    }
    
    protected void func_74189_g(final int n, final int n2) {
        final tekj tekj = tekj.field_78032_a[GuiInventoryCreative.selectedTabIndex];
        if (tekj != null && tekj.func_78019_g()) {
            this.field_73886_k._b(kkkz._a(tekj.func_78024_c()), 8, 6, 4210752);
        }
    }
    
    @Override
    protected void func_73864_a(final int n, final int n2, final int n3) {
        if (n3 == 0) {
            final int n4 = n - this.field_74198_m;
            final int n5 = n2 - this.field_74197_n;
            final tekj[] field_78032_a = tekj.field_78032_a;
            for (int length = field_78032_a.length, i = 0; i < length; ++i) {
                if (this.func_74232_a(field_78032_a[i], n4, n5)) {
                    return;
                }
            }
        }
        super.func_73864_a(n, n2, n3);
    }
    
    protected void func_73879_b(final int n, final int n2, final int n3) {
        if (n3 == 0) {
            final int n4 = n - this.field_74198_m;
            final int n5 = n2 - this.field_74197_n;
            for (final tekj currentCreativeTab : tekj.field_78032_a) {
                if (currentCreativeTab != null && this.func_74232_a(currentCreativeTab, n4, n5)) {
                    this.setCurrentCreativeTab(currentCreativeTab);
                    return;
                }
            }
        }
        super.func_73879_b(n, n2, n3);
    }
    
    private boolean needsScrollBars() {
        return tekj.field_78032_a[GuiInventoryCreative.selectedTabIndex] != null && GuiInventoryCreative.selectedTabIndex != tekj.field_78036_m.func_78021_a() && tekj.field_78032_a[GuiInventoryCreative.selectedTabIndex].func_78017_i() && ((ContainerExtendedCreative)this.field_74193_d).hasMoreThan1PageOfItemsInList();
    }
    
    private void setCurrentCreativeTab(final tekj tekj) {
        if (tekj == null) {
            return;
        }
        final int selectedTabIndex = GuiInventoryCreative.selectedTabIndex;
        GuiInventoryCreative.selectedTabIndex = tekj.func_78021_a();
        final ContainerExtendedCreative containerExtendedCreative = (ContainerExtendedCreative)this.field_74193_d;
        this.field_94077_p.clear();
        containerExtendedCreative.itemList.clear();
        tekj.func_78018_a(containerExtendedCreative.itemList);
        if (tekj == tekj.field_78036_m) {
            final ivrt field_71069_bz = this.field_73882_e._r.field_71069_bz;
            if (this.backupContainerSlots == null) {
                this.backupContainerSlots = containerExtendedCreative.field_75151_b;
            }
            containerExtendedCreative.field_75151_b = new ArrayList();
            for (int i = 0; i < field_71069_bz.field_75151_b.size() - 4; ++i) {
                final SlotCreativeInventory slotCreativeInventory = new SlotCreativeInventory(this, field_71069_bz.field_75151_b.get(i), i);
                containerExtendedCreative.field_75151_b.add(slotCreativeInventory);
                if (i >= 5 && i < 9) {
                    final int n = i - 5;
                    final int n2 = n / 2;
                    final int n3 = n % 2;
                    slotCreativeInventory.field_75223_e = 9 + n2 * 54;
                    slotCreativeInventory.field_75221_f = 6 + n3 * 27;
                }
                else if (i >= 0 && i < 5) {
                    slotCreativeInventory.field_75221_f = -2000;
                    slotCreativeInventory.field_75223_e = -2000;
                }
                else if (i < field_71069_bz.field_75151_b.size()) {
                    final int n4 = i - 9;
                    final int n5 = n4 % 9;
                    final int n6 = n4 / 9;
                    slotCreativeInventory.field_75223_e = 9 + n5 * 18;
                    if (i >= 36) {
                        slotCreativeInventory.field_75221_f = 112;
                    }
                    else {
                        slotCreativeInventory.field_75221_f = 54 + n6 * 18;
                    }
                }
            }
            int n7 = 0;
            for (int j = field_71069_bz.field_75151_b.size() - 6; j < field_71069_bz.field_75151_b.size(); ++j) {
                final SlotArmorCustom slotArmorCustom = new SlotArmorCustom(ExtendedPlayer.client(tuor._E()._r.field_71092_bJ).inventory, field_71069_bz.field_75151_b.get(j), 5 - n7, n7);
                containerExtendedCreative.field_75151_b.add(slotArmorCustom);
                slotArmorCustom.field_75223_e = 85 + n7 * 18;
                slotArmorCustom.field_75221_f = 7;
                ++n7;
            }
            this.field_74235_v = new kkuu((ivrb)GuiInventoryCreative.inventory, 0, 173, 112);
            containerExtendedCreative.field_75151_b.add(this.field_74235_v);
        }
        else if (selectedTabIndex == tekj.field_78036_m.func_78021_a()) {
            containerExtendedCreative.field_75151_b = this.backupContainerSlots;
            this.backupContainerSlots = null;
        }
        if (this.searchField != null) {
            if (tekj.hasSearchBar()) {
                this.searchField._e(true);
                this.searchField._d(false);
                this.searchField._b(true);
                this.searchField._a("");
                this.updateCreativeSearch();
            }
            else {
                this.searchField._e(false);
                this.searchField._d(true);
                this.searchField._b(false);
            }
        }
        containerExtendedCreative.scrollTo(this.currentScroll = 0.0f);
    }
    
    public void func_73867_d() {
        super.func_73867_d();
        int eventDWheel = Mouse.getEventDWheel();
        if (eventDWheel != 0 && this.needsScrollBars()) {
            final int n = ((ContainerExtendedCreative)this.field_74193_d).itemList.size() / 9 - 5 + 1;
            if (eventDWheel > 0) {
                eventDWheel = 1;
            }
            if (eventDWheel < 0) {
                eventDWheel = -1;
            }
            this.currentScroll -= (float)(eventDWheel / (double)n);
            if (this.currentScroll < 0.0f) {
                this.currentScroll = 0.0f;
            }
            if (this.currentScroll > 1.0f) {
                this.currentScroll = 1.0f;
            }
            ((ContainerExtendedCreative)this.field_74193_d).scrollTo(this.currentScroll);
        }
    }
    
    @Override
    public void func_73863_a(final int n, final int n2, final float n3) {
        final boolean buttonDown = Mouse.isButtonDown(0);
        final int field_74198_m = this.field_74198_m;
        final int field_74197_n = this.field_74197_n;
        final int n4 = field_74198_m + 175;
        final int n5 = field_74197_n + 18;
        final int n6 = n4 + 14;
        final int n7 = n5 + 112;
        if (!this.wasClicking && buttonDown && n >= n4 && n2 >= n5 && n < n6 && n2 < n7) {
            this.isScrolling = this.needsScrollBars();
        }
        if (!buttonDown) {
            this.isScrolling = false;
        }
        this.wasClicking = buttonDown;
        if (this.isScrolling) {
            this.currentScroll = (n2 - n5 - 7.5f) / (n7 - n5 - 15.0f);
            if (this.currentScroll < 0.0f) {
                this.currentScroll = 0.0f;
            }
            if (this.currentScroll > 1.0f) {
                this.currentScroll = 1.0f;
            }
            ((ContainerExtendedCreative)this.field_74193_d).scrollTo(this.currentScroll);
        }
        super.func_73863_a(n, n2, n3);
        final tekj[] field_78032_a = tekj.field_78032_a;
        int n8 = GuiInventoryCreative.tabPage * 10;
        final int min = Math.min(field_78032_a.length, (GuiInventoryCreative.tabPage + 1) * 10 + 2);
        if (GuiInventoryCreative.tabPage != 0) {
            n8 += 2;
        }
        boolean b = false;
        for (int i = n8; i < min; ++i) {
            final tekj tekj = field_78032_a[i];
            if (tekj != null && this.renderCreativeInventoryHoveringText(tekj, n, n2)) {
                b = true;
                break;
            }
        }
        if (!b && !this.renderCreativeInventoryHoveringText(tekj.field_78027_g, n, n2)) {
            this.renderCreativeInventoryHoveringText(tekj.field_78036_m, n, n2);
        }
        if (this.field_74235_v != null && GuiInventoryCreative.selectedTabIndex == tekj.field_78036_m.func_78021_a() && this.func_74188_c(this.field_74235_v.field_75223_e, this.field_74235_v.field_75221_f, 16, 16, n, n2)) {
            this.func_74190_a(kkkz._a("inventory.binSlot"), n, n2);
        }
        if (this.maxPages != 0) {
            final String format = String.format("%d / %d", GuiInventoryCreative.tabPage + 1, this.maxPages + 1);
            final int b2 = this.field_73886_k._b(format);
            GL11.glDisable(2896);
            this.field_73735_i = 300.0f;
            GuiInventoryCreative.field_74196_a._f = 300.0f;
            this.field_73886_k._b(format, this.field_74198_m + this.field_74194_b / 2 - b2 / 2, this.field_74197_n - 44, -1);
            this.field_73735_i = 0.0f;
            GuiInventoryCreative.field_74196_a._f = 0.0f;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
    }
    
    protected void func_74184_a(final ieta ieta, final int n, final int n2) {
        if (GuiInventoryCreative.selectedTabIndex == tekj.field_78027_g.func_78021_a()) {
            final List a = ieta._a((EntityPlayer)this.field_73882_e._r, this.field_73882_e._K.__aS);
            tekj func_77640_w = ieta._a().func_77640_w();
            if (func_77640_w == null && ieta._d == jhvs.field_92105_bW.field_77779_bT) {
                final Map a2 = ivog._a(ieta);
                if (a2.size() == 1) {
                    final oxau oxau = oxau._a[a2.keySet().iterator().next()];
                    for (final tekj tekj : tekj.field_78032_a) {
                        if (tekj.func_111226_a(oxau._u)) {
                            func_77640_w = tekj;
                            break;
                        }
                    }
                }
            }
            if (func_77640_w != null) {
                a.add(1, "" + hrml._r + hrml._j + kkkz._a(func_77640_w.func_78024_c()));
            }
            for (int j = 0; j < a.size(); ++j) {
                if (j == 0) {
                    a.set(j, "§" + Integer.toHexString(ieta._w()._e) + a.get(j));
                }
                else {
                    a.set(j, hrml._h + a.get(j));
                }
            }
            this.func_102021_a(a, n, n2);
        }
        else {
            super.func_74184_a(ieta, n, n2);
        }
    }
    
    @Override
    protected void func_74185_a(final float n, final int n2, final int n3) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        ncpk._c();
        final tekj tekj = tekj.field_78032_a[GuiInventoryCreative.selectedTabIndex];
        final tekj[] field_78032_a = tekj.field_78032_a;
        int n4 = GuiInventoryCreative.tabPage * 10;
        final int min = Math.min(field_78032_a.length, (GuiInventoryCreative.tabPage + 1) * 10 + 2);
        if (GuiInventoryCreative.tabPage != 0) {
            n4 += 2;
        }
        for (int i = n4; i < min; ++i) {
            final tekj tekj2 = field_78032_a[i];
            this.field_73882_e._R()._a(GuiInventoryCreative.field_110424_t);
            if (tekj2 != null && tekj2.func_78021_a() != GuiInventoryCreative.selectedTabIndex) {
                this.renderCreativeTab(tekj2);
            }
        }
        if (GuiInventoryCreative.tabPage != 0) {
            if (tekj != tekj.field_78027_g) {
                this.field_73882_e._R()._a(GuiInventoryCreative.field_110424_t);
                this.renderCreativeTab(tekj.field_78027_g);
            }
            if (tekj != tekj.field_78036_m) {
                this.field_73882_e._R()._a(GuiInventoryCreative.field_110424_t);
                this.renderCreativeTab(tekj.field_78036_m);
            }
        }
        this.field_73882_e._R()._a(new ResourceLocation("textures/gui/container/creative_inventory/tab_" + tekj.func_78015_f()));
        this.func_73729_b(this.field_74198_m, this.field_74197_n, 0, 0, this.field_74194_b, this.field_74195_c);
        this.searchField._f();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        final int n5 = this.field_74198_m + 175;
        final int n6 = this.field_74197_n + 18;
        final int n7 = n6 + 112;
        this.field_73882_e._R()._a(GuiInventoryCreative.field_110424_t);
        if (tekj.func_78017_i()) {
            this.func_73729_b(n5, n6 + (int)((n7 - n6 - 17) * this.currentScroll), 232 + (this.needsScrollBars() ? 0 : 12), 0, 12, 15);
        }
        if ((tekj == null || tekj.getTabPage() != GuiInventoryCreative.tabPage) && tekj != tekj.field_78027_g && tekj != tekj.field_78036_m) {
            return;
        }
        this.renderCreativeTab(tekj);
        if (tekj == tekj.field_78036_m) {
            kkdv._a(this.field_74198_m + 43, this.field_74197_n + 45, 20, (float)(this.field_74198_m + 43 - n2), (float)(this.field_74197_n + 45 - 30 - n3), (EntityLivingBase)this.field_73882_e._r);
        }
        super.func_74185_a(n, n2, n3);
    }
    
    protected boolean func_74232_a(final tekj tekj, final int n, final int n2) {
        if (tekj.getTabPage() != GuiInventoryCreative.tabPage && tekj != tekj.field_78027_g && tekj != tekj.field_78036_m) {
            return false;
        }
        final int func_78020_k = tekj.func_78020_k();
        int n3 = 28 * func_78020_k;
        if (func_78020_k == 5) {
            n3 = this.field_74194_b - 28 + 2;
        }
        else if (func_78020_k > 0) {
            n3 += func_78020_k;
        }
        int n4;
        if (tekj.func_78023_l()) {
            n4 = -32;
        }
        else {
            n4 = 0 + this.field_74195_c;
        }
        return n >= n3 && n <= n3 + 28 && n2 >= n4 && n2 <= n4 + 32;
    }
    
    protected boolean renderCreativeInventoryHoveringText(final tekj tekj, final int n, final int n2) {
        final int func_78020_k = tekj.func_78020_k();
        int n3 = 28 * func_78020_k;
        if (func_78020_k == 5) {
            n3 = this.field_74194_b - 28 + 2;
        }
        else if (func_78020_k > 0) {
            n3 += func_78020_k;
        }
        int n4;
        if (tekj.func_78023_l()) {
            n4 = -32;
        }
        else {
            n4 = 0 + this.field_74195_c;
        }
        if (this.func_74188_c(n3 + 3, n4 + 3, 23, 27, n, n2)) {
            this.func_74190_a(kkkz._a(tekj.func_78024_c()), n, n2);
            return true;
        }
        return false;
    }
    
    protected void renderCreativeTab(final tekj tekj) {
        final boolean b = tekj.func_78021_a() == GuiInventoryCreative.selectedTabIndex;
        final boolean func_78023_l = tekj.func_78023_l();
        final int func_78020_k = tekj.func_78020_k();
        final int n = func_78020_k * 28;
        int n2 = 0;
        int n3 = this.field_74198_m + 28 * func_78020_k;
        int field_74197_n = this.field_74197_n;
        if (b) {
            n2 += 32;
        }
        if (func_78020_k == 5) {
            n3 = this.field_74198_m + this.field_74194_b - 28;
        }
        else if (func_78020_k > 0) {
            n3 += func_78020_k;
        }
        if (func_78023_l) {
            field_74197_n -= 28;
        }
        else {
            n2 += 64;
            field_74197_n += this.field_74195_c - 4;
        }
        GL11.glDisable(2896);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        this.func_73729_b(n3, field_74197_n, n, n2, 28, 32);
        this.field_73735_i = 100.0f;
        GuiInventoryCreative.field_74196_a._f = 100.0f;
        n3 += 6;
        final int n4 = field_74197_n + (8 + (func_78023_l ? 1 : -1));
        GL11.glEnable(2896);
        GL11.glEnable(32826);
        final ieta iconItemStack = tekj.getIconItemStack();
        GuiInventoryCreative.field_74196_a._b(this.field_73886_k, this.field_73882_e._R(), iconItemStack, n3, n4);
        GuiInventoryCreative.field_74196_a._c(this.field_73886_k, this.field_73882_e._R(), iconItemStack, n3, n4);
        GL11.glDisable(2896);
        GuiInventoryCreative.field_74196_a._f = 0.0f;
        this.field_73735_i = 0.0f;
    }
    
    @Override
    protected void func_73875_a(final tdvs tdvs) {
        super.func_73875_a(tdvs);
        if (tdvs.field_73741_f == 101) {
            GuiInventoryCreative.tabPage = Math.max(GuiInventoryCreative.tabPage - 1, 0);
        }
        else if (tdvs.field_73741_f == 102) {
            GuiInventoryCreative.tabPage = Math.min(GuiInventoryCreative.tabPage + 1, this.maxPages);
        }
    }
    
    public int getCurrentTabIndex() {
        return GuiInventoryCreative.selectedTabIndex;
    }
    
    public static jyub getInventory() {
        return GuiInventoryCreative.inventory;
    }
    
    static {
        field_110424_t = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
        GuiInventoryCreative.inventory = new jyub("tmp", true, 48);
        GuiInventoryCreative.selectedTabIndex = tekj.field_78030_b.func_78021_a();
        GuiInventoryCreative.tabPage = 0;
    }
}
