package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CarouselLayoutManager extends RecyclerView.LayoutManager implements Carousel, RecyclerView.SmoothScroller.ScrollVectorProvider {
    private static final String H = "CarouselLayoutManager";
    public static final int I = 0;
    public static final int J = 1;
    public static final int K = 0;
    public static final int L = 1;
    private int A;
    @Nullable
    private Map<Integer, KeylineState> B;
    private CarouselOrientationHelper C;
    private final View.OnLayoutChangeListener D;
    private int E;
    private int F;
    private int G;
    @VisibleForTesting
    int s;
    @VisibleForTesting
    int t;
    @VisibleForTesting
    int u;
    private boolean v;
    private final DebugItemDecoration w;
    @NonNull
    private CarouselStrategy x;
    /* access modifiers changed from: private */
    @Nullable
    public KeylineStateList y;
    @Nullable
    private KeylineState z;

    private static final class ChildCalculations {

        /* renamed from: a  reason: collision with root package name */
        final View f20925a;

        /* renamed from: b  reason: collision with root package name */
        final float f20926b;

        /* renamed from: c  reason: collision with root package name */
        final float f20927c;

        /* renamed from: d  reason: collision with root package name */
        final KeylineRange f20928d;

        ChildCalculations(View view, float f2, float f3, KeylineRange keylineRange) {
            this.f20925a = view;
            this.f20926b = f2;
            this.f20927c = f3;
            this.f20928d = keylineRange;
        }
    }

    private static class DebugItemDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        private final Paint f20929a;

        /* renamed from: b  reason: collision with root package name */
        private List<KeylineState.Keyline> f20930b = Collections.unmodifiableList(new ArrayList());

        DebugItemDecoration() {
            Paint paint = new Paint();
            this.f20929a = paint;
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        public void k(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            float t2;
            float f2;
            float u2;
            float f3;
            super.k(canvas, recyclerView, state);
            this.f20929a.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.D3));
            for (KeylineState.Keyline next : this.f20930b) {
                this.f20929a.setColor(ColorUtils.j(-65281, -16776961, next.f20965c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).g()) {
                    t2 = next.f20964b;
                    f2 = (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).Z2();
                    u2 = next.f20964b;
                    f3 = (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).U2();
                } else {
                    t2 = (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).W2();
                    f2 = next.f20964b;
                    u2 = (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).X2();
                    f3 = next.f20964b;
                }
                canvas.drawLine(t2, f2, u2, f3, this.f20929a);
            }
        }

        /* access modifiers changed from: package-private */
        public void l(List<KeylineState.Keyline> list) {
            this.f20930b = Collections.unmodifiableList(list);
        }
    }

    private static class KeylineRange {

        /* renamed from: a  reason: collision with root package name */
        final KeylineState.Keyline f20931a;

        /* renamed from: b  reason: collision with root package name */
        final KeylineState.Keyline f20932b;

        KeylineRange(KeylineState.Keyline keyline, KeylineState.Keyline keyline2) {
            Preconditions.a(keyline.f20963a <= keyline2.f20963a);
            this.f20931a = keyline;
            this.f20932b = keyline2;
        }
    }

    private static class LayoutDirection {

        /* renamed from: a  reason: collision with root package name */
        private static final int f20933a = -1;

        /* renamed from: b  reason: collision with root package name */
        private static final int f20934b = 1;

        /* renamed from: c  reason: collision with root package name */
        private static final int f20935c = Integer.MIN_VALUE;

        private LayoutDirection() {
        }
    }

    public CarouselLayoutManager() {
        this(new MultiBrowseCarouselStrategy());
    }

    private void A2(RecyclerView.Recycler recycler, int i2) {
        float C2 = C2(i2);
        while (i2 >= 0) {
            ChildCalculations j3 = j3(recycler, C2, i2);
            if (!g3(j3.f20927c, j3.f20928d)) {
                C2 = x2(C2, this.z.f());
                if (!f3(j3.f20927c, j3.f20928d)) {
                    v2(j3.f20925a, 0, j3);
                }
                i2--;
            } else {
                return;
            }
        }
    }

    private float B2(View view, float f2, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.f20931a;
        float f3 = keyline.f20964b;
        KeylineState.Keyline keyline2 = keylineRange.f20932b;
        float b2 = AnimationUtils.b(f3, keyline2.f20964b, keyline.f20963a, keyline2.f20963a, f2);
        if (keylineRange.f20932b != this.z.c() && keylineRange.f20931a != this.z.j()) {
            return b2;
        }
        float f4 = this.C.f((RecyclerView.LayoutParams) view.getLayoutParams()) / this.z.f();
        KeylineState.Keyline keyline3 = keylineRange.f20932b;
        return b2 + ((f2 - keyline3.f20963a) * ((1.0f - keyline3.f20965c) + f4));
    }

    private float C2(int i2) {
        return w2((float) (Y2() - this.s), this.z.f() * ((float) i2));
    }

    private int D2(RecyclerView.State state, KeylineStateList keylineStateList) {
        boolean e3 = e3();
        KeylineState l2 = e3 ? keylineStateList.l() : keylineStateList.h();
        KeylineState.Keyline a2 = e3 ? l2.a() : l2.h();
        int d2 = (int) ((((((float) (state.d() - 1)) * l2.f()) * (e3 ? -1.0f : 1.0f)) - (a2.f20963a - ((float) Y2()))) + (((float) V2()) - a2.f20963a) + (e3 ? -a2.f20969g : a2.f20970h));
        return e3 ? Math.min(0, d2) : Math.max(0, d2);
    }

    private static int F2(int i2, int i3, int i4, int i5) {
        int i6 = i3 + i2;
        if (i6 < i4) {
            return i4 - i3;
        }
        return i6 > i5 ? i5 - i3 : i2;
    }

    private int G2(@NonNull KeylineStateList keylineStateList) {
        boolean e3 = e3();
        KeylineState h2 = e3 ? keylineStateList.h() : keylineStateList.l();
        return (int) (((float) Y2()) - x2((e3 ? h2.h() : h2.a()).f20963a, h2.f() / 2.0f));
    }

    private int H2(int i2) {
        int T2 = T2();
        if (i2 == 1) {
            return -1;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 != 17) {
            if (i2 == 33) {
                return T2 == 1 ? -1 : Integer.MIN_VALUE;
            }
            if (i2 != 66) {
                if (i2 == 130) {
                    return T2 == 1 ? 1 : Integer.MIN_VALUE;
                }
                Log.d(H, "Unknown focus request:" + i2);
                return Integer.MIN_VALUE;
            } else if (T2 == 0) {
                return e3() ? -1 : 1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (T2 == 0) {
            return e3() ? 1 : -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private void I2(RecyclerView.Recycler recycler, RecyclerView.State state) {
        n3(recycler);
        if (V() == 0) {
            A2(recycler, this.A - 1);
            z2(recycler, state, this.A);
        } else {
            int w0 = w0(U(0));
            int w02 = w0(U(V() - 1));
            A2(recycler, w0 - 1);
            z2(recycler, state, w02 + 1);
        }
        y3();
    }

    private View J2() {
        return U(e3() ? 0 : V() - 1);
    }

    private View K2() {
        return U(e3() ? V() - 1 : 0);
    }

    private int L2() {
        return g() ? c() : d();
    }

    private float M2(View view) {
        Rect rect = new Rect();
        super.c0(view, rect);
        return (float) (g() ? rect.centerX() : rect.centerY());
    }

    private int N2() {
        int i2;
        int i3;
        if (V() <= 0) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) U(0).getLayoutParams();
        if (this.C.f20936a == 0) {
            i2 = layoutParams.leftMargin;
            i3 = layoutParams.rightMargin;
        } else {
            i2 = layoutParams.topMargin;
            i3 = layoutParams.bottomMargin;
        }
        return i2 + i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r4 = r0.get(java.lang.Integer.valueOf(androidx.core.math.MathUtils.e(r4, 0, java.lang.Math.max(0, b() - 1))));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.material.carousel.KeylineState O2(int r4) {
        /*
            r3 = this;
            java.util.Map<java.lang.Integer, com.google.android.material.carousel.KeylineState> r0 = r3.B
            if (r0 == 0) goto L_0x0020
            int r1 = r3.b()
            int r1 = r1 + -1
            r2 = 0
            int r1 = java.lang.Math.max(r2, r1)
            int r4 = androidx.core.math.MathUtils.e(r4, r2, r1)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r0.get(r4)
            com.google.android.material.carousel.KeylineState r4 = (com.google.android.material.carousel.KeylineState) r4
            if (r4 == 0) goto L_0x0020
            return r4
        L_0x0020:
            com.google.android.material.carousel.KeylineStateList r4 = r3.y
            com.google.android.material.carousel.KeylineState r4 = r4.g()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.O2(int):com.google.android.material.carousel.KeylineState");
    }

    private int P2() {
        if (Z() || !this.x.f()) {
            return 0;
        }
        return T2() == 1 ? v0() : s0();
    }

    private float Q2(float f2, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.f20931a;
        float f3 = keyline.f20966d;
        KeylineState.Keyline keyline2 = keylineRange.f20932b;
        return AnimationUtils.b(f3, keyline2.f20966d, keyline.f20964b, keyline2.f20964b, f2);
    }

    /* access modifiers changed from: private */
    public int U2() {
        return this.C.h();
    }

    private int V2() {
        return this.C.i();
    }

    /* access modifiers changed from: private */
    public int W2() {
        return this.C.j();
    }

    /* access modifiers changed from: private */
    public int X2() {
        return this.C.k();
    }

    private int Y2() {
        return this.C.l();
    }

    /* access modifiers changed from: private */
    public int Z2() {
        return this.C.m();
    }

    private int a3() {
        if (Z() || !this.x.f()) {
            return 0;
        }
        return T2() == 1 ? q0() : t0();
    }

    private int b3(int i2, KeylineState keylineState) {
        return e3() ? (int) (((((float) L2()) - keylineState.h().f20963a) - (((float) i2) * keylineState.f())) - (keylineState.f() / 2.0f)) : (int) (((((float) i2) * keylineState.f()) - keylineState.a().f20963a) + (keylineState.f() / 2.0f));
    }

    private int c3(int i2, @NonNull KeylineState keylineState) {
        int i3 = Integer.MAX_VALUE;
        for (KeylineState.Keyline next : keylineState.e()) {
            float f2 = (((float) i2) * keylineState.f()) + (keylineState.f() / 2.0f);
            int L2 = (e3() ? (int) ((((float) L2()) - next.f20963a) - f2) : (int) (f2 - next.f20963a)) - this.s;
            if (Math.abs(i3) > Math.abs(L2)) {
                i3 = L2;
            }
        }
        return i3;
    }

    private static KeylineRange d3(List<KeylineState.Keyline> list, float f2, boolean z2) {
        float f3 = Float.MAX_VALUE;
        float f4 = Float.MAX_VALUE;
        float f5 = Float.MAX_VALUE;
        float f6 = -3.4028235E38f;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < list.size(); i6++) {
            KeylineState.Keyline keyline = list.get(i6);
            float f7 = z2 ? keyline.f20964b : keyline.f20963a;
            float abs = Math.abs(f7 - f2);
            if (f7 <= f2 && abs <= f3) {
                i2 = i6;
                f3 = abs;
            }
            if (f7 > f2 && abs <= f4) {
                i4 = i6;
                f4 = abs;
            }
            if (f7 <= f5) {
                i3 = i6;
                f5 = f7;
            }
            if (f7 > f6) {
                i5 = i6;
                f6 = f7;
            }
        }
        if (i2 == -1) {
            i2 = i3;
        }
        if (i4 == -1) {
            i4 = i5;
        }
        return new KeylineRange(list.get(i2), list.get(i4));
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0018 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean f3(float r3, com.google.android.material.carousel.CarouselLayoutManager.KeylineRange r4) {
        /*
            r2 = this;
            float r4 = r2.Q2(r3, r4)
            r0 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r0
            float r3 = r2.x2(r3, r4)
            boolean r4 = r2.e3()
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L_0x001a
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0024
        L_0x0018:
            r0 = 1
            goto L_0x0024
        L_0x001a:
            int r4 = r2.L2()
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0024
            goto L_0x0018
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.f3(float, com.google.android.material.carousel.CarouselLayoutManager$KeylineRange):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x001c A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean g3(float r3, com.google.android.material.carousel.CarouselLayoutManager.KeylineRange r4) {
        /*
            r2 = this;
            float r4 = r2.Q2(r3, r4)
            r0 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r0
            float r3 = r2.w2(r3, r4)
            boolean r4 = r2.e3()
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L_0x001e
            int r4 = r2.L2()
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0024
        L_0x001c:
            r0 = 1
            goto L_0x0024
        L_0x001e:
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0024
            goto L_0x001c
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.g3(float, com.google.android.material.carousel.CarouselLayoutManager$KeylineRange):boolean");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h3(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 != i6 || i3 != i7 || i4 != i8 || i5 != i9) {
            view.post(new a(this));
        }
    }

    private void i3() {
        if (this.v && Log.isLoggable(H, 3)) {
            Log.d(H, "internal representation of views on the screen");
            for (int i2 = 0; i2 < V(); i2++) {
                View U = U(i2);
                float M2 = M2(U);
                Log.d(H, "item position " + w0(U) + ", center:" + M2 + ", child index:" + i2);
            }
            Log.d(H, "==============");
        }
    }

    private ChildCalculations j3(RecyclerView.Recycler recycler, float f2, int i2) {
        View p = recycler.p(i2);
        V0(p, 0, 0);
        float w2 = w2(f2, this.z.f() / 2.0f);
        KeylineRange d3 = d3(this.z.g(), w2, false);
        return new ChildCalculations(p, w2, B2(p, w2, d3), d3);
    }

    private float k3(View view, float f2, float f3, Rect rect) {
        float w2 = w2(f2, f3);
        KeylineRange d3 = d3(this.z.g(), w2, false);
        float B2 = B2(view, w2, d3);
        super.c0(view, rect);
        v3(view, w2, d3);
        this.C.p(view, rect, f3, B2);
        return B2;
    }

    private void l3(RecyclerView.Recycler recycler) {
        View p = recycler.p(0);
        V0(p, 0, 0);
        KeylineState g2 = this.x.g(this, p);
        if (e3()) {
            g2 = KeylineState.n(g2, (float) L2());
        }
        this.y = KeylineStateList.f(this, g2, (float) N2(), (float) P2(), (float) a3());
    }

    /* access modifiers changed from: private */
    public void m3() {
        this.y = null;
        R1();
    }

    private void n3(RecyclerView.Recycler recycler) {
        while (V() > 0) {
            View U = U(0);
            float M2 = M2(U);
            if (!g3(M2, d3(this.z.g(), M2, true))) {
                break;
            }
            J1(U, recycler);
        }
        while (V() - 1 >= 0) {
            View U2 = U(V() - 1);
            float M22 = M2(U2);
            if (f3(M22, d3(this.z.g(), M22, true))) {
                J1(U2, recycler);
            } else {
                return;
            }
        }
    }

    private int o3(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (V() == 0 || i2 == 0) {
            return 0;
        }
        if (this.y == null) {
            l3(recycler);
        }
        int F2 = F2(i2, this.s, this.t, this.u);
        this.s += F2;
        w3(this.y);
        float f2 = this.z.f() / 2.0f;
        float C2 = C2(w0(U(0)));
        Rect rect = new Rect();
        float f3 = (e3() ? this.z.h() : this.z.a()).f20964b;
        float f4 = Float.MAX_VALUE;
        for (int i3 = 0; i3 < V(); i3++) {
            View U = U(i3);
            float abs = Math.abs(f3 - k3(U, C2, f2, rect));
            if (U != null && abs < f4) {
                this.F = w0(U);
                f4 = abs;
            }
            C2 = w2(C2, this.z.f());
        }
        I2(recycler, state);
        return F2;
    }

    private void p3(RecyclerView recyclerView, int i2) {
        if (g()) {
            recyclerView.scrollBy(i2, 0);
        } else {
            recyclerView.scrollBy(0, i2);
        }
    }

    private void r3(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.b6);
            q3(obtainStyledAttributes.getInt(R.styleable.c6, 0));
            u3(obtainStyledAttributes.getInt(R.styleable.Zr, 0));
            obtainStyledAttributes.recycle();
        }
    }

    private void v2(View view, int i2, ChildCalculations childCalculations) {
        float f2 = this.z.f() / 2.0f;
        k(view, i2);
        float f3 = childCalculations.f20927c;
        this.C.n(view, (int) (f3 - f2), (int) (f3 + f2));
        v3(view, childCalculations.f20926b, childCalculations.f20928d);
    }

    private void v3(View view, float f2, KeylineRange keylineRange) {
        if (view instanceof Maskable) {
            KeylineState.Keyline keyline = keylineRange.f20931a;
            float f3 = keyline.f20965c;
            KeylineState.Keyline keyline2 = keylineRange.f20932b;
            float b2 = AnimationUtils.b(f3, keyline2.f20965c, keyline.f20963a, keyline2.f20963a, f2);
            float height = (float) view.getHeight();
            float width = (float) view.getWidth();
            float b3 = AnimationUtils.b(0.0f, width / 2.0f, 0.0f, 1.0f, b2);
            RectF g2 = this.C.g(height, width, AnimationUtils.b(0.0f, height / 2.0f, 0.0f, 1.0f, b2), b3);
            float B2 = B2(view, f2, keylineRange);
            float height2 = (g2.height() / 2.0f) + B2;
            RectF rectF = new RectF(B2 - (g2.width() / 2.0f), B2 - (g2.height() / 2.0f), B2 + (g2.width() / 2.0f), height2);
            RectF rectF2 = new RectF((float) W2(), (float) Z2(), (float) X2(), (float) U2());
            if (this.x.f()) {
                this.C.a(g2, rectF, rectF2);
            }
            this.C.o(g2, rectF, rectF2);
            ((Maskable) view).setMaskRectF(g2);
        }
    }

    private float w2(float f2, float f3) {
        return e3() ? f2 - f3 : f2 + f3;
    }

    private void w3(@NonNull KeylineStateList keylineStateList) {
        int i2 = this.u;
        int i3 = this.t;
        this.z = i2 <= i3 ? e3() ? keylineStateList.h() : keylineStateList.l() : keylineStateList.j((float) this.s, (float) i3, (float) i2);
        this.w.l(this.z.g());
    }

    private float x2(float f2, float f3) {
        return e3() ? f2 + f3 : f2 - f3;
    }

    private void x3() {
        int b2 = b();
        int i2 = this.E;
        if (b2 != i2 && this.y != null) {
            if (this.x.j(this, i2)) {
                m3();
            }
            this.E = b2;
        }
    }

    private void y2(@NonNull RecyclerView.Recycler recycler, int i2, int i3) {
        if (i2 >= 0 && i2 < b()) {
            ChildCalculations j3 = j3(recycler, C2(i2), i2);
            v2(j3.f20925a, i3, j3);
        }
    }

    private void y3() {
        if (this.v && V() >= 1) {
            int i2 = 0;
            while (i2 < V() - 1) {
                int w0 = w0(U(i2));
                int i3 = i2 + 1;
                int w02 = w0(U(i3));
                if (w0 <= w02) {
                    i2 = i3;
                } else {
                    i3();
                    throw new IllegalStateException("Detected invalid child order. Child at index [" + i2 + "] had adapter position [" + w0 + "] and child at index [" + i3 + "] had adapter position [" + w02 + "].");
                }
            }
        }
    }

    private void z2(RecyclerView.Recycler recycler, RecyclerView.State state, int i2) {
        float C2 = C2(i2);
        while (i2 < state.d()) {
            ChildCalculations j3 = j3(recycler, C2, i2);
            if (!f3(j3.f20927c, j3.f20928d)) {
                C2 = w2(C2, this.z.f());
                if (!g3(j3.f20927c, j3.f20928d)) {
                    v2(j3.f20925a, -1, j3);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public int A(@NonNull RecyclerView.State state) {
        return this.u - this.t;
    }

    public int B(@NonNull RecyclerView.State state) {
        if (V() == 0 || this.y == null || b() <= 1) {
            return 0;
        }
        return (int) (((float) j0()) * (this.y.g().f() / ((float) D(state))));
    }

    public int C(@NonNull RecyclerView.State state) {
        return this.s;
    }

    public int D(@NonNull RecyclerView.State state) {
        return this.u - this.t;
    }

    /* access modifiers changed from: package-private */
    public int E2(int i2) {
        return (int) (((float) this.s) - ((float) b3(i2, O2(i2))));
    }

    public boolean J0() {
        return true;
    }

    public RecyclerView.LayoutParams P() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public boolean Q1(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z2, boolean z3) {
        int c3;
        if (this.y == null || (c3 = c3(w0(view), O2(w0(view)))) == 0) {
            return false;
        }
        p3(recyclerView, c3(w0(view), this.y.j((float) (this.s + F2(c3, this.s, this.t, this.u)), (float) this.t, (float) this.u)));
        return true;
    }

    /* access modifiers changed from: package-private */
    public int R2(int i2, @NonNull KeylineState keylineState) {
        return b3(i2, keylineState) - this.s;
    }

    /* access modifiers changed from: package-private */
    public int S2(int i2, boolean z2) {
        int R2 = R2(i2, this.y.k((float) this.s, (float) this.t, (float) this.u, true));
        int R22 = this.B != null ? R2(i2, O2(i2)) : R2;
        return (!z2 || Math.abs(R22) >= Math.abs(R2)) ? R2 : R22;
    }

    public int T2() {
        return this.C.f20936a;
    }

    public int U1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (s()) {
            return o3(i2, recycler, state);
        }
        return 0;
    }

    public void V0(@NonNull View view, int i2, int i3) {
        if (view instanceof Maskable) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            Rect rect = new Rect();
            r(view, rect);
            int i4 = i2 + rect.left + rect.right;
            int i5 = i3 + rect.top + rect.bottom;
            KeylineStateList keylineStateList = this.y;
            float f2 = (keylineStateList == null || this.C.f20936a != 0) ? (float) layoutParams.width : keylineStateList.g().f();
            KeylineStateList keylineStateList2 = this.y;
            view.measure(RecyclerView.LayoutManager.W(D0(), E0(), s0() + t0() + layoutParams.leftMargin + layoutParams.rightMargin + i4, (int) f2, s()), RecyclerView.LayoutManager.W(j0(), k0(), v0() + q0() + layoutParams.topMargin + layoutParams.bottomMargin + i5, (int) ((keylineStateList2 == null || this.C.f20936a != 1) ? (float) layoutParams.height : keylineStateList2.g().f()), t()));
            return;
        }
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    public void V1(int i2) {
        this.F = i2;
        if (this.y != null) {
            this.s = b3(i2, O2(i2));
            this.A = MathUtils.e(i2, 0, Math.max(0, b() - 1));
            w3(this.y);
            R1();
        }
    }

    public int W1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (t()) {
            return o3(i2, recycler, state);
        }
        return 0;
    }

    @Nullable
    public PointF a(int i2) {
        if (this.y == null) {
            return null;
        }
        int R2 = R2(i2, O2(i2));
        return g() ? new PointF((float) R2, 0.0f) : new PointF(0.0f, (float) R2);
    }

    public void b1(RecyclerView recyclerView) {
        super.b1(recyclerView);
        this.x.e(recyclerView.getContext());
        m3();
        recyclerView.addOnLayoutChangeListener(this.D);
    }

    public int c() {
        return D0();
    }

    public void c0(@NonNull View view, @NonNull Rect rect) {
        super.c0(view, rect);
        float centerY = (float) rect.centerY();
        if (g()) {
            centerY = (float) rect.centerX();
        }
        float Q2 = Q2(centerY, d3(this.z.g(), centerY, true));
        float f2 = 0.0f;
        float width = g() ? (((float) rect.width()) - Q2) / 2.0f : 0.0f;
        if (!g()) {
            f2 = (((float) rect.height()) - Q2) / 2.0f;
        }
        rect.set((int) (((float) rect.left) + width), (int) (((float) rect.top) + f2), (int) (((float) rect.right) - width), (int) (((float) rect.bottom) - f2));
    }

    public int d() {
        return j0();
    }

    public void d1(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.d1(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.D);
    }

    @Nullable
    public View e1(@NonNull View view, int i2, @NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        int H2;
        if (V() == 0 || (H2 = H2(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        int w0 = w0(view);
        if (H2 == -1) {
            if (w0 == 0) {
                return null;
            }
            y2(recycler, w0(U(0)) - 1, 0);
            return K2();
        } else if (w0 == b() - 1) {
            return null;
        } else {
            y2(recycler, w0(U(V() - 1)) + 1, -1);
            return J2();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e3() {
        return g() && m0() == 1;
    }

    public int f() {
        return this.G;
    }

    public void f1(@NonNull AccessibilityEvent accessibilityEvent) {
        super.f1(accessibilityEvent);
        if (V() > 0) {
            accessibilityEvent.setFromIndex(w0(U(0)));
            accessibilityEvent.setToIndex(w0(U(V() - 1)));
        }
    }

    public boolean g() {
        return this.C.f20936a == 0;
    }

    public void j2(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        AnonymousClass1 r2 = new LinearSmoothScroller(recyclerView.getContext()) {
            @Nullable
            public PointF a(int i2) {
                return CarouselLayoutManager.this.a(i2);
            }

            public int u(View view, int i2) {
                if (CarouselLayoutManager.this.y == null || !CarouselLayoutManager.this.g()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.E2(carouselLayoutManager.w0(view));
            }

            public int v(View view, int i2) {
                if (CarouselLayoutManager.this.y == null || CarouselLayoutManager.this.g()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.E2(carouselLayoutManager.w0(view));
            }
        };
        r2.q(i2);
        k2(r2);
    }

    public void m1(@NonNull RecyclerView recyclerView, int i2, int i3) {
        super.m1(recyclerView, i2, i3);
        x3();
    }

    public void p1(@NonNull RecyclerView recyclerView, int i2, int i3) {
        super.p1(recyclerView, i2, i3);
        x3();
    }

    public void q3(int i2) {
        this.G = i2;
        m3();
    }

    public boolean s() {
        return g();
    }

    public void s1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.d() <= 0 || ((float) L2()) <= 0.0f) {
            H1(recycler);
            this.A = 0;
            return;
        }
        boolean e3 = e3();
        boolean z2 = this.y == null;
        if (z2) {
            l3(recycler);
        }
        int G2 = G2(this.y);
        int D2 = D2(state, this.y);
        this.t = e3 ? D2 : G2;
        if (e3) {
            D2 = G2;
        }
        this.u = D2;
        if (z2) {
            this.s = G2;
            this.B = this.y.i(b(), this.t, this.u, e3());
            int i2 = this.F;
            if (i2 != -1) {
                this.s = b3(i2, O2(i2));
            }
        }
        int i3 = this.s;
        this.s = i3 + F2(0, i3, this.t, this.u);
        this.A = MathUtils.e(this.A, 0, state.d());
        w3(this.y);
        E(recycler);
        I2(recycler, state);
        this.E = b();
    }

    public void s3(@NonNull CarouselStrategy carouselStrategy) {
        this.x = carouselStrategy;
        m3();
    }

    public boolean t() {
        return !g();
    }

    public void t1(RecyclerView.State state) {
        super.t1(state);
        if (V() == 0) {
            this.A = 0;
        } else {
            this.A = w0(U(0));
        }
        y3();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void t3(@NonNull RecyclerView recyclerView, boolean z2) {
        this.v = z2;
        recyclerView.A1(this.w);
        if (z2) {
            recyclerView.p(this.w);
        }
        recyclerView.Q0();
    }

    public void u3(int i2) {
        if (i2 == 0 || i2 == 1) {
            n((String) null);
            CarouselOrientationHelper carouselOrientationHelper = this.C;
            if (carouselOrientationHelper == null || i2 != carouselOrientationHelper.f20936a) {
                this.C = CarouselOrientationHelper.c(this, i2);
                m3();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i2);
    }

    public int y(@NonNull RecyclerView.State state) {
        if (V() == 0 || this.y == null || b() <= 1) {
            return 0;
        }
        return (int) (((float) D0()) * (this.y.g().f() / ((float) A(state))));
    }

    public int z(@NonNull RecyclerView.State state) {
        return this.s;
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.v = false;
        this.w = new DebugItemDecoration();
        this.A = 0;
        this.D = new b(this);
        this.F = -1;
        this.G = 0;
        s3(new MultiBrowseCarouselStrategy());
        r3(context, attributeSet);
    }

    public CarouselLayoutManager(@NonNull CarouselStrategy carouselStrategy) {
        this(carouselStrategy, 0);
    }

    public CarouselLayoutManager(@NonNull CarouselStrategy carouselStrategy, int i2) {
        this.v = false;
        this.w = new DebugItemDecoration();
        this.A = 0;
        this.D = new b(this);
        this.F = -1;
        this.G = 0;
        s3(carouselStrategy);
        u3(i2);
    }
}
