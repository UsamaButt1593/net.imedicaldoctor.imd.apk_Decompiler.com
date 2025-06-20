package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;

public interface Transition<R> {

    public interface ViewAdapter {
        void f(Drawable drawable);

        View g();

        @Nullable
        Drawable h();
    }

    boolean a(R r, ViewAdapter viewAdapter);
}
