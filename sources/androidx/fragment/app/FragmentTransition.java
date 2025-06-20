package androidx.fragment.app;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.transition.FragmentTransitionSupport;
import java.util.ArrayList;
import java.util.List;

class FragmentTransition {

    /* renamed from: a  reason: collision with root package name */
    static final FragmentTransitionImpl f8017a = new FragmentTransitionCompat21();

    /* renamed from: b  reason: collision with root package name */
    static final FragmentTransitionImpl f8018b = c();

    private FragmentTransition() {
    }

    static void a(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback F = z ? fragment2.F() : fragment.F();
        if (F != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(arrayMap.i(i2));
                arrayList.add(arrayMap.m(i2));
            }
            if (z2) {
                F.g(arrayList2, arrayList, (List<View>) null);
            } else {
                F.f(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    static String b(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(arrayMap.m(i2))) {
                return arrayMap.i(i2);
            }
        }
        return null;
    }

    private static FragmentTransitionImpl c() {
        try {
            return FragmentTransitionSupport.class.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }

    static void d(@NonNull ArrayMap<String, String> arrayMap, @NonNull ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.m(size))) {
                arrayMap.k(size);
            }
        }
    }

    static void e(ArrayList<View> arrayList, int i2) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i2);
            }
        }
    }

    static boolean f() {
        return (f8017a == null && f8018b == null) ? false : true;
    }
}
