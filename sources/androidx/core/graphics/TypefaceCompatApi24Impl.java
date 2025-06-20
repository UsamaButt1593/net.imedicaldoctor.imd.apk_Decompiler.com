package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {

    /* renamed from: d  reason: collision with root package name */
    private static final String f5852d = "TypefaceCompatApi24Impl";

    /* renamed from: e  reason: collision with root package name */
    private static final String f5853e = "android.graphics.FontFamily";

    /* renamed from: f  reason: collision with root package name */
    private static final String f5854f = "addFontWeightStyle";

    /* renamed from: g  reason: collision with root package name */
    private static final String f5855g = "createFromFamiliesWithDefault";

    /* renamed from: h  reason: collision with root package name */
    private static final Class<?> f5856h;

    /* renamed from: i  reason: collision with root package name */
    private static final Constructor<?> f5857i;

    /* renamed from: j  reason: collision with root package name */
    private static final Method f5858j;

    /* renamed from: k  reason: collision with root package name */
    private static final Method f5859k;

    static {
        Method method;
        Class<?> cls;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName(f5853e);
            Constructor<?> constructor2 = cls.getConstructor((Class[]) null);
            Class cls2 = Integer.TYPE;
            method = cls.getMethod(f5854f, new Class[]{ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE});
            method2 = Typeface.class.getMethod(f5855g, new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e(f5852d, e2.getClass().getName(), e2);
            method2 = null;
            cls = null;
            method = null;
        }
        f5857i = constructor;
        f5856h = cls;
        f5858j = method;
        f5859k = method2;
    }

    TypefaceCompatApi24Impl() {
    }

    private static boolean o(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f5858j.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface p(Object obj) {
        try {
            Object newInstance = Array.newInstance(f5856h, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f5859k.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean q() {
        Method method = f5858j;
        if (method == null) {
            Log.w(f5852d, "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object r() {
        try {
            return f5857i.newInstance((Object[]) null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Nullable
    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        Object r = r();
        if (r == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.a()) {
            ByteBuffer b2 = TypefaceCompatUtil.b(context, resources, fontFileResourceEntry.b());
            if (b2 == null || !o(r, b2, fontFileResourceEntry.c(), fontFileResourceEntry.e(), fontFileResourceEntry.f())) {
                return null;
            }
        }
        return p(r);
    }

    @Nullable
    public Typeface d(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        Object r = r();
        if (r == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            Uri d2 = fontInfo.d();
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(d2);
            if (byteBuffer == null) {
                byteBuffer = TypefaceCompatUtil.f(context, cancellationSignal, d2);
                simpleArrayMap.put(d2, byteBuffer);
            }
            if (byteBuffer == null || !o(r, byteBuffer, fontInfo.c(), fontInfo.e(), fontInfo.f())) {
                return null;
            }
        }
        Typeface p = p(r);
        if (p == null) {
            return null;
        }
        return Typeface.create(p, i2);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Typeface g(@NonNull Context context, @NonNull Typeface typeface, int i2, boolean z) {
        Typeface typeface2;
        try {
            typeface2 = WeightTypefaceApi21.b(typeface, i2, z);
        } catch (RuntimeException unused) {
            typeface2 = null;
        }
        return typeface2 == null ? super.g(context, typeface, i2, z) : typeface2;
    }
}
