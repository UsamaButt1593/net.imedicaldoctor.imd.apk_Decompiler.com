package io.reactivex.rxjava3.internal.util;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.exceptions.CompositeException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.StringUtils;

public final class ExceptionHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Throwable f28479a = new Termination();

    static final class Termination extends Throwable {
        private static final long s = -4649703670690200604L;

        Termination() {
            super("No further exceptions");
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    private ExceptionHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Throwable th3;
        do {
            th2 = atomicReference.get();
            if (th2 == f28479a) {
                return false;
            }
            if (th2 == null) {
                th3 = th;
            } else {
                th3 = new CompositeException(th2, th);
            }
        } while (!g.a(atomicReference, th2, th3));
        return true;
    }

    public static NullPointerException b(String str) {
        return new NullPointerException(e(str));
    }

    public static List<Throwable> c(Throwable th) {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer(th);
        while (!arrayDeque.isEmpty()) {
            Throwable th2 = (Throwable) arrayDeque.removeFirst();
            if (th2 instanceof CompositeException) {
                List<Throwable> b2 = ((CompositeException) th2).b();
                for (int size = b2.size() - 1; size >= 0; size--) {
                    arrayDeque.offerFirst(b2.get(size));
                }
            } else {
                arrayList.add(th2);
            }
        }
        return arrayList;
    }

    public static <T> T d(T t, String str) {
        if (t != null) {
            return t;
        }
        throw b(str);
    }

    public static String e(String str) {
        return str + " Null values are generally not allowed in 3.x operators and sources.";
    }

    public static Throwable f(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f28479a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    public static <E extends Throwable> Exception g(Throwable th) throws Throwable {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }

    public static String h(long j2, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j2 + StringUtils.SPACE + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException i(Throwable th) {
        if (!(th instanceof Error)) {
            return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
        }
        throw ((Error) th);
    }
}
