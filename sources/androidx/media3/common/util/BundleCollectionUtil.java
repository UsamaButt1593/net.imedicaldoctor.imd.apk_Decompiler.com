package androidx.media3.common.util;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class BundleCollectionUtil {
    private BundleCollectionUtil() {
    }

    public static HashMap<String, String> a(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (bundle == Bundle.EMPTY) {
            return hashMap;
        }
        for (String next : bundle.keySet()) {
            String string = bundle.getString(next);
            if (string != null) {
                hashMap.put(next, string);
            }
        }
        return hashMap;
    }

    public static ImmutableMap<String, String> b(Bundle bundle) {
        return bundle == Bundle.EMPTY ? ImmutableMap.s() : ImmutableMap.g(a(bundle));
    }

    public static void c(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) Util.o(BundleCollectionUtil.class.getClassLoader()));
        }
    }

    public static <T> ImmutableList<T> d(Function<Bundle, T> function, List<Bundle> list) {
        ImmutableList.Builder r = ImmutableList.r();
        for (int i2 = 0; i2 < list.size(); i2++) {
            r.g(function.apply((Bundle) Assertions.g(list.get(i2))));
        }
        return r.e();
    }

    public static <T> SparseArray<T> e(Function<Bundle, T> function, SparseArray<Bundle> sparseArray) {
        SparseArray<T> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            sparseArray2.put(sparseArray.keyAt(i2), function.apply(sparseArray.valueAt(i2)));
        }
        return sparseArray2;
    }

    public static Bundle f(Bundle bundle, String str, Bundle bundle2) {
        Bundle bundle3 = bundle.getBundle(str);
        return bundle3 != null ? bundle3 : bundle2;
    }

    public static ArrayList<Integer> g(Bundle bundle, String str, ArrayList<Integer> arrayList) {
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(str);
        return integerArrayList != null ? integerArrayList : arrayList;
    }

    public static Bundle h(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry next : map.entrySet()) {
            bundle.putString((String) next.getKey(), (String) next.getValue());
        }
        return bundle;
    }

    public static <T> ArrayList<Bundle> i(Collection<T> collection, Function<T, Bundle> function) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        for (T apply : collection) {
            arrayList.add(function.apply(apply));
        }
        return arrayList;
    }

    public static <T> ImmutableList<Bundle> j(List<T> list, Function<T, Bundle> function) {
        ImmutableList.Builder r = ImmutableList.r();
        for (int i2 = 0; i2 < list.size(); i2++) {
            r.g(function.apply(list.get(i2)));
        }
        return r.e();
    }

    public static <T> SparseArray<Bundle> k(SparseArray<T> sparseArray, Function<T, Bundle> function) {
        SparseArray<Bundle> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            sparseArray2.put(sparseArray.keyAt(i2), function.apply(sparseArray.valueAt(i2)));
        }
        return sparseArray2;
    }
}
