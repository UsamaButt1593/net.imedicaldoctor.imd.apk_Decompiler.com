package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f22588e = new Object();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map<N, Object> f22589a;
    /* access modifiers changed from: private */
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    public final List<NodeConnection<N>> f22590b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f22591c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f22592d;

    /* renamed from: com.google.common.graph.DirectedGraphConnections$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22593a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.common.graph.ElementOrder$Type[] r0 = com.google.common.graph.ElementOrder.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22593a = r0
                com.google.common.graph.ElementOrder$Type r1 = com.google.common.graph.ElementOrder.Type.UNORDERED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22593a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.graph.ElementOrder$Type r1 = com.google.common.graph.ElementOrder.Type.STABLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.AnonymousClass5.<clinit>():void");
        }
    }

    private static abstract class NodeConnection<N> {

        /* renamed from: a  reason: collision with root package name */
        final N f22594a;

        static final class Pred<N> extends NodeConnection<N> {
            Pred(N n2) {
                super(n2);
            }

            public boolean equals(@CheckForNull Object obj) {
                if (obj instanceof Pred) {
                    return this.f22594a.equals(((Pred) obj).f22594a);
                }
                return false;
            }

            public int hashCode() {
                return Pred.class.hashCode() + this.f22594a.hashCode();
            }
        }

        static final class Succ<N> extends NodeConnection<N> {
            Succ(N n2) {
                super(n2);
            }

            public boolean equals(@CheckForNull Object obj) {
                if (obj instanceof Succ) {
                    return this.f22594a.equals(((Succ) obj).f22594a);
                }
                return false;
            }

            public int hashCode() {
                return Succ.class.hashCode() + this.f22594a.hashCode();
            }
        }

        NodeConnection(N n2) {
            this.f22594a = Preconditions.E(n2);
        }
    }

    private static final class PredAndSucc {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Object f22595a;

        PredAndSucc(Object obj) {
            this.f22595a = obj;
        }
    }

    private DirectedGraphConnections(Map<N, Object> map, @CheckForNull List<NodeConnection<N>> list, int i2, int i3) {
        this.f22589a = (Map) Preconditions.E(map);
        this.f22590b = list;
        this.f22591c = Graphs.b(i2);
        this.f22592d = Graphs.b(i3);
        Preconditions.g0(i2 <= map.size() && i3 <= map.size());
    }

    /* access modifiers changed from: private */
    public static boolean s(@CheckForNull Object obj) {
        return obj == f22588e || (obj instanceof PredAndSucc);
    }

    /* access modifiers changed from: private */
    public static boolean t(@CheckForNull Object obj) {
        return (obj == f22588e || obj == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ EndpointPair w(Object obj, NodeConnection nodeConnection) {
        boolean z = nodeConnection instanceof NodeConnection.Succ;
        N n2 = nodeConnection.f22594a;
        return z ? EndpointPair.m(obj, n2) : EndpointPair.m(n2, obj);
    }

    static <N, V> DirectedGraphConnections<N, V> x(ElementOrder<N> elementOrder) {
        ArrayList arrayList;
        int i2 = AnonymousClass5.f22593a[elementOrder.h().ordinal()];
        if (i2 == 1) {
            arrayList = null;
        } else if (i2 == 2) {
            arrayList = new ArrayList();
        } else {
            throw new AssertionError(elementOrder.h());
        }
        return new DirectedGraphConnections<>(new HashMap(4, 1.0f), arrayList, 0, 0);
    }

    static <N, V> DirectedGraphConnections<N, V> y(N n2, Iterable<EndpointPair<N>> iterable, Function<N, V> function) {
        Preconditions.E(n2);
        Preconditions.E(function);
        HashMap hashMap = new HashMap();
        ImmutableList.Builder r = ImmutableList.r();
        int i2 = 0;
        int i3 = 0;
        for (EndpointPair next : iterable) {
            if (next.g().equals(n2) && next.h().equals(n2)) {
                hashMap.put(n2, new PredAndSucc(function.apply(n2)));
                r.g(new NodeConnection.Pred(n2));
                r.g(new NodeConnection.Succ(n2));
                i2++;
            } else if (next.h().equals(n2)) {
                Object g2 = next.g();
                Object put = hashMap.put(g2, f22588e);
                if (put != null) {
                    hashMap.put(g2, new PredAndSucc(put));
                }
                r.g(new NodeConnection.Pred(g2));
                i2++;
            } else {
                Preconditions.d(next.g().equals(n2));
                Object h2 = next.h();
                V apply = function.apply(h2);
                Object put2 = hashMap.put(h2, apply);
                if (put2 != null) {
                    Preconditions.d(put2 == f22588e);
                    hashMap.put(h2, new PredAndSucc(apply));
                }
                r.g(new NodeConnection.Succ(h2));
            }
            i3++;
        }
        return new DirectedGraphConnections<>(hashMap, r.e(), i2, i3);
    }

    public Set<N> a() {
        return this.f22590b == null ? Collections.unmodifiableSet(this.f22589a.keySet()) : new AbstractSet<N>() {
            /* renamed from: b */
            public UnmodifiableIterator<N> iterator() {
                final Iterator it2 = DirectedGraphConnections.this.f22590b.iterator();
                final HashSet hashSet = new HashSet();
                return new AbstractIterator<N>(this) {
                    /* access modifiers changed from: protected */
                    @CheckForNull
                    public N a() {
                        while (it2.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it2.next();
                            if (hashSet.add(nodeConnection.f22594a)) {
                                return nodeConnection.f22594a;
                            }
                        }
                        return b();
                    }
                };
            }

            public boolean contains(@CheckForNull Object obj) {
                return DirectedGraphConnections.this.f22589a.containsKey(obj);
            }

            public int size() {
                return DirectedGraphConnections.this.f22589a.size();
            }
        };
    }

    public Set<N> b() {
        return new AbstractSet<N>() {
            /* renamed from: b */
            public UnmodifiableIterator<N> iterator() {
                if (DirectedGraphConnections.this.f22590b == null) {
                    final Iterator it2 = DirectedGraphConnections.this.f22589a.entrySet().iterator();
                    return new AbstractIterator<N>(this) {
                        /* access modifiers changed from: protected */
                        @CheckForNull
                        public N a() {
                            while (it2.hasNext()) {
                                Map.Entry entry = (Map.Entry) it2.next();
                                if (DirectedGraphConnections.t(entry.getValue())) {
                                    return entry.getKey();
                                }
                            }
                            return b();
                        }
                    };
                }
                final Iterator it3 = DirectedGraphConnections.this.f22590b.iterator();
                return new AbstractIterator<N>(this) {
                    /* access modifiers changed from: protected */
                    @CheckForNull
                    public N a() {
                        while (it3.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it3.next();
                            if (nodeConnection instanceof NodeConnection.Succ) {
                                return nodeConnection.f22594a;
                            }
                        }
                        return b();
                    }
                };
            }

            public boolean contains(@CheckForNull Object obj) {
                return DirectedGraphConnections.t(DirectedGraphConnections.this.f22589a.get(obj));
            }

            public int size() {
                return DirectedGraphConnections.this.f22592d;
            }
        };
    }

    public Set<N> c() {
        return new AbstractSet<N>() {
            /* renamed from: b */
            public UnmodifiableIterator<N> iterator() {
                if (DirectedGraphConnections.this.f22590b == null) {
                    final Iterator it2 = DirectedGraphConnections.this.f22589a.entrySet().iterator();
                    return new AbstractIterator<N>(this) {
                        /* access modifiers changed from: protected */
                        @CheckForNull
                        public N a() {
                            while (it2.hasNext()) {
                                Map.Entry entry = (Map.Entry) it2.next();
                                if (DirectedGraphConnections.s(entry.getValue())) {
                                    return entry.getKey();
                                }
                            }
                            return b();
                        }
                    };
                }
                final Iterator it3 = DirectedGraphConnections.this.f22590b.iterator();
                return new AbstractIterator<N>(this) {
                    /* access modifiers changed from: protected */
                    @CheckForNull
                    public N a() {
                        while (it3.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it3.next();
                            if (nodeConnection instanceof NodeConnection.Pred) {
                                return nodeConnection.f22594a;
                            }
                        }
                        return b();
                    }
                };
            }

            public boolean contains(@CheckForNull Object obj) {
                return DirectedGraphConnections.s(DirectedGraphConnections.this.f22589a.get(obj));
            }

            public int size() {
                return DirectedGraphConnections.this.f22591c;
            }
        };
    }

    @CheckForNull
    public V d(Object obj) {
        V v;
        Preconditions.E(obj);
        V v2 = this.f22589a.get(obj);
        if (v2 == null || v2 == (v = f22588e)) {
            v2 = null;
        } else if (v2 instanceof PredAndSucc) {
            this.f22589a.put(obj, v);
            v2 = ((PredAndSucc) v2).f22595a;
        } else {
            this.f22589a.remove(obj);
        }
        if (v2 != null) {
            int i2 = this.f22592d - 1;
            this.f22592d = i2;
            Graphs.b(i2);
            List<NodeConnection<N>> list = this.f22590b;
            if (list != null) {
                list.remove(new NodeConnection.Succ(obj));
            }
        }
        if (v2 == null) {
            return null;
        }
        return v2;
    }

    @CheckForNull
    public V e(N n2) {
        Preconditions.E(n2);
        V v = this.f22589a.get(n2);
        if (v == f22588e) {
            return null;
        }
        return v instanceof PredAndSucc ? ((PredAndSucc) v).f22595a : v;
    }

    public void f(N n2) {
        Preconditions.E(n2);
        Object obj = this.f22589a.get(n2);
        if (obj == f22588e) {
            this.f22589a.remove(n2);
        } else if (obj instanceof PredAndSucc) {
            this.f22589a.put(n2, ((PredAndSucc) obj).f22595a);
        } else {
            return;
        }
        int i2 = this.f22591c - 1;
        this.f22591c = i2;
        Graphs.b(i2);
        List<NodeConnection<N>> list = this.f22590b;
        if (list != null) {
            list.remove(new NodeConnection.Pred(n2));
        }
    }

    public Iterator<EndpointPair<N>> g(N n2) {
        Preconditions.E(n2);
        List<NodeConnection<N>> list = this.f22590b;
        final Iterator<T> j2 = list == null ? Iterators.j(Iterators.c0(c().iterator(), new h(n2)), Iterators.c0(b().iterator(), new i(n2))) : Iterators.c0(list.iterator(), new j(n2));
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        return new AbstractIterator<EndpointPair<N>>(this) {
            /* access modifiers changed from: protected */
            /* JADX WARNING: Removed duplicated region for block: B:2:0x0008  */
            @javax.annotation.CheckForNull
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.common.graph.EndpointPair<N> a() {
                /*
                    r3 = this;
                L_0x0000:
                    java.util.Iterator r0 = r4
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L_0x0028
                    java.util.Iterator r0 = r4
                    java.lang.Object r0 = r0.next()
                    com.google.common.graph.EndpointPair r0 = (com.google.common.graph.EndpointPair) r0
                    java.lang.Object r1 = r0.g()
                    java.lang.Object r2 = r0.h()
                    boolean r1 = r1.equals(r2)
                    if (r1 == 0) goto L_0x0027
                    java.util.concurrent.atomic.AtomicBoolean r1 = r0
                    r2 = 1
                    boolean r1 = r1.getAndSet(r2)
                    if (r1 != 0) goto L_0x0000
                L_0x0027:
                    return r0
                L_0x0028:
                    java.lang.Object r0 = r3.b()
                    com.google.common.graph.EndpointPair r0 = (com.google.common.graph.EndpointPair) r0
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.AnonymousClass4.a():com.google.common.graph.EndpointPair");
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V h(N r5, V r6) {
        /*
            r4 = this;
            java.util.Map<N, java.lang.Object> r0 = r4.f22589a
            java.lang.Object r0 = r0.put(r5, r6)
            r1 = 0
            if (r0 != 0) goto L_0x000b
        L_0x0009:
            r0 = r1
            goto L_0x002f
        L_0x000b:
            boolean r2 = r0 instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc
            if (r2 == 0) goto L_0x0020
            java.util.Map<N, java.lang.Object> r2 = r4.f22589a
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r3 = new com.google.common.graph.DirectedGraphConnections$PredAndSucc
            r3.<init>(r6)
            r2.put(r5, r3)
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r0 = (com.google.common.graph.DirectedGraphConnections.PredAndSucc) r0
            java.lang.Object r0 = r0.f22595a
            goto L_0x002f
        L_0x0020:
            java.lang.Object r2 = f22588e
            if (r0 != r2) goto L_0x002f
            java.util.Map<N, java.lang.Object> r0 = r4.f22589a
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r2 = new com.google.common.graph.DirectedGraphConnections$PredAndSucc
            r2.<init>(r6)
            r0.put(r5, r2)
            goto L_0x0009
        L_0x002f:
            if (r0 != 0) goto L_0x0046
            int r6 = r4.f22592d
            int r6 = r6 + 1
            r4.f22592d = r6
            com.google.common.graph.Graphs.d(r6)
            java.util.List<com.google.common.graph.DirectedGraphConnections$NodeConnection<N>> r6 = r4.f22590b
            if (r6 == 0) goto L_0x0046
            com.google.common.graph.DirectedGraphConnections$NodeConnection$Succ r2 = new com.google.common.graph.DirectedGraphConnections$NodeConnection$Succ
            r2.<init>(r5)
            r6.add(r2)
        L_0x0046:
            if (r0 != 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r1 = r0
        L_0x004a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.h(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public void i(N n2, V v) {
        Map<N, Object> map = this.f22589a;
        Object obj = f22588e;
        Object put = map.put(n2, obj);
        if (put != null) {
            if (put instanceof PredAndSucc) {
                this.f22589a.put(n2, put);
                return;
            } else if (put != obj) {
                this.f22589a.put(n2, new PredAndSucc(put));
            } else {
                return;
            }
        }
        int i2 = this.f22591c + 1;
        this.f22591c = i2;
        Graphs.d(i2);
        List<NodeConnection<N>> list = this.f22590b;
        if (list != null) {
            list.add(new NodeConnection.Pred(n2));
        }
    }
}
