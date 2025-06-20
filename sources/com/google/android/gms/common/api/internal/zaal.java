package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

final class zaal implements BaseGmsClient.ConnectionProgressReportCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<zaaw> f20052a;

    /* renamed from: b  reason: collision with root package name */
    private final Api<?> f20053b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final boolean f20054c;

    public zaal(zaaw zaaw, Api<?> api, boolean z) {
        this.f20052a = new WeakReference<>(zaaw);
        this.f20053b = api;
        this.f20054c = z;
    }

    public final void a(@NonNull ConnectionResult connectionResult) {
        zaaw zaaw = this.f20052a.get();
        if (zaaw != null) {
            Preconditions.y(Looper.myLooper() == zaaw.f20062a.y.r(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zaaw.f20063b.lock();
            try {
                if (zaaw.o(0)) {
                    if (!connectionResult.O()) {
                        zaaw.m(connectionResult, this.f20053b, this.f20054c);
                    }
                    if (zaaw.p()) {
                        zaaw.n();
                    }
                }
                zaaw.f20063b.unlock();
            } catch (Throwable th) {
                zaaw.f20063b.unlock();
                throw th;
            }
        }
    }
}
