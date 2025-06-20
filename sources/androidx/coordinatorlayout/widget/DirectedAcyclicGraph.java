package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class DirectedAcyclicGraph<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Pools.Pool<ArrayList<T>> f5091a = new Pools.SimplePool(10);

    /* renamed from: b  reason: collision with root package name */
    private final SimpleArrayMap<T, ArrayList<T>> f5092b = new SimpleArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f5093c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f5094d = new HashSet<>();

    private void e(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = this.f5092b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        e(arrayList2.get(i2), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    @NonNull
    private ArrayList<T> f() {
        ArrayList<T> b2 = this.f5091a.b();
        return b2 == null ? new ArrayList<>() : b2;
    }

    private void k(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.f5091a.c(arrayList);
    }

    public void a(@NonNull T t, @NonNull T t2) {
        if (!this.f5092b.containsKey(t) || !this.f5092b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f5092b.get(t);
        if (arrayList == null) {
            arrayList = f();
            this.f5092b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public void b(@NonNull T t) {
        if (!this.f5092b.containsKey(t)) {
            this.f5092b.put(t, null);
        }
    }

    public void c() {
        int size = this.f5092b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList m2 = this.f5092b.m(i2);
            if (m2 != null) {
                k(m2);
            }
        }
        this.f5092b.clear();
    }

    public boolean d(@NonNull T t) {
        return this.f5092b.containsKey(t);
    }

    @Nullable
    public List g(@NonNull T t) {
        return this.f5092b.get(t);
    }

    @Nullable
    public List<T> h(@NonNull T t) {
        int size = this.f5092b.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList m2 = this.f5092b.m(i2);
            if (m2 != null && m2.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f5092b.i(i2));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> i() {
        this.f5093c.clear();
        this.f5094d.clear();
        int size = this.f5092b.size();
        for (int i2 = 0; i2 < size; i2++) {
            e(this.f5092b.i(i2), this.f5093c, this.f5094d);
        }
        return this.f5093c;
    }

    public boolean j(@NonNull T t) {
        int size = this.f5092b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList m2 = this.f5092b.m(i2);
            if (m2 != null && m2.contains(t)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int l() {
        return this.f5092b.size();
    }
}
