package androidx.core.util;

import android.annotation.SuppressLint;
import java.util.Objects;

public final /* synthetic */ class k {
    @SuppressLint({"MissingNullability"})
    public static Predicate a(Predicate predicate, @SuppressLint({"MissingNullability"}) Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new i(predicate, predicate2);
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate b(Predicate predicate) {
        return new j(predicate);
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate c(Predicate predicate, @SuppressLint({"MissingNullability"}) Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new f(predicate, predicate2);
    }

    public static /* synthetic */ boolean d(Predicate predicate, Predicate predicate2, Object obj) {
        if (!predicate.test(obj) || !predicate2.test(obj)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean e(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    public static /* synthetic */ boolean f(Predicate predicate, Predicate predicate2, Object obj) {
        if (predicate.test(obj) || predicate2.test(obj)) {
            return true;
        }
        return false;
    }

    @SuppressLint({"MissingNullability"})
    public static <T> Predicate<T> g(@SuppressLint({"MissingNullability"}) Object obj) {
        if (obj == null) {
            return new g();
        }
        return new h(obj);
    }

    @SuppressLint({"MissingNullability"})
    public static <T> Predicate<T> j(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
