package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRenderer extends AxisRenderer {

    /* renamed from: h  reason: collision with root package name */
    protected YAxis f19128h;

    /* renamed from: i  reason: collision with root package name */
    protected Paint f19129i;

    /* renamed from: j  reason: collision with root package name */
    protected Path f19130j = new Path();

    /* renamed from: k  reason: collision with root package name */
    protected RectF f19131k = new RectF();

    /* renamed from: l  reason: collision with root package name */
    protected float[] f19132l = new float[2];

    /* renamed from: m  reason: collision with root package name */
    protected Path f19133m = new Path();

    /* renamed from: n  reason: collision with root package name */
    protected RectF f19134n = new RectF();
    protected Path o = new Path();
    protected float[] p = new float[2];
    protected RectF q = new RectF();

    public YAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, transformer, yAxis);
        this.f19128h = yAxis;
        if (this.f19118a != null) {
            this.f19050e.setColor(ViewCompat.y);
            this.f19050e.setTextSize(Utils.e(10.0f));
            Paint paint = new Paint(1);
            this.f19129i = paint;
            paint.setColor(-7829368);
            this.f19129i.setStrokeWidth(1.0f);
            this.f19129i.setStyle(Paint.Style.STROKE);
        }
    }

    public void g(Canvas canvas) {
        float f2;
        float i2;
        float i3;
        if (this.f19128h.f() && this.f19128h.P()) {
            float[] n2 = n();
            this.f19050e.setTypeface(this.f19128h.c());
            this.f19050e.setTextSize(this.f19128h.b());
            this.f19050e.setColor(this.f19128h.a());
            float d2 = this.f19128h.d();
            float a2 = (((float) Utils.a(this.f19050e, ExifInterface.W4)) / 2.5f) + this.f19128h.e();
            YAxis.AxisDependency v0 = this.f19128h.v0();
            YAxis.YAxisLabelPosition w0 = this.f19128h.w0();
            if (v0 == YAxis.AxisDependency.LEFT) {
                if (w0 == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.f19050e.setTextAlign(Paint.Align.RIGHT);
                    i2 = this.f19118a.P();
                } else {
                    this.f19050e.setTextAlign(Paint.Align.LEFT);
                    i3 = this.f19118a.P();
                    f2 = i3 + d2;
                    k(canvas, f2, n2, a2);
                }
            } else if (w0 == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.f19050e.setTextAlign(Paint.Align.LEFT);
                i3 = this.f19118a.i();
                f2 = i3 + d2;
                k(canvas, f2, n2, a2);
            } else {
                this.f19050e.setTextAlign(Paint.Align.RIGHT);
                i2 = this.f19118a.i();
            }
            f2 = i2 - d2;
            k(canvas, f2, n2, a2);
        }
    }

    public void h(Canvas canvas) {
        float i2;
        float j2;
        float i3;
        if (this.f19128h.f() && this.f19128h.M()) {
            this.f19051f.setColor(this.f19128h.s());
            this.f19051f.setStrokeWidth(this.f19128h.u());
            if (this.f19128h.v0() == YAxis.AxisDependency.LEFT) {
                i2 = this.f19118a.h();
                j2 = this.f19118a.j();
                i3 = this.f19118a.h();
            } else {
                i2 = this.f19118a.i();
                j2 = this.f19118a.j();
                i3 = this.f19118a.i();
            }
            canvas.drawLine(i2, j2, i3, this.f19118a.f(), this.f19051f);
        }
    }

    public void i(Canvas canvas) {
        if (this.f19128h.f()) {
            if (this.f19128h.O()) {
                int save = canvas.save();
                canvas.clipRect(m());
                float[] n2 = n();
                this.f19049d.setColor(this.f19128h.z());
                this.f19049d.setStrokeWidth(this.f19128h.B());
                this.f19049d.setPathEffect(this.f19128h.A());
                Path path = this.f19130j;
                path.reset();
                for (int i2 = 0; i2 < n2.length; i2 += 2) {
                    canvas.drawPath(o(path, i2, n2), this.f19049d);
                    path.reset();
                }
                canvas.restoreToCount(save);
            }
            if (this.f19128h.H0()) {
                l(canvas);
            }
        }
    }

    public void j(Canvas canvas) {
        float P;
        float f2;
        float h2;
        float f3;
        List<LimitLine> D = this.f19128h.D();
        if (D != null && D.size() > 0) {
            float[] fArr = this.p;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.o;
            path.reset();
            for (int i2 = 0; i2 < D.size(); i2++) {
                LimitLine limitLine = D.get(i2);
                if (limitLine.f()) {
                    int save = canvas.save();
                    this.q.set(this.f19118a.q());
                    this.q.inset(0.0f, -limitLine.t());
                    canvas.clipRect(this.q);
                    this.f19052g.setStyle(Paint.Style.STROKE);
                    this.f19052g.setColor(limitLine.s());
                    this.f19052g.setStrokeWidth(limitLine.t());
                    this.f19052g.setPathEffect(limitLine.o());
                    fArr[1] = limitLine.r();
                    this.f19048c.o(fArr);
                    path.moveTo(this.f19118a.h(), fArr[1]);
                    path.lineTo(this.f19118a.i(), fArr[1]);
                    canvas.drawPath(path, this.f19052g);
                    path.reset();
                    String p2 = limitLine.p();
                    if (p2 != null && !p2.equals("")) {
                        this.f19052g.setStyle(limitLine.u());
                        this.f19052g.setPathEffect((PathEffect) null);
                        this.f19052g.setColor(limitLine.a());
                        this.f19052g.setTypeface(limitLine.c());
                        this.f19052g.setStrokeWidth(0.5f);
                        this.f19052g.setTextSize(limitLine.b());
                        float a2 = (float) Utils.a(this.f19052g, p2);
                        float e2 = Utils.e(4.0f) + limitLine.d();
                        float t = limitLine.t() + a2 + limitLine.e();
                        LimitLine.LimitLabelPosition q2 = limitLine.q();
                        if (q2 == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            this.f19052g.setTextAlign(Paint.Align.RIGHT);
                            h2 = this.f19118a.i() - e2;
                            f3 = fArr[1];
                        } else {
                            if (q2 == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                                this.f19052g.setTextAlign(Paint.Align.RIGHT);
                                P = this.f19118a.i() - e2;
                                f2 = fArr[1];
                            } else if (q2 == LimitLine.LimitLabelPosition.LEFT_TOP) {
                                this.f19052g.setTextAlign(Paint.Align.LEFT);
                                h2 = this.f19118a.h() + e2;
                                f3 = fArr[1];
                            } else {
                                this.f19052g.setTextAlign(Paint.Align.LEFT);
                                P = this.f19118a.P() + e2;
                                f2 = fArr[1];
                            }
                            canvas.drawText(p2, P, f2 + t, this.f19052g);
                        }
                        canvas.drawText(p2, h2, (f3 - t) + a2, this.f19052g);
                    }
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k(Canvas canvas, float f2, float[] fArr, float f3) {
        int i2 = this.f19128h.G0() ? this.f19128h.f18933n : this.f19128h.f18933n - 1;
        for (int i3 = !this.f19128h.F0(); i3 < i2; i3++) {
            canvas.drawText(this.f19128h.x(i3), f2, fArr[(i3 * 2) + 1] + f3, this.f19050e);
        }
    }

    /* access modifiers changed from: protected */
    public void l(Canvas canvas) {
        int save = canvas.save();
        this.f19134n.set(this.f19118a.q());
        this.f19134n.inset(0.0f, -this.f19128h.E0());
        canvas.clipRect(this.f19134n);
        MPPointD f2 = this.f19048c.f(0.0f, 0.0f);
        this.f19129i.setColor(this.f19128h.D0());
        this.f19129i.setStrokeWidth(this.f19128h.E0());
        Path path = this.f19133m;
        path.reset();
        path.moveTo(this.f19118a.h(), (float) f2.Z);
        path.lineTo(this.f19118a.i(), (float) f2.Z);
        canvas.drawPath(path, this.f19129i);
        canvas.restoreToCount(save);
    }

    public RectF m() {
        this.f19131k.set(this.f19118a.q());
        this.f19131k.inset(0.0f, -this.f19047b.B());
        return this.f19131k;
    }

    /* access modifiers changed from: protected */
    public float[] n() {
        int length = this.f19132l.length;
        int i2 = this.f19128h.f18933n;
        if (length != i2 * 2) {
            this.f19132l = new float[(i2 * 2)];
        }
        float[] fArr = this.f19132l;
        for (int i3 = 0; i3 < fArr.length; i3 += 2) {
            fArr[i3 + 1] = this.f19128h.f18931l[i3 / 2];
        }
        this.f19048c.o(fArr);
        return fArr;
    }

    /* access modifiers changed from: protected */
    public Path o(Path path, int i2, float[] fArr) {
        int i3 = i2 + 1;
        path.moveTo(this.f19118a.P(), fArr[i3]);
        path.lineTo(this.f19118a.i(), fArr[i3]);
        return path;
    }
}
