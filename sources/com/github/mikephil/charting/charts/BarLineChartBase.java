package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.ts.PsExtractor;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.jobs.AnimatedMoveViewJob;
import com.github.mikephil.charting.jobs.AnimatedZoomJob;
import com.github.mikephil.charting.jobs.MoveViewJob;
import com.github.mikephil.charting.jobs.ZoomJob;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnDrawListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"RtlHardcoded"})
public abstract class BarLineChartBase<T extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> extends Chart<T> implements BarLineScatterCandleBubbleDataProvider {
    protected int J3 = 100;
    protected boolean K3 = false;
    protected boolean L3 = false;
    protected boolean M3 = true;
    protected boolean N3 = true;
    private boolean O3 = true;
    private boolean P3 = true;
    private boolean Q3 = true;
    private boolean R3 = true;
    protected Paint S3;
    protected Paint T3;
    protected boolean U3 = false;
    protected boolean V3 = false;
    protected boolean W3 = false;
    protected float X3 = 15.0f;
    protected boolean Y3 = false;
    protected OnDrawListener Z3;
    protected YAxis a4;
    protected YAxis b4;
    protected YAxisRenderer c4;
    protected YAxisRenderer d4;
    protected Transformer e4;
    protected Transformer f4;
    protected XAxisRenderer g4;
    private long h4 = 0;
    private long i4 = 0;
    private RectF j4 = new RectF();
    protected Matrix k4 = new Matrix();
    protected Matrix l4 = new Matrix();
    private boolean m4 = false;
    protected float[] n4 = new float[2];
    protected MPPointD o4 = MPPointD.b(0.0d, 0.0d);
    protected MPPointD p4 = MPPointD.b(0.0d, 0.0d);
    protected float[] q4 = new float[2];

    /* renamed from: com.github.mikephil.charting.charts.BarLineChartBase$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18919a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f18920b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f18921c;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(2:13|14)|15|17|18|19|20|22) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r0 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18921c = r0
                r1 = 1
                com.github.mikephil.charting.components.Legend$LegendOrientation r2 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f18921c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendOrientation r3 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment[] r2 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f18920b = r2
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.LEFT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f18920b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r2 = f18920b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment[] r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f18919a = r2
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r1 = f18919a     // Catch:{ NoSuchFieldError -> 0x005e }
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM     // Catch:{ NoSuchFieldError -> 0x005e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.BarLineChartBase.AnonymousClass2.<clinit>():void");
        }
    }

    public BarLineChartBase(Context context) {
        super(context);
    }

    public boolean A0() {
        return this.Q3;
    }

    public boolean B0() {
        return this.R3;
    }

    public void C0(float f2, float f3, YAxis.AxisDependency axisDependency) {
        g(MoveViewJob.d(this.p3, f2, f3 + ((g0(axisDependency) / this.p3.x()) / 2.0f), a(axisDependency), this));
    }

    @TargetApi(11)
    public void D0(float f2, float f3, YAxis.AxisDependency axisDependency, long j2) {
        YAxis.AxisDependency axisDependency2 = axisDependency;
        MPPointD l0 = l0(this.p3.h(), this.p3.j(), axisDependency);
        float g0 = g0(axisDependency) / this.p3.x();
        g(AnimatedMoveViewJob.j(this.p3, f2, f3 + (g0 / 2.0f), a(axisDependency), this, (float) l0.Y, (float) l0.Z, j2));
        MPPointD.c(l0);
    }

    public void E0(float f2) {
        g(MoveViewJob.d(this.p3, f2, 0.0f, a(YAxis.AxisDependency.LEFT), this));
    }

    /* access modifiers changed from: protected */
    public void F0() {
        this.f4.p(this.b4.I0());
        this.e4.p(this.a4.I0());
    }

