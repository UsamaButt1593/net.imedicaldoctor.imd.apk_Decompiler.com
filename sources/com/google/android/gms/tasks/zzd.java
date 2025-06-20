package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzd implements zzq {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20537a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Continuation f20538b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final zzw f20539c;

    public zzd(@NonNull Executor executor, @NonNull Continuation continuation, @NonNull zzw zzw) {
        this.f20537a = executor;
        this.f20538b = continuation;
        this.f20539c = zzw;
    }

    public final void b() {
        throw new UnsupportedOperationException();
    }

    public final void d(@NonNull Task task) {
        this.f20537a.execute(new zzc(this, task));
    }
}
