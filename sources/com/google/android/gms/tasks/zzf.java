package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzf<TResult, TContinuationResult> implements OnSuccessListener<TContinuationResult>, OnFailureListener, OnCanceledListener, zzq {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20540a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Continuation f20541b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final zzw f20542c;

    public zzf(@NonNull Executor executor, @NonNull Continuation continuation, @NonNull zzw zzw) {
        this.f20540a = executor;
        this.f20541b = continuation;
        this.f20542c = zzw;
    }

    public final void a(TContinuationResult tcontinuationresult) {
        this.f20542c.z(tcontinuationresult);
    }

    public final void b() {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        this.f20542c.A();
    }

    public final void d(@NonNull Task task) {
        this.f20540a.execute(new zze(this, task));
    }

    public final void e(@NonNull Exception exc) {
        this.f20542c.y(exc);
    }
}
