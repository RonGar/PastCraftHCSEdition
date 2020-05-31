// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client.gui;

import net.minecraft.util.dwbg;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import hcsmod.client.HcsClient;
import net.minecraft.client.tuor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ScrollHelper
{
    private static int depth;
    private static int maxDepth;
    int fieldLeft;
    int fieldTop;
    int fieldSize;
    private int contentSize;
    int maxScroll;
    int scrollbarStart;
    int scrollbarEnd;
    int scrollOffset;
    int scrollbarOffset;
    int scrollbarSize;
    private int scrollClickBar;
    private int scrollClickMain;
    private int guiScale;
    
    public ScrollHelper() {
        this.scrollClickBar = Integer.MIN_VALUE;
        this.scrollClickMain = Integer.MIN_VALUE;
    }
    
    @SideOnly(Side.CLIENT)
    public void iniStart() {
        this.maxScroll = 0;
        this.contentSize = 0;
        this.scrollOffset = 0;
        this.scrollbarSize = 0;
        this.scrollbarOffset = 0;
    }
    
    @SideOnly(Side.CLIENT)
    public void initAddContentHeight(final int n) {
        this.contentSize += n;
    }
    
    @SideOnly(Side.CLIENT)
    public void initFinish(final int fieldLeft, final int fieldTop, final int n, final int scrollbarStart, final int n2) {
        this.fieldLeft = fieldLeft;
        this.fieldTop = fieldTop;
        this.scrollbarStart = scrollbarStart;
        this.scrollbarEnd = scrollbarStart + n2;
        this.fieldSize = n - fieldTop;
        if (this.contentSize > this.fieldSize) {
            this.maxScroll = this.contentSize - this.fieldSize;
            this.scrollbarSize = this.fieldSize * this.fieldSize / this.contentSize;
        }
        final tuor e = tuor._E();
        this.guiScale = Math.max(1, new gowi(e._K, e._l, e._m).func_78325_e());
    }
    
    @SideOnly(Side.CLIENT)
    public void drawScrollbar() {
        if (this.scrollbarSize > 0) {
            HcsClient.drawRectF((float)this.scrollbarStart, (float)(this.fieldTop + this.scrollbarOffset), (float)this.scrollbarEnd, (float)(this.fieldTop + this.scrollbarOffset + this.scrollbarSize), -5592406);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int beginRender() {
        final tuor e = tuor._E();
        ++ScrollHelper.depth;
        ++ScrollHelper.maxDepth;
        GL11.glEnable(3089);
        GL11.glScissor(0, e._m - (this.fieldTop + this.fieldSize) * this.guiScale, e._l, this.fieldSize * this.guiScale);
        GL11.glTranslatef(0.0f, (float)(-this.scrollOffset), 0.0f);
        return this.scrollOffset;
    }
    
    @SideOnly(Side.CLIENT)
    public void finishRender(final int n, final int n2) {
        GL11.glTranslatef(0.0f, (float)this.scrollOffset, 0.0f);
        GL11.glDisable(3089);
        if (ScrollHelper.depth == ScrollHelper.maxDepth && this.maxScroll > 0) {
            this.scroll(n2, n >= this.fieldLeft && n < this.scrollbarEnd && n2 >= this.fieldTop && n2 < this.fieldTop + this.fieldSize, n >= this.scrollbarStart && n < this.scrollbarEnd && n2 >= this.fieldTop + this.scrollbarOffset && n2 < this.fieldTop + this.scrollbarOffset + this.scrollbarSize);
        }
        if (--ScrollHelper.depth == 0) {
            ScrollHelper.maxDepth = 0;
        }
    }
    
    @SideOnly(Side.CLIENT)
    void scroll(final int n, final boolean b, final boolean b2) {
        int n2 = 0;
        if (HcsClient.leftMousePressed && !HcsClient.wasLeftMousePressed && b2) {
            this.scrollClickBar = n - this.scrollbarOffset;
        }
        else if (HcsClient.leftMousePressed) {
            if (this.scrollClickBar != Integer.MIN_VALUE) {
                this.scrollbarOffset = n - this.scrollClickBar;
                this.scrollbarToScroll();
                n2 = 1;
            }
            else if (this.scrollClickMain != Integer.MIN_VALUE) {
                this.scrollOffset = -n - this.scrollClickMain;
                this.scrollToScrollbar();
                n2 = 1;
            }
        }
        else {
            this.scrollClickBar = Integer.MIN_VALUE;
            this.scrollClickMain = Integer.MIN_VALUE;
        }
        if (n2 == 0 && b) {
            if (HcsClient.leftMousePressed && !HcsClient.wasLeftMousePressed) {
                this.scrollClickMain = -n - this.scrollOffset;
                n2 = 1;
            }
            if (n2 == 0) {
                final int a = dwbg._a(-Mouse.getDWheel() * 20, -20, 20);
                if (a != 0) {
                    this.scrollOffset += a;
                    this.scrollToScrollbar();
                }
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    private void scrollbarToScroll() {
        this.scrollbarOffset = Math.max(0, this.scrollbarOffset);
        this.scrollbarOffset = Math.min(this.scrollbarOffset, this.fieldSize - this.scrollbarSize);
        this.scrollOffset = (int)(this.scrollbarOffset / (float)(this.fieldSize - this.scrollbarSize) * this.maxScroll);
    }
    
    @SideOnly(Side.CLIENT)
    private void scrollToScrollbar() {
        this.scrollOffset = Math.max(0, this.scrollOffset);
        this.scrollOffset = Math.min(this.scrollOffset, this.maxScroll);
        this.scrollbarOffset = (int)(this.scrollOffset / (float)this.maxScroll * (this.fieldSize - this.scrollbarSize));
    }
    
    public static class Horizontal extends ScrollHelper
    {
        @SideOnly(Side.CLIENT)
        @Override
        public void drawScrollbar() {
            if (this.scrollbarSize > 0) {
                HcsClient.drawRectF((float)(this.fieldLeft + this.scrollbarOffset), (float)(this.fieldTop + this.scrollbarStart), (float)(this.fieldLeft + this.scrollbarOffset + this.scrollbarSize), (float)(this.fieldTop + this.scrollbarEnd), -5592406);
            }
        }
        
        @SideOnly(Side.CLIENT)
        @Override
        public int beginRender() {
            ScrollHelper.depth++;
            ScrollHelper.maxDepth++;
            GL11.glTranslatef((float)(-this.scrollOffset), 0.0f, 0.0f);
            return this.scrollOffset;
        }
        
        @SideOnly(Side.CLIENT)
        @Override
        public void finishRender(final int n, final int n2) {
            GL11.glTranslatef((float)this.scrollOffset, 0.0f, 0.0f);
            if (ScrollHelper.depth == ScrollHelper.maxDepth && this.maxScroll > 0) {
                this.scroll(n, n >= this.fieldLeft && n2 >= this.fieldTop && n < this.fieldLeft + this.fieldSize && n2 < this.fieldTop + this.scrollbarEnd, n >= this.fieldLeft + this.scrollbarOffset && n2 >= this.fieldTop + this.scrollbarStart && n < this.fieldLeft + this.scrollbarOffset + this.scrollbarSize && n2 < this.fieldTop + this.scrollbarEnd);
            }
            if (--ScrollHelper.depth == 0) {
                ScrollHelper.maxDepth = 0;
            }
        }
    }
}
