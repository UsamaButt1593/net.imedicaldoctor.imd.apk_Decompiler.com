package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public class LineChartRenderer extends LineRadarRenderer {

    /* renamed from: i  reason: collision with root package name */
    protected LineDataProvider f19094i;

    /* renamed from: j  reason: collision with root package name */
    protected Paint f19095j;

    /* renamed from: k  reason: collision with root package name */
    protected WeakReference<Bitmap> f19096k;

    /* renamed from: l  reason: collision with root package name */
    protected Canvas f19097l;

    /* renamed from: m  reason: collision with root package name */
    protected Bitmap.Config f19098m = Bitmap.Config.ARGB_8888;

    /* renamed from: n  reason: collision with root package name */
    protected Path f19099n = new Path();
    protected Path o = new Path();
    private float[] p = new float[4];
    protected Path q = new Path();
    private HashMap<IDataSet, DataSetImageCache> r = new HashMap<>();
    private float[] s = new float[2];

    /* renamed from: com.github.mikephil.charting.renderer.LineChartRenderer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19100a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.github.mikephil.charting.data.LineDataSet$Mode[] r0 = com.github.mikephil.charting.data.LineDataSet.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19100a = r0
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.LINEAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19100a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.STEPPED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19100a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.CUBIC_BEZIER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f19100a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.HORIZONTAL_BEZIER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LineChartRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    private class DataSetImageCache {

        /* renamed from: a  reason: collision with root package name */
        private Path f19101a;

        /* renamed from: b  reason: collision with root package name */
        private Bitmap[] f19102b;

        private DataSetImageCache() {
            this.f19101a = new Path();
        }

        /* access modifiers changed from: protected */
        public void a(ILineDataSet iLineDataSet, boolean z, boolean z2) {
            int f2 = iLineDataSet.f();
            float Y = iLineDataSet.Y();
            float k1 = iLineDataSet.k1();
            for (int i2 = 0; i2 < f2; i2++) {
                int i3 = (int) (((double) Y) * 2.1d);
                Bitmap createBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                this.f19102b[i2] = createBitmap;
                LineChartRenderer.this.f19079c.setColor(iLineDataSet.Z0(i2));
                if (z2) {
                    this.f19101a.reset();
                    this.f19101a.addCircle(Y, Y, Y, Path.Direction.CW);
                    this.f19101a.addCircle(Y, Y, k1, Path.Direction.CCW);
                    canvas.drawPath(this.f19101a, LineChartRenderer.this.f19079c);
                } else {
                    canvas.drawCircle(Y, Y, Y, LineChartRenderer.this.f19079c);
                    if (z) {
                        canvas.drawCircle(Y, Y, k1, LineChartRenderer.this.f19095j);
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public Bitmap b(int i2) {
            Bitmap[] bitmapArr = this.f19102b;
            return bitmapArr[i2 % bitmapArr.length];
        }

        /* access modifiers changed from: protected */
        public boolean c(ILineDataSet iLineDataSet) {
            int f2 = iLineDataSet.f();
            Bitmap[] bitmapArr = this.f19102b;
            if (bitmapArr == null) {
                this.f19102b = new Bitmap[f2];
                return true;
            } else if (bitmapArr.length == f2) {
                return false;
            } else {
                this.f19102b = new Bitmap[f2];
                return true;
            }
        }

        /* synthetic */ DataSetImageCache(LineChartRenderer lineChartRenderer, AnonymousClass1 r2) {
            this();
        }
    }

    public LineChartRenderer(LineDataProvider lineDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f19094i = lineDataProvider;
        Paint paint = new Paint(1);
        this.f19095j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f19095j.setColor(-1);
    }

    private void y(ILineDataSet iLineDataSet, int i2, int i3, Path path) {
        float a2 = iLineDataSet.o().a(iLineDataSet, this.f19094i);
        float i4 = this.f19078b.i();
        boolean z = iLineDataSet.c0() == LineDataSet.Mode.STEPPED;
        path.reset();
        Entry X = iLineDataSet.X(i2);
        path.moveTo(X.m(), a2);
        path.lineTo(X.m(), X.c() * i4);
        int i5 = i2 + 1;
        Entry entry = null;
        while (i5 <= i3) {
            entry = iLineDataSet.X(i5);
            if (z) {
                path.lineTo(entry.m(), X.c() * i4);
            }
            path.lineTo(entry.m(), entry.c() * i4);
            i5++;
            X = entry;
        }
        if (entry != null) {
            path.lineTo(entry.m(), a2);
        }
        path.close();
    }

    public void A() {
        Canvas canvas = this.f19097l;
        if (canvas != null) {
            canvas.setBitmap((Bitmap) null);
            this.f19097l = null;
        }
        WeakReference<Bitmap> weakReference = this.f19096k;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f19096k.clear();
            this.f19096k = null;
        }
    }

    public void B(Bitmap.Config config) {
        this.f19098m = config;
        A();
    }

    public void b(Canvas canvas) {
        int o2 = (int) this.f19118a.o();
        int n2 = (int) this.f19118a.n();
        WeakReference<Bitmap> weakReference = this.f19096k;
        Bitmap bitmap = weakReference == null ? null : weakReference.get();
        if (!(bitmap != null && bitmap.getWidth() == o2 && bitmap.getHeight() == n2)) {
            if (o2 > 0 && n2 > 0) {
                bitmap = Bitmap.createBitmap(o2, n2, this.f19098m);
                this.f19096k = new WeakReference<>(bitmap);
                this.f19097l = new Canvas(bitmap);
            } else {
                return;
            }
        }
        bitmap.eraseColor(0);
        for (ILineDataSet iLineDataSet : this.f19094i.getLineData().q()) {
            if (iLineDataSet.isVisible()) {
                u(canvas, iLineDataSet);
            }
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f19079c);
    }

    public void c(Canvas canvas) {
        r(canvas);
    }

    public void d(Canvas canvas, Highlight[] highlightArr) {
        LineData lineData = this.f19094i.getLineData();
        for (Highlight highlight : highlightArr) {
            ILineDataSet iLineDataSet = (ILineDataSet) lineData.k(highlight.d());
            if (iLineDataSet != null && iLineDataSet.i1()) {
                Entry x = iLineDataSet.x(highlight.h(), highlight.j());
                if (l(x, iLineDataSet)) {
                    MPPointD f2 = this.f19094i.a(iLineDataSet.a1()).f(x.m(), x.c() * this.f19078b.i());
                    highlight.n((float) f2.Y, (float) f2.Z);
                    n(canvas, (float) f2.Y, (float) f2.Z, iLineDataSet);
                }
            }
        }
    }

    public void e(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f19082f.setColor(i2);
        canvas.drawText(str, f2, f3, this.f19082f);
    }

    public void f(Canvas canvas) {
        int i2;
        ILineDataSet iLineDataSet;
        Entry entry;
        if (k(this.f19094i)) {
            List q2 = this.f19094i.getLineData().q();
            for (int i3 = 0; i3 < q2.size(); i3++) {
                ILineDataSet iLineDataSet2 = (ILineDataSet) q2.get(i3);
                if (m(iLineDataSet2) && iLineDataSet2.e1() >= 1) {
                    a(iLineDataSet2);
                    Transformer a2 = this.f19094i.a(iLineDataSet2.a1());
                    int Y = (int) (iLineDataSet2.Y() * 1.75f);
                    if (!iLineDataSet2.h1()) {
                        Y /= 2;
                    }
                    int i4 = Y;
                    this.f19059g.a(this.f19094i, iLineDataSet2);
                    float h2 = this.f19078b.h();
                    float i5 = this.f19078b.i();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f19059g;
                    float[] c2 = a2.c(iLineDataSet2, h2, i5, xBounds.f19060a, xBounds.f19061b);
                    ValueFormatter T = iLineDataSet2.T();
                    MPPointF d2 = MPPointF.d(iLineDataSet2.f1());
                    d2.Y = Utils.e(d2.Y);
                    d2.Z = Utils.e(d2.Z);
                    int i6 = 0;
                    while (i6 < c2.length) {
                        float f2 = c2[i6];
                        float f3 = c2[i6 + 1];
                        if (!this.f19118a.J(f2)) {
                            break;
                        }
                        if (!this.f19118a.I(f2) || !this.f19118a.M(f3)) {
                            i2 = i4;
                            iLineDataSet = iLineDataSet2;
                        } else {
                            int i7 = i6 / 2;
                            Entry X = iLineDataSet2.X(this.f19059g.f19060a + i7);
                            if (iLineDataSet2.V0()) {
                                entry = X;
                                i2 = i4;
                                float f4 = f3 - ((float) i4);
                                iLineDataSet = iLineDataSet2;
                                e(canvas, T.j(X), f2, f4, iLineDataSet2.u0(i7));
                            } else {
                                entry = X;
                                i2 = i4;
                                iLineDataSet = iLineDataSet2;
                            }
                            if (entry.b() != null && iLineDataSet.B()) {
                                Drawable b2 = entry.b();
                                Utils.k(canvas, b2, (int) (f2 + d2.Y), (int) (f3 + d2.Z), b2.getIntrinsicWidth(), b2.getIntrinsicHeight());
                            }
                        }
                        i6 += 2;
                        iLineDataSet2 = iLineDataSet;
                        i4 = i2;
                    }
                    MPPointF.h(d2);
                }
            }
        }
    }

    public void j() {
    }

    /* access modifiers changed from: protected */
    public void r(Canvas canvas) {
        DataSetImageCache dataSetImageCache;
        Bitmap b2;
        this.f19079c.setStyle(Paint.Style.FILL);
        float i2 = this.f19078b.i();
        float[] fArr = this.s;
        char c2 = 0;
        float f2 = 0.0f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        List q2 = this.f19094i.getLineData().q();
        int i3 = 0;
        while (i3 < q2.size()) {
            ILineDataSet iLineDataSet = (ILineDataSet) q2.get(i3);
            if (iLineDataSet.isVisible() && iLineDataSet.h1() && iLineDataSet.e1() != 0) {
                this.f19095j.setColor(iLineDataSet.E());
                Transformer a2 = this.f19094i.a(iLineDataSet.a1());
                this.f19059g.a(this.f19094i, iLineDataSet);
                float Y = iLineDataSet.Y();
                float k1 = iLineDataSet.k1();
                boolean z = iLineDataSet.r1() && k1 < Y && k1 > f2;
                boolean z2 = z && iLineDataSet.E() == 1122867;
                if (this.r.containsKey(iLineDataSet)) {
                    dataSetImageCache = this.r.get(iLineDataSet);
                } else {
                    dataSetImageCache = new DataSetImageCache(this, (AnonymousClass1) null);
                    this.r.put(iLineDataSet, dataSetImageCache);
                }
                if (dataSetImageCache.c(iLineDataSet)) {
                    dataSetImageCache.a(iLineDataSet, z, z2);
                }
                BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f19059g;
                int i4 = xBounds.f19062c;
                int i5 = xBounds.f19060a;
                int i6 = i4 + i5;
                while (i5 <= i6) {
                    Entry X = iLineDataSet.X(i5);
                    if (X == null) {
                        break;
                    }
                    this.s[c2] = X.m();
                    this.s[1] = X.c() * i2;
                    a2.o(this.s);
                    if (!this.f19118a.J(this.s[c2])) {
                        break;
                    }
                    if (!this.f19118a.I(this.s[c2]) || !this.f19118a.M(this.s[1]) || (b2 = dataSetImageCache.b(i5)) == null) {
                        Canvas canvas2 = canvas;
                    } else {
                        float[] fArr2 = this.s;
                        canvas.drawBitmap(b2, fArr2[c2] - Y, fArr2[1] - Y, (Paint) null);
                    }
                    i5++;
                    c2 = 0;
                }
            }
            Canvas canvas3 = canvas;
            i3++;
            c2 = 0;
            f2 = 0.0f;
        }
    }

    /* access modifiers changed from: protected */
    public void s(ILineDataSet iLineDataSet) {
        ILineDataSet iLineDataSet2 = iLineDataSet;
        float i2 = this.f19078b.i();
        Transformer a2 = this.f19094i.a(iLineDataSet.a1());
        this.f19059g.a(this.f19094i, iLineDataSet2);
        float L = iLineDataSet.L();
        this.f19099n.reset();
        BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f19059g;
        if (xBounds.f19062c >= 1) {
            int i3 = xBounds.f19060a;
            Entry X = iLineDataSet2.X(Math.max(i3 - 1, 0));
            Entry X2 = iLineDataSet2.X(Math.max(i3, 0));
            if (X2 != null) {
                this.f19099n.moveTo(X2.m(), X2.c() * i2);
                Entry entry = X2;
                int i4 = this.f19059g.f19060a + 1;
                int i5 = -1;
                while (true) {
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = this.f19059g;
                    if (i4 > xBounds2.f19062c + xBounds2.f19060a) {
                        break;
                    }
                    if (i5 != i4) {
                        X2 = iLineDataSet2.X(i4);
                    }
                    int i6 = i4 + 1;
                    if (i6 < iLineDataSet.e1()) {
                        i4 = i6;
                    }
                    Entry X3 = iLineDataSet2.X(i4);
                    this.f19099n.cubicTo(entry.m() + ((X2.m() - X.m()) * L), (entry.c() + ((X2.c() - X.c()) * L)) * i2, X2.m() - ((X3.m() - entry.m()) * L), (X2.c() - ((X3.c() - entry.c()) * L)) * i2, X2.m(), X2.c() * i2);
                    X = entry;
                    entry = X2;
                    X2 = X3;
                    int i7 = i4;
                    i4 = i6;
                    i5 = i7;
                }
            } else {
                return;
            }
        }
        if (iLineDataSet.Z()) {
            this.o.reset();
            this.o.addPath(this.f19099n);
            t(this.f19097l, iLineDataSet, this.o, a2, this.f19059g);
        }
        this.f19079c.setColor(iLineDataSet.g1());
        this.f19079c.setStyle(Paint.Style.STROKE);
        a2.l(this.f19099n);
        this.f19097l.drawPath(this.f19099n, this.f19079c);
        this.f19079c.setPathEffect((PathEffect) null);
    }

    /* access modifiers changed from: protected */
    public void t(Canvas canvas, ILineDataSet iLineDataSet, Path path, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        float a2 = iLineDataSet.o().a(iLineDataSet, this.f19094i);
        path.lineTo(iLineDataSet.X(xBounds.f19060a + xBounds.f19062c).m(), a2);
        path.lineTo(iLineDataSet.X(xBounds.f19060a).m(), a2);
        path.close();
        transformer.l(path);
        Drawable Q = iLineDataSet.Q();
        if (Q != null) {
            q(canvas, path, Q);
        } else {
            p(canvas, path, iLineDataSet.g(), iLineDataSet.l());
        }
    }

    /* access modifiers changed from: protected */
    public void u(Canvas canvas, ILineDataSet iLineDataSet) {
        if (iLineDataSet.e1() >= 1) {
            this.f19079c.setStrokeWidth(iLineDataSet.u());
            this.f19079c.setPathEffect(iLineDataSet.O());
            int i2 = AnonymousClass1.f19100a[iLineDataSet.c0().ordinal()];
            if (i2 == 3) {
                s(iLineDataSet);
            } else if (i2 != 4) {
                w(canvas, iLineDataSet);
            } else {
                v(iLineDataSet);
            }
            this.f19079c.setPathEffect((PathEffect) null);
        }
    }

    /* access modifiers changed from: protected */
    public void v(ILineDataSet iLineDataSet) {
        float i2 = this.f19078b.i();
        Transformer a2 = this.f19094i.a(iLineDataSet.a1());
        this.f19059g.a(this.f19094i, iLineDataSet);
        this.f19099n.reset();
        BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f19059g;
        if (xBounds.f19062c >= 1) {
            Entry X = iLineDataSet.X(xBounds.f19060a);
            this.f19099n.moveTo(X.m(), X.c() * i2);
            int i3 = this.f19059g.f19060a + 1;
            while (true) {
                BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = this.f19059g;
                if (i3 > xBounds2.f19062c + xBounds2.f19060a) {
                    break;
                }
                Entry X2 = iLineDataSet.X(i3);
                float m2 = X.m() + ((X2.m() - X.m()) / 2.0f);
                this.f19099n.cubicTo(m2, X.c() * i2, m2, X2.c() * i2, X2.m(), X2.c() * i2);
                i3++;
                X = X2;
            }
        }
        if (iLineDataSet.Z()) {
            this.o.reset();
            this.o.addPath(this.f19099n);
            t(this.f19097l, iLineDataSet, this.o, a2, this.f19059g);
        }
        this.f19079c.setColor(iLineDataSet.g1());
        this.f19079c.setStyle(Paint.Style.STROKE);
        a2.l(this.f19099n);
        this.f19097l.drawPath(this.f19099n, this.f19079c);
        this.f19079c.setPathEffect((PathEffect) null);
    }

    /* access modifiers changed from: protected */
    public void w(Canvas canvas, ILineDataSet iLineDataSet) {
        ILineDataSet iLineDataSet2 = iLineDataSet;
        int e1 = iLineDataSet.e1();
        boolean z = iLineDataSet.c0() == LineDataSet.Mode.STEPPED;
        int i2 = z ? 4 : 2;
        Transformer a2 = this.f19094i.a(iLineDataSet.a1());
        float i3 = this.f19078b.i();
        this.f19079c.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = iLineDataSet.A() ? this.f19097l : canvas;
        this.f19059g.a(this.f19094i, iLineDataSet2);
        if (iLineDataSet.Z() && e1 > 0) {
            x(canvas, iLineDataSet2, a2, this.f19059g);
        }
        if (iLineDataSet.B0().size() > 1) {
            int i4 = i2 * 2;
            if (this.p.length <= i4) {
                this.p = new float[(i2 * 4)];
            }
            int i5 = this.f19059g.f19060a;
            while (true) {
                BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f19059g;
                if (i5 > xBounds.f19062c + xBounds.f19060a) {
                    break;
                }
                Entry X = iLineDataSet2.X(i5);
                if (X != null) {
                    this.p[0] = X.m();
                    this.p[1] = X.c() * i3;
                    if (i5 < this.f19059g.f19061b) {
                        Entry X2 = iLineDataSet2.X(i5 + 1);
                        if (X2 == null) {
                            break;
                        }
                        float[] fArr = this.p;
                        float m2 = X2.m();
                        if (z) {
                            fArr[2] = m2;
                            float[] fArr2 = this.p;
                            float f2 = fArr2[1];
                            fArr2[3] = f2;
                            fArr2[4] = fArr2[2];
                            fArr2[5] = f2;
                            fArr2[6] = X2.m();
                            this.p[7] = X2.c() * i3;
                        } else {
                            fArr[2] = m2;
                            this.p[3] = X2.c() * i3;
                        }
                    } else {
                        float[] fArr3 = this.p;
                        fArr3[2] = fArr3[0];
                        fArr3[3] = fArr3[1];
                    }
                    a2.o(this.p);
                    if (!this.f19118a.J(this.p[0])) {
                        break;
                    } else if (this.f19118a.I(this.p[2]) && (this.f19118a.K(this.p[1]) || this.f19118a.H(this.p[3]))) {
                        this.f19079c.setColor(iLineDataSet2.d0(i5));
                        canvas2.drawLines(this.p, 0, i4, this.f19079c);
                    }
                }
                i5++;
            }
        } else {
            int i6 = e1 * i2;
            if (this.p.length < Math.max(i6, i2) * 2) {
                this.p = new float[(Math.max(i6, i2) * 4)];
            }
            if (iLineDataSet2.X(this.f19059g.f19060a) != null) {
                int i7 = this.f19059g.f19060a;
                int i8 = 0;
                while (true) {
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = this.f19059g;
                    if (i7 > xBounds2.f19062c + xBounds2.f19060a) {
                        break;
                    }
                    Entry X3 = iLineDataSet2.X(i7 == 0 ? 0 : i7 - 1);
                    Entry X4 = iLineDataSet2.X(i7);
                    if (!(X3 == null || X4 == null)) {
                        this.p[i8] = X3.m();
                        int i9 = i8 + 2;
                        this.p[i8 + 1] = X3.c() * i3;
                        if (z) {
                            this.p[i9] = X4.m();
                            this.p[i8 + 3] = X3.c() * i3;
                            this.p[i8 + 4] = X4.m();
                            i9 = i8 + 6;
                            this.p[i8 + 5] = X3.c() * i3;
                        }
                        this.p[i9] = X4.m();
                        this.p[i9 + 1] = X4.c() * i3;
                        i8 = i9 + 2;
                    }
                    i7++;
                }
                if (i8 > 0) {
                    a2.o(this.p);
                    this.f19079c.setColor(iLineDataSet.g1());
                    canvas2.drawLines(this.p, 0, Math.max((this.f19059g.f19062c + 1) * i2, i2) * 2, this.f19079c);
                }
            }
        }
        this.f19079c.setPathEffect((PathEffect) null);
    }

    /* access modifiers changed from: protected */
    public void x(Canvas canvas, ILineDataSet iLineDataSet, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        int i2;
        int i3;
        Path path = this.q;
        int i4 = xBounds.f19060a;
        int i5 = xBounds.f19062c + i4;
        int i6 = 0;
        do {
            i2 = (i6 * 128) + i4;
            i3 = i2 + 128;
            if (i3 > i5) {
                i3 = i5;
            }
            if (i2 <= i3) {
                y(iLineDataSet, i2, i3, path);
                transformer.l(path);
                Drawable Q = iLineDataSet.Q();
                if (Q != null) {
                    q(canvas, path, Q);
                } else {
                    p(canvas, path, iLineDataSet.g(), iLineDataSet.l());
                }
            }
            i6++;
        } while (i2 <= i3);
    }

    public Bitmap.Config z() {
        return this.f19098m;
    }
}
