package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ParcelCompat {

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static <T extends Parcelable> List<T> a(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader) {
            return parcel.readParcelableList(list, classLoader);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static Parcelable.Creator<?> a(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            return parcel.readParcelableCreator(classLoader);
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static <T> T[] a(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return parcel.readArray(classLoader, cls);
        }

        @DoNotInline
        static <T> ArrayList<T> b(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            return parcel.readArrayList(classLoader, cls);
        }

        @DoNotInline
        static <V, K> HashMap<K, V> c(Parcel parcel, ClassLoader classLoader, Class<? extends K> cls, Class<? extends V> cls2) {
            return parcel.readHashMap(classLoader, cls, cls2);
        }

        @DoNotInline
        static <T> void d(@NonNull Parcel parcel, @NonNull List<? super T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            parcel.readList(list, classLoader, cls);
        }

        @DoNotInline
        static <K, V> void e(Parcel parcel, Map<? super K, ? super V> map, ClassLoader classLoader, Class<K> cls, Class<V> cls2) {
            parcel.readMap(map, classLoader, cls, cls2);
        }

        @DoNotInline
        static <T extends Parcelable> T f(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return (Parcelable) parcel.readParcelable(classLoader, cls);
        }

        @DoNotInline
        static <T> T[] g(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return parcel.readParcelableArray(classLoader, cls);
        }

        @DoNotInline
        static <T> Parcelable.Creator<T> h(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return parcel.readParcelableCreator(classLoader, cls);
        }

        @DoNotInline
        static <T> List<T> i(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return parcel.readParcelableList(list, classLoader, cls);
        }

        @DoNotInline
        static <T extends Serializable> T j(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return (Serializable) parcel.readSerializable(classLoader, cls);
        }

        @DoNotInline
        static <T> SparseArray<T> k(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            return parcel.readSparseArray(classLoader, cls);
        }
    }

    private ParcelCompat() {
    }

    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Nullable
    public static <T> Object[] a(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.a(parcel, classLoader, cls) : parcel.readArray(classLoader);
    }

    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @Nullable
    public static <T> ArrayList<T> b(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.b(parcel, classLoader, cls) : parcel.readArrayList(classLoader);
    }

    public static boolean c(@NonNull Parcel parcel) {
        return parcel.readInt() != 0;
    }

    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @Nullable
    public static <K, V> HashMap<K, V> d(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends K> cls, @NonNull Class<? extends V> cls2) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.c(parcel, classLoader, cls, cls2) : parcel.readHashMap(classLoader);
    }

    public static <T> void e(@NonNull Parcel parcel, @NonNull List<? super T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api33Impl.d(parcel, list, classLoader, cls);
        } else {
            parcel.readList(list, classLoader);
        }
    }

    public static <K, V> void f(@NonNull Parcel parcel, @NonNull Map<? super K, ? super V> map, @Nullable ClassLoader classLoader, @NonNull Class<K> cls, @NonNull Class<V> cls2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api33Impl.e(parcel, map, classLoader, cls, cls2);
        } else {
            parcel.readMap(map, classLoader);
        }
    }

    @Nullable
    public static <T extends Parcelable> T g(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.f(parcel, classLoader, cls);
        }
        T readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null || cls.isInstance(readParcelable)) {
            return readParcelable;
        }
        throw new BadParcelableException("Parcelable " + readParcelable.getClass() + " is not a subclass of required class " + cls.getName() + " provided in the parameter");
    }

    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Nullable
    @Deprecated
    public static <T> T[] h(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.g(parcel, classLoader, cls);
        }
        T[] readParcelableArray = parcel.readParcelableArray(classLoader);
        if (cls.isAssignableFrom(Parcelable.class)) {
            return readParcelableArray;
        }
        T[] tArr = (Object[]) Array.newInstance(cls, readParcelableArray.length);
        int i2 = 0;
        while (i2 < readParcelableArray.length) {
            try {
                tArr[i2] = cls.cast(readParcelableArray[i2]);
                i2++;
            } catch (ClassCastException unused) {
                throw new BadParcelableException("Parcelable at index " + i2 + " is not a subclass of required class " + cls.getName() + " provided in the parameter");
            }
        }
        return tArr;
    }

    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Nullable
    public static <T> Parcelable[] i(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? (Parcelable[]) Api33Impl.g(parcel, classLoader, cls) : parcel.readParcelableArray(classLoader);
    }

    @RequiresApi(30)
    @Nullable
    public static <T> Parcelable.Creator<T> j(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.h(parcel, classLoader, cls) : Api30Impl.a(parcel, classLoader);
    }

    @RequiresApi(api = 29)
    @NonNull
    public static <T> List<T> k(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.i(parcel, list, classLoader, cls) : Api29Impl.a(parcel, list, classLoader);
    }

    @Nullable
    public static <T extends Serializable> T l(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.j(parcel, classLoader, cls) : parcel.readSerializable();
    }

    @Nullable
    public static <T> SparseArray<T> m(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.k(parcel, classLoader, cls) : parcel.readSparseArray(classLoader);
    }

    public static void n(@NonNull Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }
}
