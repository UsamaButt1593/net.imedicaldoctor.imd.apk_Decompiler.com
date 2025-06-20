package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

public final class DrawableTransitionOptions extends TransitionOptions<DrawableTransitionOptions, Drawable> {
    @NonNull
    public static DrawableTransitionOptions n(@NonNull TransitionFactory<Drawable> transitionFactory) {
        return (DrawableTransitionOptions) new DrawableTransitionOptions().f(transitionFactory);
    }

    @NonNull
    public static DrawableTransitionOptions o() {
        return new DrawableTransitionOptions().h();
    }

    @NonNull
    public static DrawableTransitionOptions p(int i2) {
        return new DrawableTransitionOptions().i(i2);
    }

    @NonNull
    public static DrawableTransitionOptions q(@NonNull DrawableCrossFadeFactory.Builder builder) {
        return new DrawableTransitionOptions().l(builder);
    }

    @NonNull
    public static DrawableTransitionOptions r(@NonNull DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new DrawableTransitionOptions().m(drawableCrossFadeFactory);
    }

    @NonNull
    public DrawableTransitionOptions h() {
        return l(new DrawableCrossFadeFactory.Builder());
    }

    @NonNull
    public DrawableTransitionOptions i(int i2) {
        return l(new DrawableCrossFadeFactory.Builder(i2));
    }

    @NonNull
    public DrawableTransitionOptions l(@NonNull DrawableCrossFadeFactory.Builder builder) {
        return m(builder.a());
    }

    @NonNull
    public DrawableTransitionOptions m(@NonNull DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return (DrawableTransitionOptions) f(drawableCrossFadeFactory);
    }
}