    /* access modifiers changed from: protected */
    public void G0() {
        if (this.s) {
            Log.i(Chart.C3, "Preparing Value-Px Matrix, xmin: " + this.e3.H + ", xmax: " + this.e3.G + ", xdelta: " + this.e3.I);
        }
        Transformer transformer = this.f4;
        XAxis xAxis = this.e3;
        float f2 = xAxis.H;
        float f3 = xAxis.I;
        YAxis yAxis = this.b4;
        transformer.q(f2, f3, yAxis.I, yAxis.H);
        Transformer transformer2 = this.e4;
        XAxis xAxis2 = this.e3;
        float f5 = xAxis2.H;
        float f6 = xAxis2.I;
        YAxis yAxis2 = this.a4;
        transformer2.q(f5, f6, yAxis2.I, yAxis2.H);
    }

    /* access modifiers changed from: protected */
    public void H() {
        super.H();
        this.a4 = new YAxis(YAxis.AxisDependency.LEFT);
        this.b4 = new YAxis(YAxis.AxisDependency.RIGHT);
        this.e4 = new Transformer(this.p3);
        this.f4 = new Transformer(this.p3);
        this.c4 = new YAxisRenderer(this.p3, this.a4, this.e4);
        this.d4 = new YAxisRenderer(this.p3, this.b4, this.f4);
        this.g4 = new XAxisRenderer(this.p3, this.e3, this.e4);
        setHighlighter(new ChartHighlighter(this));
        this.j3 = new BarLineChartTouchListener(this, this.p3.r(), 3.0f);
        Paint paint = new Paint();
        this.S3 = paint;
        paint.setStyle(Paint.Style.FILL);
        this.S3.setColor(Color.rgb(PsExtractor.A, PsExtractor.A, PsExtractor.A));
        Paint paint2 = new Paint();
        this.T3 = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.T3.setColor(ViewCompat.y);
        this.T3.setStrokeWidth(Utils.e(1.0f));
    }

    public void H0() {
        this.h4 = 0;
        this.i4 = 0;
    }

    public void I0() {
        this.m4 = false;
        p();
    }

    public void J0() {
        this.p3.T(this.k4);
        this.p3.S(this.k4, this, false);
        p();
        postInvalidate();
    }

    public void K0(float f2, float f3) {
        this.p3.c0(f2);
        this.p3.d0(f3);
    }

    public void L0(float f2, float f3, float f5, float f6) {
        this.m4 = true;
        final float f7 = f2;
        final float f8 = f3;
        final float f9 = f5;
        final float f10 = f6;
        post(new Runnable() {
            public void run() {
                BarLineChartBase.this.p3.U(f7, f8, f9, f10);
                BarLineChartBase.this.F0();
                BarLineChartBase.this.G0();
            }
        });
    }

    public void M0(float f2, float f3) {
        float f5 = this.e3.I;
        this.p3.a0(f5 / f2, f5 / f3);
    }

    public void N0(float f2, float f3, YAxis.AxisDependency axisDependency) {
        this.p3.b0(g0(axisDependency) / f2, g0(axisDependency) / f3);
    }

    public void O() {
        if (this.X2 != null) {
            if (this.s) {
                Log.i(Chart.C3, "Preparing...");
            }
            DataRenderer dataRenderer = this.n3;
            if (dataRenderer != null) {
                dataRenderer.j();
            }
            o();
            YAxisRenderer yAxisRenderer = this.c4;
            YAxis yAxis = this.a4;
            yAxisRenderer.a(yAxis.H, yAxis.G, yAxis.I0());
            YAxisRenderer yAxisRenderer2 = this.d4;
            YAxis yAxis2 = this.b4;
            yAxisRenderer2.a(yAxis2.H, yAxis2.G, yAxis2.I0());
            XAxisRenderer xAxisRenderer = this.g4;
            XAxis xAxis = this.e3;
            xAxisRenderer.a(xAxis.H, xAxis.G, false);
            if (this.h3 != null) {
                this.m3.a(this.X2);
            }
            p();
        } else if (this.s) {
            Log.i(Chart.C3, "Preparing... DATA NOT SET.");
        }
    }

