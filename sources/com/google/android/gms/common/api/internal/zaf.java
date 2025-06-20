package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zaf extends zad<Void> {

    /* renamed from: c  reason: collision with root package name */
    public final zaci f20160c;

    public zaf(zaci zaci, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.f20160c = zaci;
    }

    public final /* bridge */ /* synthetic */ void d(@NonNull zaad zaad, boolean z) {
    }

    public final boolean f(zabq<?> zabq) {
        return this.f20160c.f20132a.f();
    }

    @Nullable
    public final Feature[] g(zabq<?> zabq) {
        return this.f20160c.f20132a.c();
    }

    public final void h(zabq<?> zabq) throws RemoteException {
        this.f20160c.f20132a.d(zabq.u(), this.f20145b);
        ListenerHolder.ListenerKey<?> b2 = this.f20160c.f20132a.b();
        if (b2 != null) {
            zabq.w().put(b2, this.f20160c);
        }
    }
}
