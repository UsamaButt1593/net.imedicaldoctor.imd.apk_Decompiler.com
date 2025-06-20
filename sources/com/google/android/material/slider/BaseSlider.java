package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    private static final int A4 = 63;
    private static final double B4 = 1.0E-4d;
    private static final float C4 = 0.5f;
    static final int D4 = R.style.Yj;
    static final int E4 = 1;
    static final int F4 = 0;
    private static final int G4 = 83;
    private static final int H4 = 117;
    private static final int I4 = R.attr.Ld;
    private static final int J4 = R.attr.Od;
    private static final int K4 = R.attr.Vd;
    private static final int L4 = R.attr.Td;
    @Dimension(unit = 0)
    private static final int M4 = 48;
    private static final String p4 = "BaseSlider";
    private static final String q4 = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String r4 = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String s4 = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String t4 = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final String u4 = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String v4 = "minSeparation(%s) must be greater or equal to 0";
    private static final String w4 = "minSeparation(%s) cannot be set as a dimension when using stepSize(%s)";
    private static final String x4 = "minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String y4 = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.";
    private static final int z4 = 200;
    private int A3;
    private int B3;
    private int C3;
    private int D3;
    private int E3;
    private int F3;
    private int G3;
    private int H3;
    private int I3;
    private float J3;
    private MotionEvent K3;
    private LabelFormatter L3;
    private boolean M3;
    private float N3;
    private float O3;
    private ArrayList<Float> P3;
    private int Q3;
    private int R3;
    private float S3;
    private float[] T3;
    private boolean U3;
    private int V3;
    private int W3;
    @NonNull
    private final Paint X2;
    private int X3;
    @NonNull
    private final Paint Y2;
    private boolean Y3;
    @NonNull
    private final Paint Z2;
    private boolean Z3;
    @NonNull
    private final Paint a3;
    private boolean a4;
    @NonNull
    private final Paint b3;
    @NonNull
    private ColorStateList b4;
    @NonNull
    private final Paint c3;
    @NonNull
    private ColorStateList c4;
    /* access modifiers changed from: private */
    @NonNull
    public final AccessibilityHelper d3;
    @NonNull
    private ColorStateList d4;
    private final AccessibilityManager e3;
    @NonNull
    private ColorStateList e4;
    private BaseSlider<S, L, T>.AccessibilityEventSender f3;
    @NonNull
    private ColorStateList f4;
    private int g3;
    @NonNull
    private final Path g4;
    /* access modifiers changed from: private */
    @NonNull
    public final List<TooltipDrawable> h3;
    @NonNull
    private final RectF h4;
    @NonNull
    private final List<L> i3;
    @NonNull
    private final RectF i4;
    @NonNull
    private final List<T> j3;
    @NonNull
    private final MaterialShapeDrawable j4;
    private boolean k3;
    @Nullable
    private Drawable k4;
    private ValueAnimator l3;
    @NonNull
    private List<Drawable> l4;
    private ValueAnimator m3;
    private float m4;
    private final int n3;
    private int n4;
    private int o3;
    @NonNull
    private final ViewTreeObserver.OnScrollChangedListener o4;
    private int p3;
    private int q3;
    private int r3;
    @NonNull
    private final Paint s;
    private int s3;
    private int t3;
    @Px
    private int u3;
    private int v3;
    private int w3;
    private int x3;
    private int y3;
    private int z3;

    /* renamed from: com.google.android.material.slider.BaseSlider$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21929a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.android.material.slider.BaseSlider$FullCornerDirection[] r0 = com.google.android.material.slider.BaseSlider.FullCornerDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21929a = r0
                com.google.android.material.slider.BaseSlider$FullCornerDirection r1 = com.google.android.material.slider.BaseSlider.FullCornerDirection.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21929a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.android.material.slider.BaseSlider$FullCornerDirection r1 = com.google.android.material.slider.BaseSlider.FullCornerDirection.LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21929a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.android.material.slider.BaseSlider$FullCornerDirection r1 = com.google.android.material.slider.BaseSlider.FullCornerDirection.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21929a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.android.material.slider.BaseSlider$FullCornerDirection r1 = com.google.android.material.slider.BaseSlider.FullCornerDirection.BOTH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.AnonymousClass3.<clinit>():void");
        }
    }

    private class AccessibilityEventSender implements Runnable {
        int s;

        private AccessibilityEventSender() {
            this.s = -1;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.s = i2;
        }

        public void run() {
            BaseSlider.this.d3.Y(this.s, 4);
        }
    }

    private static class AccessibilityHelper extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> t;
        final Rect u = new Rect();

        AccessibilityHelper(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.t = baseSlider;
        }

        @NonNull
        private String a0(int i2) {
            Context context;
            int i3;
            if (i2 == this.t.getValues().size() - 1) {
                context = this.t.getContext();
                i3 = R.string.D0;
            } else if (i2 != 0) {
                return "";
            } else {
                context = this.t.getContext();
                i3 = R.string.E0;
            }
            return context.getString(i3);
        }

        /* access modifiers changed from: protected */
        public int C(float f2, float f3) {
            for (int i2 = 0; i2 < this.t.getValues().size(); i2++) {
                this.t.z0(i2, this.u);
                if (this.u.contains((int) f2, (int) f3)) {
                    return i2;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public void D(List<Integer> list) {
            for (int i2 = 0; i2 < this.t.getValues().size(); i2++) {
                list.add(Integer.valueOf(i2));
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
            if (com.google.android.material.slider.BaseSlider.e(r4.t, r5, r7.getFloat(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.e0)) != false) goto L_0x0030;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean N(int r5, int r6, android.os.Bundle r7) {
            /*
                r4 = this;
                com.google.android.material.slider.BaseSlider<?, ?, ?> r0 = r4.t
                boolean r0 = r0.isEnabled()
                r1 = 0
                if (r0 != 0) goto L_0x000a
                return r1
            L_0x000a:
                r0 = 4096(0x1000, float:5.74E-42)
                r2 = 1
                r3 = 8192(0x2000, float:1.14794E-41)
                if (r6 == r0) goto L_0x003f
                if (r6 == r3) goto L_0x003f
                r0 = 16908349(0x102003d, float:2.38774E-38)
                if (r6 == r0) goto L_0x0019
                return r1
            L_0x0019:
                if (r7 == 0) goto L_0x003e
                java.lang.String r6 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"
                boolean r0 = r7.containsKey(r6)
                if (r0 != 0) goto L_0x0024
                goto L_0x003e
            L_0x0024:
                float r6 = r7.getFloat(r6)
                com.google.android.material.slider.BaseSlider<?, ?, ?> r7 = r4.t
                boolean r6 = r7.x0(r5, r6)
                if (r6 == 0) goto L_0x003e
            L_0x0030:
                com.google.android.material.slider.BaseSlider<?, ?, ?> r6 = r4.t
                r6.A0()
                com.google.android.material.slider.BaseSlider<?, ?, ?> r6 = r4.t
                r6.postInvalidate()
                r4.G(r5)
                return r2
            L_0x003e:
                return r1
            L_0x003f:
                com.google.android.material.slider.BaseSlider<?, ?, ?> r7 = r4.t
                r0 = 20
                float r7 = r7.n(r0)
                if (r6 != r3) goto L_0x004a
                float r7 = -r7
            L_0x004a:
                com.google.android.material.slider.BaseSlider<?, ?, ?> r6 = r4.t
                boolean r6 = r6.V()
                if (r6 == 0) goto L_0x0053
                float r7 = -r7
            L_0x0053:
                com.google.android.material.slider.BaseSlider<?, ?, ?> r6 = r4.t
                java.util.List r6 = r6.getValues()
                java.lang.Object r6 = r6.get(r5)
                java.lang.Float r6 = (java.lang.Float) r6
                float r6 = r6.floatValue()
                float r6 = r6 + r7
                com.google.android.material.slider.BaseSlider<?, ?, ?> r7 = r4.t
                float r7 = r7.getValueFrom()
                com.google.android.material.slider.BaseSlider<?, ?, ?> r0 = r4.t
                float r0 = r0.getValueTo()
                float r6 = androidx.core.math.MathUtils.d(r6, r7, r0)
                com.google.android.material.slider.BaseSlider<?, ?, ?> r7 = r4.t
                boolean r6 = r7.x0(r5, r6)
                if (r6 == 0) goto L_0x007d
                goto L_0x0030
            L_0x007d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.AccessibilityHelper.N(int, int, android.os.Bundle):boolean");
        }

        /* access modifiers changed from: protected */
        public void R(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.M);
            List<Float> values = this.t.getValues();
            float floatValue = values.get(i2).floatValue();
            float valueFrom = this.t.getValueFrom();
            float valueTo = this.t.getValueTo();
            if (this.t.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.a(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.a(4096);
                }
            }
            accessibilityNodeInfoCompat.T1(AccessibilityNodeInfoCompat.RangeInfoCompat.e(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.j1(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.t.getContentDescription() != null) {
                sb.append(this.t.getContentDescription());
                sb.append(",");
            }
            String d2 = this.t.F(floatValue);
            String string = this.t.getContext().getString(R.string.F0);
            if (values.size() > 1) {
                string = a0(i2);
            }
            sb.append(String.format(Locale.US, "%s, %s", new Object[]{string, d2}));
            accessibilityNodeInfoCompat.o1(sb.toString());
            this.t.z0(i2, this.u);
            accessibilityNodeInfoCompat.d1(this.u);
        }
    }

    private enum FullCornerDirection {
        BOTH,
        LEFT,
        RIGHT,
        NONE
    }

    public BaseSlider(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void A(@NonNull Canvas canvas, int i2, int i5) {
        for (int i6 = 0; i6 < this.P3.size(); i6++) {
            float floatValue = this.P3.get(i6).floatValue();
            Drawable drawable = this.k4;
            if (drawable == null) {
                if (i6 < this.l4.size()) {
                    drawable = this.l4.get(i6);
                } else {
                    if (!isEnabled()) {
                        canvas.drawCircle(((float) this.z3) + (h0(floatValue) * ((float) i2)), (float) i5, (float) getThumbRadius(), this.Y2);
                    }
                    drawable = this.j4;
                }
            }
            z(canvas, i2, i5, floatValue, drawable);
        }
    }

    /* access modifiers changed from: private */
    public void A0() {
        if (!u0() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int h0 = (int) ((h0(this.P3.get(this.R3).floatValue()) * ((float) this.X3)) + ((float) this.z3));
                int o = o();
                int i2 = this.C3;
                DrawableCompat.l(background, h0 - i2, o - i2, h0 + i2, o + i2);
            }
        }
    }

    private void B() {
        if (!this.k3) {
            this.k3 = true;
            ValueAnimator r = r(true);
            this.l3 = r;
            this.m3 = null;
            r.start();
        }
        Iterator<TooltipDrawable> it2 = this.h3.iterator();
        for (int i2 = 0; i2 < this.P3.size() && it2.hasNext(); i2++) {
            if (i2 != this.R3) {
                r0(it2.next(), this.P3.get(i2).floatValue());
            }
        }
        if (it2.hasNext()) {
            r0(it2.next(), this.P3.get(this.R3).floatValue());
            return;
        }
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.h3.size()), Integer.valueOf(this.P3.size())}));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (W() != false) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        if (isEnabled() != false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void B0() {
        /*
            r3 = this;
            int r0 = r3.x3
            if (r0 == 0) goto L_0x003a
            r1 = 1
            if (r0 == r1) goto L_0x003a
            r1 = 2
            if (r0 == r1) goto L_0x001d
            r1 = 3
            if (r0 != r1) goto L_0x0021
            boolean r0 = r3.isEnabled()
            if (r0 == 0) goto L_0x001d
            boolean r0 = r3.W()
            if (r0 == 0) goto L_0x001d
        L_0x0019:
            r3.B()
            goto L_0x0046
        L_0x001d:
            r3.C()
            goto L_0x0046
        L_0x0021:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected labelBehavior: "
            r1.append(r2)
            int r2 = r3.x3
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x003a:
            int r0 = r3.Q3
            r1 = -1
            if (r0 == r1) goto L_0x001d
            boolean r0 = r3.isEnabled()
            if (r0 == 0) goto L_0x001d
            goto L_0x0019
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.B0():void");
    }

    private void C() {
        if (this.k3) {
            this.k3 = false;
            ValueAnimator r = r(false);
            this.m3 = r;
            this.l3 = null;
            r.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ViewOverlayImpl m2 = ViewUtils.m(BaseSlider.this);
                    for (TooltipDrawable b2 : BaseSlider.this.h3) {
                        m2.b(b2);
                    }
                }
            });
            this.m3.start();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void C0(android.graphics.Canvas r9, android.graphics.Paint r10, android.graphics.RectF r11, com.google.android.material.slider.BaseSlider.FullCornerDirection r12) {
        /*
            r8 = this;
            int r0 = r8.y3
            float r1 = (float) r0
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            float r0 = (float) r0
            float r0 = r0 / r2
            int[] r3 = com.google.android.material.slider.BaseSlider.AnonymousClass3.f21929a
            int r4 = r12.ordinal()
            r4 = r3[r4]
            r5 = 3
            r6 = 2
            r7 = 1
            if (r4 == r7) goto L_0x0022
            if (r4 == r6) goto L_0x001e
            if (r4 == r5) goto L_0x001a
            goto L_0x0026
        L_0x001a:
            int r1 = r8.H3
            float r1 = (float) r1
            goto L_0x0026
        L_0x001e:
            int r0 = r8.H3
        L_0x0020:
            float r0 = (float) r0
            goto L_0x0026
        L_0x0022:
            int r0 = r8.H3
            float r1 = (float) r0
            goto L_0x0020
        L_0x0026:
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL
            r10.setStyle(r4)
            android.graphics.Paint$Cap r4 = android.graphics.Paint.Cap.BUTT
            r10.setStrokeCap(r4)
            r10.setAntiAlias(r7)
            android.graphics.Path r4 = r8.g4
            r4.reset()
            float r4 = r11.width()
            float r7 = r1 + r0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 < 0) goto L_0x0053
            android.graphics.Path r12 = r8.g4
            float[] r0 = r8.K(r1, r0)
            android.graphics.Path$Direction r1 = android.graphics.Path.Direction.CW
            r12.addRoundRect(r11, r0, r1)
            android.graphics.Path r11 = r8.g4
            r9.drawPath(r11, r10)
            goto L_0x00ae
        L_0x0053:
            float r4 = java.lang.Math.min(r1, r0)
            float r0 = java.lang.Math.max(r1, r0)
            r9.save()
            android.graphics.Path r1 = r8.g4
            android.graphics.Path$Direction r7 = android.graphics.Path.Direction.CW
            r1.addRoundRect(r11, r4, r4, r7)
            android.graphics.Path r1 = r8.g4
            r9.clipPath(r1)
            int r12 = r12.ordinal()
            r12 = r3[r12]
            if (r12 == r6) goto L_0x0098
            if (r12 == r5) goto L_0x0088
            android.graphics.RectF r12 = r8.i4
            float r1 = r11.centerX()
            float r1 = r1 - r0
            float r2 = r11.top
            float r3 = r11.centerX()
            float r3 = r3 + r0
            float r11 = r11.bottom
            r12.set(r1, r2, r3, r11)
            goto L_0x00a6
        L_0x0088:
            android.graphics.RectF r12 = r8.i4
            float r1 = r11.right
            float r2 = r2 * r0
            float r2 = r1 - r2
            float r3 = r11.top
            float r11 = r11.bottom
            r12.set(r2, r3, r1, r11)
            goto L_0x00a6
        L_0x0098:
            android.graphics.RectF r12 = r8.i4
            float r1 = r11.left
            float r3 = r11.top
            float r2 = r2 * r0
            float r2 = r2 + r1
            float r11 = r11.bottom
            r12.set(r1, r3, r2, r11)
        L_0x00a6:
            android.graphics.RectF r11 = r8.i4
            r9.drawRoundRect(r11, r0, r0, r10)
            r9.restore()
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.C0(android.graphics.Canvas, android.graphics.Paint, android.graphics.RectF, com.google.android.material.slider.BaseSlider$FullCornerDirection):void");
    }

    private void D(int i2) {
        if (i2 == 1) {
            f0(Integer.MAX_VALUE);
        } else if (i2 == 2) {
            f0(Integer.MIN_VALUE);
        } else if (i2 == 17) {
            g0(Integer.MAX_VALUE);
        } else if (i2 == 66) {
            g0(Integer.MIN_VALUE);
        }
    }

    private void D0(int i2) {
        this.X3 = Math.max(i2 - (this.z3 * 2), 0);
        Z();
    }

    private void E0() {
        boolean e0 = e0();
        boolean d0 = d0();
        if (e0) {
            requestLayout();
        } else if (d0) {
            postInvalidate();
        }
    }

    /* access modifiers changed from: private */
    public String F(float f2) {
        if (O()) {
            return this.L3.a(f2);
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", new Object[]{Float.valueOf(f2)});
    }

    private void F0() {
        if (this.a4) {
            I0();
            J0();
            H0();
            K0();
            G0();
            N0();
            this.a4 = false;
        }
    }

    private float[] G() {
        float floatValue = this.P3.get(0).floatValue();
        ArrayList<Float> arrayList = this.P3;
        float floatValue2 = arrayList.get(arrayList.size() - 1).floatValue();
        if (this.P3.size() == 1) {
            floatValue = this.N3;
        }
        float h0 = h0(floatValue);
        float h02 = h0(floatValue2);
        if (V()) {
            return new float[]{h02, h0};
        }
        return new float[]{h0, h02};
    }

    private void G0() {
        float minSeparation = getMinSeparation();
        if (minSeparation >= 0.0f) {
            float f2 = this.S3;
            if (f2 > 0.0f && minSeparation > 0.0f) {
                if (this.n4 != 1) {
                    throw new IllegalStateException(String.format(w4, new Object[]{Float.valueOf(minSeparation), Float.valueOf(this.S3)}));
                } else if (minSeparation < f2 || !T((double) minSeparation)) {
                    throw new IllegalStateException(String.format(x4, new Object[]{Float.valueOf(minSeparation), Float.valueOf(this.S3), Float.valueOf(this.S3)}));
                }
            }
        } else {
            throw new IllegalStateException(String.format(v4, new Object[]{Float.valueOf(minSeparation)}));
        }
    }

    private static float H(ValueAnimator valueAnimator, float f2) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f2;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return floatValue;
    }

    private void H0() {
        if (this.S3 > 0.0f && !L0(this.O3)) {
            throw new IllegalStateException(String.format(u4, new Object[]{Float.valueOf(this.S3), Float.valueOf(this.N3), Float.valueOf(this.O3)}));
        }
    }

    private float I(int i2, float f2) {
        float minSeparation = getMinSeparation();
        if (this.n4 == 0) {
            minSeparation = u(minSeparation);
        }
        if (V()) {
            minSeparation = -minSeparation;
        }
        int i5 = i2 + 1;
        int i6 = i2 - 1;
        return MathUtils.d(f2, i6 < 0 ? this.N3 : this.P3.get(i6).floatValue() + minSeparation, i5 >= this.P3.size() ? this.O3 : this.P3.get(i5).floatValue() - minSeparation);
    }

    private void I0() {
        if (this.N3 >= this.O3) {
            throw new IllegalStateException(String.format(s4, new Object[]{Float.valueOf(this.N3), Float.valueOf(this.O3)}));
        }
    }

    @ColorInt
    private int J(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private void J0() {
        if (this.O3 <= this.N3) {
            throw new IllegalStateException(String.format(t4, new Object[]{Float.valueOf(this.O3), Float.valueOf(this.N3)}));
        }
    }

    private float[] K(float f2, float f5) {
        return new float[]{f2, f2, f5, f5, f5, f5, f2, f2};
    }

    private void K0() {
        Iterator<Float> it2 = this.P3.iterator();
        while (it2.hasNext()) {
            Float next = it2.next();
            if (next.floatValue() < this.N3 || next.floatValue() > this.O3) {
                throw new IllegalStateException(String.format(q4, new Object[]{next, Float.valueOf(this.N3), Float.valueOf(this.O3)}));
            } else if (this.S3 > 0.0f && !L0(next.floatValue())) {
                throw new IllegalStateException(String.format(r4, new Object[]{next, Float.valueOf(this.N3), Float.valueOf(this.S3), Float.valueOf(this.S3)}));
            }
        }
    }

    private float L() {
        double w0 = w0(this.m4);
        if (V()) {
            w0 = 1.0d - w0;
        }
        float f2 = this.O3;
        float f5 = this.N3;
        return (float) ((w0 * ((double) (f2 - f5))) + ((double) f5));
    }

    private boolean L0(float f2) {
        return T(new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.N3)), MathContext.DECIMAL64).doubleValue());
    }

    private float M() {
        float f2 = this.m4;
        if (V()) {
            f2 = 1.0f - f2;
        }
        float f5 = this.O3;
        float f6 = this.N3;
        return (f2 * (f5 - f6)) + f6;
    }

    private float M0(float f2) {
        return (h0(f2) * ((float) this.X3)) + ((float) this.z3);
    }

    private boolean N() {
        return this.D3 > 0;
    }

    private void N0() {
        float f2 = this.S3;
        if (f2 != 0.0f) {
            if (((float) ((int) f2)) != f2) {
                Log.w(p4, String.format(y4, new Object[]{"stepSize", Float.valueOf(f2)}));
            }
            float f5 = this.N3;
            if (((float) ((int) f5)) != f5) {
                Log.w(p4, String.format(y4, new Object[]{"valueFrom", Float.valueOf(f5)}));
            }
            float f6 = this.O3;
            if (((float) ((int) f6)) != f6) {
                Log.w(p4, String.format(y4, new Object[]{"valueTo", Float.valueOf(f6)}));
            }
        }
    }

    private Drawable P(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        j(newDrawable);
        return newDrawable;
    }

    private void Q() {
        this.s.setStrokeWidth((float) this.y3);
        this.X2.setStrokeWidth((float) this.y3);
    }

    private boolean R() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private static boolean S(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 3;
    }

    private boolean T(double d2) {
        double doubleValue = new BigDecimal(Double.toString(d2)).divide(new BigDecimal(Float.toString(this.S3)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < B4;
    }

    private boolean U(MotionEvent motionEvent) {
        return !S(motionEvent) && R();
    }

    private boolean W() {
        Rect rect = new Rect();
        ViewUtils.l(this).getHitRect(rect);
        return getLocalVisibleRect(rect);
    }

    private void Y(@NonNull Resources resources) {
        this.v3 = resources.getDimensionPixelSize(R.dimen.xd);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.wd);
        this.o3 = dimensionPixelOffset;
        this.z3 = dimensionPixelOffset;
        this.p3 = resources.getDimensionPixelSize(R.dimen.sd);
        this.q3 = resources.getDimensionPixelSize(R.dimen.vd);
        int i2 = R.dimen.ud;
        this.r3 = resources.getDimensionPixelSize(i2);
        this.s3 = resources.getDimensionPixelSize(i2);
        this.t3 = resources.getDimensionPixelSize(R.dimen.td);
        this.I3 = resources.getDimensionPixelSize(R.dimen.od);
    }

    private void Z() {
        if (this.S3 > 0.0f) {
            F0();
            int min = Math.min((int) (((this.O3 - this.N3) / this.S3) + 1.0f), (this.X3 / this.t3) + 1);
            float[] fArr = this.T3;
            if (fArr == null || fArr.length != min * 2) {
                this.T3 = new float[(min * 2)];
            }
            float f2 = ((float) this.X3) / ((float) (min - 1));
            for (int i2 = 0; i2 < min * 2; i2 += 2) {
                float[] fArr2 = this.T3;
                fArr2[i2] = ((float) this.z3) + ((((float) i2) / 2.0f) * f2);
                fArr2[i2 + 1] = (float) o();
            }
        }
    }

    private void a0(@NonNull Canvas canvas, int i2, int i5) {
        if (u0()) {
            int h0 = (int) (((float) this.z3) + (h0(this.P3.get(this.R3).floatValue()) * ((float) i2)));
            if (Build.VERSION.SDK_INT < 28) {
                int i6 = this.C3;
                canvas.clipRect((float) (h0 - i6), (float) (i5 - i6), (float) (h0 + i6), (float) (i6 + i5), Region.Op.UNION);
            }
            canvas.drawCircle((float) h0, (float) i5, (float) this.C3, this.Z2);
        }
    }

    private void b0(@NonNull Canvas canvas, int i2) {
        if (this.G3 > 0) {
            if (this.P3.size() >= 1) {
                ArrayList<Float> arrayList = this.P3;
                float floatValue = arrayList.get(arrayList.size() - 1).floatValue();
                float f2 = this.O3;
                if (floatValue < f2) {
                    canvas.drawPoint(M0(f2), (float) i2, this.c3);
                }
            }
            if (this.P3.size() > 1) {
                float floatValue2 = this.P3.get(0).floatValue();
                float f5 = this.N3;
                if (floatValue2 > f5) {
                    canvas.drawPoint(M0(f5), (float) i2, this.c3);
                }
            }
        }
    }

    private void c0(@NonNull Canvas canvas) {
        if (this.U3 && this.S3 > 0.0f) {
            float[] G = G();
            int ceil = (int) Math.ceil((double) (G[0] * ((((float) this.T3.length) / 2.0f) - 1.0f)));
            int floor = (int) Math.floor((double) (G[1] * ((((float) this.T3.length) / 2.0f) - 1.0f)));
            if (ceil > 0) {
                canvas.drawPoints(this.T3, 0, ceil * 2, this.a3);
            }
            if (ceil <= floor) {
                canvas.drawPoints(this.T3, ceil * 2, ((floor - ceil) + 1) * 2, this.b3);
            }
            int i2 = (floor + 1) * 2;
            float[] fArr = this.T3;
            if (i2 < fArr.length) {
                canvas.drawPoints(fArr, i2, fArr.length - i2, this.a3);
            }
        }
    }

    private boolean d0() {
        int max = this.o3 + Math.max(Math.max(Math.max((this.A3 / 2) - this.p3, 0), Math.max((this.y3 - this.q3) / 2, 0)), Math.max(Math.max(this.V3 - this.r3, 0), Math.max(this.W3 - this.s3, 0)));
        if (this.z3 == max) {
            return false;
        }
        this.z3 = max;
        if (!ViewCompat.Y0(this)) {
            return true;
        }
        D0(getWidth());
        return true;
    }

    private boolean e0() {
        int max = Math.max(this.v3, Math.max(this.y3 + getPaddingTop() + getPaddingBottom(), this.B3 + getPaddingTop() + getPaddingBottom()));
        if (max == this.w3) {
            return false;
        }
        this.w3 = max;
        return true;
    }

    private boolean f0(int i2) {
        int i5 = this.R3;
        int f2 = (int) MathUtils.f(((long) i5) + ((long) i2), 0, (long) (this.P3.size() - 1));
        this.R3 = f2;
        if (f2 == i5) {
            return false;
        }
        if (this.Q3 != -1) {
            this.Q3 = f2;
        }
        A0();
        postInvalidate();
        return true;
    }

    private boolean g0(int i2) {
        if (V()) {
            i2 = i2 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i2;
        }
        return f0(i2);
    }

    private float h0(float f2) {
        float f5 = this.N3;
        float f6 = (f2 - f5) / (this.O3 - f5);
        return V() ? 1.0f - f6 : f6;
    }

    @Nullable
    private Boolean i0(int i2, @NonNull KeyEvent keyEvent) {
        if (i2 != 61) {
            if (i2 != 66) {
                if (i2 != 81) {
                    if (i2 == 69) {
                        f0(-1);
                        return Boolean.TRUE;
                    } else if (i2 != 70) {
                        switch (i2) {
                            case 21:
                                g0(-1);
                                return Boolean.TRUE;
                            case 22:
                                g0(1);
                                return Boolean.TRUE;
                            case 23:
                                break;
                            default:
                                return null;
                        }
                    }
                }
                f0(1);
                return Boolean.TRUE;
            }
            this.Q3 = this.R3;
            postInvalidate();
            return Boolean.TRUE;
        } else if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(f0(1));
        } else {
            return keyEvent.isShiftPressed() ? Boolean.valueOf(f0(-1)) : Boolean.FALSE;
        }
    }

    private void j(Drawable drawable) {
        int i2;
        int i5;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            i2 = this.A3;
            i5 = this.B3;
        } else {
            float max = ((float) Math.max(this.A3, this.B3)) / ((float) Math.max(intrinsicWidth, intrinsicHeight));
            i2 = (int) (((float) intrinsicWidth) * max);
            i5 = (int) (((float) intrinsicHeight) * max);
        }
        drawable.setBounds(0, 0, i2, i5);
    }

    private void j0() {
        for (T a2 : this.j3) {
            a2.a(this);
        }
    }

    private void k(TooltipDrawable tooltipDrawable) {
        tooltipDrawable.l1(ViewUtils.l(this));
    }

    private void k0() {
        for (T b2 : this.j3) {
            b2.b(this);
        }
    }

    @Nullable
    private Float l(int i2) {
        float n2 = this.Z3 ? n(20) : m();
        if (i2 == 21) {
            if (!V()) {
                n2 = -n2;
            }
            return Float.valueOf(n2);
        } else if (i2 == 22) {
            if (V()) {
                n2 = -n2;
            }
            return Float.valueOf(n2);
        } else if (i2 == 69) {
            return Float.valueOf(-n2);
        } else {
            if (i2 == 70 || i2 == 81) {
                return Float.valueOf(n2);
            }
            return null;
        }
    }

    private float m() {
        float f2 = this.S3;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void m0(TooltipDrawable tooltipDrawable, float f2) {
        int h0 = (this.z3 + ((int) (h0(f2) * ((float) this.X3)))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int o = o() - (this.I3 + (this.B3 / 2));
        tooltipDrawable.setBounds(h0, o - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + h0, o);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.c(ViewUtils.l(this), this, rect);
        tooltipDrawable.setBounds(rect);
    }

    /* access modifiers changed from: private */
    public float n(int i2) {
        float m2 = m();
        float f2 = (this.O3 - this.N3) / m2;
        float f5 = (float) i2;
        return f2 <= f5 ? m2 : ((float) Math.round(f2 / f5)) * m2;
    }

    private void n0(Context context, AttributeSet attributeSet, int i2) {
        TypedArray k2 = ThemeEnforcement.k(context, attributeSet, R.styleable.Ot, i2, D4, new int[0]);
        this.g3 = k2.getResourceId(R.styleable.Xt, R.style.Gk);
        this.N3 = k2.getFloat(R.styleable.St, 0.0f);
        this.O3 = k2.getFloat(R.styleable.Tt, 1.0f);
        setValues(Float.valueOf(this.N3));
        this.S3 = k2.getFloat(R.styleable.Rt, 0.0f);
        this.u3 = (int) Math.ceil((double) k2.getDimension(R.styleable.Yt, (float) Math.ceil((double) ViewUtils.i(getContext(), 48))));
        int i5 = R.styleable.nu;
        boolean hasValue = k2.hasValue(i5);
        int i6 = hasValue ? i5 : R.styleable.pu;
        if (!hasValue) {
            i5 = R.styleable.ou;
        }
        ColorStateList a2 = MaterialResources.a(context, k2, i6);
        if (a2 == null) {
            a2 = AppCompatResources.a(context, R.color.lc);
        }
        setTrackInactiveTintList(a2);
        ColorStateList a5 = MaterialResources.a(context, k2, i5);
        if (a5 == null) {
            a5 = AppCompatResources.a(context, R.color.ic);
        }
        setTrackActiveTintList(a5);
        this.j4.p0(MaterialResources.a(context, k2, R.styleable.Zt));
        int i7 = R.styleable.du;
        if (k2.hasValue(i7)) {
            setThumbStrokeColor(MaterialResources.a(context, k2, i7));
        }
        setThumbStrokeWidth(k2.getDimension(R.styleable.eu, 0.0f));
        ColorStateList a6 = MaterialResources.a(context, k2, R.styleable.Ut);
        if (a6 == null) {
            a6 = AppCompatResources.a(context, R.color.jc);
        }
        setHaloTintList(a6);
        this.U3 = k2.getBoolean(R.styleable.mu, true);
        int i8 = R.styleable.hu;
        boolean hasValue2 = k2.hasValue(i8);
        int i9 = hasValue2 ? i8 : R.styleable.ju;
        if (!hasValue2) {
            i8 = R.styleable.iu;
        }
        ColorStateList a7 = MaterialResources.a(context, k2, i9);
        if (a7 == null) {
            a7 = AppCompatResources.a(context, R.color.kc);
        }
        setTickInactiveTintList(a7);
        ColorStateList a8 = MaterialResources.a(context, k2, i8);
        if (a8 == null) {
            a8 = AppCompatResources.a(context, R.color.hc);
        }
        setTickActiveTintList(a8);
        setThumbTrackGapSize(k2.getDimensionPixelSize(R.styleable.fu, 0));
        setTrackStopIndicatorSize(k2.getDimensionPixelSize(R.styleable.su, 0));
        setTrackInsideCornerSize(k2.getDimensionPixelSize(R.styleable.ru, 0));
        int dimensionPixelSize = k2.getDimensionPixelSize(R.styleable.cu, 0) * 2;
        int dimensionPixelSize2 = k2.getDimensionPixelSize(R.styleable.gu, dimensionPixelSize);
        int dimensionPixelSize3 = k2.getDimensionPixelSize(R.styleable.bu, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(k2.getDimensionPixelSize(R.styleable.Vt, 0));
        setThumbElevation(k2.getDimension(R.styleable.au, 0.0f));
        setTrackHeight(k2.getDimensionPixelSize(R.styleable.qu, 0));
        setTickActiveRadius(k2.getDimensionPixelSize(R.styleable.ku, this.G3 / 2));
        setTickInactiveRadius(k2.getDimensionPixelSize(R.styleable.lu, this.G3 / 2));
        setLabelBehavior(k2.getInt(R.styleable.Wt, 0));
        if (!k2.getBoolean(R.styleable.Pt, true)) {
            setEnabled(false);
        }
        k2.recycle();
    }

    private int o() {
        int i2 = this.w3 / 2;
        int i5 = 0;
        if (this.x3 == 1 || t0()) {
            i5 = this.h3.get(0).getIntrinsicHeight();
        }
        return i2 + i5;
    }

    private void q0(int i2) {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.f3;
        if (accessibilityEventSender == null) {
            this.f3 = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        this.f3.a(i2);
        postDelayed(this.f3, 200);
    }

    private ValueAnimator r(boolean z) {
        int f2;
        Context context;
        int i2;
        TimeInterpolator timeInterpolator;
        float f5 = 1.0f;
        float H = H(z ? this.m3 : this.l3, z ? 0.0f : 1.0f);
        if (!z) {
            f5 = 0.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{H, f5});
        if (z) {
            f2 = MotionUtils.f(getContext(), I4, 83);
            context = getContext();
            i2 = K4;
            timeInterpolator = AnimationUtils.f20770e;
        } else {
            f2 = MotionUtils.f(getContext(), J4, 117);
            context = getContext();
            i2 = L4;
            timeInterpolator = AnimationUtils.f20768c;
        }
        TimeInterpolator g2 = MotionUtils.g(context, i2, timeInterpolator);
        ofFloat.setDuration((long) f2);
        ofFloat.setInterpolator(g2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                for (TooltipDrawable m1 : BaseSlider.this.h3) {
                    m1.m1(floatValue);
                }
                ViewCompat.t1(BaseSlider.this);
            }
        });
        return ofFloat;
    }

    private void r0(TooltipDrawable tooltipDrawable, float f2) {
        tooltipDrawable.n1(F(f2));
        m0(tooltipDrawable, f2);
        ViewUtils.m(this).a(tooltipDrawable);
    }

    private void s() {
        int i2;
        if (this.h3.size() > this.P3.size()) {
            List<TooltipDrawable> subList = this.h3.subList(this.P3.size(), this.h3.size());
            for (TooltipDrawable next : subList) {
                if (ViewCompat.R0(this)) {
                    t(next);
                }
            }
            subList.clear();
        }
        while (true) {
            i2 = 0;
            if (this.h3.size() >= this.P3.size()) {
                break;
            }
            TooltipDrawable W0 = TooltipDrawable.W0(getContext(), (AttributeSet) null, 0, this.g3);
            this.h3.add(W0);
            if (ViewCompat.R0(this)) {
                k(W0);
            }
        }
        if (this.h3.size() != 1) {
            i2 = 1;
        }
        for (TooltipDrawable J0 : this.h3) {
            J0.J0((float) i2);
        }
    }

    private void s0(@NonNull ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.P3.size() != arrayList.size() || !this.P3.equals(arrayList)) {
                this.P3 = arrayList;
                this.a4 = true;
                this.R3 = 0;
                A0();
                s();
                w();
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private void t(TooltipDrawable tooltipDrawable) {
        ViewOverlayImpl m2 = ViewUtils.m(this);
        if (m2 != null) {
            m2.b(tooltipDrawable);
            tooltipDrawable.Y0(ViewUtils.l(this));
        }
    }

    private boolean t0() {
        return this.x3 == 3;
    }

    private float u(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        float f5 = (f2 - ((float) this.z3)) / ((float) this.X3);
        float f6 = this.N3;
        return (f5 * (f6 - this.O3)) + f6;
    }

    private boolean u0() {
        return this.Y3 || !(getBackground() instanceof RippleDrawable);
    }

    private void v(int i2) {
        for (L a2 : this.i3) {
            a2.a(this, this.P3.get(i2).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.e3;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            q0(i2);
        }
    }

    private boolean v0(float f2) {
        return x0(this.Q3, f2);
    }

    private void w() {
        for (L l2 : this.i3) {
            Iterator<Float> it2 = this.P3.iterator();
            while (it2.hasNext()) {
                l2.a(this, it2.next().floatValue(), false);
            }
        }
    }

    private double w0(float f2) {
        float f5 = this.S3;
        if (f5 <= 0.0f) {
            return (double) f2;
        }
        int i2 = (int) ((this.O3 - this.N3) / f5);
        return ((double) Math.round(f2 * ((float) i2))) / ((double) i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x(@androidx.annotation.NonNull android.graphics.Canvas r12, int r13, int r14) {
        /*
            r11 = this;
            float[] r0 = r11.G()
            int r1 = r11.z3
            float r2 = (float) r1
            r3 = 1
            r4 = r0[r3]
            float r13 = (float) r13
            float r4 = r4 * r13
            float r8 = r2 + r4
            float r1 = (float) r1
            r2 = 0
            r0 = r0[r2]
            float r0 = r0 * r13
            float r6 = r1 + r0
            boolean r13 = r11.N()
            if (r13 == 0) goto L_0x00bb
            com.google.android.material.slider.BaseSlider$FullCornerDirection r13 = com.google.android.material.slider.BaseSlider.FullCornerDirection.NONE
            java.util.ArrayList<java.lang.Float> r0 = r11.P3
            int r0 = r0.size()
            if (r0 != r3) goto L_0x0032
            boolean r13 = r11.V()
            if (r13 == 0) goto L_0x0030
            com.google.android.material.slider.BaseSlider$FullCornerDirection r13 = com.google.android.material.slider.BaseSlider.FullCornerDirection.RIGHT
            goto L_0x0032
        L_0x0030:
            com.google.android.material.slider.BaseSlider$FullCornerDirection r13 = com.google.android.material.slider.BaseSlider.FullCornerDirection.LEFT
        L_0x0032:
            java.util.ArrayList<java.lang.Float> r0 = r11.P3
            int r0 = r0.size()
            if (r2 >= r0) goto L_0x00d1
            java.util.ArrayList<java.lang.Float> r0 = r11.P3
            int r0 = r0.size()
            if (r0 <= r3) goto L_0x0070
            if (r2 <= 0) goto L_0x0056
            java.util.ArrayList<java.lang.Float> r0 = r11.P3
            int r1 = r2 + -1
            java.lang.Object r0 = r0.get(r1)
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            float r6 = r11.M0(r0)
        L_0x0056:
            java.util.ArrayList<java.lang.Float> r0 = r11.P3
            java.lang.Object r0 = r0.get(r2)
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            float r0 = r11.M0(r0)
            boolean r1 = r11.V()
            if (r1 == 0) goto L_0x006f
            r8 = r6
            r6 = r0
            goto L_0x0070
        L_0x006f:
            r8 = r0
        L_0x0070:
            int[] r0 = com.google.android.material.slider.BaseSlider.AnonymousClass3.f21929a
            int r1 = r13.ordinal()
            r0 = r0[r1]
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 == r3) goto L_0x0097
            r4 = 2
            if (r0 == r4) goto L_0x008d
            r4 = 3
            if (r0 == r4) goto L_0x0083
            goto L_0x009c
        L_0x0083:
            int r0 = r11.D3
            float r0 = (float) r0
            float r6 = r6 + r0
            int r0 = r11.y3
            float r0 = (float) r0
            float r0 = r0 / r1
            float r8 = r8 + r0
            goto L_0x009c
        L_0x008d:
            int r0 = r11.y3
            float r0 = (float) r0
            float r0 = r0 / r1
            float r6 = r6 - r0
            int r0 = r11.D3
        L_0x0094:
            float r0 = (float) r0
            float r8 = r8 - r0
            goto L_0x009c
        L_0x0097:
            int r0 = r11.D3
            float r4 = (float) r0
            float r6 = r6 + r4
            goto L_0x0094
        L_0x009c:
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x00a1
            goto L_0x00b7
        L_0x00a1:
            android.graphics.RectF r0 = r11.h4
            float r4 = (float) r14
            int r5 = r11.y3
            float r7 = (float) r5
            float r7 = r7 / r1
            float r7 = r4 - r7
            float r5 = (float) r5
            float r5 = r5 / r1
            float r4 = r4 + r5
            r0.set(r6, r7, r8, r4)
            android.graphics.Paint r0 = r11.X2
            android.graphics.RectF r1 = r11.h4
            r11.C0(r12, r0, r1, r13)
        L_0x00b7:
            int r2 = r2 + 1
            goto L_0x0032
        L_0x00bb:
            android.graphics.Paint r13 = r11.X2
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.STROKE
            r13.setStyle(r0)
            android.graphics.Paint r13 = r11.X2
            android.graphics.Paint$Cap r0 = android.graphics.Paint.Cap.ROUND
            r13.setStrokeCap(r0)
            float r9 = (float) r14
            android.graphics.Paint r10 = r11.X2
            r5 = r12
            r7 = r9
            r5.drawLine(r6, r7, r8, r9, r10)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.x(android.graphics.Canvas, int, int):void");
    }

    /* access modifiers changed from: private */
    public boolean x0(int i2, float f2) {
        this.R3 = i2;
        if (((double) Math.abs(f2 - this.P3.get(i2).floatValue())) < B4) {
            return false;
        }
        this.P3.set(i2, Float.valueOf(I(i2, f2)));
        v(i2);
        return true;
    }

    private void y(@NonNull Canvas canvas, int i2, int i5) {
        float[] G = G();
        int i6 = this.z3;
        float f2 = (float) i2;
        float f5 = ((float) i6) + (G[1] * f2);
        if (f5 < ((float) (i6 + i2))) {
            if (N()) {
                RectF rectF = this.h4;
                float f6 = f5 + ((float) this.D3);
                float f7 = (float) i5;
                int i7 = this.y3;
                rectF.set(f6, f7 - (((float) i7) / 2.0f), ((float) (this.z3 + i2)) + (((float) i7) / 2.0f), f7 + (((float) i7) / 2.0f));
                C0(canvas, this.s, this.h4, FullCornerDirection.RIGHT);
            } else {
                this.s.setStyle(Paint.Style.STROKE);
                this.s.setStrokeCap(Paint.Cap.ROUND);
                float f8 = (float) i5;
                canvas.drawLine(f5, f8, (float) (this.z3 + i2), f8, this.s);
            }
        }
        int i8 = this.z3;
        float f9 = ((float) i8) + (G[0] * f2);
        if (f9 <= ((float) i8)) {
            return;
        }
        if (N()) {
            RectF rectF2 = this.h4;
            int i9 = this.y3;
            float f10 = (float) i5;
            rectF2.set(((float) this.z3) - (((float) i9) / 2.0f), f10 - (((float) i9) / 2.0f), f9 - ((float) this.D3), f10 + (((float) i9) / 2.0f));
            C0(canvas, this.s, this.h4, FullCornerDirection.LEFT);
            return;
        }
        this.s.setStyle(Paint.Style.STROKE);
        this.s.setStrokeCap(Paint.Cap.ROUND);
        float f11 = (float) i5;
        canvas.drawLine((float) this.z3, f11, f9, f11, this.s);
    }

    private boolean y0() {
        return v0(L());
    }

    private void z(@NonNull Canvas canvas, int i2, int i5, float f2, @NonNull Drawable drawable) {
        canvas.save();
        canvas.translate(((float) (this.z3 + ((int) (h0(f2) * ((float) i2))))) - (((float) drawable.getBounds().width()) / 2.0f), ((float) i5) - (((float) drawable.getBounds().height()) / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void E(boolean z) {
        this.Y3 = z;
    }

    public boolean O() {
        return this.L3 != null;
    }

    /* access modifiers changed from: package-private */
    public final boolean V() {
        return ViewCompat.c0(this) == 1;
    }

    public boolean X() {
        return this.U3;
    }

    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return this.d3.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.s.setColor(J(this.f4));
        this.X2.setColor(J(this.e4));
        this.a3.setColor(J(this.d4));
        this.b3.setColor(J(this.c4));
        this.c3.setColor(J(this.e4));
        for (TooltipDrawable next : this.h3) {
            if (next.isStateful()) {
                next.setState(getDrawableState());
            }
        }
        if (this.j4.isStateful()) {
            this.j4.setState(getDrawableState());
        }
        this.Z2.setColor(J(this.b4));
        this.Z2.setAlpha(63);
    }

    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.d3.x();
    }

    public int getActiveThumbIndex() {
        return this.Q3;
    }

    public int getFocusedThumbIndex() {
        return this.R3;
    }

    @Px
    public int getHaloRadius() {
        return this.C3;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.b4;
    }

    public int getLabelBehavior() {
        return this.x3;
    }

    /* access modifiers changed from: protected */
    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.S3;
    }

    public float getThumbElevation() {
        return this.j4.y();
    }

    @Px
    public int getThumbHeight() {
        return this.B3;
    }

    @Px
    public int getThumbRadius() {
        return this.A3 / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.j4.O();
    }

    public float getThumbStrokeWidth() {
        return this.j4.R();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.j4.z();
    }

    public int getThumbTrackGapSize() {
        return this.D3;
    }

    @Px
    public int getThumbWidth() {
        return this.A3;
    }

    @Px
    public int getTickActiveRadius() {
        return this.V3;
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.c4;
    }

    @Px
    public int getTickInactiveRadius() {
        return this.W3;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.d4;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.d4.equals(this.c4)) {
            return this.c4;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.e4;
    }

    @Px
    public int getTrackHeight() {
        return this.y3;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.f4;
    }

    public int getTrackInsideCornerSize() {
        return this.H3;
    }

    @Px
    public int getTrackSidePadding() {
        return this.z3;
    }

    public int getTrackStopIndicatorSize() {
        return this.G3;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.f4.equals(this.e4)) {
            return this.e4;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Px
    public int getTrackWidth() {
        return this.X3;
    }

    public float getValueFrom() {
        return this.N3;
    }

    public float getValueTo() {
        return this.O3;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.P3);
    }

    public void h(@NonNull L l2) {
        this.i3.add(l2);
    }

    public void i(@NonNull T t) {
        this.j3.add(t);
    }

    /* access modifiers changed from: protected */
    public boolean l0() {
        if (this.Q3 != -1) {
            return true;
        }
        float M = M();
        float M0 = M0(M);
        this.Q3 = 0;
        float abs = Math.abs(this.P3.get(0).floatValue() - M);
        for (int i2 = 1; i2 < this.P3.size(); i2++) {
            float abs2 = Math.abs(this.P3.get(i2).floatValue() - M);
            float M02 = M0(this.P3.get(i2).floatValue());
            if (Float.compare(abs2, abs) > 0) {
                break;
            }
            boolean z = !V() ? M02 - M0 < 0.0f : M02 - M0 > 0.0f;
            if (Float.compare(abs2, abs) >= 0) {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(M02 - M0) < ((float) this.n3)) {
                    this.Q3 = -1;
                    return false;
                } else if (!z) {
                }
            }
            this.Q3 = i2;
            abs = abs2;
        }
        return this.Q3 != -1;
    }

    public void o0(@NonNull L l2) {
        this.i3.remove(l2);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.o4);
        for (TooltipDrawable k2 : this.h3) {
            k(k2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.f3;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        this.k3 = false;
        for (TooltipDrawable t : this.h3) {
            t(t);
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.o4);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        if (this.a4) {
            F0();
            Z();
        }
        super.onDraw(canvas);
        int o = o();
        float floatValue = this.P3.get(0).floatValue();
        ArrayList<Float> arrayList = this.P3;
        float floatValue2 = arrayList.get(arrayList.size() - 1).floatValue();
        if (floatValue2 < this.O3 || (this.P3.size() > 1 && floatValue > this.N3)) {
            y(canvas, this.X3, o);
        }
        if (floatValue2 > this.N3) {
            x(canvas, this.X3, o);
        }
        c0(canvas);
        b0(canvas, o);
        if ((this.M3 || isFocused()) && isEnabled()) {
            a0(canvas, this.X3, o);
        }
        B0();
        A(canvas, this.X3, o);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, @Nullable Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (!z) {
            this.Q3 = -1;
            this.d3.o(this.R3);
            return;
        }
        D(i2);
        this.d3.X(this.R3);
    }

    public boolean onKeyDown(int i2, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.P3.size() == 1) {
            this.Q3 = 0;
        }
        if (this.Q3 == -1) {
            Boolean i0 = i0(i2, keyEvent);
            return i0 != null ? i0.booleanValue() : super.onKeyDown(i2, keyEvent);
        }
        this.Z3 |= keyEvent.isLongPress();
        Float l2 = l(i2);
        if (l2 != null) {
            if (v0(this.P3.get(this.Q3).floatValue() + l2.floatValue())) {
                A0();
                postInvalidate();
            }
            return true;
        }
        if (i2 != 23) {
            if (i2 != 61) {
                if (i2 != 66) {
                    return super.onKeyDown(i2, keyEvent);
                }
            } else if (keyEvent.hasNoModifiers()) {
                return f0(1);
            } else {
                if (keyEvent.isShiftPressed()) {
                    return f0(-1);
                }
                return false;
            }
        }
        this.Q3 = -1;
        postInvalidate();
        return true;
    }

    public boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        this.Z3 = false;
        return super.onKeyUp(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i5) {
        int i6 = this.w3;
        int i7 = 0;
        if (this.x3 == 1 || t0()) {
            i7 = this.h3.get(0).getIntrinsicHeight();
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(i6 + i7, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.N3 = sliderState.s;
        this.O3 = sliderState.X;
        s0(sliderState.Y);
        this.S3 = sliderState.Z;
        if (sliderState.X2) {
            requestFocus();
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.s = this.N3;
        sliderState.X = this.O3;
        sliderState.Y = new ArrayList<>(this.P3);
        sliderState.Z = this.S3;
        sliderState.X2 = hasFocus();
        return sliderState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i5, int i6, int i7) {
        D0(i2);
        A0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
        if (r2 != 3) goto L_0x0123;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.isEnabled()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            float r0 = r6.getX()
            int r2 = r5.z3
            float r2 = (float) r2
            float r2 = r0 - r2
            int r3 = r5.X3
            float r3 = (float) r3
            float r2 = r2 / r3
            r5.m4 = r2
            r3 = 0
            float r2 = java.lang.Math.max(r3, r2)
            r5.m4 = r2
            r3 = 1065353216(0x3f800000, float:1.0)
            float r2 = java.lang.Math.min(r3, r2)
            r5.m4 = r2
            int r2 = r6.getActionMasked()
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x00d7
            if (r2 == r4) goto L_0x006f
            if (r2 == r3) goto L_0x0037
            r0 = 3
            if (r2 == r0) goto L_0x006f
            goto L_0x0123
        L_0x0037:
            boolean r2 = r5.M3
            if (r2 != 0) goto L_0x005a
            boolean r2 = r5.U(r6)
            if (r2 == 0) goto L_0x0050
            float r2 = r5.J3
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            int r2 = r5.n3
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0050
            return r1
        L_0x0050:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r4)
            r5.j0()
        L_0x005a:
            boolean r0 = r5.l0()
            if (r0 != 0) goto L_0x0062
            goto L_0x0123
        L_0x0062:
            r5.M3 = r4
            r5.y0()
            r5.A0()
        L_0x006a:
            r5.invalidate()
            goto L_0x0123
        L_0x006f:
            r5.M3 = r1
            android.view.MotionEvent r0 = r5.K3
            if (r0 == 0) goto L_0x00b0
            int r0 = r0.getActionMasked()
            if (r0 != 0) goto L_0x00b0
            android.view.MotionEvent r0 = r5.K3
            float r0 = r0.getX()
            float r1 = r6.getX()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            int r1 = r5.n3
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x00b0
            android.view.MotionEvent r0 = r5.K3
            float r0 = r0.getY()
            float r1 = r6.getY()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            int r1 = r5.n3
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x00b0
            boolean r0 = r5.l0()
            if (r0 == 0) goto L_0x00b0
            r5.j0()
        L_0x00b0:
            int r0 = r5.Q3
            r1 = -1
            if (r0 == r1) goto L_0x006a
            r5.y0()
            r5.A0()
            boolean r0 = r5.N()
            if (r0 == 0) goto L_0x00d1
            int r0 = r5.E3
            if (r0 == r1) goto L_0x00d1
            int r2 = r5.F3
            if (r2 == r1) goto L_0x00d1
            r5.setThumbWidth(r0)
            int r0 = r5.F3
            r5.setThumbTrackGapSize(r0)
        L_0x00d1:
            r5.Q3 = r1
            r5.k0()
            goto L_0x006a
        L_0x00d7:
            r5.J3 = r0
            boolean r0 = r5.U(r6)
            if (r0 == 0) goto L_0x00e0
            goto L_0x0123
        L_0x00e0:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r4)
            boolean r0 = r5.l0()
            if (r0 != 0) goto L_0x00ee
            goto L_0x0123
        L_0x00ee:
            r5.requestFocus()
            r5.M3 = r4
            r5.y0()
            r5.A0()
            boolean r0 = r5.N()
            if (r0 == 0) goto L_0x011d
            int r0 = r5.A3
            r5.E3 = r0
            int r1 = r5.D3
            r5.F3 = r1
            float r0 = (float) r0
            r1 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 * r1
            int r0 = java.lang.Math.round(r0)
            int r1 = r5.A3
            int r1 = r1 - r0
            r5.setThumbWidth(r0)
            int r0 = r5.D3
            int r1 = r1 / r3
            int r0 = r0 - r1
            r5.setThumbTrackGapSize(r0)
        L_0x011d:
            r5.invalidate()
            r5.j0()
        L_0x0123:
            boolean r0 = r5.M3
            r5.setPressed(r0)
            android.view.MotionEvent r6 = android.view.MotionEvent.obtain(r6)
            r5.K3 = r6
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i2) {
        ViewOverlayImpl m2;
        super.onVisibilityChanged(view, i2);
        if (i2 != 0 && (m2 = ViewUtils.m(this)) != null) {
            for (TooltipDrawable b2 : this.h3) {
                m2.b(b2);
            }
        }
    }

    public void p() {
        this.i3.clear();
    }

    public void p0(@NonNull T t) {
        this.j3.remove(t);
    }

    public void q() {
        this.j3.clear();
    }

    /* access modifiers changed from: protected */
    public void setActiveThumbIndex(int i2) {
        this.Q3 = i2;
    }

    /* access modifiers changed from: package-private */
    public void setCustomThumbDrawable(@DrawableRes int i2) {
        setCustomThumbDrawable(getResources().getDrawable(i2));
    }

    /* access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            drawableArr[i2] = getResources().getDrawable(iArr[i2]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, (Paint) null);
    }

    public void setFocusedThumbIndex(int i2) {
        if (i2 < 0 || i2 >= this.P3.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.R3 = i2;
        this.d3.X(i2);
        postInvalidate();
    }

    public void setHaloRadius(@Px @IntRange(from = 0) int i2) {
        if (i2 != this.C3) {
            this.C3 = i2;
            Drawable background = getBackground();
            if (u0() || !(background instanceof RippleDrawable)) {
                postInvalidate();
            } else {
                DrawableUtils.m((RippleDrawable) background, this.C3);
            }
        }
    }

    public void setHaloRadiusResource(@DimenRes int i2) {
        setHaloRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.b4)) {
            this.b4 = colorStateList;
            Drawable background = getBackground();
            if (u0() || !(background instanceof RippleDrawable)) {
                this.Z2.setColor(J(colorStateList));
                this.Z2.setAlpha(63);
                invalidate();
                return;
            }
            ((RippleDrawable) background).setColor(colorStateList);
        }
    }

    public void setLabelBehavior(int i2) {
        if (this.x3 != i2) {
            this.x3 = i2;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        this.L3 = labelFormatter;
    }

    /* access modifiers changed from: protected */
    public void setSeparationUnit(int i2) {
        this.n4 = i2;
        this.a4 = true;
        postInvalidate();
    }

    public void setStepSize(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException(String.format(u4, new Object[]{Float.valueOf(f2), Float.valueOf(this.N3), Float.valueOf(this.O3)}));
        } else if (this.S3 != f2) {
            this.S3 = f2;
            this.a4 = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f2) {
        this.j4.o0(f2);
    }

    public void setThumbElevationResource(@DimenRes int i2) {
        setThumbElevation(getResources().getDimension(i2));
    }

    public void setThumbHeight(@Px @IntRange(from = 0) int i2) {
        if (i2 != this.B3) {
            this.B3 = i2;
            this.j4.setBounds(0, 0, this.A3, i2);
            Drawable drawable = this.k4;
            if (drawable != null) {
                j(drawable);
            }
            for (Drawable j2 : this.l4) {
                j(j2);
            }
            E0();
        }
    }

    public void setThumbHeightResource(@DimenRes int i2) {
        setThumbHeight(getResources().getDimensionPixelSize(i2));
    }

    public void setThumbRadius(@Px @IntRange(from = 0) int i2) {
        int i5 = i2 * 2;
        setThumbWidth(i5);
        setThumbHeight(i5);
    }

    public void setThumbRadiusResource(@DimenRes int i2) {
        setThumbRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.j4.G0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i2) {
        if (i2 != 0) {
            setThumbStrokeColor(AppCompatResources.a(getContext(), i2));
        }
    }

    public void setThumbStrokeWidth(float f2) {
        this.j4.J0(f2);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i2) {
        if (i2 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i2));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.j4.z())) {
            this.j4.p0(colorStateList);
            invalidate();
        }
    }

    public void setThumbTrackGapSize(@Px int i2) {
        if (this.D3 != i2) {
            this.D3 = i2;
            invalidate();
        }
    }

    public void setThumbWidth(@Px @IntRange(from = 0) int i2) {
        if (i2 != this.A3) {
            this.A3 = i2;
            this.j4.setShapeAppearanceModel(ShapeAppearanceModel.a().q(0, ((float) this.A3) / 2.0f).m());
            this.j4.setBounds(0, 0, this.A3, this.B3);
            Drawable drawable = this.k4;
            if (drawable != null) {
                j(drawable);
            }
            for (Drawable j2 : this.l4) {
                j(j2);
            }
            E0();
        }
    }

    public void setThumbWidthResource(@DimenRes int i2) {
        setThumbWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setTickActiveRadius(@Px @IntRange(from = 0) int i2) {
        if (this.V3 != i2) {
            this.V3 = i2;
            this.b3.setStrokeWidth((float) (i2 * 2));
            E0();
        }
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.c4)) {
            this.c4 = colorStateList;
            this.b3.setColor(J(colorStateList));
            invalidate();
        }
    }

    public void setTickInactiveRadius(@Px @IntRange(from = 0) int i2) {
        if (this.W3 != i2) {
            this.W3 = i2;
            this.a3.setStrokeWidth((float) (i2 * 2));
            E0();
        }
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.d4)) {
            this.d4 = colorStateList;
            this.a3.setColor(J(colorStateList));
            invalidate();
        }
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z) {
        if (this.U3 != z) {
            this.U3 = z;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.e4)) {
            this.e4 = colorStateList;
            this.X2.setColor(J(colorStateList));
            this.c3.setColor(J(this.e4));
            invalidate();
        }
    }

    public void setTrackHeight(@Px @IntRange(from = 0) int i2) {
        if (this.y3 != i2) {
            this.y3 = i2;
            Q();
            E0();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (!colorStateList.equals(this.f4)) {
            this.f4 = colorStateList;
            this.s.setColor(J(colorStateList));
            invalidate();
        }
    }

    public void setTrackInsideCornerSize(@Px int i2) {
        if (this.H3 != i2) {
            this.H3 = i2;
            invalidate();
        }
    }

    public void setTrackStopIndicatorSize(@Px int i2) {
        if (this.G3 != i2) {
            this.G3 = i2;
            this.c3.setStrokeWidth((float) i2);
            invalidate();
        }
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f2) {
        this.N3 = f2;
        this.a4 = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.O3 = f2;
        this.a4 = true;
        postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public void setValues(@NonNull List<Float> list) {
        s0(new ArrayList(list));
    }

    /* access modifiers changed from: package-private */
    public void z0(int i2, Rect rect) {
        int h0 = this.z3 + ((int) (h0(getValues().get(i2).floatValue()) * ((float) this.X3)));
        int o = o();
        int max = Math.max(this.A3 / 2, this.u3 / 2);
        int max2 = Math.max(this.B3 / 2, this.u3 / 2);
        rect.set(h0 - max, o - max2, h0 + max, o + max2);
    }

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() {
            @NonNull
            /* renamed from: a */
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel);
            }

            @NonNull
            /* renamed from: b */
            public SliderState[] newArray(int i2) {
                return new SliderState[i2];
            }
        };
        float X;
        boolean X2;
        ArrayList<Float> Y;
        float Z;
        float s;

        private SliderState(@NonNull Parcel parcel) {
            super(parcel);
            this.s = parcel.readFloat();
            this.X = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.Y = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.Z = parcel.readFloat();
            this.X2 = parcel.createBooleanArray()[0];
        }

        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.s);
            parcel.writeFloat(this.X);
            parcel.writeList(this.Y);
            parcel.writeFloat(this.Z);
            parcel.writeBooleanArray(new boolean[]{this.X2});
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Gg);
    }

    /* access modifiers changed from: package-private */
    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        this.k4 = P(drawable);
        this.l4.clear();
        postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        this.k4 = null;
        this.l4 = new ArrayList();
        for (Drawable P : drawableArr) {
            this.l4.add(P(P));
        }
        postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public void setValues(@NonNull Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        s0(arrayList);
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(MaterialThemeOverlay.c(context, attributeSet, i2, D4), attributeSet, i2);
        this.h3 = new ArrayList();
        this.i3 = new ArrayList();
        this.j3 = new ArrayList();
        this.k3 = false;
        this.E3 = -1;
        this.F3 = -1;
        this.M3 = false;
        this.P3 = new ArrayList<>();
        this.Q3 = -1;
        this.R3 = -1;
        this.S3 = 0.0f;
        this.U3 = true;
        this.Z3 = false;
        this.g4 = new Path();
        this.h4 = new RectF();
        this.i4 = new RectF();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.j4 = materialShapeDrawable;
        this.l4 = Collections.emptyList();
        this.n4 = 0;
        this.o4 = new a(this);
        Context context2 = getContext();
        this.s = new Paint();
        this.X2 = new Paint();
        Paint paint = new Paint(1);
        this.Y2 = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.Z2 = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.a3 = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.b3 = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.c3 = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Y(context2.getResources());
        n0(context2, attributeSet, i2);
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.y0(2);
        this.n3 = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper = new AccessibilityHelper(this);
        this.d3 = accessibilityHelper;
        ViewCompat.H1(this, accessibilityHelper);
        this.e3 = (AccessibilityManager) getContext().getSystemService("accessibility");
    }
}
