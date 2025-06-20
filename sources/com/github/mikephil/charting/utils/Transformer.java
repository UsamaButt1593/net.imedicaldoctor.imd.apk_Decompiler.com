package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.List;

public class Transformer {

    /* renamed from: a  reason: collision with root package name */
    protected Matrix f19152a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    protected Matrix f19153b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    protected ViewPortHandler f19154c;

    /* renamed from: d  reason: collision with root package name */
    protected float[] f19155d = new float[1];

    /* renamed from: e  reason: collision with root package name */
    protected float[] f19156e = new float[1];

    /* renamed from: f  reason: collision with root package name */
    protected float[] f19157f = new float[1];

    /* renamed from: g  reason: collision with root package name */
    protected float[] f19158g = new float[1];

    /* renamed from: h  reason: collision with root package name */
    protected Matrix f19159h = new Matrix();

    /* renamed from: i  reason: collision with root package name */
    float[] f19160i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    private Matrix f19161j = new Matrix();

    /* renamed from: k  reason: collision with root package name */
    private Matrix f19162k = new Matrix();

    public Transformer(ViewPortHandler viewPortHandler) {
        this.f19154c = viewPortHandler;
    }

    public float[] a(IBubbleDataSet iBubbleDataSet, float f2, int i2, int i3) {
        int i4 = ((i3 - i2) + 1) * 2;
        if (this.f19156e.length != i4) {
            this.f19156e = new float[i4];
        }
        float[] fArr = this.f19156e;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            Entry X = iBubbleDataSet.X((i5 / 2) + i2);
            if (X != null) {
                fArr[i5] = X.m();
                fArr[i5 + 1] = X.c() * f2;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        i().mapPoints(fArr);
        return fArr;
    }

    public float[] b(ICandleDataSet iCandleDataSet, float f2, float f3, int i2, int i3) {
        int i4 = ((int) ((((float) (i3 - i2)) * f2) + 1.0f)) * 2;
        if (this.f19158g.length != i4) {
            this.f19158g = new float[i4];
        }
        float[] fArr = this.f19158g;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.X((i5 / 2) + i2);
            if (candleEntry != null) {
                fArr[i5] = candleEntry.m();
                fArr[i5 + 1] = candleEntry.z() * f3;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        i().mapPoints(fArr);
        return fArr;
    }

    public float[] c(ILineDataSet iLineDataSet, float f2, float f3, int i2, int i3) {
        int i4 = (((int) (((float) (i3 - i2)) * f2)) + 1) * 2;
        if (this.f19157f.length != i4) {
            this.f19157f = new float[i4];
        }
        float[] fArr = this.f19157f;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            Entry X = iLineDataSet.X((i5 / 2) + i2);
            if (X != null) {
                fArr[i5] = X.m();
                fArr[i5 + 1] = X.c() * f3;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        i().mapPoints(fArr);
        return fArr;
    }

    public float[] d(IScatterDataSet iScatterDataSet, float f2, float f3, int i2, int i3) {
        int i4 = ((int) ((((float) (i3 - i2)) * f2) + 1.0f)) * 2;
        if (this.f19155d.length != i4) {
            this.f19155d = new float[i4];
        }
        float[] fArr = this.f19155d;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            Entry X = iScatterDataSet.X((i5 / 2) + i2);
            if (X != null) {
                fArr[i5] = X.m();
                fArr[i5 + 1] = X.c() * f3;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        i().mapPoints(fArr);
        return fArr;
    }

    public Matrix e() {
        return this.f19153b;
    }

    public MPPointD f(float f2, float f3) {
        float[] fArr = this.f19160i;
        fArr[0] = f2;
        fArr[1] = f3;
        o(fArr);
        float[] fArr2 = this.f19160i;
        return MPPointD.b((double) fArr2[0], (double) fArr2[1]);
    }

    public Matrix g() {
        i().invert(this.f19162k);
        return this.f19162k;
    }

    public Matrix h() {
        return this.f19152a;
    }

    public Matrix i() {
        this.f19161j.set(this.f19152a);
        this.f19161j.postConcat(this.f19154c.f19177a);
        this.f19161j.postConcat(this.f19153b);
        return this.f19161j;
    }

    public MPPointD j(float f2, float f3) {
        MPPointD b2 = MPPointD.b(0.0d, 0.0d);
        k(f2, f3, b2);
        return b2;
    }

    public void k(float f2, float f3, MPPointD mPPointD) {
        float[] fArr = this.f19160i;
        fArr[0] = f2;
        fArr[1] = f3;
        n(fArr);
        float[] fArr2 = this.f19160i;
        mPPointD.Y = (double) fArr2[0];
        mPPointD.Z = (double) fArr2[1];
    }

    public void l(Path path) {
        path.transform(this.f19152a);
        path.transform(this.f19154c.r());
        path.transform(this.f19153b);
    }

    public void m(List<Path> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            l(list.get(i2));
        }
    }

    public void n(float[] fArr) {
        Matrix matrix = this.f19159h;
        matrix.reset();
        this.f19153b.invert(matrix);
        matrix.mapPoints(fArr);
        this.f19154c.r().invert(matrix);
        matrix.mapPoints(fArr);
        this.f19152a.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void o(float[] fArr) {
        this.f19152a.mapPoints(fArr);
        this.f19154c.r().mapPoints(fArr);
        this.f19153b.mapPoints(fArr);
    }

    public void p(boolean z) {
        this.f19153b.reset();
        if (!z) {
            this.f19153b.postTranslate(this.f19154c.P(), this.f19154c.n() - this.f19154c.O());
            return;
        }
        this.f19153b.setTranslate(this.f19154c.P(), -this.f19154c.R());
        this.f19153b.postScale(1.0f, -1.0f);
    }

    public void q(float f2, float f3, float f4, float f5) {
        float k2 = this.f19154c.k() / f3;
        float g2 = this.f19154c.g() / f4;
        if (Float.isInfinite(k2)) {
            k2 = 0.0f;
        }
        if (Float.isInfinite(g2)) {
            g2 = 0.0f;
        }
        this.f19152a.reset();
        this.f19152a.postTranslate(-f2, -f5);
        this.f19152a.postScale(k2, -g2);
    }

    public void r(RectF rectF, float f2) {
        rectF.top *= f2;
        rectF.bottom *= f2;
        this.f19152a.mapRect(rectF);
        this.f19154c.r().mapRect(rectF);
        this.f19153b.mapRect(rectF);
    }

    public void s(RectF rectF, float f2) {
        rectF.left *= f2;
        rectF.right *= f2;
        this.f19152a.mapRect(rectF);
        this.f19154c.r().mapRect(rectF);
        this.f19153b.mapRect(rectF);
    }

    public void t(RectF rectF) {
        this.f19152a.mapRect(rectF);
        this.f19154c.r().mapRect(rectF);
        this.f19153b.mapRect(rectF);
    }

    public void u(RectF rectF) {
        this.f19152a.mapRect(rectF);
        this.f19154c.r().mapRect(rectF);
        this.f19153b.mapRect(rectF);
    }

    public void v(RectF rectF, float f2) {
        rectF.left *= f2;
        rectF.right *= f2;
        this.f19152a.mapRect(rectF);
        this.f19154c.r().mapRect(rectF);
        this.f19153b.mapRect(rectF);
    }

    public void w(List<RectF> list) {
        Matrix i2 = i();
        for (int i3 = 0; i3 < list.size(); i3++) {
            i2.mapRect(list.get(i3));
        }
    }
}
