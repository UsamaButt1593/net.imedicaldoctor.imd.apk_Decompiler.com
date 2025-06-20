package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface Function3<T1, T2, T3, R> {
    R a(T1 t1, T2 t2, T3 t3) throws Throwable;
}
