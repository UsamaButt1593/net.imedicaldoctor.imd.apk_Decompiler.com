package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

class FloatingActionButtonImpl {
    static final TimeInterpolator D = AnimationUtils.f20768c;
    static final long E = 100;
    static final long F = 100;
    static final int G = 0;
    static final int H = 1;
    static final int I = 2;
    static final float J = 1.5f;
    private static final float K = 0.0f;
    private static final float L = 0.4f;
    private static final float M = 0.4f;
    private static final float N = 1.0f;
    private static final float O = 1.0f;
    private static final float P = 1.0f;
    private static final float Q = 0.0f;
    private static final float R = 0.0f;
    private static final int S = R.attr.Fd;
    private static final int T = R.attr.Vd;
    private static final int U = R.attr.Id;
    private static final int V = R.attr.Td;
    static final int[] W = {16842919, 16842910};
    static final int[] X = {16843623, 16842908, 16842910};
    static final int[] Y = {16842908, 16842910};
    static final int[] Z = {16843623, 16842910};
    static final int[] a0 = {16842910};
    static final int[] b0 = new int[0];
    private final RectF A = new RectF();
    private final Matrix B = new Matrix();
    @Nullable
    private ViewTreeObserver.OnPreDrawListener C;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    ShapeAppearanceModel f21463a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    MaterialShapeDrawable f21464b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    Drawable f21465c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    BorderDrawable f21466d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    Drawable f21467e;

    /* renamed from: f  reason: collision with root package name */
    boolean f21468f;

    /* renamed from: g  reason: collision with root package name */
    boolean f21469g = true;

    /* renamed from: h  reason: collision with root package name */
    float f21470h;

    /* renamed from: i  reason: collision with root package name */
    float f21471i;

    /* renamed from: j  reason: collision with root package name */
    float f21472j;

    /* renamed from: k  reason: collision with root package name */
    int f21473k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final StateListAnimator f21474l;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public Animator f21475m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private MotionSpec f21476n;
    @Nullable
    private MotionSpec o;
    private float p;
    /* access modifiers changed from: private */
    public float q = 1.0f;
    private int r;
    /* access modifiers changed from: private */
    public int s = 0;
    private ArrayList<Animator.AnimatorListener> t;
    private ArrayList<Animator.AnimatorListener> u;
    private ArrayList<InternalTransformationCallback> v;
    final FloatingActionButton w;
    final ShadowViewDelegate x;
    private final Rect y = new Rect();
    private final RectF z = new RectF();

