package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

public final class ApiKey<O extends Api.ApiOptions> {

    /* renamed from: a  reason: collision with root package name */
    private final int f19980a;

    /* renamed from: b  reason: collision with root package name */
    private final Api<O> f19981b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final O f19982c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f19983d;

    private ApiKey(Api<O> api, @Nullable O o, @Nullable String str) {
        this.f19981b = api;
        this.f19982c = o;
        this.f19983d = str;
        this.f19980a = Objects.c(api, o, str);
    }

    @NonNull
    public static <O extends Api.ApiOptions> ApiKey<O> a(@NonNull Api<O> api, @Nullable O o, @Nullable String str) {
        return new ApiKey<>(api, o, str);
    }

    @NonNull
    public final String b() {
        return this.f19981b.d();
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        return Objects.b(this.f19981b, apiKey.f19981b) && Objects.b(this.f19982c, apiKey.f19982c) && Objects.b(this.f19983d, apiKey.f19983d);
    }

    public final int hashCode() {
        return this.f19980a;
    }
}
