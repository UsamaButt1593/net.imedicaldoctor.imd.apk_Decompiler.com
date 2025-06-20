package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

abstract class BaseMotionStrategy implements MotionStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21423a;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ExtendedFloatingActionButton f21424b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Animator.AnimatorListener> f21425c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final AnimatorTracker f21426d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private MotionSpec f21427e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private MotionSpec f21428f;

    BaseMotionStrategy(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
        this.f21424b = extendedFloatingActionButton;
        this.f21423a = extendedFloatingActionButton.getContext();
        this.f21426d = animatorTracker;
    }

    @CallSuper
    public void a() {
        this.f21426d.b();
    }

    @CallSuper
    public void b() {
        this.f21426d.b();
    }

    public AnimatorSet c() {
        return o(d());
    }

    public final MotionSpec d() {
        MotionSpec motionSpec = this.f21428f;
        if (motionSpec != null) {
            return motionSpec;
        }
        if (this.f21427e == null) {
            this.f21427e = MotionSpec.d(this.f21423a, e());
        }
        return (MotionSpec) Preconditions.l(this.f21427e);
    }

    @Nullable
    public MotionSpec g() {
        return this.f21428f;
    }

    public final void i(@NonNull Animator.AnimatorListener animatorListener) {
        this.f21425c.remove(animatorListener);
    }

    public final void j(@NonNull Animator.AnimatorListener animatorListener) {
        this.f21425c.add(animatorListener);
    }

    public final void k(@Nullable MotionSpec motionSpec) {
        this.f21428f = motionSpec;
    }

    @NonNull
    public final List<Animator.AnimatorListener> l() {
        return this.f21425c;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public AnimatorSet o(@NonNull MotionSpec motionSpec) {
        ArrayList arrayList = new ArrayList();
        if (motionSpec.j("opacity")) {
            arrayList.add(motionSpec.f("opacity", this.f21424b, View.ALPHA));
        }
        if (motionSpec.j("scale")) {
            arrayList.add(motionSpec.f("scale", this.f21424b, View.SCALE_Y));
            arrayList.add(motionSpec.f("scale", this.f21424b, View.SCALE_X));
        }
        if (motionSpec.j("width")) {
            arrayList.add(motionSpec.f("width", this.f21424b, ExtendedFloatingActionButton.Z3));
        }
        if (motionSpec.j("height")) {
            arrayList.add(motionSpec.f("height", this.f21424b, ExtendedFloatingActionButton.a4));
        }
        if (motionSpec.j("paddingStart")) {
            arrayList.add(motionSpec.f("paddingStart", this.f21424b, ExtendedFloatingActionButton.b4));
        }
        if (motionSpec.j("paddingEnd")) {
            arrayList.add(motionSpec.f("paddingEnd", this.f21424b, ExtendedFloatingActionButton.c4));
        }
        if (motionSpec.j("labelOpacity")) {
            arrayList.add(motionSpec.f("labelOpacity", this.f21424b, new Property<ExtendedFloatingActionButton, Float>(Float.class, "LABEL_OPACITY_PROPERTY") {
                /* renamed from: a */
                public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
                    return Float.valueOf(AnimationUtils.a(0.0f, 1.0f, (((float) Color.alpha(extendedFloatingActionButton.getCurrentTextColor())) / 255.0f) / ((float) Color.alpha(extendedFloatingActionButton.K3.getColorForState(extendedFloatingActionButton.getDrawableState(), BaseMotionStrategy.this.f21424b.K3.getDefaultColor())))));
                }

                /* renamed from: b */
                public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f2) {
                    int colorForState = extendedFloatingActionButton.K3.getColorForState(extendedFloatingActionButton.getDrawableState(), BaseMotionStrategy.this.f21424b.K3.getDefaultColor());
                    ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (AnimationUtils.a(0.0f, ((float) Color.alpha(colorForState)) / 255.0f, f2.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
                    if (f2.floatValue() == 1.0f) {
                        extendedFloatingActionButton.Y(extendedFloatingActionButton.K3);
                    } else {
                        extendedFloatingActionButton.Y(valueOf);
                    }
                }
            }));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    @CallSuper
    public void onAnimationStart(Animator animator) {
        this.f21426d.c(animator);
    }
}
