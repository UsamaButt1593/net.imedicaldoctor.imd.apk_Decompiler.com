package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.WindowUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = -2;
    public static final int D = -1;
    public static final int E = 0;
    static final int F = 250;
    static final int G = 180;
    private static final TimeInterpolator H = AnimationUtils.f20767b;
    private static final int I = 150;
    private static final int J = 75;
    private static final TimeInterpolator K = AnimationUtils.f20766a;
    private static final TimeInterpolator L = AnimationUtils.f20769d;
    private static final float M = 0.8f;
    @NonNull
    static final Handler N = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                ((BaseTransientBottomBar) message.obj).n0();
                return true;
            } else if (i2 != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).P(message.arg1);
                return true;
            }
        }
    });
    static final int O = 0;
    static final int P = 1;
    /* access modifiers changed from: private */
    public static final boolean Q = false;
    private static final int[] R = {R.attr.Ig};
    /* access modifiers changed from: private */
    public static final String S = BaseTransientBottomBar.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f21939a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f21940b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f21941c;

    /* renamed from: d  reason: collision with root package name */
    private final TimeInterpolator f21942d;

    /* renamed from: e  reason: collision with root package name */
    private final TimeInterpolator f21943e;

    /* renamed from: f  reason: collision with root package name */
    private final TimeInterpolator f21944f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ViewGroup f21945g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Context f21946h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    protected final SnackbarBaseLayout f21947i;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final ContentViewCallback f21948j;

    /* renamed from: k  reason: collision with root package name */
    private int f21949k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f21950l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private Anchor f21951m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f21952n;
    @RequiresApi(29)
    private final Runnable o;
    /* access modifiers changed from: private */
    public int p;
    /* access modifiers changed from: private */
    public int q;
    /* access modifiers changed from: private */
    public int r;
    private int s;
    /* access modifiers changed from: private */
    public int t;
    /* access modifiers changed from: private */
    public int u;
    private boolean v;
    private List<BaseCallback<B>> w;
    private Behavior x;
    @Nullable
    private final AccessibilityManager y;
    @NonNull
    SnackbarManager.Callback z;

    static class Anchor implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        @NonNull
        private final WeakReference<View> X;
        @NonNull
        private final WeakReference<BaseTransientBottomBar> s;

        private Anchor(@NonNull BaseTransientBottomBar baseTransientBottomBar, @NonNull View view) {
            this.s = new WeakReference<>(baseTransientBottomBar);
            this.X = new WeakReference<>(view);
        }

        static Anchor a(@NonNull BaseTransientBottomBar baseTransientBottomBar, @NonNull View view) {
            Anchor anchor = new Anchor(baseTransientBottomBar, view);
            if (ViewCompat.R0(view)) {
                ViewUtils.b(view, anchor);
            }
            view.addOnAttachStateChangeListener(anchor);
            return anchor;
        }

        private boolean d() {
            if (this.s.get() != null) {
                return false;
            }
            c();
            return true;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public View b() {
            return this.X.get();
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (this.X.get() != null) {
                this.X.get().removeOnAttachStateChangeListener(this);
                ViewUtils.v(this.X.get(), this);
            }
            this.X.clear();
            this.s.clear();
        }

        public void onGlobalLayout() {
            if (!d() && this.s.get().f21952n) {
                this.s.get().a0();
            }
        }

        public void onViewAttachedToWindow(View view) {
            if (!d()) {
                ViewUtils.b(view, this);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            if (!d()) {
                ViewUtils.v(view, this);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationMode {
    }

    public static abstract class BaseCallback<B> {

        /* renamed from: a  reason: collision with root package name */
        public static final int f21957a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f21958b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f21959c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f21960d = 3;

        /* renamed from: e  reason: collision with root package name */
        public static final int f21961e = 4;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface DismissEvent {
        }

        public void a(B b2, int i2) {
        }

        public void b(B b2) {
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {
        @NonNull
        private final BehaviorDelegate n3 = new BehaviorDelegate(this);

        /* access modifiers changed from: private */
        public void d0(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.n3.c(baseTransientBottomBar);
        }

        public boolean O(View view) {
            return this.n3.a(view);
        }

        public boolean s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.n3.b(coordinatorLayout, view, motionEvent);
            return super.s(coordinatorLayout, view, motionEvent);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BehaviorDelegate {

        /* renamed from: a  reason: collision with root package name */
        private SnackbarManager.Callback f21962a;

        public BehaviorDelegate(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.Z(0.1f);
            swipeDismissBehavior.W(0.6f);
            swipeDismissBehavior.a0(0);
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    SnackbarManager.c().l(this.f21962a);
                }
            } else if (coordinatorLayout.G(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                SnackbarManager.c().k(this.f21962a);
            }
        }

        public void c(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f21962a = baseTransientBottomBar.z;
        }
    }

    @Deprecated
    public interface ContentViewCallback extends ContentViewCallback {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @IntRange(from = -2)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected static class SnackbarBaseLayout extends FrameLayout {
        private static final View.OnTouchListener h3 = new View.OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        @Nullable
        ShapeAppearanceModel X2;
        private int Y2;
        private final float Z2;
        private final float a3;
        private final int b3;
        private final int c3;
        private ColorStateList d3;
        private PorterDuff.Mode e3;
        /* access modifiers changed from: private */
        @Nullable
        public Rect f3;
        private boolean g3;
        @Nullable
        private BaseTransientBottomBar<?> s;

        protected SnackbarBaseLayout(@NonNull Context context) {
            this(context, (AttributeSet) null);
        }

        @NonNull
        private Drawable d() {
            int v = MaterialColors.v(this, R.attr.e4, R.attr.I3, getBackgroundOverlayColorAlpha());
            ShapeAppearanceModel shapeAppearanceModel = this.X2;
            Drawable j2 = shapeAppearanceModel != null ? BaseTransientBottomBar.z(v, shapeAppearanceModel) : BaseTransientBottomBar.y(v, getResources());
            ColorStateList colorStateList = this.d3;
            Drawable r = DrawableCompat.r(j2);
            if (colorStateList != null) {
                DrawableCompat.o(r, this.d3);
            }
            return r;
        }

        private void e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f3 = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        /* access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.s = baseTransientBottomBar;
        }

        /* access modifiers changed from: package-private */
        public void c(ViewGroup viewGroup) {
            this.g3 = true;
            viewGroup.addView(this);
            this.g3 = false;
        }

        /* access modifiers changed from: package-private */
        public float getActionTextColorAlpha() {
            return this.a3;
        }

        /* access modifiers changed from: package-private */
        public int getAnimationMode() {
            return this.Y2;
        }

        /* access modifiers changed from: package-private */
        public float getBackgroundOverlayColorAlpha() {
            return this.Z2;
        }

        /* access modifiers changed from: package-private */
        public int getMaxInlineActionWidth() {
            return this.c3;
        }

        /* access modifiers changed from: package-private */
        public int getMaxWidth() {
            return this.b3;
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.s;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.V();
            }
            ViewCompat.B1(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.s;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.W();
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.s;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.X();
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            int i4;
            super.onMeasure(i2, i3);
            if (this.b3 > 0 && getMeasuredWidth() > (i4 = this.b3)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void setAnimationMode(int i2) {
            this.Y2 = i2;
        }

        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (!(drawable == null || this.d3 == null)) {
                drawable = DrawableCompat.r(drawable.mutate());
                DrawableCompat.o(drawable, this.d3);
                DrawableCompat.p(drawable, this.e3);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.d3 = colorStateList;
            if (getBackground() != null) {
                Drawable r = DrawableCompat.r(getBackground().mutate());
                DrawableCompat.o(r, colorStateList);
                DrawableCompat.p(r, this.e3);
                if (r != getBackground()) {
                    super.setBackgroundDrawable(r);
                }
            }
        }

        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.e3 = mode;
            if (getBackground() != null) {
                Drawable r = DrawableCompat.r(getBackground().mutate());
                DrawableCompat.p(r, mode);
                if (r != getBackground()) {
                    super.setBackgroundDrawable(r);
                }
            }
        }

        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (!this.g3 && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                e((ViewGroup.MarginLayoutParams) layoutParams);
                BaseTransientBottomBar<?> baseTransientBottomBar = this.s;
                if (baseTransientBottomBar != null) {
                    baseTransientBottomBar.t0();
                }
            }
        }

        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : h3);
            super.setOnClickListener(onClickListener);
        }

        protected SnackbarBaseLayout(@NonNull Context context, AttributeSet attributeSet) {
            super(MaterialThemeOverlay.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.xu);
            int i2 = R.styleable.Eu;
            if (obtainStyledAttributes.hasValue(i2)) {
                ViewCompat.V1(this, (float) obtainStyledAttributes.getDimensionPixelSize(i2, 0));
            }
            this.Y2 = obtainStyledAttributes.getInt(R.styleable.Au, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.Gu) || obtainStyledAttributes.hasValue(R.styleable.Hu)) {
                this.X2 = ShapeAppearanceModel.e(context2, attributeSet, 0, 0).m();
            }
            this.Z2 = obtainStyledAttributes.getFloat(R.styleable.Bu, 1.0f);
            setBackgroundTintList(MaterialResources.a(context2, obtainStyledAttributes, R.styleable.Cu));
            setBackgroundTintMode(ViewUtils.u(obtainStyledAttributes.getInt(R.styleable.Du, -1), PorterDuff.Mode.SRC_IN));
            this.a3 = obtainStyledAttributes.getFloat(R.styleable.zu, 1.0f);
            this.b3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.yu, -1);
            this.c3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Fu, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(h3);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.P1(this, d());
            }
        }
    }

    protected BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        this.f21952n = false;
        this.o = new Runnable() {
            public void run() {
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                if (baseTransientBottomBar.f21947i != null && baseTransientBottomBar.f21946h != null) {
                    int height = (WindowUtils.b(BaseTransientBottomBar.this.f21946h).height() - BaseTransientBottomBar.this.N()) + ((int) BaseTransientBottomBar.this.f21947i.getTranslationY());
                    if (height >= BaseTransientBottomBar.this.t) {
                        BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                        int unused = baseTransientBottomBar2.u = baseTransientBottomBar2.t;
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f21947i.getLayoutParams();
                    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        Log.w(BaseTransientBottomBar.S, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                        return;
                    }
                    BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
                    int unused2 = baseTransientBottomBar3.u = baseTransientBottomBar3.t;
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.t - height;
                    BaseTransientBottomBar.this.f21947i.requestLayout();
                }
            }
        };
        this.z = new SnackbarManager.Callback() {
            public void a() {
                Handler handler = BaseTransientBottomBar.N;
                handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
            }

            public void b(int i2) {
                Handler handler = BaseTransientBottomBar.N;
                handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
            }
        };
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (contentViewCallback != null) {
            this.f21945g = viewGroup;
            this.f21948j = contentViewCallback;
            this.f21946h = context;
            ThemeEnforcement.a(context);
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(K(), viewGroup, false);
            this.f21947i = snackbarBaseLayout;
            snackbarBaseLayout.setBaseTransientBottomBar(this);
            if (view instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
                snackbarContentLayout.c(snackbarBaseLayout.getActionTextColorAlpha());
                snackbarContentLayout.setMaxInlineActionWidth(snackbarBaseLayout.getMaxInlineActionWidth());
            }
            snackbarBaseLayout.addView(view);
            ViewCompat.J1(snackbarBaseLayout, 1);
            ViewCompat.Z1(snackbarBaseLayout, 1);
            ViewCompat.W1(snackbarBaseLayout, true);
            ViewCompat.k2(snackbarBaseLayout, new OnApplyWindowInsetsListener() {
                @NonNull
                public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
                    int unused = BaseTransientBottomBar.this.p = windowInsetsCompat.o();
                    int unused2 = BaseTransientBottomBar.this.q = windowInsetsCompat.p();
                    int unused3 = BaseTransientBottomBar.this.r = windowInsetsCompat.q();
                    BaseTransientBottomBar.this.t0();
                    return windowInsetsCompat;
                }
            });
            ViewCompat.H1(snackbarBaseLayout, new AccessibilityDelegateCompat() {
                public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.g(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.a(1048576);
                    accessibilityNodeInfoCompat.r1(true);
                }

                public boolean j(View view, int i2, Bundle bundle) {
                    if (i2 != 1048576) {
                        return super.j(view, i2, bundle);
                    }
                    BaseTransientBottomBar.this.A();
                    return true;
                }
            });
            this.y = (AccessibilityManager) context.getSystemService("accessibility");
            int i2 = R.attr.Fd;
            this.f21941c = MotionUtils.f(context, i2, 250);
            this.f21939a = MotionUtils.f(context, i2, I);
            this.f21940b = MotionUtils.f(context, R.attr.Id, 75);
            int i3 = R.attr.Vd;
            this.f21942d = MotionUtils.g(context, i3, K);
            this.f21944f = MotionUtils.g(context, i3, L);
            this.f21943e = MotionUtils.g(context, i3, H);
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    private ValueAnimator C(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f21942d);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseTransientBottomBar.this.f21947i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private ValueAnimator J(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f21944f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BaseTransientBottomBar.this.f21947i.setScaleX(floatValue);
                BaseTransientBottomBar.this.f21947i.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    private int L() {
        int height = this.f21947i.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f21947i.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* access modifiers changed from: private */
    public int N() {
        int[] iArr = new int[2];
        this.f21947i.getLocationInWindow(iArr);
        return iArr[1] + this.f21947i.getHeight();
    }

    private boolean U() {
        ViewGroup.LayoutParams layoutParams = this.f21947i.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    /* access modifiers changed from: private */
    public void a0() {
        this.s = x();
        t0();
    }

    private void j0(CoordinatorLayout.LayoutParams layoutParams) {
        SwipeDismissBehavior swipeDismissBehavior = this.x;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = I();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).d0(this);
        }
        swipeDismissBehavior.X(new SwipeDismissBehavior.OnDismissListener() {
            public void a(@NonNull View view) {
                if (view.getParent() != null) {
                    view.setVisibility(8);
                }
                BaseTransientBottomBar.this.B(0);
            }

            public void b(int i2) {
                if (i2 == 0) {
                    SnackbarManager.c().l(BaseTransientBottomBar.this.z);
                } else if (i2 == 1 || i2 == 2) {
                    SnackbarManager.c().k(BaseTransientBottomBar.this.z);
                }
            }
        });
        layoutParams.q(swipeDismissBehavior);
        if (D() == null) {
            layoutParams.f5083g = 80;
        }
    }

    private boolean l0() {
        return this.t > 0 && !this.f21950l && U();
    }

    private void o0() {
        if (k0()) {
            v();
            return;
        }
        if (this.f21947i.getParent() != null) {
            this.f21947i.setVisibility(0);
        }
        Z();
    }

    /* access modifiers changed from: private */
    public void p0() {
        ValueAnimator C2 = C(0.0f, 1.0f);
        ValueAnimator J2 = J(M, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{C2, J2});
        animatorSet.setDuration((long) this.f21939a);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.Z();
            }
        });
        animatorSet.start();
    }

    private void q0(final int i2) {
        ValueAnimator C2 = C(1.0f, 0.0f);
        C2.setDuration((long) this.f21940b);
        C2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.Y(i2);
            }
        });
        C2.start();
    }

    /* access modifiers changed from: private */
    public void r0() {
        int L2 = L();
        if (Q) {
            ViewCompat.j1(this.f21947i, L2);
        } else {
            this.f21947i.setTranslationY((float) L2);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{L2, 0});
        valueAnimator.setInterpolator(this.f21943e);
        valueAnimator.setDuration((long) this.f21941c);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.Z();
            }

            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f21948j.a(BaseTransientBottomBar.this.f21941c - BaseTransientBottomBar.this.f21939a, BaseTransientBottomBar.this.f21939a);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(L2) {
            final /* synthetic */ int X;
            private int s;

            {
                this.X = r2;
                this.s = r2;
            }

            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.Q) {
                    ViewCompat.j1(BaseTransientBottomBar.this.f21947i, intValue - this.s);
                } else {
                    BaseTransientBottomBar.this.f21947i.setTranslationY((float) intValue);
                }
                this.s = intValue;
            }
        });
        valueAnimator.start();
    }

    private void s0(final int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, L()});
        valueAnimator.setInterpolator(this.f21943e);
        valueAnimator.setDuration((long) this.f21941c);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.Y(i2);
            }

            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f21948j.b(0, BaseTransientBottomBar.this.f21940b);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private int s = 0;

            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.Q) {
                    ViewCompat.j1(BaseTransientBottomBar.this.f21947i, intValue - this.s);
                } else {
                    BaseTransientBottomBar.this.f21947i.setTranslationY((float) intValue);
                }
                this.s = intValue;
            }
        });
        valueAnimator.start();
    }

    /* access modifiers changed from: private */
    public void t0() {
        String str;
        String str2;
        ViewGroup.LayoutParams layoutParams = this.f21947i.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            str = S;
            str2 = "Unable to update margins because layout params are not MarginLayoutParams";
        } else if (this.f21947i.f3 == null) {
            str = S;
            str2 = "Unable to update margins because original view margins are not set";
        } else if (this.f21947i.getParent() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i2 = this.f21947i.f3.bottom + (D() != null ? this.s : this.p);
            int i3 = this.f21947i.f3.left + this.q;
            int i4 = this.f21947i.f3.right + this.r;
            int i5 = this.f21947i.f3.top;
            boolean z2 = (marginLayoutParams.bottomMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4 && marginLayoutParams.topMargin == i5) ? false : true;
            if (z2) {
                marginLayoutParams.bottomMargin = i2;
                marginLayoutParams.leftMargin = i3;
                marginLayoutParams.rightMargin = i4;
                marginLayoutParams.topMargin = i5;
                this.f21947i.requestLayout();
            }
            if ((z2 || this.u != this.t) && Build.VERSION.SDK_INT >= 29 && l0()) {
                this.f21947i.removeCallbacks(this.o);
                this.f21947i.post(this.o);
                return;
            }
            return;
        } else {
            return;
        }
        Log.w(str, str2);
    }

    private void w(int i2) {
        if (this.f21947i.getAnimationMode() == 1) {
            q0(i2);
        } else {
            s0(i2);
        }
    }

    private int x() {
        if (D() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        D().getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.f21945g.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f21945g.getHeight()) - i2;
    }

    /* access modifiers changed from: private */
    @NonNull
    public static GradientDrawable y(@ColorInt int i2, @NonNull Resources resources) {
        float dimension = resources.getDimension(R.dimen.zd);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i2);
        return gradientDrawable;
    }

    /* access modifiers changed from: private */
    @NonNull
    public static MaterialShapeDrawable z(@ColorInt int i2, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        materialShapeDrawable.p0(ColorStateList.valueOf(i2));
        return materialShapeDrawable;
    }

    public void A() {
        B(3);
    }

    /* access modifiers changed from: protected */
    public void B(int i2) {
        SnackbarManager.c().b(this.z, i2);
    }

    @Nullable
    public View D() {
        Anchor anchor = this.f21951m;
        if (anchor == null) {
            return null;
        }
        return anchor.b();
    }

    public int E() {
        return this.f21947i.getAnimationMode();
    }

    public Behavior F() {
        return this.x;
    }

    @NonNull
    public Context G() {
        return this.f21946h;
    }

    public int H() {
        return this.f21949k;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public SwipeDismissBehavior<? extends View> I() {
        return new Behavior();
    }

    /* access modifiers changed from: protected */
    @LayoutRes
    public int K() {
        return O() ? R.layout.E0 : R.layout.F;
    }

    @NonNull
    public View M() {
        return this.f21947i;
    }

    /* access modifiers changed from: protected */
    public boolean O() {
        TypedArray obtainStyledAttributes = this.f21946h.obtainStyledAttributes(R);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    /* access modifiers changed from: package-private */
    public final void P(int i2) {
        if (!k0() || this.f21947i.getVisibility() != 0) {
            Y(i2);
        } else {
            w(i2);
        }
    }

    public boolean Q() {
        return this.f21952n;
    }

    public boolean R() {
        return this.f21950l;
    }

    public boolean S() {
        return SnackbarManager.c().e(this.z);
    }

    public boolean T() {
        return SnackbarManager.c().f(this.z);
    }

    /* access modifiers changed from: package-private */
    public void V() {
        WindowInsets a2;
        if (Build.VERSION.SDK_INT >= 29 && (a2 = this.f21947i.getRootWindowInsets()) != null) {
            this.t = a2.getMandatorySystemGestureInsets().bottom;
            t0();
        }
    }

    /* access modifiers changed from: package-private */
    public void W() {
        if (T()) {
            N.post(new Runnable() {
                public void run() {
                    BaseTransientBottomBar.this.Y(3);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void X() {
        if (this.v) {
            o0();
            this.v = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(int i2) {
        SnackbarManager.c().i(this.z);
        List<BaseCallback<B>> list = this.w;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.w.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.f21947i.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f21947i);
        }
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        SnackbarManager.c().j(this.z);
        List<BaseCallback<B>> list = this.w;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.w.get(size).b(this);
            }
        }
    }

    @NonNull
    public B b0(@Nullable BaseCallback<B> baseCallback) {
        List<BaseCallback<B>> list;
        if (baseCallback == null || (list = this.w) == null) {
            return this;
        }
        list.remove(baseCallback);
        return this;
    }

    @NonNull
    public B c0(@IdRes int i2) {
        View findViewById = this.f21945g.findViewById(i2);
        if (findViewById != null) {
            return d0(findViewById);
        }
        throw new IllegalArgumentException("Unable to find anchor view with id: " + i2);
    }

    @NonNull
    public B d0(@Nullable View view) {
        Anchor anchor = this.f21951m;
        if (anchor != null) {
            anchor.c();
        }
        this.f21951m = view == null ? null : Anchor.a(this, view);
        return this;
    }

    public void e0(boolean z2) {
        this.f21952n = z2;
    }

    @NonNull
    public B f0(int i2) {
        this.f21947i.setAnimationMode(i2);
        return this;
    }

    @NonNull
    public B g0(Behavior behavior) {
        this.x = behavior;
        return this;
    }

    @NonNull
    public B h0(int i2) {
        this.f21949k = i2;
        return this;
    }

    @NonNull
    public B i0(boolean z2) {
        this.f21950l = z2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean k0() {
        AccessibilityManager accessibilityManager = this.y;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void m0() {
        SnackbarManager.c().n(H(), this.z);
    }

    /* access modifiers changed from: package-private */
    public final void n0() {
        if (this.f21947i.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f21947i.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                j0((CoordinatorLayout.LayoutParams) layoutParams);
            }
            this.f21947i.c(this.f21945g);
            a0();
            this.f21947i.setVisibility(4);
        }
        if (ViewCompat.Y0(this.f21947i)) {
            o0();
        } else {
            this.v = true;
        }
    }

    @NonNull
    public B u(@Nullable BaseCallback<B> baseCallback) {
        if (baseCallback == null) {
            return this;
        }
        if (this.w == null) {
            this.w = new ArrayList();
        }
        this.w.add(baseCallback);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        this.f21947i.post(new Runnable() {
            public void run() {
                SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.f21947i;
                if (snackbarBaseLayout != null) {
                    if (snackbarBaseLayout.getParent() != null) {
                        BaseTransientBottomBar.this.f21947i.setVisibility(0);
                    }
                    if (BaseTransientBottomBar.this.f21947i.getAnimationMode() == 1) {
                        BaseTransientBottomBar.this.p0();
                    } else {
                        BaseTransientBottomBar.this.r0();
                    }
                }
            }
        });
    }

    protected BaseTransientBottomBar(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        this(viewGroup.getContext(), viewGroup, view, contentViewCallback);
    }
}
