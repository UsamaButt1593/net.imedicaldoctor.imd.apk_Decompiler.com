package com.itextpdf.awt.geom.misc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RenderingHints implements Map<Object, Object>, Cloneable {
    public static final Key A3;
    public static final Object B3;
    public static final Object C3;
    public static final Object D3;
    public static final Key X;
    public static final Object X2;
    public static final Object Y;
    public static final Key Y2;
    public static final Object Z;
    public static final Object Z2;
    public static final Object a3;
    public static final Object b3;
    public static final Key c3;
    public static final Object d3;
    public static final Object e3;
    public static final Object f3;
    public static final Key g3;
    public static final Object h3;
    public static final Object i3;
    public static final Object j3;
    public static final Key k3;
    public static final Object l3;
    public static final Object m3;
    public static final Object n3;
    public static final Key o3;
    public static final Object p3;
    public static final Object q3;
    public static final Object r3;
    public static final Key s3;
    public static final Object t3;
    public static final Object u3;
    public static final Object v3;
    public static final Key w3;
    public static final Object x3;
    public static final Object y3;
    public static final Object z3;
    private HashMap<Object, Object> s = new HashMap<>();

    public static abstract class Key {

        /* renamed from: a  reason: collision with root package name */
        private final int f25632a;

        protected Key(int i2) {
            this.f25632a = i2;
        }

        /* access modifiers changed from: protected */
        public final int a() {
            return this.f25632a;
        }

        public abstract boolean b(Object obj);

        public final boolean equals(Object obj) {
            return this == obj;
        }

        public final int hashCode() {
            return System.identityHashCode(this);
        }
    }

    private static class KeyImpl extends Key {
        protected KeyImpl(int i2) {
            super(i2);
        }

        public boolean b(Object obj) {
            return (obj instanceof KeyValue) && ((KeyValue) obj).f25633a == this;
        }
    }

    private static class KeyValue {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Key f25633a;

        protected KeyValue(Key key) {
            this.f25633a = key;
        }
    }

    static {
        KeyImpl keyImpl = new KeyImpl(1);
        X = keyImpl;
        Y = new KeyValue(keyImpl);
        Z = new KeyValue(keyImpl);
        X2 = new KeyValue(keyImpl);
        KeyImpl keyImpl2 = new KeyImpl(2);
        Y2 = keyImpl2;
        Z2 = new KeyValue(keyImpl2);
        a3 = new KeyValue(keyImpl2);
        b3 = new KeyValue(keyImpl2);
        KeyImpl keyImpl3 = new KeyImpl(3);
        c3 = keyImpl3;
        d3 = new KeyValue(keyImpl3);
        e3 = new KeyValue(keyImpl3);
        f3 = new KeyValue(keyImpl3);
        KeyImpl keyImpl4 = new KeyImpl(4);
        g3 = keyImpl4;
        h3 = new KeyValue(keyImpl4);
        i3 = new KeyValue(keyImpl4);
        j3 = new KeyValue(keyImpl4);
        KeyImpl keyImpl5 = new KeyImpl(5);
        k3 = keyImpl5;
        l3 = new KeyValue(keyImpl5);
        m3 = new KeyValue(keyImpl5);
        n3 = new KeyValue(keyImpl5);
        KeyImpl keyImpl6 = new KeyImpl(6);
        o3 = keyImpl6;
        p3 = new KeyValue(keyImpl6);
        q3 = new KeyValue(keyImpl6);
        r3 = new KeyValue(keyImpl6);
        KeyImpl keyImpl7 = new KeyImpl(7);
        s3 = keyImpl7;
        t3 = new KeyValue(keyImpl7);
        u3 = new KeyValue(keyImpl7);
        v3 = new KeyValue(keyImpl7);
        KeyImpl keyImpl8 = new KeyImpl(8);
        w3 = keyImpl8;
        x3 = new KeyValue(keyImpl8);
        y3 = new KeyValue(keyImpl8);
        z3 = new KeyValue(keyImpl8);
        KeyImpl keyImpl9 = new KeyImpl(9);
        A3 = keyImpl9;
        B3 = new KeyValue(keyImpl9);
        C3 = new KeyValue(keyImpl9);
        D3 = new KeyValue(keyImpl9);
    }

    public RenderingHints(Key key, Object obj) {
        put(key, obj);
    }

    public void a(RenderingHints renderingHints) {
        this.s.putAll(renderingHints.s);
    }

    public void clear() {
        this.s.clear();
    }

    public Object clone() {
        RenderingHints renderingHints = new RenderingHints((Map<Key, ?>) null);
        renderingHints.s = (HashMap) this.s.clone();
        return renderingHints;
    }

    public boolean containsKey(Object obj) {
        obj.getClass();
        return this.s.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.s.containsValue(obj);
    }

    public Set<Map.Entry<Object, Object>> entrySet() {
        return this.s.entrySet();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        Set<Object> keySet = keySet();
        if (!keySet.equals(map.keySet())) {
            return false;
        }
        Iterator<Object> it2 = keySet.iterator();
        while (it2.hasNext()) {
            Key key = (Key) it2.next();
            Object obj2 = get(key);
            Object obj3 = map.get(key);
            if (obj2 == null) {
                if (obj3 == null) {
                }
            } else if (!obj2.equals(obj3)) {
            }
            return false;
        }
        return true;
    }

    public Object get(Object obj) {
        return this.s.get(obj);
    }

    public int hashCode() {
        return this.s.hashCode();
    }

    public boolean isEmpty() {
        return this.s.isEmpty();
    }

    public Set<Object> keySet() {
        return this.s.keySet();
    }

    public Object put(Object obj, Object obj2) {
        if (((Key) obj).b(obj2)) {
            return this.s.put(obj, obj2);
        }
        throw new IllegalArgumentException();
    }

    public void putAll(Map<?, ?> map) {
        if (map instanceof RenderingHints) {
            this.s.putAll(((RenderingHints) map).s);
            return;
        }
        Set<Map.Entry<?, ?>> entrySet = map.entrySet();
        if (entrySet != null) {
            for (Map.Entry next : entrySet) {
                put((Key) next.getKey(), next.getValue());
            }
        }
    }

    public Object remove(Object obj) {
        return this.s.remove(obj);
    }

    public int size() {
        return this.s.size();
    }

    public String toString() {
        return "RenderingHints[" + this.s.toString() + "]";
    }

    public Collection<Object> values() {
        return this.s.values();
    }

    public RenderingHints(Map<Key, ?> map) {
        if (map != null) {
            putAll(map);
        }
    }
}
