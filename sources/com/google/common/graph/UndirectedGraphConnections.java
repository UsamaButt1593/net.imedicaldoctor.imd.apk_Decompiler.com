package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class UndirectedGraphConnections<N, V> implements GraphConnections<N, V> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<N, V> f22650a;

    /* renamed from: com.google.common.graph.UndirectedGraphConnections$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22651a;

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
                f22651a = r0
                com.google.common.graph.ElementOrder$Type r1 = com.google.common.graph.ElementOrder.Type.UNORDERED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22651a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.graph.ElementOrder$Type r1 = com.google.common.graph.ElementOrder.Type.STABLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.UndirectedGraphConnections.AnonymousClass1.<clinit>():void");
        }
    }

    private UndirectedGraphConnections(Map<N, V> map) {
        this.f22650a = (Map) Preconditions.E(map);
    }

    static <N, V> UndirectedGraphConnections<N, V> l(ElementOrder<N> elementOrder) {
        int i2 = AnonymousClass1.f22651a[elementOrder.h().ordinal()];
        if (i2 == 1) {
            return new UndirectedGraphConnections<>(new HashMap(2, 1.0f));
        }
        if (i2 == 2) {
            return new UndirectedGraphConnections<>(new LinkedHashMap(2, 1.0f));
        }
        throw new AssertionError(elementOrder.h());
    }

    static <N, V> UndirectedGraphConnections<N, V> m(Map<N, V> map) {
        return new UndirectedGraphConnections<>(ImmutableMap.g(map));
    }

    public Set<N> a() {
        return Collections.unmodifiableSet(this.f22650a.keySet());
    }

    public Set<N> b() {
        return a();
    }

    public Set<N> c() {
        return a();
    }

    @CheckForNull
    public V d(N n2) {
        return this.f22650a.remove(n2);
    }

    @CheckForNull
    public V e(N n2) {
        return this.f22650a.get(n2);
    }

    public void f(N n2) {
        d(n2);
    }

    public Iterator<EndpointPair<N>> g(N n2) {
        return Iterators.c0(this.f22650a.keySet().iterator(), new r(n2));
    }

    @CheckForNull
    public V h(N n2, V v) {
        return this.f22650a.put(n2, v);
    }

    public void i(N n2, V v) {
        h(n2, v);
    }
}
