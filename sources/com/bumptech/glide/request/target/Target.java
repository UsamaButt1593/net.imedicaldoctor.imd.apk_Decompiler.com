package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

public interface Target<R> extends LifecycleListener {
    public static final int c0 = Integer.MIN_VALUE;

    void c(@NonNull SizeReadyCallback sizeReadyCallback);

    void e(@NonNull R r, @Nullable Transition<? super R> transition);

    void j(@Nullable Request request);

    void k(@Nullable Drawable drawable);

    void p(@Nullable Drawable drawable);

    @Nullable
    Request q();

    void r(@Nullable Drawable drawable);

    void s(@NonNull SizeReadyCallback sizeReadyCallback);
}
