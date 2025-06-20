package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class XAxisRenderer extends AxisRenderer {

    /* renamed from: h  reason: collision with root package name */
    protected XAxis f19121h;

    /* renamed from: i  reason: collision with root package name */
    protected Path f19122i = new Path();

    /* renamed from: j  reason: collision with root package name */
    protected float[] f19123j = new float[2];

    /* renamed from: k  reason: collision with root package name */
    protected RectF f19124k = new RectF();

    /* renamed from: l  reason: collision with root package name */
    protected float[] f19125l = new float[2];

    /* renamed from: m  reason: collision with root package name */
    protected RectF f19126m = new RectF();

    /* renamed from: n  reason: collision with root package name */
    float[] f19127n = new float[4];
    private Path o = new Path();

    public XAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer) {
        super(viewPortHandler, transformer, xAxis);
        this.f19121h = xAxis;
        this.f19050e.setColor(ViewCompat.y);
        this.f19050e.setTextAlign(Paint.Align.CENTER);
        this.f19050e.setTextSize(Utils.e(10.0f));
    }

    public void a(float f2, float f3, boolean z) {
        float f4;
        double d2;
        if (this.f19118a.k() > 10.0f && !this.f19118a.E()) {
            MPPointD j2 = this.f19048c.j(this.f19118a.h(), this.f19118a.j());
            MPPointD j3 = this.f19048c.j(this.f19118a.i(), this.f19118a.j());
            if (z) {
                f4 = (float) j3.Y;
                d2 = j2.Y;
            } else {
                f4 = (float) j2.Y;
                d2 = j3.Y;
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
        super.b(f2, f3);
        k();
    }

    public void g(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        if (this.f19121h.f() && this.f19121h.P()) {
            float e2 = this.f19121h.e();
            this.f19050e.setTypeface(this.f19121h.c());
            this.f19050e.setTextSize(this.f19121h.b());
            this.f19050e.setColor(this.f19121h.a());
            MPPointF c2 = MPPointF.c(0.0f, 0.0f);
            if (this.f19121h.w0() == XAxis.XAxisPosition.TOP) {
                c2.Y = 0.5f;
                c2.Z = 1.0f;
                f2 = this.f19118a.j();
            } else {
                if (this.f19121h.w0() == XAxis.XAxisPosition.TOP_INSIDE) {
                    c2.Y = 0.5f;
                    c2.Z = 1.0f;
                    f3 = this.f19118a.j() + e2;
                    e2 = (float) this.f19121h.M;
                } else {
                    if (this.f19121h.w0() != XAxis.XAxisPosition.BOTTOM) {
                        XAxis.XAxisPosition w0 = this.f19121h.w0();
                        XAxis.XAxisPosition xAxisPosition = XAxis.XAxisPosition.BOTTOM_INSIDE;
                        c2.Y = 0.5f;
                        if (w0 == xAxisPosition) {
                            c2.Z = 0.0f;
                            f2 = this.f19118a.f() - e2;
                            e2 = (float) this.f19121h.M;
                        } else {
                            c2.Z = 1.0f;
                            n(canvas, this.f19118a.j() - e2, c2);
                        }
                    }
                    c2.Y = 0.5f;
                    c2.Z = 0.0f;
                    f3 = this.f19118a.f();
                }
                f4 = f3 + e2;
                n(canvas, f4, c2);
                MPPointF.h(c2);
            }
            f4 = f2 - e2;
            n(canvas, f4, c2);
            MPPointF.h(c2);
        }
    }

    public void h(Canvas canvas) {
        if (this.f19121h.M() && this.f19121h.f()) {
            this.f19051f.setColor(this.f19121h.s());
            this.f19051f.setStrokeWidth(this.f19121h.u());
            this.f19051f.setPathEffect(this.f19121h.t());
            if (this.f19121h.w0() == XAxis.XAxisPosition.TOP || this.f19121h.w0() == XAxis.XAxisPosition.TOP_INSIDE || this.f19121h.w0() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f19118a.h(), this.f19118a.j(), this.f19118a.i(), this.f19118a.j(), this.f19051f);
            }
            if (this.f19121h.w0() == XAxis.XAxisPosition.BOTTOM || this.f19121h.w0() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.f19121h.w0() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f19118a.h(), this.f19118a.f(), this.f19118a.i(), this.f19118a.f(), this.f19051f);
            }
        }
    }

    public void i(Canvas canvas) {
        if (this.f19121h.O() && this.f19121h.f()) {
            int save = canvas.save();
            canvas.clipRect(o());
            if (this.f19123j.length != this.f19047b.f18933n * 2) {
                this.f19123j = new float[(this.f19121h.f18933n * 2)];
            }
            float[] fArr = this.f19123j;
            for (int i2 = 0; i2 < fArr.length; i2 += 2) {
                float[] fArr2 = this.f19121h.f18931l;
                int i3 = i2 / 2;
                fArr[i2] = fArr2[i3];
                fArr[i2 + 1] = fArr2[i3];
            }
            this.f19048c.o(fArr);
            r();
            Path path = this.f19122i;
            path.reset();
            for (int i4 = 0; i4 < fArr.length; i4 += 2) {
                l(canvas, fArr[i4], fArr[i4 + 1], path);
            }
            canvas.restoreToCount(save);
        }
    }

    public void j(Canvas canvas) {
        List<LimitLine> D = this.f19121h.D();
        if (D != null && D.size() > 0) {
            float[] fArr = this.f19125l;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            for (int i2 = 0; i2 < D.size(); i2++) {
                LimitLine limitLine = D.get(i2);
                if (limitLine.f()) {
                    int save = canvas.save();
                    this.f19126m.set(this.f19118a.q());
                    this.f19126m.inset(-limitLine.t(), 0.0f);
                    canvas.clipRect(this.f19126m);
                    fArr[0] = limitLine.r();
                    fArr[1] = 0.0f;
                    this.f19048c.o(fArr);
                    q(canvas, limitLine, fArr);
                    p(canvas, limitLine, fArr, limitLine.e() + 2.0f);
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
        String E = this.f19121h.E();
        this.f19050e.setTypeface(this.f19121h.c());
        this.f19050e.setTextSize(this.f19121h.b());
        FSize b2 = Utils.b(this.f19050e, E);
        float f2 = b2.Y;
        float a2 = (float) Utils.a(this.f19050e, "Q");
        FSize D = Utils.D(f2, a2, this.f19121h.v0());
        this.f19121h.J = Math.round(f2);
        this.f19121h.K = Math.round(a2);
        this.f19121h.L = Math.round(D.Y);
        this.f19121h.M = Math.round(D.Z);
        FSize.c(D);
        FSize.c(b2);
    }

    /* access modifiers changed from: protected */
    public void l(Canvas canvas, float f2, float f3, Path path) {
        path.moveTo(f2, this.f19118a.f());
        path.lineTo(f2, this.f19118a.j());
        canvas.drawPath(path, this.f19049d);
        path.reset();
    }

    /* access modifiers changed from: protected */
    public void m(Canvas canvas, String str, float f2, float f3, MPPointF mPPointF, float f4) {
        Utils.n(canvas, str, f2, f3, this.f19050e, mPPointF, f4);
    }

    /* access modifiers changed from: protected */
    public void n(Canvas canvas, float f2, MPPointF mPPointF) {
        float v0 = this.f19121h.v0();
        boolean L = this.f19121h.L();
        int i2 = this.f19121h.f18933n * 2;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3 += 2) {
            XAxis xAxis = this.f19121h;
            if (L) {
                fArr[i3] = xAxis.f18932m[i3 / 2];
            } else {
                fArr[i3] = xAxis.f18931l[i3 / 2];
            }
        }
        this.f19048c.o(fArr);
        for (int i4 = 0; i4 < i2; i4 += 2) {
            float f3 = fArr[i4];
            if (this.f19118a.L(f3)) {
                ValueFormatter H = this.f19121h.H();
                XAxis xAxis2 = this.f19121h;
                int i5 = i4 / 2;
                String c2 = H.c(xAxis2.f18931l[i5], xAxis2);
                if (this.f19121h.x0()) {
                    int i6 = this.f19121h.f18933n;
                    if (i5 == i6 - 1 && i6 > 1) {
                        float d2 = (float) Utils.d(this.f19050e, c2);
                        if (d2 > this.f19118a.Q() * 2.0f && f3 + d2 > this.f19118a.o()) {
                            f3 -= d2 / 2.0f;
                        }
                    } else if (i4 == 0) {
                        f3 += ((float) Utils.d(this.f19050e, c2)) / 2.0f;
                    }
                }
                m(canvas, c2, f3, f2, mPPointF, v0);
            }
        }
    }

    public RectF o() {
        this.f19124k.set(this.f19118a.q());
        this.f19124k.inset(-this.f19047b.B(), 0.0f);
        return this.f19124k;
    }

    public void p(Canvas canvas, LimitLine limitLine, float[] fArr, float f2) {
        float f3;
        float a2;
        float f4;
        String p = limitLine.p();
        if (p != null && !p.equals("")) {
            this.f19052g.setStyle(limitLine.u());
            this.f19052g.setPathEffect((PathEffect) null);
            this.f19052g.setColor(limitLine.a());
            this.f19052g.setStrokeWidth(0.5f);
            this.f19052g.setTextSize(limitLine.b());
            float t = limitLine.t() + limitLine.d();
            LimitLine.LimitLabelPosition q = limitLine.q();
            if (q == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                a2 = (float) Utils.a(this.f19052g, p);
                this.f19052g.setTextAlign(Paint.Align.LEFT);
                f4 = fArr[0] + t;
            } else {
                if (q == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                    this.f19052g.setTextAlign(Paint.Align.LEFT);
                    f3 = fArr[0] + t;
                } else if (q == LimitLine.LimitLabelPosition.LEFT_TOP) {
                    this.f19052g.setTextAlign(Paint.Align.RIGHT);
                    a2 = (float) Utils.a(this.f19052g, p);
                    f4 = fArr[0] - t;
                } else {
                    this.f19052g.setTextAlign(Paint.Align.RIGHT);
                    f3 = fArr[0] - t;
                }
                canvas.drawText(p, f3, this.f19118a.f() - f2, this.f19052g);
                return;
            }
            canvas.drawText(p, f4, this.f19118a.j() + f2 + a2, this.f19052g);
        }
    }

    public void q(Canvas canvas, LimitLine limitLine, float[] fArr) {
        float[] fArr2 = this.f19127n;
        fArr2[0] = fArr[0];
        fArr2[1] = this.f19118a.j();
        float[] fArr3 = this.f19127n;
        fArr3[2] = fArr[0];
        fArr3[3] = this.f19118a.f();
        this.o.reset();
        Path path = this.o;
        float[] fArr4 = this.f19127n;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.o;
        float[] fArr5 = this.f19127n;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.f19052g.setStyle(Paint.Style.STROKE);
        this.f19052g.setColor(limitLine.s());
        this.f19052g.setStrokeWidth(limitLine.t());
        this.f19052g.setPathEffect(limitLine.o());
        canvas.drawPath(this.o, this.f19052g);
    }

    /* access modifiers changed from: protected */
    public void r() {
        this.f19049d.setColor(this.f19121h.z());
        this.f19049d.setStrokeWidth(this.f19121h.B());
        this.f19049d.setPathEffect(this.f19121h.A());
    }
}
