package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

public interface RequestListener<R> {
    boolean f(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z);

    boolean g(R r, Object obj, Target<R> target, DataSource dataSource, boolean z);
}
