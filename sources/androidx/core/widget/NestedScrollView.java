package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.R;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
    static final float A3 = 0.5f;
    private static final String B3 = "NestedScrollView";
    private static final int C3 = 250;
    private static final float D3 = 0.015f;
    private static final float E3 = 0.35f;
    private static final float F3 = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    private static final float G3 = 4.0f;
    private static final int H3 = -1;
    private static final AccessibilityDelegate I3 = new AccessibilityDelegate();
    private static final int[] J3 = {16843130};
    static final int z3 = 250;
    private long X2;
    private final Rect Y2;
    /* access modifiers changed from: private */
    public OverScroller Z2;
    @VisibleForTesting
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public EdgeEffect a3;
    @VisibleForTesting
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public EdgeEffect b3;
    private int c3;
    private boolean d3;
    private boolean e3;
    private View f3;
    private boolean g3;
    private VelocityTracker h3;
    private boolean i3;
    private boolean j3;
    private int k3;
    private int l3;
    private int m3;
    private int n3;
    private final int[] o3;
    private final int[] p3;
    private int q3;
    private int r3;
    private final float s;
    private SavedState s3;
    private final NestedScrollingParentHelper t3;
    private final NestedScrollingChildHelper u3;
    private float v3;
    private OnScrollChangeListener w3;
    @VisibleForTesting
    final DifferentialMotionFlingTargetImpl x3;
    @VisibleForTesting
    DifferentialMotionFlingController y3;

    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.N(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.P(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.g(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.j1(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                accessibilityNodeInfoCompat.X1(true);
                if (nestedScrollView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.s);
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.D);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.r);
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.F);
                }
            }
        }

        public boolean j(View view, int i2, Bundle bundle) {
            if (super.j(view, i2, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i2 != 4096) {
                if (i2 == 8192 || i2 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.e0(0, max, true);
                    return true;
                } else if (i2 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.e0(0, min, true);
            return true;
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    class DifferentialMotionFlingTargetImpl implements DifferentialMotionFlingTarget {
        DifferentialMotionFlingTargetImpl() {
        }

        public boolean a(float f2) {
            if (f2 == 0.0f) {
                return false;
            }
            c();
            NestedScrollView.this.z((int) f2);
            return true;
        }

        public float b() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        public void c() {
            NestedScrollView.this.Z2.abortAnimation();
        }
    }

    public interface OnScrollChangeListener {
        void a(@NonNull NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        public int s;

        SavedState(Parcel parcel) {
            super(parcel);
            this.s = parcel.readInt();
        }

        @NonNull
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.s + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.s);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NestedScrollView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private float B(int i2) {
        double log = Math.log((double) ((((float) Math.abs(i2)) * E3) / (this.s * D3)));
        float f2 = F3;
        return (float) (((double) (this.s * D3)) * Math.exp((((double) f2) / (((double) f2) - 1.0d)) * log));
    }

    private boolean C(int i2, int i4) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i4 >= childAt.getTop() - scrollY && i4 < childAt.getBottom() - scrollY && i2 >= childAt.getLeft() && i2 < childAt.getRight();
    }

    private void D() {
        VelocityTracker velocityTracker = this.h3;
        if (velocityTracker == null) {
            this.h3 = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void E() {
        this.Z2 = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.k3 = viewConfiguration.getScaledTouchSlop();
        this.l3 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.m3 = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void F() {
        if (this.h3 == null) {
            this.h3 = VelocityTracker.obtain();
        }
    }

    private void G(int i2, int i4) {
        this.c3 = i2;
        this.n3 = i4;
        f(2, 0);
    }

    private boolean I(View view) {
        return !L(view, 0, getHeight());
    }

    private static boolean K(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && K((View) parent, view2);
    }

    private boolean L(View view, int i2, int i4) {
        view.getDrawingRect(this.Y2);
        offsetDescendantRectToMyCoords(view, this.Y2);
        return this.Y2.bottom + i2 >= getScrollY() && this.Y2.top - i2 <= getScrollY() + i4;
    }

    private void M(int i2, int i4, @Nullable int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.u3.e(0, scrollY2, 0, i2 - scrollY2, (int[]) null, i4, iArr);
    }

    private void N(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.n3) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.c3 = (int) motionEvent.getY(i2);
            this.n3 = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.h3;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void Q() {
        VelocityTracker velocityTracker = this.h3;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.h3 = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int R(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.a3
            float r0 = androidx.core.widget.EdgeEffectCompat.d(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            android.widget.EdgeEffect r0 = r3.a3
            float r4 = -r4
            float r4 = androidx.core.widget.EdgeEffectCompat.j(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.a3
            float r5 = androidx.core.widget.EdgeEffectCompat.d(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            android.widget.EdgeEffect r5 = r3.a3
        L_0x002c:
            r5.onRelease()
        L_0x002f:
            r1 = r4
            goto L_0x0051
        L_0x0031:
            android.widget.EdgeEffect r0 = r3.b3
            float r0 = androidx.core.widget.EdgeEffectCompat.d(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0051
            android.widget.EdgeEffect r0 = r3.b3
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.EdgeEffectCompat.j(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.b3
            float r5 = androidx.core.widget.EdgeEffectCompat.d(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            android.widget.EdgeEffect r5 = r3.b3
            goto L_0x002c
        L_0x0051:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L_0x0061
            r3.invalidate()
        L_0x0061:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.R(int, float):int");
    }

    private void S(boolean z) {
        if (z) {
            f(2, 1);
        } else {
            h(1);
        }
        this.r3 = getScrollY();
        postInvalidateOnAnimation();
    }

    private boolean T(int i2, int i4, int i5) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i6 = height + scrollY;
        boolean z = false;
        boolean z2 = i2 == 33;
        View y = y(z2, i4, i5);
        if (y == null) {
            y = this;
        }
        if (i4 < scrollY || i5 > i6) {
            U(z2 ? i4 - scrollY : i5 - i6, 0, 1, true);
            z = true;
        }
        if (y != findFocus()) {
            y.requestFocus(i2);
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int U(int r22, int r23, int r24, boolean r25) {
        /*
            r21 = this;
            r10 = r21
            r11 = r23
            r12 = r24
            r13 = 1
            if (r12 != r13) goto L_0x000d
            r0 = 2
            r10.f(r0, r12)
        L_0x000d:
            int[] r3 = r10.p3
            int[] r4 = r10.o3
            r1 = 0
            r0 = r21
            r2 = r22
            r5 = r24
            boolean r0 = r0.b(r1, r2, r3, r4, r5)
            r14 = 0
            if (r0 == 0) goto L_0x002d
            int[] r0 = r10.p3
            r0 = r0[r13]
            int r0 = r22 - r0
            int[] r1 = r10.o3
            r1 = r1[r13]
            r15 = r0
            r16 = r1
            goto L_0x0031
        L_0x002d:
            r15 = r22
            r16 = 0
        L_0x0031:
            int r17 = r21.getScrollY()
            int r9 = r21.getScrollRange()
            boolean r0 = r21.k()
            if (r0 == 0) goto L_0x0044
            if (r25 != 0) goto L_0x0044
            r18 = 1
            goto L_0x0046
        L_0x0044:
            r18 = 0
        L_0x0046:
            r8 = 0
            r19 = 1
            r1 = 0
            r3 = 0
            r5 = 0
            r7 = 0
            r0 = r21
            r2 = r15
            r4 = r17
            r6 = r9
            r20 = r9
            r9 = r19
            boolean r0 = r0.O(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x0065
            boolean r0 = r10.d(r12)
            if (r0 != 0) goto L_0x0065
            r8 = 1
            goto L_0x0066
        L_0x0065:
            r8 = 0
        L_0x0066:
            int r0 = r21.getScrollY()
            int r2 = r0 - r17
            int r4 = r15 - r2
            int[] r7 = r10.p3
            r7[r13] = r14
            r3 = 0
            int[] r5 = r10.o3
            r1 = 0
            r0 = r21
            r6 = r24
            r0.c(r1, r2, r3, r4, r5, r6, r7)
            int[] r0 = r10.o3
            r0 = r0[r13]
            int r16 = r16 + r0
            int[] r0 = r10.p3
            r0 = r0[r13]
            int r15 = r15 - r0
            int r0 = r17 + r15
            if (r0 >= 0) goto L_0x00b0
            if (r18 == 0) goto L_0x00d7
            android.widget.EdgeEffect r0 = r10.a3
            int r1 = -r15
            float r1 = (float) r1
            int r2 = r21.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            float r2 = (float) r11
            int r3 = r21.getWidth()
            float r3 = (float) r3
            float r2 = r2 / r3
            androidx.core.widget.EdgeEffectCompat.j(r0, r1, r2)
            android.widget.EdgeEffect r0 = r10.b3
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x00d7
            android.widget.EdgeEffect r0 = r10.b3
        L_0x00ac:
            r0.onRelease()
            goto L_0x00d7
        L_0x00b0:
            r1 = r20
            if (r0 <= r1) goto L_0x00d7
            if (r18 == 0) goto L_0x00d7
            android.widget.EdgeEffect r0 = r10.b3
            float r1 = (float) r15
            int r2 = r21.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            float r2 = (float) r11
            int r3 = r21.getWidth()
            float r3 = (float) r3
            float r2 = r2 / r3
            r3 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 - r2
            androidx.core.widget.EdgeEffectCompat.j(r0, r1, r3)
            android.widget.EdgeEffect r0 = r10.a3
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x00d7
            android.widget.EdgeEffect r0 = r10.a3
            goto L_0x00ac
        L_0x00d7:
            android.widget.EdgeEffect r0 = r10.a3
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x00ea
            android.widget.EdgeEffect r0 = r10.b3
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x00e8
            goto L_0x00ea
        L_0x00e8:
            r14 = r8
            goto L_0x00ed
        L_0x00ea:
            r21.postInvalidateOnAnimation()
        L_0x00ed:
            if (r14 == 0) goto L_0x00f8
            if (r12 != 0) goto L_0x00f8
            android.view.VelocityTracker r0 = r10.h3
            if (r0 == 0) goto L_0x00f8
            r0.clear()
        L_0x00f8:
            if (r12 != r13) goto L_0x0107
            r10.h(r12)
            android.widget.EdgeEffect r0 = r10.a3
            r0.onRelease()
            android.widget.EdgeEffect r0 = r10.b3
            r0.onRelease()
        L_0x0107:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.U(int, int, int, boolean):int");
    }

    private void V(View view) {
        view.getDrawingRect(this.Y2);
        offsetDescendantRectToMyCoords(view, this.Y2);
        int n2 = n(this.Y2);
        if (n2 != 0) {
            scrollBy(0, n2);
        }
    }

    private boolean W(Rect rect, boolean z) {
        int n2 = n(rect);
        boolean z2 = n2 != 0;
        if (z2) {
            if (z) {
                scrollBy(0, n2);
            } else {
                Y(0, n2);
            }
        }
        return z2;
    }

    private boolean X(@NonNull EdgeEffect edgeEffect, int i2) {
        if (i2 > 0) {
            return true;
        }
        return B(-i2) < EdgeEffectCompat.d(edgeEffect) * ((float) getHeight());
    }

    private void a0(int i2, int i4, int i5, boolean z) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.X2 > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.Z2;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i4 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i5);
                S(z);
            } else {
                if (!this.Z2.isFinished()) {
                    e();
                }
                scrollBy(i2, i4);
            }
            this.X2 = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    private void e() {
        this.Z2.abortAnimation();
        h(1);
    }

    private boolean f0(MotionEvent motionEvent) {
        boolean z;
        if (EdgeEffectCompat.d(this.a3) != 0.0f) {
            EdgeEffectCompat.j(this.a3, 0.0f, motionEvent.getX() / ((float) getWidth()));
            z = true;
        } else {
            z = false;
        }
        if (EdgeEffectCompat.d(this.b3) == 0.0f) {
            return z;
        }
        EdgeEffectCompat.j(this.b3, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    private boolean k() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    private boolean l() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int m(int i2, int i4, int i5) {
        if (i4 >= i5 || i2 < 0) {
            return 0;
        }
        return i4 + i2 > i5 ? i5 - i4 : i2;
    }

    private void p(int i2) {
        if (i2 == 0) {
            return;
        }
        if (this.j3) {
            Y(0, i2);
        } else {
            scrollBy(0, i2);
        }
    }

    private boolean v(int i2) {
        EdgeEffect edgeEffect;
        if (EdgeEffectCompat.d(this.a3) != 0.0f) {
            if (X(this.a3, i2)) {
                edgeEffect = this.a3;
            } else {
                i2 = -i2;
                z(i2);
                return true;
            }
        } else if (EdgeEffectCompat.d(this.b3) == 0.0f) {
            return false;
        } else {
            i2 = -i2;
            if (X(this.b3, i2)) {
                edgeEffect = this.b3;
            }
            z(i2);
            return true;
        }
        edgeEffect.onAbsorb(i2);
        return true;
    }

    private void w() {
        this.n3 = -1;
        this.g3 = false;
        Q();
        h(0);
        this.a3.onRelease();
        this.b3.onRelease();
    }

    private View y(boolean z, int i2, int i4) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i4) {
                boolean z4 = i2 < top && bottom < i4;
                if (view == null) {
                    view = view2;
                    z2 = z4;
                } else {
                    boolean z5 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z4) {
                            if (!z5) {
                            }
                        }
                    } else if (z4) {
                        view = view2;
                        z2 = true;
                    } else if (!z5) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    public boolean A(int i2) {
        int childCount;
        boolean z = i2 == 130;
        int height = getHeight();
        Rect rect = this.Y2;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.Y2.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.Y2;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.Y2;
        return T(i2, rect3.top, rect3.bottom);
    }

    public boolean H() {
        return this.i3;
    }

    public boolean J() {
        return this.j3;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean O(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x002a
            if (r1 != r5) goto L_0x0028
            if (r2 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r2 = 0
            goto L_0x002b
        L_0x002a:
            r2 = 1
        L_0x002b:
            if (r1 == 0) goto L_0x0034
            if (r1 != r5) goto L_0x0032
            if (r3 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r1 = 0
            goto L_0x0035
        L_0x0034:
            r1 = 1
        L_0x0035:
            int r3 = r15 + r13
            if (r2 != 0) goto L_0x003b
            r2 = 0
            goto L_0x003d
        L_0x003b:
            r2 = r19
        L_0x003d:
            int r6 = r16 + r14
            if (r1 != 0) goto L_0x0043
            r1 = 0
            goto L_0x0045
        L_0x0043:
            r1 = r20
        L_0x0045:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L_0x0050
            r3 = r2
        L_0x004e:
            r2 = 1
            goto L_0x0055
        L_0x0050:
            if (r3 >= r7) goto L_0x0054
            r3 = r7
            goto L_0x004e
        L_0x0054:
            r2 = 0
        L_0x0055:
            if (r6 <= r1) goto L_0x005a
            r6 = r1
        L_0x0058:
            r1 = 1
            goto L_0x005f
        L_0x005a:
            if (r6 >= r8) goto L_0x005e
            r6 = r8
            goto L_0x0058
        L_0x005e:
            r1 = 0
        L_0x005f:
            if (r1 == 0) goto L_0x007e
            boolean r7 = r12.d(r5)
            if (r7 != 0) goto L_0x007e
            android.widget.OverScroller r7 = r0.Z2
            r8 = 0
            int r9 = r12.getScrollRange()
            r10 = 0
            r11 = 0
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r10
            r17 = r11
            r18 = r8
            r19 = r9
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L_0x007e:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L_0x0085
            if (r1 == 0) goto L_0x0086
        L_0x0085:
            r4 = 1
        L_0x0086:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.O(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    public boolean P(int i2) {
        boolean z = i2 == 130;
        int height = getHeight();
        if (z) {
            this.Y2.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.Y2;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.Y2.top = getScrollY() - height;
            Rect rect2 = this.Y2;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.Y2;
        int i4 = rect3.top;
        int i5 = height + i4;
        rect3.bottom = i5;
        return T(i2, i4, i5);
    }

    public final void Y(int i2, int i4) {
        a0(i2, i4, ItemTouchHelper.Callback.f15380c, false);
    }

    public final void Z(int i2, int i4, int i5) {
        a0(i2, i4, i5, false);
    }

    public boolean a(int i2, int i4, int i5, int i6, @Nullable int[] iArr, int i7) {
        return this.u3.g(i2, i4, i5, i6, iArr, i7);
    }

    public void addView(@NonNull View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(int i2, int i4, @Nullable int[] iArr, @Nullable int[] iArr2, int i5) {
        return this.u3.d(i2, i4, iArr, iArr2, i5);
    }

    public final void b0(int i2, int i4) {
        d0(i2, i4, ItemTouchHelper.Callback.f15380c, false);
    }

    public void c(int i2, int i4, int i5, int i6, @Nullable int[] iArr, int i7, @NonNull int[] iArr2) {
        this.u3.e(i2, i4, i5, i6, iArr, i7, iArr2);
    }

    public final void c0(int i2, int i4, int i5) {
        d0(i2, i4, i5, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (!this.Z2.isFinished()) {
            this.Z2.computeScrollOffset();
            int currY = this.Z2.getCurrY();
            int o = o(currY - this.r3);
            this.r3 = currY;
            int[] iArr = this.p3;
            iArr[1] = 0;
            b(0, o, iArr, (int[]) null, 1);
            int i2 = o - this.p3[1];
            int scrollRange = getScrollRange();
            if (i2 != 0) {
                int scrollY = getScrollY();
                O(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                int i4 = i2 - scrollY2;
                int[] iArr2 = this.p3;
                iArr2[1] = 0;
                c(0, scrollY2, 0, i4, this.o3, 1, iArr2);
                i2 = i4 - this.p3[1];
            }
            if (i2 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    if (i2 < 0) {
                        if (this.a3.isFinished()) {
                            edgeEffect = this.a3;
                        }
                    } else if (this.b3.isFinished()) {
                        edgeEffect = this.b3;
                    }
                    edgeEffect.onAbsorb((int) this.Z2.getCurrVelocity());
                }
                e();
            }
            if (!this.Z2.isFinished()) {
                postInvalidateOnAnimation();
            } else {
                h(1);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public boolean d(int i2) {
        return this.u3.l(i2);
    }

    /* access modifiers changed from: package-private */
    public void d0(int i2, int i4, int i5, boolean z) {
        a0(i2 - getScrollX(), i4 - getScrollY(), i5, z);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || x(keyEvent);
    }

    public boolean dispatchNestedFling(float f2, float f4, boolean z) {
        return this.u3.a(f2, f4, z);
    }

    public boolean dispatchNestedPreFling(float f2, float f4) {
        return this.u3.b(f2, f4);
    }

    public boolean dispatchNestedPreScroll(int i2, int i4, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return b(i2, i4, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i2, int i4, int i5, int i6, @Nullable int[] iArr) {
        return this.u3.f(i2, i4, i5, i6, iArr);
    }

    public void draw(@NonNull Canvas canvas) {
        int i2;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i4 = 0;
        if (!this.a3.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (Api21Impl.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                i2 = getPaddingLeft();
            } else {
                i2 = 0;
            }
            if (Api21Impl.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate((float) i2, (float) min);
            this.a3.setSize(width, height);
            if (this.a3.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save);
        }
        if (!this.b3.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (Api21Impl.a(this)) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i4 = getPaddingLeft();
            }
            if (Api21Impl.a(this)) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate((float) (i4 - width2), (float) max);
            canvas.rotate(180.0f, (float) width2, 0.0f);
            this.b3.setSize(width2, height2);
            if (this.b3.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save2);
        }
    }

    /* access modifiers changed from: package-private */
    public void e0(int i2, int i4, boolean z) {
        d0(i2, i4, ItemTouchHelper.Callback.f15380c, z);
    }

    public boolean f(int i2, int i4) {
        return this.u3.s(i2, i4);
    }

    public void g(@NonNull View view, int i2, int i4, int i5, int i6, int i7, @NonNull int[] iArr) {
        M(i6, i7, iArr);
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.t3.a();
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public float getVerticalScrollFactorCompat() {
        if (this.v3 == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.v3 = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.v3;
    }

    public void h(int i2) {
        this.u3.u(i2);
    }

    public boolean hasNestedScrollingParent() {
        return d(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.u3.m();
    }

    public boolean j(int i2) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !L(findNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            U(maxScrollAmount, 0, 1, true);
        } else {
            findNextFocus.getDrawingRect(this.Y2);
            offsetDescendantRectToMyCoords(findNextFocus, this.Y2);
            U(n(this.Y2), 0, 1, true);
            findNextFocus.requestFocus(i2);
        }
        if (findFocus != null && findFocus.isFocused() && I(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void measureChild(@NonNull View view, int i2, int i4) {
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i2, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    /* access modifiers changed from: protected */
    public int n(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i2 - verticalFadingEdgeLength : i2;
        int i5 = rect.bottom;
        if (i5 > i4 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i4, (childAt.getBottom() + layoutParams.bottomMargin) - i2);
        } else if (rect.top >= scrollY || i5 >= i4) {
            return 0;
        } else {
            return Math.max(rect.height() > height ? 0 - (i4 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
    }

    /* access modifiers changed from: package-private */
    public int o(int i2) {
        int height = getHeight();
        if (i2 > 0 && EdgeEffectCompat.d(this.a3) != 0.0f) {
            int round = Math.round((((float) (-height)) / G3) * EdgeEffectCompat.j(this.a3, (((float) (-i2)) * G3) / ((float) height), 0.5f));
            if (round != i2) {
                this.a3.finish();
            }
            return i2 - round;
        } else if (i2 >= 0 || EdgeEffectCompat.d(this.b3) == 0.0f) {
            return i2;
        } else {
            float f2 = (float) height;
            int round2 = Math.round((f2 / G3) * EdgeEffectCompat.j(this.b3, (((float) i2) * G3) / f2, 0.5f));
            if (round2 != i2) {
                this.b3.finish();
            }
            return i2 - round2;
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.e3 = false;
    }

    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        int i2;
        float f2;
        int i4;
        if (motionEvent.getAction() == 8 && !this.g3) {
            if (MotionEventCompat.l(motionEvent, 2)) {
                i4 = 9;
                f2 = motionEvent.getAxisValue(9);
                i2 = (int) motionEvent.getX();
            } else if (MotionEventCompat.l(motionEvent, 4194304)) {
                f2 = motionEvent.getAxisValue(26);
                i2 = getWidth() / 2;
                i4 = 26;
            } else {
                i4 = 0;
                f2 = 0.0f;
                i2 = 0;
            }
            if (f2 != 0.0f) {
                U(-((int) (f2 * getVerticalScrollFactorCompat())), i2, 1, MotionEventCompat.l(motionEvent, 8194));
                if (i4 != 0) {
                    this.y3.g(motionEvent, i4);
                }
                return true;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 2 && this.g3) {
            return true;
        }
        int i2 = action & 255;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    int i4 = this.n3;
                    if (i4 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i4);
                        if (findPointerIndex == -1) {
                            Log.e(B3, "Invalid pointerId=" + i4 + " in onInterceptTouchEvent");
                        } else {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.c3) > this.k3 && (2 & getNestedScrollAxes()) == 0) {
                                this.g3 = true;
                                this.c3 = y;
                                F();
                                this.h3.addMovement(motionEvent);
                                this.q3 = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i2 != 3) {
                    if (i2 == 6) {
                        N(motionEvent);
                    }
                }
            }
            this.g3 = false;
            this.n3 = -1;
            Q();
            if (this.Z2.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            h(0);
        } else {
            int y2 = (int) motionEvent.getY();
            if (!C((int) motionEvent.getX(), y2)) {
                if (!f0(motionEvent) && this.Z2.isFinished()) {
                    z = false;
                }
                this.g3 = z;
                Q();
            } else {
                this.c3 = y2;
                this.n3 = motionEvent.getPointerId(0);
                D();
                this.h3.addMovement(motionEvent);
                this.Z2.computeScrollOffset();
                if (!f0(motionEvent) && this.Z2.isFinished()) {
                    z = false;
                }
                this.g3 = z;
                f(2, 0);
            }
        }
        return this.g3;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        super.onLayout(z, i2, i4, i5, i6);
        int i7 = 0;
        this.d3 = false;
        View view = this.f3;
        if (view != null && K(view, this)) {
            V(this.f3);
        }
        this.f3 = null;
        if (!this.e3) {
            if (this.s3 != null) {
                scrollTo(getScrollX(), this.s3.s);
                this.s3 = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i7 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int m2 = m(scrollY, paddingTop, i7);
            if (m2 != scrollY) {
                scrollTo(getScrollX(), m2);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.e3 = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        if (this.i3 && View.MeasureSpec.getMode(i4) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean onNestedFling(@NonNull View view, float f2, float f4, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f4, true);
        z((int) f4);
        return true;
    }

    public boolean onNestedPreFling(@NonNull View view, float f2, float f4) {
        return dispatchNestedPreFling(f2, f4);
    }

    public void onNestedPreScroll(@NonNull View view, int i2, int i4, @NonNull int[] iArr) {
        u(view, i2, i4, iArr, 0);
    }

    public void onNestedScroll(@NonNull View view, int i2, int i4, int i5, int i6) {
        M(i6, 0, (int[]) null);
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2) {
        s(view, view2, i2, 0);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i4, boolean z, boolean z2) {
        super.scrollTo(i2, i4);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (i2 == 2) {
            i2 = TsExtractor.L;
        } else if (i2 == 1) {
            i2 = 33;
        }
        FocusFinder instance = FocusFinder.getInstance();
        View findNextFocus = rect == null ? instance.findNextFocus(this, (View) null, i2) : instance.findNextFocusFromRect(this, rect, i2);
        if (findNextFocus != null && !I(findNextFocus)) {
            return findNextFocus.requestFocus(i2, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.s3 = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.s = getScrollY();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i4, int i5, int i6) {
        super.onScrollChanged(i2, i4, i5, i6);
        OnScrollChangeListener onScrollChangeListener = this.w3;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.a(this, i2, i4, i5, i6);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && L(findFocus, 0, i6)) {
            findFocus.getDrawingRect(this.Y2);
            offsetDescendantRectToMyCoords(findFocus, this.Y2);
            p(n(this.Y2));
        }
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2) {
        return r(view, view2, i2, 0);
    }

    public void onStopNestedScroll(@NonNull View view) {
        t(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        if (r12.Z2.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012a, code lost:
        if (r12.Z2.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r13) {
        /*
            r12 = this;
            r12.F()
            int r0 = r13.getActionMasked()
            r1 = 0
            if (r0 != 0) goto L_0x000c
            r12.q3 = r1
        L_0x000c:
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r13)
            int r3 = r12.q3
            float r3 = (float) r3
            r4 = 0
            r2.offsetLocation(r4, r3)
            r3 = 1
            if (r0 == 0) goto L_0x012e
            if (r0 == r3) goto L_0x00e6
            r4 = 2
            if (r0 == r4) goto L_0x0078
            r1 = 3
            if (r0 == r1) goto L_0x004f
            r1 = 5
            if (r0 == r1) goto L_0x003c
            r1 = 6
            if (r0 == r1) goto L_0x002a
            goto L_0x0159
        L_0x002a:
            r12.N(r13)
            int r0 = r12.n3
            int r0 = r13.findPointerIndex(r0)
            float r13 = r13.getY(r0)
            int r13 = (int) r13
            r12.c3 = r13
            goto L_0x0159
        L_0x003c:
            int r0 = r13.getActionIndex()
            float r1 = r13.getY(r0)
            int r1 = (int) r1
            r12.c3 = r1
            int r13 = r13.getPointerId(r0)
            r12.n3 = r13
            goto L_0x0159
        L_0x004f:
            boolean r13 = r12.g3
            if (r13 == 0) goto L_0x0073
            int r13 = r12.getChildCount()
            if (r13 <= 0) goto L_0x0073
            android.widget.OverScroller r4 = r12.Z2
            int r5 = r12.getScrollX()
            int r6 = r12.getScrollY()
            r9 = 0
            int r10 = r12.getScrollRange()
            r7 = 0
            r8 = 0
            boolean r13 = r4.springBack(r5, r6, r7, r8, r9, r10)
            if (r13 == 0) goto L_0x0073
        L_0x0070:
            r12.postInvalidateOnAnimation()
        L_0x0073:
            r12.w()
            goto L_0x0159
        L_0x0078:
            int r0 = r12.n3
            int r0 = r13.findPointerIndex(r0)
            r4 = -1
            if (r0 != r4) goto L_0x00a0
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Invalid pointerId="
            r13.append(r0)
            int r0 = r12.n3
            r13.append(r0)
            java.lang.String r0 = " in onTouchEvent"
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = "NestedScrollView"
            android.util.Log.e(r0, r13)
            goto L_0x0159
        L_0x00a0:
            float r4 = r13.getY(r0)
            int r4 = (int) r4
            int r5 = r12.c3
            int r5 = r5 - r4
            float r6 = r13.getX(r0)
            int r6 = r12.R(r5, r6)
            int r5 = r5 - r6
            boolean r6 = r12.g3
            if (r6 != 0) goto L_0x00cf
            int r6 = java.lang.Math.abs(r5)
            int r7 = r12.k3
            if (r6 <= r7) goto L_0x00cf
            android.view.ViewParent r6 = r12.getParent()
            if (r6 == 0) goto L_0x00c6
            r6.requestDisallowInterceptTouchEvent(r3)
        L_0x00c6:
            r12.g3 = r3
            int r6 = r12.k3
            if (r5 <= 0) goto L_0x00ce
            int r5 = r5 - r6
            goto L_0x00cf
        L_0x00ce:
            int r5 = r5 + r6
        L_0x00cf:
            boolean r6 = r12.g3
            if (r6 == 0) goto L_0x0159
            float r13 = r13.getX(r0)
            int r13 = (int) r13
            int r13 = r12.U(r5, r13, r1, r1)
            int r4 = r4 - r13
            r12.c3 = r4
            int r0 = r12.q3
            int r0 = r0 + r13
            r12.q3 = r0
            goto L_0x0159
        L_0x00e6:
            android.view.VelocityTracker r13 = r12.h3
            int r0 = r12.m3
            float r0 = (float) r0
            r1 = 1000(0x3e8, float:1.401E-42)
            r13.computeCurrentVelocity(r1, r0)
            int r0 = r12.n3
            float r13 = r13.getYVelocity(r0)
            int r13 = (int) r13
            int r0 = java.lang.Math.abs(r13)
            int r1 = r12.l3
            if (r0 < r1) goto L_0x0115
            boolean r0 = r12.v(r13)
            if (r0 != 0) goto L_0x0073
            int r13 = -r13
            float r0 = (float) r13
            boolean r1 = r12.dispatchNestedPreFling(r4, r0)
            if (r1 != 0) goto L_0x0073
            r12.dispatchNestedFling(r4, r0, r3)
            r12.z(r13)
            goto L_0x0073
        L_0x0115:
            android.widget.OverScroller r5 = r12.Z2
            int r6 = r12.getScrollX()
            int r7 = r12.getScrollY()
            r10 = 0
            int r11 = r12.getScrollRange()
            r8 = 0
            r9 = 0
            boolean r13 = r5.springBack(r6, r7, r8, r9, r10, r11)
            if (r13 == 0) goto L_0x0073
            goto L_0x0070
        L_0x012e:
            int r0 = r12.getChildCount()
            if (r0 != 0) goto L_0x0135
            return r1
        L_0x0135:
            boolean r0 = r12.g3
            if (r0 == 0) goto L_0x0142
            android.view.ViewParent r0 = r12.getParent()
            if (r0 == 0) goto L_0x0142
            r0.requestDisallowInterceptTouchEvent(r3)
        L_0x0142:
            android.widget.OverScroller r0 = r12.Z2
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x014d
            r12.e()
        L_0x014d:
            float r0 = r13.getY()
            int r0 = (int) r0
            int r13 = r13.getPointerId(r1)
            r12.G(r0, r13)
        L_0x0159:
            android.view.VelocityTracker r13 = r12.h3
            if (r13 == 0) goto L_0x0160
            r13.addMovement(r2)
        L_0x0160:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void q(@NonNull View view, int i2, int i4, int i5, int i6, int i7) {
        M(i6, i7, (int[]) null);
    }

    public boolean r(@NonNull View view, @NonNull View view2, int i2, int i4) {
        return (i2 & 2) != 0;
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.d3) {
            V(view2);
        } else {
            this.f3 = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(@NonNull View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return W(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            Q();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.d3 = true;
        super.requestLayout();
    }

    public void s(@NonNull View view, @NonNull View view2, int i2, int i4) {
        this.t3.c(view, view2, i2, i4);
        f(2, i4);
    }

    public void scrollTo(int i2, int i4) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int m2 = m(i2, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int m4 = m(i4, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (m2 != getScrollX() || m4 != getScrollY()) {
                super.scrollTo(m2, m4);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.i3) {
            this.i3 = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.u3.p(z);
    }

    public void setOnScrollChangeListener(@Nullable OnScrollChangeListener onScrollChangeListener) {
        this.w3 = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.j3 = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i2) {
        return f(i2, 0);
    }

    public void stopNestedScroll() {
        h(0);
    }

    public void t(@NonNull View view, int i2) {
        this.t3.e(view, i2);
        h(i2);
    }

    public void u(@NonNull View view, int i2, int i4, @NonNull int[] iArr, int i5) {
        b(i2, i4, iArr, (int[]) null, i5);
    }

    public boolean x(@NonNull KeyEvent keyEvent) {
        this.Y2.setEmpty();
        boolean l2 = l();
        int i2 = TsExtractor.L;
        if (!l2) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, TsExtractor.L);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(TsExtractor.L)) ? false : true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode != 62) {
                        if (keyCode != 92) {
                            if (keyCode != 93) {
                                if (keyCode == 122) {
                                    P(33);
                                    return false;
                                } else if (keyCode != 123) {
                                    return false;
                                }
                            }
                        }
                    } else if (keyEvent.isShiftPressed()) {
                        i2 = 33;
                    }
                    P(i2);
                    return false;
                } else if (!keyEvent.isAltPressed()) {
                    return j(TsExtractor.L);
                }
                return A(TsExtractor.L);
            } else if (!keyEvent.isAltPressed()) {
                return j(33);
            }
            return A(33);
        }
    }

    public void z(int i2) {
        if (getChildCount() > 0) {
            this.Z2.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            S(true);
        }
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f5110n);
    }

    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Y2 = new Rect();
        this.d3 = true;
        this.e3 = false;
        this.f3 = null;
        this.g3 = false;
        this.j3 = true;
        this.n3 = -1;
        this.o3 = new int[2];
        this.p3 = new int[2];
        DifferentialMotionFlingTargetImpl differentialMotionFlingTargetImpl = new DifferentialMotionFlingTargetImpl();
        this.x3 = differentialMotionFlingTargetImpl;
        this.y3 = new DifferentialMotionFlingController(getContext(), differentialMotionFlingTargetImpl);
        this.a3 = EdgeEffectCompat.a(context, attributeSet);
        this.b3 = EdgeEffectCompat.a(context, attributeSet);
        this.s = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        E();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, J3, i2, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.t3 = new NestedScrollingParentHelper(this);
        this.u3 = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.H1(this, I3);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
