package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

final class zzb extends CancellationToken {

    /* renamed from: a  reason: collision with root package name */
    private final zzw f20536a = new zzw();

    zzb() {
    }

    public final boolean a() {
        return this.f20536a.u();
    }

    public final CancellationToken b(@NonNull OnTokenCanceledListener onTokenCanceledListener) {
        this.f20536a.l(TaskExecutors.f20522a, new zza(this, onTokenCanceledListener));
        return this;
    }

    public final void c() {
        this.f20536a.C((Object) null);
    }
}