    public void O0(float f2, YAxis.AxisDependency axisDependency) {
        this.p3.d0(g0(axisDependency) / f2);
    }

    public void P0(float f2, YAxis.AxisDependency axisDependency) {
        this.p3.Z(g0(axisDependency) / f2);
    }

    public void Q0(float f2, float f3, float f5, float f6) {
        this.p3.l0(f2, f3, f5, -f6, this.k4);
        this.p3.S(this.k4, this, false);
        p();
        postInvalidate();
    }

    public void R0(float f2, float f3, float f5, float f6, YAxis.AxisDependency axisDependency) {
        g(ZoomJob.d(this.p3, f2, f3, f5, f6, a(axisDependency), axisDependency, this));
    }

    @TargetApi(11)
    public void S0(float f2, float f3, float f5, float f6, YAxis.AxisDependency axisDependency, long j2) {
        YAxis.AxisDependency axisDependency2 = axisDependency;
        MPPointD l0 = l0(this.p3.h(), this.p3.j(), axisDependency2);
        g(AnimatedZoomJob.j(this.p3, this, a(axisDependency2), e(axisDependency2), this.e3.I, f2, f3, this.p3.w(), this.p3.x(), f5, f6, (float) l0.Y, (float) l0.Z, j2));
        MPPointD.c(l0);
    }

    public void T0() {
        MPPointF p = this.p3.p();
        this.p3.o0(p.Y, -p.Z, this.k4);
        this.p3.S(this.k4, this, false);
        MPPointF.h(p);
        p();
        postInvalidate();
    }

    public void U0() {
        MPPointF p = this.p3.p();
        this.p3.q0(p.Y, -p.Z, this.k4);
        this.p3.S(this.k4, this, false);
        MPPointF.h(p);
        p();
        postInvalidate();
    }

    public void V(Paint paint, int i2) {
        super.V(paint, i2);
        if (i2 == 4) {
            this.S3 = paint;
        }
    }

    public void V0(float f2, float f3) {
        MPPointF centerOffsets = getCenterOffsets();
        Matrix matrix = this.k4;
        this.p3.l0(f2, f3, centerOffsets.Y, -centerOffsets.Z, matrix);
        this.p3.S(matrix, this, false);
    }

    /* access modifiers changed from: protected */
    public void Z() {
        ((BarLineScatterCandleBubbleData) this.X2).g(getLowestVisibleX(), getHighestVisibleX());
        this.e3.n(((BarLineScatterCandleBubbleData) this.X2).y(), ((BarLineScatterCandleBubbleData) this.X2).x());
        if (this.a4.f()) {
            YAxis yAxis = this.a4;
            YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
            yAxis.n(((BarLineScatterCandleBubbleData) this.X2).C(axisDependency), ((BarLineScatterCandleBubbleData) this.X2).A(axisDependency));
        }
        if (this.b4.f()) {
            YAxis yAxis2 = this.b4;
            YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
            yAxis2.n(((BarLineScatterCandleBubbleData) this.X2).C(axisDependency2), ((BarLineScatterCandleBubbleData) this.X2).A(axisDependency2));
        }
        p();
    }

    public Transformer a(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.e4 : this.f4;
    }

