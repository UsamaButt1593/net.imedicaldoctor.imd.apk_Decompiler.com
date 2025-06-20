package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface Function4<T1, T2, T3, T4, R> {
    R a(T1 t1, T2 t2, T3 t3, T4 t4) throws Throwable;
}
