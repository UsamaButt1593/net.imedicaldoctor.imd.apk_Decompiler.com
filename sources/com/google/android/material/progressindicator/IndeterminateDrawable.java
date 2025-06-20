package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.google.android.material.R;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.List;

public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private DrawingDelegate<S> k3;
    private IndeterminateAnimatorDelegate<ObjectAnimator> l3;
    private Drawable m3;

    IndeterminateDrawable(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec, @NonNull DrawingDelegate<S> drawingDelegate, @NonNull IndeterminateAnimatorDelegate<ObjectAnimator> indeterminateAnimatorDelegate) {
        super(context, baseProgressIndicatorSpec);
        H(drawingDelegate);
        G(indeterminateAnimatorDelegate);
    }

    @NonNull
    public static IndeterminateDrawable<LinearProgressIndicatorSpec> A(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return B(context, linearProgressIndicatorSpec, new LinearDrawingDelegate(linearProgressIndicatorSpec));
    }

    @NonNull
    static IndeterminateDrawable<LinearProgressIndicatorSpec> B(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec, @NonNull LinearDrawingDelegate linearDrawingDelegate) {
        return new IndeterminateDrawable<>(context, linearProgressIndicatorSpec, linearDrawingDelegate, linearProgressIndicatorSpec.f21697h == 0 ? new LinearIndeterminateContiguousAnimatorDelegate(linearProgressIndicatorSpec) : new LinearIndeterminateDisjointAnimatorDelegate(context, linearProgressIndicatorSpec));
    }

    private boolean F() {
        AnimatorDurationScaleProvider animatorDurationScaleProvider = this.Y;
        return animatorDurationScaleProvider != null && animatorDurationScaleProvider.a(this.s.getContentResolver()) == 0.0f;
    }

    @NonNull
    public static IndeterminateDrawable<CircularProgressIndicatorSpec> y(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return z(context, circularProgressIndicatorSpec, new CircularDrawingDelegate(circularProgressIndicatorSpec));
    }

    @NonNull
    static IndeterminateDrawable<CircularProgressIndicatorSpec> z(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec, @NonNull CircularDrawingDelegate circularDrawingDelegate) {
        IndeterminateDrawable<CircularProgressIndicatorSpec> indeterminateDrawable = new IndeterminateDrawable<>(context, circularProgressIndicatorSpec, circularDrawingDelegate, new CircularIndeterminateAnimatorDelegate(circularProgressIndicatorSpec));
        indeterminateDrawable.I(VectorDrawableCompat.e(context.getResources(), R.drawable.i1, (Resources.Theme) null));
        return indeterminateDrawable;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public IndeterminateAnimatorDelegate<ObjectAnimator> C() {
        return this.l3;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public DrawingDelegate<S> D() {
        return this.k3;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Drawable E() {
        return this.m3;
    }

    /* access modifiers changed from: package-private */
    public void G(@NonNull IndeterminateAnimatorDelegate<ObjectAnimator> indeterminateAnimatorDelegate) {
        this.l3 = indeterminateAnimatorDelegate;
        indeterminateAnimatorDelegate.e(this);
    }

    /* access modifiers changed from: package-private */
    public void H(@NonNull DrawingDelegate<S> drawingDelegate) {
        this.k3 = drawingDelegate;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void I(@Nullable Drawable drawable) {
        this.m3 = drawable;
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
        Paint paint;
        float f2;
        float f3;
        int i2;
        DrawingDelegate<S> drawingDelegate;
        Canvas canvas2;
        int i3;
        int i4;
        Drawable drawable;
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            if (!F() || (drawable = this.m3) == null) {
                canvas.save();
                this.k3.g(canvas, getBounds(), k(), o(), n());
                int i5 = this.X.f21642g;
                int alpha = getAlpha();
                if (i5 == 0) {
                    drawingDelegate = this.k3;
                    paint = this.f3;
                    i2 = this.X.f21639d;
                    i4 = 0;
                    f2 = 0.0f;
                    f3 = 1.0f;
                    canvas2 = canvas;
                    i3 = alpha;
                } else {
                    DrawingDelegate.ActiveIndicator activeIndicator = this.l3.f21670b.get(0);
                    List<DrawingDelegate.ActiveIndicator> list = this.l3.f21670b;
                    DrawingDelegate.ActiveIndicator activeIndicator2 = list.get(list.size() - 1);
                    DrawingDelegate<S> drawingDelegate2 = this.k3;
                    if (drawingDelegate2 instanceof LinearDrawingDelegate) {
                        i3 = alpha;
                        i4 = i5;
                        drawingDelegate2.d(canvas, this.f3, 0.0f, activeIndicator.f21665a, this.X.f21639d, i3, i4);
                        drawingDelegate = this.k3;
                        paint = this.f3;
                        f2 = activeIndicator2.f21666b;
                        i2 = this.X.f21639d;
                        f3 = 1.0f;
                        canvas2 = canvas;
                    } else {
                        paint = this.f3;
                        f2 = activeIndicator2.f21666b;
                        f3 = 1.0f + activeIndicator.f21665a;
                        i2 = this.X.f21639d;
                        alpha = 0;
                        drawingDelegate = drawingDelegate2;
                        canvas2 = canvas;
                        i3 = 0;
                        i4 = i5;
                    }
                }
                drawingDelegate.d(canvas2, paint, f2, f3, i2, i3, i4);
                for (int i6 = 0; i6 < this.l3.f21670b.size(); i6++) {
                    DrawingDelegate.ActiveIndicator activeIndicator3 = this.l3.f21670b.get(i6);
                    this.k3.c(canvas, this.f3, activeIndicator3, getAlpha());
                    if (i6 > 0 && i5 > 0) {
                        this.k3.d(canvas, this.f3, this.l3.f21670b.get(i6 - 1).f21666b, activeIndicator3.f21665a, this.X.f21639d, alpha, i5);
                    }
                }
                canvas.restore();
                return;
            }
            drawable.setBounds(getBounds());
            DrawableCompat.n(this.m3, this.X.f21638c[0]);
            this.m3.draw(canvas);
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

    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    public /* bridge */ /* synthetic */ boolean n() {
        return super.n();
    }

    public /* bridge */ /* synthetic */ boolean o() {
        return super.o();
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
        Drawable drawable;
        boolean x = super.x(z, z2, z3);
        if (F() && (drawable = this.m3) != null) {
            return drawable.setVisible(z, z2);
        }
        if (!isRunning()) {
            this.l3.a();
        }
        if (z && (z3 || (Build.VERSION.SDK_INT <= 22 && !F()))) {
            this.l3.i();
        }
        return x;
    }
}
