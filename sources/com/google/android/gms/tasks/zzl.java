package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class zzl implements zzq {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20549a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f20550b = new Object();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public OnFailureListener f20551c;

    public zzl(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.f20549a = executor;
        this.f20551c = onFailureListener;
    }

    public final void b() {
        synchronized (this.f20550b) {
            this.f20551c = null;
        }
    }

    public final void d(@NonNull Task task) {
        if (!task.v() && !task.t()) {
            synchronized (this.f20550b) {
                try {
                    if (this.f20551c != null) {
                        this.f20549a.execute(new zzk(this, task));
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