    /* access modifiers changed from: protected */
    public void a0(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        Legend legend = this.h3;
        if (legend != null && legend.f() && !this.h3.H()) {
            int i2 = AnonymousClass2.f18921c[this.h3.C().ordinal()];
            if (i2 == 1) {
                int i3 = AnonymousClass2.f18920b[this.h3.y().ordinal()];
                if (i3 == 1) {
                    rectF.left += Math.min(this.h3.x, this.p3.o() * this.h3.z()) + this.h3.d();
                    return;
                } else if (i3 == 2) {
                    rectF.right += Math.min(this.h3.x, this.p3.o() * this.h3.z()) + this.h3.d();
                    return;
                } else if (i3 == 3) {
                    int i5 = AnonymousClass2.f18919a[this.h3.E().ordinal()];
                    if (i5 != 1) {
                        if (i5 != 2) {
                            return;
                        }
                    }
                    rectF.top += Math.min(this.h3.y, this.p3.n() * this.h3.z()) + this.h3.e();
                    return;
                } else {
                    return;
                }
            } else if (i2 == 2) {
                int i6 = AnonymousClass2.f18919a[this.h3.E().ordinal()];
                if (i6 != 1) {
                    if (i6 != 2) {
                        return;
                    }
                }
                rectF.top += Math.min(this.h3.y, this.p3.n() * this.h3.z()) + this.h3.e();
                return;
            } else {
                return;
            }
            rectF.bottom += Math.min(this.h3.y, this.p3.n() * this.h3.z()) + this.h3.e();
        }
    }

    public void b0(float f2, float f3, YAxis.AxisDependency axisDependency) {
        float g0 = g0(axisDependency) / this.p3.x();
        g(MoveViewJob.d(this.p3, f2 - ((getXAxis().I / this.p3.w()) / 2.0f), f3 + (g0 / 2.0f), a(axisDependency), this));
    }

