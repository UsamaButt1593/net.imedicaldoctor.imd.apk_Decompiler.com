package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.util.Log;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class AxisBase extends ComponentBase {
    protected boolean A = false;
    protected boolean B = true;
    protected float C = 0.0f;
    protected float D = 0.0f;
    protected boolean E = false;
    protected boolean F = false;
    public float G = 0.0f;
    public float H = 0.0f;
    public float I = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    protected ValueFormatter f18926g;

    /* renamed from: h  reason: collision with root package name */
    private int f18927h = -7829368;

    /* renamed from: i  reason: collision with root package name */
    private float f18928i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private int f18929j = -7829368;

    /* renamed from: k  reason: collision with root package name */
    private float f18930k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    public float[] f18931l = new float[0];

    /* renamed from: m  reason: collision with root package name */
    public float[] f18932m = new float[0];

    /* renamed from: n  reason: collision with root package name */
    public int f18933n;
    public int o;
    private int p = 6;
    protected float q = 1.0f;
    protected boolean r = false;
    protected boolean s = false;
    protected boolean t = true;
    protected boolean u = true;
    protected boolean v = true;
    protected boolean w = false;
    private DashPathEffect x = null;
    private DashPathEffect y = null;
    protected List<LimitLine> z;

    public AxisBase() {
        this.f18938e = Utils.e(10.0f);
        this.f18935b = Utils.e(5.0f);
        this.f18936c = Utils.e(5.0f);
        this.z = new ArrayList();
    }

    public DashPathEffect A() {
        return this.y;
    }

    public float B() {
        return this.f18928i;
    }

    public int C() {
        return this.p;
    }

    public List<LimitLine> D() {
        return this.z;
    }

    public String E() {
        String str = "";
        for (int i2 = 0; i2 < this.f18931l.length; i2++) {
            String x2 = x(i2);
            if (x2 != null && str.length() < x2.length()) {
                str = x2;
            }
        }
        return str;
    }

    public float F() {
        return this.D;
    }

    public float G() {
        return this.C;
    }

    public ValueFormatter H() {
        ValueFormatter valueFormatter = this.f18926g;
        if (valueFormatter == null || ((valueFormatter instanceof DefaultAxisValueFormatter) && ((DefaultAxisValueFormatter) valueFormatter).l() != this.o)) {
            this.f18926g = new DefaultAxisValueFormatter(this.o);
        }
        return this.f18926g;
    }

    public boolean I() {
        return this.x != null;
    }

    public boolean J() {
        return this.F;
    }

    public boolean K() {
        return this.E;
    }

    public boolean L() {
        return this.w && this.f18933n > 0;
    }

    public boolean M() {
        return this.u;
    }

    public boolean N() {
        return this.B;
    }

    public boolean O() {
        return this.t;
    }

    public boolean P() {
        return this.v;
    }

    public boolean Q() {
        return this.A;
    }

    public boolean R() {
        return this.s;
    }

    public boolean S() {
        return this.r;
    }

    public boolean T() {
        return this.y != null;
    }

    public void U() {
        this.z.clear();
    }

    public void V(LimitLine limitLine) {
        this.z.remove(limitLine);
    }

    public void W() {
        this.F = false;
    }

    public void X() {
        this.E = false;
    }

    public void Y(int i2) {
        this.f18929j = i2;
    }

    public void Z(DashPathEffect dashPathEffect) {
        this.x = dashPathEffect;
    }

    public void a0(float f2) {
        this.f18930k = Utils.e(f2);
    }

    @Deprecated
    public void b0(float f2) {
        c0(f2);
    }

    public void c0(float f2) {
        this.F = true;
        this.G = f2;
        this.I = Math.abs(f2 - this.H);
    }

    @Deprecated
    public void d0(float f2) {
        e0(f2);
    }

    public void e0(float f2) {
        this.E = true;
        this.H = f2;
        this.I = Math.abs(this.G - f2);
    }

    public void f0(boolean z2) {
        this.w = z2;
    }

    public void g0(boolean z2) {
        this.u = z2;
    }

    public void h0(boolean z2) {
        this.t = z2;
    }

    public void i0(boolean z2) {
        this.B = z2;
    }

    public void j0(boolean z2) {
        this.v = z2;
    }

    public void k0(boolean z2) {
        this.A = z2;
    }

    public void l0(float f2) {
        this.q = f2;
        this.r = true;
    }

    public void m(LimitLine limitLine) {
        this.z.add(limitLine);
        if (this.z.size() > 6) {
            Log.e("MPAndroiChart", "Warning! You have more than 6 LimitLines on your axis, do you really want that?");
        }
    }

    public void m0(boolean z2) {
        this.r = z2;
    }

    public void n(float f2, float f3) {
        float f4 = this.E ? this.H : f2 - this.C;
        float f5 = this.F ? this.G : f3 + this.D;
        if (Math.abs(f5 - f4) == 0.0f) {
            f5 += 1.0f;
            f4 -= 1.0f;
        }
        this.H = f4;
        this.G = f5;
        this.I = Math.abs(f5 - f4);
    }

    public void n0(int i2) {
        this.f18927h = i2;
    }

    public void o() {
        this.x = null;
    }

    public void o0(DashPathEffect dashPathEffect) {
        this.y = dashPathEffect;
    }

    public void p() {
        this.y = null;
    }

    public void p0(float f2) {
        this.f18928i = Utils.e(f2);
    }

    public void q(float f2, float f3, float f4) {
        this.x = new DashPathEffect(new float[]{f2, f3}, f4);
    }

    public void q0(int i2) {
        if (i2 > 25) {
            i2 = 25;
        }
        if (i2 < 2) {
            i2 = 2;
        }
        this.p = i2;
        this.s = false;
    }

    public void r(float f2, float f3, float f4) {
        this.y = new DashPathEffect(new float[]{f2, f3}, f4);
    }

    public void r0(int i2, boolean z2) {
        q0(i2);
        this.s = z2;
    }

    public int s() {
        return this.f18929j;
    }

    public void s0(float f2) {
        this.D = f2;
    }

    public DashPathEffect t() {
        return this.x;
    }

    public void t0(float f2) {
        this.C = f2;
    }

    public float u() {
        return this.f18930k;
    }

    public void u0(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            valueFormatter = new DefaultAxisValueFormatter(this.o);
        }
        this.f18926g = valueFormatter;
    }

    public float v() {
        return this.G;
    }

    public float w() {
        return this.H;
    }

    public String x(int i2) {
        return (i2 < 0 || i2 >= this.f18931l.length) ? "" : H().c(this.f18931l[i2], this);
    }

    public float y() {
        return this.q;
    }

    public int z() {
        return this.f18927h;
    }
}
