package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.FontResourcesParserCompat;
import java.lang.reflect.Field;

@RestrictTo({RestrictTo.Scope.LIBRARY})
final class WeightTypefaceApi14 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5870a = "WeightTypeface";

    /* renamed from: b  reason: collision with root package name */
    private static final String f5871b = "native_instance";

    /* renamed from: c  reason: collision with root package name */
    private static final Field f5872c;
    @GuardedBy("sWeightCacheLock")

    /* renamed from: d  reason: collision with root package name */
    private static final LongSparseArray<SparseArray<Typeface>> f5873d = new LongSparseArray<>(3);

    /* renamed from: e  reason: collision with root package name */
    private static final Object f5874e = new Object();

    static {
        Field field;
        try {
            field = Typeface.class.getDeclaredField(f5871b);
            field.setAccessible(true);
        } catch (Exception e2) {
            Log.e(f5870a, e2.getClass().getName(), e2);
            field = null;
        }
        f5872c = field;
    }

    private WeightTypefaceApi14() {
    }

    @Nullable
    static Typeface a(@NonNull TypefaceCompatBaseImpl typefaceCompatBaseImpl, @NonNull Context context, @NonNull Typeface typeface, int i2, boolean z) {
        if (!d()) {
            return null;
        }
        boolean z2 = (i2 << 1) | z;
        synchronized (f5874e) {
            try {
                long c2 = c(typeface);
                LongSparseArray<SparseArray<Typeface>> longSparseArray = f5873d;
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
                Typeface b2 = b(typefaceCompatBaseImpl, context, typeface, i2, z);
                if (b2 == null) {
                    b2 = e(typeface, i2, z);
                }
                h2.put(z2 ? 1 : 0, b2);
                return b2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    private static Typeface b(@NonNull TypefaceCompatBaseImpl typefaceCompatBaseImpl, @NonNull Context context, @NonNull Typeface typeface, int i2, boolean z) {
        FontResourcesParserCompat.FontFamilyFilesResourceEntry m2 = typefaceCompatBaseImpl.m(typeface);
        if (m2 == null) {
            return null;
        }
        return typefaceCompatBaseImpl.c(context, m2, context.getResources(), i2, z);
    }

    private static long c(@NonNull Typeface typeface) {
        try {
            return ((Number) f5872c.get(typeface)).longValue();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean d() {
        return f5872c != null;
    }

    private static Typeface e(Typeface typeface, int i2, boolean z) {
        int i3 = 0;
        boolean z2 = i2 >= 600;
        if (z2 || z) {
            i3 = !z2 ? 2 : !z ? 1 : 3;
        }
        return Typeface.create(typeface, i3);
    }
}
