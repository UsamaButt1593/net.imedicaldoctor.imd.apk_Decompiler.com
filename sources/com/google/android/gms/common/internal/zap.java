package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

final class zap implements PendingResult.StatusListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PendingResult f20289a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f20290b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ PendingResultUtil.ResultConverter f20291c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zas f20292d;

    zap(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, zas zas) {
        this.f20289a = pendingResult;
        this.f20290b = taskCompletionSource;
        this.f20291c = resultConverter;
        this.f20292d = zas;
    }

    public final void a(Status status) {
        if (status.R()) {
            this.f20290b.c(this.f20291c.a(this.f20289a.e(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.f20290b.b(ApiExceptionUtil.a(status));
    }
}
