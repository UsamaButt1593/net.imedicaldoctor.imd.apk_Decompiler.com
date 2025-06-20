package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SharedValues {

    /* renamed from: c  reason: collision with root package name */
    public static final int f4964c = -1;

    /* renamed from: a  reason: collision with root package name */
    private SparseIntArray f4965a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, HashSet<WeakReference<SharedValuesListener>>> f4966b = new HashMap<>();

    public interface SharedValuesListener {
        void a(int i2, int i3, int i4);
    }

    public void a(int i2, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = this.f4966b.get(Integer.valueOf(i2));
        if (hashSet == null) {
            hashSet = new HashSet();
            this.f4966b.put(Integer.valueOf(i2), hashSet);
        }
        hashSet.add(new WeakReference(sharedValuesListener));
    }

    public void b() {
        this.f4966b.clear();
    }

    public void c(int i2, int i3) {
        int i4 = this.f4965a.get(i2, -1);
        if (i4 != i3) {
            this.f4965a.put(i2, i3);
            HashSet hashSet = this.f4966b.get(Integer.valueOf(i2));
            if (hashSet != null) {
                Iterator it2 = hashSet.iterator();
                boolean z = false;
                while (it2.hasNext()) {
                    SharedValuesListener sharedValuesListener = (SharedValuesListener) ((WeakReference) it2.next()).get();
                    if (sharedValuesListener != null) {
                        sharedValuesListener.a(i2, i3, i4);
                    } else {
                        z = true;
                    }
                }
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it3 = hashSet.iterator();
                    while (it3.hasNext()) {
                        WeakReference weakReference = (WeakReference) it3.next();
                        if (((SharedValuesListener) weakReference.get()) == null) {
                            arrayList.add(weakReference);
                        }
                    }
                    hashSet.removeAll(arrayList);
                }
            }
        }
    }

    public int d(int i2) {
        return this.f4965a.get(i2, -1);
    }

    public void e(int i2, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = this.f4966b.get(Integer.valueOf(i2));
        if (hashSet != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                WeakReference weakReference = (WeakReference) it2.next();
                SharedValuesListener sharedValuesListener2 = (SharedValuesListener) weakReference.get();
                if (sharedValuesListener2 == null || sharedValuesListener2 == sharedValuesListener) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }

    public void f(SharedValuesListener sharedValuesListener) {
        for (Integer intValue : this.f4966b.keySet()) {
            e(intValue.intValue(), sharedValuesListener);
        }
    }
}
