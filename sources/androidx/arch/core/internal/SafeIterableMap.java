package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    private Entry<K, V> X;
    private final WeakHashMap<SupportRemove<K, V>, Boolean> Y = new WeakHashMap<>();
    private int Z = 0;
    Entry<K, V> s;

    static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        /* access modifiers changed from: package-private */
        public Entry<K, V> b(Entry<K, V> entry) {
            return entry.Z;
        }

        /* access modifiers changed from: package-private */
        public Entry<K, V> c(Entry<K, V> entry) {
            return entry.Y;
        }
    }

    private static class DescendingIterator<K, V> extends ListIterator<K, V> {
        DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        /* access modifiers changed from: package-private */
        public Entry<K, V> b(Entry<K, V> entry) {
            return entry.Y;
        }

        /* access modifiers changed from: package-private */
        public Entry<K, V> c(Entry<K, V> entry) {
            return entry.Z;
        }
    }

    static class Entry<K, V> implements Map.Entry<K, V> {
        @NonNull
        final V X;
        Entry<K, V> Y;
        Entry<K, V> Z;
        @NonNull
        final K s;

        Entry(@NonNull K k2, @NonNull V v) {
            this.s = k2;
            this.X = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.s.equals(entry.s) && this.X.equals(entry.X);
        }

        @NonNull
        public K getKey() {
            return this.s;
        }

        @NonNull
        public V getValue() {
            return this.X;
        }

        public int hashCode() {
            return this.s.hashCode() ^ this.X.hashCode();
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.s + "=" + this.X;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class IteratorWithAdditions extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        private boolean X = true;
        private Entry<K, V> s;

        IteratorWithAdditions() {
        }

        /* access modifiers changed from: package-private */
        public void a(@NonNull Entry<K, V> entry) {
            Entry<K, V> entry2 = this.s;
            if (entry == entry2) {
                Entry<K, V> entry3 = entry2.Z;
                this.s = entry3;
                this.X = entry3 == null;
            }
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            Entry<K, V> entry;
            if (this.X) {
                this.X = false;
                entry = SafeIterableMap.this.s;
            } else {
                Entry<K, V> entry2 = this.s;
                entry = entry2 != null ? entry2.Y : null;
            }
            this.s = entry;
            return this.s;
        }

        public boolean hasNext() {
            if (this.X) {
                return SafeIterableMap.this.s != null;
            }
            Entry<K, V> entry = this.s;
            return (entry == null || entry.Y == null) ? false : true;
        }
    }

    private static abstract class ListIterator<K, V> extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        Entry<K, V> X;
        Entry<K, V> s;

        ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.s = entry2;
            this.X = entry;
        }

        private Entry<K, V> e() {
            Entry<K, V> entry = this.X;
            Entry<K, V> entry2 = this.s;
            if (entry == entry2 || entry2 == null) {
                return null;
            }
            return c(entry);
        }

        public void a(@NonNull Entry<K, V> entry) {
            if (this.s == entry && entry == this.X) {
                this.X = null;
                this.s = null;
            }
            Entry<K, V> entry2 = this.s;
            if (entry2 == entry) {
                this.s = b(entry2);
            }
            if (this.X == entry) {
                this.X = e();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract Entry<K, V> b(Entry<K, V> entry);

        /* access modifiers changed from: package-private */
        public abstract Entry<K, V> c(Entry<K, V> entry);

        /* renamed from: d */
        public Map.Entry<K, V> next() {
            Entry<K, V> entry = this.X;
            this.X = e();
            return entry;
        }

        public boolean hasNext() {
            return this.X != null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class SupportRemove<K, V> {
        /* access modifiers changed from: package-private */
        public abstract void a(@NonNull Entry<K, V> entry);
    }

    @Nullable
    public Map.Entry<K, V> b() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Entry<K, V> c(K k2) {
        Entry<K, V> entry = this.s;
        while (entry != null && !entry.s.equals(k2)) {
            entry = entry.Y;
        }
        return entry;
    }

    @NonNull
    public SafeIterableMap<K, V>.IteratorWithAdditions d() {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.Y.put(iteratorWithAdditions, Boolean.FALSE);
        return iteratorWithAdditions;
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator descendingIterator = new DescendingIterator(this.X, this.s);
        this.Y.put(descendingIterator, Boolean.FALSE);
        return descendingIterator;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator it2 = iterator();
        Iterator it3 = safeIterableMap.iterator();
        while (it2.hasNext() && it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            Object next = it3.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it2.hasNext() && !it3.hasNext();
    }

    @Nullable
    public Map.Entry<K, V> g() {
        return this.X;
    }

    /* access modifiers changed from: package-private */
    public Entry<K, V> h(@NonNull K k2, @NonNull V v) {
        Entry<K, V> entry = new Entry<>(k2, v);
        this.Z++;
        Entry<K, V> entry2 = this.X;
        if (entry2 == null) {
            this.s = entry;
        } else {
            entry2.Y = entry;
            entry.Z = entry2;
        }
        this.X = entry;
        return entry;
    }

    public int hashCode() {
        Iterator it2 = iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 += ((Map.Entry) it2.next()).hashCode();
        }
        return i2;
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.s, this.X);
        this.Y.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public V j(@NonNull K k2, @NonNull V v) {
        Entry c2 = c(k2);
        if (c2 != null) {
            return c2.X;
        }
        h(k2, v);
        return null;
    }

    public V k(@NonNull K k2) {
        Entry c2 = c(k2);
        if (c2 == null) {
            return null;
        }
        this.Z--;
        if (!this.Y.isEmpty()) {
            for (SupportRemove<K, V> a2 : this.Y.keySet()) {
                a2.a(c2);
            }
        }
        Entry<K, V> entry = c2.Z;
        Entry<K, V> entry2 = c2.Y;
        if (entry != null) {
            entry.Y = entry2;
        } else {
            this.s = entry2;
        }
        Entry<K, V> entry3 = c2.Y;
        if (entry3 != null) {
            entry3.Z = entry;
        } else {
            this.X = entry;
        }
        c2.Y = null;
        c2.Z = null;
        return c2.X;
    }

    public int size() {
        return this.Z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            sb.append(((Map.Entry) it2.next()).toString());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
