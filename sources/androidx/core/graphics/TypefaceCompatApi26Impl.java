package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final int A = -1;
    private static final String t = "TypefaceCompatApi26Impl";
    private static final String u = "android.graphics.FontFamily";
    private static final String v = "addFontFromAssetManager";
    private static final String w = "addFontFromBuffer";
    private static final String x = "createFromFamiliesWithDefault";
    private static final String y = "freeze";
    private static final String z = "abortCreation";

    /* renamed from: m  reason: collision with root package name */
    protected final Class<?> f5860m;

    /* renamed from: n  reason: collision with root package name */
    protected final Constructor<?> f5861n;
    protected final Method o;
    protected final Method p;
    protected final Method q;
    protected final Method r;
    protected final Method s;

    public TypefaceCompatApi26Impl() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor<?> constructor;
        Class<?> cls;
        try {
            cls = C();
            constructor = D(cls);
            method5 = z(cls);
            method4 = A(cls);
            method3 = E(cls);
            method2 = y(cls);
            method = B(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e(t, "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            cls = null;
            constructor = null;
            method5 = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f5860m = cls;
        this.f5861n = constructor;
        this.o = method5;
        this.p = method4;
        this.q = method3;
        this.r = method2;
        this.s = method;
    }

    @Nullable
    private Object s() {
        try {
            return this.f5861n.newInstance((Object[]) null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void t(Object obj) {
        try {
            this.r.invoke(obj, (Object[]) null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean u(Context context, Object obj, String str, int i2, int i3, int i4, @Nullable FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.o.invoke(obj, new Object[]{context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean v(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.p.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean w(Object obj) {
        try {
            return ((Boolean) this.q.invoke(obj, (Object[]) null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean x() {
        if (this.o == null) {
            Log.w(t, "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.o != null;
    }

    /* access modifiers changed from: protected */
    public Method A(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod(w, new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    /* access modifiers changed from: protected */
    public Method B(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod(x, new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    /* access modifiers changed from: protected */
    public Class<?> C() throws ClassNotFoundException {
        return Class.forName(u);
    }

    /* access modifiers changed from: protected */
    public Constructor<?> D(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor((Class[]) null);
    }

    /* access modifiers changed from: protected */
    public Method E(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod(y, (Class[]) null);
    }

    @Nullable
    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        if (!x()) {
            return super.b(context, fontFamilyFilesResourceEntry, resources, i2);
        }
        Object s2 = s();
        if (s2 == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.a()) {
            if (!u(context, s2, fontFileResourceEntry.a(), fontFileResourceEntry.c(), fontFileResourceEntry.e(), fontFileResourceEntry.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.d()))) {
                t(s2);
                return null;
            }
        }
        if (!w(s2)) {
            return null;
        }
        return p(s2);
    }

    @Nullable
    public Typeface d(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        Typeface p2;
        ParcelFileDescriptor openFileDescriptor;
        if (fontInfoArr.length < 1) {
            return null;
        }
        if (!x()) {
            FontsContractCompat.FontInfo l2 = l(fontInfoArr, i2);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(l2.d(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(l2.e()).setItalic(l2.f()).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            Map<Uri, ByteBuffer> h2 = TypefaceCompatUtil.h(context, fontInfoArr, cancellationSignal);
            Object s2 = s();
            if (s2 == null) {
                return null;
            }
            boolean z2 = false;
            for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
                ByteBuffer byteBuffer = h2.get(fontInfo.d());
                if (byteBuffer != null) {
                    if (!v(s2, byteBuffer, fontInfo.c(), fontInfo.e(), fontInfo.f() ? 1 : 0)) {
                        t(s2);
                        return null;
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                t(s2);
                return null;
            } else if (w(s2) && (p2 = p(s2)) != null) {
                return Typeface.create(p2, i2);
            } else {
                return null;
            }
        }
        throw th;
    }

    @Nullable
    public Typeface f(Context context, Resources resources, int i2, String str, int i3) {
        if (!x()) {
            return super.f(context, resources, i2, str, i3);
        }
        Object s2 = s();
        if (s2 == null) {
            return null;
        }
        if (!u(context, s2, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            t(s2);
            return null;
        } else if (!w(s2)) {
            return null;
        } else {
            return p(s2);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Typeface g(@NonNull Context context, @NonNull Typeface typeface, int i2, boolean z2) {
        Typeface typeface2;
        try {
            typeface2 = WeightTypefaceApi26.b(typeface, i2, z2);
        } catch (RuntimeException unused) {
            typeface2 = null;
        }
        return typeface2 == null ? super.g(context, typeface, i2, z2) : typeface2;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Typeface p(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f5860m, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.s.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Method y(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod(z, (Class[]) null);
    }

    /* access modifiers changed from: protected */
    public Method z(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod(v, new Class[]{AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }
}
