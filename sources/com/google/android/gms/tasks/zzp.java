package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzp<TResult, TContinuationResult> implements OnSuccessListener<TContinuationResult>, OnFailureListener, OnCanceledListener, zzq {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20555a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final SuccessContinuation f20556b;

    /* renamed from: c  reason: collision with root package name */
    private final zzw f20557c;

    public zzp(@NonNull Executor executor, @NonNull SuccessContinuation successContinuation, @NonNull zzw zzw) {
        this.f20555a = executor;
        this.f20556b = successContinuation;
        this.f20557c = zzw;
    }

    public final void a(TContinuationResult tcontinuationresult) {
        this.f20557c.z(tcontinuationresult);
    }

    public final void b() {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        this.f20557c.A();
    }

    public final void d(@NonNull Task task) {
        this.f20555a.execute(new zzo(this, task));
    }

    public final void e(@NonNull Exception exc) {
        this.f20557c.y(exc);
    }
}
