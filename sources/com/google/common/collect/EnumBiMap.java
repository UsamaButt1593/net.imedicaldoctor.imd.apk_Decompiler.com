package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {
    @GwtIncompatible
    private static final long b3 = 0;
    transient Class<K> Z2;
    transient Class<V> a3;

    private EnumBiMap(Class<K> cls, Class<V> cls2) {
        super(new EnumMap(cls), new EnumMap(cls2));
        this.Z2 = cls;
        this.a3 = cls2;
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> Z1(Class<K> cls, Class<V> cls2) {
        return new EnumBiMap<>(cls, cls2);
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> c2(Map<K, V> map) {
        EnumBiMap<K, V> Z1 = Z1(h2(map), i2(map));
        Z1.putAll(map);
        return Z1;
    }

    static <K extends Enum<K>> Class<K> h2(Map<K, ?> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).Z2;
        }
        if (map instanceof EnumHashBiMap) {
            return ((EnumHashBiMap) map).Z2;
        }
        Preconditions.d(!map.isEmpty());
        return Platform.b((Enum) map.keySet().iterator().next());
    }

    private static <V extends Enum<V>> Class<V> i2(Map<?, V> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).a3;
        }
        Preconditions.d(!map.isEmpty());
        return Platform.b((Enum) map.values().iterator().next());
    }

    @GwtIncompatible
    private void k2(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object readObject = objectInputStream.readObject();
        Objects.requireNonNull(readObject);
        this.Z2 = (Class) readObject;
        Object readObject2 = objectInputStream.readObject();
        Objects.requireNonNull(readObject2);
        this.a3 = (Class) readObject2;
        Q1(new EnumMap(this.Z2), new EnumMap(this.a3));
        Serialization.b(this, objectInputStream);
    }

    @GwtIncompatible
    private void m2(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.Z2);
        objectOutputStream.writeObject(this.a3);
        Serialization.i(this, objectOutputStream);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: X1 */
    public K I1(K k2) {
        return (Enum) Preconditions.E(k2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Y1 */
    public V J1(V v) {
        return (Enum) Preconditions.E(v);
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @GwtIncompatible
    public Class<K> j2() {
        return this.Z2;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object k0(@ParametricNullness Object obj, @ParametricNullness Object obj2) {
        return super.k0(obj, obj2);
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @GwtIncompatible
    public Class<V> l2() {
        return this.a3;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(@ParametricNullness Object obj, @ParametricNullness Object obj2) {
        return super.put(obj, obj2);
    }

    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    public /* bridge */ /* synthetic */ BiMap q2() {
        return super.q2();
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj) {
        return super.remove(obj);
    }

    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }
}
