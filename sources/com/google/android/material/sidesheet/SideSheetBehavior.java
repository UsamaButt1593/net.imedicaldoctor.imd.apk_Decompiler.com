package com.google.android.material.sidesheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.annotation.GravityInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;

public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements Sheet<SideSheetCallback> {
    private static final int s3 = R.string.g2;
    static final int t3 = 500;
    private static final float u3 = 0.5f;
    private static final float v3 = 0.1f;
    private static final int w3 = -1;
    private static final int x3 = R.style.Hh;
    private float X;
    private ShapeAppearanceModel X2;
    @Nullable
    private MaterialShapeDrawable Y;
    private final SideSheetBehavior<V>.StateSettlingTracker Y2 = new StateSettlingTracker();
    @Nullable
    private ColorStateList Z;
    private float Z2;
    /* access modifiers changed from: private */
    public boolean a3 = true;
    /* access modifiers changed from: private */
    public int b3 = 5;
    private int c3 = 5;
    /* access modifiers changed from: private */
    @Nullable
    public ViewDragHelper d3;
    private boolean e3;
    private float f3 = 0.1f;
    /* access modifiers changed from: private */
    public int g3;
    private int h3;
    private int i3;
    private int j3;
    /* access modifiers changed from: private */
    @Nullable
    public WeakReference<V> k3;
    @Nullable
    private WeakReference<View> l3;
    @IdRes
    private int m3 = -1;
    @Nullable
    private VelocityTracker n3;
    @Nullable
    private MaterialSideContainerBackHelper o3;
    private int p3;
    @NonNull
    private final Set<SideSheetCallback> q3 = new LinkedHashSet();
    private final ViewDragHelper.Callback r3 = new ViewDragHelper.Callback() {
        public int a(@NonNull View view, int i2, int i3) {
            return MathUtils.e(i2, SideSheetBehavior.this.s.g(), SideSheetBehavior.this.s.f());
        }

        public int b(@NonNull View view, int i2, int i3) {
            return view.getTop();
        }

        public int d(@NonNull View view) {
            return SideSheetBehavior.this.g3 + SideSheetBehavior.this.t0();
        }

        public void j(int i2) {
            if (i2 == 1 && SideSheetBehavior.this.a3) {
                SideSheetBehavior.this.Y0(1);
            }
        }

        public void k(@NonNull View view, int i2, int i3, int i4, int i5) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View o0 = SideSheetBehavior.this.o0();
            if (!(o0 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) o0.getLayoutParams()) == null)) {
                SideSheetBehavior.this.s.p(marginLayoutParams, view.getLeft(), view.getRight());
                o0.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.g0(view, i2);
        }

        public void l(@NonNull View view, float f2, float f3) {
            int V = SideSheetBehavior.this.c0(view, f2, f3);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.d1(view, V, sideSheetBehavior.c1());
        }

        public boolean m(@NonNull View view, int i2) {
            return (SideSheetBehavior.this.b3 == 1 || SideSheetBehavior.this.k3 == null || SideSheetBehavior.this.k3.get() != view) ? false : true;
        }
    };
    /* access modifiers changed from: private */
    public SheetDelegate s;

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            @Nullable
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        final int Y;

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.Y);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Y = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, @NonNull SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.Y = sideSheetBehavior.b3;
        }
    }

    class StateSettlingTracker {

        /* renamed from: a  reason: collision with root package name */
        private int f21922a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f21923b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f21924c = new e(this);

        StateSettlingTracker() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f21923b = false;
            if (SideSheetBehavior.this.d3 != null && SideSheetBehavior.this.d3.o(true)) {
                b(this.f21922a);
            } else if (SideSheetBehavior.this.b3 == 2) {
                SideSheetBehavior.this.Y0(this.f21922a);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            if (SideSheetBehavior.this.k3 != null && SideSheetBehavior.this.k3.get() != null) {
                this.f21922a = i2;
                if (!this.f21923b) {
                    ViewCompat.v1((View) SideSheetBehavior.this.k3.get(), this.f21924c);
                    this.f21923b = true;
                }
            }
        }
    }

    public SideSheetBehavior() {
    }

    @Nullable
    private CoordinatorLayout.LayoutParams A0() {
        View view;
        WeakReference<V> weakReference = this.k3;
        if (weakReference == null || (view = (View) weakReference.get()) == null || !(view.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            return null;
        }
        return (CoordinatorLayout.LayoutParams) view.getLayoutParams();
    }

    private boolean C0() {
        CoordinatorLayout.LayoutParams A0 = A0();
        return A0 != null && A0.leftMargin > 0;
    }

    private boolean D0() {
        CoordinatorLayout.LayoutParams A0 = A0();
        return A0 != null && A0.rightMargin > 0;
    }

    private boolean G0(@NonNull MotionEvent motionEvent) {
        return Z0() && b0((float) this.p3, motionEvent.getX()) > ((float) this.d3.E());
    }

    private boolean H0(float f2) {
        return this.s.k(f2);
    }

    private boolean I0(@NonNull V v) {
        ViewParent parent = v.getParent();
        return parent != null && parent.isLayoutRequested() && ViewCompat.R0(v);
    }

    private boolean J0(View view, int i2, boolean z) {
        int v0 = v0(i2);
        ViewDragHelper z0 = z0();
        return z0 != null && (!z ? z0.X(view, v0, view.getTop()) : z0.V(v0, view.getTop()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean K0(int i2, View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        b(i2);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L0(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, View view, ValueAnimator valueAnimator) {
        this.s.o(marginLayoutParams, AnimationUtils.c(i2, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M0(int i2) {
        View view = (View) this.k3.get();
        if (view != null) {
            d1(view, i2, false);
        }
    }

    private void N0(@NonNull CoordinatorLayout coordinatorLayout) {
        int i2;
        View findViewById;
        if (this.l3 == null && (i2 = this.m3) != -1 && (findViewById = coordinatorLayout.findViewById(i2)) != null) {
            this.l3 = new WeakReference<>(findViewById);
        }
    }

    private void P0(V v, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i2) {
        ViewCompat.A1(v, accessibilityActionCompat, (CharSequence) null, e0(i2));
    }

    private void Q0() {
        VelocityTracker velocityTracker = this.n3;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.n3 = null;
        }
    }

    private void R0(@NonNull V v, Runnable runnable) {
        if (I0(v)) {
            v.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void W0(int i2) {
        SheetDelegate sheetDelegate = this.s;
        if (sheetDelegate != null && sheetDelegate.j() == i2) {
            return;
        }
        if (i2 == 0) {
            this.s = new RightSheetDelegate(this);
            if (this.X2 != null && !D0()) {
                ShapeAppearanceModel.Builder v = this.X2.v();
                v.P(0.0f).C(0.0f);
                g1(v.m());
            }
        } else if (i2 == 1) {
            this.s = new LeftSheetDelegate(this);
            if (this.X2 != null && !C0()) {
                ShapeAppearanceModel.Builder v2 = this.X2.v();
                v2.K(0.0f).x(0.0f);
                g1(v2.m());
            }
        } else {
            throw new IllegalArgumentException("Invalid sheet edge position value: " + i2 + ". Must be " + 0 + " or " + 1 + ".");
        }
    }

    private void X0(@NonNull V v, int i2) {
        W0(GravityCompat.d(((CoordinatorLayout.LayoutParams) v.getLayoutParams()).f5079c, i2) == 3 ? 1 : 0);
    }

    private boolean Z0() {
        return this.d3 != null && (this.a3 || this.b3 == 1);
    }

    private int a0(int i2, V v) {
        int i4 = this.b3;
        if (i4 == 1 || i4 == 2) {
            return i2 - this.s.h(v);
        }
        if (i4 == 3) {
            return 0;
        }
        if (i4 == 5) {
            return this.s.e();
        }
        throw new IllegalStateException("Unexpected value: " + this.b3);
    }

    private float b0(float f2, float f4) {
        return Math.abs(f2 - f4);
    }

    private boolean b1(@NonNull V v) {
        return (v.isShown() || ViewCompat.J(v) != null) && this.a3;
    }

    /* access modifiers changed from: private */
    public int c0(@NonNull View view, float f2, float f4) {
        if (H0(f2)) {
            return 3;
        }
        if (a1(view, f2)) {
            return (this.s.m(f2, f4) || this.s.l(view)) ? 5 : 3;
        }
        if (f2 == 0.0f || !SheetUtils.a(f2, f4)) {
            int left = view.getLeft();
            if (Math.abs(left - p0()) < Math.abs(left - this.s.e())) {
                return 3;
            }
        }
    }

    private void d0() {
        WeakReference<View> weakReference = this.l3;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.l3 = null;
    }

    /* access modifiers changed from: private */
    public void d1(View view, int i2, boolean z) {
        if (J0(view, i2, z)) {
            Y0(2);
            this.Y2.b(i2);
            return;
        }
        Y0(i2);
    }

    private AccessibilityViewCommand e0(int i2) {
        return new c(this, i2);
    }

    private void e1() {
        View view;
        WeakReference<V> weakReference = this.k3;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            ViewCompat.x1(view, 262144);
            ViewCompat.x1(view, 1048576);
            if (this.b3 != 5) {
                P0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.z, 5);
            }
            if (this.b3 != 3) {
                P0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.x, 3);
            }
        }
    }

    private void f0(@NonNull Context context) {
        if (this.X2 != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.X2);
            this.Y = materialShapeDrawable;
            materialShapeDrawable.a0(context);
            ColorStateList colorStateList = this.Z;
            if (colorStateList != null) {
                this.Y.p0(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.Y.setTint(typedValue.data);
        }
    }

    private void f1() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference<V> weakReference = this.k3;
        if (weakReference != null && weakReference.get() != null) {
            View view = (View) this.k3.get();
            View o0 = o0();
            if (o0 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) o0.getLayoutParams()) != null) {
                this.s.o(marginLayoutParams, (int) ((((float) this.g3) * view.getScaleX()) + ((float) this.j3)));
                o0.requestLayout();
            }
        }
    }

    /* access modifiers changed from: private */
    public void g0(@NonNull View view, int i2) {
        if (!this.q3.isEmpty()) {
            float b2 = this.s.b(i2);
            for (SideSheetCallback b4 : this.q3) {
                b4.b(view, b2);
            }
        }
    }

    private void g1(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = this.Y;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    private void h0(View view) {
        if (ViewCompat.J(view) == null) {
            ViewCompat.K1(view, view.getResources().getString(s3));
        }
    }

    private void h1(@NonNull View view) {
        int i2 = this.b3 == 5 ? 4 : 0;
        if (view.getVisibility() != i2) {
            view.setVisibility(i2);
        }
    }

    @NonNull
    public static <V extends View> SideSheetBehavior<V> j0(@NonNull V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior f2 = ((CoordinatorLayout.LayoutParams) layoutParams).f();
            if (f2 instanceof SideSheetBehavior) {
                return (SideSheetBehavior) f2;
            }
            throw new IllegalArgumentException("The view is not associated with SideSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int l0(int i2, int i4, int i5, int i6) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, i4, i6);
        if (i5 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i5), 1073741824);
        }
        if (size != 0) {
            i5 = Math.min(size, i5);
        }
        return View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
    }

    @Nullable
    private ValueAnimator.AnimatorUpdateListener n0() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        View o0 = o0();
        if (o0 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) o0.getLayoutParams()) == null) {
            return null;
        }
        return new d(this, marginLayoutParams, this.s.c(marginLayoutParams), o0);
    }

    @GravityInt
    private int q0() {
        SheetDelegate sheetDelegate = this.s;
        return (sheetDelegate == null || sheetDelegate.j() == 0) ? 5 : 3;
    }

    /* access modifiers changed from: package-private */
    public float B0() {
        VelocityTracker velocityTracker = this.n3;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.X);
        return this.n3.getXVelocity();
    }

    public void E0() {
        b(5);
    }

    public void F(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.a() != null) {
            super.F(coordinatorLayout, v, savedState.a());
        }
        int i2 = savedState.Y;
        if (i2 == 1 || i2 == 2) {
            i2 = 5;
        }
        this.b3 = i2;
        this.c3 = i2;
    }

    public boolean F0() {
        return this.a3;
    }

    @NonNull
    public Parcelable G(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
        return new SavedState(super.G(coordinatorLayout, v), (SideSheetBehavior<?>) this);
    }

    public boolean L(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.b3 == 1 && actionMasked == 0) {
            return true;
        }
        if (Z0()) {
            this.d3.M(motionEvent);
        }
        if (actionMasked == 0) {
            Q0();
        }
        if (this.n3 == null) {
            this.n3 = VelocityTracker.obtain();
        }
        this.n3.addMovement(motionEvent);
        if (Z0() && actionMasked == 2 && !this.e3 && G0(motionEvent)) {
            this.d3.d(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.e3;
    }

    /* renamed from: O0 */
    public void f(@NonNull SideSheetCallback sideSheetCallback) {
        this.q3.remove(sideSheetCallback);
    }

    public void S0(@Nullable View view) {
        this.m3 = -1;
        if (view == null) {
            d0();
            return;
        }
        this.l3 = new WeakReference<>(view);
        WeakReference<V> weakReference = this.k3;
        if (weakReference != null) {
            View view2 = (View) weakReference.get();
            if (ViewCompat.Y0(view2)) {
                view2.requestLayout();
            }
        }
    }

    public void T0(@IdRes int i2) {
        this.m3 = i2;
        d0();
        WeakReference<V> weakReference = this.k3;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (i2 != -1 && ViewCompat.Y0(view)) {
                view.requestLayout();
            }
        }
    }

    public void U0(boolean z) {
        this.a3 = z;
    }

    public void V0(float f2) {
        this.f3 = f2;
    }

    /* access modifiers changed from: package-private */
    public void Y0(int i2) {
        View view;
        if (this.b3 != i2) {
            this.b3 = i2;
            if (i2 == 3 || i2 == 5) {
                this.c3 = i2;
            }
            WeakReference<V> weakReference = this.k3;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                h1(view);
                for (SideSheetCallback a2 : this.q3) {
                    a2.a(view, i2);
                }
                e1();
            }
        }
    }

    /* renamed from: Z */
    public void a(@NonNull SideSheetCallback sideSheetCallback) {
        this.q3.add(sideSheetCallback);
    }

    /* access modifiers changed from: package-private */
    public boolean a1(@NonNull View view, float f2) {
        return this.s.n(view, f2);
    }

    public void b(int i2) {
        if (i2 == 1 || i2 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i2 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        WeakReference<V> weakReference = this.k3;
        if (weakReference == null || weakReference.get() == null) {
            Y0(i2);
        } else {
            R0((View) this.k3.get(), new b(this, i2));
        }
    }

    public void c(@NonNull BackEventCompat backEventCompat) {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.o3;
        if (materialSideContainerBackHelper != null) {
            materialSideContainerBackHelper.j(backEventCompat);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean c1() {
        return true;
    }

    public void d(@NonNull BackEventCompat backEventCompat) {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.o3;
        if (materialSideContainerBackHelper != null) {
            materialSideContainerBackHelper.l(backEventCompat, q0());
            f1();
        }
    }

    public void e() {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.o3;
        if (materialSideContainerBackHelper != null) {
            BackEventCompat c2 = materialSideContainerBackHelper.c();
            if (c2 == null || Build.VERSION.SDK_INT < 34) {
                b(5);
            } else {
                this.o3.h(c2, q0(), new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        SideSheetBehavior.this.Y0(5);
                        if (SideSheetBehavior.this.k3 != null && SideSheetBehavior.this.k3.get() != null) {
                            ((View) SideSheetBehavior.this.k3.get()).requestLayout();
                        }
                    }
                }, n0());
            }
        }
    }

    public void g() {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.o3;
        if (materialSideContainerBackHelper != null) {
            materialSideContainerBackHelper.f();
        }
    }

    public int getState() {
        return this.b3;
    }

    public void i0() {
        b(3);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public MaterialSideContainerBackHelper k0() {
        return this.o3;
    }

    /* access modifiers changed from: package-private */
    public int m0() {
        return this.g3;
    }

    public void o(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.o(layoutParams);
        this.k3 = null;
        this.d3 = null;
        this.o3 = null;
    }

    @Nullable
    public View o0() {
        WeakReference<View> weakReference = this.l3;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int p0() {
        return this.s.d();
    }

    public void r() {
        super.r();
        this.k3 = null;
        this.d3 = null;
        this.o3 = null;
    }

    public float r0() {
        return this.f3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        r3 = r2.d3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean s(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r3, @androidx.annotation.NonNull V r4, @androidx.annotation.NonNull android.view.MotionEvent r5) {
        /*
            r2 = this;
            boolean r3 = r2.b1(r4)
            r4 = 1
            r0 = 0
            if (r3 != 0) goto L_0x000b
            r2.e3 = r4
            return r0
        L_0x000b:
            int r3 = r5.getActionMasked()
            if (r3 != 0) goto L_0x0014
            r2.Q0()
        L_0x0014:
            android.view.VelocityTracker r1 = r2.n3
            if (r1 != 0) goto L_0x001e
            android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
            r2.n3 = r1
        L_0x001e:
            android.view.VelocityTracker r1 = r2.n3
            r1.addMovement(r5)
            if (r3 == 0) goto L_0x0032
            if (r3 == r4) goto L_0x002b
            r1 = 3
            if (r3 == r1) goto L_0x002b
            goto L_0x0039
        L_0x002b:
            boolean r3 = r2.e3
            if (r3 == 0) goto L_0x0039
            r2.e3 = r0
            return r0
        L_0x0032:
            float r3 = r5.getX()
            int r3 = (int) r3
            r2.p3 = r3
        L_0x0039:
            boolean r3 = r2.e3
            if (r3 != 0) goto L_0x0048
            androidx.customview.widget.ViewDragHelper r3 = r2.d3
            if (r3 == 0) goto L_0x0048
            boolean r3 = r3.W(r5)
            if (r3 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r4 = 0
        L_0x0049:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.s(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public float s0() {
        return 0.5f;
    }

    public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        if (ViewCompat.W(coordinatorLayout) && !ViewCompat.W(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.k3 == null) {
            this.k3 = new WeakReference<>(v);
            this.o3 = new MaterialSideContainerBackHelper(v);
            MaterialShapeDrawable materialShapeDrawable = this.Y;
            if (materialShapeDrawable != null) {
                ViewCompat.P1(v, materialShapeDrawable);
                MaterialShapeDrawable materialShapeDrawable2 = this.Y;
                float f2 = this.Z2;
                if (f2 == -1.0f) {
                    f2 = ViewCompat.T(v);
                }
                materialShapeDrawable2.o0(f2);
            } else {
                ColorStateList colorStateList = this.Z;
                if (colorStateList != null) {
                    ViewCompat.Q1(v, colorStateList);
                }
            }
            h1(v);
            e1();
            if (ViewCompat.X(v) == 0) {
                ViewCompat.Z1(v, 1);
            }
            h0(v);
        }
        X0(v, i2);
        if (this.d3 == null) {
            this.d3 = ViewDragHelper.q(coordinatorLayout, this.r3);
        }
        int h2 = this.s.h(v);
        coordinatorLayout.N(v, i2);
        this.h3 = coordinatorLayout.getWidth();
        this.i3 = this.s.i(coordinatorLayout);
        this.g3 = v.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        this.j3 = marginLayoutParams != null ? this.s.a(marginLayoutParams) : 0;
        ViewCompat.i1(v, a0(h2, v));
        N0(coordinatorLayout);
        for (SheetCallback next : this.q3) {
            if (next instanceof SideSheetCallback) {
                ((SideSheetCallback) next).c(v);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public int t0() {
        return this.j3;
    }

    public boolean u(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        v.measure(l0(i2, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, -1, marginLayoutParams.width), l0(i5, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, -1, marginLayoutParams.height));
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int u0() {
        return this.c3;
    }

    /* access modifiers changed from: package-private */
    public int v0(int i2) {
        if (i2 == 3) {
            return p0();
        }
        if (i2 == 5) {
            return this.s.e();
        }
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i2);
    }

    /* access modifiers changed from: package-private */
    public int w0() {
        return this.i3;
    }

    /* access modifiers changed from: package-private */
    public int x0() {
        return this.h3;
    }

    /* access modifiers changed from: package-private */
    public int y0() {
        return 500;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ViewDragHelper z0() {
        return this.d3;
    }

    public SideSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Ft);
        int i2 = R.styleable.Jt;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.Z = MaterialResources.a(context, obtainStyledAttributes, i2);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Mt)) {
            this.X2 = ShapeAppearanceModel.e(context, attributeSet, 0, x3).m();
        }
        int i4 = R.styleable.Lt;
        if (obtainStyledAttributes.hasValue(i4)) {
            T0(obtainStyledAttributes.getResourceId(i4, -1));
        }
        f0(context);
        this.Z2 = obtainStyledAttributes.getDimension(R.styleable.It, -1.0f);
        U0(obtainStyledAttributes.getBoolean(R.styleable.Kt, true));
        obtainStyledAttributes.recycle();
        this.X = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
