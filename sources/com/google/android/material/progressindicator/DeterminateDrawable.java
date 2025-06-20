package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.math.MathUtils;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DrawingDelegate;

public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private static final int p3 = 10000;
    private static final float q3 = 50.0f;
    static final float r3 = 0.01f;
    private static final FloatPropertyCompat<DeterminateDrawable<?>> s3 = new FloatPropertyCompat<DeterminateDrawable<?>>("indicatorLevel") {
        /* renamed from: d */
        public float b(DeterminateDrawable<?> determinateDrawable) {
            return determinateDrawable.G() * 10000.0f;
        }

        /* renamed from: e */
        public void c(DeterminateDrawable<?> determinateDrawable, float f2) {
            determinateDrawable.J(f2 / 10000.0f);
        }
    };
    private DrawingDelegate<S> k3;
    private final SpringForce l3;
    private final SpringAnimation m3;
    private final DrawingDelegate.ActiveIndicator n3;
    private boolean o3 = false;

    DeterminateDrawable(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec, @NonNull DrawingDelegate<S> drawingDelegate) {
        super(context, baseProgressIndicatorSpec);
        I(drawingDelegate);
        this.n3 = new DrawingDelegate.ActiveIndicator();
        SpringForce springForce = new SpringForce();
        this.l3 = springForce;
        springForce.g(1.0f);
        springForce.i(50.0f);
        SpringAnimation springAnimation = new SpringAnimation(this, s3);
        this.m3 = springAnimation;
        springAnimation.D(springForce);
        q(1.0f);
    }

    @NonNull
    public static DeterminateDrawable<CircularProgressIndicatorSpec> B(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return C(context, circularProgressIndicatorSpec, new CircularDrawingDelegate(circularProgressIndicatorSpec));
    }

    @NonNull
    static DeterminateDrawable<CircularProgressIndicatorSpec> C(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec, @NonNull CircularDrawingDelegate circularDrawingDelegate) {
        return new DeterminateDrawable<>(context, circularProgressIndicatorSpec, circularDrawingDelegate);
    }

    @NonNull
    public static DeterminateDrawable<LinearProgressIndicatorSpec> D(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return E(context, linearProgressIndicatorSpec, new LinearDrawingDelegate(linearProgressIndicatorSpec));
    }

    @NonNull
    static DeterminateDrawable<LinearProgressIndicatorSpec> E(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec, @NonNull LinearDrawingDelegate linearDrawingDelegate) {
        return new DeterminateDrawable<>(context, linearProgressIndicatorSpec, linearDrawingDelegate);
    }

    /* access modifiers changed from: private */
    public float G() {
        return this.n3.f21666b;
    }

    /* access modifiers changed from: private */
    public void J(float f2) {
        this.n3.f21666b = f2;
        invalidateSelf();
    }

    public void A(@NonNull DynamicAnimation.OnAnimationEndListener onAnimationEndListener) {
        this.m3.b(onAnimationEndListener);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public DrawingDelegate<S> F() {
        return this.k3;
    }

    public void H(@NonNull DynamicAnimation.OnAnimationEndListener onAnimationEndListener) {
        this.m3.l(onAnimationEndListener);
    }

    /* access modifiers changed from: package-private */
    public void I(@NonNull DrawingDelegate<S> drawingDelegate) {
        this.k3 = drawingDelegate;
    }

    /* access modifiers changed from: package-private */
    public void K(float f2) {
        setLevel((int) (f2 * 10000.0f));
    }

    public /* bridge */ /* synthetic */ void b(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        super.b(animationCallback);
    }

    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public /* bridge */ /* synthetic */ boolean d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return super.d(animationCallback);
    }

    public void draw(@NonNull Canvas canvas) {
        DrawingDelegate<S> drawingDelegate;
        Paint paint;
        int i2;
        int alpha;
        int i3;
        float f2;
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.k3.g(canvas, getBounds(), k(), o(), n());
            this.f3.setStyle(Paint.Style.FILL);
            this.f3.setAntiAlias(true);
            DrawingDelegate.ActiveIndicator activeIndicator = this.n3;
            BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.X;
            activeIndicator.f21667c = baseProgressIndicatorSpec.f21638c[0];
            int i4 = baseProgressIndicatorSpec.f21642g;
            if (i4 > 0) {
                if (!(this.k3 instanceof LinearDrawingDelegate)) {
                    i4 = (int) ((((float) i4) * MathUtils.d(G(), 0.0f, r3)) / r3);
                }
                i3 = i4;
                drawingDelegate = this.k3;
                paint = this.f3;
                f2 = G();
                i2 = this.X.f21639d;
                alpha = getAlpha();
            } else {
                drawingDelegate = this.k3;
                paint = this.f3;
                i2 = baseProgressIndicatorSpec.f21639d;
                alpha = getAlpha();
                i3 = 0;
                f2 = 0.0f;
            }
            drawingDelegate.d(canvas, paint, f2, 1.0f, i2, alpha, i3);
            this.k3.c(canvas, this.f3, this.n3, getAlpha());
            this.k3.b(canvas, this.f3, this.X.f21638c[0], getAlpha());
            canvas.restore();
        }
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public int getIntrinsicHeight() {
        return this.k3.e();
    }

    public int getIntrinsicWidth() {
        return this.k3.f();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    public void jumpToCurrentState() {
        this.m3.E();
        J(((float) getLevel()) / 10000.0f);
    }

    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    public /* bridge */ /* synthetic */ boolean n() {
        return super.n();
    }

    public /* bridge */ /* synthetic */ boolean o() {
        return super.o();
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        if (this.o3) {
            this.m3.E();
            J(((float) i2) / 10000.0f);
            return true;
        }
        this.m3.t(G() * 10000.0f);
        this.m3.z((float) i2);
        return true;
    }

    public /* bridge */ /* synthetic */ void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        super.setAlpha(i2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public /* bridge */ /* synthetic */ boolean w(boolean z, boolean z2, boolean z3) {
        return super.w(z, z2, z3);
    }

    /* access modifiers changed from: package-private */
    public boolean x(boolean z, boolean z2, boolean z3) {
        boolean x = super.x(z, z2, z3);
        float a2 = this.Y.a(this.s.getContentResolver());
        if (a2 == 0.0f) {
            this.o3 = true;
        } else {
            this.o3 = false;
            this.l3.i(50.0f / a2);
        }
        return x;
    }
}
