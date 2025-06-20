package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

public class Response<T extends Result> {
    private Result s;

    public Response() {
    }

    /* access modifiers changed from: protected */
    @NonNull
    public T b() {
        return this.s;
    }

    public void c(@NonNull T t) {
        this.s = t;
    }

    protected Response(@NonNull T t) {
        this.s = t;
    }
}
