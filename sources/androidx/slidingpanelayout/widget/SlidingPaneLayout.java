package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    private static final String t3 = "SlidingPaneLayout";
    private static final int u3 = 32;
    private static final int v3 = -858993460;
    private static final int w3 = 400;
    private int X2;
    private Drawable Y2;
    private Drawable Z2;
    private final int a3;
    private boolean b3;
    View c3;
    float d3;
    private float e3;
    int f3;
    boolean g3;
    private int h3;
    private float i3;
    private float j3;
    private PanelSlideListener k3;
    final ViewDragHelper l3;
    boolean m3;
    private boolean n3;
    private final Rect o3;
    final ArrayList<DisableLayerRunnable> p3;
    private Method q3;
    private Field r3;
    private int s;
    private boolean s3;

    class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: d  reason: collision with root package name */
        private final Rect f15803d = new Rect();

        AccessibilityDelegate() {
        }

        private void n(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f15803d;
            accessibilityNodeInfoCompat2.s(rect);
            accessibilityNodeInfoCompat.d1(rect);
            accessibilityNodeInfoCompat2.t(rect);
            accessibilityNodeInfoCompat.e1(rect);
            accessibilityNodeInfoCompat.p2(accessibilityNodeInfoCompat2.M0());
            accessibilityNodeInfoCompat.N1(accessibilityNodeInfoCompat2.S());
            accessibilityNodeInfoCompat.j1(accessibilityNodeInfoCompat2.y());
            accessibilityNodeInfoCompat.o1(accessibilityNodeInfoCompat2.D());
            accessibilityNodeInfoCompat.u1(accessibilityNodeInfoCompat2.x0());
            accessibilityNodeInfoCompat.k1(accessibilityNodeInfoCompat2.s0());
            accessibilityNodeInfoCompat.w1(accessibilityNodeInfoCompat2.y0());
            accessibilityNodeInfoCompat.x1(accessibilityNodeInfoCompat2.z0());
            accessibilityNodeInfoCompat.a1(accessibilityNodeInfoCompat2.p0());
            accessibilityNodeInfoCompat.Y1(accessibilityNodeInfoCompat2.I0());
            accessibilityNodeInfoCompat.I1(accessibilityNodeInfoCompat2.D0());
            accessibilityNodeInfoCompat.a(accessibilityNodeInfoCompat2.p());
            accessibilityNodeInfoCompat.L1(accessibilityNodeInfoCompat2.Q());
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat Q0 = AccessibilityNodeInfoCompat.Q0(accessibilityNodeInfoCompat);
            super.g(view, Q0);
            n(accessibilityNodeInfoCompat, Q0);
            Q0.T0();
            accessibilityNodeInfoCompat.j1(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.a2(view);
            ViewParent o0 = ViewCompat.o0(view);
            if (o0 instanceof View) {
                accessibilityNodeInfoCompat.P1((View) o0);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i2);
                if (!o(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.Z1(childAt, 1);
                    accessibilityNodeInfoCompat.c(childAt);
                }
            }
        }

        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!o(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        public boolean o(View view) {
            return SlidingPaneLayout.this.j(view);
        }
    }

    private class DisableLayerRunnable implements Runnable {
        final View s;

        DisableLayerRunnable(View view) {
            this.s = view;
        }

        public void run() {
            if (this.s.getParent() == SlidingPaneLayout.this) {
                this.s.setLayerType(0, (Paint) null);
                SlidingPaneLayout.this.i(this.s);
            }
            SlidingPaneLayout.this.p3.remove(this);
        }
    }

    private class DragHelperCallback extends ViewDragHelper.Callback {
        DragHelperCallback() {
        }

        public int a(View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.c3.getLayoutParams();
            if (SlidingPaneLayout.this.k()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.c3.getWidth());
                return Math.max(Math.min(i2, width), width - SlidingPaneLayout.this.f3);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i2, paddingLeft), SlidingPaneLayout.this.f3 + paddingLeft);
        }

        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        public int d(View view) {
            return SlidingPaneLayout.this.f3;
        }

        public void f(int i2, int i3) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.l3.d(slidingPaneLayout.c3, i3);
        }

        public void i(View view, int i2) {
            SlidingPaneLayout.this.r();
        }

        public void j(int i2) {
            SlidingPaneLayout slidingPaneLayout;
            boolean z;
            if (SlidingPaneLayout.this.l3.F() == 0) {
                SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                if (slidingPaneLayout2.d3 == 0.0f) {
                    slidingPaneLayout2.v(slidingPaneLayout2.c3);
                    SlidingPaneLayout slidingPaneLayout3 = SlidingPaneLayout.this;
                    slidingPaneLayout3.f(slidingPaneLayout3.c3);
                    slidingPaneLayout = SlidingPaneLayout.this;
                    z = false;
                } else {
                    slidingPaneLayout2.g(slidingPaneLayout2.c3);
                    slidingPaneLayout = SlidingPaneLayout.this;
                    z = true;
                }
                slidingPaneLayout.m3 = z;
            }
        }

        public void k(View view, int i2, int i3, int i4, int i5) {
            SlidingPaneLayout.this.n(i2);
            SlidingPaneLayout.this.invalidate();
        }

        public void l(View view, float f2, float f3) {
            int i2;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.k()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f2 < 0.0f || (f2 == 0.0f && SlidingPaneLayout.this.d3 > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f3;
                }
                i2 = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.c3.getWidth();
            } else {
                i2 = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i3 > 0 || (i3 == 0 && SlidingPaneLayout.this.d3 > 0.5f)) {
                    i2 += SlidingPaneLayout.this.f3;
                }
            }
            SlidingPaneLayout.this.l3.V(i2, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean m(View view, int i2) {
            if (SlidingPaneLayout.this.g3) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f15808b;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: e  reason: collision with root package name */
        private static final int[] f15806e = {16843137};

        /* renamed from: a  reason: collision with root package name */
        public float f15807a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        boolean f15808b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15809c;

        /* renamed from: d  reason: collision with root package name */
        Paint f15810d;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f15806e);
            this.f15807a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.f15807a = layoutParams.f15807a;
        }
    }

    public interface PanelSlideListener {
        void a(@NonNull View view, float f2);

        void b(@NonNull View view);

        void c(@NonNull View view);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        boolean Y;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Y = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.Y ? 1 : 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void a(View view, float f2) {
        }

        public void b(View view) {
        }

        public void c(View view) {
        }
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean d(View view, int i2) {
        if (!this.n3 && !u(0.0f, i2)) {
            return false;
        }
        this.m3 = false;
        return true;
    }

    private void e(View view, float f2, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 > 0.0f && i2 != 0) {
            int i4 = (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24) | (i2 & ViewCompat.x);
            if (layoutParams.f15810d == null) {
                layoutParams.f15810d = new Paint();
            }
            layoutParams.f15810d.setColorFilter(new PorterDuffColorFilter(i4, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.f15810d);
            }
            i(view);
        } else if (view.getLayerType() != 0) {
            Paint paint = layoutParams.f15810d;
            if (paint != null) {
                paint.setColorFilter((ColorFilter) null);
            }
            DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(view);
            this.p3.add(disableLayerRunnable);
            ViewCompat.v1(this, disableLayerRunnable);
        }
    }

    private boolean p(View view, int i2) {
        if (!this.n3 && !u(1.0f, i2)) {
            return false;
        }
        this.m3 = true;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.k()
            android.view.View r1 = r9.c3
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.f15809c
            r3 = 0
            if (r2 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0016
            int r1 = r1.rightMargin
            goto L_0x0018
        L_0x0016:
            int r1 = r1.leftMargin
        L_0x0018:
            if (r1 > 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            int r2 = r9.getChildCount()
        L_0x0021:
            if (r3 >= r2) goto L_0x0059
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.c3
            if (r4 != r5) goto L_0x002c
            goto L_0x0056
        L_0x002c:
            float r5 = r9.e3
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.h3
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.e3 = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L_0x0044
            int r5 = -r5
        L_0x0044:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L_0x0056
            float r5 = r9.e3
            if (r0 == 0) goto L_0x004f
            float r5 = r5 - r6
            goto L_0x0051
        L_0x004f:
            float r5 = r6 - r5
        L_0x0051:
            int r6 = r9.X2
            r9.e(r4, r5, r6)
        L_0x0056:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.q(float):void");
    }

    private static boolean w(View view) {
        return view.isOpaque();
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, boolean z, int i2, int i4, int i5) {
        int i6;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i7 = i4 + scrollX;
                if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && (i6 = i5 + scrollY) >= childAt.getTop() && i6 < childAt.getBottom()) {
                    if (a(childAt, true, i2, i7 - childAt.getLeft(), i6 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z) {
            if (view.canScrollHorizontally(k() ? i2 : -i2)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean b() {
        return this.b3;
    }

    public boolean c() {
        return d(this.c3, 0);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.l3.o(true)) {
            return;
        }
        if (!this.b3) {
            this.l3.a();
        } else {
            ViewCompat.t1(this);
        }
    }

    public void draw(Canvas canvas) {
        int i2;
        int i4;
        super.draw(canvas);
        Drawable drawable = k() ? this.Z2 : this.Y2;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (k()) {
                i4 = childAt.getRight();
                i2 = intrinsicWidth + i4;
            } else {
                int left = childAt.getLeft();
                int i5 = left - intrinsicWidth;
                i2 = left;
                i4 = i5;
            }
            drawable.setBounds(i4, top, i2, bottom);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.b3 && !layoutParams.f15808b && this.c3 != null) {
            canvas.getClipBounds(this.o3);
            if (k()) {
                Rect rect = this.o3;
                rect.left = Math.max(rect.left, this.c3.getRight());
            } else {
                Rect rect2 = this.o3;
                rect2.right = Math.min(rect2.right, this.c3.getLeft());
            }
            canvas.clipRect(this.o3);
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public void f(View view) {
        PanelSlideListener panelSlideListener = this.k3;
        if (panelSlideListener != null) {
            panelSlideListener.c(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public void g(View view) {
        PanelSlideListener panelSlideListener = this.k3;
        if (panelSlideListener != null) {
            panelSlideListener.b(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.X2;
    }

    @Px
    public int getParallaxDistance() {
        return this.h3;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public void h(View view) {
        PanelSlideListener panelSlideListener = this.k3;
        if (panelSlideListener != null) {
            panelSlideListener.a(view, this.d3);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(View view) {
        ViewCompat.f2(view, ((LayoutParams) view.getLayoutParams()).f15810d);
    }

    /* access modifiers changed from: package-private */
    public boolean j(View view) {
        if (view == null) {
            return false;
        }
        return this.b3 && ((LayoutParams) view.getLayoutParams()).f15809c && this.d3 > 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return ViewCompat.c0(this) == 1;
    }

    public boolean l() {
        return !this.b3 || this.d3 == 1.0f;
    }

    public boolean m() {
        return this.b3;
    }

    /* access modifiers changed from: package-private */
    public void n(int i2) {
        if (this.c3 == null) {
            this.d3 = 0.0f;
            return;
        }
        boolean k2 = k();
        LayoutParams layoutParams = (LayoutParams) this.c3.getLayoutParams();
        int width = this.c3.getWidth();
        if (k2) {
            i2 = (getWidth() - i2) - width;
        }
        float paddingRight = ((float) (i2 - ((k2 ? getPaddingRight() : getPaddingLeft()) + (k2 ? layoutParams.rightMargin : layoutParams.leftMargin)))) / ((float) this.f3);
        this.d3 = paddingRight;
        if (this.h3 != 0) {
            q(paddingRight);
        }
        if (layoutParams.f15809c) {
            e(this.c3, this.d3, this.s);
        }
        h(this.c3);
    }

    public boolean o() {
        return p(this.c3, 0);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.n3 = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n3 = true;
        int size = this.p3.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p3.get(i2).run();
        }
        this.p3.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.b3 && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.m3 = !this.l3.L(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.b3 || (this.g3 && actionMasked != 0)) {
            this.l3.c();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.l3.c();
            return false;
        } else {
            if (actionMasked == 0) {
                this.g3 = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.i3 = x;
                this.j3 = y;
                if (this.l3.L(this.c3, (int) x, (int) y) && j(this.c3)) {
                    z = true;
                    return this.l3.W(motionEvent) || z;
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.i3);
                float abs2 = Math.abs(y2 - this.j3);
                if (abs > ((float) this.l3.E()) && abs2 > abs) {
                    this.l3.c();
                    this.g3 = true;
                    return false;
                }
            }
            z = false;
            if (this.l3.W(motionEvent)) {
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        boolean k2 = k();
        ViewDragHelper viewDragHelper = this.l3;
        if (k2) {
            viewDragHelper.T(2);
        } else {
            viewDragHelper.T(1);
        }
        int i11 = i5 - i2;
        int paddingRight = k2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = k2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.n3) {
            this.d3 = (!this.b3 || !this.m3) ? 0.0f : 1.0f;
        }
        int i12 = paddingRight;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f15808b) {
                    int i14 = i11 - paddingLeft;
                    int min = (Math.min(paddingRight, i14 - this.a3) - i12) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f3 = min;
                    int i15 = k2 ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f15809c = ((i12 + i15) + min) + (measuredWidth / 2) > i14;
                    int i16 = (int) (((float) min) * this.d3);
                    i12 += i15 + i16;
                    this.d3 = ((float) i16) / ((float) min);
                    i7 = 0;
                } else if (!this.b3 || (i10 = this.h3) == 0) {
                    i12 = paddingRight;
                    i7 = 0;
                } else {
                    i7 = (int) ((1.0f - this.d3) * ((float) i10));
                    i12 = paddingRight;
                }
                if (k2) {
                    i8 = (i11 - i12) + i7;
                    i9 = i8 - measuredWidth;
                } else {
                    i9 = i12 - i7;
                    i8 = i9 + measuredWidth;
                }
                childAt.layout(i9, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                paddingRight += childAt.getWidth();
            }
        }
        if (this.n3) {
            if (this.b3) {
                if (this.h3 != 0) {
                    q(this.d3);
                }
                if (((LayoutParams) this.c3.getLayoutParams()).f15809c) {
                    e(this.c3, this.d3, this.s);
                }
            } else {
                for (int i17 = 0; i17 < childCount; i17++) {
                    e(getChildAt(i17), 0.0f, this.s);
                }
            }
            v(this.c3);
        }
        this.n3 = false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0112 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            int r1 = android.view.View.MeasureSpec.getMode(r21)
            int r2 = android.view.View.MeasureSpec.getSize(r21)
            int r3 = android.view.View.MeasureSpec.getMode(r22)
            int r4 = android.view.View.MeasureSpec.getSize(r22)
            r5 = 300(0x12c, float:4.2E-43)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1073741824(0x40000000, float:2.0)
            if (r1 == r7) goto L_0x0030
            boolean r8 = r20.isInEditMode()
            if (r8 == 0) goto L_0x0028
            if (r1 != r6) goto L_0x0023
            goto L_0x0047
        L_0x0023:
            if (r1 != 0) goto L_0x0047
            r2 = 300(0x12c, float:4.2E-43)
            goto L_0x0047
        L_0x0028:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Width must have an exact value or MATCH_PARENT"
            r1.<init>(r2)
            throw r1
        L_0x0030:
            if (r3 != 0) goto L_0x0047
            boolean r1 = r20.isInEditMode()
            if (r1 == 0) goto L_0x003f
            if (r3 != 0) goto L_0x0047
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 300(0x12c, float:4.2E-43)
            goto L_0x0047
        L_0x003f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Height must not be UNSPECIFIED"
            r1.<init>(r2)
            throw r1
        L_0x0047:
            r1 = 0
            if (r3 == r6) goto L_0x005b
            if (r3 == r7) goto L_0x004f
            r4 = 0
            r5 = 0
            goto L_0x0067
        L_0x004f:
            int r5 = r20.getPaddingTop()
            int r4 = r4 - r5
            int r5 = r20.getPaddingBottom()
            int r4 = r4 - r5
            r5 = r4
            goto L_0x0067
        L_0x005b:
            int r5 = r20.getPaddingTop()
            int r4 = r4 - r5
            int r5 = r20.getPaddingBottom()
            int r4 = r4 - r5
            r5 = r4
            r4 = 0
        L_0x0067:
            int r8 = r20.getPaddingLeft()
            int r8 = r2 - r8
            int r9 = r20.getPaddingRight()
            int r8 = r8 - r9
            int r9 = r20.getChildCount()
            r10 = 2
            if (r9 <= r10) goto L_0x0080
            java.lang.String r10 = "SlidingPaneLayout"
            java.lang.String r11 = "onMeasure: More than two child views are not supported."
            android.util.Log.e(r10, r11)
        L_0x0080:
            r10 = 0
            r0.c3 = r10
            r14 = r8
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0087:
            r15 = 8
            r16 = 1
            if (r11 >= r9) goto L_0x011b
            android.view.View r6 = r0.getChildAt(r11)
            android.view.ViewGroup$LayoutParams r17 = r6.getLayoutParams()
            r7 = r17
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r7 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r7
            int r10 = r6.getVisibility()
            if (r10 != r15) goto L_0x00a3
            r7.f15809c = r1
            goto L_0x0112
        L_0x00a3:
            float r10 = r7.f15807a
            r15 = 0
            int r18 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r18 <= 0) goto L_0x00b0
            float r13 = r13 + r10
            int r10 = r7.width
            if (r10 != 0) goto L_0x00b0
            goto L_0x0112
        L_0x00b0:
            int r10 = r7.leftMargin
            int r15 = r7.rightMargin
            int r10 = r10 + r15
            int r15 = r7.width
            r1 = -2
            if (r15 != r1) goto L_0x00c5
            int r10 = r8 - r10
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r15)
            r15 = r10
            r1 = -1
            goto L_0x00d8
        L_0x00c5:
            r1 = -1
            if (r15 != r1) goto L_0x00d2
            int r10 = r8 - r10
            r15 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r15)
            r15 = r10
            goto L_0x00d8
        L_0x00d2:
            r10 = 1073741824(0x40000000, float:2.0)
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
        L_0x00d8:
            int r10 = r7.height
            r1 = -2
            if (r10 != r1) goto L_0x00e4
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00df:
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
            goto L_0x00f0
        L_0x00e4:
            r1 = -1
            if (r10 != r1) goto L_0x00ea
            r1 = 1073741824(0x40000000, float:2.0)
            goto L_0x00df
        L_0x00ea:
            r1 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r1)
        L_0x00f0:
            r6.measure(r15, r10)
            int r1 = r6.getMeasuredWidth()
            int r10 = r6.getMeasuredHeight()
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 != r15) goto L_0x0105
            if (r10 <= r4) goto L_0x0105
            int r4 = java.lang.Math.min(r10, r5)
        L_0x0105:
            int r14 = r14 - r1
            if (r14 >= 0) goto L_0x010a
            r1 = 1
            goto L_0x010b
        L_0x010a:
            r1 = 0
        L_0x010b:
            r7.f15808b = r1
            r12 = r12 | r1
            if (r1 == 0) goto L_0x0112
            r0.c3 = r6
        L_0x0112:
            int r11 = r11 + 1
            r1 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1073741824(0x40000000, float:2.0)
            goto L_0x0087
        L_0x011b:
            if (r12 != 0) goto L_0x0122
            r1 = 0
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0209
        L_0x0122:
            int r1 = r0.a3
            int r1 = r8 - r1
            r3 = 0
        L_0x0127:
            if (r3 >= r9) goto L_0x0209
            android.view.View r6 = r0.getChildAt(r3)
            int r7 = r6.getVisibility()
            if (r7 != r15) goto L_0x013a
        L_0x0133:
            r19 = r1
        L_0x0135:
            r1 = 0
            r7 = 1073741824(0x40000000, float:2.0)
            goto L_0x0201
        L_0x013a:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r7 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r7
            int r10 = r6.getVisibility()
            if (r10 != r15) goto L_0x0147
            goto L_0x0133
        L_0x0147:
            int r10 = r7.width
            if (r10 != 0) goto L_0x0154
            float r10 = r7.f15807a
            r11 = 0
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x0154
            r10 = 1
            goto L_0x0155
        L_0x0154:
            r10 = 0
        L_0x0155:
            if (r10 == 0) goto L_0x0159
            r11 = 0
            goto L_0x015d
        L_0x0159:
            int r11 = r6.getMeasuredWidth()
        L_0x015d:
            if (r12 == 0) goto L_0x01a0
            android.view.View r15 = r0.c3
            if (r6 == r15) goto L_0x01a0
            int r15 = r7.width
            if (r15 >= 0) goto L_0x0133
            if (r11 > r1) goto L_0x0170
            float r11 = r7.f15807a
            r15 = 0
            int r11 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r11 <= 0) goto L_0x0133
        L_0x0170:
            if (r10 == 0) goto L_0x0191
            int r7 = r7.height
            r10 = -2
            if (r7 != r10) goto L_0x0180
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r10)
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0198
        L_0x0180:
            r10 = -1
            if (r7 != r10) goto L_0x018a
            r10 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r10)
            goto L_0x0198
        L_0x018a:
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x018c:
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r10)
            goto L_0x0198
        L_0x0191:
            r10 = 1073741824(0x40000000, float:2.0)
            int r7 = r6.getMeasuredHeight()
            goto L_0x018c
        L_0x0198:
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r10)
            r6.measure(r11, r7)
            goto L_0x0133
        L_0x01a0:
            float r10 = r7.f15807a
            r15 = 0
            int r10 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r10 <= 0) goto L_0x0133
            int r10 = r7.width
            if (r10 != 0) goto L_0x01ca
            int r10 = r7.height
            r15 = -2
            if (r10 != r15) goto L_0x01b9
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r15)
            r15 = 1073741824(0x40000000, float:2.0)
            goto L_0x01d1
        L_0x01b9:
            r15 = -1
            if (r10 != r15) goto L_0x01c3
            r15 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r15)
            goto L_0x01d1
        L_0x01c3:
            r15 = 1073741824(0x40000000, float:2.0)
        L_0x01c5:
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r15)
            goto L_0x01d1
        L_0x01ca:
            r15 = 1073741824(0x40000000, float:2.0)
            int r10 = r6.getMeasuredHeight()
            goto L_0x01c5
        L_0x01d1:
            if (r12 == 0) goto L_0x01e9
            int r15 = r7.leftMargin
            int r7 = r7.rightMargin
            int r15 = r15 + r7
            int r7 = r8 - r15
            r19 = r1
            r15 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r15)
            if (r11 == r7) goto L_0x0135
            r6.measure(r1, r10)
            goto L_0x0135
        L_0x01e9:
            r19 = r1
            r1 = 0
            int r15 = java.lang.Math.max(r1, r14)
            float r7 = r7.f15807a
            float r15 = (float) r15
            float r7 = r7 * r15
            float r7 = r7 / r13
            int r7 = (int) r7
            int r11 = r11 + r7
            r7 = 1073741824(0x40000000, float:2.0)
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r7)
            r6.measure(r11, r10)
        L_0x0201:
            int r3 = r3 + 1
            r1 = r19
            r15 = 8
            goto L_0x0127
        L_0x0209:
            int r1 = r20.getPaddingTop()
            int r4 = r4 + r1
            int r1 = r20.getPaddingBottom()
            int r4 = r4 + r1
            r0.setMeasuredDimension(r2, r4)
            r0.b3 = r12
            androidx.customview.widget.ViewDragHelper r1 = r0.l3
            int r1 = r1.F()
            if (r1 == 0) goto L_0x0227
            if (r12 != 0) goto L_0x0227
            androidx.customview.widget.ViewDragHelper r1 = r0.l3
            r1.a()
        L_0x0227:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.Y) {
            o();
        } else {
            c();
        }
        this.m3 = savedState.Y;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Y = m() ? l() : this.m3;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        if (i2 != i5) {
            this.n3 = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.b3) {
            return super.onTouchEvent(motionEvent);
        }
        this.l3.M(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.i3 = x;
            this.j3 = y;
        } else if (actionMasked == 1 && j(this.c3)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f2 = x2 - this.i3;
            float f4 = y2 - this.j3;
            int E = this.l3.E();
            if ((f2 * f2) + (f4 * f4) < ((float) (E * E)) && this.l3.L(this.c3, (int) x2, (int) y2)) {
                d(this.c3, 0);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.b3) {
            this.m3 = view == this.c3;
        }
    }

    @Deprecated
    public void s() {
        c();
    }

    public void setCoveredFadeColor(@ColorInt int i2) {
        this.X2 = i2;
    }

    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        this.k3 = panelSlideListener;
    }

    public void setParallaxDistance(@Px int i2) {
        this.h3 = i2;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.Y2 = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.Z2 = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i2) {
        setShadowDrawable(getResources().getDrawable(i2));
    }

    public void setShadowResourceLeft(int i2) {
        setShadowDrawableLeft(ContextCompat.l(getContext(), i2));
    }

    public void setShadowResourceRight(int i2) {
        setShadowDrawableRight(ContextCompat.l(getContext(), i2));
    }

    public void setSliderFadeColor(@ColorInt int i2) {
        this.s = i2;
    }

    @Deprecated
    public void t() {
        o();
    }

    /* access modifiers changed from: package-private */
    public boolean u(float f2, int i2) {
        int i4;
        if (!this.b3) {
            return false;
        }
        boolean k2 = k();
        LayoutParams layoutParams = (LayoutParams) this.c3.getLayoutParams();
        if (k2) {
            i4 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f2 * ((float) this.f3))) + ((float) this.c3.getWidth())));
        } else {
            i4 = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f2 * ((float) this.f3)));
        }
        ViewDragHelper viewDragHelper = this.l3;
        View view = this.c3;
        if (!viewDragHelper.X(view, i4, view.getTop())) {
            return false;
        }
        r();
        ViewCompat.t1(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void v(View view) {
        int i2;
        int i4;
        int i5;
        int i6;
        View childAt;
        boolean z;
        View view2 = view;
        boolean k2 = k();
        int width = k2 ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = k2 ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !w(view)) {
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i2 = 0;
        } else {
            i6 = view.getLeft();
            i5 = view.getRight();
            i4 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i7 = 0;
        while (true) {
            if (i7 < childCount && (childAt = getChildAt(i7)) != view2) {
                if (childAt.getVisibility() == 8) {
                    z = k2;
                } else {
                    z = k2;
                    childAt.setVisibility((Math.max(k2 ? paddingLeft : width, childAt.getLeft()) < i6 || Math.max(paddingTop, childAt.getTop()) < i4 || Math.min(k2 ? width : paddingLeft, childAt.getRight()) > i5 || Math.min(height, childAt.getBottom()) > i2) ? 0 : 4);
                }
                i7++;
                view2 = view;
                k2 = z;
            } else {
                return;
            }
        }
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = v3;
        this.n3 = true;
        this.o3 = new Rect();
        this.p3 = new ArrayList<>();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.a3 = (int) ((32.0f * f2) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.H1(this, new AccessibilityDelegate());
        ViewCompat.Z1(this, 1);
        ViewDragHelper p = ViewDragHelper.p(this, 0.5f, new DragHelperCallback());
        this.l3 = p;
        p.U(f2 * 400.0f);
    }
}
