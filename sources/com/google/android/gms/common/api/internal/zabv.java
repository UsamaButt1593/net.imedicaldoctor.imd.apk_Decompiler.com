package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zabv<O extends Api.ApiOptions> extends zaag {
    @NotOnlyInitialized

    /* renamed from: f  reason: collision with root package name */
    private final GoogleApi<O> f20117f;

    public zabv(GoogleApi<O> googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f20117f = googleApi;
    }

    public final void H(zada zada) {
    }

    public final void I(zada zada) {
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T l(@NonNull T t) {
        return this.f20117f.h(t);
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T m(@NonNull T t) {
        return this.f20117f.n(t);
    }

    public final Context q() {
        return this.f20117f.q();
    }

    public final Looper r() {
        return this.f20117f.t();
    }
}
