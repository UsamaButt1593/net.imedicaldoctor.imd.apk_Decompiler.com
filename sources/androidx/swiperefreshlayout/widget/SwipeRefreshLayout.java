package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int K3 = 0;
    public static final int L3 = 1;
    public static final int M3 = -1;
    @VisibleForTesting
    static final int N3 = 40;
    @VisibleForTesting
    static final int O3 = 56;
    private static final String P3 = "SwipeRefreshLayout";
    private static final int Q3 = 255;
    private static final int R3 = 76;
    private static final float S3 = 2.0f;
    private static final int T3 = -1;
    private static final float U3 = 0.5f;
    private static final float V3 = 0.8f;
    private static final int W3 = 150;
    private static final int X3 = 300;
    private static final int Y3 = 200;
    private static final int Z3 = 200;
    private static final int a4 = -328966;
    private static final int b4 = 64;
    private static final int[] c4 = {16842766};
    private Animation A3;
    private Animation B3;
    private Animation C3;
    boolean D3;
    private int E3;
    boolean F3;
    private OnChildScrollUpCallback G3;
    private Animation.AnimationListener H3;
    private final Animation I3;
    private final Animation J3;
    OnRefreshListener X2;
    boolean Y2;
    private int Z2;
    private float a3;
    private float b3;
    private final NestedScrollingParentHelper c3;
    private final NestedScrollingChildHelper d3;
    private final int[] e3;
    private final int[] f3;
    private boolean g3;
    private int h3;
    int i3;
    private float j3;
    private float k3;
    private boolean l3;
    private int m3;
    boolean n3;
    private boolean o3;
    private final DecelerateInterpolator p3;
    CircleImageView q3;
    private int r3;
    private View s;
    protected int s3;
    float t3;
    protected int u3;
    int v3;
    int w3;
    CircularProgressDrawable x3;
    private Animation y3;
    private Animation z3;

    public interface OnChildScrollUpCallback {
        boolean a(@NonNull SwipeRefreshLayout swipeRefreshLayout, @Nullable View view);
    }

    public interface OnRefreshListener {
        void a();
    }

    public SwipeRefreshLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void A(boolean z, boolean z2) {
        if (this.Y2 != z) {
            this.D3 = z2;
            l();
            this.Y2 = z;
            if (z) {
                e(this.i3, this.H3);
            } else {
                F(this.H3);
            }
        }
    }

    private Animation B(final int i2, final int i4) {
        AnonymousClass4 r0 = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                CircularProgressDrawable circularProgressDrawable = SwipeRefreshLayout.this.x3;
                int i2 = i2;
                circularProgressDrawable.setAlpha((int) (((float) i2) + (((float) (i4 - i2)) * f2)));
            }
        };
        r0.setDuration(300);
        this.q3.b((Animation.AnimationListener) null);
        this.q3.clearAnimation();
        this.q3.startAnimation(r0);
        return r0;
    }

    private void C(float f2) {
        float f4 = this.k3;
        int i2 = this.Z2;
        if (f2 - f4 > ((float) i2) && !this.l3) {
            this.j3 = f4 + ((float) i2);
            this.l3 = true;
            this.x3.setAlpha(76);
        }
    }

    private void D() {
        this.B3 = B(this.x3.getAlpha(), 255);
    }

    private void E() {
        this.A3 = B(this.x3.getAlpha(), 76);
    }

    private void G(int i2, Animation.AnimationListener animationListener) {
        this.s3 = i2;
        this.t3 = this.q3.getScaleX();
        AnonymousClass8 r32 = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                float f3 = swipeRefreshLayout.t3;
                swipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
                SwipeRefreshLayout.this.v(f2);
            }
        };
        this.C3 = r32;
        r32.setDuration(150);
        if (animationListener != null) {
            this.q3.b(animationListener);
        }
        this.q3.clearAnimation();
        this.q3.startAnimation(this.C3);
    }

    private void H(Animation.AnimationListener animationListener) {
        this.q3.setVisibility(0);
        this.x3.setAlpha(255);
        AnonymousClass2 r0 = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f2);
            }
        };
        this.y3 = r0;
        r0.setDuration((long) this.h3);
        if (animationListener != null) {
            this.q3.b(animationListener);
        }
        this.q3.clearAnimation();
        this.q3.startAnimation(this.y3);
    }

    private void e(int i2, Animation.AnimationListener animationListener) {
        this.s3 = i2;
        this.I3.reset();
        this.I3.setDuration(200);
        this.I3.setInterpolator(this.p3);
        if (animationListener != null) {
            this.q3.b(animationListener);
        }
        this.q3.clearAnimation();
        this.q3.startAnimation(this.I3);
    }

    private void i(int i2, Animation.AnimationListener animationListener) {
        if (this.n3) {
            G(i2, animationListener);
            return;
        }
        this.s3 = i2;
        this.J3.reset();
        this.J3.setDuration(200);
        this.J3.setInterpolator(this.p3);
        if (animationListener != null) {
            this.q3.b(animationListener);
        }
        this.q3.clearAnimation();
        this.q3.startAnimation(this.J3);
    }

    private void k() {
        this.q3 = new CircleImageView(getContext(), a4);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.x3 = circularProgressDrawable;
        circularProgressDrawable.F(1);
        this.q3.setImageDrawable(this.x3);
        this.q3.setVisibility(8);
        addView(this.q3);
    }

    private void l() {
        if (this.s == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.q3)) {
                    this.s = childAt;
                    return;
                }
            }
        }
    }

    private void m(float f2) {
        if (f2 > this.a3) {
            A(true, true);
            return;
        }
        this.Y2 = false;
        this.x3.C(0.0f, 0.0f);
        i(this.i3, !this.n3 ? new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (!swipeRefreshLayout.n3) {
                    swipeRefreshLayout.F((Animation.AnimationListener) null);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        } : null);
        this.x3.u(false);
    }

    private boolean n(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    private void p(float f2) {
        this.x3.u(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.a3));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.a3;
        int i2 = this.w3;
        if (i2 <= 0) {
            i2 = this.F3 ? this.v3 - this.u3 : this.v3;
        }
        float f4 = (float) i2;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f4 * 2.0f) / f4) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i4 = this.u3 + ((int) ((f4 * min) + (f4 * pow * 2.0f)));
        if (this.q3.getVisibility() != 0) {
            this.q3.setVisibility(0);
        }
        if (!this.n3) {
            this.q3.setScaleX(1.0f);
            this.q3.setScaleY(1.0f);
        }
        if (this.n3) {
            setAnimationProgress(Math.min(1.0f, f2 / this.a3));
        }
        if (f2 < this.a3) {
            if (this.x3.getAlpha() > 76 && !n(this.A3)) {
                E();
            }
        } else if (this.x3.getAlpha() < 255 && !n(this.B3)) {
            D();
        }
        this.x3.C(0.0f, Math.min(V3, max * V3));
        this.x3.v(Math.min(1.0f, max));
        this.x3.z((((max * 0.4f) - 16.0f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i4 - this.i3);
    }

    private void setColorViewAlpha(int i2) {
        this.q3.getBackground().setAlpha(i2);
        this.x3.setAlpha(i2);
    }

    private void w(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.m3) {
            this.m3 = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void F(Animation.AnimationListener animationListener) {
        AnonymousClass3 r0 = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
            }
        };
        this.z3 = r0;
        r0.setDuration(150);
        this.q3.b(animationListener);
        this.q3.clearAnimation();
        this.q3.startAnimation(this.z3);
    }

    public boolean dispatchNestedFling(float f2, float f4, boolean z) {
        return this.d3.a(f2, f4, z);
    }

    public boolean dispatchNestedPreFling(float f2, float f4) {
        return this.d3.b(f2, f4);
    }

    public boolean dispatchNestedPreScroll(int i2, int i4, int[] iArr, int[] iArr2) {
        return this.d3.c(i2, i4, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i4, int i5, int i6, int[] iArr) {
        return this.d3.f(i2, i4, i5, i6, iArr);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i4) {
        int i5 = this.r3;
        return i5 < 0 ? i4 : i4 == i2 + -1 ? i5 : i4 >= i5 ? i4 + 1 : i4;
    }

    public int getNestedScrollAxes() {
        return this.c3.a();
    }

    public int getProgressCircleDiameter() {
        return this.E3;
    }

    public int getProgressViewEndOffset() {
        return this.v3;
    }

    public int getProgressViewStartOffset() {
        return this.u3;
    }

    public boolean hasNestedScrollingParent() {
        return this.d3.k();
    }

    public boolean isNestedScrollingEnabled() {
        return this.d3.m();
    }

    public boolean j() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.G3;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.a(this, this.s);
        }
        View view = this.s;
        return view instanceof ListView ? ListViewCompat.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    public boolean o() {
        return this.Y2;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        l();
        int actionMasked = motionEvent.getActionMasked();
        if (this.o3 && actionMasked == 0) {
            this.o3 = false;
        }
        if (!isEnabled() || this.o3 || j() || this.Y2 || this.g3) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.m3;
                    if (i2 == -1) {
                        Log.e(P3, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    C(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        w(motionEvent);
                    }
                }
            }
            this.l3 = false;
            this.m3 = -1;
        } else {
            setTargetOffsetTopAndBottom(this.u3 - this.q3.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.m3 = pointerId;
            this.l3 = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.k3 = motionEvent.getY(findPointerIndex2);
        }
        return this.l3;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.s == null) {
                l();
            }
            View view = this.s;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.q3.getMeasuredWidth();
                int measuredHeight2 = this.q3.getMeasuredHeight();
                int i7 = measuredWidth / 2;
                int i8 = measuredWidth2 / 2;
                int i9 = this.i3;
                this.q3.layout(i7 - i8, i9, i7 + i8, measuredHeight2 + i9);
            }
        }
    }

    public void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        if (this.s == null) {
            l();
        }
        View view = this.s;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.q3.measure(View.MeasureSpec.makeMeasureSpec(this.E3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.E3, 1073741824));
            this.r3 = -1;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                if (getChildAt(i5) == this.q3) {
                    this.r3 = i5;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f2, float f4, boolean z) {
        return dispatchNestedFling(f2, f4, z);
    }

    public boolean onNestedPreFling(View view, float f2, float f4) {
        return dispatchNestedPreFling(f2, f4);
    }

    public void onNestedPreScroll(View view, int i2, int i4, int[] iArr) {
        if (i4 > 0) {
            float f2 = this.b3;
            if (f2 > 0.0f) {
                float f4 = (float) i4;
                if (f4 > f2) {
                    iArr[1] = i4 - ((int) f2);
                    this.b3 = 0.0f;
                } else {
                    this.b3 = f2 - f4;
                    iArr[1] = i4;
                }
                p(this.b3);
            }
        }
        if (this.F3 && i4 > 0 && this.b3 == 0.0f && Math.abs(i4 - iArr[1]) > 0) {
            this.q3.setVisibility(8);
        }
        int[] iArr2 = this.e3;
        if (dispatchNestedPreScroll(i2 - iArr[0], i4 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScroll(View view, int i2, int i4, int i5, int i6) {
        dispatchNestedScroll(i2, i4, i5, i6, this.f3);
        int i7 = i6 + this.f3[1];
        if (i7 < 0 && !j()) {
            float abs = this.b3 + ((float) Math.abs(i7));
            this.b3 = abs;
            p(abs);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.c3.b(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.b3 = 0.0f;
        this.g3 = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return isEnabled() && !this.o3 && !this.Y2 && (i2 & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.c3.d(view);
        this.g3 = false;
        float f2 = this.b3;
        if (f2 > 0.0f) {
            m(f2);
            this.b3 = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.o3 && actionMasked == 0) {
            this.o3 = false;
        }
        if (!isEnabled() || this.o3 || j() || this.Y2 || this.g3) {
            return false;
        }
        if (actionMasked == 0) {
            this.m3 = motionEvent.getPointerId(0);
            this.l3 = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.m3);
            if (findPointerIndex < 0) {
                Log.e(P3, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.l3) {
                this.l3 = false;
                m((motionEvent.getY(findPointerIndex) - this.j3) * 0.5f);
            }
            this.m3 = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.m3);
            if (findPointerIndex2 < 0) {
                Log.e(P3, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y = motionEvent.getY(findPointerIndex2);
            C(y);
            if (this.l3) {
                float f2 = (y - this.j3) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                p(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(P3, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.m3 = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                w(motionEvent);
            }
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        View view = this.s;
        if (view == null || ViewCompat.a1(view)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* access modifiers changed from: package-private */
    public void setAnimationProgress(float f2) {
        this.q3.setScaleX(f2);
        this.q3.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(@ColorRes int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        l();
        this.x3.y(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = ContextCompat.g(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.a3 = (float) i2;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            x();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.d3.p(z);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback onChildScrollUpCallback) {
        this.G3 = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(@Nullable OnRefreshListener onRefreshListener) {
        this.X2 = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i2) {
        this.q3.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i2) {
        setProgressBackgroundColorSchemeColor(ContextCompat.g(getContext(), i2));
    }

    public void setRefreshing(boolean z) {
        if (!z || this.Y2 == z) {
            A(z, false);
            return;
        }
        this.Y2 = z;
        setTargetOffsetTopAndBottom((!this.F3 ? this.v3 + this.u3 : this.v3) - this.i3);
        this.D3 = false;
        H(this.H3);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.E3 = (int) (getResources().getDisplayMetrics().density * (i2 == 0 ? 56.0f : 40.0f));
            this.q3.setImageDrawable((Drawable) null);
            this.x3.F(i2);
            this.q3.setImageDrawable(this.x3);
        }
    }

    public void setSlingshotDistance(@Px int i2) {
        this.w3 = i2;
    }

    /* access modifiers changed from: package-private */
    public void setTargetOffsetTopAndBottom(int i2) {
        this.q3.bringToFront();
        ViewCompat.j1(this.q3, i2);
        this.i3 = this.q3.getTop();
    }

    public boolean startNestedScroll(int i2) {
        return this.d3.r(i2);
    }

    public void stopNestedScroll() {
        this.d3.t();
    }

    /* access modifiers changed from: package-private */
    public void v(float f2) {
        int i2 = this.s3;
        setTargetOffsetTopAndBottom((i2 + ((int) (((float) (this.u3 - i2)) * f2))) - this.q3.getTop());
    }

    /* access modifiers changed from: package-private */
    public void x() {
        this.q3.clearAnimation();
        this.x3.stop();
        this.q3.setVisibility(8);
        setColorViewAlpha(255);
        if (this.n3) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.u3 - this.i3);
        }
        this.i3 = this.q3.getTop();
    }

    public void y(boolean z, int i2) {
        this.v3 = i2;
        this.n3 = z;
        this.q3.invalidate();
    }

    public void z(boolean z, int i2, int i4) {
        this.n3 = z;
        this.u3 = i2;
        this.v3 = i4;
        this.F3 = true;
        x();
        this.Y2 = false;
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Y2 = false;
        this.a3 = -1.0f;
        this.e3 = new int[2];
        this.f3 = new int[2];
        this.m3 = -1;
        this.r3 = -1;
        this.H3 = new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                OnRefreshListener onRefreshListener;
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (swipeRefreshLayout.Y2) {
                    swipeRefreshLayout.x3.setAlpha(255);
                    SwipeRefreshLayout.this.x3.start();
                    SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                    if (swipeRefreshLayout2.D3 && (onRefreshListener = swipeRefreshLayout2.X2) != null) {
                        onRefreshListener.a();
                    }
                    SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                    swipeRefreshLayout3.i3 = swipeRefreshLayout3.q3.getTop();
                    return;
                }
                swipeRefreshLayout.x();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        this.I3 = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                int abs = !swipeRefreshLayout.F3 ? swipeRefreshLayout.v3 - Math.abs(swipeRefreshLayout.u3) : swipeRefreshLayout.v3;
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                int i2 = swipeRefreshLayout2.s3;
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i2 + ((int) (((float) (abs - i2)) * f2))) - swipeRefreshLayout2.q3.getTop());
                SwipeRefreshLayout.this.x3.v(1.0f - f2);
            }
        };
        this.J3 = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.v(f2);
            }
        };
        this.Z2 = ViewConfiguration.get(context).getScaledTouchSlop();
        this.h3 = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.p3 = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.E3 = (int) (displayMetrics.density * 40.0f);
        k();
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.v3 = i2;
        this.a3 = (float) i2;
        this.c3 = new NestedScrollingParentHelper(this);
        this.d3 = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i4 = -this.E3;
        this.i3 = i4;
        this.u3 = i4;
        v(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c4);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }
}
