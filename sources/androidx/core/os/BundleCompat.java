package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import java.util.ArrayList;

public final class BundleCompat {

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static <T> T a(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
            return bundle.getParcelable(str, cls);
        }

        @DoNotInline
        static <T> T[] b(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
            return bundle.getParcelableArray(str, cls);
        }

        @DoNotInline
        static <T> ArrayList<T> c(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends T> cls) {
            return bundle.getParcelableArrayList(str, cls);
        }

        @DoNotInline
        static <T extends Serializable> T d(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
            return bundle.getSerializable(str, cls);
        }

        @DoNotInline
        static <T> SparseArray<T> e(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends T> cls) {
            return bundle.getSparseParcelableArray(str, cls);
        }
    }

    private BundleCompat() {
    }

    @Deprecated
    @Nullable
    public static IBinder a(@NonNull Bundle bundle, @Nullable String str) {
        return bundle.getBinder(str);
    }

    @Nullable
    public static <T> T b(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.a(bundle, str, cls);
        }
        T parcelable = bundle.getParcelable(str);
        if (cls.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Nullable
    public static Parcelable[] c(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends Parcelable> cls) {
        return Build.VERSION.SDK_INT >= 34 ? (Parcelable[]) Api33Impl.b(bundle, str, cls) : bundle.getParcelableArray(str);
    }

    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @Nullable
    public static <T> ArrayList<T> d(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.c(bundle, str, cls) : bundle.getParcelableArrayList(str);
    }

    @Nullable
    public static <T extends Serializable> T e(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.d(bundle, str, cls);
        }
        T serializable = bundle.getSerializable(str);
        if (cls.isInstance(serializable)) {
            return serializable;
        }
        return null;
    }

    @Nullable
    public static <T> SparseArray<T> f(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.e(bundle, str, cls) : bundle.getSparseParcelableArray(str);
    }

    @Deprecated
    public static void g(@NonNull Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
