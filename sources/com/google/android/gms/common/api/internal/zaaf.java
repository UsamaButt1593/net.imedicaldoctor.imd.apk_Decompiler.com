package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

final class zaaf {

    /* renamed from: a  reason: collision with root package name */
    private final ApiKey<?> f20045a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource<Boolean> f20046b = new TaskCompletionSource<>();

    public zaaf(ApiKey<?> apiKey) {
        this.f20045a = apiKey;
    }

    public final ApiKey<?> a() {
        return this.f20045a;
    }

    public final TaskCompletionSource<Boolean> b() {
        return this.f20046b;
    }
}
