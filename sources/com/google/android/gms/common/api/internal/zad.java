package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zad<T> extends zac {

    /* renamed from: b  reason: collision with root package name */
    protected final TaskCompletionSource<T> f20145b;

    public zad(int i2, TaskCompletionSource<T> taskCompletionSource) {
        super(i2);
        this.f20145b = taskCompletionSource;
    }

    public final void a(@NonNull Status status) {
        this.f20145b.d(new ApiException(status));
    }

    public final void b(@NonNull Exception exc) {
        this.f20145b.d(exc);
    }

    public final void c(zabq<?> zabq) throws DeadObjectException {
        try {
            h(zabq);
        } catch (DeadObjectException e2) {
            a(zai.e(e2));
            throw e2;
        } catch (RemoteException e3) {
            a(zai.e(e3));
        } catch (RuntimeException e4) {
            this.f20145b.d(e4);
        }
    }

    public void d(@NonNull zaad zaad, boolean z) {
    }

    /* access modifiers changed from: protected */
    public abstract void h(zabq<?> zabq) throws RemoteException;
}
