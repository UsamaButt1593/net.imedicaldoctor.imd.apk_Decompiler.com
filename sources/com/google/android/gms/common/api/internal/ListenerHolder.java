package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

@KeepForSdk
public final class ListenerHolder<L> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20006a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private volatile L f20007b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private volatile ListenerKey<L> f20008c;

    @KeepForSdk
    public static final class ListenerKey<L> {

        /* renamed from: a  reason: collision with root package name */
        private final L f20009a;

        /* renamed from: b  reason: collision with root package name */
        private final String f20010b;

        @KeepForSdk
        ListenerKey(L l2, String str) {
            this.f20009a = l2;
            this.f20010b = str;
        }

        @NonNull
        @KeepForSdk
        public String a() {
            String str = this.f20010b;
            int identityHashCode = System.identityHashCode(this.f20009a);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(str);
            sb.append("@");
            sb.append(identityHashCode);
            return sb.toString();
        }

        @KeepForSdk
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.f20009a == listenerKey.f20009a && this.f20010b.equals(listenerKey.f20010b);
        }

        @KeepForSdk
        public int hashCode() {
            return (System.identityHashCode(this.f20009a) * 31) + this.f20010b.hashCode();
        }
    }

    @KeepForSdk
    public interface Notifier<L> {
        @KeepForSdk
        void a(@NonNull L l2);

        @KeepForSdk
        void b();
    }

    @KeepForSdk
    ListenerHolder(@NonNull Looper looper, @NonNull L l2, @NonNull String str) {
        this.f20006a = new HandlerExecutor(looper);
        this.f20007b = Preconditions.s(l2, "Listener must not be null");
        this.f20008c = new ListenerKey<>(l2, Preconditions.l(str));
    }

    @KeepForSdk
    public void a() {
        this.f20007b = null;
        this.f20008c = null;
    }

    @KeepForSdk
    @Nullable
    public ListenerKey<L> b() {
        return this.f20008c;
    }

    @KeepForSdk
    public boolean c() {
        return this.f20007b != null;
    }

    @KeepForSdk
    public void d(@NonNull Notifier<? super L> notifier) {
        Preconditions.s(notifier, "Notifier must not be null");
        this.f20006a.execute(new zacb(this, notifier));
    }

    /* access modifiers changed from: package-private */
    public final void e(Notifier<? super L> notifier) {
        L l2 = this.f20007b;
        if (l2 == null) {
            notifier.b();
            return;
        }
        try {
            notifier.a(l2);
        } catch (RuntimeException e2) {
            notifier.b();
            throw e2;
        }
    }

    @KeepForSdk
    ListenerHolder(@NonNull Executor executor, @NonNull L l2, @NonNull String str) {
        this.f20006a = (Executor) Preconditions.s(executor, "Executor must not be null");
        this.f20007b = Preconditions.s(l2, "Listener must not be null");
        this.f20008c = new ListenerKey<>(l2, Preconditions.l(str));
    }
}
