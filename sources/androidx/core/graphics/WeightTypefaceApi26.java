package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(26)
@SuppressLint({"SoonBlockedPrivateApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class WeightTypefaceApi26 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5885a = "WeightTypeface";

    /* renamed from: b  reason: collision with root package name */
    private static final String f5886b = "native_instance";

    /* renamed from: c  reason: collision with root package name */
    private static final String f5887c = "nativeCreateFromTypefaceWithExactStyle";

    /* renamed from: d  reason: collision with root package name */
    private static final Field f5888d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f5889e;

    /* renamed from: f  reason: collision with root package name */
    private static final Constructor<Typeface> f5890f;
    @GuardedBy("sWeightCacheLock")

    /* renamed from: g  reason: collision with root package name */
    private static final LongSparseArray<SparseArray<Typeface>> f5891g = new LongSparseArray<>(3);

    /* renamed from: h  reason: collision with root package name */
    private static final Object f5892h = new Object();

    static {
        Method method;
        Field field;
        Constructor<Typeface> constructor;
        Class<Typeface> cls = Typeface.class;
        try {
            field = cls.getDeclaredField(f5886b);
            Class cls2 = Long.TYPE;
            method = cls.getDeclaredMethod(f5887c, new Class[]{cls2, Integer.TYPE, Boolean.TYPE});
            method.setAccessible(true);
            constructor = cls.getDeclaredConstructor(new Class[]{cls2});
            constructor.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException e2) {
            Log.e(f5885a, e2.getClass().getName(), e2);
            field = null;
            constructor = null;
            method = null;
        }
        f5888d = field;
        f5889e = method;
        f5890f = constructor;
    }

    private WeightTypefaceApi26() {
    }

    @Nullable
    private static Typeface a(long j2) {
        try {
            return f5890f.newInstance(new Object[]{Long.valueOf(j2)});
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Nullable
    static Typeface b(@NonNull Typeface typeface, int i2, boolean z) {
        if (!d()) {
            return null;
        }
        boolean z2 = (i2 << 1) | z;
        synchronized (f5892h) {
            try {
                long c2 = c(typeface);
                LongSparseArray<SparseArray<Typeface>> longSparseArray = f5891g;
                SparseArray h2 = longSparseArray.h(c2);
                if (h2 == null) {
                    h2 = new SparseArray(4);
                    longSparseArray.p(c2, h2);
                } else {
                    Typeface typeface2 = (Typeface) h2.get(z2);
                    if (typeface2 != null) {
                        return typeface2;
                    }
                }
                Typeface a2 = a(e(c2, i2, z));
                h2.put(z2 ? 1 : 0, a2);
                return a2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static long c(@NonNull Typeface typeface) {
        try {
            return f5888d.getLong(typeface);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean d() {
        return f5888d != null;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long e(long j2, int i2, boolean z) {
        try {
            return ((Long) f5889e.invoke((Object) null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Boolean.valueOf(z)})).longValue();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }
}
