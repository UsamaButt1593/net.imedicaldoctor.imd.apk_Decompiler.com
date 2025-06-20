package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import java.util.Set;

abstract class GeneratedAppGlideModule extends AppGlideModule {
    GeneratedAppGlideModule() {
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public abstract Set<Class<?>> d();

    /* access modifiers changed from: package-private */
    @Nullable
    public RequestManagerRetriever.RequestManagerFactory e() {
        return null;
    }
}
