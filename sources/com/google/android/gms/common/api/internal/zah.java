package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zah extends zad<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    public final ListenerHolder.ListenerKey<?> f20164c;

    public zah(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.f20164c = listenerKey;
    }

    public final /* bridge */ /* synthetic */ void d(@NonNull zaad zaad, boolean z) {
    }

    public final boolean f(zabq<?> zabq) {
        zaci zaci = zabq.w().get(this.f20164c);
        return zaci != null && zaci.f20132a.f();
    }

    @Nullable
    public final Feature[] g(zabq<?> zabq) {
        zaci zaci = zabq.w().get(this.f20164c);
        if (zaci == null) {
            return null;
        }
        return zaci.f20132a.c();
    }

    public final void h(zabq<?> zabq) throws RemoteException {
        zaci remove = zabq.w().remove(this.f20164c);
        if (remove != null) {
            remove.f20133b.b(zabq.u(), this.f20145b);
            remove.f20132a.a();
            return;
        }
        this.f20145b.e(Boolean.FALSE);
    }
}
