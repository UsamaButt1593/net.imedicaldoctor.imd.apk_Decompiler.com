package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Event<T> {
    public static <T> Event<T> A(T t, @Nullable EventContext eventContext) {
        return new AutoValue_Event((Integer) null, t, Priority.HIGHEST, (ProductData) null, eventContext);
    }

    public static <T> Event<T> B(T t, @Nullable ProductData productData) {
        return new AutoValue_Event((Integer) null, t, Priority.HIGHEST, productData, (EventContext) null);
    }

    public static <T> Event<T> C(T t, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        return new AutoValue_Event((Integer) null, t, Priority.HIGHEST, productData, eventContext);
    }

    public static <T> Event<T> f(int i2, T t) {
        return new AutoValue_Event(Integer.valueOf(i2), t, Priority.DEFAULT, (ProductData) null, (EventContext) null);
    }

    public static <T> Event<T> g(int i2, T t, @Nullable EventContext eventContext) {
        return new AutoValue_Event(Integer.valueOf(i2), t, Priority.DEFAULT, (ProductData) null, eventContext);
    }

    public static <T> Event<T> h(int i2, T t, @Nullable ProductData productData) {
        return new AutoValue_Event(Integer.valueOf(i2), t, Priority.DEFAULT, productData, (EventContext) null);
    }

    public static <T> Event<T> i(int i2, T t, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        return new AutoValue_Event(Integer.valueOf(i2), t, Priority.DEFAULT, productData, eventContext);
    }

    public static <T> Event<T> j(T t) {
        return new AutoValue_Event((Integer) null, t, Priority.DEFAULT, (ProductData) null, (EventContext) null);
    }

    public static <T> Event<T> k(T t, @Nullable EventContext eventContext) {
        return new AutoValue_Event((Integer) null, t, Priority.DEFAULT, (ProductData) null, eventContext);
    }

    public static <T> Event<T> l(T t, @Nullable ProductData productData) {
        return new AutoValue_Event((Integer) null, t, Priority.DEFAULT, productData, (EventContext) null);
    }

    public static <T> Event<T> m(T t, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        return new AutoValue_Event((Integer) null, t, Priority.DEFAULT, productData, eventContext);
    }

    public static <T> Event<T> n(int i2, T t) {
        return new AutoValue_Event(Integer.valueOf(i2), t, Priority.VERY_LOW, (ProductData) null, (EventContext) null);
    }

    public static <T> Event<T> o(int i2, T t, @Nullable EventContext eventContext) {
        return new AutoValue_Event(Integer.valueOf(i2), t, Priority.VERY_LOW, (ProductData) null, eventContext);
    }

    public static <T> Event<T> p(int i2, T t, @Nullable ProductData productData) {
        return new AutoValue_Event(Integer.valueOf(i2), t, Priority.VERY_LOW, productData, (EventContext) null);
    }

    public static <T> Event<T> q(int i2, T t, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        return new AutoValue_Event(Integer.valueOf(i2), t, Priority.VERY_LOW, productData, eventContext);
    }

    public static <T> Event<T> r(T t) {
        return new AutoValue_Event((Integer) null, t, Priority.VERY_LOW, (ProductData) null, (EventContext) null);
    }

    public static <T> Event<T> s(T t, @Nullable EventContext eventContext) {
        return new AutoValue_Event((Integer) null, t, Priority.VERY_LOW, (ProductData) null, eventContext);
    }

    public static <T> Event<T> t(T t, @Nullable ProductData productData) {
        return new AutoValue_Event((Integer) null, t, Priority.VERY_LOW, productData, (EventContext) null);
    }

    public static <T> Event<T> u(T t, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        return new AutoValue_Event((Integer) null, t, Priority.VERY_LOW, productData, eventContext);
    }

    public static <T> Event<T> v(int i2, T t) {
        return new AutoValue_Event(Integer.valueOf(i2), t, Priority.HIGHEST, (ProductData) null, (EventContext) null);
    }

    public static <T> Event<T> w(int i2, T t, @Nullable EventContext eventContext) {
        return new AutoValue_Event(Integer.valueOf(i2), t, Priority.HIGHEST, (ProductData) null, eventContext);
    }

    public static <T> Event<T> x(int i2, T t, @Nullable ProductData productData) {
        return new AutoValue_Event(Integer.valueOf(i2), t, Priority.HIGHEST, productData, (EventContext) null);
    }

    public static <T> Event<T> y(int i2, T t, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        return new AutoValue_Event(Integer.valueOf(i2), t, Priority.HIGHEST, productData, eventContext);
    }

    public static <T> Event<T> z(T t) {
        return new AutoValue_Event((Integer) null, t, Priority.HIGHEST, (ProductData) null, (EventContext) null);
    }

    @Nullable
    public abstract Integer a();

    @Nullable
    public abstract EventContext b();

    public abstract T c();

    public abstract Priority d();

    @Nullable
    public abstract ProductData e();
}
