package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class zzh implements zzq {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20543a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f20544b = new Object();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public OnCanceledListener f20545c;

    public zzh(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.f20543a = executor;
        this.f20545c = onCanceledListener;
    }

    public final void b() {
        synchronized (this.f20544b) {
            this.f20545c = null;
        }
    }

    public final void d(@NonNull Task task) {
        if (task.t()) {
            synchronized (this.f20544b) {
                try {
                    if (this.f20545c != null) {
                        this.f20543a.execute(new zzg(this));
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }
}
