package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    /* access modifiers changed from: private */
    public List<SmallSortedMap<K, V>.Entry> X;
    private volatile SmallSortedMap<K, V>.EntrySet X2;
    /* access modifiers changed from: private */
    public Map<K, V> Y;
    /* access modifiers changed from: private */
    public Map<K, V> Y2;
    private boolean Z;
    private volatile SmallSortedMap<K, V>.DescendingEntrySet Z2;
    private final int s;

    private class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> X;
        private int s;

        private DescendingEntryIterator() {
            this.s = SmallSortedMap.this.X.size();
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.X == null) {
                this.X = SmallSortedMap.this.Y2.entrySet().iterator();
            }
            return this.X;
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            Object obj;
            if (a().hasNext()) {
                obj = a().next();
            } else {
                List b2 = SmallSortedMap.this.X;
                int i2 = this.s - 1;
                this.s = i2;
                obj = b2.get(i2);
            }
            return (Map.Entry) obj;
        }

        public boolean hasNext() {
            int i2 = this.s;
            return (i2 > 0 && i2 <= SmallSortedMap.this.X.size()) || a().hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        private DescendingEntrySet() {
            super();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new DescendingEntryIterator();
        }
    }

    private static class EmptySet {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final Iterator<Object> f7247a = new Iterator<Object>() {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f7248b = new Iterable<Object>() {
            public Iterator<Object> iterator() {
                return EmptySet.f7247a;
            }
        };

        private EmptySet() {
        }

        static <T> Iterable<T> b() {
            return f7248b;
        }
    }

    private class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {
        private V X;
        private final K s;

        Entry(K k2, V v) {
            this.s = k2;
            this.X = v;
        }

        private boolean b(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        /* renamed from: a */
        public int compareTo(SmallSortedMap<K, V>.Entry entry) {
            return getKey().compareTo(entry.getKey());
        }

        /* renamed from: c */
        public K getKey() {
            return this.s;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b(this.s, entry.getKey()) && b(this.X, entry.getValue());
        }

        public V getValue() {
            return this.X;
        }

        public int hashCode() {
            K k2 = this.s;
            int i2 = 0;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.X;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        public V setValue(V v) {
            SmallSortedMap.this.g();
            V v2 = this.X;
            this.X = v;
            return v2;
        }

        public String toString() {
            return this.s + "=" + this.X;
        }

        Entry(SmallSortedMap smallSortedMap, Map.Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }
    }

    private class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private boolean X;
        private Iterator<Map.Entry<K, V>> Y;
        private int s;

        private EntryIterator() {
            this.s = -1;
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.Y == null) {
                this.Y = SmallSortedMap.this.Y.entrySet().iterator();
            }
            return this.Y;
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            this.X = true;
            int i2 = this.s + 1;
            this.s = i2;
            return (Map.Entry) (i2 < SmallSortedMap.this.X.size() ? SmallSortedMap.this.X.get(this.s) : a().next());
        }

        public boolean hasNext() {
            if (this.s + 1 >= SmallSortedMap.this.X.size()) {
                return !SmallSortedMap.this.Y.isEmpty() && a().hasNext();
            }
            return true;
        }

        public void remove() {
            if (this.X) {
                this.X = false;
                SmallSortedMap.this.g();
                if (this.s < SmallSortedMap.this.X.size()) {
                    SmallSortedMap smallSortedMap = SmallSortedMap.this;
                    int i2 = this.s;
                    this.s = i2 - 1;
                    Object unused = smallSortedMap.w(i2);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        /* renamed from: b */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            SmallSortedMap.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            SmallSortedMap.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            SmallSortedMap.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return SmallSortedMap.this.size();
        }
    }

    private SmallSortedMap(int i2) {
        this.s = i2;
        this.X = Collections.emptyList();
        this.Y = Collections.emptyMap();
        this.Y2 = Collections.emptyMap();
    }

    private int f(K k2) {
        int i2;
        int size = this.X.size();
        int i3 = size - 1;
        if (i3 >= 0) {
            int compareTo = k2.compareTo(this.X.get(i3).getKey());
            if (compareTo > 0) {
                i2 = size + 1;
                return -i2;
            } else if (compareTo == 0) {
                return i3;
            }
        }
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) / 2;
            int compareTo2 = k2.compareTo(this.X.get(i5).getKey());
            if (compareTo2 < 0) {
                i3 = i5 - 1;
            } else if (compareTo2 <= 0) {
                return i5;
            } else {
                i4 = i5 + 1;
            }
        }
        i2 = i4 + 1;
        return -i2;
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.Z) {
            throw new UnsupportedOperationException();
        }
    }

    private void i() {
        g();
        if (this.X.isEmpty() && !(this.X instanceof ArrayList)) {
            this.X = new ArrayList(this.s);
        }
    }

    private SortedMap<K, V> o() {
        g();
        if (this.Y.isEmpty() && !(this.Y instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.Y = treeMap;
            this.Y2 = treeMap.descendingMap();
        }
        return (SortedMap) this.Y;
    }

    static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> t(int i2) {
        return new SmallSortedMap<FieldDescriptorType, Object>(i2) {
            public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
                return SmallSortedMap.super.put((FieldSet.FieldDescriptorLite) obj, obj2);
            }

            public void s() {
                if (!p()) {
                    for (int i2 = 0; i2 < k(); i2++) {
                        Map.Entry j2 = j(i2);
                        if (((FieldSet.FieldDescriptorLite) j2.getKey()).M()) {
                            j2.setValue(Collections.unmodifiableList((List) j2.getValue()));
                        }
                    }
                    for (Map.Entry entry : m()) {
                        if (((FieldSet.FieldDescriptorLite) entry.getKey()).M()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                SmallSortedMap.super.s();
            }
        };
    }

    static <K extends Comparable<K>, V> SmallSortedMap<K, V> u(int i2) {
        return new SmallSortedMap<>(i2);
    }

    /* access modifiers changed from: private */
    public V w(int i2) {
        g();
        V value = this.X.remove(i2).getValue();
        if (!this.Y.isEmpty()) {
            Iterator it2 = o().entrySet().iterator();
            this.X.add(new Entry(this, (Map.Entry) it2.next()));
            it2.remove();
        }
        return value;
    }

    public void clear() {
        g();
        if (!this.X.isEmpty()) {
            this.X.clear();
        }
        if (!this.Y.isEmpty()) {
            this.Y.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.Y.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.X2 == null) {
            this.X2 = new EntrySet();
        }
        return this.X2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmallSortedMap)) {
            return super.equals(obj);
        }
        SmallSortedMap smallSortedMap = (SmallSortedMap) obj;
        int size = size();
        if (size != smallSortedMap.size()) {
            return false;
        }
        int k2 = k();
        if (k2 != smallSortedMap.k()) {
            return entrySet().equals(smallSortedMap.entrySet());
        }
        for (int i2 = 0; i2 < k2; i2++) {
            if (!j(i2).equals(smallSortedMap.j(i2))) {
                return false;
            }
        }
        if (k2 != size) {
            return this.Y.equals(smallSortedMap.Y);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int f2 = f(comparable);
        return f2 >= 0 ? this.X.get(f2).getValue() : this.Y.get(comparable);
    }

    /* access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> h() {
        if (this.Z2 == null) {
            this.Z2 = new DescendingEntrySet();
        }
        return this.Z2;
    }

    public int hashCode() {
        int k2 = k();
        int i2 = 0;
        for (int i3 = 0; i3 < k2; i3++) {
            i2 += this.X.get(i3).hashCode();
        }
        return l() > 0 ? i2 + this.Y.hashCode() : i2;
    }

    public Map.Entry<K, V> j(int i2) {
        return this.X.get(i2);
    }

    public int k() {
        return this.X.size();
    }

    public int l() {
        return this.Y.size();
    }

    public Iterable<Map.Entry<K, V>> m() {
        return this.Y.isEmpty() ? EmptySet.b() : this.Y.entrySet();
    }

    /* access modifiers changed from: package-private */
    public Iterable<Map.Entry<K, V>> n() {
        return this.Y2.isEmpty() ? EmptySet.b() : this.Y2.entrySet();
    }

    public boolean p() {
        return this.Z;
    }

    public V remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int f2 = f(comparable);
        if (f2 >= 0) {
            return w(f2);
        }
        if (this.Y.isEmpty()) {
            return null;
        }
        return this.Y.remove(comparable);
    }

    public void s() {
        if (!this.Z) {
            this.Y = this.Y.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.Y);
            this.Y2 = this.Y2.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.Y2);
            this.Z = true;
        }
    }

    public int size() {
        return this.X.size() + this.Y.size();
    }

    /* renamed from: v */
    public V put(K k2, V v) {
        g();
        int f2 = f(k2);
        if (f2 >= 0) {
            return this.X.get(f2).setValue(v);
        }
        i();
        int i2 = -(f2 + 1);
        if (i2 >= this.s) {
            return o().put(k2, v);
        }
        int size = this.X.size();
        int i3 = this.s;
        if (size == i3) {
            Entry remove = this.X.remove(i3 - 1);
            o().put(remove.getKey(), remove.getValue());
        }
        this.X.add(i2, new Entry(k2, v));
        return null;
    }
}
