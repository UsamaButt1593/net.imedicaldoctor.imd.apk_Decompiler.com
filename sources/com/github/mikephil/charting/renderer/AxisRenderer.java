package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class AxisRenderer extends Renderer {

    /* renamed from: b  reason: collision with root package name */
    protected AxisBase f19047b;

    /* renamed from: c  reason: collision with root package name */
    protected Transformer f19048c;

    /* renamed from: d  reason: collision with root package name */
    protected Paint f19049d;

    /* renamed from: e  reason: collision with root package name */
    protected Paint f19050e;

    /* renamed from: f  reason: collision with root package name */
    protected Paint f19051f;

    /* renamed from: g  reason: collision with root package name */
    protected Paint f19052g;

    public AxisRenderer(ViewPortHandler viewPortHandler, Transformer transformer, AxisBase axisBase) {
        super(viewPortHandler);
        this.f19048c = transformer;
        this.f19047b = axisBase;
        if (this.f19118a != null) {
            this.f19050e = new Paint(1);
            Paint paint = new Paint();
            this.f19049d = paint;
            paint.setColor(-7829368);
            this.f19049d.setStrokeWidth(1.0f);
            Paint paint2 = this.f19049d;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            this.f19049d.setAlpha(90);
            Paint paint3 = new Paint();
            this.f19051f = paint3;
            paint3.setColor(ViewCompat.y);
            this.f19051f.setStrokeWidth(1.0f);
            this.f19051f.setStyle(style);
            Paint paint4 = new Paint(1);
            this.f19052g = paint4;
            paint4.setStyle(style);
        }
    }

    public void a(float f2, float f3, boolean z) {
        float f4;
        double d2;
        ViewPortHandler viewPortHandler = this.f19118a;
        if (viewPortHandler != null && viewPortHandler.k() > 10.0f && !this.f19118a.F()) {
            MPPointD j2 = this.f19048c.j(this.f19118a.h(), this.f19118a.j());
            MPPointD j3 = this.f19048c.j(this.f19118a.h(), this.f19118a.f());
            if (!z) {
                f4 = (float) j3.Z;
                d2 = j2.Z;
            } else {
                f4 = (float) j2.Z;
                d2 = j3.Z;
            }
            float f5 = (float) d2;
            MPPointD.c(j2);
            MPPointD.c(j3);
            f2 = f4;
            f3 = f5;
        }
        b(f2, f3);
    }

    /* access modifiers changed from: protected */
    public void b(float f2, float f3) {
        float f4 = f2;
        float f5 = f3;
        int C = this.f19047b.C();
        double abs = (double) Math.abs(f5 - f4);
        if (C == 0 || abs <= 0.0d || Double.isInfinite(abs)) {
            AxisBase axisBase = this.f19047b;
            axisBase.f18931l = new float[0];
            axisBase.f18932m = new float[0];
            axisBase.f18933n = 0;
            return;
        }
        double L = (double) Utils.L(abs / ((double) C));
        if (this.f19047b.S() && L < ((double) this.f19047b.y())) {
            L = (double) this.f19047b.y();
        }
        double L2 = (double) Utils.L(Math.pow(10.0d, (double) ((int) Math.log10(L))));
        if (((int) (L / L2)) > 5) {
            L = Math.floor(L2 * 10.0d);
        }
        int L3 = this.f19047b.L();
        if (this.f19047b.R()) {
            L = (double) (((float) abs) / ((float) (C - 1)));
            AxisBase axisBase2 = this.f19047b;
            axisBase2.f18933n = C;
            if (axisBase2.f18931l.length < C) {
                axisBase2.f18931l = new float[C];
            }
            for (int i2 = 0; i2 < C; i2++) {
                this.f19047b.f18931l[i2] = f4;
                f4 = (float) (((double) f4) + L);
            }
        } else {
            int i3 = (L > 0.0d ? 1 : (L == 0.0d ? 0 : -1));
            double ceil = i3 == 0 ? 0.0d : Math.ceil(((double) f4) / L) * L;
            if (this.f19047b.L()) {
                ceil -= L;
            }
            double J = i3 == 0 ? 0.0d : Utils.J(Math.floor(((double) f5) / L) * L);
            if (i3 != 0) {
                for (double d2 = ceil; d2 <= J; d2 += L) {
                    L3++;
                }
            }
            AxisBase axisBase3 = this.f19047b;
            axisBase3.f18933n = L3;
            if (axisBase3.f18931l.length < L3) {
                axisBase3.f18931l = new float[L3];
            }
            for (int i4 = 0; i4 < L3; i4++) {
                if (ceil == 0.0d) {
                    ceil = 0.0d;
                }
                this.f19047b.f18931l[i4] = (float) ceil;
                ceil += L;
            }
            C = L3;
        }
        this.f19047b.o = (L > 1.0d ? 1 : (L == 1.0d ? 0 : -1)) < 0 ? (int) Math.ceil(-Math.log10(L)) : 0;
        if (this.f19047b.L()) {
            AxisBase axisBase4 = this.f19047b;
            if (axisBase4.f18932m.length < C) {
                axisBase4.f18932m = new float[C];
            }
            float f6 = ((float) L) / 2.0f;
            for (int i5 = 0; i5 < C; i5++) {
                AxisBase axisBase5 = this.f19047b;
                axisBase5.f18932m[i5] = axisBase5.f18931l[i5] + f6;
            }
        }
    }

    public Paint c() {
        return this.f19050e;
    }

    public Paint d() {
        return this.f19051f;
    }

    public Paint e() {
        return this.f19049d;
    }

    public Transformer f() {
        return this.f19048c;
    }

    public abstract void g(Canvas canvas);

    public abstract void h(Canvas canvas);

    public abstract void i(Canvas canvas);

    public abstract void j(Canvas canvas);
}
