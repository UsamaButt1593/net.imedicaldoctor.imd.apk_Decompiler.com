package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

public class YAxis extends AxisBase {
    private boolean J;
    private boolean K;
    protected boolean L;
    protected boolean M;
    private boolean N;
    private boolean O;
    protected int P;
    protected float Q;
    protected float R;
    protected float S;
    private YAxisLabelPosition T;
    private AxisDependency U;
    protected float V;
    protected float W;

    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis() {
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = -7829368;
        this.Q = 1.0f;
        this.R = 10.0f;
        this.S = 10.0f;
        this.T = YAxisLabelPosition.OUTSIDE_CHART;
        this.V = 0.0f;
        this.W = Float.POSITIVE_INFINITY;
        this.U = AxisDependency.LEFT;
        this.f18936c = 0.0f;
    }

    public float A0(Paint paint) {
        paint.setTextSize(this.f18938e);
        float d2 = ((float) Utils.d(paint, E())) + (d() * 2.0f);
        float y0 = y0();
        float x0 = x0();
        if (y0 > 0.0f) {
            y0 = Utils.e(y0);
        }
        if (x0 > 0.0f && x0 != Float.POSITIVE_INFINITY) {
            x0 = Utils.e(x0);
        }
        if (((double) x0) <= 0.0d) {
            x0 = d2;
        }
        return Math.max(y0, Math.min(d2, x0));
    }

    public float B0() {
        return this.S;
    }

    public float C0() {
        return this.R;
    }

    public int D0() {
        return this.P;
    }

    public float E0() {
        return this.Q;
    }

    public boolean F0() {
        return this.J;
    }

    public boolean G0() {
        return this.K;
    }

    public boolean H0() {
        return this.M;
    }

    public boolean I0() {
        return this.L;
    }

    @Deprecated
    public boolean J0() {
        return this.O;
    }

    @Deprecated
    public boolean K0() {
        return this.N;
    }

    public boolean L0() {
        return f() && P() && w0() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    public void M0(boolean z) {
        this.K = z;
    }

    public void N0(boolean z) {
        this.M = z;
    }

    public void O0(boolean z) {
        this.L = z;
    }

    public void P0(float f2) {
        this.W = f2;
    }

    public void Q0(float f2) {
        this.V = f2;
    }

    public void R0(YAxisLabelPosition yAxisLabelPosition) {
        this.T = yAxisLabelPosition;
    }

    public void S0(float f2) {
        this.S = f2;
    }

    public void T0(float f2) {
        this.R = f2;
    }

    @Deprecated
    public void U0(boolean z) {
        if (z) {
            e0(0.0f);
        } else {
            X();
        }
    }

    @Deprecated
    public void V0(boolean z) {
        this.O = z;
    }

    @Deprecated
    public void W0(boolean z) {
        this.N = z;
    }

    public void X0(int i2) {
        this.P = i2;
    }

    public void Y0(float f2) {
        this.Q = Utils.e(f2);
    }

    public void n(float f2, float f3) {
        if (Math.abs(f3 - f2) == 0.0f) {
            f3 += 1.0f;
            f2 -= 1.0f;
        }
        float abs = Math.abs(f3 - f2);
        this.H = this.E ? this.H : f2 - ((abs / 100.0f) * B0());
        float C0 = this.F ? this.G : f3 + ((abs / 100.0f) * C0());
        this.G = C0;
        this.I = Math.abs(this.H - C0);
    }

    public AxisDependency v0() {
        return this.U;
    }

    public YAxisLabelPosition w0() {
        return this.T;
    }

    public float x0() {
        return this.W;
    }

    public float y0() {
        return this.V;
    }

    public float z0(Paint paint) {
        paint.setTextSize(this.f18938e);
        return ((float) Utils.a(paint, E())) + (e() * 2.0f);
    }

    public YAxis(AxisDependency axisDependency) {
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = -7829368;
        this.Q = 1.0f;
        this.R = 10.0f;
        this.S = 10.0f;
        this.T = YAxisLabelPosition.OUTSIDE_CHART;
        this.V = 0.0f;
        this.W = Float.POSITIVE_INFINITY;
        this.U = axisDependency;
        this.f18936c = 0.0f;
    }
}
