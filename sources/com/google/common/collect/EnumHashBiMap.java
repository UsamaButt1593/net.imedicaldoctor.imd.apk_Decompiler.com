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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractBiMap<K, V> {
    @GwtIncompatible
    private static final long a3 = 0;
    transient Class<K> Z2;

    private EnumHashBiMap(Class<K> cls) {
        super(new EnumMap(cls), new HashMap());
        this.Z2 = cls;
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> Y1(Class<K> cls) {
        return new EnumHashBiMap<>(cls);
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> Z1(Map<K, ? extends V> map) {
        EnumHashBiMap<K, V> Y1 = Y1(EnumBiMap.h2(map));
        Y1.putAll(map);
        return Y1;
    }

    @GwtIncompatible
    private void j2(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object readObject = objectInputStream.readObject();
        Objects.requireNonNull(readObject);
        this.Z2 = (Class) readObject;
        Q1(new EnumMap(this.Z2), new HashMap());
        Serialization.b(this, objectInputStream);
    }

    @GwtIncompatible
    private void k2(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.Z2);
        Serialization.i(this, objectOutputStream);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: X1 */
    public K I1(K k2) {
        return (Enum) Preconditions.E(k2);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    /* renamed from: c2 */
    public V k0(K k2, @ParametricNullness V v) {
        return super.k0(k2, v);
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
    public Class<K> h2() {
        return this.Z2;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    /* renamed from: i2 */
    public V put(K k2, @ParametricNullness V v) {
        return super.put(k2, v);
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
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
