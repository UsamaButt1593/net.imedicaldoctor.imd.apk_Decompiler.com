package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.BitmapTransitionFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

public final class BitmapTransitionOptions extends TransitionOptions<BitmapTransitionOptions, Bitmap> {
    @NonNull
    public static BitmapTransitionOptions o(@NonNull TransitionFactory<Bitmap> transitionFactory) {
        return (BitmapTransitionOptions) new BitmapTransitionOptions().f(transitionFactory);
    }

    @NonNull
    public static BitmapTransitionOptions p() {
        return new BitmapTransitionOptions().h();
    }

    @NonNull
    public static BitmapTransitionOptions q(int i2) {
        return new BitmapTransitionOptions().i(i2);
    }

    @NonNull
    public static BitmapTransitionOptions r(@NonNull DrawableCrossFadeFactory.Builder builder) {
        return new BitmapTransitionOptions().l(builder);
    }

    @NonNull
    public static BitmapTransitionOptions s(@NonNull DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new BitmapTransitionOptions().m(drawableCrossFadeFactory);
    }

    @NonNull
    public static BitmapTransitionOptions t(@NonNull TransitionFactory<Drawable> transitionFactory) {
        return new BitmapTransitionOptions().n(transitionFactory);
    }

    @NonNull
    public BitmapTransitionOptions h() {
        return l(new DrawableCrossFadeFactory.Builder());
    }

    @NonNull
    public BitmapTransitionOptions i(int i2) {
        return l(new DrawableCrossFadeFactory.Builder(i2));
    }

    @NonNull
    public BitmapTransitionOptions l(@NonNull DrawableCrossFadeFactory.Builder builder) {
        return n(builder.a());
    }

    @NonNull
    public BitmapTransitionOptions m(@NonNull DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return n(drawableCrossFadeFactory);
    }

    @NonNull
    public BitmapTransitionOptions n(@NonNull TransitionFactory<Drawable> transitionFactory) {
        return (BitmapTransitionOptions) f(new BitmapTransitionFactory(transitionFactory));
    }
}
