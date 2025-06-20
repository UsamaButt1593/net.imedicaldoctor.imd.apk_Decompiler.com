package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;

public final class zal {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayMap<ApiKey<?>, ConnectionResult> f20169a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayMap<ApiKey<?>, String> f20170b = new ArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource<Map<ApiKey<?>, String>> f20171c = new TaskCompletionSource<>();

    /* renamed from: d  reason: collision with root package name */
    private int f20172d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f20173e = false;

    public zal(Iterable<? extends HasApiKey<?>> iterable) {
        for (HasApiKey b2 : iterable) {
            this.f20169a.put(b2.b(), null);
        }
        this.f20172d = this.f20169a.keySet().size();
    }

    public final Task<Map<ApiKey<?>, String>> a() {
        return this.f20171c.a();
    }

    public final Set<ApiKey<?>> b() {
        return this.f20169a.keySet();
    }

    public final void c(ApiKey<?> apiKey, ConnectionResult connectionResult, @Nullable String str) {
        this.f20169a.put(apiKey, connectionResult);
        this.f20170b.put(apiKey, str);
        this.f20172d--;
        if (!connectionResult.O()) {
            this.f20173e = true;
        }
        if (this.f20172d != 0) {
            return;
        }
        if (this.f20173e) {
            this.f20171c.b(new AvailabilityException(this.f20169a));
            return;
        }
        this.f20171c.c(this.f20170b);
    }
}
