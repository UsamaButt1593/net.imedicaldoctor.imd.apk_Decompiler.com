package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class LottieResult<V> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final V f16761a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f16762b;

    public LottieResult(V v) {
        this.f16761a = v;
        this.f16762b = null;
    }

    @Nullable
    public Throwable a() {
        return this.f16762b;
    }

    @Nullable
    public V b() {
        return this.f16761a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult) obj;
        if (b() != null && b().equals(lottieResult.b())) {
            return true;
        }
        if (a() == null || lottieResult.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public LottieResult(Throwable th) {
        this.f16762b = th;
        this.f16761a = null;
    }
}
