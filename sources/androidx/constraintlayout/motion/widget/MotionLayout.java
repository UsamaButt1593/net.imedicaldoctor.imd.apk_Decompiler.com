package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.StringUtils;

public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static final int f5 = 0;
    public static final int g5 = 1;
    public static final int h5 = 2;
    public static final int i5 = 3;
    public static final int j5 = 4;
    public static final int k5 = 5;
    public static final int l5 = 6;
    public static final int m5 = 7;
    static final String n5 = "MotionLayout";
    private static final boolean o5 = false;
    public static boolean p5 = false;
    public static final int q5 = 0;
    public static final int r5 = 1;
    public static final int s5 = 2;
    static final int t5 = 50;
    public static final int u5 = 0;
    public static final int v5 = 1;
    public static final int w5 = 2;
    public static final int x5 = 3;
    private static final float y5 = 1.0E-5f;
    private float A4 = 0.0f;
    boolean B4 = false;
    protected boolean C4 = false;
    int D4;
    MotionScene E3;
    int E4;
    Interpolator F3;
    int F4;
    Interpolator G3 = null;
    int G4;
    float H3 = 0.0f;
    int H4;
    /* access modifiers changed from: private */
    public int I3 = -1;
    int I4;
    int J3 = -1;
    float J4;
    /* access modifiers changed from: private */
    public int K3 = -1;
    private KeyCache K4 = new KeyCache();
    /* access modifiers changed from: private */
    public int L3 = 0;
    private boolean L4 = false;
    /* access modifiers changed from: private */
    public int M3 = 0;
    /* access modifiers changed from: private */
    public StateCache M4;
    private boolean N3 = true;
    private Runnable N4 = null;
    HashMap<View, MotionController> O3 = new HashMap<>();
    private int[] O4 = null;
    private long P3 = 0;
    int P4 = 0;
    private float Q3 = 1.0f;
    /* access modifiers changed from: private */
    public boolean Q4 = false;
    float R3 = 0.0f;
    int R4 = 0;
    float S3 = 0.0f;
    HashMap<View, ViewState> S4 = new HashMap<>();
    private long T3;
    /* access modifiers changed from: private */
    public int T4;
    float U3 = 0.0f;
    /* access modifiers changed from: private */
    public int U4;
    private boolean V3;
    private int V4;
    boolean W3 = false;
    Rect W4 = new Rect();
    boolean X3 = false;
    private boolean X4 = false;
    private TransitionListener Y3;
    TransitionState Y4 = TransitionState.UNDEFINED;
    private float Z3;
    Model Z4 = new Model();
    private float a4;
    private boolean a5 = false;
    int b4 = 0;
    private RectF b5 = new RectF();
    DevModeDraw c4;
    private View c5 = null;
    private boolean d4 = false;
    private Matrix d5 = null;
    private StopLogic e4 = new StopLogic();
    ArrayList<Integer> e5 = new ArrayList<>();
    private DecelerateInterpolator f4 = new DecelerateInterpolator();
    private DesignTool g4;
    boolean h4 = true;
    int i4;
    int j4;
    int k4;
    int l4;
    boolean m4 = false;
    float n4;
    float o4;
    long p4;
    float q4;
    private boolean r4 = false;
    private ArrayList<MotionHelper> s4 = null;
    private ArrayList<MotionHelper> t4 = null;
    private ArrayList<MotionHelper> u4 = null;
    private CopyOnWriteArrayList<TransitionListener> v4 = null;
    private int w4 = 0;
    private long x4 = -1;
    private float y4 = 0.0f;
    private int z4 = 0;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4470a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState[] r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4470a = r0
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4470a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4470a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4470a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.AnonymousClass5.<clinit>():void");
        }
    }

    class DecelerateInterpolator extends MotionInterpolator {

        /* renamed from: a  reason: collision with root package name */
        float f4471a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        float f4472b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        float f4473c;

        DecelerateInterpolator() {
        }

        public float a() {
            return MotionLayout.this.H3;
        }

        public void b(float f2, float f3, float f4) {
            this.f4471a = f2;
            this.f4472b = f3;
            this.f4473c = f4;
        }

        public float getInterpolation(float f2) {
            float f3;
            float f4 = this.f4471a;
            if (f4 > 0.0f) {
                float f5 = this.f4473c;
                if (f4 / f5 < f2) {
                    f2 = f4 / f5;
                }
                MotionLayout.this.H3 = f4 - (f5 * f2);
                f3 = (f4 * f2) - (((f5 * f2) * f2) / 2.0f);
            } else {
                float f6 = this.f4473c;
                if ((-f4) / f6 < f2) {
                    f2 = (-f4) / f6;
                }
                MotionLayout.this.H3 = (f6 * f2) + f4;
                f3 = (f4 * f2) + (((f6 * f2) * f2) / 2.0f);
            }
            return f3 + this.f4472b;
        }
    }

    private class DevModeDraw {
        private static final int v = 16;

        /* renamed from: a  reason: collision with root package name */
        float[] f4475a;

        /* renamed from: b  reason: collision with root package name */
        int[] f4476b;

        /* renamed from: c  reason: collision with root package name */
        float[] f4477c;

        /* renamed from: d  reason: collision with root package name */
        Path f4478d;

        /* renamed from: e  reason: collision with root package name */
        Paint f4479e;

        /* renamed from: f  reason: collision with root package name */
        Paint f4480f;

        /* renamed from: g  reason: collision with root package name */
        Paint f4481g;

        /* renamed from: h  reason: collision with root package name */
        Paint f4482h;

        /* renamed from: i  reason: collision with root package name */
        Paint f4483i;

        /* renamed from: j  reason: collision with root package name */
        private float[] f4484j;

        /* renamed from: k  reason: collision with root package name */
        final int f4485k = -21965;

        /* renamed from: l  reason: collision with root package name */
        final int f4486l = -2067046;

        /* renamed from: m  reason: collision with root package name */
        final int f4487m = -13391360;

        /* renamed from: n  reason: collision with root package name */
        final int f4488n = 1996488704;
        final int o = 10;
        DashPathEffect p;
        int q;
        Rect r = new Rect();
        boolean s = false;
        int t = 1;

        public DevModeDraw() {
            Paint paint = new Paint();
            this.f4479e = paint;
            paint.setAntiAlias(true);
            this.f4479e.setColor(-21965);
            this.f4479e.setStrokeWidth(2.0f);
            Paint paint2 = this.f4479e;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f4480f = paint3;
            paint3.setAntiAlias(true);
            this.f4480f.setColor(-2067046);
            this.f4480f.setStrokeWidth(2.0f);
            this.f4480f.setStyle(style);
            Paint paint4 = new Paint();
            this.f4481g = paint4;
            paint4.setAntiAlias(true);
            this.f4481g.setColor(-13391360);
            this.f4481g.setStrokeWidth(2.0f);
            this.f4481g.setStyle(style);
            Paint paint5 = new Paint();
            this.f4482h = paint5;
            paint5.setAntiAlias(true);
            this.f4482h.setColor(-13391360);
            this.f4482h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f4484j = new float[8];
            Paint paint6 = new Paint();
            this.f4483i = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.p = dashPathEffect;
            this.f4481g.setPathEffect(dashPathEffect);
            this.f4477c = new float[100];
            this.f4476b = new int[50];
            if (this.s) {
                this.f4479e.setStrokeWidth(8.0f);
                this.f4483i.setStrokeWidth(8.0f);
                this.f4480f.setStrokeWidth(8.0f);
                this.t = 4;
            }
        }

        private void c(Canvas canvas) {
            canvas.drawLines(this.f4475a, this.f4479e);
        }

        private void d(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.q; i2++) {
                int i3 = this.f4476b[i2];
                if (i3 == 1) {
                    z = true;
                }
                if (i3 == 0) {
                    z2 = true;
                }
            }
            if (z) {
                g(canvas);
            }
            if (z2) {
                e(canvas);
            }
        }

        private void e(Canvas canvas) {
            float[] fArr = this.f4475a;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[fArr.length - 2];
            float f5 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f2, f4), Math.max(f3, f5), Math.max(f2, f4), Math.max(f3, f5), this.f4481g);
            canvas.drawLine(Math.min(f2, f4), Math.min(f3, f5), Math.min(f2, f4), Math.max(f3, f5), this.f4481g);
        }

        private void f(Canvas canvas, float f2, float f3) {
            Canvas canvas2 = canvas;
            float[] fArr = this.f4475a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float min = Math.min(f4, f6);
            float max = Math.max(f5, f7);
            float min2 = f2 - Math.min(f4, f6);
            float max2 = Math.max(f5, f7) - f3;
            String str = "" + (((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f6 - f4))) + 0.5d))) / 100.0f);
            m(str, this.f4482h);
            canvas2.drawText(str, ((min2 / 2.0f) - ((float) (this.r.width() / 2))) + min, f3 - 20.0f, this.f4482h);
            canvas.drawLine(f2, f3, Math.min(f4, f6), f3, this.f4481g);
            String str2 = "" + (((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f7 - f5))) + 0.5d))) / 100.0f);
            m(str2, this.f4482h);
            canvas2.drawText(str2, f2 + 5.0f, max - ((max2 / 2.0f) - ((float) (this.r.height() / 2))), this.f4482h);
            canvas.drawLine(f2, f3, f2, Math.max(f5, f7), this.f4481g);
        }

        private void g(Canvas canvas) {
            float[] fArr = this.f4475a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f4481g);
        }

        private void h(Canvas canvas, float f2, float f3) {
            float[] fArr = this.f4475a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f4 - f6), (double) (f5 - f7));
            float f8 = f6 - f4;
            float f9 = f7 - f5;
            float f10 = (((f2 - f4) * f8) + ((f3 - f5) * f9)) / (hypot * hypot);
            float f11 = f4 + (f8 * f10);
            float f12 = f5 + (f10 * f9);
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f11, f12);
            float hypot2 = (float) Math.hypot((double) (f11 - f2), (double) (f12 - f3));
            String str = "" + (((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            m(str, this.f4482h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - ((float) (this.r.width() / 2)), -20.0f, this.f4482h);
            canvas.drawLine(f2, f3, f11, f12, this.f4481g);
        }

        private void i(Canvas canvas, float f2, float f3, int i2, int i3) {
            Canvas canvas2 = canvas;
            String str = "" + (((float) ((int) (((double) (((f2 - ((float) (i2 / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i2)))) + 0.5d))) / 100.0f);
            m(str, this.f4482h);
            canvas2.drawText(str, ((f2 / 2.0f) - ((float) (this.r.width() / 2))) + 0.0f, f3 - 20.0f, this.f4482h);
            canvas.drawLine(f2, f3, Math.min(0.0f, 1.0f), f3, this.f4481g);
            String str2 = "" + (((float) ((int) (((double) (((f3 - ((float) (i3 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i3)))) + 0.5d))) / 100.0f);
            m(str2, this.f4482h);
            canvas2.drawText(str2, f2 + 5.0f, 0.0f - ((f3 / 2.0f) - ((float) (this.r.height() / 2))), this.f4482h);
            canvas.drawLine(f2, f3, f2, Math.max(0.0f, 1.0f), this.f4481g);
        }

        private void j(Canvas canvas, MotionController motionController) {
            this.f4478d.reset();
            for (int i2 = 0; i2 <= 50; i2++) {
                motionController.g(((float) i2) / ((float) 50), this.f4484j, 0);
                Path path = this.f4478d;
                float[] fArr = this.f4484j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f4478d;
                float[] fArr2 = this.f4484j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f4478d;
                float[] fArr3 = this.f4484j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f4478d;
                float[] fArr4 = this.f4484j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f4478d.close();
            }
            this.f4479e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f4478d, this.f4479e);
            canvas.translate(-2.0f, -2.0f);
            this.f4479e.setColor(SupportMenu.f5941c);
            canvas.drawPath(this.f4478d, this.f4479e);
        }

        private void k(Canvas canvas, int i2, int i3, MotionController motionController) {
            int i4;
            int i5;
            float f2;
            float f3;
            Canvas canvas2 = canvas;
            int i6 = i2;
            MotionController motionController2 = motionController;
            View view = motionController2.f4456b;
            if (view != null) {
                i5 = view.getWidth();
                i4 = motionController2.f4456b.getHeight();
            } else {
                i5 = 0;
                i4 = 0;
            }
            for (int i7 = 1; i7 < i3 - 1; i7++) {
                if (i6 != 4 || this.f4476b[i7 - 1] != 0) {
                    float[] fArr = this.f4477c;
                    int i8 = i7 * 2;
                    float f4 = fArr[i8];
                    float f5 = fArr[i8 + 1];
                    this.f4478d.reset();
                    this.f4478d.moveTo(f4, f5 + 10.0f);
                    this.f4478d.lineTo(f4 + 10.0f, f5);
                    this.f4478d.lineTo(f4, f5 - 10.0f);
                    this.f4478d.lineTo(f4 - 10.0f, f5);
                    this.f4478d.close();
                    int i9 = i7 - 1;
                    motionController2.w(i9);
                    if (i6 == 4) {
                        int i10 = this.f4476b[i9];
                        if (i10 == 1) {
                            h(canvas2, f4 - 0.0f, f5 - 0.0f);
                        } else if (i10 == 0) {
                            f(canvas2, f4 - 0.0f, f5 - 0.0f);
                        } else if (i10 == 2) {
                            f3 = f5;
                            f2 = f4;
                            i(canvas, f4 - 0.0f, f5 - 0.0f, i5, i4);
                            canvas2.drawPath(this.f4478d, this.f4483i);
                        }
                        f3 = f5;
                        f2 = f4;
                        canvas2.drawPath(this.f4478d, this.f4483i);
                    } else {
                        f3 = f5;
                        f2 = f4;
                    }
                    if (i6 == 2) {
                        h(canvas2, f2 - 0.0f, f3 - 0.0f);
                    }
                    if (i6 == 3) {
                        f(canvas2, f2 - 0.0f, f3 - 0.0f);
                    }
                    if (i6 == 6) {
                        i(canvas, f2 - 0.0f, f3 - 0.0f, i5, i4);
                    }
                    canvas2.drawPath(this.f4478d, this.f4483i);
                }
            }
            float[] fArr2 = this.f4475a;
            if (fArr2.length > 1) {
                canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f4480f);
                float[] fArr3 = this.f4475a;
                canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f4480f);
            }
        }

        private void l(Canvas canvas, float f2, float f3, float f4, float f5) {
            canvas.drawRect(f2, f3, f4, f5, this.f4481g);
            canvas.drawLine(f2, f3, f4, f5, this.f4481g);
        }

        public void a(Canvas canvas, HashMap<View, MotionController> hashMap, int i2, int i3) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i3 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.K3) + ":" + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, (float) (MotionLayout.this.getHeight() - 30), this.f4482h);
                    canvas.drawText(str, 11.0f, (float) (MotionLayout.this.getHeight() - 29), this.f4479e);
                }
                for (MotionController next : hashMap.values()) {
                    int q2 = next.q();
                    if (i3 > 0 && q2 == 0) {
                        q2 = 1;
                    }
                    if (q2 != 0) {
                        this.q = next.e(this.f4477c, this.f4476b);
                        if (q2 >= 1) {
                            int i4 = i2 / 16;
                            float[] fArr = this.f4475a;
                            if (fArr == null || fArr.length != i4 * 2) {
                                this.f4475a = new float[(i4 * 2)];
                                this.f4478d = new Path();
                            }
                            int i5 = this.t;
                            canvas.translate((float) i5, (float) i5);
                            this.f4479e.setColor(1996488704);
                            this.f4483i.setColor(1996488704);
                            this.f4480f.setColor(1996488704);
                            this.f4481g.setColor(1996488704);
                            next.f(this.f4475a, i4);
                            b(canvas, q2, this.q, next);
                            this.f4479e.setColor(-21965);
                            this.f4480f.setColor(-2067046);
                            this.f4483i.setColor(-2067046);
                            this.f4481g.setColor(-13391360);
                            int i6 = this.t;
                            canvas.translate((float) (-i6), (float) (-i6));
                            b(canvas, q2, this.q, next);
                            if (q2 == 5) {
                                j(canvas, next);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        public void b(Canvas canvas, int i2, int i3, MotionController motionController) {
            if (i2 == 4) {
                d(canvas);
            }
            if (i2 == 2) {
                g(canvas);
            }
            if (i2 == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i2, i3, motionController);
        }

        /* access modifiers changed from: package-private */
        public void m(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.r);
        }
    }

    class Model {

        /* renamed from: a  reason: collision with root package name */
        ConstraintWidgetContainer f4489a = new ConstraintWidgetContainer();

        /* renamed from: b  reason: collision with root package name */
        ConstraintWidgetContainer f4490b = new ConstraintWidgetContainer();

        /* renamed from: c  reason: collision with root package name */
        ConstraintSet f4491c = null;

        /* renamed from: d  reason: collision with root package name */
        ConstraintSet f4492d = null;

        /* renamed from: e  reason: collision with root package name */
        int f4493e;

        /* renamed from: f  reason: collision with root package name */
        int f4494f;

        Model() {
        }

        private void b(int i2, int i3) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.J3 == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer = this.f4490b;
                ConstraintSet constraintSet = this.f4492d;
                motionLayout2.B(constraintWidgetContainer, optimizationLevel, (constraintSet == null || constraintSet.f4706d == 0) ? i2 : i3, (constraintSet == null || constraintSet.f4706d == 0) ? i3 : i2);
                ConstraintSet constraintSet2 = this.f4491c;
                if (constraintSet2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f4489a;
                    int i4 = constraintSet2.f4706d;
                    int i5 = i4 == 0 ? i2 : i3;
                    if (i4 == 0) {
                        i2 = i3;
                    }
                    motionLayout3.B(constraintWidgetContainer2, optimizationLevel, i5, i2);
                    return;
                }
                return;
            }
            ConstraintSet constraintSet3 = this.f4491c;
            if (constraintSet3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f4489a;
                int i6 = constraintSet3.f4706d;
                motionLayout4.B(constraintWidgetContainer3, optimizationLevel, i6 == 0 ? i2 : i3, i6 == 0 ? i3 : i2);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            ConstraintWidgetContainer constraintWidgetContainer4 = this.f4490b;
            ConstraintSet constraintSet4 = this.f4492d;
            int i7 = (constraintSet4 == null || constraintSet4.f4706d == 0) ? i2 : i3;
            if (constraintSet4 == null || constraintSet4.f4706d == 0) {
                i2 = i3;
            }
            motionLayout5.B(constraintWidgetContainer4, optimizationLevel, i7, i2);
        }

        @SuppressLint({"LogConditional"})
        private void d(String str, ConstraintWidgetContainer constraintWidgetContainer) {
            String str2 = str + StringUtils.SPACE + Debug.k((View) constraintWidgetContainer.w());
            Log.v(MotionLayout.n5, str2 + "  ========= " + constraintWidgetContainer);
            int size = constraintWidgetContainer.l2().size();
            for (int i2 = 0; i2 < size; i2++) {
                String str3 = str2 + "[" + i2 + "] ";
                ConstraintWidget constraintWidget = constraintWidgetContainer.l2().get(i2);
                StringBuilder sb = new StringBuilder();
                sb.append("");
                String str4 = "_";
                sb.append(constraintWidget.R.f4183f != null ? ExifInterface.d5 : str4);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                sb3.append(constraintWidget.T.f4183f != null ? "B" : str4);
                String sb4 = sb3.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(sb4);
                sb5.append(constraintWidget.Q.f4183f != null ? "L" : str4);
                String sb6 = sb5.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(sb6);
                if (constraintWidget.S.f4183f != null) {
                    str4 = "R";
                }
                sb7.append(str4);
                String sb8 = sb7.toString();
                View view = (View) constraintWidget.w();
                String k2 = Debug.k(view);
                if (view instanceof TextView) {
                    k2 = k2 + "(" + ((TextView) view).getText() + ")";
                }
                Log.v(MotionLayout.n5, str3 + "  " + k2 + StringUtils.SPACE + constraintWidget + StringUtils.SPACE + sb8);
            }
            Log.v(MotionLayout.n5, str2 + " done. ");
        }

        @SuppressLint({"LogConditional"})
        private void e(String str, ConstraintLayout.LayoutParams layoutParams) {
            StringBuilder sb = new StringBuilder();
            sb.append(StringUtils.SPACE);
            sb.append(layoutParams.t != -1 ? "SS" : "__");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            String str2 = "|__";
            sb3.append(layoutParams.s != -1 ? "|SE" : str2);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append(layoutParams.u != -1 ? "|ES" : str2);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            sb7.append(layoutParams.v != -1 ? "|EE" : str2);
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(sb8);
            sb9.append(layoutParams.f4630e != -1 ? "|LL" : str2);
            String sb10 = sb9.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(sb10);
            sb11.append(layoutParams.f4631f != -1 ? "|LR" : str2);
            String sb12 = sb11.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(sb12);
            sb13.append(layoutParams.f4632g != -1 ? "|RL" : str2);
            String sb14 = sb13.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append(sb14);
            sb15.append(layoutParams.f4633h != -1 ? "|RR" : str2);
            String sb16 = sb15.toString();
            StringBuilder sb17 = new StringBuilder();
            sb17.append(sb16);
            sb17.append(layoutParams.f4634i != -1 ? "|TT" : str2);
            String sb18 = sb17.toString();
            StringBuilder sb19 = new StringBuilder();
            sb19.append(sb18);
            sb19.append(layoutParams.f4635j != -1 ? "|TB" : str2);
            String sb20 = sb19.toString();
            StringBuilder sb21 = new StringBuilder();
            sb21.append(sb20);
            sb21.append(layoutParams.f4636k != -1 ? "|BT" : str2);
            String sb22 = sb21.toString();
            StringBuilder sb23 = new StringBuilder();
            sb23.append(sb22);
            if (layoutParams.f4637l != -1) {
                str2 = "|BB";
            }
            sb23.append(str2);
            String sb24 = sb23.toString();
            Log.v(MotionLayout.n5, str + sb24);
        }

        @SuppressLint({"LogConditional"})
        private void f(String str, ConstraintWidget constraintWidget) {
            String str2;
            String str3;
            String str4;
            StringBuilder sb = new StringBuilder();
            sb.append(StringUtils.SPACE);
            String str5 = "B";
            String str6 = "__";
            if (constraintWidget.R.f4183f != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ExifInterface.d5);
                sb2.append(constraintWidget.R.f4183f.f4182e == ConstraintAnchor.Type.TOP ? ExifInterface.d5 : str5);
                str2 = sb2.toString();
            } else {
                str2 = str6;
            }
            sb.append(str2);
            String sb3 = sb.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb3);
            if (constraintWidget.T.f4183f != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str5);
                if (constraintWidget.T.f4183f.f4182e == ConstraintAnchor.Type.TOP) {
                    str5 = ExifInterface.d5;
                }
                sb5.append(str5);
                str3 = sb5.toString();
            } else {
                str3 = str6;
            }
            sb4.append(str3);
            String sb6 = sb4.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            String str7 = "R";
            if (constraintWidget.Q.f4183f != null) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("L");
                sb8.append(constraintWidget.Q.f4183f.f4182e == ConstraintAnchor.Type.LEFT ? "L" : str7);
                str4 = sb8.toString();
            } else {
                str4 = str6;
            }
            sb7.append(str4);
            String sb9 = sb7.toString();
            StringBuilder sb10 = new StringBuilder();
            sb10.append(sb9);
            if (constraintWidget.S.f4183f != null) {
                StringBuilder sb11 = new StringBuilder();
                sb11.append(str7);
                if (constraintWidget.S.f4183f.f4182e == ConstraintAnchor.Type.LEFT) {
                    str7 = "L";
                }
                sb11.append(str7);
                str6 = sb11.toString();
            }
            sb10.append(str6);
            String sb12 = sb10.toString();
            Log.v(MotionLayout.n5, str + sb12 + " ---  " + constraintWidget);
        }

        private void m(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            if (!(constraintSet == null || constraintSet.f4706d == 0)) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.B(this.f4490b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator<ConstraintWidget> it2 = constraintWidgetContainer.l2().iterator();
            while (it2.hasNext()) {
                ConstraintWidget next = it2.next();
                next.f1(true);
                sparseArray.put(((View) next.w()).getId(), next);
            }
            Iterator<ConstraintWidget> it3 = constraintWidgetContainer.l2().iterator();
            while (it3.hasNext()) {
                ConstraintWidget next2 = it3.next();
                View view = (View) next2.w();
                constraintSet.u(view.getId(), layoutParams);
                next2.c2(constraintSet.u0(view.getId()));
                next2.y1(constraintSet.n0(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.s((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).I();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.i(false, view, next2, layoutParams, sparseArray);
                next2.b2(constraintSet.t0(view.getId()) == 1 ? view.getVisibility() : constraintSet.s0(view.getId()));
            }
            Iterator<ConstraintWidget> it4 = constraintWidgetContainer.l2().iterator();
            while (it4.hasNext()) {
                ConstraintWidget next3 = it4.next();
                if (next3 instanceof VirtualLayout) {
                    Helper helper = (Helper) next3;
                    ((ConstraintHelper) next3.w()).G(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).n2();
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x013c A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r18 = this;
                r0 = r18
                androidx.constraintlayout.motion.widget.MotionLayout r1 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r1 = r1.getChildCount()
                androidx.constraintlayout.motion.widget.MotionLayout r2 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r2 = r2.O3
                r2.clear()
                android.util.SparseArray r2 = new android.util.SparseArray
                r2.<init>()
                int[] r3 = new int[r1]
                r5 = 0
            L_0x0017:
                if (r5 >= r1) goto L_0x0037
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r6 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.MotionController r7 = new androidx.constraintlayout.motion.widget.MotionController
                r7.<init>(r6)
                int r8 = r6.getId()
                r3[r5] = r8
                r2.put(r8, r7)
                androidx.constraintlayout.motion.widget.MotionLayout r8 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r8 = r8.O3
                r8.put(r6, r7)
                int r5 = r5 + 1
                goto L_0x0017
            L_0x0037:
                r5 = 0
            L_0x0038:
                if (r5 >= r1) goto L_0x0142
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r6 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r7 = r7.O3
                java.lang.Object r7 = r7.get(r6)
                r13 = r7
                androidx.constraintlayout.motion.widget.MotionController r13 = (androidx.constraintlayout.motion.widget.MotionController) r13
                if (r13 != 0) goto L_0x0051
                r16 = r2
                goto L_0x013c
            L_0x0051:
                androidx.constraintlayout.widget.ConstraintSet r7 = r0.f4491c
                java.lang.String r14 = ")"
                java.lang.String r15 = " ("
                java.lang.String r12 = "no widget for  "
                java.lang.String r11 = "MotionLayout"
                if (r7 == 0) goto L_0x00b6
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r0.f4489a
                androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r0.g(r7, r6)
                if (r7 == 0) goto L_0x007d
                androidx.constraintlayout.motion.widget.MotionLayout r8 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r7 = r8.a1(r7)
                androidx.constraintlayout.widget.ConstraintSet r8 = r0.f4491c
                androidx.constraintlayout.motion.widget.MotionLayout r9 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r9 = r9.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r10 = r10.getHeight()
                r13.W(r7, r8, r9, r10)
                goto L_0x00b1
            L_0x007d:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.b4
                if (r7 == 0) goto L_0x00b1
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.g()
                r7.append(r8)
                r7.append(r12)
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.k(r6)
                r7.append(r8)
                r7.append(r15)
                java.lang.Class r8 = r6.getClass()
                java.lang.String r8 = r8.getName()
                r7.append(r8)
                r7.append(r14)
                java.lang.String r7 = r7.toString()
                android.util.Log.e(r11, r7)
            L_0x00b1:
                r16 = r2
                r4 = r11
                r2 = r12
                goto L_0x00e4
            L_0x00b6:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                boolean r7 = r7.Q4
                if (r7 == 0) goto L_0x00b1
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.utils.ViewState> r7 = r7.S4
                java.lang.Object r7 = r7.get(r6)
                r8 = r7
                androidx.constraintlayout.motion.utils.ViewState r8 = (androidx.constraintlayout.motion.utils.ViewState) r8
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r10 = r7.R4
                int r16 = r7.T4
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r17 = r7.U4
                r7 = r13
                r9 = r6
                r4 = r11
                r11 = r16
                r16 = r2
                r2 = r12
                r12 = r17
                r7.X(r8, r9, r10, r11, r12)
            L_0x00e4:
                androidx.constraintlayout.widget.ConstraintSet r7 = r0.f4492d
                if (r7 == 0) goto L_0x013c
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r0.f4490b
                androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r0.g(r7, r6)
                if (r7 == 0) goto L_0x0108
                androidx.constraintlayout.motion.widget.MotionLayout r2 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r2 = r2.a1(r7)
                androidx.constraintlayout.widget.ConstraintSet r4 = r0.f4492d
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r6 = r6.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.getHeight()
                r13.T(r2, r4, r6, r7)
                goto L_0x013c
            L_0x0108:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.b4
                if (r7 == 0) goto L_0x013c
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.g()
                r7.append(r8)
                r7.append(r2)
                java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.k(r6)
                r7.append(r2)
                r7.append(r15)
                java.lang.Class r2 = r6.getClass()
                java.lang.String r2 = r2.getName()
                r7.append(r2)
                r7.append(r14)
                java.lang.String r2 = r7.toString()
                android.util.Log.e(r4, r2)
            L_0x013c:
                int r5 = r5 + 1
                r2 = r16
                goto L_0x0038
            L_0x0142:
                r16 = r2
                r4 = 0
            L_0x0145:
                if (r4 >= r1) goto L_0x0166
                r2 = r3[r4]
                r5 = r16
                java.lang.Object r2 = r5.get(r2)
                androidx.constraintlayout.motion.widget.MotionController r2 = (androidx.constraintlayout.motion.widget.MotionController) r2
                int r6 = r2.k()
                r7 = -1
                if (r6 == r7) goto L_0x0161
                java.lang.Object r6 = r5.get(r6)
                androidx.constraintlayout.motion.widget.MotionController r6 = (androidx.constraintlayout.motion.widget.MotionController) r6
                r2.b0(r6)
            L_0x0161:
                int r4 = r4 + 1
                r16 = r5
                goto L_0x0145
            L_0x0166:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.Model.a():void");
        }

        /* access modifiers changed from: package-private */
        public void c(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ArrayList<ConstraintWidget> l2 = constraintWidgetContainer.l2();
            HashMap hashMap = new HashMap();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.l2().clear();
            constraintWidgetContainer2.n(constraintWidgetContainer, hashMap);
            Iterator<ConstraintWidget> it2 = l2.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next = it2.next();
                ConstraintWidget barrier = next instanceof androidx.constraintlayout.core.widgets.Barrier ? new androidx.constraintlayout.core.widgets.Barrier() : next instanceof Guideline ? new Guideline() : next instanceof Flow ? new Flow() : next instanceof Placeholder ? new Placeholder() : next instanceof Helper ? new HelperWidget() : new ConstraintWidget();
                constraintWidgetContainer2.b(barrier);
                hashMap.put(next, barrier);
            }
            Iterator<ConstraintWidget> it3 = l2.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next2 = it3.next();
                ((ConstraintWidget) hashMap.get(next2)).n(next2, hashMap);
            }
        }

        /* access modifiers changed from: package-private */
        public ConstraintWidget g(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.w() == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> l2 = constraintWidgetContainer.l2();
            int size = l2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = l2.get(i2);
                if (constraintWidget.w() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void h(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.f4491c = constraintSet;
            this.f4492d = constraintSet2;
            this.f4489a = new ConstraintWidgetContainer();
            this.f4490b = new ConstraintWidgetContainer();
            this.f4489a.U2(MotionLayout.this.Y2.G2());
            this.f4490b.U2(MotionLayout.this.Y2.G2());
            this.f4489a.p2();
            this.f4490b.p2();
            c(MotionLayout.this.Y2, this.f4489a);
            c(MotionLayout.this.Y2, this.f4490b);
            if (((double) MotionLayout.this.S3) > 0.5d) {
                if (constraintSet != null) {
                    m(this.f4489a, constraintSet);
                }
                m(this.f4490b, constraintSet2);
            } else {
                m(this.f4490b, constraintSet2);
                if (constraintSet != null) {
                    m(this.f4489a, constraintSet);
                }
            }
            this.f4489a.Y2(MotionLayout.this.w());
            this.f4489a.a3();
            this.f4490b.Y2(MotionLayout.this.w());
            this.f4490b.a3();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f4489a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.D1(dimensionBehaviour);
                    this.f4490b.D1(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.f4489a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.Y1(dimensionBehaviour2);
                    this.f4490b.Y1(dimensionBehaviour2);
                }
            }
        }

        public boolean i(int i2, int i3) {
            return (i2 == this.f4493e && i3 == this.f4494f) ? false : true;
        }

        public void j(int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.H4 = mode;
            motionLayout.I4 = mode2;
            motionLayout.getOptimizationLevel();
            b(i2, i3);
            if (!((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824)) {
                b(i2, i3);
                MotionLayout.this.D4 = this.f4489a.m0();
                MotionLayout.this.E4 = this.f4489a.D();
                MotionLayout.this.F4 = this.f4490b.m0();
                MotionLayout.this.G4 = this.f4490b.D();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.C4 = (motionLayout2.D4 == motionLayout2.F4 && motionLayout2.E4 == motionLayout2.G4) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i4 = motionLayout3.D4;
            int i5 = motionLayout3.E4;
            int i6 = motionLayout3.H4;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                i4 = (int) (((float) i4) + (motionLayout3.J4 * ((float) (motionLayout3.F4 - i4))));
            }
            int i7 = i4;
            int i8 = motionLayout3.I4;
            if (i8 == Integer.MIN_VALUE || i8 == 0) {
                i5 = (int) (((float) i5) + (motionLayout3.J4 * ((float) (motionLayout3.G4 - i5))));
            }
            MotionLayout.this.A(i2, i3, i7, i5, this.f4489a.P2() || this.f4490b.P2(), this.f4489a.N2() || this.f4490b.N2());
        }

        public void k() {
            j(MotionLayout.this.L3, MotionLayout.this.M3);
            MotionLayout.this.Z0();
        }

        public void l(int i2, int i3) {
            this.f4493e = i2;
            this.f4494f = i3;
        }
    }

    protected interface MotionTracker {
        void a(int i2, float f2);

        float b(int i2);

        float c(int i2);

        void clear();

        void d(MotionEvent motionEvent);

        float e();

        float f();

        void g(int i2);

        void recycle();
    }

    private static class MyTracker implements MotionTracker {

        /* renamed from: b  reason: collision with root package name */
        private static MyTracker f4496b = new MyTracker();

        /* renamed from: a  reason: collision with root package name */
        VelocityTracker f4497a;

        private MyTracker() {
        }

        public static MyTracker h() {
            f4496b.f4497a = VelocityTracker.obtain();
            return f4496b;
        }

        public void a(int i2, float f2) {
            VelocityTracker velocityTracker = this.f4497a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i2, f2);
            }
        }

        public float b(int i2) {
            VelocityTracker velocityTracker = this.f4497a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity(i2);
            }
            return 0.0f;
        }

        public float c(int i2) {
            if (this.f4497a != null) {
                return c(i2);
            }
            return 0.0f;
        }

        public void clear() {
            VelocityTracker velocityTracker = this.f4497a;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        public void d(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f4497a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        public float e() {
            VelocityTracker velocityTracker = this.f4497a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        public float f() {
            VelocityTracker velocityTracker = this.f4497a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        public void g(int i2) {
            VelocityTracker velocityTracker = this.f4497a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i2);
            }
        }

        public void recycle() {
            VelocityTracker velocityTracker = this.f4497a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f4497a = null;
            }
        }
    }

    class StateCache {

        /* renamed from: a  reason: collision with root package name */
        float f4498a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f4499b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        int f4500c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f4501d = -1;

        /* renamed from: e  reason: collision with root package name */
        final String f4502e = "motion.progress";

        /* renamed from: f  reason: collision with root package name */
        final String f4503f = "motion.velocity";

        /* renamed from: g  reason: collision with root package name */
        final String f4504g = "motion.StartState";

        /* renamed from: h  reason: collision with root package name */
        final String f4505h = "motion.EndState";

        StateCache() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i2 = this.f4500c;
            if (!(i2 == -1 && this.f4501d == -1)) {
                if (i2 == -1) {
                    MotionLayout.this.g1(this.f4501d);
                } else {
                    int i3 = this.f4501d;
                    if (i3 == -1) {
                        MotionLayout.this.F(i2, -1, -1);
                    } else {
                        MotionLayout.this.Y0(i2, i3);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (!Float.isNaN(this.f4499b)) {
                MotionLayout.this.X0(this.f4498a, this.f4499b);
                this.f4498a = Float.NaN;
                this.f4499b = Float.NaN;
                this.f4500c = -1;
                this.f4501d = -1;
            } else if (!Float.isNaN(this.f4498a)) {
                MotionLayout.this.setProgress(this.f4498a);
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f4498a);
            bundle.putFloat("motion.velocity", this.f4499b);
            bundle.putInt("motion.StartState", this.f4500c);
            bundle.putInt("motion.EndState", this.f4501d);
            return bundle;
        }

        public void c() {
            this.f4501d = MotionLayout.this.K3;
            this.f4500c = MotionLayout.this.I3;
            this.f4499b = MotionLayout.this.getVelocity();
            this.f4498a = MotionLayout.this.getProgress();
        }

        public void d(int i2) {
            this.f4501d = i2;
        }

        public void e(float f2) {
            this.f4498a = f2;
        }

        public void f(int i2) {
            this.f4500c = i2;
        }

        public void g(Bundle bundle) {
            this.f4498a = bundle.getFloat("motion.progress");
            this.f4499b = bundle.getFloat("motion.velocity");
            this.f4500c = bundle.getInt("motion.StartState");
            this.f4501d = bundle.getInt("motion.EndState");
        }

        public void h(float f2) {
            this.f4499b = f2;
        }
    }

    public interface TransitionListener {
        void a(MotionLayout motionLayout, int i2, int i3, float f2);

        void c(MotionLayout motionLayout, int i2, int i3);

        void d(MotionLayout motionLayout, int i2, boolean z, float f2);

        void k(MotionLayout motionLayout, int i2);
    }

    enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        I0((AttributeSet) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean H0(float r8, float r9, android.view.View r10, android.view.MotionEvent r11) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof android.view.ViewGroup
            r1 = 1
            if (r0 == 0) goto L_0x0036
            r0 = r10
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r0.getChildCount()
            int r2 = r2 - r1
        L_0x000d:
            if (r2 < 0) goto L_0x0036
            android.view.View r3 = r0.getChildAt(r2)
            int r4 = r3.getLeft()
            float r4 = (float) r4
            float r4 = r4 + r8
            int r5 = r10.getScrollX()
            float r5 = (float) r5
            float r4 = r4 - r5
            int r5 = r3.getTop()
            float r5 = (float) r5
            float r5 = r5 + r9
            int r6 = r10.getScrollY()
            float r6 = (float) r6
            float r5 = r5 - r6
            boolean r3 = r7.H0(r4, r5, r3, r11)
            if (r3 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0037
        L_0x0033:
            int r2 = r2 + -1
            goto L_0x000d
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 != 0) goto L_0x0075
            android.graphics.RectF r2 = r7.b5
            int r3 = r10.getRight()
            float r3 = (float) r3
            float r3 = r3 + r8
            int r4 = r10.getLeft()
            float r4 = (float) r4
            float r3 = r3 - r4
            int r4 = r10.getBottom()
            float r4 = (float) r4
            float r4 = r4 + r9
            int r5 = r10.getTop()
            float r5 = (float) r5
            float r4 = r4 - r5
            r2.set(r8, r9, r3, r4)
            int r2 = r11.getAction()
            if (r2 != 0) goto L_0x006c
            android.graphics.RectF r2 = r7.b5
            float r3 = r11.getX()
            float r4 = r11.getY()
            boolean r2 = r2.contains(r3, r4)
            if (r2 == 0) goto L_0x0075
        L_0x006c:
            float r8 = -r8
            float r9 = -r9
            boolean r8 = r7.j0(r10, r11, r8, r9)
            if (r8 == 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r1 = r0
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.H0(float, float, android.view.View, android.view.MotionEvent):boolean");
    }

    private void I0(AttributeSet attributeSet) {
        MotionScene motionScene;
        int i2;
        p5 = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.jk);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.mk) {
                    this.E3 = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.lk) {
                    this.J3 = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.ok) {
                    this.U3 = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.W3 = true;
                } else if (index == R.styleable.kk) {
                    z = obtainStyledAttributes.getBoolean(index, z);
                } else {
                    if (index == R.styleable.pk) {
                        if (this.b4 == 0) {
                            i2 = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                        }
                    } else if (index == R.styleable.nk) {
                        i2 = obtainStyledAttributes.getInt(index, 0);
                    }
                    this.b4 = i2;
                }
            }
            obtainStyledAttributes.recycle();
            if (this.E3 == null) {
                Log.e(n5, "WARNING NO app:layoutDescription tag");
            }
            if (!z) {
                this.E3 = null;
            }
        }
        if (this.b4 != 0) {
            k0();
        }
        if (this.J3 == -1 && (motionScene = this.E3) != null) {
            this.J3 = motionScene.N();
            this.I3 = this.E3.N();
            this.K3 = this.E3.u();
        }
    }

    private void R0() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if (this.Y3 != null || ((copyOnWriteArrayList = this.v4) != null && !copyOnWriteArrayList.isEmpty())) {
            this.B4 = false;
            Iterator<Integer> it2 = this.e5.iterator();
            while (it2.hasNext()) {
                Integer next = it2.next();
                TransitionListener transitionListener = this.Y3;
                if (transitionListener != null) {
                    transitionListener.k(this, next.intValue());
                }
                CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.v4;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<TransitionListener> it3 = copyOnWriteArrayList2.iterator();
                    while (it3.hasNext()) {
                        it3.next().k(this, next.intValue());
                    }
                }
            }
            this.e5.clear();
        }
    }

    /* access modifiers changed from: private */
    public void Z0() {
        int childCount = getChildCount();
        this.Z4.a();
        boolean z = true;
        this.W3 = true;
        SparseArray sparseArray = new SparseArray();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            sparseArray.put(childAt.getId(), this.O3.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int m2 = this.E3.m();
        if (m2 != -1) {
            for (int i6 = 0; i6 < childCount; i6++) {
                MotionController motionController = this.O3.get(getChildAt(i6));
                if (motionController != null) {
                    motionController.U(m2);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.O3.size()];
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            MotionController motionController2 = this.O3.get(getChildAt(i8));
            if (motionController2.k() != -1) {
                sparseBooleanArray.put(motionController2.k(), true);
                iArr[i7] = motionController2.k();
                i7++;
            }
        }
        if (this.u4 != null) {
            for (int i9 = 0; i9 < i7; i9++) {
                MotionController motionController3 = this.O3.get(findViewById(iArr[i9]));
                if (motionController3 != null) {
                    this.E3.z(motionController3);
                }
            }
            Iterator<MotionHelper> it2 = this.u4.iterator();
            while (it2.hasNext()) {
                it2.next().g(this, this.O3);
            }
            for (int i10 = 0; i10 < i7; i10++) {
                MotionController motionController4 = this.O3.get(findViewById(iArr[i10]));
                if (motionController4 != null) {
                    motionController4.a0(width, height, this.Q3, getNanoTime());
                }
            }
        } else {
            for (int i11 = 0; i11 < i7; i11++) {
                MotionController motionController5 = this.O3.get(findViewById(iArr[i11]));
                if (motionController5 != null) {
                    this.E3.z(motionController5);
                    motionController5.a0(width, height, this.Q3, getNanoTime());
                }
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            MotionController motionController6 = this.O3.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                this.E3.z(motionController6);
                motionController6.a0(width, height, this.Q3, getNanoTime());
            }
        }
        float M = this.E3.M();
        if (M != 0.0f) {
            if (((double) M) >= 0.0d) {
                z = false;
            }
            float abs = Math.abs(M);
            float f2 = -3.4028235E38f;
            float f3 = Float.MAX_VALUE;
            float f6 = Float.MAX_VALUE;
            float f7 = -3.4028235E38f;
            for (int i13 = 0; i13 < childCount; i13++) {
                MotionController motionController7 = this.O3.get(getChildAt(i13));
                if (!Float.isNaN(motionController7.f4467m)) {
                    for (int i14 = 0; i14 < childCount; i14++) {
                        MotionController motionController8 = this.O3.get(getChildAt(i14));
                        if (!Float.isNaN(motionController8.f4467m)) {
                            f3 = Math.min(f3, motionController8.f4467m);
                            f2 = Math.max(f2, motionController8.f4467m);
                        }
                    }
                    while (i2 < childCount) {
                        MotionController motionController9 = this.O3.get(getChildAt(i2));
                        if (!Float.isNaN(motionController9.f4467m)) {
                            motionController9.o = 1.0f / (1.0f - abs);
                            float f8 = motionController9.f4467m;
                            motionController9.f4468n = abs - (z ? ((f2 - f8) / (f2 - f3)) * abs : ((f8 - f3) * abs) / (f2 - f3));
                        }
                        i2++;
                    }
                    return;
                }
                float t = motionController7.t();
                float u = motionController7.u();
                float f9 = z ? u - t : u + t;
                f6 = Math.min(f6, f9);
                f7 = Math.max(f7, f9);
            }
            while (i2 < childCount) {
                MotionController motionController10 = this.O3.get(getChildAt(i2));
                float t2 = motionController10.t();
                float u2 = motionController10.u();
                float f10 = z ? u2 - t2 : u2 + t2;
                motionController10.o = 1.0f / (1.0f - abs);
                motionController10.f4468n = abs - (((f10 - f6) * abs) / (f7 - f6));
                i2++;
            }
        }
    }

    /* access modifiers changed from: private */
    public Rect a1(ConstraintWidget constraintWidget) {
        this.W4.top = constraintWidget.p0();
        this.W4.left = constraintWidget.o0();
        Rect rect = this.W4;
        int m0 = constraintWidget.m0();
        Rect rect2 = this.W4;
        rect.right = m0 + rect2.left;
        int D = constraintWidget.D();
        Rect rect3 = this.W4;
        rect2.bottom = D + rect3.top;
        return rect3;
    }

    private boolean j0(View view, MotionEvent motionEvent, float f2, float f3) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f2, f3);
            boolean onTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f2, -f3);
            return onTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f2, f3);
        if (this.d5 == null) {
            this.d5 = new Matrix();
        }
        matrix.invert(this.d5);
        obtain.transform(this.d5);
        boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }

    private void k0() {
        MotionScene motionScene = this.E3;
        if (motionScene == null) {
            Log.e(n5, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int N = motionScene.N();
        MotionScene motionScene2 = this.E3;
        l0(N, motionScene2.o(motionScene2.N()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<MotionScene.Transition> it2 = this.E3.s().iterator();
        while (it2.hasNext()) {
            MotionScene.Transition next = it2.next();
            if (next == this.E3.f4509c) {
                Log.v(n5, "CHECK: CURRENT");
            }
            m0(next);
            int I = next.I();
            int B = next.B();
            String i2 = Debug.i(getContext(), I);
            String i3 = Debug.i(getContext(), B);
            if (sparseIntArray.get(I) == B) {
                Log.e(n5, "CHECK: two transitions with the same start and end " + i2 + "->" + i3);
            }
            if (sparseIntArray2.get(B) == I) {
                Log.e(n5, "CHECK: you can't have reverse transitions" + i2 + "->" + i3);
            }
            sparseIntArray.put(I, B);
            sparseIntArray2.put(B, I);
            if (this.E3.o(I) == null) {
                Log.e(n5, " no such constraintSetStart " + i2);
            }
            if (this.E3.o(B) == null) {
                Log.e(n5, " no such constraintSetEnd " + i2);
            }
        }
    }

    private void l0(int i2, ConstraintSet constraintSet) {
        String i3 = Debug.i(getContext(), i2);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int id = childAt.getId();
            if (id == -1) {
                Log.w(n5, "CHECK: " + i3 + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (constraintSet.k0(id) == null) {
                Log.w(n5, "CHECK: " + i3 + " NO CONSTRAINTS for " + Debug.k(childAt));
            }
        }
        int[] o0 = constraintSet.o0();
        for (int i7 = 0; i7 < o0.length; i7++) {
            int i8 = o0[i7];
            String i9 = Debug.i(getContext(), i8);
            if (findViewById(o0[i7]) == null) {
                Log.w(n5, "CHECK: " + i3 + " NO View matches id " + i9);
            }
            if (constraintSet.n0(i8) == -1) {
                Log.w(n5, "CHECK: " + i3 + "(" + i9 + ") no LAYOUT_HEIGHT");
            }
            if (constraintSet.u0(i8) == -1) {
                Log.w(n5, "CHECK: " + i3 + "(" + i9 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    private void m0(MotionScene.Transition transition) {
        if (transition.I() == transition.B()) {
            Log.e(n5, "CHECK: start and end constraint set should not be the same!");
        }
    }

    private void o0() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            MotionController motionController = this.O3.get(childAt);
            if (motionController != null) {
                motionController.V(childAt);
            }
        }
    }

    private static boolean o1(float f2, float f3, float f6) {
        if (f2 > 0.0f) {
            float f7 = f2 / f6;
            return f3 + ((f2 * f7) - (((f6 * f7) * f7) / 2.0f)) > 1.0f;
        }
        float f8 = (-f2) / f6;
        return f3 + ((f2 * f8) + (((f6 * f8) * f8) / 2.0f)) < 0.0f;
    }

    @SuppressLint({"LogConditional"})
    private void p0() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            Log.v(n5, StringUtils.SPACE + Debug.g() + StringUtils.SPACE + Debug.k(this) + StringUtils.SPACE + Debug.i(getContext(), this.J3) + StringUtils.SPACE + Debug.k(childAt) + childAt.getLeft() + StringUtils.SPACE + childAt.getTop());
        }
    }

    private void v0() {
        boolean z;
        float signum = Math.signum(this.U3 - this.S3);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.F3;
        float f2 = this.S3 + (!(interpolator instanceof StopLogic) ? ((((float) (nanoTime - this.T3)) * signum) * 1.0E-9f) / this.Q3 : 0.0f);
        if (this.V3) {
            f2 = this.U3;
        }
        int i2 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
        if ((i2 <= 0 || f2 < this.U3) && (signum > 0.0f || f2 > this.U3)) {
            z = false;
        } else {
            f2 = this.U3;
            z = true;
        }
        if (interpolator != null && !z) {
            f2 = this.d4 ? interpolator.getInterpolation(((float) (nanoTime - this.P3)) * 1.0E-9f) : interpolator.getInterpolation(f2);
        }
        if ((i2 > 0 && f2 >= this.U3) || (signum <= 0.0f && f2 <= this.U3)) {
            f2 = this.U3;
        }
        this.J4 = f2;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.G3;
        if (interpolator2 != null) {
            f2 = interpolator2.getInterpolation(f2);
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            MotionController motionController = this.O3.get(childAt);
            if (motionController != null) {
                motionController.L(childAt, f2, nanoTime2, this.K4);
            }
        }
        if (this.C4) {
            requestLayout();
        }
    }

    private void w0() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.Y3 != null || ((copyOnWriteArrayList = this.v4) != null && !copyOnWriteArrayList.isEmpty())) && this.A4 != this.R3) {
            if (this.z4 != -1) {
                TransitionListener transitionListener = this.Y3;
                if (transitionListener != null) {
                    transitionListener.c(this, this.I3, this.K3);
                }
                CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.v4;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<TransitionListener> it2 = copyOnWriteArrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().c(this, this.I3, this.K3);
                    }
                }
                this.B4 = true;
            }
            this.z4 = -1;
            float f2 = this.R3;
            this.A4 = f2;
            TransitionListener transitionListener2 = this.Y3;
            if (transitionListener2 != null) {
                transitionListener2.a(this, this.I3, this.K3, f2);
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList3 = this.v4;
            if (copyOnWriteArrayList3 != null) {
                Iterator<TransitionListener> it3 = copyOnWriteArrayList3.iterator();
                while (it3.hasNext()) {
                    it3.next().a(this, this.I3, this.K3, this.R3);
                }
            }
            this.B4 = true;
        }
    }

    private void y0(MotionLayout motionLayout, int i2, int i3) {
        TransitionListener transitionListener = this.Y3;
        if (transitionListener != null) {
            transitionListener.c(this, i2, i3);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.v4;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                it2.next().c(motionLayout, i2, i3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void A0(int i2, float f2, float f3, float f6, float[] fArr) {
        String str;
        HashMap<View, MotionController> hashMap = this.O3;
        View o = o(i2);
        MotionController motionController = hashMap.get(o);
        if (motionController != null) {
            motionController.p(f2, f3, f6, fArr);
            float y = o.getY();
            this.Z3 = f2;
            this.a4 = y;
            return;
        }
        if (o == null) {
            str = "" + i2;
        } else {
            str = o.getContext().getResources().getResourceName(i2);
        }
        Log.w(n5, "WARNING could not find view id " + str);
    }

    public ConstraintSet B0(int i2) {
        MotionScene motionScene = this.E3;
        if (motionScene == null) {
            return null;
        }
        return motionScene.o(i2);
    }

    /* access modifiers changed from: package-private */
    public String C0(int i2) {
        MotionScene motionScene = this.E3;
        if (motionScene == null) {
            return null;
        }
        return motionScene.X(i2);
    }

    public void D0(boolean z) {
        this.b4 = z ? 2 : 1;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public MotionController E0(int i2) {
        return this.O3.get(findViewById(i2));
    }

    public void F(int i2, int i3, int i6) {
        setState(TransitionState.SETUP);
        this.J3 = i2;
        this.I3 = -1;
        this.K3 = -1;
        ConstraintLayoutStates constraintLayoutStates = this.g3;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.e(i2, (float) i3, (float) i6);
            return;
        }
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            motionScene.o(i2).r(this);
        }
    }

    public MotionScene.Transition F0(int i2) {
        return this.E3.O(i2);
    }

    public void G0(View view, float f2, float f3, float[] fArr, int i2) {
        float f6;
        float f7 = this.H3;
        float f8 = this.S3;
        if (this.F3 != null) {
            float signum = Math.signum(this.U3 - f8);
            float interpolation = this.F3.getInterpolation(this.S3 + y5);
            f6 = this.F3.getInterpolation(this.S3);
            f7 = (signum * ((interpolation - f6) / y5)) / this.Q3;
        } else {
            f6 = f8;
        }
        Interpolator interpolator = this.F3;
        if (interpolator instanceof MotionInterpolator) {
            f7 = ((MotionInterpolator) interpolator).a();
        }
        MotionController motionController = this.O3.get(view);
        if ((i2 & 1) == 0) {
            motionController.C(f6, view.getWidth(), view.getHeight(), f2, f3, fArr);
        } else {
            motionController.p(f6, f2, f3, fArr);
        }
        if (i2 < 2) {
            fArr[0] = fArr[0] * f7;
            fArr[1] = fArr[1] * f7;
        }
    }

    public boolean J0() {
        return this.X4;
    }

    public boolean K0() {
        return this.Q4;
    }

    public boolean L0() {
        return this.N3;
    }

    public boolean M0(int i2) {
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            return motionScene.U(i2);
        }
        return false;
    }

    public void N0(int i2) {
        float f2;
        if (!isAttachedToWindow()) {
            this.J3 = i2;
        }
        if (this.I3 == i2) {
            f2 = 0.0f;
        } else if (this.K3 == i2) {
            f2 = 1.0f;
        } else {
            Y0(i2, i2);
            return;
        }
        setProgress(f2);
    }

    /* access modifiers changed from: package-private */
    public int O0(String str) {
        MotionScene motionScene = this.E3;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.W(str);
    }

    /* access modifiers changed from: protected */
    public MotionTracker P0() {
        return MyTracker.h();
    }

    /* access modifiers changed from: package-private */
    public void Q0() {
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            if (motionScene.i(this, this.J3)) {
                requestLayout();
                return;
            }
            int i2 = this.J3;
            if (i2 != -1) {
                this.E3.f(this, i2);
            }
            if (this.E3.r0()) {
                this.E3.p0();
            }
        }
    }

    @Deprecated
    public void S0() {
        Log.e(n5, "This method is deprecated. Please call rebuildScene() instead.");
        T0();
    }

    public void T0() {
        this.Z4.k();
        invalidate();
    }

    public boolean U0(TransitionListener transitionListener) {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.v4;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(transitionListener);
    }

    @RequiresApi(api = 17)
    public void V0(int i2, int i3) {
        int i6 = 1;
        this.Q4 = true;
        this.T4 = getWidth();
        this.U4 = getHeight();
        int rotation = getDisplay().getRotation();
        if ((rotation + 1) % 4 <= (this.V4 + 1) % 4) {
            i6 = 2;
        }
        this.R4 = i6;
        this.V4 = rotation;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            ViewState viewState = this.S4.get(childAt);
            if (viewState == null) {
                viewState = new ViewState();
                this.S4.put(childAt, viewState);
            }
            viewState.a(childAt);
        }
        this.I3 = -1;
        this.K3 = i2;
        this.E3.n0(-1, i2);
        this.Z4.h(this.Y2, (ConstraintSet) null, this.E3.o(this.K3));
        this.R3 = 0.0f;
        this.S3 = 0.0f;
        invalidate();
        e1(new Runnable() {
            public void run() {
                boolean unused = MotionLayout.this.Q4 = false;
            }
        });
        if (i3 > 0) {
            this.Q3 = ((float) i3) / 1000.0f;
        }
    }

    public void W0(int i2) {
        if (getCurrentState() == -1) {
            g1(i2);
            return;
        }
        int[] iArr = this.O4;
        if (iArr == null) {
            this.O4 = new int[4];
        } else if (iArr.length <= this.P4) {
            this.O4 = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.O4;
        int i3 = this.P4;
        this.P4 = i3 + 1;
        iArr2[i3] = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (r3 > 0.5f) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r4 > 0) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void X0(float r3, float r4) {
        /*
            r2 = this;
            boolean r0 = r2.isAttachedToWindow()
            if (r0 != 0) goto L_0x001c
            androidx.constraintlayout.motion.widget.MotionLayout$StateCache r0 = r2.M4
            if (r0 != 0) goto L_0x0011
            androidx.constraintlayout.motion.widget.MotionLayout$StateCache r0 = new androidx.constraintlayout.motion.widget.MotionLayout$StateCache
            r0.<init>()
            r2.M4 = r0
        L_0x0011:
            androidx.constraintlayout.motion.widget.MotionLayout$StateCache r0 = r2.M4
            r0.e(r3)
            androidx.constraintlayout.motion.widget.MotionLayout$StateCache r3 = r2.M4
            r3.h(r4)
            return
        L_0x001c:
            r2.setProgress(r3)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
            r2.setState(r0)
            r2.H3 = r4
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0035
            if (r4 <= 0) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            r2.h0(r0)
            goto L_0x0044
        L_0x0035:
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0044
            int r4 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r4 == 0) goto L_0x0044
            r4 = 1056964608(0x3f000000, float:0.5)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0030
            goto L_0x0031
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.X0(float, float):void");
    }

    public void Y0(int i2, int i3) {
        if (!isAttachedToWindow()) {
            if (this.M4 == null) {
                this.M4 = new StateCache();
            }
            this.M4.f(i2);
            this.M4.d(i3);
            return;
        }
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            this.I3 = i2;
            this.K3 = i3;
            motionScene.n0(i2, i3);
            this.Z4.h(this.Y2, this.E3.o(i2), this.E3.o(i3));
            T0();
            this.S3 = 0.0f;
            f1();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        if (r10 != 7) goto L_0x00cf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b1(int r10, float r11, float r12) {
        /*
            r9 = this;
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.E3
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            float r0 = r9.S3
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            r0 = 1
            r9.d4 = r0
            long r1 = r9.getNanoTime()
            r9.P3 = r1
            androidx.constraintlayout.motion.widget.MotionScene r1 = r9.E3
            int r1 = r1.t()
            float r1 = (float) r1
            r2 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r2
            r9.Q3 = r1
            r9.U3 = r11
            r9.W3 = r0
            r1 = 0
            r2 = 7
            r3 = 6
            r4 = 2
            if (r10 == 0) goto L_0x007e
            if (r10 == r0) goto L_0x007e
            if (r10 == r4) goto L_0x007e
            r5 = 4
            if (r10 == r5) goto L_0x0049
            r5 = 5
            if (r10 == r5) goto L_0x003b
            if (r10 == r3) goto L_0x007e
            if (r10 == r2) goto L_0x007e
            goto L_0x00cf
        L_0x003b:
            float r10 = r9.S3
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.E3
            float r0 = r0.B()
            boolean r10 = o1(r12, r10, r0)
            if (r10 == 0) goto L_0x005c
        L_0x0049:
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.f4
            float r11 = r9.S3
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.E3
            float r0 = r0.B()
            r10.b(r12, r11, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.f4
        L_0x0058:
            r9.F3 = r10
            goto L_0x00cf
        L_0x005c:
            androidx.constraintlayout.motion.utils.StopLogic r2 = r9.e4
            float r3 = r9.S3
            float r6 = r9.Q3
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.E3
            float r7 = r10.B()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.E3
            float r8 = r10.C()
            r4 = r11
            r5 = r12
            r2.b(r3, r4, r5, r6, r7, r8)
            r9.H3 = r1
        L_0x0075:
            int r10 = r9.J3
            r9.U3 = r11
            r9.J3 = r10
            androidx.constraintlayout.motion.utils.StopLogic r10 = r9.e4
            goto L_0x0058
        L_0x007e:
            if (r10 == r0) goto L_0x008a
            if (r10 != r2) goto L_0x0083
            goto L_0x008a
        L_0x0083:
            if (r10 == r4) goto L_0x0087
            if (r10 != r3) goto L_0x008b
        L_0x0087:
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x008b
        L_0x008a:
            r11 = 0
        L_0x008b:
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.E3
            int r10 = r10.n()
            androidx.constraintlayout.motion.utils.StopLogic r0 = r9.e4
            float r1 = r9.S3
            if (r10 != 0) goto L_0x00ab
            float r4 = r9.Q3
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.E3
            float r5 = r10.B()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.E3
            float r6 = r10.C()
            r2 = r11
            r3 = r12
            r0.b(r1, r2, r3, r4, r5, r6)
            goto L_0x0075
        L_0x00ab:
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.E3
            float r4 = r10.J()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.E3
            float r5 = r10.K()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.E3
            float r6 = r10.I()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.E3
            float r7 = r10.L()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.E3
            int r8 = r10.H()
            r2 = r11
            r3 = r12
            r0.f(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0075
        L_0x00cf:
            r10 = 0
            r9.V3 = r10
            long r10 = r9.getNanoTime()
            r9.P3 = r10
            r9.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.b1(int, float, float):void");
    }

    public void c1(float f2, float f3) {
        if (this.E3 != null && this.S3 != f2) {
            this.d4 = true;
            this.P3 = getNanoTime();
            this.Q3 = ((float) this.E3.t()) / 1000.0f;
            this.U3 = f2;
            this.W3 = true;
            this.e4.f(this.S3, f2, f3, this.E3.J(), this.E3.K(), this.E3.I(), this.E3.L(), this.E3.H());
            int i2 = this.J3;
            this.U3 = f2;
            this.J3 = i2;
            this.F3 = this.e4;
            this.V3 = false;
            this.P3 = getNanoTime();
            invalidate();
        }
    }

    public void d1() {
        h0(1.0f);
        this.N4 = null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchDraw(android.graphics.Canvas r10) {
        /*
            r9 = this;
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> r0 = r9.u4
            if (r0 == 0) goto L_0x0018
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0018
            java.lang.Object r1 = r0.next()
            androidx.constraintlayout.motion.widget.MotionHelper r1 = (androidx.constraintlayout.motion.widget.MotionHelper) r1
            r1.h(r10)
            goto L_0x0008
        L_0x0018:
            r0 = 0
            r9.u0(r0)
            androidx.constraintlayout.motion.widget.MotionScene r1 = r9.E3
            if (r1 == 0) goto L_0x0027
            androidx.constraintlayout.motion.widget.ViewTransitionController r1 = r1.s
            if (r1 == 0) goto L_0x0027
            r1.d()
        L_0x0027:
            super.dispatchDraw(r10)
            androidx.constraintlayout.motion.widget.MotionScene r1 = r9.E3
            if (r1 != 0) goto L_0x002f
            return
        L_0x002f:
            int r1 = r9.b4
            r2 = 1
            r1 = r1 & r2
            if (r1 != r2) goto L_0x00f6
            boolean r1 = r9.isInEditMode()
            if (r1 != 0) goto L_0x00f6
            int r1 = r9.w4
            int r1 = r1 + r2
            r9.w4 = r1
            long r3 = r9.getNanoTime()
            long r5 = r9.x4
            r7 = -1
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x006a
            long r5 = r3 - r5
            r7 = 200000000(0xbebc200, double:9.8813129E-316)
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x006c
            int r1 = r9.w4
            float r1 = (float) r1
            float r5 = (float) r5
            r6 = 814313567(0x3089705f, float:1.0E-9)
            float r5 = r5 * r6
            float r1 = r1 / r5
            r5 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 * r5
            int r1 = (int) r1
            float r1 = (float) r1
            float r1 = r1 / r5
            r9.y4 = r1
            r9.w4 = r0
        L_0x006a:
            r9.x4 = r3
        L_0x006c:
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r1 = 1109917696(0x42280000, float:42.0)
            r0.setTextSize(r1)
            float r1 = r9.getProgress()
            r3 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 * r3
            int r1 = (int) r1
            float r1 = (float) r1
            r3 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            float r5 = r9.y4
            r4.append(r5)
            java.lang.String r5 = " fps "
            r4.append(r5)
            int r5 = r9.I3
            java.lang.String r5 = androidx.constraintlayout.motion.widget.Debug.l(r9, r5)
            r4.append(r5)
            java.lang.String r5 = " -> "
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            int r4 = r9.K3
            java.lang.String r4 = androidx.constraintlayout.motion.widget.Debug.l(r9, r4)
            r5.append(r4)
            java.lang.String r4 = " (progress: "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = " ) state="
            r5.append(r1)
            int r1 = r9.J3
            r4 = -1
            if (r1 != r4) goto L_0x00ca
            java.lang.String r1 = "undefined"
            goto L_0x00ce
        L_0x00ca:
            java.lang.String r1 = androidx.constraintlayout.motion.widget.Debug.l(r9, r1)
        L_0x00ce:
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.setColor(r4)
            int r4 = r9.getHeight()
            int r4 = r4 + -29
            float r4 = (float) r4
            r5 = 1093664768(0x41300000, float:11.0)
            r10.drawText(r1, r5, r4, r0)
            r4 = -7864184(0xffffffffff880088, float:NaN)
            r0.setColor(r4)
            int r4 = r9.getHeight()
            int r4 = r4 + -30
            float r4 = (float) r4
            r10.drawText(r1, r3, r4, r0)
        L_0x00f6:
            int r0 = r9.b4
            if (r0 <= r2) goto L_0x0114
            androidx.constraintlayout.motion.widget.MotionLayout$DevModeDraw r0 = r9.c4
            if (r0 != 0) goto L_0x0105
            androidx.constraintlayout.motion.widget.MotionLayout$DevModeDraw r0 = new androidx.constraintlayout.motion.widget.MotionLayout$DevModeDraw
            r0.<init>()
            r9.c4 = r0
        L_0x0105:
            androidx.constraintlayout.motion.widget.MotionLayout$DevModeDraw r0 = r9.c4
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r1 = r9.O3
            androidx.constraintlayout.motion.widget.MotionScene r2 = r9.E3
            int r2 = r2.t()
            int r3 = r9.b4
            r0.a(r10, r1, r2, r3)
        L_0x0114:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> r0 = r9.u4
            if (r0 == 0) goto L_0x012c
            java.util.Iterator r0 = r0.iterator()
        L_0x011c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x012c
            java.lang.Object r1 = r0.next()
            androidx.constraintlayout.motion.widget.MotionHelper r1 = (androidx.constraintlayout.motion.widget.MotionHelper) r1
            r1.i(r10)
            goto L_0x011c
        L_0x012c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.dispatchDraw(android.graphics.Canvas):void");
    }

    public void e1(Runnable runnable) {
        h0(1.0f);
        this.N4 = runnable;
    }

    public void f1() {
        h0(0.0f);
    }

    public void g(@NonNull View view, int i2, int i3, int i6, int i7, int i8, int[] iArr) {
        if (!(!this.m4 && i2 == 0 && i3 == 0)) {
            iArr[0] = iArr[0] + i6;
            iArr[1] = iArr[1] + i7;
        }
        this.m4 = false;
    }

    public void g0(TransitionListener transitionListener) {
        if (this.v4 == null) {
            this.v4 = new CopyOnWriteArrayList<>();
        }
        this.v4.add(transitionListener);
    }

    public void g1(int i2) {
        if (!isAttachedToWindow()) {
            if (this.M4 == null) {
                this.M4 = new StateCache();
            }
            this.M4.d(i2);
            return;
        }
        i1(i2, -1, -1);
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.E3;
        if (motionScene == null) {
            return null;
        }
        return motionScene.r();
    }

    public int getCurrentState() {
        return this.J3;
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.E3;
        if (motionScene == null) {
            return null;
        }
        return motionScene.s();
    }

    public DesignTool getDesignTool() {
        if (this.g4 == null) {
            this.g4 = new DesignTool(this);
        }
        return this.g4;
    }

    public int getEndState() {
        return this.K3;
    }

    /* access modifiers changed from: protected */
    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.S3;
    }

    public MotionScene getScene() {
        return this.E3;
    }

    public int getStartState() {
        return this.I3;
    }

    public float getTargetPosition() {
        return this.U3;
    }

    public Bundle getTransitionState() {
        if (this.M4 == null) {
            this.M4 = new StateCache();
        }
        this.M4.c();
        return this.M4.b();
    }

    public long getTransitionTimeMs() {
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            this.Q3 = ((float) motionScene.t()) / 1000.0f;
        }
        return (long) (this.Q3 * 1000.0f);
    }

    public float getVelocity() {
        return this.H3;
    }

    /* access modifiers changed from: package-private */
    public void h0(float f2) {
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            float f3 = this.S3;
            float f6 = this.R3;
            if (f3 != f6 && this.V3) {
                this.S3 = f6;
            }
            float f7 = this.S3;
            if (f7 != f2) {
                this.d4 = false;
                this.U3 = f2;
                this.Q3 = ((float) motionScene.t()) / 1000.0f;
                setProgress(this.U3);
                this.F3 = null;
                this.G3 = this.E3.x();
                this.V3 = false;
                this.P3 = getNanoTime();
                this.W3 = true;
                this.R3 = f7;
                this.S3 = f7;
                invalidate();
            }
        }
    }

    public void h1(int i2, int i3) {
        if (!isAttachedToWindow()) {
            if (this.M4 == null) {
                this.M4 = new StateCache();
            }
            this.M4.d(i2);
            return;
        }
        j1(i2, -1, -1, i3);
    }

    public boolean i0(int i2, MotionController motionController) {
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            return motionScene.h(i2, motionController);
        }
        return false;
    }

    public void i1(int i2, int i3, int i6) {
        j1(i2, i3, i6, -1);
    }

    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
        if (r14 > 0) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j1(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            androidx.constraintlayout.motion.widget.MotionScene r0 = r10.E3
            r1 = -1
            if (r0 == 0) goto L_0x0014
            androidx.constraintlayout.widget.StateSet r0 = r0.f4508b
            if (r0 == 0) goto L_0x0014
            int r2 = r10.J3
            float r12 = (float) r12
            float r13 = (float) r13
            int r12 = r0.a(r2, r11, r12, r13)
            if (r12 == r1) goto L_0x0014
            r11 = r12
        L_0x0014:
            int r12 = r10.J3
            if (r12 != r11) goto L_0x0019
            return
        L_0x0019:
            int r13 = r10.I3
            r0 = 1148846080(0x447a0000, float:1000.0)
            r2 = 0
            if (r13 != r11) goto L_0x002a
            r10.h0(r2)
            if (r14 <= 0) goto L_0x0029
            float r11 = (float) r14
            float r11 = r11 / r0
            r10.Q3 = r11
        L_0x0029:
            return
        L_0x002a:
            int r13 = r10.K3
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r13 != r11) goto L_0x003a
            r10.h0(r3)
            if (r14 <= 0) goto L_0x0039
            float r11 = (float) r14
            float r11 = r11 / r0
            r10.Q3 = r11
        L_0x0039:
            return
        L_0x003a:
            r10.K3 = r11
            if (r12 == r1) goto L_0x0050
            r10.Y0(r12, r11)
            r10.h0(r3)
            r10.S3 = r2
            r10.d1()
            if (r14 <= 0) goto L_0x004f
            float r11 = (float) r14
            float r11 = r11 / r0
            r10.Q3 = r11
        L_0x004f:
            return
        L_0x0050:
            r12 = 0
            r10.d4 = r12
            r10.U3 = r3
            r10.R3 = r2
            r10.S3 = r2
            long r4 = r10.getNanoTime()
            r10.T3 = r4
            long r4 = r10.getNanoTime()
            r10.P3 = r4
            r10.V3 = r12
            r13 = 0
            r10.F3 = r13
            if (r14 != r1) goto L_0x0076
            androidx.constraintlayout.motion.widget.MotionScene r4 = r10.E3
            int r4 = r4.t()
            float r4 = (float) r4
            float r4 = r4 / r0
            r10.Q3 = r4
        L_0x0076:
            r10.I3 = r1
            androidx.constraintlayout.motion.widget.MotionScene r4 = r10.E3
            int r5 = r10.K3
            r4.n0(r1, r5)
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            if (r14 != 0) goto L_0x0091
            androidx.constraintlayout.motion.widget.MotionScene r14 = r10.E3
            int r14 = r14.t()
        L_0x008c:
            float r14 = (float) r14
            float r14 = r14 / r0
            r10.Q3 = r14
            goto L_0x0094
        L_0x0091:
            if (r14 <= 0) goto L_0x0094
            goto L_0x008c
        L_0x0094:
            int r14 = r10.getChildCount()
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r0 = r10.O3
            r0.clear()
            r0 = 0
        L_0x009e:
            if (r0 >= r14) goto L_0x00c0
            android.view.View r4 = r10.getChildAt(r0)
            androidx.constraintlayout.motion.widget.MotionController r5 = new androidx.constraintlayout.motion.widget.MotionController
            r5.<init>(r4)
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r6 = r10.O3
            r6.put(r4, r5)
            int r5 = r4.getId()
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r6 = r10.O3
            java.lang.Object r4 = r6.get(r4)
            androidx.constraintlayout.motion.widget.MotionController r4 = (androidx.constraintlayout.motion.widget.MotionController) r4
            r1.put(r5, r4)
            int r0 = r0 + 1
            goto L_0x009e
        L_0x00c0:
            r0 = 1
            r10.W3 = r0
            androidx.constraintlayout.motion.widget.MotionLayout$Model r1 = r10.Z4
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r10.Y2
            androidx.constraintlayout.motion.widget.MotionScene r5 = r10.E3
            androidx.constraintlayout.widget.ConstraintSet r11 = r5.o(r11)
            r1.h(r4, r13, r11)
            r10.T0()
            androidx.constraintlayout.motion.widget.MotionLayout$Model r11 = r10.Z4
            r11.a()
            r10.o0()
            int r11 = r10.getWidth()
            int r13 = r10.getHeight()
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> r1 = r10.u4
            if (r1 == 0) goto L_0x0139
            r1 = 0
        L_0x00e8:
            if (r1 >= r14) goto L_0x0101
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r4 = r10.O3
            android.view.View r5 = r10.getChildAt(r1)
            java.lang.Object r4 = r4.get(r5)
            androidx.constraintlayout.motion.widget.MotionController r4 = (androidx.constraintlayout.motion.widget.MotionController) r4
            if (r4 != 0) goto L_0x00f9
            goto L_0x00fe
        L_0x00f9:
            androidx.constraintlayout.motion.widget.MotionScene r5 = r10.E3
            r5.z(r4)
        L_0x00fe:
            int r1 = r1 + 1
            goto L_0x00e8
        L_0x0101:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> r1 = r10.u4
            java.util.Iterator r1 = r1.iterator()
        L_0x0107:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0119
            java.lang.Object r4 = r1.next()
            androidx.constraintlayout.motion.widget.MotionHelper r4 = (androidx.constraintlayout.motion.widget.MotionHelper) r4
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r5 = r10.O3
            r4.g(r10, r5)
            goto L_0x0107
        L_0x0119:
            r1 = 0
        L_0x011a:
            if (r1 >= r14) goto L_0x015e
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r4 = r10.O3
            android.view.View r5 = r10.getChildAt(r1)
            java.lang.Object r4 = r4.get(r5)
            androidx.constraintlayout.motion.widget.MotionController r4 = (androidx.constraintlayout.motion.widget.MotionController) r4
            if (r4 != 0) goto L_0x012b
            goto L_0x0136
        L_0x012b:
            float r7 = r10.Q3
            long r8 = r10.getNanoTime()
            r5 = r11
            r6 = r13
            r4.a0(r5, r6, r7, r8)
        L_0x0136:
            int r1 = r1 + 1
            goto L_0x011a
        L_0x0139:
            r1 = 0
        L_0x013a:
            if (r1 >= r14) goto L_0x015e
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r4 = r10.O3
            android.view.View r5 = r10.getChildAt(r1)
            java.lang.Object r4 = r4.get(r5)
            androidx.constraintlayout.motion.widget.MotionController r4 = (androidx.constraintlayout.motion.widget.MotionController) r4
            if (r4 != 0) goto L_0x014b
            goto L_0x015b
        L_0x014b:
            androidx.constraintlayout.motion.widget.MotionScene r5 = r10.E3
            r5.z(r4)
            float r7 = r10.Q3
            long r8 = r10.getNanoTime()
            r5 = r11
            r6 = r13
            r4.a0(r5, r6, r7, r8)
        L_0x015b:
            int r1 = r1 + 1
            goto L_0x013a
        L_0x015e:
            androidx.constraintlayout.motion.widget.MotionScene r11 = r10.E3
            float r11 = r11.M()
            int r13 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x01bb
            r13 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r1 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r4 = 0
        L_0x016f:
            if (r4 >= r14) goto L_0x0191
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r5 = r10.O3
            android.view.View r6 = r10.getChildAt(r4)
            java.lang.Object r5 = r5.get(r6)
            androidx.constraintlayout.motion.widget.MotionController r5 = (androidx.constraintlayout.motion.widget.MotionController) r5
            float r6 = r5.t()
            float r5 = r5.u()
            float r5 = r5 + r6
            float r13 = java.lang.Math.min(r13, r5)
            float r1 = java.lang.Math.max(r1, r5)
            int r4 = r4 + 1
            goto L_0x016f
        L_0x0191:
            if (r12 >= r14) goto L_0x01bb
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r4 = r10.O3
            android.view.View r5 = r10.getChildAt(r12)
            java.lang.Object r4 = r4.get(r5)
            androidx.constraintlayout.motion.widget.MotionController r4 = (androidx.constraintlayout.motion.widget.MotionController) r4
            float r5 = r4.t()
            float r6 = r4.u()
            float r7 = r3 - r11
            float r7 = r3 / r7
            r4.o = r7
            float r5 = r5 + r6
            float r5 = r5 - r13
            float r5 = r5 * r11
            float r6 = r1 - r13
            float r5 = r5 / r6
            float r5 = r11 - r5
            r4.f4468n = r5
            int r12 = r12 + 1
            goto L_0x0191
        L_0x01bb:
            r10.R3 = r2
            r10.S3 = r2
            r10.W3 = r0
            r10.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.j1(int, int, int, int):void");
    }

    public void k1() {
        this.Z4.h(this.Y2, this.E3.o(this.I3), this.E3.o(this.K3));
        T0();
    }

    public void l1(int i2, ConstraintSet constraintSet) {
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            motionScene.j0(i2, constraintSet);
        }
        k1();
        if (this.J3 == i2) {
            constraintSet.r(this);
        }
    }

    public void m1(int i2, ConstraintSet constraintSet, int i3) {
        if (this.E3 != null && this.J3 == i2) {
            int i6 = R.id.N3;
            l1(i6, B0(i2));
            F(i6, -1, -1);
            l1(i2, constraintSet);
            MotionScene.Transition transition = new MotionScene.Transition(-1, this.E3, i6, i2);
            transition.O(i3);
            setTransition(transition);
            d1();
        }
    }

    public ConstraintSet n0(int i2) {
        MotionScene motionScene = this.E3;
        if (motionScene == null) {
            return null;
        }
        ConstraintSet o = motionScene.o(i2);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.I(o);
        return constraintSet;
    }

    public void n1(int i2, View... viewArr) {
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            motionScene.t0(i2, viewArr);
        } else {
            Log.e(n5, " no motionScene");
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        MotionScene.Transition transition;
        int i2;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.V4 = display.getRotation();
        }
        MotionScene motionScene = this.E3;
        if (!(motionScene == null || (i2 = this.J3) == -1)) {
            ConstraintSet o = motionScene.o(i2);
            this.E3.h0(this);
            ArrayList<MotionHelper> arrayList = this.u4;
            if (arrayList != null) {
                Iterator<MotionHelper> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    it2.next().b(this);
                }
            }
            if (o != null) {
                o.r(this);
            }
            this.I3 = this.J3;
        }
        Q0();
        StateCache stateCache = this.M4;
        if (stateCache == null) {
            MotionScene motionScene2 = this.E3;
            if (motionScene2 != null && (transition = motionScene2.f4509c) != null && transition.z() == 4) {
                d1();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            }
        } else if (this.X4) {
            post(new Runnable() {
                public void run() {
                    MotionLayout.this.M4.a();
                }
            });
        } else {
            stateCache.a();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchResponse J;
        int s;
        RectF r;
        MotionScene motionScene = this.E3;
        if (motionScene != null && this.N3) {
            ViewTransitionController viewTransitionController = motionScene.s;
            if (viewTransitionController != null) {
                viewTransitionController.l(motionEvent);
            }
            MotionScene.Transition transition = this.E3.f4509c;
            if (transition != null && transition.K() && (J = transition.J()) != null && ((motionEvent.getAction() != 0 || (r = J.r(this, new RectF())) == null || r.contains(motionEvent.getX(), motionEvent.getY())) && (s = J.s()) != -1)) {
                View view = this.c5;
                if (view == null || view.getId() != s) {
                    this.c5 = findViewById(s);
                }
                View view2 = this.c5;
                if (view2 != null) {
                    this.b5.set((float) view2.getLeft(), (float) this.c5.getTop(), (float) this.c5.getRight(), (float) this.c5.getBottom());
                    if (this.b5.contains(motionEvent.getX(), motionEvent.getY()) && !H0((float) this.c5.getLeft(), (float) this.c5.getTop(), this.c5, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i6, int i7) {
        this.L4 = true;
        try {
            if (this.E3 == null) {
                super.onLayout(z, i2, i3, i6, i7);
                return;
            }
            int i8 = i6 - i2;
            int i9 = i7 - i3;
            if (!(this.k4 == i8 && this.l4 == i9)) {
                T0();
                u0(true);
            }
            this.k4 = i8;
            this.l4 = i9;
            this.i4 = i8;
            this.j4 = i9;
            this.L4 = false;
        } finally {
            this.L4 = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.E3 == null) {
            super.onMeasure(i2, i3);
            return;
        }
        boolean z = false;
        boolean z2 = (this.L3 == i2 && this.M3 == i3) ? false : true;
        if (this.a5) {
            this.a5 = false;
            Q0();
            R0();
            z2 = true;
        }
        if (this.d3) {
            z2 = true;
        }
        this.L3 = i2;
        this.M3 = i3;
        int N = this.E3.N();
        int u = this.E3.u();
        if ((z2 || this.Z4.i(N, u)) && this.I3 != -1) {
            super.onMeasure(i2, i3);
            this.Z4.h(this.Y2, this.E3.o(N), this.E3.o(u));
            this.Z4.k();
            this.Z4.l(N, u);
        } else {
            if (z2) {
                super.onMeasure(i2, i3);
            }
            z = true;
        }
        if (this.C4 || z) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int m0 = this.Y2.m0() + getPaddingLeft() + getPaddingRight();
            int D = this.Y2.D() + paddingTop;
            int i6 = this.H4;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                int i7 = this.D4;
                m0 = (int) (((float) i7) + (this.J4 * ((float) (this.F4 - i7))));
                requestLayout();
            }
            int i8 = this.I4;
            if (i8 == Integer.MIN_VALUE || i8 == 0) {
                int i9 = this.E4;
                D = (int) (((float) i9) + (this.J4 * ((float) (this.G4 - i9))));
                requestLayout();
            }
            setMeasuredDimension(m0, D);
        }
        v0();
    }

    public boolean onNestedFling(@NonNull View view, float f2, float f3, boolean z) {
        return false;
    }

    public boolean onNestedPreFling(@NonNull View view, float f2, float f3) {
        return false;
    }

    public void onRtlPropertiesChanged(int i2) {
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            motionScene.m0(w());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.E3;
        if (motionScene == null || !this.N3 || !motionScene.r0()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene.Transition transition = this.E3.f4509c;
        if (transition != null && !transition.K()) {
            return super.onTouchEvent(motionEvent);
        }
        this.E3.f0(motionEvent, getCurrentState(), this);
        if (this.E3.f4509c.L(4)) {
            return this.E3.f4509c.J().t();
        }
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.v4 == null) {
                this.v4 = new CopyOnWriteArrayList<>();
            }
            this.v4.add(motionHelper);
            if (motionHelper.e()) {
                if (this.s4 == null) {
                    this.s4 = new ArrayList<>();
                }
                this.s4.add(motionHelper);
            }
            if (motionHelper.f()) {
                if (this.t4 == null) {
                    this.t4 = new ArrayList<>();
                }
                this.t4.add(motionHelper);
            }
            if (motionHelper.j()) {
                if (this.u4 == null) {
                    this.u4 = new ArrayList<>();
                }
                this.u4.add(motionHelper);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.s4;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.t4;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void q(@NonNull View view, int i2, int i3, int i6, int i7, int i8) {
    }

    /* access modifiers changed from: package-private */
    public void q0(boolean z) {
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            motionScene.k(z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.f4509c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean r(@androidx.annotation.NonNull android.view.View r1, @androidx.annotation.NonNull android.view.View r2, int r3, int r4) {
        /*
            r0 = this;
            androidx.constraintlayout.motion.widget.MotionScene r1 = r0.E3
            if (r1 == 0) goto L_0x0021
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r1.f4509c
            if (r1 == 0) goto L_0x0021
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r1.J()
            if (r1 == 0) goto L_0x0021
            androidx.constraintlayout.motion.widget.MotionScene r1 = r0.E3
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r1.f4509c
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r1.J()
            int r1 = r1.f()
            r1 = r1 & 2
            if (r1 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r1 = 1
            return r1
        L_0x0021:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.r(android.view.View, android.view.View, int, int):boolean");
    }

    public void r0(int i2, boolean z) {
        boolean z2;
        MotionScene.Transition F0 = F0(i2);
        if (z) {
            z2 = true;
        } else {
            MotionScene motionScene = this.E3;
            if (F0 == motionScene.f4509c) {
                Iterator<MotionScene.Transition> it2 = motionScene.Q(this.J3).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    MotionScene.Transition next = it2.next();
                    if (next.K()) {
                        this.E3.f4509c = next;
                        break;
                    }
                }
            }
            z2 = false;
        }
        F0.Q(z2);
    }

    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (!this.C4 && this.J3 == -1 && (motionScene = this.E3) != null && (transition = motionScene.f4509c) != null) {
            int E = transition.E();
            if (E != 0) {
                if (E == 2) {
                    int childCount = getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        this.O3.get(getChildAt(i2)).P();
                    }
                    return;
                }
            } else {
                return;
            }
        }
        super.requestLayout();
    }

    public void s(@NonNull View view, @NonNull View view2, int i2, int i3) {
        this.p4 = getNanoTime();
        this.q4 = 0.0f;
        this.n4 = 0.0f;
        this.o4 = 0.0f;
    }

    public void s0(int i2, boolean z) {
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            motionScene.l(i2, z);
        }
    }

    public void setDebugMode(int i2) {
        this.b4 = i2;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.X4 = z;
    }

    public void setInteractionEnabled(boolean z) {
        this.N3 = z;
    }

    public void setInterpolatedProgress(float f2) {
        if (this.E3 != null) {
            setState(TransitionState.MOVING);
            Interpolator x = this.E3.x();
            if (x != null) {
                setProgress(x.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList<MotionHelper> arrayList = this.t4;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.t4.get(i2).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList<MotionHelper> arrayList = this.s4;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.s4.get(i2).setProgress(f2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r5.S3 == 0.0f) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        if (r5.S3 == 1.0f) goto L_0x0046;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProgress(float r6) {
        /*
            r5 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            int r2 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r2 < 0) goto L_0x000b
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0012
        L_0x000b:
            java.lang.String r3 = "MotionLayout"
            java.lang.String r4 = "Warning! Progress is defined for values between 0.0 and 1.0 inclusive"
            android.util.Log.w(r3, r4)
        L_0x0012:
            boolean r3 = r5.isAttachedToWindow()
            if (r3 != 0) goto L_0x0029
            androidx.constraintlayout.motion.widget.MotionLayout$StateCache r0 = r5.M4
            if (r0 != 0) goto L_0x0023
            androidx.constraintlayout.motion.widget.MotionLayout$StateCache r0 = new androidx.constraintlayout.motion.widget.MotionLayout$StateCache
            r0.<init>()
            r5.M4 = r0
        L_0x0023:
            androidx.constraintlayout.motion.widget.MotionLayout$StateCache r0 = r5.M4
            r0.e(r6)
            return
        L_0x0029:
            if (r2 > 0) goto L_0x004c
            float r2 = r5.S3
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x003c
            int r0 = r5.J3
            int r2 = r5.K3
            if (r0 != r2) goto L_0x003c
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
            r5.setState(r0)
        L_0x003c:
            int r0 = r5.I3
            r5.J3 = r0
            float r0 = r5.S3
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0072
        L_0x0046:
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
        L_0x0048:
            r5.setState(r0)
            goto L_0x0072
        L_0x004c:
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x006c
            float r2 = r5.S3
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0061
            int r1 = r5.J3
            int r2 = r5.I3
            if (r1 != r2) goto L_0x0061
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
            r5.setState(r1)
        L_0x0061:
            int r1 = r5.K3
            r5.J3 = r1
            float r1 = r5.S3
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0072
            goto L_0x0046
        L_0x006c:
            r0 = -1
            r5.J3 = r0
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
            goto L_0x0048
        L_0x0072:
            androidx.constraintlayout.motion.widget.MotionScene r0 = r5.E3
            if (r0 != 0) goto L_0x0077
            return
        L_0x0077:
            r0 = 1
            r5.V3 = r0
            r5.U3 = r6
            r5.R3 = r6
            r1 = -1
            r5.T3 = r1
            r5.P3 = r1
            r6 = 0
            r5.F3 = r6
            r5.W3 = r0
            r5.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.setProgress(float):void");
    }

    public void setScene(MotionScene motionScene) {
        this.E3 = motionScene;
        motionScene.m0(w());
        T0();
    }

    /* access modifiers changed from: package-private */
    public void setStartState(int i2) {
        if (!isAttachedToWindow()) {
            if (this.M4 == null) {
                this.M4 = new StateCache();
            }
            this.M4.f(i2);
            this.M4.d(i2);
            return;
        }
        this.J3 = i2;
    }

    /* access modifiers changed from: package-private */
    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState != transitionState2 || this.J3 != -1) {
            TransitionState transitionState3 = this.Y4;
            this.Y4 = transitionState;
            TransitionState transitionState4 = TransitionState.MOVING;
            if (transitionState3 == transitionState4 && transitionState == transitionState4) {
                w0();
            }
            int i2 = AnonymousClass5.f4470a[transitionState3.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (transitionState == transitionState4) {
                    w0();
                }
                if (transitionState != transitionState2) {
                    return;
                }
            } else if (!(i2 == 3 && transitionState == transitionState2)) {
                return;
            }
            x0();
        }
    }

    public void setTransition(int i2) {
        MotionScene motionScene;
        int i3;
        if (this.E3 != null) {
            MotionScene.Transition F0 = F0(i2);
            this.I3 = F0.I();
            this.K3 = F0.B();
            if (!isAttachedToWindow()) {
                if (this.M4 == null) {
                    this.M4 = new StateCache();
                }
                this.M4.f(this.I3);
                this.M4.d(this.K3);
                return;
            }
            int i6 = this.J3;
            float f2 = 0.0f;
            float f3 = i6 == this.I3 ? 0.0f : i6 == this.K3 ? 1.0f : Float.NaN;
            this.E3.o0(F0);
            this.Z4.h(this.Y2, this.E3.o(this.I3), this.E3.o(this.K3));
            T0();
            if (this.S3 != f3) {
                if (f3 == 0.0f) {
                    t0(true);
                    motionScene = this.E3;
                    i3 = this.I3;
                } else if (f3 == 1.0f) {
                    t0(false);
                    motionScene = this.E3;
                    i3 = this.K3;
                }
                motionScene.o(i3).r(this);
            }
            if (!Float.isNaN(f3)) {
                f2 = f3;
            }
            this.S3 = f2;
            if (Float.isNaN(f3)) {
                Log.v(n5, Debug.g() + " transitionToStart ");
                f1();
                return;
            }
            setProgress(f3);
        }
    }

    public void setTransitionDuration(int i2) {
        MotionScene motionScene = this.E3;
        if (motionScene == null) {
            Log.e(n5, "MotionScene not defined");
        } else {
            motionScene.k0(i2);
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.Y3 = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.M4 == null) {
            this.M4 = new StateCache();
        }
        this.M4.g(bundle);
        if (isAttachedToWindow()) {
            this.M4.a();
        }
    }

    public void t(@NonNull View view, int i2) {
        MotionScene motionScene = this.E3;
        if (motionScene != null) {
            float f2 = this.q4;
            if (f2 != 0.0f) {
                motionScene.e0(this.n4 / f2, this.o4 / f2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t0(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            MotionController motionController = this.O3.get(getChildAt(i2));
            if (motionController != null) {
                motionController.i(z);
            }
        }
    }

    public String toString() {
        Context context = getContext();
        return Debug.i(context, this.I3) + "->" + Debug.i(context, this.K3) + " (pos:" + this.S3 + " Dpos/Dt:" + this.H3;
    }

    public void u(@NonNull final View view, int i2, int i3, @NonNull int[] iArr, int i6) {
        MotionScene.Transition transition;
        TouchResponse J;
        int s;
        MotionScene motionScene = this.E3;
        if (motionScene != null && (transition = motionScene.f4509c) != null && transition.K()) {
            int i7 = -1;
            if (!transition.K() || (J = transition.J()) == null || (s = J.s()) == -1 || view.getId() == s) {
                if (motionScene.D()) {
                    TouchResponse J2 = transition.J();
                    if (!(J2 == null || (J2.f() & 4) == 0)) {
                        i7 = i3;
                    }
                    float f2 = this.R3;
                    if ((f2 == 1.0f || f2 == 0.0f) && view.canScrollVertically(i7)) {
                        return;
                    }
                }
                if (!(transition.J() == null || (transition.J().f() & 1) == 0)) {
                    float F = motionScene.F((float) i2, (float) i3);
                    float f3 = this.S3;
                    if ((f3 <= 0.0f && F < 0.0f) || (f3 >= 1.0f && F > 0.0f)) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new Runnable(this) {
                            public void run() {
                                view.setNestedScrollingEnabled(true);
                            }
                        });
                        return;
                    }
                }
                float f6 = this.R3;
                long nanoTime = getNanoTime();
                float f7 = (float) i2;
                this.n4 = f7;
                float f8 = (float) i3;
                this.o4 = f8;
                this.q4 = (float) (((double) (nanoTime - this.p4)) * 1.0E-9d);
                this.p4 = nanoTime;
                motionScene.d0(f7, f8);
                if (f6 != this.R3) {
                    iArr[0] = i2;
                    iArr[1] = i3;
                }
                u0(false);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.m4 = true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0250, code lost:
        if (r1 != r2) goto L_0x0254;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0260, code lost:
        if (r1 != r2) goto L_0x0254;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0210 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x011c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void u0(boolean r23) {
        /*
            r22 = this;
            r0 = r22
            long r1 = r0.T3
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0010
            long r1 = r22.getNanoTime()
            r0.T3 = r1
        L_0x0010:
            float r1 = r0.S3
            r2 = -1
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0020
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0020
            r0.J3 = r2
        L_0x0020:
            boolean r5 = r0.r4
            r6 = 1
            r7 = 0
            if (r5 != 0) goto L_0x0032
            boolean r5 = r0.W3
            if (r5 == 0) goto L_0x0244
            if (r23 != 0) goto L_0x0032
            float r5 = r0.U3
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 == 0) goto L_0x0244
        L_0x0032:
            float r5 = r0.U3
            float r5 = r5 - r1
            float r1 = java.lang.Math.signum(r5)
            long r8 = r22.getNanoTime()
            android.view.animation.Interpolator r5 = r0.F3
            boolean r10 = r5 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            r11 = 814313567(0x3089705f, float:1.0E-9)
            if (r10 != 0) goto L_0x0053
            long r12 = r0.T3
            long r12 = r8 - r12
            float r10 = (float) r12
            float r10 = r10 * r1
            float r10 = r10 * r11
            float r12 = r0.Q3
            float r10 = r10 / r12
            goto L_0x0054
        L_0x0053:
            r10 = 0
        L_0x0054:
            float r12 = r0.S3
            float r12 = r12 + r10
            boolean r13 = r0.V3
            if (r13 == 0) goto L_0x005d
            float r12 = r0.U3
        L_0x005d:
            int r13 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x0067
            float r14 = r0.U3
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x0071
        L_0x0067:
            int r14 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r14 > 0) goto L_0x0077
            float r14 = r0.U3
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0077
        L_0x0071:
            float r12 = r0.U3
            r0.W3 = r7
            r14 = 1
            goto L_0x0078
        L_0x0077:
            r14 = 0
        L_0x0078:
            r0.S3 = r12
            r0.R3 = r12
            r0.T3 = r8
            r15 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r5 == 0) goto L_0x0108
            if (r14 != 0) goto L_0x0108
            boolean r14 = r0.d4
            if (r14 == 0) goto L_0x00e8
            long r2 = r0.P3
            long r2 = r8 - r2
            float r2 = (float) r2
            float r2 = r2 * r11
            float r2 = r5.getInterpolation(r2)
            android.view.animation.Interpolator r3 = r0.F3
            androidx.constraintlayout.motion.utils.StopLogic r5 = r0.e4
            r10 = 2
            if (r3 != r5) goto L_0x00a5
            boolean r3 = r5.e()
            if (r3 == 0) goto L_0x00a3
            r3 = 2
            goto L_0x00a6
        L_0x00a3:
            r3 = 1
            goto L_0x00a6
        L_0x00a5:
            r3 = 0
        L_0x00a6:
            r0.S3 = r2
            r0.T3 = r8
            android.view.animation.Interpolator r5 = r0.F3
            boolean r8 = r5 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r8 == 0) goto L_0x00e6
            androidx.constraintlayout.motion.widget.MotionInterpolator r5 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r5
            float r5 = r5.a()
            r0.H3 = r5
            float r8 = java.lang.Math.abs(r5)
            float r9 = r0.Q3
            float r8 = r8 * r9
            int r8 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r8 > 0) goto L_0x00c8
            if (r3 != r10) goto L_0x00c8
            r0.W3 = r7
        L_0x00c8:
            int r8 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x00d8
            r8 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r9 < 0) goto L_0x00d8
            r0.S3 = r8
            r0.W3 = r7
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x00d8:
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x00e6
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x00e6
            r0.S3 = r4
            r0.W3 = r7
            r12 = 0
            goto L_0x010b
        L_0x00e6:
            r12 = r2
            goto L_0x010b
        L_0x00e8:
            float r2 = r5.getInterpolation(r12)
            android.view.animation.Interpolator r3 = r0.F3
            boolean r5 = r3 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r5 == 0) goto L_0x00fb
            androidx.constraintlayout.motion.widget.MotionInterpolator r3 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r3
            float r3 = r3.a()
        L_0x00f8:
            r0.H3 = r3
            goto L_0x0105
        L_0x00fb:
            float r12 = r12 + r10
            float r3 = r3.getInterpolation(r12)
            float r3 = r3 - r2
            float r3 = r3 * r1
            float r3 = r3 / r10
            goto L_0x00f8
        L_0x0105:
            r12 = r2
        L_0x0106:
            r3 = 0
            goto L_0x010b
        L_0x0108:
            r0.H3 = r10
            goto L_0x0106
        L_0x010b:
            float r2 = r0.H3
            float r2 = java.lang.Math.abs(r2)
            int r2 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r2 <= 0) goto L_0x011a
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
            r0.setState(r2)
        L_0x011a:
            if (r3 == r6) goto L_0x0143
            if (r13 <= 0) goto L_0x0124
            float r2 = r0.U3
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x012e
        L_0x0124:
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0132
            float r2 = r0.U3
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0132
        L_0x012e:
            float r12 = r0.U3
            r0.W3 = r7
        L_0x0132:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x013c
            int r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0143
        L_0x013c:
            r0.W3 = r7
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
        L_0x0143:
            int r2 = r22.getChildCount()
            r0.r4 = r7
            long r8 = r22.getNanoTime()
            r0.J4 = r12
            android.view.animation.Interpolator r3 = r0.G3
            if (r3 != 0) goto L_0x0155
            r3 = r12
            goto L_0x0159
        L_0x0155:
            float r3 = r3.getInterpolation(r12)
        L_0x0159:
            android.view.animation.Interpolator r5 = r0.G3
            if (r5 == 0) goto L_0x0171
            float r10 = r0.Q3
            float r10 = r1 / r10
            float r10 = r10 + r12
            float r5 = r5.getInterpolation(r10)
            r0.H3 = r5
            android.view.animation.Interpolator r10 = r0.G3
            float r10 = r10.getInterpolation(r12)
            float r5 = r5 - r10
            r0.H3 = r5
        L_0x0171:
            r5 = 0
        L_0x0172:
            if (r5 >= r2) goto L_0x019a
            android.view.View r10 = r0.getChildAt(r5)
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r11 = r0.O3
            java.lang.Object r11 = r11.get(r10)
            r16 = r11
            androidx.constraintlayout.motion.widget.MotionController r16 = (androidx.constraintlayout.motion.widget.MotionController) r16
            if (r16 == 0) goto L_0x0197
            boolean r11 = r0.r4
            androidx.constraintlayout.core.motion.utils.KeyCache r15 = r0.K4
            r17 = r10
            r18 = r3
            r19 = r8
            r21 = r15
            boolean r10 = r16.L(r17, r18, r19, r21)
            r10 = r10 | r11
            r0.r4 = r10
        L_0x0197:
            int r5 = r5 + 1
            goto L_0x0172
        L_0x019a:
            if (r13 <= 0) goto L_0x01a2
            float r2 = r0.U3
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x01ac
        L_0x01a2:
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x01ae
            float r2 = r0.U3
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x01ae
        L_0x01ac:
            r2 = 1
            goto L_0x01af
        L_0x01ae:
            r2 = 0
        L_0x01af:
            boolean r3 = r0.r4
            if (r3 != 0) goto L_0x01be
            boolean r3 = r0.W3
            if (r3 != 0) goto L_0x01be
            if (r2 == 0) goto L_0x01be
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
        L_0x01be:
            boolean r3 = r0.C4
            if (r3 == 0) goto L_0x01c5
            r22.requestLayout()
        L_0x01c5:
            boolean r3 = r0.r4
            r2 = r2 ^ r6
            r2 = r2 | r3
            r0.r4 = r2
            int r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x01e9
            int r2 = r0.I3
            r3 = -1
            if (r2 == r3) goto L_0x01e9
            int r3 = r0.J3
            if (r3 == r2) goto L_0x01e9
            r0.J3 = r2
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.E3
            androidx.constraintlayout.widget.ConstraintSet r2 = r3.o(r2)
            r2.p(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
            r7 = 1
        L_0x01e9:
            double r2 = (double) r12
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r5 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r5 < 0) goto L_0x0207
            int r2 = r0.J3
            int r3 = r0.K3
            if (r2 == r3) goto L_0x0207
            r0.J3 = r3
            androidx.constraintlayout.motion.widget.MotionScene r2 = r0.E3
            androidx.constraintlayout.widget.ConstraintSet r2 = r2.o(r3)
            r2.p(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
            r7 = 1
        L_0x0207:
            boolean r2 = r0.r4
            if (r2 != 0) goto L_0x0226
            boolean r2 = r0.W3
            if (r2 == 0) goto L_0x0210
            goto L_0x0226
        L_0x0210:
            if (r13 <= 0) goto L_0x0218
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 == 0) goto L_0x0220
        L_0x0218:
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0229
            int r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0229
        L_0x0220:
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
            goto L_0x0229
        L_0x0226:
            r22.invalidate()
        L_0x0229:
            boolean r2 = r0.r4
            if (r2 != 0) goto L_0x0244
            boolean r2 = r0.W3
            if (r2 != 0) goto L_0x0244
            if (r13 <= 0) goto L_0x0239
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 == 0) goto L_0x0241
        L_0x0239:
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x0244
            int r1 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0244
        L_0x0241:
            r22.Q0()
        L_0x0244:
            float r1 = r0.S3
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0258
            int r1 = r0.J3
            int r2 = r0.K3
            if (r1 == r2) goto L_0x0253
            goto L_0x0254
        L_0x0253:
            r6 = r7
        L_0x0254:
            r0.J3 = r2
            r7 = r6
            goto L_0x0263
        L_0x0258:
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x0263
            int r1 = r0.J3
            int r2 = r0.I3
            if (r1 == r2) goto L_0x0253
            goto L_0x0254
        L_0x0263:
            boolean r1 = r0.a5
            r1 = r1 | r7
            r0.a5 = r1
            if (r7 == 0) goto L_0x0271
            boolean r1 = r0.L4
            if (r1 != 0) goto L_0x0271
            r22.requestLayout()
        L_0x0271:
            float r1 = r0.S3
            r0.R3 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.u0(boolean):void");
    }

    public void x(int i2) {
        MotionScene.Transition transition;
        if (i2 != 0) {
            try {
                MotionScene motionScene = new MotionScene(getContext(), this, i2);
                this.E3 = motionScene;
                if (this.J3 == -1) {
                    this.J3 = motionScene.N();
                    this.I3 = this.E3.N();
                    this.K3 = this.E3.u();
                }
                if (isAttachedToWindow()) {
                    Display display = getDisplay();
                    this.V4 = display == null ? 0 : display.getRotation();
                    MotionScene motionScene2 = this.E3;
                    if (motionScene2 != null) {
                        ConstraintSet o = motionScene2.o(this.J3);
                        this.E3.h0(this);
                        ArrayList<MotionHelper> arrayList = this.u4;
                        if (arrayList != null) {
                            Iterator<MotionHelper> it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                it2.next().b(this);
                            }
                        }
                        if (o != null) {
                            o.r(this);
                        }
                        this.I3 = this.J3;
                    }
                    Q0();
                    StateCache stateCache = this.M4;
                    if (stateCache == null) {
                        MotionScene motionScene3 = this.E3;
                        if (motionScene3 != null && (transition = motionScene3.f4509c) != null && transition.z() == 4) {
                            d1();
                            setState(TransitionState.SETUP);
                            setState(TransitionState.MOVING);
                        }
                    } else if (this.X4) {
                        post(new Runnable() {
                            public void run() {
                                MotionLayout.this.M4.a();
                            }
                        });
                    } else {
                        stateCache.a();
                    }
                } else {
                    this.E3 = null;
                }
            } catch (Exception e2) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e2);
            } catch (Exception e3) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e3);
            }
        } else {
            this.E3 = null;
        }
    }

    /* access modifiers changed from: protected */
    public void x0() {
        int i2;
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.Y3 != null || ((copyOnWriteArrayList = this.v4) != null && !copyOnWriteArrayList.isEmpty())) && this.z4 == -1) {
            this.z4 = this.J3;
            if (!this.e5.isEmpty()) {
                ArrayList<Integer> arrayList = this.e5;
                i2 = arrayList.get(arrayList.size() - 1).intValue();
            } else {
                i2 = -1;
            }
            int i3 = this.J3;
            if (!(i2 == i3 || i3 == -1)) {
                this.e5.add(Integer.valueOf(i3));
            }
        }
        R0();
        Runnable runnable = this.N4;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.O4;
        if (iArr != null && this.P4 > 0) {
            g1(iArr[0]);
            int[] iArr2 = this.O4;
            System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
            this.P4--;
        }
    }

    /* access modifiers changed from: protected */
    public void z(int i2) {
        this.g3 = null;
    }

    public void z0(int i2, boolean z, float f2) {
        TransitionListener transitionListener = this.Y3;
        if (transitionListener != null) {
            transitionListener.d(this, i2, z, f2);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.v4;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                it2.next().d(this, i2, z, f2);
            }
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        I0(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void setTransition(MotionScene.Transition transition) {
        this.E3.o0(transition);
        setState(TransitionState.SETUP);
        float f2 = this.J3 == this.E3.u() ? 1.0f : 0.0f;
        this.S3 = f2;
        this.R3 = f2;
        this.U3 = f2;
        this.T3 = transition.L(1) ? -1 : getNanoTime();
        int N = this.E3.N();
        int u = this.E3.u();
        if (N != this.I3 || u != this.K3) {
            this.I3 = N;
            this.K3 = u;
            this.E3.n0(N, u);
            this.Z4.h(this.Y2, this.E3.o(this.I3), this.E3.o(this.K3));
            this.Z4.l(this.I3, this.K3);
            this.Z4.k();
            T0();
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        I0(attributeSet);
    }
}
