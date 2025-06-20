package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {

    /* renamed from: d  reason: collision with root package name */
    private static final String f5843d = "TypefaceCompatApi21Impl";

    /* renamed from: e  reason: collision with root package name */
    private static final String f5844e = "android.graphics.FontFamily";

    /* renamed from: f  reason: collision with root package name */
    private static final String f5845f = "addFontWeightStyle";

    /* renamed from: g  reason: collision with root package name */
    private static final String f5846g = "createFromFamiliesWithDefault";

    /* renamed from: h  reason: collision with root package name */
    private static Class<?> f5847h = null;

    /* renamed from: i  reason: collision with root package name */
    private static Constructor<?> f5848i = null;

    /* renamed from: j  reason: collision with root package name */
    private static Method f5849j = null;

    /* renamed from: k  reason: collision with root package name */
    private static Method f5850k = null;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f5851l = false;

    TypefaceCompatApi21Impl() {
    }

    private static boolean o(Object obj, String str, int i2, boolean z) {
        r();
        try {
            return ((Boolean) f5849j.invoke(obj, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Typeface p(Object obj) {
        r();
        try {
            Object newInstance = Array.newInstance(f5847h, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f5850k.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private File q(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void r() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f5851l) {
            f5851l = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName(f5844e);
                Constructor<?> constructor2 = cls.getConstructor((Class[]) null);
                method = cls.getMethod(f5845f, new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod(f5846g, new Class[]{Array.newInstance(cls, 1).getClass()});
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                Log.e(f5843d, e2.getClass().getName(), e2);
                method2 = null;
                cls = null;
                method = null;
            }
            f5848i = constructor;
            f5847h = cls;
            f5849j = method;
            f5850k = method2;
        }
    }

    private static Object s() {
        r();
        try {
            return f5848i.newInstance((Object[]) null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        Object s = s();
        FontResourcesParserCompat.FontFileResourceEntry[] a2 = fontFamilyFilesResourceEntry.a();
        int length = a2.length;
        int i3 = 0;
        while (i3 < length) {
            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = a2[i3];
            File e2 = TypefaceCompatUtil.e(context);
            if (e2 == null) {
                return null;
            }
            try {
                if (!TypefaceCompatUtil.c(e2, resources, fontFileResourceEntry.b())) {
                    e2.delete();
                    return null;
                } else if (!o(s, e2.getPath(), fontFileResourceEntry.e(), fontFileResourceEntry.f())) {
                    return null;
                } else {
                    i3++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e2.delete();
            }
        }
        return p(s);
    }

    public Typeface d(Context context, CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        ParcelFileDescriptor openFileDescriptor;
        FileInputStream fileInputStream;
        if (fontInfoArr.length < 1) {
            return null;
        }
        FontsContractCompat.FontInfo l2 = l(fontInfoArr, i2);
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(l2.d(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            File q = q(openFileDescriptor);
            if (q != null) {
                if (q.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(q);
                    openFileDescriptor.close();
                    return createFromFile;
                }
            }
            fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface e2 = super.e(context, fileInputStream);
            fileInputStream.close();
            openFileDescriptor.close();
            return e2;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
        throw th;
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
