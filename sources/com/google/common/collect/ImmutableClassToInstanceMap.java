package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"B"})
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private static final ImmutableClassToInstanceMap<Object> X = new ImmutableClassToInstanceMap<>(ImmutableMap.s());
    private final ImmutableMap<Class<? extends B>, B> s;

    public static final class Builder<B> {

        /* renamed from: a  reason: collision with root package name */
        private final ImmutableMap.Builder<Class<? extends B>, B> f22385a = ImmutableMap.b();

        private static <T> T b(Class<T> cls, Object obj) {
            return Primitives.f(cls).cast(obj);
        }

        public ImmutableClassToInstanceMap<B> a() {
            ImmutableMap<Class<? extends B>, B> d2 = this.f22385a.d();
            return d2.isEmpty() ? ImmutableClassToInstanceMap.E1() : new ImmutableClassToInstanceMap<>(d2);
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> c(Class<T> cls, T t) {
            this.f22385a.i(cls, t);
            return this;
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> d(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry next : map.entrySet()) {
                Class cls = (Class) next.getKey();
                this.f22385a.i(cls, b(cls, next.getValue()));
            }
            return this;
        }
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        this.s = immutableMap;
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> B1(Map<? extends Class<? extends S>, ? extends S> map) {
        return map instanceof ImmutableClassToInstanceMap ? (ImmutableClassToInstanceMap) map : new Builder().d(map).a();
    }

    public static <B> ImmutableClassToInstanceMap<B> E1() {
        return X;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> G1(Class<T> cls, T t) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.t(cls, t));
    }

    public static <B> Builder<B> x1() {
        return new Builder<>();
    }

    /* access modifiers changed from: package-private */
    public Object I1() {
        return isEmpty() ? E1() : this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public Map<Class<? extends B>, B> Z0() {
        return this.s;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public <T extends B> T q(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    public <T extends B> T r(Class<T> cls) {
        return this.s.get(Preconditions.E(cls));
    }
}
