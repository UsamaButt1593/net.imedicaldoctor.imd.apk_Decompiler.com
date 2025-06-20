package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    @Nullable
    ArrayMap<K, V>.EntrySet f3;
    @Nullable
    ArrayMap<K, V>.KeySet g3;
    @Nullable
    ArrayMap<K, V>.ValueCollection h3;

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
        }

        public int size() {
            return ArrayMap.this.Y;
        }
    }

    final class KeyIterator extends IndexBasedArrayIterator<K> {
        KeyIterator() {
            super(ArrayMap.this.Y);
        }

        /* access modifiers changed from: protected */
        public K a(int i2) {
            return ArrayMap.this.i(i2);
        }

        /* access modifiers changed from: protected */
        public void b(int i2) {
            ArrayMap.this.k(i2);
        }
    }

    final class KeySet implements Set<K> {
        KeySet() {
        }

        public boolean add(K k2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            ArrayMap.this.clear();
        }

        public boolean contains(Object obj) {
            return ArrayMap.this.containsKey(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return ArrayMap.this.n(collection);
        }

        public boolean equals(Object obj) {
            return ArrayMap.o(this, obj);
        }

        public int hashCode() {
            int i2 = 0;
            for (int i3 = ArrayMap.this.Y - 1; i3 >= 0; i3--) {
                Object i4 = ArrayMap.this.i(i3);
                i2 += i4 == null ? 0 : i4.hashCode();
            }
            return i2;
        }

        public boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        public boolean remove(Object obj) {
            int f2 = ArrayMap.this.f(obj);
            if (f2 < 0) {
                return false;
            }
            ArrayMap.this.k(f2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return ArrayMap.this.p(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return ArrayMap.this.s(collection);
        }

        public int size() {
            return ArrayMap.this.Y;
        }

        public Object[] toArray() {
            int i2 = ArrayMap.this.Y;
            Object[] objArr = new Object[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = ArrayMap.this.i(i3);
            }
            return objArr;
        }

        public <T> T[] toArray(T[] tArr) {
            return ArrayMap.this.t(tArr, 0);
        }
    }

    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int X = -1;
        boolean Y;
        int s;

        MapIterator() {
            this.s = ArrayMap.this.Y - 1;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.X++;
                this.Y = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object obj) {
            if (!this.Y) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                return ContainerHelpers.c(entry.getKey(), ArrayMap.this.i(this.X)) && ContainerHelpers.c(entry.getValue(), ArrayMap.this.m(this.X));
            }
        }

        public K getKey() {
            if (this.Y) {
                return ArrayMap.this.i(this.X);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.Y) {
                return ArrayMap.this.m(this.X);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.X < this.s;
        }

        public int hashCode() {
            if (this.Y) {
                Object i2 = ArrayMap.this.i(this.X);
                Object m2 = ArrayMap.this.m(this.X);
                int i3 = 0;
                int hashCode = i2 == null ? 0 : i2.hashCode();
                if (m2 != null) {
                    i3 = m2.hashCode();
                }
                return hashCode ^ i3;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.Y) {
                ArrayMap.this.k(this.X);
                this.X--;
                this.s--;
                this.Y = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.Y) {
                return ArrayMap.this.l(this.X, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class ValueCollection implements Collection<V> {
        ValueCollection() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            ArrayMap.this.clear();
        }

        public boolean contains(Object obj) {
            return ArrayMap.this.h(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        public boolean remove(Object obj) {
            int h2 = ArrayMap.this.h(obj);
            if (h2 < 0) {
                return false;
            }
            ArrayMap.this.k(h2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i2 = ArrayMap.this.Y;
            int i3 = 0;
            boolean z = false;
            while (i3 < i2) {
                if (collection.contains(ArrayMap.this.m(i3))) {
                    ArrayMap.this.k(i3);
                    i3--;
                    i2--;
                    z = true;
                }
                i3++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i2 = ArrayMap.this.Y;
            int i3 = 0;
            boolean z = false;
            while (i3 < i2) {
                if (!collection.contains(ArrayMap.this.m(i3))) {
                    ArrayMap.this.k(i3);
                    i3--;
                    i2--;
                    z = true;
                }
                i3++;
            }
            return z;
        }

        public int size() {
            return ArrayMap.this.Y;
        }

        public Object[] toArray() {
            int i2 = ArrayMap.this.Y;
            Object[] objArr = new Object[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = ArrayMap.this.m(i3);
            }
            return objArr;
        }

        public <T> T[] toArray(T[] tArr) {
            return ArrayMap.this.t(tArr, 1);
        }
    }

    final class ValueIterator extends IndexBasedArrayIterator<V> {
        ValueIterator() {
            super(ArrayMap.this.Y);
        }

        /* access modifiers changed from: protected */
        public V a(int i2) {
            return ArrayMap.this.m(i2);
        }

        /* access modifiers changed from: protected */
        public void b(int i2) {
            ArrayMap.this.k(i2);
        }
    }

    public ArrayMap() {
    }

    static <T> boolean o(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @NonNull
    public Set<Map.Entry<K, V>> entrySet() {
        ArrayMap<K, V>.EntrySet entrySet = this.f3;
        if (entrySet != null) {
            return entrySet;
        }
        ArrayMap<K, V>.EntrySet entrySet2 = new EntrySet();
        this.f3 = entrySet2;
        return entrySet2;
    }

    @NonNull
    public Set<K> keySet() {
        ArrayMap<K, V>.KeySet keySet = this.g3;
        if (keySet != null) {
            return keySet;
        }
        ArrayMap<K, V>.KeySet keySet2 = new KeySet();
        this.g3 = keySet2;
        return keySet2;
    }

    public boolean n(@NonNull Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public boolean p(@NonNull Collection<?> collection) {
        int i2 = this.Y;
        for (Object remove : collection) {
            remove(remove);
        }
        return i2 != this.Y;
    }

    public void putAll(@NonNull Map<? extends K, ? extends V> map) {
        c(this.Y + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public boolean s(@NonNull Collection<?> collection) {
        int i2 = this.Y;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (!collection.contains(i(i3))) {
                k(i3);
            }
        }
        return i2 != this.Y;
    }

    /* access modifiers changed from: package-private */
    public <T> T[] t(T[] tArr, int i2) {
        int i3 = this.Y;
        if (tArr.length < i3) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3);
        }
        for (int i4 = 0; i4 < i3; i4++) {
            tArr[i4] = this.X[(i4 << 1) + i2];
        }
        if (tArr.length > i3) {
            tArr[i3] = null;
        }
        return tArr;
    }

    @NonNull
    public Collection<V> values() {
        ArrayMap<K, V>.ValueCollection valueCollection = this.h3;
        if (valueCollection != null) {
            return valueCollection;
        }
        ArrayMap<K, V>.ValueCollection valueCollection2 = new ValueCollection();
        this.h3 = valueCollection2;
        return valueCollection2;
    }

    public ArrayMap(int i2) {
        super(i2);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
