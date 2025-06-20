package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TaskCompletionSource<TResult> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final zzw f20521a = new zzw();

    public TaskCompletionSource() {
    }

    @NonNull
    public Task<TResult> a() {
        return this.f20521a;
    }

    public void b(@NonNull Exception exc) {
        this.f20521a.y(exc);
    }

    public void c(@Nullable TResult tresult) {
        this.f20521a.z(tresult);
    }

    public boolean d(@NonNull Exception exc) {
        return this.f20521a.B(exc);
    }

    public boolean e(@Nullable TResult tresult) {
        return this.f20521a.C(tresult);
    }

    public TaskCompletionSource(@NonNull CancellationToken cancellationToken) {
        cancellationToken.b(new zzs(this));
    }
}
