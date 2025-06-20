package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class ImmutableMapEntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

    @GwtIncompatible
    @J2ktIncompatible
    private static class EntrySetSerializedForm<K, V> implements Serializable {
        private static final long X = 0;
        final ImmutableMap<K, V> s;

        EntrySetSerializedForm(ImmutableMap<K, V> immutableMap) {
            this.s = immutableMap;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return this.s.entrySet();
        }
    }

    static final class RegularEntrySet<K, V> extends ImmutableMapEntrySet<K, V> {
        private final transient ImmutableMap<K, V> Y2;
        private final transient ImmutableList<Map.Entry<K, V>> Z2;

        RegularEntrySet(ImmutableMap<K, V> immutableMap, ImmutableList<Map.Entry<K, V>> immutableList) {
            this.Y2 = immutableMap;
            this.Z2 = immutableList;
        }

        /* access modifiers changed from: package-private */
        public ImmutableList<Map.Entry<K, V>> H() {
            return this.Z2;
        }

        /* access modifiers changed from: package-private */
        public ImmutableMap<K, V> U() {
            return this.Y2;
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible("not used in GWT")
        public int c(Object[] objArr, int i2) {
            return this.Z2.c(objArr, i2);
        }

        /* renamed from: k */
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.Z2.iterator();
        }

        RegularEntrySet(ImmutableMap<K, V> immutableMap, Map.Entry<K, V>[] entryArr) {
            this(immutableMap, ImmutableList.o(entryArr));
        }
    }

    ImmutableMapEntrySet() {
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use EntrySetSerializedForm");
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public boolean I() {
        return U().m();
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableMap<K, V> U();

    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = U().get(entry.getKey());
        return obj2 != null && obj2.equals(entry.getValue());
    }

    public int hashCode() {
        return U().hashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return U().n();
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @J2ktIncompatible
    public Object n() {
        return new EntrySetSerializedForm(U());
    }

    public int size() {
        return U().size();
    }
}
