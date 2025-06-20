package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

@KeepForSdk
public class ListenerHolders {

    /* renamed from: a  reason: collision with root package name */
    private final Set<ListenerHolder<?>> f20011a = Collections.newSetFromMap(new WeakHashMap());

    @NonNull
    @KeepForSdk
    public static <L> ListenerHolder<L> a(@NonNull L l2, @NonNull Looper looper, @NonNull String str) {
        Preconditions.s(l2, "Listener must not be null");
        Preconditions.s(looper, "Looper must not be null");
        Preconditions.s(str, "Listener type must not be null");
        return new ListenerHolder<>(looper, l2, str);
    }

    @NonNull
    @KeepForSdk
    public static <L> ListenerHolder<L> b(@NonNull L l2, @NonNull Executor executor, @NonNull String str) {
        Preconditions.s(l2, "Listener must not be null");
        Preconditions.s(executor, "Executor must not be null");
        Preconditions.s(str, "Listener type must not be null");
        return new ListenerHolder<>(executor, l2, str);
    }

    @NonNull
    @KeepForSdk
    public static <L> ListenerHolder.ListenerKey<L> c(@NonNull L l2, @NonNull String str) {
        Preconditions.s(l2, "Listener must not be null");
        Preconditions.s(str, "Listener type must not be null");
        Preconditions.m(str, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey<>(l2, str);
    }

    @NonNull
    public final <L> ListenerHolder<L> d(@NonNull L l2, @NonNull Looper looper, @NonNull String str) {
        ListenerHolder<L> a2 = a(l2, looper, "NO_TYPE");
        this.f20011a.add(a2);
        return a2;
    }

    public final void e() {
        for (ListenerHolder<?> a2 : this.f20011a) {
            a2.a();
        }
        this.f20011a.clear();
    }
}
