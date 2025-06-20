package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class MutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private final Map<Class<? extends B>, B> s;

    private static final class SerializedForm<B> implements Serializable {
        private static final long X = 0;
        private final Map<Class<? extends B>, B> s;

        SerializedForm(Map<Class<? extends B>, B> map) {
            this.s = map;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return MutableClassToInstanceMap.J1(this.s);
        }
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        this.s = (Map) Preconditions.E(map);
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    @CheckForNull
    public static <T> T E1(Class<T> cls, @CheckForNull Object obj) {
        return Primitives.f(cls).cast(obj);
    }

    /* access modifiers changed from: private */
    public static <B> Map.Entry<Class<? extends B>, B> G1(final Map.Entry<Class<? extends B>, B> entry) {
        return new ForwardingMapEntry<Class<? extends B>, B>() {
            /* access modifiers changed from: protected */
            /* renamed from: a1 */
            public Map.Entry<Class<? extends B>, B> Z0() {
                return entry;
            }

            @ParametricNullness
            public B setValue(@ParametricNullness B b2) {
                Object unused = MutableClassToInstanceMap.E1((Class) getKey(), b2);
                return super.setValue(b2);
            }
        };
    }

    public static <B> MutableClassToInstanceMap<B> I1() {
        return new MutableClassToInstanceMap<>(new HashMap());
    }

    public static <B> MutableClassToInstanceMap<B> J1(Map<Class<? extends B>, B> map) {
        return new MutableClassToInstanceMap<>(map);
    }

    private void L1(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object M1() {
        return new SerializedForm(Z0());
    }

    @CanIgnoreReturnValue
    @CheckForNull
    /* renamed from: K1 */
    public B put(Class<? extends B> cls, @ParametricNullness B b2) {
        E1(cls, b2);
        return super.put(cls, b2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public Map<Class<? extends B>, B> Z0() {
        return this.s;
    }

    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new ForwardingSet<Map.Entry<Class<? extends B>, B>>() {
            /* access modifiers changed from: protected */
            /* renamed from: E1 */
            public Set<Map.Entry<Class<? extends B>, B>> a1() {
                return MutableClassToInstanceMap.this.Z0().entrySet();
            }

            public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
                return new TransformedIterator<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>>(this, a1().iterator()) {
                    /* access modifiers changed from: package-private */
                    /* renamed from: b */
                    public Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> entry) {
                        return MutableClassToInstanceMap.G1(entry);
                    }
                };
            }

            public Object[] toArray() {
                return v1();
            }

            public <T> T[] toArray(T[] tArr) {
                return x1(tArr);
            }
        };
    }

    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            E1((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public <T extends B> T q(Class<T> cls, @ParametricNullness T t) {
        return E1(cls, put(cls, t));
    }

    @CheckForNull
    public <T extends B> T r(Class<T> cls) {
        return E1(cls, get(cls));
    }
}
