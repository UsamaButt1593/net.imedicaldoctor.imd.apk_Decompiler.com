package com.bumptech.glide.module;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.GlideBuilder;

public abstract class AppGlideModule extends LibraryGlideModule implements AppliesOptions {
    public void a(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
    }

    public boolean c() {
        return true;
    }
}
