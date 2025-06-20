package androidx.media3.common.util;

import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UnstableApi
public final class CopyOnWriteMultiset<E> implements Iterable<E> {
    @GuardedBy("lock")
    private final Map<E, Integer> X = new HashMap();
    @GuardedBy("lock")
    private Set<E> Y = Collections.emptySet();
    @GuardedBy("lock")
    private List<E> Z = Collections.emptyList();
    private final Object s = new Object();

    public void b(E e2) {
        synchronized (this.s) {
            try {
                ArrayList arrayList = new ArrayList(this.Z);
                arrayList.add(e2);
                this.Z = Collections.unmodifiableList(arrayList);
                Integer num = this.X.get(e2);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.Y);
                    hashSet.add(e2);
                    this.Y = Collections.unmodifiableSet(hashSet);
                }
                Map<E, Integer> map = this.X;
                int i2 = 1;
                if (num != null) {
                    i2 = 1 + num.intValue();
                }
                map.put(e2, Integer.valueOf(i2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(E r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.s
            monitor-enter(r0)
            java.util.Map<E, java.lang.Integer> r1 = r4.X     // Catch:{ all -> 0x000f }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x000f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x000f }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return
        L_0x000f:
            r5 = move-exception
            goto L_0x004e
        L_0x0011:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x000f }
            java.util.List<E> r3 = r4.Z     // Catch:{ all -> 0x000f }
            r2.<init>(r3)     // Catch:{ all -> 0x000f }
            r2.remove(r5)     // Catch:{ all -> 0x000f }
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)     // Catch:{ all -> 0x000f }
            r4.Z = r2     // Catch:{ all -> 0x000f }
            int r2 = r1.intValue()     // Catch:{ all -> 0x000f }
            r3 = 1
            if (r2 != r3) goto L_0x003e
            java.util.Map<E, java.lang.Integer> r1 = r4.X     // Catch:{ all -> 0x000f }
            r1.remove(r5)     // Catch:{ all -> 0x000f }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x000f }
            java.util.Set<E> r2 = r4.Y     // Catch:{ all -> 0x000f }
            r1.<init>(r2)     // Catch:{ all -> 0x000f }
            r1.remove(r5)     // Catch:{ all -> 0x000f }
            java.util.Set r5 = java.util.Collections.unmodifiableSet(r1)     // Catch:{ all -> 0x000f }
            r4.Y = r5     // Catch:{ all -> 0x000f }
            goto L_0x004c
        L_0x003e:
            java.util.Map<E, java.lang.Integer> r2 = r4.X     // Catch:{ all -> 0x000f }
            int r1 = r1.intValue()     // Catch:{ all -> 0x000f }
            int r1 = r1 - r3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x000f }
            r2.put(r5, r1)     // Catch:{ all -> 0x000f }
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return
        L_0x004e:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.CopyOnWriteMultiset.c(java.lang.Object):void");
    }

    public Set<E> e() {
        Set<E> set;
        synchronized (this.s) {
            set = this.Y;
        }
        return set;
    }

    public Iterator<E> iterator() {
        Iterator<E> it2;
        synchronized (this.s) {
            it2 = this.Z.iterator();
        }
        return it2;
    }

    public int l1(E e2) {
        int intValue;
        synchronized (this.s) {
            try {
                intValue = this.X.containsKey(e2) ? this.X.get(e2).intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return intValue;
    }
}
