package androidx.core.util;

import android.annotation.SuppressLint;

@SuppressLint({"UnknownNullness"})
public interface Predicate<T> {
    @SuppressLint({"MissingNullability"})
    Predicate<T> a(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate);

    @SuppressLint({"MissingNullability"})
    Predicate<T> b(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate);

    @SuppressLint({"MissingNullability"})
    Predicate<T> negate();

    boolean test(T t);
}