    @TargetApi(11)
    public void c0(float f2, float f3, YAxis.AxisDependency axisDependency, long j2) {
        YAxis.AxisDependency axisDependency2 = axisDependency;
        MPPointD l0 = l0(this.p3.h(), this.p3.j(), axisDependency);
        float g0 = g0(axisDependency) / this.p3.x();
        float w = getXAxis().I / this.p3.w();
        g(AnimatedMoveViewJob.j(this.p3, f2 - (w / 2.0f), f3 + (g0 / 2.0f), a(axisDependency), this, (float) l0.Y, (float) l0.Z, j2));
        MPPointD.c(l0);
    }

    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.j3;
        if (chartTouchListener instanceof BarLineChartTouchListener) {
            ((BarLineChartTouchListener) chartTouchListener).h();
        }
    }

    public void d0(float f2, YAxis.AxisDependency axisDependency) {
        g(MoveViewJob.d(this.p3, 0.0f, f2 + ((g0(axisDependency) / this.p3.x()) / 2.0f), a(axisDependency), this));
    }

    public YAxis e(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.a4 : this.b4;
    }

    /* access modifiers changed from: protected */
    public void e0(Canvas canvas) {
        if (this.U3) {
            canvas.drawRect(this.p3.q(), this.S3);
        }
        if (this.V3) {
            canvas.drawRect(this.p3.q(), this.T3);
        }
    }

    public boolean f(YAxis.AxisDependency axisDependency) {
        return e(axisDependency).I0();
    }

    public void f0() {
        Matrix matrix = this.l4;
        this.p3.m(matrix);
        this.p3.S(matrix, this, false);
        p();
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public float g0(YAxis.AxisDependency axisDependency) {
        return (axisDependency == YAxis.AxisDependency.LEFT ? this.a4 : this.b4).I;
    }

    public YAxis getAxisLeft() {
        return this.a4;
    }

    public YAxis getAxisRight() {
        return this.b4;
    }

    public /* bridge */ /* synthetic */ BarLineScatterCandleBubbleData getData() {
        return (BarLineScatterCandleBubbleData) super.getData();
    }

    public OnDrawListener getDrawListener() {
        return this.Z3;
    }

    public float getHighestVisibleX() {
        a(YAxis.AxisDependency.LEFT).k(this.p3.i(), this.p3.f(), this.p4);
        return (float) Math.min((double) this.e3.G, this.p4.Y);
    }

    public float getLowestVisibleX() {
        a(YAxis.AxisDependency.LEFT).k(this.p3.h(), this.p3.f(), this.o4);
        return (float) Math.max((double) this.e3.H, this.o4.Y);
    }

    public int getMaxVisibleCount() {
        return this.J3;
    }

    public float getMinOffset() {
        return this.X3;
    }

    public YAxisRenderer getRendererLeftYAxis() {
        return this.c4;
    }

    public YAxisRenderer getRendererRightYAxis() {
        return this.d4;
    }

    public XAxisRenderer getRendererXAxis() {
        return this.g4;
    }

    public float getScaleX() {
        ViewPortHandler viewPortHandler = this.p3;
        if (viewPortHandler == null) {
            return 1.0f;
        }
        return viewPortHandler.w();
    }

    public float getScaleY() {
        ViewPortHandler viewPortHandler = this.p3;
        if (viewPortHandler == null) {
            return 1.0f;
        }
        return viewPortHandler.x();
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    public float getYChartMax() {
        return Math.max(this.a4.G, this.b4.G);
    }

    public float getYChartMin() {
        return Math.min(this.a4.H, this.b4.H);
    }

    public IBarLineScatterCandleBubbleDataSet h0(float f2, float f3) {
        Highlight x = x(f2, f3);
        if (x != null) {
            return (IBarLineScatterCandleBubbleDataSet) ((BarLineScatterCandleBubbleData) this.X2).k(x.d());
        }
        return null;
    }

    public Entry i0(float f2, float f3) {
        Highlight x = x(f2, f3);
        if (x != null) {
            return ((BarLineScatterCandleBubbleData) this.X2).s(x);
        }
        return null;
    }

    public MPPointD j0(float f2, float f3, YAxis.AxisDependency axisDependency) {
        return a(axisDependency).f(f2, f3);
    }

    public MPPointF k0(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        this.n4[0] = entry.m();
        this.n4[1] = entry.c();
        a(axisDependency).o(this.n4);
        float[] fArr = this.n4;
        return MPPointF.c(fArr[0], fArr[1]);
    }

    public MPPointD l0(float f2, float f3, YAxis.AxisDependency axisDependency) {
        MPPointD b2 = MPPointD.b(0.0d, 0.0d);
        m0(f2, f3, axisDependency, b2);
        return b2;
    }

    public void m0(float f2, float f3, YAxis.AxisDependency axisDependency, MPPointD mPPointD) {
        a(axisDependency).k(f2, f3, mPPointD);
    }

    public boolean n0() {
        return this.p3.C();
    }

    /* access modifiers changed from: protected */
    public void o() {
        this.e3.n(((BarLineScatterCandleBubbleData) this.X2).y(), ((BarLineScatterCandleBubbleData) this.X2).x());
        YAxis yAxis = this.a4;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.n(((BarLineScatterCandleBubbleData) this.X2).C(axisDependency), ((BarLineScatterCandleBubbleData) this.X2).A(axisDependency));
        YAxis yAxis2 = this.b4;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.n(((BarLineScatterCandleBubbleData) this.X2).C(axisDependency2), ((BarLineScatterCandleBubbleData) this.X2).A(axisDependency2));
    }

    public boolean o0() {
        return this.a4.I0() || this.b4.I0();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.X2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            e0(canvas);
            if (this.K3) {
                Z();
            }
            if (this.a4.f()) {
                YAxisRenderer yAxisRenderer = this.c4;
                YAxis yAxis = this.a4;
                yAxisRenderer.a(yAxis.H, yAxis.G, yAxis.I0());
            }
            if (this.b4.f()) {
                YAxisRenderer yAxisRenderer2 = this.d4;
                YAxis yAxis2 = this.b4;
                yAxisRenderer2.a(yAxis2.H, yAxis2.G, yAxis2.I0());
            }
            if (this.e3.f()) {
                XAxisRenderer xAxisRenderer = this.g4;
                XAxis xAxis = this.e3;
                xAxisRenderer.a(xAxis.H, xAxis.G, false);
            }
            this.g4.h(canvas);
            this.c4.h(canvas);
            this.d4.h(canvas);
            if (this.e3.N()) {
                this.g4.i(canvas);
            }
            if (this.a4.N()) {
                this.c4.i(canvas);
            }
            if (this.b4.N()) {
                this.d4.i(canvas);
            }
            if (this.e3.f() && this.e3.Q()) {
                this.g4.j(canvas);
            }
            if (this.a4.f() && this.a4.Q()) {
                this.c4.j(canvas);
            }
            if (this.b4.f() && this.b4.Q()) {
                this.d4.j(canvas);
            }
            int save = canvas.save();
            canvas.clipRect(this.p3.q());
            this.n3.b(canvas);
            if (!this.e3.N()) {
                this.g4.i(canvas);
            }
            if (!this.a4.N()) {
                this.c4.i(canvas);
            }
            if (!this.b4.N()) {
                this.d4.i(canvas);
            }
            if (Y()) {
                this.n3.d(canvas, this.w3);
            }
            canvas.restoreToCount(save);
            this.n3.c(canvas);
            if (this.e3.f() && !this.e3.Q()) {
                this.g4.j(canvas);
            }
            if (this.a4.f() && !this.a4.Q()) {
                this.c4.j(canvas);
            }
            if (this.b4.f() && !this.b4.Q()) {
                this.d4.j(canvas);
            }
            this.g4.g(canvas);
            this.c4.g(canvas);
            this.d4.g(canvas);
            if (q0()) {
                int save2 = canvas.save();
                canvas.clipRect(this.p3.q());
                this.n3.f(canvas);
                canvas.restoreToCount(save2);
            } else {
                this.n3.f(canvas);
            }
            this.m3.f(canvas);
            u(canvas);
            v(canvas);
            if (this.s) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long j2 = this.h4 + currentTimeMillis2;
                this.h4 = j2;
                long j3 = this.i4 + 1;
                this.i4 = j3;
                Log.i(Chart.C3, "Drawtime: " + currentTimeMillis2 + " ms, average: " + (j2 / j3) + " ms, cycles: " + this.i4);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i5, int i6) {
        float[] fArr = this.q4;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.Y3) {
            fArr[0] = this.p3.h();
            this.q4[1] = this.p3.j();
            a(YAxis.AxisDependency.LEFT).n(this.q4);
        }
        super.onSizeChanged(i2, i3, i5, i6);
        if (this.Y3) {
            a(YAxis.AxisDependency.LEFT).o(this.q4);
            this.p3.e(this.q4, this);
            return;
        }
        ViewPortHandler viewPortHandler = this.p3;
        viewPortHandler.S(viewPortHandler.r(), this, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        ChartTouchListener chartTouchListener = this.j3;
        if (chartTouchListener == null || this.X2 == null || !this.f3) {
            return false;
        }
        return chartTouchListener.onTouch(this, motionEvent);
    }

    public void p() {
        if (!this.m4) {
            a0(this.j4);
            RectF rectF = this.j4;
            float f2 = rectF.left + 0.0f;
            float f3 = rectF.top + 0.0f;
            float f5 = rectF.right + 0.0f;
            float f6 = rectF.bottom + 0.0f;
            if (this.a4.L0()) {
                f2 += this.a4.A0(this.c4.c());
            }
            if (this.b4.L0()) {
                f5 += this.b4.A0(this.d4.c());
            }
            if (this.e3.f() && this.e3.P()) {
                XAxis xAxis = this.e3;
                float e2 = ((float) xAxis.M) + xAxis.e();
                if (this.e3.w0() == XAxis.XAxisPosition.BOTTOM) {
                    f6 += e2;
                } else {
                    if (this.e3.w0() != XAxis.XAxisPosition.TOP) {
                        if (this.e3.w0() == XAxis.XAxisPosition.BOTH_SIDED) {
                            f6 += e2;
                        }
                    }
                    f3 += e2;
                }
            }
            float extraTopOffset = f3 + getExtraTopOffset();
            float extraRightOffset = f5 + getExtraRightOffset();
            float extraBottomOffset = f6 + getExtraBottomOffset();
            float extraLeftOffset = f2 + getExtraLeftOffset();
            float e3 = Utils.e(this.X3);
            this.p3.U(Math.max(e3, extraLeftOffset), Math.max(e3, extraTopOffset), Math.max(e3, extraRightOffset), Math.max(e3, extraBottomOffset));
            if (this.s) {
                Log.i(Chart.C3, "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
                StringBuilder sb = new StringBuilder();
                sb.append("Content: ");
                sb.append(this.p3.q().toString());
                Log.i(Chart.C3, sb.toString());
            }
        }
        F0();
        G0();
    }

    public boolean p0() {
        return this.K3;
    }

    public boolean q0() {
        return this.W3;
    }

    public boolean r0() {
        return this.M3;
    }

    public boolean s0() {
        return this.O3 || this.P3;
    }

    public void setAutoScaleMinMaxEnabled(boolean z) {
        this.K3 = z;
    }

    public void setBorderColor(int i2) {
        this.T3.setColor(i2);
    }

    public void setBorderWidth(float f2) {
        this.T3.setStrokeWidth(Utils.e(f2));
    }

    public void setClipValuesToContent(boolean z) {
        this.W3 = z;
    }

    public void setDoubleTapToZoomEnabled(boolean z) {
        this.M3 = z;
    }

    public void setDragEnabled(boolean z) {
        this.O3 = z;
        this.P3 = z;
    }

    public void setDragOffsetX(float f2) {
        this.p3.W(f2);
    }

    public void setDragOffsetY(float f2) {
        this.p3.X(f2);
    }

    public void setDragXEnabled(boolean z) {
        this.O3 = z;
    }

    public void setDragYEnabled(boolean z) {
        this.P3 = z;
    }

    public void setDrawBorders(boolean z) {
        this.V3 = z;
    }

    public void setDrawGridBackground(boolean z) {
        this.U3 = z;
    }

    public void setGridBackgroundColor(int i2) {
        this.S3.setColor(i2);
    }

    public void setHighlightPerDragEnabled(boolean z) {
        this.N3 = z;
    }

    public void setKeepPositionOnRotation(boolean z) {
        this.Y3 = z;
    }

    public void setMaxVisibleValueCount(int i2) {
        this.J3 = i2;
    }

    public void setMinOffset(float f2) {
        this.X3 = f2;
    }

    public void setOnDrawListener(OnDrawListener onDrawListener) {
        this.Z3 = onDrawListener;
    }

    public void setPinchZoom(boolean z) {
        this.L3 = z;
    }

    public void setRendererLeftYAxis(YAxisRenderer yAxisRenderer) {
        this.c4 = yAxisRenderer;
    }

    public void setRendererRightYAxis(YAxisRenderer yAxisRenderer) {
        this.d4 = yAxisRenderer;
    }

    public void setScaleEnabled(boolean z) {
        this.Q3 = z;
        this.R3 = z;
    }

    public void setScaleXEnabled(boolean z) {
        this.Q3 = z;
    }

    public void setScaleYEnabled(boolean z) {
        this.R3 = z;
    }

    public void setVisibleXRangeMaximum(float f2) {
        this.p3.c0(this.e3.I / f2);
    }

    public void setVisibleXRangeMinimum(float f2) {
        this.p3.Y(this.e3.I / f2);
    }

    public void setXAxisRenderer(XAxisRenderer xAxisRenderer) {
        this.g4 = xAxisRenderer;
    }

    public boolean t0() {
        return this.O3;
    }

    public boolean u0() {
        return this.P3;
    }

    public boolean v0() {
        return this.V3;
    }

    public boolean w0() {
        return this.p3.D();
    }

    public boolean x0() {
        return this.N3;
    }

    public boolean y0() {
        return this.Y3;
    }

    public Paint z(int i2) {
        Paint z = super.z(i2);
        if (z != null) {
            return z;
        }
        if (i2 != 4) {
            return null;
        }
        return this.S3;
    }

    public boolean z0() {
        return this.L3;
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
