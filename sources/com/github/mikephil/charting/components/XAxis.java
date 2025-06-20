package com.github.mikephil.charting.components;

import com.github.mikephil.charting.utils.Utils;

public class XAxis extends AxisBase {
    public int J = 1;
    public int K = 1;
    public int L = 1;
    public int M = 1;
    protected float N = 0.0f;
    private boolean O = false;
    private XAxisPosition P = XAxisPosition.TOP;

    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxis() {
        this.f18936c = Utils.e(4.0f);
    }

    public void A0(XAxisPosition xAxisPosition) {
        this.P = xAxisPosition;
    }

    public float v0() {
        return this.N;
    }

    public XAxisPosition w0() {
        return this.P;
    }

    public boolean x0() {
        return this.O;
    }

    public void y0(boolean z) {
        this.O = z;
    }

    public void z0(float f2) {
        this.N = f2;
    }
}
