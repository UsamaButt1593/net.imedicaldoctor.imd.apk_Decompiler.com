package com.bumptech.glide.module;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;

@Deprecated
public interface GlideModule extends RegistersComponents, AppliesOptions {
    /* synthetic */ void a(@NonNull Context context, @NonNull GlideBuilder glideBuilder);

    /* synthetic */ void b(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry);
}
