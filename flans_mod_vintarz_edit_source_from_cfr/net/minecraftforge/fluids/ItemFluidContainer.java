/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  hsus
 *  ieta
 *  jhvs
 *  net.minecraftforge.fluids.FluidStack
 *  net.minecraftforge.fluids.IFluidContainerItem
 *  zxiv
 */
package net.minecraftforge.fluids;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

public class ItemFluidContainer
extends jhvs
implements IFluidContainerItem {
    protected int capacity;

    public ItemFluidContainer(int n) {
        super(n);
    }

    public ItemFluidContainer(int n, int n2) {
        super(n);
        this.capacity = n2;
    }

    public ItemFluidContainer setCapacity(int n) {
        this.capacity = n;
        return this;
    }

    public FluidStack getFluid(ieta ieta2) {
        if (ieta2._e == null || !ieta2._e._c("Fluid")) {
            return null;
        }
        return FluidStack.loadFluidStackFromNBT((hsus)ieta2._e._m("Fluid"));
    }

    public int getCapacity(ieta ieta2) {
        return this.capacity;
    }

    public int fill(ieta ieta2, FluidStack fluidStack, boolean bl) {
        if (fluidStack == null) {
            return 0;
        }
        if (!bl) {
            if (ieta2._e == null || !ieta2._e._c("Fluid")) {
                return Math.min(this.capacity, fluidStack.amount);
            }
            FluidStack fluidStack2 = FluidStack.loadFluidStackFromNBT((hsus)ieta2._e._m("Fluid"));
            if (fluidStack2 == null) {
                return Math.min(this.capacity, fluidStack.amount);
            }
            if (!fluidStack2.isFluidEqual(fluidStack)) {
                return 0;
            }
            return Math.min(this.capacity - fluidStack2.amount, fluidStack.amount);
        }
        if (ieta2._e == null) {
            ieta2._e = new hsus();
        }
        if (!ieta2._e._c("Fluid")) {
            hsus hsus2 = fluidStack.writeToNBT(new hsus());
            if (this.capacity < fluidStack.amount) {
                hsus2._a("Amount", this.capacity);
                ieta2._e._a("Fluid", (zxiv)hsus2);
                return this.capacity;
            }
            ieta2._e._a("Fluid", (zxiv)hsus2);
            return fluidStack.amount;
        }
        hsus hsus3 = ieta2._e._m("Fluid");
        FluidStack fluidStack3 = FluidStack.loadFluidStackFromNBT((hsus)hsus3);
        if (!fluidStack3.isFluidEqual(fluidStack)) {
            return 0;
        }
        int n = this.capacity - fluidStack3.amount;
        if (fluidStack.amount < n) {
            fluidStack3.amount += fluidStack.amount;
            n = fluidStack.amount;
        } else {
            fluidStack3.amount = this.capacity;
        }
        ieta2._e._a("Fluid", (zxiv)fluidStack3.writeToNBT(hsus3));
        return n;
    }

    public FluidStack drain(ieta ieta2, int n, boolean bl) {
        if (ieta2._e == null || !ieta2._e._c("Fluid") || n == 0) {
            return null;
        }
        FluidStack fluidStack = FluidStack.loadFluidStackFromNBT((hsus)ieta2._e._m("Fluid"));
        if (fluidStack == null) {
            return null;
        }
        int n2 = Math.min(fluidStack.amount, n);
        if (bl) {
            if (n >= fluidStack.amount) {
                ieta2._e._p("Fluid");
                if (ieta2._e._e()) {
                    ieta2._e = null;
                }
                return fluidStack;
            }
            hsus hsus2 = ieta2._e._m("Fluid");
            hsus2._a("Amount", hsus2._f("Amount") - n);
            ieta2._e._a("Fluid", (zxiv)hsus2);
        }
        fluidStack.amount = n2;
        return fluidStack;
    }
}

