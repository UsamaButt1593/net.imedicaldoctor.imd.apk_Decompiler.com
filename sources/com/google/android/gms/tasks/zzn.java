package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class zzn implements zzq {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20552a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f20553b = new Object();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public OnSuccessListener f20554c;

    public zzn(@NonNull Executor executor, @NonNull OnSuccessListener onSuccessListener) {
        this.f20552a = executor;
        this.f20554c = onSuccessListener;
    }

    public final void b() {
        synchronized (this.f20553b) {
            this.f20554c = null;
        }
    }

    public final void d(@NonNull Task task) {
        if (task.v()) {
            synchronized (this.f20553b) {
                try {
                    if (this.f20554c != null) {
                        this.f20552a.execute(new zzm(this, task));
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
