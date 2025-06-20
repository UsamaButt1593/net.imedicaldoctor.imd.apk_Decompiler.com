package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zag<ResultT> extends zac {

    /* renamed from: b  reason: collision with root package name */
    private final TaskApiCall<Api.AnyClient, ResultT> f20161b;

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource<ResultT> f20162c;

    /* renamed from: d  reason: collision with root package name */
    private final StatusExceptionMapper f20163d;

    public zag(int i2, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i2);
        this.f20162c = taskCompletionSource;
        this.f20161b = taskApiCall;
        this.f20163d = statusExceptionMapper;
        if (i2 == 2 && taskApiCall.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    public final void a(@NonNull Status status) {
        this.f20162c.d(this.f20163d.a(status));
    }

    public final void b(@NonNull Exception exc) {
        this.f20162c.d(exc);
    }

    public final void c(zabq<?> zabq) throws DeadObjectException {
        try {
            this.f20161b.b(zabq.u(), this.f20162c);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            a(zai.e(e3));
        } catch (RuntimeException e4) {
            this.f20162c.d(e4);
        }
    }

    public final void d(@NonNull zaad zaad, boolean z) {
        zaad.d(this.f20162c, z);
    }

    public final boolean f(zabq<?> zabq) {
        return this.f20161b.c();
    }

    @Nullable
    public final Feature[] g(zabq<?> zabq) {
        return this.f20161b.e();
    }
}
