package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.ArrayList;
import java.util.List;

abstract class IndeterminateAnimatorDelegate<T extends Animator> {

    /* renamed from: a  reason: collision with root package name */
    protected IndeterminateDrawable f21669a;

    /* renamed from: b  reason: collision with root package name */
    protected final List<DrawingDelegate.ActiveIndicator> f21670b = new ArrayList();

    protected IndeterminateAnimatorDelegate(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            this.f21670b.add(new DrawingDelegate.ActiveIndicator());
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: protected */
    public float b(int i2, int i3, int i4) {
        return ((float) (i2 - i3)) / ((float) i4);
    }

    public abstract void c();

    public abstract void d(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    /* access modifiers changed from: protected */
    public void e(@NonNull IndeterminateDrawable indeterminateDrawable) {
        this.f21669a = indeterminateDrawable;
    }

    /* access modifiers changed from: package-private */
    public abstract void f();

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public abstract void g();

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public abstract void h(float f2);

    /* access modifiers changed from: package-private */
    public abstract void i();

    public abstract void j();
}
