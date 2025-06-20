package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.Transition;

public class DrawableCrossFadeTransition implements Transition<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f18502a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18503b;

    public DrawableCrossFadeTransition(int i2, boolean z) {
        this.f18502a = i2;
        this.f18503b = z;
    }

    /* renamed from: b */
    public boolean a(Drawable drawable, Transition.ViewAdapter viewAdapter) {
        Drawable h2 = viewAdapter.h();
        if (h2 == null) {
            h2 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{h2, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f18503b);
        transitionDrawable.startTransition(this.f18502a);
        viewAdapter.f(transitionDrawable);
        return true;
    }
}
