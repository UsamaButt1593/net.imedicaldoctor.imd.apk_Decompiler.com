package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class LottieCompositionCache {

    /* renamed from: b  reason: collision with root package name */
    private static final LottieCompositionCache f17121b = new LottieCompositionCache();

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<String, LottieComposition> f17122a = new LruCache<>(20);

    @VisibleForTesting
    LottieCompositionCache() {
    }

    public static LottieCompositionCache c() {
        return f17121b;
    }

    public void a() {
        this.f17122a.evictAll();
    }

    @Nullable
    public LottieComposition b(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f17122a.get(str);
    }

    public void d(@Nullable String str, LottieComposition lottieComposition) {
        if (str != null) {
            this.f17122a.put(str, lottieComposition);
        }
    }

    public void e(int i2) {
        this.f17122a.resize(i2);
    }
}
