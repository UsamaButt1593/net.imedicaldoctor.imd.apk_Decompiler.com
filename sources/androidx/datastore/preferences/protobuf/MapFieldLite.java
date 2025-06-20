package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {
    private static final MapFieldLite X;
    private boolean s = true;

    static {
        MapFieldLite mapFieldLite = new MapFieldLite();
        X = mapFieldLite;
        mapFieldLite.m();
    }

    private MapFieldLite() {
    }

    static <K, V> int a(Map<K, V> map) {
        int i2 = 0;
        for (Map.Entry next : map.entrySet()) {
            i2 += b(next.getValue()) ^ b(next.getKey());
        }
        return i2;
    }

    private static int b(Object obj) {
        if (obj instanceof byte[]) {
            return Internal.m((byte[]) obj);
        }
        if (!(obj instanceof Internal.EnumLite)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private static void c(Map<?, ?> map) {
        for (Object next : map.keySet()) {
            Internal.d(next);
            Internal.d(map.get(next));
        }
    }

    private static Object d(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        return Arrays.copyOf(bArr, bArr.length);
    }

    static <K, V> Map<K, V> e(Map<K, V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            linkedHashMap.put(next.getKey(), d(next.getValue()));
        }
        return linkedHashMap;
    }

    public static <K, V> MapFieldLite<K, V> f() {
        return X;
    }

    private void g() {
        if (!l()) {
            throw new UnsupportedOperationException();
        }
    }

    private static boolean h(Object obj, Object obj2) {
        return (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) ? obj.equals(obj2) : Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <K, V> boolean i(java.util.Map<K, V> r4, java.util.Map<K, V> r5) {
        /*
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r4.size()
            int r2 = r5.size()
            r3 = 0
            if (r1 == r2) goto L_0x0010
            return r3
        L_0x0010:
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0018:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0042
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            boolean r2 = r5.containsKey(r2)
            if (r2 != 0) goto L_0x002f
            return r3
        L_0x002f:
            java.lang.Object r2 = r1.getValue()
            java.lang.Object r1 = r1.getKey()
            java.lang.Object r1 = r5.get(r1)
            boolean r1 = h(r2, r1)
            if (r1 != 0) goto L_0x0018
            return r3
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MapFieldLite.i(java.util.Map, java.util.Map):boolean");
    }

    public void clear() {
        g();
        super.clear();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Map) && i(this, (Map) obj);
    }

    public int hashCode() {
        return a(this);
    }

    public boolean l() {
        return this.s;
    }

    public void m() {
        this.s = false;
    }

    public void n(MapFieldLite<K, V> mapFieldLite) {
        g();
        if (!mapFieldLite.isEmpty()) {
            putAll(mapFieldLite);
        }
    }

    public MapFieldLite<K, V> o() {
        return isEmpty() ? new MapFieldLite<>() : new MapFieldLite<>(this);
    }

    public V p(Map.Entry<K, V> entry) {
        return put(entry.getKey(), entry.getValue());
    }

    public V put(K k2, V v) {
        g();
        Internal.d(k2);
        Internal.d(v);
        return super.put(k2, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        g();
        c(map);
        super.putAll(map);
    }

    public V remove(Object obj) {
        g();
        return super.remove(obj);
    }

    private MapFieldLite(Map<K, V> map) {
        super(map);
    }
}
