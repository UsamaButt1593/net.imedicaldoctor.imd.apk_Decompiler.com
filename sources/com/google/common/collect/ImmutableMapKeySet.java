package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class ImmutableMapKeySet<K, V> extends IndexedImmutableSet<K> {
    private final ImmutableMap<K, V> Y2;

    @GwtIncompatible
    @J2ktIncompatible
    private static class KeySetSerializedForm<K> implements Serializable {
        private static final long X = 0;
        final ImmutableMap<K, ?> s;

        KeySetSerializedForm(ImmutableMap<K, ?> immutableMap) {
            this.s = immutableMap;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return this.s.keySet();
        }
    }

    ImmutableMapKeySet(ImmutableMap<K, V> immutableMap) {
        this.Y2 = immutableMap;
    }

    public boolean contains(@CheckForNull Object obj) {
        return this.Y2.containsKey(obj);
    }

    /* access modifiers changed from: package-private */
    public K get(int i2) {
        return this.Y2.entrySet().b().get(i2).getKey();
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return true;
    }

    /* renamed from: k */
    public UnmodifiableIterator<K> iterator() {
        return this.Y2.o();
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public Object n() {
        return new KeySetSerializedForm(this.Y2);
    }

    public int size() {
        return this.Y2.size();
    }
}
