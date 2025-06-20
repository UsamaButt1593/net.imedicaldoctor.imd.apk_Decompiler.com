package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {

    /* renamed from: a  reason: collision with root package name */
    private final TransitionFactory<Drawable> f18493a;

    private final class BitmapGlideAnimation implements Transition<R> {

        /* renamed from: a  reason: collision with root package name */
        private final Transition<Drawable> f18494a;

        BitmapGlideAnimation(Transition<Drawable> transition) {
            this.f18494a = transition;
        }

        public boolean a(R r, Transition.ViewAdapter viewAdapter) {
            return this.f18494a.a(new BitmapDrawable(viewAdapter.g().getResources(), BitmapContainerTransitionFactory.this.b(r)), viewAdapter);
        }
    }

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        this.f18493a = transitionFactory;
    }

    public Transition<R> a(DataSource dataSource, boolean z) {
        return new BitmapGlideAnimation(this.f18493a.a(dataSource, z));
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap b(R r);
}
