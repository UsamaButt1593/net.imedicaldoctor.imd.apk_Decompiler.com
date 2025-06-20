package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Timed<T> {

    /* renamed from: a  reason: collision with root package name */
    final T f28535a;

    /* renamed from: b  reason: collision with root package name */
    final long f28536b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f28537c;

    public Timed(@NonNull T t, long j2, @NonNull TimeUnit timeUnit) {
        Objects.requireNonNull(t, "value is null");
        this.f28535a = t;
        this.f28536b = j2;
        Objects.requireNonNull(timeUnit, "unit is null");
        this.f28537c = timeUnit;
    }

    public long a() {
        return this.f28536b;
    }

    public long b(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.f28536b, this.f28537c);
    }

    @NonNull
    public TimeUnit c() {
        return this.f28537c;
    }

    @NonNull
    public T d() {
        return this.f28535a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        return Objects.equals(this.f28535a, timed.f28535a) && this.f28536b == timed.f28536b && Objects.equals(this.f28537c, timed.f28537c);
    }

    public int hashCode() {
        long j2 = this.f28536b;
        return (((this.f28535a.hashCode() * 31) + ((int) (j2 ^ (j2 >>> 31)))) * 31) + this.f28537c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f28536b + ", unit=" + this.f28537c + ", value=" + this.f28535a + "]";
    }
}
