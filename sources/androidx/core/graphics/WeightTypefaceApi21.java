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

@RequiresApi(21)
@SuppressLint({"SoonBlockedPrivateApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class WeightTypefaceApi21 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5875a = "WeightTypeface";

    /* renamed from: b  reason: collision with root package name */
    private static final String f5876b = "native_instance";

    /* renamed from: c  reason: collision with root package name */
    private static final String f5877c = "nativeCreateFromTypeface";

    /* renamed from: d  reason: collision with root package name */
    private static final String f5878d = "nativeCreateWeightAlias";

    /* renamed from: e  reason: collision with root package name */
    private static final Field f5879e;

    /* renamed from: f  reason: collision with root package name */
    private static final Method f5880f;

    /* renamed from: g  reason: collision with root package name */
    private static final Method f5881g;

    /* renamed from: h  reason: collision with root package name */
    private static final Constructor<Typeface> f5882h;
    @GuardedBy("sWeightCacheLock")

    /* renamed from: i  reason: collision with root package name */
    private static final LongSparseArray<SparseArray<Typeface>> f5883i = new LongSparseArray<>(3);

    /* renamed from: j  reason: collision with root package name */
    private static final Object f5884j = new Object();

    static {
        Method method;
        Field field;
        Constructor<Typeface> constructor;
        Method method2;
        Class<Typeface> cls = Typeface.class;
        try {
            field = cls.getDeclaredField(f5876b);
            Class cls2 = Long.TYPE;
            Class cls3 = Integer.TYPE;
            method = cls.getDeclaredMethod(f5877c, new Class[]{cls2, cls3});
            method.setAccessible(true);
            method2 = cls.getDeclaredMethod(f5878d, new Class[]{cls2, cls3});
            method2.setAccessible(true);
            constructor = cls.getDeclaredConstructor(new Class[]{cls2});
            constructor.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException e2) {
            Log.e(f5875a, e2.getClass().getName(), e2);
            field = null;
            method2 = null;
            constructor = null;
            method = null;
        }
        f5879e = field;
        f5880f = method;
        f5881g = method2;
        f5882h = constructor;
    }

    private WeightTypefaceApi21() {
    }

    @Nullable
    private static Typeface a(long j2) {
        try {
            return f5882h.newInstance(new Object[]{Long.valueOf(j2)});
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
        synchronized (f5884j) {
            try {
                long c2 = c(typeface);
                LongSparseArray<SparseArray<Typeface>> longSparseArray = f5883i;
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
                Typeface a2 = a(z == typeface.isItalic() ? f(c2, i2) : e(c2, i2, z));
                h2.put(z2 ? 1 : 0, a2);
                return a2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static long c(@NonNull Typeface typeface) {
        try {
            return f5879e.getLong(typeface);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean d() {
        return f5879e != null;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long e(long j2, int i2, boolean z) {
        try {
            Long l2 = (Long) f5880f.invoke((Object) null, new Object[]{Long.valueOf(j2), Integer.valueOf(z ? 2 : 0)});
            l2.longValue();
            return ((Long) f5881g.invoke((Object) null, new Object[]{l2, Integer.valueOf(i2)})).longValue();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long f(long j2, int i2) {
        try {
            return ((Long) f5881g.invoke((Object) null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})).longValue();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }
}
