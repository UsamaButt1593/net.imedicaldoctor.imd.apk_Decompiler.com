package com.google.common.reflect;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class ImmutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final ImmutableMap<TypeToken<? extends B>, B> s;

    public static final class Builder<B> {

        /* renamed from: a  reason: collision with root package name */
        private final ImmutableMap.Builder<TypeToken<? extends B>, B> f22989a;

        private Builder() {
            this.f22989a = ImmutableMap.b();
        }

        public ImmutableTypeToInstanceMap<B> a() {
            return new ImmutableTypeToInstanceMap<>(this.f22989a.d());
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> b(TypeToken<T> typeToken, T t) {
            this.f22989a.i(typeToken.V(), t);
            return this;
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> c(Class<T> cls, T t) {
            this.f22989a.i(TypeToken.T(cls), t);
            return this;
        }
    }

    private ImmutableTypeToInstanceMap(ImmutableMap<TypeToken<? extends B>, B> immutableMap) {
        this.s = immutableMap;
    }

    public static <B> ImmutableTypeToInstanceMap<B> B1() {
        return new ImmutableTypeToInstanceMap<>(ImmutableMap.s());
    }

    @CheckForNull
    private <T extends B> T G1(TypeToken<T> typeToken) {
        return this.s.get(typeToken);
    }

    public static <B> Builder<B> x1() {
        return new Builder<>();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    /* renamed from: E1 */
    public B put(TypeToken<? extends B> typeToken, B b2) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public <T extends B> T G0(TypeToken<T> typeToken, T t) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    public <T extends B> T L(TypeToken<T> typeToken) {
        return G1(typeToken.V());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public Map<TypeToken<? extends B>, B> Z0() {
        return this.s;
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException();
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
        return G1(TypeToken.T(cls));
    }
}