    private class DisabledElevationAnimation extends ShadowAnimatorImpl {
        DisabledElevationAnimation() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            return 0.0f;
        }
    }

    private class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToHoveredFocusedTranslationZAnimation() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.f21470h + floatingActionButtonImpl.f21471i;
        }
    }

    private class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToPressedTranslationZAnimation() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.f21470h + floatingActionButtonImpl.f21472j;
        }
    }

    interface InternalTransformationCallback {
        void a();

        void b();
    }

    interface InternalVisibilityChangedListener {
        void a();

        void b();
    }

    private class ResetElevationAnimation extends ShadowAnimatorImpl {
        ResetElevationAnimation() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            return FloatingActionButtonImpl.this.f21470h;
        }
    }

    private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private float X;
        private float Y;
        private boolean s;

        private ShadowAnimatorImpl() {
        }

        /* access modifiers changed from: protected */
        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.k0((float) ((int) this.Y));
            this.s = false;
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            if (!this.s) {
                MaterialShapeDrawable materialShapeDrawable = FloatingActionButtonImpl.this.f21464b;
                this.X = materialShapeDrawable == null ? 0.0f : materialShapeDrawable.y();
                this.Y = a();
                this.s = true;
            }
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            float f2 = this.X;
            floatingActionButtonImpl.k0((float) ((int) (f2 + ((this.Y - f2) * valueAnimator.getAnimatedFraction()))));
        }
    }

    FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.w = floatingActionButton;
        this.x = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.f21474l = stateListAnimator;
        stateListAnimator.a(W, k(new ElevateToPressedTranslationZAnimation()));
        stateListAnimator.a(X, k(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.a(Y, k(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.a(Z, k(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.a(a0, k(new ResetElevationAnimation()));
        stateListAnimator.a(b0, k(new DisabledElevationAnimation()));
        this.p = floatingActionButton.getRotation();
    }

    private boolean e0() {
        return ViewCompat.Y0(this.w) && !this.w.isInEditMode();
    }

    /* access modifiers changed from: private */
    public void h(float f2, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.w.getDrawable();
        if (drawable != null && this.r != 0) {
            RectF rectF = this.z;
            RectF rectF2 = this.A;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i2 = this.r;
            rectF2.set(0.0f, 0.0f, (float) i2, (float) i2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i3 = this.r;
            matrix.postScale(f2, f2, ((float) i3) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    @NonNull
    private AnimatorSet i(@NonNull MotionSpec motionSpec, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.w, View.ALPHA, new float[]{f2});
        motionSpec.h("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.w, View.SCALE_X, new float[]{f3});
        motionSpec.h("scale").a(ofFloat2);
        l0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.w, View.SCALE_Y, new float[]{f3});
        motionSpec.h("scale").a(ofFloat3);
        l0(ofFloat3);
        arrayList.add(ofFloat3);
        h(f4, this.B);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.w, new ImageMatrixProperty(), new MatrixEvaluator() {
            /* renamed from: a */
            public Matrix evaluate(float f2, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
                float unused = FloatingActionButtonImpl.this.q = f2;
                return super.evaluate(f2, matrix, matrix2);
            }
        }, new Matrix[]{new Matrix(this.B)});
        motionSpec.h("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(float f2, float f3, float f4, int i2, int i3) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        final float alpha = this.w.getAlpha();
        final float scaleX = this.w.getScaleX();
        final float scaleY = this.w.getScaleY();
        final float f5 = this.q;
        final Matrix matrix = new Matrix(this.B);
        final float f6 = f2;
        final float f7 = f3;
        final float f8 = f4;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatingActionButtonImpl.this.w.setAlpha(AnimationUtils.b(alpha, f6, 0.0f, 0.2f, floatValue));
                FloatingActionButtonImpl.this.w.setScaleX(AnimationUtils.a(scaleX, f7, floatValue));
                FloatingActionButtonImpl.this.w.setScaleY(AnimationUtils.a(scaleY, f7, floatValue));
                float unused = FloatingActionButtonImpl.this.q = AnimationUtils.a(f5, f8, floatValue);
                FloatingActionButtonImpl.this.h(AnimationUtils.a(f5, f8, floatValue), matrix);
                FloatingActionButtonImpl.this.w.setImageMatrix(matrix);
            }
        });
        arrayList.add(ofFloat);
        AnimatorSetCompat.a(animatorSet, arrayList);
        animatorSet.setDuration((long) MotionUtils.f(this.w.getContext(), i2, this.w.getContext().getResources().getInteger(R.integer.M)));
        animatorSet.setInterpolator(MotionUtils.g(this.w.getContext(), i3, AnimationUtils.f20767b));
        return animatorSet;
    }

    @NonNull
    private ValueAnimator k(@NonNull ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    private void l0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT == 26) {
            objectAnimator.setEvaluator(new TypeEvaluator<Float>() {

                /* renamed from: a  reason: collision with root package name */
                FloatEvaluator f21478a = new FloatEvaluator();

                /* renamed from: a */
                public Float evaluate(float f2, Float f3, Float f4) {
                    float floatValue = this.f21478a.evaluate(f2, f3, f4).floatValue();
                    if (floatValue < 0.1f) {
                        floatValue = 0.0f;
                    }
                    return Float.valueOf(floatValue);
                }
            });
        }
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener r() {
        if (this.C == null) {
            this.C = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.I();
                    return true;
                }
            };
        }
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.w.getVisibility() != 0 ? this.s == 2 : this.s != 1;
    }

    /* access modifiers changed from: package-private */
    public void B() {
        this.f21474l.c();
    }

    /* access modifiers changed from: package-private */
    public void C() {
        MaterialShapeDrawable materialShapeDrawable = this.f21464b;
        if (materialShapeDrawable != null) {
            MaterialShapeUtils.f(this.w, materialShapeDrawable);
        }
        if (O()) {
            this.w.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    /* access modifiers changed from: package-private */
    public void D() {
    }

    /* access modifiers changed from: package-private */
    public void E() {
        ViewTreeObserver viewTreeObserver = this.w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void F(int[] iArr) {
        this.f21474l.d(iArr);
    }

    /* access modifiers changed from: package-private */
    public void G(float f2, float f3, float f4) {
        B();
        j0();
        k0(f2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.graphics.drawable.Drawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.graphics.drawable.InsetDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.graphics.drawable.InsetDrawable} */
    /* JADX WARNING: type inference failed for: r0v3, types: [android.graphics.drawable.Drawable] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H(@androidx.annotation.NonNull android.graphics.Rect r8) {
        /*
            r7 = this;
            android.graphics.drawable.Drawable r0 = r7.f21467e
            java.lang.String r1 = "Didn't initialize content background"
            androidx.core.util.Preconditions.m(r0, r1)
            boolean r0 = r7.d0()
            if (r0 == 0) goto L_0x0023
            android.graphics.drawable.InsetDrawable r0 = new android.graphics.drawable.InsetDrawable
            android.graphics.drawable.Drawable r2 = r7.f21467e
            int r3 = r8.left
            int r4 = r8.top
            int r5 = r8.right
            int r6 = r8.bottom
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            com.google.android.material.shadow.ShadowViewDelegate r8 = r7.x
        L_0x001f:
            r8.c(r0)
            goto L_0x0028
        L_0x0023:
            com.google.android.material.shadow.ShadowViewDelegate r8 = r7.x
            android.graphics.drawable.Drawable r0 = r7.f21467e
            goto L_0x001f
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.H(android.graphics.Rect):void");
    }

    /* access modifiers changed from: package-private */
    public void I() {
        float rotation = this.w.getRotation();
        if (this.p != rotation) {
            this.p = rotation;
            h0();
        }
    }

    /* access modifiers changed from: package-private */
    public void J() {
        ArrayList<InternalTransformationCallback> arrayList = this.v;
        if (arrayList != null) {
            Iterator<InternalTransformationCallback> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void K() {
        ArrayList<InternalTransformationCallback> arrayList = this.v;
        if (arrayList != null) {
            Iterator<InternalTransformationCallback> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().a();
            }
        }
    }

    public void L(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.u;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void M(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.t;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void N(@NonNull InternalTransformationCallback internalTransformationCallback) {
        ArrayList<InternalTransformationCallback> arrayList = this.v;
        if (arrayList != null) {
            arrayList.remove(internalTransformationCallback);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean O() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void P(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f21464b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintList(colorStateList);
        }
        BorderDrawable borderDrawable = this.f21466d;
        if (borderDrawable != null) {
            borderDrawable.d(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(@Nullable PorterDuff.Mode mode) {
        MaterialShapeDrawable materialShapeDrawable = this.f21464b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintMode(mode);
        }
    }

    /* access modifiers changed from: package-private */
    public final void R(float f2) {
        if (this.f21470h != f2) {
            this.f21470h = f2;
            G(f2, this.f21471i, this.f21472j);
        }
    }

    /* access modifiers changed from: package-private */
    public void S(boolean z2) {
        this.f21468f = z2;
    }

    /* access modifiers changed from: package-private */
    public final void T(@Nullable MotionSpec motionSpec) {
        this.o = motionSpec;
    }

    /* access modifiers changed from: package-private */
    public final void U(float f2) {
        if (this.f21471i != f2) {
            this.f21471i = f2;
            G(this.f21470h, f2, this.f21472j);
        }
    }

    /* access modifiers changed from: package-private */
    public final void V(float f2) {
        this.q = f2;
        Matrix matrix = this.B;
        h(f2, matrix);
        this.w.setImageMatrix(matrix);
    }

    /* access modifiers changed from: package-private */
    public final void W(int i2) {
        if (this.r != i2) {
            this.r = i2;
            i0();
        }
    }

    /* access modifiers changed from: package-private */
    public void X(int i2) {
        this.f21473k = i2;
    }

    /* access modifiers changed from: package-private */
    public final void Y(float f2) {
        if (this.f21472j != f2) {
            this.f21472j = f2;
            G(this.f21470h, this.f21471i, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void Z(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f21465c;
        if (drawable != null) {
            DrawableCompat.o(drawable, RippleUtils.e(colorStateList));
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(boolean z2) {
        this.f21469g = z2;
        j0();
    }

    /* access modifiers changed from: package-private */
    public final void b0(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f21463a = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.f21464b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Drawable drawable = this.f21465c;
        if (drawable instanceof Shapeable) {
            ((Shapeable) drawable).setShapeAppearanceModel(shapeAppearanceModel);
        }
        BorderDrawable borderDrawable = this.f21466d;
        if (borderDrawable != null) {
            borderDrawable.g(shapeAppearanceModel);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c0(@Nullable MotionSpec motionSpec) {
        this.f21476n = motionSpec;
    }

    /* access modifiers changed from: package-private */
    public boolean d0() {
        return true;
    }

    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.u == null) {
            this.u = new ArrayList<>();
        }
        this.u.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void f(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.t == null) {
            this.t = new ArrayList<>();
        }
        this.t.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public final boolean f0() {
        return !this.f21468f || this.w.getSizeDimension() >= this.f21473k;
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull InternalTransformationCallback internalTransformationCallback) {
        if (this.v == null) {
            this.v = new ArrayList<>();
        }
        this.v.add(internalTransformationCallback);
    }

    /* access modifiers changed from: package-private */
    public void g0(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z2) {
        if (!A()) {
            Animator animator = this.f21475m;
            if (animator != null) {
                animator.cancel();
            }
            boolean z3 = this.f21476n == null;
            if (e0()) {
                if (this.w.getVisibility() != 0) {
                    float f2 = 0.0f;
                    this.w.setAlpha(0.0f);
                    this.w.setScaleY(z3 ? 0.4f : 0.0f);
                    this.w.setScaleX(z3 ? 0.4f : 0.0f);
                    if (z3) {
                        f2 = 0.4f;
                    }
                    V(f2);
                }
                MotionSpec motionSpec = this.f21476n;
                AnimatorSet i2 = motionSpec != null ? i(motionSpec, 1.0f, 1.0f, 1.0f) : j(1.0f, 1.0f, 1.0f, S, T);
                i2.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        int unused = FloatingActionButtonImpl.this.s = 0;
                        Animator unused2 = FloatingActionButtonImpl.this.f21475m = null;
                        InternalVisibilityChangedListener internalVisibilityChangedListener = internalVisibilityChangedListener;
                        if (internalVisibilityChangedListener != null) {
                            internalVisibilityChangedListener.a();
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.w.c(0, z2);
                        int unused = FloatingActionButtonImpl.this.s = 2;
                        Animator unused2 = FloatingActionButtonImpl.this.f21475m = animator;
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = this.t;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        i2.addListener(it2.next());
                    }
                }
                i2.start();
                return;
            }
            this.w.c(0, z2);
            this.w.setAlpha(1.0f);
            this.w.setScaleY(1.0f);
            this.w.setScaleX(1.0f);
            V(1.0f);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h0() {
        MaterialShapeDrawable materialShapeDrawable = this.f21464b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.x0((int) this.p);
        }
    }

    /* access modifiers changed from: package-private */
    public final void i0() {
        V(this.q);
    }

    /* access modifiers changed from: package-private */
    public final void j0() {
        Rect rect = this.y;
        s(rect);
        H(rect);
        this.x.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public void k0(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.f21464b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.o0(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public MaterialShapeDrawable l() {
        return new MaterialShapeDrawable((ShapeAppearanceModel) Preconditions.l(this.f21463a));
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final Drawable m() {
        return this.f21467e;
    }

    /* access modifiers changed from: package-private */
    public float n() {
        return this.f21470h;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f21468f;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final MotionSpec p() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public float q() {
        return this.f21471i;
    }

    /* access modifiers changed from: package-private */
    public void s(@NonNull Rect rect) {
        int w2 = w();
        float n2 = this.f21469g ? n() + this.f21472j : 0.0f;
        int max = Math.max(w2, (int) Math.ceil((double) n2));
        int max2 = Math.max(w2, (int) Math.ceil((double) (n2 * J)));
        rect.set(max, max2, max, max2);
    }

    /* access modifiers changed from: package-private */
    public float t() {
        return this.f21472j;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final ShapeAppearanceModel u() {
        return this.f21463a;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final MotionSpec v() {
        return this.f21476n;
    }

    /* access modifiers changed from: package-private */
    public int w() {
        if (this.f21468f) {
            return Math.max((this.f21473k - this.w.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void x(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z2) {
        if (!z()) {
            Animator animator = this.f21475m;
            if (animator != null) {
                animator.cancel();
            }
            if (e0()) {
                MotionSpec motionSpec = this.o;
                AnimatorSet i2 = motionSpec != null ? i(motionSpec, 0.0f, 0.0f, 0.0f) : j(0.0f, 0.4f, 0.4f, U, V);
                i2.addListener(new AnimatorListenerAdapter() {
                    private boolean s;

                    public void onAnimationCancel(Animator animator) {
                        this.s = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        int unused = FloatingActionButtonImpl.this.s = 0;
                        Animator unused2 = FloatingActionButtonImpl.this.f21475m = null;
                        if (!this.s) {
                            FloatingActionButton floatingActionButton = FloatingActionButtonImpl.this.w;
                            boolean z = z2;
                            floatingActionButton.c(z ? 8 : 4, z);
                            InternalVisibilityChangedListener internalVisibilityChangedListener = internalVisibilityChangedListener;
                            if (internalVisibilityChangedListener != null) {
                                internalVisibilityChangedListener.b();
                            }
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.w.c(0, z2);
                        int unused = FloatingActionButtonImpl.this.s = 1;
                        Animator unused2 = FloatingActionButtonImpl.this.f21475m = animator;
                        this.s = false;
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = this.u;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        i2.addListener(it2.next());
                    }
                }
                i2.start();
                return;
            }
            this.w.c(z2 ? 8 : 4, z2);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void y(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        MaterialShapeDrawable l2 = l();
        this.f21464b = l2;
        l2.setTintList(colorStateList);
        if (mode != null) {
            this.f21464b.setTintMode(mode);
        }
        this.f21464b.w0(-12303292);
        this.f21464b.a0(this.w.getContext());
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.f21464b.getShapeAppearanceModel());
        rippleDrawableCompat.setTintList(RippleUtils.e(colorStateList2));
        this.f21465c = rippleDrawableCompat;
        this.f21467e = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.l(this.f21464b), rippleDrawableCompat});
    }

    /* access modifiers changed from: package-private */
    public boolean z() {
        return this.w.getVisibility() == 0 ? this.s == 1 : this.s != 2;
    }
}
