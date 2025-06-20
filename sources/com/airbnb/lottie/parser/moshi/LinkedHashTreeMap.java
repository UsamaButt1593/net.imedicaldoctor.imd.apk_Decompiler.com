package com.airbnb.lottie.parser.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Comparator<Comparable> b3 = new Comparator<Comparable>() {
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    static final /* synthetic */ boolean c3 = false;
    Node<K, V>[] X;
    int X2;
    final Node<K, V> Y;
    int Y2;
    int Z;
    private LinkedHashTreeMap<K, V>.EntrySet Z2;
    private LinkedHashTreeMap<K, V>.KeySet a3;
    Comparator<? super K> s;

    static final class AvlBuilder<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private Node<K, V> f17337a;

        /* renamed from: b  reason: collision with root package name */
        private int f17338b;

        /* renamed from: c  reason: collision with root package name */
        private int f17339c;

        /* renamed from: d  reason: collision with root package name */
        private int f17340d;

        AvlBuilder() {
        }

        /* access modifiers changed from: package-private */
        public void a(Node<K, V> node) {
            node.Y = null;
            node.s = null;
            node.X = null;
            node.b3 = 1;
            int i2 = this.f17338b;
            if (i2 > 0) {
                int i3 = this.f17340d;
                if ((i3 & 1) == 0) {
                    this.f17340d = i3 + 1;
                    this.f17338b = i2 - 1;
                    this.f17339c++;
                }
            }
            node.s = this.f17337a;
            this.f17337a = node;
            int i4 = this.f17340d;
            int i5 = i4 + 1;
            this.f17340d = i5;
            int i6 = this.f17338b;
            if (i6 > 0 && (i5 & 1) == 0) {
                this.f17340d = i4 + 2;
                this.f17338b = i6 - 1;
                this.f17339c++;
            }
            int i7 = 4;
            while (true) {
                int i8 = i7 - 1;
                if ((this.f17340d & i8) == i8) {
                    int i9 = this.f17339c;
                    if (i9 == 0) {
                        Node<K, V> node2 = this.f17337a;
                        Node<K, V> node3 = node2.s;
                        Node<K, V> node4 = node3.s;
                        node3.s = node4.s;
                        this.f17337a = node3;
                        node3.X = node4;
                        node3.Y = node2;
                        node3.b3 = node2.b3 + 1;
                        node4.s = node3;
                        node2.s = node3;
                    } else {
                        if (i9 == 1) {
                            Node<K, V> node5 = this.f17337a;
                            Node<K, V> node6 = node5.s;
                            this.f17337a = node6;
                            node6.Y = node5;
                            node6.b3 = node5.b3 + 1;
                            node5.s = node6;
                        } else if (i9 != 2) {
                        }
                        this.f17339c = 0;
                    }
                    i7 *= 2;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            this.f17338b = ((Integer.highestOneBit(i2) * 2) - 1) - i2;
            this.f17340d = 0;
            this.f17339c = 0;
            this.f17337a = null;
        }

        /* access modifiers changed from: package-private */
        public Node<K, V> c() {
            Node<K, V> node = this.f17337a;
            if (node.s == null) {
                return node;
            }
            throw new IllegalStateException();
        }
    }

    static class AvlIterator<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private Node<K, V> f17341a;

        AvlIterator() {
        }

        public Node<K, V> a() {
            Node<K, V> node = this.f17341a;
            if (node == null) {
                return null;
            }
            Node<K, V> node2 = node.s;
            node.s = null;
            Node<K, V> node3 = node.Y;
            while (true) {
                Node<K, V> node4 = node2;
                node2 = node3;
                Node<K, V> node5 = node4;
                if (node2 != null) {
                    node2.s = node5;
                    node3 = node2.X;
                } else {
                    this.f17341a = node5;
                    return node;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(Node<K, V> node) {
            Node<K, V> node2 = null;
            while (node != null) {
                node.s = node2;
                node2 = node;
                node = node.X;
            }
            this.f17341a = node2;
        }
    }

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.e((Map.Entry) obj) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() {
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                /* renamed from: b */
                public Map.Entry<K, V> next() {
                    return a();
                }
            };
        }

        public boolean remove(Object obj) {
            Node e2;
            if (!(obj instanceof Map.Entry) || (e2 = LinkedHashTreeMap.this.e((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.h(e2, true);
            return true;
        }

        public int size() {
            return LinkedHashTreeMap.this.Z;
        }
    }

    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K>() {
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                public K next() {
                    return a().Y2;
                }
            };
        }

        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.i(obj) != null;
        }

        public int size() {
            return LinkedHashTreeMap.this.Z;
        }
    }

    abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        Node<K, V> X = null;
        int Y;
        Node<K, V> s;

        LinkedTreeMapIterator() {
            this.s = LinkedHashTreeMap.this.Y.Z;
            this.Y = LinkedHashTreeMap.this.X2;
        }

        /* access modifiers changed from: package-private */
        public final Node<K, V> a() {
            Node<K, V> node = this.s;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (node == linkedHashTreeMap.Y) {
                throw new NoSuchElementException();
            } else if (linkedHashTreeMap.X2 == this.Y) {
                this.s = node.Z;
                this.X = node;
                return node;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            return this.s != LinkedHashTreeMap.this.Y;
        }

        public final void remove() {
            Node<K, V> node = this.X;
            if (node != null) {
                LinkedHashTreeMap.this.h(node, true);
                this.X = null;
                this.Y = LinkedHashTreeMap.this.X2;
                return;
            }
            throw new IllegalStateException();
        }
    }

    static final class Node<K, V> implements Map.Entry<K, V> {
        Node<K, V> X;
        Node<K, V> X2;
        Node<K, V> Y;
        final K Y2;
        Node<K, V> Z;
        final int Z2;
        V a3;
        int b3;
        Node<K, V> s;

        Node() {
            this.Y2 = null;
            this.Z2 = -1;
            this.X2 = this;
            this.Z = this;
        }

        public Node<K, V> a() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.X; node2 != null; node2 = node2.X) {
                node = node2;
            }
            return node;
        }

        public Node<K, V> b() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.Y; node2 != null; node2 = node2.Y) {
                node = node2;
            }
            return node;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x002e
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.Y2
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x002e
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x002e
            L_0x001c:
                V r0 = r3.a3
                java.lang.Object r4 = r4.getValue()
                if (r0 != 0) goto L_0x0027
                if (r4 != 0) goto L_0x002e
                goto L_0x002d
            L_0x0027:
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x002e
            L_0x002d:
                r1 = 1
            L_0x002e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node.equals(java.lang.Object):boolean");
        }

        public K getKey() {
            return this.Y2;
        }

        public V getValue() {
            return this.a3;
        }

        public int hashCode() {
            K k2 = this.Y2;
            int i2 = 0;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.a3;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        public V setValue(V v) {
            V v2 = this.a3;
            this.a3 = v;
            return v2;
        }

        public String toString() {
            return this.Y2 + "=" + this.a3;
        }

        Node(Node<K, V> node, K k2, int i2, Node<K, V> node2, Node<K, V> node3) {
            this.s = node;
            this.Y2 = k2;
            this.Z2 = i2;
            this.b3 = 1;
            this.Z = node2;
            this.X2 = node3;
            node3.Z = this;
            node2.X2 = this;
        }
    }

    LinkedHashTreeMap() {
        this((Comparator) null);
    }

    private void a() {
        Node<K, V>[] b2 = b(this.X);
        this.X = b2;
        this.Y2 = (b2.length / 2) + (b2.length / 4);
    }

    static <K, V> Node<K, V>[] b(Node<K, V>[] nodeArr) {
        int length = nodeArr.length;
        Node<K, V>[] nodeArr2 = new Node[(length * 2)];
        AvlIterator avlIterator = new AvlIterator();
        AvlBuilder avlBuilder = new AvlBuilder();
        AvlBuilder avlBuilder2 = new AvlBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            Node<K, V> node = nodeArr[i2];
            if (node != null) {
                avlIterator.b(node);
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    Node a2 = avlIterator.a();
                    if (a2 == null) {
                        break;
                    } else if ((a2.Z2 & length) == 0) {
                        i3++;
                    } else {
                        i4++;
                    }
                }
                avlBuilder.b(i3);
                avlBuilder2.b(i4);
                avlIterator.b(node);
                while (true) {
                    Node a4 = avlIterator.a();
                    if (a4 == null) {
                        break;
                    } else if ((a4.Z2 & length) == 0) {
                        avlBuilder.a(a4);
                    } else {
                        avlBuilder2.a(a4);
                    }
                }
                Node<K, V> node2 = null;
                nodeArr2[i2] = i3 > 0 ? avlBuilder.c() : null;
                int i5 = i2 + length;
                if (i4 > 0) {
                    node2 = avlBuilder2.c();
                }
                nodeArr2[i5] = node2;
            }
        }
        return nodeArr2;
    }

    private boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void g(Node<K, V> node, boolean z) {
        while (node != null) {
            Node<K, V> node2 = node.X;
            Node<K, V> node3 = node.Y;
            int i2 = 0;
            int i3 = node2 != null ? node2.b3 : 0;
            int i4 = node3 != null ? node3.b3 : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                Node<K, V> node4 = node3.X;
                Node<K, V> node5 = node3.Y;
                int i6 = node5 != null ? node5.b3 : 0;
                if (node4 != null) {
                    i2 = node4.b3;
                }
                int i7 = i2 - i6;
                if (i7 != -1 && (i7 != 0 || z)) {
                    l(node3);
                }
                k(node);
                if (z) {
                    return;
                }
            } else if (i5 == 2) {
                Node<K, V> node6 = node2.X;
                Node<K, V> node7 = node2.Y;
                int i8 = node7 != null ? node7.b3 : 0;
                if (node6 != null) {
                    i2 = node6.b3;
                }
                int i9 = i2 - i8;
                if (i9 != 1 && (i9 != 0 || z)) {
                    k(node2);
                }
                l(node);
                if (z) {
                    return;
                }
            } else if (i5 == 0) {
                node.b3 = i3 + 1;
                if (z) {
                    return;
                }
            } else {
                node.b3 = Math.max(i3, i4) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.s;
        }
    }

    private void j(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.s;
        node.s = null;
        if (node2 != null) {
            node2.s = node3;
        }
        if (node3 == null) {
            int i2 = node.Z2;
            Node<K, V>[] nodeArr = this.X;
            nodeArr[i2 & (nodeArr.length - 1)] = node2;
        } else if (node3.X == node) {
            node3.X = node2;
        } else {
            node3.Y = node2;
        }
    }

    private void k(Node<K, V> node) {
        Node<K, V> node2 = node.X;
        Node<K, V> node3 = node.Y;
        Node<K, V> node4 = node3.X;
        Node<K, V> node5 = node3.Y;
        node.Y = node4;
        if (node4 != null) {
            node4.s = node;
        }
        j(node, node3);
        node3.X = node;
        node.s = node3;
        int i2 = 0;
        int max = Math.max(node2 != null ? node2.b3 : 0, node4 != null ? node4.b3 : 0) + 1;
        node.b3 = max;
        if (node5 != null) {
            i2 = node5.b3;
        }
        node3.b3 = Math.max(max, i2) + 1;
    }

    private void l(Node<K, V> node) {
        Node<K, V> node2 = node.X;
        Node<K, V> node3 = node.Y;
        Node<K, V> node4 = node2.X;
        Node<K, V> node5 = node2.Y;
        node.X = node5;
        if (node5 != null) {
            node5.s = node;
        }
        j(node, node2);
        node2.Y = node;
        node.s = node2;
        int i2 = 0;
        int max = Math.max(node3 != null ? node3.b3 : 0, node5 != null ? node5.b3 : 0) + 1;
        node.b3 = max;
        if (node4 != null) {
            i2 = node4.b3;
        }
        node2.b3 = Math.max(max, i2) + 1;
    }

    private static int m(int i2) {
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    private Object n() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public void clear() {
        Arrays.fill(this.X, (Object) null);
        this.Z = 0;
        this.X2++;
        Node<K, V> node = this.Y;
        Node<K, V> node2 = node.Z;
        while (node2 != node) {
            Node<K, V> node3 = node2.Z;
            node2.X2 = null;
            node2.Z = null;
            node2 = node3;
        }
        node.X2 = node;
        node.Z = node;
    }

    public boolean containsKey(Object obj) {
        return f(obj) != null;
    }

    /* access modifiers changed from: package-private */
    public Node<K, V> d(K k2, boolean z) {
        int i2;
        Node<K, V> node;
        Node<K, V> node2;
        Comparator<? super K> comparator = this.s;
        Node<K, V>[] nodeArr = this.X;
        int m2 = m(k2.hashCode());
        int length = (nodeArr.length - 1) & m2;
        Node<K, V> node3 = nodeArr[length];
        if (node3 != null) {
            Comparable comparable = comparator == b3 ? (Comparable) k2 : null;
            while (true) {
                K k3 = node3.Y2;
                int compareTo = comparable != null ? comparable.compareTo(k3) : comparator.compare(k2, k3);
                if (compareTo == 0) {
                    return node3;
                }
                Node<K, V> node4 = compareTo < 0 ? node3.X : node3.Y;
                if (node4 == null) {
                    node = node3;
                    i2 = compareTo;
                    break;
                }
                node3 = node4;
            }
        } else {
            node = node3;
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        Node<K, V> node5 = this.Y;
        if (node != null) {
            node2 = new Node<>(node, k2, m2, node5, node5.X2);
            if (i2 < 0) {
                node.X = node2;
            } else {
                node.Y = node2;
            }
            g(node, true);
        } else if (comparator != b3 || (k2 instanceof Comparable)) {
            node2 = new Node<>(node, k2, m2, node5, node5.X2);
            nodeArr[length] = node2;
        } else {
            throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
        }
        int i3 = this.Z;
        this.Z = i3 + 1;
        if (i3 > this.Y2) {
            a();
        }
        this.X2++;
        return node2;
    }

    /* access modifiers changed from: package-private */
    public Node<K, V> e(Map.Entry<?, ?> entry) {
        Node<K, V> f2 = f(entry.getKey());
        if (f2 == null || !c(f2.a3, entry.getValue())) {
            return null;
        }
        return f2;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.EntrySet entrySet = this.Z2;
        if (entrySet != null) {
            return entrySet;
        }
        LinkedHashTreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
        this.Z2 = entrySet2;
        return entrySet2;
    }

    /* access modifiers changed from: package-private */
    public Node<K, V> f(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return d(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public V get(Object obj) {
        Node f2 = f(obj);
        if (f2 != null) {
            return f2.a3;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void h(Node<K, V> node, boolean z) {
        int i2;
        if (z) {
            Node<K, V> node2 = node.X2;
            node2.Z = node.Z;
            node.Z.X2 = node2;
            node.X2 = null;
            node.Z = null;
        }
        Node<K, V> node3 = node.X;
        Node<K, V> node4 = node.Y;
        Node<K, V> node5 = node.s;
        int i3 = 0;
        if (node3 == null || node4 == null) {
            if (node3 != null) {
                j(node, node3);
                node.X = null;
            } else if (node4 != null) {
                j(node, node4);
                node.Y = null;
            } else {
                j(node, (Node<K, V>) null);
            }
            g(node5, false);
            this.Z--;
            this.X2++;
            return;
        }
        Node<K, V> b2 = node3.b3 > node4.b3 ? node3.b() : node4.a();
        h(b2, false);
        Node<K, V> node6 = node.X;
        if (node6 != null) {
            i2 = node6.b3;
            b2.X = node6;
            node6.s = b2;
            node.X = null;
        } else {
            i2 = 0;
        }
        Node<K, V> node7 = node.Y;
        if (node7 != null) {
            i3 = node7.b3;
            b2.Y = node7;
            node7.s = b2;
            node.Y = null;
        }
        b2.b3 = Math.max(i2, i3) + 1;
        j(node, b2);
    }

    /* access modifiers changed from: package-private */
    public Node<K, V> i(Object obj) {
        Node<K, V> f2 = f(obj);
        if (f2 != null) {
            h(f2, true);
        }
        return f2;
    }

    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.KeySet keySet = this.a3;
        if (keySet != null) {
            return keySet;
        }
        LinkedHashTreeMap<K, V>.KeySet keySet2 = new KeySet();
        this.a3 = keySet2;
        return keySet2;
    }

    public V put(K k2, V v) {
        if (k2 != null) {
            Node d2 = d(k2, true);
            V v2 = d2.a3;
            d2.a3 = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public V remove(Object obj) {
        Node i2 = i(obj);
        if (i2 != null) {
            return i2.a3;
        }
        return null;
    }

    public int size() {
        return this.Z;
    }

    LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.Z = 0;
        this.X2 = 0;
        this.s = comparator == null ? b3 : comparator;
        this.Y = new Node<>();
        Node<K, V>[] nodeArr = new Node[16];
        this.X = nodeArr;
        this.Y2 = (nodeArr.length / 2) + (nodeArr.length / 4);
    }
}
