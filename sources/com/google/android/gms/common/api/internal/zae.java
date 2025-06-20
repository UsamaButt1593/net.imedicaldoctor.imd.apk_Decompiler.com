package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Preconditions;

public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zai {

    /* renamed from: b  reason: collision with root package name */
    protected final A f20159b;

    public zae(int i2, A a2) {
        super(i2);
        this.f20159b = (BaseImplementation.ApiMethodImpl) Preconditions.s(a2, "Null methods are not runnable.");
    }

    public final void a(@NonNull Status status) {
        try {
            this.f20159b.a(status);
        } catch (IllegalStateException e2) {
            Log.w("ApiCallRunner", "Exception reporting failure", e2);
        }
    }

    public final void b(@NonNull Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(simpleName.length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        try {
            this.f20159b.a(new Status(10, sb.toString()));
        } catch (IllegalStateException e2) {
            Log.w("ApiCallRunner", "Exception reporting failure", e2);
        }
    }

    public final void c(zabq<?> zabq) throws DeadObjectException {
        try {
            this.f20159b.A(zabq.u());
        } catch (RuntimeException e2) {
            b(e2);
        }
    }

    public final void d(@NonNull zaad zaad, boolean z) {
        zaad.c(this.f20159b, z);
    }
}
