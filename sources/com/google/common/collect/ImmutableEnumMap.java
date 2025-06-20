package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
    private final transient EnumMap<K, V> Y2;

    @J2ktIncompatible
    private static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long X = 0;
        final EnumMap<K, V> s;

        EnumSerializedForm(EnumMap<K, V> enumMap) {
            this.s = enumMap;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return new ImmutableEnumMap(this.s);
        }
    }

    private ImmutableEnumMap(EnumMap<K, V> enumMap) {
        this.Y2 = enumMap;
        Preconditions.d(!enumMap.isEmpty());
    }

    @J2ktIncompatible
    private void F(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use EnumSerializedForm");
    }

    static <K extends Enum<K>, V> ImmutableMap<K, V> K(EnumMap<K, V> enumMap) {
        int size = enumMap.size();
        if (size == 0) {
            return ImmutableMap.s();
        }
        if (size != 1) {
            return new ImmutableEnumMap(enumMap);
        }
        Map.Entry entry = (Map.Entry) Iterables.z(enumMap.entrySet());
        return ImmutableMap.t((Enum) entry.getKey(), entry.getValue());
    }

    /* access modifiers changed from: package-private */
    @J2ktIncompatible
    public Object I() {
        return new EnumSerializedForm(this.Y2);
    }

    /* access modifiers changed from: package-private */
    public UnmodifiableIterator<Map.Entry<K, V>> J() {
        return Maps.J0(this.Y2.entrySet().iterator());
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return this.Y2.containsKey(obj);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumMap) {
            obj = ((ImmutableEnumMap) obj).Y2;
        }
        return this.Y2.equals(obj);
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        return this.Y2.get(obj);
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public UnmodifiableIterator<K> o() {
        return Iterators.f0(this.Y2.keySet().iterator());
    }

    public int size() {
        return this.Y2.size();
    }
}
