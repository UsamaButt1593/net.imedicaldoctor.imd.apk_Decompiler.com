package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class zzj implements zzq {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20546a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f20547b = new Object();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public OnCompleteListener f20548c;

    public zzj(@NonNull Executor executor, @NonNull OnCompleteListener onCompleteListener) {
        this.f20546a = executor;
        this.f20548c = onCompleteListener;
    }

    public final void b() {
        synchronized (this.f20547b) {
            this.f20548c = null;
        }
    }

    public final void d(@NonNull Task task) {
        synchronized (this.f20547b) {
            try {
                if (this.f20548c != null) {
                    this.f20546a.execute(new zzi(this, task));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
