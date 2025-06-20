package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    /* access modifiers changed from: private */
    public final ImmutableMap<K, V> X;

    @GwtIncompatible
    @J2ktIncompatible
    private static class SerializedForm<V> implements Serializable {
        private static final long X = 0;
        final ImmutableMap<?, V> s;

        SerializedForm(ImmutableMap<?, V> immutableMap) {
            this.s = immutableMap;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return this.s.values();
        }
    }

    ImmutableMapValues(ImmutableMap<K, V> immutableMap) {
        this.X = immutableMap;
    }

    public ImmutableList<V> b() {
        final ImmutableList<Map.Entry<K, V>> b2 = this.X.entrySet().b();
        return new ImmutableList<V>(this) {
            public V get(int i2) {
                return ((Map.Entry) b2.get(i2)).getValue();
            }

            /* access modifiers changed from: package-private */
            public boolean j() {
                return true;
            }

            public int size() {
                return b2.size();
            }
        };
    }

    public boolean contains(@CheckForNull Object obj) {
        return obj != null && Iterators.q(iterator(), obj);
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return true;
    }

    /* renamed from: k */
    public UnmodifiableIterator<V> iterator() {
        return new UnmodifiableIterator<V>() {
            final UnmodifiableIterator<Map.Entry<K, V>> s;

            {
                this.s = ImmutableMapValues.this.X.entrySet().iterator();
            }

            public boolean hasNext() {
                return this.s.hasNext();
            }

            public V next() {
                return this.s.next().getValue();
            }
        };
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public Object n() {
        return new SerializedForm(this.X);
    }

    public int size() {
        return this.X.size();
    }
}
