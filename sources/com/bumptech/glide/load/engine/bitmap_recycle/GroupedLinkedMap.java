package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupedLinkedMap<K extends Poolable, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedEntry<K, V> f17978a = new LinkedEntry<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, LinkedEntry<K, V>> f17979b = new HashMap();

    private static class LinkedEntry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f17980a;

        /* renamed from: b  reason: collision with root package name */
        private List<V> f17981b;

        /* renamed from: c  reason: collision with root package name */
        LinkedEntry<K, V> f17982c;

        /* renamed from: d  reason: collision with root package name */
        LinkedEntry<K, V> f17983d;

        LinkedEntry() {
            this((Object) null);
        }

        public void a(V v) {
            if (this.f17981b == null) {
                this.f17981b = new ArrayList();
            }
            this.f17981b.add(v);
        }

        @Nullable
        public V b() {
            int c2 = c();
            if (c2 > 0) {
                return this.f17981b.remove(c2 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f17981b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        LinkedEntry(K k2) {
            this.f17983d = this;
            this.f17982c = this;
            this.f17980a = k2;
        }
    }

    GroupedLinkedMap() {
    }

    private void b(LinkedEntry<K, V> linkedEntry) {
        e(linkedEntry);
        LinkedEntry<K, V> linkedEntry2 = this.f17978a;
        linkedEntry.f17983d = linkedEntry2;
        linkedEntry.f17982c = linkedEntry2.f17982c;
        g(linkedEntry);
    }

    private void c(LinkedEntry<K, V> linkedEntry) {
        e(linkedEntry);
        LinkedEntry<K, V> linkedEntry2 = this.f17978a;
        linkedEntry.f17983d = linkedEntry2.f17983d;
        linkedEntry.f17982c = linkedEntry2;
        g(linkedEntry);
    }

    private static <K, V> void e(LinkedEntry<K, V> linkedEntry) {
        LinkedEntry<K, V> linkedEntry2 = linkedEntry.f17983d;
        linkedEntry2.f17982c = linkedEntry.f17982c;
        linkedEntry.f17982c.f17983d = linkedEntry2;
    }

    private static <K, V> void g(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.f17982c.f17983d = linkedEntry;
        linkedEntry.f17983d.f17982c = linkedEntry;
    }

    @Nullable
    public V a(K k2) {
        LinkedEntry linkedEntry = this.f17979b.get(k2);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(k2);
            this.f17979b.put(k2, linkedEntry);
        } else {
            k2.a();
        }
        b(linkedEntry);
        return linkedEntry.b();
    }

    public void d(K k2, V v) {
        LinkedEntry linkedEntry = this.f17979b.get(k2);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(k2);
            c(linkedEntry);
            this.f17979b.put(k2, linkedEntry);
        } else {
            k2.a();
        }
        linkedEntry.a(v);
    }

    @Nullable
    public V f() {
        LinkedEntry<K, V> linkedEntry = this.f17978a;
        while (true) {
            linkedEntry = linkedEntry.f17983d;
            if (linkedEntry.equals(this.f17978a)) {
                return null;
            }
            V b2 = linkedEntry.b();
            if (b2 != null) {
                return b2;
            }
            e(linkedEntry);
            this.f17979b.remove(linkedEntry.f17980a);
            ((Poolable) linkedEntry.f17980a).a();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        LinkedEntry<K, V> linkedEntry = this.f17978a.f17982c;
        boolean z = false;
        while (!linkedEntry.equals(this.f17978a)) {
            sb.append(ASCIIPropertyListParser.f18652j);
            sb.append(linkedEntry.f17980a);
            sb.append(ASCIIPropertyListParser.A);
            sb.append(linkedEntry.c());
            sb.append("}, ");
            linkedEntry = linkedEntry.f17982c;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
