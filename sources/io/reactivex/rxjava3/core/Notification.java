package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Objects;

public final class Notification<T> {

    /* renamed from: b  reason: collision with root package name */
    static final Notification<Object> f28367b = new Notification<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    final Object f28368a;

    private Notification(@Nullable Object obj) {
        this.f28368a = obj;
    }

    @NonNull
    public static <T> Notification<T> a() {
        return f28367b;
    }

    @NonNull
    public static <T> Notification<T> b(@NonNull Throwable th) {
        Objects.requireNonNull(th, "error is null");
        return new Notification<>(NotificationLite.h(th));
    }

    @NonNull
    public static <T> Notification<T> c(T t) {
        Objects.requireNonNull(t, "value is null");
        return new Notification<>(t);
    }

    @Nullable
    public Throwable d() {
        Object obj = this.f28368a;
        if (NotificationLite.o(obj)) {
            return NotificationLite.j(obj);
        }
        return null;
    }

    @Nullable
    public T e() {
        Object obj = this.f28368a;
        if (obj == null || NotificationLite.o(obj)) {
            return null;
        }
        return this.f28368a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return Objects.equals(this.f28368a, ((Notification) obj).f28368a);
        }
        return false;
    }

    public boolean f() {
        return this.f28368a == null;
    }

    public boolean g() {
        return NotificationLite.o(this.f28368a);
    }

    public boolean h() {
        Object obj = this.f28368a;
        return obj != null && !NotificationLite.o(obj);
    }

    public int hashCode() {
        Object obj = this.f28368a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f28368a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.o(obj)) {
            return "OnErrorNotification[" + NotificationLite.j(obj) + "]";
        }
        return "OnNextNotification[" + this.f28368a + "]";
    }
}
