package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {
    @GwtIncompatible
    @J2ktIncompatible
    private static final long d3 = 0;
    /* access modifiers changed from: private */
    @CheckForNull
    public transient Node<K, V> Y2;
    /* access modifiers changed from: private */
    @CheckForNull
    public transient Node<K, V> Z2;
    /* access modifiers changed from: private */
    public transient Map<K, KeyList<K, V>> a3;
    /* access modifiers changed from: private */
    public transient int b3;
    /* access modifiers changed from: private */
    public transient int c3;

    private class DistinctKeyIterator implements Iterator<K> {
        @CheckForNull
        Node<K, V> X;
        @CheckForNull
        Node<K, V> Y;
        int Z;
        final Set<K> s;

        private DistinctKeyIterator() {
            this.s = Sets.y(LinkedListMultimap.this.keySet().size());
            this.X = LinkedListMultimap.this.Y2;
            this.Z = LinkedListMultimap.this.c3;
        }

        private void a() {
            if (LinkedListMultimap.this.c3 != this.Z) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            a();
            return this.X != null;
        }

        @ParametricNullness
        public K next() {
            Node<K, V> node;
            a();
            Node<K, V> node2 = this.X;
            if (node2 != null) {
                this.Y = node2;
                this.s.add(node2.s);
                do {
                    node = this.X.Y;
                    this.X = node;
                    if (node == null || this.s.add(node.s)) {
                    }
                    node = this.X.Y;
                    this.X = node;
                    break;
                } while (this.s.add(node.s));
                return this.Y.s;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            a();
            Preconditions.h0(this.Y != null, "no calls to next() since the last call to remove()");
            LinkedListMultimap.this.D(this.Y.s);
            this.Y = null;
            this.Z = LinkedListMultimap.this.c3;
        }
    }

    private static class KeyList<K, V> {

        /* renamed from: a  reason: collision with root package name */
        Node<K, V> f22427a;

        /* renamed from: b  reason: collision with root package name */
        Node<K, V> f22428b;

        /* renamed from: c  reason: collision with root package name */
        int f22429c = 1;

        KeyList(Node<K, V> node) {
            this.f22427a = node;
            this.f22428b = node;
            node.Y2 = null;
            node.X2 = null;
        }
    }

    private static final class Node<K, V> extends AbstractMapEntry<K, V> {
        @ParametricNullness
        V X;
        @CheckForNull
        Node<K, V> X2;
        @CheckForNull
        Node<K, V> Y;
        @CheckForNull
        Node<K, V> Y2;
        @CheckForNull
        Node<K, V> Z;
        @ParametricNullness
        final K s;

        Node(@ParametricNullness K k2, @ParametricNullness V v) {
            this.s = k2;
            this.X = v;
        }

        @ParametricNullness
        public K getKey() {
            return this.s;
        }

        @ParametricNullness
        public V getValue() {
            return this.X;
        }

        @ParametricNullness
        public V setValue(@ParametricNullness V v) {
            V v2 = this.X;
            this.X = v;
            return v2;
        }
    }

    private class NodeIterator implements ListIterator<Map.Entry<K, V>> {
        @CheckForNull
        Node<K, V> X;
        int X2;
        @CheckForNull
        Node<K, V> Y;
        @CheckForNull
        Node<K, V> Z;
        int s;

        NodeIterator(int i2) {
            this.X2 = LinkedListMultimap.this.c3;
            int size = LinkedListMultimap.this.size();
            Preconditions.d0(i2, size);
            if (i2 < size / 2) {
                this.X = LinkedListMultimap.this.Y2;
                while (true) {
                    int i3 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    next();
                    i2 = i3;
                }
            } else {
                this.Z = LinkedListMultimap.this.Z2;
                this.s = size;
                while (true) {
                    int i4 = i2 + 1;
                    if (i2 >= size) {
                        break;
                    }
                    previous();
                    i2 = i4;
                }
            }
            this.Y = null;
        }

        private void b() {
            if (LinkedListMultimap.this.c3 != this.X2) {
                throw new ConcurrentModificationException();
            }
        }

        /* renamed from: a */
        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        /* renamed from: c */
        public Node<K, V> next() {
            b();
            Node<K, V> node = this.X;
            if (node != null) {
                this.Y = node;
                this.Z = node;
                this.X = node.Y;
                this.s++;
                return node;
            }
            throw new NoSuchElementException();
        }

        @CanIgnoreReturnValue
        /* renamed from: d */
        public Node<K, V> previous() {
            b();
            Node<K, V> node = this.Z;
            if (node != null) {
                this.Y = node;
                this.X = node;
                this.Z = node.Z;
                this.s--;
                return node;
            }
            throw new NoSuchElementException();
        }

        /* renamed from: e */
        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public void f(@ParametricNullness V v) {
            Preconditions.g0(this.Y != null);
            this.Y.X = v;
        }

        public boolean hasNext() {
            b();
            return this.X != null;
        }

        public boolean hasPrevious() {
            b();
            return this.Z != null;
        }

        public int nextIndex() {
            return this.s;
        }

        public int previousIndex() {
            return this.s - 1;
        }

        public void remove() {
            b();
            Preconditions.h0(this.Y != null, "no calls to next() since the last call to remove()");
            Node<K, V> node = this.Y;
            if (node != this.X) {
                this.Z = node.Z;
                this.s--;
            } else {
                this.X = node.Y;
            }
            LinkedListMultimap.this.E(node);
            this.Y = null;
            this.X2 = LinkedListMultimap.this.c3;
        }
    }

    private class ValueForKeyIterator implements ListIterator<V> {
        int X;
        @CheckForNull
        Node<K, V> X2;
        @CheckForNull
        Node<K, V> Y;
        @CheckForNull
        Node<K, V> Z;
        @ParametricNullness
        final K s;

        ValueForKeyIterator(@ParametricNullness K k2) {
            this.s = k2;
            KeyList keyList = (KeyList) LinkedListMultimap.this.a3.get(k2);
            this.Y = keyList == null ? null : keyList.f22427a;
        }

        public void add(@ParametricNullness V v) {
            this.X2 = LinkedListMultimap.this.u(this.s, v, this.Y);
            this.X++;
            this.Z = null;
        }

        public boolean hasNext() {
            return this.Y != null;
        }

        public boolean hasPrevious() {
            return this.X2 != null;
        }

        @ParametricNullness
        @CanIgnoreReturnValue
        public V next() {
            Node<K, V> node = this.Y;
            if (node != null) {
                this.Z = node;
                this.X2 = node;
                this.Y = node.X2;
                this.X++;
                return node.X;
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.X;
        }

        @ParametricNullness
        @CanIgnoreReturnValue
        public V previous() {
            Node<K, V> node = this.X2;
            if (node != null) {
                this.Z = node;
                this.Y = node;
                this.X2 = node.Y2;
                this.X--;
                return node.X;
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.X - 1;
        }

        public void remove() {
            Preconditions.h0(this.Z != null, "no calls to next() since the last call to remove()");
            Node<K, V> node = this.Z;
            if (node != this.Y) {
                this.X2 = node.Y2;
                this.X--;
            } else {
                this.Y = node.X2;
            }
            LinkedListMultimap.this.E(node);
            this.Z = null;
        }

        public void set(@ParametricNullness V v) {
            Preconditions.g0(this.Z != null);
            this.Z.X = v;
        }

        public ValueForKeyIterator(@ParametricNullness K k2, int i2) {
            KeyList keyList = (KeyList) LinkedListMultimap.this.a3.get(k2);
            int i3 = keyList == null ? 0 : keyList.f22429c;
            Preconditions.d0(i2, i3);
            if (i2 < i3 / 2) {
                this.Y = keyList == null ? null : keyList.f22427a;
                while (true) {
                    int i4 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    next();
                    i2 = i4;
                }
            } else {
                this.X2 = keyList == null ? null : keyList.f22428b;
                this.X = i3;
                while (true) {
                    int i5 = i2 + 1;
                    if (i2 >= i3) {
                        break;
                    }
                    previous();
                    i2 = i5;
                }
            }
            this.s = k2;
            this.Z = null;
        }
    }

    LinkedListMultimap() {
        this(12);
    }

    private List<V> B(@ParametricNullness K k2) {
        return Collections.unmodifiableList(Lists.s(new ValueForKeyIterator(k2)));
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void C(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.a3 = CompactLinkedHashMap.i0();
        int readInt = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* access modifiers changed from: private */
    public void D(@ParametricNullness K k2) {
        Iterators.h(new ValueForKeyIterator(k2));
    }

    /* access modifiers changed from: private */
    public void E(Node<K, V> node) {
        Node<K, V> node2 = node.Z;
        Node<K, V> node3 = node.Y;
        if (node2 != null) {
            node2.Y = node3;
        } else {
            this.Y2 = node3;
        }
        Node<K, V> node4 = node.Y;
        if (node4 != null) {
            node4.Z = node2;
        } else {
            this.Z2 = node2;
        }
        if (node.Y2 == null && node.X2 == null) {
            KeyList remove = this.a3.remove(node.s);
            Objects.requireNonNull(remove);
            remove.f22429c = 0;
            this.c3++;
        } else {
            KeyList keyList = this.a3.get(node.s);
            Objects.requireNonNull(keyList);
            keyList.f22429c--;
            Node<K, V> node5 = node.Y2;
            if (node5 == null) {
                Node<K, V> node6 = node.X2;
                Objects.requireNonNull(node6);
                keyList.f22427a = node6;
            } else {
                node5.X2 = node.X2;
            }
            Node<K, V> node7 = node.X2;
            Node<K, V> node8 = node.Y2;
            if (node7 == null) {
                Objects.requireNonNull(node8);
                keyList.f22428b = node8;
            } else {
                node7.Y2 = node8;
            }
        }
        this.b3--;
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void H(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry entry : j()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Node<K, V> u(@ParametricNullness K k2, @ParametricNullness V v, @CheckForNull Node<K, V> node) {
        Map<K, KeyList<K, V>> map;
        KeyList keyList;
        Node<K, V> node2 = new Node<>(k2, v);
        if (this.Y2 == null) {
            this.Z2 = node2;
            this.Y2 = node2;
            map = this.a3;
            keyList = new KeyList(node2);
        } else {
            if (node == null) {
                Node<K, V> node3 = this.Z2;
                Objects.requireNonNull(node3);
                node3.Y = node2;
                node2.Z = this.Z2;
                this.Z2 = node2;
                KeyList keyList2 = this.a3.get(k2);
                if (keyList2 == null) {
                    map = this.a3;
                    keyList = new KeyList(node2);
                } else {
                    keyList2.f22429c++;
                    Node<K, V> node4 = keyList2.f22428b;
                    node4.X2 = node2;
                    node2.Y2 = node4;
                    keyList2.f22428b = node2;
                }
            } else {
                KeyList keyList3 = this.a3.get(k2);
                Objects.requireNonNull(keyList3);
                keyList3.f22429c++;
                node2.Z = node.Z;
                node2.Y2 = node.Y2;
                node2.Y = node;
                node2.X2 = node;
                Node<K, V> node5 = node.Y2;
                if (node5 == null) {
                    keyList3.f22427a = node2;
                } else {
                    node5.X2 = node2;
                }
                Node<K, V> node6 = node.Z;
                if (node6 == null) {
                    this.Y2 = node2;
                } else {
                    node6.Y = node2;
                }
                node.Z = node2;
                node.Y2 = node2;
            }
            this.b3++;
            return node2;
        }
        map.put(k2, keyList);
        this.c3++;
        this.b3++;
        return node2;
    }

    public static <K, V> LinkedListMultimap<K, V> v() {
        return new LinkedListMultimap<>();
    }

    public static <K, V> LinkedListMultimap<K, V> w(int i2) {
        return new LinkedListMultimap<>(i2);
    }

    public static <K, V> LinkedListMultimap<K, V> x(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    /* renamed from: A */
    public List<Map.Entry<K, V>> j() {
        return (List) super.j();
    }

    /* renamed from: F */
    public List<V> values() {
        return (List) super.values();
    }

    public /* bridge */ /* synthetic */ boolean N0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.N0(obj, obj2);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean T0(@ParametricNullness Object obj, Iterable iterable) {
        return super.T0(obj, iterable);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean Z(Multimap multimap) {
        return super.Z(multimap);
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> a() {
        return new Multimaps.AsMap(this);
    }

    public void clear() {
        this.Y2 = null;
        this.Z2 = null;
        this.a3.clear();
        this.b3 = 0;
        this.c3++;
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return this.a3.containsKey(obj);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public /* bridge */ /* synthetic */ Multiset d0() {
        return super.d0();
    }

    /* access modifiers changed from: package-private */
    public Set<K> e() {
        return new Sets.ImprovedAbstractSet<K>() {
            public boolean contains(@CheckForNull Object obj) {
                return LinkedListMultimap.this.containsKey(obj);
            }

            public Iterator<K> iterator() {
                return new DistinctKeyIterator();
            }

            public boolean remove(@CheckForNull Object obj) {
                return !LinkedListMultimap.this.b(obj).isEmpty();
            }

            public int size() {
                return LinkedListMultimap.this.a3.size();
            }
        };
    }

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: package-private */
    public Multiset<K> f() {
        return new Multimaps.Keys(this);
    }

    public /* bridge */ /* synthetic */ Map g() {
        return super.g();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> i() {
        throw new AssertionError("should never be called");
    }

    public boolean isEmpty() {
        return this.Y2 == null;
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @CanIgnoreReturnValue
    public boolean put(@ParametricNullness K k2, @ParametricNullness V v) {
        u(k2, v, (Node) null);
        return true;
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    public int size() {
        return this.b3;
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public List<Map.Entry<K, V>> d() {
        return new AbstractSequentialList<Map.Entry<K, V>>() {
            public ListIterator<Map.Entry<K, V>> listIterator(int i2) {
                return new NodeIterator(i2);
            }

            public int size() {
                return LinkedListMultimap.this.b3;
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public List<V> h() {
        return new AbstractSequentialList<V>() {
            public ListIterator<V> listIterator(int i2) {
                final NodeIterator nodeIterator = new NodeIterator(i2);
                return new TransformedListIterator<Map.Entry<K, V>, V>(this, nodeIterator) {
                    /* access modifiers changed from: package-private */
                    @ParametricNullness
                    /* renamed from: c */
                    public V a(Map.Entry<K, V> entry) {
                        return entry.getValue();
                    }

                    public void set(@ParametricNullness V v) {
                        nodeIterator.f(v);
                    }
                };
            }

            public int size() {
                return LinkedListMultimap.this.b3;
            }
        };
    }

    private LinkedListMultimap(int i2) {
        this.a3 = Platform.d(i2);
    }

    @CanIgnoreReturnValue
    public List<V> b(@CheckForNull Object obj) {
        List<V> B = B(obj);
        D(obj);
        return B;
    }

    @CanIgnoreReturnValue
    public List<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        List<V> B = B(k2);
        ValueForKeyIterator valueForKeyIterator = new ValueForKeyIterator(k2);
        Iterator<? extends V> it2 = iterable.iterator();
        while (valueForKeyIterator.hasNext() && it2.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.set(it2.next());
        }
        while (valueForKeyIterator.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.remove();
        }
        while (it2.hasNext()) {
            valueForKeyIterator.add(it2.next());
        }
        return B;
    }

    public List<V> get(@ParametricNullness final K k2) {
        return new AbstractSequentialList<V>() {
            public ListIterator<V> listIterator(int i2) {
                return new ValueForKeyIterator(k2, i2);
            }

            public int size() {
                KeyList keyList = (KeyList) LinkedListMultimap.this.a3.get(k2);
                if (keyList == null) {
                    return 0;
                }
                return keyList.f22429c;
            }
        };
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        Z(multimap);
    }
}
