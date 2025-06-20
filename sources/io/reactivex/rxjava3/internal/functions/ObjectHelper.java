package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.functions.BiPredicate;
import java.util.Objects;

public final class ObjectHelper {

    /* renamed from: a  reason: collision with root package name */
    static final BiPredicate<Object, Object> f28389a = new BiObjectPredicate();

    static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        BiObjectPredicate() {
        }

        public boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> BiPredicate<T, T> a() {
        return f28389a;
    }

    public static int b(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i2);
    }

    public static long c(long j2, String str) {
        if (j2 > 0) {
            return j2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j2);
    }
}
