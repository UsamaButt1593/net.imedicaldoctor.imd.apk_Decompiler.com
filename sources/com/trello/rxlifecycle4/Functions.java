package com.trello.rxlifecycle4;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.concurrent.CancellationException;

final class Functions {

    /* renamed from: a  reason: collision with root package name */
    static final Function<Throwable, Boolean> f28247a = new Function<Throwable, Boolean>() {
        /* renamed from: a */
        public Boolean apply(Throwable th) throws Exception {
            if (th instanceof OutsideLifecycleException) {
                return Boolean.TRUE;
            }
            Exceptions.a(th);
            return Boolean.FALSE;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static final Predicate<Boolean> f28248b = new Predicate<Boolean>() {
        /* renamed from: a */
        public boolean test(Boolean bool) throws Exception {
            return bool.booleanValue();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    static final Function<Object, Completable> f28249c = new Function<Object, Completable>() {
        /* renamed from: a */
        public Completable apply(Object obj) throws Exception {
            return Completable.X(new CancellationException());
        }
    };

    private Functions() {
        throw new AssertionError("No instances!");
    }
}
