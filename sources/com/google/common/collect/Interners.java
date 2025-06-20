package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class Interners {

    public static class InternerBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final MapMaker f22423a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f22424b;

        private InternerBuilder() {
            this.f22423a = new MapMaker();
            this.f22424b = true;
        }

        public <E> Interner<E> a() {
            if (!this.f22424b) {
                this.f22423a.l();
            }
            return new InternerImpl(this.f22423a);
        }

        public InternerBuilder b(int i2) {
            this.f22423a.a(i2);
            return this;
        }

        public InternerBuilder c() {
            this.f22424b = true;
            return this;
        }

        @GwtIncompatible("java.lang.ref.WeakReference")
        public InternerBuilder d() {
            this.f22424b = false;
            return this;
        }
    }

    private static class InternerFunction<E> implements Function<E, E> {
        private final Interner<E> s;

        public InternerFunction(Interner<E> interner) {
            this.s = interner;
        }

        public E apply(E e2) {
            return this.s.a(e2);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof InternerFunction) {
                return this.s.equals(((InternerFunction) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return this.s.hashCode();
        }
    }

    @VisibleForTesting
    static final class InternerImpl<E> implements Interner<E> {
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        final MapMakerInternalMap<E, MapMaker.Dummy, ?, ?> f22425a;

        private InternerImpl(MapMaker mapMaker) {
            this.f22425a = MapMakerInternalMap.e(mapMaker.h(Equivalence.c()));
        }

        public E a(E e2) {
            E key;
            do {
                MapMakerInternalMap.InternalEntry f2 = this.f22425a.f(e2);
                if (f2 != null && (key = f2.getKey()) != null) {
                    return key;
                }
            } while (this.f22425a.putIfAbsent(e2, MapMaker.Dummy.VALUE) != null);
            return e2;
        }
    }

    private Interners() {
    }

    public static <E> Function<E, E> a(Interner<E> interner) {
        return new InternerFunction((Interner) Preconditions.E(interner));
    }

    public static InternerBuilder b() {
        return new InternerBuilder();
    }

    public static <E> Interner<E> c() {
        return b().c().a();
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public static <E> Interner<E> d() {
        return b().d().a();
    }
}
