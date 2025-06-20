package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import androidx.media3.extractor.ts.PsExtractor;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Chart<T extends ChartData<? extends IDataSet<? extends Entry>>> extends ViewGroup implements ChartInterface {
    public static final String C3 = "MPAndroidChart";
    public static final int D3 = 4;
    public static final int E3 = 7;
    public static final int F3 = 11;
    public static final int G3 = 13;
    public static final int H3 = 14;
    public static final int I3 = 18;
    protected ArrayList<Runnable> A3 = new ArrayList<>();
    private boolean B3 = false;
    protected T X2 = null;
    protected boolean Y2 = true;
    private boolean Z2 = true;
    private float a3 = 0.9f;
    protected DefaultValueFormatter b3 = new DefaultValueFormatter(0);
    protected Paint c3;
    protected Paint d3;
    protected XAxis e3;
    protected boolean f3 = true;
    protected Description g3;
    protected Legend h3;
    protected OnChartValueSelectedListener i3;
    protected ChartTouchListener j3;
    private String k3 = "No chart data available.";
    private OnChartGestureListener l3;
    protected LegendRenderer m3;
    protected DataRenderer n3;
    protected IHighlighter o3;
    protected ViewPortHandler p3 = new ViewPortHandler();
    protected ChartAnimator q3;
    private float r3 = 0.0f;
    protected boolean s = false;
    private float s3 = 0.0f;
    private float t3 = 0.0f;
    private float u3 = 0.0f;
    private boolean v3 = false;
    protected Highlight[] w3;
    protected float x3 = 0.0f;
    protected boolean y3 = true;
    protected IMarker z3;

    /* renamed from: com.github.mikephil.charting.charts.Chart$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18922a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                android.graphics.Bitmap$CompressFormat[] r0 = android.graphics.Bitmap.CompressFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18922a = r0
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18922a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.WEBP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f18922a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.Chart.AnonymousClass2.<clinit>():void");
        }
    }

    public Chart(Context context) {
        super(context);
        H();
    }

    private void X(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback((Drawable.Callback) null);
        }
        if (view instanceof ViewGroup) {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 < viewGroup.getChildCount()) {
                    X(viewGroup.getChildAt(i2));
                    i2++;
                } else {
                    viewGroup.removeAllViews();
                    return;
                }
            }
        }
    }

    public void A(float f2, float f4, int i2) {
        B(f2, f4, i2, true);
    }

    public void B(float f2, float f4, int i2, boolean z) {
        if (i2 < 0 || i2 >= this.X2.m()) {
            F((Highlight) null, z);
        } else {
            F(new Highlight(f2, f4, i2), z);
        }
    }

    public void C(float f2, int i2) {
        D(f2, i2, true);
    }

    public void D(float f2, int i2, boolean z) {
        B(f2, Float.NaN, i2, z);
    }

    public void E(Highlight highlight) {
        F(highlight, false);
    }

    public void F(Highlight highlight, boolean z) {
        Entry entry = null;
        if (highlight == null) {
            this.w3 = null;
        } else {
            if (this.s) {
                Log.i(C3, "Highlighted: " + highlight.toString());
            }
            Entry s2 = this.X2.s(highlight);
            if (s2 == null) {
                this.w3 = null;
                highlight = null;
            } else {
                this.w3 = new Highlight[]{highlight};
            }
            entry = s2;
        }
        setLastHighlighted(this.w3);
        if (z && this.i3 != null) {
            if (!Y()) {
                this.i3.b();
            } else {
                this.i3.a(entry, highlight);
            }
        }
        invalidate();
    }

    public void G(Highlight[] highlightArr) {
        this.w3 = highlightArr;
        setLastHighlighted(highlightArr);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void H() {
        setWillNotDraw(false);
        this.q3 = new ChartAnimator(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Chart.this.postInvalidate();
            }
        });
        Utils.H(getContext());
        this.x3 = Utils.e(500.0f);
        this.g3 = new Description();
        Legend legend = new Legend();
        this.h3 = legend;
        this.m3 = new LegendRenderer(this.p3, legend);
        this.e3 = new XAxis();
        this.c3 = new Paint(1);
        Paint paint = new Paint(1);
        this.d3 = paint;
        paint.setColor(Color.rgb(MetaDo.s0, PsExtractor.w, 51));
        this.d3.setTextAlign(Paint.Align.CENTER);
        this.d3.setTextSize(Utils.e(12.0f));
        if (this.s) {
            Log.i("", "Chart.init()");
        }
    }

    public boolean I() {
        return this.Z2;
    }

    @Deprecated
    public boolean J() {
        return K();
    }

    public boolean K() {
        return this.y3;
    }

    public boolean L() {
        T t = this.X2;
        return t == null || t.r() <= 0;
    }

    public boolean M() {
        return this.Y2;
    }

    public boolean N() {
        return this.s;
    }

    public abstract void O();

    public void P(Runnable runnable) {
        this.A3.remove(runnable);
    }

    public boolean Q(String str) {
        return S(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, 40);
    }

    public boolean R(String str, int i2) {
        return S(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0109 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean S(java.lang.String r8, java.lang.String r9, java.lang.String r10, android.graphics.Bitmap.CompressFormat r11, int r12) {
        /*
            r7 = this;
            if (r12 < 0) goto L_0x0006
            r0 = 100
            if (r12 <= r0) goto L_0x0008
        L_0x0006:
            r12 = 50
        L_0x0008:
            long r0 = java.lang.System.currentTimeMillis()
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            java.io.File r3 = new java.io.File
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = r2.getAbsolutePath()
            r4.append(r2)
            java.lang.String r2 = "/DCIM/"
            r4.append(r2)
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            r3.<init>(r9)
            boolean r9 = r3.exists()
            r2 = 0
            if (r9 != 0) goto L_0x003b
            boolean r9 = r3.mkdirs()
            if (r9 != 0) goto L_0x003b
            return r2
        L_0x003b:
            int[] r9 = com.github.mikephil.charting.charts.Chart.AnonymousClass2.f18922a
            int r4 = r11.ordinal()
            r9 = r9[r4]
            r4 = 1
            if (r9 == r4) goto L_0x007b
            r5 = 2
            if (r9 == r5) goto L_0x006b
            java.lang.String r9 = ".jpg"
            boolean r5 = r8.endsWith(r9)
            java.lang.String r6 = "image/jpeg"
            if (r5 != 0) goto L_0x008b
            java.lang.String r5 = ".jpeg"
            boolean r5 = r8.endsWith(r5)
            if (r5 != 0) goto L_0x008b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L_0x0060:
            r5.append(r8)
            r5.append(r9)
            java.lang.String r8 = r5.toString()
            goto L_0x008b
        L_0x006b:
            java.lang.String r9 = ".webp"
            boolean r5 = r8.endsWith(r9)
            java.lang.String r6 = "image/webp"
            if (r5 != 0) goto L_0x008b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L_0x0060
        L_0x007b:
            java.lang.String r9 = ".png"
            boolean r5 = r8.endsWith(r9)
            java.lang.String r6 = "image/png"
            if (r5 != 0) goto L_0x008b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L_0x0060
        L_0x008b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r3 = r3.getAbsolutePath()
            r9.append(r3)
            java.lang.String r3 = "/"
            r9.append(r3)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x010b }
            r3.<init>(r9)     // Catch:{ IOException -> 0x010b }
            android.graphics.Bitmap r5 = r7.getChartBitmap()     // Catch:{ IOException -> 0x010b }
            r5.compress(r11, r12, r3)     // Catch:{ IOException -> 0x010b }
            r3.flush()     // Catch:{ IOException -> 0x010b }
            r3.close()     // Catch:{ IOException -> 0x010b }
            java.io.File r11 = new java.io.File
            r11.<init>(r9)
            long r11 = r11.length()
            android.content.ContentValues r3 = new android.content.ContentValues
            r5 = 8
            r3.<init>(r5)
            java.lang.String r5 = "title"
            r3.put(r5, r8)
            java.lang.String r5 = "_display_name"
            r3.put(r5, r8)
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            java.lang.String r0 = "date_added"
            r3.put(r0, r8)
            java.lang.String r8 = "mime_type"
            r3.put(r8, r6)
            java.lang.String r8 = "description"
            r3.put(r8, r10)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            java.lang.String r10 = "orientation"
            r3.put(r10, r8)
            java.lang.String r8 = "_data"
            r3.put(r8, r9)
            java.lang.Long r8 = java.lang.Long.valueOf(r11)
            java.lang.String r9 = "_size"
            r3.put(r9, r8)
            android.content.Context r8 = r7.getContext()
            android.content.ContentResolver r8 = r8.getContentResolver()
            android.net.Uri r9 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            android.net.Uri r8 = r8.insert(r9, r3)
            if (r8 == 0) goto L_0x010a
            r2 = 1
        L_0x010a:
            return r2
        L_0x010b:
            r8 = move-exception
            r8.printStackTrace()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.Chart.S(java.lang.String, java.lang.String, java.lang.String, android.graphics.Bitmap$CompressFormat, int):boolean");
    }

    public boolean T(String str, String str2) {
        Bitmap chartBitmap = getChartBitmap();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + str2 + "/" + str + ".png");
            chartBitmap.compress(Bitmap.CompressFormat.PNG, 40, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void U(float f2, float f4, float f5, float f6) {
        setExtraLeftOffset(f2);
        setExtraTopOffset(f4);
        setExtraRightOffset(f5);
        setExtraBottomOffset(f6);
    }

    public void V(Paint paint, int i2) {
        if (i2 == 7) {
            this.d3 = paint;
        } else if (i2 == 11) {
            this.c3 = paint;
        }
    }

    /* access modifiers changed from: protected */
    public void W(float f2, float f4) {
        T t = this.X2;
        this.b3.m(Utils.r((t == null || t.r() < 2) ? Math.max(Math.abs(f2), Math.abs(f4)) : Math.abs(f4 - f2)));
    }

    public boolean Y() {
        Highlight[] highlightArr = this.w3;
        return (highlightArr == null || highlightArr.length <= 0 || highlightArr[0] == null) ? false : true;
    }

    public void g(Runnable runnable) {
        if (this.p3.B()) {
            post(runnable);
        } else {
            this.A3.add(runnable);
        }
    }

    public ChartAnimator getAnimator() {
        return this.q3;
    }

    public MPPointF getCenter() {
        return MPPointF.c(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    public MPPointF getCenterOfView() {
        return getCenter();
    }

    public MPPointF getCenterOffsets() {
        return this.p3.p();
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    public RectF getContentRect() {
        return this.p3.q();
    }

    public T getData() {
        return this.X2;
    }

    public ValueFormatter getDefaultValueFormatter() {
        return this.b3;
    }

    public Description getDescription() {
        return this.g3;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.a3;
    }

    public float getExtraBottomOffset() {
        return this.t3;
    }

    public float getExtraLeftOffset() {
        return this.u3;
    }

    public float getExtraRightOffset() {
        return this.s3;
    }

    public float getExtraTopOffset() {
        return this.r3;
    }

    public Highlight[] getHighlighted() {
        return this.w3;
    }

    public IHighlighter getHighlighter() {
        return this.o3;
    }

    public ArrayList<Runnable> getJobs() {
        return this.A3;
    }

    public Legend getLegend() {
        return this.h3;
    }

    public LegendRenderer getLegendRenderer() {
        return this.m3;
    }

    public IMarker getMarker() {
        return this.z3;
    }

    @Deprecated
    public IMarker getMarkerView() {
        return getMarker();
    }

    public float getMaxHighlightDistance() {
        return this.x3;
    }

    public OnChartGestureListener getOnChartGestureListener() {
        return this.l3;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.j3;
    }

    public DataRenderer getRenderer() {
        return this.n3;
    }

    public ViewPortHandler getViewPortHandler() {
        return this.p3;
    }

    public XAxis getXAxis() {
        return this.e3;
    }

    public float getXChartMax() {
        return this.e3.G;
    }

    public float getXChartMin() {
        return this.e3.H;
    }

    public float getXRange() {
        return this.e3.I;
    }

    public float getYMax() {
        return this.X2.z();
    }

    public float getYMin() {
        return this.X2.B();
    }

    @RequiresApi(11)
    public void h(int i2) {
        this.q3.a(i2);
    }

    @RequiresApi(11)
    public void i(int i2, Easing.EasingFunction easingFunction) {
        this.q3.b(i2, easingFunction);
    }

    @RequiresApi(11)
    public void j(int i2, int i4) {
        this.q3.c(i2, i4);
    }

    @RequiresApi(11)
    public void k(int i2, int i4, Easing.EasingFunction easingFunction) {
        this.q3.d(i2, i4, easingFunction);
    }

    @RequiresApi(11)
    public void l(int i2, int i4, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        this.q3.e(i2, i4, easingFunction, easingFunction2);
    }

    @RequiresApi(11)
    public void m(int i2) {
        this.q3.f(i2);
    }

    @RequiresApi(11)
    public void n(int i2, Easing.EasingFunction easingFunction) {
        this.q3.g(i2, easingFunction);
    }

    /* access modifiers changed from: protected */
    public abstract void o();

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.B3) {
            X(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.X2 == null) {
            if (!TextUtils.isEmpty(this.k3)) {
                MPPointF center = getCenter();
                canvas.drawText(this.k3, center.Y, center.Z, this.d3);
            }
        } else if (!this.v3) {
            p();
            this.v3 = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            getChildAt(i7).layout(i2, i4, i5, i6);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        int e2 = (int) Utils.e(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), View.resolveSize(e2, i2)), Math.max(getSuggestedMinimumHeight(), View.resolveSize(e2, i4)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i4, int i5, int i6) {
        if (this.s) {
            Log.i(C3, "OnSizeChanged()");
        }
        if (i2 > 0 && i4 > 0 && i2 < 10000 && i4 < 10000) {
            if (this.s) {
                Log.i(C3, "Setting chart dimens, width: " + i2 + ", height: " + i4);
            }
            this.p3.V((float) i2, (float) i4);
        } else if (this.s) {
            Log.w(C3, "*Avoiding* setting chart dimens! width: " + i2 + ", height: " + i4);
        }
        O();
        Iterator<Runnable> it2 = this.A3.iterator();
        while (it2.hasNext()) {
            post(it2.next());
        }
        this.A3.clear();
        super.onSizeChanged(i2, i4, i5, i6);
    }

    /* access modifiers changed from: protected */
    public abstract void p();

    public void q() {
        this.X2 = null;
        this.v3 = false;
        this.w3 = null;
        this.j3.f((Highlight) null);
        invalidate();
    }

    public void r() {
        this.A3.clear();
    }

    public void s() {
        this.X2.h();
        invalidate();
    }

    public void setData(T t) {
        this.X2 = t;
        this.v3 = false;
        if (t != null) {
            W(t.B(), t.z());
            for (IDataSet iDataSet : this.X2.q()) {
                if (iDataSet.m0() || iDataSet.T() == this.b3) {
                    iDataSet.s0(this.b3);
                }
            }
            O();
            if (this.s) {
                Log.i(C3, "Data is set.");
            }
        }
    }

    public void setDescription(Description description) {
        this.g3 = description;
    }

    public void setDragDecelerationEnabled(boolean z) {
        this.Z2 = z;
    }

    public void setDragDecelerationFrictionCoef(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 >= 1.0f) {
            f2 = 0.999f;
        }
        this.a3 = f2;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z) {
        setDrawMarkers(z);
    }

    public void setDrawMarkers(boolean z) {
        this.y3 = z;
    }

    public void setExtraBottomOffset(float f2) {
        this.t3 = Utils.e(f2);
    }

    public void setExtraLeftOffset(float f2) {
        this.u3 = Utils.e(f2);
    }

    public void setExtraRightOffset(float f2) {
        this.s3 = Utils.e(f2);
    }

    public void setExtraTopOffset(float f2) {
        this.r3 = Utils.e(f2);
    }

    public void setHardwareAccelerationEnabled(boolean z) {
        setLayerType(z ? 2 : 1, (Paint) null);
    }

    public void setHighlightPerTapEnabled(boolean z) {
        this.Y2 = z;
    }

    public void setHighlighter(ChartHighlighter chartHighlighter) {
        this.o3 = chartHighlighter;
    }

    /* access modifiers changed from: protected */
    public void setLastHighlighted(Highlight[] highlightArr) {
        Highlight highlight;
        if (highlightArr == null || highlightArr.length <= 0 || (highlight = highlightArr[0]) == null) {
            this.j3.f((Highlight) null);
        } else {
            this.j3.f(highlight);
        }
    }

    public void setLogEnabled(boolean z) {
        this.s = z;
    }

    public void setMarker(IMarker iMarker) {
        this.z3 = iMarker;
    }

    @Deprecated
    public void setMarkerView(IMarker iMarker) {
        setMarker(iMarker);
    }

    public void setMaxHighlightDistance(float f2) {
        this.x3 = Utils.e(f2);
    }

    public void setNoDataText(String str) {
        this.k3 = str;
    }

    public void setNoDataTextColor(int i2) {
        this.d3.setColor(i2);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.d3.setTypeface(typeface);
    }

    public void setOnChartGestureListener(OnChartGestureListener onChartGestureListener) {
        this.l3 = onChartGestureListener;
    }

    public void setOnChartValueSelectedListener(OnChartValueSelectedListener onChartValueSelectedListener) {
        this.i3 = onChartValueSelectedListener;
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.j3 = chartTouchListener;
    }

    public void setRenderer(DataRenderer dataRenderer) {
        if (dataRenderer != null) {
            this.n3 = dataRenderer;
        }
    }

    public void setTouchEnabled(boolean z) {
        this.f3 = z;
    }

    public void setUnbindEnabled(boolean z) {
        this.B3 = z;
    }

    public void t() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    /* access modifiers changed from: protected */
    public void u(Canvas canvas) {
        float f2;
        float f4;
        Description description = this.g3;
        if (description != null && description.f()) {
            MPPointF m2 = this.g3.m();
            this.c3.setTypeface(this.g3.c());
            this.c3.setTextSize(this.g3.b());
            this.c3.setColor(this.g3.a());
            this.c3.setTextAlign(this.g3.o());
            if (m2 == null) {
                f4 = (((float) getWidth()) - this.p3.Q()) - this.g3.d();
                f2 = (((float) getHeight()) - this.p3.O()) - this.g3.e();
            } else {
                float f5 = m2.Y;
                f2 = m2.Z;
                f4 = f5;
            }
            canvas.drawText(this.g3.n(), f4, f2, this.c3);
        }
    }

    /* access modifiers changed from: protected */
    public void v(Canvas canvas) {
        if (this.z3 != null && K() && Y()) {
            int i2 = 0;
            while (true) {
                Highlight[] highlightArr = this.w3;
                if (i2 < highlightArr.length) {
                    Highlight highlight = highlightArr[i2];
                    IDataSet k2 = this.X2.k(highlight.d());
                    Entry s2 = this.X2.s(this.w3[i2]);
                    int s4 = k2.s(s2);
                    if (s2 != null && ((float) s4) <= ((float) k2.e1()) * this.q3.h()) {
                        float[] y = y(highlight);
                        if (this.p3.G(y[0], y[1])) {
                            this.z3.a(s2, highlight);
                            this.z3.b(canvas, y[0], y[1]);
                        }
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void w() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public Highlight x(float f2, float f4) {
        if (this.X2 != null) {
            return getHighlighter().a(f2, f4);
        }
        Log.e(C3, "Can't select by touch. No data set.");
        return null;
    }

    /* access modifiers changed from: protected */
    public float[] y(Highlight highlight) {
        return new float[]{highlight.e(), highlight.f()};
    }

    public Paint z(int i2) {
        if (i2 == 7) {
            return this.d3;
        }
        if (i2 != 11) {
            return null;
        }
        return this.c3;
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        H();
    }

    public Chart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        H();
    }
}
